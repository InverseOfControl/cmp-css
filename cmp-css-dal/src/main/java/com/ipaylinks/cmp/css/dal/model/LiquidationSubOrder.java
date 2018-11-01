package com.ipaylinks.cmp.css.dal.model;

import java.math.BigDecimal;
import java.util.Date;

public class LiquidationSubOrder {
    /**
     * 主键，待清算子订单号
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : ID
     */
    private String id;

    /**
     * 清算主订单编号
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : LIQUIDATION_ORDER_ID
     */
    private String liquidationOrderId;

    /**
     * 支付子订单号
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : PAY_SUB_ORDER_ID
     */
    private String paySubOrderId;

    /**
     * 支付方式 01-信用卡支付、02-本地化支付
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : PAY_METHOD
     */
    private String payMethod;

    /**
     * 支付状态 00-未支付 01-支付成功 02-支付失败
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : PAY_STATUS
     */
    private String payStatus;

    /**
     * 交易币种
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : TRANS_CURRENCY
     */
    private String transCurrency;

    /**
     * VISA、MC、JCB、AE、DC，qiwi等
     * 表 : T_LIQUIDATION_SUB_ORDER
     */
    private String payKind;

    /**
     * 信用卡支付：卡Bin对应的国家，本地化支付：本地化国家
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : CARD_COUNTRY
     */
    private String cardCountry;

    /**
     * 卡类型 01-信用卡、02-借记卡，信用卡支付必输
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : CARD_TYPE
     */
    private String cardType;

    /**
     * 交易方式 EDC、DCC 信用卡支付必输
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : TRANS_METHOD
     */
    private String transMethod;

    /**
     * 交易模型 3D、非3D，信用卡支付必输
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : TRANS_MODEL
     */
    private String transModel;

    /**
     * 卡号 信用卡支付时必输,保存卡索引
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : CARD_NO
     */
    private String cardNo;

    /**
     * 支付渠道
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : PAY_ORG_CODE
     */
    private String payOrgCode;

    /**
     * 支付币种
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : PAY_CURRENCY
     */
    private String payCurrency;

    /**
     * 支付金额
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : PAY_AMOUNT
     */
    private BigDecimal payAmount;

    /**
     * 支付完成时间
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : PAY_COMPLETE_TIME
     */
    private Date payCompleteTime;

    /**
     * 记账状态 00-未记账 01-已记账 02-记账失败
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : ACCOUNTING_STATUS
     */
    private String accountingStatus;

    /**
     * 差错处理标识 01-正常  02-差错补单
     */
    private String errorHandlingFlag;

    /**
     * 创建时间
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : GMT_CREATE_TIME
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : GMT_UPDATE_TIME
     */
    private Date gmtUpdateTime;
    /**
     * 更新时间
     * 表 : T_LIQUIDATION_SUB_ORDER
     * 对应字段 : CHANNEL_ORDER_NO
     */
    private String channelOrderNo;

    public String getErrorHandlingFlag() {
        return errorHandlingFlag;
    }

    public void setErrorHandlingFlag(String errorHandlingFlag) {
        this.errorHandlingFlag = errorHandlingFlag;
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.ID：主键，待清算子订单号
     */
    public String getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  主键，待清算子订单号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.LIQUIDATION_ORDER_ID：清算主订单编号
     */
    public String getLiquidationOrderId() {
        return liquidationOrderId;
    }

    /**
     * set method 
     *
     * @param liquidationOrderId  清算主订单编号
     */
    public void setLiquidationOrderId(String liquidationOrderId) {
        this.liquidationOrderId = liquidationOrderId == null ? null : liquidationOrderId.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.PAY_SUB_ORDER_ID：支付子订单号
     */
    public String getPaySubOrderId() {
        return paySubOrderId;
    }

    /**
     * set method 
     *
     * @param paySubOrderId  支付子订单号
     */
    public void setPaySubOrderId(String paySubOrderId) {
        this.paySubOrderId = paySubOrderId == null ? null : paySubOrderId.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.PAY_METHOD：支付方式 01-信用卡支付、02-本地化支付
     */
    public String getPayMethod() {
        return payMethod;
    }

    /**
     * set method 
     *
     * @param payMethod  支付方式 01-信用卡支付、02-本地化支付
     */
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod == null ? null : payMethod.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.PAY_STATUS：支付状态 00-未支付 01-支付成功 02-支付失败
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * set method 
     *
     * @param payStatus  支付状态 00-未支付 01-支付成功 02-支付失败
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.TRANS_CURRENCY：交易币种
     */
    public String getTransCurrency() {
        return transCurrency;
    }

    /**
     * set method 
     *
     * @param transCurrency  交易币种
     */
    public void setTransCurrency(String transCurrency) {
        this.transCurrency = transCurrency == null ? null : transCurrency.trim();
    }

    public String getPayKind() {
        return payKind;
    }

    public void setPayKind(String payKind) {
        this.payKind = payKind;
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.CARD_COUNTRY：信用卡支付：卡Bin对应的国家，本地化支付：本地化国家
     */
    public String getCardCountry() {
        return cardCountry;
    }

    /**
     * set method 
     *
     * @param cardCountry  信用卡支付：卡Bin对应的国家，本地化支付：本地化国家
     */
    public void setCardCountry(String cardCountry) {
        this.cardCountry = cardCountry == null ? null : cardCountry.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.CARD_TYPE：卡类型 01-信用卡、02-借记卡，信用卡支付必输
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * set method 
     *
     * @param cardType  卡类型 01-信用卡、02-借记卡，信用卡支付必输
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.TRANS_METHOD：交易方式 EDC、DCC 信用卡支付必输
     */
    public String getTransMethod() {
        return transMethod;
    }

    /**
     * set method 
     *
     * @param transMethod  交易方式 EDC、DCC 信用卡支付必输
     */
    public void setTransMethod(String transMethod) {
        this.transMethod = transMethod == null ? null : transMethod.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.TRANS_MODEL：交易模型 3D、非3D，信用卡支付必输
     */
    public String getTransModel() {
        return transModel;
    }

    /**
     * set method 
     *
     * @param transModel  交易模型 3D、非3D，信用卡支付必输
     */
    public void setTransModel(String transModel) {
        this.transModel = transModel == null ? null : transModel.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.CARD_NO：卡号 信用卡支付时必输,保存卡索引
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * set method 
     *
     * @param cardNo  卡号 信用卡支付时必输,保存卡索引
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.PAY_ORG_CODE：支付渠道
     */
    public String getPayOrgCode() {
        return payOrgCode;
    }

    /**
     * set method 
     *
     * @param payOrgCode  支付渠道
     */
    public void setPayOrgCode(String payOrgCode) {
        this.payOrgCode = payOrgCode == null ? null : payOrgCode.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.PAY_CURRENCY：支付币种
     */
    public String getPayCurrency() {
        return payCurrency;
    }

    /**
     * set method 
     *
     * @param payCurrency  支付币种
     */
    public void setPayCurrency(String payCurrency) {
        this.payCurrency = payCurrency == null ? null : payCurrency.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.PAY_AMOUNT：支付金额
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * set method 
     *
     * @param payAmount  支付金额
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.PAY_COMPLETE_TIME：支付完成时间
     */
    public Date getPayCompleteTime() {
        return payCompleteTime;
    }

    /**
     * set method 
     *
     * @param payCompleteTime  支付完成时间
     */
    public void setPayCompleteTime(Date payCompleteTime) {
        this.payCompleteTime = payCompleteTime;
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.ACCOUNTING_STATUS：记账状态 00-未记账 01-已记账 02-记账失败
     */
    public String getAccountingStatus() {
        return accountingStatus;
    }

    /**
     * set method 
     *
     * @param accountingStatus  记账状态 00-未记账 01-已记账 02-记账失败
     */
    public void setAccountingStatus(String accountingStatus) {
        this.accountingStatus = accountingStatus == null ? null : accountingStatus.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.GMT_CREATE_TIME：创建时间
     */
    public Date getGmtCreateTime() {
        return gmtCreateTime;
    }

    /**
     * set method 
     *
     * @param gmtCreateTime  创建时间
     */
    public void setGmtCreateTime(Date gmtCreateTime) {
        this.gmtCreateTime = gmtCreateTime;
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_SUB_ORDER.GMT_UPDATE_TIME：更新时间
     */
    public Date getGmtUpdateTime() {
        return gmtUpdateTime;
    }

    /**
     * set method 
     *
     * @param gmtUpdateTime  更新时间
     */
    public void setGmtUpdateTime(Date gmtUpdateTime) {
        this.gmtUpdateTime = gmtUpdateTime;
    }

	public String getChannelOrderNo() {
		return channelOrderNo;
	}

	public void setChannelOrderNo(String channelOrderNo) {
		this.channelOrderNo = channelOrderNo;
	}
    
    
}
