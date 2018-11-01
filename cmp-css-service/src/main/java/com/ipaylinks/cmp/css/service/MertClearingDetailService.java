package com.ipaylinks.cmp.css.service;

import com.ipaylinks.cmp.css.dal.model.MertClearingDetail;
import com.ipaylinks.cmp.css.dal.model.MertFee;

import java.util.List;

public interface MertClearingDetailService {

    /**
     * 根据指导状态获取对应清算明细
     */
	List<MertClearingDetail> getMertClearingDetail(MertClearingDetail mertClearingDetail);

	List<MertClearingDetail> getMertClearingDetailList();

	/**
	 * 查询商户手续费
	 *
	 * @author hongxu.gao
	 * @date 2018/8/15 10:29
	 */
	List<MertClearingDetail> selectList(MertClearingDetail mertClearingDetail);

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

	List<MertClearingDetail> selectListByOrderTypeAndOriId(String orderType, String oriId);

	/**
	 * 收费
	 *
	 * @author hongxu.gao
	 * @date 2018/9/3 16:17
	 */
	int charge(MertFee mertFe);

}
