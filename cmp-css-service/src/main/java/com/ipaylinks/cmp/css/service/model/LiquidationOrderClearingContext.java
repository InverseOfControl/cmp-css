package com.ipaylinks.cmp.css.service.model;

import com.ipaylinks.cmp.css.dal.model.AccsplitOrder;
import com.ipaylinks.cmp.css.dal.model.LiquidationOrder;
import com.ipaylinks.cmp.css.dal.model.MertClearingDetail;

import java.util.List;

/**
 *  清算订单清分处理上下文
 * @author ipay
 * @date 2018/8/14 19:36  
 */
public class LiquidationOrderClearingContext {

    private LiquidationOrder liquidationOrder;

    private List<AccsplitOrder> accsplitOrderList;

    private List<MertClearingDetail> mertClearingDetailList;

    public LiquidationOrder getLiquidationOrder() {
        return liquidationOrder;
    }

    public void setLiquidationOrder(LiquidationOrder liquidationOrder) {
        this.liquidationOrder = liquidationOrder;
    }

    public List<AccsplitOrder> getAccsplitOrderList() {
        return accsplitOrderList;
    }

    public void setAccsplitOrderList(List<AccsplitOrder> accsplitOrderList) {
        this.accsplitOrderList = accsplitOrderList;
    }

    public List<MertClearingDetail> getMertClearingDetailList() {
        return mertClearingDetailList;
    }

    public void setMertClearingDetailList(List<MertClearingDetail> mertClearingDetailList) {
        this.mertClearingDetailList = mertClearingDetailList;
    }
}
