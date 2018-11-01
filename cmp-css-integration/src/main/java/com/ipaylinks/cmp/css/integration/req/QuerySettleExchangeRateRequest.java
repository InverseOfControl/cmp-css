package com.ipaylinks.cmp.css.integration.req;

import com.ipaylinks.common.rpc.BaseRequest;

public class QuerySettleExchangeRateRequest extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3329707285473874326L;
	
	private String transCurrency;
	
	private String settleCurrency;

	public String getTransCurrency() {
		return transCurrency;
	}

	public void setTransCurrency(String transCurrency) {
		this.transCurrency = transCurrency;
	}

	public String getSettleCurrency() {
		return settleCurrency;
	}

	public void setSettleCurrency(String settleCurrency) {
		this.settleCurrency = settleCurrency;
	}
	
	

}
