package com.ipaylinks.cmp.css.biz.job.executor.handler;

import com.ipaylinks.cmp.css.service.TradeAccountReportService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@JobHandler(value="dealTradeAccountReprotTask")
public class DealTradeAccountReprotTask extends IJobHandler {

	private Logger logger = LoggerFactory.getLogger(DealTradeAccountReprotTask.class);
	
	@Autowired
	private  TradeAccountReportService  tradeAccountReportService;

	 //每月1号00:00:30 以商户号+支付方式统计上个月的交易量
	 //信用卡支付：
	 //表头：年月|商户号|商户名称|信用卡支付|消费总笔数|消费总金额|退款总笔数|退款总金额|拒付总笔数|拒付总金额|消费比例费|消费固定费|拒付率
	 //本地化支付：
	 //表头： 年月|商户号|商户名称|本地化支付|消费总笔数|消费总金额|退款总笔数|退款总金额|拒付总笔数|拒付总金额|消费比例费|消费固定费；
	 //注意计算规则：
	 //1、拒付率的算法：上月拒付成功总笔数/上月消费成功总笔数；
	 //2、消费包含消费成功和预授权完成成功；
	 //3、金额统计：按照折合人民币金额统计，转换为美元；
	 /**
     * @des    定时生成清算月统计交易量报表
     * @return 处理结果生成月度统计报表，每月生成一份
     * @author yuyao
     * @data   <a>2018-07-09<a>
     * @plan   执行计划 2018-**-** 00-01-00
     * */
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		Date date =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("DealTradeAccountReprotTask deal begin date ={}",sdf.format(date));
		//启动处理JOB
		dealTradeAccountReportService();
		//预处理结算明细订单
		logger.info("DealSettlementTask del pre settlement datail end date ={}",sdf.format(date));
		return null;
	}

	/**
     * @des    定时出来结算系统生成交易统计报表
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
     * @data   <a>2018-07-09<a>
     * @plan   执行计划 2018-**-** 00-01-00
     * */
	 public void dealTradeAccountReportService(){
		 tradeAccountReportService.dealTradeAccountReport();
	 }

}
