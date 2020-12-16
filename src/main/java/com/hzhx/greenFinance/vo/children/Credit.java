package com.hzhx.greenFinance.vo.children;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

@XmlAccessorType(XmlAccessType.FIELD)
//XML文件中的根标识
@XmlRootElement(name = "credit")
//控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {   
    "businessTypes",   
    "letterCreditNo",   
    "contractNo",   
    "businessOrg",   
    "letterCreditAmount",   
    "letterCreditBalance",   
    "issueDate",   
    "expiringDate",   
    "closeDate",   
    "revocationDate",   
    "termTypeCd",   
    "fiveLevelCd",   
    "guaranteeMethodCd",   
    "marginLevel",   
    "greenDecidedDate",   
    "cbrcGreenClass",   
    "isEnvironmentalInterest",   
    "environmentalInterestCd"
}) 
public class Credit {
	private BusinessType businessTypes;
	private String letterCreditNo;
	private String contractNo;
	private String businessOrg;
	private BigDecimal letterCreditAmount;
	private BigDecimal letterCreditBalance;
	private String issueDate;
	private String expiringDate;
	private String closeDate;
	private String revocationDate;
	private String termTypeCd;
	private String fiveLevelCd;
	private String guaranteeMethodCd;
	private BigDecimal marginLevel;
	private String greenDecidedDate;
	private String cbrcGreenClass;
	private String isEnvironmentalInterest;
	private String environmentalInterestCd;
	public BusinessType getBusinessType() {
		return businessTypes;
	}
	public void setBusinessType(BusinessType businessTypes) {
		this.businessTypes = businessTypes;
	}
	public String getLetterCreditNo() {
		return letterCreditNo;
	}
	public void setLetterCreditNo(String letterCreditNo) {
		this.letterCreditNo = letterCreditNo;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getBusinessOrg() {
		return businessOrg;
	}
	public void setBusinessOrg(String businessOrg) {
		this.businessOrg = businessOrg;
	}
	public BigDecimal getLetterCreditAmount() {
		return letterCreditAmount;
	}
	public void setLetterCreditAmount(String letterCreditAmount) {
		letterCreditAmount = StringUtils.isBlank(letterCreditAmount)?"0":letterCreditAmount.replace(",","");
		this.letterCreditAmount = BigDecimal.valueOf(Double.valueOf(letterCreditAmount));
	}
	public BigDecimal getLetterCreditBalance() {
		return letterCreditBalance;
	}
	public void setLetterCreditBalance(String letterCreditBalance) {
		letterCreditBalance = StringUtils.isBlank(letterCreditBalance)?"0":letterCreditBalance.replace(",","");
		this.letterCreditBalance = BigDecimal.valueOf(Double.valueOf(letterCreditBalance));
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getExpiringDate() {
		return expiringDate;
	}
	public void setExpiringDate(String expiringDate) {
		this.expiringDate = expiringDate;
	}
	public String getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	public String getRevocationDate() {
		return revocationDate;
	}
	public void setRevocationDate(String revocationDate) {
		this.revocationDate = revocationDate;
	}
	public String getTermTypeCd() {
		return termTypeCd;
	}
	public void setTermTypeCd(String termTypeCd) {
		this.termTypeCd = termTypeCd;
	}
	public String getFiveLevelCd() {
		return fiveLevelCd;
	}
	public void setFiveLevelCd(String fiveLevelCd) {
		this.fiveLevelCd = fiveLevelCd;
	}
	public String getGuaranteeMethodCd() {
		return guaranteeMethodCd;
	}
	public void setGuaranteeMethodCd(String guaranteeMethodCd) {
		this.guaranteeMethodCd = guaranteeMethodCd;
	}
	public BigDecimal getMarginLevel() {
		return marginLevel;
	}
	public void setMarginLevel(String marginLevel) {
		marginLevel = StringUtils.isBlank(marginLevel)?"0":marginLevel.replace(",","");
		this.marginLevel = BigDecimal.valueOf(Double.valueOf(marginLevel));
	}
	public String getGreenDecidedDate() {
		return greenDecidedDate;
	}
	public void setGreenDecidedDate(String greenDecidedDate) {
		this.greenDecidedDate = greenDecidedDate;
	}
	public String getCbrcGreenClass() {
		return cbrcGreenClass;
	}
	public void setCbrcGreenClass(String cbrcGreenClass) {
		this.cbrcGreenClass = cbrcGreenClass;
	}
	public String getIsEnvironmentalInterest() {
		return isEnvironmentalInterest;
	}
	public void setIsEnvironmentalInterest(String isEnvironmentalInterest) {
		this.isEnvironmentalInterest = isEnvironmentalInterest;
	}
	public String getEnvironmentalInterestCd() {
		return environmentalInterestCd;
	}
	public void setEnvironmentalInterestCd(String environmentalInterestCd) {
		this.environmentalInterestCd = environmentalInterestCd;
	}
	
}
