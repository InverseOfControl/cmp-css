package com.ipaylinks.cmp.css.service;

public interface FileUploadFtpService {

	/**
	* 上传商户对账单到ftp
	* @param merchantId			商户ID
	* @param reconcileDate		对账单日期 yyyy-MM-dd 或者  yyyyMMdd
	* @param localFullFileName	本地文件全路径
	* @throws Exception
	*/
	void uploadToFtp(String merchantId, String reconcileDate, String localFullFileName) throws Exception;
    
}
