package com.ipaylinks.cmp.css.dal.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.ipaylinks.cmp.css.dal.model.MertSettlementOrder;

public interface MertSettlementOrderMapper {
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
     * 根据结算单记账状态失败重新记账
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
     * 获取结算单业务ID
     *
     * @param record
     */
	String getSettlementOrderId();

	 /**
     * 获取结算单明细需要进行汇总的列表
     *
     * @param record
     */
	List<MertSettlementOrder> getSettlementOrderList(MertSettlementOrder mertSettlementOrder);

    /**
     * 查询结算单列表数据
     * @param mertSettlementOrder
     */
    List<MertSettlementOrder> getMertSettlementOrderList(MertSettlementOrder mertSettlementOrder);

    /**
     * 批量更新结算单
     * @param mertSettlementOrder
     */
	int updateMertSettlementOrder(MertSettlementOrder record);

	  /**
     * 查询待记账的结算单列表
     * @param mertSettlementOrder
     */
	List<MertSettlementOrder> getMertSettlementOrderListByAccount(
			MertSettlementOrder record);
	 /**
     * 根据汇总单编号修正汇总单金额
     * @param mertSettlementOrder
     */
	List<MertSettlementOrder> sumMertSettlementOrderAmount(MertSettlementOrder record);

	List<MertSettlementOrder> getMertSettlementOrderListForReport(
			MertSettlementOrder mertSettlementOrder);

	 /**
     * 获取异常的记账数据和结算汇总数据
     * @param record
     */
	List<MertSettlementOrder> getMertSettlementOrderErrorList(
			MertSettlementOrder mertSettlementOrder);
}