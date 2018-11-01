package com.ipaylinks.cmp.css.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ipaylinks.cmp.css.dal.mapper.MertSettlementLogMapper;
import com.ipaylinks.cmp.css.dal.model.MertSettlementLog;
import com.ipaylinks.cmp.css.service.MertSettlementLogService;

@Service("mertSettlementLogService")
public class MertSettlementLogServiceImpl implements MertSettlementLogService {

	@Autowired
	 private MertSettlementLogMapper mertSettlementLogMapper;
	@Override
	public MertSettlementLog createMertSettlementLog(String settleDate,String merchantId,
			String busId, Object jsonString, String busType,String operType ) {
		MertSettlementLog mertSettlementLog =new MertSettlementLog();
		String objectStr =JSONObject.toJSONString(jsonString);
		mertSettlementLog.setResult(objectStr);
		mertSettlementLog.setStatus(operType);
		mertSettlementLog.setTradeType(busType);
		mertSettlementLog.setMerchantId(merchantId);
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date =new Date();
		mertSettlementLog.setDealDate(sdf.format(date));
		mertSettlementLog.setGmtCreateTime(new Date());
		mertSettlementLog.setGmtUpdateTime(new Date());
		mertSettlementLogMapper.insertSelective(mertSettlementLog);
		return mertSettlementLog;
	}

}
