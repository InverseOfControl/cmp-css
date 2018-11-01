/**
 * 启赟金融信息服务（上海）有限公司
 * Copyright (c) 2015-2017 iPayLinks.All Rights Reserved.
 */
package com.ipaylinks.cmp.css.biz.abstarction;

/** 
 * 抽象处理类

 * @author Joseph
 * @since 2018年4月26日 下午2:19:25  
 */
public abstract class AbstractProcessor implements Processor {

    @Override
    public void process(Context ctx) throws Exception {
        doProcess(ctx);
    }

    protected abstract void doProcess(Context ctx) throws Exception;
    
}
