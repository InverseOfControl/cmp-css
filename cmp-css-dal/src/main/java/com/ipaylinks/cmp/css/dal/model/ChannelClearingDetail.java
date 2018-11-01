package com.ipaylinks.cmp.css.dal.model;

import java.math.BigDecimal;
import java.util.Date;

public class ChannelClearingDetail {
    /**
     * 主键
     * 表 : T_CHANNEL_CLEARING_DETAIL
     * 对应字段 : ID
     */
    private String id;

    /**
     * 渠道流水号
     * 表 : T_CHANNEL_CLEARING_DETAIL
     * 对应字段 : CHANNEL_DETAIL_ID
     */
    private String channelDetailId;

    /**
     * 比例费币种
     * 表 : T_CHANNEL_CLEARING_DETAIL
     * 对应字段 : PERCENT_FEE_CURRENCY
     */
    private String percentFeeCurrency;

    /**
     * 比例费金额
     * 表 : T_CHANNEL_CLEARING_DETAIL
     * 对应字段 : PERCENT_FEE_AMOUNT
     */
    private BigDecimal percentFeeAmount;

    /**
     * 固定费币种
     * 表 : T_CHANNEL_CLEARING_DETAIL
     * 对应字段 : FIXED_FEE_CURRENCY
     */
    private String fixedFeeCurrency;

    /**
     * 固定费金额
     * 表 : T_CHANNEL_CLEARING_DETAIL
     * 对应字段 : FIXED_FEE_AMOUNT
     */
    private BigDecimal fixedFeeAmount;

    /**
     * 处理费币种
     * 表 : T_CHANNEL_CLEARING_DETAIL
     * 对应字段 : FEE_CURRENCY
     */
    private String feeCurrency;

    /**
     * 处理费金额
     * 表 : T_CHANNEL_CLEARING_DETAIL
     * 对应字段 : FEE_AMOUNT
     */
    private BigDecimal feeAmount;

    /**
     * 成本结算币种
     * 表 : T_CHANNEL_CLEARING_DETAIL
     * 对应字段 : COST_SETTLE_CURRENCY
     */
    private String costSettleCurrency;

    /**
     * 成功结算金额
     * 表 : T_CHANNEL_CLEARING_DETAIL
     * 对应字段 : COST_SETTLE_AMOUNT
     */
    private BigDecimal costSettleAmount;

    /**
     * 成本结算日期 yyyyMMdd
     * 表 : T_CHANNEL_CLEARING_DETAIL
     * 对应字段 : COST_SETTLE_DATE
     */
    private String costSettleDate;

    /**
     * 成本收取方式
     * 表 : T_CHANNEL_CLEARING_DETAIL
     * 对应字段 : CHARGE_COST_METHOD
     */
    private String chargeCostMethod;

    /**
     * 成本规则ID
     * 表 : T_CHANNEL_CLEARING_DETAIL
     * 对应字段 : COST_ID
     */
    private String costId;

    /**
     * 创建时间
     * 表 : T_CHANNEL_CLEARING_DETAIL
     * 对应字段 : GMT_CREATE_TIME
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     * 表 : T_CHANNEL_CLEARING_DETAIL
     * 对应字段 : GMT_UPDATE_TIME
     */
    private Date gmtUpdateTime;

    /**
     * get method 
     *
     * @return T_CHANNEL_CLEARING_DETAIL.ID：主键
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
     * @return T_CHANNEL_CLEARING_DETAIL.CHANNEL_DETAIL_ID：渠道流水号
     */
    public String getChannelDetailId() {
        return channelDetailId;
    }

    /**
     * set method 
     *
     * @param channelDetailId  渠道流水号
     */
    public void setChannelDetailId(String channelDetailId) {
        this.channelDetailId = channelDetailId == null ? null : channelDetailId.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_CLEARING_DETAIL.PERCENT_FEE_CURRENCY：比例费币种
     */
    public String getPercentFeeCurrency() {
        return percentFeeCurrency;
    }

    /**
     * set method 
     *
     * @param percentFeeCurrency  比例费币种
     */
    public void setPercentFeeCurrency(String percentFeeCurrency) {
        this.percentFeeCurrency = percentFeeCurrency == null ? null : percentFeeCurrency.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_CLEARING_DETAIL.PERCENT_FEE_AMOUNT：比例费金额
     */
    public BigDecimal getPercentFeeAmount() {
        return percentFeeAmount;
    }

    /**
     * set method 
     *
     * @param percentFeeAmount  比例费金额
     */
    public void setPercentFeeAmount(BigDecimal percentFeeAmount) {
        this.percentFeeAmount = percentFeeAmount;
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_CLEARING_DETAIL.FIXED_FEE_CURRENCY：固定费币种
     */
    public String getFixedFeeCurrency() {
        return fixedFeeCurrency;
    }

    /**
     * set method 
     *
     * @param fixedFeeCurrency  固定费币种
     */
    public void setFixedFeeCurrency(String fixedFeeCurrency) {
        this.fixedFeeCurrency = fixedFeeCurrency == null ? null : fixedFeeCurrency.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_CLEARING_DETAIL.FIXED_FEE_AMOUNT：固定费金额
     */
    public BigDecimal getFixedFeeAmount() {
        return fixedFeeAmount;
    }

    /**
     * set method 
     *
     * @param fixedFeeAmount  固定费金额
     */
    public void setFixedFeeAmount(BigDecimal fixedFeeAmount) {
        this.fixedFeeAmount = fixedFeeAmount;
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_CLEARING_DETAIL.FEE_CURRENCY：处理费币种
     */
    public String getFeeCurrency() {
        return feeCurrency;
    }

    /**
     * set method 
     *
     * @param feeCurrency  处理费币种
     */
    public void setFeeCurrency(String feeCurrency) {
        this.feeCurrency = feeCurrency == null ? null : feeCurrency.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_CLEARING_DETAIL.FEE_AMOUNT：处理费金额
     */
    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    /**
     * set method 
     *
     * @param feeAmount  处理费金额
     */
    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_CLEARING_DETAIL.COST_SETTLE_CURRENCY：成本结算币种
     */
    public String getCostSettleCurrency() {
        return costSettleCurrency;
    }

    /**
     * set method 
     *
     * @param costSettleCurrency  成本结算币种
     */
    public void setCostSettleCurrency(String costSettleCurrency) {
        this.costSettleCurrency = costSettleCurrency == null ? null : costSettleCurrency.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_CLEARING_DETAIL.COST_SETTLE_AMOUNT：成功结算金额
     */
    public BigDecimal getCostSettleAmount() {
        return costSettleAmount;
    }

    /**
     * set method 
     *
     * @param costSettleAmount  成功结算金额
     */
    public void setCostSettleAmount(BigDecimal costSettleAmount) {
        this.costSettleAmount = costSettleAmount;
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_CLEARING_DETAIL.COST_SETTLE_DATE：成本结算日期 yyyyMMdd
     */
    public String getCostSettleDate() {
        return costSettleDate;
    }

    /**
     * set method 
     *
     * @param costSettleDate  成本结算日期 yyyyMMdd
     */
    public void setCostSettleDate(String costSettleDate) {
        this.costSettleDate = costSettleDate == null ? null : costSettleDate.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_CLEARING_DETAIL.CHARGE_COST_METHOD：成本收取方式
     */
    public String getChargeCostMethod() {
        return chargeCostMethod;
    }

    /**
     * set method 
     *
     * @param chargeCostMethod  成本收取方式
     */
    public void setChargeCostMethod(String chargeCostMethod) {
        this.chargeCostMethod = chargeCostMethod == null ? null : chargeCostMethod.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_CLEARING_DETAIL.COST_ID：成本规则ID
     */
    public String getCostId() {
        return costId;
    }

    /**
     * set method 
     *
     * @param costId  成本规则ID
     */
    public void setCostId(String costId) {
        this.costId = costId == null ? null : costId.trim();
    }

    /**
     * get method 
     *
     * @return T_CHANNEL_CLEARING_DETAIL.GMT_CREATE_TIME：创建时间
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
     * @return T_CHANNEL_CLEARING_DETAIL.GMT_UPDATE_TIME：更新时间
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