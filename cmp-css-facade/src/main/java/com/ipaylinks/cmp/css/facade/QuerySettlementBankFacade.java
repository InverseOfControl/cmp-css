package com.ipaylinks.cmp.css.facade;

import com.ipaylinks.cmp.css.facade.request.CreateSettlementBankRequest;
import com.ipaylinks.cmp.css.facade.request.QuerySettlementBankRequest;
import com.ipaylinks.cmp.css.facade.response.CreateSettlementBankResponse;
import com.ipaylinks.cmp.css.facade.response.QuerySettlementBankResponse;

public interface QuerySettlementBankFacade {

	/**
     * @des    查询商户结算银行配置信息
     * @param  商户信息
     * @return 返回商户结算银行配置信息
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	QuerySettlementBankResponse querySettlementBank(QuerySettlementBankRequest request);
	
	/**
     * @des    设置商户结算银行配置信息
     * @param  商户信息
     * @return 返回操作状态
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	CreateSettlementBankResponse createSettlementBank(CreateSettlementBankRequest request);
	
	/**
     * @des    更新商户结算银行配置信息
     * @param  商户信息
     * @return 返回操作状态
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	CreateSettlementBankResponse updateSettlementBank(CreateSettlementBankRequest request);

	
	/**
     * @des    删除商户结算银行配置信息
     * @param  商户信息
     * @return 返回操作状态
     * @author yuyao
     * @data <a>2018-07-09<a>
     * */
	CreateSettlementBankResponse delSettlementBank(QuerySettlementBankRequest request);


}
