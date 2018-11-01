package com.ipaylinks.cmp.css.biz.job.executor.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ipaylinks.cmp.css.facade.constant.AccountConstantConstant;
import com.ipaylinks.cmp.css.service.MertSettlementSummaryService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;


@Component
@JobHandler(value="dealMertSettlementOrderAccountTask")
public class DealMertSettlementOrderAccountTask extends IJobHandler {

private Logger logger = LoggerFactory.getLogger(DealMertSettlementOrderAccountTask.class);
	

	@Autowired
	private  MertSettlementSummaryService  mertSettlementSummaryService;
	/**
     * @des    根据结算汇总单进行获取结算单记账异常失败进行补偿记账
     * @param  子订单记账失败的数据
     * @author yuyao
     * @data   <a>2018-07-09<a>
     * @plan   自动定义时间，定期自动触发补偿记账流程
     * */
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		String dealCode =AccountConstantConstant.DEAL_SETTLE_SUMMARY_CODE;
		logger.info("DealClearingOrderAccounTask deal clearing order account task bigin={}",dealCode);
		mertSettlementSummaryService.dealMertSettlementOrderAccountError(dealCode);
		logger.info("DealClearingOrderAccounTask deal clearing order account task end={}",dealCode);
		return SUCCESS;
	}

}
