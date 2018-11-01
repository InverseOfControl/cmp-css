package com.ipaylinks.cmp.css.facade;

import com.ipaylinks.cmp.css.facade.dto.MertFeeDto;
import com.ipaylinks.cmp.css.facade.request.QueryMerchantFeeRequest;
import com.ipaylinks.common.rpc.BaseResponse;
import com.ipaylinks.common.rpc.response.PageQueryResponse;

public interface QueryMerchantFeeFacade {

	/**
	 * 查询商户手续费
	 *
	 * @author hongxu.gao
	 * @date 2018/8/14 19:34
	 * @return com.ipaylinks.common.rpc.response.MultiResponse
	 */
	PageQueryResponse<MertFeeDto> queryMerchantFee(QueryMerchantFeeRequest request);

	/**
	 * 收费
	 *
	 * @author hongxu.gao
	 * @date 2018/9/3 16:13
	 * @return com.ipaylinks.common.rpc.BaseResponse
	 */
	BaseResponse charge(QueryMerchantFeeRequest request);

}
