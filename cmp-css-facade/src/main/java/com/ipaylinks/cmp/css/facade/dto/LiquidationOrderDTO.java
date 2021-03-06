package com.ipaylinks.cmp.css.facade.dto;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LiquidationOrderDTO implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 主键，待清算主订单号
     */
    private String id;

    /**
     * 商户ID
     */
    @NotNull(message = "liquidationOrderDTO.merchantId不能为空")
    @NotEmpty(message = "liquidationOrderDTO.merchantId不能为空")
    private String merchantId;

    /**
     * 商户名称
     */
    private String merchantName;

    /**
     * 支付方式 01-信用卡支付、02-本地化支付
     */
    private String payMethod;

    /**
     * 产品编码 01-收单
     */
    private String productCode;

    /**
     * 交易类型 com.ipaylinks.common.enums.TradeTypeEnum
     */
    @NotNull(message = "liquidationOrderDTO.transType不能为空")
    @NotEmpty(message = "liquidationOrderDTO.transType不能为空")
    private String transType;

    /**
     * 交易状态 01-成功、02-失败，支付核心只推送成功的订单，风控推送成功和失败的订单
     */
    @NotNull(message = "liquidationOrderDTO.transStatus不能为空")
    @NotEmpty(message = "liquidationOrderDTO.transStatus不能为空")
    private String transStatus;

    /**
     * 交易币种
     */
    @NotNull(message = "liquidationOrderDTO.transCurrency不能为空")
    @NotEmpty(message = "liquidationOrderDTO.transCurrency不能为空")
    private String transCurrency;

    /**
     * 交易金额
     */
    @NotNull(message = "liquidationOrderDTO.transAmount不能为空")
    private BigDecimal transAmount;

    /**
     * 结算币种
     */
    @NotNull(message = "liquidationOrderDTO.settleCurrency不能为空")
    @NotEmpty(message = "liquidationOrderDTO.settleCurrency不能为空")
    private String settleCurrency;

    /**
     * 是否是最后一笔退款，退款时必传，0：否 1：是
     */
    private String isLastRefund;

    public String getIsLastRefund() {
        return isLastRefund;
    }

    public void setIsLastRefund(String isLastRefund) {
        this.isLastRefund = isLastRefund;
    }

    /**
     * 结算日期 yyyyMMdd
     */
    private String settleDate;

    /**
     * 分账信息
     */
    private String subAccountData;

    /**
     * 清算状态 com.ipaylinks.cmp.css.facade.enums.LiquidationStatusEnum
     */
    private String status;

    /**
     * 费用收取类型 01-单笔 02-批量
     */
    private String feeType;

    /**
     * 费用规则ID
     */
    private String feeId;

    /**
     * 费用收取标志 00-未收费 01-已收费
     */
    private String feeFlag;

    /**
     * 商户订单号
     */
    @NotNull(message = "liquidationOrderDTO.merchantOrderId不能为空")
    @NotEmpty(message = "liquidationOrderDTO.merchantOrderId不能为空")
    private String merchantOrderId;

    /**
     * 收单订单号
     */
    @NotNull(message = "liquidationOrderDTO.orderId不能为空")
    @NotEmpty(message = "liquidationOrderDTO.orderId不能为空")
    private String orderId;

    /**
     * 支付订单号
     */
    @NotNull(message = "liquidationOrderDTO.payOrderId不能为空")
    @NotEmpty(message = "liquidationOrderDTO.payOrderId不能为空")
    private String payOrderId;

    /**
     * 原商户订单号
     */
    private String oriMerchantOrderId;

    /**
     * 原收单订单号
     */
    private String oriOrderId;

    /**
     * 原支付订单号
     */
    private String oriPayOrderId;

    /**
     * 支付完成时间
     */
    private Date payCompleteTime;

    /**
     * 创建时间
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     */
    private Date gmtUpdateTime;

    /**
     * 交易方式 EDC、DCC 信用卡支付必输
     */
    private String transMethod;

    /**
     * 支付渠道
     */
    @NotNull(message = "liquidationOrderDTO.payOrgCode不能为空")
    @NotEmpty(message = "liquidationOrderDTO.payOrgCode不能为空")
    private String payOrgCode;

    /**
     * VISA、MC、JCB、AE、DC，qiwi等
     */
    private String payKind;

    /**
     * 信用卡支付：卡Bin对应的国家二字码，本地化支付：本地化国家
     */
    private String cardCountry;

    /**
     * 卡类型 01-信用卡、02-借记卡，信用卡支付必输
     */
    private String cardType;

    /**
     * 交易模型 3D、非3D，信用卡支付必输
     */
    private String transModel;

    /**
     * 卡号 信用卡支付时必输,保存卡索引
     */
    private String cardNo;

    /**
     * 地区。包括欧盟、非欧盟
     */
    private String region;
    
    /**
     * 是否全额退款
     */
    private  String isAllRefund;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public String getTransCurrency() {
        return transCurrency;
    }

    public void setTransCurrency(String transCurrency) {
        this.transCurrency = transCurrency;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public String getSettleCurrency() {
        return settleCurrency;
    }

    public void setSettleCurrency(String settleCurrency) {
        this.settleCurrency = settleCurrency;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public String getSubAccountData() {
        return subAccountData;
    }

    public void setSubAccountData(String subAccountData) {
        this.subAccountData = subAccountData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }

    public String getFeeFlag() {
        return feeFlag;
    }

    public void setFeeFlag(String feeFlag) {
        this.feeFlag = feeFlag;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getOriMerchantOrderId() {
        return oriMerchantOrderId;
    }

    public void setOriMerchantOrderId(String oriMerchantOrderId) {
        this.oriMerchantOrderId = oriMerchantOrderId;
    }

    public String getOriOrderId() {
        return oriOrderId;
    }

    public void setOriOrderId(String oriOrderId) {
        this.oriOrderId = oriOrderId;
    }

    public String getOriPayOrderId() {
        return oriPayOrderId;
    }

    public void setOriPayOrderId(String oriPayOrderId) {
        this.oriPayOrderId = oriPayOrderId;
    }

    public Date getPayCompleteTime() {
        return payCompleteTime;
    }

    public void setPayCompleteTime(Date payCompleteTime) {
        this.payCompleteTime = payCompleteTime;
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

    public String getTransMethod() {
        return transMethod;
    }

    public void setTransMethod(String transMethod) {
        this.transMethod = transMethod;
    }

    public String getPayOrgCode() {
        return payOrgCode;
    }

    public void setPayOrgCode(String payOrgCode) {
        this.payOrgCode = payOrgCode;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
	public String getIsAllRefund() {
		return isAllRefund;
	}

	public void setIsAllRefund(String isAllRefund) {
		this.isAllRefund = isAllRefund;
	}
}
