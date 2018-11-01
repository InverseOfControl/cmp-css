package com.ipaylinks.cmp.css.facade.response;

import com.ipaylinks.common.rpc.BaseResponse;

public class QuerySettlementDetailResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4028069116102863810L;

    /**
     * 商户ID
     */
    private String merchantId;
    
    /**
     * 商户订单号
     */
    private String MERCHANT_ORDER_ID;
    
    /**
     * 支付订单号
     */
    private String ORDER_ID;
    
    /**
     * 交易类型 com.ipaylinks.common.enums.TradeTypeEnum
     */
    private String transType;
    
    /**
     * 金额类型
     */
    private String amountType;

    /**
     * 订单币种
     */
    private String transCurrency;
	
    /**
	 * 费用结算方式
	 */
	private String feeSettleMethod;
	
	/**
	 * 结算币种
	 */
	private String settleCurrency;
	
	/**
	 * 结算单号
	 */
	private String settlementId;
	
	/**
	 * 结算状态
	 */
	private String settleStatus;
	
	/**
	 * 结算日期
	 */
	private String settleTime;

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMERCHANT_ORDER_ID() {
		return MERCHANT_ORDER_ID;
	}

	public void setMERCHANT_ORDER_ID(String mERCHANT_ORDER_ID) {
		MERCHANT_ORDER_ID = mERCHANT_ORDER_ID;
	}

	public String getORDER_ID() {
		return ORDER_ID;
	}

	public void setORDER_ID(String oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getAmountType() {
		return amountType;
	}

	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}

	public String getTransCurrency() {
		return transCurrency;
	}

	public void setTransCurrency(String transCurrency) {
		this.transCurrency = transCurrency;
	}

	public String getFeeSettleMethod() {
		return feeSettleMethod;
	}

	public void setFeeSettleMethod(String feeSettleMethod) {
		this.feeSettleMethod = feeSettleMethod;
	}

	public String getSettleCurrency() {
		return settleCurrency;
	}

	public void setSettleCurrency(String settleCurrency) {
		this.settleCurrency = settleCurrency;
	}

	public String getSettlementId() {
		return settlementId;
	}

	public void setSettlementId(String settlementId) {
		this.settlementId = settlementId;
	}

	public String getSettleStatus() {
		return settleStatus;
	}

	public void setSettleStatus(String settleStatus) {
		this.settleStatus = settleStatus;
	}

	public String getSettleTime() {
		return settleTime;
	}

	public void setSettleTime(String settleTime) {
		this.settleTime = settleTime;
	}


    
}
