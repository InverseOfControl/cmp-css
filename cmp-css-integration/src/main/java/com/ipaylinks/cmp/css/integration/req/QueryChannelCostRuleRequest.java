package com.ipaylinks.cmp.css.integration.req;

import com.ipaylinks.common.rpc.BaseRequest;

public class QueryChannelCostRuleRequest extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8140850990519425929L;

	/**
	 * 渠道号	字符	M	
	 */
	private String orgCode;
	/**
	 * 交易类型	字符	M	包含：支付、提现、汇款、拒付、退款、退票、授信
	 */
	private String tradeType;
	/**
	 * 地区	字符	O	包括欧盟、非欧盟，送参数时需要注意不同卡组织对欧盟的非欧盟的定义
	 */
	private String region;
	/**
	 * 国家	字符	O	国家二字码，如：US
	 */
	private String countryCode;
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
	private String accountType;
	/**
	 * 币种	字符	O	货币字母代码，如：USD
	 */
	private String currencyCode;
	/**
	 * 交易模型	字符	O	包含：3D、非3D
	 */
	private String tradeModel;
	/**
	 * 二级商户号	字符	O	渠道根据不同维度（如币种）关联的二级商户号
	 */
	private String secondaryAccount;
	/**
	 * 子渠道	字符	O	渠道对应的子渠道
	 */
	private String subChannelCode;
	 
	 
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
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
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getTradeModel() {
		return tradeModel;
	}
	public void setTradeModel(String tradeModel) {
		this.tradeModel = tradeModel;
	}
	public String getSecondaryAccount() {
		return secondaryAccount;
	}
	public void setSecondaryAccount(String secondaryAccount) {
		this.secondaryAccount = secondaryAccount;
	}
	public String getSubChannelCode() {
		return subChannelCode;
	}
	public void setSubChannelCode(String subChannelCode) {
		this.subChannelCode = subChannelCode;
	}

}
