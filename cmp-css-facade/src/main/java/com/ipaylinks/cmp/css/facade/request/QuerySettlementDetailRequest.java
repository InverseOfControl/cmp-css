package com.ipaylinks.cmp.css.facade.request;

import com.ipaylinks.common.page.PageBean;
import com.ipaylinks.common.rpc.BaseRequest;
import net.sf.oval.constraint.NotNull;

public class QuerySettlementDetailRequest extends BaseRequest {

	private static final long serialVersionUID = -7800293724092441458L;

    /**
     * 商户ID
     */
    private String merchantId;
    
    /**
     * 商户订单号
     */
    private String merchantOrderId;
    
    /**
     * 支付订单号
     */
    private String orderId;
    
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
	 * 记账状态
	 */
	private String accountingStatus;

	/**
	 * 结算开始日期
	 */
	private String beginSettleDate;

	/**
	 * 结算结束日期
	 */
	private String endSettleDate;

	/**
	 * 分页
	 */
	private PageBean pageBean;

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

	public String getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAccountingStatus() {
		return accountingStatus;
	}

	public void setAccountingStatus(String accountingStatus) {
		this.accountingStatus = accountingStatus;
	}

	public String getBeginSettleDate() {
		return beginSettleDate;
	}

	public void setBeginSettleDate(String beginSettleDate) {
		this.beginSettleDate = beginSettleDate;
	}

	public String getEndSettleDate() {
		return endSettleDate;
	}

	public void setEndSettleDate(String endSettleDate) {
		this.endSettleDate = endSettleDate;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
}
