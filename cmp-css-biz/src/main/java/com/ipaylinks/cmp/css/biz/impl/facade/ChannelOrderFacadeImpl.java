package com.ipaylinks.cmp.css.biz.impl.facade;

import com.github.pagehelper.Page;
import com.ipaylinks.cmp.css.biz.common.ChannelOrderCreateContext;
import com.ipaylinks.cmp.css.biz.impl.common.SaveOrderRequestHandler;
import com.ipaylinks.cmp.css.dal.model.ChannelCost;
import com.ipaylinks.cmp.css.dal.model.ChannelOrder;
import com.ipaylinks.cmp.css.facade.ChannelOrderFacade;
import com.ipaylinks.cmp.css.facade.dto.ChannelCostDto;
import com.ipaylinks.cmp.css.facade.dto.ChannelOrderDTO;
import com.ipaylinks.cmp.css.facade.request.ChannelOrderCreateRequest;
import com.ipaylinks.cmp.css.facade.request.ChannelOrderQueryRequest;
import com.ipaylinks.cmp.css.facade.request.QueryChannelCostRequest;
import com.ipaylinks.cmp.css.service.ChannelOrderService;
import com.ipaylinks.cmp.css.util.ResponseUtils;
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
 * 渠道流水对外服务
 * @author dapeng.tong
 */
@Service("channelOrderFacade")
public class ChannelOrderFacadeImpl implements ChannelOrderFacade {

    private Logger logger = LoggerFactory.getLogger(ChannelOrderFacadeImpl.class);
    @Autowired
    private SaveOrderRequestHandler saveOrderRequestHandler;
    @Autowired
    private ChannelOrderService channelOrderService;

    @Override
    public BaseResponse createChannelOrder(ChannelOrderCreateRequest request) {
        logger.info("渠道流水落单开始，request={}", request);
        ChannelOrderCreateContext ctx = new ChannelOrderCreateContext();
        ctx.setBaseRequest(request);
        BaseResponse response = saveOrderRequestHandler.invoke(ctx);
        logger.info("渠道流水落单结束");
        return response;
    }

    @Override
    public PageQueryResponse queryChannelOrder(ChannelOrderQueryRequest request) {
        logger.info("ChannelOrderFacadeImpl.queryChannelOrder begin, request={}", request );
        Page<ChannelOrderDTO> page = PagedUtil.startPage(request.getPageBean());
        ChannelOrder channelOrder = new ChannelOrder();
        BeanUtils.copyProperties(request, channelOrder);
        channelOrderService.selectList(channelOrder);

        PagedResult pagedResult = null;
        try {
            pagedResult = PagedUtil.toPagedResultDTO(page, ChannelOrderDTO.class);
        } catch (Exception e) {
            logger.error("QuerySettlementDetailFacadeImpl.queryChannelOrder page exception：" + e );
        }

        PageQueryResponse pageQueryResponse = new PageQueryResponse();
        pageQueryResponse.setPagedResult(pagedResult);
        ResponseUtils.setToSuccess(pageQueryResponse);
        logger.info("ChannelOrderFacadeImpl.queryChannelOrder end, response={}", pageQueryResponse);
        return pageQueryResponse;
    }

    @Override
    public PageQueryResponse<ChannelCostDto> queryChannelCost(QueryChannelCostRequest request) {
        logger.info("ChannelOrderFacadeImpl.queryChannelCost begin, request={}", request );
        Page<ChannelCostDto> page = PagedUtil.startPage(request.getPageBean());
        ChannelCost channelCost = new ChannelCost();
        BeanUtils.copyProperties(request, channelCost);
        channelOrderService.selectChannelCost(channelCost);

        PagedResult<ChannelCostDto> pagedResult = null;
        try {
            pagedResult = PagedUtil.toPagedResultDTO(page, ChannelCostDto.class);
        } catch (Exception e) {
            logger.error("ChannelOrderFacadeImpl.queryChannelCost page exception：{}", e );
        }

        PageQueryResponse<ChannelCostDto> pageQueryResponse = new PageQueryResponse();
        pageQueryResponse.setPagedResult(pagedResult);
        ResponseUtils.setToSuccess(pageQueryResponse);
        logger.info("ChannelOrderFacadeImpl.queryChannelCost end, response={}", pageQueryResponse);
        return pageQueryResponse;
    }

}
