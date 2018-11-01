package com.ipaylinks.cmp.css.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ipaylinks.cmp.css.CmpCssApplication;
import com.ipaylinks.cmp.css.biz.job.executor.handler.LiquidationOrderStatisticsJobHandler;
import com.ipaylinks.cmp.css.dal.model.LiquidationOrder;
import com.ipaylinks.cmp.css.dal.model.MertSettlementDetail;
import com.ipaylinks.cmp.css.dal.model.MertSettlementOrder;
import com.ipaylinks.cmp.css.dal.model.MertSettlementTask;
import com.ipaylinks.cmp.css.facade.enums.BussTypeEnums;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.facade.enums.LogStatusEnums;
import com.ipaylinks.cmp.css.facade.enums.SettleEnum;
import com.ipaylinks.cmp.css.facade.enums.SummaryStatusEnums;
import com.ipaylinks.cmp.css.service.LiquidationOrderClearingService;
import com.ipaylinks.cmp.css.service.LiquidationOrderService;
import com.ipaylinks.cmp.css.service.MertSettlementDetailService;
import com.ipaylinks.cmp.css.service.MertSettlementLogService;
import com.ipaylinks.cmp.css.service.MertSettlementOrderService;
import com.ipaylinks.cmp.css.service.MertSettlementSummaryService;
import com.ipaylinks.cmp.css.service.MertSettlementTaskService;
import com.ipaylinks.cmp.css.util.BusinessException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmpCssApplication.class)
public class SettleMentTaskTest {

	 private Logger logger = LoggerFactory.getLogger(SettleMentTaskTest.class);
	@Autowired
	private  MertSettlementDetailService  mertSettlementDetailService;
	
	@Autowired
	private  MertSettlementTaskService  mertSettlementTaskService;
	
	@Autowired
	private  MertSettlementOrderService  mertSettlementOrderService;
	
	@Autowired
	private  MertSettlementSummaryService  mertSettlementSummaryService;
	
	@Autowired
	private MertSettlementLogService mertSettlementLogService;
	
	@Autowired
	private LiquidationOrderService liquidationOrderService;
	
	@Autowired
	private LiquidationOrderClearingService liquidationOrderClearingService;
	
	/**
	 * 处理结算单异常数据记账失败，汇总失败的结算单
	 * 
	 * */
/*	@Test
    public void dealSettlementDetailErrorTest() throws Exception{
		//获取异常的
		MertSettlementOrder mertSettlementOrder=new MertSettlementOrder();
		mertSettlementOrder.setSummaryStatus(SummaryStatusEnums.SUCCESS.getCode());
		mertSettlementOrder.setAccountingStatus(AcctPipeLogStatusTypeEnum.SUCCESS.getCode());
		List<MertSettlementOrder> mertSettlementOrderList =mertSettlementOrderService.getMertSettlementOrderErrorList(mertSettlementOrder);
		mertSettlementDetailService.dealMertSettlementOrderAbortDetail(mertSettlementOrderList);
	 }*/
/*	@Test
	public void TestClearingOrder() throws Exception{
		
		List<LiquidationOrder>  LiquidationOrderlist =liquidationOrderService.queryLiquidationOrderError();
		for (Iterator iterator = LiquidationOrderlist.iterator(); iterator
				.hasNext();) {
			LiquidationOrder liquidationOrder = (LiquidationOrder) iterator
					.next();
			liquidationOrderClearingService.clearingLiquidationOrder(liquidationOrder.getOrderId());
		}
	}
	@Test
	public void createTradeBookTest() throws Exception{
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
	}
	@Test
	public void SettlementBookDetailTest() throws Exception{
		Date settleDate =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
		logger.info("create merchant T day trade statement of account begin date={}",sdf.format(settleDate));
		try {
			List<MertSettlementDetail> listMertSettlementDetail=mertSettlementDetailService.countTradeMerchant();
			//根据商户和结算日期生成当前结算日期下的商户所有结算汇总单对账单
			for (Iterator iterator = listMertSettlementDetail.iterator(); iterator
					.hasNext();) {
				MertSettlementDetail mertSettlementDetail = (MertSettlementDetail) iterator
						.next();
				mertSettlementLogService.createMertSettlementLog(sdf.format(settleDate),"01","00",BussTypeEnums.SETTLE_SUMMARY_BOOK.getDesc(),BussTypeEnums.SETTLE_SUMMARY_BOOK.getCode(),LogStatusEnums.INIT.getCode());
				mertSettlementSummaryService.createMertSettlementSummaryAccount(mertSettlementDetail.getMerchantId(),sdf.format(settleDate));
			}
		} catch (Exception e) {
			logger.info("create merchant T day trade statement of account error ={}",e);
			throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "生成商户交易对账单异常");
		}
		logger.info("create merchant T day trade statement of account end date={}",sdf.format(settleDate));
	}
	*/
    @Test
    public void querySettlementDetailTest() throws Exception{
    	
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
			//根据商户和结算日期生成当前结算日期下的商户所有结算汇总单对账单
			mertSettlementLogService.createMertSettlementLog(sdf.format(date),"01","00",BussTypeEnums.SETTLE_SUMMARY_BOOK.getDesc(),BussTypeEnums.SETTLE_SUMMARY_BOOK.getCode(),LogStatusEnums.INIT.getCode());
			mertSettlementSummaryService.createMertSettlementSummaryAccount(mertSettlementTask.getMerchantId(),mertSettlementTask.getSettleDate());
		}
    }
}
