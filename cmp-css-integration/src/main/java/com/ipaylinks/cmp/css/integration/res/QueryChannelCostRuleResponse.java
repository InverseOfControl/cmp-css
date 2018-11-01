package com.ipaylinks.cmp.css.integration.res;

import java.math.BigDecimal;

import com.ipaylinks.common.rpc.BaseResponse;

public class QueryChannelCostRuleResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6637619601275916117L;
	/**
	 * 成本规则ID	如果响应码为成功，则需要返回
	 */
	private String feeId;
	/**
	 * 单笔/批量	对于业务系统的单笔计费，如果计费返回是批量，则各费用项均为零
	 */
	
	/**
	 * 规则类型	包括价格，阶梯价格，阶梯累进价格
	 */
	
	/**
	 * 单笔金额	Y-必输、N-非必输
	 */
	private BigDecimal singleAmount;
	/**
	 * 总金额	Y-必输、N-非必输
	 */
	private String totalAmount;
	/**
	 * 总笔数	Y-必输、N-非必输
	 */
	private String totleCount;
	/**
	 * 拒付率	Y-必输、N-非必输
	 */
	private String protestRate;
	/**
	 * 拒付总笔数	Y-必输、N-非必输
	 */
	private String protestCount;
	/**
	 * 交易总笔数	Y-必输、N-非必输
	 */
	private String originalTransCount;
	/**
	 * 原单笔金额	Y-必输、N-非必输
	 */
	private BigDecimal originalTransAmount;
	/**
	 * 原比例费	Y-必输、N-非必输
	 */
	private BigDecimal originalPercentFeeAmount;
	/**
	 * 原固定费	Y-必输、N-非必输
	 */
	private BigDecimal originalFixedFeeAmount;
	/**
	 * 已退比例费	Y-必输、N-非必输
	 */
	private BigDecimal returnedPercentFeeAmount;
	/**
	 * 已退固定费	Y-必输、N-非必输
	 */
	private BigDecimal returnedFixedFeeAmount;
	public String getFeeId() {
		return feeId;
	}
	public void setFeeId(String feeId) {
		this.feeId = feeId;
	}
	public BigDecimal getSingleAmount() {
		return singleAmount;
	}
	public void setSingleAmount(BigDecimal singleAmount) {
		this.singleAmount = singleAmount;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
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
	public String getOriginalTransCount() {
		return originalTransCount;
	}
	public void setOriginalTransCount(String originalTransCount) {
		this.originalTransCount = originalTransCount;
	}
	public BigDecimal getOriginalTransAmount() {
		return originalTransAmount;
	}
	public void setOriginalTransAmount(BigDecimal originalTransAmount) {
		this.originalTransAmount = originalTransAmount;
	}
	public BigDecimal getOriginalPercentFeeAmount() {
		return originalPercentFeeAmount;
	}
	public void setOriginalPercentFeeAmount(BigDecimal originalPercentFeeAmount) {
		this.originalPercentFeeAmount = originalPercentFeeAmount;
	}
	public BigDecimal getOriginalFixedFeeAmount() {
		return originalFixedFeeAmount;
	}
	public void setOriginalFixedFeeAmount(BigDecimal originalFixedFeeAmount) {
		this.originalFixedFeeAmount = originalFixedFeeAmount;
	}
	public BigDecimal getReturnedPercentFeeAmount() {
		return returnedPercentFeeAmount;
	}
	public void setReturnedPercentFeeAmount(BigDecimal returnedPercentFeeAmount) {
		this.returnedPercentFeeAmount = returnedPercentFeeAmount;
	}
	public BigDecimal getReturnedFixedFeeAmount() {
		return returnedFixedFeeAmount;
	}
	public void setReturnedFixedFeeAmount(BigDecimal returnedFixedFeeAmount) {
		this.returnedFixedFeeAmount = returnedFixedFeeAmount;
	}
	
	
}
