package com.ipaylinks.cmp.css.integration.res;

import java.util.List;

import com.ipaylinks.cmp.css.integration.dto.AccountRuleDto;
import com.ipaylinks.common.rpc.BaseResponse;
public class QueryMermberAccountResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6839620171110281084L;

    private List<AccountRuleDto> listAccountRuloDto;

	public List<AccountRuleDto> getListAccountRuloDto() {
		return listAccountRuloDto;
	}

	public void setListAccountRuloDto(List<AccountRuleDto> listAccountRuloDto) {
		this.listAccountRuloDto = listAccountRuloDto;
	}
    
    
	
	
	 
}
