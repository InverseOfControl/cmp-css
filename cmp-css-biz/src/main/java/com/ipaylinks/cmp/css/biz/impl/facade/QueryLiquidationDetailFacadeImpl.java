package com.ipaylinks.cmp.css.biz.impl.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ipaylinks.cmp.css.facade.QueryLiquidationDetailFacade;
import com.ipaylinks.cmp.css.facade.request.QueryLiquidationDetailRequest;
import com.ipaylinks.cmp.css.facade.response.QueryLiquidationDetailResponse;

public class QueryLiquidationDetailFacadeImpl implements
		QueryLiquidationDetailFacade {

	private Logger logger = LoggerFactory.getLogger(QueryLiquidationDetailFacadeImpl.class);

	/**
     * @des    查询商户结算信息
     * @param  商户信息
     * @return 返回商户结算汇总单
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	@Override
	public QueryLiquidationDetailResponse QueryLiquidationDetail(
			QueryLiquidationDetailRequest request) {
		logger.info("QueryLiquidationDetailFacadeImpl query Liquidation Detail  begin request={}", request);
		QueryLiquidationDetailResponse response =new QueryLiquidationDetailResponse();
		logger.info("QueryLiquidationDetailFacadeImpl query Liquidation Detail  end response={}", response);
		return response;
	}

}
