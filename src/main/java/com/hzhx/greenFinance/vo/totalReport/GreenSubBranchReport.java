package com.hzhx.greenFinance.vo.totalReport;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GBRR")
public class GreenSubBranchReport {
	private ReportSummarys reportSummarys;
	@XmlElementWrapper(name = "greenSubBranchs")
	@XmlElement(name="greenSubBranch")
	private List<GreenSubBranch> greenSubBranchs;

	public ReportSummarys getReportSummarys() {
		return reportSummarys;
	}

	public void setReportSummarys(ReportSummarys reportSummarys) {
		this.reportSummarys = reportSummarys;
	}

	public List<GreenSubBranch> getGreenSubBranchs() {
		return greenSubBranchs;
	}

	public void setGreenSubBranchs(List<GreenSubBranch> greenSubBranchs) {
		this.greenSubBranchs = greenSubBranchs;
	}

}
