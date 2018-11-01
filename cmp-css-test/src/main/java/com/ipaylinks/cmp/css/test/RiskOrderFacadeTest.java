package com.ipaylinks.cmp.css.test;

import com.ipaylinks.cmp.css.CmpCssApplication;
import com.ipaylinks.cmp.css.facade.RiskOrderFacade;
import com.ipaylinks.cmp.css.facade.request.RiskOrderCreateRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmpCssApplication.class)
public class RiskOrderFacadeTest {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RiskOrderFacade riskOrderFacade;

    @Test
    public void createRiskOrder() throws Exception{
        RiskOrderCreateRequest request = new RiskOrderCreateRequest();
        request.setClientCode("txncore");
        request.setMerchantId("10000003781");
        request.setMerchantName("杨秋华");
        request.setMerchantOrderId("500001" + System.currentTimeMillis());
        request.setOrderId("600009" + System.currentTimeMillis());
        request.setRiskOrderId("700005" + System.currentTimeMillis());
        request.setTransCurrency("CNY");
        request.setTransType("01");
        request.setPayMethod("01");
        request.setTransAmount(new BigDecimal(12098));
        riskOrderFacade.createRiskOrder(request);
        Thread.sleep(50000);
    }

}
