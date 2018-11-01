package com.ipaylinks.cmp.css.service.impl;

import com.ipaylinks.cmp.css.dal.mapper.RequestLogMapper;
import com.ipaylinks.cmp.css.dal.model.RequestLog;
import com.ipaylinks.cmp.css.service.RequestLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("requestLogService")
public class RequestLogServiceImpl implements RequestLogService {

    private Logger logger = LoggerFactory.getLogger(RequestLogServiceImpl.class);

    @Autowired(required = false)
    private RequestLogMapper requestLogMapper;

    @Override
    public int insertSelective(RequestLog record) {
        return requestLogMapper.insertSelective(record);
    }

    @Override
    public RequestLog selectByPrimaryKey(String id) {
        return requestLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RequestLog record) {
        return requestLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void updateResponseContentById(String id, String responseContent){
        try {
            RequestLog record = new RequestLog();
            record.setId(id);
            record.setResponseContent(responseContent);
            requestLogMapper.updateByPrimaryKeySelective(record);
        }catch (Exception e){
            logger.error("更新RequestLog异常", e);
        }
    }

}
