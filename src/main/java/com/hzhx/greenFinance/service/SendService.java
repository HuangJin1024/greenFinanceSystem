package com.hzhx.greenFinance.service;

import org.springframework.stereotype.Service;

import com.hzhx.greenFinance.vo.ResultVo;


@Service
public interface SendService {
	/**
	 * 6.3业务数据报送接口
	 * @param messageType	报文类型
	 * @param msgBusinessType 	报文业务类型
	 * @return
	 */
	public ResultVo reportData(String msgType, String msgBusinessType);
	
	/**
	 * 6.4报送回执查询接口
	 * @param reportPackageName 数据包名
	 * @return
	 */
	public ResultVo receipt(String reportPackageName);
	
	/**
	 * 6.5驳回业务查询接口
	 * @return
	 */
	public ResultVo inspection();
	
	/**
	 * 6.6驳回信息接收确认接口
	 * @param businessType	驳回类型
	 * @param businessNo	业务编号
	 * @return
	 */
	public ResultVo inspectionFeedback();
	
	/**
	 * 6.7报表报送任务查询接口
	 * @return
	 */
	public ResultVo getFormTaskList();
	
	/**
	 * 6.8报表数据报送接口
	 * @return
	 */
	public ResultVo reportForm(String formPeriod);
	
	/**
	 * 6.9报表报送回执查询接口
	 * @param reportPackageName	报送数据包名
	 * @return
	 */
	public ResultVo receiptForm(String reportPackageName);
	
	/**
	 * 6.10报表审核结果查询接口
	 * @param formPeriod 报表期数
	 * @return
	 */
	public ResultVo queryAuditResult(String formPeriod);

	/**
	 * 报送全量数据
	 * @param msgType 
	 * @return
	 */
	public ResultVo reportDataAll(String msgType);

	/**
	 * 报送每日增量数据
	 * @param msgType
	 * @param dataDate 
	 * @return
	 */
	public ResultVo reportDataDaily(String msgType, String dataDate);

}
