package com.ipaylinks.cmp.css.facade.enums;

public enum DcDirectionEnum {

	/**
	 * 01-借记
	 */
	DR("DR", "借"),
	/**
	 * 02-贷记
	 */
	CR("CR", "贷");
	 
	private final String code;
	private final String message;
	
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	private DcDirectionEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
