package com.hzhx.greenFinance.renHangVo;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang.StringUtils;

@XmlAccessorType(XmlAccessType.FIELD)
public class LoanCl {
	private String loanNo;
	private String businessOrgCd;
	private String contractNo;
	private String loanTypeCd;
	private String loanProduct;
	private String loanTermTypeCd;
	private String loanPurposeCd;
	private BigDecimal loanAmount;
	private BigDecimal loanBalance;
	private Integer timeLimit;
	private String guaranteeTypeCd;
	private BigDecimal interestRate;
	private String repaymentMethodCd;
	private String loanDate;
	private String expiringDate;
	private String loanState;
	private String latestRepaydate;
	private String overdueDate;
	private BigDecimal overBalance;
	private String fiveCategoryCd;
	private String fiveCategoryChgDate;

	public String getLoanNo() {
		return loanNo;
	}

	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}

	public String getBusinessOrgCd() {
		return businessOrgCd;
	}

	public void setBusinessOrgCd(String businessOrgCd) {
		this.businessOrgCd = businessOrgCd;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getLoanTypeCd() {
		return loanTypeCd;
	}

	public void setLoanTypeCd(String loanTypeCd) {
		this.loanTypeCd = loanTypeCd;
	}

	public String getLoanProduct() {
		return loanProduct;
	}

	public void setLoanProduct(String loanProduct) {
		this.loanProduct = loanProduct;
	}

	public String getLoanTermTypeCd() {
		return loanTermTypeCd;
	}

	public void setLoanTermTypeCd(String loanTermTypeCd) {
		this.loanTermTypeCd = loanTermTypeCd;
	}

	public String getLoanPurposeCd() {
		return loanPurposeCd;
	}

	public void setLoanPurposeCd(String loanPurposeCd) {
		this.loanPurposeCd = loanPurposeCd;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		loanAmount = StringUtils.isBlank(loanAmount) ? "0" : loanAmount.replace(",", "");
		this.loanAmount = BigDecimal.valueOf(Double.valueOf(loanAmount));
	}

	public BigDecimal getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(String loanBalance) {
		loanBalance = StringUtils.isBlank(loanBalance) ? "0" : loanBalance.replace(",", "");
		this.loanBalance = BigDecimal.valueOf(Double.valueOf(loanBalance));
	}

	public Integer getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getGuaranteeTypeCd() {
		return guaranteeTypeCd;
	}

	public void setGuaranteeTypeCd(String guaranteeTypeCd) {
		this.guaranteeTypeCd = guaranteeTypeCd;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		interestRate = StringUtils.isBlank(interestRate) ? "0" : interestRate.replace(",", "");
		this.interestRate = BigDecimal.valueOf(Double.valueOf(interestRate));
	}

	public String getRepaymentMethodCd() {
		return repaymentMethodCd;
	}

	public void setRepaymentMethodCd(String repaymentMethodCd) {
		this.repaymentMethodCd = repaymentMethodCd;
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

	public String getLoanState() {
		return loanState;
	}

	public void setLoanState(String loanState) {
		this.loanState = loanState;
	}

	public String getLatestRepaydate() {
		return latestRepaydate;
	}

	public void setLatestRepaydate(String latestRepaydate) {
		this.latestRepaydate = latestRepaydate;
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
		overBalance = StringUtils.isBlank(overBalance) ? "0" : overBalance.replace(",", "");
		this.overBalance = BigDecimal.valueOf(Double.valueOf(overBalance));
	}

	public String getFiveCategoryCd() {
		return fiveCategoryCd;
	}

	public void setFiveCategoryCd(String fiveCategoryCd) {
		this.fiveCategoryCd = fiveCategoryCd;
	}

	public String getFiveCategoryChgDate() {
		return fiveCategoryChgDate;
	}

	public void setFiveCategoryChgDate(String fiveCategoryChgDate) {
		this.fiveCategoryChgDate = fiveCategoryChgDate;
	}

}
