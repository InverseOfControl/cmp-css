package com.ipaylinks.cmp.css.facade.enums;

public enum DealStatusEnum {

	/**
	 * 00-未生成
	 */
	INIT("00", "初始化"),
	/**
	 * 01-已生成
	 */
	SUCCESS("01", "已处理"),
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

	private DealStatusEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
