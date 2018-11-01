package com.ipaylinks.cmp.css.facade.enums;

public enum RefundStatusEnum {

	YES("1", "是"),
    NO("0", "否");
  
    private String code;
    private String desc;

    private RefundStatusEnum(String code, String desc) {
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
