package com.ipaylinks.cmp.css.facade;

import com.ipaylinks.cmp.css.facade.dto.ChannelCostDto;
import com.ipaylinks.cmp.css.facade.request.ChannelOrderCreateRequest;
import com.ipaylinks.cmp.css.facade.request.ChannelOrderQueryRequest;
import com.ipaylinks.cmp.css.facade.request.QueryChannelCostRequest;
import com.ipaylinks.common.rpc.BaseResponse;
import com.ipaylinks.common.rpc.response.PageQueryResponse;

/**
 * 渠道流水对外服务
 */
public interface ChannelOrderFacade {

    /**
     * 渠道流水落单
     * @param request
     * @return
     */
    BaseResponse createChannelOrder(ChannelOrderCreateRequest request);

    /**
     * 渠道流水查询
     *
     * @author hongxu.gao
     * @date 2018/8/6 15:11
     * @param request 请求对象
     * @return com.ipaylinks.common.rpc.BaseResponse
     */
    PageQueryResponse queryChannelOrder(ChannelOrderQueryRequest request);


    /**
     * 渠道成本查询
     *
     * @author hongxu.gao
     * @date 2018/8/29 17:10
     * @return com.ipaylinks.common.rpc.response.PageQueryResponse<com.ipaylinks.cmp.css.facade.dto.ChannelCostDto>
     */
    PageQueryResponse<ChannelCostDto> queryChannelCost(QueryChannelCostRequest request);

}
