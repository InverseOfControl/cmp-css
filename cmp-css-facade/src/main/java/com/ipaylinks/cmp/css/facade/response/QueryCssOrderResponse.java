package com.ipaylinks.cmp.css.facade.response;

import java.util.Date;

import com.ipaylinks.common.rpc.BaseResponse;

public class QueryCssOrderResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7653908842004664769L;
	/**
	 * 商户号
	 * */
	private String merchantId;

	/**
	 * 商户名称
	 * */
	private  String  merchantName;

	/**
	 * 交易类型
	 * */
	private String transType;

	/**
	 * 订单状态
	 * */
	private String transStatus;
	

	/**
	 * 支付方式
	 * */
	private String payMethod;

	/**
	 * 商户订单号
	 * */
	private String merchantOrderId;

	/**
	 * 支付订单号 
	 * */
	private String payOrderId;

	/**
	 * 订单币种
	 * */
	private String transCurrency;

	/**
	 * 
	订单金额
	 * */
	private String transAmount;

	/**
	 * 原支付订单号
	 * */
	private String oriPayOrderId;

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

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
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

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
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

	public String getTransCurrency() {
		return transCurrency;
	}

	public void setTransCurrency(String transCurrency) {
		this.transCurrency = transCurrency;
	}

	public String getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(String transAmount) {
		this.transAmount = transAmount;
	}

	public String getOriPayOrderId() {
		return oriPayOrderId;
	}

	public void setOriPayOrderId(String oriPayOrderId) {
		this.oriPayOrderId = oriPayOrderId;
	}

	public Date getPayCompleteTime() {
		return payCompleteTime;
	}

	public void setPayCompleteTime(Date payCompleteTime) {
		this.payCompleteTime = payCompleteTime;
	}

    
}
