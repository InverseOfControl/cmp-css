package com.ipaylinks.cmp.css.service;

import java.util.List;

import com.ipaylinks.cmp.css.dal.model.MertSettlementDetail;
import com.ipaylinks.cmp.css.dal.model.MertSettlementOrder;
import com.ipaylinks.cmp.css.dal.model.MertSettlementTask;
import com.ipaylinks.cmp.css.integration.res.CreateMermberAccountFeeResponse;
import com.ipaylinks.cmp.css.util.BusinessException;
public interface MertSettlementDetailService {

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
     * 根据系统获取所有结算明细进行预处理
     *
     * @param record
     */
	List<MertSettlementDetail> getMertSettlementDetail(MertSettlementDetail record);

	 /**
     * 根据结算明细单生成结算单任务
     *
     * @param record
     */
	List<MertSettlementOrder> getMertSettlementDetailList(
			MertSettlementDetail mertSettlementDetail);
	 /**
     * 查询记账失败的交易明细记录
     *
     * @param record
     */
	List<MertSettlementDetail> getMertSettlementAccountErrorDetail(MertSettlementDetail record);

	 /**
     * 根据商户和结算时间获取商户结算单列表
     *
     * @param record
     */
	List<MertSettlementDetail> getSumMertSettlementDetail();

	 /**
     * 根据商户和结算时间生成商户结算单任务s
     *
     * @param record
     */
	MertSettlementTask createMertSettlementTask(
			MertSettlementDetail mertSettlementDetail,String settleDate) throws BusinessException;
	 /**
     * 根据商户和结算时间生成商户结算单任务s
     *
     * @param record
	 * @return 
     */
	List<MertSettlementDetail> getMertSettlementDetailByMerchantId(
			MertSettlementDetail mertSettlementDetail)throws BusinessException;
	 /**
     * 根据根据商户信息生成保证金记录
     *
     * @param record
	 * @return 
     */
	void createMertSettlementCashDeposit(
			List<MertSettlementDetail> mertSettlementDetailDeposit) throws BusinessException;

	/**
	 * 查询结算明细列表信息
	 *
	 * @author hongxu.gao
	 * @date 2018/8/8 15:33
	 * @return java.util.List<com.ipaylinks.cmp.css.dal.model.MertSettlementDetail>
	 */
	List<MertSettlementDetail> selectList(MertSettlementDetail mertSettlementDetail);

	 /**
     * 根据结算明细进行记账异常记录进行补偿记账
     *
     * @param record
	 * @return 
     */
	void dealMertSettlementDetailAccountError(String dealCode,String settleDate) throws BusinessException;

	 /**
     * 根据结算明细生成保证金数据
     *
     * @param record
	 * @return 
     */
	void createMertSettlementCashDepositFromMertSettlementDetail(
			MertSettlementDetail mertSettlementDetail)  throws BusinessException;
	
	/**
     * 处理结算明细保证金记账失败重新记账
     *
     * @param record
	 * @return 
     */
	void dealMertSettlementCashDepositAccountError() throws BusinessException;

	/**
     * 处理结算明细预处理操作
     *
     * @param record
	 * @return 
     */
	void preMertSettlementDetailList(MertSettlementDetail mertSettlementDetail) throws BusinessException;
	
	/**
     * 生成结算单结算任务
     *
     * @param record
	 * @return 
     */
	List<MertSettlementTask> createMertSettlementTaskFromMertSettlementDetail(MertSettlementDetail mertSettlementDetail) throws BusinessException;

	/**
     * 根据商户编号和结算单编号生成商户结算明细
     *
     * @param record
	 * @return 
     */
	List<MertSettlementDetail> getMertSettlementDetailListByMerchantId(
			MertSettlementDetail mertSettlementDetail);
	/**
     * 重新处理保证金失败重新需要生成保证金的数据
     *
     * @param record
	 * @return 
     */
	void dealMertSettlementCashDepositFromMertSettlementDetail(
			MertSettlementDetail mertSettlementDetail) throws BusinessException ;
	/**
     * 生成结算单明细报表
     *
     * @param record
	 * @return 
     */
	List<MertSettlementDetail> getMertSettlementDetailListByMerchantIdReport(
			MertSettlementDetail mertSettlementDetail);
	/**
     * 更新结算单Id到结算单明细字段
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
	void dealMertSettlementOrderAbortDetail(List<MertSettlementOrder> mertSettlementOrderList) throws BusinessException;

	/**
     * 统计所有需要出的对账单的交易商户
     *
     * @param record
	 * @return 
     */
	List<MertSettlementDetail> countTradeMerchant();
	/**
     * 结算明细单记账
     *
     * @param record
	 * @return 
     */
	CreateMermberAccountFeeResponse dealMertSettlementDetailAccount ( 
			MertSettlementDetail mertSettlementDetail, String dealCode) throws BusinessException;

	/**
     * 根据清算主订单ID获取结算明细进行
     *
     * @param record
	 * @return 
     */
	List<MertSettlementDetail> getMertSettlementDetailListByOrderId(
			String orderId);
	
}
