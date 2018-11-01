/*
 * *
 *  * 启赟金融信息服务（上海）有限公司
 *  * Copyright (c) 2015-2017 iPayLinks.All Rights Reserved.
 *
 *
 */

package com.ipaylinks.cmp.css.biz.mq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * mq消息监听类
 * @author dapeng.tong
 */
@Component
public class MqListener {
    private static  Logger logger = LoggerFactory.getLogger(MqListener.class);

    /*@Autowired
    private ClearingOrderHandler clearingOrderHandler;

    *//**
     * 接收订单清分清算通知
     * @param message
     *//*
    @JmsListener(destination = "${mq.message.orderClearing:Q_CMP_CSS_ORDER_CLEARING}", concurrency = "5-10")
    public void receivedOrderClearing(String message){
        logger.info("接收清算订单清算通知开始, message={}",message);
        try{
            OrderClearingNotifyMessage messageObj = new Gson().fromJson(message,OrderClearingNotifyMessage.class);
            clearingOrderHandler.invoke(messageObj.getOrderType(), messageObj.getOrderId());
        }catch (Exception e){
            logger.error("接收清算订单清算通知异常:{}",e);
            //TODO 这里应该加个告警
        }
        logger.info("接收清算订单清算通知结束");
    }*/
    
}
