package com.ipaylinks.cmp.css.dal.model;

import java.util.Date;

public class TradeStatistics {
    /**
     * 主键
     * 表 : T_TRADE_STATISTICS
     * 对应字段 : ID
     */
    private String id;

    /**
     * 统计类型
     * 表 : T_TRADE_STATISTICS
     * 对应字段 : TYPE
     */
    private String type;

    /**
     * 统计日期
     * 表 : T_TRADE_STATISTICS
     * 对应字段 : STATISTIC_DATE
     */
    private String statisticDate;

    /**
     * 商户号
     * 表 : T_TRADE_STATISTICS
     * 对应字段 : MERCHANT_ID
     */
    private String merchantId;

    /**
     * 商户名称
     * 表 : T_TRADE_STATISTICS
     * 对应字段 : MERCHANT_NAME
     */
    private String merchantName;

    /**
     * 支付方式(01-本地化 02-信用卡)
     * 表 : T_TRADE_STATISTICS
     * 对应字段 : PAY_METHOD
     */
    private String payMethod;

    /**
     * 拒付率
     * 表 : T_TRADE_STATISTICS
     * 对应字段 : CHARGE_BACK_RATE
     */
    private String chargeBackRate;

    /**
     * 创建时间
     * 表 : T_TRADE_STATISTICS
     * 对应字段 : GMT_CREATE_TIME
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     * 表 : T_TRADE_STATISTICS
     * 对应字段 : GMT_UPDATE_TIME
     */
    private Date gmtUpdateTime;

    /**
     * get method 
     *
     * @return T_TRADE_STATISTICS.ID：主键
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
     * @return T_TRADE_STATISTICS.TYPE：统计类型
     */
    public String getType() {
        return type;
    }

    /**
     * set method 
     *
     * @param type  统计类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * get method 
     *
     * @return T_TRADE_STATISTICS.STATISTIC_DATE：统计日期
     */
    public String getStatisticDate() {
        return statisticDate;
    }

    /**
     * set method 
     *
     * @param statisticDate  统计日期
     */
    public void setStatisticDate(String statisticDate) {
        this.statisticDate = statisticDate == null ? null : statisticDate.trim();
    }

    /**
     * get method 
     *
     * @return T_TRADE_STATISTICS.MERCHANT_ID：商户号
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * set method 
     *
     * @param merchantId  商户号
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    /**
     * get method 
     *
     * @return T_TRADE_STATISTICS.MERCHANT_NAME：商户名称
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
     * @return T_TRADE_STATISTICS.PAY_METHOD：支付方式(01-本地化 02-信用卡)
     */
    public String getPayMethod() {
        return payMethod;
    }

    /**
     * set method 
     *
     * @param payMethod  支付方式(01-本地化 02-信用卡)
     */
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod == null ? null : payMethod.trim();
    }

    /**
     * get method 
     *
     * @return T_TRADE_STATISTICS.CHARGE_BACK_RATE：拒付率
     */
    public String getChargeBackRate() {
        return chargeBackRate;
    }

    /**
     * set method 
     *
     * @param chargeBackRate  拒付率
     */
    public void setChargeBackRate(String chargeBackRate) {
        this.chargeBackRate = chargeBackRate == null ? null : chargeBackRate.trim();
    }

    /**
     * get method 
     *
     * @return T_TRADE_STATISTICS.GMT_CREATE_TIME：创建时间
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
     * @return T_TRADE_STATISTICS.GMT_UPDATE_TIME：更新时间
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