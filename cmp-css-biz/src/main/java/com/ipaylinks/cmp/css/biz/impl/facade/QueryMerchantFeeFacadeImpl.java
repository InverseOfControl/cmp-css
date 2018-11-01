package com.ipaylinks.cmp.css.biz.impl.facade;

import com.github.pagehelper.Page;
import com.ipaylinks.cmp.css.dal.model.MertFee;
import com.ipaylinks.cmp.css.facade.QueryMerchantFeeFacade;
import com.ipaylinks.cmp.css.facade.dto.MertFeeDto;
import com.ipaylinks.cmp.css.facade.enums.SettleEnum;
import com.ipaylinks.cmp.css.facade.request.QueryMerchantFeeRequest;
import com.ipaylinks.cmp.css.service.MertClearingDetailService;
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

@Service("queryMerchantFeeFacade")
public class QueryMerchantFeeFacadeImpl implements QueryMerchantFeeFacade {

	private Logger logger = LoggerFactory.getLogger(QueryMerchantFeeFacadeImpl.class);

	@Autowired
	private MertClearingDetailService mertClearingDetailService;

	@Override
	public PageQueryResponse<MertFeeDto> queryMerchantFee(QueryMerchantFeeRequest request) {
		logger.info("QueryMerchantFeeFacadeImpl.queryMerchantFee begin request={}", request);
		PageQueryResponse<MertFeeDto> pageQueryResponse = new PageQueryResponse();
		Page<MertFeeDto> page =  PagedUtil.startPage(request.getPageBean());
		MertFee mertFee = new MertFee();
		BeanUtils.copyProperties(request, mertFee);
		mertClearingDetailService.selectMertFee(mertFee);

		PagedResult<MertFeeDto> pagedResult = null;
		try {
			pagedResult = PagedUtil.toPagedResultDTO(page, MertFeeDto.class);
		} catch (Exception e) {
			logger.error("QuerySettlementDetailFacadeImpl.queryMerchantFee page exception：{}", e );
			ResponseUtils.setToFail(pageQueryResponse, BaseExceptionCode.TRANSFORM_ERROR);
			return pageQueryResponse;
		}

		pageQueryResponse.setPagedResult(pagedResult);
		ResponseUtils.setToSuccess(pageQueryResponse);
		logger.info("QueryMerchantFeeFacadeImpl.queryMerchantFee end response={}", pageQueryResponse);
		return pageQueryResponse;
	}

    @Override
    public BaseResponse charge(QueryMerchantFeeRequest request) {
        logger.info("QueryMerchantFeeFacadeImpl.charge begin request={}", request);
        BaseResponse response = new BaseResponse();
        MertFee mertFee = new MertFee();
        mertFee.setId(request.getId());
        mertFee.setSettleStatus(SettleEnum.SETTLED.getCode());

        int n = mertClearingDetailService.charge(mertFee);
        if(n > 0){
			ResponseUtils.setToSuccess(response);
		}else{
			ResponseUtils.setToFail(response,BaseExceptionCode.DATA_ACCESS_EXCEPTION.getCode(),"收费失败");
			logger.error("QuerySettlementDetailFacadeImpl.charge exception：{}", "收费失败");
		}
        logger.info("QueryMerchantFeeFacadeImpl.charge end response={}", response);
        return response;
    }

}
