package com.ipaylinks.cmp.css.dal.model;

import java.math.BigDecimal;
import java.util.Date;

public class MertSettlementDetail {
    /**
     * 主键
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : ID
     */
    private String id;

    /**
     * 商户订单号
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : MERCHANT_ORDER_ID
     */
    private String merchantOrderId;

    /**
     * 收单订单号
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : ORDER_ID
     */
    private String orderId;

    /**
     * 清分明细ID
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : CLEARING_DETAIL_ID
     */
    private String clearingDetailId;

    /**
     * 商户ID
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : MERCHANT_ID
     */
    private String merchantId;

    /**
     * 商户名称
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : MERCHANT_NAME
     */
    private String merchantName;

    /**
     * 交易类型
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : TRANS_TYPE
     */
    private String transType;

    /**
     * 金额类型
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : AMOUNT_TYPE
     */
    private String amountType;

    /**
     * 交易币种
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : TRANS_CURRENCY
     */
    private String transCurrency;

    /**
     * 交易金额
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : TRANS_AMOUNT
     */
    private BigDecimal transAmount;

    /**
     * 结算类型
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : SETTLE_TYPE
     */
    private String settleType;

    /**
     * 结算币种
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : SETTLE_CURRENCY
     */
    private String settleCurrency;

    /**
     * 结算金额
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : SETTLE_AMOUNT
     */
    private BigDecimal settleAmount;

    /**
     * 结算汇率
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : SETTLE_RATE
     */
    private BigDecimal settleRate;

    /**
     * 结算日期 yyyyMMdd
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : SETTLE_DATE
     */
    private String settleDate;

    /**
     * 结算单号
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : SETTLEMENT_ID
     */
    private String settlementId;

    /**
     * 结算批次号
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : SETTLE_BATCH_ID
     */
    private String settleBatchId;

    /**
     * 费用结算方式
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : FEE_SETTLE_METHOD
     */
    private String feeSettleMethod;

    /**
     * 结算状态
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : SETTLE_STATUS
     */
    private String settleStatus;

    /**
     * 结算时间
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : SETTLE_TIME
     */
    private Date settleTime;

    /**
     * 创建时间
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : GMT_CREATE_TIME
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : GMT_UPDATE_TIME
     */
    private Date gmtUpdateTime;

    /**
     * 支付方式 01-信用卡支付、02-本地化支付
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : PAY_METHOD
     */
    private String payMethod;

    /**
     * 记账状态
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : ACCOUNTING_STATUS
     */
    private String accountingStatus;

    /**
     * 记账流水号
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : ACCOUNTING_ID
     */
    private String accountingId;

    /**
     * 记账时间
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : ACCOUNTING_TIME
     */
    private Date accountingTime;
    
    /**
     * 保证金状态
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : DEPOSIT_STATUS
     */
    private String depositStatus;

    /**
     * 开始结算日期
     */
    private String beginSettleDate;
    /**
     * 结束结算日期
     */
    private String endSettleDate;
	/**
     * 订单类型：01-清算主订单 02-风控订单
     */
    private String orderType;

    /**
     * 订单ID：清算主订单ID、风控订单ID
     */
    private String oriId;
    
    private String settleCompleteTime;
    
    private String settleStartTime;
    
    private Date payCompleteTime;

    private String payKind;

    public String getPayKind() {
        return payKind;
    }

    public void setPayKind(String payKind) {
        this.payKind = payKind;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOriId() {
        return oriId;
    }

    public void setOriId(String oriId) {
        this.oriId = oriId;
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.ID：主键
     */
    public String getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.MERCHANT_ORDER_ID：商户订单号
     */
    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    /**
     * set method 
     *
     * @param merchantOrderId  商户订单号
     */
    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId == null ? null : merchantOrderId.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.ORDER_ID：收单订单号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * set method 
     *
     * @param orderId  收单订单号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.CLEARING_DETAIL_ID：清分明细ID
     */
    public String getClearingDetailId() {
        return clearingDetailId;
    }

    /**
     * set method 
     *
     * @param clearingDetailId  清分明细ID
     */
    public void setClearingDetailId(String clearingDetailId) {
        this.clearingDetailId = clearingDetailId == null ? null : clearingDetailId.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.MERCHANT_ID：商户ID
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * set method 
     *
     * @param merchantId  商户ID
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.MERCHANT_NAME：商户名称
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * set method 
     *
     * @param merchantName  商户名称
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.TRANS_TYPE：交易类型
     */
    public String getTransType() {
        return transType;
    }

    /**
     * set method 
     *
     * @param transType  交易类型
     */
    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.AMOUNT_TYPE：金额类型
     */
    public String getAmountType() {
        return amountType;
    }

    /**
     * set method 
     *
     * @param amountType  金额类型
     */
    public void setAmountType(String amountType) {
        this.amountType = amountType == null ? null : amountType.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.TRANS_CURRENCY：交易币种
     */
    public String getTransCurrency() {
        return transCurrency;
    }

    /**
     * set method 
     *
     * @param transCurrency  交易币种
     */
    public void setTransCurrency(String transCurrency) {
        this.transCurrency = transCurrency == null ? null : transCurrency.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.TRANS_AMOUNT：交易金额
     */
    public BigDecimal getTransAmount() {
        return transAmount;
    }

    /**
     * set method 
     *
     * @param transAmount  交易金额
     */
    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.SETTLE_TYPE：结算类型
     */
    public String getSettleType() {
        return settleType;
    }

    /**
     * set method 
     *
     * @param settleType  结算类型
     */
    public void setSettleType(String settleType) {
        this.settleType = settleType == null ? null : settleType.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.SETTLE_CURRENCY：结算币种
     */
    public String getSettleCurrency() {
        return settleCurrency;
    }

    /**
     * set method 
     *
     * @param settleCurrency  结算币种
     */
    public void setSettleCurrency(String settleCurrency) {
        this.settleCurrency = settleCurrency == null ? null : settleCurrency.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.SETTLE_AMOUNT：结算金额
     */
    public BigDecimal getSettleAmount() {
        return settleAmount;
    }

    /**
     * set method 
     *
     * @param settleAmount  结算金额
     */
    public void setSettleAmount(BigDecimal settleAmount) {
        this.settleAmount = settleAmount;
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.SETTLE_RATE：结算汇率
     */
    public BigDecimal getSettleRate() {
        return settleRate;
    }

    /**
     * set method 
     *
     * @param settleRate  结算汇率
     */
    public void setSettleRate(BigDecimal settleRate) {
        this.settleRate = settleRate;
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.SETTLE_DATE：结算日期 yyyyMMdd
     */
    public String getSettleDate() {
        return settleDate;
    }

    /**
     * set method 
     *
     * @param settleDate  结算日期 yyyyMMdd
     */
    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate == null ? null : settleDate.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.SETTLEMENT_ID：结算单号
     */
    public String getSettlementId() {
        return settlementId;
    }

    /**
     * set method 
     *
     * @param settlementId  结算单号
     */
    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId == null ? null : settlementId.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.SETTLE_BATCH_ID：结算批次号
     */
    public String getSettleBatchId() {
        return settleBatchId;
    }

    /**
     * set method 
     *
     * @param settleBatchId  结算批次号
     */
    public void setSettleBatchId(String settleBatchId) {
        this.settleBatchId = settleBatchId == null ? null : settleBatchId.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.FEE_SETTLE_METHOD：费用结算方式
     */
    public String getFeeSettleMethod() {
        return feeSettleMethod;
    }

    /**
     * set method 
     *
     * @param feeSettleMethod  费用结算方式
     */
    public void setFeeSettleMethod(String feeSettleMethod) {
        this.feeSettleMethod = feeSettleMethod == null ? null : feeSettleMethod.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.SETTLE_STATUS：结算状态
     */
    public String getSettleStatus() {
        return settleStatus;
    }

    /**
     * set method 
     *
     * @param settleStatus  结算状态
     */
    public void setSettleStatus(String settleStatus) {
        this.settleStatus = settleStatus == null ? null : settleStatus.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.SETTLE_TIME：结算时间
     */
    public Date getSettleTime() {
        return settleTime;
    }

    /**
     * set method 
     *
     * @param settleTime  结算时间
     */
    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.GMT_CREATE_TIME：创建时间
     */
    public Date getGmtCreateTime() {
        return gmtCreateTime;
    }

    /**
     * set method 
     *
     * @param gmtCreateTime  创建时间
     */
    public void setGmtCreateTime(Date gmtCreateTime) {
        this.gmtCreateTime = gmtCreateTime;
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.GMT_UPDATE_TIME：更新时间
     */
    public Date getGmtUpdateTime() {
        return gmtUpdateTime;
    }

    /**
     * set method 
     *
     * @param gmtUpdateTime  更新时间
     */
    public void setGmtUpdateTime(Date gmtUpdateTime) {
        this.gmtUpdateTime = gmtUpdateTime;
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.PAY_METHOD：支付方式 01-信用卡支付、02-本地化支付
     */
    public String getPayMethod() {
        return payMethod;
    }

    /**
     * set method 
     *
     * @param payMethod  支付方式 01-信用卡支付、02-本地化支付
     */
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod == null ? null : payMethod.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.ACCOUNTING_STATUS：记账状态
     */
    public String getAccountingStatus() {
        return accountingStatus;
    }

    /**
     * set method 
     *
     * @param accountingStatus  记账状态
     */
    public void setAccountingStatus(String accountingStatus) {
        this.accountingStatus = accountingStatus == null ? null : accountingStatus.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.ACCOUNTING_ID：记账流水号
     */
    public String getAccountingId() {
        return accountingId;
    }

    /**
     * set method 
     *
     * @param accountingId  记账流水号
     */
    public void setAccountingId(String accountingId) {
        this.accountingId = accountingId == null ? null : accountingId.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_DETAIL.ACCOUNTING_TIME：记账时间
     */
    public Date getAccountingTime() {
        return accountingTime;
    }

    /**
     * set method 
     *
     * @param accountingTime  记账时间
     */
    public void setAccountingTime(Date accountingTime) {
        this.accountingTime = accountingTime;
    }

	public String getDepositStatus() {
		return depositStatus;
	}

	public void setDepositStatus(String depositStatus) {
		this.depositStatus = depositStatus;
	}

    public String getBeginSettleDate() {
        return beginSettleDate;
    }

    public void setBeginSettleDate(String beginSettleDate) {
        this.beginSettleDate = beginSettleDate;
    }

    public String getEndSettleDate() {
        return endSettleDate;
    }

    public void setEndSettleDate(String endSettleDate) {
        this.endSettleDate = endSettleDate;
    }

	public String getSettleCompleteTime() {
		return settleCompleteTime;
	}

	public void setSettleCompleteTime(String settleCompleteTime) {
		this.settleCompleteTime = settleCompleteTime;
	}

	public String getSettleStartTime() {
		return settleStartTime;
	}

	public void setSettleStartTime(String settleStartTime) {
		this.settleStartTime = settleStartTime;
	}

	public Date getPayCompleteTime() {
		return payCompleteTime;
	}

	public void setPayCompleteTime(Date payCompleteTime) {
		this.payCompleteTime = payCompleteTime;
	}


	
}

