package com.ipaylinks.cmp.css.service;

import com.ipaylinks.cmp.css.dal.model.LiquidationOrder;
import com.ipaylinks.cmp.css.util.BusinessException;

import java.util.Date;
import java.util.List;

public interface LiquidationOrderService {
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
    int insertSelective(LiquidationOrder record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    LiquidationOrder selectByPrimaryKey(String id);
    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(LiquidationOrder record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(LiquidationOrder record);


    List<LiquidationOrder> selectByParams(LiquidationOrder record);

    /**
     * 根据收单订单号查询
     * @param orderId
     * @return
     */
    LiquidationOrder selectByOrderId(String orderId);

    /**
     * 根据原始收单订单号查询
     * @param oriOrderId
     * @return
     */
    List<LiquidationOrder> selectByOriOrderId(String oriOrderId);

    /**
     * 查询列表数据
     *
     * @author hongxu.gao
     * @date 2018/8/3 14:12
     * @param record
     * @return java.util.List<com.ipaylinks.cmp.css.dal.model.LiquidationOrder>
     */
    List<LiquidationOrder> selectList(LiquidationOrder record);

    /**
     * 根据交易日获取当日交易数据
     * @desc 支持单商户生成和自动生成
     * @author yuyao
     * @date 2018/8/3 14:12
     */
	void createMerTradeStatementAccount(String merchantId,String date) throws BusinessException;

	/**
     * 根据自然日获取当前一日所有参与交易的商户信息
     * @desc 支持单商户生成和自动生成
     * @author yuyao
     * @date 2018/8/3 14:12
     */
	List<LiquidationOrder> getMertListByDay(String date);
	/**
     * 重新处理清分失败的记录
     * @desc 支持单商户生成和自动生成
     * @author yuyao
     * @date 2018/8/3 14:12
     */
	List<LiquidationOrder> queryLiquidationOrderError();

}
