package com.ipaylinks.cmp.css.integration.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ipaylinks.common.rpc.BaseRequest;
/**
 * 记账规则查询请求
 * @author chen_yq
 * @date 2018.04.24
 */
public class RuleRequest extends BaseRequest{
	private static final long serialVersionUID = -5129122806283588526L;
	/**产品code**/
	private String prodCode;
	/**场景code**/
    private String sceneCode;
    /**交易类型**/
    private String tradeType;
    /**金额类型**/
    private String financeType;
    /**币种类型**/
    private String currencyType;
    public RuleRequest () {}
    /**
     * @param sceneCode 场景code
     * @param tradeType 交易类型
     * @param financeType 金额类型
     */
    public RuleRequest (String sceneCode,String tradeType,String financeType) {
    	this.sceneCode = sceneCode;
    	this.tradeType = tradeType;
    	this.financeType = financeType;
    }
    
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getSceneCode() {
		return sceneCode;
	}
	public void setSceneCode(String sceneCode) {
		this.sceneCode = sceneCode;
	}
	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getFinanceType() {
		return financeType;
	}

	public void setFinanceType(String financeType) {
		this.financeType = financeType;
	}
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}
}
