package com.hzhx.greenFinance.vo.report;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hzhx.greenFinance.vo.CustomerCreditInfo;
import com.hzhx.greenFinance.vo.ReportSummarys;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GBRR")
@XmlType(propOrder = { "reportSummarys", "customerCreditInfo"})
public class CustomerCreditReport {
	private ReportSummarys reportSummarys;
	@XmlElementWrapper(name = "customers")
	@XmlElement(name="customer")
	private List<CustomerCreditInfo> customerCreditInfo;
	public ReportSummarys getReportSummarys() {
		return reportSummarys;
	}
	public void setReportSummarys(ReportSummarys reportSummarys) {
		this.reportSummarys = reportSummarys;
	}
	public List<CustomerCreditInfo> getCustomerCreditInfo() {
		return customerCreditInfo;
	}
	public void setCustomerCreditInfo(List<CustomerCreditInfo> customerCreditInfo) {
		this.customerCreditInfo = customerCreditInfo;
	}
	
}
