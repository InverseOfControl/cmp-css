package com.ipaylinks.cmp.css.facade.enums;

/**
 * 交易状态
 */
public enum TradeStatusEnum {
	SUCCESS("01", "成功"),
	FAIL("02", "失败");

    private String code;
    private String desc;

    private TradeStatusEnum(String code, String desc) {
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
