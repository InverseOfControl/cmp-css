package com.ipaylinks.cmp.css.service;

import com.ipaylinks.cmp.css.dal.model.ChannelCost;
import com.ipaylinks.cmp.css.dal.model.ChannelOrder;

import java.util.List;

public interface ChannelOrderService {
    /**
     * 根据主键删除数据库的记录
     *
     * @param id
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(ChannelOrder record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(ChannelOrder record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    ChannelOrder selectByPrimaryKey(String id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(ChannelOrder record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(ChannelOrder record);


    List<ChannelOrder> selectByParams(ChannelOrder record);

    List<ChannelOrder> selectByOrderId(String orderId);

    /**
     * 查询列表
     *
     * @author hongxu.gao
     * @date 2018/8/6 15:18
     * @param record
     * @return java.util.List<com.ipaylinks.cmp.css.dal.model.ChannelOrder>
     */
    List<ChannelOrder> selectList(ChannelOrder record);

    /**
     * 查询渠道成本
     *
     * @author hongxu.gao
     * @date 2018/8/29 17:04
     * @return java.util.List<com.ipaylinks.cmp.css.dal.model.ChannelCost>
     */
    List<ChannelCost> selectChannelCost(ChannelCost channelCost);

}
