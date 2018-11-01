package com.ipaylinks.cmp.css.facade;

import com.ipaylinks.cmp.css.facade.request.RiskOrderCreateRequest;
import com.ipaylinks.common.rpc.BaseResponse;

/**
 * 风控订单对外服务
 */
public interface RiskOrderFacade {

    /**
     * 风控订单落单
     * @param request
     * @return
     */
    BaseResponse createRiskOrder(RiskOrderCreateRequest request);



}
