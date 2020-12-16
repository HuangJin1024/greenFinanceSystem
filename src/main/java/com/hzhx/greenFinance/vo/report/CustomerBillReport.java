package com.hzhx.greenFinance.vo.report;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hzhx.greenFinance.vo.CustomerBillInfo;
import com.hzhx.greenFinance.vo.ReportSummarys;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GBRR")
@XmlType(propOrder = { "reportSummarys", "customerBillInfo"})
public class CustomerBillReport {
	private ReportSummarys reportSummarys;
	@XmlElementWrapper(name = "customers")
	@XmlElement(name="customer")
	private List<CustomerBillInfo> customerBillInfo;
	public ReportSummarys getReportSummarys() {
		return reportSummarys;
	}
	public void setReportSummarys(ReportSummarys reportSummarys) {
		this.reportSummarys = reportSummarys;
	}
	public List<CustomerBillInfo> getCustomerBillInfo() {
		return customerBillInfo;
	}
	public void setCustomerBillInfo(List<CustomerBillInfo> customerBillInfo) {
		this.customerBillInfo = customerBillInfo;
	}
	
}
