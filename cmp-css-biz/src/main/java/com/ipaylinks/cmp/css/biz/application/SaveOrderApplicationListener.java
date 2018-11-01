package com.ipaylinks.cmp.css.biz.application;

import com.google.gson.Gson;
import com.ipaylinks.cmp.css.biz.abstarction.Context;
import com.ipaylinks.cmp.css.biz.common.BaseRequestContext;
import com.ipaylinks.cmp.css.biz.common.ChannelOrderCreateContext;
import com.ipaylinks.cmp.css.biz.common.LiquidationOrderCreateContext;
import com.ipaylinks.cmp.css.biz.common.RiskOrderCreateContext;
import com.ipaylinks.cmp.css.biz.impl.common.ClearingOrderHandler;
import com.ipaylinks.cmp.css.biz.impl.common.RequestValidator;
import com.ipaylinks.cmp.css.dal.model.AccsplitOrder;
import com.ipaylinks.cmp.css.dal.model.ChannelOrder;
import com.ipaylinks.cmp.css.dal.model.IdempotentControl;
import com.ipaylinks.cmp.css.dal.model.LiquidationOrder;
import com.ipaylinks.cmp.css.dal.model.LiquidationSubOrder;
import com.ipaylinks.cmp.css.dal.model.RequestLog;
import com.ipaylinks.cmp.css.dal.model.RiskOrder;
import com.ipaylinks.cmp.css.facade.dto.LiquidationOrderDTO;
import com.ipaylinks.cmp.css.facade.dto.LiquidationSubOrderDTO;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.facade.enums.OrderTypeEnum;
import com.ipaylinks.cmp.css.facade.request.ChannelOrderCreateRequest;
import com.ipaylinks.cmp.css.facade.request.LiquidationOrderCreateRequest;
import com.ipaylinks.cmp.css.facade.request.RiskOrderCreateRequest;
import com.ipaylinks.cmp.css.integration.mcs.MerchantSettlementConfigFacadeClient;
import com.ipaylinks.cmp.css.integration.res.MertSettlementInfo;
import com.ipaylinks.cmp.css.integration.util.EnumMappingUtil;
import com.ipaylinks.cmp.css.service.AccsplitOrderService;
import com.ipaylinks.cmp.css.service.ChannelOrderService;
import com.ipaylinks.cmp.css.service.IdempotentControlService;
import com.ipaylinks.cmp.css.service.LiquidationOrderService;
import com.ipaylinks.cmp.css.service.LiquidationSubOrderService;
import com.ipaylinks.cmp.css.service.RequestLogService;
import com.ipaylinks.cmp.css.service.RiskOrderService;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.ipaylinks.cmp.css.util.ResponseUtils;
import com.ipaylinks.common.CalculateUtil;
import com.ipaylinks.common.enums.BaseRespStatusEnum;
import com.ipaylinks.common.exception.BaseExceptionCode;
import com.ipaylinks.common.rpc.BaseRequest;
import com.ipaylinks.common.rpc.BaseResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *  商户对账单上传到ftp 事件监听
 *  @author dapeng.tong
 *  @create 2018/8/16
 *
 */
@Component
public class SaveOrderApplicationListener implements ApplicationListener<SaveOrderApplicationEvent> {
    private static Logger logger = LoggerFactory.getLogger(SaveOrderApplicationListener.class);

    @Autowired
    private RequestLogService requestLogService;
    @Autowired
    private RequestValidator requestValidator;
    @Autowired
    private IdempotentControlService idempotentControlService;
    @Autowired
    private TransactionTemplate transactionTemplate;
    @Autowired
    private LiquidationOrderService liquidationOrderService;
    @Autowired
    private LiquidationSubOrderService liquidationSubOrderService;
    @Autowired
    private AccsplitOrderService accsplitOrderService;
    @Autowired
    private RiskOrderService riskOrderService;
    @Autowired
    private ChannelOrderService channelOrderService;
    @Autowired
    private MerchantSettlementConfigFacadeClient merchantSettlementConfigFacadeClient;
    @Autowired
    private ClearingOrderHandler clearingOrderHandler;

    @Async
    @Override
    public void onApplicationEvent(SaveOrderApplicationEvent event) {
        logger.info("落单处理ApplicationListener开始");
        BaseRequestContext ctx = event.getCtx();
        BaseResponse response = new BaseResponse();
        try {
            //保存请求日志
            saveRequestLog(ctx);
            //请求参数校验
            validateRequestParams(ctx);
            //订单转换处理，转换为标准订单
            convertOrder(ctx);
            //订单幂等性处理，通过幂等控制表实现
            idempotentControl(ctx);
            //保存订单到数据库
            saveOrder(ctx);
            //落单后处理
            afterSaveOrder(ctx);
            //清算清分
            clearingOrder(ctx);
            //设置response状态为成功
            ResponseUtils.setToSuccess(response);
        }catch (BusinessException e){
            logger.error("落单处理ApplicationListener异常", e);
            ResponseUtils.setToFail(response, e.getResponseCode(), e.getResponseMsg());
        }catch (Exception e){
            logger.error("落单处理ApplicationListener异常", e);
            ResponseUtils.setToFail(response, CmpCssExceptionCode.SYSTEM_EXCEPTION);
        }
        //更新请求日志
        requestLogService.updateResponseContentById(ctx.getRequestLog().getId(), new Gson().toJson(response));
        logger.info("落单处理ApplicationListener结束，response={}", response);
    }

    private void saveRequestLog(Context ctx) throws Exception {
        logger.info("RequestLogSaveProcessor begin");
        if(ctx instanceof LiquidationOrderCreateContext){
            LiquidationOrderCreateContext context = (LiquidationOrderCreateContext)ctx;
            LiquidationOrderCreateRequest request = (LiquidationOrderCreateRequest)context.getBaseRequest();
            RequestLog requestLog = new RequestLog();
            requestLog.setReqSysId(request.getClientCode());
            requestLog.setRequestId(request.getTraceId());
            requestLog.setType("清算订单落单");
            requestLog.setRequestContent(new Gson().toJson(request));
            requestLog.setOrderId(request.getLiquidationOrderDTO()!=null?request.getLiquidationOrderDTO().getOrderId():null);
            requestLogService.insertSelective(requestLog);
            context.setRequestLog(requestLog);
        }else if(ctx instanceof RiskOrderCreateContext){
            RiskOrderCreateContext context = (RiskOrderCreateContext)ctx;
            RiskOrderCreateRequest request = (RiskOrderCreateRequest)context.getBaseRequest();
            RequestLog requestLog = new RequestLog();
            requestLog.setReqSysId(request.getClientCode());
            requestLog.setRequestId(request.getTraceId());
            requestLog.setType("风控订单落单");
            requestLog.setRequestContent(new Gson().toJson(request));
            requestLog.setOrderId(request.getOrderId());
            requestLogService.insertSelective(requestLog);
            context.setRequestLog(requestLog);
        }else if(ctx instanceof ChannelOrderCreateContext){
            ChannelOrderCreateContext context = (ChannelOrderCreateContext)ctx;
            ChannelOrderCreateRequest request = (ChannelOrderCreateRequest)context.getBaseRequest();
            RequestLog requestLog = new RequestLog();
            requestLog.setReqSysId(request.getClientCode());
            requestLog.setRequestId(request.getTraceId());
            requestLog.setType("渠道订单落单");
            requestLog.setRequestContent(new Gson().toJson(request));
            requestLog.setOrderId(request.getOrderId());
            requestLogService.insertSelective(requestLog);
            context.setRequestLog(requestLog);
        }else{
            logger.info("未知的上下文");
        }
        logger.info("RequestLogSaveProcessor end");
    }

    private void validateRequestParams(Context ctx) throws Exception {
        logger.info("RequestParamsValidateProcessor begin");
        BaseRequestContext baseRequestContext = (BaseRequestContext)ctx;
        BaseRequest baseRequest = baseRequestContext.getBaseRequest();
        requestValidator.validate(baseRequest);
        if(ctx instanceof LiquidationOrderCreateContext){
            LiquidationOrderCreateContext context = (LiquidationOrderCreateContext)ctx;
            LiquidationOrderCreateRequest request = (LiquidationOrderCreateRequest)context.getBaseRequest();
            requestValidator.validate(request.getLiquidationOrderDTO());
            for(LiquidationSubOrderDTO liquidationSubOrderDTO : request.getLiquidationSubOrderDTOList()){
                requestValidator.validate(liquidationSubOrderDTO);
            }
        }
        logger.info("RequestParamsValidateProcessor end");
    }

    private void convertOrder(Context ctx) throws Exception {
        logger.info("OrderConvertProcessor begin");
        if(ctx instanceof LiquidationOrderCreateContext){
            //清算主订单转换
            convertLiquidationOrder(ctx);
            //清算子订单转换
            convertLiquidationSubOrder(ctx);
            //分账订单转换
            convertAccsplitOrder(ctx);
        }else if(ctx instanceof RiskOrderCreateContext){
            RiskOrderCreateContext context = (RiskOrderCreateContext)ctx;
            RiskOrderCreateRequest request = (RiskOrderCreateRequest)context.getBaseRequest();
            RiskOrder riskOrder = new RiskOrder();
            BeanUtils.copyProperties(request, riskOrder);
            riskOrder.setPayMethod(EnumMappingUtil.getPayMethodByPayKind(riskOrder.getPayKind()));
            context.setRiskOrder(riskOrder);
        }else if(ctx instanceof ChannelOrderCreateContext){
            ChannelOrderCreateContext context = (ChannelOrderCreateContext)ctx;
            ChannelOrderCreateRequest request = (ChannelOrderCreateRequest)context.getBaseRequest();
            ChannelOrder channelOrder = new ChannelOrder();
            BeanUtils.copyProperties(request, channelOrder);
            channelOrder.setPayMethod(EnumMappingUtil.getPayMethodByPayKind(channelOrder.getPayKind()));
            context.setChannelOrder(channelOrder);
        }else{
            logger.info("未知的上下文");
        }
        logger.info("OrderConvertProcessor end");
    }

    private void convertLiquidationOrder(Context ctx) throws Exception {
        logger.info("LiquidationOrderConverter begin");
        LiquidationOrderCreateContext context = (LiquidationOrderCreateContext)ctx;
        LiquidationOrderCreateRequest request = (LiquidationOrderCreateRequest)context.getBaseRequest();
        LiquidationOrderDTO liquidationOrderDTO = request.getLiquidationOrderDTO();
        LiquidationOrder liquidationOrder = new LiquidationOrder();
        BeanUtils.copyProperties(liquidationOrderDTO, liquidationOrder);
        liquidationOrder.setPayMethod(EnumMappingUtil.getPayMethodByPayKind(liquidationOrder.getPayKind()));
        context.setLiquidationOrder(liquidationOrder);
        logger.info("LiquidationOrderConverter end");
    }

    private void convertLiquidationSubOrder(Context ctx) throws Exception {
        logger.info("LiquidationSubOrderConverter begin");
        LiquidationOrderCreateContext context = (LiquidationOrderCreateContext)ctx;
        LiquidationOrderCreateRequest request = (LiquidationOrderCreateRequest)context.getBaseRequest();
        List<LiquidationSubOrderDTO> liquidationSubOrderDTOList = request.getLiquidationSubOrderDTOList();
        List<LiquidationSubOrder> liquidationSubOrderList = new ArrayList<>();
        for(LiquidationSubOrderDTO liquidationSubOrderDTO : liquidationSubOrderDTOList){
            LiquidationSubOrder liquidationSubOrder = new LiquidationSubOrder();
            BeanUtils.copyProperties(liquidationSubOrderDTO, liquidationSubOrder);
            liquidationSubOrder.setPayAmount(CalculateUtil.roundMoney(liquidationSubOrder.getPayAmount(), liquidationSubOrder.getPayCurrency()));
            liquidationSubOrder.setPayMethod(EnumMappingUtil.getPayMethodByPayKind(liquidationSubOrder.getPayKind()));
            liquidationSubOrderList.add(liquidationSubOrder);
        }
        context.setLiquidationSubOrderList(liquidationSubOrderList);
        logger.info("LiquidationSubOrderConverter end");
    }

    private void convertAccsplitOrder(Context ctx) throws Exception {
        logger.info("AccSplitOrderConverter begin");
        LiquidationOrderCreateContext context = (LiquidationOrderCreateContext)ctx;
        LiquidationOrderCreateRequest request = (LiquidationOrderCreateRequest)context.getBaseRequest();
        LiquidationOrderDTO liquidationOrderDTO = request.getLiquidationOrderDTO();
        if(StringUtils.isNotBlank(liquidationOrderDTO.getSubAccountData())){
            logger.info("subAccountData is not null");
            List<Map<String, String>> subAccountList = new Gson().fromJson(liquidationOrderDTO.getSubAccountData(), List.class);
            List<AccsplitOrder> accsplitOrderList = new ArrayList<>();
            for(Map<String, String> subAccount : subAccountList){
                AccsplitOrder accsplitOrder = new AccsplitOrder();
                String merchantId = subAccount.get("merchantId");
                if(StringUtils.isBlank(merchantId)){
                    merchantId = subAccount.get("partnerId");
                }
                String transCurrency = subAccount.get("currency");
                if(StringUtils.isBlank(transCurrency)){
                    transCurrency = subAccount.get("currencyCode");
                }
                accsplitOrder.setMerchantId(merchantId);
                //TODO 看是传过来，还是查数据库，如果查数据库，在OrderPostProcessProcessor处理
                accsplitOrder.setMerchantName(subAccount.get("merchantName"));
                accsplitOrder.setTransCurrency(transCurrency);
                accsplitOrder.setTransAmount(new BigDecimal(subAccount.get("amount")).divide(new BigDecimal(100)));
                accsplitOrder.setMerchantOrderId(liquidationOrderDTO.getMerchantOrderId());
                accsplitOrder.setOrderId(liquidationOrderDTO.getOrderId());
                accsplitOrderList.add(accsplitOrder);
            }
            context.setAccsplitOrderList(accsplitOrderList);
        }
        logger.info("AccSplitOrderConverter end");
    }

    private void idempotentControl(Context ctx) throws Exception {
        logger.info("OrderIdempotentControlProcessor begin");
        if(ctx instanceof LiquidationOrderCreateContext){
            LiquidationOrderCreateContext context = (LiquidationOrderCreateContext)ctx;
            IdempotentControl idempotentControl = new IdempotentControl();
            idempotentControl.setBizDesc("清算订单落单");
            idempotentControl.setUniqueKey(context.getLiquidationOrder().getOrderId());
            idempotentControlService.insert(idempotentControl);
        }else if(ctx instanceof RiskOrderCreateContext){
            /*RiskOrderCreateContext context = (RiskOrderCreateContext)ctx;
            IdempotentControl idempotentControl = new IdempotentControl();
            idempotentControl.setBizDesc("风控订单落单");
            idempotentControl.setUniqueKey(context.getRiskOrder().getRiskOrderId());
            idempotentControlService.insert(idempotentControl);*/
        }else if(ctx instanceof ChannelOrderCreateContext){
            /*ChannelOrderCreateContext context = (ChannelOrderCreateContext)ctx;
            IdempotentControl idempotentControl = new IdempotentControl();
            idempotentControl.setBizDesc("渠道订单落单");
            idempotentControl.setUniqueKey(context.getChannelOrder().getChannelOrderId());
            idempotentControlService.insert(idempotentControl);*/
        }else{
            logger.info("未知的上下文");
        }
        logger.info("OrderIdempotentControlProcessor end");
    }

    private void saveOrder(Context ctx) throws Exception{
        logger.info("OrderPersistProcessor begin");
        if(ctx instanceof LiquidationOrderCreateContext){
            LiquidationOrderCreateContext context = (LiquidationOrderCreateContext)ctx;
            boolean result = saveLiquidationOrder(context);
            if(!result){
                throw new BusinessException(CmpCssExceptionCode.DATABASE_EXCEPTION.getCode(), "清算订单保存异常");
            }
        }else if(ctx instanceof RiskOrderCreateContext){
            RiskOrderCreateContext context = (RiskOrderCreateContext)ctx;
            riskOrderService.insertSelective(context.getRiskOrder());
        }else if(ctx instanceof ChannelOrderCreateContext){
            ChannelOrderCreateContext context = (ChannelOrderCreateContext)ctx;
            channelOrderService.insertSelective(context.getChannelOrder());
        }else{
            logger.info("未知的上下文");
        }
        logger.info("OrderPersistProcessor end");
    }

    private boolean saveLiquidationOrder(LiquidationOrderCreateContext context){
        boolean result = transactionTemplate.execute(new TransactionCallback<Boolean>() {
            @Override
            public Boolean doInTransaction(TransactionStatus transactionStatus) {
                boolean resp = true;
                try {
                    liquidationOrderService.insertSelective(context.getLiquidationOrder());
                    List<LiquidationSubOrder> liquidationSubOrderList = context.getLiquidationSubOrderList();
                    for(LiquidationSubOrder liquidationSubOrder : liquidationSubOrderList){
                        liquidationSubOrder.setLiquidationOrderId(context.getLiquidationOrder().getId());
                        liquidationSubOrderService.insertSelective(liquidationSubOrder);
                    }
                    List<AccsplitOrder> accsplitOrderList = context.getAccsplitOrderList();
                    if(!CollectionUtils.isEmpty(accsplitOrderList)){
                        for(AccsplitOrder accsplitOrder : accsplitOrderList){
                            accsplitOrderService.insertSelective(accsplitOrder);
                        }
                    }
                }catch (Exception e) {
                    logger.error("清算订单保存异常", e);
                    transactionStatus.setRollbackOnly();
                    resp = false;
                }
                return resp;
            }
        });
        return result;
    }

    private void afterSaveOrder(Context ctx) throws Exception {
        logger.info("OrderPostProcessProcessor begin");
        if(ctx instanceof LiquidationOrderCreateContext){
            LiquidationOrderCreateContext context = (LiquidationOrderCreateContext)ctx;
            LiquidationOrder liquidationOrder = context.getLiquidationOrder();
            MertSettlementInfo mertSettlementInfo = merchantSettlementConfigFacadeClient.queryMertSettlementInfo(liquidationOrder.getMerchantId(), liquidationOrder.getPayMethod(), liquidationOrder.getCardCountry(), liquidationOrder.getPayOrgCode(), liquidationOrder.getTransCurrency(), liquidationOrder.getTransMethod());
            String settleDate = mertSettlementInfo.getMertSettlementDate();
            String settleCurrency = mertSettlementInfo.getSettlementCurrencys();
            liquidationOrder.setSettleDate(settleDate);
            liquidationOrder.setSettleCurrency(settleCurrency);
            if(StringUtils.isBlank(settleDate) || StringUtils.isBlank(settleCurrency)){
                throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "查询到的结算日期或结算币种为空");
            }
            liquidationOrderService.updateByPrimaryKeySelective(liquidationOrder);
        }else if(ctx instanceof RiskOrderCreateContext){
            //TODO
        }else if(ctx instanceof ChannelOrderCreateContext){
            //TODO
        }else{
            logger.info("未知的上下文");
        }
        logger.info("OrderPostProcessProcessor end");
    }

    private void clearingOrder(Context ctx) throws BusinessException {
        logger.info("OrderClearingNotifyProcessor begin");
        if(ctx instanceof LiquidationOrderCreateContext){
            LiquidationOrderCreateContext context = (LiquidationOrderCreateContext)ctx;
            BaseResponse baseResponse= clearingOrderHandler.invoke(OrderTypeEnum.LIQUIDATION, context.getLiquidationOrder().getOrderId());
            if (!BaseExceptionCode.SUCCESS.getCode().equals(baseResponse.getResponseCode())) {
            	 logger.info("订单清分异常，无法进行记账处理",baseResponse.getResponseMsg());
            	 throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), baseResponse.getResponseMsg());
            }
            clearingOrderHandler.invoke(OrderTypeEnum.LIQUIDATION_SUB, context.getLiquidationOrder().getOrderId());
            //结算明细记账
            clearingOrderHandler.invoke(OrderTypeEnum.SETTLEMENT_DETAIL, context.getLiquidationOrder().getOrderId());
        }else if(ctx instanceof RiskOrderCreateContext){
            RiskOrderCreateContext context = (RiskOrderCreateContext)ctx;
            clearingOrderHandler.invoke(OrderTypeEnum.RISK, context.getRiskOrder().getOrderId());
        }else if(ctx instanceof ChannelOrderCreateContext){
            ChannelOrderCreateContext context = (ChannelOrderCreateContext)ctx;
            clearingOrderHandler.invoke(OrderTypeEnum.CHANNEL, context.getChannelOrder().getChannelOrderId());
        }else{
            logger.info("未知的上下文");
        }
        logger.info("OrderClearingNotifyProcessor end");
    }

}
