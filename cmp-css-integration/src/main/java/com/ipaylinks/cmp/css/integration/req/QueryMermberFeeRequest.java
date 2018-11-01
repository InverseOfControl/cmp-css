package com.ipaylinks.cmp.css.integration.req;

import java.util.Date;

import com.ipaylinks.common.rpc.BaseRequest;

public class QueryMermberFeeRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1328780925736603109L;
	
	 /**
     * 商户ID
     */
	private String merchantId;
	 /**
     * 交易类型	字符	M	包含：支付、提现、汇款、拒付、退款、退票、授信
	 */
	private String transType;
	/**
	 * 币种	字符	O	货币字母代码，如：USD
	 */
	private String transCurrency;
	/**
	 * 地区	字符	O	包括欧盟、非欧盟，送参数时需要注意不同卡组织对欧盟的非欧盟的定义
	 */
	private String are;
	/**
	 * 国家	字符	O	国家二字码，如：US
	 */
	private String cardCountry;
	/**
	 * 卡组织	字符	O	包含：VISA、MC、JCB、AE、DC等
	 */
	private String cardOrg;
	/**
	 * 卡类型	字符	O	包含：借记卡、信用卡
	 */
	private String cardType;
	/**
	 * 账户类型	字符	O	包含：对公账户、对私账户
	 */
	private String accType;
	/**
	 * 支付方式	字符	O	包含：信用卡支付、本地化支付
	 */
	private String payMethod;

	/**
	 * 交易方式	字符	O	包含：DCC、EDC
	 */
    private String transMethod;
	/**
	 * 交易模型	字符	O	包含：3D、非3D
	 */
    private String transModel;
	/**
	 * 渠道号	字符	O	系统定义的渠道号
	 */
    private String payOrgCode;
	/**
	 * 到账时效	字符	O	包含：实时、快速、普通
	 */
    private Date dueTime;
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
	public String getTransCurrency() {
		return transCurrency;
	}
	public void setTransCurrency(String transCurrency) {
		this.transCurrency = transCurrency;
	}
	public String getAre() {
		return are;
	}
	public void setAre(String are) {
		this.are = are;
	}
	public String getCardCountry() {
		return cardCountry;
	}
	public void setCardCountry(String cardCountry) {
		this.cardCountry = cardCountry;
	}
	public String getCardOrg() {
		return cardOrg;
	}
	public void setCardOrg(String cardOrg) {
		this.cardOrg = cardOrg;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getTransMethod() {
		return transMethod;
	}
	public void setTransMethod(String transMethod) {
		this.transMethod = transMethod;
	}
	public String getTransModel() {
		return transModel;
	}
	public void setTransModel(String transModel) {
		this.transModel = transModel;
	}
	public String getPayOrgCode() {
		return payOrgCode;
	}
	public void setPayOrgCode(String payOrgCode) {
		this.payOrgCode = payOrgCode;
	}
	public Date getDueTime() {
		return dueTime;
	}
	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}

}
