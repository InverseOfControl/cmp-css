package com.ipaylinks.cmp.css.integration.req;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ipaylinks.cmp.css.integration.dto.CreateAccountingAmount;
import com.ipaylinks.common.rpc.BaseRequest;

public class CreateAccountingRequest extends BaseRequest{
	private static final long serialVersionUID = 3713096826308807367L;

	/**系统CODE**/
	private String sysCode;
	
	/**请求流水号：调用方系统的流水号**/
	private String requestId;
	
	/**系统流水号[acs订单号]，一路透传**/
	private String sysTraceNo;
	
	/**商户订单号**/
	private String merchantOrderNo;
	
	/**交易订单号[支付/提现/退款/清算 订单号...]**/
	private String txnOrderNo;
	
	/**订单支付完成时间**/
	private Date txnTime;
	
	/**记账内容**/
    private String content;
    /**渠道号**/
	private String orgCode;
	
    /**产品code**/
	private String prodCode;
	/**场景code**/
    private String sceneCode;
    /**交易类型**/
    private String tradeType;
    /**金额类型**/
    private String financeType;
    
	/**用户号[商户号]**/
	private String userId;
	/**用户类型**/
	private String userType;
	/**用户名称**/
	private String userName;
	
    private List<CreateAccountingAmount> list;
    
    public CreateAccountingRequest () {}

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

	public String getSysTraceNo() {
		return sysTraceNo;
	}

	public void setSysTraceNo(String sysTraceNo) {
		this.sysTraceNo = sysTraceNo;
	}

	public String getMerchantOrderNo() {
		return merchantOrderNo;
	}

	public void setMerchantOrderNo(String merchantOrderNo) {
		this.merchantOrderNo = merchantOrderNo;
	}

	public String getTxnOrderNo() {
		return txnOrderNo;
	}

	public void setTxnOrderNo(String txnOrderNo) {
		this.txnOrderNo = txnOrderNo;
	}

	public Date getTxnTime() {
		return txnTime;
	}

	public void setTxnTime(Date txnTime) {
		this.txnTime = txnTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getSceneCode() {
		return sceneCode;
	}

	public void setSceneCode(String sceneCode) {
		this.sceneCode = sceneCode;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getFinanceType() {
		return financeType;
	}

	public void setFinanceType(String financeType) {
		this.financeType = financeType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<CreateAccountingAmount> getList() {
		return list;
	}

	public void setList(List<CreateAccountingAmount> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}
}
