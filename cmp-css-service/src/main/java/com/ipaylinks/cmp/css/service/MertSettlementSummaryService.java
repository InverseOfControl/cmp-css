package com.ipaylinks.cmp.css.service;

import java.util.List;

import com.ipaylinks.cmp.css.dal.model.MertSettlementOrder;
import com.ipaylinks.cmp.css.dal.model.MertSettlementSummary;
import com.ipaylinks.cmp.css.util.BusinessException;

public interface MertSettlementSummaryService {

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
    int insert(MertSettlementSummary record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(MertSettlementSummary record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    MertSettlementSummary selectByPrimaryKey(String id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MertSettlementSummary record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(MertSettlementSummary record);
    /**
     * 根据生成结算汇总单业务ID
     *
     */
	String getSettleSummaryOrderId();

    /**
     * 查询结算汇总单列表数据
     * @param mertSettlementSummary
     */
    List<MertSettlementSummary> getMertSettlementSummaryList(MertSettlementSummary mertSettlementSummary);

    /**
     * 处理结算汇总单对应的结算单记账失败补偿记账
     * @param dealCode
     */
	void dealMertSettlementOrderAccountError(String dealCode) throws BusinessException ;

	 /**
     * 根据结算单明细进行生成结算汇总单
     * @param dealCode
     */
	void createMertSettlementSummary(MertSettlementOrder mertSettlementOrder) throws BusinessException;

	 /**
     * 生成商户结算汇总对账单
     * @param dealCode
     */
	void createMertSettlementSummaryAccount(String merchantId,String settleDate) throws BusinessException;
}
