package com.ipaylinks.cmp.css.biz.job.executor.handler;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ipaylinks.cmp.css.dal.model.LiquidationOrder;
import com.ipaylinks.cmp.css.service.LiquidationOrderClearingService;
import com.ipaylinks.cmp.css.service.LiquidationOrderService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

@Component
@JobHandler(value="dealClearingOrderTask")
public class DealClearingOrderTask extends IJobHandler{

private Logger logger = LoggerFactory.getLogger(DealClearingOrderTask.class);
	

	@Autowired
	private  LiquidationOrderService  liquidationOrderService;
	
	@Autowired
	private LiquidationOrderClearingService liquidationOrderClearingService;
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
		List<LiquidationOrder>  LiquidationOrderlist =liquidationOrderService.queryLiquidationOrderError();
		for (Iterator iterator = LiquidationOrderlist.iterator(); iterator
				.hasNext();) {
			LiquidationOrder liquidationOrder = (LiquidationOrder) iterator
					.next();
			liquidationOrderClearingService.clearingLiquidationOrder(liquidationOrder.getOrderId());
		}
		return SUCCESS;
	}
}
