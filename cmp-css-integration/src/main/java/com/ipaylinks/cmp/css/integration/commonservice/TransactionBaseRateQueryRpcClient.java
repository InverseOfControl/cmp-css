package com.ipaylinks.cmp.css.integration.commonservice;

import com.ipay.commonService.rate.request.dto.TransactionBaseRateQueryRequest;
import com.ipay.commonService.rate.response.dto.TransactionBaseRateQueryResponse;
import com.ipay.commonService.rate.rpc.TransactionBaseRateQueryRpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 调用commonService查询交易基本汇率
 * @author dapeng.tong
 * @date 2018/08/15
 */
@Service("transactionBaseRateQueryRpcClient")
public class TransactionBaseRateQueryRpcClient {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired(required = false)
    private TransactionBaseRateQueryRpc transactionBaseRateQueryRpc;

    /**查询交易基本汇率
     * @param sourceCurrency 源币种
     * @param targetCurrency 目标币种
     * @return BigDecimal 交易基本汇率
     */
    public BigDecimal queryTransactionBaseRate(String sourceCurrency, String targetCurrency) {
        BigDecimal exchangeRate = null;
        try {
            TransactionBaseRateQueryRequest req = new TransactionBaseRateQueryRequest();
            req.setCurrency(sourceCurrency);
            req.setTargetCurrency("CNY");
            req.setStatus("1");
            log.info("查询交易基本汇率的请求参数1：[{}]", req);
            TransactionBaseRateQueryResponse rateQueryResponse = transactionBaseRateQueryRpc.invoke(req);
            log.info("查询交易基本汇率的返回参数1：[{}]", rateQueryResponse);
            String sourceCNY = rateQueryResponse.getTransactionBaseRateList().get(0).getExchangeRate();
            req.setCurrency(targetCurrency);
            log.info("查询交易基本汇率的请求参数2：[{}]", req);
            rateQueryResponse = transactionBaseRateQueryRpc.invoke(req);
            log.info("查询交易基本汇率的返回参数2：[{}]", rateQueryResponse);
            String targetCNY = rateQueryResponse.getTransactionBaseRateList().get(0).getExchangeRate();
            exchangeRate = new BigDecimal(sourceCNY).divide(new BigDecimal(targetCNY),8, BigDecimal.ROUND_HALF_DOWN);
        } catch (Exception e) {
            log.error("查询交易基本汇率异常----", e);
        }
        log.info("查询交易基本汇率的结果信息：[{}]", exchangeRate == null ? "null" : exchangeRate);
        return exchangeRate;
    }

}
