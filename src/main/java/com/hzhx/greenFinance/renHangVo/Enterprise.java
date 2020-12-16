package com.hzhx.greenFinance.renHangVo;


import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;


@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "enterprise")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "enterpriseNo", "enterpriseName", "unifiedSocialCreditCd", "legalPerson", "registeredAmount",
		"areaCd", "industryCd", "companyTypeCd", "companySizeCd", "businessScope", "majorBusiness",
		"greenDecidedStandardName", "greenClass" })
public class Enterprise {
	private String enterpriseNo;
	private String enterpriseName;
	private String unifiedSocialCreditCd;
	private String legalPerson;
	private BigDecimal registeredAmount;
	private String areaCd;
	private String industryCd;
	private String companyTypeCd;
	private String companySizeCd;
	private String businessScope;
	private String majorBusiness;
	private String greenDecidedStandardName;
	private String greenClass;
	public String getEnterpriseNo() {
		return enterpriseNo;
	}
	public void setEnterpriseNo(String enterpriseNo) {
		this.enterpriseNo = enterpriseNo;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public String getUnifiedSocialCreditCd() {
		return unifiedSocialCreditCd;
	}
	public void setUnifiedSocialCreditCd(String unifiedSocialCreditCd) {
		this.unifiedSocialCreditCd = unifiedSocialCreditCd;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	public BigDecimal getRegisteredAmount() {
		return registeredAmount;
	}
	public void setRegisteredAmount(String registeredAmount) {
		registeredAmount = StringUtils.isBlank(registeredAmount)?"0":registeredAmount.replace(",","");
		this.registeredAmount = BigDecimal.valueOf(Double.valueOf(registeredAmount));
	}
	public String getAreaCd() {
		return areaCd;
	}
	public void setAreaCd(String areaCd) {
		this.areaCd = areaCd;
	}
	public String getIndustryCd() {
		return industryCd;
	}
	public void setIndustryCd(String industryCd) {
		this.industryCd = industryCd;
	}
	public String getCompanyTypeCd() {
		return companyTypeCd;
	}
	public void setCompanyTypeCd(String companyTypeCd) {
		this.companyTypeCd = companyTypeCd;
	}
	public String getCompanySizeCd() {
		return companySizeCd;
	}
	public void setCompanySizeCd(String companySizeCd) {
		this.companySizeCd = companySizeCd;
	}
	public String getBusinessScope() {
		return businessScope;
	}
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	public String getMajorBusiness() {
		return majorBusiness;
	}
	public void setMajorBusiness(String majorBusiness) {
		this.majorBusiness = majorBusiness;
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
	
}
