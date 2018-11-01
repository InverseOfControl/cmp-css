package com.ipaylinks.cmp.css.facade.enums;
/**
 * 账户类型枚举，以会计系统为准
 *
 */
public enum AcctAccountTypeEnum {
	
	/**01-内部**/
	INNER("01","内部"),
	/**02-商户**/
	MERCHANT("02","商户"),
	/**03-个人**/
	PERSONAL("03","个人");
	private final String code;
	private final String message;
	
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	private AcctAccountTypeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
