/**
 * 启赟金融信息服务（上海）有限公司
 * Copyright (c) 2015-2017 iPayLinks.All Rights Reserved.
 */
package com.ipaylinks.cmp.css.biz.common;

import com.ipaylinks.cmp.css.dal.model.AccsplitOrder;
import com.ipaylinks.cmp.css.dal.model.LiquidationOrder;
import com.ipaylinks.cmp.css.dal.model.LiquidationSubOrder;

import java.util.List;

/** 
 * 清算订单落单上下文
 * @author Joseph
 * @since 2018年4月26日 下午2:17:00  
 */
public class LiquidationOrderCreateContext extends BaseRequestContext {

    /**
     * 清算主订单
     */
    private LiquidationOrder liquidationOrder;

    /**
     * 清算子订单
     */
    private List<LiquidationSubOrder> liquidationSubOrderList;

    /**
     * 分账订单
     */
    private List<AccsplitOrder> accsplitOrderList;

    public LiquidationOrder getLiquidationOrder() {
        return liquidationOrder;
    }

    public void setLiquidationOrder(LiquidationOrder liquidationOrder) {
        this.liquidationOrder = liquidationOrder;
    }

    public List<LiquidationSubOrder> getLiquidationSubOrderList() {
        return liquidationSubOrderList;
    }

    public void setLiquidationSubOrderList(List<LiquidationSubOrder> liquidationSubOrderList) {
        this.liquidationSubOrderList = liquidationSubOrderList;
    }

    public List<AccsplitOrder> getAccsplitOrderList() {
        return accsplitOrderList;
    }

    public void setAccsplitOrderList(List<AccsplitOrder> accsplitOrderList) {
        this.accsplitOrderList = accsplitOrderList;
    }
}
