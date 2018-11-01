package com.ipaylinks.cmp.css.service;

import com.ipaylinks.cmp.css.dal.model.LiquidationOrder;
import com.ipaylinks.cmp.css.dal.model.MertClearingDetail;
import com.ipaylinks.cmp.css.dal.model.RiskOrder;
import com.ipaylinks.cmp.css.util.BusinessException;

import java.util.List;

public interface LiquidationOrderClearingService {


    /**
     * 清算订单清分
     *
     * @param orderId
     * @throws Exception
     */
    void clearingLiquidationOrder(String orderId) throws Exception ;

    /**
     * 风控订单清分
     */
    void clearingRiskOrder(String orderId) throws Exception;

    /**
     * 生成清算主订单结算明细
     */
    void genMertSettlementDetail(LiquidationOrder liquidationOrder, List<MertClearingDetail> mertClearingDetailList) throws BusinessException;

    /**
     * 生成风控订单结算明细
     */
    void genMertSettlementDetail(RiskOrder riskOrder, List<MertClearingDetail> mertClearingDetailList) throws Exception;

}
