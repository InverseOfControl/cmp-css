package com.ipaylinks.cmp.css.dal.mapper;

import com.ipaylinks.cmp.css.dal.model.TradeStatistics;

public interface TradeStatisticsMapper {
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
    int insert(TradeStatistics record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(TradeStatistics record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    TradeStatistics selectByPrimaryKey(String id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(TradeStatistics record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(TradeStatistics record);
}