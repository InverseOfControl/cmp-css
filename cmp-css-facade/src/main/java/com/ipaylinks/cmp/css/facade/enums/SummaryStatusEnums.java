package com.ipaylinks.cmp.css.facade.enums;

public enum SummaryStatusEnums {

	INIT("00","未汇总"),
	SUCCESS("01", "已汇总"),
	FAILED("02", "失败");

    private String code;
    private String desc;

    private SummaryStatusEnums(String code, String desc) {
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
