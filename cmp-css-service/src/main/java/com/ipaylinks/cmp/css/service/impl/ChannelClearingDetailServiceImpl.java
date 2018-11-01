package com.ipaylinks.cmp.css.service.impl;

import com.ipaylinks.cmp.css.dal.mapper.ChannelClearingDetailMapper;
import com.ipaylinks.cmp.css.dal.model.ChannelClearingDetail;
import com.ipaylinks.cmp.css.service.ChannelClearingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelClearingDetailServiceImpl implements ChannelClearingDetailService {

    @Autowired(required = false)
    private ChannelClearingDetailMapper channelClearingDetailMapper;

    @Override
    public void insertClearingDetail(ChannelClearingDetail channelClearingDetail) {
        channelClearingDetailMapper.insertSelective(channelClearingDetail);
    }
}
