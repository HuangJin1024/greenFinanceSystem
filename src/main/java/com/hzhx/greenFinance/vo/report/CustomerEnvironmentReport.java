package com.hzhx.greenFinance.vo.report;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hzhx.greenFinance.vo.CustomerEnvironmentInfo;
import com.hzhx.greenFinance.vo.ReportSummarys;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GBRR")
@XmlType(propOrder = { "reportSummarys", "customerEnvironmentInfo"})
public class CustomerEnvironmentReport {
	private ReportSummarys reportSummarys;
	@XmlElementWrapper(name = "customers")
	@XmlElement(name="customer")
	private List<CustomerEnvironmentInfo> customerEnvironmentInfo;
	public ReportSummarys getReportSummarys() {
		return reportSummarys;
	}
	public void setReportSummarys(ReportSummarys reportSummarys) {
		this.reportSummarys = reportSummarys;
	}
	public List<CustomerEnvironmentInfo> getCustomerEnvironmentInfo() {
		return customerEnvironmentInfo;
	}
	public void setCustomerEnvironmentInfo(List<CustomerEnvironmentInfo> customerEnvironmentInfo) {
		this.customerEnvironmentInfo = customerEnvironmentInfo;
	}
	
}
