package com.ipaylinks.cmp.css.service;

import java.util.List;

import com.ipaylinks.cmp.css.dal.model.MertSettlementOrder;

public interface MertSettlementOrderService {

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
    int insert(MertSettlementOrder record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(MertSettlementOrder record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    MertSettlementOrder selectByPrimaryKey(String id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MertSettlementOrder record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(MertSettlementOrder record);

    /**
     * 根据商户号结算币种生成对应结算单
     *
     * @param record
     */
	void batchInsert(List<MertSettlementOrder> mertSettlementOrder);
	 /**
     * 根据结算单记账失败状态获取重新记账数据
     *
     * @param record
     */
	List<MertSettlementOrder> getMertSettlementAccountError();

	 /**
     * 获取当前所有记账失败的交易记录进行重新记账
     *
     * @param record
     */
	List<MertSettlementOrder> getMertSettlementOrderAccountErrorDetail(
			MertSettlementOrder mertSettlementOrder);
	 /**
     * 获取结算单业务编码
     *
     * @param record
     */
	String getSettlementOrderId();

	 /**
     * 获取结算单列表
     *
     * @param record
     */
	List<MertSettlementOrder> getSettlementOrderList(MertSettlementOrder mertSettlementOrder);

    /**
     * 查询结算单列表数据
     * @param mertSettlementOrder
     */
    List<MertSettlementOrder> getMertSettlementOrderList(MertSettlementOrder mertSettlementOrder);

	int updateMertSettlementOrder(MertSettlementOrder record);

	List<MertSettlementOrder> getMertSettlementOrderListByAccount(
			MertSettlementOrder mertSettlementOrder);
	 /**
     * 根据汇总单编号修正汇总单金额
     * @param mertSettlementOrder
     */
	List<MertSettlementOrder> sumMertSettlementOrderAmount(MertSettlementOrder record);
	/**
	 * 
	 * 获取结算单
	 * 
	 */
	List<MertSettlementOrder> getMertSettlementOrderListForReport(
			MertSettlementOrder mertSettlementOrder);
	/**
	 * 
	 * 获取异常的记账数据和结算汇总数据
	 * 
	 */
	List<MertSettlementOrder> getMertSettlementOrderErrorList(
			MertSettlementOrder mertSettlementOrder);
}
