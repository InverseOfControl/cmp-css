/**
 * 启赟金融信息服务（上海）有限公司
 * Copyright (c) 2015-2017 iPayLinks.All Rights Reserved.
 */
package com.ipaylinks.cmp.css.biz.common;

import com.ipaylinks.cmp.css.dal.model.RiskOrder;

/** 
 * 风控订单落单上下文
 * @author Joseph
 * @since 2018年4月26日 下午2:17:00  
 */
public class RiskOrderCreateContext extends BaseRequestContext {

    /**
     * 风控订单
     */
    private RiskOrder riskOrder;

    public RiskOrder getRiskOrder() {
        return riskOrder;
    }

    public void setRiskOrder(RiskOrder riskOrder) {
        this.riskOrder = riskOrder;
    }
}
