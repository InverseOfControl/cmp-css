package com.ipaylinks.cmp.css.facade.enums;

public enum FeeEnum {
    freight(99001, "运费"),
    serviceCharge(99002, "服务费"),
    taxation(99003, "税费"),
    otherCharge(99004, "其他费用"),
    refuseFee(99005, "拒付费"),
    transFee(99006, "消费用"),
    fixedChardeFee(99007, "固定费"),
    cashDeposit(98, "保证金"); 

    private int code;
    private String desc;

    private FeeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getEnumName() {
        return this.getEnumName();
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
