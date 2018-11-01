package com.ipaylinks.cmp.css.facade.request;

import com.ipaylinks.common.page.PageBean;
import com.ipaylinks.common.rpc.BaseRequest;
import net.sf.oval.constraint.NotNull;

public class QuerySettlementRequest extends BaseRequest {

	private static final long serialVersionUID = -3495920988163991421L;

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
	private String settlementOrderId;
	
	/**
	 * 记账状态
	 */
	private String accountingStatus;
	
	/**
	 * 结算单开始日期
	 */
	private String orderBeginDate;

	/**
	 * 结算单结束日期
	 */
	private String orderEndDate;

	/**
	 * 分页信息
	 */
	@NotNull(message = "分页信息不能为空")
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

	public String getSettlementOrderId() {
		return settlementOrderId;
	}

	public void setSettlementOrderId(String settlementOrderId) {
		this.settlementOrderId = settlementOrderId;
	}

	public String getAccountingStatus() {
		return accountingStatus;
	}

	public void setAccountingStatus(String accountingStatus) {
		this.accountingStatus = accountingStatus;
	}

	public String getOrderBeginDate() {
		return orderBeginDate;
	}

	public void setOrderBeginDate(String orderBeginDate) {
		this.orderBeginDate = orderBeginDate;
	}

	public String getOrderEndDate() {
		return orderEndDate;
	}

	public void setOrderEndDate(String orderEndDate) {
		this.orderEndDate = orderEndDate;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
}
