package com.ipaylinks.cmp.css.facade.enums;

/**
 * 记账状态
 */
public enum AccountStatusEnum {
    NO("0", "未记账"),
	SUCCESS("1", "记账成功"),
	FAIL("9", "记账失败");

    private String code;
    private String desc;

    private AccountStatusEnum(String code, String desc) {
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
