package com.hzhx.greenFinance.vo.totalReport;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GBRR")
public class AreaFinancingReport {
	private ReportSummarys reportSummarys;
	private List<AreaFinancings> areaFinancings;

	public ReportSummarys getReportSummarys() {
		return reportSummarys;
	}

	public void setReportSummarys(ReportSummarys reportSummarys) {
		this.reportSummarys = reportSummarys;
	}

	public List<AreaFinancings> getAreaFinancings() {
		return areaFinancings;
	}

	public void setAreaFinancings(List<AreaFinancings> areaFinancings) {
		this.areaFinancings = areaFinancings;
	}

}
