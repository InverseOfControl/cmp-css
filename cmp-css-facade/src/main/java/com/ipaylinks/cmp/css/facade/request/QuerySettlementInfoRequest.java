package com.ipaylinks.cmp.css.facade.request;

import com.ipaylinks.common.rpc.BaseRequest;

public class QuerySettlementInfoRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5511706160598373783L;

	/**
	 * 商户ID
	 * */
	private  String  merchantId;
	/**
	 * 商户名称
	 * */
	private  String  merchantName;
	
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}	 
}
