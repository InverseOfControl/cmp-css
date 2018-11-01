package com.ipaylinks.cmp.css.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class MertFeeDto implements Serializable {
    private static final long serialVersionUID = -5997260107974179556L;

    /**
     * 主键
     */
    private String id;
    /**
     * 商户号
     */
    private String merchantId;
    /**
     * 商户名称
     */
    private String merchantName;
    /**
     * 商户订单号
     */
    private String merchantOrderId;
    /**
     * 收单订单号
     */
    private String orderId;
    /**
     * 订单类型
     */
    private String transType;
    /**
     * 订单金额类型
     */
    private String amountType;
    /**
     * 订单币种
     */
    private String transCurrency;
    /**
     * 订单金额
     */
    private BigDecimal transAmount;
    /**
     * 费用币种
     */
    private String feeCurrency;
    /**
     * 费用金额
     */
    private BigDecimal feeAmount;
    /**
     * 费用结算币种
     */
    private String feeSettleCurrency;
    /**
     * 费用结算金额
     */
    private BigDecimal feeSettleAmount;
    /**
     * 订单日期
     */
    private String orderDate;
    /**
     * 结算日期
     */
    private String settleDate;
    /**
     * 结算汇率
     */
    private String settleRate;
    /**
     * 收费方式
     */
    private String feeSettleMethod;
    /**
     * 结算状态
     */
    private String settleStatus;
    /**
     * 记账状态
     */
    private String accountingStatus;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getFeeCurrency() {
        return feeCurrency;
    }

    public void setFeeCurrency(String feeCurrency) {
        this.feeCurrency = feeCurrency;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getFeeSettleCurrency() {
        return feeSettleCurrency;
    }

    public void setFeeSettleCurrency(String feeSettleCurrency) {
        this.feeSettleCurrency = feeSettleCurrency;
    }

    public BigDecimal getFeeSettleAmount() {
        return feeSettleAmount;
    }

    public void setFeeSettleAmount(BigDecimal feeSettleAmount) {
        this.feeSettleAmount = feeSettleAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public String getSettleRate() {
        return settleRate;
    }

    public void setSettleRate(String settleRate) {
        this.settleRate = settleRate;
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

    public String getAccountingStatus() {
        return accountingStatus;
    }

    public void setAccountingStatus(String accountingStatus) {
        this.accountingStatus = accountingStatus;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }
}
