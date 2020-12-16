package com.hzhx.greenFinance.renHangVo;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import org.apache.commons.lang.StringUtils;

@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
	private String customerNo;
	private String customerName;
	private String unifiedSocialCreditCd;
	private String legalPerson;
	private BigDecimal registeredAmount;
	private String registeredAreaCd;
	private String foundedDate;
	private String businessScope;
	private String majorBusiness;
	private String industryCd;
	private String companyTypeCd;
	private String companySizeCd;
	private Integer employeeNumber;
	private BigDecimal operatingIncome;
	private BigDecimal totalAssets;
	@XmlElementWrapper(name = "shareholders")
	@XmlElement(name = "shareholder")
	private List<Shareholder> shareholders;
	private String basicDepositBankFlag;
	private String basicDepositAccount;
	private String basicDepositBankName;
	private String basicDepositBankCd;
	private CustomerCredit customerCredit;
	@XmlElementWrapper(name = "loans")
	@XmlElement(name = "loan")
	private List<LoanCl> loans;

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
		registeredAmount = StringUtils.isBlank(registeredAmount) ? "0" : registeredAmount.replace(",", "");
		this.registeredAmount = BigDecimal.valueOf(Double.valueOf(registeredAmount));
	}

	public String getRegisteredAreaCd() {
		return registeredAreaCd;
	}

	public void setRegisteredAreaCd(String registeredAreaCd) {
		this.registeredAreaCd = registeredAreaCd;
	}

	public String getFoundedDate() {
		return foundedDate;
	}

	public void setFoundedDate(String foundedDate) {
		this.foundedDate = foundedDate;
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

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public BigDecimal getOperatingIncome() {
		return operatingIncome;
	}

	public void setOperatingIncome(String operatingIncome) {
		operatingIncome = StringUtils.isBlank(operatingIncome) ? "0" : operatingIncome.replace(",", "");
		this.operatingIncome = BigDecimal.valueOf(Double.valueOf(operatingIncome));
	}

	public BigDecimal getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(String totalAssets) {
		totalAssets = StringUtils.isBlank(totalAssets) ? "0" : totalAssets.replace(",", "");
		this.totalAssets = BigDecimal.valueOf(Double.valueOf(totalAssets));
	}

	public List<Shareholder> getShareholders() {
		return shareholders;
	}

	public void setShareholders(List<Shareholder> shareholders) {
		this.shareholders = shareholders;
	}

	public String getBasicDepositBankFlag() {
		return basicDepositBankFlag;
	}

	public void setBasicDepositBankFlag(String basicDepositBankFlag) {
		this.basicDepositBankFlag = basicDepositBankFlag;
	}

	public String getBasicDepositAccount() {
		return basicDepositAccount;
	}

	public void setBasicDepositAccount(String basicDepositAccount) {
		this.basicDepositAccount = basicDepositAccount;
	}

	public String getBasicDepositBankName() {
		return basicDepositBankName;
	}

	public void setBasicDepositBankName(String basicDepositBankName) {
		this.basicDepositBankName = basicDepositBankName;
	}

	public String getBasicDepositBankCd() {
		return basicDepositBankCd;
	}

	public void setBasicDepositBankCd(String basicDepositBankCd) {
		this.basicDepositBankCd = basicDepositBankCd;
	}

	public CustomerCredit getCustomerCredit() {
		return customerCredit;
	}

	public void setCustomerCredit(CustomerCredit customerCredit) {
		this.customerCredit = customerCredit;
	}

	public List<LoanCl> getLoans() {
		return loans;
	}

	public void setLoans(List<LoanCl> loans) {
		this.loans = loans;
	}

}

