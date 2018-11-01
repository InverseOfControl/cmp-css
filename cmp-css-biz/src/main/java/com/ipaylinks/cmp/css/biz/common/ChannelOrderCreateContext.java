/**
 * 启赟金融信息服务（上海）有限公司
 * Copyright (c) 2015-2017 iPayLinks.All Rights Reserved.
 */
package com.ipaylinks.cmp.css.biz.common;

import com.ipaylinks.cmp.css.dal.model.ChannelOrder;

/** 
 * 渠道流水落单上下文
 * @author Joseph
 * @since 2018年4月26日 下午2:17:00  
 */
public class ChannelOrderCreateContext extends BaseRequestContext {

    /**
     * 渠道流水
     */
    private ChannelOrder channelOrder;

    public ChannelOrder getChannelOrder() {
        return channelOrder;
    }

    public void setChannelOrder(ChannelOrder channelOrder) {
        this.channelOrder = channelOrder;
    }
}
