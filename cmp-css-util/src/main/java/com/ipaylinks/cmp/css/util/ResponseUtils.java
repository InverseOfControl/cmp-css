package com.ipaylinks.cmp.css.util;

import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.common.enums.BaseRespStatusEnum;
import com.ipaylinks.common.exception.BaseExceptionCode;
import com.ipaylinks.common.rpc.BaseResponse;

public class ResponseUtils {

    /**
     * response置为成功
     * @param response
     */
    public static void setToSuccess(BaseResponse response){
        response.setResponseStatus(BaseRespStatusEnum.SUCCESS.getCode());
        response.setResponseCode(BaseExceptionCode.SUCCESS.getCode());
        response.setResponseMsg(BaseExceptionCode.SUCCESS.getMsg());
    }

    /**
     * response置为失败
     * @param response
     */
    public static void setToFail(BaseResponse response, CmpCssExceptionCode exceptionCode){
        response.setResponseStatus(BaseRespStatusEnum.FAIL.getCode());
        response.setResponseCode(exceptionCode.getCode());
        response.setResponseMsg(exceptionCode.getMsg());
    }

    /**
     * response置为失败
     * @param response
     */
    public static void setToFail(BaseResponse response, CmpCssExceptionCode exceptionCode, String msg){
        response.setResponseStatus(BaseRespStatusEnum.FAIL.getCode());
        response.setResponseCode(exceptionCode.getCode());
        response.setResponseMsg(msg);
    }

    /**
     * response置为失败
     * @param response
     */
    public static void setToFail(BaseResponse response, String responseCode, String responseMsg){
        response.setResponseStatus(BaseRespStatusEnum.FAIL.getCode());
        response.setResponseCode(responseCode);
        response.setResponseMsg(responseMsg);
    }

    /**
     * response置为失败
     * @param response
     */
    public static void setToFail(BaseResponse response, BaseExceptionCode exceptionCode){
        response.setResponseStatus(BaseRespStatusEnum.FAIL.getCode());
        response.setResponseCode(exceptionCode.getCode());
        response.setResponseMsg(exceptionCode.getMsg());
    }
    
    public static void setToFail(BaseResponse resp, BusinessException ex) {
        resp.setResponseStatus(BaseRespStatusEnum.FAIL.getCode());
        resp.setResponseCode(ex.getResponseCode());
        resp.setResponseMsg(ex.getResponseMsg());
    }

}
