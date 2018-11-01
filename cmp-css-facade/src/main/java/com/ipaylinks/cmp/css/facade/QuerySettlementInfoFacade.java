package com.ipaylinks.cmp.css.facade;

import com.ipaylinks.cmp.css.facade.request.CreateSettlementInfoRequest;
import com.ipaylinks.cmp.css.facade.request.QuerySettlementInfoRequest;
import com.ipaylinks.cmp.css.facade.response.CreateSettlementInfoResponse;
import com.ipaylinks.cmp.css.facade.response.QuerySettlementInfoResponse;

public interface QuerySettlementInfoFacade {

	/**
     * @des    查询商户结算配置信息
     * @param  商户信息
     * @return 返回商户结算配置信息
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	QuerySettlementInfoResponse querySettlementInfo(QuerySettlementInfoRequest request);
	
	/**
     * @des    商户结算信息配置
     * @param  商户信息
     * @return 返回删除状态
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	CreateSettlementInfoResponse createSettlementInfo(CreateSettlementInfoRequest request);
	
	/**
     * @des    商户结算信息配置更新
     * @param  商户信息
     * @return 返回删除状态
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	CreateSettlementInfoResponse updateSettlementInfo(CreateSettlementInfoRequest request);
	
	/**
     * @des    商户结算信息配置删除
     * @param  商户信息
     * @return 返回删除状态
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	CreateSettlementInfoResponse delSettlementInfo(QuerySettlementInfoRequest request);


}
