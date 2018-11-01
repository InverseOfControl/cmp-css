package com.ipaylinks.cmp.css.integration.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 记账规则信息
 * @author chen_yq
 * @date 2018.4.24
 */
public class RuleRecordDto implements Serializable{
	private static final long serialVersionUID = 4805392224541384404L;
    /**支付服务编码**/
    private Integer psCode;
    /**借贷方向**/
    private String dcDirection;
    /**科目号**/
    private Long titleNo;
    /**币种类型**/
    private String currencyType;
    /**金额类型**/
    private String financeType;
    /**账户类型**/
    private String accountType;
    public RuleRecordDto () {}

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

	public Long getTitleNo() {
		return titleNo;
	}

	public void setTitleNo(Long titleNo) {
		this.titleNo = titleNo;
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

	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}
}
