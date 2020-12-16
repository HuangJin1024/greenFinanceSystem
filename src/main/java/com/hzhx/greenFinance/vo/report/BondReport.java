package com.hzhx.greenFinance.vo.report;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hzhx.greenFinance.vo.ReportSummarys;
import com.hzhx.greenFinance.vo.children.Bond;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GBRR")
@XmlType(propOrder = { "reportSummarys", "bond"})
public class BondReport {
	private ReportSummarys reportSummarys;
	@XmlElementWrapper(name = "bonds")
	@XmlElement(name="customer")
	private List<Bond> bond;
	public ReportSummarys getReportSummarys() {
		return reportSummarys;
	}
	public void setReportSummarys(ReportSummarys reportSummarys) {
		this.reportSummarys = reportSummarys;
	}
	public List<Bond> getBond() {
		return bond;
	}
	public void setBond(List<Bond> bond) {
		this.bond = bond;
	}
	
}
