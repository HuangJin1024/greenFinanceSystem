package com.hzhx.greenFinance.Util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.crypto.SecretKey;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.utils.DateUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.hzhx.greenFinance.dao.SqlUtilMapper;
import com.hzhx.greenFinance.service.QueryInfoService;
import com.hzhx.greenFinance.service.QueryRHInfoService;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import net.sf.json.JSONObject;

@Component
public class HttpParamUtil {
	private static Logger logger = LoggerFactory.getLogger(HttpParamUtil.class);

	// 文件地址
	@Value("${filePath}")
	private String filePath;

	// 人行文件地址
	@Value("${renhangFilePath}")
	private String renhangFilePath;

	// 人行发送私钥
	@Value("${key_RH}")
	private String key_RH;

	// 发送私钥
	@Value("${sendPrivateKey}")
	private String sendPrivateKey;

	// 文件公钥
	@Value("${filePublicKey}")
	private String filePublicKey;

	// Http头部
	@Value("${reportBankCd}")
	private String reportBank;// 报送机构:报送机构金融许可证号
	private String requestId;// 请求编号:小于等于32位字符的数字字母组合，如请求序列号或UUID
	private String timestamp;// 时间戳
	private String signature;// 签名:通过报送机构、请求编号、时间戳生成签名
	@Value("${version}")
	private String version;// 版本号:1.0
	@Value("${versionRH}")
	private String versionRH;// 版本号:2.0

	private String url;// 请求地址
	// http参数
	private String fileBase64;// 报送文件串:要报送数据包文件的文件串
	private String fileName;// 文件名:数据包名
	private String fileSecretKey;// 文件密钥串:文件加密的密钥串

	private String reqData;
	private String reportDate;
	private String serialNo;
	private String reportPackageName;// 报送数据包名
	private String formPeriod;// 报表期数
	private List businessNoList;

	@Autowired
	private Environment env;
	@Autowired
	private SqlUtilMapper sqlUtilMapper;
	@Autowired
	private QueryInfoService queryInfoService;
	@Autowired
	private QueryRHInfoService queryRHInfoService;

	/**
	 * 获取文件名称
	 * 
	 * @param msgType
	 * @param msgBusinessType
	 * @return
	 */
	private void getFileName(String msgType, String msgBusinessType) {
		// 报送机构金融许可证号
		reportBank = env.getProperty("reportBankCd");
		// 报送日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		reportDate = sdf.format(new Date());
		// 序列号
		String fileNameIndex = sqlUtilMapper.findFileNameIndex(reportBank, reportDate, msgType);
		fileNameIndex = StringUtils.isNotBlank(fileNameIndex) ? fileNameIndex : "000";
		serialNo = String.format("%03d", Integer.valueOf(fileNameIndex) + 1);

		fileName = msgType + reportBank + "_" + reportDate + "_" + serialNo + ".zip";

		// 查询信息生产文件并返回文件路径和文件名称
		if ("true".equals(env.getProperty("dataBaseOpen"))) {

			queryInfoService.queryInfoToXml(msgBusinessType, fileName);
		}

	}

	// 加密签名生成机制
	/**
	 * 获取加密签名
	 * 
	 * @param msgType
	 * @return
	 */
	private String getSignature(String interfaceName) {
		Map<String, String> reqBodyMap = new HashMap<String, String>();// 请求体Map

		// 1-报送机构金融许可证号
		reportBank = env.getProperty("reportBankCd");
		// 2-请求编号
		requestId = UUID.randomUUID().toString().replace("-", "");
		// 3-时间戳
		timestamp = String.valueOf(System.currentTimeMillis());
		// 4-请求体
		switch (interfaceName) {
		case "reportData":// 6.3业务数据报送接口
			reqBodyMap.put("fileSecretKey", fileSecretKey);
			reqBodyMap.put("fileBase64", fileBase64);
			reqBodyMap.put("fileName", fileName);
			break;
		case "receipt":// 6.4报送回执查询接口
			reqBodyMap.put("reportPackageName", reportPackageName);
			break;
		case "inspection":// 6.5驳回业务查询接口

			break;
		case "inspectionFeedback":// 6.6驳回信息接收确认接口
			// reqBodyMap.put("businessNoList", businessNoList.toString());
			break;
		case "getFormTaskList":// 6.7报表报送任务查询接口

			break;
		case "reportForm":// 6.8报表数据报送接口
			reqBodyMap.put("formPeriod", formPeriod);
			reqBodyMap.put("fileBase64", fileBase64);
			reqBodyMap.put("fileName", fileName);
			reqBodyMap.put("fileSecretKey", fileSecretKey);
			break;
		case "receiptForm":// 6.9报表报送回执查询接口
			reqBodyMap.put("reportPackageName", reportPackageName);
			break;
		case "queryAuditResult":// 6.10报表审核结果查询接口
			// reqBodyMap.put("formPeriod", formPeriod);
			break;
		default:
			break;
		}
		JSONObject json = new JSONObject(reqBodyMap);
		String requestBody = json.toString();

		logger.info("请求机构reportBank:" + reportBank);
		logger.info("请求编号requestId:" + requestId);
		logger.info("时间戳timestamp:" + timestamp);
		logger.info("请求体requestBody:" + requestBody);

		String signature = null;
		try {
			signature = getSign(reportBank, requestId, timestamp, requestBody, sendPrivateKey);
			logger.info("加密签名signature:" + signature);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return signature;
	}

	// 加密报文串生成机制
	/**
	 * 加密报文 fileBase64 fileSecretKey
	 */
	private void getEncryptMessage() throws Exception {
		// 1）生成AES对称加密的秘钥
		SecretKey secretKey = SecureUtil.generateKey("AES");
		byte[] secretKeyEncoded = secretKey.getEncoded();

		// 2）对文件加密，并生成base64字符串
		// 获取文件流
		byte[] fileBytes = file2byte(new File(filePath + fileName));
		byte[] data = SecureUtil.aes(secretKeyEncoded).encrypt(fileBytes);
		fileBase64 = Base64.encodeBase64String(data);

		// 3）使用SM2对AES秘钥进行加密，并生成base64字符串,SM2加密算法,filePublicKey为绿茵系统2.0提供的AES秘钥加密公钥，secretKeyEncoded为步骤1生成的AES秘钥。
		byte[] secretKeyDecrypt = null;
		try {
			PublicKey publicKey = SM2Util.getPublicKeyFromString(filePublicKey);
			secretKeyDecrypt = SmUtil.sm2().setPublicKey(publicKey).encrypt(secretKeyEncoded, KeyType.PublicKey);
			fileSecretKey = Base64.encodeBase64String(secretKeyDecrypt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将文件转换成byte数组
	 * 
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	private byte[] file2byte(File file) throws Exception {
		byte[] buffer = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();
		} catch (FileNotFoundException e) {
			logger.info(file.getPath() + "文件不存在");
			throw e;
		} catch (IOException e) {
			logger.info(file.getPath() + "文件异常");
			throw e;
		}
		return buffer;
	}

	/**
	 * 获取数据报送接口请求信息
	 * 
	 * @param msgType
	 * @return
	 */
	// 6.3业务数据报送接口
	public Map<String, String> reportDataParam(String msgType, String msgBusinessType) throws Exception {
		Map<String, String> httpParamMap = new HashMap<String, String>();
		getFileName(msgType, msgBusinessType);
		getEncryptMessage();
		signature = getSignature("reportData");
		url = env.getProperty("url.reportData");
		httpParamMap.put("url", url);
		httpParamMap.put("fileBase64", fileBase64);
		httpParamMap.put("fileName", fileName);
		httpParamMap.put("fileSecretKey", fileSecretKey);
		httpParamMap.put("reportBank", reportBank);
		httpParamMap.put("requestId", requestId);
		httpParamMap.put("timestamp", timestamp);
		httpParamMap.put("signature", signature);
		httpParamMap.put("version", version);
		return httpParamMap;
	}

	// 6.4报送回执查询接口
	public Map<String, String> receiptParam(String reportPackageNameTemp) {
		Map<String, String> httpParamMap = new HashMap<String, String>();
		reportPackageName = reportPackageNameTemp;
		signature = getSignature("receipt");
		url = env.getProperty("url.receipt");
		httpParamMap.put("url", url);
		httpParamMap.put("reportPackageName", reportPackageName);
		httpParamMap.put("reportBank", reportBank);
		httpParamMap.put("requestId", requestId);
		httpParamMap.put("timestamp", timestamp);
		httpParamMap.put("signature", signature);
		httpParamMap.put("version", version);
		return httpParamMap;
	}

	// 6.5驳回业务查询接口
	public Map<String, String> inspectionParam() {
		Map<String, String> httpParamMap = new HashMap<String, String>();
		signature = getSignature("inspection");
		url = env.getProperty("url.inspection");
		httpParamMap.put("url", url);
		httpParamMap.put("reportBank", reportBank);
		httpParamMap.put("requestId", requestId);
		httpParamMap.put("timestamp", timestamp);
		httpParamMap.put("signature", signature);
		httpParamMap.put("version", version);
		return httpParamMap;
	}

	// 6.6驳回信息接收确认接口
	public Map<String, String> inspectionFeedbackParam(List<?> list) {
		Map<String, String> httpParamMap = new HashMap<String, String>();
		signature = getSignature("inspectionFeedback");
		url = env.getProperty("url.inspectionFeedback");
		httpParamMap.put("url", url);
		httpParamMap.put("businessNoList", list.toString());
		httpParamMap.put("reportBank", reportBank);
		httpParamMap.put("requestId", requestId);
		httpParamMap.put("timestamp", timestamp);
		httpParamMap.put("signature", signature);
		httpParamMap.put("version", version);
		return httpParamMap;
	}

	// 6.7报表报送任务查询接口
	public Map<String, String> getFormTaskListParam() {
		Map<String, String> httpParamMap = new HashMap<String, String>();
		signature = getSignature("getFormTaskList");
		url = env.getProperty("url.getFormTaskList");
		httpParamMap.put("url", url);
		httpParamMap.put("reportBank", reportBank);
		httpParamMap.put("requestId", requestId);
		httpParamMap.put("timestamp", timestamp);
		httpParamMap.put("signature", signature);
		httpParamMap.put("version", version);
		return httpParamMap;
	}

	// 6.8报表数据报送接口
	public Map<String, String> reportFormParam(String formPeriodTemp) throws Exception {
		Map<String, String> httpParamMap = new HashMap<String, String>();
		formPeriod = formPeriodTemp;
		getFromFileName(formPeriod);
		getEncryptMessage();
		signature = getSignature("reportForm");
		url = env.getProperty("url.reportForm");
		httpParamMap.put("url", url);
		httpParamMap.put("formPeriod", formPeriod);
		httpParamMap.put("fileBase64", fileBase64);
		httpParamMap.put("fileName", fileName);
		httpParamMap.put("fileSecretKey", fileSecretKey);
		httpParamMap.put("reportBank", reportBank);
		httpParamMap.put("requestId", requestId);
		httpParamMap.put("timestamp", timestamp);
		httpParamMap.put("signature", signature);
		httpParamMap.put("version", version);
		return httpParamMap;
	}

	private void getFromFileName(String formPeriod) {
		// 报送机构金融许可证号
		reportBank = env.getProperty("reportBankCd");
		// 报送日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		reportDate = sdf.format(new Date());
		// 序列号
		String fileNameIndex = sqlUtilMapper.findFileNameIndex(reportBank, reportDate, "R");
		fileNameIndex = StringUtils.isNotBlank(fileNameIndex) ? fileNameIndex : "000";
		serialNo = String.format("%03d", Integer.valueOf(fileNameIndex) + 1);

		// 数据包名称
		fileName = "R" + reportBank + "_" + reportDate + "_" + serialNo + ".zip";

		if ("true".equals(env.getProperty("dataBaseOpen"))) {

			queryInfoService.queryFormInfoToXml(fileName, formPeriod);
		}
	}

	// 6.9报表报送回执查询接口
	public Map<String, String> receiptFormParam(String reportPackageNameTemp) {
		Map<String, String> httpParamMap = new HashMap<String, String>();
		reportPackageName = reportPackageNameTemp;
		signature = getSignature("receiptForm");
		url = env.getProperty("url.receiptForm");
		httpParamMap.put("url", url);
		httpParamMap.put("reportPackageName", reportPackageName);
		httpParamMap.put("reportBank", reportBank);
		httpParamMap.put("requestId", requestId);
		httpParamMap.put("timestamp", timestamp);
		httpParamMap.put("signature", signature);
		httpParamMap.put("version", version);
		return httpParamMap;
	}

	// 6.10报表审核结果查询接口
	public Map<String, String> queryAuditResultParam(String formPeriodTemp) {
		Map<String, String> httpParamMap = new HashMap<String, String>();
		formPeriod = formPeriodTemp;
		signature = getSignature("queryAuditResult");
		url = env.getProperty("url.queryAuditResult");
		httpParamMap.put("url", url);
		httpParamMap.put("formPeriod", formPeriod);
		httpParamMap.put("reportBank", reportBank);
		httpParamMap.put("requestId", requestId);
		httpParamMap.put("timestamp", timestamp);
		httpParamMap.put("signature", signature);
		httpParamMap.put("version", version);
		return httpParamMap;
	}

	private static String getSign(String bankCd, String requestId, String timestamp, String requestBody,
			String privateKeyStr) throws Exception {
		String reqDataSHA256 = StringUtils.isBlank(requestBody) ? "" : sha256(requestBody);
		String originalSignText = bankCd + requestId + timestamp + reqDataSHA256;
		logger.info("加密原文串:" + originalSignText);
		return SM2Utils.sign(privateKeyStr, bankCd + requestId + timestamp + reqDataSHA256);
	}

	private static String sha256(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.update(str.getBytes("UTF-8"));
		return Base64.encodeBase64String(messageDigest.digest());
	}

	public Map<String, String> reportAllDataParam(String msgType) throws Exception {
		Map<String, String> httpParamMap = new HashMap<String, String>();
		getAllDateFileName(msgType);
		getEncryptMessage();
		signature = getSignature("reportData");
		url = env.getProperty("url.reportData");
		httpParamMap.put("url", url);
		httpParamMap.put("fileBase64", fileBase64);
		httpParamMap.put("fileName", fileName);
		httpParamMap.put("fileSecretKey", fileSecretKey);
		httpParamMap.put("reportBank", reportBank);
		httpParamMap.put("requestId", requestId);
		httpParamMap.put("timestamp", timestamp);
		httpParamMap.put("signature", signature);
		httpParamMap.put("version", version);
		return httpParamMap;
	}

	private void getAllDateFileName(String msgType) {
		// 报送机构金融许可证号
		reportBank = env.getProperty("reportBankCd");
		// 报送日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		reportDate = sdf.format(new Date());
		// 序列号
		String fileNameIndex = sqlUtilMapper.findFileNameIndex(reportBank, reportDate, msgType);
		fileNameIndex = StringUtils.isNotBlank(fileNameIndex) ? fileNameIndex : "000";
		serialNo = String.format("%03d", Integer.valueOf(fileNameIndex) + 1);

		// 数据包名称
		fileName = msgType + reportBank + "_" + reportDate + "_" + serialNo + ".zip";

		if ("true".equals(env.getProperty("dataBaseOpen"))) {
			if ("D".equals(msgType)) {
				queryInfoService.queryDeleteInfoToXml(fileName);
			} else {

				queryInfoService.queryAllInfoToXml(fileName);
			}
		}
	}

	public Map<String, String> reportDataDailyParam(String msgType, String dataDate) throws Exception {
		Map<String, String> httpParamMap = new HashMap<String, String>();
		getDailyDateFileName(msgType, dataDate);
		getEncryptMessage();
		signature = getSignature("reportData");
		url = env.getProperty("url.reportData");
		httpParamMap.put("url", url);
		httpParamMap.put("fileBase64", fileBase64);
		httpParamMap.put("fileName", fileName);
		httpParamMap.put("fileSecretKey", fileSecretKey);
		httpParamMap.put("reportBank", reportBank);
		httpParamMap.put("requestId", requestId);
		httpParamMap.put("timestamp", timestamp);
		httpParamMap.put("signature", signature);
		httpParamMap.put("version", version);
		return httpParamMap;
	}

	private void getDailyDateFileName(String msgType, String dataDate) {
		// 报送机构金融许可证号
		reportBank = env.getProperty("reportBankCd");
		// 报送日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		reportDate = sdf.format(new Date());
		// 序列号
		String fileNameIndex = sqlUtilMapper.findFileNameIndex(reportBank, reportDate, msgType);
		fileNameIndex = StringUtils.isNotBlank(fileNameIndex) ? fileNameIndex : "000";
		serialNo = String.format("%03d", Integer.valueOf(fileNameIndex) + 1);

		// 数据包名称
		fileName = msgType + reportBank + "_" + reportDate + "_" + serialNo + ".zip";

		if ("true".equals(env.getProperty("dataBaseOpen"))) {

			queryInfoService.queryDailyInfoToXml(fileName, dataDate);
		}
	}

	// =========================================人行数据========================================

	public Map<String, String> reportAllDataParamRH(String msgType) {
		Map<String, String> httpParamMap = new HashMap<String, String>();

		getRHAllDateFileName(msgType);

		signature = getRHSignature("reportData");
		url = env.getProperty("http_send");
		httpParamMap.put("fileRealPath", renhangFilePath + fileName);
		httpParamMap.put("fileName", fileName);
		httpParamMap.put("url", url);
		httpParamMap.put("reqData", reqData);
		httpParamMap.put("reportBank", reportBank);
		httpParamMap.put("requestId", requestId);
		httpParamMap.put("timestamp", timestamp);
		httpParamMap.put("signature", signature);
		httpParamMap.put("version", versionRH);
		return httpParamMap;
	}

	/**
	 * 获取加密签名(人行)
	 * 
	 * @param msgType
	 * @return
	 */
	private String getRHSignature(String interfaceName) {
		// 1-报送机构金融许可证号
		reportBank = env.getProperty("reportBankCd_RH");
		// 2-请求编号
		requestId = UUID.randomUUID().toString().replace("-", "");
		// 3-时间戳
		timestamp = String.valueOf(System.currentTimeMillis());

		// 4-请求体
		switch (interfaceName) {
		case "reportData":
			try {
				byte[] fileBytes = file2byte(new File(renhangFilePath + fileName));
				String reqType = "11090001";
				String reportDate = DateUtils.formatDate(new Date(), "yyyyMMdd");
				byte[] sha256 = DigestUtils.sha256(fileBytes);
				String fileSHA256 = Base64.encodeBase64String(sha256);
				String callbackUrl = env.getProperty("http_send");

				Map<String, String> reqDataMap = new HashMap<String, String>();
				reqDataMap.put("reqType", reqType);
				reqDataMap.put("reportDate", reportDate);
				reqDataMap.put("fileSHA256", fileSHA256);
				reqDataMap.put("callbackUrl", callbackUrl);
				JSONObject reqDataJson = new JSONObject(reqDataMap);
				reqData = reqDataJson.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "receipt":// 6.4报送回执查询接口
			Map<String, String> reqDataMap = new HashMap<String, String>();
			reqDataMap.put("reportDate", reportDate);
			JSONObject reqDataJson = new JSONObject(reqDataMap);
			reqData = reqDataJson.toString();
			break;
		case "inspection":// 6.5驳回业务查询接口

			break;
		case "reportMCIF":// 附件3 数据上报
			try {
				byte[] fileBytes = file2byte(new File(renhangFilePath + fileName));
				String reportDate = DateUtils.formatDate(new Date(), "yyyyMMdd");
				byte[] sha256 = DigestUtils.sha256(fileBytes);
				String fileSHA256 = Base64.encodeBase64String(sha256);

				Map<String, String> reqDataMap1 = new HashMap<String, String>();
				reqDataMap1.put("reportDate", reportDate);
				reqDataMap1.put("fileSHA256", fileSHA256);
				JSONObject reqDataJson1 = new JSONObject(reqDataMap1);
				reqData = reqDataJson1.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "receiptMCIF": // 附件3 数据上报回执
			Map<String, String> reqDataMap2 = new HashMap<String, String>();
			reqDataMap2.put("reportDate", reportDate);
			reqDataMap2.put("reportPackageName", reportPackageName);
			JSONObject reqDataJson2 = new JSONObject(reqDataMap2);
			reqData = reqDataJson2.toString();
			break;
		}

		logger.info("请求机构reportBank:" + reportBank);
		logger.info("请求编号requestId:" + requestId);
		logger.info("时间戳timestamp:" + timestamp);
		logger.info("请求体reqData:" + reqData);

		String signature = null;
		try {
			signature = getSign(reportBank, requestId, timestamp, reqData, key_RH);
			logger.info("加密签名signature:" + signature);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return signature;
	}

	private void getRHAllDateFileName(String msgType) {
		// 报送机构金融许可证号
		reportBank = env.getProperty("reportBankCd_RH");
		// 报送日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		reportDate = sdf.format(new Date());
		// 序列号
		String fileNameIndex = sqlUtilMapper.findFileNameIndex(reportBank, reportDate, msgType);
		fileNameIndex = StringUtils.isNotBlank(fileNameIndex) ? fileNameIndex : "000";
		serialNo = String.format("%03d", Integer.valueOf(fileNameIndex) + 1);

		// 数据包名称
		fileName = msgType + reportBank + "_" + reportDate + "_" + serialNo + ".zip";

		if ("true".equals(env.getProperty("dataBaseOpen"))) {

			if ("N".equals(msgType)) {
				queryRHInfoService.queryAllInfoToXml(fileName);
			} else if ("A".equals(msgType)) {
				queryRHInfoService.queryAllInfoToXml(fileName);
			} else if ("D".equals(msgType)) {
				queryRHInfoService.queryDeleteInfoToXml(fileName);
			} else if ("MCN".equals(msgType)) {
				queryRHInfoService.queryMCNInfoToXml(fileName);
			}
		}
	}

	public Map<String, String> receiptParamRH(String reportDateParam) {
		Map<String, String> httpParamMap = new HashMap<String, String>();
		reportDate = reportDateParam;
		signature = getRHSignature("receipt");
		url = env.getProperty("http_query");
		httpParamMap.put("url", url);
		httpParamMap.put("reqData", reqData);
		httpParamMap.put("reportBank", reportBank);
		httpParamMap.put("requestId", requestId);
		httpParamMap.put("timestamp", timestamp);
		httpParamMap.put("signature", signature);
		httpParamMap.put("version", versionRH);
		return httpParamMap;
	}

	public Map<String, String> inspectionParamRH() {
		Map<String, String> httpParamMap = new HashMap<String, String>();
		signature = getRHSignature("inspection");
		url = env.getProperty("http_reject");
		httpParamMap.put("url", url);
		httpParamMap.put("reqData", reqData);
		httpParamMap.put("reportBank", reportBank);
		httpParamMap.put("requestId", requestId);
		httpParamMap.put("timestamp", timestamp);
		httpParamMap.put("signature", signature);
		httpParamMap.put("version", versionRH);
		return httpParamMap;
	}

	public Map<String, String> reportMCIFParamRH(String msgType) {
		Map<String, String> httpParamMap = new HashMap<String, String>();

		getRHAllDateFileName(msgType);

		signature = getRHSignature("reportMCIF");
		url = env.getProperty("http_mc_send");
		httpParamMap.put("fileRealPath", renhangFilePath + fileName);
		httpParamMap.put("fileName", fileName);
		httpParamMap.put("url", url);
		httpParamMap.put("reqData", reqData);
		httpParamMap.put("reportBank", reportBank);
		httpParamMap.put("requestId", requestId);
		httpParamMap.put("timestamp", timestamp);
		httpParamMap.put("signature", signature);
		httpParamMap.put("version", versionRH);
		return httpParamMap;
	}

	public Map<String, String> reportMCIFParamRH(String reportDateParam, String reportPackageNameParam) {
		Map<String, String> httpParamMap = new HashMap<String, String>();
		reportDate = reportDateParam;
		reportPackageName = reportPackageNameParam;
		signature = getRHSignature("receiptMCIF");
		url = env.getProperty("http_mc_query");
		httpParamMap.put("url", url);
		httpParamMap.put("reqData", reqData);
		httpParamMap.put("reportBank", reportBank);
		httpParamMap.put("requestId", requestId);
		httpParamMap.put("timestamp", timestamp);
		httpParamMap.put("signature", signature);
		httpParamMap.put("version", versionRH);
		return httpParamMap;
	}
}
