package com.ipaylinks.cmp.css.dal.model;

import java.math.BigDecimal;
import java.util.Date;

public class TradeAccountReport {
    /**
     * 主键
     * 表 : T_TRADE_ACCOUNT_REPORT
     * 对应字段 : ID
     */
    private String id;

    /**
     * 商户ID
     * 表 : T_TRADE_ACCOUNT_REPORT
     * 对应字段 : MERCHANT_ID
     */
    private String merchantId;

    /**
     * 商户名称
     * 表 : T_TRADE_ACCOUNT_REPORT
     * 对应字段 : MERCHANT_NAME
     */
    private String merchantName;

    /**
     * 交易月份
     * 表 : T_TRADE_ACCOUNT_REPORT
     * 对应字段 : TRADE_MONTH
     */
    private Integer tradeMonth;

    /**
     * 支付方式  01-信用卡支付，02-本地化支付
     * 表 : T_TRADE_ACCOUNT_REPORT
     * 对应字段 : PAY_METHOD
     */
    private String payMethod;

    /**
     * 消费总金额
     * 表 : T_TRADE_ACCOUNT_REPORT
     * 对应字段 : TRANS_AMOUNT
     */
    private BigDecimal transAmount;

    /**
     * 消费总笔数
     * 表 : T_TRADE_ACCOUNT_REPORT
     * 对应字段 : TRANS_COUNT
     */
    private Long transCount;

    /**
     * 退款总笔数
     * 表 : T_TRADE_ACCOUNT_REPORT
     * 对应字段 : REFUND_COUNT
     */
    private Long refundCount;

    /**
     * 退款总金额
     * 表 : T_TRADE_ACCOUNT_REPORT
     * 对应字段 : REFUND_AMOUNT
     */
    private BigDecimal refundAmount;

    /**
     * 拒付总笔数
     * 表 : T_TRADE_ACCOUNT_REPORT
     * 对应字段 : REFUSE_COUNT
     */
    private Long refuseCount;

    /**
     * 拒付总金额
     * 表 : T_TRADE_ACCOUNT_REPORT
     * 对应字段 : REFUSE_AMOUNT
     */
    private BigDecimal refuseAmount;

    /**
     * 消费比例费
     * 表 : T_TRADE_ACCOUNT_REPORT
     * 对应字段 : TRANS_FEE
     */
    private BigDecimal transFee;

    /**
     * 消费固定费
     * 表 : T_TRADE_ACCOUNT_REPORT
     * 对应字段 : FIXED_CHARDE_FEE
     */
    private BigDecimal fixedChardeFee;

    /**
     * 拒付率
     * 表 : T_TRADE_ACCOUNT_REPORT
     * 对应字段 : REFUSE_RATIO
     */
    private BigDecimal refuseRatio;

    /**
     * 创建时间
     * 表 : T_TRADE_ACCOUNT_REPORT
     * 对应字段 : GMT_CREATE_TIME
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     * 表 : T_TRADE_ACCOUNT_REPORT
     * 对应字段 : GMT_UPDATE_TIME
     */
    private Date gmtUpdateTime;

    /**
     * get method 
     *
     * @return T_TRADE_ACCOUNT_REPORT.ID：主键
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
     * @return T_TRADE_ACCOUNT_REPORT.MERCHANT_ID：商户ID
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
     * @return T_TRADE_ACCOUNT_REPORT.MERCHANT_NAME：商户名称
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
     * @return T_TRADE_ACCOUNT_REPORT.TRADE_MONTH：交易月份
     */
    public Integer getTradeMonth() {
        return tradeMonth;
    }

    /**
     * set method 
     *
     * @param tradeMonth  交易月份
     */
    public void setTradeMonth(Integer tradeMonth) {
        this.tradeMonth = tradeMonth;
    }

    /**
     * get method 
     *
     * @return T_TRADE_ACCOUNT_REPORT.PAY_METHOD：支付方式  01-信用卡支付，02-本地化支付
     */
    public String getPayMethod() {
        return payMethod;
    }

    /**
     * set method 
     *
     * @param payMethod  支付方式  01-信用卡支付，02-本地化支付
     */
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod == null ? null : payMethod.trim();
    }

    /**
     * get method 
     *
     * @return T_TRADE_ACCOUNT_REPORT.TRANS_AMOUNT：消费总金额
     */
    public BigDecimal getTransAmount() {
        return transAmount == null ? BigDecimal.ZERO : transAmount;
    }

    /**
     * set method 
     *
     * @param transAmount  消费总金额
     */
    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    /**
     * get method 
     *
     * @return T_TRADE_ACCOUNT_REPORT.TRANS_COUNT：消费总笔数
     */
    public Long getTransCount() {
        return transCount == null ? 0L : transCount;
    }

    /**
     * set method 
     *
     * @param transCount  消费总笔数
     */
    public void setTransCount(Long transCount) {
        this.transCount = transCount;
    }

    /**
     * get method 
     *
     * @return T_TRADE_ACCOUNT_REPORT.REFUND_COUNT：退款总笔数
     */
    public Long getRefundCount() {
        return refundCount == null ? 0L : refundCount;
    }

    /**
     * set method 
     *
     * @param refundCount  退款总笔数
     */
    public void setRefundCount(Long refundCount) {
        this.refundCount = refundCount;
    }

    /**
     * get method 
     *
     * @return T_TRADE_ACCOUNT_REPORT.REFUND_AMOUNT：退款总金额
     */
    public BigDecimal getRefundAmount() {
        return refundAmount == null ? BigDecimal.ZERO : refundAmount;
    }

    /**
     * set method 
     *
     * @param refundAmount  退款总金额
     */
    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    /**
     * get method 
     *
     * @return T_TRADE_ACCOUNT_REPORT.REFUSE_COUNT：拒付总笔数
     */
    public Long getRefuseCount() {
        return refuseCount == null ? 0L : refuseCount;
    }

    /**
     * set method 
     *
     * @param refuseCount  拒付总笔数
     */
    public void setRefuseCount(Long refuseCount) {
        this.refuseCount = refuseCount;
    }

    /**
     * get method 
     *
     * @return T_TRADE_ACCOUNT_REPORT.REFUSE_AMOUNT：拒付总金额
     */
    public BigDecimal getRefuseAmount() {
        return refuseAmount == null ? BigDecimal.ZERO : refuseAmount;
    }

    /**
     * set method 
     *
     * @param refuseAmount  拒付总金额
     */
    public void setRefuseAmount(BigDecimal refuseAmount) {
        this.refuseAmount = refuseAmount;
    }

    /**
     * get method 
     *
     * @return T_TRADE_ACCOUNT_REPORT.TRANS_FEE：消费比例费
     */
    public BigDecimal getTransFee() {
        return transFee == null ? BigDecimal.ZERO : transFee;
    }

    /**
     * set method 
     *
     * @param transFee  消费比例费
     */
    public void setTransFee(BigDecimal transFee) {
        this.transFee = transFee;
    }

    /**
     * get method 
     *
     * @return T_TRADE_ACCOUNT_REPORT.FIXED_CHARDE_FEE：消费固定费
     */
    public BigDecimal getFixedChardeFee() {
        return fixedChardeFee == null ? BigDecimal.ZERO : fixedChardeFee;
    }

    /**
     * set method 
     *
     * @param fixedChardeFee  消费固定费
     */
    public void setFixedChardeFee(BigDecimal fixedChardeFee) {
        this.fixedChardeFee = fixedChardeFee;
    }

    /**
     * get method 
     *
     * @return T_TRADE_ACCOUNT_REPORT.REFUSE_RATIO：拒付率
     */
    public BigDecimal getRefuseRatio() {
        return refuseRatio == null ? BigDecimal.ZERO : refuseRatio;
    }

    /**
     * set method 
     *
     * @param refuseRatio  拒付率
     */
    public void setRefuseRatio(BigDecimal refuseRatio) {
        this.refuseRatio = refuseRatio;
    }

    /**
     * get method 
     *
     * @return T_TRADE_ACCOUNT_REPORT.GMT_CREATE_TIME：创建时间
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
     * @return T_TRADE_ACCOUNT_REPORT.GMT_UPDATE_TIME：更新时间
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
