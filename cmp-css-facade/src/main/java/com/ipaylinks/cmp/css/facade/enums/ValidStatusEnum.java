package com.ipaylinks.cmp.css.facade.enums;

public enum ValidStatusEnum {

	YES("0", "有效"),
    NO("1", "无效");
  
    private String code;
    private String desc;

    private ValidStatusEnum(String code, String desc) {
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
