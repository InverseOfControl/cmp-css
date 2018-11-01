package com.ipaylinks.cmp.css.dal.mapper;

import com.ipaylinks.cmp.css.dal.model.AccountLog;

public interface AccountLogMapper {
    /**
     * 根据主键删除数据库的记录
     *
     * @param id
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(AccountLog record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(AccountLog record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    AccountLog selectByPrimaryKey(String id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(AccountLog record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(AccountLog record);
}