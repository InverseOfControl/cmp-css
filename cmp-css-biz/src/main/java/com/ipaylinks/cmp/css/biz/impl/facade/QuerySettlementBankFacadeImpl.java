package com.ipaylinks.cmp.css.biz.impl.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ipaylinks.cmp.css.facade.QuerySettlementBankFacade;
import com.ipaylinks.cmp.css.facade.request.CreateSettlementBankRequest;
import com.ipaylinks.cmp.css.facade.request.QuerySettlementBankRequest;
import com.ipaylinks.cmp.css.facade.response.CreateSettlementBankResponse;
import com.ipaylinks.cmp.css.facade.response.QuerySettlementBankResponse;

public class QuerySettlementBankFacadeImpl implements QuerySettlementBankFacade {

	private Logger logger = LoggerFactory.getLogger(QuerySettlementBankFacadeImpl.class);

	/**
     * @des    查询商户结算银行配置信息
     * @param  商户信息
     * @return 返回商户结算银行配置信息
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	@Override
	public QuerySettlementBankResponse querySettlementBank(QuerySettlementBankRequest request) {
		logger.info("QuerySettlementBankFacadeImpl query settle bank info begin request={}", request);
		QuerySettlementBankResponse response =new QuerySettlementBankResponse();
		logger.info("QuerySettlementBankFacadeImpl query settle bank info end response={}", response);
		return response;
	}

	/**
     * @des    配置商户结算银行配置信息
     * @param  商户信息
     * @return 返回商户结算银行配置信息
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	@Override
	public CreateSettlementBankResponse createSettlementBank(CreateSettlementBankRequest request) {
		logger.info("QuerySettlementBankFacadeImpl create settle bank info begin request={}", request);
		CreateSettlementBankResponse response =new CreateSettlementBankResponse();
		logger.info("QuerySettlementBankFacadeImpl create settle bank info end response={}", response);
		return response;
	}

	/**
     * @des    更新商户结算银行配置信息
     * @param  商户信息
     * @return 返回商户结算银行配置信息
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	@Override
	public CreateSettlementBankResponse updateSettlementBank(CreateSettlementBankRequest request) {
		logger.info("QuerySettlementBankFacadeImpl update settle bank info begin request={}", request);
		CreateSettlementBankResponse response =new CreateSettlementBankResponse();
		logger.info("QuerySettlementBankFacadeImpl update settle bank  info end response={}", response);
		return response;
	}
	
	/**
     * @des    删除商户结算银行配置信息
     * @param  商户信息
     * @return 返回商户结算银行配置信息
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	@Override
	public CreateSettlementBankResponse delSettlementBank(QuerySettlementBankRequest request) {
		logger.info("QuerySettlementBankFacadeImpl del settle bank info begin request={}", request);
		CreateSettlementBankResponse response =new CreateSettlementBankResponse();
		logger.info("QuerySettlementBankFacadeImpl del settle bank info end response={}", response);
		return response;
	}

}
