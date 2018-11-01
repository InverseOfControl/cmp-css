package com.ipaylinks.cmp.css.integration.req;

import com.ipaylinks.common.rpc.BaseRequest;

public class QueryMertSettlementDateRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5873216610869026603L;
	/**
	 * 系统/模块ID
	 */
	private String sysId;
	/**
	 * 请求流水号
	 */
	 private String reqId;
	/**
	 * 商户号
	 */
	private  String merchantId;
	/**
	 * 支付方式
	 */
	private  String payMethod;
	
	/**
	 * 国家
	 */
	private  String cardCountry;

	/**
	 * 渠道号
	 */
	private  String payOrgCode;

	public String getSysId() {
		return sysId;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getCardCountry() {
		return cardCountry;
	}

	public void setCardCountry(String cardCountry) {
		this.cardCountry = cardCountry;
	}

	public String getPayOrgCode() {
		return payOrgCode;
	}

	public void setPayOrgCode(String payOrgCode) {
		this.payOrgCode = payOrgCode;
	}
	
}
