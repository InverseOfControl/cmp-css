package com.ipaylinks.cmp.css.integration.commonservice;

import com.ipay.commonService.rate.model.SettlementRate;
import com.ipay.commonService.rate.request.dto.SettlementRateQueryRequest;
import com.ipay.commonService.rate.response.dto.SettlementRateQueryResponse;
import com.ipay.commonService.rate.rpc.SettlementRateQueryRpc;
import com.ipaylinks.common.CardOrgEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * 调用commonService查询清算汇率
 * @author dapeng.tong
 * @date 2018/08/15
 */
@Service("settlementRateQueryRpcClient")
public class SettlementRateQueryRpcClient {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired(required = false)
    private SettlementRateQueryRpc settlementRateQueryRpc;

    /**查询清算汇率
     * @param sourceCurrency 源币种，即订单的币种
     * @param merchantId 商户号
     * @param orderAmount 订单金额，单位到元
     * @param cardOrg 卡组织
     * @param targetCurrency 目标币种
     * @return BigDecimal 清算汇率
     */
    public BigDecimal querySettlementRate(String sourceCurrency, String merchantId, Long orderAmount, String cardOrg, String targetCurrency) {
        BigDecimal exchangeRate = null;
        try {
            if(orderAmount==null || orderAmount.longValue()==0L){
                orderAmount = 1L;
            }
            SettlementRateQueryRequest req = new SettlementRateQueryRequest();
            req.setCurrencyCode(sourceCurrency);
            req.setPartnerId(merchantId);
            req.setTargetCurrencyCode(targetCurrency);
            req.setLeastCurrencyCode("USD");
            req.setPoint(getTime());
            req.setOrderAmount(Math.abs(orderAmount));
            req.setStatus("1");
            if (StringUtils.isNotEmpty(cardOrg) && !CardOrgEnum.LOCAL.getOrgName().equals(cardOrg)) {
                req.setCardOrg(cardOrg);
            }
            log.info("查询清算汇率的请求参数：[{}]", req);
            SettlementRateQueryResponse rateQueryResponse = settlementRateQueryRpc.invoke(req);
            log.info("查询清算汇率的返回参数：[{}]", rateQueryResponse);
            if (rateQueryResponse != null) {
                SettlementRate rate = rateQueryResponse.getSettleRate();
                if (rate != null && rate.getExchangeRate() != null) {
                    exchangeRate = rate.getExchangeRate();
                }
            }
        } catch (Exception e) {
            log.error("查询清算汇率异常----", e);
        }
        log.info("查询清算汇率的结果信息：[{}]", exchangeRate == null ? "null" : exchangeRate);
        return exchangeRate;
    }

    /**将当前系统时间的HH24:mm转换成HH24.mm
     * @return double 待两位小数点的数字
     */
    private double getTime() {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);
        double s = min / 100.0;
        double rst = hour + s;
        return rst;
    }
}
