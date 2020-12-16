package com.hzhx.greenFinance.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
//XML文件中的根标识
@XmlRootElement(name = "reportSummarys")
//控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "reportBankCd", "reportDataType"})
public class ReportSummarys {
	private String reportBankCd;
	private String reportDataType;
	
	public ReportSummarys(String reportBankCd, String reportDataType) {
		super();
		this.reportBankCd = reportBankCd;
		this.reportDataType = reportDataType;
	}
	public ReportSummarys() {
		super();
	}
	public String getReportBankCd() {
		return reportBankCd;
	}
	public void setReportBankCd(String reportBankCd) {
		this.reportBankCd = reportBankCd;
	}
	public String getReportDataType() {
		return reportDataType;
	}
	public void setReportDataType(String reportDataType) {
		this.reportDataType = reportDataType;
	}
	
}
