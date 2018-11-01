package com.ipaylinks.cmp.css.dal.model;

import java.math.BigDecimal;
import java.util.Date;

public class MertSettlementOrder {
    /**
     * 主键
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : ID
     */
    private String id;

    /**
     * 商户ID
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : MERCHANT_ID
     */
    private String merchantId;

    /**
     * 商户名称
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : MERCHANT_NAME
     */
    private String merchantName;

    /**
     * 结算类型
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : SETTLE_TYPE
     */
    private String settleType;

    /**
     * 结算币种
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : SETTLE_CURRENCY
     */
    private String settleCurrency;

    /**
     * 结算金额
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : SETTLE_AMOUNT
     */
    private BigDecimal settleAmount;

    /**
     * 费用结算方式
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : FEE_SETTLE_METHOD
     */
    private String feeSettleMethod;

    /**
     * 结算单日期 yyyyMMdd
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : SETTLEMENT_DATE
     */
    private String settlementDate;

    /**
     * 订单开始日期yyyyMMdd
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : ORDER_BEGIN_DATE
     */
    private String orderBeginDate;

    /**
     * 订单结束日期yyyyMMdd
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : ORDER_END_DATE
     */
    private String orderEndDate;

    /**
     * 结算汇总单编号
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : SETTLEMENT_SUMMARY_ID
     */
    private String settlementSummaryId;

    /**
     * 汇总状态
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : SUMMARY_STATUS
     */
    private String summaryStatus;

    /**
     * 记账状态
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : ACCOUNTING_STATUS
     */
    private String accountingStatus;

    /**
     * 记账流水号
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : ACCOUNTING_ID
     */
    private String accountingId;

    /**
     * 记账时间
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : ACCOUNTING_TIME
     */
    private Date accountingTime;

    /**
     * 创建时间
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : GMT_CREATE_TIME
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : GMT_UPDATE_TIME
     */
    private Date gmtUpdateTime;

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
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : TRANS_AMOUNT
     */
    private BigDecimal transAmount;
    
    /**
     * 结算单编号
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : SETTLEMENT_ORDER_ID
     */
    private String  settlementOrderId;		
    /**
     * 结算单状态
     * 表 : T_MERT_SETTLEMENT_DETAIL
     * 对应字段 : IS_VALID
     */
    private String isValid;

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_ORDER.ID：主键
     */
    public String getId() {
        return id;
    }

    public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
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
     * @return T_MERT_SETTLEMENT_ORDER.MERCHANT_ID：商户ID
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
     * @return T_MERT_SETTLEMENT_ORDER.MERCHANT_NAME：商户名称
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
     * @return T_MERT_SETTLEMENT_ORDER.SETTLE_TYPE：结算类型
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
     * @return T_MERT_SETTLEMENT_ORDER.SETTLE_CURRENCY：结算币种
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
     * @return T_MERT_SETTLEMENT_ORDER.SETTLE_AMOUNT：结算金额
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
     * @return T_MERT_SETTLEMENT_ORDER.FEE_SETTLE_METHOD：费用结算方式
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
     * @return T_MERT_SETTLEMENT_ORDER.SETTLEMENT_DATE：结算单日期 yyyyMMdd
     */
    public String getSettlementDate() {
        return settlementDate;
    }

    /**
     * set method 
     *
     * @param settlementDate  结算单日期 yyyyMMdd
     */
    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate == null ? null : settlementDate.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_ORDER.ORDER_BEGIN_DATE：订单开始日期yyyyMMdd
     */
    public String getOrderBeginDate() {
        return orderBeginDate;
    }

    /**
     * set method 
     *
     * @param orderBeginDate  订单开始日期yyyyMMdd
     */
    public void setOrderBeginDate(String orderBeginDate) {
        this.orderBeginDate = orderBeginDate == null ? null : orderBeginDate.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_ORDER.ORDER_END_DATE：订单结束日期yyyyMMdd
     */
    public String getOrderEndDate() {
        return orderEndDate;
    }

    /**
     * set method 
     *
     * @param orderEndDate  订单结束日期yyyyMMdd
     */
    public void setOrderEndDate(String orderEndDate) {
        this.orderEndDate = orderEndDate == null ? null : orderEndDate.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_ORDER.SETTLEMENT_SUMMARY_ID：结算汇总单编号
     */
    public String getSettlementSummaryId() {
        return settlementSummaryId;
    }

    /**
     * set method 
     *
     * @param settlementSummaryId  结算汇总单编号
     */
    public void setSettlementSummaryId(String settlementSummaryId) {
        this.settlementSummaryId = settlementSummaryId == null ? null : settlementSummaryId.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_ORDER.SUMMARY_STATUS：汇总状态
     */
    public String getSummaryStatus() {
        return summaryStatus;
    }

    /**
     * set method 
     *
     * @param summaryStatus  汇总状态
     */
    public void setSummaryStatus(String summaryStatus) {
        this.summaryStatus = summaryStatus == null ? null : summaryStatus.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_ORDER.ACCOUNTING_STATUS：记账状态
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
     * @return T_MERT_SETTLEMENT_ORDER.ACCOUNTING_ID：记账流水号
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
     * @return T_MERT_SETTLEMENT_ORDER.ACCOUNTING_TIME：记账时间
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

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_ORDER.GMT_CREATE_TIME：创建时间
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
     * @return T_MERT_SETTLEMENT_ORDER.GMT_UPDATE_TIME：更新时间
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