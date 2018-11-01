package com.ipaylinks.cmp.css.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ipaylinks.cmp.css.CmpCssApplication;
import com.ipaylinks.cmp.css.facade.LiquidationOrderFacade;
import com.ipaylinks.cmp.css.facade.dto.LiquidationOrderDTO;
import com.ipaylinks.cmp.css.facade.dto.LiquidationSubOrderDTO;
import com.ipaylinks.cmp.css.facade.enums.ErrorHandingFlagEnum;
import com.ipaylinks.cmp.css.facade.request.LiquidationOrderCreateRequest;
import com.ipaylinks.common.enums.TradeTypeEnum;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmpCssApplication.class)
public class LiquidationOrderFacadeTest {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LiquidationOrderFacade liquidationOrderFacade;

    @Test
    public void createLiquidationOrder() throws Exception{
        LiquidationOrderDTO liquidationOrderDTO = new LiquidationOrderDTO();
        liquidationOrderDTO.setMerchantId("10000003892");
        liquidationOrderDTO.setMerchantName("杨秋华");
        liquidationOrderDTO.setTransType(TradeTypeEnum.SALE.getNumeric());
        liquidationOrderDTO.setTransStatus("01");
        liquidationOrderDTO.setPayOrderId("400001" + System.currentTimeMillis());
        liquidationOrderDTO.setTransCurrency("CNY");
        liquidationOrderDTO.setTransAmount(new BigDecimal(1000));
        liquidationOrderDTO.setSettleCurrency("USD");
        liquidationOrderDTO.setMerchantOrderId("100001" + System.currentTimeMillis());
        liquidationOrderDTO.setOrderId("200004" + System.currentTimeMillis());
        liquidationOrderDTO.setPayMethod("01");
        liquidationOrderDTO.setPayCompleteTime(new Date());
        //liquidationOrderDTO.setSubAccountData("[{\"merchantId\":\"10000001001\",\"amount\":\"100\",\"currency\":\"CNY\"},{\"merchantId\":\"10000001002\",\"amount\":\"10589\",\"currency\":\"CNY\"}]");
        liquidationOrderDTO.setPayOrgCode("10090011");
        //增加判断全额退款
        // liquidationOrderDTO.setIsAllRefund("1");
        liquidationOrderDTO.setPayKind("VISA");

        List<LiquidationSubOrderDTO> liquidationSubOrderDTOList = new ArrayList<>();

        LiquidationSubOrderDTO liquidationSubOrderDTO = new LiquidationSubOrderDTO();
        liquidationSubOrderDTO.setPayMethod("01");
        liquidationSubOrderDTO.setPayStatus("01");
        liquidationSubOrderDTO.setPaySubOrderId("300001" + System.currentTimeMillis());
        liquidationSubOrderDTO.setTransCurrency("CNY");
        liquidationSubOrderDTO.setPayOrgCode("10090011");
        liquidationSubOrderDTO.setPayCurrency("USD");
        liquidationSubOrderDTO.setPayAmount(new BigDecimal(1000));
        // liquidationSubOrderDTO.setErrorHandlingFlag(ErrorHandingFlagEnum.NO.getCode());
        liquidationSubOrderDTO.setPayKind("VISA");
        //liquidationSubOrderDTO.setChannelOrderNo("10003300000000");

        liquidationSubOrderDTOList.add(liquidationSubOrderDTO);

        LiquidationOrderCreateRequest request = new LiquidationOrderCreateRequest();
        request.setClientCode("txncore");
        request.setLiquidationOrderDTO(liquidationOrderDTO);
        request.setLiquidationSubOrderDTOList(liquidationSubOrderDTOList);
        liquidationOrderFacade.createLiquidationOrder(request);

    }

    /**
     * 清算订单查询测试
     *
     * @author hongxu.gao
     * @date 2018/7/27 11:21
     *//*
    @Test
    public void queryLiquidationOrderTest() throws IOException {
        LiquidationOrderQueryRequest liquidationOrderQueryRequest = new LiquidationOrderQueryRequest();

        PageBean pageBean = new PageBean();
        pageBean.setPageNumber(1);
        pageBean.setPageSize(2);

        liquidationOrderQueryRequest.setPageBean(pageBean);

        BaseResponse response = liquidationOrderFacade.queryLiquidationOrder(liquidationOrderQueryRequest);
        System.err.println(JSON.json(response).toString());
    }*/
}
