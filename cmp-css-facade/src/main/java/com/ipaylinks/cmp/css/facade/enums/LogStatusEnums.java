package com.ipaylinks.cmp.css.facade.enums;

public enum LogStatusEnums {

	/**
	 * 00-新生成
	 */
	INIT("00", "新建"),
	/**
	 * 01-已完成
	 */
	SUCCESS("01", "已完成"),
	/**
	 * 02-失败
	 */
	FAILED("02", "失败");

    private String code;
    private String desc;

    private LogStatusEnums(String code, String desc) {
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
