package com.ipaylinks.cmp.css.facade;

import com.ipaylinks.cmp.css.facade.request.QueryLiquidationDetailRequest;
import com.ipaylinks.cmp.css.facade.response.QueryLiquidationDetailResponse;

public interface QueryLiquidationDetailFacade {

	/**
     * @des    查询商户清算流水信息
     * @return 返回商户清算流水信息
     * @author yuyao
     * @data <a>2018-07-09<a>3388951503
     * */
	QueryLiquidationDetailResponse QueryLiquidationDetail(QueryLiquidationDetailRequest request);
}
