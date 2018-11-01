package com.ipaylinks.cmp.css.facade.request;

import com.ipaylinks.cmp.css.facade.enums.OrderTypeEnum;
import com.ipaylinks.common.rpc.BaseRequest;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class OrderClearingRequest extends BaseRequest{

    private static final long serialVersionUID = -1L;

    /**
     * 订单类型
     */
    @NotNull(message = "orderType不能为空")
    @NotEmpty(message = "orderType不能为空")
    private OrderTypeEnum orderType;

    /**
     * 收单订单号
     */
    @NotNull(message = "orderId不能为空")
    @NotEmpty(message = "orderId不能为空")
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
