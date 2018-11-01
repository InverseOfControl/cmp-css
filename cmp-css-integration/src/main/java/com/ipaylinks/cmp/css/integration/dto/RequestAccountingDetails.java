package com.ipaylinks.cmp.css.integration.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import net.sf.oval.constraint.NotNull;

/**
 * 记账请求详细
 * 
 * @author zhuxiaoyan
 * @date 2018年4月23日
 */
public class RequestAccountingDetails implements Serializable {

	private static final long serialVersionUID = -6100231729267331213L;
	private String voucherNo;//凭证号
	@NotNull(errorCode = "WRITE_RECORD_DRDIRECTION_CAN_NOT_BE_EMPTY")
	private String drDirection;//借贷方向
	private BigDecimal accountNo;//账户号
	private BigDecimal amount;//金额
	private String currency;//币种
	private BigDecimal cnyAmount;//人民币金额
	private String psCode;//支付服务码
	private String orgCode;//渠道号
	private int group;//用于判断借贷平衡，借方和贷方是否同一组
	
	public RequestAccountingDetails () {}
	
	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	public String getDrDirection() {
		return drDirection;
	}

	public void setDrDirection(String drDirection) {
		this.drDirection = drDirection;
	}

	public BigDecimal getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(BigDecimal accountNo) {
		this.accountNo = accountNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getCnyAmount() {
		return cnyAmount;
	}

	public void setCnyAmount(BigDecimal cnyAmount) {
		this.cnyAmount = cnyAmount;
	}

	public String getPsCode() {
		return psCode;
	}

	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}

}
