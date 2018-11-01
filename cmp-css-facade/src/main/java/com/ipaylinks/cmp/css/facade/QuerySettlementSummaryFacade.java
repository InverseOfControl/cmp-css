package com.ipaylinks.cmp.css.facade;

import com.ipaylinks.cmp.css.facade.dto.MertSettlementSummaryDto;
import com.ipaylinks.cmp.css.facade.request.QuerySettlementSummaryRequest;
import com.ipaylinks.common.rpc.response.PageQueryResponse;

public interface QuerySettlementSummaryFacade {

	/**
     * @des    查询商户结算单流水信息
     * @return 返回商户结算单流水信息
     * @author yuyao
     * @data <a>2018-07-09<a>3388951503
     * */
	PageQueryResponse<MertSettlementSummaryDto> querySettlementSummary(QuerySettlementSummaryRequest request);

}
