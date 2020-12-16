package com.hzhx.greenFinance.service;

import org.springframework.stereotype.Service;

import com.hzhx.greenFinance.vo.ResultVo;


@Service
public interface SendRHService {

	/**
	 * 报文上送数据
	 * @param msgType 
	 * @return
	 */
	public ResultVo reportDataAllRH(String msgType);

	/**
	 * 报送回执查询接口
	 * @param reportDate
	 * @return
	 */
	public ResultVo receipt(String reportDate);

	/**
	 * 业务核查驳回接口
	 * @return
	 */
	public ResultVo inspection();

	/**
	 * 绿色信贷特色监测模块 贷款信息上报
	 * @return
	 */
	public ResultVo reportMCIF(String msgType);

	/**
	 * 绿色信贷特色监测模块 贷款信息上报回执查询
	 * @param reportDate
	 * @param reportPackageName
	 * @return
	 */
	public ResultVo reportMCIF(String reportDate, String reportPackageName);

}
