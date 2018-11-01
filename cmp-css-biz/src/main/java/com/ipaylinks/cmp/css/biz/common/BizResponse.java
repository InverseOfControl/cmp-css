package com.ipaylinks.cmp.css.biz.common;

import com.alibaba.dubbo.common.json.JSON;
import com.ipaylinks.common.rpc.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 扩展BaseResponse,封装返回数据 {@link BaseResponse]
 *
 * @author hongxu.gao
 * @date 2018/7/27 11:32
 */
public class BizResponse<T> extends BaseResponse{

    private final Logger logger = LoggerFactory.getLogger(BizResponse.class);

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        try {
            return JSON.json(this).toString();
        } catch (IOException e) {
            logger.error("BizResponse convert to json exception：",e);
            e.printStackTrace();
        }
        return null;
    }
}
