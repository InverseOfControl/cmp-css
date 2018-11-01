package com.ipaylinks.cmp.css.biz.job.executor.handler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ipaylinks.cmp.css.dal.model.MertSettlementDetail;
import com.ipaylinks.cmp.css.dal.model.MertSettlementOrder;
import com.ipaylinks.cmp.css.dal.model.MertSettlementTask;
import com.ipaylinks.cmp.css.facade.enums.BussTypeEnums;
import com.ipaylinks.cmp.css.facade.enums.LogStatusEnums;
import com.ipaylinks.cmp.css.facade.enums.SettleEnum;
import com.ipaylinks.cmp.css.facade.enums.SummaryStatusEnums;
import com.ipaylinks.cmp.css.integration.mcs.MerchantSettlementConfigFacadeClient;
import com.ipaylinks.cmp.css.service.MertSettlementDetailService;
import com.ipaylinks.cmp.css.service.MertSettlementLogService;
import com.ipaylinks.cmp.css.service.MertSettlementOrderService;
import com.ipaylinks.cmp.css.service.MertSettlementSummaryService;
import com.ipaylinks.cmp.css.service.MertSettlementTaskService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

@Component
@JobHandler(value="dealSettlementTask")
public class DealSettlementTask extends IJobHandler {

	private Logger logger = LoggerFactory.getLogger(DealSettlementTask.class);
    
	@Autowired
	private  MertSettlementDetailService  mertSettlementDetailService;
	
	@Autowired
	private MerchantSettlementConfigFacadeClient merchantSettlementConfigFacadeClient;
	
	@Autowired
	private  MertSettlementTaskService  mertSettlementTaskService;
	
	@Autowired
	private  MertSettlementOrderService  mertSettlementOrderService;
	
	@Autowired
	private  MertSettlementSummaryService  mertSettlementSummaryService;
	
	@Autowired
	private MertSettlementLogService mertSettlementLogService;
	/**
     * @des    结算系统定时任务启动接口
     * @param  param 自定义参数
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
     * @data   <a>2018-07-09<a>
     * @plan   执行计划 2018-**-** 00-01-00
     * */
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		Date date =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
		//启动处理JOB	
		//预处理结算明细订单
		MertSettlementDetail mertSettlementDetail =new MertSettlementDetail();
		mertSettlementDetail.setSettleStatus(SettleEnum.OUTSTANDING.getCode());
		mertSettlementDetail.setSettleDate(sdf.format(date));
		mertSettlementLogService.createMertSettlementLog(sdf.format(date),"01","00",BussTypeEnums.SETTLE_TASK.getDesc(),BussTypeEnums.SETTLE_TASK.getCode(),LogStatusEnums.INIT.getCode());
		//根据结算单明细生成结算任务
		List<MertSettlementTask> mertSettlementTaskList =mertSettlementDetailService.createMertSettlementTaskFromMertSettlementDetail(mertSettlementDetail);
		mertSettlementLogService.createMertSettlementLog(sdf.format(date),"01","00",BussTypeEnums.SETTLE_DETAIL.getDesc(),BussTypeEnums.SETTLE_DETAIL.getCode(),LogStatusEnums.INIT.getCode());
	    //根据结算任务预处理结算明细
		for (Iterator iterator = mertSettlementTaskList.iterator(); iterator
				.hasNext();) {
			MertSettlementTask mertSettlementTask = (MertSettlementTask) iterator
					.next();
			mertSettlementDetail.setSettleDate(mertSettlementTask.getSettleDate());
			mertSettlementDetail.setSettleStatus(mertSettlementTask.getSettleStatus());
			mertSettlementDetail.setMerchantId(mertSettlementTask.getMerchantId());
			mertSettlementDetailService.preMertSettlementDetailList(mertSettlementDetail);
			//根据结算单任务进行处理结算明细生成结算单
			mertSettlementLogService.createMertSettlementLog(sdf.format(date),"01","00",BussTypeEnums.SETTLE_ORDER.getDesc(),BussTypeEnums.SETTLE_ORDER.getCode(),LogStatusEnums.INIT.getCode());
			//处理待结算状态AND当前结算时间前的所有数据
			mertSettlementTaskService.dealMertSettlementTask(mertSettlementTask);
			
			//生成汇总单
			mertSettlementLogService.createMertSettlementLog(sdf.format(date),"01","00",BussTypeEnums.SETTLE_SUMMARY.getDesc(),BussTypeEnums.SETTLE_SUMMARY.getCode(),LogStatusEnums.INIT.getCode());
			MertSettlementOrder mertSettlementOrder =new MertSettlementOrder();
			mertSettlementOrder.setSummaryStatus(SummaryStatusEnums.INIT.getCode());
			mertSettlementOrder.setSettlementDate(mertSettlementTask.getSettleDate());
			mertSettlementOrder.setMerchantId(mertSettlementTask.getMerchantId());
			mertSettlementSummaryService.createMertSettlementSummary(mertSettlementOrder);
			
		}
		return SUCCESS;
	}
}
