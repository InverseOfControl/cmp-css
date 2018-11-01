/**
 * 启赟金融信息服务（上海）有限公司
 * Copyright (c) 2015-2017 iPayLinks.All Rights Reserved.
 */
package com.ipaylinks.cmp.css.biz.impl.order.validator;

import com.ipaylinks.cmp.css.biz.abstarction.AbstractProcessor;
import com.ipaylinks.cmp.css.biz.abstarction.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/** 
 * 清算子订单验证处理器

 * @author Joseph
 * @since 2018年4月26日 下午6:59:19  
 */
@Service
public class LiquidationSubOrderValidator extends AbstractProcessor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /**
     * {@inheritDoc}
     * 
     * @see com.ipaylinks.cmp.css.biz.abstarction.Processor#process(com.ipaylinks.cmp.css.biz.abstarction.Context)
     */
    @Override
    protected void doProcess(Context ctx) throws Exception {
        logger.debug("LiquidationSubOrderValidator begin");
        logger.debug("LiquidationSubOrderValidator end");
    }
}
