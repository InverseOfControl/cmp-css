package com.ipaylinks.cmp.css.integration.req;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ipaylinks.cmp.css.integration.dto.RequestAccountingDetails;
import com.ipaylinks.common.rpc.BaseRequest;

/**
 * 记账请求
 * @date 2018.07.27
 */
public class CreateWriteRecordRequest extends BaseRequest {

	private static final long serialVersionUID = 6433048685565800925L;
	private String sysCode;//系统CODE
	private String requestId;//请求流水号
	private String txnOrderNo;//交易订单号[提现订单号,网关订单号,渠道订单号]
	private String orderType;//订单类型
	private String sysTraceNo;//系统流水号[网关订单号]
	private String bookType;//记账类型[01-记账,02-调帐]
	private Date txnTime;//订单支付完成时间
	private String operator;
    private String content;//记账内容
	private List<RequestAccountingDetails> records;

	public CreateWriteRecordRequest () {}
	
	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getTxnOrderNo() {
		return txnOrderNo;
	}

	public void setTxnOrderNo(String txnOrderNo) {
		this.txnOrderNo = txnOrderNo;
	}

	public String getSysTraceNo() {
		return sysTraceNo;
	}

	public void setSysTraceNo(String sysTraceNo) {
		this.sysTraceNo = sysTraceNo;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public Date getTxnTime() {
		return txnTime;
	}

	public void setTxnTime(Date txnTime) {
		this.txnTime = txnTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<RequestAccountingDetails> getRecords() {
		return records;
	}

	public void setRecords(List<RequestAccountingDetails> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}

}
