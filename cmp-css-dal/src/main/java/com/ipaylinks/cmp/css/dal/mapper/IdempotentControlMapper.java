package com.ipaylinks.cmp.css.dal.mapper;

import com.ipaylinks.cmp.css.dal.model.IdempotentControl;

public interface IdempotentControlMapper {

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(IdempotentControl record);


}
