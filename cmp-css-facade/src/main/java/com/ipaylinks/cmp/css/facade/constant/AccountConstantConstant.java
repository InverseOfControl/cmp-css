package com.ipaylinks.cmp.css.facade.constant;

import java.io.Serializable;

public class AccountConstantConstant implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3068260011892018872L;

	
	public static final String PRODUCT_NO="10"; 
	
	public static final String AMOUNT_TYPE="01"; 
	
	public static final String DEAL_LIQUIDATION_SUB_ORDER_CODE="1001";  //清算明细
	
	public static final String PRODUCT_DESC="产品描述"; 
	
	public static final String DEAL_SETTLE_DETAIL_CODE="1002"; //结算明细
	
	public static final String DEAL_SETTLE_ORDER_CODE="1003";  //结算单
	
	public static final String DEAL_SETTLE_SUMMARY_CODE="1004"; 
	
	public static final String DEAL_CHANNEL_CODE="1005"; 
	
	public static final String DEAL_ERROR_HANDING_FLAG_CODE="1007";
	
	public static final String DEAL_CASH_DEPOSIT_CODE="04"; //收取保证金
	
	public static final String DEAL_RETURN_CASH_DEPOSIT_CODE="05"; //归还保证金
	
	//清算子订单记账
	public static final Integer PS_SEAL_TRADE_CODE=100101;  //清分明细->消费/预授权交易币种
	
	public static final Integer PS_SEAL_PAY_CODE=100102;  //清分明细->消费/预授权支付币种
	
	public static final Integer PS_REFUND_TRADE_CODE=100103; //清分明细->退款 交易币种
 
	public static final Integer PS_REFUND_PAY_CODE=100104; //清分明细->退款 支付币种
	
	public static final Integer PS_REFUSE_TRADE_CODE=100105; //清分明细->拒付 交易币种
	 
	public static final Integer PS_REFUSE_PAY_CODE=100106; //清分明细->拒付 支付币种
	
	//结算明细记账
	public static final Integer PS_SETTLE_DETAIL_TRADE_PAY_CODE=100201; //结算明细->消费/预授权 支付币种
 
	public static final Integer PS_SETTLE_DETAIL_TRADE_CODE=100202; //结算明细->退款 交易币种  比例费/固定费
	 
	public static final Integer PS_SETTLE_DETAIL_PAY_CODE=100201; //结算明细->拒付 支付币种 处理费
	
	
	public static final Integer PS_SETTLE_ORDER_TRADE_PAY_CODE=100201; //结算单->消费/预授权 支付币种
	 
	public static final Integer PS_SETTLE_ORDER_TRADE_CODE=100202; //结算单->退款 交易币种  比例费/固定费
	
	//汇总单记账
	
	public static final Integer PS_SETTLE_ORDER_SUMARRY_TRADE_CODE=100301; //结算单->消费/预授权/退款/拒付  交易币种  本金/比例费/固定费
	
	public static final Integer PS_SETTLE_ORDER_SUMARRY_PAY_CODE=100302; //结算单->消费/预授权/退款/拒付  交易币种  本金/比例费/固定费
	
	public static final Integer PS_SETTLE_ORDER_SUMARRY_REFUND_CODE=100304; //结算单->退款/拒付 交易币种  本金
	
	public static final Integer PS_SETTLE_ORDER_SUMARRY_REFUND_PAY_CODE=100305; //结算单->退款/拒付  交易币种  本金
	
	public static final Integer PS_SETTLE_ORDER_SUMARRY_SALE_TRADE_CODE=100306; //结算单->消费/预授权   交易币种  比例费/固定费/处理费
	
	public static final Integer PS_SETTLE_ORDER_SUMARRY_SALE_PAY_CODE=100307;   //结算单->消费/预授权   交易币种  比例费/固定费/处理费
	
	public static final Integer PS_SETTLE_ORDER_SUMARRY_REFUND_D_CODE=100303; //结算单->消费/预授权   归还保证金 交易币种  
	
	public static final Integer PS_SETTLE_ORDER_SUMARRY_TRADE_D_CODE=100308; //结算单->消费/预授权   收还保证金 交易币种
	
}
