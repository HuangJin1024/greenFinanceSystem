package com.hzhx.greenFinance.vo.report;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hzhx.greenFinance.vo.CustomerLoanInfo;
import com.hzhx.greenFinance.vo.ReportSummarys;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GBRR")
@XmlType(propOrder = { "reportSummarys", "customerLoanInfo"})
/**
 * 4.3.1贷款信息
 * @author hzhx
 *
 */
public class CustomerLoanInfoReport {
	private ReportSummarys reportSummarys;
	@XmlElementWrapper(name = "customers")
	@XmlElement(name="customer")
	private List<CustomerLoanInfo> customerLoanInfo;
	public ReportSummarys getReportSummarys() {
		return reportSummarys;
	}
	public void setReportSummarys(ReportSummarys reportSummarys) {
		this.reportSummarys = reportSummarys;
	}
	public List<CustomerLoanInfo> getCustomerLoanInfo() {
		return customerLoanInfo;
	}
	public void setCustomerLoanInfo(List<CustomerLoanInfo> customerLoanInfo) {
		this.customerLoanInfo = customerLoanInfo;
	}

	
}
