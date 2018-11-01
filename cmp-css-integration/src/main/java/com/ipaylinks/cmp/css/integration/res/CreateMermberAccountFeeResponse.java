package com.ipaylinks.cmp.css.integration.res;

import java.util.Date;

import com.ipaylinks.common.rpc.BaseResponse;

public class CreateMermberAccountFeeResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5278740351036261297L;

	/**
	 * 记账状态
	 */
	private String accountingStatus;
	/**
	 * 记账流水号			
	 */
	private String accountingId;	
	/**
	 * 记账时间
	 */
	private Date accountingTime;
	public String getAccountingStatus() {
		return accountingStatus;
	}
	public void setAccountingStatus(String accountingStatus) {
		this.accountingStatus = accountingStatus;
	}
	public String getAccountingId() {
		return accountingId;
	}
	public void setAccountingId(String accountingId) {
		this.accountingId = accountingId;
	}
	public Date getAccountingTime() {
		return accountingTime;
	}
	public void setAccountingTime(Date accountingTime) {
		this.accountingTime = accountingTime;
	}
    
}
