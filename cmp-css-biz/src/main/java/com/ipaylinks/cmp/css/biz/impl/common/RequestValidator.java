package com.ipaylinks.cmp.css.biz.impl.common;

import com.ipaylinks.cmp.css.biz.common.BizResponse;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.ipaylinks.cmp.css.util.ResponseUtils;
import com.ipaylinks.common.rpc.BaseResponse;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 请求参数校验
 * @author dapeng.tong
 * @date 2018/5/8 10:54  
 */
@Service("requestValidator")
public class RequestValidator {
    private Logger logger = LoggerFactory.getLogger(RequestValidator.class);
    @Autowired
    private Validator validator;

    public void validate(Object validatedObject) throws Exception{
        logger.info("请求参数校验开始");
        List<ConstraintViolation> list = validator.validate(validatedObject);
        if(list!=null && list.size()>0){
            throw new BusinessException(CmpCssExceptionCode.PARAMETERS_ERROR.getCode(), list.get(0).getMessage());
        }
        logger.info("请求参数校验通过");
    }

    /**
     * 封装参数校验失败后的响应对象
     *
     * @author hongxu.gao
     * @date 2018/8/6 17:15
     * @param request 请求对象
     * @return com.ipaylinks.cmp.css.biz.common.BizResponse
     */
    public <T> BaseResponse validateResponse(T request){
        BizResponse response = null;
        try {
            this.validate(request);
        } catch (Exception e) {
            response = new BizResponse();
            BusinessException businessException = (BusinessException) e;
            ResponseUtils.setToFail(response,businessException);
        }
        return response;
    }
}
