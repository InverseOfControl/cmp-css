package com.ipaylinks.cmp.css.dal.mapper;

import com.ipaylinks.cmp.css.dal.model.LiquidationOrder;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LiquidationOrderMapper {
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
    int insert(LiquidationOrder record);

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
     * 清算订单查询
     *
     * @author hongxu.gao
     * @date 2018/7/27 13:53
     * @param record
     * @return java.util.List<com.ipaylinks.cmp.css.dal.model.LiquidationOrder>
     */
    List<LiquidationOrder> selectList(LiquidationOrder record);

    /**
     * 获取商户交易对账单明细
     * @author yuyao
     * @date 2018/7/27 13:53
     * @param record
     */
	List<LiquidationOrder> getLiquidationOrderList(Map<String,String> map);
	  /**
     * 获取商户编号
     * @author yuyao
     * @date 2018/7/27 13:53
     * @param record
     */
	List<LiquidationOrder> getLiquidationOrderHeaderList(
			@Param("merchantId") String merchantId,@Param("tradeDate") String tradeDate);


	/**
     * 根据自然日获取当前一日所有参与交易的商户信息
     * @desc 支持单商户生成和自动生成
     * @author yuyao
     * @date 2018/8/3 14:12
     */
	List<LiquidationOrder> getMertListByDay(@Param("tradeDate") String tradeDate);

	/**
     * 重新处理清分失败的记录
     * @desc 支持单商户生成和自动生成
     * @author yuyao
     * @date 2018/8/3 14:12
     */
	List<LiquidationOrder> queryLiquidationOrderError();
}
