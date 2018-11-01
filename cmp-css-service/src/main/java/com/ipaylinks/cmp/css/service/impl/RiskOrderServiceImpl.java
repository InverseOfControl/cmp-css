package com.ipaylinks.cmp.css.service.impl;

import com.ipaylinks.cmp.css.dal.mapper.RiskOrderMapper;
import com.ipaylinks.cmp.css.dal.model.RiskOrder;
import com.ipaylinks.cmp.css.service.RiskOrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("riskOrderService")
public class RiskOrderServiceImpl implements RiskOrderService {

    @Autowired(required = false)
    private RiskOrderMapper riskOrderMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return riskOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RiskOrder record) {
        return riskOrderMapper.insert(record);
    }

    @Override
    public int insertSelective(RiskOrder record) {
        return riskOrderMapper.insertSelective(record);
    }

    @Override
    public RiskOrder selectByPrimaryKey(String id) {
        return riskOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RiskOrder record) {
        return riskOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RiskOrder record) {
        return riskOrderMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<RiskOrder> selectByParams(RiskOrder record){
        return riskOrderMapper.selectByParams(record);
    }

    @Override
    public RiskOrder selectByOrderId(String orderId){
        if(StringUtils.isBlank(orderId)){
            return null;
        }
        RiskOrder record = new RiskOrder();
        record.setOrderId(orderId);
        return this.selectByParams(record).get(0);
    }
}
