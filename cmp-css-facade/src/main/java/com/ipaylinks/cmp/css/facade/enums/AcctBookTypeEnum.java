package com.ipaylinks.cmp.css.facade.enums;

/**
 * 记账类型
 * @author zhuxiaoyan
 * @date 2018年4月26日 
 */
public enum AcctBookTypeEnum {
	
	//	[01.记账成功  02.记账失败]
	KEEPACCOUNT("01", "记账"),
	/**02-调帐**/
	ADJUSTMENTACCOUNT("02", "调帐"),
	/**03-红冲**/
	REDFLUSH("03", "红冲"),
	/**
	 * 01-记账
	 */
	ACCOUNT_SUCCESS("01", "记账成功"),
	/**
	 * 02-记账失败
	 */
	ACCOUNT_FAILED("02", "记账失败");
	 
	private final String code;
	private final String message;
	
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	private AcctBookTypeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
