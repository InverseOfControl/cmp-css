package com.ipaylinks.cmp.css.dal.mapper;

import com.ipaylinks.cmp.css.dal.model.TradeAccountReport;

import java.util.List;

public interface TradeAccountReportMapper {
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
    int insert(TradeAccountReport record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(TradeAccountReport record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    TradeAccountReport selectByPrimaryKey(String id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(TradeAccountReport record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(TradeAccountReport record);

    void batchCreate(List<TradeAccountReport> list);

    int deleteLastMonth();

    List<TradeAccountReport> selectLastMonthByMerchantIdAndPayMethod(TradeAccountReport record);
}
