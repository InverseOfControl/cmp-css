package com.ipaylinks.cmp.css.facade.request;

import com.ipaylinks.common.page.PageBean;
import com.ipaylinks.common.rpc.BaseRequest;
import net.sf.oval.constraint.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * 清算订单查询请求对象
 *
 * @author hongxu.gao
 * @date 2018/7/27 10:50
 */
public class LiquidationOrderQueryRequest extends BaseRequest{

    /**
     * 商户ID
     */
    private String merchantId;

    /**
     * 交易类型 com.ipaylinks.common.enums.TradeTypeEnum
     */
    private String transType;

    /**
     * 清算状态 com.ipaylinks.cmp.css.facade.enums.LiquidationStatusEnum
     */
    private String transStatus;

    /**
     * 交易币种
     */
    private String transCurrency;

    /**
     * 商户订单号
     */
    private String merchantOrderId;

    /**
     * 支付订单号
     */
    private String payOrderId;

    /**
     * 收单订单号
     */
    private String orderId;

    /**
     * 支付方式
     */
    private String payMethod;

    /**
     * 开始订单完成时间
     */
    private Date beginPayCompleteTime;
    /**
     * 结束订单完成时间
     */
    private Date endPayCompleteTime;

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

    public String getTransCurrency() {
        return transCurrency;
    }

    public void setTransCurrency(String transCurrency) {
        this.transCurrency = transCurrency;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public Date getBeginPayCompleteTime() {
        return beginPayCompleteTime;
    }

    public void setBeginPayCompleteTime(Date beginPayCompleteTime) {
        this.beginPayCompleteTime = beginPayCompleteTime;
    }

    public Date getEndPayCompleteTime() {
        return endPayCompleteTime;
    }

    public void setEndPayCompleteTime(Date endPayCompleteTime) {
        this.endPayCompleteTime = endPayCompleteTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
