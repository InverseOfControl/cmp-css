package com.ipaylinks.cmp.css.facade.request;

import com.ipaylinks.common.rpc.BaseRequest;

public class QuerySettlementBankRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4195905076177560034L;


	/**
	 * 商户ID
	 * */
	private  String  merchantId;

	/**
	 * 商户名称
	 * */
	private  String  merchantName;
	/**
	 * 结算币种
	 * */
	private  String  settleCurrency;

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getSettleCurrency() {
		return settleCurrency;
	}

	public void setSettleCurrency(String settleCurrency) {
		this.settleCurrency = settleCurrency;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	

}
