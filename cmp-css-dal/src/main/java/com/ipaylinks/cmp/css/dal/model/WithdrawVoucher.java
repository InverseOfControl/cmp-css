package com.ipaylinks.cmp.css.dal.model;

import java.math.BigDecimal;
import java.util.Date;

public class WithdrawVoucher {
    /**
     * 表 : T_WITHDRAW_VOUCHER
     * 对应字段 : ID
     */
    private String id;

    /**
     * 商户ID
     * 表 : T_WITHDRAW_VOUCHER
     * 对应字段 : MERCHANT_ID
     */
    private String merchantId;

    /**
     * 结算出款时间
     * 表 : T_WITHDRAW_VOUCHER
     * 对应字段 : FUNDOUT_TIME
     */
    private Date fundoutTime;

    /**
     * 结算出款币种
     * 表 : T_WITHDRAW_VOUCHER
     * 对应字段 : FUNDOUT_CURRENCY_CODE
     */
    private String fundoutCurrencyCode;

    /**
     * 结算出款金额
     * 表 : T_WITHDRAW_VOUCHER
     * 对应字段 : FUNDOUT_AMOUNT
     */
    private BigDecimal fundoutAmount;

    /**
     * 结算单开始日期yyyyMMdd
     * 表 : T_WITHDRAW_VOUCHER
     * 对应字段 : BEGIN_DATE
     */
    private String beginDate;

    /**
     * 结算单结束日期yyyyMMdd
     * 表 : T_WITHDRAW_VOUCHER
     * 对应字段 : END_DATE
     */
    private String endDate;

    /**
     * 出款类型
     * 表 : T_WITHDRAW_VOUCHER
     * 对应字段 : FUNDOUT_TYPE
     */
    private String fundoutType;

    /**
     * 是否自动出款
     * 表 : T_WITHDRAW_VOUCHER
     * 对应字段 : AUTO_FUNDOUT_FLAG
     */
    private String autoFundoutFlag;

    /**
     * 出款状态
     * 表 : T_WITHDRAW_VOUCHER
     * 对应字段 : FUNDOUT_STATUS
     */
    private String fundoutStatus;

    /**
     * 出款流水号
     * 表 : T_WITHDRAW_VOUCHER
     * 对应字段 : FUNDOUT_ID
     */
    private String fundoutId;

    /**
     * 出款请求时间
     * 表 : T_WITHDRAW_VOUCHER
     * 对应字段 : FUNDOUT_REQUEST_TIME
     */
    private Date fundoutRequestTime;

    /**
     * 出款完成时间
     * 表 : T_WITHDRAW_VOUCHER
     * 对应字段 : FUNDOUT_COMPLETE_TIME
     */
    private Date fundoutCompleteTime;

    /**
     * 创建时间
     * 表 : T_WITHDRAW_VOUCHER
     * 对应字段 : GMT_CREATE_TIME
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     * 表 : T_WITHDRAW_VOUCHER
     * 对应字段 : GMT_UPDATE_TIME
     */
    private Date gmtUpdateTime;

    /**
     * get method 
     *
     * @return T_WITHDRAW_VOUCHER.ID：null
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
     * @return T_WITHDRAW_VOUCHER.MERCHANT_ID：商户ID
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
     * @return T_WITHDRAW_VOUCHER.FUNDOUT_TIME：结算出款时间
     */
    public Date getFundoutTime() {
        return fundoutTime;
    }

    /**
     * set method 
     *
     * @param fundoutTime  结算出款时间
     */
    public void setFundoutTime(Date fundoutTime) {
        this.fundoutTime = fundoutTime;
    }

    /**
     * get method 
     *
     * @return T_WITHDRAW_VOUCHER.FUNDOUT_CURRENCY_CODE：结算出款币种
     */
    public String getFundoutCurrencyCode() {
        return fundoutCurrencyCode;
    }

    /**
     * set method 
     *
     * @param fundoutCurrencyCode  结算出款币种
     */
    public void setFundoutCurrencyCode(String fundoutCurrencyCode) {
        this.fundoutCurrencyCode = fundoutCurrencyCode == null ? null : fundoutCurrencyCode.trim();
    }

    /**
     * get method 
     *
     * @return T_WITHDRAW_VOUCHER.FUNDOUT_AMOUNT：结算出款金额
     */
    public BigDecimal getFundoutAmount() {
        return fundoutAmount;
    }

    /**
     * set method 
     *
     * @param fundoutAmount  结算出款金额
     */
    public void setFundoutAmount(BigDecimal fundoutAmount) {
        this.fundoutAmount = fundoutAmount;
    }

    /**
     * get method 
     *
     * @return T_WITHDRAW_VOUCHER.BEGIN_DATE：结算单开始日期yyyyMMdd
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
     * @return T_WITHDRAW_VOUCHER.END_DATE：结算单结束日期yyyyMMdd
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
     * @return T_WITHDRAW_VOUCHER.FUNDOUT_TYPE：出款类型
     */
    public String getFundoutType() {
        return fundoutType;
    }

    /**
     * set method 
     *
     * @param fundoutType  出款类型
     */
    public void setFundoutType(String fundoutType) {
        this.fundoutType = fundoutType == null ? null : fundoutType.trim();
    }

    /**
     * get method 
     *
     * @return T_WITHDRAW_VOUCHER.AUTO_FUNDOUT_FLAG：是否自动出款
     */
    public String getAutoFundoutFlag() {
        return autoFundoutFlag;
    }

    /**
     * set method 
     *
     * @param autoFundoutFlag  是否自动出款
     */
    public void setAutoFundoutFlag(String autoFundoutFlag) {
        this.autoFundoutFlag = autoFundoutFlag == null ? null : autoFundoutFlag.trim();
    }

    /**
     * get method 
     *
     * @return T_WITHDRAW_VOUCHER.FUNDOUT_STATUS：出款状态
     */
    public String getFundoutStatus() {
        return fundoutStatus;
    }

    /**
     * set method 
     *
     * @param fundoutStatus  出款状态
     */
    public void setFundoutStatus(String fundoutStatus) {
        this.fundoutStatus = fundoutStatus == null ? null : fundoutStatus.trim();
    }

    /**
     * get method 
     *
     * @return T_WITHDRAW_VOUCHER.FUNDOUT_ID：出款流水号
     */
    public String getFundoutId() {
        return fundoutId;
    }

    /**
     * set method 
     *
     * @param fundoutId  出款流水号
     */
    public void setFundoutId(String fundoutId) {
        this.fundoutId = fundoutId == null ? null : fundoutId.trim();
    }

    /**
     * get method 
     *
     * @return T_WITHDRAW_VOUCHER.FUNDOUT_REQUEST_TIME：出款请求时间
     */
    public Date getFundoutRequestTime() {
        return fundoutRequestTime;
    }

    /**
     * set method 
     *
     * @param fundoutRequestTime  出款请求时间
     */
    public void setFundoutRequestTime(Date fundoutRequestTime) {
        this.fundoutRequestTime = fundoutRequestTime;
    }

    /**
     * get method 
     *
     * @return T_WITHDRAW_VOUCHER.FUNDOUT_COMPLETE_TIME：出款完成时间
     */
    public Date getFundoutCompleteTime() {
        return fundoutCompleteTime;
    }

    /**
     * set method 
     *
     * @param fundoutCompleteTime  出款完成时间
     */
    public void setFundoutCompleteTime(Date fundoutCompleteTime) {
        this.fundoutCompleteTime = fundoutCompleteTime;
    }

    /**
     * get method 
     *
     * @return T_WITHDRAW_VOUCHER.GMT_CREATE_TIME：创建时间
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
     * @return T_WITHDRAW_VOUCHER.GMT_UPDATE_TIME：更新时间
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