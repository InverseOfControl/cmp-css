package com.ipaylinks.cmp.css.facade.request;

import com.ipaylinks.common.page.PageBean;
import com.ipaylinks.common.rpc.BaseRequest;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 清算子订单查询请求对象
 *
 * @author hongxu.gao
 * @date 2018/7/27 10:50
 */
public class LiquidationSubOrderQueryRequest extends BaseRequest{

    /**
     * 清算子订单号
     */
    private String id;

    /**
     * 清算主订单号
     */
    private String liquidationOrderId;

    /**
     * 渠道流水单号
     */
    private String channelOrderNo;

    /**
     * 分页对象
     */
    private PageBean pageBean;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLiquidationOrderId() {
        return liquidationOrderId;
    }

    public void setLiquidationOrderId(String liquidationOrderId) {
        this.liquidationOrderId = liquidationOrderId;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
