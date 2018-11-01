package com.ipaylinks.cmp.css.service.impl;

import com.ipaylinks.cmp.css.dal.mapper.TradeAccountReportMapper;
import com.ipaylinks.cmp.css.dal.model.MertClearingDetail;
import com.ipaylinks.cmp.css.dal.model.TradeAccountReport;
import com.ipaylinks.common.enums.FinanceTypeEnum;
import com.ipaylinks.cmp.css.facade.enums.PayTypeEnum;
import com.ipaylinks.common.enums.TradeTypeEnum;
import com.ipaylinks.cmp.css.integration.commonservice.TransactionBaseRateQueryRpcClient;
import com.ipaylinks.cmp.css.service.MertClearingDetailService;
import com.ipaylinks.cmp.css.service.TradeAccountReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("tradeAccountReportService")
public class TradeAccountReportServiceImpl implements TradeAccountReportService {

private Logger logger = LoggerFactory.getLogger(TradeAccountReportServiceImpl.class);
	
    @Autowired(required = false)
	private TradeAccountReportMapper tradeAccountReportMapper;
    
    @Autowired(required = false)
	private MertClearingDetailService mertClearingDetailService;

	@Autowired
	private TransactionBaseRateQueryRpcClient transactionBaseRateQueryRpcClient;

	/**
     * 每月1号00:00:30 以商户号+支付方式统计上个月的交易量
     * */
	@Override
	public void dealTradeAccountReport() {
		logger.info("dealTradeAccountReport 开始执行");
		//查询上月的清分明细汇总记录
		List<MertClearingDetail> mertClearingDetailList = mertClearingDetailService.sumLastMonthRecord();
		//key: merchantId_payMethod
		Map<String, TradeAccountReport> map = new HashMap<>();
		for (MertClearingDetail mertClearingDetail : mertClearingDetailList) {
			try {
				String key = mertClearingDetail.getMerchantId() + "_" + mertClearingDetail.getPayMethod();
				TradeAccountReport tradeAccountReport;
				if(map.containsKey(key)){
					tradeAccountReport = map.get(key);
				}else{
					tradeAccountReport = buildTradeAccountReport(mertClearingDetail);
				}
				//美元金额
				BigDecimal transAmountUSD = calcTransAmountUSD(mertClearingDetail.getTransCurrency(), mertClearingDetail.getTransAmount());
				//记录数
				Integer recordCount = mertClearingDetail.getRecordCount();
				if(TradeTypeEnum.SALE.getNumeric().equals(mertClearingDetail.getTransType()) || TradeTypeEnum.CAPTURE.getNumeric().equals(mertClearingDetail.getTransType())){
					if(FinanceTypeEnum.PRINCIPAL.getCode().equals(mertClearingDetail.getAmountType())){
						tradeAccountReport.setTransAmount(tradeAccountReport.getTransAmount().add(transAmountUSD));
						tradeAccountReport.setTransCount(tradeAccountReport.getTransCount()+recordCount);
					}else if(FinanceTypeEnum.PROPORTIONAL_FEE.getCode().equals(mertClearingDetail.getAmountType())){
						tradeAccountReport.setTransFee(tradeAccountReport.getTransFee().add(transAmountUSD));
					}else if(FinanceTypeEnum.FIXED_FEE.getCode().equals(mertClearingDetail.getAmountType())){
						tradeAccountReport.setFixedChardeFee(tradeAccountReport.getFixedChardeFee().add(transAmountUSD));
					}
				}else if(TradeTypeEnum.REFUND.getNumeric().equals(mertClearingDetail.getTransType()) || TradeTypeEnum.VOID.getNumeric().equals(mertClearingDetail.getTransType())){
					tradeAccountReport.setRefundAmount(tradeAccountReport.getRefundAmount().add(transAmountUSD));
					tradeAccountReport.setRefundCount(tradeAccountReport.getRefundCount()+recordCount);
				}else if(TradeTypeEnum.CHARGEBACK.getNumeric().equals(mertClearingDetail.getTransType())){
					tradeAccountReport.setRefuseAmount(tradeAccountReport.getRefuseAmount().add(transAmountUSD));
					tradeAccountReport.setRefuseCount(tradeAccountReport.getRefuseCount()+recordCount);
				}
				map.put(key, tradeAccountReport);
			}catch (Exception e){
				//TODO 加个告警吧
				logger.error("dealTradeAccountReport异常", e);
			}
		}
		List<TradeAccountReport> list = new ArrayList<>();
		//设置拒付率
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			TradeAccountReport tradeAccountReport = map.get(key);
			if(PayTypeEnum.CardsAccepted.getCode().equals(tradeAccountReport.getPayMethod())){
				if(tradeAccountReport.getTransCount().intValue()==0){
					tradeAccountReport.setRefuseRatio(new BigDecimal(0));
				}else{
					tradeAccountReport.setRefuseRatio(new BigDecimal(tradeAccountReport.getRefuseCount()).divide(new BigDecimal(tradeAccountReport.getTransCount()),6, BigDecimal.ROUND_HALF_DOWN));
				}
			}
			list.add(tradeAccountReport);
		}
		//插入数据库
		batchCreate(list);
		logger.info("dealTradeAccountReport 执行结束");
	}

	@Override
	public TradeAccountReport selectLastMonthByMerchantIdAndPayMethod(String merchantId, String payMethod) {
		TradeAccountReport record = new TradeAccountReport();
		record.setMerchantId(merchantId);
		record.setPayMethod(payMethod);
		List<TradeAccountReport> list = tradeAccountReportMapper.selectLastMonthByMerchantIdAndPayMethod(record);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}

	private BigDecimal calcTransAmountUSD(String transCurrency, BigDecimal transAmount){
		logger.info("calcTransAmountUSD, transCurrency={}, transAmount={}", transCurrency, transAmount);
		if("USD".equalsIgnoreCase(transCurrency)){
			return transAmount;
		}
		//查询汇率
		BigDecimal exchangeRate = transactionBaseRateQueryRpcClient.queryTransactionBaseRate(transCurrency, "USD");
		transAmount = transAmount.multiply(exchangeRate);
		logger.info("calcTransAmountUSD, exchangeRate={}, transAmount={}", exchangeRate, transAmount);
		return transAmount;
	}

	private TradeAccountReport buildTradeAccountReport(MertClearingDetail mertClearingDetail){
		TradeAccountReport tradeAccountReport = new TradeAccountReport();
		tradeAccountReport.setMerchantId(mertClearingDetail.getMerchantId());
		tradeAccountReport.setMerchantName(mertClearingDetail.getMerchantName());
		tradeAccountReport.setPayMethod(mertClearingDetail.getPayMethod());
		tradeAccountReport.setTradeMonth(Integer.valueOf(mertClearingDetail.getTradeMonth()));
		return tradeAccountReport;
	}

	private void batchCreate(List<TradeAccountReport> list){
		logger.info("每月交易统计批量插入开始");
		if(!CollectionUtils.isEmpty(list)){
			//删除上月的记录
			tradeAccountReportMapper.deleteLastMonth();
			int count = list.size();
			logger.info("每月交易统计批量插入，count=" + count);
			//每页条数
			int pageSize = 1000;
			int totlePage = count/pageSize;
			int mod = count%pageSize;
			if(mod!=0){
				totlePage+=1;
			}
			for(int i=0; i<totlePage; i++){
				int fromIndex = pageSize * i;
				int toIndex;
				if(i==totlePage-1){
					toIndex = count;
				}else{
					toIndex = pageSize * (i+1);
				}
				List<TradeAccountReport> subList = list.subList(fromIndex, toIndex);
				logger.info("每月交易统计批量插入第" + i + "次开始");
				tradeAccountReportMapper.batchCreate(subList);
				logger.info("每月交易统计批量插入第" + i + "次结束");
			}
		}
		logger.info("每月交易统计批量插入结束");
	}

}
