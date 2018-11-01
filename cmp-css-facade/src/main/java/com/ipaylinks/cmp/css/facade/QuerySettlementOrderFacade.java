package com.ipaylinks.cmp.css.facade;

import com.ipaylinks.cmp.css.facade.dto.MertSettlementOrderDto;
import com.ipaylinks.cmp.css.facade.request.QuerySettlementRequest;
import com.ipaylinks.common.rpc.response.PageQueryResponse;

public interface QuerySettlementOrderFacade {

	/**
	 * 查询商户结算单信息
	 *
	 * @author hongxu.gao
	 * @date 2018/8/28 17:24
	 * @param request 请求参数对象
	 * @return com.ipaylinks.common.rpc.response.PageQueryResponse<com.ipaylinks.cmp.css.facade.dto.MertSettlementOrderDto>
	 */
	PageQueryResponse<MertSettlementOrderDto> querySettlementOrder(QuerySettlementRequest request);
}
