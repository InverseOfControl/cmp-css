package com.ipaylinks.cmp.css.service.impl;

import com.ipaylinks.cmp.css.dal.mapper.LiquidationSubOrderMapper;
import com.ipaylinks.cmp.css.dal.model.LiquidationSubOrder;
import com.ipaylinks.cmp.css.service.LiquidationSubOrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("liquidationSubOrderService")
public class LiquidationSubOrderServiceImpl implements LiquidationSubOrderService {
    
    @Autowired(required = false)
    private LiquidationSubOrderMapper LiquidationSubOrderMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return LiquidationSubOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(LiquidationSubOrder record) {
        return LiquidationSubOrderMapper.insert(record);
    }

    @Override
    public int insertSelective(LiquidationSubOrder record) {
        return LiquidationSubOrderMapper.insertSelective(record);
    }

    @Override
    public LiquidationSubOrder selectByPrimaryKey(String id) {
        return LiquidationSubOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(LiquidationSubOrder record) {
        return LiquidationSubOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LiquidationSubOrder record) {
        return LiquidationSubOrderMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<LiquidationSubOrder> selectByParams(LiquidationSubOrder record){
        return LiquidationSubOrderMapper.selectByParams(record);
    }

    @Override
    public List<LiquidationSubOrder> selectByLiquidationOrderId(String liquidationOrderId){
        if(StringUtils.isBlank(liquidationOrderId)){
            return null;
        }
        LiquidationSubOrder record = new LiquidationSubOrder();
        record.setLiquidationOrderId(liquidationOrderId);
        return this.selectByParams(record);
    }
}
