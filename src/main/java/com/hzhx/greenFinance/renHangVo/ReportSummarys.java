package com.hzhx.greenFinance.renHangVo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
//XML文件中的根标识
@XmlRootElement(name = "reportSummarys")
//控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "reportBankCd","reportSummarys"})
public class ReportSummarys {
	private String reportBankCd;
	//@XmlElementWrapper(name = "reportSummarys")
	@XmlElement(name = "reportSummary")
	private List<ReportSummary> reportSummarys;
	public String getReportBankCd() {
		return reportBankCd;
	}
	public void setReportBankCd(String reportBankCd) {
		this.reportBankCd = reportBankCd;
	}
	public List<ReportSummary> getReportSummarys() {
		return reportSummarys;
	}
	public void setReportSummarys(List<ReportSummary> reportSummarys) {
		this.reportSummarys = reportSummarys;
	}
}
