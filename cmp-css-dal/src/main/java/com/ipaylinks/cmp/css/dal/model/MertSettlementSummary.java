package com.ipaylinks.cmp.css.dal.model;

import java.math.BigDecimal;
import java.util.Date;

public class MertSettlementSummary {
    /**
     * 主键
     * 表 : T_MERT_SETTLEMENT_SUMMARY
     * 对应字段 : ID
     */
    private String id;

    /**
     * 商户 ID
     * 表 : T_MERT_SETTLEMENT_SUMMARY
     * 对应字段 : MERCHANT_ID
     */
    private String merchantId;

    /**
     * 结算汇总日期yyyyMMdd
     * 表 : T_MERT_SETTLEMENT_SUMMARY
     * 对应字段 : SUMMARY_DATE
     */
    private String summaryDate;

    /**
     * 结算汇总币种
     * 表 : T_MERT_SETTLEMENT_SUMMARY
     * 对应字段 : SUMMARY_CURRENCY
     */
    private String summaryCurrency;

    /**
     * 结算汇总金额
     * 表 : T_MERT_SETTLEMENT_SUMMARY
     * 对应字段 : SUMMARY_AMOUNT
     */
    private BigDecimal summaryAmount;

    /**
     * 结算单开始日期yyyyMMdd
     * 表 : T_MERT_SETTLEMENT_SUMMARY
     * 对应字段 : BEGIN_DATE
     */
    private String beginDate;

    /**
     * 结算单结束日期yyyyMMdd
     * 表 : T_MERT_SETTLEMENT_SUMMARY
     * 对应字段 : END_DATE
     */
    private String endDate;

    /**
     * 是否自动出款
     * 表 : T_MERT_SETTLEMENT_SUMMARY
     * 对应字段 : AUTO_WITHDRAW_FLAG
     */
    private String autoWithdrawFlag;

    /**
     * 出款状态
     * 表 : T_MERT_SETTLEMENT_SUMMARY
     * 对应字段 : WITHDRAW_STATUS
     */
    private String withdrawStatus;

    /**
     * 出款流水号
     * 表 : T_MERT_SETTLEMENT_SUMMARY
     * 对应字段 : WITHDRAW_ID
     */
    private String withdrawId;

    /**
     * 出款请求时间
     * 表 : T_MERT_SETTLEMENT_SUMMARY
     * 对应字段 : WITHDRAW_REQUEST_TIME
     */
    private Date withdrawRequestTime;

    /**
     * 出款完成时间
     * 表 : T_MERT_SETTLEMENT_SUMMARY
     * 对应字段 : WITHDRAW_COMPLETE_TIME
     */
    private Date withdrawCompleteTime;

    /**
     * 创建时间
     * 表 : T_MERT_SETTLEMENT_SUMMARY
     * 对应字段 : GMT_CREATE_TIME
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     * 表 : T_MERT_SETTLEMENT_SUMMARY
     * 对应字段 : GMT_UPDATE_TIME
     */
    private Date gmtUpdateTime;
    
    /**
     * 商户名称
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : MERCHANT_NAME
     */
    private String merchantName;
    
    /**
     * 结算汇总单号
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : SUMMARY_ORDER_ID
     */
    private String summaryOrderId;
    
    /**
     * 结算汇总单号
     * 表 : T_MERT_SETTLEMENT_ORDER
     * 对应字段 : DEAL_STATUS
     */
    private String dealStatus;

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_SUMMARY.ID：主键
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
     * @return T_MERT_SETTLEMENT_SUMMARY.MERCHANT_ID：商户 ID
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * set method 
     *
     * @param merchantId  商户 ID
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_SUMMARY.SUMMARY_DATE：结算汇总日期yyyyMMdd
     */
    public String getSummaryDate() {
        return summaryDate;
    }

    /**
     * set method 
     *
     * @param summaryDate  结算汇总日期yyyyMMdd
     */
    public void setSummaryDate(String summaryDate) {
        this.summaryDate = summaryDate == null ? null : summaryDate.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_SUMMARY.SUMMARY_CURRENCY：结算汇总币种
     */
    public String getSummaryCurrency() {
        return summaryCurrency;
    }

    /**
     * set method 
     *
     * @param summaryCurrency  结算汇总币种
     */
    public void setSummaryCurrency(String summaryCurrency) {
        this.summaryCurrency = summaryCurrency == null ? null : summaryCurrency.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_SUMMARY.SUMMARY_AMOUNT：结算汇总金额
     */
    public BigDecimal getSummaryAmount() {
        return summaryAmount;
    }

    /**
     * set method 
     *
     * @param summaryAmount  结算汇总金额
     */
    public void setSummaryAmount(BigDecimal summaryAmount) {
        this.summaryAmount = summaryAmount;
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_SUMMARY.BEGIN_DATE：结算单开始日期yyyyMMdd
     */
    public String getBeginDate() {
        return beginDate;
    }

    /**
     * set method 
     *
     * @param beginDate  结算单开始日期yyyyMMdd
     */
    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate == null ? null : beginDate.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_SUMMARY.END_DATE：结算单结束日期yyyyMMdd
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * set method 
     *
     * @param endDate  结算单结束日期yyyyMMdd
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_SUMMARY.AUTO_WITHDRAW_FLAG：是否自动出款
     */
    public String getAutoWithdrawFlag() {
        return autoWithdrawFlag;
    }

    /**
     * set method 
     *
     * @param autoWithdrawFlag  是否自动出款
     */
    public void setAutoWithdrawFlag(String autoWithdrawFlag) {
        this.autoWithdrawFlag = autoWithdrawFlag == null ? null : autoWithdrawFlag.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_SUMMARY.WITHDRAW_STATUS：出款状态
     */
    public String getWithdrawStatus() {
        return withdrawStatus;
    }

    /**
     * set method 
     *
     * @param withdrawStatus  出款状态
     */
    public void setWithdrawStatus(String withdrawStatus) {
        this.withdrawStatus = withdrawStatus == null ? null : withdrawStatus.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_SUMMARY.WITHDRAW_ID：出款流水号
     */
    public String getWithdrawId() {
        return withdrawId;
    }

    /**
     * set method 
     *
     * @param withdrawId  出款流水号
     */
    public void setWithdrawId(String withdrawId) {
        this.withdrawId = withdrawId == null ? null : withdrawId.trim();
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_SUMMARY.WITHDRAW_REQUEST_TIME：出款请求时间
     */
    public Date getWithdrawRequestTime() {
        return withdrawRequestTime;
    }

    /**
     * set method 
     *
     * @param withdrawRequestTime  出款请求时间
     */
    public void setWithdrawRequestTime(Date withdrawRequestTime) {
        this.withdrawRequestTime = withdrawRequestTime;
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_SUMMARY.WITHDRAW_COMPLETE_TIME：出款完成时间
     */
    public Date getWithdrawCompleteTime() {
        return withdrawCompleteTime;
    }

    /**
     * set method 
     *
     * @param withdrawCompleteTime  出款完成时间
     */
    public void setWithdrawCompleteTime(Date withdrawCompleteTime) {
        this.withdrawCompleteTime = withdrawCompleteTime;
    }

    /**
     * get method 
     *
     * @return T_MERT_SETTLEMENT_SUMMARY.GMT_CREATE_TIME：创建时间
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
     * @return T_MERT_SETTLEMENT_SUMMARY.GMT_UPDATE_TIME：更新时间
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

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getSummaryOrderId() {
		return summaryOrderId;
	}

	public void setSummaryOrderId(String summaryOrderId) {
		this.summaryOrderId = summaryOrderId;
	}

	public String getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}
    
    
}