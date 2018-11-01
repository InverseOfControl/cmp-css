package com.ipaylinks.cmp.css.facade;

import com.ipaylinks.cmp.css.facade.dto.MertSettlementDetailDto;
import com.ipaylinks.cmp.css.facade.request.QuerySettlementDetailRequest;
import com.ipaylinks.common.rpc.response.PageQueryResponse;

public interface QuerySettlementDetailFacade {

	/**
     * @des    查询商户结算流水信息
     * @return 返回商户结算流水信息
     * @author yuyao
     * @data <a>2018-07-09<a>3388951503
     * */
	PageQueryResponse<MertSettlementDetailDto> querySettlementDetail(QuerySettlementDetailRequest request);
}
