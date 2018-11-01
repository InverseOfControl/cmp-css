package com.ipaylinks.cmp.css.facade;

import com.ipaylinks.cmp.css.facade.request.QueryTradeAccountReportRequest;
import com.ipaylinks.cmp.css.facade.response.QueryTradeAccountReportResponse;

public interface QueryTradeAccountReportFacade {

	/**
     * @des    查询商户结算单流水信息
     * @return 返回商户结算单流水信息
     * @author yuyao
     * @data <a>2018-07-09<a>3388951503
     * */
	QueryTradeAccountReportResponse queryTradeAccountReport(QueryTradeAccountReportRequest request);
	
}
