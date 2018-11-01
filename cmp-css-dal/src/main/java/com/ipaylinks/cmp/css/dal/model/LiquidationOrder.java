package com.ipaylinks.cmp.css.dal.model;

import java.math.BigDecimal;
import java.util.Date;

public class LiquidationOrder {
    /**
     * 主键，待清算主订单号
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : ID
     */
    private String id;

    /**
     * 商户ID
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : MERCHANT_ID
     */
    private String merchantId;

    /**
     * 商户名称
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : MERCHANT_NAME
     */
    private String merchantName;

    /**
     * 产品编码 01-收单
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : PRODUCT_CODE
     */
    private String productCode;

    /**
     * 交易类型 com.ipaylinks.common.enums.TradeTypeEnum
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : TRANS_TYPE
     */
    private String transType;

    /**
     * 交易状态 01-成功、02-失败，支付核心只推送成功的订单，风控推送成功和失败的订单
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : TRANS_STATUS
     */
    private String transStatus;

    /**
     * 交易币种
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : TRANS_CURRENCY
     */
    private String transCurrency;

    /**
     * 交易金额
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : TRANS_AMOUNT
     */
    private BigDecimal transAmount;

    /**
     * 结算币种
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : SETTLE_CURRENCY
     */
    private String settleCurrency;

    /**
     * 结算日期 yyyyMMdd
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : SETTLE_DATE
     */
    private String settleDate;

    /**
     * 分账信息
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : SUB_ACCOUNT_DATA
     */
    private String subAccountData;

    /**
     * 清算状态 com.ipaylinks.cmp.css.facade.enums.LiquidationStatusEnum
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : STATUS
     */
    private String status;

    /**
     * 费用收取类型 01-单笔 02-批量
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : FEE_TYPE
     */
    private String feeType;

    /**
     * 费用规则ID
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : FEE_ID
     */
    private String feeId;

    /**
     * 费用收取标志 00-未收费 01-已收费
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : FEE_FLAG
     */
    private String feeFlag;

    /**
     * 商户订单号
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : MERCHANT_ORDER_ID
     */
    private String merchantOrderId;

    /**
     * 收单订单号
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : ORDER_ID
     */
    private String orderId;

    /**
     * 支付订单号
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : PAY_ORDER_ID
     */
    private String payOrderId;

    /**
     * 原商户订单号
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : ORI_MERCHANT_ORDER_ID
     */
    private String oriMerchantOrderId;

    /**
     * 原收单订单号
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : ORI_ORDER_ID
     */
    private String oriOrderId;

    /**
     * 原支付订单号
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : ORI_PAY_ORDER_ID
     */
    private String oriPayOrderId;

    /**
     * 支付完成时间
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : PAY_COMPLETE_TIME
     */
    private Date payCompleteTime;

    /**
     * 创建时间
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : GMT_CREATE_TIME
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : GMT_UPDATE_TIME
     */
    private Date gmtUpdateTime;

    /**
     * 支付方式 01-信用卡支付、02-本地化支付
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : PAY_METHOD
     */
    private String payMethod;

    /**
     * 交易方式 EDC、DCC 信用卡支付必输
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : TRANS_METHOD
     */
    private String transMethod;

    /**
     * 支付渠道
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : PAY_ORG_CODE
     */
    private String payOrgCode;

    /**
     * VISA、MC、JCB、AE、DC，qiwi等
     * 表 : T_LIQUIDATION_ORDER
     */
    private String payKind;

    /**
     * 信用卡支付：卡Bin对应的国家二字码，本地化支付：本地化国家
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : CARD_COUNTRY
     */
    private String cardCountry;

    /**
     * 卡类型 01-信用卡、02-借记卡，信用卡支付必输
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : CARD_TYPE
     */
    private String cardType;

    /**
     * 交易模型 3D、非3D，信用卡支付必输
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : TRANS_MODEL
     */
    private String transModel;

    /**
     * 卡号 信用卡支付时必输,保存卡索引
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : CARD_NO
     */
    private String cardNo;

    /**
     * 地区。包括欧盟、非欧盟
     * 表 : T_LIQUIDATION_ORDER
     * 对应字段 : REGION
     */
    private String region;

    /**
     * 是否是最后一笔退款，退款时必传，0：否 1：是
     */
    private String isLastRefund;

    /**
     * 订单开始支付完成时间
     */
    private Date beginPayCompleteTime;
    /**
     * 订单结束支付完成时间
     */
    private Date endPayCompleteTime;
    /**
     * 是否全额退款
     */
    private String isAllRefund;
    
    /**
     *  收费ID
     */
    private java.lang.String calcFeeId;

    public String getIsLastRefund() {
        return isLastRefund;
    }

    public void setIsLastRefund(String isLastRefund) {
        this.isLastRefund = isLastRefund;
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.ID：主键，待清算主订单号
     */
    public String getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  主键，待清算主订单号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.MERCHANT_ID：商户ID
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * set method 
     *
     * @param merchantId  商户ID
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.MERCHANT_NAME：商户名称
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * set method 
     *
     * @param merchantName  商户名称
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.PRODUCT_CODE：产品编码 01-收单
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * set method 
     *
     * @param productCode  产品编码 01-收单
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.TRANS_TYPE：交易类型 com.ipaylinks.common.enums.TradeTypeEnum
     */
    public String getTransType() {
        return transType;
    }

    /**
     * set method 
     *
     * @param transType  交易类型 com.ipaylinks.common.enums.TradeTypeEnum
     */
    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.TRANS_STATUS：交易状态 01-成功、02-失败，支付核心只推送成功的订单，风控推送成功和失败的订单
     */
    public String getTransStatus() {
        return transStatus;
    }

    /**
     * set method 
     *
     * @param transStatus  交易状态 01-成功、02-失败，支付核心只推送成功的订单，风控推送成功和失败的订单
     */
    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus == null ? null : transStatus.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.TRANS_CURRENCY：交易币种
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

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.TRANS_AMOUNT：交易金额
     */
    public BigDecimal getTransAmount() {
        return transAmount;
    }

    /**
     * set method 
     *
     * @param transAmount  交易金额
     */
    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.SETTLE_CURRENCY：结算币种
     */
    public String getSettleCurrency() {
        return settleCurrency;
    }

    /**
     * set method 
     *
     * @param settleCurrency  结算币种
     */
    public void setSettleCurrency(String settleCurrency) {
        this.settleCurrency = settleCurrency == null ? null : settleCurrency.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.SETTLE_DATE：结算日期 yyyyMMdd
     */
    public String getSettleDate() {
        return settleDate;
    }

    /**
     * set method 
     *
     * @param settleDate  结算日期 yyyyMMdd
     */
    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate == null ? null : settleDate.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.SUB_ACCOUNT_DATA：分账信息
     */
    public String getSubAccountData() {
        return subAccountData;
    }

    /**
     * set method 
     *
     * @param subAccountData  分账信息
     */
    public void setSubAccountData(String subAccountData) {
        this.subAccountData = subAccountData == null ? null : subAccountData.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.STATUS：清算状态 com.ipaylinks.cmp.css.facade.enums.LiquidationStatusEnum
     */
    public String getStatus() {
        return status;
    }

    /**
     * set method 
     *
     * @param status  清算状态 com.ipaylinks.cmp.css.facade.enums.LiquidationStatusEnum
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.FEE_TYPE：费用收取类型 01-单笔 02-批量
     */
    public String getFeeType() {
        return feeType;
    }

    /**
     * set method 
     *
     * @param feeType  费用收取类型 01-单笔 02-批量
     */
    public void setFeeType(String feeType) {
        this.feeType = feeType == null ? null : feeType.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.FEE_ID：费用规则ID
     */
    public String getFeeId() {
        return feeId;
    }

    /**
     * set method 
     *
     * @param feeId  费用规则ID
     */
    public void setFeeId(String feeId) {
        this.feeId = feeId == null ? null : feeId.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.FEE_FLAG：费用收取标志 00-未收费 01-已收费
     */
    public String getFeeFlag() {
        return feeFlag;
    }

    /**
     * set method 
     *
     * @param feeFlag  费用收取标志 00-未收费 01-已收费
     */
    public void setFeeFlag(String feeFlag) {
        this.feeFlag = feeFlag == null ? null : feeFlag.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.MERCHANT_ORDER_ID：商户订单号
     */
    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    /**
     * set method 
     *
     * @param merchantOrderId  商户订单号
     */
    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId == null ? null : merchantOrderId.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.ORDER_ID：收单订单号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * set method 
     *
     * @param orderId  收单订单号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.PAY_ORDER_ID：支付订单号
     */
    public String getPayOrderId() {
        return payOrderId;
    }

    /**
     * set method 
     *
     * @param payOrderId  支付订单号
     */
    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId == null ? null : payOrderId.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.ORI_MERCHANT_ORDER_ID：原商户订单号
     */
    public String getOriMerchantOrderId() {
        return oriMerchantOrderId;
    }

    /**
     * set method 
     *
     * @param oriMerchantOrderId  原商户订单号
     */
    public void setOriMerchantOrderId(String oriMerchantOrderId) {
        this.oriMerchantOrderId = oriMerchantOrderId == null ? null : oriMerchantOrderId.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.ORI_ORDER_ID：原收单订单号
     */
    public String getOriOrderId() {
        return oriOrderId;
    }

    /**
     * set method 
     *
     * @param oriOrderId  原收单订单号
     */
    public void setOriOrderId(String oriOrderId) {
        this.oriOrderId = oriOrderId == null ? null : oriOrderId.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.ORI_PAY_ORDER_ID：原支付订单号
     */
    public String getOriPayOrderId() {
        return oriPayOrderId;
    }

    /**
     * set method 
     *
     * @param oriPayOrderId  原支付订单号
     */
    public void setOriPayOrderId(String oriPayOrderId) {
        this.oriPayOrderId = oriPayOrderId == null ? null : oriPayOrderId.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.PAY_COMPLETE_TIME：支付完成时间
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
     * @return T_LIQUIDATION_ORDER.GMT_CREATE_TIME：创建时间
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
     * @return T_LIQUIDATION_ORDER.GMT_UPDATE_TIME：更新时间
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

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.PAY_METHOD：支付方式 01-信用卡支付、02-本地化支付
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
     * @return T_LIQUIDATION_ORDER.TRANS_METHOD：交易方式 EDC、DCC 信用卡支付必输
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
     * @return T_LIQUIDATION_ORDER.PAY_ORG_CODE：支付渠道
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

    public String getPayKind() {
        return payKind;
    }

    public void setPayKind(String payKind) {
        this.payKind = payKind;
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.CARD_COUNTRY：信用卡支付：卡Bin对应的国家二字码，本地化支付：本地化国家
     */
    public String getCardCountry() {
        return cardCountry;
    }

    /**
     * set method 
     *
     * @param cardCountry  信用卡支付：卡Bin对应的国家二字码，本地化支付：本地化国家
     */
    public void setCardCountry(String cardCountry) {
        this.cardCountry = cardCountry == null ? null : cardCountry.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_ORDER.CARD_TYPE：卡类型 01-信用卡、02-借记卡，信用卡支付必输
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
     * @return T_LIQUIDATION_ORDER.TRANS_MODEL：交易模型 3D、非3D，信用卡支付必输
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
     * @return T_LIQUIDATION_ORDER.CARD_NO：卡号 信用卡支付时必输,保存卡索引
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
     * @return T_LIQUIDATION_ORDER.REGION：地区。包括欧盟、非欧盟
     */
    public String getRegion() {
        return region;
    }

    /**
     * set method 
     *
     * @param region  地区。包括欧盟、非欧盟
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public Date getBeginPayCompleteTime() {
        return beginPayCompleteTime;
    }

    public void setBeginPayCompleteTime(Date beginPayCompleteTime) {
        this.beginPayCompleteTime = beginPayCompleteTime;
    }

    public Date getEndPayCompleteTime() {
        return endPayCompleteTime;
    }

    public void setEndPayCompleteTime(Date endPayCompleteTime) {
        this.endPayCompleteTime = endPayCompleteTime;
    }

	public String getIsAllRefund() {
		return isAllRefund;
	}

	public void setIsAllRefund(String isAllRefund) {
		this.isAllRefund = isAllRefund;
	}

	public java.lang.String getCalcFeeId() {
		return calcFeeId;
	}

	public void setCalcFeeId(java.lang.String calcFeeId) {
		this.calcFeeId = calcFeeId;
	}
    
    
}
