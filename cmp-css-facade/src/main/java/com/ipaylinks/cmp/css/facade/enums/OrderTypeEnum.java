/**
 * 
 */
package com.ipaylinks.cmp.css.facade.enums;

/**
 * 订单类型
 * @author dapeng.tong
 *
 */
public enum OrderTypeEnum {

	LIQUIDATION("01","清算主订单"),
	RISK("02","风控订单"),
	CHANNEL("03","渠道订单"),
	LIQUIDATION_SUB("04","清算子订单"),
	SETTLEMENT_DETAIL("05","清算子订单")
	
	;
	
	private String code;
	private String desc;
	
	private OrderTypeEnum(String code,String desc){
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
	
	
}
