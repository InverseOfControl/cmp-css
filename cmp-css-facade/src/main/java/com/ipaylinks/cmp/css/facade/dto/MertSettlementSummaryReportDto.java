package com.ipaylinks.cmp.css.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MertSettlementSummaryReportDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5219199420254349138L;

	private String id;
	/**清算主订单*/
	private String liquidationOrderId;
	/**商户订单号*/
	private String merchantOrderId;
	/**收单订单号*/
	private String orderId;
	/**清分明细ID*/
	private String clearingDetailId;
	/**商户ID*/
	private String merchantId;
	/**商户名称*/
	private String merchantName;
	/**交易类型*/
	private String transType;
	/**金额类型*/
	private String amountType;
	/**交易币种*/
	private String transCurrency;
	/**交易金额*/
	private BigDecimal transAmount;
	/**结算类型*/
	private String settleType;
	/**结算币种*/
	private String settleCurrency;
	/**结算金额*/
	private BigDecimal settleAmount;
	/**结算汇率*/
	private BigDecimal settleRate;
	/**结算日期 yyyyMMdd*/
	private String settleDate;
	/**结算单号*/
	private String settlementId;
	/**结算批次号*/
	private String settleBatchId;
	/**费用结算方式*/
	private String feeSettleMethod;
	/**结算状态*/
	private String settleStatus;
	/**结算时间*/
	private Date settleTime;
	/**创建时间*/
	private Date gmtCreateTime;
	/**更新时间*/
	private Date gmtUpdateTime;
	/**支付方式 01-信用卡支付、02-本地化支付*/
	private String payMethod;
	/**记账状态*/
	private String accountingStatus;
	/**记账流水号*/
	private String accountingId;
	/**记账时间*/
	private Date accountingTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLiquidationOrderId() {
		return liquidationOrderId;
	}
	public void setLiquidationOrderId(String liquidationOrderId) {
		this.liquidationOrderId = liquidationOrderId;
	}
	public String getMerchantOrderId() {
		return merchantOrderId;
	}
	public void setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getClearingDetailId() {
		return clearingDetailId;
	}
	public void setClearingDetailId(String clearingDetailId) {
		this.clearingDetailId = clearingDetailId;
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
	public BigDecimal getSettleRate() {
		return settleRate;
	}
	public void setSettleRate(BigDecimal settleRate) {
		this.settleRate = settleRate;
	}
	public String getSettleDate() {
		return settleDate;
	}
	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}
	public String getSettlementId() {
		return settlementId;
	}
	public void setSettlementId(String settlementId) {
		this.settlementId = settlementId;
	}
	public String getSettleBatchId() {
		return settleBatchId;
	}
	public void setSettleBatchId(String settleBatchId) {
		this.settleBatchId = settleBatchId;
	}
	public String getFeeSettleMethod() {
		return feeSettleMethod;
	}
	public void setFeeSettleMethod(String feeSettleMethod) {
		this.feeSettleMethod = feeSettleMethod;
	}
	public String getSettleStatus() {
		return settleStatus;
	}
	public void setSettleStatus(String settleStatus) {
		this.settleStatus = settleStatus;
	}
	public Date getSettleTime() {
		return settleTime;
	}
	public void setSettleTime(Date settleTime) {
		this.settleTime = settleTime;
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
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
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

}
