package com.ipaylinks.cmp.css.biz.job.executor.handler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ipaylinks.cmp.css.dal.model.MertSettlementDetail;
import com.ipaylinks.cmp.css.facade.enums.BussTypeEnums;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.facade.enums.LogStatusEnums;
import com.ipaylinks.cmp.css.service.MertSettlementDetailService;
import com.ipaylinks.cmp.css.service.MertSettlementLogService;
import com.ipaylinks.cmp.css.service.MertSettlementSummaryService;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

@Component
@JobHandler(value="dealMertSettlementsSummaryAccountTask")
public class DealMertSettlementsSummaryAccountTask extends IJobHandler {

private Logger logger = LoggerFactory.getLogger(DealMertSettlementsSummaryAccountTask.class);

	@Autowired
	private MertSettlementSummaryService mertSettlementSummaryService; 
	@Autowired
	private MertSettlementDetailService mertSettlementDetailService; 
	
	@Autowired
	private MertSettlementLogService mertSettlementLogService;
	
	/**
     * @des    根据当前结算日期生成商户结算对账单进行上传到商户服务器
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
     * @data   <a>2018-07-09<a>
     * @plan   执行计划 2018-**-** 00-01-00
     * */
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		Date settleDate =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
		logger.info("create merchant T day trade statement of account begin date={}",sdf.format(settleDate));
		try {
			List<MertSettlementDetail> listMertSettlementDetail=mertSettlementDetailService.countTradeMerchant();
			//根据商户和结算日期生成当前结算日期下的商户所有结算汇总单对账单
			for (Iterator iterator = listMertSettlementDetail.iterator(); iterator
					.hasNext();) {
				MertSettlementDetail mertSettlementDetail = (MertSettlementDetail) iterator
						.next();
				mertSettlementLogService.createMertSettlementLog(sdf.format(settleDate),"01","00",BussTypeEnums.SETTLE_SUMMARY_BOOK.getDesc(),BussTypeEnums.SETTLE_SUMMARY_BOOK.getCode(),LogStatusEnums.INIT.getCode());
				mertSettlementSummaryService.createMertSettlementSummaryAccount(mertSettlementDetail.getMerchantId(),sdf.format(settleDate));
			}
		} catch (Exception e) {
			logger.info("create merchant T day trade statement of account error ={}",e);
			throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "生成商户交易对账单异常");
		}
		logger.info("create merchant T day trade statement of account end date={}",sdf.format(settleDate));
		return SUCCESS;
	}
}

