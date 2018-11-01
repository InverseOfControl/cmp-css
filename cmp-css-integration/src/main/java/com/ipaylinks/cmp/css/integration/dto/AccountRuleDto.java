package com.ipaylinks.cmp.css.integration.dto;

import java.io.Serializable;

public class AccountRuleDto implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 2092581573877078177L;
	/**
     * 支付服务编码
     */
    private Integer psCode;
    /**
     * 借贷方向[DR/CR  借/贷]
     */
    private String dcDirection;
    /**
     * 科目号[0 代表任意科目,  用于调帐]
     */
    private Long acctTitle;
    /**
     * 币种类型
     */
    private String currencyType;
    /**
     * 金额类型
     */
    private String financeType;
    /**
     * 账户类型
     */
    private String accountType;
	public Integer getPsCode() {
		return psCode;
	}
	public void setPsCode(Integer psCode) {
		this.psCode = psCode;
	}
	public String getDcDirection() {
		return dcDirection;
	}
	public void setDcDirection(String dcDirection) {
		this.dcDirection = dcDirection;
	}
	public Long getAcctTitle() {
		return acctTitle;
	}
	public void setAcctTitle(Long acctTitle) {
		this.acctTitle = acctTitle;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public String getFinanceType() {
		return financeType;
	}
	public void setFinanceType(String financeType) {
		this.financeType = financeType;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
    
    
    
}
