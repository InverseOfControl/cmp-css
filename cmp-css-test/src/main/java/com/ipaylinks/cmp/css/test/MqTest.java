package com.ipaylinks.cmp.css.test;

import com.ipaylinks.cmp.css.CmpCssApplication;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmpCssApplication.class)
public class MqTest {
    private Logger logger = LoggerFactory.getLogger(getClass());

   /* @Autowired
    private MqSender mqSender;

    @Test
    public void orderClearingNotify() throws Exception{
        OrderClearingNotifyMessage messageObj = new OrderClearingNotifyMessage();
        mqSender.notifyOrderClearing(messageObj);
        Thread.sleep(10000);
    }*/

}
