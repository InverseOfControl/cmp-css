package com.ipaylinks.cmp.css.facade.enums;

public enum PayTypeEnum {
	
	LocalizedPayment ("02", "本地化支付"),
	CardsAccepted("01", "信用卡支付");

    private String code;
    private String desc;

    private PayTypeEnum(String code, String desc) {
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
