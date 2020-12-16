package com.hzhx.greenFinance.renHangVo;

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
@XmlType(propOrder = { "projectNo", "projectCode", "projectName", "enterpriseNo", "projectIndustryCd",
		"totalInvestAmt", "capitalSourceCd", "address", "projectContent", "pbcGreenClass", "cbrcGreenClass",
		"otherGreenDecidedStdNm", "otherGreenClass", "greenDecidedStandardName", "greenClass" })
public class Project {
	private String projectNo;
	private String projectCode;
	private String projectName;
	private String enterpriseNo;
	private String projectIndustryCd;
	private BigDecimal totalInvestAmt;
	private String capitalSourceCd;
	private String address;
	private String projectContent;
	private String pbcGreenClass;
	private String cbrcGreenClass;
	private String otherGreenDecidedStdNm;
	private String otherGreenClass;
	private String greenDecidedStandardName;
	private String greenClass;
	//private EnvironmentBenefit environmentBenefit;
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
	public String getEnterpriseNo() {
		return enterpriseNo;
	}
	public void setEnterpriseNo(String enterpriseNo) {
		this.enterpriseNo = enterpriseNo;
	}
	public String getProjectIndustryCd() {
		return projectIndustryCd;
	}
	public void setProjectIndustryCd(String projectIndustryCd) {
		this.projectIndustryCd = projectIndustryCd;
	}
	public BigDecimal getTotalInvestAmt() {
		return totalInvestAmt;
	}
	public void setTotalInvestAmt(String totalInvestAmt) {
		totalInvestAmt = StringUtils.isBlank(totalInvestAmt)?"0":totalInvestAmt.replace(",","");
		BigDecimal temp = BigDecimal.valueOf(Double.valueOf(totalInvestAmt));
		this.totalInvestAmt = temp.setScale(2,BigDecimal.ROUND_HALF_UP);
	}
	public String getCapitalSourceCd() {
		return capitalSourceCd;
	}
	public void setCapitalSourceCd(String capitalSourceCd) {
		this.capitalSourceCd = capitalSourceCd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProjectContent() {
		return projectContent;
	}
	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}
	public String getPbcGreenClass() {
		return pbcGreenClass;
	}
	public void setPbcGreenClass(String pbcGreenClass) {
		this.pbcGreenClass = pbcGreenClass;
	}
	public String getCbrcGreenClass() {
		return cbrcGreenClass;
	}
	public void setCbrcGreenClass(String cbrcGreenClass) {
		this.cbrcGreenClass = cbrcGreenClass;
	}
	public String getOtherGreenDecidedStdNm() {
		return otherGreenDecidedStdNm;
	}
	public void setOtherGreenDecidedStdNm(String otherGreenDecidedStdNm) {
		this.otherGreenDecidedStdNm = otherGreenDecidedStdNm;
	}
	public String getOtherGreenClass() {
		return otherGreenClass;
	}
	public void setOtherGreenClass(String otherGreenClass) {
		this.otherGreenClass = otherGreenClass;
	}
	public String getGreenDecidedStandardName() {
		return greenDecidedStandardName;
	}
	public void setGreenDecidedStandardName(String greenDecidedStandardName) {
		this.greenDecidedStandardName = greenDecidedStandardName;
	}
	public String getGreenClass() {
		return greenClass;
	}
	public void setGreenClass(String greenClass) {
		this.greenClass = greenClass;
	}
	/*public EnvironmentBenefit getEnvironmentBenefit() {
		return environmentBenefit;
	}
	public void setEnvironmentBenefit(EnvironmentBenefit environmentBenefit) {
		this.environmentBenefit = environmentBenefit;
	}*/

}
