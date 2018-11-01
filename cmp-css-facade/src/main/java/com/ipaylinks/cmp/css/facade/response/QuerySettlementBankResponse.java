package com.ipaylinks.cmp.css.facade.response;

import java.util.Date;

import com.ipaylinks.common.rpc.BaseResponse;

public class QuerySettlementBankResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 572097523485257934L;



	/**
	 * 商户ID
	 * */
	private  String  merchantId;
	/**
	 * 商户名称
	 * */
	private  String  merchantName;


	/**
	 * 结算币种
	 * */
	private  String  settleCurrency;

/*账号

账户名称

SWIFT Code

电子联行号

IBAN号

开户行名称-英文

开户行地址-英文

账户行SWIFT Code

状态*/

	/**
	 *创建时间
	 * */
	private  Date  gmtCreateTime;
	
	
	/**
	 *最后更新时间
	 * */
	private  Date  gmtUpdateTime;
	 

}
