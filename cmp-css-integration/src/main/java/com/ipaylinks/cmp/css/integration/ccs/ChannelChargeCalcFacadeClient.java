package com.ipaylinks.cmp.css.integration.ccs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ipaylinks.ccs.facade.biz.ChannelChargeCalcFacade;
import com.ipaylinks.ccs.facade.biz.ChargeStrategyQueryFacade;
import com.ipaylinks.ccs.facade.enums.TradeStatusEnum;
import com.ipaylinks.ccs.facade.model.ChannelChargeStrategyQueryRequest;
import com.ipaylinks.ccs.facade.model.ChargeCalculateRequest;
import com.ipaylinks.ccs.facade.model.ChargeCalculateResponse;
import com.ipaylinks.ccs.facade.model.ChargeStrategyResponse;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.integration.model.ChannelChargeCalculateParam;
import com.ipaylinks.cmp.css.integration.model.ChannelChargeCalculateResult;
import com.ipaylinks.cmp.css.integration.model.ChannelChargeStrategyQueryParam;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.ipaylinks.cmp.css.util.DateUtil;
import com.ipaylinks.cmp.css.util.ResponseUtils;
import com.ipaylinks.common.enums.BaseRespStatusEnum;
import com.ipaylinks.common.rpc.response.SingleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

/**
 * 渠道费用结算相关接口
 *
 * @author hongxu.gao
 * @date 2018/8/10 11:29
 */
@Service("channelChargeCalcFacadeClient")
public class ChannelChargeCalcFacadeClient {

    private Logger logger = LoggerFactory.getLogger(ChannelChargeCalcFacadeClient.class);

    public static final String SYSTEM_ID = "cmp-css";

    @Autowired(required = false)
    private ChannelChargeCalcFacade channelChargeCalcFacade;

    @Autowired(required = false)
    private ChargeStrategyQueryFacade chargeStrategyQueryFacade;

    /**
     * 渠道成本计算策略查询
     *
     * @param params 接口请求参数对象
     * @return ChargeStrategyResponse 计费测试响应对象
     * @author hongxu.gao
     * @date 2018/8/10 10:31
     */
    public ChargeStrategyResponse channelChargeStrategyQuery(ChannelChargeStrategyQueryParam params) throws Exception {
        ChannelChargeStrategyQueryRequest request = new ChannelChargeStrategyQueryRequest();
        BeanUtils.copyProperties(params, request);
        request.setReqId(generateReqId());
        request.setClientCode(SYSTEM_ID);
        if (params.getTradeStatus().equals(TradeStatusEnum.SUCCESS.getCode())) {
            request.setTradeStatus(TradeStatusEnum.SUCCESS);
        } else {
            request.setTradeStatus(TradeStatusEnum.FAIL);
        }
        logger.info("渠道成本计算策略查询开始，request={}", request);

        ChargeStrategyResponse response = chargeStrategyQueryFacade.channelChargeStrategyQuery(request);
        if (!BaseRespStatusEnum.SUCCESS.getCode().equals(response.getResponseStatus())) {
            logger.info("渠道成本计算策略查询失败,response={}", response);
            throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "渠道成本计算策略查询失败，算费系统返回失败!");
        }

        logger.info("渠道成本计算策略查询结束，response{}", response);
        return response;
    }

    /**
     * 渠道成本计算
     *
     * @param params 接口请求参数对象
     * @return com.ipaylinks.cmp.css.integration.model.ChargeCalculateResult
     * @author hongxu.gao
     * @date 2018/8/10 11:04
     */
    public ChannelChargeCalculateResult channelChargeCalc(ChannelChargeCalculateParam params) throws Exception {
        ChargeCalculateRequest request = new ChargeCalculateRequest();
        BeanUtils.copyProperties(params, request);
        request.setReqId(generateReqId());
        request.setClientCode(SYSTEM_ID);
        logger.info("渠道成本计算开始，request={}", request);

        ChargeCalculateResponse response = channelChargeCalcFacade.channelChargeCalc(request);
        if (!BaseRespStatusEnum.SUCCESS.getCode().equals(response.getResponseStatus())) {
            logger.info("渠道成本计算失败，response={}", response);
            throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "渠道成本计算失败，算费系统返回失败");
        }

        logger.info("渠道成本计算结束，response={}", response);
        ChannelChargeCalculateResult result = new ChannelChargeCalculateResult();
        BeanUtils.copyProperties(response, result);
        return result;
    }

    /**
     * 请求流水号生成
     *
     * @author hongxu.gao
     * @date 2018/8/10 15:07
     */
    private String generateReqId() {
        StringBuffer sb = new StringBuffer();
        sb.append("cmp-css");
        sb.append(DateUtil.toFullDateCompactString(new Date()));
        sb.append(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10));
        return sb.toString();
    }

    /**
     * 构建计费接口请求参数对象
     *
     * @param chargeStrategyResponse 渠道计费策略查询接口的响应对象
     * @param orderMap               渠道计费接口所用的业务参数
     * @return SingleResponse
     * @author hongxu.gao
     * @date 2018/8/14 14:29
     */
    public SingleResponse buildChannelChargeCalcMustParams(ChargeStrategyResponse chargeStrategyResponse, Map orderMap) {
        SingleResponse response = null;
        Map<String, Object> chargeCalculateMustParamMap = new HashMap<>();
        // 计费接口所需参数集合（包含必填和非必填）
        Map<String, Object> chargeCalculateMap = this.convertOrderMapToChargeCalculateMap(orderMap);

        // 计费接口所许参数集合（只有必填）
        JSONArray jsonArray = JSON.parseArray(chargeStrategyResponse.getRequiredParamJson());
        for (Iterator iterator = jsonArray.iterator(); iterator.hasNext(); ) {
            String fieldName = Objects.toString(iterator.next());
            chargeCalculateMustParamMap.put(fieldName, chargeCalculateMap.get(fieldName));
        }

        // 把必填参数集合信息赋值到渠道计费接口请求参数对象中
        ChannelChargeCalculateParam channelChargeCalculateParam = null;
        try {
            response = setValues(chargeCalculateMustParamMap);
        } catch (Exception e) {
            logger.info("ChannelChargeCalcFacadeClient.setValues方法异常:" + e);
        }
        return response;
    }

    /**
     * 此方法用于把cmp-css系统中业务参数映射到渠道计费接口的请求参数集合
     * 给this.setValues()方法进行动态赋值。
     * 如果以后还有其它参数变动，只需要在此处添加映射关系即可。
     *
     * @param orderMap 业务参数集合对象，由biz层传入
     * @return java.util.Map<java.lang.String   ,   java.lang.Object>
     * @author hongxu.gao
     * @date 2018/8/14 14:18
     */
    private Map<String, Object> convertOrderMapToChargeCalculateMap(Map<String, Object> orderMap) {
        Map<String, Object> chargeCalculateMap = new HashMap<>();
        chargeCalculateMap.put("singleAmount", orderMap.get("payAmount"));
        return chargeCalculateMap;
    }

    /**
     * 将必填参数Map集合中的值，通过反射赋值给渠道计费接口的请求参数对象中{@link ChannelChargeCalculateParam}
     *
     * @param chargeCalculateMustParamMap 渠道计费策略查询接口中返回的必填参数集合
     * @return com.ipaylinks.cmp.css.integration.model.ChannelChargeCalculateParam
     * @author hongxu.gao
     * @date 2018/8/14 14:13
     */
    private SingleResponse setValues(Map<String, Object> chargeCalculateMustParamMap) throws Exception {
        SingleResponse response = new SingleResponse();
        ChannelChargeCalculateParam channelChargeCalculateParam = ChannelChargeCalculateParam.class.newInstance();
        Field[] fields = channelChargeCalculateParam.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (!chargeCalculateMustParamMap.containsKey(field.getName())) {
                continue;
            }
            String val = Objects.toString(chargeCalculateMustParamMap.get(field.getName()), "");
            if (StringUtils.isEmpty(val)) {
                ResponseUtils.setToFail(response, CmpCssExceptionCode.PARAMETERS_ERROR, "字段【" + field.getName() + "】值为空！");
                return response;
            }
            if (field.getType() == BigDecimal.class) {
                field.set(channelChargeCalculateParam, new BigDecimal(val));
            } else if (field.getType() == Long.class) {
                field.setLong(channelChargeCalculateParam, Long.valueOf(val));
            } else if (field.getType() == String.class) {
                field.set(channelChargeCalculateParam, val);
            }
        }
        response.setResponseObj(channelChargeCalculateParam);
        ResponseUtils.setToSuccess(response);
        return response;
    }

}
