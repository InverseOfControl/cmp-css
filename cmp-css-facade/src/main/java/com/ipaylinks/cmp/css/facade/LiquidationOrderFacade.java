package com.ipaylinks.cmp.css.facade;

import com.ipaylinks.cmp.css.facade.request.LiquidationOrderCreateRequest;
import com.ipaylinks.cmp.css.facade.request.LiquidationOrderQueryRequest;
import com.ipaylinks.cmp.css.facade.request.LiquidationSubOrderQueryRequest;
import com.ipaylinks.common.rpc.BaseResponse;
import com.ipaylinks.common.rpc.response.PageQueryResponse;

/**
 * 清算订单对外服务
 */
public interface LiquidationOrderFacade {

    /**
     * 清算订单落单
     * @param request
     * @return
     */
    BaseResponse createLiquidationOrder(LiquidationOrderCreateRequest request);

    /**
     * 清算订单查询接口
     *   
     * @author hongxu.gao
     * @date 2018/7/27 10:51
     * @param request 请求参数对象
     * @return com.ipaylinks.common.rpc.BaseResponse        
     */
    PageQueryResponse queryLiquidationOrder(LiquidationOrderQueryRequest request);

    /**
     * 清算子订单查询接口
     *
     * @author hongxu.gao
     * @date 2018/9/8 14:05
     * @param request 请求参数对象
     * @return com.ipaylinks.common.rpc.response.PageQueryResponse
     */
    PageQueryResponse queryLiquidationSubOrder(LiquidationSubOrderQueryRequest request);

}
