package com.ipaylinks.cmp.css.test;

import com.csvreader.CsvWriter;
import com.ipaylinks.cmp.css.CmpCssApplication;
import com.ipaylinks.cmp.css.dal.model.LiquidationOrder;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.service.LiquidationOrderService;
import com.ipaylinks.cmp.css.util.BusinessException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmpCssApplication.class)
public class CsvTest {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LiquidationOrderService liquidationOrderService;
    @Test
    public void test() throws Exception{
    	
    	try {
		    //当前日期
			Date date =new Date();
			//根据当前结算日获取上一日所有设计到商户的交易记录
			SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
			List<LiquidationOrder>  LiquidationOrderlist =liquidationOrderService.getMertListByDay(sdf.format(date));
			for (Iterator iterator = LiquidationOrderlist.iterator(); iterator
					.hasNext();) {
				LiquidationOrder liquidationOrder = (LiquidationOrder) iterator
						.next();
				liquidationOrderService.createMerTradeStatementAccount(liquidationOrder.getMerchantId(), sdf.format(date));
			}
		} catch (Exception e) {
			logger.info("create merchant T day trade statement of account error ={}",e);
			throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "处理结算对账单异常");
		}
    	
    	
    	
    	
        logger.info("结束");
        //创建对账文件 TODO
        String  filePath="/opt/temp/reconcile_order/20180830/10000003781/";
        //生成对象头
        try {
            File file = new File(filePath);
            file.mkdirs();
            filePath = filePath + "交易对账单.csv";
            file = new File(filePath);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            String[] tradeHeader={"序号","商户编号","商户名称","商户订单编号","订单日期","网关订单号","订单类型","订单币种","订单金额","原商户订单编号","扩展序列1","扩展序列1"};
            CsvWriter csvWriter = new CsvWriter(filePath, ',', Charset.forName("GBK"));
            csvWriter.writeRecord(tradeHeader);
            csvWriter.close();
        }catch (Exception e){
            logger.error("异常", e);
        }
        logger.info("结束");
    }

}
