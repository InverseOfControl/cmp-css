package com.ipaylinks.cmp.css.facade.request;

import com.ipaylinks.common.rpc.BaseRequest;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.Date;

public class ChannelOrderCreateRequest extends BaseRequest{

    private static final long serialVersionUID = -1L;

    /**
     * 商户ID
     */
    @NotNull(message = "merchantId不能为空")
    @NotEmpty(message = "merchantId不能为空")
    private String merchantId;

    /**
     * 商户名称
     */
    private String merchantName;

    /**
     * 交易类型
     */
    @NotNull(message = "transType不能为空")
    @NotEmpty(message = "transType不能为空")
    private String transType;

    /**
     * 交易状态
     */
    @NotNull(message = "transStatus不能为空")
    @NotEmpty(message = "transStatus不能为空")
    private String transStatus;

    /**
     * 支付方式 01-信用卡支付 02-本地化支付
     */
    private String payMethod;

    /**
     * 渠道类型 01-收单
     */
    @NotNull(message = "channelType不能为空")
    @NotEmpty(message = "channelType不能为空")
    private String channelType;

    /**
     * 渠道号
     */
    @NotNull(message = "orgCode不能为空")
    @NotEmpty(message = "orgCode不能为空")
    private String orgCode;

    /**
     * 子渠道号
     */
    private String orgSubCode;

    /**
     *  VISA、MC、JCB、AE、DC，qiwi等
     */
    private String payKind;

    /**
     * 渠道交易币种
     */
    @NotNull(message = "payCurrency不能为空")
    @NotEmpty(message = "payCurrency不能为空")
    private String payCurrency;

    /**
     * 渠道交易金额
     */
    @NotNull(message = "payAmount不能为空")
    private BigDecimal payAmount;

    /**
     * 商户订单号
     */
    @NotNull(message = "merchantOrderId不能为空")
    @NotEmpty(message = "merchantOrderId不能为空")
    private String merchantOrderId;

    /**
     * 收单订单号
     */
    @NotNull(message = "orderId不能为空")
    @NotEmpty(message = "orderId不能为空")
    private String orderId;

    /**
     * 支付订单号
     */
    @NotNull(message = "paymentOrderId不能为空")
    @NotEmpty(message = "paymentOrderId不能为空")
    private String paymentOrderId;

    /**
     * 渠道流水号
     */
    @NotNull(message = "channelOrderId不能为空")
    @NotEmpty(message = "channelOrderId不能为空")
    private String channelOrderId;

    /**
     * 渠道完成时间
     */
    private Date channelCompleteTime;

    /**
     * 渠道返回流水号
     */
    private String channelReturnId;

    /**
     * 成本收取类型
     */
    private String chargeCostType;

    /**
     * 成本收取标志
     */
    private String chargeCostFlag;

    /**
     * 参考号
     */
    private String channelReferenceNo;

    /**
     * 授权号
     */
    private String channelAccessCode;

    /**
     * 原渠道流水号
     */
    private String oriChannelOrderId;

    /**
     * 原渠道交易币种
     */
    private String oriPayCurrency;

    /**
     * 原渠道交易金额
     */
    private BigDecimal oriPayAmount;

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

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

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

    public String getPayKind() {
        return payKind;
    }

    public void setPayKind(String payKind) {
        this.payKind = payKind;
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

    public String getPaymentOrderId() {
        return paymentOrderId;
    }

    public void setPaymentOrderId(String paymentOrderId) {
        this.paymentOrderId = paymentOrderId;
    }

    public String getChannelOrderId() {
        return channelOrderId;
    }

    public void setChannelOrderId(String channelOrderId) {
        this.channelOrderId = channelOrderId;
    }

    public Date getChannelCompleteTime() {
        return channelCompleteTime;
    }

    public void setChannelCompleteTime(Date channelCompleteTime) {
        this.channelCompleteTime = channelCompleteTime;
    }

    public String getChannelReturnId() {
        return channelReturnId;
    }

    public void setChannelReturnId(String channelReturnId) {
        this.channelReturnId = channelReturnId;
    }

    public String getChargeCostType() {
        return chargeCostType;
    }

    public void setChargeCostType(String chargeCostType) {
        this.chargeCostType = chargeCostType;
    }

    public String getChargeCostFlag() {
        return chargeCostFlag;
    }

    public void setChargeCostFlag(String chargeCostFlag) {
        this.chargeCostFlag = chargeCostFlag;
    }

    public String getChannelReferenceNo() {
        return channelReferenceNo;
    }

    public void setChannelReferenceNo(String channelReferenceNo) {
        this.channelReferenceNo = channelReferenceNo;
    }

    public String getChannelAccessCode() {
        return channelAccessCode;
    }

    public void setChannelAccessCode(String channelAccessCode) {
        this.channelAccessCode = channelAccessCode;
    }

    public String getOriChannelOrderId() {
        return oriChannelOrderId;
    }

    public void setOriChannelOrderId(String oriChannelOrderId) {
        this.oriChannelOrderId = oriChannelOrderId;
    }

    public String getOriPayCurrency() {
        return oriPayCurrency;
    }

    public void setOriPayCurrency(String oriPayCurrency) {
        this.oriPayCurrency = oriPayCurrency;
    }

    public BigDecimal getOriPayAmount() {
        return oriPayAmount;
    }

    public void setOriPayAmount(BigDecimal oriPayAmount) {
        this.oriPayAmount = oriPayAmount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
