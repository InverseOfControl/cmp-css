package com.ipaylinks.cmp.css.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ipaylinks.cmp.css.dal.model.MertSettlementDetail;
import com.ipaylinks.cmp.css.dal.model.MertSettlementTask;

public interface MertSettlementDetailMapper {
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
    int insert(MertSettlementDetail record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(MertSettlementDetail record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    MertSettlementDetail selectByPrimaryKey(String id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MertSettlementDetail record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(MertSettlementDetail record);
    
    /**
     * 获取待处理清单
     *
     * @param record
     */
	List<MertSettlementDetail> getMertSettlementDetailList(MertSettlementDetail record);


	/**
     * 根据条件获取结算明细进行生成结算单定时任务表
     *
     * @param record
     */
	List<MertSettlementDetail> getMertSettlementAccountErrorDetail(MertSettlementDetail record);

 

	/**
     * 根据条件获取结算明细进行生成结算单定时任务表
     *
     * @param record
     */
	List<MertSettlementTask> createSettleDetailToSettleTask();

	 /**
     * 根据商户和结算时间获取商户结算单列表
     *
     * @param record
     */
	List<MertSettlementDetail> getSumMertSettlementDetail();

	/**
     * 根据结算单任务回写任务批次号
     *
     * @param record
	 * @return 
     */
	int updateMertSettlementDetail1(MertSettlementDetail mertSettlementDetail1);

	/**
     *根据商户结算日期和商户编号获取商户结算列表信息
     *
     * @param record
	 * @return 
     */
	List<MertSettlementDetail> getMertSettlementDetailByMerchantId(
			MertSettlementDetail mertSettlementDetail);

	/**
	 * 查询结算明细列表信息
	 *
	 * @author hongxu.gao
	 * @date 2018/8/8 15:33
	 * @return java.util.List<com.ipaylinks.cmp.css.dal.model.MertSettlementDetail>
	 */
	List<MertSettlementDetail> selectList(MertSettlementDetail mertSettlementDetail);
	/**
     *获取需要生成保证金列表
     *
     * @param record
	 * @return 
     */
	List<MertSettlementDetail> getMertSettlementDetailDeposit(MertSettlementDetail record);

	/**
     *根据结算时间和结算状态生成结算任务
     *
     * @param record
	 * @return 
     */
	List<MertSettlementDetail> getSumMertSettlementDetailTask(
			MertSettlementDetail mertSettlementDetail);

	List<MertSettlementDetail> getMertSettlementDetailListByMerchantIdReport(
			MertSettlementDetail mertSettlementDetail);
	/**
     *根据结算单id回写结算明细
     *
     * @param record
	 * @return 
     */
	int updateMertSettlementDetail1Id(MertSettlementDetail mertSettlementDetail);

	/**
     * 处理由于结算单异常影响的结算明细
     *
     * @param record
	 * @return 
     */
	List<MertSettlementDetail> getDealMertSettlementOrderAbortDetail(@Param("merchantId")String merchantId,
			@Param("settlementId")String settlementId);

	/**
     * 统计所有需要出的对账单的交易商户
     *
     * @param record
	 * @return 
     */
	List<MertSettlementDetail> countTradeMerchant();
	/**
     * 根据清算主订单ID获取结算明细进行
     *
     * @param record
	 * @return 
     */
	List<MertSettlementDetail> getMertSettlementDetailListByOrderId(
			String orderId);
}