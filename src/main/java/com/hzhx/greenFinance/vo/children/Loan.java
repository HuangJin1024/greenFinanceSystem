package com.hzhx.greenFinance.vo.children;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

/**
 * 贷款信息
 * 
 * @author hzhx
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "loan")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "businessTypes", "contractNo", "loanNo", "projectNo", "loanKindCd", "loanProduct", "businessOrg",
		"loanPurposeDesc", "loanAmount", "loanBalance", "timeLimit", "loanDate", "expiringDate", "overdueDate",
		"overBalance", "guaranteeMethodCd", "interestRate", "repaymentMethodCd", "latestRepayDate", "fiveLevelCd", "industryCd",
		"isGreen", "greenDecidedDate", "cbrcGreenClass", "pbcGreenClass", "localGreenClass", "isEnvironmentalInterest",
		"environmentalInterestCd" })
public class Loan {
	private BusinessType businessTypes;
	private String contractNo;
	private String loanNo;
	private String projectNo;
	private String loanKindCd;
	private String loanProduct;
	private String businessOrg;
	private String loanPurposeDesc;
	private BigDecimal loanAmount;
	private BigDecimal loanBalance;
	private Integer timeLimit;
	private String loanDate;
	private String expiringDate;
	private String overdueDate;
	private BigDecimal overBalance;
	private String guaranteeMethodCd;
	private BigDecimal interestRate;
	private String repaymentMethodCd;
	private String latestRepayDate;
	private String fiveLevelCd;
	private String industryCd;
	private String isGreen;
	private String greenDecidedDate;
	private String cbrcGreenClass;
	private String pbcGreenClass;
	private String localGreenClass;
	private String isEnvironmentalInterest;
	private String environmentalInterestCd;

	public BusinessType getBusinessTypes() {
		return businessTypes;
	}

	public void setBusinessTypes(BusinessType businessTypes) {
		this.businessTypes = businessTypes;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getLoanNo() {
		return loanNo;
	}

	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getLoanKindCd() {
		return loanKindCd;
	}

	public void setLoanKindCd(String loanKindCd) {
		this.loanKindCd = loanKindCd;
	}

	public String getLoanProduct() {
		return loanProduct;
	}

	public void setLoanProduct(String loanProduct) {
		this.loanProduct = loanProduct;
	}

	public String getBusinessOrg() {
		return businessOrg;
	}

	public void setBusinessOrg(String businessOrg) {
		this.businessOrg = businessOrg;
	}

	public String getLoanPurposeDesc() {
		return loanPurposeDesc;
	}

	public void setLoanPurposeDesc(String loanPurposeDesc) {
		this.loanPurposeDesc = loanPurposeDesc;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		loanAmount = StringUtils.isBlank(loanAmount)?"0":loanAmount.replace(",","");
		this.loanAmount = BigDecimal.valueOf(Double.valueOf(loanAmount));
	}

	public BigDecimal getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(String loanBalance) {
		loanBalance = StringUtils.isBlank(loanBalance)?"0":loanBalance.replace(",","");
		this.loanBalance = BigDecimal.valueOf(Double.valueOf(loanBalance));
	}

	public Integer getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
		timeLimit = StringUtils.isBlank(timeLimit)?null:timeLimit.replace(",","");
		this.timeLimit = Integer.valueOf(timeLimit);
	}

	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public String getExpiringDate() {
		return expiringDate;
	}

	public void setExpiringDate(String expiringDate) {
		this.expiringDate = expiringDate;
	}

	public String getOverdueDate() {
		return overdueDate;
	}

	public void setOverdueDate(String overdueDate) {
		this.overdueDate = overdueDate;
	}

	public BigDecimal getOverBalance() {
		return overBalance;
	}

	public void setOverBalance(String overBalance) {
		overBalance = StringUtils.isBlank(overBalance)?"0":overBalance.replace(",","");
		this.overBalance = BigDecimal.valueOf(Double.valueOf(overBalance));
	}

	public String getGuaranteeMethodCd() {
		return guaranteeMethodCd;
	}

	public void setGuaranteeMethodCd(String guaranteeMethodCd) {
		this.guaranteeMethodCd = guaranteeMethodCd;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		interestRate = StringUtils.isBlank(interestRate)?"0":interestRate.replace(",","");
		this.interestRate = BigDecimal.valueOf(Double.valueOf(interestRate));
	}

	public String getRepaymentMethodCd() {
		return repaymentMethodCd;
	}

	public void setRepaymentMethodCd(String repaymentMethodCd) {
		this.repaymentMethodCd = repaymentMethodCd;
	}

	public String getLatestRepayDate() {
		return latestRepayDate;
	}

	public void setLatestRepayDate(String latestRepayDate) {
		this.latestRepayDate = latestRepayDate;
	}

	public String getFiveLevelCd() {
		return fiveLevelCd;
	}

	public void setFiveLevelCd(String fiveLevelCd) {
		this.fiveLevelCd = fiveLevelCd;
	}

	public String getIndustryCd() {
		return industryCd;
	}

	public void setIndustryCd(String industryCd) {
		this.industryCd = industryCd;
	}

	public String getIsGreen() {
		return isGreen;
	}

	public void setIsGreen(String isGreen) {
		this.isGreen = isGreen;
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
