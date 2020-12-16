package com.hzhx.greenFinance.renHangVo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ReportSummaryCl {

	private String reportBank;
	private String dataDate;
	private Integer customerNumber;

	public String getReportBank() {
		return reportBank;
	}

	public void setReportBank(String reportBank) {
		this.reportBank = reportBank;
	}

	public String getDataDate() {
		return dataDate;
	}

	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}

	public Integer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}


}
