package com.ipaylinks.cmp.css.biz.job.executor.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ipaylinks.cmp.css.facade.constant.AccountConstantConstant;
import com.ipaylinks.cmp.css.service.MertSettlementDetailService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;


@Component
@JobHandler(value="dealMertSettlementDetailAccountTask")
public class DealMertSettlementDetailAccountTask extends IJobHandler {

	private Logger logger = LoggerFactory.getLogger(DealMertSettlementDetailAccountTask.class);
	

	@Autowired
	private  MertSettlementDetailService  mertSettlementDetailService;
	/**
     * @des    根据结算明细记账失败的进行补偿记录结算明细账
     * @param  子订单记账失败的数据
     * @author yuyao
     * @data   <a>2018-07-09<a>
     * @plan   自动定义时间，定期自动触发补偿记账流程
     * */
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		String dealCode =AccountConstantConstant.DEAL_SETTLE_DETAIL_CODE;
		Date date =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
		logger.info("DealClearingOrderAccounTask deal clearing order account task bigin={}",dealCode);
		mertSettlementDetailService.dealMertSettlementDetailAccountError(dealCode,sdf.format(date));
		logger.info("DealClearingOrderAccounTask deal clearing order account task end={}",dealCode);
		return SUCCESS;
	}

}
