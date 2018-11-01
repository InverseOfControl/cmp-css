/*
 * *
 *  * 启赟金融信息服务（上海）有限公司
 *  * Copyright (c) 2015-2017 iPayLinks.All Rights Reserved.
 *
 */

package com.ipaylinks.cmp.css.util;

/*
 *  异常包装
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = -1L;

	private String responseCode;

	private String responseMsg;

	public BusinessException(String responseCode, String responseMsg) {
		super(responseMsg);
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}
}

