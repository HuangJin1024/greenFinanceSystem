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

}
