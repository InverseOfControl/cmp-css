package com.ipaylinks.cmp.css.facade.enums;

public enum TradeCodeEnum {

 	consumptionCode("1002", "消费"),
	preAuthorizationCode("1002", "预授权完成"),
	refundCode("1003", "退款"),
	refuseCode("1012", "拒付");
	
    private String code;
    private String desc;

    private TradeCodeEnum(String code, String desc) {
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
