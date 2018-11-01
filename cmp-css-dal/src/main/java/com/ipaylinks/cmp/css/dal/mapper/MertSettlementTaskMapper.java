package com.ipaylinks.cmp.css.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ipaylinks.cmp.css.dal.model.MertSettlementTask;

public interface MertSettlementTaskMapper {
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
    int insert(MertSettlementTask record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(MertSettlementTask record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    MertSettlementTask selectByPrimaryKey(String id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MertSettlementTask record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(MertSettlementTask record);

    /**
     * 获取带处理结算任务
     *
     * @param record
     */
	List<MertSettlementTask> selectMertSettlementTask(MertSettlementTask reqMertSettlementTask);

    /**
     * 生成结算单任务
     *
     * @param record
     */
	MertSettlementTask insertMertSettlementTask(MertSettlementTask record);

	String selectBatchId();
	/**
     * 返回結算任務列表
     *
     * @param record
     */
	List<MertSettlementTask> getPendingSettlementTaskList(@Param("merchantId")String merchantId,@Param("settleStatus") String settleStatus);
}