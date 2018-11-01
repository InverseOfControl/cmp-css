package com.ipaylinks.cmp.css.integration.model;

/**
 * 商户收费策咯查询请求参数
 * @author dapeng.tong
 **/
public class MerchChargeStrategyQueryParam {

    /**
     * 收费场景。包含：支付、提现、汇款、拒付、退款、退票、授信、风控、换汇
     */
    private String chargeScene;
    /**
     * 币种。货币字母代码，如：USD
     */
    private String currencyCode;
    /**
     * 地区。包括欧盟、非欧盟，送参数时需要注意不同卡组织对欧盟的非欧盟的定义
     */
    private String region;
    /**
     * 国家二字码，如：US
     */
    private String countryCode;
    /**
     *卡组织。包含：VISA、MC、JCB、AE、DC
     */
    private String cardOrg;
    /**
     * 卡类型 01-信用卡、02-借记卡，信用卡支付必输
     */
    private String cardType;
    /**
     * 账户类型。包含：对公账户、对私账户
     */
    private String accountType;
    /**
     * 交易模型。包含：3D、非3D
     */
    private String tradeModel;

    /**
     * 商户号
     */
    private String merchantId;
    /**
     * 支付方式。包含：信用卡支付、本地化支付
     */
    private String payMode;
    /**
     * 交易方式。包含：DCC、EDC
     */
    private String transactionMode;
    /**
     * 渠道号。系统定义的渠道号
     */
    private String channelCode;
    /**
     * 到账时效。包含：实时、快速、普通
     */
    private String remitTimeliness;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getTransactionMode() {
        return transactionMode;
    }

    public void setTransactionMode(String transactionMode) {
        this.transactionMode = transactionMode;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getRemitTimeliness() {
        return remitTimeliness;
    }

    public void setRemitTimeliness(String remitTimeliness) {
        this.remitTimeliness = remitTimeliness;
    }

    public String getChargeScene() {
        return chargeScene;
    }

    public void setChargeScene(String chargeScene) {
        this.chargeScene = chargeScene;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCardOrg() {
        return cardOrg;
    }

    public void setCardOrg(String cardOrg) {
        this.cardOrg = cardOrg;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getTradeModel() {
        return tradeModel;
    }

    public void setTradeModel(String tradeModel) {
        this.tradeModel = tradeModel;
    }
}
