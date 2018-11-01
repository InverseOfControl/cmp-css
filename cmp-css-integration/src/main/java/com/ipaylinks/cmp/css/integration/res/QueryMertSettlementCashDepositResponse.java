package com.ipaylinks.cmp.css.integration.res;

import com.ipaylinks.common.rpc.BaseResponse;

import java.math.BigDecimal;

public class QueryMertSettlementCashDepositResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1875041121166387661L;
	
	private Short percent;
	
	private String returnDate ;
	
	private String returnCycle;
	
	private String returnType;
	
	private BigDecimal settleAmount;

	public Short getPercent() {
		return percent;
	}

	public void setPercent(Short percent) {
		this.percent = percent;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getReturnCycle() {
		return returnCycle;
	}

	public void setReturnCycle(String returnCycle) {
		this.returnCycle = returnCycle;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public BigDecimal getSettleAmount() {
		return settleAmount;
	}

	public void setSettleAmount(BigDecimal settleAmount) {
		this.settleAmount = settleAmount;
	}
	
	
}
