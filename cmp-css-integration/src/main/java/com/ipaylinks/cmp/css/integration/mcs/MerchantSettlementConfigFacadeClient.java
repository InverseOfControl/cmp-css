package com.ipaylinks.cmp.css.integration.mcs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.integration.req.QueryMertSettlementCashDepositRequest;
import com.ipaylinks.cmp.css.integration.res.MertSettlementInfo;
import com.ipaylinks.cmp.css.integration.res.QueryMertSettlementCashDepositResponse;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.ipaylinks.common.enums.BaseRespStatusEnum;
import com.ipaylinks.mcs.facade.MerchantSettlementConfigFacade;
import com.ipaylinks.mcs.facade.request.MerchantSettlementConfigRequest;
import com.ipaylinks.mcs.facade.response.QueryMertSettlementDateResponse;

@Service("merchantSettlementConfigFacadeClient")
public class MerchantSettlementConfigFacadeClient {
	
	private Logger logger = LoggerFactory.getLogger(MerchantSettlementConfigFacadeClient.class);
	
	@Autowired(required = false)
	private MerchantSettlementConfigFacade merchantSettlementConfigFacade;

	/**
	 *  查询商户结算日期
	 * @param merchantId  商户号
	 * @param payMethod   支付方式
	 * @param cardCountry 国家
	 * @param payOrgCode  渠道号
	 * @param transCurrency  交易币种
	 * @param transMethod  交易方式 EDC、DCC
	 * @return
	 * @throws Exception
	 */
	public MertSettlementInfo queryMertSettlementInfo(String merchantId, String payMethod, String cardCountry, String payOrgCode, String transCurrency, String transMethod) throws Exception{
		//调用外部接口返回商户结算时间和参数
		QueryMertSettlementDateResponse response = null;
		try {
			MerchantSettlementConfigRequest request = new MerchantSettlementConfigRequest();
			request.setMerchantId(merchantId);
			request.setPaymentMethods(payMethod);
			request.setCountryCodes(cardCountry);
			request.setChannelCodes(payOrgCode);
			request.setTransCurrency(transCurrency);
			request.setTransMethod(transMethod);
			logger.info("调用mcs查询商户结算信息，request={}", request);
			response = merchantSettlementConfigFacade.queryMertSettlementConfigInfo(request);
			logger.info("调用mcs查询商户结算信息，response={}", response);
		} catch (Exception e) {
			logger.info("query mermber settle rate error",e);
			throw new BusinessException(CmpCssExceptionCode.INVOKE_SERVICE_EXCEPTION.getCode(), "调用mcs查询商户结算信息异常");
		}
		if(!BaseRespStatusEnum.SUCCESS.getCode().equals(response.getResponseStatus())){
			throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "调用mcs查询商户结算信息失败");
		}
		MertSettlementInfo mertSettlementInfo = new MertSettlementInfo();
		BeanUtils.copyProperties(response, mertSettlementInfo);
		return mertSettlementInfo;
	}

	/**
	 * @des    根据商户交易类型消费和预授权完成获取商户保证金记录
	 * @param  request 主订单信息
	 * @return
	 * @author yuyao
	 * @data <a>2018-07-09<a>
	 * */
	public QueryMertSettlementCashDepositResponse queryMertSettlementCashDeposit(
			QueryMertSettlementCashDepositRequest request) throws BusinessException {
		logger.info("查询结算金额是否为起结金额", JSONObject.toJSON(request));
		QueryMertSettlementDateResponse response =new QueryMertSettlementDateResponse();
		QueryMertSettlementCashDepositResponse queryResponse =new QueryMertSettlementCashDepositResponse();
		try {
			MerchantSettlementConfigRequest merchantSettlementConfigRequest =new MerchantSettlementConfigRequest();
			merchantSettlementConfigRequest.setMerchantId(request.getMerchantId());
			merchantSettlementConfigRequest.setTransCurrency(request.getTransCurrency());
			logger.info("查询结算金额结束", JSONObject.toJSON(request));
			response = merchantSettlementConfigFacade.queryMertSettlementConfigInfo(merchantSettlementConfigRequest);
			logger.info("查询结算金额结束", JSONObject.toJSON(response));
			if(!BaseRespStatusEnum.SUCCESS.getCode().equals(response.getResponseStatus())){
                throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "查询保证金参数异常");
            }
			queryResponse.setReturnCycle(response.getMarginSettlementCycle());
			queryResponse.setPercent(response.getMarginRatio());
			queryResponse.setReturnDate(String.valueOf(response.getMarginSettlementDay()));
			queryResponse.setReturnType(response.getMarginSettlementDayType());
			queryResponse.setSettleAmount(response.getStartSettlementMoney());
			queryResponse.setResponseCode(response.getResponseCode());
			queryResponse.setResponseMsg(response.getResponseMsg());
			queryResponse.setResponseStatus(response.getResponseStatus());
		} catch (Exception e) {
			logger.error("查询结算金额结束", e.getMessage());
            throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "查询保证金参数异常");
		}
		logger.info("查询结算金额结束", JSONObject.toJSON(queryResponse));
		return queryResponse;
	}
}
