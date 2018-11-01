package com.ipaylinks.cmp.css.dal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ipaylinks.cmp.css.dal.model.MertSettlementSummary;
import com.ipaylinks.cmp.css.util.BusinessException;

public interface MertSettlementSummaryMapper {
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
     * 获取结算汇总单编号
     *
     * @param record
     */
	String getSettleSummaryOrderId();

    /**
     * 查询结算汇总单列表数据
     * @param mertSettlementSummary
     */
    List<MertSettlementSummary> selectList(MertSettlementSummary mertSettlementSummary);

    /**
     * 查询结算汇总单列表数据
     * @param mertSettlementSummary
     */
	List<MertSettlementSummary> getSettleSummaryOrderList(MertSettlementSummary mertSettlementSummary) throws BusinessException;
	 /**
     * 获取当前日期的结算汇总单设计到商户信息
     * @param mertSettlementSummary
     */
	List<MertSettlementSummary> getSettleSummaryHeaderList(@Param("merchantId")String merchantId,@Param("summaryDate")String summaryDate) throws BusinessException;
	 /**
     * 根据结算币种和商户号统计当前需要记账的结算汇总单
     * @param mertSettlementSummary
     */
	List<MertSettlementSummary> getMertSettlementSummaryList(@Param("merchantId")String merchantId,@Param("summaryCurrency")String summaryCurrency,@Param("dealStatus")String dealStatus);
}