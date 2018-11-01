package com.ipaylinks.cmp.css.integration.ccs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ipaylinks.ccs.facade.biz.ChargeStrategyQueryFacade;
import com.ipaylinks.ccs.facade.biz.MerchChargeCalcFacade;
import com.ipaylinks.ccs.facade.model.ChargeCalculateRequest;
import com.ipaylinks.ccs.facade.model.ChargeCalculateResponse;
import com.ipaylinks.ccs.facade.model.ChargeStrategyResponse;
import com.ipaylinks.ccs.facade.model.MerchChargeStrategyQueryRequest;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.integration.model.ChargeCalculateResult;
import com.ipaylinks.cmp.css.integration.model.MerchChargeStrategyQueryParam;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.ipaylinks.common.enums.BaseRespStatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * 商户费用计算
 * @author dapeng.tong
 */
@Service("merchChargeCalcFacadeClient")
public class MerchChargeCalcFacadeClient {

    private Logger logger = LoggerFactory.getLogger(MerchChargeCalcFacadeClient.class);

    @Autowired(required = false)
    private ChargeStrategyQueryFacade chargeStrategyQueryFacade;

    @Autowired(required = false)
    private MerchChargeCalcFacade merchChargeCalcFacade;

    /**
     * 商户费用计算
     * @return
     * @throws Exception
     */
    public ChargeCalculateResult merchChargeCalc(MerchChargeStrategyQueryParam merchChargeStrategyQueryParam, Map<String, Object> paramMap) throws Exception{
        try{
        	System.out.println("ceshi ");
        	//查询商户算费策略
            ChargeStrategyResponse chargeStrategyResponse = this.merchChargeStrategyQuery(merchChargeStrategyQueryParam);
            //计算费用请求参数
            ChargeCalculateRequest chargeCalculateRequest = buildMertChargeCalcMustParams(chargeStrategyResponse, paramMap);
            chargeCalculateRequest.setFeeId(chargeStrategyResponse.getFeeId());
            chargeCalculateRequest.setRequestTime(new SimpleDateFormat("yyyyMMdd").format(new Date()));
            chargeCalculateRequest.setReqId(UUID.randomUUID().toString().replace("-", ""));
            logger.info("商户费用计算，request={}" , chargeCalculateRequest);
            ChargeCalculateResponse response = merchChargeCalcFacade.merchChargeCalc(chargeCalculateRequest);
            logger.info("商户费用计算，response={}" , response);
            if(!BaseRespStatusEnum.SUCCESS.getCode().equals(response.getResponseStatus())){
                throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "商户费用计算，算费系统返回失败");
            }
            ChargeCalculateResult chargeCalculateResult = new ChargeCalculateResult();
            BeanUtils.copyProperties(response, chargeCalculateResult);
            return chargeCalculateResult;
            
        }catch (Exception e){
            logger.error("商户费用计算异常", e);
            throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "商户费用计算异常");
        }
    }

    /**
     * 商户算费策略查询
     * @return
     * @throws Exception
     */
    private ChargeStrategyResponse merchChargeStrategyQuery(MerchChargeStrategyQueryParam param) throws Exception{
        try{
            MerchChargeStrategyQueryRequest request = new MerchChargeStrategyQueryRequest();
            BeanUtils.copyProperties(param, request);
            request.setReqId(UUID.randomUUID().toString().replace("-", ""));
            logger.info("商户算费策略查询，request={}" , request);
            ChargeStrategyResponse response = chargeStrategyQueryFacade.merchChargeStrategyQuery(request);
            logger.info("商户算费策略查询，response={}" , response);
            if(!BaseRespStatusEnum.SUCCESS.getCode().equals(response.getResponseStatus())){
                throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "商户算费策略查询，算费系统返回失败");
            }
            return response;
        }catch (Exception e){
            logger.error("商户算费策略查询异常", e);
            throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "商户算费策略查询异常");
        }
    }


    /**
     * 构建计费接口请求参数对象
     */
    public ChargeCalculateRequest buildMertChargeCalcMustParams(ChargeStrategyResponse chargeStrategyResponse, Map<String, Object> paramMap) throws Exception {
        Map<String, Object> chargeCalculateMustParamMap = new HashMap<>();
        // 计费接口所许参数集合（只有必填）
        JSONArray jsonArray = JSON.parseArray(chargeStrategyResponse.getRequiredParamJson());
        for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();){
            String fieldName = Objects.toString(iterator.next());
            chargeCalculateMustParamMap.put(fieldName, paramMap.get(fieldName));
        }
        return setValues(chargeCalculateMustParamMap);
    }

    /**
     * 将必填参数Map集合中的值，通过反射赋值给渠道计费接口的请求参数对象中
     */
    private ChargeCalculateRequest setValues(Map<String,Object> chargeCalculateMustParamMap) throws Exception {
        ChargeCalculateRequest chargeCalculateRequest = new ChargeCalculateRequest();
        Field[] fields = ChargeCalculateRequest.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if(!chargeCalculateMustParamMap.containsKey(field.getName())){
                continue;
            }
            String val = Objects.toString(chargeCalculateMustParamMap.get(field.getName()), "");
            if(StringUtils.isEmpty(val)){
                throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "算费必填字段【"+ field.getName() + "】值为空！");
            }
            if (field.getType() == BigDecimal.class) {
                field.set(chargeCalculateRequest, new BigDecimal(val));
            } else if (field.getType() == Long.class) {
                field.setLong(chargeCalculateRequest, Long.valueOf(val));
            } else if (field.getType() == String.class) {
                field.set(chargeCalculateRequest, val);
            }
        }
        return chargeCalculateRequest;
    }
}
