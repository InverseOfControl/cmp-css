/*
 * *
 *  * 启赟金融信息服务（上海）有限公司
 *  * Copyright (c) 2015-2017 iPayLinks.All Rights Reserved.
 *
 *
 */

package com.ipaylinks.cmp.css.biz.mq.producter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * mq消费发送类
 * @author dapeng.tong
 */
@Component
public class MqSender {

    private static Logger logger = LoggerFactory.getLogger(MqSender.class);

    /*@Value("${mq.message.orderClearing:Q_CMP_CSS_ORDER_CLEARING}")
    private String orderClearingNotifyQueueName;

    @Autowired
    private JmsTemplate jmsTemplate;

    *//**
     * 订单清分清算通知，异步通知到清算、清分模块，自发自收
     * @param messageObj
     *  
     *//*
    @Async
    public void notifyOrderClearing(OrderClearingNotifyMessage messageObj){
        logger.info("发送订单清分通知开始，{}", messageObj);
        try {
            if(Objects.nonNull(messageObj)){
                messageObj.setDestClientCode(ClientEnum.CMP_CHANNEL.getClientCode());
                String message = new Gson().toJson(messageObj);
                jmsTemplate.convertAndSend(orderClearingNotifyQueueName, message);
            }
        }catch (Exception e){
            logger.error("发送订单清分通知异常", e);
            //TODO 这里应该加个告警
        }
        logger.info("发送订单清分通知结束");
    }
*/
}
