package com.ipaylinks.cmp.css.facade;

import com.ipaylinks.cmp.css.facade.request.QueryCssOrderRequest;
import com.ipaylinks.cmp.css.facade.response.QueryCssOrderResponse;

public interface QueryCssOrderFacade {

	/**
     * @des    查询商户清算订单信息
     * @param  商户信息
     * @return 返回商户清算订单信息
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	QueryCssOrderResponse queryCssOrderInfo(QueryCssOrderRequest request);


}
