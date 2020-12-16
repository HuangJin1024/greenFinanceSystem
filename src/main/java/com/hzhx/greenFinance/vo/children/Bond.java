package com.hzhx.greenFinance.vo.children;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "bond")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "businessTypes", "tradeNo", "businessOrg", "bondTypeCd", "bondCode", "bondName", "parValue",
		"couponRate", "issueDate", "expiringDate", "repaymentMethodCd", "timeLimit", "creditRating",
		"creditRatingAgency", "issuerName", "issuerCountryCd", "issuerIndustryCd", "bondIndustryCd", "fiveLevelCd",
		"tradeValueDate", "remainingParValue", "defaultAmount", "businessBalance", "greenDecidedDate", "cbrcGreenClass",
		"isEnvironmentalInterest", "environmentalInterestCd", "isConstructionBond" })
public class Bond {
	private BusinessType businessTypes;
	private String tradeNo;
	private String businessOrg;
	private String bondTypeCd;
	private String bondCode;
	private String bondName;
	private BigDecimal parValue;
	private BigDecimal couponRate;
	private String issueDate;
	private String expiringDate;
	private String repaymentMethodCd;
	private int timeLimit;
	private String creditRating;
	private String creditRatingAgency;
	private String issuerName;
	private String issuerCountryCd;
	private String issuerIndustryCd;
	private String bondIndustryCd;
	private String fiveLevelCd;
	private String tradeValueDate;
	private BigDecimal remainingParValue;
	private BigDecimal defaultAmount;
	private BigDecimal businessBalance;
	private String greenDecidedDate;
	private String cbrcGreenClass;
	private String isEnvironmentalInterest;
	private String environmentalInterestCd;
	private String isConstructionBond;
	public BusinessType getBusinessType() {
		return businessTypes;
	}
	public void setBusinessType(BusinessType businessTypes) {
		this.businessTypes = businessTypes;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getBusinessOrg() {
		return businessOrg;
	}
	public void setBusinessOrg(String businessOrg) {
		this.businessOrg = businessOrg;
	}
	public String getBondTypeCd() {
		return bondTypeCd;
	}
	public void setBondTypeCd(String bondTypeCd) {
		this.bondTypeCd = bondTypeCd;
	}
	public String getBondCode() {
		return bondCode;
	}
	public void setBondCode(String bondCode) {
		this.bondCode = bondCode;
	}
	public String getBondName() {
		return bondName;
	}
	public void setBondName(String bondName) {
		this.bondName = bondName;
	}
	public BigDecimal getParValue() {
		return parValue;
	}
	public void setParValue(String parValue) {
		parValue = StringUtils.isBlank(parValue)?"0":parValue.replace(",", "");
		this.parValue = BigDecimal.valueOf(Double.valueOf(parValue));
	}
	public BigDecimal getCouponRate() {
		return couponRate;
	}
	public void setCouponRate(String couponRate) {
		couponRate = StringUtils.isBlank(couponRate)?"0":couponRate.replace(",", "");
		this.couponRate = BigDecimal.valueOf(Double.valueOf(couponRate));
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
	public String getRepaymentMethodCd() {
		return repaymentMethodCd;
	}
	public void setRepaymentMethodCd(String repaymentMethodCd) {
		this.repaymentMethodCd = repaymentMethodCd;
	}
	public int getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(String timeLimit) {
		timeLimit = StringUtils.isBlank(timeLimit)?"0":timeLimit.replace(",", "");
		this.timeLimit = Integer.valueOf(timeLimit);
	}
	public String getCreditRating() {
		return creditRating;
	}
	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}
	public String getCreditRatingAgency() {
		return creditRatingAgency;
	}
	public void setCreditRatingAgency(String creditRatingAgency) {
		this.creditRatingAgency = creditRatingAgency;
	}
	public String getIssuerName() {
		return issuerName;
	}
	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}
	public String getIssuerCountryCd() {
		return issuerCountryCd;
	}
	public void setIssuerCountryCd(String issuerCountryCd) {
		this.issuerCountryCd = issuerCountryCd;
	}
	public String getIssuerIndustryCd() {
		return issuerIndustryCd;
	}
	public void setIssuerIndustryCd(String issuerIndustryCd) {
		this.issuerIndustryCd = issuerIndustryCd;
	}
	public String getBondIndustryCd() {
		return bondIndustryCd;
	}
	public void setBondIndustryCd(String bondIndustryCd) {
		this.bondIndustryCd = bondIndustryCd;
	}
	public String getFiveLevelCd() {
		return fiveLevelCd;
	}
	public void setFiveLevelCd(String fiveLevelCd) {
		this.fiveLevelCd = fiveLevelCd;
	}
	public String getTradeValueDate() {
		return tradeValueDate;
	}
	public void setTradeValueDate(String tradeValueDate) {
		this.tradeValueDate = tradeValueDate;
	}
	public BigDecimal getRemainingParValue() {
		return remainingParValue;
	}
	public void setRemainingParValue(String remainingParValue) {
		remainingParValue = StringUtils.isBlank(remainingParValue)?"0":remainingParValue.replace(",", "");
		this.remainingParValue = BigDecimal.valueOf(Double.valueOf(remainingParValue));
	}
	public BigDecimal getDefaultAmount() {
		return defaultAmount;
	}
	public void setDefaultAmount(String defaultAmount) {
		defaultAmount = StringUtils.isBlank(defaultAmount)?"0":defaultAmount.replace(",", "");
		this.defaultAmount = BigDecimal.valueOf(Double.valueOf(defaultAmount));
	}
	public BigDecimal getBusinessBalance() {
		return businessBalance;
	}
	public void setBusinessBalance(String businessBalance) {
		businessBalance = StringUtils.isBlank(businessBalance)?"0":businessBalance.replace(",", "");
		this.businessBalance = BigDecimal.valueOf(Double.valueOf(businessBalance));
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
	public String getIsConstructionBond() {
		return isConstructionBond;
	}
	public void setIsConstructionBond(String isConstructionBond) {
		this.isConstructionBond = isConstructionBond;
	}
	
	
}
