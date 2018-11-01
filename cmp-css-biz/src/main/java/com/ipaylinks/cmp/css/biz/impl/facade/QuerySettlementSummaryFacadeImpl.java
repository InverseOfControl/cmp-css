package com.ipaylinks.cmp.css.biz.impl.facade;

import com.github.pagehelper.Page;
import com.ipaylinks.cmp.css.biz.impl.common.RequestValidator;
import com.ipaylinks.cmp.css.dal.model.MertSettlementSummary;
import com.ipaylinks.cmp.css.facade.QuerySettlementSummaryFacade;
import com.ipaylinks.cmp.css.facade.dto.MertSettlementSummaryDto;
import com.ipaylinks.cmp.css.facade.request.QuerySettlementSummaryRequest;
import com.ipaylinks.cmp.css.service.MertSettlementSummaryService;
import com.ipaylinks.cmp.css.util.ResponseUtils;
import com.ipaylinks.common.page.PagedResult;
import com.ipaylinks.common.page.PagedUtil;
import com.ipaylinks.common.rpc.response.PageQueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("querySettlementSummaryFacade")
public class QuerySettlementSummaryFacadeImpl implements QuerySettlementSummaryFacade {
	
	private Logger logger = LoggerFactory.getLogger(QuerySettlementSummaryFacadeImpl.class);

	@Autowired
	private MertSettlementSummaryService mertSettlementSummaryService;

	@Autowired
	private RequestValidator requestValidator;

	/**
	 * 查询结算汇总单信息
	 *
	 * @author hongxu.gao
	 * @date 2018/8/7 15:46
	 * @param request 请求参数对象
	 * @return com.ipaylinks.cmp.css.facade.response.QuerySettlementSummaryResponse
	 */
	@Override
	public PageQueryResponse<MertSettlementSummaryDto> querySettlementSummary(QuerySettlementSummaryRequest request) {
		logger.info("QuerySettlementSummaryFacadeImpl.querySettlementSummary begin request={}", request);
		Page<MertSettlementSummaryDto> page =  PagedUtil.startPage(request.getPageBean());
		MertSettlementSummary mertSettlementSummary = new MertSettlementSummary();
		BeanUtils.copyProperties(request, mertSettlementSummary);
		mertSettlementSummaryService.getMertSettlementSummaryList(mertSettlementSummary);

		PagedResult<MertSettlementSummaryDto> pagedResult = null;
		try {
			pagedResult = PagedUtil.toPagedResultDTO(page, MertSettlementSummaryDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("QuerySettlementDetailFacadeImpl.querySettlementSummary page exception：" + e );
		}

		PageQueryResponse<MertSettlementSummaryDto> pageQueryResponse = new PageQueryResponse();
		pageQueryResponse.setPagedResult(pagedResult);
		ResponseUtils.setToSuccess(pageQueryResponse);
		logger.info("QuerySettlementSummaryFacadeImpl.querySettlementSummary end response={}", pageQueryResponse);
		return pageQueryResponse;
	}

}
