package com.ipaylinks.cmp.css.integration.res;

import java.math.BigDecimal;

import com.ipaylinks.common.rpc.BaseResponse;

public class QueryCalculateChannelCostResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3300944044112925779L;

	/**
	 * 计费规则ID	
	 */
	private String feeId;
	/**
	 * 收费/付费	包含：收费、付费
	 */
	private String chargeType;
	/**
	 * 收费方式	
	 */
	private String chargeMode;
	/**
	 * 费用结算日期	
	 */
	private String settleDate;
	/**
	 * 比例费币种	
	 */
	private String percentFeeCurrency;
	/**
	 * 比例费金额	
	 */
	 private BigDecimal percentFeeAmount;
	/**
	 * 固定费币种	
	 */
	private String fixedFeeCurrency;
	/**
	 * 固定费金额	
	 */
	 private BigDecimal fixedFeeAmount;
	/**
	 * 处理费币种	
	 */
	 private String feeCurrency;
	/**
	 * 处理费金额	
	 */
	 private BigDecimal feeAmount;
	 
	public String getFeeId() {
		return feeId;
	}
	public void setFeeId(String feeId) {
		this.feeId = feeId;
	}
	public String getChargeType() {
		return chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	public String getChargeMode() {
		return chargeMode;
	}
	public void setChargeMode(String chargeMode) {
		this.chargeMode = chargeMode;
	}
	public String getSettleDate() {
		return settleDate;
	}
	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}
	public String getPercentFeeCurrency() {
		return percentFeeCurrency;
	}
	public void setPercentFeeCurrency(String percentFeeCurrency) {
		this.percentFeeCurrency = percentFeeCurrency;
	}
	public String getFixedFeeCurrency() {
		return fixedFeeCurrency;
	}
	public void setFixedFeeCurrency(String fixedFeeCurrency) {
		this.fixedFeeCurrency = fixedFeeCurrency;
	}
 
	public String getFeeCurrency() {
		return feeCurrency;
	}
	public void setFeeCurrency(String feeCurrency) {
		this.feeCurrency = feeCurrency;
	}
	public BigDecimal getPercentFeeAmount() {
		return percentFeeAmount;
	}
	public void setPercentFeeAmount(BigDecimal percentFeeAmount) {
		this.percentFeeAmount = percentFeeAmount;
	}
	public BigDecimal getFixedFeeAmount() {
		return fixedFeeAmount;
	}
	public void setFixedFeeAmount(BigDecimal fixedFeeAmount) {
		this.fixedFeeAmount = fixedFeeAmount;
	}
	public BigDecimal getFeeAmount() {
		return feeAmount;
	}
	public void setFeeAmount(BigDecimal feeAmount) {
		this.feeAmount = feeAmount;
	}
}
