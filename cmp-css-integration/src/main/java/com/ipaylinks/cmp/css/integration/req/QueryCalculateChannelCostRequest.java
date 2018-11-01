package com.ipaylinks.cmp.css.integration.req;

import java.math.BigDecimal;
import java.util.Date;

import com.ipaylinks.common.rpc.BaseRequest;

public class QueryCalculateChannelCostRequest extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7328735883338810228L;

	/**
	 * 成本规则ID	字符	M	
	 */
	private String feeId;
	/**
	 * 交易完成日期	字符	M	
	 */
	private Date tradeTime;
	/**
	 * 单笔金额	数值	O	
	 */
	private BigDecimal singleAmount;
	/**
	 * 总金额	数值	O	
	 */
	private BigDecimal totleAmount;
	/**
	 * 总笔数	数值	O	
	 */
	private String totleCount;
	/**
	 * 拒付率	数值	O	
	 */
	private String protestRate;
	/**
	 * 拒付总笔数	数值	O	
	 */
	private String protestCount;
	/**
	 * 交易总笔数	数值	O	
	 */
	private String tradeCount;
	/**
	 * 原单笔金额	数值	O	
	 */
	private BigDecimal originalTransAmount;
	/**
	 * 原比例费	数值	O	
	 */
	private BigDecimal originalPercentFee;
	/**
	 * 原固定费	数值	O	
	 */
	private BigDecimal originalFixedFee;
	/**
	 * 已退比例费	数值	O	
	 */
	private BigDecimal returnedPercentFee;
	/**
	 * 已退固定费	数值	O	
	 */
	private BigDecimal returnedFixedFee;
	/**
	 * 已退金额	数值	O	
	 */
	private BigDecimal returnedAmount;
	
	public String getFeeId() {
		return feeId;
	}
	public void setFeeId(String feeId) {
		this.feeId = feeId;
	}
	public Date getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	public String getTotleCount() {
		return totleCount;
	}
	public void setTotleCount(String totleCount) {
		this.totleCount = totleCount;
	}
	public String getProtestRate() {
		return protestRate;
	}
	public void setProtestRate(String protestRate) {
		this.protestRate = protestRate;
	}
	public String getProtestCount() {
		return protestCount;
	}
	public void setProtestCount(String protestCount) {
		this.protestCount = protestCount;
	}
	public String getTradeCount() {
		return tradeCount;
	}
	public void setTradeCount(String tradeCount) {
		this.tradeCount = tradeCount;
	}
	public BigDecimal getSingleAmount() {
		return singleAmount;
	}
	public void setSingleAmount(BigDecimal singleAmount) {
		this.singleAmount = singleAmount;
	}
	public BigDecimal getTotleAmount() {
		return totleAmount;
	}
	public void setTotleAmount(BigDecimal totleAmount) {
		this.totleAmount = totleAmount;
	}
	public BigDecimal getOriginalTransAmount() {
		return originalTransAmount;
	}
	public void setOriginalTransAmount(BigDecimal originalTransAmount) {
		this.originalTransAmount = originalTransAmount;
	}
	public BigDecimal getOriginalPercentFee() {
		return originalPercentFee;
	}
	public void setOriginalPercentFee(BigDecimal originalPercentFee) {
		this.originalPercentFee = originalPercentFee;
	}
	public BigDecimal getOriginalFixedFee() {
		return originalFixedFee;
	}
	public void setOriginalFixedFee(BigDecimal originalFixedFee) {
		this.originalFixedFee = originalFixedFee;
	}
	public BigDecimal getReturnedPercentFee() {
		return returnedPercentFee;
	}
	public void setReturnedPercentFee(BigDecimal returnedPercentFee) {
		this.returnedPercentFee = returnedPercentFee;
	}
	public BigDecimal getReturnedFixedFee() {
		return returnedFixedFee;
	}
	public void setReturnedFixedFee(BigDecimal returnedFixedFee) {
		this.returnedFixedFee = returnedFixedFee;
	}
	public BigDecimal getReturnedAmount() {
		return returnedAmount;
	}
	public void setReturnedAmount(BigDecimal returnedAmount) {
		this.returnedAmount = returnedAmount;
	}
	
}
