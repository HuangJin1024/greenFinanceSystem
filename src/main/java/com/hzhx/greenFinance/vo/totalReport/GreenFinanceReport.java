package com.hzhx.greenFinance.vo.totalReport;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GBRR")
public class GreenFinanceReport {
	private ReportSummarys reportSummarys;
	private List<GreenFinances> greenFinances;
	
	public ReportSummarys getReportSummarys() {
		return reportSummarys;
	}

	public void setReportSummarys(ReportSummarys reportSummarys) {
		this.reportSummarys = reportSummarys;
	}

	public List<GreenFinances> getGreenFinances() {
		return greenFinances;
	}

	public void setGreenFinances(List<GreenFinances> greenFinances) {
		this.greenFinances = greenFinances;
	}


}
