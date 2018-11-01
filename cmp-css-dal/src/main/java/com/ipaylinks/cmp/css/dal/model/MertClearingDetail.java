package com.ipaylinks.cmp.css.dal.model;

import java.math.BigDecimal;
import java.util.Date;

public class MertClearingDetail {
    /**
     * 主键
     * 表 : T_MERT_CLEARING_DETAIL
     * 对应字段 : ID
     */
    private String id;

    /**
     * 收单订单号
     * 表 : T_MERT_CLEARING_DETAIL
     * 对应字段 : ORDER_ID
     */
    private String orderId;

    /**
     * 商户编号
     * 表 : T_MERT_CLEARING_DETAIL
     * 对应字段 : MERCHANT_ID
     */
    private String merchantId;

    /**
     * 商户名称
     * 表 : T_MERT_CLEARING_DETAIL
     * 对应字段 : MERCHANT_NAME
     */
    private String merchantName;

    /**
     * 支付方式 01-信用卡支付、02-本地化支付
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : PAY_METHOD
     */
    private String payMethod;

    /**
     * 交易类型 com.ipaylinks.common.enums.TradeTypeEnum
     * 表 : T_MERT_CLEARING_DETAIL
     * 对应字段 : TRANS_TYPE
     */
    private String transType;

    /**
     * 金额类型 01-本金、02-比例费、03-固定费、04-处理费
     * 表 : T_MERT_CLEARING_DETAIL
     * 对应字段 : AMOUNT_TYPE
     */
    private String amountType;

    /**
     * 交易币种
     * 表 : T_MERT_CLEARING_DETAIL
     * 对应字段 : TRANS_CURRENCY
     */
    private String transCurrency;

    /**
     * 交易金额
     * 表 : T_MERT_CLEARING_DETAIL
     * 对应字段 : TRANS_AMOUNT
     */
    private BigDecimal transAmount;

    /**
     * 费用结算方式
     * 表 : T_MERT_CLEARING_DETAIL
     * 对应字段 : FEE_SETTLE_METHOD
     */
    private String feeSettleMethod;

    /**
     * 结算日期 yyyyMMdd
     * 表 : T_MERT_CLEARING_DETAIL
     * 对应字段 : SETTLE_DATE
     */
    private String settleDate;

    /**
     * 结算币种
     * 表 : T_MERT_CLEARING_DETAIL
     * 对应字段 : SETTLE_CURRENCY_CODE
     */
    private String settleCurrencyCode;

    /**
     * 状态 00-未处理  01-已生成结算明细  02-生成结算明细失败
     * 表 : T_MERT_CLEARING_DETAIL
     * 对应字段 : STATUS
     */
    private String status;

    /**
     * 创建时间
     * 表 : T_MERT_CLEARING_DETAIL
     * 对应字段 : GMT_CREATE_TIME
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     * 表 : T_MERT_CLEARING_DETAIL
     * 对应字段 : GMT_UPDATE_TIME
     */
    private Date gmtUpdateTime;

    /**
     * 订单类型：01-清算主订单 02-风控订单
     */
    private String orderType;

    /**
     * 订单ID：清算主订单ID、风控订单ID
     */
    private String oriId;

    /**
     * 记录数，数据统计时使用
     */
    private Integer recordCount;

    /**
     * 交易月份，数据统计时使用
     */
    private String tradeMonth;

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

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public String getTradeMonth() {
        return tradeMonth;
    }

    public void setTradeMonth(String tradeMonth) {
        this.tradeMonth = tradeMonth;
    }

    /**
     * get method 
     *
     * @return T_MERT_CLEARING_DETAIL.ID：主键
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * get method 
     *
     * @return T_MERT_CLEARING_DETAIL.MERCHANT_ID：商户编号
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * set method 
     *
     * @param merchantId  商户编号
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_CLEARING_DETAIL.MERCHANT_NAME：商户名称
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

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    /**
     * get method 
     *
     * @return T_MERT_CLEARING_DETAIL.TRANS_TYPE：交易类型 com.ipaylinks.common.enums.TradeTypeEnum
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
     * @return T_MERT_CLEARING_DETAIL.AMOUNT_TYPE：金额类型 01-本金、02-比例费、03-固定费、04-处理费
     */
    public String getAmountType() {
        return amountType;
    }

    /**
     * set method 
     *
     * @param amountType  金额类型 01-本金、02-比例费、03-固定费、04-处理费
     */
    public void setAmountType(String amountType) {
        this.amountType = amountType == null ? null : amountType.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_CLEARING_DETAIL.TRANS_CURRENCY：交易币种
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
     * @return T_MERT_CLEARING_DETAIL.TRANS_AMOUNT：交易金额
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
     * @return T_MERT_CLEARING_DETAIL.FEE_SETTLE_METHOD：费用结算方式
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
     * @return T_MERT_CLEARING_DETAIL.SETTLE_DATE：结算日期 yyyyMMdd
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
     * @return T_MERT_CLEARING_DETAIL.SETTLE_CURRENCY_CODE：结算币种
     */
    public String getSettleCurrencyCode() {
        return settleCurrencyCode;
    }

    /**
     * set method 
     *
     * @param settleCurrencyCode  结算币种
     */
    public void setSettleCurrencyCode(String settleCurrencyCode) {
        this.settleCurrencyCode = settleCurrencyCode == null ? null : settleCurrencyCode.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_CLEARING_DETAIL.ACCOUNTING_STATUS：记账状态 00-未记账 01-已记账 02-记账失败
     */
    public String getStatus() {
        return status;
    }

    /**
     * set method 
     *
     * @param status  状态 00-未处理  01-已生成结算明细  02-生成结算明细失败
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_CLEARING_DETAIL.GMT_CREATE_TIME：创建时间
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
     * @return T_MERT_CLEARING_DETAIL.GMT_UPDATE_TIME：更新时间
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
}
