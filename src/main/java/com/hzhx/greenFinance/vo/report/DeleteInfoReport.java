package com.hzhx.greenFinance.vo.report;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.hzhx.greenFinance.vo.ReportSummarys;
import com.hzhx.greenFinance.vo.children.Bill;
import com.hzhx.greenFinance.vo.children.Bond;
import com.hzhx.greenFinance.vo.children.Credit;
import com.hzhx.greenFinance.vo.children.Environment;
import com.hzhx.greenFinance.vo.children.Loan;
import com.hzhx.greenFinance.vo.children.Project;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GBRR")
public class DeleteInfoReport {
	private ReportSummarys reportSummarys;

	@XmlElementWrapper(name = "loans")
	@XmlElement(name = "loan")
	private List<Loan> loans;

	@XmlElementWrapper(name = "environments")
	@XmlElement(name = "environment")
	private List<Environment> environments;

	@XmlElementWrapper(name = "bonds")
	@XmlElement(name = "bond")
	private List<Bond> bonds;

	@XmlElementWrapper(name = "credits")
	@XmlElement(name = "credit")
	private List<Credit> credits;
	
	@XmlElementWrapper(name = "bills")
	@XmlElement(name = "bill")
	private List<Bill> bills;

	@XmlElementWrapper(name = "projects")
	@XmlElement(name = "project")
	private List<Project> projects;

	public ReportSummarys getReportSummarys() {
		return reportSummarys;
	}

	public void setReportSummarys(ReportSummarys reportSummarys) {
		this.reportSummarys = reportSummarys;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public List<Environment> getEnvironments() {
		return environments;
	}

	public void setEnvironments(List<Environment> environments) {
		this.environments = environments;
	}

	public List<Bond> getBonds() {
		return bonds;
	}

	public void setBonds(List<Bond> bonds) {
		this.bonds = bonds;
	}

	public List<Credit> getCredits() {
		return credits;
	}

	public void setCredits(List<Credit> credits) {
		this.credits = credits;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
