package com.ipaylinks.cmp.css.integration.req;

import com.ipaylinks.common.rpc.BaseRequest;

public class QueryMertSettlementCashDepositRequest extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1502572568558410848L;
	
	/**
	 * 商户号
	 */
	private  String merchantId;
	/**
	 * 币种
	 */
	private String transCurrency;
	/**
	 * 币种
	 */
	private String settleDate;
	
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getTransCurrency() {
		return transCurrency;
	}
	public void setTransCurrency(String transCurrency) {
		this.transCurrency = transCurrency;
	}
	public String getSettleDate() {
		return settleDate;
	}
	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}

	
}
