package com.ipaylinks.cmp.css.facade.dto;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LiquidationSubOrderDTO implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 主键，待清算子订单号
     */
    private String id;

    /**
     * 清算主订单编号
     */
    private String liquidationOrderId;

    /**
     * 支付子订单号
     */
    @NotNull(message = "liquidationSubOrderDTO.paySubOrderId不能为空")
    @NotEmpty(message = "liquidationSubOrderDTO.paySubOrderId不能为空")
    private String paySubOrderId;

    /**
     * 支付方式 01-信用卡支付、02-本地化支付
     */
    private String payMethod;

    /**
     * 支付状态 00-未支付 01-支付成功 02-支付失败
     */
    @NotNull(message = "liquidationSubOrderDTO.payStatus不能为空")
    @NotEmpty(message = "liquidationSubOrderDTO.payStatus不能为空")
    private String payStatus;

    /**
     * 交易币种
     */
    @NotNull(message = "liquidationSubOrderDTO.transCurrency不能为空")
    @NotEmpty(message = "liquidationSubOrderDTO.transCurrency不能为空")
    private String transCurrency;

    /**
     * VISA、MC、JCB、AE、DC，qiwi等
     */
    private String payKind;

    /**
     * 信用卡支付：卡Bin对应的国家，本地化支付：本地化国家
     */
    private String cardCountry;

    /**
     * 卡类型 01-信用卡、02-借记卡，信用卡支付必输
     */
    private String cardType;

    /**
     * 交易方式 EDC、DCC 信用卡支付必输
     */
    private String transMethod;

    /**
     * 交易模型 3D、非3D，信用卡支付必输
     */
    private String transModel;

    /**
     * 卡号 信用卡支付时必输,保存卡索引
     */
    private String cardNo;

    /**
     * 支付渠道
     */
    @NotNull(message = "liquidationSubOrderDTO.payOrgCode不能为空")
    @NotEmpty(message = "liquidationSubOrderDTO.payOrgCode不能为空")
    private String payOrgCode;

    /**
     * 支付币种
     */
    @NotNull(message = "liquidationSubOrderDTO.payCurrency不能为空")
    @NotEmpty(message = "liquidationSubOrderDTO.payCurrency不能为空")
    private String payCurrency;

    /**
     * 支付金额
     */
    @NotNull(message = "liquidationSubOrderDTO.payAmount不能为空")
    private BigDecimal payAmount;

    /**
     * 支付完成时间
     */
    private Date payCompleteTime;

    /**
     * 记账状态 00-未记账 01-已记账 02-记账失败
     */
    private String accountingStatus;

    /**
     * 差错处理标识 01-正常  02-差错补单
     */
    private String errorHandlingFlag;

    /**
     * 创建时间
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     */
    private Date gmtUpdateTime;
    
    private String channelOrderNo;

    public String getErrorHandlingFlag() {
        return errorHandlingFlag;
    }

    public void setErrorHandlingFlag(String errorHandlingFlag) {
        this.errorHandlingFlag = errorHandlingFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLiquidationOrderId() {
        return liquidationOrderId;
    }

    public void setLiquidationOrderId(String liquidationOrderId) {
        this.liquidationOrderId = liquidationOrderId;
    }

    public String getPaySubOrderId() {
        return paySubOrderId;
    }

    public void setPaySubOrderId(String paySubOrderId) {
        this.paySubOrderId = paySubOrderId;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getTransCurrency() {
        return transCurrency;
    }

    public void setTransCurrency(String transCurrency) {
        this.transCurrency = transCurrency;
    }

    public String getPayKind() {
        return payKind;
    }

    public void setPayKind(String payKind) {
        this.payKind = payKind;
    }

    public String getCardCountry() {
        return cardCountry;
    }

    public void setCardCountry(String cardCountry) {
        this.cardCountry = cardCountry;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getPayOrgCode() {
        return payOrgCode;
    }

    public void setPayOrgCode(String payOrgCode) {
        this.payOrgCode = payOrgCode;
    }

    public String getPayCurrency() {
        return payCurrency;
    }

    public void setPayCurrency(String payCurrency) {
        this.payCurrency = payCurrency;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Date getPayCompleteTime() {
        return payCompleteTime;
    }

    public void setPayCompleteTime(Date payCompleteTime) {
        this.payCompleteTime = payCompleteTime;
    }

    public String getAccountingStatus() {
        return accountingStatus;
    }

    public void setAccountingStatus(String accountingStatus) {
        this.accountingStatus = accountingStatus;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public String getChannelOrderNo() {
		return channelOrderNo;
	}

	public void setChannelOrderNo(String channelOrderNo) {
		this.channelOrderNo = channelOrderNo;
	}
    
    
}
