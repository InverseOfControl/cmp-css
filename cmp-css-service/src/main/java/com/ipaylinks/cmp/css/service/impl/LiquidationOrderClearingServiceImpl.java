package com.ipaylinks.cmp.css.service.impl;

import com.ipaylinks.ccs.facade.enums.ChargeSceneEnum;
import com.ipaylinks.cmp.css.dal.mapper.MertClearingDetailMapper;
import com.ipaylinks.cmp.css.dal.mapper.MertSettlementDetailMapper;
import com.ipaylinks.cmp.css.dal.model.AccsplitOrder;
import com.ipaylinks.cmp.css.dal.model.LiquidationOrder;
import com.ipaylinks.cmp.css.dal.model.MertClearingDetail;
import com.ipaylinks.cmp.css.dal.model.MertSettlementDetail;
import com.ipaylinks.cmp.css.dal.model.RiskOrder;
import com.ipaylinks.cmp.css.dal.model.TradeAccountReport;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.facade.enums.FeeFlagEnum;
import com.ipaylinks.cmp.css.facade.enums.LiquidationStatusEnum;
import com.ipaylinks.cmp.css.facade.enums.MertClearingDetailStatusEnum;
import com.ipaylinks.cmp.css.facade.enums.OrderTypeEnum;
import com.ipaylinks.cmp.css.facade.enums.RefundStatusEnum;
import com.ipaylinks.cmp.css.integration.ccs.MerchChargeCalcFacadeClient;
import com.ipaylinks.cmp.css.integration.commonservice.SettlementRateQueryRpcClient;
import com.ipaylinks.cmp.css.integration.model.ChargeCalculateResult;
import com.ipaylinks.cmp.css.integration.model.MerchChargeStrategyQueryParam;
import com.ipaylinks.cmp.css.integration.util.EnumMappingUtil;
import com.ipaylinks.cmp.css.service.AccsplitOrderService;
import com.ipaylinks.cmp.css.service.LiquidationOrderClearingService;
import com.ipaylinks.cmp.css.service.LiquidationOrderService;
import com.ipaylinks.cmp.css.service.RiskOrderService;
import com.ipaylinks.cmp.css.service.TradeAccountReportService;
import com.ipaylinks.cmp.css.service.model.LiquidationOrderClearingContext;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.ipaylinks.common.enums.FinanceTypeEnum;
import com.ipaylinks.common.enums.TradeTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service("liquidationOrderClearingService")
public class LiquidationOrderClearingServiceImpl implements LiquidationOrderClearingService {

    private Logger logger = LoggerFactory.getLogger(LiquidationOrderClearingServiceImpl.class);

    @Autowired
    private LiquidationOrderService liquidationOrderService;
    @Autowired
    private AccsplitOrderService accsplitOrderService;
    @Autowired
    private MerchChargeCalcFacadeClient merchChargeCalcFacadeClient;
    @Autowired(required = false)
    private MertClearingDetailMapper mertClearingDetailMapper;
    @Autowired
    private TransactionTemplate transactionTemplate;
    @Autowired(required = false)
    private MertSettlementDetailMapper mertSettlementDetailMapper;
    @Autowired
    private SettlementRateQueryRpcClient settlementRateQueryRpcClient;
    @Autowired
    private RiskOrderService riskOrderService;
    @Autowired
    private TradeAccountReportService tradeAccountReportService;

    /**
     * 清算订单清分
     *
     * @param orderId
     * @throws Exception
     */
    @Override
    public void clearingLiquidationOrder(String orderId) throws Exception {
        logger.info("清算主订单清分开始，orderId={}", orderId);
        //获取清算主订单
        LiquidationOrder liquidationOrder = liquidationOrderService.selectByOrderId(orderId);
        if (liquidationOrder == null) {
            throw new BusinessException(CmpCssExceptionCode.BUSINESS_ERROR.getCode(), "未找到清算主订单");
        }
        if (LiquidationStatusEnum.CLEARING_SUCCESS.getCode().equals(liquidationOrder.getStatus())) {
            throw new BusinessException(CmpCssExceptionCode.BUSINESS_ERROR.getCode(), "清算主订单已清分，不允许重复处理");
        }

        LiquidationOrderClearingContext ctx = new LiquidationOrderClearingContext();
        ctx.setLiquidationOrder(liquidationOrder);
        try {
            //获取分账订单列表
            List<AccsplitOrder> accsplitOrderList = accsplitOrderService.selectByOrderId(orderId);
            ctx.setAccsplitOrderList(accsplitOrderList);
            //清分明细列表
            List<MertClearingDetail> mertClearingDetailList = new ArrayList<>();
            ctx.setMertClearingDetailList(mertClearingDetailList);
            //查询算费策略，处理本金、计算费用，构建清分明细对象列表
            buildMertClearingDetailList(ctx);
            //保存清分数据，创建清分明细，更新清算主订单、分账订单
            saveClearingDataTransaction(ctx);
        } catch (Exception e) {
            //更新清算状态
            liquidationOrder.setStatus(LiquidationStatusEnum.CLEARING_FAILED.getCode());
            liquidationOrderService.updateByPrimaryKeySelective(liquidationOrder);
            logger.error("清分失败", e);
            throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "清分失败");
        }
        logger.info("清算主订单清分成功，orderId={}", orderId);
        //生成结算明细
        genMertSettlementDetail(ctx.getLiquidationOrder(), ctx.getMertClearingDetailList());
    }

    /**
     * 查询算费策略，处理本金、计算费用，构建清分明细对象列表
     * @param ctx
     * @return
     * @throws Exception
     */
    private void buildMertClearingDetailList(LiquidationOrderClearingContext ctx) throws Exception {
        LiquidationOrder liquidationOrder = ctx.getLiquidationOrder();
        List<AccsplitOrder> accsplitOrderList = ctx.getAccsplitOrderList();
        if (CollectionUtils.isEmpty(accsplitOrderList)) {
            MertClearingDetail mertClearingDetail = buildMertClearingDetail(liquidationOrder);
            ChargeCalculateResult chargeCalculateResult = getMertClearingDetailList(ctx, mertClearingDetail, liquidationOrder.getTransAmount());
            liquidationOrder.setFeeId(chargeCalculateResult.getFeeId());
            liquidationOrder.setCalcFeeId(chargeCalculateResult.getCalcFeeId());
        } else {
            //分账总金额
            BigDecimal fenZhangZongJinE = new BigDecimal(0);
            for (AccsplitOrder accsplitOrder : accsplitOrderList) {
                fenZhangZongJinE = fenZhangZongJinE.add(accsplitOrder.getTransAmount());
            }
            if (fenZhangZongJinE.compareTo(liquidationOrder.getTransAmount()) > 0) {
                throw new BusinessException(CmpCssExceptionCode.BUSINESS_ERROR.getCode(), "分账总金额不能大于交易金额");
            }
            for (AccsplitOrder accsplitOrder : accsplitOrderList) {
                //分账账户清分明细
                MertClearingDetail mertClearingDetail = buildMertClearingDetail(liquidationOrder, accsplitOrder);
                ChargeCalculateResult chargeCalculateResult  = getMertClearingDetailList(ctx, mertClearingDetail, accsplitOrder.getTransAmount());
                accsplitOrder.setFeeId(chargeCalculateResult.getFeeId());
                accsplitOrder.setCalcFeeId(chargeCalculateResult.getCalcFeeId());
            }
            //主账户清分明细
            MertClearingDetail mertClearingDetail = buildMertClearingDetail(liquidationOrder);
            ChargeCalculateResult  chargeCalculateResult = getMertClearingDetailList(ctx, mertClearingDetail, liquidationOrder.getTransAmount().subtract(fenZhangZongJinE));
            liquidationOrder.setFeeId(chargeCalculateResult.getFeeId());
            liquidationOrder.setCalcFeeId(chargeCalculateResult.getCalcFeeId());
        }
    }

    /**
     * 构建清分明细对象列表（包含本金、比例费、固定费、处理费）
     * @param ctx
     * @param mertClearingDetail 清分明细
     * @param singleAmount 交易金额
     * @return 算费规则ID
     * @throws Exception
     */
    private ChargeCalculateResult getMertClearingDetailList(LiquidationOrderClearingContext ctx, MertClearingDetail mertClearingDetail, BigDecimal singleAmount) throws Exception{
        LiquidationOrder liquidationOrder = ctx.getLiquidationOrder();
        //收费场景
        ChargeSceneEnum chargeSceneEnum = EnumMappingUtil.tradeTypeEnum2ChargeSceneEnum(TradeTypeEnum.getByNumeric(liquidationOrder.getTransType()));
        ChargeCalculateResult chargeCalculateResult = this.merchChargeCalc(liquidationOrder, mertClearingDetail.getMerchantId(), singleAmount, chargeSceneEnum);
        //本金
        MertClearingDetail benJin = new MertClearingDetail();
        BeanUtils.copyProperties(mertClearingDetail, benJin);
        benJin.setAmountType(FinanceTypeEnum.PRINCIPAL.getCode());
        if(TradeTypeEnum.REFUND.getNumeric().equals(liquidationOrder.getTransType())
            || TradeTypeEnum.VOID.getNumeric().equals(liquidationOrder.getTransType())
            || TradeTypeEnum.CHARGEBACK.getNumeric().equals(liquidationOrder.getTransType())){
            //负向交易，本金金额为负
            benJin.setTransAmount(singleAmount.negate());
        }else{
            benJin.setTransAmount(singleAmount);
        }
        benJin.setTransCurrency(liquidationOrder.getTransCurrency());
        benJin.setSettleDate(liquidationOrder.getSettleDate());
        ctx.getMertClearingDetailList().add(benJin);
        //手续费清分明细列表
        ctx.getMertClearingDetailList().addAll(getMertClearingDetailListForFee(liquidationOrder,mertClearingDetail, chargeCalculateResult));
        return chargeCalculateResult;
    }

    /**
     * 获取手续费清分明细列表
     * @param mertClearingDetail
     * @param chargeCalculateResult
     * @return
     */
    private List<MertClearingDetail> getMertClearingDetailListForFee(LiquidationOrder liquidationOrder,MertClearingDetail mertClearingDetail, ChargeCalculateResult chargeCalculateResult){
        List<MertClearingDetail> mertClearingDetailList = new ArrayList<>();
        //比例费
        if(chargeCalculateResult.getPercentFee().compareTo(new BigDecimal(0)) != 0){
            MertClearingDetail biLiFei = new MertClearingDetail();
            BeanUtils.copyProperties(mertClearingDetail, biLiFei);
            BigDecimal percentFee =new BigDecimal(0);
            //全额退款业务处理
            if(liquidationOrder.getTransType().equals(TradeTypeEnum.REFUND.getNumeric())){
            	if(liquidationOrder.getIsAllRefund() !=null&&liquidationOrder.getIsAllRefund().equals(RefundStatusEnum.YES.getCode())){
            		MertClearingDetail mertClearingDetailFee =mertClearingDetailMapper.selectOgiProportionalFee(liquidationOrder.getMerchantId(),liquidationOrder.getOriOrderId(),FinanceTypeEnum.PROPORTIONAL_FEE.getCode());
            		if(chargeCalculateResult.getPercentFee().compareTo(mertClearingDetailFee.getTransAmount().abs())>0){
            			percentFee=mertClearingDetailFee.getTransAmount().abs();
            		}else{
            			percentFee=chargeCalculateResult.getPercentFee();
            		}
            	}else{
            		//设置部分退款比例费
            		percentFee=chargeCalculateResult.getPercentFee();
            	}
            }else{
            	//正常业务处理
            	percentFee=chargeCalculateResult.getPercentFee();
            }
            biLiFei.setAmountType(FinanceTypeEnum.PROPORTIONAL_FEE.getCode());
            biLiFei.setTransAmount(percentFee);
            biLiFei.setSettleDate(chargeCalculateResult.getFeeSettlementDate());
            biLiFei.setFeeSettleMethod(chargeCalculateResult.getChargeWay());
            mertClearingDetailList.add(biLiFei);
        }
        //固定费
        if(chargeCalculateResult.getFixedFee().compareTo(new BigDecimal(0)) != 0){
            MertClearingDetail guDingFei = new MertClearingDetail();
            BeanUtils.copyProperties(mertClearingDetail, guDingFei);
            guDingFei.setAmountType(FinanceTypeEnum.FIXED_FEE.getCode());
            guDingFei.setTransAmount(chargeCalculateResult.getFixedFee());
            guDingFei.setTransCurrency(chargeCalculateResult.getFixedCurrency());
            guDingFei.setSettleDate(chargeCalculateResult.getFeeSettlementDate());
            guDingFei.setFeeSettleMethod(chargeCalculateResult.getChargeWay());
            mertClearingDetailList.add(guDingFei);
        }
        //处理费
        if(chargeCalculateResult.getDealFee().compareTo(new BigDecimal(0)) != 0){
            MertClearingDetail chuLiFei = new MertClearingDetail();
            BeanUtils.copyProperties(mertClearingDetail, chuLiFei);
            chuLiFei.setAmountType(FinanceTypeEnum.PROCESSING_FEE.getCode());
            chuLiFei.setTransAmount(chargeCalculateResult.getDealFee());
            chuLiFei.setTransCurrency(chargeCalculateResult.getDealCurrency());
            chuLiFei.setSettleDate(chargeCalculateResult.getFeeSettlementDate());
            chuLiFei.setFeeSettleMethod(chargeCalculateResult.getChargeWay());
            mertClearingDetailList.add(chuLiFei);
        }
        return mertClearingDetailList;
    }

    /**
     * 获取手续费清分明细列表
     * @param mertClearingDetail
     * @param chargeCalculateResult
     * @return
     */
    private List<MertClearingDetail> getMertClearingDetailListForRiskFee(MertClearingDetail mertClearingDetail, ChargeCalculateResult chargeCalculateResult){
        List<MertClearingDetail> mertClearingDetailList = new ArrayList<>();
        //比例费
        if(chargeCalculateResult.getPercentFee().compareTo(new BigDecimal(0)) != 0){
            MertClearingDetail biLiFei = new MertClearingDetail();
            BeanUtils.copyProperties(mertClearingDetail, biLiFei);
            biLiFei.setAmountType(FinanceTypeEnum.PROPORTIONAL_FEE.getCode());
            biLiFei.setTransAmount(chargeCalculateResult.getPercentFee());
            biLiFei.setSettleDate(chargeCalculateResult.getFeeSettlementDate());
            biLiFei.setFeeSettleMethod(chargeCalculateResult.getChargeWay());
            mertClearingDetailList.add(biLiFei);
        }
        //固定费
        if(chargeCalculateResult.getFixedFee().compareTo(new BigDecimal(0)) != 0){
            MertClearingDetail guDingFei = new MertClearingDetail();
            BeanUtils.copyProperties(mertClearingDetail, guDingFei);
            guDingFei.setAmountType(FinanceTypeEnum.FIXED_FEE.getCode());
            guDingFei.setTransAmount(chargeCalculateResult.getFixedFee());
            guDingFei.setTransCurrency(chargeCalculateResult.getFixedCurrency());
            guDingFei.setSettleDate(chargeCalculateResult.getFeeSettlementDate());
            guDingFei.setFeeSettleMethod(chargeCalculateResult.getChargeWay());
            mertClearingDetailList.add(guDingFei);
        }
        //处理费
        if(chargeCalculateResult.getDealFee().compareTo(new BigDecimal(0)) != 0){
            MertClearingDetail chuLiFei = new MertClearingDetail();
            BeanUtils.copyProperties(mertClearingDetail, chuLiFei);
            chuLiFei.setAmountType(FinanceTypeEnum.PROCESSING_FEE.getCode());
            chuLiFei.setTransAmount(chargeCalculateResult.getDealFee());
            chuLiFei.setTransCurrency(chargeCalculateResult.getDealCurrency());
            chuLiFei.setSettleDate(chargeCalculateResult.getFeeSettlementDate());
            chuLiFei.setFeeSettleMethod(chargeCalculateResult.getChargeWay());
            mertClearingDetailList.add(chuLiFei);
        }
        return mertClearingDetailList;
    }

    private MertClearingDetail buildMertClearingDetail(LiquidationOrder liquidationOrder) {
        MertClearingDetail mertClearingDetail = new MertClearingDetail();
        mertClearingDetail.setOrderId(liquidationOrder.getOrderId());
        mertClearingDetail.setMerchantId(liquidationOrder.getMerchantId());
        mertClearingDetail.setMerchantName(liquidationOrder.getMerchantName());
        mertClearingDetail.setTransType(liquidationOrder.getTransType());
        mertClearingDetail.setTransCurrency(liquidationOrder.getTransCurrency());
        mertClearingDetail.setSettleCurrencyCode(liquidationOrder.getSettleCurrency());
        mertClearingDetail.setPayMethod(liquidationOrder.getPayMethod());
        mertClearingDetail.setTransCurrency(liquidationOrder.getTransCurrency());
        mertClearingDetail.setOrderType(OrderTypeEnum.LIQUIDATION.getCode());
        mertClearingDetail.setOriId(liquidationOrder.getId());
        return mertClearingDetail;
    }

    private MertClearingDetail buildMertClearingDetail(LiquidationOrder liquidationOrder, AccsplitOrder accsplitOrder) {
        MertClearingDetail mertClearingDetail = new MertClearingDetail();
        mertClearingDetail.setOrderId(liquidationOrder.getOrderId());
        mertClearingDetail.setMerchantId(accsplitOrder.getMerchantId());
        mertClearingDetail.setMerchantName(accsplitOrder.getMerchantName());
        mertClearingDetail.setTransType(liquidationOrder.getTransType());
        mertClearingDetail.setTransCurrency(liquidationOrder.getTransCurrency());
        mertClearingDetail.setSettleDate(liquidationOrder.getSettleDate());
        mertClearingDetail.setSettleCurrencyCode(accsplitOrder.getTransCurrency());
        mertClearingDetail.setPayMethod(liquidationOrder.getPayMethod());
        mertClearingDetail.setOrderType(OrderTypeEnum.LIQUIDATION.getCode());
        mertClearingDetail.setOriId(liquidationOrder.getId());
        return mertClearingDetail;
    }

    private ChargeCalculateResult merchChargeCalc(LiquidationOrder liquidationOrder, String merchantId, BigDecimal singleAmount, ChargeSceneEnum chargeSceneEnum) throws Exception{
        //查询商户算费策略请求参数
        MerchChargeStrategyQueryParam merchChargeStrategyQueryParam = new MerchChargeStrategyQueryParam();
        //收费场景
        merchChargeStrategyQueryParam.setChargeScene(chargeSceneEnum.getCode());
        //币种。货币字母代码，如：USD
        merchChargeStrategyQueryParam.setCurrencyCode(liquidationOrder.getTransCurrency());
        //地区。包括欧盟、非欧盟，送参数时需要注意不同卡组织对欧盟的非欧盟的定义
        merchChargeStrategyQueryParam.setRegion(liquidationOrder.getRegion());
        //国家二字码，如：US
        merchChargeStrategyQueryParam.setCountryCode(liquidationOrder.getCardCountry());
        //卡组织。包含：VISA、MC、JCB、AE、DC
        merchChargeStrategyQueryParam.setCardOrg(liquidationOrder.getPayKind());
        //卡类型。01-信用卡、02-借记卡，信用卡支付必输
        merchChargeStrategyQueryParam.setCardType(liquidationOrder.getCardType());
        //交易模型。包含：3D、非3D
        merchChargeStrategyQueryParam.setTradeModel(liquidationOrder.getTransModel());
        //商户号
        merchChargeStrategyQueryParam.setMerchantId(merchantId);
        //支付方式。包含：信用卡支付、本地化支付
        merchChargeStrategyQueryParam.setPayMode(liquidationOrder.getPayMethod());
        //交易方式。包含：DCC、EDC
        merchChargeStrategyQueryParam.setTransactionMode(liquidationOrder.getTransMethod());
        //渠道号。系统定义的渠道号
        merchChargeStrategyQueryParam.setChannelCode(liquidationOrder.getPayOrgCode());
        //查询上月交易统计
        TradeAccountReport tradeAccountReport = tradeAccountReportService.selectLastMonthByMerchantIdAndPayMethod(merchantId, liquidationOrder.getPayMethod());
        if(tradeAccountReport==null){
            tradeAccountReport = new TradeAccountReport();
        }
        //计算费用参数
        Map<String, Object> paramMap = new HashMap<>();
        //单笔金额
        paramMap.put("singleAmount", singleAmount);
        //总金额
        paramMap.put("totalAmount", tradeAccountReport.getTransAmount());
        //总笔数
        paramMap.put("totalCount", tradeAccountReport.getTransCount());
        //拒付率
        paramMap.put("protestRate", tradeAccountReport.getRefuseRatio());
        //拒付总笔数
        paramMap.put("protestCount", tradeAccountReport.getRefuseCount());

        if(TradeTypeEnum.REFUND.getNumeric().equalsIgnoreCase(liquidationOrder.getTransType())
            || TradeTypeEnum.VOID.getNumeric().equalsIgnoreCase(liquidationOrder.getTransType())
            || TradeTypeEnum.CHARGEBACK.getNumeric().equalsIgnoreCase(liquidationOrder.getTransType())){
            //原比例费 - 比例费为0时，不生成清分明细，这里初始为0
            paramMap.put("originalPercentFee", BigDecimal.ZERO);
            //原固定费 - 固定费为0时，不生成清分明细，这里初始为0
            paramMap.put("originalFixedFee", BigDecimal.ZERO);
            //退款需要提供算费ID
            LiquidationOrder oriLiquidationOrder = liquidationOrderService.selectByOrderId(liquidationOrder.getOriOrderId());
            paramMap.put("calcFeeId", oriLiquidationOrder.getCalcFeeId());
            //查询原始交易的清分明细
            MertClearingDetail record = new MertClearingDetail();
            record.setOrderId(liquidationOrder.getOriOrderId());
            List<MertClearingDetail> oriMertClearingDetailList = mertClearingDetailMapper.selectList(record);
            for(MertClearingDetail mertClearingDetail : oriMertClearingDetailList){
                if(FinanceTypeEnum.PRINCIPAL.getCode().equalsIgnoreCase(mertClearingDetail.getAmountType())){
                    //原单笔金额
                    paramMap.put("originalTransAmount", mertClearingDetail.getTransAmount());
                }else if(FinanceTypeEnum.PROPORTIONAL_FEE.getCode().equalsIgnoreCase(mertClearingDetail.getAmountType())){
                    //原比例费
                    paramMap.put("originalPercentFee", mertClearingDetail.getTransAmount());
                }else if(FinanceTypeEnum.FIXED_FEE.getCode().equalsIgnoreCase(mertClearingDetail.getAmountType())){
                    //原固定费
                    paramMap.put("originalFixedFee", mertClearingDetail.getTransAmount());
                }
            }
        }

        if(TradeTypeEnum.REFUND.getNumeric().equalsIgnoreCase(liquidationOrder.getTransType())
            || TradeTypeEnum.VOID.getNumeric().equalsIgnoreCase(liquidationOrder.getTransType())){
            //已退金额
            BigDecimal returnedAmount = BigDecimal.ZERO;
            //已退比例费
            BigDecimal returnedPercentFee = BigDecimal.ZERO;
            //已退固定费
            BigDecimal returnedFixedFee = BigDecimal.ZERO;
            //根据原始收单订单号查询清算订单列表
          
            List<LiquidationOrder> liquidationOrderList = liquidationOrderService.selectByOriOrderId(liquidationOrder.getOriOrderId());
            if(!CollectionUtils.isEmpty(liquidationOrderList)){
                //移除非退款的记录
                Iterator<LiquidationOrder> iterator = liquidationOrderList.iterator();
                while(iterator.hasNext()){
                    LiquidationOrder order = iterator.next();
                    if(!TradeTypeEnum.REFUND.getNumeric().equalsIgnoreCase(order.getTransType())
                        && !TradeTypeEnum.VOID.getNumeric().equalsIgnoreCase(order.getTransType())){
                        iterator.remove();
                    }
                }
                if(!CollectionUtils.isEmpty(liquidationOrderList)){
                    List<MertClearingDetail> mertClearingDetailList = new ArrayList<>();
                    for(LiquidationOrder order : liquidationOrderList){
                        MertClearingDetail record = new MertClearingDetail();
                        record.setOrderId(order.getOrderId());
                        mertClearingDetailList.addAll(mertClearingDetailMapper.selectList(record));
                    }

                    for(MertClearingDetail mertClearingDetail : mertClearingDetailList){
                        if(FinanceTypeEnum.PRINCIPAL.getCode().equalsIgnoreCase(mertClearingDetail.getAmountType())){
                            returnedAmount = returnedAmount.add(mertClearingDetail.getTransAmount());
                        }else if(FinanceTypeEnum.PROPORTIONAL_FEE.getCode().equalsIgnoreCase(mertClearingDetail.getAmountType())){
                            returnedPercentFee = returnedPercentFee.add(mertClearingDetail.getTransAmount());
                        }else if(FinanceTypeEnum.FIXED_FEE.getCode().equalsIgnoreCase(mertClearingDetail.getAmountType())){
                            returnedFixedFee = returnedFixedFee.add(mertClearingDetail.getTransAmount());
                        }
                    }
                }
            }
            paramMap.put("returnedAmount", returnedAmount);
            paramMap.put("returnedPercentFee", returnedPercentFee);
            paramMap.put("returnedFixedFee", returnedFixedFee);
        }
        logger.info("商户计费，paramMap={}", paramMap);
        //计算费用
        ChargeCalculateResult chargeCalculateResult = merchChargeCalcFacadeClient.merchChargeCalc(merchChargeStrategyQueryParam, paramMap);
        return chargeCalculateResult;
    }

    /**
     * 保存清分数据
     * @param ctx
     * @throws Exception
     */
    private void saveClearingDataTransaction(LiquidationOrderClearingContext ctx) throws Exception{
        boolean result;
        try {
            result = transactionTemplate.execute(new TransactionCallback<Boolean>() {
                @Override
                public Boolean doInTransaction(TransactionStatus transactionStatus) {
                    try {
                        //创建清分明细
                    	List<MertClearingDetail> mertClearingDetailList = ctx.getMertClearingDetailList();
                        for(MertClearingDetail mertClearingDetail : mertClearingDetailList){
                            mertClearingDetailMapper.insertSelective(mertClearingDetail);
                        }
                        //更新清算状态
                        LiquidationOrder liquidationOrder = ctx.getLiquidationOrder();
                        liquidationOrder.setStatus(LiquidationStatusEnum.CLEARING_SUCCESS.getCode());
                        liquidationOrder.setFeeFlag(FeeFlagEnum.RECEIVED.getCode());
                        liquidationOrderService.updateByPrimaryKeySelective(liquidationOrder);

                        //更新分账订单状态
                        List<AccsplitOrder> accsplitOrderList = ctx.getAccsplitOrderList();
                        if(!CollectionUtils.isEmpty(accsplitOrderList)){
                            for(AccsplitOrder accsplitOrder : accsplitOrderList){
                                accsplitOrder.setFeeFlag(FeeFlagEnum.RECEIVED.getCode());
                                accsplitOrderService.updateByPrimaryKeySelective(accsplitOrder);
                            }
                        }
                    }catch (Exception e) {
                        logger.error("保存清分明细异常", e);
                        transactionStatus.setRollbackOnly();
                        return false;
                    }
                    return true;
                }
            });
        } catch (Exception e) {
            logger.error("保存清分明细异常", e);
            result = false;
        }
        if(!result){
            throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "保存清分明细异常");
        }
    }

    /**
     * 生成清算主订单结算明细
     */
    @Override
    public void genMertSettlementDetail(LiquidationOrder liquidationOrder, List<MertClearingDetail> mertClearingDetailList) throws BusinessException {
        logger.info("清算主订单开始生成结算明细，id={}，orderId={}" + liquidationOrder.getId(), liquidationOrder.getOrderId());
        try {
            List<MertSettlementDetail> mertSettlementDetailList = new ArrayList<>();
            for(MertClearingDetail mertClearingDetail : mertClearingDetailList){
                BigDecimal settleRate = settlementRateQueryRpcClient.querySettlementRate(mertClearingDetail.getTransCurrency(), mertClearingDetail.getMerchantId(), mertClearingDetail.getTransAmount().longValue(), EnumMappingUtil.getCardOrgByPayKind(liquidationOrder.getPayKind()), mertClearingDetail.getSettleCurrencyCode());
                MertSettlementDetail mertSettlementDetail = new MertSettlementDetail();
                mertSettlementDetail.setMerchantOrderId(liquidationOrder.getMerchantOrderId());
                mertSettlementDetail.setOrderId(liquidationOrder.getOrderId());
                mertSettlementDetail.setClearingDetailId(mertClearingDetail.getId());
                mertSettlementDetail.setMerchantId(liquidationOrder.getMerchantId());
                mertSettlementDetail.setMerchantName(liquidationOrder.getMerchantName());
                mertSettlementDetail.setTransType(liquidationOrder.getTransType());
                mertSettlementDetail.setAmountType(mertClearingDetail.getAmountType());
                mertSettlementDetail.setTransCurrency(mertClearingDetail.getTransCurrency());
                mertSettlementDetail.setTransAmount(mertClearingDetail.getTransAmount());
                mertSettlementDetail.setPayCompleteTime(liquidationOrder.getPayCompleteTime());
                //mertSettlementDetail.setSettleType();
                mertSettlementDetail.setSettleCurrency(mertClearingDetail.getSettleCurrencyCode());
                mertSettlementDetail.setSettleAmount(mertClearingDetail.getTransAmount().multiply(settleRate));
                mertSettlementDetail.setSettleRate(settleRate);
                mertSettlementDetail.setSettleDate(mertClearingDetail.getSettleDate());
                mertSettlementDetail.setFeeSettleMethod(mertClearingDetail.getFeeSettleMethod());
                mertSettlementDetail.setPayMethod(liquidationOrder.getPayMethod());
                mertSettlementDetail.setOrderType(OrderTypeEnum.LIQUIDATION.getCode());
                mertSettlementDetail.setOriId(liquidationOrder.getId());
                mertSettlementDetail.setPayKind(liquidationOrder.getPayKind());
                mertSettlementDetailList.add(mertSettlementDetail);
            }
            //保存结算明细
            saveDataTransaction(liquidationOrder, mertClearingDetailList, mertSettlementDetailList);
        }catch (Exception e){
            //更新清算主订单状态
            liquidationOrder.setStatus(LiquidationStatusEnum.SETTLEMENT_FAILED.getCode());
            liquidationOrderService.updateByPrimaryKeySelective(liquidationOrder);
            logger.error("清算主订单生成结算明细异常", e);
            throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "清算主订单生成结算明细异常");
        }
        logger.info("清算主订单生成结算明细结束，id={}，orderId={}" + liquidationOrder.getId(), liquidationOrder.getOrderId());
    }

    /**
     * 保存清算主订单结算明细
     * @param mertClearingDetailList
     * @param mertSettlementDetailList
     * @throws Exception
     */
    private void saveDataTransaction(LiquidationOrder liquidationOrder, List<MertClearingDetail> mertClearingDetailList, List<MertSettlementDetail> mertSettlementDetailList) throws Exception{
        boolean result;
        try {
            result = transactionTemplate.execute(new TransactionCallback<Boolean>() {
                @Override
                public Boolean doInTransaction(TransactionStatus transactionStatus) {
                    try {
                        //保存结算明细
                        saveMertSettlementDetail(mertClearingDetailList, mertSettlementDetailList);
                        //更新清算主订单状态
                        liquidationOrder.setStatus(LiquidationStatusEnum.SETTLEMENT_SUCCESS.getCode());
                        liquidationOrderService.updateByPrimaryKeySelective(liquidationOrder);
                    }catch (Exception e) {
                        logger.error("保存结算明细异常", e);
                        transactionStatus.setRollbackOnly();
                        return false;
                    }
                    return true;
                }
            });
        } catch (Exception e) {
            logger.error("保存结算明细异常", e);
            result = false;
        }
        if(!result){
            //更新清分明细状态
            for(MertClearingDetail mertClearingDetail : mertClearingDetailList){
                mertClearingDetail.setStatus(MertClearingDetailStatusEnum.FAILED.getCode());
                mertClearingDetailMapper.updateByPrimaryKeySelective(mertClearingDetail);
            }
            throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "保存结算明细异常");
        }
    }

    /**
     * 保存结算明细
     * @param mertClearingDetailList
     * @param mertSettlementDetailList
     */
    private void saveMertSettlementDetail(List<MertClearingDetail> mertClearingDetailList, List<MertSettlementDetail> mertSettlementDetailList){
        //创建结算明细
        for(MertSettlementDetail mertSettlementDetail : mertSettlementDetailList){
            mertSettlementDetailMapper.insertSelective(mertSettlementDetail);
        }
        //更新清分明细状态
        for(MertClearingDetail mertClearingDetail : mertClearingDetailList){
            mertClearingDetail.setStatus(MertClearingDetailStatusEnum.SUCCESS.getCode());
            mertClearingDetailMapper.updateByPrimaryKeySelective(mertClearingDetail);
        }
    }


    /**********************************************************************/

    /**
     * 风控订单清分
     */
    @Override
    public void clearingRiskOrder(String orderId) throws Exception{
        RiskOrder riskOrder = riskOrderService.selectByOrderId(orderId);
        if (riskOrder == null) {
            throw new BusinessException(CmpCssExceptionCode.BUSINESS_ERROR.getCode(), "未找到风控订单");
        }
        if (LiquidationStatusEnum.CLEARING_SUCCESS.getCode().equals(riskOrder.getFeeFlag())) {
            throw new BusinessException(CmpCssExceptionCode.BUSINESS_ERROR.getCode(), "风控订单已清分，不允许重复处理");
        }
        List<MertClearingDetail> mertClearingDetailList = null;
        try {
            //查询算费策略，处理本金、计算费用，构建清分明细对象列表
            mertClearingDetailList = buildMertClearingDetailList(riskOrder);
            //保存清分数据，创建清分明细，更新风控订单
            saveClearingDataTransaction(riskOrder, mertClearingDetailList);
        } catch (Exception e) {
            //更新风控订单
            riskOrder.setFeeFlag(LiquidationStatusEnum.CLEARING_FAILED.getCode());
            riskOrderService.updateByPrimaryKeySelective(riskOrder);
            logger.error("清分风控订单失败", e);
            throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "清分风控订单失败");
        }
        //生成结算明细
        genMertSettlementDetail(riskOrder, mertClearingDetailList);
    }

    /**
     * 获取风控订单清分明细列表
     * @param riskOrder
     * @return
     */
	private List<MertClearingDetail> buildMertClearingDetailList(RiskOrder riskOrder) throws Exception{
	    //查询商户算费策略请求参数
        MerchChargeStrategyQueryParam merchChargeStrategyQueryParam = new MerchChargeStrategyQueryParam();
        merchChargeStrategyQueryParam.setChargeScene(ChargeSceneEnum.Risk.getCode());
        merchChargeStrategyQueryParam.setMerchantId(riskOrder.getMerchantId());
        merchChargeStrategyQueryParam.setPayMode(riskOrder.getPayMethod());

        //计算费用参数
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("singleAmount", riskOrder.getTransAmount());

        //计算费用
        ChargeCalculateResult chargeCalculateResult = merchChargeCalcFacadeClient.merchChargeCalc(merchChargeStrategyQueryParam, paramMap);
        //给riskOrder赋值
        riskOrder.setFeeId(chargeCalculateResult.getFeeId());
        MertClearingDetail mertClearingDetail = buildMertClearingDetail(riskOrder);
		List<MertClearingDetail> mertClearingDetailList = getMertClearingDetailListForRiskFee(mertClearingDetail, chargeCalculateResult);
		return mertClearingDetailList;
	}

    private MertClearingDetail buildMertClearingDetail(RiskOrder riskOrder) {
        MertClearingDetail mertClearingDetail = new MertClearingDetail();
        mertClearingDetail.setOrderId(riskOrder.getOrderId());
        mertClearingDetail.setMerchantId(riskOrder.getMerchantId());
        mertClearingDetail.setMerchantName(riskOrder.getMerchantName());
        mertClearingDetail.setTransType(riskOrder.getTransType());
        mertClearingDetail.setSettleCurrencyCode(riskOrder.getSettleCurrency());
        mertClearingDetail.setPayMethod(riskOrder.getPayMethod());
        mertClearingDetail.setOrderType(OrderTypeEnum.RISK.getCode());
        mertClearingDetail.setOriId(riskOrder.getId());
        return mertClearingDetail;
    }

    /**
     * 保存清分数据
     * @throws Exception
     */
    private void saveClearingDataTransaction(RiskOrder riskOrder, List<MertClearingDetail> mertClearingDetailList) throws Exception{
        boolean result;
        try {
            result = transactionTemplate.execute(new TransactionCallback<Boolean>() {
                @Override
                public Boolean doInTransaction(TransactionStatus transactionStatus) {
                    try {
                        //创建清分明细
                        for(MertClearingDetail mertClearingDetail : mertClearingDetailList){
                            mertClearingDetailMapper.insertSelective(mertClearingDetail);
                        }
                        //更新风控订单收费状态
                        riskOrder.setFeeFlag(LiquidationStatusEnum.CLEARING_SUCCESS.getCode());
                        riskOrderService.updateByPrimaryKeySelective(riskOrder);
                    }catch (Exception e) {
                        logger.error("保存清分明细异常", e);
                        transactionStatus.setRollbackOnly();
                        return false;
                    }
                    return true;
                }
            });
        } catch (Exception e) {
            logger.error("保存清分明细异常", e);
            result = false;
        }
        if(!result){
            throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "保存清分明细异常");
        }
    }

    /**
     * 生成风控订单结算明细
     */
    @Override
    public void genMertSettlementDetail(RiskOrder riskOrder, List<MertClearingDetail> mertClearingDetailList) throws Exception {
        logger.info("风控订单开始生成结算明细，id={}，orderId={}" + riskOrder.getId(), riskOrder.getOrderId());
        try {
            List<MertSettlementDetail> mertSettlementDetailList = new ArrayList<>();
            for(MertClearingDetail mertClearingDetail : mertClearingDetailList){
                BigDecimal settleRate = settlementRateQueryRpcClient.querySettlementRate(mertClearingDetail.getTransCurrency(), mertClearingDetail.getMerchantId(), mertClearingDetail.getTransAmount().longValue(), EnumMappingUtil.getCardOrgByPayKind(riskOrder.getPayKind()), mertClearingDetail.getSettleCurrencyCode());
                MertSettlementDetail mertSettlementDetail = new MertSettlementDetail();
                mertSettlementDetail.setMerchantOrderId(riskOrder.getMerchantOrderId());
                mertSettlementDetail.setOrderId(riskOrder.getOrderId());
                mertSettlementDetail.setClearingDetailId(mertClearingDetail.getId());
                mertSettlementDetail.setMerchantId(riskOrder.getMerchantId());
                mertSettlementDetail.setMerchantName(riskOrder.getMerchantName());
                mertSettlementDetail.setTransType(riskOrder.getTransType());
                mertSettlementDetail.setAmountType(mertClearingDetail.getAmountType());
                mertSettlementDetail.setTransCurrency(mertClearingDetail.getTransCurrency());
                mertSettlementDetail.setTransAmount(mertClearingDetail.getTransAmount());
                //mertSettlementDetail.setSettleType();
                mertSettlementDetail.setSettleCurrency(mertClearingDetail.getSettleCurrencyCode());
                mertSettlementDetail.setSettleAmount(mertClearingDetail.getTransAmount().multiply(settleRate));
                mertSettlementDetail.setSettleRate(settleRate);
                mertSettlementDetail.setSettleDate(mertClearingDetail.getSettleDate());
                mertSettlementDetail.setFeeSettleMethod(mertClearingDetail.getFeeSettleMethod());
                mertSettlementDetail.setPayMethod(riskOrder.getPayMethod());
                mertSettlementDetail.setOrderType(OrderTypeEnum.RISK.getCode());
                mertSettlementDetail.setOriId(riskOrder.getId());
                mertSettlementDetail.setPayKind(riskOrder.getPayKind());
                mertSettlementDetailList.add(mertSettlementDetail);
            }
            //保存结算明细
            saveDataTransaction(riskOrder, mertClearingDetailList, mertSettlementDetailList);
        }catch (Exception e){
            //更新风控订单
            riskOrder.setFeeFlag(LiquidationStatusEnum.SETTLEMENT_FAILED.getCode());
            riskOrderService.updateByPrimaryKeySelective(riskOrder);
            logger.error("风控订单生成结算明细异常", e);
            throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "风控订单生成结算明细异常");
        }
        logger.info("风控订单生成结算明细结束，id={}，orderId={}" + riskOrder.getId(), riskOrder.getOrderId());


    }

    /**
     * 保存风控订单结算明细
     * @param mertClearingDetailList
     * @param mertSettlementDetailList
     * @throws Exception
     */
    private void saveDataTransaction(RiskOrder riskOrder, List<MertClearingDetail> mertClearingDetailList, List<MertSettlementDetail> mertSettlementDetailList) throws Exception{
        boolean result;
        try {
            result = transactionTemplate.execute(new TransactionCallback<Boolean>() {
                @Override
                public Boolean doInTransaction(TransactionStatus transactionStatus) {
                    try {
                        //保存结算明细
                        saveMertSettlementDetail(mertClearingDetailList, mertSettlementDetailList);
                        //更新风控订单
                        riskOrder.setFeeFlag(LiquidationStatusEnum.SETTLEMENT_SUCCESS.getCode());
                        riskOrderService.updateByPrimaryKeySelective(riskOrder);
                    }catch (Exception e) {
                        logger.error("保存结算明细异常", e);
                        transactionStatus.setRollbackOnly();
                        return false;
                    }
                    return true;
                }
            });
        } catch (Exception e) {
            logger.error("保存结算明细异常", e);
            result = false;
        }
        if(!result){
            //更新清分明细状态
            for(MertClearingDetail mertClearingDetail : mertClearingDetailList){
                mertClearingDetail.setStatus(MertClearingDetailStatusEnum.FAILED.getCode());
                mertClearingDetailMapper.updateByPrimaryKeySelective(mertClearingDetail);
            }
            throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "保存结算明细异常");
        }
    }
}
