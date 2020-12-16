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
import com.hzhx.greenFinance.dao.QueryDeleteInfoMapper;
import com.hzhx.greenFinance.dao.QueryEnvironmentInfoMapper;
import com.hzhx.greenFinance.dao.QueryLoanInfoMapper;
import com.hzhx.greenFinance.dao.formDao.QueryAreaFinancingMapper;
import com.hzhx.greenFinance.dao.formDao.QueryGreenBuildMapper;
import com.hzhx.greenFinance.dao.formDao.QueryGreenFinanceMapper;
import com.hzhx.greenFinance.dao.formDao.QueryGreenOperateMapper;
import com.hzhx.greenFinance.dao.formDao.QueryGreenSubBranchsMapper;
import com.hzhx.greenFinance.dao.formDao.QueryRiskEnterpriseMapper;
import com.hzhx.greenFinance.service.QueryInfoService;
import com.hzhx.greenFinance.vo.CustomerBillInfo;
import com.hzhx.greenFinance.vo.CustomerCreditInfo;
import com.hzhx.greenFinance.vo.CustomerEnvironmentInfo;
import com.hzhx.greenFinance.vo.CustomerLoanInfo;
import com.hzhx.greenFinance.vo.ReportSummarys;
import com.hzhx.greenFinance.vo.children.Bill;
import com.hzhx.greenFinance.vo.children.Bond;
import com.hzhx.greenFinance.vo.children.Credit;
import com.hzhx.greenFinance.vo.children.Loan;
import com.hzhx.greenFinance.vo.report.BondReport;
import com.hzhx.greenFinance.vo.report.CustomerBillReport;
import com.hzhx.greenFinance.vo.report.CustomerCreditReport;
import com.hzhx.greenFinance.vo.report.CustomerEnvironmentReport;
import com.hzhx.greenFinance.vo.report.CustomerLoanInfoReport;
import com.hzhx.greenFinance.vo.report.DeleteInfoReport;
import com.hzhx.greenFinance.vo.totalReport.AreaFinancingReport;
import com.hzhx.greenFinance.vo.totalReport.AreaFinancings;
import com.hzhx.greenFinance.vo.totalReport.GreenBuild;
import com.hzhx.greenFinance.vo.totalReport.GreenBuildReport;
import com.hzhx.greenFinance.vo.totalReport.GreenFinanceReport;
import com.hzhx.greenFinance.vo.totalReport.GreenFinances;
import com.hzhx.greenFinance.vo.totalReport.GreenOperateReport;
import com.hzhx.greenFinance.vo.totalReport.GreenOperates;
import com.hzhx.greenFinance.vo.totalReport.GreenSubBranch;
import com.hzhx.greenFinance.vo.totalReport.GreenSubBranchReport;
import com.hzhx.greenFinance.vo.totalReport.RiskEnterpriseReport;
import com.hzhx.greenFinance.vo.totalReport.RiskEnterprises;

@Service
public class QueryInfoServiceImpl implements QueryInfoService {
	private static Logger logger = LoggerFactory.getLogger(QueryInfoServiceImpl.class);
	private static String[] normalBusinessTypeArr = new String[] { "LB", "LC", "AB", "BI", "ER" };
	private static String[] formBusinessTypeArr = new String[] { "B001", "B002", "B003", "B004", "B005","B006" };

	private String xmlFileName;
	private File dir;
	private static int pageCount = 1000;

	@Autowired
	private Environment env;
	@Autowired
	private QueryDeleteInfoMapper queryDeleteInfoMapper;
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
	@Autowired
	private QueryGreenFinanceMapper queryGreenFinanceMapper;
	@Autowired
	private QueryAreaFinancingMapper queryAreaFinancingMapper;
	@Autowired
	private QueryGreenBuildMapper queryGreenBuildMapper;
	@Autowired
	private QueryGreenOperateMapper queryGreenOperateMapper;
	@Autowired
	private QueryGreenSubBranchsMapper queryGreenSubBranchsMapper;
	@Autowired
	private QueryRiskEnterpriseMapper queryRiskEnterpriseMapper;

	@Override
	public void queryInfoToXml(String msgBusinessType, String zipFileName) {
		try {
			xmlFileName = zipFileName.substring(0, 29) + "_" + msgBusinessType + "_001" + ".xml";
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
				getDeleteInfoReport(xmlFileName);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 删除信息报文
	 * @param xmlFileName
	 */
	private void getDeleteInfoReport(String xmlFileName) {
		List<Loan> loans = queryDeleteInfoMapper.queryLoans();
		List<Bill> bills = queryDeleteInfoMapper.queryBills();
		List<Credit> credits = queryDeleteInfoMapper.queryCredits();
		
		DeleteInfoReport deleteInfoReport = new DeleteInfoReport();
		deleteInfoReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "DB"));
		deleteInfoReport.setLoans(loans);
		deleteInfoReport.setBills(bills);
		deleteInfoReport.setCredits(credits);
		
		creatXmlFile(deleteInfoReport, xmlFileName);
	}



	/**
	 * 4.3.5环境/安全风险信息 报文
	 * 
	 * @param xmlFileName
	 */
	private void getEnvironmentInfoReport(String xmlFileName) {
		int count = queryEnvironmentInfoMapper.queryCustomerEnvironmentInfoCount();
		if(count>0){
			
			List<CustomerEnvironmentInfo> environmentInfoList = queryEnvironmentInfoMapper
					.queryCustomerEnvironmentInfo();
			CustomerEnvironmentReport cEnvironmentReport = new CustomerEnvironmentReport();
			cEnvironmentReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "BI"));
			cEnvironmentReport.setCustomerEnvironmentInfo(environmentInfoList);
			xmlFileName = xmlFileName.substring(0, 33) + "001" + ".xml";
			creatXmlFile(cEnvironmentReport, xmlFileName);
		}
		/*int count = queryEnvironmentInfoMapper.queryCustomerEnvironmentInfoCount();
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
		}*/
	}

	/**
	 * 绿色债券投资信息报文
	 * 
	 * @param zipFileName
	 */
	private void getBondReport(String xmlFileName) {
		int count = queryBondInfoMapper.queryBondInfoByPageCount();
		if(count>0){
			
			List<Bond> bondList = queryBondInfoMapper.queryBondInfo();
			BondReport bondReport = new BondReport();
			bondReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "BI"));
			bondReport.setBond(bondList);
			xmlFileName = xmlFileName.substring(0, 33) + "001" + ".xml";
			creatXmlFile(bondReport, xmlFileName);
		}
		/*int count = queryBondInfoMapper.queryBondInfoByPageCount();
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
		}*/
	}

	/**
	 * 4.3.3绿色银行承兑汇票信息 报文
	 * 
	 * @param zipFileName
	 */
	private void getCustomerBillReport(String xmlFileName) {
		int count = queryBillInfoMapper.queryCustomerBillInfoCount();
		if(count>0){
			
			List<CustomerBillInfo> customerBillInfoList = queryBillInfoMapper.queryCustomerBillInfo();
			CustomerBillReport customerBillReport = new CustomerBillReport();
			customerBillReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "AB"));
			customerBillReport.setCustomerBillInfo(customerBillInfoList);
			xmlFileName = xmlFileName.substring(0, 33) + "001" + ".xml";
			creatXmlFile(customerBillReport, xmlFileName);
		}
		/*int count = queryBillInfoMapper.queryCustomerBillInfoCount();
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
		}*/
	}

	/**
	 * 4.3.2绿色信用证信息 报文
	 * 
	 * @param zipFileName
	 */
	private void getCustomerCreditReport(String xmlFileName) {
		int count = queryCreditInfoMapper.queryCustomerCreditInfoCount();
		if(count>0){
			
			List<CustomerCreditInfo> customerCreditInfoList = queryCreditInfoMapper
					.queryCustomerCreditInfo();
			CustomerCreditReport customerLoanInfoReport = new CustomerCreditReport();
			customerLoanInfoReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "LC"));
			customerLoanInfoReport.setCustomerCreditInfo(customerCreditInfoList);
			xmlFileName = xmlFileName.substring(0, 33) + "001" + ".xml";
			creatXmlFile(customerLoanInfoReport, xmlFileName);
		}
		/*int count = queryCreditInfoMapper.queryCustomerCreditInfoCount();
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
		}*/
	}

	/**
	 * 4.3.1贷款信息 报文
	 * 
	 * @param zipFileName
	 */
	private void getCustomerLoanInfoReport(String xmlFileName) {
		int count = queryLoanInfoMapper.queryCustomerLoanInfoCount();
		if(count>0){
			
			List<CustomerLoanInfo> customerLoanInfoList = queryLoanInfoMapper.queryCustomerLoanInfo();
			CustomerLoanInfoReport customerLoanInfoReport = new CustomerLoanInfoReport();
			customerLoanInfoReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "LB"));
			customerLoanInfoReport.setCustomerLoanInfo(customerLoanInfoList);
			
			xmlFileName = xmlFileName.substring(0, 33) + "001" + ".xml";
			creatXmlFile(customerLoanInfoReport, xmlFileName);
		}
		
		/*int count = queryLoanInfoMapper.queryCustomerLoanInfoCount();
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
		}*/
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
		if(fileList.length>0){
			
			try {
				FileOutputStream fos;
				fos = new FileOutputStream(new File(zipPath + zipFileName));
				ZipUtils.toZip(fileList, fos);
				logger.info("---将xml打包zip成功---");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
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
		if(count>0){
			List<CustomerEnvironmentInfo> environmentInfoList = queryEnvironmentInfoMapper
					.queryDailyInfoByPage(null, dataDate);
			CustomerEnvironmentReport cEnvironmentReport = new CustomerEnvironmentReport();
			cEnvironmentReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "BI"));
			cEnvironmentReport.setCustomerEnvironmentInfo(environmentInfoList);
			creatXmlFile(cEnvironmentReport, xmlFileName);
		}
		/*int pageNum = (count - 1) / pageCount + 1;
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
		}*/
	}

	private void getBondReport(String xmlFileName, String dataDate) {
		int count = queryBondInfoMapper.queryDailyCount(dataDate);
		if(count>0){
			List<Bond> bondList = queryBondInfoMapper.queryDailyInfoByPage(null, dataDate);
			BondReport bondReport = new BondReport();
			bondReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "BI"));
			bondReport.setBond(bondList);
			creatXmlFile(bondReport, xmlFileName);
		}
		/*int pageNum = (count - 1) / pageCount + 1;
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
		}*/
	}

	private void getCustomerBillReport(String xmlFileName, String dataDate) {
		int count = queryBillInfoMapper.queryDailyCount(dataDate);
		if(count>0){
			List<CustomerBillInfo> customerBillInfoList = queryBillInfoMapper.queryDailyInfoByPage(null, dataDate);
			CustomerBillReport customerBillReport = new CustomerBillReport();
			customerBillReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "AB"));
			customerBillReport.setCustomerBillInfo(customerBillInfoList);
			creatXmlFile(customerBillReport, xmlFileName);
		}
		/*int pageNum = (count - 1) / pageCount + 1;
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
		}*/
	}

	private void getCustomerCreditReport(String xmlFileName, String dataDate) {
		int count = queryCreditInfoMapper.queryDailyCount(dataDate);
		if(count>0){
			List<CustomerCreditInfo> customerCreditInfoList = queryCreditInfoMapper.queryDailyInfoByPage(null,
					dataDate);
			CustomerCreditReport customerLoanInfoReport = new CustomerCreditReport();
			customerLoanInfoReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "LC"));
			customerLoanInfoReport.setCustomerCreditInfo(customerCreditInfoList);
			creatXmlFile(customerLoanInfoReport, xmlFileName);
		}
		
		/*int pageNum = (count - 1) / pageCount + 1;
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
		}*/
	}

	private void getCustomerLoanInfoReport(String xmlFileName, String dataDate) {
		int count = queryLoanInfoMapper.queryDailyCount(dataDate);
		if(count>0){
			List<CustomerLoanInfo> customerLoanInfoList = queryLoanInfoMapper.queryDailyInfoByPage(null, dataDate);
			CustomerLoanInfoReport customerLoanInfoReport = new CustomerLoanInfoReport();
			customerLoanInfoReport.setReportSummarys(new ReportSummarys(env.getProperty("reportBankCd"), "LB"));
			customerLoanInfoReport.setCustomerLoanInfo(customerLoanInfoList);

			creatXmlFile(customerLoanInfoReport, xmlFileName);
		}
		/*int pageNum = (count - 1) / pageCount + 1;
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
		}*/
	}

	@Override
	public void queryFormInfoToXml(String zipFileName,String formPeriod) {
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

		for (String BusinessType : formBusinessTypeArr) {
			queryFormInfoToXml(BusinessType, zipFileName,formPeriod);
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

	private void queryFormInfoToXml(String msgBusinessType, String zipFileName,String formPeriod) {
		try {
			xmlFileName = zipFileName.substring(0, 29) + "_" + msgBusinessType + ".xml";
			switch (msgBusinessType) {
			case "B001":// 绿色融资统计表报文
				getGreenFinanceReport(xmlFileName,formPeriod);
				break;
			case "B002":// 环境、安全等重大风险企业信贷情况统计表报文
				getRiskEnterpriseReport(xmlFileName,formPeriod);
				break;
			case "B003":// 银行机构绿色运营统计表报文
				getGreenOperateReport(xmlFileName,formPeriod);
				break;
			case "B004":// 银行机构区域融资情况统计表报文
				getAreaFinancingReport(xmlFileName,formPeriod);
				break;
			case "B005":// 银行机构绿色专营支行融资情况监测表报文
				getGreenSubBranchReport(xmlFileName,formPeriod);
				break;
			case "B006":// 银行机构绿色专营体系建设情况表报文
				getGreenBuildReport(xmlFileName,formPeriod);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getGreenBuildReport(String xmlFileName,String formPeriod) {
		GreenBuildReport GreenBuildReport = new GreenBuildReport();
		GreenBuild greenBuild = queryGreenBuildMapper.queryGreenBuild();
		GreenBuildReport.setGreenBuild(greenBuild);
		GreenBuildReport.setReportSummarys(new com.hzhx.greenFinance.vo.totalReport.ReportSummarys(env.getProperty("reportBankCd"),formPeriod,"B006"));
		creatXmlFile(GreenBuildReport, xmlFileName);
	}

	private void getGreenSubBranchReport(String xmlFileName,String formPeriod) {
		GreenSubBranchReport greenSubBranchReport = new GreenSubBranchReport();
		List<GreenSubBranch> greenSubBranchs = queryGreenSubBranchsMapper.queryGreenSubBranchs();
		greenSubBranchReport.setGreenSubBranchs(greenSubBranchs);
		greenSubBranchReport.setReportSummarys(new com.hzhx.greenFinance.vo.totalReport.ReportSummarys(env.getProperty("reportBankCd"),formPeriod,"B005"));
		creatXmlFile(greenSubBranchReport, xmlFileName);
	}

	private void getAreaFinancingReport(String xmlFileName,String formPeriod) {
		AreaFinancingReport areaFinancingReport = new AreaFinancingReport();
		List<AreaFinancings> areaFinancings = queryAreaFinancingMapper.queryAreaFinancings();
		areaFinancingReport.setAreaFinancings(areaFinancings);
		areaFinancingReport.setReportSummarys(new com.hzhx.greenFinance.vo.totalReport.ReportSummarys(env.getProperty("reportBankCd"),formPeriod,"B004"));
		creatXmlFile(areaFinancingReport, xmlFileName);
	}

	private void getGreenOperateReport(String xmlFileName,String formPeriod) {
		GreenOperateReport greenOperateReport = new GreenOperateReport();
		List<GreenOperates> greenOperates = queryGreenOperateMapper.queryGreenOperates();
		greenOperateReport.setGreenOperates(greenOperates);
		greenOperateReport.setReportSummarys(new com.hzhx.greenFinance.vo.totalReport.ReportSummarys(env.getProperty("reportBankCd"),formPeriod,"B003"));
		creatXmlFile(greenOperateReport, xmlFileName);
	}

	private void getRiskEnterpriseReport(String xmlFileName,String formPeriod) {
		RiskEnterpriseReport riskEnterpriseReport = new RiskEnterpriseReport();
		List<RiskEnterprises> riskEnterprises = queryRiskEnterpriseMapper.queryRiskEnterprises();
		riskEnterpriseReport.setRiskEnterprises(riskEnterprises);
		riskEnterpriseReport.setReportSummarys(new com.hzhx.greenFinance.vo.totalReport.ReportSummarys(env.getProperty("reportBankCd"),formPeriod,"B002"));
		creatXmlFile(riskEnterpriseReport, xmlFileName);
	}

	private void getGreenFinanceReport(String xmlFileName,String formPeriod) {
		GreenFinanceReport greenFinanceReport = new GreenFinanceReport();
		List<GreenFinances> greenFinances = queryGreenFinanceMapper.queryGreenFinances();
		greenFinanceReport.setGreenFinances(greenFinances);
		greenFinanceReport.setReportSummarys(new com.hzhx.greenFinance.vo.totalReport.ReportSummarys(env.getProperty("reportBankCd"),formPeriod,"B001"));
		creatXmlFile(greenFinanceReport, xmlFileName);
	}



	@Override
	public void queryDeleteInfoToXml(String zipFileName) {
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

		queryInfoToXml("DB", zipFileName);

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
}
