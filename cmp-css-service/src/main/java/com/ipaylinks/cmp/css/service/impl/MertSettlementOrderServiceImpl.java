package com.ipaylinks.cmp.css.service.impl;

import com.ipaylinks.cmp.css.dal.mapper.MertSettlementOrderMapper;
import com.ipaylinks.cmp.css.dal.model.MertSettlementOrder;
import com.ipaylinks.cmp.css.service.MertSettlementOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service("mertSettlementOrderService")
public class MertSettlementOrderServiceImpl implements
		MertSettlementOrderService {

	@Autowired(required = false)
	private MertSettlementOrderMapper mertSettlementOrderMapper;
	
	@Override
	public int deleteByPrimaryKey(String id) {
		return mertSettlementOrderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(MertSettlementOrder record) {
		return mertSettlementOrderMapper.insert(record);
	}

	@Override
	public int insertSelective(MertSettlementOrder record) {
		return mertSettlementOrderMapper.insertSelective(record);
	}

	@Override
	public MertSettlementOrder selectByPrimaryKey(String id) {
		return mertSettlementOrderMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(MertSettlementOrder record) {
		return mertSettlementOrderMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MertSettlementOrder record) {
		return mertSettlementOrderMapper.updateByPrimaryKey(record);
	}

	@Override
	public void batchInsert(List<MertSettlementOrder> mertSettlementOrderList) {
		// TODO Auto-generated method stub
		if(mertSettlementOrderList!=null){
			 for (Iterator iterator = mertSettlementOrderList.iterator(); iterator
					.hasNext();) {
				MertSettlementOrder mertSettlementOrder = (MertSettlementOrder) iterator
						.next();
				mertSettlementOrderMapper.insert(mertSettlementOrder);
			}
		}
	}

	@Override
	public List<MertSettlementOrder> getMertSettlementAccountError() {
		return mertSettlementOrderMapper.getMertSettlementAccountError();
	}

	 /**
     * 获取当前所有记账失败的交易记录进行重新记账
     *
     */
	@Override
	public List<MertSettlementOrder> getMertSettlementOrderAccountErrorDetail(
			MertSettlementOrder mertSettlementOrder) {
		return  mertSettlementOrderMapper.getMertSettlementOrderAccountErrorDetail(mertSettlementOrder);
	}

	 /**
     * 获取结算单业务编码ID
     *
     */
	@Override
	public String getSettlementOrderId() {
		return mertSettlementOrderMapper.getSettlementOrderId();
	}

	@Override
	public List<MertSettlementOrder> getSettlementOrderList(MertSettlementOrder mertSettlementOrder) {
		List<MertSettlementOrder> mertSettlementOrderList=mertSettlementOrderMapper.getSettlementOrderList(mertSettlementOrder);
		return mertSettlementOrderList;
	}

	@Override
	public List<MertSettlementOrder> getMertSettlementOrderList(MertSettlementOrder mertSettlementOrder) {
		return mertSettlementOrderMapper.getMertSettlementOrderList(mertSettlementOrder);
	}

	@Override
	public int updateMertSettlementOrder(MertSettlementOrder record) {
		return mertSettlementOrderMapper.updateMertSettlementOrder(record);
	}

	@Override
	public List<MertSettlementOrder> getMertSettlementOrderListByAccount(
			MertSettlementOrder record) {
		return mertSettlementOrderMapper.getMertSettlementOrderListByAccount(record);
	}
	 /**
     * 根据汇总单编号修正汇总单金额
     * @param record
     */
	@Override
	public List<MertSettlementOrder> sumMertSettlementOrderAmount(MertSettlementOrder record) {
		return  mertSettlementOrderMapper.sumMertSettlementOrderAmount(record);
	}

	@Override
	public List<MertSettlementOrder> getMertSettlementOrderListForReport(
			MertSettlementOrder mertSettlementOrder) {
		return  mertSettlementOrderMapper.getMertSettlementOrderListForReport(mertSettlementOrder);
	}

	 /**
     * 获取异常的记账数据和结算汇总数据
     * @param record
     */
	@Override
	public List<MertSettlementOrder> getMertSettlementOrderErrorList(
			MertSettlementOrder mertSettlementOrder) {
		return  mertSettlementOrderMapper.getMertSettlementOrderErrorList(mertSettlementOrder);
	}
}
