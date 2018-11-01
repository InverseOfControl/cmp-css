package com.ipaylinks.cmp.css.facade.enums;

public enum WithdrawStatusEnum {

	paidAmount("01", "已出款"),
	unpaidAmount ("02", "未出款"),
	iSAutoWithdraw("01", "自动提现"),
	autoWithdrawFlag("02", "手动提现");

    private String code;
    private String desc;

    private WithdrawStatusEnum(String code, String desc) {
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
