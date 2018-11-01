package com.ipaylinks.cmp.css.facade.request;

import com.ipaylinks.common.page.PageBean;
import com.ipaylinks.common.rpc.BaseRequest;
import net.sf.oval.constraint.NotNull;

import java.util.Date;

/**
 * 渠道订单查询请求对象
 *
 * @author hongxu.gao
 * @date 2018/8/6 14:57
 */
public class ChannelOrderQueryRequest extends BaseRequest {

    private static final long serialVersionUID = -1L;

    /**
     * 商户ID
     */
    private String merchantId;
    /**
     * 交易类型
     */
    private String transType;
    /**
     * 交易状态
     */
    private String transStatus;
    /**
     * 渠道号
     */
    private String orgCode;
    /**
     * 子渠道号
     */
    private String orgSubCode;
    /**
     * 渠道交易币种
     */
    private String payCurrency;
    /**
     * 支付方式
     */
    private String payMethod;
    /**
     * 渠道流水号
     */
    private String channelOrderId;
    /**
     * 渠道返回流水号
     */
    private String channelReturnId;
    /**
     * 渠道交易完成开始日期
     */
    private Date beginChannelCompleteTime;
    /**
     * 渠道交易完成结束日期
     */
    private Date endChannelCompleteTime;

    /**
     * 商户订单号
     */
    private String merchantOrderId;

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

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgSubCode() {
        return orgSubCode;
    }

    public void setOrgSubCode(String orgSubCode) {
        this.orgSubCode = orgSubCode;
    }

    public String getPayCurrency() {
        return payCurrency;
    }

    public void setPayCurrency(String payCurrency) {
        this.payCurrency = payCurrency;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getChannelOrderId() {
        return channelOrderId;
    }

    public void setChannelOrderId(String channelOrderId) {
        this.channelOrderId = channelOrderId;
    }

    public String getChannelReturnId() {
        return channelReturnId;
    }

    public void setChannelReturnId(String channelReturnId) {
        this.channelReturnId = channelReturnId;
    }

    public Date getBeginChannelCompleteTime() {
        return beginChannelCompleteTime;
    }

    public void setBeginChannelCompleteTime(Date beginChannelCompleteTime) {
        this.beginChannelCompleteTime = beginChannelCompleteTime;
    }

    public Date getEndChannelCompleteTime() {
        return endChannelCompleteTime;
    }

    public void setEndChannelCompleteTime(Date endChannelCompleteTime) {
        this.endChannelCompleteTime = endChannelCompleteTime;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }
}


