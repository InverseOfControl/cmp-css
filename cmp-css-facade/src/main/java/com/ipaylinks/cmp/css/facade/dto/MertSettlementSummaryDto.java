package com.ipaylinks.cmp.css.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MertSettlementSummaryDto implements Serializable{

    private static final long serialVersionUID = -8285840798757021949L;

    /**主键*/
    private String id;
    /**商户 ID*/
    private String merchantId;
    /**结算汇总日期yyyyMMdd*/
    private String summaryDate;
    /**结算汇总币种*/
    private String summaryCurrency;
    /**结算汇总金额*/
    private BigDecimal summaryAmount;
    /**结算单开始日期yyyyMMdd*/
    private String beginDate;
    /**结算单结束日期yyyyMMdd*/
    private String endDate;
    /**是否自动出款*/
    private String autoWithdrawFlag;
    /**出款状态*/
    private String withdrawStatus;
    /**出款流水号*/
    private String withdrawId;
    /**出款请求时间*/
    private Date withdrawRequestTime;
    /**出款完成时间*/
    private Date withdrawCompleteTime;
    /**创建时间*/
    private Date gmtCreateTime;
    /**更新时间*/
    private Date gmtUpdateTime;
    /**商户名称*/
    private String merchantName;
    /**结算汇总单号*/
    private String summaryOrderId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getSummaryDate() {
        return summaryDate;
    }

    public void setSummaryDate(String summaryDate) {
        this.summaryDate = summaryDate;
    }

    public String getSummaryCurrency() {
        return summaryCurrency;
    }

    public void setSummaryCurrency(String summaryCurrency) {
        this.summaryCurrency = summaryCurrency;
    }

    public BigDecimal getSummaryAmount() {
        return summaryAmount;
    }

    public void setSummaryAmount(BigDecimal summaryAmount) {
        this.summaryAmount = summaryAmount;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAutoWithdrawFlag() {
        return autoWithdrawFlag;
    }

    public void setAutoWithdrawFlag(String autoWithdrawFlag) {
        this.autoWithdrawFlag = autoWithdrawFlag;
    }

    public String getWithdrawStatus() {
        return withdrawStatus;
    }

    public void setWithdrawStatus(String withdrawStatus) {
        this.withdrawStatus = withdrawStatus;
    }

    public String getWithdrawId() {
        return withdrawId;
    }

    public void setWithdrawId(String withdrawId) {
        this.withdrawId = withdrawId;
    }

    public Date getWithdrawRequestTime() {
        return withdrawRequestTime;
    }

    public void setWithdrawRequestTime(Date withdrawRequestTime) {
        this.withdrawRequestTime = withdrawRequestTime;
    }

    public Date getWithdrawCompleteTime() {
        return withdrawCompleteTime;
    }

    public void setWithdrawCompleteTime(Date withdrawCompleteTime) {
        this.withdrawCompleteTime = withdrawCompleteTime;
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
}
