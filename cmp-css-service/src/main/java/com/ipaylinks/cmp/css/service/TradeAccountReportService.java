package com.ipaylinks.cmp.css.service;

import com.ipaylinks.cmp.css.dal.model.TradeAccountReport;

public interface TradeAccountReportService {

	 /**
     * 定时任务生成月度交易报表
     **/
	void dealTradeAccountReport();

	/**
	 * 根据商户id和支付方式查询上个月的数据
	 * @return
	 */
	TradeAccountReport selectLastMonthByMerchantIdAndPayMethod(String merchantId, String payMethod);
    
}
