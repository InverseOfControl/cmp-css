package com.ipaylinks.cmp.css.facade.request;

import com.ipaylinks.common.page.PageBean;
import com.ipaylinks.common.rpc.BaseRequest;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 商户手续费查询请求对象
 *
 * @author hongxu.gao
 * @date 2018/8/15 9:56
 */
public class QueryMerchantFeeRequest extends BaseRequest {

	private static final long serialVersionUID = -6714303379412915368L;

	/** 主键 */
	private String id;
	/** 商户ID */
	private String merchantId;
	/** 商户名称 */
	private String merchantName;
	/** 交易类型 */
	private String transType;
	/** 费用类型 */
	private String amountType;
	/** 费用结算方式 */
	private String feeSettleMethod;
	/** 结算状态 */
	private String settleStatus;
	/** 交易币种 */
	private String transCurrency;
    /** 开始结算日期 */
    private String beginSettleDate;
    /** 结束结算日期 */
    private String endSettleDate;
    /** 开始订单日期 */
    private String beginOrderDate;
    /** 结算订单日期 */
    private String endOrderDate;
	/** 分页信息 */
	private PageBean pageBean;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getAmountType() {
		return amountType;
	}

	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}

	public String getFeeSettleMethod() {
		return feeSettleMethod;
	}

	public void setFeeSettleMethod(String feeSettleMethod) {
		this.feeSettleMethod = feeSettleMethod;
	}

	public String getSettleStatus() {
		return settleStatus;
	}

	public void setSettleStatus(String settleStatus) {
		this.settleStatus = settleStatus;
	}

	public String getTransCurrency() {
		return transCurrency;
	}

	public void setTransCurrency(String transCurrency) {
		this.transCurrency = transCurrency;
	}

    public String getBeginSettleDate() {
        return beginSettleDate;
    }

    public void setBeginSettleDate(String beginSettleDate) {
        this.beginSettleDate = beginSettleDate;
    }

    public String getEndSettleDate() {
        return endSettleDate;
    }

    public void setEndSettleDate(String endSettleDate) {
        this.endSettleDate = endSettleDate;
    }

    public String getBeginOrderDate() {
        return beginOrderDate;
    }

    public void setBeginOrderDate(String beginOrderDate) {
        this.beginOrderDate = beginOrderDate;
    }

    public String getEndOrderDate() {
        return endOrderDate;
    }

    public void setEndOrderDate(String endOrderDate) {
        this.endOrderDate = endOrderDate;
    }

    public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
