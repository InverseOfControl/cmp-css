package com.ipaylinks.cmp.css.service;

import java.util.List;

import com.ipaylinks.cmp.css.dal.model.MertSettlementTask;
import com.ipaylinks.cmp.css.util.BusinessException;

public interface MertSettlementTaskService {

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
     * 批量插入结算任务订单表
     *
     * @param record
     */
	void batchInsertMertSettlementTask(
			List<MertSettlementTask> listMertSettlementTask);
    /**
     * 获取当天带结算任务明细
     *
     * @param record
     */
	List<MertSettlementTask> queryMertSettlementTask(MertSettlementTask reqMertSettlementTask);

	/**
     * 生成结算单任务
     *
     * @param record
     */
	int createMertSettlementTask(MertSettlementTask mertSettlementTask);
	/**
     * 生成结算单任务
     *
     * @param record
     */
	String createBatchId();

	/**
     * 根据结算单任务处理结算明细
     *
     * @param record
     */
	void dealMertSettlementTask(MertSettlementTask reqMertSettlementTask) throws BusinessException;
	/**
     * 查詢待處理的結算任務列表
     *
     * @param record
     */
	List<MertSettlementTask> getPendingSettlementTaskList(String merchantId,String code);
}
