package com.ipaylinks.cmp.css.integration.req;

import com.ipaylinks.common.rpc.BaseRequest;

public class QueryMermberAccountRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -744032342916754104L;
	
	/**
	 * 产品编码
	 */
	private String productNo;
	/**
	 * 产品描述
	 */
	private String productDesc;
	/**
	 * 业务场景码
	 */
	private String dealCode;
	/**
	 *业务场景码描述
	 */
	private String dealDesc;
	/**
	 * 交易类型1：交易、2：支付
	 */
	private String tradeType; 
	/**
	 * 交易说明
	 */
	private String tradeDescription;
	/**
	 * 金额类型
	 */
	private String financeType;
	
	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getDealCode() {
		return dealCode;
	}

	public void setDealCode(String dealCode) {
		this.dealCode = dealCode;
	}

	public String getDealDesc() {
		return dealDesc;
	}

	public void setDealDesc(String dealDesc) {
		this.dealDesc = dealDesc;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getTradeDescription() {
		return tradeDescription;
	}

	public void setTradeDescription(String tradeDescription) {
		this.tradeDescription = tradeDescription;
	}

	public String getFinanceType() {
		return financeType;
	}

	public void setFinanceType(String financeType) {
		this.financeType = financeType;
	}

	
}
