package com.ipaylinks.cmp.css.dal.model;

import java.util.Date;

public class IdempotentControl {
    /**
     * 主键
     * 表 : T_IDEMPOTENT_CONTROL
     * 对应字段 : ID
     */
    private String id;

    /**
     * 业务描述
     * 表 : T_IDEMPOTENT_CONTROL
     * 对应字段 : BIZ_DESC
     */
    private String bizDesc;

    /**
     * 唯一索引约束值
     * 表 : T_IDEMPOTENT_CONTROL
     * 对应字段 : UNIQUE_KEY
     */
    private String uniqueKey;

    /**
     * 创建时间
     * 表 : T_IDEMPOTENT_CONTROL
     * 对应字段 : GMT_CREATE_TIME
     */
    private Date gmtCreateTime;

    /**
     * 更新时间
     * 表 : T_IDEMPOTENT_CONTROL
     * 对应字段 : GMT_UPDATE_TIME
     */
    private Date gmtUpdateTime;

    /**
     * get method 
     *
     * @return T_IDEMPOTENT_CONTROL.ID：主键
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
     * @return T_IDEMPOTENT_CONTROL.BIZ_DESC：业务描述
     */
    public String getBizDesc() {
        return bizDesc;
    }

    /**
     * set method 
     *
     * @param bizDesc  业务描述
     */
    public void setBizDesc(String bizDesc) {
        this.bizDesc = bizDesc == null ? null : bizDesc.trim();
    }

    /**
     * get method 
     *
     * @return T_IDEMPOTENT_CONTROL.UNIQUE_KEY：唯一索引约束值
     */
    public String getUniqueKey() {
        return uniqueKey;
    }

    /**
     * set method 
     *
     * @param uniqueKey  唯一索引约束值
     */
    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey == null ? null : uniqueKey.trim();
    }

    /**
     * get method 
     *
     * @return T_IDEMPOTENT_CONTROL.GMT_CREATE_TIME：创建时间
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
     * @return T_IDEMPOTENT_CONTROL.GMT_UPDATE_TIME：更新时间
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