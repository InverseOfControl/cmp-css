package com.ipaylinks.cmp.css.service.impl;

import com.ipaylinks.cmp.css.dal.mapper.LiquidationLogMapper;
import com.ipaylinks.cmp.css.dal.model.LiquidationLog;
import com.ipaylinks.cmp.css.service.LiquidationLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("liquidationLogService")
public class LiquidationLogServiceImpl implements LiquidationLogService {

    private Logger logger = LoggerFactory.getLogger(LiquidationLogServiceImpl.class);

    @Autowired(required = false)
    private LiquidationLogMapper liquidationLogMapper;

    @Override
    public LiquidationLog createLiquidationLog(String orderId, String orderType) {
        LiquidationLog liquidationLog = new LiquidationLog();
        liquidationLog.setOrderId(orderId);
        liquidationLog.setOrderType(orderType);
        liquidationLogMapper.insertSelective(liquidationLog);
        return liquidationLog;
    }

    @Override
    public LiquidationLog selectByPrimaryKey(String id) {
        return liquidationLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(LiquidationLog record) {
        return liquidationLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void updateResultById(String id, String result){
        try {
            LiquidationLog record = new LiquidationLog();
            record.setId(id);
            record.setResult(result);
            liquidationLogMapper.updateByPrimaryKeySelective(record);
        }catch (Exception e){
            logger.error("更新LiquidationLog异常", e);
        }
    }

}
