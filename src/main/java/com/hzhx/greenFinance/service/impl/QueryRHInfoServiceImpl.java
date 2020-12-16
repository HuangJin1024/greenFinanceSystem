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
import com.hzhx.greenFinance.dao.QueryRHInfoMapper;
import com.hzhx.greenFinance.renHangVo.DeleteReport;
import com.hzhx.greenFinance.renHangVo.Enterprise;
import com.hzhx.greenFinance.renHangVo.Loan;
import com.hzhx.greenFinance.renHangVo.Personal;
import com.hzhx.greenFinance.renHangVo.Project;
import com.hzhx.greenFinance.renHangVo.ReportSummary;
import com.hzhx.greenFinance.renHangVo.ReportSummarys;
import com.hzhx.greenFinance.renHangVo.SendReport;
import com.hzhx.greenFinance.service.QueryRHInfoService;

@Service
public class QueryRHInfoServiceImpl implements QueryRHInfoService {
	private static Logger logger = LoggerFactory.getLogger(QueryRHInfoServiceImpl.class);

	private String xmlFileName;
	private File dir;
	private static int pageCount = 1000;

	@Autowired
	private Environment env;
	@Autowired
	private QueryRHInfoMapper queryRHInfoMapper;

	@Override
	public void queryAllInfoToXml(String zipFileName) {
		createDir();

		xmlFileName = zipFileName.substring(0, 28) + "_001" + ".xml";
		getSendReport(xmlFileName);

		String xmlPath = env.getProperty("renhangFilePath") + "xml_temp";
		String zipPath = env.getProperty("renhangFilePath");

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
	public void queryDeleteInfoToXml(String zipFileName) {
		createDir();

		xmlFileName = zipFileName.substring(0, 28) + "_001" + ".xml";
		getDeleteReport(xmlFileName);

		String xmlPath = env.getProperty("renhangFilePath") + "xml_temp";
		String zipPath = env.getProperty("renhangFilePath");

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


	/**
	 * 人行数据报文
	 * 
	 * @param zipFileName
	 */
	private void getSendReport(String xmlFileName) {
		SendReport sendReport = new SendReport();
		
		List<ReportSummary> sumList = queryRHInfoMapper.queryReportSummaryList();
		ReportSummarys rs = new ReportSummarys();
		rs.setReportSummarys(sumList);
		rs.setReportBankCd(env.getProperty("reportBankCd_RH"));
		
		List<Enterprise> eList = queryRHInfoMapper.queryEnterpriseList();
		List<Personal> pList = queryRHInfoMapper.queryPersonalList();
		List<Project> pjList = queryRHInfoMapper.queryProjectList();
		List<Loan> lList = queryRHInfoMapper.queryLoanList();
		List<com.hzhx.greenFinance.renHangVo.Environment> evList = queryRHInfoMapper.queryEnvironmentList();
		
		sendReport.setReportSummarys(rs);
		if(eList.size()>0){
			sendReport.setEnterprise(eList);
		}
		if(pList.size()>0){
			sendReport.setPersonal(pList);
		}
		if(pjList.size()>0){
			sendReport.setProject(pjList);
		}
		if(lList.size()>0){
			sendReport.setLoan(lList);
		}
		if(evList.size()>0){
			sendReport.setEnvironment(evList);
		}
		creatXmlFile(sendReport, xmlFileName);
	}

	/**
	 * 人行删除数据报文
	 * 
	 * @param xmlFileName
	 */
	private void getDeleteReport(String xmlFileName) {
		DeleteReport deleteReport = new DeleteReport();
		
		List<ReportSummary> sumList = queryRHInfoMapper.queryDeleteSummaryList();
		ReportSummarys rs = new ReportSummarys();
		rs.setReportSummarys(sumList);
		rs.setReportBankCd(env.getProperty("reportBankCd_RH"));
		
		List<Loan> loanNoList = queryRHInfoMapper.getSendedLoanNoList();
		//List<String> involvedReasonNoList = queryRHInfoMapper.getSendedInvolvedReasonNoList();
		
		deleteReport.setReportSummarys(rs);
		deleteReport .setLoanNoList(loanNoList);
		//deleteReport .setInvolvedReasonNoList(involvedReasonNoList);
		creatXmlFile(deleteReport, xmlFileName);
	}

	/**
	 * 生成xml文件
	 * @param obj
	 * @param xmlFileName
	 */
	private void creatXmlFile(Object obj, String xmlFileName) {

		// xml路径
		String xmlPath = dir.getPath() + File.separator + xmlFileName;
		logger.info("---将对象转换成File类型的xml Start---");
		XMLUtil.convertToXml(obj, xmlPath);
		logger.info("---将对象转换成File类型的xml End---");
	}

	/**
	 * 创建临时目录
	 */
	private void createDir() {
		// 临时文件夹
		dir = new File(env.getProperty("renhangFilePath") + File.separator + "xml_temp");
		if (dir.exists()) {
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				files[i].getAbsoluteFile().delete();
			}
		} else {
			dir.mkdir();
		}
	}
}
