package com.hzhx.greenFinance.vo.totalReport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GBRR")
public class GreenBuildReport {
	private ReportSummarys reportSummarys;
	private GreenBuild greenBuild;

	public ReportSummarys getReportSummarys() {
		return reportSummarys;
	}

	public void setReportSummarys(ReportSummarys reportSummarys) {
		this.reportSummarys = reportSummarys;
	}

	public GreenBuild getGreenBuild() {
		return greenBuild;
	}

	public void setGreenBuild(GreenBuild greenBuild) {
		this.greenBuild = greenBuild;
	}

}
