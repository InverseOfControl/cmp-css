package com.ipaylinks.cmp.css.dal.model;

import java.util.Date;

public class LiquidationLog {
    /**
     * 主键
     * 表 : T_LIQUIDATION_LOG
     * 对应字段 : ID
     */
    private String id;

    /**
     * 订单编号
     * 表 : T_LIQUIDATION_LOG
     * 对应字段 : ORDER_ID
     */
    private String orderId;

    /**
     * 创建时间
     * 表 : T_LIQUIDATION_LOG
     * 对应字段 : CREATE_TIME
     */
    private Date createTime;

    /**
     * 更新时间
     * 表 : T_LIQUIDATION_LOG
     * 对应字段 : UPDATE_TIME
     */
    private Date updateTime;

    /**
     * 订单类型 01-清算订单、02-风控订单、03-渠道订单
     * 表 : T_LIQUIDATION_LOG
     * 对应字段 : ORDER_TYPE
     */
    private String orderType;

    /**
     * 处理结果
     * 表 : T_LIQUIDATION_LOG
     * 对应字段 : RESULT
     */
    private String result;

    /**
     * get method 
     *
     * @return T_LIQUIDATION_LOG.ID：主键
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
     * @return T_LIQUIDATION_LOG.ORDER_ID：订单编号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * set method 
     *
     * @param orderId  订单编号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_LOG.CREATE_TIME：创建时间
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
     * @return T_LIQUIDATION_LOG.UPDATE_TIME：更新时间
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

    /**
     * get method 
     *
     * @return T_LIQUIDATION_LOG.ORDER_TYPE：订单类型 01-清算订单、02-风控订单、03-渠道订单
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * set method 
     *
     * @param orderType  订单类型 01-清算订单、02-风控订单、03-渠道订单
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    /**
     * get method 
     *
     * @return T_LIQUIDATION_LOG.RESULT：处理结果
     */
    public String getResult() {
        return result;
    }

    /**
     * set method 
     *
     * @param result  处理结果
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}