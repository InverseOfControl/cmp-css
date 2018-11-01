package com.ipaylinks.cmp.css.test;

import com.ipaylinks.cmp.css.CmpCssApplication;
import com.ipaylinks.cmp.css.service.TradeAccountReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmpCssApplication.class)
public class TradeAccountReportServiceTest {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TradeAccountReportService tradeAccountReportService;

    @Test
    public void dealTradeAccountReport() throws Exception{
        tradeAccountReportService.dealTradeAccountReport();
    }

}
