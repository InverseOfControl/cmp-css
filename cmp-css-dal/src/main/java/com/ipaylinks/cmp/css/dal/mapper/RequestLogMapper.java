package com.ipaylinks.cmp.css.dal.mapper;

import com.ipaylinks.cmp.css.dal.model.RequestLog;

public interface RequestLogMapper {
    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(RequestLog record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    RequestLog selectByPrimaryKey(String id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(RequestLog record);

}
