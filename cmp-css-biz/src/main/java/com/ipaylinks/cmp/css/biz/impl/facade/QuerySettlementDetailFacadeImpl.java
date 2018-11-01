package com.ipaylinks.cmp.css.biz.impl.facade;

import com.github.pagehelper.Page;
import com.ipaylinks.cmp.css.biz.impl.common.RequestValidator;
import com.ipaylinks.cmp.css.dal.model.MertSettlementDetail;
import com.ipaylinks.cmp.css.facade.QuerySettlementDetailFacade;
import com.ipaylinks.cmp.css.facade.dto.MertSettlementDetailDto;
import com.ipaylinks.cmp.css.facade.request.QuerySettlementDetailRequest;
import com.ipaylinks.cmp.css.service.MertSettlementDetailService;
import com.ipaylinks.cmp.css.util.ResponseUtils;
import com.ipaylinks.common.page.PagedResult;
import com.ipaylinks.common.page.PagedUtil;
import com.ipaylinks.common.rpc.response.PageQueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("querySettlementDetailFacade")
public class QuerySettlementDetailFacadeImpl implements QuerySettlementDetailFacade {

	private Logger logger = LoggerFactory.getLogger(QuerySettlementDetailFacadeImpl.class);

	@Autowired
	private RequestValidator requestValidator;

	@Autowired
	private MertSettlementDetailService mertSettlementDetailService;

	/**
	 * 查询商户结算明细
	 *   
	 * @author hongxu.gao
	 * @date 2018/8/7 14:08     
	 * @param request 请求对象
	 * @return com.ipaylinks.common.rpc.BaseResponse        
	 */
	@Override
	public PageQueryResponse<MertSettlementDetailDto> querySettlementDetail(QuerySettlementDetailRequest request) {
		logger.info("QuerySettlementDetailFacadeImpl.querySettlementDetail begin request={}", request);
		Page<MertSettlementDetailDto> page =  PagedUtil.startPage(request.getPageBean());
		MertSettlementDetail mertSettlementDetail = new MertSettlementDetail();
		BeanUtils.copyProperties(request, mertSettlementDetail);
		mertSettlementDetailService.selectList(mertSettlementDetail);

		PagedResult<MertSettlementDetailDto> pagedResult = null;
		try {
			pagedResult = PagedUtil.toPagedResultDTO(page, MertSettlementDetailDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("QuerySettlementDetailFacadeImpl.querySettlementDetail page exception：" + e );
		}

		PageQueryResponse<MertSettlementDetailDto> pageQueryResponse = new PageQueryResponse();
		pageQueryResponse.setPagedResult(pagedResult);
		ResponseUtils.setToSuccess(pageQueryResponse);
		logger.info("QuerySettlementDetailFacadeImpl.querySettlementDetail end response={}", pageQueryResponse);
		return pageQueryResponse;
	}

}
