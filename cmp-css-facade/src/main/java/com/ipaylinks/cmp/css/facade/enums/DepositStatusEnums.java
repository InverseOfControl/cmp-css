package com.ipaylinks.cmp.css.facade.enums;

public enum DepositStatusEnums {

	/**
	 * 00-未生成
	 */
	INIT("00", "未生成"),
	/**
	 * 01-已生成
	 */
	SUCCESS("01", "已生成"),
	/**
	 * 02-失败
	 */
	FAILED("02", "失败");
	 
	private final String code;
	private final String message;
	
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	private DepositStatusEnums(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
