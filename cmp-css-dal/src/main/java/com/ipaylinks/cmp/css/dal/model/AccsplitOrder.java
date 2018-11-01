package com.ipaylinks.cmp.css.dal.model;

import java.math.BigDecimal;
import java.util.Date;

public class AccsplitOrder {
    /**
     * 表 : T_ACCSPLIT_ORDER
     * 对应字段 : ID
     */
    private String id;

    /**
     * 商户ID
     * 表 : T_ACCSPLIT_ORDER
     * 对应字段 : MERCHANT_ID
     */
    private String merchantId;

    /**
     * 商户名称
     * 表 : T_ACCSPLIT_ORDER
     * 对应字段 : MERCHANT_NAME
     */
    private String merchantName;

    /**
     * 交易币种
     * 表 : T_ACCSPLIT_ORDER
     * 对应字段 : TRANS_CURRENCY
     */
    private String transCurrency;

    /**
     * 交易金额
     * 表 : T_ACCSPLIT_ORDER
     * 对应字段 : TRANS_AMOUNT
     */
    private BigDecimal transAmount;

    /**
     * 商户订单号
     * 表 : T_ACCSPLIT_ORDER
     * 对应字段 : MERCHANT_ORDER_ID
     */
    private String merchantOrderId;

    /**
     * 收单订单号
     * 表 : T_ACCSPLIT_ORDER
     * 对应字段 : ORDER_ID
     */
    private String orderId;

    /**
     * 创建时间
     * 表 : T_ACCSPLIT_ORDER
     * 对应字段 : GMT_CREATE_TIME
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     * 表 : T_ACCSPLIT_ORDER
     * 对应字段 : GMT_UPDATE_TIME
     */
    private Date gmtUpdateTime;

    /**
     * 费用规则ID
     * 表 : T_ACCSPLIT_ORDER
     * 对应字段 : FEE_ID
     */
    private String feeId;

    /**
     * 费用收取标志 00-未收费 01-已收费
     * 表 : T_ACCSPLIT_ORDER
     * 对应字段 : FEE_FLAG
     */
    private String feeFlag;
    
    /**
     *  收费ID
     */
    private java.lang.String calcFeeId;

    /**
     * get method 
     *
     * @return T_ACCSPLIT_ORDER.ID：null
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
     * @return T_ACCSPLIT_ORDER.MERCHANT_ID：商户ID
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
     * @return T_ACCSPLIT_ORDER.MERCHANT_NAME：商户名称
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
     * @return T_ACCSPLIT_ORDER.TRANS_CURRENCY：交易币种
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
     * @return T_ACCSPLIT_ORDER.TRANS_AMOUNT：交易金额
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
     * @return T_ACCSPLIT_ORDER.MERCHANT_ORDER_ID：商户订单号
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
     * @return T_ACCSPLIT_ORDER.ORDER_ID：收单订单号
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
     * @return T_ACCSPLIT_ORDER.GMT_CREATE_TIME：创建时间
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
     * @return T_ACCSPLIT_ORDER.GMT_UPDATE_TIME：更新时间
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
     * @return T_ACCSPLIT_ORDER.FEE_ID：费用规则ID
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
     * @return T_ACCSPLIT_ORDER.FEE_FLAG：费用收取标志 00-未收费 01-已收费
     */
    public String getFeeFlag() {
        return feeFlag;
    }

    /**
     * set method 
     *
     * @param feeFlag  费用收取标志 00-未收费 01-已收费
     */
    public void setFeeFlag(String feeFlag) {
        this.feeFlag = feeFlag == null ? null : feeFlag.trim();
    }

	public java.lang.String getCalcFeeId() {
		return calcFeeId;
	}

	public void setCalcFeeId(java.lang.String calcFeeId) {
		this.calcFeeId = calcFeeId;
	}
    
    
}