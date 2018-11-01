/**
 * 启赟金融信息服务（上海）有限公司
 * Copyright (c) 2015-2017 iPayLinks.All Rights Reserved.
 */
package com.ipaylinks.cmp.css.biz.abstarction;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

/** 
 * 抽象处理器链

 * @author Joseph
 * @since 2018年4月26日 下午5:06:03  
 */
public abstract class AbstractProcessorChainExecutor extends AbstractProcessor implements InitializingBean, ApplicationContextAware {

    protected ApplicationContext applicationContext;

    protected List<Processor> processorList;

    /**
     * {@inheritDoc}
     * 
     * @see com.ipaylinks.cmp.css.biz.abstarction.AbstractProcessor#doProcess(com.ipaylinks.cmp.css.biz.abstarction.Context)
     */
    @Override
    protected void doProcess(Context ctx) throws Exception {

        if (CollectionUtils.isNotEmpty(processorList)) {
            for (Processor processor : processorList) {
                processor.process(ctx);
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * */
    protected abstract void buildProcessorWorkflow() throws Exception;

    /**
     * {@inheritDoc}
     * 
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        buildProcessorWorkflow();
    }

}
