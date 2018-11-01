package com.ipaylinks.cmp.css.integration.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CreateAccountingAmount implements Serializable {
	private static final long serialVersionUID = -1060051890628122242L;
	/**币种类型**/
	private String currencyType;
	/**币种**/
	private String currency;
	/**金额**/
	private BigDecimal amount;
	
	/**凭证号：[清算子单号/对账子单号...]**/
	private String voucherNo;

	public CreateAccountingAmount () {}

	public CreateAccountingAmount (String currencyType,String currency,BigDecimal amount,String voucherNo) {
		this.currencyType = currencyType;
		this.currency = currency;
		this.amount = amount;
		this.voucherNo = voucherNo;
	}
	
	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}
	
}
