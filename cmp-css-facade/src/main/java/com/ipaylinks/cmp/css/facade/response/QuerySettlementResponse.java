package com.ipaylinks.cmp.css.facade.response;

import com.ipaylinks.common.rpc.BaseResponse;

import java.util.Date;

public class QuerySettlementResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4548293961869063111L;

	/**
     * 商户ID
     */
    private String merchantId;
 
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
	 * 结算币种
	 */
	private String settleCurrency;

	/**
	 * 	结算汇总单编号
	 */
	private String settlementSummaryId;
	
	/**
	 * 汇总状态
	 */
	private String summaryStatus;

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
	private Date settlementDate;

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
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

	public String getSettleCurrency() {
		return settleCurrency;
	}

	public void setSettleCurrency(String settleCurrency) {
		this.settleCurrency = settleCurrency;
	}

	public String getSettlementSummaryId() {
		return settlementSummaryId;
	}

	public void setSettlementSummaryId(String settlementSummaryId) {
		this.settlementSummaryId = settlementSummaryId;
	}

	public String getSummaryStatus() {
		return summaryStatus;
	}

	public void setSummaryStatus(String summaryStatus) {
		this.summaryStatus = summaryStatus;
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

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	
}
