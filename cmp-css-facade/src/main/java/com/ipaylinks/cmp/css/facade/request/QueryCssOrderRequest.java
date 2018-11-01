package com.ipaylinks.cmp.css.facade.request;

import java.util.Date;

import com.ipaylinks.common.rpc.BaseRequest;

public class QueryCssOrderRequest extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1837451861161171777L;

	/**
	 * 商户号
	 * */
	private String merchantId;

	/**
	 * 交易类型
	 * */
	private String transType;

	/**
	 * 订单状态
	 * */
	private String transStatus;
	
	/**
	 * 订单币种
	 * */
	private String transCurrency;

	
	/**
	 * 商户订单号
	 * */
	private String merchantOrderId;

	/**
	 * 支付订单号 
	 * */
	private String payOrderId;

	/**
	 * 支付方式
	 * */
	private String payMethod;
	/**
	 * 订单完成日期 
	 * */
	private Date payCompleteTime;
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
	public String getTransStatus() {
		return transStatus;
	}
	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}
	public String getTransCurrency() {
		return transCurrency;
	}
	public void setTransCurrency(String transCurrency) {
		this.transCurrency = transCurrency;
	}
	public String getMerchantOrderId() {
		return merchantOrderId;
	}
	public void setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}
	public String getPayOrderId() {
		return payOrderId;
	}
	public void setPayOrderId(String payOrderId) {
		this.payOrderId = payOrderId;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public Date getPayCompleteTime() {
		return payCompleteTime;
	}
	public void setPayCompleteTime(Date payCompleteTime) {
		this.payCompleteTime = payCompleteTime;
	}
	
	






}
