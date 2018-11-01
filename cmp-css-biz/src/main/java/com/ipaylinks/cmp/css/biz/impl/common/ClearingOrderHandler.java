package com.ipaylinks.cmp.css.biz.impl.common;

import com.ipaylinks.acct.facade.enums.AcctPipeLogStatusTypeEnum;
import com.ipaylinks.ccs.facade.model.ChargeStrategyResponse;
import com.ipaylinks.cmp.css.dal.model.*;
import com.ipaylinks.cmp.css.facade.constant.AccountConstantConstant;
import com.ipaylinks.cmp.css.facade.dto.LiquidationSubOrderDTO;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.facade.enums.ErrorHandingFlagEnum;
import com.ipaylinks.cmp.css.facade.enums.FeeFlagEnum;
import com.ipaylinks.cmp.css.facade.enums.OrderTypeEnum;
import com.ipaylinks.cmp.css.integration.act.AccountingRuleFacadeQueryRpcClient;
import com.ipaylinks.cmp.css.integration.ccs.ChannelChargeCalcFacadeClient;
import com.ipaylinks.cmp.css.integration.ccs.ChannelWaterPushFacadeClient;
import com.ipaylinks.cmp.css.integration.dto.CreateAccountingAmount;
import com.ipaylinks.cmp.css.integration.model.ChannelChargeCalculateParam;
import com.ipaylinks.cmp.css.integration.model.ChannelChargeCalculateResult;
import com.ipaylinks.cmp.css.integration.model.ChannelChargeStrategyQueryParam;
import com.ipaylinks.cmp.css.integration.req.CreateAccountingRequest;
import com.ipaylinks.cmp.css.integration.res.CreateMermberAccountFeeResponse;
import com.ipaylinks.cmp.css.integration.util.EnumMappingUtil;
import com.ipaylinks.cmp.css.service.*;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.ipaylinks.cmp.css.util.DateUtil;
import com.ipaylinks.cmp.css.util.RedisKeyConstants;
import com.ipaylinks.cmp.css.util.ResponseUtils;
import com.ipaylinks.common.enums.BaseRespStatusEnum;
import com.ipaylinks.common.enums.CurrencyTypeEnum;
import com.ipaylinks.common.enums.FinanceTypeEnum;
import com.ipaylinks.common.enums.TradeTypeEnum;
import com.ipaylinks.common.rpc.BaseResponse;
import com.ipaylinks.common.rpc.response.SingleResponse;
import com.ipaylinks.verify.facade.dto.SettlementTransDetailDTO;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 清分处理
 *
 * @author dapeng.tong
 * @date 2018/5/8 10:54
 */
@Service("clearingOrderHandler")
public class ClearingOrderHandler {
    private Logger logger = LoggerFactory.getLogger(ClearingOrderHandler.class);

    @Autowired
    private LiquidationOrderService liquidationOrderService;
    @Autowired
    private LiquidationSubOrderService liquidationSubOrderService;
    @Autowired
    private ChannelOrderService channelOrderService;
    @Autowired
    private LiquidationLogService liquidationLogService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ChannelChargeCalcFacadeClient channelChargeCalcFacadeClient;
    @Autowired
    private ChannelClearingDetailService channelClearingDetailService;
    @Autowired
    private ChannelWaterPushFacadeClient channelWaterPushFacadeClient;
    @Autowired
    private AccountingRuleFacadeQueryRpcClient accountingRuleFacadeQueryRpcClient;
    @Autowired
    private LiquidationOrderClearingService liquidationOrderClearingService;
    @Autowired
    private MertSettlementDetailService mertSettlementDetailService;
    

    public BaseResponse invoke(OrderTypeEnum orderType, String orderId) {
        logger.info("清分清算处理开始, orderType={}, orderId={}", orderType, orderId);
        BaseResponse response = new BaseResponse();
        //清分清算日志
        LiquidationLog liquidationLog = null;
        String redisKey = "";
        try {
            if (orderType == null || StringUtils.isBlank(orderId)) {
                throw new BusinessException(CmpCssExceptionCode.PARAMETERS_ERROR.getCode(), "订单类型和订单ID不能为空");
            }
            //创建清分清算日志
            liquidationLog = liquidationLogService.createLiquidationLog(orderId, orderType.getCode());
            //redis锁
            redisKey = RedisKeyConstants.CLEARING_LOCK + orderType.getCode() + orderId;
            boolean flag = redisTemplate.opsForValue().setIfAbsent(redisKey, "1");
            redisTemplate.expire(redisKey, 30, TimeUnit.SECONDS);
            if (!flag) {
                throw new BusinessException(CmpCssExceptionCode.CONCURRENT_EXCEPTION.getCode(), "订单处理中，不能重复处理");
            }
            //清分处理
            clearingOrder(orderType, orderId);
            ResponseUtils.setToSuccess(response);
        } catch (BusinessException e) {
            logger.error("清分清算处理异常", e);
            ResponseUtils.setToFail(response, e.getResponseCode(), e.getResponseMsg());
        } catch (Exception e) {
            logger.error("清分清算处理异常", e);
            ResponseUtils.setToFail(response, CmpCssExceptionCode.SYSTEM_EXCEPTION, e.getMessage());
        } finally {
            try {
                redisTemplate.delete(redisKey);
            } catch (Exception e) {
                logger.error("删除redisKey异常", e);
            }
        }
        if (liquidationLog != null) {
            //更新清分清算日志
            liquidationLogService.updateResultById(liquidationLog.getId(), response.getResponseMsg());
        }
        logger.info("清分清算处理结束, response={}", response);
        return response;
    }

    /**
     * 清分处理
     *
     * @param orderType
     * @param orderId
     * @throws Exception
     */
    private void clearingOrder(OrderTypeEnum orderType, String orderId) throws Exception {
        switch (orderType) {
            case LIQUIDATION:
                //清算主订单清分
                liquidationOrderClearingService.clearingLiquidationOrder(orderId);
                break;
            case RISK:
                liquidationOrderClearingService.clearingRiskOrder(orderId);
                break;
            case CHANNEL:
                clearingChannelOrder(orderId);
                break;
            case LIQUIDATION_SUB:
                //清算子订单记账
                String dealCode = AccountConstantConstant.DEAL_LIQUIDATION_SUB_ORDER_CODE;
                doAccountingForLiquidationSubOrder(orderId, dealCode);
                //补偿清算子订单记账失败记录
                doAccountingForLiquidationSubOrderAccountEorror(dealCode);
                break;
            case SETTLEMENT_DETAIL:
            	//结算明细记账
            	doAccountingForSettlementDetail(orderId);
                break;
            default:
                throw new BusinessException(CmpCssExceptionCode.PARAMETERS_ERROR.getCode(), "未知的订单类型");
        }
    }

	/**
     * @des    处理结算明细日间记账
     * @param  orderId 清算主订单ID
     * @author yuyao
	 * @throws BusinessException 
     * @date   <a>2018-07-09<a>
     * */
    private void doAccountingForSettlementDetail(String orderId) throws BusinessException {
    	logger.info("结算明细进行记账开始",orderId);
    	List<MertSettlementDetail> mertSettlementDetailList=mertSettlementDetailService.getMertSettlementDetailListByOrderId(orderId);
    	if (mertSettlementDetailList == null) {
    		logger.error("结算明细进行记账失败",orderId);
            throw new BusinessException(CmpCssExceptionCode.BUSINESS_ERROR.getCode(), "未找到结算明细记账记录");
        }
    	for (Iterator iterator = mertSettlementDetailList.iterator(); iterator
				.hasNext();) {
			MertSettlementDetail mertSettlementDetail = (MertSettlementDetail) iterator
					.next();
			String dealCode =AccountConstantConstant.DEAL_SETTLE_DETAIL_CODE;
			//消费本金不记账，通过子单记账，保证金不记账	
			if(!mertSettlementDetail.getAmountType().equals(FinanceTypeEnum.PRINCIPAL.getCode())){
				CreateMermberAccountFeeResponse response=mertSettlementDetailService.dealMertSettlementDetailAccount(mertSettlementDetail,dealCode);
				if(!BaseRespStatusEnum.SUCCESS.getCode().equals(response.getResponseStatus())){
					 logger.error("结算明细进行记账失败",mertSettlementDetail.getId());
					 throw new BusinessException(CmpCssExceptionCode.BUSINESS_ERROR.getCode(), response.getResponseMsg());
				}
			} 
		}
    	logger.info("结算明细进行记账结束",orderId);
	}

	/**
     * 清算子订单记账
     *
     * @param orderId
     * @throws Exception
     */
    private CreateMermberAccountFeeResponse doAccountingForLiquidationSubOrder(String orderId, String dealCode) throws Exception {
        LiquidationOrder liquidationOrder = liquidationOrderService.selectByOrderId(orderId);
        if (liquidationOrder == null) {
            throw new BusinessException(CmpCssExceptionCode.BUSINESS_ERROR.getCode(), "未找到清算主订单");
        }
        //获取清算子订单信息
        List<LiquidationSubOrder> liquidationSubOrderList = liquidationSubOrderService.selectByLiquidationOrderId(liquidationOrder.getId());
        if (liquidationSubOrderList == null) {
            throw new BusinessException(CmpCssExceptionCode.BUSINESS_ERROR.getCode(), "未找到清算子订单");
        }
        CreateMermberAccountFeeResponse createMermberAccountFeeResponse = new CreateMermberAccountFeeResponse();
        //开始调用记账接口
        //根据清算主订单查询记账规则接口获取主订单记账规则
        CreateAccountingRequest request = new CreateAccountingRequest();
        request.setProdCode(AccountConstantConstant.PRODUCT_NO);
        request.setMerchantOrderNo(liquidationOrder.getMerchantOrderId());
        request.setTradeType(liquidationOrder.getTransType());
        request.setFinanceType(AccountConstantConstant.AMOUNT_TYPE);
        request.setUserId(liquidationOrder.getMerchantId());
        request.setUserName(liquidationOrder.getMerchantName());
        request.setSysTraceNo(liquidationOrder.getOrderId());
        request.setTxnOrderNo(liquidationOrder.getMerchantOrderId());
        request.setTxnTime(liquidationOrder.getPayCompleteTime());
        List<CreateAccountingAmount> CreateAccountingRequestList = new ArrayList<CreateAccountingAmount>();
        for (Iterator iterator = liquidationSubOrderList.iterator(); iterator.hasNext(); ) {
            LiquidationSubOrder liquidationSubOrder = (LiquidationSubOrder) iterator.next();
            //记录正常子单补单操作记账
            if (liquidationSubOrder.getErrorHandlingFlag().equals(ErrorHandingFlagEnum.YES.getCode())) {
                request.setSceneCode(AccountConstantConstant.DEAL_LIQUIDATION_SUB_ORDER_CODE);
            } else {
                //差错补单
                request.setSceneCode(AccountConstantConstant.DEAL_ERROR_HANDING_FLAG_CODE);
            }
            //防止重复记账
            if (liquidationSubOrder.getAccountingStatus().equals(AcctPipeLogStatusTypeEnum.SUCCESS.getCode())) {
                continue;
            }
            CreateAccountingAmount createAccountingAmountTrade = new CreateAccountingAmount();
            createAccountingAmountTrade.setAmount(liquidationOrder.getTransAmount().abs());
            createAccountingAmountTrade.setCurrency(liquidationOrder.getTransCurrency());
            createAccountingAmountTrade.setCurrencyType(CurrencyTypeEnum.TRANSACTION.getCode());
            createAccountingAmountTrade.setVoucherNo(liquidationOrder.getId());
            CreateAccountingRequestList.add(createAccountingAmountTrade);
            CreateAccountingAmount createAccountingAmountPay = new CreateAccountingAmount();

            createAccountingAmountPay.setAmount(liquidationSubOrder.getPayAmount().abs());
            createAccountingAmountPay.setCurrency(liquidationSubOrder.getPayCurrency());
            createAccountingAmountPay.setCurrencyType(CurrencyTypeEnum.PAYMENT.getCode());
            createAccountingAmountPay.setVoucherNo(liquidationSubOrder.getLiquidationOrderId());
            CreateAccountingRequestList.add(createAccountingAmountPay);
            request.setList(CreateAccountingRequestList);
            request.setOrgCode(liquidationSubOrder.getPayOrgCode());
            request.setRequestId(liquidationSubOrder.getId());
            logger.info("create liquidation sub order account begin request={}", request);
            createMermberAccountFeeResponse = accountingRuleFacadeQueryRpcClient.createAccountFeeRule(request);
            logger.info("create liquidation sub order account end response={}", createMermberAccountFeeResponse);
            if (!BaseRespStatusEnum.SUCCESS.getCode().equals(createMermberAccountFeeResponse.getResponseStatus())) {
                //修改子订单记账状态
                liquidationSubOrder.setAccountingStatus(createMermberAccountFeeResponse.getAccountingStatus());
                liquidationSubOrder.setGmtUpdateTime(new Date());
                liquidationSubOrderService.updateByPrimaryKey(liquidationSubOrder);
                logger.error("", "清算子订单记账失败");
                return createMermberAccountFeeResponse;
            }
            //修改子订单记账状态
            liquidationSubOrder.setAccountingStatus(createMermberAccountFeeResponse.getAccountingStatus());
            liquidationSubOrder.setGmtUpdateTime(new Date());
            liquidationSubOrderService.updateByPrimaryKey(liquidationSubOrder);
            
            //补单记账成功调用对账系统
            if(liquidationSubOrder.getErrorHandlingFlag().equals(ErrorHandingFlagEnum.NO.getCode())){
            	LiquidationSubOrderDTO liquidationSubOrderDto=new LiquidationSubOrderDTO();
            	BeanUtils.copyProperties(liquidationSubOrder, liquidationSubOrderDto);
            	channelWaterPushFacadeClient.pushAccount(liquidationSubOrderDto, liquidationOrder.getTransType());
            }
        }
        return createMermberAccountFeeResponse;
    }

    /**
     * 重新补偿清算子订单记账规则
     *
     * @param dealCode
     * @throws Exception
     */
    public void doAccountingForLiquidationSubOrderAccountEorror(String dealCode) throws Exception {

        LiquidationSubOrder liquidationSubOrderRequest = new LiquidationSubOrder();
        liquidationSubOrderRequest.setAccountingStatus(AcctPipeLogStatusTypeEnum.FAIL.getCode());
        //获取清算子订单记账失败的记录
        try {
            List<LiquidationSubOrder> liquidationSubOrderList = liquidationSubOrderService.selectByParams(liquidationSubOrderRequest);
            for (Iterator iterator = liquidationSubOrderList.iterator(); iterator
                    .hasNext(); ) {
                LiquidationSubOrder liquidationSubOrder = (LiquidationSubOrder) iterator
                        .next();
                LiquidationOrder liquidationOrder = liquidationOrderService.selectByPrimaryKey(liquidationSubOrder.getLiquidationOrderId());
                if (liquidationOrder != null) {
                    doAccountingForLiquidationSubOrder(liquidationOrder.getOrderId(), dealCode);
                }
            }
        } catch (Exception e) {
            throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "清算子订单补偿记账失败");
        }
    }

    /**
     * 渠道流水清分（包含补处理）
     *
     * @param channelOrderId 渠道流水号
     * @author hongxu.gao
     * @date 2018/9/18 10:56
     */
    public void clearingChannelOrder(String channelOrderId) throws Exception {
        logger.info("渠道订单清分开始，request={}", channelOrderId);
        ChannelOrder channelOrderTmp = new ChannelOrder();
        channelOrderTmp.setChannelOrderId(channelOrderId);
        List<ChannelOrder> channelOrderList = channelOrderService.selectByParams(channelOrderTmp);
        if (CollectionUtils.isEmpty(channelOrderList)) {
            throw new BusinessException(CmpCssExceptionCode.BUSINESS_ERROR.getCode(), "未找到渠道流水");
        }

        ChannelClearingDetail channelClearingDetail = new ChannelClearingDetail();
        ChannelOrder order = channelOrderList.get(0);
        String chargeCostFlag = Objects.toString(order.getChargeCostFlag(), "");
        String waterPushFlag = Objects.toString(order.getWaterPushFlag(), "");
        if (!chargeCostFlag.equals(FeeFlagEnum.RECEIVED.getCode())) {
            try {
                // 计费规则查询
                ChannelChargeStrategyQueryParam strategyQueryParam = new ChannelChargeStrategyQueryParam();
                strategyQueryParam.setChannelCode(order.getOrgCode());
                strategyQueryParam.setChargeScene(EnumMappingUtil.tradeTypeEnum2ChargeSceneEnum(TradeTypeEnum.getByNumeric(order.getTransType())).getCode());
                strategyQueryParam.setTradeStatus(order.getTransStatus());
                ChargeStrategyResponse chargeStrategyResponse = channelChargeCalcFacadeClient.channelChargeStrategyQuery(strategyQueryParam);

                // 解析计费策略查询接口响应对象并构建计费接口请求参数对象
                Map<Object, Object> calculateParamMap = new BeanMap(order);
                SingleResponse singleResponse = channelChargeCalcFacadeClient.buildChannelChargeCalcMustParams(chargeStrategyResponse, calculateParamMap);
                if (!singleResponse.getResponseStatus().equals(BaseRespStatusEnum.SUCCESS.getCode())) {
                    updateChannelOrderChargeCostStats(order.getId(), "", FeeFlagEnum.FAILED.getCode());
                    logger.info("渠道计费接口所需必填参数" + singleResponse.getResponseMsg());
                } else {
                    // 计费接口调用
                    ChannelChargeCalculateParam calculateParam = (ChannelChargeCalculateParam) singleResponse.getResponseObj();
                    calculateParam.setFeeId(chargeStrategyResponse.getFeeId());
                    calculateParam.setRequestTime(DateUtil.toFullDateString(new Date()));
                    ChannelChargeCalculateResult calculateResult = channelChargeCalcFacadeClient.channelChargeCalc(calculateParam);

                    // 保存渠道流水清分明细
                    channelClearingDetail = this.buildChannelClearingDetailParams(calculateResult, order.getChannelOrderId());
                    channelClearingDetailService.insertClearingDetail(channelClearingDetail);

                    // 修改渠道流水单收费状态
                    updateChannelOrderChargeCostStats(order.getId(), calculateResult.getChargeWay(), FeeFlagEnum.RECEIVED.getCode());
                }
            } catch (BusinessException e) {
                updateChannelOrderChargeCostStats(order.getId(), "", FeeFlagEnum.FAILED.getCode());
                BaseResponse baseResponse = new BaseResponse();
                baseResponse.setResponseCode(e.getResponseCode());
                baseResponse.setResponseMsg(e.getResponseMsg());
                logger.error("渠道成本计算失败,response={}", baseResponse);
            }
        }

        if (!waterPushFlag.equals(BaseRespStatusEnum.SUCCESS.getCode())) {
            // 渠道流水推送
            SettlementTransDetailDTO settlementTransDetailDto = new SettlementTransDetailDTO();
            BeanUtils.copyProperties(order, settlementTransDetailDto);
            BeanUtils.copyProperties(channelClearingDetail, settlementTransDetailDto);
            BaseResponse response = channelWaterPushFacadeClient.push(settlementTransDetailDto);
            ChannelOrder tmpChannelOrder = new ChannelOrder();
            tmpChannelOrder.setId(order.getId());
            if (BaseRespStatusEnum.SUCCESS.getCode().equals(response.getResponseStatus())) {
                tmpChannelOrder.setWaterPushFlag(BaseRespStatusEnum.SUCCESS.getCode());
            } else {
                tmpChannelOrder.setWaterPushFlag(BaseRespStatusEnum.FAIL.getCode());
            }
            channelOrderService.updateByPrimaryKeySelective(tmpChannelOrder);
        }
        logger.info("渠道订单清分结束");
    }

    /**
     * 修改渠道流水单成本收取状态
     *
     * @return void
     * @author hongxu.gao
     * @date 2018/9/10 11:14
     */
    private void updateChannelOrderChargeCostStats(String id, String chargeWay, String flag) {
        ChannelOrder channelOrderTmp = new ChannelOrder();
        channelOrderTmp.setId(id);
        channelOrderTmp.setChargeCostFlag(flag);
        channelOrderTmp.setChargeCostType(chargeWay);
        channelOrderTmp.setGmtUpdateTime(new Date());
        channelOrderService.updateByPrimaryKeySelective(channelOrderTmp);
    }

    /**
     * 构建渠道清分明细对象数据
     *
     * @param calculateResult 渠道成本响应结果对象
     * @param channelOrderId  渠道流水号
     * @return com.ipaylinks.cmp.css.dal.model.ChannelClearingDetail
     * @author hongxu.gao
     * @date 2018/9/18 10:49
     */
    private ChannelClearingDetail buildChannelClearingDetailParams(ChannelChargeCalculateResult calculateResult, String channelOrderId) {
        ChannelClearingDetail channelClearingDetail = new ChannelClearingDetail();
        channelClearingDetail.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        channelClearingDetail.setChannelDetailId(channelOrderId);
        channelClearingDetail.setPercentFeeCurrency(calculateResult.getPercentCurrency());
        channelClearingDetail.setPercentFeeAmount(calculateResult.getPercentFee());
        channelClearingDetail.setFixedFeeCurrency(calculateResult.getFixedCurrency());
        channelClearingDetail.setFixedFeeAmount(calculateResult.getFixedFee());
        channelClearingDetail.setFeeCurrency(calculateResult.getDealCurrency());
        channelClearingDetail.setFeeAmount(calculateResult.getDealFee());
        channelClearingDetail.setCostSettleDate(calculateResult.getFeeSettlementDate());
        channelClearingDetail.setChargeCostMethod(calculateResult.getChargeWay());
        channelClearingDetail.setCostId(calculateResult.getFeeId());
        channelClearingDetail.setGmtCreateTime(new Date());
        return channelClearingDetail;
    }

}

