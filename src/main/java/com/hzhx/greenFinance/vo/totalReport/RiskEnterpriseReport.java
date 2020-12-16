package com.hzhx.greenFinance.vo.totalReport;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GBRR")
public class RiskEnterpriseReport {
	private ReportSummarys reportSummarys;
	private List<RiskEnterprises> riskEnterprises;

	public ReportSummarys getReportSummarys() {
		return reportSummarys;
	}

	public void setReportSummarys(ReportSummarys reportSummarys) {
		this.reportSummarys = reportSummarys;
	}

	public List<RiskEnterprises> getRiskEnterprises() {
		return riskEnterprises;
	}

	public void setRiskEnterprises(List<RiskEnterprises> riskEnterprises) {
		this.riskEnterprises = riskEnterprises;
	}

}
