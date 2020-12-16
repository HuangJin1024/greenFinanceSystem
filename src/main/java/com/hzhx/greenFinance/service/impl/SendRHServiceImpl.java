package com.hzhx.greenFinance.service.impl;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.hzhx.greenFinance.Util.HttpParamUtil;
import com.hzhx.greenFinance.dao.GreenfinSendLogMapper;
import com.hzhx.greenFinance.entity.GreenfinSendLog;
import com.hzhx.greenFinance.service.SendRHService;
import com.hzhx.greenFinance.vo.ResultVo;

import net.sf.json.JSONObject;

@Service
public class SendRHServiceImpl implements SendRHService {
	private Logger logger = LoggerFactory.getLogger(SendRHServiceImpl.class);
	
	@Value("${httpOpen}")
	private String httpOpen;
	
	@Autowired
	private HttpParamUtil httpParamUtil;
	@Resource
	private RestTemplate restTemplate;

	private ResultVo resultVo = new ResultVo();
	@Autowired
	private GreenfinSendLogMapper greenfinSendLogMapper;

	private String response = "";
	
	@Override
	public ResultVo reportDataAllRH(String msgType) {

		HashMap<String, String> httpParamMap = (HashMap<String, String>) httpParamUtil.reportAllDataParamRH(msgType);

		// 1-设置请求头
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("multipart/form-data");
		headers.setContentType(type);

		// 报送机构
		headers.add("bank", httpParamMap.get("reportBank"));
		// 请求编号
		headers.add("requestId", httpParamMap.get("requestId"));
		// 时间戳
		headers.add("timestamp", httpParamMap.get("timestamp"));
		// 签名
		headers.add("signature", httpParamMap.get("signature"));
		// 版本号
		headers.add("version", httpParamMap.get("version"));

		// 2-设置请求体
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		String fileName  = httpParamMap.get("fileName");
		// 上传文件时需要
		FileSystemResource fileSystemResource = new FileSystemResource(new File(httpParamMap.get("fileRealPath")));
		map.add("file", fileSystemResource);
		// reqData
		map.add("reqData", httpParamMap.get("reqData"));

		// 3-发送请求
		HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(map,
				headers);

		GreenfinSendLog greenfinSendLog = new GreenfinSendLog(httpParamMap.get("requestId"));
		greenfinSendLog.setRequestDate(DateFormatUtils.format(new Date(), "yyyyMMdd"));
		greenfinSendLog.setRequestUrl(httpParamMap.get("url"));
		greenfinSendLog.setReportBank(httpParamMap.get("reportBank"));
		greenfinSendLog.setTimestamp(httpParamMap.get("timestamp"));
		greenfinSendLog.setFileName(httpParamMap.get("fileName"));
		try {
			if("true".equals(httpOpen)){
				response = restTemplate.postForObject(httpParamMap.get("url"), httpEntity, String.class);
			}
			logger.info("接口返回信息：" + response);
			JSONObject jsonResult = JSONObject.fromObject(response);
			// 保存接口调用记录和结果到数据库
			greenfinSendLog.setResultCode(jsonResult.getString("code"));
			greenfinSendLog.setResultMessage(jsonResult.getString("message"));
			greenfinSendLog.setFileNameIndex(fileName.substring(0, 1));
			greenfinSendLog.setRequestType(fileName.substring(26, 29));
			resultVo.setCode(jsonResult.getString("code"));
			resultVo.setMessage(jsonResult.getString("message"));
		} catch (Exception e) {
			logger.info("接口异常：" + e.getMessage());
			greenfinSendLog.setResultCode("999");
			greenfinSendLog.setResultMessage("接口异常");
			resultVo.setCode("999");
			resultVo.setMessage("接口异常");
		}

		greenfinSendLogMapper.insert(greenfinSendLog);
		return resultVo;
	}

	@Override
	public ResultVo receipt(String reportDate) {

		HashMap<String, String> httpParamMap = (HashMap<String, String>) httpParamUtil.receiptParamRH(reportDate);

		// 1-设置请求头
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		// 报送机构
		headers.add("bank", httpParamMap.get("reportBank"));
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
		// 报送日期
		map.put("reportDate", reportDate);

		// 3-发送请求
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(map, headers);

		GreenfinSendLog greenfinSendLog = new GreenfinSendLog(httpParamMap.get("requestId"));
		greenfinSendLog.setRequestDate(DateFormatUtils.format(new Date(), "yyyyMMdd"));
		greenfinSendLog.setRequestUrl(httpParamMap.get("url"));
		greenfinSendLog.setReportBank(httpParamMap.get("reportBank"));
		greenfinSendLog.setTimestamp(httpParamMap.get("timestamp"));
		greenfinSendLog.setFileName(httpParamMap.get("fileName"));
		try {
			if("true".equals(httpOpen)){
				response = restTemplate.postForObject(httpParamMap.get("url"), httpEntity, String.class);
			}
			logger.info("接口返回信息：" + response);
			JSONObject jsonResult = JSONObject.fromObject(response);
			// 保存接口调用记录和结果到数据库
			greenfinSendLog.setResultCode(jsonResult.getString("code"));
			greenfinSendLog.setResultMessage(jsonResult.getString("message"));
			resultVo.setCode(jsonResult.getString("code"));
			resultVo.setMessage(jsonResult.getString("message"));
		} catch (Exception e) {
			logger.info("接口异常：" + e.getMessage());
			greenfinSendLog.setResultCode("999");
			greenfinSendLog.setResultMessage("接口异常");
			resultVo.setCode("999");
			resultVo.setMessage("接口异常");
		}

		greenfinSendLogMapper.insert(greenfinSendLog);
		return resultVo;
	}

	@Override
	public ResultVo inspection() {

		HashMap<String, String> httpParamMap = (HashMap<String, String>) httpParamUtil.inspectionParamRH();

		// 1-设置请求头
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		// 报送机构
		headers.add("bank", httpParamMap.get("reportBank"));
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
		// 报送日期
		map.put("reportDate", httpParamMap.get("reportDate"));

		// 3-发送请求
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(map, headers);

		GreenfinSendLog greenfinSendLog = new GreenfinSendLog(httpParamMap.get("requestId"));
		greenfinSendLog.setRequestDate(DateFormatUtils.format(new Date(), "yyyyMMdd"));
		greenfinSendLog.setRequestUrl(httpParamMap.get("url"));
		greenfinSendLog.setReportBank(httpParamMap.get("reportBank"));
		greenfinSendLog.setTimestamp(httpParamMap.get("timestamp"));
		greenfinSendLog.setFileName(httpParamMap.get("fileName"));
		try {
			if("true".equals(httpOpen)){
				response = restTemplate.postForObject(httpParamMap.get("url"), httpEntity, String.class);
			}
			logger.info("接口返回信息：" + response);
			JSONObject jsonResult = JSONObject.fromObject(response);
			// 保存接口调用记录和结果到数据库
			greenfinSendLog.setResultCode(jsonResult.getString("code"));
			greenfinSendLog.setResultMessage(jsonResult.getString("message"));
			resultVo.setCode(jsonResult.getString("code"));
			resultVo.setMessage(jsonResult.getString("message"));
		} catch (Exception e) {
			logger.info("接口异常：" + e.getMessage());
			greenfinSendLog.setResultCode("999");
			greenfinSendLog.setResultMessage("接口异常");
			resultVo.setCode("999");
			resultVo.setMessage("接口异常");
		}

		greenfinSendLogMapper.insert(greenfinSendLog);
		return resultVo;
	}

	@Override
	public ResultVo reportMCIF(String msgType) {

		HashMap<String, String> httpParamMap = (HashMap<String, String>) httpParamUtil.reportMCIFParamRH(msgType);

		// 1-设置请求头
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("multipart/form-data");
		headers.setContentType(type);

		// 报送机构
		headers.add("bank", httpParamMap.get("reportBank"));
		// 请求编号
		headers.add("requestId", httpParamMap.get("requestId"));
		// 时间戳
		headers.add("timestamp", httpParamMap.get("timestamp"));
		// 签名
		headers.add("signature", httpParamMap.get("signature"));
		// 版本号
		headers.add("version", httpParamMap.get("version"));

		// 2-设置请求体
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		//String fileName  = httpParamMap.get("fileName");
		// 上传文件时需要
		FileSystemResource fileSystemResource = new FileSystemResource(new File(httpParamMap.get("fileRealPath")));
		map.add("file", fileSystemResource);
		// reqData
		map.add("reqData", httpParamMap.get("reqData"));

		// 3-发送请求
		HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(map,
				headers);

		GreenfinSendLog greenfinSendLog = new GreenfinSendLog(httpParamMap.get("requestId"));
		greenfinSendLog.setRequestDate(DateFormatUtils.format(new Date(), "yyyyMMdd"));
		greenfinSendLog.setRequestUrl(httpParamMap.get("url"));
		greenfinSendLog.setReportBank(httpParamMap.get("reportBank"));
		greenfinSendLog.setTimestamp(httpParamMap.get("timestamp"));
		greenfinSendLog.setFileName(httpParamMap.get("fileName"));
		try {
			if("true".equals(httpOpen)){
				response = restTemplate.postForObject(httpParamMap.get("url"), httpEntity, String.class);
			}
			logger.info("接口返回信息：" + response);
			JSONObject jsonResult = JSONObject.fromObject(response);
			// 保存接口调用记录和结果到数据库
			greenfinSendLog.setResultCode(jsonResult.getString("code"));
			greenfinSendLog.setResultMessage(jsonResult.getString("message"));
			greenfinSendLog.setFileNameIndex(httpParamMap.get("fileName").substring(28, 30));
			greenfinSendLog.setRequestType(httpParamMap.get("fileName").substring(0, 3));
			resultVo.setCode(jsonResult.getString("code"));
			resultVo.setMessage(jsonResult.getString("message"));
		} catch (Exception e) {
			logger.info("接口异常：" + e.getMessage());
			greenfinSendLog.setResultCode("999");
			greenfinSendLog.setResultMessage("接口异常");
			resultVo.setCode("999");
			resultVo.setMessage("接口异常");
		}

		greenfinSendLogMapper.insert(greenfinSendLog);
		return resultVo;
	}

	@Override
	public ResultVo reportMCIF(String reportDate, String reportPackageName) {

		HashMap<String, String> httpParamMap = (HashMap<String, String>) httpParamUtil.reportMCIFParamRH(reportDate,reportPackageName);

		// 1-设置请求头
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		// 报送机构
		headers.add("bank", httpParamMap.get("reportBank"));
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
		// 报送日期
		map.put("reportDate", reportDate);
		map.put("reportPackageName", reportPackageName);

		// 3-发送请求
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(map, headers);

		GreenfinSendLog greenfinSendLog = new GreenfinSendLog(httpParamMap.get("requestId"));
		greenfinSendLog.setRequestDate(DateFormatUtils.format(new Date(), "yyyyMMdd"));
		greenfinSendLog.setRequestUrl(httpParamMap.get("url"));
		greenfinSendLog.setReportBank(httpParamMap.get("reportBank"));
		greenfinSendLog.setTimestamp(httpParamMap.get("timestamp"));
		greenfinSendLog.setFileName(httpParamMap.get("fileName"));
		try {
			if("true".equals(httpOpen)){
				response = restTemplate.postForObject(httpParamMap.get("url"), httpEntity, String.class);
			}
			logger.info("接口返回信息：" + response);
			JSONObject jsonResult = JSONObject.fromObject(response);
			// 保存接口调用记录和结果到数据库
			greenfinSendLog.setResultCode(jsonResult.getString("code"));
			greenfinSendLog.setResultMessage(jsonResult.getString("message"));
			resultVo.setCode(jsonResult.getString("code"));
			resultVo.setMessage(jsonResult.getString("message"));
		} catch (Exception e) {
			logger.info("接口异常：" + e.getMessage());
			greenfinSendLog.setResultCode("999");
			greenfinSendLog.setResultMessage("接口异常");
			resultVo.setCode("999");
			resultVo.setMessage("接口异常");
		}

		greenfinSendLogMapper.insert(greenfinSendLog);
		return resultVo;
	}

}
