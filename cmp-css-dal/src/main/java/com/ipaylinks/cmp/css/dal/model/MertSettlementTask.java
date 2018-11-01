package com.ipaylinks.cmp.css.dal.model;

import java.util.Date;

public class MertSettlementTask {
    /**
     * 主键
     * 表 : T_MERT_SETTLEMENT_TASK
     * 对应字段 : ID
     */
    private String id;

    /**
     * 商户号
     * 表 : T_MERT_SETTLEMENT_TASK
     * 对应字段 : MERCHANT_ID
     */
    private String merchantId;

    /**
     * 结算日期 yyyyMMdd
     * 表 : T_MERT_SETTLEMENT_TASK
     * 对应字段 : SETTLE_DATE
     */
    private String settleDate;

    /**
     * 结算启动时间
     * 表 : T_MERT_SETTLEMENT_TASK
     * 对应字段 : SETTLE_START_TIME
     */
    private String settleStartTime;

    /**
     * 结算结束时间
     * 表 : T_MERT_SETTLEMENT_TASK
     * 对应字段 : SETTLE_COMPLETE_TIME
     */
    private String settleCompleteTime;

    /**
     * 结算规则ID
     * 表 : T_MERT_SETTLEMENT_TASK
     * 对应字段 : SETTLE_RULE_ID
     */
    private String settleRuleId;

    /**
     * 结算状态
     * 表 : T_MERT_SETTLEMENT_TASK
     * 对应字段 : SETTLE_STATUS
     */
    private String settleStatus;

    /**
     * 结算批次号
     * 表 : T_MERT_SETTLEMENT_TASK
     * 对应字段 : SETTLE_BATCH_ID
     */
    private String settleBatchId;

    /**
     * 创建时间
     * 表 : T_MERT_SETTLEMENT_TASK
     * 对应字段 : GMT_CREATE_TIME
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     * 表 : T_MERT_SETTLEMENT_TASK
     * 对应字段 : GMT_UPDATE_TIME
     */
    private Date gmtUpdateTime;

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_TASK.ID：主键
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
     * @return T_MERT_SETTLEMENT_TASK.MERCHANT_ID：商户号
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
     * @return T_MERT_SETTLEMENT_TASK.SETTLE_DATE：结算日期 yyyyMMdd
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
     * @return T_MERT_SETTLEMENT_TASK.SETTLE_START_TIME：结算启动时间
     */
    
    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_TASK.SETTLE_RULE_ID：结算规则ID
     */
    public String getSettleRuleId() {
        return settleRuleId;
    }

    public String getSettleStartTime() {
		return settleStartTime;
	}

	public void setSettleStartTime(String settleStartTime) {
		this.settleStartTime = settleStartTime;
	}

	public String getSettleCompleteTime() {
		return settleCompleteTime;
	}

	public void setSettleCompleteTime(String settleCompleteTime) {
		this.settleCompleteTime = settleCompleteTime;
	}

	/**
     * set method 
     *
     * @param settleRuleId  结算规则ID
     */
    public void setSettleRuleId(String settleRuleId) {
        this.settleRuleId = settleRuleId == null ? null : settleRuleId.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_TASK.SETTLE_STATUS：结算状态
     */
    public String getSettleStatus() {
        return settleStatus;
    }

    /**
     * set method 
     *
     * @param settleStatus  结算状态
     */
    public void setSettleStatus(String settleStatus) {
        this.settleStatus = settleStatus == null ? null : settleStatus.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_TASK.SETTLE_BATCH_ID：结算批次号
     */
    public String getSettleBatchId() {
        return settleBatchId;
    }

    /**
     * set method 
     *
     * @param settleBatchId  结算批次号
     */
    public void setSettleBatchId(String settleBatchId) {
        this.settleBatchId = settleBatchId == null ? null : settleBatchId.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_TASK.GMT_CREATE_TIME：创建时间
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
     * @return T_MERT_SETTLEMENT_TASK.GMT_UPDATE_TIME：更新时间
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