/**
 * 启赟金融信息服务（上海）有限公司
 * Copyright (c) 2015-2017 iPayLinks.All Rights Reserved.
 */
package com.ipaylinks.cmp.css.biz.impl.settlement.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ipaylinks.cmp.css.biz.abstarction.AbstractProcessor;
import com.ipaylinks.cmp.css.biz.abstarction.Context;

/** 
 * 结算订单明细处理

 * @author Joseph
 * @since 2018年5月22日 下午8:39:13  
 */
@Service
public class SettlementOrderPersistProcessor extends AbstractProcessor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * {@inheritDoc}
     * 
     * @see com.ipaylinks.cmp.css.biz.abstarction.AbstractProcessor#doProcess(com.ipaylinks.cmp.css.biz.abstarction.Context)
     */
    @Override
    protected void doProcess(Context ctx) throws Exception {
        logger.info("test");
    }

}
