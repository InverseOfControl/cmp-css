package com.ipaylinks.cmp.css.dal.model;

import java.math.BigDecimal;
import java.util.Date;

public class ChannelOrder {
    /**
     * 主键
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : ID
     */
    private String id;

    /**
     * 商户ID
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : MERCHANT_ID
     */
    private String merchantId;

    /**
     * 商户名称
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : MERCHANT_NAME
     */
    private String merchantName;

    /**
     * 交易类型
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : TRANS_TYPE
     */
    private String transType;

    /**
     * 交易状态
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : TRANS_STATUS
     */
    private String transStatus;

    /**
     * 支付方式 01-信用卡支付 02-本地化支付
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : PAY_METHOD
     */
    private String payMethod;

    /**
     * 渠道类型 01-收单
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : CHANNEL_TYPE
     */
    private String channelType;

    /**
     * 渠道号
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : ORG_CODE
     */
    private String orgCode;

    /**
     * 子渠道号
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : ORG_SUB_CODE
     */
    private String orgSubCode;

    /**
     *  VISA、MC、JCB、AE、DC，qiwi等
     */
    private String payKind;

    /**
     * 渠道交易币种
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : PAY_CURRENCY
     */
    private String payCurrency;

    /**
     * 渠道交易金额
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : PAY_AMOUNT
     */
    private BigDecimal payAmount;

    /**
     * 商户订单号
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : MERCHANT_ORDER_ID
     */
    private String merchantOrderId;

    /**
     * 收单订单号
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : ORDER_ID
     */
    private String orderId;

    /**
     * 支付订单号
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : PAYMENT_ORDER_ID
     */
    private String paymentOrderId;

    /**
     * 渠道流水号
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : CHANNEL_ORDER_ID
     */
    private String channelOrderId;

    /**
     * 渠道完成时间
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : CHANNEL_COMPLETE_TIME
     */
    private Date channelCompleteTime;

    /**
     * 渠道返回流水号
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : CHANNEL_RETURN_ID
     */
    private String channelReturnId;

    /**
     * 成本收取类型
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : CHARGE_COST_TYPE
     */
    private String chargeCostType;

    /**
     * 成本收取标志
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : CHARGE_COST_FLAG
     */
    private String chargeCostFlag;

    /**
     * 参考号
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : CHANNEL_REFERENCE_NO
     */
    private String channelReferenceNo;

    /**
     * 授权号
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : CHANNEL_ACCESS_CODE
     */
    private String channelAccessCode;

    /**
     * 原渠道流水号
     * 表 : T_CHANNEL_ORDER
     */
    private String oriChannelOrderId;

    /**
     * 原渠道交易币种
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : ORI_PAY_CURRENCY
     */
    private String oriPayCurrency;

    /**
     * 原渠道交易金额
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : ORI_PAY_AMOUNT
     */
    private BigDecimal oriPayAmount;

    /**
     * 创建时间
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : GMT_CREATE_TIME
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     * 表 : T_CHANNEL_ORDER
     * 对应字段 : GMT_UPDATE_TIME
     */
    private Date gmtUpdateTime;
    /**
     * 交易完成开始时间
     */
    private Date beginChannelCompleteTime;
    /**
     * 交易完成结束时间
     */
    private Date endChannelCompleteTime;

    /**
     * 渠道流水是否推送成功标识
     */
    private String waterPushFlag;

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.ID：主键
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
     * @return T_CHANNEL_ORDER.MERCHANT_ID：商户ID
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
     * @return T_CHANNEL_ORDER.MERCHANT_NAME：商户名称
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
     * @return T_CHANNEL_ORDER.TRANS_TYPE：交易类型
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
     * @return T_CHANNEL_ORDER.TRANS_STATUS：交易状态
     */
    public String getTransStatus() {
        return transStatus;
    }

    /**
     * set method 
     *
     * @param transStatus  交易状态
     */
    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus == null ? null : transStatus.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.PAY_METHOD：支付方式 01-信用卡支付 02-本地化支付
     */
    public String getPayMethod() {
        return payMethod;
    }

    /**
     * set method 
     *
     * @param payMethod  支付方式 01-信用卡支付 02-本地化支付
     */
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod == null ? null : payMethod.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.CHANNEL_TYPE：渠道类型 01-收单
     */
    public String getChannelType() {
        return channelType;
    }

    /**
     * set method 
     *
     * @param channelType  渠道类型 01-收单
     */
    public void setChannelType(String channelType) {
        this.channelType = channelType == null ? null : channelType.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.ORG_CODE：渠道号
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * set method 
     *
     * @param orgCode  渠道号
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.ORG_SUB_CODE：子渠道号
     */
    public String getOrgSubCode() {
        return orgSubCode;
    }

    /**
     * set method 
     *
     * @param orgSubCode  子渠道号
     */
    public void setOrgSubCode(String orgSubCode) {
        this.orgSubCode = orgSubCode == null ? null : orgSubCode.trim();
    }

    public String getPayKind() {
        return payKind;
    }

    public void setPayKind(String payKind) {
        this.payKind = payKind;
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.PAY_CURRENCY：渠道交易币种
     */
    public String getPayCurrency() {
        return payCurrency;
    }

    /**
     * set method 
     *
     * @param payCurrency  渠道交易币种
     */
    public void setPayCurrency(String payCurrency) {
        this.payCurrency = payCurrency == null ? null : payCurrency.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.PAY_AMOUNT：渠道交易金额
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * set method 
     *
     * @param payAmount  渠道交易金额
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.MERCHANT_ORDER_ID：商户订单号
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
     * @return T_CHANNEL_ORDER.ORDER_ID：收单订单号
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
     * @return T_CHANNEL_ORDER.PAYMENT_ORDER_ID：支付订单号
     */
    public String getPaymentOrderId() {
        return paymentOrderId;
    }

    /**
     * set method 
     *
     * @param paymentOrderId  支付订单号
     */
    public void setPaymentOrderId(String paymentOrderId) {
        this.paymentOrderId = paymentOrderId == null ? null : paymentOrderId.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.CHANNEL_ORDER_ID：渠道流水号
     */
    public String getChannelOrderId() {
        return channelOrderId;
    }

    /**
     * set method 
     *
     * @param channelOrderId  渠道流水号
     */
    public void setChannelOrderId(String channelOrderId) {
        this.channelOrderId = channelOrderId == null ? null : channelOrderId.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.CHANNEL_COMPLETE_TIME：渠道完成时间
     */
    public Date getChannelCompleteTime() {
        return channelCompleteTime;
    }

    /**
     * set method 
     *
     * @param channelCompleteTime  渠道完成时间
     */
    public void setChannelCompleteTime(Date channelCompleteTime) {
        this.channelCompleteTime = channelCompleteTime;
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.CHANNEL_RETURN_ID：渠道返回流水号
     */
    public String getChannelReturnId() {
        return channelReturnId;
    }

    /**
     * set method 
     *
     * @param channelReturnId  渠道返回流水号
     */
    public void setChannelReturnId(String channelReturnId) {
        this.channelReturnId = channelReturnId == null ? null : channelReturnId.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.CHARGE_COST_TYPE：成本收取类型
     */
    public String getChargeCostType() {
        return chargeCostType;
    }

    /**
     * set method 
     *
     * @param chargeCostType  成本收取类型
     */
    public void setChargeCostType(String chargeCostType) {
        this.chargeCostType = chargeCostType == null ? null : chargeCostType.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.CHARGE_COST_FLAG：成本收取标志
     */
    public String getChargeCostFlag() {
        return chargeCostFlag;
    }

    /**
     * set method 
     *
     * @param chargeCostFlag  成本收取标志
     */
    public void setChargeCostFlag(String chargeCostFlag) {
        this.chargeCostFlag = chargeCostFlag == null ? null : chargeCostFlag.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.CHANNEL_REFERENCE_NO：参考号
     */
    public String getChannelReferenceNo() {
        return channelReferenceNo;
    }

    /**
     * set method 
     *
     * @param channelReferenceNo  参考号
     */
    public void setChannelReferenceNo(String channelReferenceNo) {
        this.channelReferenceNo = channelReferenceNo == null ? null : channelReferenceNo.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.CHANNEL_ACCESS_CODE：授权号
     */
    public String getChannelAccessCode() {
        return channelAccessCode;
    }

    /**
     * set method 
     *
     * @param channelAccessCode  授权号
     */
    public void setChannelAccessCode(String channelAccessCode) {
        this.channelAccessCode = channelAccessCode == null ? null : channelAccessCode.trim();
    }

    public String getOriChannelOrderId() {
        return oriChannelOrderId;
    }

    public void setOriChannelOrderId(String oriChannelOrderId) {
        this.oriChannelOrderId = oriChannelOrderId;
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.ORI_PAY_CURRENCY：原渠道交易币种
     */
    public String getOriPayCurrency() {
        return oriPayCurrency;
    }

    /**
     * set method 
     *
     * @param oriPayCurrency  原渠道交易币种
     */
    public void setOriPayCurrency(String oriPayCurrency) {
        this.oriPayCurrency = oriPayCurrency == null ? null : oriPayCurrency.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.ORI_PAY_AMOUNT：原渠道交易金额
     */
    public BigDecimal getOriPayAmount() {
        return oriPayAmount;
    }

    /**
     * set method 
     *
     * @param oriPayAmount  原渠道交易金额
     */
    public void setOriPayAmount(BigDecimal oriPayAmount) {
        this.oriPayAmount = oriPayAmount;
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_ORDER.GMT_CREATE_TIME：创建时间
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
     * @return T_CHANNEL_ORDER.GMT_UPDATE_TIME：更新时间
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

    public Date getBeginChannelCompleteTime() {
        return beginChannelCompleteTime;
    }

    public void setBeginChannelCompleteTime(Date beginChannelCompleteTime) {
        this.beginChannelCompleteTime = beginChannelCompleteTime;
    }

    public Date getEndChannelCompleteTime() {
        return endChannelCompleteTime;
    }

    public void setEndChannelCompleteTime(Date endChannelCompleteTime) {
        this.endChannelCompleteTime = endChannelCompleteTime;
    }

    public String getWaterPushFlag() {
        return waterPushFlag;
    }

    public void setWaterPushFlag(String waterPushFlag) {
        this.waterPushFlag = waterPushFlag;
    }
}

