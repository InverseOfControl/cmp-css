package com.ipaylinks.cmp.css.dal.model;

import java.util.Date;

public class RequestLog {
    /**
     * 主键
     * 表 : T_REQUEST_LOG
     * 对应字段 : ID
     */
    private String id;

    /**
     * 请求系统编号
     * 表 : T_REQUEST_LOG
     * 对应字段 : REQ_SYS_ID
     */
    private String reqSysId;

    /**
     * 请求唯一流水号
     * 表 : T_REQUEST_LOG
     * 对应字段 : REQUEST_ID
     */
    private String requestId;

    /**
     * 流水类型
     * 表 : T_REQUEST_LOG
     * 对应字段 : TYPE
     */
    private String type;

    /**
     * 业务流水号
     * 表 : T_REQUEST_LOG
     * 对应字段 : ORDER_ID
     */
    private String orderId;

    /**
     * 创建时间
     * 表 : T_REQUEST_LOG
     * 对应字段 : GMT_CREATE_TIME
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     * 表 : T_REQUEST_LOG
     * 对应字段 : GMT_UPDATE_TIME
     */
    private Date gmtUpdateTime;

    /**
     * 请求原始报文
     * 表 : T_REQUEST_LOG
     * 对应字段 : REQUEST_CONTENT
     */
    private String requestContent;

    /**
     * 响应报文
     * 表 : T_REQUEST_LOG
     * 对应字段 : RESPONSE_CONTENT
     */
    private String responseContent;

    /**
     * get method
     *
     * @return T_REQUEST_LOG.REQUEST_CONTENT：请求原始报文
     */
    public String getRequestContent() {
        return requestContent;
    }

    /**
     * set method
     *
     * @param requestContent  请求原始报文
     */
    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent == null ? null : requestContent.trim();
    }

    /**
     * get method
     *
     * @return T_REQUEST_LOG.RESPONSE_CONTENT：响应报文
     */
    public String getResponseContent() {
        return responseContent;
    }

    /**
     * set method
     *
     * @param responseContent  响应报文
     */
    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent == null ? null : responseContent.trim();
    }

    /**
     * get method 
     *
     * @return T_REQUEST_LOG.ID：主键
     */
    public String getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * get method 
     *
     * @return T_REQUEST_LOG.REQ_SYS_ID：请求系统编号
     */
    public String getReqSysId() {
        return reqSysId;
    }

    /**
     * set method 
     *
     * @param reqSysId  请求系统编号
     */
    public void setReqSysId(String reqSysId) {
        this.reqSysId = reqSysId == null ? null : reqSysId.trim();
    }

    /**
     * get method 
     *
     * @return T_REQUEST_LOG.REQUEST_ID：请求唯一流水号
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * set method 
     *
     * @param requestId  请求唯一流水号
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
    }

    /**
     * get method 
     *
     * @return T_REQUEST_LOG.TYPE：流水类型
     */
    public String getType() {
        return type;
    }

    /**
     * set method 
     *
     * @param type  流水类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * get method 
     *
     * @return T_REQUEST_LOG.ORDER_ID：业务流水号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * set method 
     *
     * @param orderId  业务流水号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * get method 
     *
     * @return T_REQUEST_LOG.GMT_CREATE_TIME：创建时间
     */
    public Date getGmtCreateTime() {
        return gmtCreateTime;
    }

    /**
     * set method 
     *
     * @param gmtCreateTime  创建时间
     */
    public void setGmtCreateTime(Date gmtCreateTime) {
        this.gmtCreateTime = gmtCreateTime;
    }

    /**
     * get method 
     *
     * @return T_REQUEST_LOG.GMT_UPDATE_TIME：更新时间
     */
    public Date getGmtUpdateTime() {
        return gmtUpdateTime;
    }

    /**
     * set method 
     *
     * @param gmtUpdateTime  更新时间
     */
    public void setGmtUpdateTime(Date gmtUpdateTime) {
        this.gmtUpdateTime = gmtUpdateTime;
    }
}
