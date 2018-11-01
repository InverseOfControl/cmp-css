package com.ipaylinks.cmp.css.integration.model;

import java.math.BigDecimal;

/**
 * 商户、渠道计费结果
 * @author dapeng.tong
 **/
public class ChargeCalculateResult {

    /**
     * 原查询计费规则请求号
     */
    private String reqId;

    /**
     * 计费规则ID
     */
    private String feeId;
    /**
     * 收费方式
     */
    private String chargeMode;
    /**
     * feeSettlementDate
     */
    private String feeSettlementDate;
    /**
     * 比例费币种
     */
    private String percentCurrency;
    /**
     * 比例费金额
     */
    private BigDecimal percentFee;
    /**
     * 固定费币种
     */
    private String fixedCurrency;
    /**
     * 固定费金额
     */
    private BigDecimal fixedFee;
    /**
     * 处理费币种
     */
    private String dealCurrency;
    /**
     * 处理费金额
     */
    private BigDecimal dealFee;

    /**
     *  收费方式 （内收、外收）
     */
    private String chargeWay;
    
    /**
     *  收费ID
     */
    private java.lang.String calcFeeId;
    public String getChargeWay() {
        return chargeWay;
    }

    public void setChargeWay(String chargeWay) {
        this.chargeWay = chargeWay;
    }

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

    public String getFeeSettlementDate() {
        return feeSettlementDate;
    }

    public void setFeeSettlementDate(String feeSettlementDate) {
        this.feeSettlementDate = feeSettlementDate;
    }

    public String getPercentCurrency() {
        return percentCurrency;
    }

    public void setPercentCurrency(String percentCurrency) {
        this.percentCurrency = percentCurrency;
    }

    public BigDecimal getPercentFee() {
        return percentFee;
    }

    public void setPercentFee(BigDecimal percentFee) {
        this.percentFee = percentFee;
    }

    public String getFixedCurrency() {
        return fixedCurrency;
    }

    public void setFixedCurrency(String fixedCurrency) {
        this.fixedCurrency = fixedCurrency;
    }

    public BigDecimal getFixedFee() {
        return fixedFee;
    }

    public void setFixedFee(BigDecimal fixedFee) {
        this.fixedFee = fixedFee;
    }

    public String getDealCurrency() {
        return dealCurrency;
    }

    public void setDealCurrency(String dealCurrency) {
        this.dealCurrency = dealCurrency;
    }

    public BigDecimal getDealFee() {
        return dealFee;
    }

    public void setDealFee(BigDecimal dealFee) {
        this.dealFee = dealFee;
    }

	public java.lang.String getCalcFeeId() {
		return calcFeeId;
	}

	public void setCalcFeeId(java.lang.String calcFeeId) {
		this.calcFeeId = calcFeeId;
	}
    
}
