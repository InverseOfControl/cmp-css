package com.ipaylinks.cmp.css.service.impl;

import com.csvreader.CsvWriter;
import com.ipaylinks.cmp.css.dal.mapper.LiquidationOrderMapper;
import com.ipaylinks.cmp.css.dal.model.LiquidationOrder;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.service.FileUploadFtpService;
import com.ipaylinks.cmp.css.service.LiquidationOrderService;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.ipaylinks.common.enums.TradeTypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.List;

@Service("liquidationOrderService")
public class LiquidationOrderServiceImpl implements LiquidationOrderService {

	private Logger logger = LoggerFactory.getLogger(LiquidationOrderServiceImpl.class);
	
    @Autowired(required = false)
    private LiquidationOrderMapper liquidationOrderMapper;

    @Autowired(required = false)
    private FileUploadFtpService fileUploadFtpService;

    @Override
    public int deleteByPrimaryKey(String id) {
        return liquidationOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(LiquidationOrder record) {
        return liquidationOrderMapper.insertSelective(record);
    }

    @Override
    public LiquidationOrder selectByPrimaryKey(String id) {
        return liquidationOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(LiquidationOrder record) {
        return liquidationOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LiquidationOrder record) {
        return liquidationOrderMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<LiquidationOrder> selectByParams(LiquidationOrder record){
        return liquidationOrderMapper.selectByParams(record);
    }

    @Override
    public LiquidationOrder selectByOrderId(String orderId){
        if(StringUtils.isBlank(orderId)){
            return null;
        }
        LiquidationOrder record = new LiquidationOrder();
        record.setOrderId(orderId);
        return this.selectByParams(record).get(0);
    }

    @Override
    public List<LiquidationOrder> selectByOriOrderId(String oriOrderId){
        if(StringUtils.isBlank(oriOrderId)){
            return null;
        }
        LiquidationOrder record = new LiquidationOrder();
        record.setOriOrderId(oriOrderId);
        return this.selectByParams(record);
    }

    @Override
    public List<LiquidationOrder> selectList(LiquidationOrder record) {
        return liquidationOrderMapper.selectList(record);
    }

    /**
     * 根据清算订单日期获取清算订单数据生成T-1日 清算对账文件
     * @author yuyao
     * 
     * */
	@Override
	public void createMerTradeStatementAccount(String merchantId,String orderDate) throws BusinessException {
		try {
			
			String[] tradeHeader={"序号","商户编号","商户名称","商户订单编号","订单日期","网关订单号","订单类型","订单币种","订单金额","原商户订单编号","扩展序列1","扩展序列1"};
			SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
			//创建对账文件 TODO
			String  filePath="/opt/temp/reconcile_order/"+ orderDate+"/"+merchantId+"/";
			String fileName =orderDate+"transaction.csv";
			//生成对象头
			try {
                File file = new File(filePath);
                file.mkdirs();
                //交易对账单
                filePath = filePath + fileName;
                file = new File(filePath);
                if(file.exists()){
                    file.delete();
                }
                file.createNewFile();
                //String filePath1="C:\\StemQ\\"+orderDate+"\\"+merchantId+".csv"; 测试地址
				CsvWriter csvWriter=new CsvWriter(filePath,',', Charset.forName("GBK"));
				csvWriter.writeRecord(tradeHeader);
				//获取对象明细
				List<LiquidationOrder> liquidationOrderHeaderList =this.liquidationOrderMapper.getLiquidationOrderHeaderList(merchantId,orderDate);
				for (int i =0 ;i<liquidationOrderHeaderList.size();i++) {
					LiquidationOrder liquidationOrder = liquidationOrderHeaderList.get(i);  
					String[] content={""+(i+1)+"",liquidationOrder.getMerchantId(),liquidationOrder.getMerchantName(),liquidationOrder.getMerchantOrderId(),sdf.format(liquidationOrder.getGmtCreateTime()),liquidationOrder.getOrderId(),TradeTypeEnum.getDescByNumeric(liquidationOrder.getTransType()),liquidationOrder.getTransCurrency(),String.valueOf(liquidationOrder.getTransAmount()),liquidationOrder.getOriMerchantOrderId(),"",""};
				    csvWriter.writeRecord(content);
			    }
	            csvWriter.close();
	            try {
                    fileUploadFtpService.uploadToFtp(merchantId, orderDate, filePath);
                }catch (Exception e){
                    logger.error("上传商户交易对账单异常", e);
                }
			} catch (IOException e) {
				logger.error("create merchant settlement  summary account  error ={}",e);
				throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "生成商户交易对账单异常");
			}
		} catch (Exception e) {
			logger.info("create merchant settlement  summary account  error ={}",e);
			throw new BusinessException(CmpCssExceptionCode.SYSTEM_EXCEPTION.getCode(), "生成商户交易对账单异常");
		}
	}

	/**
     * 根据自然日获取当前一日所有参与交易的商户信息
     * @desc 支持单商户生成和自动生成
     * @author yuyao
     * @date 2018/8/3 14:12
     */
	@Override
	public List<LiquidationOrder> getMertListByDay(String date) {
		return liquidationOrderMapper.getMertListByDay(date);
	}

	/**
     * 重新处理清分失败的记录
     * @desc 支持单商户生成和自动生成
     * @author yuyao
     * @date 2018/8/3 14:12
     */
	@Override
	public List<LiquidationOrder> queryLiquidationOrderError() {
		return liquidationOrderMapper.queryLiquidationOrderError();
	}
}
