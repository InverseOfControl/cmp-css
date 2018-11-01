package com.ipaylinks.cmp.css.biz.job.executor.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ipaylinks.cmp.css.biz.impl.common.ClearingOrderHandler;
import com.ipaylinks.cmp.css.facade.constant.AccountConstantConstant;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

@Component
@JobHandler(value="dealClearingOrderAccounTask")
public class DealClearingOrderAccounTask extends IJobHandler {

	private Logger logger = LoggerFactory.getLogger(DealClearingOrderAccounTask.class);
	

	@Autowired
	private  ClearingOrderHandler  clearingOrderHandler;
	/**
     * @des    清分明细处理清算子订单记账失败任务
     * @param  子订单记账失败的数据
     * @return 处理结算明细到结算单定时任务
     * @author yuyao
     * @data   <a>2018-07-09<a>
     * @plan   自动定义时间，定期自动触发补偿记账流程
     * */
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		String dealCode =AccountConstantConstant.DEAL_LIQUIDATION_SUB_ORDER_CODE;
		logger.info("DealClearingOrderAccounTask deal clearing order account task bigin={}",dealCode);
		clearingOrderHandler.doAccountingForLiquidationSubOrderAccountEorror(dealCode);
		logger.info("DealClearingOrderAccounTask deal clearing order account task end={}",dealCode);
		return SUCCESS;
	}
}
