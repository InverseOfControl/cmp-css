package com.ipaylinks.cmp.css.facade.enums;

/**
 * 用户类型
 * @author zhuxiaoyan
 * @date 2018年4月20日 
 */
public enum AcctUserTypeEnum {

	//	01-商户、02-个人、03-内部
	/**用户类型：01-商户**/
	MERCHANT("01", "商户"),
	/**02-个人**/
	PERSONAL("02", "个人"),
	/**03-内部**/
	INNER("03", "内部");
	
	private final String code;
	private final String message;
	
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	private AcctUserTypeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

}
