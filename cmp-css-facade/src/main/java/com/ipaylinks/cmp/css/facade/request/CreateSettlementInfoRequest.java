package com.ipaylinks.cmp.css.facade.request;

import java.util.Date;

import com.ipaylinks.common.rpc.BaseRequest;

public class CreateSettlementInfoRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5511706160598373783L;

	/**
	 * 商户ID
	 * */
	private  String  merchantId;
	/**
	 * 商户名称
	 * */
	private  String  merchantName;

	/**
	 * 支付方式
	 * */
	private  String  transMethod;

	/**
	 * 国家
	 * */
	private  String  cardCountry;

	/**
	 * 渠道
	 * */
	private  String  orgCode;

	/**
	 *子渠道
	 * */
	private  String  orgSubCode;
 
	/**
	 * 结算周期
	 * */
	private  String  settleMethod;

	/**
	 * 结算日
	 * */
	private  String  settleDate;

	/**
	 * 结算日类型
	 * */
	private  String  settleType;

	/**
	 * 结算币种
	 * */
	private  String  settleCurrency;

	/**
	 * 起结金额
	 * */
	private  String  settleAmount;

	/**
	 * 比例
	 * */
	private  String  proportion;
 
	/**
	 * 归还周期
	 * */
	private  String  returnCycle;
	
	/**
	 * 归还日
	 * */
	private  Date  returnDate ;
	
	/**
	 * 归还日类型
	 * */
	private  String  returnDateType;
 
	
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
	public String getTransMethod() {
		return transMethod;
	}
	public void setTransMethod(String transMethod) {
		this.transMethod = transMethod;
	}
	public String getCardCountry() {
		return cardCountry;
	}
	public void setCardCountry(String cardCountry) {
		this.cardCountry = cardCountry;
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
	public String getSettleMethod() {
		return settleMethod;
	}
	public void setSettleMethod(String settleMethod) {
		this.settleMethod = settleMethod;
	}
	public String getSettleDate() {
		return settleDate;
	}
	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}
	public String getSettleType() {
		return settleType;
	}
	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}
	public String getSettleCurrency() {
		return settleCurrency;
	}
	public void setSettleCurrency(String settleCurrency) {
		this.settleCurrency = settleCurrency;
	}
	public String getSettleAmount() {
		return settleAmount;
	}
	public void setSettleAmount(String settleAmount) {
		this.settleAmount = settleAmount;
	}
	public String getProportion() {
		return proportion;
	}
	public void setProportion(String proportion) {
		this.proportion = proportion;
	}
	public String getReturnCycle() {
		return returnCycle;
	}
	public void setReturnCycle(String returnCycle) {
		this.returnCycle = returnCycle;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public String getReturnDateType() {
		return returnDateType;
	}
	public void setReturnDateType(String returnDateType) {
		this.returnDateType = returnDateType;
	}	
	
}
