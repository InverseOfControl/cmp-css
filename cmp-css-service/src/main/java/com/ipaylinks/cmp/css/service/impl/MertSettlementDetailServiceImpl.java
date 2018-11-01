package com.ipaylinks.cmp.css.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ipaylinks.acct.facade.enums.AcctPipeLogStatusTypeEnum;
import com.ipaylinks.cmp.css.dal.mapper.MertSettlementDetailMapper;
import com.ipaylinks.cmp.css.dal.model.MertSettlementDetail;
import com.ipaylinks.cmp.css.dal.model.MertSettlementOrder;
import com.ipaylinks.cmp.css.dal.model.MertSettlementTask;
import com.ipaylinks.cmp.css.facade.constant.AccountConstantConstant;
import com.ipaylinks.cmp.css.facade.enums.AcctBookTypeEnum;
import com.ipaylinks.cmp.css.facade.enums.BussTypeEnums;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.facade.enums.DepositStatusEnums;
import com.ipaylinks.cmp.css.facade.enums.FeeEnum;
import com.ipaylinks.cmp.css.facade.enums.LogStatusEnums;
import com.ipaylinks.cmp.css.facade.enums.PayTypeEnum;
import com.ipaylinks.cmp.css.facade.enums.SettleEnum;
import com.ipaylinks.cmp.css.facade.enums.SettleTypeRule;
import com.ipaylinks.cmp.css.facade.enums.ValidStatusEnum;
import com.ipaylinks.cmp.css.integration.act.AccountingRuleFacadeQueryRpcClient;
import com.ipaylinks.cmp.css.integration.commonservice.SettlementRateQueryRpcClient;
import com.ipaylinks.cmp.css.integration.dto.CreateAccountingAmount;
import com.ipaylinks.cmp.css.integration.mcs.MerchantSettlementConfigFacadeClient;
import com.ipaylinks.cmp.css.integration.req.CreateAccountingRequest;
import com.ipaylinks.cmp.css.integration.req.QueryMertSettlementCashDepositRequest;
import com.ipaylinks.cmp.css.integration.res.CreateMermberAccountFeeResponse;
import com.ipaylinks.cmp.css.integration.res.QueryMertSettlementCashDepositResponse;
import com.ipaylinks.cmp.css.integration.util.EnumMappingUtil;
import com.ipaylinks.cmp.css.service.MertSettlementDetailService;
import com.ipaylinks.cmp.css.service.MertSettlementLogService;
import com.ipaylinks.cmp.css.service.MertSettlementOrderService;
import com.ipaylinks.cmp.css.service.MertSettlementTaskService;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.ipaylinks.common.CalculateUtil;
import com.ipaylinks.common.enums.BaseRespStatusEnum;
import com.ipaylinks.common.enums.CurrencyTypeEnum;
import com.ipaylinks.common.enums.FinanceTypeEnum;
import com.ipaylinks.common.enums.TradeTypeEnum;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service("mertSettlementDetailService")
public class MertSettlementDetailServiceImpl implements
		MertSettlementDetailService {
	
	private Logger logger = LoggerFactory.getLogger(MertSettlementDetailServiceImpl.class);
	
    @Autowired(required = false)
	private MertSettlementDetailMapper mertSettlementDetailMapper;
    @Autowired(required = false)
	private  MertSettlementTaskService mertSettlementTaskService;
	@Autowired
	private MerchantSettlementConfigFacadeClient merchantSettlementConfigFacadeClient;
	@Autowired
	private AccountingRuleFacadeQueryRpcClient accountingRuleFacadeQueryRpcClient;
	@Autowired
	private SettlementRateQueryRpcClient settlementRateQueryRpcClient;
	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private MertSettlementLogService mertSettlementLogService;

	@Autowired
	private  MertSettlementOrderService  mertSettlementOrderService;
	
	
	 /**
     * 根据系统获取所有结算明细进行预处理
     * @param record
     */
	@Override
	public List<MertSettlementDetail> getMertSettlementDetail(MertSettlementDetail record) {
		logger.info("MertSettlementDetailServiceImpl query MertSettlementDetail list bengin request={}",record);
		List<MertSettlementDetail> list=this.mertSettlementDetailMapper.getMertSettlementDetailList(record);
		logger.info("MertSettlementDetailServiceImpl query MertSettlementDetail list end request={}",list);
		return list;
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return mertSettlementDetailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(MertSettlementDetail record) {
		return mertSettlementDetailMapper.insert(record);
	}

	@Override
	public int insertSelective(MertSettlementDetail record) {
		return mertSettlementDetailMapper.insertSelective(record);
	}

	@Override
	public MertSettlementDetail selectByPrimaryKey(String id) {
		return mertSettlementDetailMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(MertSettlementDetail record) {
		return mertSettlementDetailMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MertSettlementDetail record) {
		return mertSettlementDetailMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<MertSettlementOrder> getMertSettlementDetailList(
			MertSettlementDetail mertSettlementDetail) {
		List<MertSettlementOrder> list=null;//this.mertSettlementDetailMapper.createSettleDetailToSettleOrder();
		return list;
	}

	@Override
	public List<MertSettlementDetail> getMertSettlementAccountErrorDetail(MertSettlementDetail record) {
		logger.info("MertSettlementDetailServiceImpl query MertSettlementDetail list bengin request={}",record);
		List<MertSettlementDetail> list=this.mertSettlementDetailMapper.getMertSettlementAccountErrorDetail(record);
		logger.info("MertSettlementDetailServiceImpl query MertSettlementDetail list end request={}",list);
		return list;
	}

	 /**
     * 根据商户和结算时间获取商户结算单列表
     **/
	@Override
	public List<MertSettlementDetail> getSumMertSettlementDetail() {
		Date date =new Date();
		logger.info("MertSettlementDetailServiceImpl query MertSettlementDetail list bengin request={}",date);
		List<MertSettlementDetail> list=this.mertSettlementDetailMapper.getSumMertSettlementDetail();
		logger.info("MertSettlementDetailServiceImpl query MertSettlementDetail list end request={}",date);
		return list;
	}

	 /**
     * 根据商户和结算时间获取商户结算单列表
     ** @throws BusinessException
     */
	@Override
	public MertSettlementTask createMertSettlementTask(MertSettlementDetail mertSettlementDetail,String settleDate) throws BusinessException {
        //创建結算任務日誌
		MertSettlementTask  mertSettlementTask =new MertSettlementTask();
		boolean result;
		 try {
			 result = transactionTemplate.execute(new TransactionCallback<Boolean>() {
            @Override
            public Boolean doInTransaction(TransactionStatus transactionStatus) {
                try {
	                	mertSettlementTask.setSettleDate(settleDate);
	            		mertSettlementTask.setMerchantId(mertSettlementDetail.getMerchantId());
	            		mertSettlementTask.setSettleCompleteTime(settleDate);
	            		mertSettlementTask.setSettleStartTime(mertSettlementDetail.getSettleStartTime());
	            		mertSettlementTask.setSettleRuleId(SettleTypeRule.DN.getCode());//默认D+1结算交易方式
	            		mertSettlementTask.setSettleStatus(SettleEnum.OUTSTANDING.getCode());
						String  settleBatchId =mertSettlementTaskService.createBatchId();
						mertSettlementTask.setSettleBatchId(settleBatchId);
						int retTask =mertSettlementTaskService.createMertSettlementTask(mertSettlementTask);
						
						mertSettlementLogService.createMertSettlementLog(settleDate,mertSettlementTask.getMerchantId(),settleBatchId,mertSettlementTask,BussTypeEnums.SETTLE_TASK.getCode(),LogStatusEnums.INIT.getCode());
						//修改结算明细为已经结算
						MertSettlementDetail reqMertSettlementDetail =new MertSettlementDetail();
						reqMertSettlementDetail.setSettleStatus(SettleEnum.SETTLED.getCode());
						reqMertSettlementDetail.setMerchantId(mertSettlementDetail.getMerchantId());
						reqMertSettlementDetail.setGmtUpdateTime(new Date());
						reqMertSettlementDetail.setSettleBatchId(settleBatchId);
						reqMertSettlementDetail.setSettleCompleteTime(settleDate);
						reqMertSettlementDetail.setSettleStartTime(mertSettlementDetail.getSettleStartTime());
						int ret =mertSettlementDetailMapper.updateMertSettlementDetail1(reqMertSettlementDetail);
                    }catch (Exception e) {
                        logger.error("保存结算任务异常", e);
                        mertSettlementLogService.createMertSettlementLog(settleDate,mertSettlementTask.getMerchantId(),mertSettlementTask.getId(),mertSettlementTask,BussTypeEnums.SETTLE_TASK.getCode(),LogStatusEnums.FAILED.getCode());
                        transactionStatus.setRollbackOnly();
                        return false;
                    }
                    return true;
                }
			 });
        } catch (Exception e) {
            logger.error("保存结算任务异常", e);
            result = false;
        }
        if(!result){
            throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "保存结算任务异常");
        }
        mertSettlementLogService.createMertSettlementLog(settleDate,mertSettlementTask.getMerchantId(),mertSettlementTask.getId(),mertSettlementTask,BussTypeEnums.SETTLE_TASK.getCode(),LogStatusEnums.SUCCESS.getCode());
		return mertSettlementTask;
	}

	@Override
	public List<MertSettlementDetail> getMertSettlementDetailByMerchantId(
			MertSettlementDetail mertSettlementDetail) throws BusinessException {
		List<MertSettlementDetail> mertSettlementDetailList = mertSettlementDetailMapper.getMertSettlementDetailByMerchantId(mertSettlementDetail);
		return  mertSettlementDetailList;
	}

	 /**
     * 根据商户交易类型和预授权完成类型生成商户保证金结算明细
     */
	@Override
	public void createMertSettlementCashDeposit(List<MertSettlementDetail> mertSettlementDetailDeposit) throws BusinessException{
		   boolean result;
	        try {
	            result = transactionTemplate.execute(new TransactionCallback<Boolean>() {
	                @Override
	                public Boolean doInTransaction(TransactionStatus transactionStatus) {
	                    try {
							for (Iterator iterator = mertSettlementDetailDeposit.iterator(); iterator
									.hasNext();) {
								MertSettlementDetail mertSettlementDetail = (MertSettlementDetail) iterator
										.next();
								int ret=mertSettlementDetailMapper.insertSelective(mertSettlementDetail);
								if(ret==0){
									throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "保存保证金明细异常");
								}
							}
	                    }catch (Exception e) {
	                    	mertSettlementLogService.createMertSettlementLog("","01","00",mertSettlementDetailDeposit,BussTypeEnums.SETTLE_DEPOSIT.getCode(),LogStatusEnums.FAILED.getCode());
	                        logger.error("结算明细生成保证金异常", e);
	                        transactionStatus.setRollbackOnly();
	                        return false;
	                    }
	                    return true;
	                }
	            });
	        } catch (Exception e) {
	        	
	            logger.error("保存保证金明细异常", e);
	            result = false;
	        }
	        if(!result){
	            throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "保存保证金明细异常");
	        }
	}
	@Override
	public List<MertSettlementDetail> selectList(MertSettlementDetail mertSettlementDetail) {
		return mertSettlementDetailMapper.selectList(mertSettlementDetail);
	}

	/**
     * @des    处理结算明细记账失败数据进行补偿记账
     * @param  dealCode 自定义参数
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
     * @data   <a>2018-07-09<a>
     * @plan   执行计划 2018-**-** 00-01-00
     * */
	@Override
	public void dealMertSettlementDetailAccountError(String dealCode,String settleDate)
			throws BusinessException {
		 MertSettlementDetail mertSettlementDetail =new MertSettlementDetail();
		 mertSettlementDetail.setAccountingStatus(AcctPipeLogStatusTypeEnum.FAIL.getCode());
		 mertSettlementDetail.setSettleStatus(SettleEnum.SETTLEMENTFAILURE.getCode());
		 mertSettlementDetail.setSettleDate(settleDate);
		 try {
			 List<MertSettlementDetail> MertSettlementDetail=mertSettlementDetailMapper.getMertSettlementAccountErrorDetail(mertSettlementDetail);
			 for (Iterator iterator = MertSettlementDetail.iterator(); iterator
					.hasNext();) {
				MertSettlementDetail mertSettlementDetail2 = (MertSettlementDetail) iterator
						.next();
				mertSettlementDetail2.setAccountingStatus(AcctPipeLogStatusTypeEnum.INITIAL.getCode());
				mertSettlementDetail2.setSettleStatus(SettleEnum.OUTSTANDING.getCode());
				mertSettlementDetailMapper.updateByPrimaryKeySelective(mertSettlementDetail2);
			}
		} catch (Exception e) {
			logger.info("query settle detail account error msg={}",e);
			throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "查询结算明细记账失败异常"); 
		}
	}

	
	/**
     * @des	        根据商户结算明细进行生成保证金明细
     * @param  mertSettlementDetail 结算明细记录，状态为记账待结算的交易明细
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
	 * @throws BusinessException 
     * */
	@Override
	public void createMertSettlementCashDepositFromMertSettlementDetail(MertSettlementDetail mertSettlementDetail) throws BusinessException{
		logger.info("DealSettlementTask deal MertSettlement Cash Deposit  begin Request ={}",mertSettlementDetail);
			//根据消费和预授权完成进行计算商户保证金
			mertSettlementLogService.createMertSettlementLog(mertSettlementDetail.getSettleDate(),"01","00",BussTypeEnums.SETTLE_DEPOSIT.getDesc(),BussTypeEnums.SETTLE_DEPOSIT.getCode(),LogStatusEnums.INIT.getCode());
			if(mertSettlementDetail.getTransType().equals(TradeTypeEnum.SALE.getNumeric()) || mertSettlementDetail.getTransType().equals(TradeTypeEnum.CAPTURE.getNumeric())){
				QueryMertSettlementCashDepositRequest request =new QueryMertSettlementCashDepositRequest();
				request.setMerchantId(mertSettlementDetail.getMerchantId());
				request.setTransCurrency(mertSettlementDetail.getTransCurrency());
				QueryMertSettlementCashDepositResponse response =new QueryMertSettlementCashDepositResponse();
				try {
					List<MertSettlementDetail>  mertSettlementDetailDeposit =new ArrayList<MertSettlementDetail>();
					logger.info("query merchant set deposit request begin","查询保证金比例");
					response =merchantSettlementConfigFacadeClient.queryMertSettlementCashDeposit(request);
					if(response.getPercent()==null && response.getPercent().equals("")){
						//设置默认保证金比例
						response.setPercent(Short.valueOf("0"));
						//如果设置为零，或者没有设置则退出
						if(response.getPercent()==0){
							return;
						}
					}
					
					logger.info("query merchant set deposit request end","查询保证金比例结束");
					mertSettlementLogService.createMertSettlementLog(mertSettlementDetail.getSettleDate(),"01","00",response,BussTypeEnums.SETTLE_DEPOSIT.getCode(),LogStatusEnums.INIT.getCode());
					
					if(!BaseRespStatusEnum.SUCCESS.getCode().equals(response.getResponseStatus())){
		                throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "查询保证金参数返回异常");
		            }
					//生成保证金
					MertSettlementDetail mertSettlementDetailCharge =new MertSettlementDetail();
					//复制所有属性
					BeanUtils.copyProperties(mertSettlementDetail,mertSettlementDetailCharge);
					//设置保证金支付币种
					mertSettlementDetailCharge.setSettleCurrency(mertSettlementDetail.getSettleCurrency());
					mertSettlementDetailCharge.setAmountType(FinanceTypeEnum.CHARGE_SECURITY_DEPOSIT.getCode());
					//计算保证金结算金额
					mertSettlementDetailCharge.setSettleStatus(SettleEnum.SETTLED.getCode());
					mertSettlementDetailCharge.setDepositStatus(DepositStatusEnums.SUCCESS.getCode());
					mertSettlementDetailCharge.setTransCurrency(mertSettlementDetail.getSettleCurrency());
					mertSettlementDetailCharge.setAccountingTime(new Date());
					BigDecimal origAmount =mertSettlementDetail.getSettleAmount().multiply(new BigDecimal(response.getPercent())).divide(new BigDecimal(100));
					BigDecimal settelAmount =CalculateUtil.roundMoney(origAmount, mertSettlementDetailCharge.getSettleCurrency());
					mertSettlementDetailCharge.setSettleAmount(settelAmount.negate());
					mertSettlementDetailCharge.setTransAmount(settelAmount.negate());
					mertSettlementDetailCharge.setAccountingTime(new Date());
					//生成收取保证金订单
					mertSettlementDetailCharge.setAccountingStatus(AcctPipeLogStatusTypeEnum.SUCCESS.getCode());
					mertSettlementDetailCharge.setSettleRate(BigDecimal.ONE);
					mertSettlementDetailDeposit.add(mertSettlementDetailCharge);
					
				    
					//生成归还保证金
					//生成归还保证金结算时间
					MertSettlementDetail mertSettlementDetailReturn =new MertSettlementDetail();
					//复制所有属性
					BeanUtils.copyProperties(mertSettlementDetail,mertSettlementDetailReturn);
					Date strDate=DateUtils.parseDate(mertSettlementDetailReturn.getSettleDate(), "yyyyMMdd");
					Date date =DateUtils.addDays(strDate,Integer.valueOf(response.getReturnDate()));
					mertSettlementDetailReturn.setTransCurrency(mertSettlementDetail.getSettleCurrency());
					mertSettlementDetailReturn.setAmountType(FinanceTypeEnum.RETURN_SECURITY_DEPOSIT.getCode());
					mertSettlementDetailReturn.setSettleCurrency(mertSettlementDetail.getSettleCurrency());
					mertSettlementDetailReturn.setDepositStatus(DepositStatusEnums.SUCCESS.getCode());
					mertSettlementDetailReturn.setSettleStatus(SettleEnum.OUTSTANDING.getCode());
					
					mertSettlementDetailReturn.setSettleAmount(settelAmount);
					mertSettlementDetailReturn.setTransAmount(settelAmount);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					mertSettlementDetailReturn.setSettleDate(sdf.format(date));
					mertSettlementDetailReturn.setSettleBatchId("");
					mertSettlementDetailReturn.setAccountingStatus(AcctPipeLogStatusTypeEnum.INITIAL.getCode());
					mertSettlementDetailReturn.setSettleRate(BigDecimal.ONE);
					//生成归还保证金订单
					mertSettlementDetailDeposit.add(mertSettlementDetailReturn);
					
					try {
						this.createMertSettlementCashDeposit(mertSettlementDetailDeposit);
					} catch (Exception e) {
						mertSettlementDetail.setDepositStatus(DepositStatusEnums.FAILED.getCode());
						mertSettlementDetail.setSettleStatus(SettleEnum.SETTLEMENTFAILURE.getCode());
						mertSettlementDetail.setGmtUpdateTime(new Date());
						this.updateByPrimaryKey(mertSettlementDetail);
						logger.error("DealSettlementTask deal MertSettlement Cash Deposit  end error ={}",e);
						throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "生成商户保证金异常"); 
					}
					mertSettlementDetail.setDepositStatus(DepositStatusEnums.SUCCESS.getCode());
					mertSettlementDetail.setAccountingStatus(AcctPipeLogStatusTypeEnum.SUCCESS.getCode());
					mertSettlementDetail.setSettleStatus(SettleEnum.SETTLED.getCode());
					mertSettlementDetail.setGmtUpdateTime(new Date());
					int ret =this.updateByPrimaryKey(mertSettlementDetail);
					if(ret==0){
						throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "生成商户保证金任务异常"); 
					}
				} catch (Exception e) {
					logger.error("DealSettlementTask deal MertSettlement Cash Deposit  end error ={}",e);
					throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "生成商户保证金任务异常"); 
				}
			}
		mertSettlementLogService.createMertSettlementLog(mertSettlementDetail.getSettleDate(),"01","00",mertSettlementDetail,BussTypeEnums.SETTLE_DEPOSIT.getCode(),LogStatusEnums.SUCCESS.getCode());
		logger.info("DealSettlementTask deal MertSettlement Cash Deposit  end response ={}",mertSettlementDetail);
	}

	/** 
	 * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss 
	 *  
	 * @param strDate 
	 * @return 
	 */  
	public static Date strToDateLong(String strDate) {  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    ParsePosition pos = new ParsePosition(0);  
	    Date strtodate = formatter.parse(strDate, pos);  
	    return strtodate;  
	} 
	/**
     * @des    处理结算明细保证金记账失败数据
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
     * @data   <a>2018-07-09<a>
     * @plan   执行计划 2018-**-** 00-01-00
     * */
	@Override
	 public void dealMertSettlementCashDepositAccountError() throws BusinessException{
		 logger.info("DealSettlementTask deal MertSettlement Cash Deposit account begin ={}",new Date());
		 MertSettlementDetail mertSettlementDetail =new MertSettlementDetail();
		 mertSettlementDetail.setAmountType(String.valueOf(FeeEnum.cashDeposit.getCode()));
		 mertSettlementDetail.setAccountingStatus(AcctBookTypeEnum.ACCOUNT_FAILED.getCode());
		 try {
			 List<MertSettlementDetail> MertSettlementDetail=this.getMertSettlementAccountErrorDetail(mertSettlementDetail);
			 for (Iterator iterator = MertSettlementDetail.iterator(); iterator
					.hasNext();) {
				MertSettlementDetail mertSettlementDetail2 = (MertSettlementDetail) iterator
						.next();
				String dealCode =AccountConstantConstant.DEAL_SETTLE_ORDER_CODE;
				dealMertSettlementDetailAccount(mertSettlementDetail2,dealCode);
			}
		} catch (Exception e) {
			logger.info("DealSettlementTask deal MertSettlement Cash Deposit account error ={}",e);
			throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "处理结算明细保证金记账失败的数据异常"); 
		}
		 logger.info("DealSettlementTask deal MertSettlement Cash Deposit account end ={}",new Date());
	 }

	/**
     * @des    预处理结算明细数据
     * @param  record 自定义参数
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
     * @data   <a>2018-07-09<a>
     * @plan   执行计划 2018-**-** 00-01-00
     * */
	@Override
	public  void preMertSettlementDetailList(MertSettlementDetail record) throws BusinessException{
		 logger.info("结算预处理开始",JSONObject.toJSON(record));
		 //获取结算任务列表
		 MertSettlementTask requestMertSettlementTask =new MertSettlementTask();
		 requestMertSettlementTask.setMerchantId(record.getMerchantId());
		 requestMertSettlementTask.setSettleDate(record.getSettleDate());
		 requestMertSettlementTask.setSettleStatus(record.getSettleStatus());
		 List<MertSettlementTask> mertSettlementTaskList =mertSettlementTaskService.queryMertSettlementTask(requestMertSettlementTask);
		 for (Iterator iterator = mertSettlementTaskList.iterator(); iterator
				.hasNext();) {
			MertSettlementTask mertSettlementTask = (MertSettlementTask) iterator
					.next();
			//获取结算任务设计到的结算明细
			MertSettlementDetail requestMertSettlementDetail =new MertSettlementDetail();
			requestMertSettlementDetail.setSettleStatus(mertSettlementTask.getSettleStatus());
			requestMertSettlementDetail.setMerchantId(mertSettlementTask.getMerchantId());
			requestMertSettlementDetail.setSettleCompleteTime(mertSettlementTask.getSettleCompleteTime());
			requestMertSettlementDetail.setSettleStartTime(mertSettlementTask.getSettleStartTime());
			List<MertSettlementDetail> list = this.getMertSettlementDetail(requestMertSettlementDetail);
			
			for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
				MertSettlementDetail mertSettlementDetail2 = (MertSettlementDetail) iterator2
						.next();
				try {
					//计算结算金额CalculateUtil
					//遇到保证金归还设置为记账成功，结算为已经结算
					if((mertSettlementDetail2.getAmountType().equals(FinanceTypeEnum.RETURN_SECURITY_DEPOSIT.getCode()))){
						mertSettlementDetail2.setAccountingTime(new Date());
						mertSettlementDetail2.setAccountingStatus(AcctPipeLogStatusTypeEnum.SUCCESS.getCode());
						mertSettlementDetail2.setSettleStatus(SettleEnum.SETTLED.getCode());
					}else{
						//获取单条记录获取获取对应数据修复
						if(mertSettlementDetail2.getSettleCurrency().equals(mertSettlementDetail2.getTransCurrency())){
							BigDecimal settleRatebigDecimal =new BigDecimal("1");
							mertSettlementDetail2.setSettleRate(settleRatebigDecimal.setScale(6,BigDecimal.ROUND_HALF_UP));
						}else{
							//支付方式为信用卡支付
							if(mertSettlementDetail2.getPayMethod().equals(PayTypeEnum.CardsAccepted.getCode())){
								//获取结算币种和交易币种查询配置汇率
								BigDecimal exchangeRate=this.getExchangeRate(mertSettlementDetail2);
								if(exchangeRate ==null){
									//设置不结算报警
									continue;
								}
								mertSettlementDetail2.setSettleRate(exchangeRate.setScale(6,BigDecimal.ROUND_HALF_UP));
							}
						}
						BigDecimal origAmount=mertSettlementDetail2.getTransAmount().multiply(mertSettlementDetail2.getSettleRate());
						BigDecimal settelAmount =CalculateUtil.roundMoney(origAmount, mertSettlementDetail2.getSettleCurrency());
						mertSettlementDetail2.setSettleAmount(settelAmount);
						mertSettlementDetail2.setSettleTime(new Date());
						mertSettlementDetail2.setSettleStatus(SettleEnum.SETTLED.getCode());
					}
					//消费和预授权进行生成保证金
					if(mertSettlementDetail2.getTransType().equals(TradeTypeEnum.SALE.getNumeric()) || mertSettlementDetail2.getTransType().equals(TradeTypeEnum.CAPTURE.getNumeric())){
						//本金进行生成保证金
						if(mertSettlementDetail2.getAmountType().equals(FinanceTypeEnum.PRINCIPAL.getCode())){
							if(!mertSettlementDetail2.getDepositStatus().equals(DepositStatusEnums.SUCCESS)){
								createMertSettlementCashDepositFromMertSettlementDetail(mertSettlementDetail2);
							}
						}
					}                                                            
					//消费 /预授权完成/退款业务不处理，修改结算状态和记账状态
					if(mertSettlementDetail2.getTransType().equals(TradeTypeEnum.REFUND.getNumeric()) || mertSettlementDetail2.getTransType().equals(TradeTypeEnum.SALE.getNumeric()) || mertSettlementDetail2.getTransType().equals(TradeTypeEnum.CAPTURE.getNumeric())){
						//本金进行修改记账状态和保证金状态
						if(mertSettlementDetail2.getAmountType().equals(FinanceTypeEnum.PRINCIPAL.getCode())){
							mertSettlementDetail2.setAccountingTime(new Date());
							mertSettlementDetail2.setAccountingStatus(AcctPipeLogStatusTypeEnum.SUCCESS.getCode());
							mertSettlementDetail2.setDepositStatus(DepositStatusEnums.SUCCESS.getCode());
							mertSettlementDetail2.setSettleStatus(SettleEnum.SETTLED.getCode());
						}
					}
					mertSettlementDetail2.setGmtUpdateTime(new Date());
					this.updateByPrimaryKeySelective(mertSettlementDetail2);
				} catch (Exception e) {
					logger.error("结算预处理异常",e.getMessage());
					throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "更新结算汇率异常");
				}
			}
		}
		 logger.info("结算预处理结束",JSONObject.toJSON(record));
	 }
	
	/**
     * @des    处理结算明细记账
     * @param  mertSettlementDetail 自定义参数
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
     * @data   <a>2018-07-09<a>
     * @plan   执行计划 2018-**-** 00-01-00
     * */
	 public  CreateMermberAccountFeeResponse dealMertSettlementDetailAccount(MertSettlementDetail mertSettlementDetail,String dealCode) throws BusinessException{
 	      logger.info("结算明细记账开始",JSONObject.toJSON(mertSettlementDetail));
		 mertSettlementLogService.createMertSettlementLog(mertSettlementDetail.getSettleDate(),"01","00",BussTypeEnums.SETTLE_ACCOUNT.getDesc(),BussTypeEnums.SETTLE_ACCOUNT.getCode(),LogStatusEnums.INIT.getCode());
		 //开始调用记账接口
		CreateAccountingRequest request =new CreateAccountingRequest();
		request.setProdCode(AccountConstantConstant.PRODUCT_NO);
		request.setSceneCode(dealCode);
		request.setTradeType(mertSettlementDetail.getTransType());
		request.setFinanceType(mertSettlementDetail.getAmountType());
		request.setSysTraceNo(mertSettlementDetail.getOrderId());
		request.setTxnOrderNo(mertSettlementDetail.getMerchantOrderId());
		request.setMerchantOrderNo(mertSettlementDetail.getMerchantOrderId());
		request.setUserId(mertSettlementDetail.getMerchantId());
		request.setUserName(mertSettlementDetail.getMerchantName());
		request.setTxnTime(mertSettlementDetail.getPayCompleteTime());
		request.setRequestId(mertSettlementDetail.getId());
		List<CreateAccountingAmount> accountingAmountList =new ArrayList<CreateAccountingAmount>();
		//上送交易币种
		CreateAccountingAmount accountingAmount =new CreateAccountingAmount();
		accountingAmount.setAmount(mertSettlementDetail.getTransAmount().abs());
		accountingAmount.setCurrency(mertSettlementDetail.getTransCurrency());
		accountingAmount.setVoucherNo(mertSettlementDetail.getOriId());
		accountingAmount.setCurrencyType(CurrencyTypeEnum.TRANSACTION.getCode());
		//封装记账对象
		accountingAmountList.add(accountingAmount);
 		request.setList(accountingAmountList);
 		
 		//调用记账接口
		logger.info("调用记账接口开始",JSONObject.toJSON(request));
		CreateMermberAccountFeeResponse createMermberAccountFeeResponse =accountingRuleFacadeQueryRpcClient.createAccountFeeRule(request);
		logger.info("调用记账接口结束",JSONObject.toJSON(createMermberAccountFeeResponse));
		
		if(!BaseRespStatusEnum.SUCCESS.getCode().equals(createMermberAccountFeeResponse.getResponseStatus())){
			logger.error("结算明细记账异常",createMermberAccountFeeResponse.getResponseMsg());
			mertSettlementDetail.setAccountingStatus(createMermberAccountFeeResponse.getAccountingStatus());
			mertSettlementDetail.setAccountingTime(createMermberAccountFeeResponse.getAccountingTime());
			mertSettlementDetail.setGmtUpdateTime(new Date());
			this.updateByPrimaryKeySelective(mertSettlementDetail);
			mertSettlementLogService.createMertSettlementLog(mertSettlementDetail.getSettleDate(),"01","00",createMermberAccountFeeResponse,BussTypeEnums.SETTLE_ACCOUNT.getCode(),LogStatusEnums.FAILED.getCode());
			return createMermberAccountFeeResponse;
		}
		mertSettlementLogService.createMertSettlementLog(mertSettlementDetail.getSettleDate(),"01","00",createMermberAccountFeeResponse,BussTypeEnums.SETTLE_ACCOUNT.getCode(),LogStatusEnums.SUCCESS.getCode());
		//更新结算明细的记账状态、记账流水号和记账时间，如果记账失败，需要重试，超过重试次数告警人工介入
		//需要增加几个字段  1、记账状态 2、记账流水号 3、 记账时间
		mertSettlementDetail.setAccountingId(createMermberAccountFeeResponse.getAccountingId());
		mertSettlementDetail.setAccountingStatus(createMermberAccountFeeResponse.getAccountingStatus());
		mertSettlementDetail.setAccountingTime(createMermberAccountFeeResponse.getAccountingTime());
		mertSettlementDetail.setDepositStatus(DepositStatusEnums.SUCCESS.getCode());
		mertSettlementDetail.setGmtUpdateTime(new Date());
		this.updateByPrimaryKeySelective(mertSettlementDetail);
		logger.error("结算明细记账结束",JSONObject.toJSON(mertSettlementDetail));
		return createMermberAccountFeeResponse;
	}
	 
	/**
     * @des	        处理结算明细生成结算单任务处理批次 
     * @param  
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
	 * @throws BusinessException 
     * @data   <a>2018-07-09<a>
     * @plan   3. 按商户号+结算类型+结算币种+费用结算方式维度统计所有当批次的且清算日期为当日的所有未清算明细汇总结算明细生成结算单
     * */
	@Override
	public List<MertSettlementTask> createMertSettlementTaskFromMertSettlementDetail(MertSettlementDetail mertSettlementDetail) throws BusinessException{
		logger.info("根据当日结算明细设计的商户生成结算任务开始",JSONObject.toJSON(mertSettlementDetail));
		List<MertSettlementDetail> list=mertSettlementDetailMapper.getSumMertSettlementDetailTask(mertSettlementDetail);
		List<MertSettlementTask> mertSettlementTaskListRes=new ArrayList<MertSettlementTask>();
		if(null == list || list.size() ==0 ){
			return mertSettlementTaskListRes; 
		}
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			MertSettlementDetail reqMertSettlementDetail = (MertSettlementDetail) iterator
					.next();
			List<MertSettlementTask> mertSettlementTaskList =mertSettlementTaskService.getPendingSettlementTaskList(reqMertSettlementDetail.getMerchantId(),SettleEnum.OUTSTANDING.getCode());
			if(mertSettlementTaskList.size()>0){
				logger.info("根据当前用户存在未处理的结算任务",JSONObject.toJSON(mertSettlementTaskList));
				for (Iterator iterator2 = mertSettlementTaskList.iterator(); iterator2
						.hasNext();) {
					MertSettlementTask mertSettlementTask = (MertSettlementTask) iterator2
							.next();
					mertSettlementTaskListRes.add(mertSettlementTask);
				}
			}else{
				//生成商戶结算任务单
				MertSettlementTask mertSettlementTask=	createMertSettlementTask(reqMertSettlementDetail,mertSettlementDetail.getSettleDate());
				mertSettlementTaskListRes.add(mertSettlementTask);
			}
		}
		logger.info("根据当日结算明细设计的商户生成结算任务结束",JSONObject.toJSON(mertSettlementTaskListRes));
		mertSettlementLogService.createMertSettlementLog(mertSettlementDetail.getSettleDate(),"01","00",mertSettlementTaskListRes,BussTypeEnums.SETTLE_TASK.getCode(),LogStatusEnums.SUCCESS.getCode());
		return mertSettlementTaskListRes;
	}
	/**
     * @des    根据结算币种和订单币种查询结算汇率
     * @param  record 自定义参数
     * @return 返回结算汇率
     * @author yuyao
     * @data   <a>2018-07-09<a>
     * @plan   执行计划 2018-**-** 00-01-00
     * */
	 public BigDecimal getExchangeRate(MertSettlementDetail record){
		return settlementRateQueryRpcClient.querySettlementRate(record.getTransCurrency(), record.getMerchantId(), record.getTransAmount().longValue(),
			EnumMappingUtil.getCardOrgByPayKind(record.getPayKind()), record.getSettleCurrency());
	 }
	 
 	/**
     * 根据系统获取所有结算明细进行预处理
     * @param record
     */
	public List<MertSettlementDetail> getMertSettlementDetailDeposit(MertSettlementDetail record) {
		logger.info("MertSettlementDetailServiceImpl query MertSettlementDetail list bengin request={}",record);
		List<MertSettlementDetail> list=this.mertSettlementDetailMapper.getMertSettlementDetailDeposit(record);
		logger.info("MertSettlementDetailServiceImpl query MertSettlementDetail list end request={}",list);
		return list;
	}

 	/**
     * 根据商户编号和结算单编号 获取结算单明细
     */
	@Override
	public List<MertSettlementDetail> getMertSettlementDetailListByMerchantId(
			MertSettlementDetail mertSettlementDetail) {
		return mertSettlementDetailMapper.selectList(mertSettlementDetail);
	}

	/**
     * 获取保证金生成失败需要重新生成的保证金数据
	 * @throws BusinessException 
     */
	@Override
	public void dealMertSettlementCashDepositFromMertSettlementDetail(MertSettlementDetail mertSettlementDetail) throws BusinessException {
		mertSettlementDetail.setDepositStatus(DepositStatusEnums.FAILED.getCode());
		List<MertSettlementDetail> list = this.getMertSettlementDetailDeposit(mertSettlementDetail);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			MertSettlementDetail mertSettlementDetail1 = (MertSettlementDetail) iterator
					.next();
			createMertSettlementCashDepositFromMertSettlementDetail(mertSettlementDetail1);
		}
	}

	@Override
	public List<MertSettlementDetail> getMertSettlementDetailListByMerchantIdReport(
			MertSettlementDetail mertSettlementDetail) {
		return mertSettlementDetailMapper.getMertSettlementDetailListByMerchantIdReport(mertSettlementDetail);
	}

	@Override
	public int updateMertSettlementDetail1Id(
			MertSettlementDetail mertSettlementDetail) {
		return mertSettlementDetailMapper.updateMertSettlementDetail1Id(mertSettlementDetail);
	}

	/**
     * 处理由于结算单异常影响的结算明细
     *
     * @param mertSettlementOrderList 异常结算单
	 * @return 
     */
	@Override
	public void dealMertSettlementOrderAbortDetail(
			List<MertSettlementOrder> mertSettlementOrderList) throws BusinessException{
		 mertSettlementLogService.createMertSettlementLog("","01","00",mertSettlementOrderList,BussTypeEnums.SETTLE_ERROR_ORDER.getCode(),LogStatusEnums.INIT.getCode());
		 if(mertSettlementOrderList!=null){
			 for (Iterator iterator = mertSettlementOrderList.iterator(); iterator
					.hasNext();) {
				MertSettlementOrder mertSettlementOrderError = (MertSettlementOrder) iterator
						.next();
				List<MertSettlementDetail> mertSettlementDetailError =mertSettlementDetailMapper.getDealMertSettlementOrderAbortDetail(mertSettlementOrderError.getMerchantId(),mertSettlementOrderError.getSettlementOrderId());
				mertSettlementLogService.createMertSettlementLog("","01","00",mertSettlementDetailError,BussTypeEnums.SETTLE_ERROR_DETAIL.getCode(),LogStatusEnums.INIT.getCode());
				for (Iterator iterator2 = mertSettlementDetailError.iterator(); iterator2
						.hasNext();) {
					MertSettlementDetail mertSettlementDetail = (MertSettlementDetail) iterator2
							.next();
					try {
						mertSettlementDetail.setSettleStatus(SettleEnum.OUTSTANDING.getCode());
						mertSettlementDetail.setGmtUpdateTime(new Date());
						int ret =mertSettlementDetailMapper.updateByPrimaryKey(mertSettlementDetail);
						if(ret==0){
							throw new BusinessException(CmpCssExceptionCode.DATA_NOT_EXISTS.getCode(), "更新异常结算明细异常");
						}
					} catch (Exception e) {
						logger.error("mertSettlementDetail query MertSettlementDetailError list end request={}",mertSettlementDetail);
						mertSettlementLogService.createMertSettlementLog("","01","00",mertSettlementDetail,BussTypeEnums.SETTLE_ERROR_DETAIL.getCode(),LogStatusEnums.FAILED.getCode());
						throw new BusinessException(CmpCssExceptionCode.DATA_NOT_EXISTS.getCode(), "更新异常结算明细异常");
					}
				}
				mertSettlementLogService.createMertSettlementLog("","01","00",mertSettlementDetailError,BussTypeEnums.SETTLE_ERROR_DETAIL.getCode(),LogStatusEnums.SUCCESS.getCode());
				mertSettlementOrderError.setIsValid(ValidStatusEnum.NO.getCode());
				mertSettlementOrderService.updateByPrimaryKey(mertSettlementOrderError);
				
			}
		 }
		 mertSettlementLogService.createMertSettlementLog("","01","00",mertSettlementOrderList,BussTypeEnums.SETTLE_ERROR_ORDER.getCode(),LogStatusEnums.SUCCESS.getCode());
	}

	@Override
	public List<MertSettlementDetail> countTradeMerchant() {
		return mertSettlementDetailMapper.countTradeMerchant();
	}
	/**
     * 根据清算主订单ID获取结算明细进行
     *
     * @param record
	 * @return 
     */
	@Override
	public List<MertSettlementDetail> getMertSettlementDetailListByOrderId(
			String orderId) {
		return mertSettlementDetailMapper.getMertSettlementDetailListByOrderId(orderId);
	}
}
