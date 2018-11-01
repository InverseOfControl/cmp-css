package com.ipaylinks.cmp.css.service.impl;

import com.ipaylinks.cmp.css.dal.mapper.AccsplitOrderMapper;
import com.ipaylinks.cmp.css.dal.model.AccsplitOrder;
import com.ipaylinks.cmp.css.service.AccsplitOrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accsplitOrderService")
public class AccsplitOrderServiceImpl implements AccsplitOrderService {

    @Autowired(required = false)
    private AccsplitOrderMapper accsplitOrderMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return accsplitOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(AccsplitOrder record) {
        return accsplitOrderMapper.insertSelective(record);
    }

    @Override
    public AccsplitOrder selectByPrimaryKey(String id) {
        return accsplitOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AccsplitOrder record) {
        return accsplitOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AccsplitOrder record) {
        return accsplitOrderMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<AccsplitOrder> selectByParams(AccsplitOrder record){
        return accsplitOrderMapper.selectByParams(record);
    }

    @Override
    public List<AccsplitOrder> selectByOrderId(String orderId){
        if(StringUtils.isBlank(orderId)){
            return null;
        }
        AccsplitOrder record = new AccsplitOrder();
        record.setOrderId(orderId);
        return this.selectByParams(record);
    }
}
