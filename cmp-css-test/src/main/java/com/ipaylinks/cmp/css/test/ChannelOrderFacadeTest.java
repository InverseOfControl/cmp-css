package com.ipaylinks.cmp.css.test;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.dubbo.common.json.JSON;
import com.ipaylinks.cmp.css.CmpCssApplication;
import com.ipaylinks.cmp.css.facade.ChannelOrderFacade;
import com.ipaylinks.cmp.css.facade.request.ChannelOrderCreateRequest;
import com.ipaylinks.cmp.css.facade.request.ChannelOrderQueryRequest;
import com.ipaylinks.cmp.css.integration.ccs.ChannelWaterPushFacadeClient;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.ipaylinks.common.page.PageBean;
import com.ipaylinks.common.rpc.BaseResponse;
import com.ipaylinks.verify.facade.dto.SettlementTransDetailDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmpCssApplication.class)
public class ChannelOrderFacadeTest {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ChannelOrderFacade channelOrderFacade;

   /* @Test
    public void createChannelOrder() throws Exception{
        ChannelOrderCreateRequest request = new ChannelOrderCreateRequest();
        request.setClientCode("txncore");
        request.setMerchantId("10000003700");
        request.setMerchantName("杨秋华");
        request.setTransType("01");
        request.setTransStatus("01");
        request.setPayMethod("01");
        request.setChannelType("01");
        request.setOrgCode("10090011");
        request.setPayCurrency("CNY");
        request.setPayAmount(new BigDecimal(125.68));
        request.setMerchantOrderId("500001");
        request.setOrderId("600010");
        request.setPaymentOrderId("800001");
        request.setChannelOrderId("700008"+System.currentTimeMillis());
        channelOrderFacade.createChannelOrder(request);

        Thread.sleep(20000);
    }

    @Test
    public void queryChannelOrder() throws Exception{
        ChannelOrderQueryRequest request = new ChannelOrderQueryRequest();

        PageBean pageBean = new PageBean();
        pageBean.setPageNumber(1);
        pageBean.setPageSize(2);

        request.setPageBean(pageBean);

        BaseResponse response = channelOrderFacade.queryChannelOrder(request);
        System.err.println(JSON.json(response).toString());
    }*/


    @Autowired
    private ChannelWaterPushFacadeClient channelWaterPushFacadeClient;
    @Test
    public void testChannelFlowPush() throws BusinessException {
        SettlementTransDetailDTO transDetailDTO = new SettlementTransDetailDTO();
        transDetailDTO.setMerchantId("22");
        transDetailDTO.setMerchantName("测试");
        transDetailDTO.setTransType("3");
        transDetailDTO.setTransStatus("4");
        transDetailDTO.setPayMethod("5");
        transDetailDTO.setChannelType("6");
        transDetailDTO.setOrgSubCode("10091016");
        transDetailDTO.setCardType("9");
        transDetailDTO.setPayCurrency("10");
        transDetailDTO.setPayAmount(new BigDecimal("11"));
        transDetailDTO.setMerchantOrderId("12");
        transDetailDTO.setOrderId("13");
        transDetailDTO.setPaymentOrderId("14");
        transDetailDTO.setChannelReturnId("15");
        transDetailDTO.setChargeCostType("16");
        transDetailDTO.setChargeCostFlag("17");
        transDetailDTO.setChannelReferenceNo("18");
        transDetailDTO.setChannelAccessCode("19");
        transDetailDTO.setOriChannelReturnId("20");
        transDetailDTO.setOriPayCurrency("21");
        transDetailDTO.setOriPayAmount("22");
        transDetailDTO.setChannelOrderId("23");
        transDetailDTO.setPercentFeeCurrency("24");
        transDetailDTO.setPercentFeeAmount("25");
        transDetailDTO.setFixedFeeCurrency("26");
        transDetailDTO.setFixedFeeAmount(new BigDecimal("27"));
        transDetailDTO.setFeeCurrency("28");
        transDetailDTO.setFeeAmount(new BigDecimal("29"));
        transDetailDTO.setCostSettleCurrency("30");
        transDetailDTO.setCostSettleAmount(new BigDecimal("31"));
        transDetailDTO.setCostSettleDate("32");
        transDetailDTO.setChargeCostMethod("33");
        transDetailDTO.setCostId("34");
        transDetailDTO.setBatchNo("35");
        transDetailDTO.setReconStatus("36");

        channelWaterPushFacadeClient.push(transDetailDTO);
    }
}
