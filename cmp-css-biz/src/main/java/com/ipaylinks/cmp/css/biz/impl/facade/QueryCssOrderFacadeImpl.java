package com.ipaylinks.cmp.css.biz.impl.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ipaylinks.cmp.css.facade.QueryCssOrderFacade;
import com.ipaylinks.cmp.css.facade.request.QueryCssOrderRequest;
import com.ipaylinks.cmp.css.facade.response.QueryCssOrderResponse;

public class QueryCssOrderFacadeImpl implements QueryCssOrderFacade {

	private Logger logger = LoggerFactory.getLogger(ChannelOrderFacadeImpl.class);

	/**
     * @des    查询商户清算订单信息
     * @param  商户信息
     * @return 返回商户清算订单信息
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	@Override
	public QueryCssOrderResponse queryCssOrderInfo(QueryCssOrderRequest request) {
		
		logger.info("QueryCssOrderFacadeImpl query css order  info begin request={}", request);
		QueryCssOrderResponse response =new QueryCssOrderResponse();
		logger.info("QueryCssOrderFacadeImpl quer  css order  info end response={}", response);
		return response;
	}

}
