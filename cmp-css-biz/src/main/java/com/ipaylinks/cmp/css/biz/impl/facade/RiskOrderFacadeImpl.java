package com.ipaylinks.cmp.css.biz.impl.facade;

import com.ipaylinks.cmp.css.biz.common.RiskOrderCreateContext;
import com.ipaylinks.cmp.css.biz.impl.common.SaveOrderRequestHandler;
import com.ipaylinks.cmp.css.facade.RiskOrderFacade;
import com.ipaylinks.cmp.css.facade.request.RiskOrderCreateRequest;
import com.ipaylinks.common.rpc.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 风控订单对外服务
 * @author dapeng.tong
 */
@Service("riskOrderFacade")
public class RiskOrderFacadeImpl implements RiskOrderFacade {

    private Logger logger = LoggerFactory.getLogger(RiskOrderFacadeImpl.class);

    @Autowired
    private SaveOrderRequestHandler saveOrderRequestHandler;

    @Override
    public BaseResponse createRiskOrder(RiskOrderCreateRequest request) {
        logger.info("风控订单落单开始，request={}", request);
        RiskOrderCreateContext ctx = new RiskOrderCreateContext();
        ctx.setBaseRequest(request);
        BaseResponse response = saveOrderRequestHandler.invoke(ctx);
        logger.info("风控订单落单结束");
        return response;
    }

}
