package com.ipaylinks.cmp.css.facade.response;

import java.util.Date;
import com.ipaylinks.common.rpc.BaseResponse;

public class QuerySettlementSummaryResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6573676811016930795L;

	/**
     * 商户ID
     */
    private String merchantId;
    
    /**
     * 商户名称
     */
    private String merchantName;
    
	/**
	 * 结算币种
	 */
	private String settleCurrency;

	/**
	 * 	结算汇总单编号
	 */
	private String settlementSummaryId;

	/**
	 * 	是否自动提现
	 */
	private String autoWithdrawFlag;
	
	/**
	 * 	自动提现状态
	 */
	private String withdrawStatus;
	/**
	 * 	结算汇总单日期
	 */
	private Date summaryDate;

    /**
     * 创建时间
     */
    private Date gmtCreateTime;

    /**
     * 最后更新时间
     */
    private Date gmtUpdateTime;

    /**
     * 结算金额
     */
    private String summaryAmount;

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

	public String getSettleCurrency() {
		return settleCurrency;
	}

	public void setSettleCurrency(String settleCurrency) {
		this.settleCurrency = settleCurrency;
	}

	public String getSettlementSummaryId() {
		return settlementSummaryId;
	}

	public void setSettlementSummaryId(String settlementSummaryId) {
		this.settlementSummaryId = settlementSummaryId;
	}

	public String getAutoWithdrawFlag() {
		return autoWithdrawFlag;
	}

	public void setAutoWithdrawFlag(String autoWithdrawFlag) {
		this.autoWithdrawFlag = autoWithdrawFlag;
	}

	public String getWithdrawStatus() {
		return withdrawStatus;
	}

	public void setWithdrawStatus(String withdrawStatus) {
		this.withdrawStatus = withdrawStatus;
	}

	public Date getSummaryDate() {
		return summaryDate;
	}

	public void setSummaryDate(Date summaryDate) {
		this.summaryDate = summaryDate;
	}

	public Date getGmtCreateTime() {
		return gmtCreateTime;
	}

	public void setGmtCreateTime(Date gmtCreateTime) {
		this.gmtCreateTime = gmtCreateTime;
	}

	public Date getGmtUpdateTime() {
		return gmtUpdateTime;
	}

	public void setGmtUpdateTime(Date gmtUpdateTime) {
		this.gmtUpdateTime = gmtUpdateTime;
	}

	public String getSummaryAmount() {
		return summaryAmount;
	}

	public void setSummaryAmount(String summaryAmount) {
		this.summaryAmount = summaryAmount;
	}

}
