package com.ipaylinks.cmp.css.facade.request;

import java.math.BigDecimal;
import java.util.Date;

import com.ipaylinks.common.rpc.BaseRequest;

public class QueryLiquidationDetailRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1329185763713716795L;

    /**
     * 商户ID
     */
    private String merchantId;

    /**
     * 交易类型 com.ipaylinks.common.enums.TradeTypeEnum
     */
    private String transType;

    /**
     * 交易状态 01-成功、02-失败，支付核心只推送成功的订单，风控推送成功和失败的订单
     */
    private String transStatus;

    /**
     * 交易币种
     */
    private String transCurrency;

    /**
     * 交易金额
     */
    private BigDecimal transAmount;

    /**
     * 支付方式 01-信用卡支付、02-本地化支付
     */
    private String payMethod;
    
	/**
	 * 渠道
	 * */
	private  String  orgCode;

	/**
	 *子渠道
	 * */
	private  String  orgSubCode;

    /**
     * 支付订单号
     */
    private String payOrderId;
    
    /**
     * 支付完成时间
     */
    private Date payCompleteTime;
    
    /**
     *  渠道流水号
     */
    private Date channelOrderId;
    
    /**
     * 渠道返回流水号
     */
    private Date channelReturnId;
    
	
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
	public BigDecimal getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(BigDecimal transAmount) {
		this.transAmount = transAmount;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgSubCode() {
		return orgSubCode;
	}
	public void setOrgSubCode(String orgSubCode) {
		this.orgSubCode = orgSubCode;
	}
	public String getPayOrderId() {
		return payOrderId;
	}
	public void setPayOrderId(String payOrderId) {
		this.payOrderId = payOrderId;
	}
	public Date getPayCompleteTime() {
		return payCompleteTime;
	}
	public void setPayCompleteTime(Date payCompleteTime) {
		this.payCompleteTime = payCompleteTime;
	}
	public Date getChannelOrderId() {
		return channelOrderId;
	}
	public void setChannelOrderId(Date channelOrderId) {
		this.channelOrderId = channelOrderId;
	}
	public Date getChannelReturnId() {
		return channelReturnId;
	}
	public void setChannelReturnId(Date channelReturnId) {
		this.channelReturnId = channelReturnId;
	}
    
}
