package com.hzhx.greenFinance.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.hzhx.greenFinance.Util.XMLUtil;
import com.hzhx.greenFinance.Util.ZipUtils;
import com.hzhx.greenFinance.config.PageBean;
import com.hzhx.greenFinance.dao.QueryBillInfoMapper;
import com.hzhx.greenFinance.dao.QueryBondInfoMapper;
import com.hzhx.greenFinance.dao.QueryCreditInfoMapper;
import com.hzhx.greenFinance.dao.QueryEnvironmentInfoMapper;
import com.hzhx.greenFinance.dao.QueryLoanInfoMapper;
import com.hzhx.greenFinance.service.QueryInfoService;
import com.hzhx.greenFinance.vo.CustomerBillInfo;
import com.hzhx.greenFinance.vo.CustomerCreditInfo;
import com.hzhx.greenFinance.vo.CustomerEnvironmentInfo;
import com.hzhx.greenFinance.vo.CustomerLoanInfo;
import com.hzhx.greenFinance.vo.ReportSummarys;
import com.hzhx.greenFinance.vo.children.Bond;
import com.hzhx.greenFinance.vo.report.BondReport;
import com.hzhx.greenFinance.vo.report.CustomerBillReport;
import com.hzhx.greenFinance.vo.report.CustomerCreditReport;
import com.hzhx.greenFinance.vo.report.CustomerEnvironmentReport;
import com.hzhx.greenFinance.vo.report.CustomerLoanInfoReport;

@Service
public class QueryInfoServiceImpl implements QueryInfoService {
	private static Logger logger = LoggerFactory.getLogger(QueryInfoServiceImpl.class);
	private static String[] normalBusinessTypeArr = new String[] { "LB", "LC", "AB", "BI", "ER" };

	private String xmlFileName;
	private File dir;
	private static int pageCount = 1000;

	@Autowired
	private Environment env;
	@Autowired
	private QueryLoanInfoMapper queryLoanInfoMapper;
	@Autowired
	private QueryCreditInfoMapper queryCreditInfoMapper;
	@Autowired
	private QueryBillInfoMapper queryBillInfoMapper;
	@Autowired
	private QueryBondInfoMapper queryBondInfoMapper;
	@Autowired
	private QueryEnvironmentInfoMapper queryEnvironmentInfoMapper;

	@Override
	public void queryInfoToXml(String msgBusinessType, String zipFileName) {
		try {
			xmlFileName = zipFileName.substring(0, 29) + "_" + msgBusinessType + "_001_" + ".xml";
			switch (msgBusinessType) {
			case "LB":// 贷款信息报文
				getCustomerLoanInfoReport(xmlFileName);
				break;
			case "LC":// 绿色信用证信息报文
				getCustomerCreditReport(xmlFileName);
				break;
			case "AB":// 绿色银行承兑汇票信息报文
				getCustomerBillReport(xmlFileName);
				break;
			case "BI":// 绿色债券投资信息报文
				getBondReport(xmlFileName);
				break;
			case "ER":// 环境/安全风险信息报文
				getEnvironmentInfoReport(xmlFileName);
				break;
			case "IM":// 个人信息修正报文

				break;
			case "EM":// 企业信息修正报文

				break;
			case "PM":// 项目信息修正报文

				break;
			case "GM":// 绿色认定分类修正报文

				break;
			case "OM":// 业务发生机构修正报文

				break;
			case "DB":// 删除报文

				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 4.3.5环境/安全风险信息 报文
	 * 
	 * @param xmlFileName
	 */
	private void getEnvironmentInfoReport(String xmlFileName) {
		int count = queryEnvironmentInfoMapper.queryCustomerEnvironmentInfoCount();
		if(count>0){
			int pageNum = (count - 1) / pageCount + 1;
			PageBean pageBean = new PageBean();
			for (int i = 0; i < pageNum; i++) {
				pageBean.setLimit(pageCount);
				pageBean.setOffset(pageCount * i);
				
				List<CustomerEnvironmentInfo> environmentInfoList = queryEnvironmentInfoMapper
						.queryCustomerEnvironmentInfoByPage(pageBean);
				CustomerEnvironmentReport cEnvironmentReport = new CustomerEnvironmentReport();
				cEnvironmentReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "BI"));
				cEnvironmentReport.setCustomerEnvironmentInfo(environmentInfoList);
				xmlFileName = xmlFileName.substring(0, 33) + String.format("%03d", i + 1) + ".xml";
				creatXmlFile(cEnvironmentReport, xmlFileName);
			}
		}
	}

	/**
	 * 绿色债券投资信息报文
	 * 
	 * @param zipFileName
	 */
	private void getBondReport(String xmlFileName) {
		int count = queryBondInfoMapper.queryBondInfoByPageCount();
		if(count>0){
			int pageNum = (count - 1) / pageCount + 1;
			PageBean pageBean = new PageBean();
			for (int i = 0; i < pageNum; i++) {
				pageBean.setLimit(pageCount);
				pageBean.setOffset(pageCount * i);
				
				List<Bond> bondList = queryBondInfoMapper.queryBondInfoByPage(pageBean);
				BondReport bondReport = new BondReport();
				bondReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "BI"));
				bondReport.setBond(bondList);
				xmlFileName = xmlFileName.substring(0, 33) + String.format("%03d", i + 1) + ".xml";
				creatXmlFile(bondReport, xmlFileName);
			}
		}
	}

	/**
	 * 4.3.3绿色银行承兑汇票信息 报文
	 * 
	 * @param zipFileName
	 */
	private void getCustomerBillReport(String xmlFileName) {
		int count = queryBillInfoMapper.queryCustomerBillInfoCount();
		if(count>0){
			int pageNum = (count - 1) / pageCount + 1;
			PageBean pageBean = new PageBean();
			for (int i = 0; i < pageNum; i++) {
				pageBean.setLimit(pageCount);
				pageBean.setOffset(pageCount * i);
				
				List<CustomerBillInfo> customerBillInfoList = queryBillInfoMapper.queryCustomerBillInfoByPage(pageBean);
				CustomerBillReport customerBillReport = new CustomerBillReport();
				customerBillReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "AB"));
				customerBillReport.setCustomerBillInfo(customerBillInfoList);
				xmlFileName = xmlFileName.substring(0, 33) + String.format("%03d", i + 1) + ".xml";
				creatXmlFile(customerBillReport, xmlFileName);
			}
		}
	}

	/**
	 * 4.3.2绿色信用证信息 报文
	 * 
	 * @param zipFileName
	 */
	private void getCustomerCreditReport(String xmlFileName) {
		int count = queryCreditInfoMapper.queryCustomerCreditInfoCount();
		if(count>0){
			int pageNum = (count - 1) / pageCount + 1;
			PageBean pageBean = new PageBean();
			for (int i = 0; i < pageNum; i++) {
				pageBean.setLimit(pageCount);
				pageBean.setOffset(pageCount * i);
				
				List<CustomerCreditInfo> customerCreditInfoList = queryCreditInfoMapper
						.queryCustomerCreditInfoByPage(pageBean);
				CustomerCreditReport customerLoanInfoReport = new CustomerCreditReport();
				customerLoanInfoReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "LC"));
				customerLoanInfoReport.setCustomerCreditInfo(customerCreditInfoList);
				xmlFileName = xmlFileName.substring(0, 33) + String.format("%03d", i + 1) + ".xml";
				creatXmlFile(customerLoanInfoReport, xmlFileName);
			}
		}
	}

	/**
	 * 4.3.1贷款信息 报文
	 * 
	 * @param zipFileName
	 */
	private void getCustomerLoanInfoReport(String xmlFileName) {
		int count = queryLoanInfoMapper.queryCustomerLoanInfoCount();
		if(count>0){
			int pageNum = (count - 1) / pageCount + 1;
			PageBean pageBean = new PageBean();
			for (int i = 0; i < pageNum; i++) {
				pageBean.setLimit(pageCount);
				pageBean.setOffset(pageCount * i);
				
				List<CustomerLoanInfo> customerLoanInfoList = queryLoanInfoMapper.queryCustomerLoanInfoByPage(pageBean);
				CustomerLoanInfoReport customerLoanInfoReport = new CustomerLoanInfoReport();
				customerLoanInfoReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "LB"));
				customerLoanInfoReport.setCustomerLoanInfo(customerLoanInfoList);
				
				xmlFileName = xmlFileName.substring(0, 33) + String.format("%03d", i + 1) + ".xml";
				creatXmlFile(customerLoanInfoReport, xmlFileName);
			}
		}
	}

	private void creatXmlFile(Object obj, String xmlFileName) {

		// xml路径
		String xmlPath = dir.getPath() + File.separator + xmlFileName;
		logger.info("---将对象转换成File类型的xml Start---");
		XMLUtil.convertToXml(obj, xmlPath);
		logger.info("---将对象转换成File类型的xml End---");
	}

	@Override
	public void queryAllInfoToXml(String zipFileName) {
		// 临时文件夹
		dir = new File(env.getProperty("filePath") + File.separator + "xml_temp");
		if (dir.exists()) {
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				files[i].getAbsoluteFile().delete();
			}
		}else{
			dir.mkdir();
		}

		for (String BusinessType : normalBusinessTypeArr) {
			queryInfoToXml(BusinessType, zipFileName);
		}

		String xmlPath = env.getProperty("filePath") + "xml_temp";
		String zipPath = env.getProperty("filePath");

		File[] fileList = new File(xmlPath).listFiles();
		try {
			FileOutputStream fos;
			fos = new FileOutputStream(new File(zipPath + zipFileName));
			ZipUtils.toZip(fileList, fos);
			logger.info("---将xml打包zip成功---");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void queryDailyInfoToXml(String zipFileName, String dataDate) {
		// 临时文件夹
		dir = new File(env.getProperty("filePath") + File.separator + "xml_temp");
		if (dir.exists()) {
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				files[i].getAbsoluteFile().delete();
			}
		}else{
			dir.mkdir();
		}

		for (String BusinessType : normalBusinessTypeArr) {
			queryInfoToXml(BusinessType, zipFileName, dataDate);
		}

		String xmlPath = env.getProperty("filePath") + "xml_temp";
		String zipPath = env.getProperty("filePath");

		File[] fileList = new File(xmlPath).listFiles();
		try {
			FileOutputStream fos;
			fos = new FileOutputStream(new File(zipPath + zipFileName));
			ZipUtils.toZip(fileList, fos);
			logger.info("---将xml打包zip成功---");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void queryInfoToXml(String businessType, String zipFileName, String dataDate) {
		try {
			xmlFileName = zipFileName.substring(0, 29) + "_" + businessType + "_001_" + ".xml";
			switch (businessType) {
			case "LB":// 贷款信息报文
				getCustomerLoanInfoReport(xmlFileName, dataDate);
				break;
			case "LC":// 绿色信用证信息报文
				getCustomerCreditReport(xmlFileName, dataDate);
				break;
			case "AB":// 绿色银行承兑汇票信息报文
				getCustomerBillReport(xmlFileName, dataDate);
				break;
			case "BI":// 绿色债券投资信息报文
				getBondReport(xmlFileName, dataDate);
				break;
			case "ER":// 环境/安全风险信息报文
				getEnvironmentInfoReport(xmlFileName, dataDate);
				break;
			case "IM":// 个人信息修正报文

				break;
			case "EM":// 企业信息修正报文

				break;
			case "PM":// 项目信息修正报文

				break;
			case "GM":// 绿色认定分类修正报文

				break;
			case "OM":// 业务发生机构修正报文

				break;
			case "DB":// 删除报文

				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getEnvironmentInfoReport(String xmlFileName, String dataDate) {
		int count = queryEnvironmentInfoMapper.queryDailyCount(dataDate);
		int pageNum = (count - 1) / pageCount + 1;
		PageBean pageBean = new PageBean();
		for (int i = 0; i < pageNum; i++) {
			pageBean.setLimit(pageCount);
			pageBean.setOffset(pageCount * i);

			List<CustomerEnvironmentInfo> environmentInfoList = queryEnvironmentInfoMapper
					.queryDailyInfoByPage(pageBean, dataDate);
			CustomerEnvironmentReport cEnvironmentReport = new CustomerEnvironmentReport();
			cEnvironmentReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "BI"));
			cEnvironmentReport.setCustomerEnvironmentInfo(environmentInfoList);
			xmlFileName = xmlFileName.substring(0, 33) + String.format("%03d", i + 1) + ".xml";
			creatXmlFile(cEnvironmentReport, xmlFileName);
		}
	}

	private void getBondReport(String xmlFileName, String dataDate) {
		int count = queryBondInfoMapper.queryDailyCount(dataDate);
		int pageNum = (count - 1) / pageCount + 1;
		PageBean pageBean = new PageBean();
		for (int i = 0; i < pageNum; i++) {
			pageBean.setLimit(pageCount);
			pageBean.setOffset(pageCount * i);

			List<Bond> bondList = queryBondInfoMapper.queryDailyInfoByPage(pageBean, dataDate);
			BondReport bondReport = new BondReport();
			bondReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "BI"));
			bondReport.setBond(bondList);
			xmlFileName = xmlFileName.substring(0, 33) + String.format("%03d", i + 1) + ".xml";
			creatXmlFile(bondReport, xmlFileName);
		}
	}

	private void getCustomerBillReport(String xmlFileName, String dataDate) {
		int count = queryBillInfoMapper.queryDailyCount(dataDate);
		int pageNum = (count - 1) / pageCount + 1;
		PageBean pageBean = new PageBean();
		for (int i = 0; i < pageNum; i++) {
			pageBean.setLimit(pageCount);
			pageBean.setOffset(pageCount * i);

			List<CustomerBillInfo> customerBillInfoList = queryBillInfoMapper.queryDailyInfoByPage(pageBean, dataDate);
			CustomerBillReport customerBillReport = new CustomerBillReport();
			customerBillReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "AB"));
			customerBillReport.setCustomerBillInfo(customerBillInfoList);
			xmlFileName = xmlFileName.substring(0, 33) + String.format("%03d", i + 1) + ".xml";
			creatXmlFile(customerBillReport, xmlFileName);
		}
	}

	private void getCustomerCreditReport(String xmlFileName, String dataDate) {
		int count = queryCreditInfoMapper.queryDailyCount(dataDate);
		int pageNum = (count - 1) / pageCount + 1;
		PageBean pageBean = new PageBean();
		for (int i = 0; i < pageNum; i++) {
			pageBean.setLimit(pageCount);
			pageBean.setOffset(pageCount * i);

			List<CustomerCreditInfo> customerCreditInfoList = queryCreditInfoMapper.queryDailyInfoByPage(pageBean,
					dataDate);
			CustomerCreditReport customerLoanInfoReport = new CustomerCreditReport();
			customerLoanInfoReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "LC"));
			customerLoanInfoReport.setCustomerCreditInfo(customerCreditInfoList);
			xmlFileName = xmlFileName.substring(0, 33) + String.format("%03d", i + 1) + ".xml";
			creatXmlFile(customerLoanInfoReport, xmlFileName);
		}
	}

	private void getCustomerLoanInfoReport(String xmlFileName, String dataDate) {
		int count = queryLoanInfoMapper.queryDailyCount(dataDate);
		int pageNum = (count - 1) / pageCount + 1;
		PageBean pageBean = new PageBean();
		for (int i = 0; i < pageNum; i++) {
			pageBean.setLimit(pageCount);
			pageBean.setOffset(pageCount * i);

			List<CustomerLoanInfo> customerLoanInfoList = queryLoanInfoMapper.queryDailyInfoByPage(pageBean, dataDate);
			CustomerLoanInfoReport customerLoanInfoReport = new CustomerLoanInfoReport();
			customerLoanInfoReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "LB"));
			customerLoanInfoReport.setCustomerLoanInfo(customerLoanInfoList);

			xmlFileName = xmlFileName.substring(0, 33) + String.format("%03d", i + 1) + ".xml";
			creatXmlFile(customerLoanInfoReport, xmlFileName);
		}
	}
}
