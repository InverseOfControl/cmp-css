package com.ipaylinks.cmp.css.biz.job.executor.handler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ipaylinks.cmp.css.facade.LiquidationOrderFacade;
import com.ipaylinks.cmp.css.facade.dto.LiquidationOrderDTO;
import com.ipaylinks.cmp.css.facade.dto.LiquidationSubOrderDTO;
import com.ipaylinks.cmp.css.facade.request.LiquidationOrderCreateRequest;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 清算主订单统计
 * 每月1号00:00:30 以商户号+支付方式统计上个月的交易量。
 * 统计格式：
 * 年月|商户号|商户名称|信用卡支付|消费总笔数|消费总金额|退款总笔数|退款总金额|拒付总笔数|拒付总金额|消费比例费|消费固定费|拒付率；
 * 年月|商户号|商户名称|本地化支付|消费总笔数|消费总金额|退款总笔数|退款总金额|拒付总笔数|拒付总金额|消费比例费|消费固定费；
 * 说明：
 * 拒付率的算法：上月拒付成功总笔数/上月消费成功总笔数；
 * 消费包含消费成功和预授权完成成功；
 * 金额统计：按照折合人民币金额统计，转换为美元；
 * @author dapeng.tong
 * @since 2018年7月25日 下午4:32:35
 */
@JobHandler(value = "liquidationOrderStatisticsJobHandler")
@Component
public class LiquidationOrderStatisticsJobHandler extends IJobHandler {

    private Logger logger = LoggerFactory.getLogger(LiquidationOrderStatisticsJobHandler.class);

    @Autowired
    private LiquidationOrderFacade liquidationOrderFacade;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        log("清算主订单统计task开始执行, param=" + param);
        //TODO 待做
        createLiquidationOrder();
        log("清算主订单统计task执行结束");
        return SUCCESS;
    }

    public void createLiquidationOrder() throws Exception{
        LiquidationOrderDTO liquidationOrderDTO = new LiquidationOrderDTO();
        liquidationOrderDTO.setMerchantId("10000003783");
        liquidationOrderDTO.setMerchantName("杨秋华");
        liquidationOrderDTO.setTransType("01");
        liquidationOrderDTO.setTransStatus("01");
        liquidationOrderDTO.setPayOrderId("400001" + System.currentTimeMillis());
        liquidationOrderDTO.setTransCurrency("CNY");
        liquidationOrderDTO.setTransAmount(new BigDecimal(100.56));
        liquidationOrderDTO.setSettleCurrency("USD");
        liquidationOrderDTO.setMerchantOrderId("100001" + System.currentTimeMillis());
        liquidationOrderDTO.setOrderId("200004" + System.currentTimeMillis());
        liquidationOrderDTO.setPayMethod("01");
        //liquidationOrderDTO.setSubAccountData("[{\"merchantId\":\"10000001001\",\"amount\":\"100\",\"currency\":\"CNY\"},{\"merchantId\":\"10000001002\",\"amount\":\"10589\",\"currency\":\"CNY\"}]");
        liquidationOrderDTO.setPayOrgCode("10090011");

        List<LiquidationSubOrderDTO> liquidationSubOrderDTOList = new ArrayList<>();

        LiquidationSubOrderDTO liquidationSubOrderDTO = new LiquidationSubOrderDTO();
        liquidationSubOrderDTO.setPayMethod("01");
        liquidationSubOrderDTO.setPayStatus("01");
        liquidationSubOrderDTO.setPaySubOrderId("300001" + System.currentTimeMillis());
        liquidationSubOrderDTO.setTransCurrency("CNY");
        liquidationSubOrderDTO.setPayOrgCode("10090011");
        liquidationSubOrderDTO.setPayCurrency("CNY");
        liquidationSubOrderDTO.setPayAmount(new BigDecimal(18.88));

        liquidationSubOrderDTOList.add(liquidationSubOrderDTO);

        LiquidationOrderCreateRequest request = new LiquidationOrderCreateRequest();
        request.setClientCode("txncore");
        request.setLiquidationOrderDTO(liquidationOrderDTO);
        request.setLiquidationSubOrderDTOList(liquidationSubOrderDTOList);
        liquidationOrderFacade.createLiquidationOrder(request);

        Thread.sleep(50000);
    }

    private void log(String message){
        logger.info(message);
        XxlJobLogger.log(message);
    }

    private void log(String message, Exception e){
        logger.error(message, e);
        XxlJobLogger.log(message + e.getMessage());
    }



}
