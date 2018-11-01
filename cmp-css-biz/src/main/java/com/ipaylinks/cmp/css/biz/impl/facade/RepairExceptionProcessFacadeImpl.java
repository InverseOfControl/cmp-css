package com.ipaylinks.cmp.css.biz.impl.facade;

import com.ipaylinks.cmp.css.biz.impl.common.ClearingOrderHandler;
import com.ipaylinks.cmp.css.biz.impl.common.RequestValidator;
import com.ipaylinks.cmp.css.dal.model.LiquidationOrder;
import com.ipaylinks.cmp.css.dal.model.MertClearingDetail;
import com.ipaylinks.cmp.css.dal.model.RiskOrder;
import com.ipaylinks.cmp.css.facade.RepairExceptionProcessFacade;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.facade.enums.LiquidationStatusEnum;
import com.ipaylinks.cmp.css.facade.enums.OrderTypeEnum;
import com.ipaylinks.cmp.css.facade.request.ChannelOrderQueryRequest;
import com.ipaylinks.cmp.css.facade.request.GenMertSettlementDetailRequest;
import com.ipaylinks.cmp.css.facade.request.OrderClearingRequest;
import com.ipaylinks.cmp.css.service.LiquidationOrderClearingService;
import com.ipaylinks.cmp.css.service.LiquidationOrderService;
import com.ipaylinks.cmp.css.service.MertClearingDetailService;
import com.ipaylinks.cmp.css.service.RiskOrderService;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.ipaylinks.cmp.css.util.RedisKeyConstants;
import com.ipaylinks.cmp.css.util.ResponseUtils;
import com.ipaylinks.common.rpc.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 异常流程补处理
 * @author dapeng.tong
 */
@Service("repairExceptionProcessFacade")
public class RepairExceptionProcessFacadeImpl implements RepairExceptionProcessFacade {

    private Logger logger = LoggerFactory.getLogger(RepairExceptionProcessFacadeImpl.class);

    @Autowired
    private ClearingOrderHandler clearingOrderHandler;
    @Autowired
    private LiquidationOrderClearingService liquidationOrderClearingService;
    @Autowired
    private RequestValidator requestValidator;
    @Autowired
    private LiquidationOrderService liquidationOrderService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private MertClearingDetailService mertClearingDetailService;
    @Autowired
    private RiskOrderService riskOrderService;

    @Override
    public BaseResponse orderClearing(OrderClearingRequest request) {
        logger.info("清分补处理开始，request={}", request);
        BaseResponse response = clearingOrderHandler.invoke(request.getOrderType(), request.getOrderId());
        logger.info("清分补处理结束，response={}", response);
        return response;
    }

    @Override
    public BaseResponse genMertSettlementDetailForLiquidationOrder(GenMertSettlementDetailRequest request) {
        logger.info("清算主订单生成结算明细补处理开始，request={}", request);
        BaseResponse response = new BaseResponse();
        String redisKey = "";
        try {
            //请求参数校验
            requestValidator.validate(request);
            //获取清算主订单
            LiquidationOrder liquidationOrder = liquidationOrderService.selectByPrimaryKey(request.getOriId());
            if (liquidationOrder == null) {
                throw new BusinessException(CmpCssExceptionCode.BUSINESS_ERROR.getCode(), "未找到清算主订单");
            }
            if (!LiquidationStatusEnum.SETTLEMENT_FAILED.getCode().equals(liquidationOrder.getStatus())) {
                logger.info("liquidationOrder.status={}", liquidationOrder.getStatus());
                throw new BusinessException(CmpCssExceptionCode.BUSINESS_ERROR.getCode(), "未找到生成结算明细失败的清算主订单");
            }
            //redis锁
            redisKey = RedisKeyConstants.GEN_MERT_SETTLEMENT_DETAIL_LOCK + OrderTypeEnum.LIQUIDATION.getCode() + request.getOriId();
            boolean flag = redisTemplate.opsForValue().setIfAbsent(redisKey, "1");
            redisTemplate.expire(redisKey, 30, TimeUnit.SECONDS);
            if (!flag) {
                throw new BusinessException(CmpCssExceptionCode.CONCURRENT_EXCEPTION.getCode(), "订单处理中，不能重复处理");
            }
            //查询清分明细
            List<MertClearingDetail > mertClearingDetailList = mertClearingDetailService.selectListByOrderTypeAndOriId(OrderTypeEnum.LIQUIDATION.getCode(), request.getOriId());
            //生成结算明细
            liquidationOrderClearingService.genMertSettlementDetail(liquidationOrder, mertClearingDetailList);
            ResponseUtils.setToSuccess(response);
        } catch (BusinessException e) {
            logger.error("清算主订单生成结算明细补处理异常", e);
            ResponseUtils.setToFail(response, e.getResponseCode(), e.getResponseMsg());
        } catch (Exception e) {
            logger.error("清算主订单生成结算明细补处理异常", e);
            ResponseUtils.setToFail(response, CmpCssExceptionCode.SYSTEM_EXCEPTION, e.getMessage());
        } finally {
            try {
                redisTemplate.delete(redisKey);
            } catch (Exception e) {
                logger.error("删除redisKey异常", e);
            }
        }
        logger.info("清算主订单生成结算明细补处理结束, response={}", response);
        return response;
    }

    @Override
    public BaseResponse genMertSettlementDetailForRiskOrder(GenMertSettlementDetailRequest request) {
        logger.info("风控订单生成结算明细补处理开始，request={}", request);
        BaseResponse response = new BaseResponse();
        String redisKey = "";
        try {
            //请求参数校验
            requestValidator.validate(request);
            //获取风控订单
            RiskOrder riskOrder = riskOrderService.selectByPrimaryKey(request.getOriId());
            if (riskOrder == null) {
                throw new BusinessException(CmpCssExceptionCode.BUSINESS_ERROR.getCode(), "未找到风控订单");
            }
            if (!LiquidationStatusEnum.SETTLEMENT_FAILED.getCode().equals(riskOrder.getFeeFlag())) {
                logger.info("riskOrder.feeFlag={}", riskOrder.getFeeFlag());
                throw new BusinessException(CmpCssExceptionCode.BUSINESS_ERROR.getCode(), "未找到生成结算明细失败的风控订单");
            }
            //redis锁
            redisKey = RedisKeyConstants.GEN_MERT_SETTLEMENT_DETAIL_LOCK + OrderTypeEnum.RISK.getCode() + request.getOriId();
            boolean flag = redisTemplate.opsForValue().setIfAbsent(redisKey, "1");
            redisTemplate.expire(redisKey, 30, TimeUnit.SECONDS);
            if (!flag) {
                throw new BusinessException(CmpCssExceptionCode.CONCURRENT_EXCEPTION.getCode(), "订单处理中，不能重复处理");
            }
            //查询清分明细
            List<MertClearingDetail > mertClearingDetailList = mertClearingDetailService.selectListByOrderTypeAndOriId(OrderTypeEnum.RISK.getCode(), request.getOriId());
            //生成结算明细
            liquidationOrderClearingService.genMertSettlementDetail(riskOrder, mertClearingDetailList);
            ResponseUtils.setToSuccess(response);
        } catch (BusinessException e) {
            logger.error("风控订单生成结算明细补处理异常", e);
            ResponseUtils.setToFail(response, e.getResponseCode(), e.getResponseMsg());
        } catch (Exception e) {
            logger.error("风控订单生成结算明细补处理异常", e);
            ResponseUtils.setToFail(response, CmpCssExceptionCode.SYSTEM_EXCEPTION, e.getMessage());
        } finally {
            try {
                redisTemplate.delete(redisKey);
            } catch (Exception e) {
                logger.error("删除redisKey异常", e);
            }
        }
        logger.info("风控订单生成结算明细补处理结束, response={}", response);
        return response;
    }

    @Override
    public BaseResponse channelWaterPush(ChannelOrderQueryRequest request) {
        String channelOrderId = request.getChannelOrderId();
        BaseResponse baseResponse = new BaseResponse();
        try {
            clearingOrderHandler.clearingChannelOrder(channelOrderId);
        } catch (Exception e) {
            ResponseUtils.setToFail(baseResponse,CmpCssExceptionCode.BUSINESS_ERROR);
            return baseResponse;
        }
        ResponseUtils.setToSuccess(baseResponse);
        return baseResponse;
    }

}
