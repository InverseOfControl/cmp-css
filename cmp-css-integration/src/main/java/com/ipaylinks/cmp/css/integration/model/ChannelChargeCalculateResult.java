package com.ipaylinks.cmp.css.integration.model;

import java.math.BigDecimal;

/**
 * 渠道成本计算接口响应参数对象
 *
 * @author hongxu.gao
 * @date 2018/8/10 11:22
 */
public class ChannelChargeCalculateResult {
    /** 计费规则ID */
    private String feeId;
    /** 收费/付费(1-收费，2-付费) */
    private String chargePayType;
    /** 收费方式（01-内收，02-外收） */
    private String chargeWay;
    /** 费用结算日期 */
    private String feeSettlementDate;
    /** 比例费币种 */
    private String percentCurrency;
    /** 比例费金额 */
    private BigDecimal percentFee;
    /** 固定费币种 */
    private String fixedCurrency;
    /** 固定费金额 */
    private BigDecimal fixedFee;
    /** 处理费币种 */
    private String dealCurrency;
    /** 处理费金额 */
    private BigDecimal dealFee;

    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }

    public String getChargePayType() {
        return chargePayType;
    }

    public void setChargePayType(String chargePayType) {
        this.chargePayType = chargePayType;
    }

    public String getChargeWay() {
        return chargeWay;
    }

    public void setChargeWay(String chargeWay) {
        this.chargeWay = chargeWay;
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

    public BigDecimal getPercentFee() {
        return percentFee;
    }

    public void setPercentFee(BigDecimal percentFee) {
        this.percentFee = percentFee;
    }
}
