package com.ipaylinks.cmp.css.service;

import com.ipaylinks.cmp.css.dal.model.LiquidationLog;

public interface LiquidationLogService {

    /**
     * 创建清算日志
     */
    LiquidationLog createLiquidationLog(String orderId, String orderType);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    LiquidationLog selectByPrimaryKey(String id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(LiquidationLog record);

    /**
     * 更新处理结果
     * @param id
     * @param result
     */
    void updateResultById(String id, String result);

}
