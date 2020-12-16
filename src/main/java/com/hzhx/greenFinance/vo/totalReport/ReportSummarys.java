package com.hzhx.greenFinance.vo.totalReport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ReportSummarys {
	private String reportBankCd;
	private String formPeriod;
	private String formNo;

	
	
	public ReportSummarys(String reportBankCd, String formPeriod, String formNo) {
		super();
		this.reportBankCd = reportBankCd;
		this.formPeriod = formPeriod;
		this.formNo = formNo;
	}

	public String getReportBankCd() {
		return reportBankCd;
	}

	public void setReportBankCd(String reportBankCd) {
		this.reportBankCd = reportBankCd;
	}

	public String getFormPeriod() {
		return formPeriod;
	}

	public void setFormPeriod(String formPeriod) {
		this.formPeriod = formPeriod;
	}

	public String getFormNo() {
		return formNo;
	}

	public void setFormNo(String formNo) {
		this.formNo = formNo;
	}

}
