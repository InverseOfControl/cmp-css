package com.ipaylinks.cmp.css.dal.mapper;

import com.ipaylinks.cmp.css.dal.model.MertClearingDetail;
import com.ipaylinks.cmp.css.dal.model.MertFee;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MertClearingDetailMapper {
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
    int insertSelective(MertClearingDetail record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    MertClearingDetail selectByPrimaryKey(String id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MertClearingDetail record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(MertClearingDetail record);
    
    /**
     * 根据指导状态获取对应清算明细
     *
     * @param record
     */
    List<MertClearingDetail> getMertClearingDetailList(MertClearingDetail record);

    /**
     * 查询商户清分明细表信息
     */
    List<MertClearingDetail> selectList(MertClearingDetail record);

    /**
     * 汇总上月交易
     * 汇总维度：merchant_id、pay_method、trans_type、amount_type、trans_currency
     * @return
     */
    List<MertClearingDetail> sumLastMonthRecord();

    /**
     * 查询商户手续费
     *
     * @author hongxu.gao
     * @date 2018/8/29 15:28
     * @return java.util.List<com.ipaylinks.cmp.css.dal.model.MertFee>
     */
    List<MertFee> selectMertFee(MertFee mertFee);

    /**
     * 收费
     *
     * @author hongxu.gao
     * @date 2018/9/3 16:18
     */
    int charge(MertFee mertFee);
    /**
     * 获取原交易金额的比例费
     *
     * @author hongxu.gao
     * @date 2018/9/3 16:18
     */
	MertClearingDetail selectOgiProportionalFee(@Param("merchantId")String merchantId,@Param("oriOrderId")String oriOrderId,@Param("amountType")String amountType);
}
