/**
 * 启赟金融信息服务（上海）有限公司
 * Copyright (c) 2015-2017 iPayLinks.All Rights Reserved.
 */
package com.ipaylinks.cmp.css.biz.impl.order.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ipaylinks.cmp.css.biz.abstarction.AbstractProcessor;
import com.ipaylinks.cmp.css.biz.abstarction.Context;
import com.ipaylinks.cmp.css.biz.common.LiquidationContext;

/** 
 * 风控订单验证处理器

 * @author Joseph
 * @since 2018年4月26日 下午6:59:19  
 */
@Service
public class RiskOrderValidator extends AbstractProcessor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * {@inheritDoc}
     * 
     * @see com.ipaylinks.cmp.css.biz.abstarction.AbstarctValidator#doProcess(com.ipaylinks.cmp.css.biz.abstarction.Context)
     */
    @Override
    protected void doProcess(Context ctx) throws Exception {
        logger.debug("RiskOrderValidator begin");
        logger.debug("RiskOrderValidator end");
    }   
}
