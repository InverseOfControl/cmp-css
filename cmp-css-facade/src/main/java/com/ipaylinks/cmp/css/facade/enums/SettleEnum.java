package com.ipaylinks.cmp.css.facade.enums;

public enum SettleEnum {
	
	OUTSTANDING("00", "未结算"),
	SETTLED("01", "已结算"),
	SETTLEMENTFAILURE ("02", "结算失败");

    private String code;
    private String desc;

    private SettleEnum(String code, String desc) {
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
