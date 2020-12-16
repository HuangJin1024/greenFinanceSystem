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
@XmlType(propOrder = { "reportSummarys", "enterprise", "personal", "project", "loan", "environment" })

/**
 * 人行数据报送报文
 * @author hzhx
 *
 */
public class SendReport {
	private ReportSummarys reportSummarys;

	@XmlElementWrapper(name = "enterprises")
	@XmlElement(name = "enterprise")
	private List<Enterprise> enterprise;

	@XmlElementWrapper(name = "personals")
	@XmlElement(name = "personal")
	private List<Personal> personal;

	@XmlElementWrapper(name = "projects")
	@XmlElement(name = "project")
	private List<Project> project;

	@XmlElementWrapper(name = "loans")
	@XmlElement(name = "loan")
	private List<Loan> loan;

	@XmlElementWrapper(name = "environments")
	@XmlElement(name = "environment")
	private List<Environment> environment;

	public ReportSummarys getReportSummarys() {
		return reportSummarys;
	}

	public void setReportSummarys(ReportSummarys reportSummarys) {
		this.reportSummarys = reportSummarys;
	}

	public List<Enterprise> getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(List<Enterprise> enterprise) {
		this.enterprise = enterprise;
	}

	public List<Personal> getPersonal() {
		return personal;
	}

	public void setPersonal(List<Personal> personal) {
		this.personal = personal;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public List<Loan> getLoan() {
		return loan;
	}

	public void setLoan(List<Loan> loan) {
		this.loan = loan;
	}

	public List<Environment> getEnvironment() {
		return environment;
	}

	public void setEnvironment(List<Environment> environment) {
		this.environment = environment;
	}

}
