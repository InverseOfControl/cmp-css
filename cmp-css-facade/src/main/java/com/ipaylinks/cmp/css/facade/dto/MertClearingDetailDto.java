package com.ipaylinks.cmp.css.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MertClearingDetailDto implements Serializable {
    private static final long serialVersionUID = -3494316007278894474L;

    private String id;
    /** 收单订单号 */
    private String orderId;
    /** 商户编号 */
    private String merchantId;
    /** 商户名称 */
    private String merchantName;
    /** 支付方式 01-信用卡支付、02-本地化支付 */
    private String payMethod;
    /** 交易类型 com.ipaylinks.common.enums.TradeTypeEnum */
    private String transType;
    /** 金额类型 01-本金、02-比例费、03-固定费、04-处理费 */
    private String amountType;
    /** 交易币种 */
    private String transCurrency;
    /** 交易金额 */
    private BigDecimal transAmount;
    /** 费用结算方式 */
    private String feeSettleMethod;
    /** 结算日期 yyyyMMdd */
    private String settleDate;
    /** 结算币种 */
    private String settleCurrencyCode;
    /** 记账状态 00-未记账 01-已记账 02-记账失败 */
    private String status;
    /** 创建时间 */
    private Date gmtCreateTime;
    /** 更新时间 */
    private Date gmtUpdateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
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

    public String getFeeSettleMethod() {
        return feeSettleMethod;
    }

    public void setFeeSettleMethod(String feeSettleMethod) {
        this.feeSettleMethod = feeSettleMethod;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public String getSettleCurrencyCode() {
        return settleCurrencyCode;
    }

    public void setSettleCurrencyCode(String settleCurrencyCode) {
        this.settleCurrencyCode = settleCurrencyCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
