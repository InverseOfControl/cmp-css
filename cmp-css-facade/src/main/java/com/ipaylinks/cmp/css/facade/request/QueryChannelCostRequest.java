package com.ipaylinks.cmp.css.facade.request;

import com.ipaylinks.common.page.PageBean;
import com.ipaylinks.common.rpc.BaseRequest;

import java.util.Date;

public class QueryChannelCostRequest extends BaseRequest {

	private static final long serialVersionUID = 1009206191652212244L;

	/**
	 * 渠道号
	 */
	private String orgCode;
	/**
	 * 子渠道号
	 */
	private String orgSubCode;
	/**
	 * 支付方式
	 */
	private String payMethod;
	/**
	 * 交易类型
	 */
	private String transType;
	/**
	 * 交易状态
	 */
	private String transStatus;
	/**
	 * 交易币种
	 */
	private String payCurrency;
	/**
	 * 费用收取方式
	 */
	private String chargeCostMethod;
	/**
	 * 开始交易完成时间
	 */
	private Date beginChannelCompleteTime;
	/**
	 * 结束交易完成时间
	 */
	private Date endChannelCompleteTime;
	/**
	 * 开始结算日期
	 */
	private String beginCostSettleDate;
	/**
	 * 结束结算日期
	 */
	private String endCostSettleDate;
	/**
	 * 分页
	 */
	private PageBean pageBean;
	/**
	 * 渠道流水号
	 */
	private String channelOrderId;

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

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
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

	public String getPayCurrency() {
		return payCurrency;
	}

	public void setPayCurrency(String payCurrency) {
		this.payCurrency = payCurrency;
	}

	public String getChargeCostMethod() {
		return chargeCostMethod;
	}

	public void setChargeCostMethod(String chargeCostMethod) {
		this.chargeCostMethod = chargeCostMethod;
	}

	public Date getBeginChannelCompleteTime() {
		return beginChannelCompleteTime;
	}

	public void setBeginChannelCompleteTime(Date beginChannelCompleteTime) {
		this.beginChannelCompleteTime = beginChannelCompleteTime;
	}

	public Date getEndChannelCompleteTime() {
		return endChannelCompleteTime;
	}

	public void setEndChannelCompleteTime(Date endChannelCompleteTime) {
		this.endChannelCompleteTime = endChannelCompleteTime;
	}

	public String getBeginCostSettleDate() {
		return beginCostSettleDate;
	}

	public void setBeginCostSettleDate(String beginCostSettleDate) {
		this.beginCostSettleDate = beginCostSettleDate;
	}

	public String getEndCostSettleDate() {
		return endCostSettleDate;
	}

	public void setEndCostSettleDate(String endCostSettleDate) {
		this.endCostSettleDate = endCostSettleDate;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public String getChannelOrderId() {
		return channelOrderId;
	}

	public void setChannelOrderId(String channelOrderId) {
		this.channelOrderId = channelOrderId;
	}
}
