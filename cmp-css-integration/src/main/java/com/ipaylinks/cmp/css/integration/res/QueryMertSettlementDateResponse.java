package com.ipaylinks.cmp.css.integration.res;

import com.ipaylinks.common.rpc.BaseResponse;

public class QueryMertSettlementDateResponse extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = -460116282558879121L;
	
	/**
	 * 请求流水号
	 */
	 private String reqId;
	/**
	 * 商户号
	 */
	 private  String merchantId;
	/**
	 * 本金结算日期
	 */
	private String settleDate;
	
	
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
	public String getSettleDate() {
		return settleDate;
	}
	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}
	
}
