package com.ipaylinks.cmp.css.service.impl;

import com.ipaylinks.cmp.css.service.FileUploadFtpService;
import com.ipaylinks.cmp.css.util.BusinessException;
import com.ipaylinks.verify.facade.code.RespCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("fileUploadFtpService")
public class FileUploadFtpServiceImpl implements FileUploadFtpService {

private Logger logger = LoggerFactory.getLogger(FileUploadFtpServiceImpl.class);

	@Value("${uploadPartnerReconcile.remote_path}")
	private String remote_path;
	@Value("${uploadPartnerReconcile.ftp_host}")
	private String ftp_host;
	@Value("${uploadPartnerReconcile.username}")
	private String username;

	@Override
	public void uploadToFtp(String merchantId, String reconcileDate, String localFullFileName) throws BusinessException{
		try {
			reconcileDate = reconcileDate.replace("-", "");
			//上传文件到ftp
			String SPACE = " ";
			String full_remote_path = remote_path + "/" + merchantId +"/" + reconcileDate.substring(0, 4) + "/" + reconcileDate.substring(4, 6) + "/";
			String mkdirCmd = "ssh" + SPACE + username + "@" + ftp_host + SPACE + "[ -d" + SPACE + full_remote_path + " ] && echo ok || mkdir -p " + full_remote_path;
			String copyCmd = "scp" + SPACE + localFullFileName + SPACE + username + "@" + ftp_host + ":" + full_remote_path;
			logger.info("mkdirCmd=" + mkdirCmd);
			logger.info("copyCmd=" + copyCmd);
			Process process =Runtime.getRuntime().exec(mkdirCmd);
			int exitVal = process.waitFor();

			if(exitVal != 0) {
				logger.info("上传对账单文件到FTP失败");
				throw new BusinessException(RespCodeEnum.SYSTEM_ERROR.getCode(), "上传对账单文件到FTP失败");
			}

			process =Runtime.getRuntime().exec(copyCmd);
			exitVal = process.waitFor();

			if(exitVal != 0) {
				logger.info("上传对账单文件到FTP失败");
				throw new BusinessException(RespCodeEnum.SYSTEM_ERROR.getCode(), "上传对账单文件到FTP失败");
			}
			logger.info("上传对账单文件到FTP成功");
		}catch (BusinessException e){
			throw e;
		}catch (Exception e){
			logger.error("上传对账单文件到FTP失败", e);
			throw new BusinessException(RespCodeEnum.SYSTEM_ERROR.getCode(), "上传对账单文件到FTP失败");
		}
	}

}
