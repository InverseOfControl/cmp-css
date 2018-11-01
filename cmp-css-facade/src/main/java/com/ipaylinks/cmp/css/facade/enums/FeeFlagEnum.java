package com.ipaylinks.cmp.css.facade.enums;

/**
 * 费用收取标志
 */
public enum FeeFlagEnum {

	INIT("00", "未收费"),
    RECEIVED("01", "已收费"),
    FAILED("02", "费用收取失败")
    ;

    private String code;
    private String desc;

    private FeeFlagEnum(String code, String desc) {
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
