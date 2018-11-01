package com.ipaylinks.cmp.css.integration.model;

/**
 * 渠道计费策略查询参数
 * @author dapeng.tong
 * @modifer hongxu.gao
 **/
public class ChannelChargeStrategyQueryParam {
    /** 系统编号 */
    private String clientCode;
    /** 请求流水号 */
    private String reqId;
    /** 渠道号 */
    private String channelCode;
    /** 收费场景（包含：支付、提现、汇款、拒付、退款、退票、授信、风控、换汇） */
    private String chargeScene;
    /** 币种。货币字母代码，如：USD */
    private String currencyCode;
    /** 地区。包括欧盟、非欧盟，送参数时需要注意不同卡组织对欧盟的非欧盟的定义 */
    private String region;
    /** 国家二字码，如：US */
    private String countryCode;
    /** 卡组织。包含：VISA、MC、JCB、AE、DC */
    private String cardOrg;
    /** 账户类型。包含：对公账户、对私账户 */
    private String cardType;
    /** 账户类型。包含：对公账户、对私账户 */
    private String accountType;
    /** 交易模型。包含：3D、非3D */
    private String tradeModel;
    /** 二级商户号 */
    private String secondaryAccount;
    /** 子渠道 */
    private String subChannelCode;
    /** 交易状态 */
    private String tradeStatus;

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
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

    public String getSecondaryAccount() {
        return secondaryAccount;
    }

    public void setSecondaryAccount(String secondaryAccount) {
        this.secondaryAccount = secondaryAccount;
    }

    public String getSubChannelCode() {
        return subChannelCode;
    }

    public void setSubChannelCode(String subChannelCode) {
        this.subChannelCode = subChannelCode;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }
}
