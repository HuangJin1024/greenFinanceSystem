package com.hzhx.greenFinance.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hzhx.greenFinance.vo.children.EnterpriseInfo;
import com.hzhx.greenFinance.vo.children.IndividualInfo;
import com.hzhx.greenFinance.vo.children.Loan;
import com.hzhx.greenFinance.vo.children.Project;

/**
 * 客户绿色贷款信息
 * 
 * @author hzhx
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
//XML文件中的根标识
@XmlRootElement(name = "customer")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "customerNo", "customerTypeCd", "individualInfo", "enterpriseInfo", "loan", "project" })
public class CustomerLoanInfo{  
	private String customerNo;
	private String customerTypeCd;
	private IndividualInfo individualInfo;
	private EnterpriseInfo enterpriseInfo;
	@XmlElementWrapper(name = "loans")
	private List<Loan> loan;
	@XmlElementWrapper(name = "projects")
	private List<Project> project;
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getCustomerTypeCd() {
		return customerTypeCd;
	}
	public void setCustomerTypeCd(String customerTypeCd) {
		this.customerTypeCd = customerTypeCd;
	}
	public IndividualInfo getIndividualInfo() {
		return individualInfo;
	}
	public void setIndividualInfo(IndividualInfo individualInfo) {
		this.individualInfo = individualInfo;
	}
	public EnterpriseInfo getEnterpriseInfo() {
		return enterpriseInfo;
	}
	public void setEnterpriseInfo(EnterpriseInfo enterpriseInfo) {
		this.enterpriseInfo = enterpriseInfo;
	}
	public List<Loan> getLoan() {
		return loan;
	}
	public void setLoan(List<Loan> loan) {
		this.loan = loan;
	}
	public List<Project> getProject() {
		return project;
	}
	public void setProject(List<Project> project) {
		this.project = project;
	}

}
