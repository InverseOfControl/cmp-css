package com.ipaylinks.cmp.css.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MertSettlementOrderDto implements Serializable {

	private static final long serialVersionUID = -7441264444895353161L;

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 商户ID
	 */
	private String merchantId;

	/**
	 * 商户名称
	 */
	private String merchantName;

	/**
	 * 结算类型
	 */
	private String settleType;

	/**
	 * 结算币种
	 */
	private String settleCurrency;

	/**
	 * 结算金额
	 */
	private BigDecimal settleAmount;

	/**
	 * 费用结算方式
	 */
	private String feeSettleMethod;

	/**
	 * 结算单日期 yyyyMMdd
	 */
	private String settlementDate;

	/**
	 * 订单开始日期yyyyMMdd
	 */
	private String orderBeginDate;

	/**
	 * 订单结束日期yyyyMMdd
	 */
	private String orderEndDate;

	/**
	 * 结算汇总单编号
	 */
	private String settlementSummaryId;

	/**
	 * 汇总状态
	 */
	private String summaryStatus;

	/**
	 * 记账状态
	 */
	private String accountingStatus;

	/**
	 * 记账流水号
	 */
	private String accountingId;

	/**
	 * 记账时间
	 */
	private Date accountingTime;

	/**
	 * 创建时间
	 */
	private Date gmtCreateTime;

	/**
	 * 更新时间
	 */
	private Date gmtUpdateTime;

	/**
	 * 交易类型
	 */
	private String transType;

	/**
	 * 金额类型
	 */
	private String amountType;

	/**
	 * 交易币种
	 */
	private String transCurrency;

	/**
	 * 交易金额
	 */
	private BigDecimal transAmount;

	/**
	 * 结算单编号
	 */
	private String  settlementOrderId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getSettleType() {
		return settleType;
	}

	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}

	public String getSettleCurrency() {
		return settleCurrency;
	}

	public void setSettleCurrency(String settleCurrency) {
		this.settleCurrency = settleCurrency;
	}

	public BigDecimal getSettleAmount() {
		return settleAmount;
	}

	public void setSettleAmount(BigDecimal settleAmount) {
		this.settleAmount = settleAmount;
	}

	public String getFeeSettleMethod() {
		return feeSettleMethod;
	}

	public void setFeeSettleMethod(String feeSettleMethod) {
		this.feeSettleMethod = feeSettleMethod;
	}

	public String getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}

	public String getOrderBeginDate() {
		return orderBeginDate;
	}

	public void setOrderBeginDate(String orderBeginDate) {
		this.orderBeginDate = orderBeginDate;
	}

	public String getOrderEndDate() {
		return orderEndDate;
	}

	public void setOrderEndDate(String orderEndDate) {
		this.orderEndDate = orderEndDate;
	}

	public String getSettlementSummaryId() {
		return settlementSummaryId;
	}

	public void setSettlementSummaryId(String settlementSummaryId) {
		this.settlementSummaryId = settlementSummaryId;
	}

	public String getSummaryStatus() {
		return summaryStatus;
	}

	public void setSummaryStatus(String summaryStatus) {
		this.summaryStatus = summaryStatus;
	}

	public String getAccountingStatus() {
		return accountingStatus;
	}

	public void setAccountingStatus(String accountingStatus) {
		this.accountingStatus = accountingStatus;
	}

	public String getAccountingId() {
		return accountingId;
	}

	public void setAccountingId(String accountingId) {
		this.accountingId = accountingId;
	}

	public Date getAccountingTime() {
		return accountingTime;
	}

	public void setAccountingTime(Date accountingTime) {
		this.accountingTime = accountingTime;
	}

	public Date getGmtCreateTime() {
		return gmtCreateTime;
	}

	public void setGmtCreateTime(Date gmtCreateTime) {
		this.gmtCreateTime = gmtCreateTime;
	}

	public Date getGmtUpdateTime() {
		return gmtUpdateTime;
	}

	public void setGmtUpdateTime(Date gmtUpdateTime) {
		this.gmtUpdateTime = gmtUpdateTime;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getAmountType() {
		return amountType;
	}

	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}

	public String getTransCurrency() {
		return transCurrency;
	}

	public void setTransCurrency(String transCurrency) {
		this.transCurrency = transCurrency;
	}

	public BigDecimal getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(BigDecimal transAmount) {
		this.transAmount = transAmount;
	}

	public String getSettlementOrderId() {
		return settlementOrderId;
	}

	public void setSettlementOrderId(String settlementOrderId) {
		this.settlementOrderId = settlementOrderId;
	}
}
