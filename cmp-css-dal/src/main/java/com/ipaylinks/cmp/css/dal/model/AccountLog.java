package com.ipaylinks.cmp.css.dal.model;

import java.util.Date;

public class AccountLog {
    /**
     * 主键
     * 表 : T_ACCOUNT_LOG
     * 对应字段 : ID
     */
    private String id;

    /**
     * 请求流水号
     * 表 : T_ACCOUNT_LOG
     * 对应字段 : REQUEST_ID
     */
    private String requestId;

    /**
     * 交易订单号
     * 表 : T_ACCOUNT_LOG
     * 对应字段 : TRADE_ORDER_ID
     */
    private String tradeOrderId;

    /**
     * 清算主订单号
     * 表 : T_ACCOUNT_LOG
     * 对应字段 : SETTLEMENT_ORDER_ID
     */
    private String settlementOrderId;

    /**
     * 记账类型
     * 表 : T_ACCOUNT_LOG
     * 对应字段 : ACCOUNTING_TYPE
     */
    private String accountingType;

    /**
     * 记账状态 00-未记账 01-已记账 02-记账失败
     * 表 : T_ACCOUNT_LOG
     * 对应字段 : ACCOUNTING_STATUS
     */
    private String accountingStatus;

    /**
     * 记账流水号 记账系统返回的流水号
     * 表 : T_ACCOUNT_LOG
     * 对应字段 : ACCOUNTING_ID
     */
    private String accountingId;

    /**
     * 记账内容 记账请求报文
     * 表 : T_ACCOUNT_LOG
     * 对应字段 : ACCOUNTING_CONTENT
     */
    private String accountingContent;

    /**
     * 记账时间
     * 表 : T_ACCOUNT_LOG
     * 对应字段 : ACCOUNTING_TIME
     */
    private Date accountingTime;

    /**
     * 原始记账流水号  如果是撤销交易，存正向交易的记账流水
     * 表 : T_ACCOUNT_LOG
     * 对应字段 : ORIGINAL_ACCOUNTING_ID
     */
    private String originalAccountingId;

    /**
     * 创建时间
     * 表 : T_ACCOUNT_LOG
     * 对应字段 : CREATE_TIME
     */
    private Date createTime;

    /**
     * 更新时间
     * 表 : T_ACCOUNT_LOG
     * 对应字段 : UPDATE_TIME
     */
    private Date updateTime;

    /**
     * get method 
     *
     * @return T_ACCOUNT_LOG.ID：主键
     */
    public String getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * get method 
     *
     * @return T_ACCOUNT_LOG.REQUEST_ID：请求流水号
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * set method 
     *
     * @param requestId  请求流水号
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
    }

    /**
     * get method 
     *
     * @return T_ACCOUNT_LOG.TRADE_ORDER_ID：交易订单号
     */
    public String getTradeOrderId() {
        return tradeOrderId;
    }

    /**
     * set method 
     *
     * @param tradeOrderId  交易订单号
     */
    public void setTradeOrderId(String tradeOrderId) {
        this.tradeOrderId = tradeOrderId == null ? null : tradeOrderId.trim();
    }

    /**
     * get method 
     *
     * @return T_ACCOUNT_LOG.SETTLEMENT_ORDER_ID：清算主订单号
     */
    public String getSettlementOrderId() {
        return settlementOrderId;
    }

    /**
     * set method 
     *
     * @param settlementOrderId  清算主订单号
     */
    public void setSettlementOrderId(String settlementOrderId) {
        this.settlementOrderId = settlementOrderId == null ? null : settlementOrderId.trim();
    }

    /**
     * get method 
     *
     * @return T_ACCOUNT_LOG.ACCOUNTING_TYPE：记账类型
     */
    public String getAccountingType() {
        return accountingType;
    }

    /**
     * set method 
     *
     * @param accountingType  记账类型
     */
    public void setAccountingType(String accountingType) {
        this.accountingType = accountingType == null ? null : accountingType.trim();
    }

    /**
     * get method 
     *
     * @return T_ACCOUNT_LOG.ACCOUNTING_STATUS：记账状态 00-未记账 01-已记账 02-记账失败
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
     * @return T_ACCOUNT_LOG.ACCOUNTING_ID：记账流水号 记账系统返回的流水号
     */
    public String getAccountingId() {
        return accountingId;
    }

    /**
     * set method 
     *
     * @param accountingId  记账流水号 记账系统返回的流水号
     */
    public void setAccountingId(String accountingId) {
        this.accountingId = accountingId == null ? null : accountingId.trim();
    }

    /**
     * get method 
     *
     * @return T_ACCOUNT_LOG.ACCOUNTING_CONTENT：记账内容 记账请求报文
     */
    public String getAccountingContent() {
        return accountingContent;
    }

    /**
     * set method 
     *
     * @param accountingContent  记账内容 记账请求报文
     */
    public void setAccountingContent(String accountingContent) {
        this.accountingContent = accountingContent == null ? null : accountingContent.trim();
    }

    /**
     * get method 
     *
     * @return T_ACCOUNT_LOG.ACCOUNTING_TIME：记账时间
     */
    public Date getAccountingTime() {
        return accountingTime;
    }

    /**
     * set method 
     *
     * @param accountingTime  记账时间
     */
    public void setAccountingTime(Date accountingTime) {
        this.accountingTime = accountingTime;
    }

    /**
     * get method 
     *
     * @return T_ACCOUNT_LOG.ORIGINAL_ACCOUNTING_ID：原始记账流水号  如果是撤销交易，存正向交易的记账流水
     */
    public String getOriginalAccountingId() {
        return originalAccountingId;
    }

    /**
     * set method 
     *
     * @param originalAccountingId  原始记账流水号  如果是撤销交易，存正向交易的记账流水
     */
    public void setOriginalAccountingId(String originalAccountingId) {
        this.originalAccountingId = originalAccountingId == null ? null : originalAccountingId.trim();
    }

    /**
     * get method 
     *
     * @return T_ACCOUNT_LOG.CREATE_TIME：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * set method 
     *
     * @param createTime  创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * get method 
     *
     * @return T_ACCOUNT_LOG.UPDATE_TIME：更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * set method 
     *
     * @param updateTime  更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}