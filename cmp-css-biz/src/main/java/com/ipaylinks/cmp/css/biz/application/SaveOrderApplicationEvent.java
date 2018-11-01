package com.ipaylinks.cmp.css.biz.application;

import com.ipaylinks.cmp.css.biz.common.BaseRequestContext;
import org.springframework.context.ApplicationEvent;

/**
 *  落单事件
 *  @author dapeng.tong
 *  @create 2018/8/16
 *
 */
public class SaveOrderApplicationEvent extends ApplicationEvent {

    private BaseRequestContext ctx;

    public SaveOrderApplicationEvent() {
        super("saveOrderApplicationEvent");
    }

    public BaseRequestContext getCtx() {
        return ctx;
    }

    public void setCtx(BaseRequestContext ctx) {
        this.ctx = ctx;
    }
}
