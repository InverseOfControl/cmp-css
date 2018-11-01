package com.ipaylinks.cmp.css.dal.mapper;

import com.ipaylinks.cmp.css.dal.model.LiquidationSubOrder;

import java.util.List;

public interface LiquidationSubOrderMapper {
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
    int insert(LiquidationSubOrder record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(LiquidationSubOrder record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    LiquidationSubOrder selectByPrimaryKey(String id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(LiquidationSubOrder record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(LiquidationSubOrder record);

    List<LiquidationSubOrder> selectByParams(LiquidationSubOrder record);
}
