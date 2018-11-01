package com.ipaylinks.cmp.css.biz.job.executor.handler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ipaylinks.acct.facade.enums.AcctPipeLogStatusTypeEnum;
import com.ipaylinks.cmp.css.dal.model.MertSettlementOrder;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.facade.enums.SummaryStatusEnums;
import com.ipaylinks.cmp.css.service.MertSettlementDetailService;
import com.ipaylinks.cmp.css.service.MertSettlementOrderService;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

@Component
@JobHandler(value="dealMertTradeOrderAccountTask")
public class DealMertTradeOrderErrorTask extends IJobHandler {

private Logger logger = LoggerFactory.getLogger(DealMertTradeOrderErrorTask.class);

	@Autowired
	private MertSettlementOrderService  mertSettlementOrderService; 
	
	@Autowired
	private MertSettlementDetailService  mertSettlementDetailService; 
	
	/**
     * @des    处理结算单异常
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
     * @data   <a>2018-07-09<a>
     * @plan   执行计划 2018-**-** 00-01-00
     * */
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		Date date =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
		logger.info("create merchant T day trade statement of account begin date={}",sdf.format(date));
		try {
			//获取异常的
			MertSettlementOrder mertSettlementOrder=new MertSettlementOrder();
			mertSettlementOrder.setSummaryStatus(SummaryStatusEnums.SUCCESS.getCode());
			mertSettlementOrder.setAccountingStatus(AcctPipeLogStatusTypeEnum.SUCCESS.getCode());
			List<MertSettlementOrder> mertSettlementOrderList =mertSettlementOrderService.getMertSettlementOrderErrorList(mertSettlementOrder);
			mertSettlementDetailService.dealMertSettlementOrderAbortDetail(mertSettlementOrderList);
		} catch (Exception e) {
			logger.info("create merchant T day trade statement of account error ={}",e);
			throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "处理结算对账单异常");
		}
		logger.info("create merchant T day trade statement of account end date={}",sdf.format(date));
		return SUCCESS;
	}
}
