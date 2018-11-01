package com.ipaylinks.cmp.css.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.alibaba.fastjson.JSONObject;
import com.ipaylinks.acct.facade.enums.AcctPipeLogStatusTypeEnum;
import com.ipaylinks.cmp.css.dal.mapper.MertSettlementTaskMapper;
import com.ipaylinks.cmp.css.dal.model.MertSettlementDetail;
import com.ipaylinks.cmp.css.dal.model.MertSettlementOrder;
import com.ipaylinks.cmp.css.dal.model.MertSettlementTask;
import com.ipaylinks.cmp.css.facade.enums.BussTypeEnums;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.facade.enums.DepositStatusEnums;
import com.ipaylinks.cmp.css.facade.enums.LogStatusEnums;
import com.ipaylinks.cmp.css.facade.enums.SettleEnum;
import com.ipaylinks.cmp.css.facade.enums.SummaryStatusEnums;
import com.ipaylinks.cmp.css.service.MertSettlementDetailService;
import com.ipaylinks.cmp.css.service.MertSettlementLogService;
import com.ipaylinks.cmp.css.service.MertSettlementOrderService;
import com.ipaylinks.cmp.css.service.MertSettlementTaskService;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.ipaylinks.common.CalculateUtil;

@Service("mertSettlementTaskService")
public class MertSettlementTaskServiceImpl implements MertSettlementTaskService {
	
	private Logger logger = LoggerFactory.getLogger(MertSettlementTaskServiceImpl.class);
	
	@Autowired
	private  MertSettlementTaskMapper mertSettlementTaskMapper;
	
	@Autowired
	private  MertSettlementDetailService mertSettlementDetailService;
	
	@Autowired
	private  MertSettlementOrderService  mertSettlementOrderService;
	@Autowired
	private  TransactionTemplate transactionTemplate;
	
	@Autowired
	private  MertSettlementLogService mertSettlementLogService;

	@Override
	public int deleteByPrimaryKey(String id) {
		return mertSettlementTaskMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(MertSettlementTask record) {
		return mertSettlementTaskMapper.insert(record);
	}

	@Override
	public int insertSelective(MertSettlementTask record) {
		return mertSettlementTaskMapper.insertSelective(record);
	}

	@Override
	public MertSettlementTask selectByPrimaryKey(String id) {
		return mertSettlementTaskMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(MertSettlementTask record) {
		return mertSettlementTaskMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MertSettlementTask record) {
		return mertSettlementTaskMapper.updateByPrimaryKey(record);
	}

	
	@Override
	public void batchInsertMertSettlementTask(List<MertSettlementTask> listMertSettlementTask) {
		for (Iterator iterator = listMertSettlementTask.iterator(); iterator
				.hasNext();) {
			MertSettlementTask mertSettlementTask = (MertSettlementTask) iterator
					.next();
			mertSettlementTaskMapper.insertSelective(mertSettlementTask);
		}
	}

	@Override
	public List<MertSettlementTask> queryMertSettlementTask(MertSettlementTask reqMertSettlementTask) {
		return mertSettlementTaskMapper.selectMertSettlementTask(reqMertSettlementTask);
	}

	@Override
	public int createMertSettlementTask(MertSettlementTask record) {
		return mertSettlementTaskMapper.insertSelective(record);
	}

	@Override
	public String createBatchId() {
		return mertSettlementTaskMapper.selectBatchId();
	}

	/**
     * @des	        系统自动根据结算单任务进行生成结算单
     * @param  结算明细记录，状态为记账失败的交易
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
	 * @throws BusinessException 
     * */
	@Override
	public void dealMertSettlementTask(MertSettlementTask reqMertSettlementTask)
			throws BusinessException {
	 	//获取结算单任务信息
		//开始处理结算单明细
		logger.info("处理结算任务开始",JSONObject.toJSON(reqMertSettlementTask));
		List<MertSettlementTask>  listMertSettlementTask =this.queryMertSettlementTask(reqMertSettlementTask);
		if(listMertSettlementTask !=null){
			for (Iterator iterator = listMertSettlementTask.iterator(); iterator
						.hasNext();) {
				MertSettlementTask mertSettlementTask = (MertSettlementTask) iterator
						.next();
				boolean result;
				try {
					result = transactionTemplate.execute(new TransactionCallback<Boolean>() {
		            @Override
		            public Boolean doInTransaction(TransactionStatus transactionStatus) {
		            try {
						MertSettlementDetail mertSettlementDetail =new MertSettlementDetail();
						mertSettlementDetail.setSettleBatchId(mertSettlementTask.getSettleBatchId());
						mertSettlementDetail.setMerchantId(mertSettlementTask.getMerchantId());
						mertSettlementDetail.setSettleDate(mertSettlementTask.getSettleDate());
						mertSettlementDetail.setDepositStatus(DepositStatusEnums.SUCCESS.getCode());
						mertSettlementDetail.setAccountingStatus(AcctPipeLogStatusTypeEnum.SUCCESS.getCode());
						List<MertSettlementDetail> mertSettlementDetailList= mertSettlementDetailService.getMertSettlementDetailByMerchantId(mertSettlementDetail);
						for (Iterator iterator2 = mertSettlementDetailList.iterator(); iterator2
								.hasNext();) {
								MertSettlementDetail mertSettlementDetails = (MertSettlementDetail) iterator2
										.next();
								MertSettlementOrder mertSettlementOrder =new MertSettlementOrder();
								String settlementOrderId=mertSettlementOrderService.getSettlementOrderId();
								mertSettlementOrder.setSettlementOrderId(settlementOrderId);
								mertSettlementOrder.setMerchantId(mertSettlementDetails.getMerchantId());
								mertSettlementOrder.setMerchantName(mertSettlementDetails.getMerchantName());
								mertSettlementOrder.setSettlementDate(reqMertSettlementTask.getSettleDate());
								mertSettlementOrder.setSettleCurrency(mertSettlementDetails.getSettleCurrency());
								mertSettlementOrder.setFeeSettleMethod(mertSettlementDetails.getFeeSettleMethod());
								mertSettlementOrder.setSettleAmount(CalculateUtil.roundMoney(mertSettlementDetails.getSettleAmount(),mertSettlementDetails.getSettleCurrency()));
								mertSettlementOrder.setSettleType(mertSettlementDetails.getSettleType());
								mertSettlementOrder.setTransAmount(mertSettlementDetails.getTransAmount());
								mertSettlementOrder.setTransCurrency(mertSettlementDetails.getTransCurrency());
								mertSettlementOrder.setTransType(mertSettlementDetails.getTransType());
								mertSettlementOrder.setAmountType(mertSettlementDetails.getAmountType());
								mertSettlementOrder.setSummaryStatus(SummaryStatusEnums.INIT.getCode());
								mertSettlementOrder.setAccountingStatus(AcctPipeLogStatusTypeEnum.INITIAL.getCode());
								//需要处理的时间
								mertSettlementOrder.setOrderBeginDate(mertSettlementDetails.getSettleDate());
								mertSettlementOrder.setOrderEndDate(mertSettlementDetails.getSettleDate());
								mertSettlementOrderService.insertSelective(mertSettlementOrder);
							  	logger.error("生成结算订单",JSONObject.toJSON(mertSettlementOrder));
								//修改结算明细为已经结算
								mertSettlementDetail.setSettleStatus(SettleEnum.SETTLED.getCode());
								mertSettlementDetail.setGmtUpdateTime(new Date());
								mertSettlementDetail.setSettlementId(settlementOrderId);
								mertSettlementDetail.setAmountType(mertSettlementDetails.getAmountType());
								mertSettlementDetail.setTransType(mertSettlementDetails.getTransType());
								mertSettlementDetail.setTransCurrency(mertSettlementDetails.getTransCurrency());
								mertSettlementDetailService.updateMertSettlementDetail1Id(mertSettlementDetail);
								logger.error("修改结算订单单号",JSONObject.toJSON(mertSettlementDetail));
							}
						//修改结算任务为已经结算
						mertSettlementTask.setSettleStatus(SettleEnum.SETTLED.getCode());
						mertSettlementTask.setGmtUpdateTime(new Date());
						mertSettlementTaskMapper.updateByPrimaryKey(mertSettlementTask);
		            }catch (Exception e) {
		                logger.error("保存结算单异常异常", e.getMessage());
		                transactionStatus.setRollbackOnly();
		                return false;
		            }
		            return true;
		        }
			  });
			 } catch (Exception e) {
			        logger.error("保存结算单异常异常", e);
			        result = false;
		    }
		    if(!result){
		        throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "保存结算单异常异常");
		    }
		    mertSettlementLogService.createMertSettlementLog(mertSettlementTask.getSettleDate(),"01","00",mertSettlementTask,BussTypeEnums.SETTLE_ORDER.getCode(),LogStatusEnums.SUCCESS.getCode());
			}
		}
		logger.info("处理结算任务结束",JSONObject.toJSON(reqMertSettlementTask));
	}

	@Override
	public List<MertSettlementTask> getPendingSettlementTaskList(String merchantId,String code) {
		return mertSettlementTaskMapper.getPendingSettlementTaskList(merchantId,code);
	}
}
