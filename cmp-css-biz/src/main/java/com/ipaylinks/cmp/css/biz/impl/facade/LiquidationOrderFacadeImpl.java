package com.ipaylinks.cmp.css.biz.impl.facade;

import com.github.pagehelper.Page;
import com.ipaylinks.cmp.css.biz.common.LiquidationOrderCreateContext;
import com.ipaylinks.cmp.css.biz.impl.common.SaveOrderRequestHandler;
import com.ipaylinks.cmp.css.dal.model.LiquidationOrder;
import com.ipaylinks.cmp.css.dal.model.LiquidationSubOrder;
import com.ipaylinks.cmp.css.facade.LiquidationOrderFacade;
import com.ipaylinks.cmp.css.facade.dto.LiquidationOrderDto2;
import com.ipaylinks.cmp.css.facade.dto.LiquidationSubOrderDTO;
import com.ipaylinks.cmp.css.facade.request.LiquidationOrderCreateRequest;
import com.ipaylinks.cmp.css.facade.request.LiquidationOrderQueryRequest;
import com.ipaylinks.cmp.css.facade.request.LiquidationSubOrderQueryRequest;
import com.ipaylinks.cmp.css.service.LiquidationOrderService;
import com.ipaylinks.cmp.css.service.LiquidationSubOrderService;
import com.ipaylinks.cmp.css.util.ResponseUtils;
import com.ipaylinks.common.exception.BaseExceptionCode;
import com.ipaylinks.common.page.PagedResult;
import com.ipaylinks.common.page.PagedUtil;
import com.ipaylinks.common.rpc.BaseResponse;
import com.ipaylinks.common.rpc.response.PageQueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 清算订单对外服务
 * @author dapeng.tong
 */
@Service("liquidationOrderFacade")
public class LiquidationOrderFacadeImpl implements LiquidationOrderFacade {

    private Logger logger = LoggerFactory.getLogger(LiquidationOrderFacadeImpl.class);

    @Autowired
    private SaveOrderRequestHandler saveOrderRequestHandler;

    @Autowired
    private LiquidationOrderService liquidationOrderService;

    @Autowired
    private LiquidationSubOrderService liquidationSubOrderService;

    @Override
    public BaseResponse createLiquidationOrder(LiquidationOrderCreateRequest request) {
        logger.info("清算订单落单开始，request={}", request);
        LiquidationOrderCreateContext ctx = new LiquidationOrderCreateContext();
        ctx.setBaseRequest(request);
        BaseResponse response = saveOrderRequestHandler.invoke(ctx);
        logger.info("清算订单落单结束");
        return response;
    }

    @Override
    public PageQueryResponse queryLiquidationOrder(LiquidationOrderQueryRequest request) {
        logger.info("LiquidationOrderFacadeImpl.queryLiquidationOrder begin，request={}", request);
        Page<LiquidationOrderDto2> page = PagedUtil.startPage(request.getPageBean());
        LiquidationOrder liquidationOrder = new LiquidationOrder();
        BeanUtils.copyProperties(request, liquidationOrder);
        liquidationOrderService.selectList(liquidationOrder);

        PagedResult pagedResult = null;
        try {
            pagedResult = PagedUtil.toPagedResultDTO(page, LiquidationOrderDto2.class);
        } catch (Exception e) {
            logger.error("QuerySettlementDetailFacadeImpl.queryLiquidationOrder page exception：{}", e );
        }

        PageQueryResponse pageQueryResponse = new PageQueryResponse();
        pageQueryResponse.setPagedResult(pagedResult);
        ResponseUtils.setToSuccess(pageQueryResponse);
        logger.info("LiquidationOrderFacadeImpl.queryLiquidationOrder end，result={}", pageQueryResponse);
        return pageQueryResponse;
    }

    @Override
    public PageQueryResponse<LiquidationSubOrderDTO> queryLiquidationSubOrder(LiquidationSubOrderQueryRequest request) {
        logger.info("查询清算子订单开始，request={}", request);
        PageQueryResponse pageQueryResponse = new PageQueryResponse();
        Page<LiquidationSubOrderDTO> page = PagedUtil.startPage(request.getPageBean());
        LiquidationSubOrder liquidationSubOrder = new LiquidationSubOrder();
        BeanUtils.copyProperties(request, liquidationSubOrder);
        liquidationSubOrderService.selectByParams(liquidationSubOrder);

        PagedResult pagedResult = null;
        try {
            pagedResult = PagedUtil.toPagedResultDTO(page, LiquidationSubOrderDTO.class);
        } catch (Exception e) {
            logger.error("查询清算子订单异常，exception={}", e );
            ResponseUtils.setToFail(pageQueryResponse, BaseExceptionCode.TRANSFORM_ERROR.getCode(),"查询清算子订单异常");
            return pageQueryResponse;
        }
        pageQueryResponse.setPagedResult(pagedResult);
        ResponseUtils.setToSuccess(pageQueryResponse);
        logger.info("查询清算子订单结束，response={}", pageQueryResponse);
        return pageQueryResponse;
    }

}
