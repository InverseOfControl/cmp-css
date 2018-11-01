package com.ipaylinks.cmp.css.integration.model;

/**
 * 渠道成本计费策略查询结果对象
 *
 * @author hongxu.gao
 * @date 2018/8/10 10:21
 */
public class ChannelChargeStrategyQueryResult {
    /** 计费规则ID */
    private String feeId;
    /** 计费方式（单笔/批量） */
    private String chargeMode;
    /** 规则类型 */
    private String chargeRule;
    /** 单笔金额 */
    private String singleAmount;
    /** 总金额 */
    private String totalAmount;
    /** 总笔数 */
    private String totalCount;
    /** 拒付率 */
    private String protestRate;
    /** 拒付总笔数 */
    private String protestCount;
    /** 原单笔金额 */
    private String originalTransAmount;
    /** 原比例费 */
    private String originalPercentFee;
    /** 原固定费 */
    private String originalFixedFee;
    /** 已退比例费 */
    private String returnedPercentFee;
    /** 已退固定费 */
    private String returnedFixedFee;

    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }

    public String getChargeMode() {
        return chargeMode;
    }

    public void setChargeMode(String chargeMode) {
        this.chargeMode = chargeMode;
    }

    public String getChargeRule() {
        return chargeRule;
    }

    public void setChargeRule(String chargeRule) {
        this.chargeRule = chargeRule;
    }

    public String getSingleAmount() {
        return singleAmount;
    }

    public void setSingleAmount(String singleAmount) {
        this.singleAmount = singleAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getProtestRate() {
        return protestRate;
    }

    public void setProtestRate(String protestRate) {
        this.protestRate = protestRate;
    }

    public String getProtestCount() {
        return protestCount;
    }

    public void setProtestCount(String protestCount) {
        this.protestCount = protestCount;
    }

    public String getOriginalTransAmount() {
        return originalTransAmount;
    }

    public void setOriginalTransAmount(String originalTransAmount) {
        this.originalTransAmount = originalTransAmount;
    }

    public String getOriginalPercentFee() {
        return originalPercentFee;
    }

    public void setOriginalPercentFee(String originalPercentFee) {
        this.originalPercentFee = originalPercentFee;
    }

    public String getOriginalFixedFee() {
        return originalFixedFee;
    }

    public void setOriginalFixedFee(String originalFixedFee) {
        this.originalFixedFee = originalFixedFee;
    }

    public String getReturnedPercentFee() {
        return returnedPercentFee;
    }

    public void setReturnedPercentFee(String returnedPercentFee) {
        this.returnedPercentFee = returnedPercentFee;
    }

    public String getReturnedFixedFee() {
        return returnedFixedFee;
    }

    public void setReturnedFixedFee(String returnedFixedFee) {
        this.returnedFixedFee = returnedFixedFee;
    }
}
