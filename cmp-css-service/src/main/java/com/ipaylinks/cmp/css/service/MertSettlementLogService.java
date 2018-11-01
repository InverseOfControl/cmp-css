package com.ipaylinks.cmp.css.service;

import com.ipaylinks.cmp.css.dal.model.MertSettlementLog;

public interface MertSettlementLogService {

	MertSettlementLog createMertSettlementLog(String settleDate,String merchantId,
			String busId, Object jsonString, String busType,String operType);

}
