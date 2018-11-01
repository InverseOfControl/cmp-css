package com.ipaylinks.cmp.css.facade.request;

import com.ipaylinks.common.rpc.BaseRequest;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class RiskOrderCreateRequest extends BaseRequest{

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
    @NotNull(message = "merchantName不能为空")
    @NotEmpty(message = "merchantName不能为空")
    private String merchantName;

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
     * 风控订单号
     */
    @NotNull(message = "riskOrderId不能为空")
    @NotEmpty(message = "riskOrderId不能为空")
    private String riskOrderId;

    /**
     * 交易币种
     */
    @NotNull(message = "transCurrency不能为空")
    @NotEmpty(message = "transCurrency不能为空")
    private String transCurrency;

    /**
     * 交易金额
     */
    @NotNull(message = "transAmount不能为空")
    private BigDecimal transAmount;

    /**
     * 交易类型 com.ipaylinks.common.enums.TradeTypeEnum
     */
    @NotNull(message = "transType不能为空")
    @NotEmpty(message = "transType不能为空")
    private String transType;

    /**
     * 支付方式 01-信用卡支付、02-本地化支付
     */
    @NotNull(message = "payMethod不能为空")
    @NotEmpty(message = "payMethod不能为空")
    private String payMethod;

    private String payKind;

    public String getPayKind() {
        return payKind;
    }

    public void setPayKind(String payKind) {
        this.payKind = payKind;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
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

    public String getRiskOrderId() {
        return riskOrderId;
    }

    public void setRiskOrderId(String riskOrderId) {
        this.riskOrderId = riskOrderId;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
