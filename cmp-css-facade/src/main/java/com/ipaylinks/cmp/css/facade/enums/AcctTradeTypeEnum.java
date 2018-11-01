package com.ipaylinks.cmp.css.facade.enums;
/**
 * 记账规则，交易类型
 * @author chen_yq
 * @date 2018.04.24
 */
public enum AcctTradeTypeEnum {
	/**01-消费**/
	SALE("01","消费"),
	/**02-预授权完成**/
	CAPTURE("02","预授权完成"),
	/**03-退款**/
	REFUND("03","退款"),
	/**04-拒付**/
	CHANGEBACK("04","拒付");
	private String code;
	private String message;
	private AcctTradeTypeEnum(String code,String message){
		this.code = code;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
