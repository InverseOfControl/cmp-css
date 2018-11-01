package com.ipaylinks.cmp.css.facade.enums;

public enum SettleServicetypeEnum {
	
	productCode("10","支付产品"), //产品编码
	settleDetail("01", "结算明细"),
	settleOrder("02", "结算单"),
	settleSummary ("03", "结算汇总单");

    private String code;
    private String desc;

    private SettleServicetypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getEnumName() {
        return this.getEnumName();
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
