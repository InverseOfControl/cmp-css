package com.ipaylinks.cmp.css.biz.impl.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ipaylinks.cmp.css.facade.QuerySettlementInfoFacade;
import com.ipaylinks.cmp.css.facade.request.CreateSettlementInfoRequest;
import com.ipaylinks.cmp.css.facade.request.QuerySettlementInfoRequest;
import com.ipaylinks.cmp.css.facade.response.CreateSettlementInfoResponse;
import com.ipaylinks.cmp.css.facade.response.QuerySettlementInfoResponse;

@Service("querySettlementInfoFacade")
public class QuerySettlementInfoFacadeImpl implements QuerySettlementInfoFacade{

	private Logger logger = LoggerFactory.getLogger(LiquidationOrderFacadeImpl.class);

	/**
     * @des    查询商户结算配置信息
     * @param  商户信息
     * @return 返回商户结算配置信息时间
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	@Override
	public QuerySettlementInfoResponse querySettlementInfo(QuerySettlementInfoRequest request) {
		logger.info("QuerySettlementInfoFacadeImpl query settle info begin request={}", request);
		QuerySettlementInfoResponse response =new QuerySettlementInfoResponse();
		logger.info("QuerySettlementInfoFacadeImpl query settle info end response={}", response);
		return response;
	}
	/**
     * @des    商户结算信息配置
     * @param  商户信息
     * @return 返回商户结算配置信息时间
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	@Override
	public CreateSettlementInfoResponse createSettlementInfo(CreateSettlementInfoRequest request) {
		logger.info("QuerySettlementInfoFacadeImpl set settle info begin request={}", request);
		CreateSettlementInfoResponse response =new CreateSettlementInfoResponse();
		logger.info("QuerySettlementInfoFacadeImpl set settle info end response={}", response);
		return response;
	}
	/**
     * @des    更新商户结算信息配置
     * @param  商户信息
     * @return 返回操作状态
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	@Override
	public CreateSettlementInfoResponse updateSettlementInfo(
			CreateSettlementInfoRequest request) {
		logger.info("QuerySettlementInfoFacadeImpl update member settle info begin request={}", request);
		CreateSettlementInfoResponse response =new CreateSettlementInfoResponse();
		logger.info("QuerySettlementInfoFacadeImpl update member settle info end response={}", response);
		return response;
	}
	/**
     * @des    删除商户结算信息配置
     * @param  商户信息
     * @return 返回操作状态
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	@Override
	public CreateSettlementInfoResponse delSettlementInfo(
			QuerySettlementInfoRequest request) {
		logger.info("QuerySettlementInfoFacadeImpl del member settle info begin request={}", request);
		CreateSettlementInfoResponse response =new CreateSettlementInfoResponse();
		logger.info("QuerySettlementInfoFacadeImpl del member settle info end response={}", response);
		return response;
	}

}
