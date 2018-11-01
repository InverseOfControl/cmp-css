package com.ipaylinks.cmp.css.biz.impl.facade;

import com.github.pagehelper.Page;
import com.ipaylinks.cmp.css.dal.model.MertSettlementOrder;
import com.ipaylinks.cmp.css.facade.QuerySettlementOrderFacade;
import com.ipaylinks.cmp.css.facade.dto.MertSettlementOrderDto;
import com.ipaylinks.cmp.css.facade.request.QuerySettlementRequest;
import com.ipaylinks.cmp.css.service.MertSettlementOrderService;
import com.ipaylinks.cmp.css.util.ResponseUtils;
import com.ipaylinks.common.page.PagedResult;
import com.ipaylinks.common.page.PagedUtil;
import com.ipaylinks.common.rpc.response.PageQueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("querySettlementOrderFacade")
public class QuerySettlementOrderFacadeImpl implements QuerySettlementOrderFacade {

	private Logger logger = LoggerFactory.getLogger(QuerySettlementOrderFacadeImpl.class);

	@Autowired
	private MertSettlementOrderService mertSettlementOrderService;

	/**
	 * 查询商户结算单信息
	 *
	 * @author hongxu.gao
	 * @date 2018/8/7 14:51
	 * @param request 请求参数对象
	 * @return com.ipaylinks.cmp.css.facade.response.QuerySettlementResponse
	 */
	@Override
	public PageQueryResponse<MertSettlementOrderDto> querySettlementOrder(QuerySettlementRequest request) {
		logger.info("QuerySettlementOrderFacadeImpl.querySettlementOrder begin request={}", request);
		Page<MertSettlementOrderDto> page =  PagedUtil.startPage(request.getPageBean());
		MertSettlementOrder mertSettlementOrder = new MertSettlementOrder();
		BeanUtils.copyProperties(request, mertSettlementOrder);
		mertSettlementOrderService.getMertSettlementOrderList(mertSettlementOrder);

		PagedResult<MertSettlementOrderDto> pagedResult = null;
		try {
			pagedResult = PagedUtil.toPagedResultDTO(page, MertSettlementOrderDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("QuerySettlementOrderFacadeImpl.querySettlementOrder page exception：" + e );
		}

		PageQueryResponse<MertSettlementOrderDto> pageQueryResponse = new PageQueryResponse();
		pageQueryResponse.setPagedResult(pagedResult);
		ResponseUtils.setToSuccess(pageQueryResponse);
		logger.info("QuerySettlementOrderFacadeImpl.querySettlementOrder end response={}", pageQueryResponse);
		return pageQueryResponse;
	}

}
