package com.ipaylinks.cmp.css.service;

import com.ipaylinks.cmp.css.dal.model.IdempotentControl;

public interface IdempotentControlService {

     /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(IdempotentControl record) throws Exception;

}
