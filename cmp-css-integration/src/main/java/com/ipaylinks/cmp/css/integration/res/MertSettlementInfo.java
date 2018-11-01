package com.ipaylinks.cmp.css.integration.res;

import java.math.BigDecimal;

/**
 * 商户配置结算属性和保证金属性响应对象
 */
public class MertSettlementInfo {

    /**
     * 商户结算日期（yyyyMMdd）
     */
    private String mertSettlementDate;
    /**
     * 结算币种
     */
    private String settlementCurrencys;
    /**
     * 起始结算金额
     */
    private BigDecimal startSettlementMoney;
    /**
     * 保证金额比例
     */
    private Short marginRatio;
    /**
     * 保证金结算周期
     */
    private String marginSettlementCycle;
    /**
     * 保证金结算日类型
     */
    private String marginSettlementDayType;

    /**
     * 保证金结算日
     */
    private Short marginSettlementDay;

    public String getMertSettlementDate() {
        return mertSettlementDate;
    }

    public void setMertSettlementDate(String mertSettlementDate) {
        this.mertSettlementDate = mertSettlementDate;
    }

    public String getSettlementCurrencys() {
        return settlementCurrencys;
    }

    public void setSettlementCurrencys(String settlementCurrencys) {
        this.settlementCurrencys = settlementCurrencys;
    }

    public BigDecimal getStartSettlementMoney() {
        return startSettlementMoney;
    }

    public void setStartSettlementMoney(BigDecimal startSettlementMoney) {
        this.startSettlementMoney = startSettlementMoney;
    }

    public Short getMarginRatio() {
        return marginRatio;
    }

    public void setMarginRatio(Short marginRatio) {
        this.marginRatio = marginRatio;
    }

    public String getMarginSettlementCycle() {
        return marginSettlementCycle;
    }

    public void setMarginSettlementCycle(String marginSettlementCycle) {
        this.marginSettlementCycle = marginSettlementCycle;
    }

    public String getMarginSettlementDayType() {
        return marginSettlementDayType;
    }

    public void setMarginSettlementDayType(String marginSettlementDayType) {
        this.marginSettlementDayType = marginSettlementDayType;
    }

    public Short getMarginSettlementDay() {
        return marginSettlementDay;
    }

    public void setMarginSettlementDay(Short marginSettlementDay) {
        this.marginSettlementDay = marginSettlementDay;
    }
}
