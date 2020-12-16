package com.hzhx.greenFinance.renHangVo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MCIR")
public class CustomersLoansReport {
	private ReportSummaryCl reportSummary;
	
	@XmlElementWrapper(name = "customers")
	@XmlElement(name = "customer")
	private List<Customer> Customers;

	public ReportSummaryCl getReportSummary() {
		return reportSummary;
	}

	public void setReportSummary(ReportSummaryCl reportSummary) {
		this.reportSummary = reportSummary;
	}

	public List<Customer> getCustomers() {
		return Customers;
	}

	public void setCustomers(List<Customer> customers) {
		Customers = customers;
	}

}

