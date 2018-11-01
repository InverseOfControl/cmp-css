package com.ipaylinks.cmp.css.facade.enums;

public enum ErrorHandingFlagEnum {

	/**
	 * 01-正常
	 */
	YES("01", "正常"),
	/**
	 * 02-补单
	 */
	NO("02", "补单");
	 
	private final String code;
	private final String message;
	
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	private ErrorHandingFlagEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
