/**
 * 启赟金融信息服务（上海）有限公司
 * Copyright (c) 2015-2017 iPayLinks.All Rights Reserved.
 */
package com.ipaylinks.cmp.css.biz.common;

import com.ipaylinks.cmp.css.biz.abstarction.AbstarctContext;
import com.ipaylinks.cmp.css.dal.model.RequestLog;
import com.ipaylinks.common.rpc.BaseRequest;

/**
 * BaseRequest上下文
 * @author Joseph
 * @since 2018年4月26日 下午7:09:16  
 */
public class BaseRequestContext extends AbstarctContext {

    /**
     * 请求参数对象
     */
    private BaseRequest baseRequest;

    /**
     * 请求日志
     */
    private RequestLog requestLog;

    public BaseRequest getBaseRequest() {
        return baseRequest;
    }

    public void setBaseRequest(BaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }

    public RequestLog getRequestLog() {
        return requestLog;
    }

    public void setRequestLog(RequestLog requestLog) {
        this.requestLog = requestLog;
    }
}
