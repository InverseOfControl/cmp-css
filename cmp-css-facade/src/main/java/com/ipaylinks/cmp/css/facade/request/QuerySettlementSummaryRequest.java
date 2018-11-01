package com.ipaylinks.cmp.css.facade.request;

import com.ipaylinks.common.page.PageBean;
import com.ipaylinks.common.rpc.BaseRequest;
import net.sf.oval.constraint.NotNull;

public class QuerySettlementSummaryRequest extends BaseRequest {

    private static final long serialVersionUID = 5796036984215056505L;

    /**
     * 商户ID
     */
    private String merchantId;
    /**
     * 结算汇总币种
     */
    private String summaryCurrency;

    /**
     * 结算汇总单编号
     */
    private String summaryOrderId;

    /**
     * 是否自动提现
     */
    private String autoWithdrawFlag;

    /**
     * 结算汇总单开始日期
     */
    private String beginDate;

    /**
     * 结算汇总单结束日期
     */
    private String endDate;

    /**
     * 分页信息
     */
    @NotNull(message = "分页信息不能为空")
    private PageBean pageBean;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getSummaryOrderId() {
        return summaryOrderId;
    }

    public void setSummaryOrderId(String summaryOrderId) {
        this.summaryOrderId = summaryOrderId;
    }

    public String getAutoWithdrawFlag() {
        return autoWithdrawFlag;
    }

    public void setAutoWithdrawFlag(String autoWithdrawFlag) {
        this.autoWithdrawFlag = autoWithdrawFlag;
    }

    public String getSummaryCurrency() {
        return summaryCurrency;
    }

    public void setSummaryCurrency(String summaryCurrency) {
        this.summaryCurrency = summaryCurrency;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }
}
