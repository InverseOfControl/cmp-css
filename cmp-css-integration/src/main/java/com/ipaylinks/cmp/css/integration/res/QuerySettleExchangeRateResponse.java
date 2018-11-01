package com.ipaylinks.cmp.css.integration.res;

import java.math.BigDecimal;

import com.ipaylinks.common.rpc.BaseResponse;

public class QuerySettleExchangeRateResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2474988960889017275L;

	private BigDecimal exchangeRate;

	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	
	

}
