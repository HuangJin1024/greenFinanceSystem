package com.hzhx.greenFinance.vo.children;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "project")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "projectNo", "projectCode", "projectName", "projectIndustryCd", "totalInvestAmount",
		"capitalSourceCd", "projectLocationCd", "projectAddress", "projectContent", "cbrcGreenClass",
		"pbcGreenClass", "localGreenClass", "environmentBenefit" })
public class Project {
	private String projectNo;
	private String projectCode;
	private String projectName;
	private String projectIndustryCd;
	private BigDecimal totalInvestAmount;
	private String capitalSourceCd;
	private String projectLocationCd;
	private String projectAddress;
	private String projectContent;
	private String cbrcGreenClass;
	private String pbcGreenClass;
	private String localGreenClass;
	private EnvironmentBenefit environmentBenefit;
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectIndustryCd() {
		return projectIndustryCd;
	}
	public void setProjectIndustryCd(String projectIndustryCd) {
		this.projectIndustryCd = projectIndustryCd;
	}
	public BigDecimal getTotalInvestAmount() {
		return totalInvestAmount;
	}
	public void setTotalInvestAmount(String totalInvestAmount) {
		totalInvestAmount = StringUtils.isBlank(totalInvestAmount)?"0":totalInvestAmount.replace(",","");
		BigDecimal temp = BigDecimal.valueOf(Double.valueOf(totalInvestAmount));
		this.totalInvestAmount = temp.setScale(2,BigDecimal.ROUND_HALF_UP);
	}
	public String getCapitalSourceCd() {
		return capitalSourceCd;
	}
	public void setCapitalSourceCd(String capitalSourceCd) {
		this.capitalSourceCd = capitalSourceCd;
	}
	public String getProjectLocationCd() {
		return projectLocationCd;
	}
	public void setProjectLocationCd(String projectLocationCd) {
		this.projectLocationCd = projectLocationCd;
	}
	public String getProjectAddress() {
		return projectAddress;
	}
	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}
	public String getProjectContent() {
		return projectContent;
	}
	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}
	public String getCbrcGreenClass() {
		return cbrcGreenClass;
	}
	public void setCbrcGreenClass(String cbrcGreenClass) {
		this.cbrcGreenClass = cbrcGreenClass;
	}
	public String getPbcGreenClass() {
		return pbcGreenClass;
	}
	public void setPbcGreenClass(String pbcGreenClass) {
		this.pbcGreenClass = pbcGreenClass;
	}
	public String getLocalGreenClass() {
		return localGreenClass;
	}
	public void setLocalGreenClass(String localGreenClass) {
		this.localGreenClass = localGreenClass;
	}
	public EnvironmentBenefit getEnvironmentBenefit() {
		return environmentBenefit;
	}
	public void setEnvironmentBenefit(EnvironmentBenefit environmentBenefit) {
		this.environmentBenefit = environmentBenefit;
	}

}
