package com.ipaylinks.cmp.css.biz.job.executor.handler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ipaylinks.cmp.css.dal.model.LiquidationOrder;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.service.LiquidationOrderService;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

@Component
@JobHandler(value="dealMertTradeAccountTask")
public class DealMertTradeAccountTask extends IJobHandler {

	private Logger logger = LoggerFactory.getLogger(DealMertTradeAccountTask.class);

	@Autowired
	private LiquidationOrderService liquidationOrderService;
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		try {
		    //当前日期
			Date date =new Date();
			//根据当前结算日获取上一日所有设计到商户的交易记录
			SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
			List<LiquidationOrder>  LiquidationOrderlist =liquidationOrderService.getMertListByDay(sdf.format(date));
			for (Iterator iterator = LiquidationOrderlist.iterator(); iterator
					.hasNext();) {
				LiquidationOrder liquidationOrder = (LiquidationOrder) iterator
						.next();
				liquidationOrderService.createMerTradeStatementAccount(liquidationOrder.getMerchantId(), sdf.format(date));
			}
		} catch (Exception e) {
			logger.info("create merchant T day trade statement of account error ={}",e);
			throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "处理结算对账单异常");
		}
		return SUCCESS;
	}
}
