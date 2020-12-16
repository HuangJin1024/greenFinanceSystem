package com.hzhx.greenFinance.vo.children;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

@XmlAccessorType(XmlAccessType.FIELD)
//XML文件中的根标识
@XmlRootElement(name = "enterpriseInfo")
//控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {   
      "enterpriseName",   
      "unifiedSocialCreditCd",   
      "legalPerson",   
      "registeredAmount",   
      "registeredAreaCd",   
      "industryCd",   
      "ownershipTypeCd",   
      "scaleTypeCd",   
      "businessScope",   
      "majorBusiness",   
      "unifiedCreditFlag",   
      "creditLimit"
}) 
public class EnterpriseInfo {
	private String enterpriseName;
	private String unifiedSocialCreditCd;
	private String legalPerson;
	private BigDecimal registeredAmount;
	private String registeredAreaCd;
	private String industryCd;
	private String ownershipTypeCd;
	private String scaleTypeCd;
	private String businessScope;
	private String majorBusiness;
	private String unifiedCreditFlag;
	private BigDecimal creditLimit;
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
	public String getRegisteredAreaCd() {
		return registeredAreaCd;
	}
	public void setRegisteredAreaCd(String registeredAreaCd) {
		this.registeredAreaCd = registeredAreaCd;
	}
	public String getIndustryCd() {
		return industryCd;
	}
	public void setIndustryCd(String industryCd) {
		this.industryCd = industryCd;
	}
	public String getOwnershipTypeCd() {
		return ownershipTypeCd;
	}
	public void setOwnershipTypeCd(String ownershipTypeCd) {
		this.ownershipTypeCd = ownershipTypeCd;
	}
	public String getScaleTypeCd() {
		return scaleTypeCd;
	}
	public void setScaleTypeCd(String scaleTypeCd) {
		this.scaleTypeCd = scaleTypeCd;
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
	public String getUnifiedCreditFlag() {
		return unifiedCreditFlag;
	}
	public void setUnifiedCreditFlag(String unifiedCreditFlag) {
		this.unifiedCreditFlag = unifiedCreditFlag;
	}
	public BigDecimal getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(String creditLimit) {
		creditLimit = StringUtils.isBlank(creditLimit)?"0":creditLimit.replace(",","");
		this.creditLimit = BigDecimal.valueOf(Double.valueOf(creditLimit));
	}
	
}
