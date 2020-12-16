package com.hzhx.greenFinance.renHangVo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GFIR")
@XmlType(propOrder = { "reportSummarys", "loanNoList", "involvedReasonNoList" })

/**
 * 人行数据删除报文
 * 
 * @author hzhx
 *
 */
public class DeleteReport {
	private ReportSummarys reportSummarys;

	@XmlElementWrapper(name = "loans")
	@XmlElement(name = "loan")
	private List<Loan> loanNoList;

	@XmlElementWrapper(name = "environments")
	@XmlElement(name = "environment")
	private List<String> involvedReasonNoList;

	public ReportSummarys getReportSummarys() {
		return reportSummarys;
	}

	public void setReportSummarys(ReportSummarys reportSummarys) {
		this.reportSummarys = reportSummarys;
	}

	public List<Loan> getLoanNoList() {
		return loanNoList;
	}

	public void setLoanNoList(List<Loan> loanNoList) {
		this.loanNoList = loanNoList;
	}

	public List<String> getInvolvedReasonNoList() {
		return involvedReasonNoList;
	}

	public void setInvolvedReasonNoList(List<String> involvedReasonNoList) {
		this.involvedReasonNoList = involvedReasonNoList;
	}
	
	
}
