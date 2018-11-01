package com.ipaylinks.cmp.css.service.impl;

import com.ipaylinks.cmp.css.dal.mapper.MertClearingDetailMapper;
import com.ipaylinks.cmp.css.dal.model.MertClearingDetail;
import com.ipaylinks.cmp.css.dal.model.MertFee;
import com.ipaylinks.cmp.css.service.MertClearingDetailService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mertClearingDetailService")
public class MertClearingDetailServiceImpl implements MertClearingDetailService {

	private Logger logger = LoggerFactory.getLogger(MertClearingDetailServiceImpl.class);

	@Autowired(required = false)
	private MertClearingDetailMapper mertClearingDetailMapper;

	/**
     * @des    获取清算明细列表
     * @param  mertClearingDetail 自定义参数
     * @return 处理结果自动结束，每天定时跑
     * @author yuyao
     * @data   <a>2018-07-09<a>
     * */
	@Override
	public List<MertClearingDetail> getMertClearingDetail(MertClearingDetail mertClearingDetail) {
		List<MertClearingDetail> list=mertClearingDetailMapper.getMertClearingDetailList(mertClearingDetail);
		return list;
	}

	@Override
	public List<MertClearingDetail> getMertClearingDetailList() {
		MertClearingDetail mertClearingDetail =new MertClearingDetail ();
		List<MertClearingDetail> list=mertClearingDetailMapper.getMertClearingDetailList(mertClearingDetail);
		return list;
	}

	@Override
	public List<MertClearingDetail> selectList(MertClearingDetail mertClearingDetail) {
		return mertClearingDetailMapper.selectList(mertClearingDetail);
	}

	@Override
	public List<MertClearingDetail> sumLastMonthRecord(){
		return mertClearingDetailMapper.sumLastMonthRecord();
	}

	@Override
	public List<MertFee> selectMertFee(MertFee mertFee) {
		return mertClearingDetailMapper.selectMertFee(mertFee);
	}

	@Override
	public List<MertClearingDetail> selectListByOrderTypeAndOriId(String orderType, String oriId){
		if(StringUtils.isBlank(orderType) || StringUtils.isBlank(oriId)){
			return null;
		}
		MertClearingDetail record = new MertClearingDetail();
		record.setOrderType(orderType);
		record.setOriId(oriId);
		return this.selectList(record);
	}

	@Override
	public int charge(MertFee mertFe) {
		return mertClearingDetailMapper.charge(mertFe);
	}

}
