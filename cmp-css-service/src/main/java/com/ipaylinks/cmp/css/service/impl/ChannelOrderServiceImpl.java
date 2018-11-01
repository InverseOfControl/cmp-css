package com.ipaylinks.cmp.css.service.impl;

import com.ipaylinks.cmp.css.dal.mapper.ChannelOrderMapper;
import com.ipaylinks.cmp.css.dal.model.ChannelCost;
import com.ipaylinks.cmp.css.dal.model.ChannelOrder;
import com.ipaylinks.cmp.css.service.ChannelOrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("channelOrderService")
public class ChannelOrderServiceImpl implements ChannelOrderService {

    @Autowired(required = false)
    private ChannelOrderMapper channelOrderMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return channelOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ChannelOrder record) {
        return channelOrderMapper.insert(record);
    }

    @Override
    public int insertSelective(ChannelOrder record) {
        return channelOrderMapper.insertSelective(record);
    }

    @Override
    public ChannelOrder selectByPrimaryKey(String id) {
        return channelOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ChannelOrder record) {
        return channelOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ChannelOrder record) {
        return channelOrderMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ChannelOrder> selectByParams(ChannelOrder record){
        return channelOrderMapper.selectByParams(record);
    }

    @Override
    public List<ChannelOrder> selectByOrderId(String orderId){
        if(StringUtils.isBlank(orderId)){
            return null;
        }
        ChannelOrder record = new ChannelOrder();
        record.setOrderId(orderId);
        return this.selectByParams(record);
    }

    public List<ChannelOrder> selectList(ChannelOrder record) {
        return channelOrderMapper.selectList(record);
    }

    @Override
    public List<ChannelCost> selectChannelCost(ChannelCost channelCost) {
        return channelOrderMapper.selectChannelCost(channelCost);
    }


}
