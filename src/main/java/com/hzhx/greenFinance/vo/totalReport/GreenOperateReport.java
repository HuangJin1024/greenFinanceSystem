package com.hzhx.greenFinance.vo.totalReport;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GBRR")
public class GreenOperateReport {
	private ReportSummarys reportSummarys;
	private List<GreenOperates> greenOperates;

	public ReportSummarys getReportSummarys() {
		return reportSummarys;
	}

	public void setReportSummarys(ReportSummarys reportSummarys) {
		this.reportSummarys = reportSummarys;
	}

	public List<GreenOperates> getGreenOperates() {
		return greenOperates;
	}

	public void setGreenOperates(List<GreenOperates> greenOperates) {
		this.greenOperates = greenOperates;
	}


}
