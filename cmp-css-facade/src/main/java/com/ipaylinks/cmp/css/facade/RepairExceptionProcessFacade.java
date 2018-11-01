package com.ipaylinks.cmp.css.facade;

import com.ipaylinks.cmp.css.facade.request.ChannelOrderQueryRequest;
import com.ipaylinks.cmp.css.facade.request.GenMertSettlementDetailRequest;
import com.ipaylinks.cmp.css.facade.request.OrderClearingRequest;
import com.ipaylinks.common.rpc.BaseResponse;

/**
 *  异常流程补处理
 */
public interface RepairExceptionProcessFacade {

    //TODO 落单失败也要能补落，要看下怎么弄
    //TODO 查询结算日期等失败补处理

    /**
     *  订单清分失败，重新清分
     * @param request
     * @return
     */
    BaseResponse orderClearing(OrderClearingRequest request);

    /**
     * 清算主订单清分明细生成结算明细失败，重新生成
     * @return
     */
    BaseResponse genMertSettlementDetailForLiquidationOrder(GenMertSettlementDetailRequest request);

    /**
     * 风控订单清分明细生成结算明细失败，重新生成
     * @return
     */
    BaseResponse genMertSettlementDetailForRiskOrder(GenMertSettlementDetailRequest request);

    //TODO 清算子订单记账失败，重新处理

    /**
     * 渠道流水推送失败，手动触发按钮重新推送
     *
     * @author hongxu.gao
     * @date 2018/9/17 15:13
     * @param request 请求对象
     * @return com.ipaylinks.common.rpc.BaseResponse
     */
    BaseResponse channelWaterPush(ChannelOrderQueryRequest request);

}
