package com.ipaylinks.cmp.css.facade.enums;

public enum SettleTypeRule {

	DN("01", "运费"),
    TN("02", "服务费");
  
    private String code;
    private String desc;

    private SettleTypeRule(String code, String desc) {
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
