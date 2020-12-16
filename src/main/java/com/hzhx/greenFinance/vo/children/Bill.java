package com.hzhx.greenFinance.vo.children;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "bill")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "businessTypes", "billNo", "acceptanceNo", "businessOrg", "billAmount", "issueDate",
		"expiringDate", "paymentDate", "payingBankName", "payeeName", "payeeBankName", "fiveLevelCd",
		"guaranteeMethodCd", "marginLevel", "greenDecidedDate", "cbrcGreenClass", "isEnvironmentalInterest",
		"environmentalInterestCd" })
public class Bill {
	private BusinessType businessTypes;
	private String billNo;
	private String acceptanceNo;
	private String businessOrg;
	private BigDecimal billAmount;
	private String issueDate;
	private String expiringDate;
	private String paymentDate;
	private String payingBankName;
	private String payeeName;
	private String payeeBankName;
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

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getAcceptanceNo() {
		return acceptanceNo;
	}

	public void setAcceptanceNo(String acceptanceNo) {
		this.acceptanceNo = acceptanceNo;
	}

	public String getBusinessOrg() {
		return businessOrg;
	}

	public void setBusinessOrg(String businessOrg) {
		this.businessOrg = businessOrg;
	}

	public BigDecimal getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(String billAmount) {
		billAmount = StringUtils.isBlank(billAmount)?"0":billAmount.replace(",", "");
		this.billAmount = BigDecimal.valueOf(Double.valueOf(billAmount));
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

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPayingBankName() {
		return payingBankName;
	}

	public void setPayingBankName(String payingBankName) {
		this.payingBankName = payingBankName;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeeBankName() {
		return payeeBankName;
	}

	public void setPayeeBankName(String payeeBankName) {
		this.payeeBankName = payeeBankName;
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
		marginLevel = StringUtils.isBlank(marginLevel)?"0":marginLevel.replace(",", "");
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
