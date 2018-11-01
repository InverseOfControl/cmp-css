/*
 * *
 *  * 启赟金融信息服务（上海）有限公司
 *  * Copyright (c) 2015-2017 iPayLinks.All Rights Reserved.
 *
 *
 */

package com.ipaylinks.cmp.css.biz.mq.message;

import com.ipaylinks.cmp.css.facade.enums.OrderTypeEnum;
import com.ipaylinks.common.mq.BaseMessage;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *  订单清算通知，异步通知到清算、清分模块
 *  清算订单、风控订单
 */
public class OrderClearingNotifyMessage extends BaseMessage {

    private static final long serialVersionUID = -1L;

    /**
     * 订单类型
     */
    private OrderTypeEnum orderType;

    /**
     *  订单ID，收单订单号
     */
    private String orderId;

    public OrderTypeEnum getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderTypeEnum orderType) {
        this.orderType = orderType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
