package com.hzhx.greenFinance.service;

import org.springframework.stereotype.Service;

@Service
public interface QueryRHInfoService {
	/**
	 * 查询信息组成xml文件
	 * @param msgBusinessType
	 * @param zipFileName
	 */
	//public void queryInfoToXml(String msgBusinessType, String zipFileName);

	public void queryAllInfoToXml(String zipFileName);

	public void queryDeleteInfoToXml(String fileName);

	//public void queryDailyInfoToXml(String fileName, String dataDate);
	
	
}
