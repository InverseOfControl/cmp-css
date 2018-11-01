package com.ipaylinks.cmp.css.biz.impl.common;

import com.ipaylinks.cmp.css.biz.application.SaveOrderApplicationEvent;
import com.ipaylinks.cmp.css.biz.common.BaseRequestContext;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.util.ResponseUtils;
import com.ipaylinks.common.rpc.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * 落单请求处理
 * @author dapeng.tong
 * @date 2018/5/8 10:54  
 */
@Service("saveOrderRequestHandler")
public class SaveOrderRequestHandler {
    private Logger logger = LoggerFactory.getLogger(SaveOrderRequestHandler.class);

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public BaseResponse invoke(BaseRequestContext ctx) {
        logger.info("落单请求处理开始");
        BaseResponse response = new BaseResponse();
        try {
            //落单事件
            SaveOrderApplicationEvent event = new SaveOrderApplicationEvent();
            event.setCtx(ctx);
            applicationEventPublisher.publishEvent(event);
            //设置response状态为成功
            ResponseUtils.setToSuccess(response);
        }catch (Exception e){
            logger.error("落单请求处理异常", e);
            ResponseUtils.setToFail(response, CmpCssExceptionCode.SYSTEM_EXCEPTION);
        }
        logger.info("落单请求处理结束，response={}", response);
        return response;
    }
}
