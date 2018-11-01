package com.ipaylinks.cmp.css.integration.act;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.ipaylinks.common.rpc.ClientEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipaylinks.acct.facade.AccountingFacade;
import com.ipaylinks.acct.facade.AccountingRuleFacade;
import com.ipaylinks.acct.facade.request.AccountingAmount;
import com.ipaylinks.acct.facade.request.AccountingRequest;
import com.ipaylinks.acct.facade.response.WriteRecordResponse;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.integration.dto.CreateAccountingAmount;
import com.ipaylinks.cmp.css.integration.req.CreateAccountingRequest;
import com.ipaylinks.cmp.css.integration.res.CreateMermberAccountFeeResponse;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.ipaylinks.cmp.css.util.DateUtil;
import com.ipaylinks.common.enums.BaseRespStatusEnum;

@Service("accountingRuleFacadeClient")
public class AccountingRuleFacadeQueryRpcClient {
	
	@Autowired(required = false)
	private AccountingRuleFacade accountingRuleFacade;
	
	@Autowired(required = false)
	private AccountingFacade accountingFacade;
	
	private Logger logger = LoggerFactory.getLogger(AccountingRuleFacadeQueryRpcClient.class);

    /**账户提交记账信息到账户系统
     * @param CreateWriteRecordRequest 请求参数
     * @return CreateMermberAccountFeeResponse 返回记账规则对象
     */
	public CreateMermberAccountFeeResponse createAccountFeeRule(
			CreateAccountingRequest request) throws BusinessException{
		logger.info("清算入账登记接口请求参数：[{}]", request);
		CreateMermberAccountFeeResponse response =new CreateMermberAccountFeeResponse();
		
		//过滤记账规则
		List<CreateAccountingAmount> requestRecordsList =request.getList();
		if(requestRecordsList.size()==0){
			throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "商户记账对象不存在");
		}
		//记账规则上送数据
	    AccountingRequest  accountingRequest =new AccountingRequest();
	    //封装业务对象
	    accountingRequest.setSysCode(ClientEnum.CMP_CSS.getClientCode());
		accountingRequest.setOperator(ClientEnum.CMP_CSS.getClientCode());
	    accountingRequest.setSysTraceNo(request.getSysTraceNo());
	    accountingRequest.setTxnOrderNo(request.getTxnOrderNo());
	    accountingRequest.setTxnTime(request.getTxnTime());
	    accountingRequest.setRequestId(request.getRequestId());
	    accountingRequest.setProdCode(request.getProdCode());
	    accountingRequest.setSceneCode(request.getSceneCode());
	    accountingRequest.setTradeType(request.getTradeType());
	    accountingRequest.setFinanceType(request.getFinanceType());
	    accountingRequest.setUserId(request.getUserId());
	    accountingRequest.setUserName(request.getUserName());
		accountingRequest.setMerchantOrderId(request.getMerchantOrderNo());
		accountingRequest.setOrgCode(request.getOrgCode());
	    //设置记账属性
	    List<AccountingAmount> listAccountingAmount =new ArrayList<AccountingAmount>();
	    //复制记账规则
	    for (Iterator iterator = requestRecordsList.iterator(); iterator
				.hasNext();) {
	    		CreateAccountingAmount createAccountingAmount = (CreateAccountingAmount) iterator
					.next();
					AccountingAmount AccountingAmount =new AccountingAmount();
			//复制对象到记账对象中
			BeanUtils.copyProperties(createAccountingAmount,AccountingAmount);
			listAccountingAmount.add(AccountingAmount);
		}
	    accountingRequest.setList(listAccountingAmount);
	   
		//调用记账规则
		logger.info("调用入账请求参数：[{}]", request);
		WriteRecordResponse writeRecordResponse=accountingFacade.accounting(accountingRequest);
		logger.info("入账返回结果：[{}]", writeRecordResponse);
		if(!BaseRespStatusEnum.SUCCESS.getCode().equals(writeRecordResponse.getResponseStatus())){
			response.setAccountingStatus(writeRecordResponse.getStatus());
			response.setResponseStatus(writeRecordResponse.getResponseStatus());
			response.setResponseCode(writeRecordResponse.getResponseCode());
			response.setResponseMsg(writeRecordResponse.getResponseMsg());
			logger.error("商户记账入账失败：[{}]", writeRecordResponse);
			return response;
        }
		//数据转化返回记账结果
		response.setAccountingId(String.valueOf(writeRecordResponse.getPipeLogId()));
		response.setAccountingTime(new Date());
		response.setAccountingStatus(writeRecordResponse.getStatus());
		response.setResponseStatus(writeRecordResponse.getResponseStatus());
		response.setResponseCode(writeRecordResponse.getResponseCode());
		logger.info("返回入账登记结果：[{}]", response);
		return response;
	}
}
