package com.ipaylinks.cmp.css.integration.model;

import java.math.BigDecimal;

/**
 * 算费计算费用基础参数
 * @author dapeng.tong
 **/
public class ChargeCalculateParam {

    /**
     * 计费规则ID
     */
    private String feeId;

    /**
     * 交易完成日期
     */
    private String requestTime;

    /**
     * 单笔金额
     */
    private BigDecimal singleAmount;

    /**
    * 总金额
    */
    private BigDecimal totleAmount;

    /**
     * 总笔数
     */
    private Long totleCount;

    /**
     * 拒付率
     */
    private BigDecimal protestRate;
    /**
     * 拒付总笔数
     */
    private Long protestCount;

    /**
     * 原单笔金额
     */
    private BigDecimal originalTransAmount;

    /**
     * 原比例费
     */
    private BigDecimal originalPercentFee;

    /**
     * 原固定费
     */
    private BigDecimal originalFixedFee;

    /**
     * 已退比例费
     */
    private BigDecimal returnedPercentFee;

    /**
     * 已退固定费
     */
    private BigDecimal returnedFixedFee;

    /**
     * 已退金额
     */
    private BigDecimal returnedAmount;


    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public BigDecimal getSingleAmount() {
        return singleAmount;
    }

    public void setSingleAmount(BigDecimal singleAmount) {
        this.singleAmount = singleAmount;
    }

    public BigDecimal getTotleAmount() {
        return totleAmount;
    }

    public void setTotleAmount(BigDecimal totleAmount) {
        this.totleAmount = totleAmount;
    }

    public Long getTotleCount() {
        return totleCount;
    }

    public void setTotleCount(Long totleCount) {
        this.totleCount = totleCount;
    }

    public BigDecimal getProtestRate() {
        return protestRate;
    }

    public void setProtestRate(BigDecimal protestRate) {
        this.protestRate = protestRate;
    }

    public Long getProtestCount() {
        return protestCount;
    }

    public void setProtestCount(Long protestCount) {
        this.protestCount = protestCount;
    }

    public BigDecimal getOriginalTransAmount() {
        return originalTransAmount;
    }

    public void setOriginalTransAmount(BigDecimal originalTransAmount) {
        this.originalTransAmount = originalTransAmount;
    }

    public BigDecimal getOriginalPercentFee() {
        return originalPercentFee;
    }

    public void setOriginalPercentFee(BigDecimal originalPercentFee) {
        this.originalPercentFee = originalPercentFee;
    }

    public BigDecimal getOriginalFixedFee() {
        return originalFixedFee;
    }

    public void setOriginalFixedFee(BigDecimal originalFixedFee) {
        this.originalFixedFee = originalFixedFee;
    }

    public BigDecimal getReturnedPercentFee() {
        return returnedPercentFee;
    }

    public void setReturnedPercentFee(BigDecimal returnedPercentFee) {
        this.returnedPercentFee = returnedPercentFee;
    }

    public BigDecimal getReturnedFixedFee() {
        return returnedFixedFee;
    }

    public void setReturnedFixedFee(BigDecimal returnedFixedFee) {
        this.returnedFixedFee = returnedFixedFee;
    }

    public BigDecimal getReturnedAmount() {
        return returnedAmount;
    }

    public void setReturnedAmount(BigDecimal returnedAmount) {
        this.returnedAmount = returnedAmount;
    }
}
