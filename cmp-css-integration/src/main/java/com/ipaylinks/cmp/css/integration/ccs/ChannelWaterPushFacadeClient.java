package com.ipaylinks.cmp.css.integration.ccs;

import com.alibaba.fastjson.JSONObject;
import com.ipaylinks.cmp.css.facade.dto.LiquidationSubOrderDTO;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.ipaylinks.cmp.css.util.ResponseUtils;
import com.ipaylinks.common.enums.BaseRespStatusEnum;
import com.ipaylinks.common.exception.BaseExceptionCode;
import com.ipaylinks.common.rpc.BaseResponse;
import com.ipaylinks.verify.facade.VerifyFacade;
import com.ipaylinks.verify.facade.dto.CallBackAccountingDTO;
import com.ipaylinks.verify.facade.dto.SettlementTransDetailDTO;
import com.ipaylinks.verify.facade.enums.OrderDealStateEnum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 渠道流水推送
 *
 * @author hongxu.gao
 * @date 2018/8/14 16:15
 */
@Service
public class ChannelWaterPushFacadeClient {

    private Logger logger = LoggerFactory.getLogger(ChannelChargeCalcFacadeClient.class);

    @Autowired(required = false)
    private VerifyFacade verifyFacade;

    public BaseResponse push(SettlementTransDetailDTO SettlementTransDetailDto) throws BusinessException {
        logger.info("渠道流水推送开始，request={}", SettlementTransDetailDto);
        BaseResponse response = verifyFacade.settlementDetail(SettlementTransDetailDto);
        if (null == response || !BaseRespStatusEnum.SUCCESS.getCode().equals(response.getResponseStatus())) {
            logger.info("渠道流水推送失败,对账系统返回失败。response={}", response);
            response = new BaseResponse();
            ResponseUtils.setToFail(response, BaseExceptionCode.INVOKE_UNKOWN_ERR);
        }
        logger.info("渠道流水推送结束，response={} ", response);
        return response;
    }
    
    public BaseResponse pushAccount(LiquidationSubOrderDTO liquidationSubOrderDTO,String transType) throws BusinessException {
        logger.info("补单记账成功推送对账系统开始，request={}", JSONObject.toJSON(liquidationSubOrderDTO));
        CallBackAccountingDTO  callBackAccountingDTO  =new CallBackAccountingDTO();
        callBackAccountingDTO.setChannelOrderId(liquidationSubOrderDTO.getChannelOrderNo());
        callBackAccountingDTO.setOrgCode(liquidationSubOrderDTO.getPayOrgCode());
        callBackAccountingDTO.setCurrency(liquidationSubOrderDTO.getPayCurrency());
        callBackAccountingDTO.setTransAmt(liquidationSubOrderDTO.getPayAmount());
        logger.info("调用对账接口。request={}", JSONObject.toJSON(callBackAccountingDTO));
        BaseResponse response = verifyFacade.callBackAccounting(callBackAccountingDTO);
        if (null == response || !BaseRespStatusEnum.SUCCESS.getCode().equals(response.getResponseStatus())) {
            logger.info("补单记账成功推送失败,对账系统返回失败。response={}", JSONObject.toJSON(response));
            response = new BaseResponse();
            ResponseUtils.setToFail(response, BaseExceptionCode.INVOKE_UNKOWN_ERR);
        }
        logger.info("补单记账成功推送对账系统结束，request={}", JSONObject.toJSON(response));
        return response;
    }

}
