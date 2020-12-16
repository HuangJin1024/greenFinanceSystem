package com.hzhx.greenFinance.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hzhx.greenFinance.Util.HttpParamUtil;
import com.hzhx.greenFinance.dao.GreenfinSendLogMapper;
import com.hzhx.greenFinance.entity.GreenfinSendLog;
import com.hzhx.greenFinance.service.SendService;
import com.hzhx.greenFinance.vo.ResultVo;

import net.sf.json.JSONObject;

@Service
public class SendServiceImpl implements SendService {
	private Logger logger = LoggerFactory.getLogger(SendServiceImpl.class);
	@Autowired
	private HttpParamUtil httpParamUtil;
	@Resource
	private RestTemplate restTemplate;
	
	private ResultVo resultVo = new ResultVo();
	@Autowired
	private GreenfinSendLogMapper greenfinSendLogMapper;
	// 业务数据报送
	@Override
	public ResultVo reportData(String msgType, String msgBusinessType) {

		HashMap<String, String> httpParamMap = (HashMap<String, String>) httpParamUtil.reportDataParam(msgType,
				msgBusinessType);

		// 1-设置请求头
		HttpHeaders headers = new HttpHeaders();
		/*
		 * MediaType type = MediaType.parseMediaType("multipart/form-data");
		 * headers.setContentType(type);
		 */
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		// 报送机构
		headers.add("reportBank", httpParamMap.get("reportBank"));
		// 请求编号
		headers.add("requestId", httpParamMap.get("requestId"));
		// 时间戳
		headers.add("timestamp", httpParamMap.get("timestamp"));
		// 签名
		headers.add("signature", httpParamMap.get("signature"));
		// 版本号
		headers.add("version", httpParamMap.get("version"));

		/*
		 * // 2-设置请求体，注意是LinkedMultiValueMap MultiValueMap<String, Object>
		 * paramMap = new LinkedMultiValueMap<>();
		 */
		// 2-设置请求体
		Map<String, Object> map = new HashMap<String, Object>();
		// 文件名
		map.put("fileName", httpParamMap.get("fileName"));
		// 报送文件串
		map.put("fileBase64", httpParamMap.get("fileBase64"));
		// 文件密钥串
		map.put("fileSecretKey", httpParamMap.get("fileSecretKey"));

		/*上传文件时需要
		 * FileSystemResource fileSystemResource = new
		 * FileSystemResource("file"); paramMap.add("file", fileSystemResource);
		 */

		// 3-发送请求
		/*HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(paramMap,
				headers);*/
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(map, headers);

		String response = restTemplate.postForObject(httpParamMap.get("url"), httpEntity, String.class);
		logger.info("接口返回信息：" + response);
		JSONObject jsonResult = JSONObject.fromObject(response);
		resultVo.setCode(jsonResult.getString("code"));
		resultVo.setMessage(jsonResult.getString("message"));
		return resultVo;
	}

	@Override
	public ResultVo receipt(String reportPackageName) {
		HashMap<String, String> httpParamMap = (HashMap<String, String>) httpParamUtil.receiptParam(reportPackageName);

		// 1-设置请求头
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		// 报送机构
		headers.set("reportBank", httpParamMap.get("reportBank"));
		// 请求编号
		headers.set("requestId", httpParamMap.get("requestId"));
		// 时间戳
		headers.set("timestamp", httpParamMap.get("timestamp"));
		// 签名
		headers.set("signature", httpParamMap.get("signature"));
		// 版本号
		headers.set("version", httpParamMap.get("version"));

		// 2-设置请求体
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reportPackageName", reportPackageName);

		// 3-发送请求
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(map, headers);
		String response = restTemplate.postForObject(httpParamMap.get("url"), httpEntity, String.class);
		logger.info("接口返回信息：" + response);
		JSONObject jsonResult = JSONObject.fromObject(response);
		resultVo.setCode(jsonResult.getString("code"));
		resultVo.setMessage(jsonResult.getString("message"));
		return resultVo;
	}

	@Override
	public ResultVo inspection() {
		HashMap<String, String> httpParamMap = (HashMap<String, String>) httpParamUtil.inspectionParam();

		// 1-设置请求头
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		// 报送机构
		headers.set("reportBank", httpParamMap.get("reportBank"));
		// 请求编号
		headers.set("requestId", httpParamMap.get("requestId"));
		// 时间戳
		headers.set("timestamp", httpParamMap.get("timestamp"));
		// 签名
		headers.set("signature", httpParamMap.get("signature"));
		// 版本号
		headers.set("version", httpParamMap.get("version"));

		// 2-设置请求体
		Map<String, Object> map = new HashMap<String, Object>();

		// 3-发送请求
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(map, headers);
		String response = restTemplate.postForObject(httpParamMap.get("url"), httpEntity, String.class);
		logger.info("接口返回信息：" + response);
		JSONObject jsonResult = JSONObject.fromObject(response);
		resultVo.setCode(jsonResult.getString("code"));
		resultVo.setMessage(jsonResult.getString("message"));
		return resultVo;
	}

	@Override
	public ResultVo inspectionFeedback() {
		List list = new ArrayList<>();
		HashMap<String, String> httpParamMap = (HashMap<String, String>) httpParamUtil.inspectionFeedbackParam(list);

		// 1-设置请求头
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		// 报送机构
		headers.set("reportBank", httpParamMap.get("reportBank"));
		// 请求编号
		headers.set("requestId", httpParamMap.get("requestId"));
		// 时间戳
		headers.set("timestamp", httpParamMap.get("timestamp"));
		// 签名
		headers.set("signature", httpParamMap.get("signature"));
		// 版本号
		headers.set("version", httpParamMap.get("version"));

		// 2-设置请求体
		Map<String, Object> map = new HashMap<String, Object>();
		// map.put("reportPackageName", reportPackageName);

		// 3-发送请求
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(map, headers);
		String response = restTemplate.postForObject(httpParamMap.get("url"), httpEntity, String.class);
		logger.info("接口返回信息：" + response);
		JSONObject jsonResult = JSONObject.fromObject(response);
		resultVo.setCode(jsonResult.getString("code"));
		resultVo.setMessage(jsonResult.getString("message"));
		return resultVo;
	}

	@Override
	public ResultVo getFormTaskList() {
		HashMap<String, String> httpParamMap = (HashMap<String, String>) httpParamUtil.getFormTaskListParam();

		// 1-设置请求头
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		// 报送机构
		headers.set("reportBank", httpParamMap.get("reportBank"));
		// 请求编号
		headers.set("requestId", httpParamMap.get("requestId"));
		// 时间戳
		headers.set("timestamp", httpParamMap.get("timestamp"));
		// 签名
		headers.set("signature", httpParamMap.get("signature"));
		// 版本号
		headers.set("version", httpParamMap.get("version"));

		// 2-设置请求体
		Map<String, Object> map = new HashMap<String, Object>();

		// 3-发送请求
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(map, headers);
		String response = restTemplate.postForObject(httpParamMap.get("url"), httpEntity, String.class);
		logger.info("接口返回信息：" + response);
		JSONObject jsonResult = JSONObject.fromObject(response);
		resultVo.setCode(jsonResult.getString("code"));
		resultVo.setMessage(jsonResult.getString("message"));
		return resultVo;
	}

	// 报表数据报送
	@Override
	public ResultVo reportForm(String formPeriod) {
		HashMap<String, String> httpParamMap = (HashMap<String, String>) httpParamUtil.reportFormParam(formPeriod);

		// 1-设置请求头
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		// 报送机构
		headers.set("reportBank", httpParamMap.get("reportBank"));
		// 请求编号
		headers.set("requestId", httpParamMap.get("requestId"));
		// 时间戳
		headers.set("timestamp", httpParamMap.get("timestamp"));
		// 签名
		headers.set("signature", httpParamMap.get("signature"));
		// 版本号
		headers.set("version", httpParamMap.get("version"));

		// 2-设置请求体
		Map<String, Object> map = new HashMap<String, Object>();
		// 文件名
		map.put("fileName", httpParamMap.get("fileName"));
		// 报送文件串
		map.put("fileBase64", httpParamMap.get("fileBase64"));
		// 文件密钥串
		map.put("fileSecretKey", httpParamMap.get("fileSecretKey"));

		// 3-发送请求
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(map, headers);
		String response = restTemplate.postForObject(httpParamMap.get("url"), httpEntity, String.class);
		logger.info("接口返回信息：" + response);
		JSONObject jsonResult = JSONObject.fromObject(response);
		resultVo.setCode(jsonResult.getString("code"));
		resultVo.setMessage(jsonResult.getString("message"));
		return resultVo;
	}

	@Override
	public ResultVo receiptForm(String reportPackageName) {

		HashMap<String, String> httpParamMap = (HashMap<String, String>) httpParamUtil
				.receiptFormParam(reportPackageName);

		// 1-设置请求头
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		// 报送机构
		headers.set("reportBank", httpParamMap.get("reportBank"));
		// 请求编号
		headers.set("requestId", httpParamMap.get("requestId"));
		// 时间戳
		headers.set("timestamp", httpParamMap.get("timestamp"));
		// 签名
		headers.set("signature", httpParamMap.get("signature"));
		// 版本号
		headers.set("version", httpParamMap.get("version"));

		// 2-设置请求体
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 3-发送请求
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(map, headers);
		String response = restTemplate.postForObject(httpParamMap.get("url"), httpEntity, String.class);
		logger.info("接口返回信息：" + response);
		JSONObject jsonResult = JSONObject.fromObject(response);
		resultVo.setCode(jsonResult.getString("code"));
		resultVo.setMessage(jsonResult.getString("message"));
		return resultVo;

	}

	@Override
	public ResultVo queryAuditResult(String formPeriod) {

		HashMap<String, String> httpParamMap = (HashMap<String, String>) httpParamUtil
				.queryAuditResultParam(formPeriod);

		// 1-设置请求头
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		// 报送机构
		headers.set("reportBank", httpParamMap.get("reportBank"));
		// 请求编号
		headers.set("requestId", httpParamMap.get("requestId"));
		// 时间戳
		headers.set("timestamp", httpParamMap.get("timestamp"));
		// 签名
		headers.set("signature", httpParamMap.get("signature"));
		// 版本号
		headers.set("version", httpParamMap.get("version"));

		// 2-设置请求体
		Map<String, Object> map = new HashMap<String, Object>();
		// map.put("reportPackageName", reportPackageName);

		// 3-发送请求
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(map, headers);
		String response = restTemplate.postForObject(httpParamMap.get("url"), httpEntity, String.class);
		logger.info("接口返回信息：" + response);
		JSONObject jsonResult = JSONObject.fromObject(response);
		resultVo.setCode(jsonResult.getString("code"));
		resultVo.setMessage(jsonResult.getString("message"));
		return resultVo;

	}

	@Override
	public ResultVo reportDataAll(String msgType) {

		HashMap<String, String> httpParamMap = (HashMap<String, String>) httpParamUtil.reportAllDataParam(msgType);

		// 1-设置请求头
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		// 报送机构
		headers.add("reportBank", httpParamMap.get("reportBank"));
		// 请求编号
		headers.add("requestId", httpParamMap.get("requestId"));
		// 时间戳
		headers.add("timestamp", httpParamMap.get("timestamp"));
		// 签名
		headers.add("signature", httpParamMap.get("signature"));
		// 版本号
		headers.add("version", httpParamMap.get("version"));

		// 2-设置请求体
		Map<String, Object> map = new HashMap<String, Object>();
		// 文件名
		map.put("fileName", httpParamMap.get("fileName"));
		// 报送文件串
		map.put("fileBase64", httpParamMap.get("fileBase64"));
		// 文件密钥串
		map.put("fileSecretKey", httpParamMap.get("fileSecretKey"));

		// 3-发送请求
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(map, headers);

		GreenfinSendLog greenfinSendLog = new GreenfinSendLog(httpParamMap.get("requestId"));
		greenfinSendLog.setRequestDate(DateFormatUtils.format(new Date(), "yyyyMMdd"));
		greenfinSendLog.setRequestUrl(httpParamMap.get("url"));
		greenfinSendLog.setReportBank(httpParamMap.get("reportBank"));
		greenfinSendLog.setTimestamp(httpParamMap.get("timestamp"));
		greenfinSendLog.setFileName(httpParamMap.get("fileName"));
		try {
			//String response = restTemplate.postForObject(httpParamMap.get("url"), httpEntity, String.class);
			String response = "123";
			logger.info("接口返回信息：" + response);
			JSONObject jsonResult = JSONObject.fromObject(response);
			//保存接口调用记录和结果到数据库
			greenfinSendLog.setResultCode(jsonResult.getString("code"));
			greenfinSendLog.setResultMessage(jsonResult.getString("message"));
			resultVo.setCode(jsonResult.getString("code"));
			resultVo.setMessage(jsonResult.getString("message"));
		} catch (Exception e) {
			logger.info("接口异常："+e.getMessage());
			greenfinSendLog.setResultCode("999");
			greenfinSendLog.setResultMessage("接口异常");
			resultVo.setCode("999");
			resultVo.setMessage("接口异常");
		}
		
		greenfinSendLogMapper.insert(greenfinSendLog);
		return resultVo;
	}

	@Override
	public ResultVo reportDataDaily(String msgType, String dataDate) {

		HashMap<String, String> httpParamMap = (HashMap<String, String>) httpParamUtil.reportDataDailyParam(msgType,dataDate);

		// 1-设置请求头
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		// 报送机构
		headers.add("reportBank", httpParamMap.get("reportBank"));
		// 请求编号
		headers.add("requestId", httpParamMap.get("requestId"));
		// 时间戳
		headers.add("timestamp", httpParamMap.get("timestamp"));
		// 签名
		headers.add("signature", httpParamMap.get("signature"));
		// 版本号
		headers.add("version", httpParamMap.get("version"));

		// 2-设置请求体
		Map<String, Object> map = new HashMap<String, Object>();
		// 文件名
		map.put("fileName", httpParamMap.get("fileName"));
		// 报送文件串
		map.put("fileBase64", httpParamMap.get("fileBase64"));
		// 文件密钥串
		map.put("fileSecretKey", httpParamMap.get("fileSecretKey"));

		// 3-发送请求
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(map, headers);

		GreenfinSendLog greenfinSendLog = new GreenfinSendLog(httpParamMap.get("requestId"));
		greenfinSendLog.setRequestDate(DateFormatUtils.format(new Date(), "yyyyMMdd"));
		greenfinSendLog.setRequestUrl(httpParamMap.get("url"));
		greenfinSendLog.setReportBank(httpParamMap.get("reportBank"));
		greenfinSendLog.setTimestamp(httpParamMap.get("timestamp"));
		greenfinSendLog.setFileName(httpParamMap.get("fileName"));
		try {
			//String response = restTemplate.postForObject(httpParamMap.get("url"), httpEntity, String.class);
			String response = "123";
			logger.info("接口返回信息：" + response);
			JSONObject jsonResult = JSONObject.fromObject(response);
			//保存接口调用记录和结果到数据库
			greenfinSendLog.setResultCode(jsonResult.getString("code"));
			greenfinSendLog.setResultMessage(jsonResult.getString("message"));
			resultVo.setCode(jsonResult.getString("code"));
			resultVo.setMessage(jsonResult.getString("message"));
		} catch (Exception e) {
			logger.info("接口异常："+e.getMessage());
			greenfinSendLog.setResultCode("999");
			greenfinSendLog.setResultMessage("接口异常");
			resultVo.setCode("999");
			resultVo.setMessage("接口异常");
		}
		
		greenfinSendLogMapper.insert(greenfinSendLog);
		return resultVo;
	}

}
