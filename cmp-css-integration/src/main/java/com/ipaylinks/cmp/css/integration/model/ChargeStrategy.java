package com.ipaylinks.cmp.css.integration.model;

/**
 * 计费策略
 * @author dapeng.tong
 **/
public class ChargeStrategy {

    /**
     * 原查询计费规则请求号
     */
    private String reqId;

    /**
     * 计费规则ID
     */
    private String feeId;
    /**
     * 收费方式, 对于业务系统的单笔计费，如果计费返回是批量，则各费用项均为零
     */
    private String chargeMode;



    /**
     * 包括价格，阶梯价格，阶梯累进价格
     */
    private String chargeRule;
    /**
     * 单笔金额, Y-必输、N-非必输
     */
    private String singleAmount;
    /**
     * 总金额, Y-必输、N-非必输
     */
    private String totleAmount;
    /**
     * 总笔数, Y-必输、N-非必输
     */
    private String totleCount;
    /**
     * 拒付率, Y-必输、N-非必输
     */
    private String protestRate;
    /**
     * 拒付总笔数, Y-必输、N-非必输
     */
    private String protestCount;
    /**
     * 单笔金额, Y-必输、N-非必输
     */
    private String originalTransAmount;
    /**
     * 原单笔金额, Y-必输、N-非必输
     */
    private String originalPercentFee;
    /**
     * 原比例费, Y-必输、N-非必输
     */
    private String originalFixedFee;
    /**
     * 已退比例费, Y-必输、N-非必输
     */
    private String returnedPercentFee;
    /**
     * 已退固定费, Y-必输、N-非必输
     */
    private String returnedFixedFee;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

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

    public String getTotleAmount() {
        return totleAmount;
    }

    public void setTotleAmount(String totleAmount) {
        this.totleAmount = totleAmount;
    }

    public String getTotleCount() {
        return totleCount;
    }

    public void setTotleCount(String totleCount) {
        this.totleCount = totleCount;
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

    @Override
    public String toString() {
        return "ChargeStrategyResponse{" +
                "reqId='" + reqId + '\'' +
                ", feeId='" + feeId + '\'' +
                ", chargeMode='" + chargeMode + '\'' +
                ", chargeRule='" + chargeRule + '\'' +
                ", singleAmount='" + singleAmount + '\'' +
                ", totleAmount='" + totleAmount + '\'' +
                ", totleCount='" + totleCount + '\'' +
                ", protestRate='" + protestRate + '\'' +
                ", protestCount='" + protestCount + '\'' +
                ", originalTransAmount='" + originalTransAmount + '\'' +
                ", originalPercentFee='" + originalPercentFee + '\'' +
                ", originalFixedFee='" + originalFixedFee + '\'' +
                ", returnedPercentFee='" + returnedPercentFee + '\'' +
                ", returnedFixedFee='" + returnedFixedFee + '\'' +
                '}';
    }
}
