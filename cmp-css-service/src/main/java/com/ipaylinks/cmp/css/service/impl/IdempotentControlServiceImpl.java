package com.ipaylinks.cmp.css.service.impl;

import com.ipaylinks.cmp.css.dal.mapper.IdempotentControlMapper;
import com.ipaylinks.cmp.css.dal.model.IdempotentControl;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.service.IdempotentControlService;
import com.ipaylinks.cmp.css.util.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service("idempotentControlService")
public class IdempotentControlServiceImpl implements IdempotentControlService {

    @Autowired(required = false)
    private IdempotentControlMapper idempotentControlMapper;

     /**
     * 插入数据库记录
     *
     * @param record
     */
     @Override
     public int insert(IdempotentControl record) throws Exception{
         try {
             return idempotentControlMapper.insert(record);
         }catch (DuplicateKeyException e){
             throw new BusinessException(CmpCssExceptionCode.VIOLATION_UNIQUE_CONSTRAINT.getCode(), "幂等校验失败");
         }
     }
    
}
