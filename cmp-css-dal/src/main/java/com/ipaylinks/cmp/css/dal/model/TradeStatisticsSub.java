package com.ipaylinks.cmp.css.dal.model;

import java.math.BigDecimal;
import java.util.Date;

public class TradeStatisticsSub {
    /**
     * 主键
     * 表 : T_TRADE_STATISTICS_SUB
     * 对应字段 : ID
     */
    private String id;

    /**
     * 统计ID
     * 表 : T_TRADE_STATISTICS_SUB
     * 对应字段 : TRADE_STATISTICS_ID
     */
    private String tradeStatisticsId;

    /**
     * 交易类型
     * 表 : T_TRADE_STATISTICS_SUB
     * 对应字段 : TRANS_TYPE
     */
    private String transType;

    /**
     * 成功笔数
     * 表 : T_TRADE_STATISTICS_SUB
     * 对应字段 : SUCCESS_COUNT
     */
    private Long successCount;

    /**
     * 成功金额
     * 表 : T_TRADE_STATISTICS_SUB
     * 对应字段 : SUCCESS_AMOUNT
     */
    private BigDecimal successAmount;

    /**
     * 失败总笔数
     * 表 : T_TRADE_STATISTICS_SUB
     * 对应字段 : FAILED_COUNT
     */
    private Long failedCount;

    /**
     * 失败总金额
     * 表 : T_TRADE_STATISTICS_SUB
     * 对应字段 : FAILED_AMOUNT
     */
    private BigDecimal failedAmount;

    /**
     * 比例费
     * 表 : T_TRADE_STATISTICS_SUB
     * 对应字段 : PERCENT_FEE
     */
    private BigDecimal percentFee;

    /**
     * 固定费
     * 表 : T_TRADE_STATISTICS_SUB
     * 对应字段 : FIXED_FEE
     */
    private BigDecimal fixedFee;

    /**
     * 创建时间
     * 表 : T_TRADE_STATISTICS_SUB
     * 对应字段 : GMT_CREATE_TIME
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     * 表 : T_TRADE_STATISTICS_SUB
     * 对应字段 : GMT_UPDATE_TIME
     */
    private Date gmtUpdateTime;

    /**
     * get method 
     *
     * @return T_TRADE_STATISTICS_SUB.ID：主键
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
     * @return T_TRADE_STATISTICS_SUB.TRADE_STATISTICS_ID：统计ID
     */
    public String getTradeStatisticsId() {
        return tradeStatisticsId;
    }

    /**
     * set method 
     *
     * @param tradeStatisticsId  统计ID
     */
    public void setTradeStatisticsId(String tradeStatisticsId) {
        this.tradeStatisticsId = tradeStatisticsId == null ? null : tradeStatisticsId.trim();
    }

    /**
     * get method 
     *
     * @return T_TRADE_STATISTICS_SUB.TRANS_TYPE：交易类型
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
     * @return T_TRADE_STATISTICS_SUB.SUCCESS_COUNT：成功笔数
     */
    public Long getSuccessCount() {
        return successCount;
    }

    /**
     * set method 
     *
     * @param successCount  成功笔数
     */
    public void setSuccessCount(Long successCount) {
        this.successCount = successCount;
    }

    /**
     * get method 
     *
     * @return T_TRADE_STATISTICS_SUB.SUCCESS_AMOUNT：成功金额
     */
    public BigDecimal getSuccessAmount() {
        return successAmount;
    }

    /**
     * set method 
     *
     * @param successAmount  成功金额
     */
    public void setSuccessAmount(BigDecimal successAmount) {
        this.successAmount = successAmount;
    }

    /**
     * get method 
     *
     * @return T_TRADE_STATISTICS_SUB.FAILED_COUNT：失败总笔数
     */
    public Long getFailedCount() {
        return failedCount;
    }

    /**
     * set method 
     *
     * @param failedCount  失败总笔数
     */
    public void setFailedCount(Long failedCount) {
        this.failedCount = failedCount;
    }

    /**
     * get method 
     *
     * @return T_TRADE_STATISTICS_SUB.FAILED_AMOUNT：失败总金额
     */
    public BigDecimal getFailedAmount() {
        return failedAmount;
    }

    /**
     * set method 
     *
     * @param failedAmount  失败总金额
     */
    public void setFailedAmount(BigDecimal failedAmount) {
        this.failedAmount = failedAmount;
    }

    /**
     * get method 
     *
     * @return T_TRADE_STATISTICS_SUB.PERCENT_FEE：比例费
     */
    public BigDecimal getPercentFee() {
        return percentFee;
    }

    /**
     * set method 
     *
     * @param percentFee  比例费
     */
    public void setPercentFee(BigDecimal percentFee) {
        this.percentFee = percentFee;
    }

    /**
     * get method 
     *
     * @return T_TRADE_STATISTICS_SUB.FIXED_FEE：固定费
     */
    public BigDecimal getFixedFee() {
        return fixedFee;
    }

    /**
     * set method 
     *
     * @param fixedFee  固定费
     */
    public void setFixedFee(BigDecimal fixedFee) {
        this.fixedFee = fixedFee;
    }

    /**
     * get method 
     *
     * @return T_TRADE_STATISTICS_SUB.GMT_CREATE_TIME：创建时间
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
     * @return T_TRADE_STATISTICS_SUB.GMT_UPDATE_TIME：更新时间
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