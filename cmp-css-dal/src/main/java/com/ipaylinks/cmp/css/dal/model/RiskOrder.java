package com.ipaylinks.cmp.css.dal.model;

import java.math.BigDecimal;
import java.util.Date;

public class RiskOrder {
    /**
     * 表 : T_RISK_ORDER
     * 对应字段 : ID
     */
    private String id;

    /**
     * 商户ID
     * 表 : T_RISK_ORDER
     * 对应字段 : MERCHANT_ID
     */
    private String merchantId;

    /**
     * 商户名称
     * 表 : T_RISK_ORDER
     * 对应字段 : MERCHANT_NAME
     */
    private String merchantName;

    /**
     * 商户订单号
     * 表 : T_RISK_ORDER
     * 对应字段 : MERCHANT_ORDER_ID
     */
    private String merchantOrderId;

    /**
     * 收单订单号
     * 表 : T_RISK_ORDER
     * 对应字段 : ORDER_ID
     */
    private String orderId;

    /**
     * 风控订单号
     * 表 : T_RISK_ORDER
     * 对应字段 : RISK_ORDER_ID
     */
    private String riskOrderId;

    /**
     * 交易币种
     * 表 : T_RISK_ORDER
     * 对应字段 : TRANS_CURRENCY
     */
    private String transCurrency;

    /**
     * 交易金额
     * 表 : T_RISK_ORDER
     * 对应字段 : TRANS_AMOUNT
     */
    private BigDecimal transAmount;

    /**
     * 费用收取类型 01-单笔 02-批量
     * 表 : T_RISK_ORDER
     * 对应字段 : FEE_TYPE
     */
    private String feeType;

    /**
     * 费用规则ID
     * 表 : T_RISK_ORDER
     * 对应字段 : FEE_ID
     */
    private String feeId;

    /**
     * 费用收取标志
     * 表 : T_RISK_ORDER
     * 对应字段 : FEE_FLAG
     */
    private String feeFlag;

    /**
     * 风控结算币种
     * 表 : T_RISK_ORDER
     * 对应字段 : SETTLE_CURRENCY
     */
    private String settleCurrency;

    /**
     * 风控结算金额
     * 表 : T_RISK_ORDER
     * 对应字段 : SETTLE_AMOUNT
     */
    private BigDecimal settleAmount;

    /**
     * 创建时间
     * 表 : T_RISK_ORDER
     * 对应字段 : GMT_CREATE_TIME
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     * 表 : T_RISK_ORDER
     * 对应字段 : GMT_UPDATE_TIME
     */
    private Date gmtUpdateTime;

    /**
     * 交易类型 com.ipaylinks.common.enums.TradeTypeEnum
     * 表 : T_RISK_ORDER
     * 对应字段 : TRANS_TYPE
     */
    private String transType;

    /**
     * 支付方式 01-信用卡支付、02-本地化支付
     * 表 : T_RISK_ORDER
     * 对应字段 : PAY_METHOD
     */
    private String payMethod;

    private String payKind;

    public String getPayKind() {
        return payKind;
    }

    public void setPayKind(String payKind) {
        this.payKind = payKind;
    }

    /**
     * get method 
     *
     * @return T_RISK_ORDER.ID：null
     */
    public String getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  null
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * get method 
     *
     * @return T_RISK_ORDER.MERCHANT_ID：商户ID
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
     * @return T_RISK_ORDER.MERCHANT_NAME：商户名称
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
     * @return T_RISK_ORDER.MERCHANT_ORDER_ID：商户订单号
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
     * @return T_RISK_ORDER.ORDER_ID：收单订单号
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
     * @return T_RISK_ORDER.RISK_ORDER_ID：风控订单号
     */
    public String getRiskOrderId() {
        return riskOrderId;
    }

    /**
     * set method 
     *
     * @param riskOrderId  风控订单号
     */
    public void setRiskOrderId(String riskOrderId) {
        this.riskOrderId = riskOrderId == null ? null : riskOrderId.trim();
    }

    /**
     * get method 
     *
     * @return T_RISK_ORDER.TRANS_CURRENCY：交易币种
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
     * @return T_RISK_ORDER.TRANS_AMOUNT：交易金额
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
     * @return T_RISK_ORDER.FEE_TYPE：费用收取类型 01-单笔 02-批量
     */
    public String getFeeType() {
        return feeType;
    }

    /**
     * set method 
     *
     * @param feeType  费用收取类型 01-单笔 02-批量
     */
    public void setFeeType(String feeType) {
        this.feeType = feeType == null ? null : feeType.trim();
    }

    /**
     * get method 
     *
     * @return T_RISK_ORDER.FEE_ID：费用规则ID
     */
    public String getFeeId() {
        return feeId;
    }

    /**
     * set method 
     *
     * @param feeId  费用规则ID
     */
    public void setFeeId(String feeId) {
        this.feeId = feeId == null ? null : feeId.trim();
    }

    /**
     * get method 
     *
     * @return T_RISK_ORDER.FEE_FLAG：费用收取标志
     */
    public String getFeeFlag() {
        return feeFlag;
    }

    /**
     * set method 
     *
     * @param feeFlag  费用收取标志
     */
    public void setFeeFlag(String feeFlag) {
        this.feeFlag = feeFlag == null ? null : feeFlag.trim();
    }

    /**
     * get method 
     *
     * @return T_RISK_ORDER.SETTLE_CURRENCY：风控结算币种
     */
    public String getSettleCurrency() {
        return settleCurrency;
    }

    /**
     * set method 
     *
     * @param settleCurrency  风控结算币种
     */
    public void setSettleCurrency(String settleCurrency) {
        this.settleCurrency = settleCurrency == null ? null : settleCurrency.trim();
    }

    /**
     * get method 
     *
     * @return T_RISK_ORDER.SETTLE_AMOUNT：风控结算金额
     */
    public BigDecimal getSettleAmount() {
        return settleAmount;
    }

    /**
     * set method 
     *
     * @param settleAmount  风控结算金额
     */
    public void setSettleAmount(BigDecimal settleAmount) {
        this.settleAmount = settleAmount;
    }

    /**
     * get method 
     *
     * @return T_RISK_ORDER.GMT_CREATE_TIME：创建时间
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
     * @return T_RISK_ORDER.GMT_UPDATE_TIME：更新时间
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
     * @return T_RISK_ORDER.TRANS_TYPE：交易类型 com.ipaylinks.common.enums.TradeTypeEnum
     */
    public String getTransType() {
        return transType;
    }

    /**
     * set method 
     *
     * @param transType  交易类型 com.ipaylinks.common.enums.TradeTypeEnum
     */
    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    /**
     * get method 
     *
     * @return T_RISK_ORDER.PAY_METHOD：支付方式 01-信用卡支付、02-本地化支付
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
}
