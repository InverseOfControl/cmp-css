package com.ipaylinks.cmp.css.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.csvreader.CsvWriter;
import com.ipaylinks.acct.facade.enums.AcctPipeLogStatusTypeEnum;
import com.ipaylinks.cmp.css.dal.mapper.MertSettlementSummaryMapper;
import com.ipaylinks.cmp.css.dal.model.MertSettlementDetail;
import com.ipaylinks.cmp.css.dal.model.MertSettlementOrder;
import com.ipaylinks.cmp.css.dal.model.MertSettlementSummary;
import com.ipaylinks.cmp.css.facade.constant.AccountConstantConstant;
import com.ipaylinks.cmp.css.facade.dto.MertSettlementSummaryReportDto;
import com.ipaylinks.cmp.css.facade.enums.BussTypeEnums;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.facade.enums.DealStatusEnum;
import com.ipaylinks.cmp.css.facade.enums.LogStatusEnums;
import com.ipaylinks.cmp.css.facade.enums.SummaryStatusEnums;
import com.ipaylinks.cmp.css.facade.enums.WithdrawStatusEnum;
import com.ipaylinks.cmp.css.integration.act.AccountingRuleFacadeQueryRpcClient;
import com.ipaylinks.cmp.css.integration.dto.CreateAccountingAmount;
import com.ipaylinks.cmp.css.integration.mcs.MerchantSettlementConfigFacadeClient;
import com.ipaylinks.cmp.css.integration.req.CreateAccountingRequest;
import com.ipaylinks.cmp.css.integration.req.QueryMertSettlementCashDepositRequest;
import com.ipaylinks.cmp.css.integration.res.CreateMermberAccountFeeResponse;
import com.ipaylinks.cmp.css.integration.res.QueryMertSettlementCashDepositResponse;
import com.ipaylinks.cmp.css.service.FileUploadFtpService;
import com.ipaylinks.cmp.css.service.MertSettlementDetailService;
import com.ipaylinks.cmp.css.service.MertSettlementLogService;
import com.ipaylinks.cmp.css.service.MertSettlementOrderService;
import com.ipaylinks.cmp.css.service.MertSettlementSummaryService;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.ipaylinks.common.CalculateUtil;
import com.ipaylinks.common.enums.BaseRespStatusEnum;
import com.ipaylinks.common.enums.CurrencyTypeEnum;
import com.ipaylinks.common.enums.FinanceTypeEnum;
import com.ipaylinks.common.enums.TradeTypeEnum;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.File;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service("mertSettlementSummaryService")
public class MertSettlementSummaryServiceImpl implements
		MertSettlementSummaryService {
	
	private Logger logger = LoggerFactory.getLogger(MertSettlementSummaryServiceImpl.class);


	@Autowired(required = false)
	private MertSettlementSummaryMapper  mertSettlementSummaryMapper;
	
	@Autowired
	private  MertSettlementOrderService  mertSettlementOrderService;
	
	@Autowired
	private  MertSettlementDetailService  mertSettlementDetailService;
	
	@Autowired
	private  MerchantSettlementConfigFacadeClient merchantSettlementConfigFacadeClient;
	
	@Autowired
	private  AccountingRuleFacadeQueryRpcClient accountingRuleFacadeQueryRpcClient;
	@Autowired
	private TransactionTemplate transactionTemplate;
	@Autowired(required = false)
	private FileUploadFtpService fileUploadFtpService;
	
	@Autowired
	private MertSettlementLogService mertSettlementLogService;
	@Override
	public int deleteByPrimaryKey(String id) {
		return mertSettlementSummaryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(MertSettlementSummary record) {
		return mertSettlementSummaryMapper.insert(record);
	}

	@Override
	public int insertSelective(MertSettlementSummary record) {
		return mertSettlementSummaryMapper.insertSelective(record);
	}

	@Override
	public MertSettlementSummary selectByPrimaryKey(String id) {
		return mertSettlementSummaryMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(MertSettlementSummary record) {
		return mertSettlementSummaryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MertSettlementSummary record) {
		return mertSettlementSummaryMapper.updateByPrimaryKey(record);
	}

	@Override
	public String getSettleSummaryOrderId() {
		return mertSettlementSummaryMapper.getSettleSummaryOrderId();
	}

	@Override
	public List<MertSettlementSummary> getMertSettlementSummaryList(MertSettlementSummary mertSettlementSummary) {
		return mertSettlementSummaryMapper.selectList(mertSettlementSummary);
	}

	 
    private final static String[] summaryHeader={"序号","商户编号","商户名称","结算日期"};
    private final static String[] orderHeader={"序号","结算币种","结算金额"};
    private final static String[] detailHeader={"序号","商户编号","订单日期","商户订单号","网关订单号","订单类型","订单币种","订单金额","结算币种","结算金额","费用类型","支付方式","渠道号","原商户订单号"};
	/**
     * @des    处理结算汇总单对应的结算单记账失败的补偿记账
     * @param  dealCode 自定义参数:记账类型
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
	 * @throws BusinessException 
     * @data   <a>2018-07-09<a>
     * */
	@Override
	public void dealMertSettlementOrderAccountError(String dealCode) throws BusinessException {
		MertSettlementOrder mertSettlementOrderRequest =new MertSettlementOrder();
		mertSettlementOrderRequest.setAccountingStatus(AcctPipeLogStatusTypeEnum.FAIL.getCode());
    	//获取清算子订单记账失败的记录
    	try {
    		List<MertSettlementOrder> mertSettlementOrderList = mertSettlementOrderService.getMertSettlementOrderAccountErrorDetail(mertSettlementOrderRequest);
    		for (Iterator iterator = mertSettlementOrderList.iterator(); iterator
					.hasNext();) {
				MertSettlementOrder mertSettlementOrder = (MertSettlementOrder) iterator
						.next();
				mertSettlementOrder.setAccountingStatus(AcctPipeLogStatusTypeEnum.INITIAL.getCode());
				mertSettlementOrder.setSummaryStatus(SummaryStatusEnums.INIT.getCode());
				mertSettlementOrderService.updateByPrimaryKeySelective(mertSettlementOrder);
			}
    	} catch (Exception e) {
			 throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "清算子订单补偿记账失败");
		}
	}

	/**
     * @des    根据结算单数据生成结算汇总单
     * @return 以商户号+结算币种为维度查询结算单中结算单日期为当前结算处理日期、结算单状态为未汇总、
     * 		        费用结算方式为内收的结算单，如果汇总金额大于起结金额，则生成结算汇总单，否则不生成结算汇总单
     * @author yuyao
     * @data   <a>2018-07-09<a>
     * */
	@Override
	public void createMertSettlementSummary(MertSettlementOrder record) throws BusinessException{
		//获取结算待汇总结算单明细
		logger.info("生成结算汇总单开始", JSONObject.toJSON(record));
		List<MertSettlementOrder> mertSettlementOrderList =mertSettlementOrderService.getSettlementOrderList(record);
		List<MertSettlementSummary> listMertSettlementSummary  =new ArrayList<MertSettlementSummary>();
		for (Iterator iterator = mertSettlementOrderList.iterator(); iterator
				.hasNext();) {
			MertSettlementOrder mertSettlementOrder = (MertSettlementOrder) iterator
					.next();
			boolean result;
				try {
					result = transactionTemplate.execute(new TransactionCallback<Boolean>() {
		                @Override
		                public Boolean doInTransaction(TransactionStatus transactionStatus) {
		                    try {
	                    		String summaryOrderId =getSettleSummaryOrderId();
								MertSettlementSummary mertSettlementSummary =new MertSettlementSummary();
								mertSettlementSummary.setSummaryOrderId(summaryOrderId);
								mertSettlementSummary.setMerchantId(mertSettlementOrder.getMerchantId());
								mertSettlementSummary.setMerchantName(mertSettlementOrder.getMerchantName());
								mertSettlementSummary.setSummaryAmount(mertSettlementOrder.getSettleAmount());
								mertSettlementSummary.setSummaryDate(record.getSettlementDate());
								mertSettlementSummary.setSummaryCurrency(mertSettlementOrder.getSettleCurrency());
								mertSettlementSummary.setBeginDate(mertSettlementOrder.getOrderBeginDate());
								mertSettlementSummary.setEndDate(mertSettlementOrder.getOrderEndDate());
								mertSettlementSummary.setDealStatus(DealStatusEnum.INIT.getCode());
								//获取商户结算结算金额
								QueryMertSettlementCashDepositRequest request =new QueryMertSettlementCashDepositRequest();
								request.setMerchantId(mertSettlementOrder.getMerchantId());
								request.setTransCurrency(mertSettlementOrder.getSettleCurrency());
								QueryMertSettlementCashDepositResponse response =new QueryMertSettlementCashDepositResponse();
								logger.info("查询结算金额是否为起结金额", JSONObject.toJSON(request));
								response =merchantSettlementConfigFacadeClient.queryMertSettlementCashDeposit(request);
								//判断结算金额是否大于起接金额,设置自动提现标签
								if(mertSettlementOrder.getSettleAmount().compareTo(response.getSettleAmount())>0){
									mertSettlementSummary.setAutoWithdrawFlag(WithdrawStatusEnum.iSAutoWithdraw.getCode());
								}else{
									mertSettlementSummary.setAutoWithdrawFlag(WithdrawStatusEnum.autoWithdrawFlag.getCode());
								}
								mertSettlementSummary.setWithdrawStatus(WithdrawStatusEnum.unpaidAmount.getCode()); //未出款
								logger.info("生成汇总单完成", JSONObject.toJSON(mertSettlementSummary));
								int ret =mertSettlementSummaryMapper.insertSelective(mertSettlementSummary);
								if(ret>0){
									listMertSettlementSummary.add(mertSettlementSummary);
						        }
								//更新结算单汇总单号
					            MertSettlementOrder updateMertSettlementOrder =new MertSettlementOrder();
					            updateMertSettlementOrder.setSummaryStatus(SummaryStatusEnums.INIT.getCode());
					            updateMertSettlementOrder.setSettlementSummaryId(summaryOrderId);
					            updateMertSettlementOrder.setSettleCurrency(mertSettlementOrder.getSettleCurrency());
					            updateMertSettlementOrder.setSettlementDate(mertSettlementOrder.getSettlementDate());
					            updateMertSettlementOrder.setMerchantId(mertSettlementOrder.getMerchantId());
					            updateMertSettlementOrder.setGmtUpdateTime(new Date());
								//更新
								mertSettlementOrderService.updateMertSettlementOrder(updateMertSettlementOrder);
								
		                    }catch (Exception e) {
		                        logger.error("结算汇总单生成异常", e);
		                        transactionStatus.setRollbackOnly();
		                        return false;
		                    }
		                    return true;
			                }
						});
			        } catch (Exception e) {
			            logger.error("结算汇总单生成异常", e);
			            result = false;
			       }
				   if(!result){
			           throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "结算汇总单生成异常");
			       }
				   /*//汇总金额
				   logger.info("修复汇总单汇总金额", JSONObject.toJSON(mertSettlementSummaryList));
				   dealMertSettlementSummaryAmount(mertSettlementSummaryList);*/
		}
		logger.info("汇总单对应的结算单进行记账", JSONObject.toJSON(record));
		for (Iterator iterator2 = listMertSettlementSummary.iterator(); iterator2
			.hasNext();) {
			System.out.println("");
		   MertSettlementSummary mertSettlementSummary2 = (MertSettlementSummary) iterator2
				.next();
		   getMertSettlementSummary(mertSettlementSummary2.getMerchantId(),mertSettlementSummary2.getSummaryCurrency());
		}
		logger.info("生成结算汇总单结束", JSONObject.toJSON(record));
		
	}
	
	/**
     * @des	        根据当前汇总单查询需要进行记账的汇总单
     * @param   merchantId 商户号
     * @param   settleCurrency  结算币种
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
	 * @throws BusinessException
     * */
	public List<MertSettlementSummary> getMertSettlementSummary(String merchantId,String summaryCurrency) throws BusinessException{
		//获取当前用户所有未处理，未记账的汇总单进行统计是否需要记账
		logger.info("统计当前汇总单是否需要记账处理", JSONObject.toJSON(merchantId),JSONObject.toJSON(summaryCurrency));
		List<MertSettlementSummary> listMertSettlementSummary =mertSettlementSummaryMapper.getMertSettlementSummaryList(merchantId,summaryCurrency,DealStatusEnum.INIT.getCode());
		BigDecimal settleAmount =BigDecimal.ZERO; 
		for (Iterator iterator = listMertSettlementSummary.iterator(); iterator
				.hasNext();) {
			MertSettlementSummary mertSettlementSummary = (MertSettlementSummary) iterator
					.next();
			//汇总需要记账的汇总单金额
			settleAmount =settleAmount.add(mertSettlementSummary.getSummaryAmount());
		}	
    	if(settleAmount.compareTo(new BigDecimal("0"))>0){
    		//结算汇总单记账处理
    		for (Iterator iterator2 = listMertSettlementSummary.iterator(); iterator2
    				.hasNext();) {
				MertSettlementSummary mertSettlementSummary2 = (MertSettlementSummary) iterator2
						.next();
				MertSettlementOrder mertSettlementOrderAccount =new MertSettlementOrder();
				mertSettlementOrderAccount.setAccountingStatus(AcctPipeLogStatusTypeEnum.INITIAL.getCode());
				mertSettlementOrderAccount.setSettlementSummaryId(mertSettlementSummary2.getSummaryOrderId());
				mertSettlementOrderAccount.setSummaryStatus(SummaryStatusEnums.SUCCESS.getCode());
				mertSettlementOrderAccount.setSettlementDate(mertSettlementSummary2.getSummaryDate());
				mertSettlementOrderAccount.setMerchantId(mertSettlementSummary2.getMerchantId());
			    String dealCode=AccountConstantConstant.DEAL_SETTLE_ORDER_CODE;
			    logger.info("结算单记账开始", JSONObject.toJSON(mertSettlementOrderAccount));
			    CreateMermberAccountFeeResponse response=dealMertSettlementOrderAcccount(mertSettlementOrderAccount,dealCode);
			    logger.info("结算单记账结束", JSONObject.toJSON(response));
			    if(!BaseRespStatusEnum.SUCCESS.getCode().equals(response.getResponseStatus())){
			    	 //修改汇总单处理状态
				    mertSettlementSummary2.setDealStatus(DealStatusEnum.FAILED.getCode());
			    }else{
			    	 //修改汇总单处理状态
				    mertSettlementSummary2.setDealStatus(DealStatusEnum.SUCCESS.getCode());
			    }
			    mertSettlementSummary2.setGmtUpdateTime(new Date());
			    mertSettlementSummaryMapper.updateByPrimaryKey(mertSettlementSummary2);
    		}
    	}
	   logger.info("当前记录的了需要记账的结算汇总单信息", JSONObject.toJSON(listMertSettlementSummary));
	   return listMertSettlementSummary;
	}
	/**
     * @des	        根据结算单进行记账
     * @param  mertSettlementSummaryList 结算单明细记录，状态为记账待结算结算单记账处理
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
	 * @throws BusinessException
     * */
	private CreateMermberAccountFeeResponse dealMertSettlementOrderAcccount(MertSettlementOrder mertSettlementOrder,String dealCode)  throws BusinessException{
		 logger.info("结算单记账开始", JSONObject.toJSON(mertSettlementOrder));
		CreateMermberAccountFeeResponse createMermberAccountFeeResponse =new CreateMermberAccountFeeResponse();	
			//获取需要记账的结算单信息
			List<MertSettlementOrder> mertSettlementOrderList =mertSettlementOrderService.getMertSettlementOrderListByAccount(mertSettlementOrder);
			for (Iterator iterator1 = mertSettlementOrderList.iterator(); iterator1
					.hasNext();) {
				MertSettlementOrder mertSettlementOrder2 = (MertSettlementOrder) iterator1
						.next();
				//防止重复记账
				if(mertSettlementOrder2.getAccountingStatus().equals(AcctPipeLogStatusTypeEnum.SUCCESS.getCode())){
					continue;
				}
				if(mertSettlementOrder2.getSettleAmount().compareTo(BigDecimal.ZERO)==0){
					mertSettlementOrder2.setAccountingStatus(AcctPipeLogStatusTypeEnum.SUCCESS.getCode());
					mertSettlementOrder2.setAccountingTime(new Date());
					mertSettlementOrder2.setSummaryStatus(SummaryStatusEnums.SUCCESS.getCode());
					logger.info("当前结算单金额为零无需记账",JSONObject.toJSON(mertSettlementOrder2));
					mertSettlementOrderService.updateByPrimaryKey(mertSettlementOrder2);
					continue;
				}
				CreateAccountingRequest request =new CreateAccountingRequest();
				request.setProdCode(AccountConstantConstant.PRODUCT_NO);
				request.setSceneCode(dealCode);
				request.setTradeType(mertSettlementOrder2.getTransType());
				request.setFinanceType(mertSettlementOrder2.getAmountType());
				request.setUserId(mertSettlementOrder2.getMerchantId());
				request.setUserName(mertSettlementOrder2.getMerchantName());
				request.setTxnTime(new Date());
				request.setTxnOrderNo(mertSettlementOrder2.getSettlementOrderId());
				request.setRequestId(mertSettlementOrder2.getSettlementOrderId());
				List<CreateAccountingAmount> accountingAmountList =new ArrayList<CreateAccountingAmount>();
				
				//如果是保证金，则不拼装交易数据
				if(mertSettlementOrder2.getAmountType().equals(FinanceTypeEnum.CHARGE_SECURITY_DEPOSIT.getCode()) || mertSettlementOrder2.getAmountType().equals(FinanceTypeEnum.RETURN_SECURITY_DEPOSIT.getCode())){
					//上送结算币种
					CreateAccountingAmount accountingAmountSettle =new CreateAccountingAmount();
					accountingAmountSettle.setAmount(mertSettlementOrder2.getSettleAmount().abs());
					accountingAmountSettle.setCurrency(mertSettlementOrder2.getSettleCurrency());
					accountingAmountSettle.setVoucherNo(mertSettlementOrder2.getSettlementOrderId());
					accountingAmountSettle.setCurrencyType(CurrencyTypeEnum.MERCHANT_SETTLEMENT.getCode());
					accountingAmountList.add(accountingAmountSettle);
					request.setList(accountingAmountList);
				}else{
					//上送交易币种
					CreateAccountingAmount accountingAmountTrade =new CreateAccountingAmount();
					accountingAmountTrade.setAmount(mertSettlementOrder2.getTransAmount().abs());
					accountingAmountTrade.setCurrency(mertSettlementOrder2.getTransCurrency());
					accountingAmountTrade.setVoucherNo(mertSettlementOrder2.getSettlementOrderId());
					accountingAmountTrade.setCurrencyType(CurrencyTypeEnum.TRANSACTION.getCode());
					accountingAmountList.add(accountingAmountTrade);
					//上送结算币种
					CreateAccountingAmount accountingAmountSettle =new CreateAccountingAmount();
					accountingAmountSettle.setAmount(mertSettlementOrder2.getSettleAmount().abs());
					accountingAmountSettle.setCurrency(mertSettlementOrder2.getSettleCurrency());
					accountingAmountSettle.setVoucherNo(mertSettlementOrder2.getSettlementOrderId());
					accountingAmountSettle.setCurrencyType(CurrencyTypeEnum.MERCHANT_SETTLEMENT.getCode());
					//封装记账对象
					accountingAmountList.add(accountingAmountSettle);
					request.setList(accountingAmountList);
				}
		 		//调用记账接口
				logger.info("结算单记账调用记账接口", JSONObject.toJSON(request));
				createMermberAccountFeeResponse =accountingRuleFacadeQueryRpcClient.createAccountFeeRule(request);
				logger.info("结算单记账调用记账接口", JSONObject.toJSON(createMermberAccountFeeResponse));
				
				if(!BaseRespStatusEnum.SUCCESS.getCode().equals(createMermberAccountFeeResponse.getResponseStatus())){
					mertSettlementOrder2.setAccountingStatus(createMermberAccountFeeResponse.getAccountingStatus());
					mertSettlementOrder2.setAccountingTime(new Date());
					mertSettlementOrder2.setSummaryStatus(SummaryStatusEnums.FAILED.getCode());
					logger.info("update set  mert settle order status  error ={}","结算单记账状态异常");
				}else{
					mertSettlementOrder2.setAccountingId(createMermberAccountFeeResponse.getAccountingId());
					mertSettlementOrder2.setAccountingStatus(createMermberAccountFeeResponse.getAccountingStatus());
					mertSettlementOrder2.setAccountingTime(createMermberAccountFeeResponse.getAccountingTime());
					mertSettlementOrder2.setSummaryStatus(SummaryStatusEnums.SUCCESS.getCode());
				}
				mertSettlementOrder2.setGmtUpdateTime(new Date());
				mertSettlementLogService.createMertSettlementLog(mertSettlementOrder2.getSettlementDate(),"01","00",createMermberAccountFeeResponse,BussTypeEnums.SETTLE_SUMMARY_BOOK.getCode(),LogStatusEnums.SUCCESS.getCode());
				try {
					mertSettlementOrderService.updateByPrimaryKey(mertSettlementOrder2);
				} catch (Exception e) {
					logger.error("结算单记账异常", e.getMessage());
					mertSettlementLogService.createMertSettlementLog(mertSettlementOrder.getSettlementDate(),"01","00",createMermberAccountFeeResponse,BussTypeEnums.SETTLE_SUMMARY_BOOK.getCode(),LogStatusEnums.FAILED.getCode());
					return createMermberAccountFeeResponse;
				}
			}
			 logger.info("结算单记账结束", JSONObject.toJSON(createMermberAccountFeeResponse));
		return createMermberAccountFeeResponse;
	}

	/**
     * @des	        根据结算日期生成商户结算汇总对账单
     * @param  summaryDate 汇总单日期
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
	 * @throws BusinessException 
     * */
	@Override
	public void createMertSettlementSummaryAccount(String merchantId,String summaryDate)
			throws BusinessException {
		try {
			List<MertSettlementSummary> mertSettlementSummaryHeaderList =mertSettlementSummaryMapper.getSettleSummaryHeaderList(merchantId,summaryDate);
			if(mertSettlementSummaryHeaderList.isEmpty()){
				//针对没有交易的商户进行推送空的交易对账单
				MertSettlementSummary mertSettlementSummaryHeader =new MertSettlementSummary();
				mertSettlementSummaryHeader.setSummaryDate(summaryDate);
				List<MertSettlementSummary> mertSettlementSummaryBodyList =new ArrayList<MertSettlementSummary>();
				List<MertSettlementOrder> mertSettlementOrderBodyList = new ArrayList<MertSettlementOrder>();
				List<MertSettlementDetail> mertSettlementDetailBodyList = new ArrayList<MertSettlementDetail>();
				createSettlementSummaryAccountFile(mertSettlementSummaryHeader,mertSettlementSummaryBodyList,mertSettlementOrderBodyList,mertSettlementDetailBodyList);
			}else{
				//商户有交易数据则出结算对账单
				for (Iterator iterator = mertSettlementSummaryHeaderList.iterator(); iterator
						.hasNext();) {
					MertSettlementSummary mertSettlementSummaryHeader = (MertSettlementSummary) iterator
							.next();
					//获取汇总单体
					List<MertSettlementSummary> mertSettlementSummaryBodyList =mertSettlementSummaryMapper.getSettleSummaryOrderList(mertSettlementSummaryHeader);
					//生成结算单体
					List<MertSettlementOrder> mertSettlementOrderBodyList=new ArrayList<MertSettlementOrder>();
					//生成结算明细体
					List<MertSettlementDetail> mertSettlementDetailBodyList=new ArrayList<MertSettlementDetail>();
					for (Iterator iterator5 = mertSettlementSummaryBodyList.iterator(); iterator5
							.hasNext();) {
						MertSettlementSummary mertSettlementSummary = (MertSettlementSummary) iterator5
								.next();
						MertSettlementOrder mertSettlementOrder =new MertSettlementOrder();
						mertSettlementOrder.setMerchantId(mertSettlementSummary.getMerchantId());
						mertSettlementOrder.setSettlementSummaryId(mertSettlementSummary.getSummaryOrderId());
						mertSettlementOrder.setSettlementDate(mertSettlementSummary.getSummaryDate());
						mertSettlementOrder.setSettleCurrency(mertSettlementSummary.getSummaryCurrency());
						//根据商户编码和结算汇总编号获取结算单明细
						List<MertSettlementOrder> mertSettlementOrderList =mertSettlementOrderService.getMertSettlementOrderListForReport(mertSettlementOrder);
						for (Iterator iterator2 = mertSettlementOrderList.iterator(); iterator2
								.hasNext();) {
							MertSettlementOrder mertSettlementOrder1 = (MertSettlementOrder) iterator2
									.next();
							mertSettlementOrderBodyList.add(mertSettlementOrder1);
							//根据结算单编号获取结算明细
							MertSettlementDetail mertSettlementDetail =new MertSettlementDetail();
							mertSettlementDetail.setMerchantId(mertSettlementOrder1.getMerchantId());
							mertSettlementDetail.setSettlementId(mertSettlementOrder1.getSettlementOrderId());
							List<MertSettlementDetail> MertSettlementDetailList=mertSettlementDetailService.getMertSettlementDetailListByMerchantIdReport(mertSettlementDetail);
							for (Iterator iterator3 = MertSettlementDetailList
									.iterator(); iterator3.hasNext();) {
								//获取结算明细记录
								MertSettlementDetail mertSettlementDetailBody = (MertSettlementDetail) iterator3
										.next();
								mertSettlementDetailBodyList.add(mertSettlementDetailBody);
							}
						}
					}
					createSettlementSummaryAccountFile(mertSettlementSummaryHeader,mertSettlementSummaryBodyList,mertSettlementOrderBodyList,mertSettlementDetailBodyList);
				} 
			}
		} catch (Exception e) {
			logger.info("create merchant settlement  summary account  error ={}",e);
			throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "生成商户结算汇总对账单异常");
		}
	}
	/**
     * @des	        根据结算日期生成商户结算汇总对账单生成文件
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
	 * @throws BusinessException 
     * */
	private void createSettlementSummaryAccountFile(MertSettlementSummary mertSettlementSummaryHeader,
			List<MertSettlementSummary> mertSettlementSummaryBodyList,
			List<MertSettlementOrder> mertSettlementOrderBodyList,
			List<MertSettlementDetail> mertSettlementDetailBodyList) throws BusinessException{
		 //结算对账单
		 String fileName =mertSettlementSummaryHeader.getSummaryDate()+"settlement.csv";
	     String filePath ="/opt/temp/reconcile_order/"+mertSettlementSummaryHeader.getSummaryDate()+"/"+mertSettlementSummaryHeader.getMerchantId()+"/";
		//String filePath ="C:/StemQ/"+mertSettlementSummaryHeader.getSummaryDate()+"/"+mertSettlementSummaryHeader.getMerchantId()+"/"; 
	    try {

			File file = new File(filePath);
			file.mkdirs();
			filePath = filePath + fileName;
			file = new File(filePath);
			if(file.exists()){
				file.delete();
			}
			file.createNewFile();

    		CsvWriter csvWriter=new CsvWriter(filePath,',', Charset.forName("GBK"));
    		//生成结算汇总单头
    		csvWriter.writeRecord(summaryHeader);
    		for (int i =0;i<mertSettlementSummaryBodyList.size();i++) {
    			MertSettlementSummary mertSettlementSummary = (MertSettlementSummary) mertSettlementSummaryBodyList.get(i);
    			String[] summaryContent={""+(i+1)+"",mertSettlementSummary.getMerchantId(),mertSettlementSummary.getMerchantName(),mertSettlementSummary.getSummaryDate()};
			    //生成结算汇总单明细
    			csvWriter.writeRecord(summaryContent);
			} 
    		//生成结算汇总单头
    		csvWriter.writeRecord(orderHeader);
    		for (int j =0;j<mertSettlementOrderBodyList.size();j++) {
    			MertSettlementOrder mertSettlementOrder = (MertSettlementOrder) mertSettlementOrderBodyList.get(j);
    			String[] orderContent={""+(j+1)+"",mertSettlementOrder.getSettleCurrency(),String.valueOf(mertSettlementOrder.getSettleAmount())};
			    //生成结算单明细
    			csvWriter.writeRecord(orderContent);
			}
    		//生成结算明细单单头
    		csvWriter.writeRecord(detailHeader);
    		for (int k =0;k<mertSettlementDetailBodyList.size();k++) {
    			MertSettlementDetail mertSettlementDetailDto = (MertSettlementDetail) mertSettlementDetailBodyList.get(k);
    			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    			String transDate= sdf.format(mertSettlementDetailDto.getGmtCreateTime());
				String[] detailContent={""+(k+1)+"",mertSettlementDetailDto.getMerchantId(),transDate,mertSettlementDetailDto.getMerchantOrderId(),mertSettlementDetailDto.getOrderId(),TradeTypeEnum.getDescByNumeric(mertSettlementDetailDto.getTransType()),mertSettlementDetailDto.getTransCurrency(),String.valueOf(mertSettlementDetailDto.getTransAmount()),mertSettlementDetailDto.getSettleCurrency(),String.valueOf(mertSettlementDetailDto.getSettleAmount()),FinanceTypeEnum.getMessage(mertSettlementDetailDto.getAmountType()),mertSettlementDetailDto.getPayMethod(),"",""};
				//生成结算明细
				csvWriter.writeRecord(detailContent);
			}
			try {
				fileUploadFtpService.uploadToFtp(mertSettlementSummaryHeader.getMerchantId(), mertSettlementSummaryHeader.getSummaryDate(), filePath);
			}catch (Exception e){
				logger.error("上传商户结算对账单异常", e);
			}
		} catch (Exception e) {
			logger.info("create merchant settlement  summary account  error ={}",e);
		}
	}
	/**
     * @des	       根据汇总单修正汇总单出款金额
     * @param  mertSettlementSummaryList 结算单明细记录，状态已记账已结算结算单进行汇总
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
	 * @throws BusinessException 
     * */
	private void dealMertSettlementSummaryAmount(List<MertSettlementSummary> mertSettlementSummaryList) throws BusinessException{
		for (Iterator iterator = mertSettlementSummaryList.iterator(); iterator
				.hasNext();) {
			MertSettlementSummary mertSettlementSummary = (MertSettlementSummary) iterator
					.next();
			try {
				MertSettlementOrder mertSettlementOrder =new MertSettlementOrder();
				mertSettlementOrder.setSettlementSummaryId(mertSettlementSummary.getSummaryOrderId());
				mertSettlementOrder.setMerchantId(mertSettlementSummary.getMerchantId());
				mertSettlementOrder.setSettleCurrency(mertSettlementSummary.getSummaryCurrency());
				List<MertSettlementOrder> list=mertSettlementOrderService.sumMertSettlementOrderAmount(mertSettlementOrder);
				for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
					MertSettlementOrder mertSettlementOrder1 = (MertSettlementOrder) iterator2
							.next();
					mertSettlementSummary.setSummaryAmount(CalculateUtil.roundMoney(mertSettlementOrder1.getSettleAmount(),mertSettlementOrder.getSettleCurrency()));
					int ret =mertSettlementSummaryMapper.updateByPrimaryKeySelective(mertSettlementSummary);
					 if(ret==0){
		            	 throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "结算汇总单金额修复异常");
		            }
				}
				mertSettlementLogService.createMertSettlementLog(mertSettlementOrder.getSettlementDate(),"01","00",mertSettlementOrder,BussTypeEnums.SETTLE_SUMMARY_BOOK.getCode(),LogStatusEnums.SUCCESS.getCode());
			} catch (Exception e) {
				logger.error("update sumarry amount is error","结算汇总单金额修复异常");
				 throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "结算汇总单金额修复异常");
			}
		}
	}
}
