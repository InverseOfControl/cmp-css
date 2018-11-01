package com.ipaylinks.cmp.css.facade.enums;

public enum BussTypeEnums {

	/**
	 * 00-结算任务
	 */
	SETTLE_TASK("00", "结算任务"),
	/**
	 * 01-结算明细
	 */
	SETTLE_DETAIL("01", "结算明细"),
	/**
	 * 02-结算单
	 */
	SETTLE_ORDER("02", "结算单"),
	/**
	 * 03-汇总单
	 */
	SETTLE_SUMMARY("03", "汇总单"),
	/**
	 * 04-记账
	 */
	SETTLE_ACCOUNT("04","记账"),
	/**
	 * 05-汇总对账单
	 */
	SETTLE_SUMMARY_BOOK("05","汇总对账单"),
	/**
	 * 01-结算明细
	 */
	SETTLE_DEPOSIT("06","保证金"),
	/**
	 * 01-结算明细
	 */
	SETTLE_ERROR_ORDER("07","异常结算单"),
	/**
	 * 01-异常结算明细
	 */
	SETTLE_ERROR_DETAIL("08", "异常结算明细");
	
    private String code;
    private String desc;

    private BussTypeEnums(String code, String desc) {
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
