package com.hzhx.greenFinance.renHangVo;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
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
@XmlType(propOrder = { "reportSceneType", "contractNo", "loanNo", "customerTypeCd", "customerNo", "projectNo",
		"loanKindCd", "loanProduct", "loanTypeCd", "cnapsCode", "loanPurpose", "loanAmount", "loanBalance",
		"overBalance", "timeLimit", "timeLimitUnit", "loanDate", "expiringDate", "overdueDate", "fiveLevelChgDate",
		"guaranteeMethodCd", "interestRate", "repaymentMethod", "latestRepaydate", "fiveLevelCd", "greenDecidedDate",
		"pbcGreenClass", "cbrcGreenClass", "otherGreenDecidedStdNm", "otherGreenClass", "isAccordWithCreditPolicy",
		"pledgeReloanState", "pledgeReloanChgDate", "pledgeExpiringDate" })
public class Loan {
	@XmlElementWrapper(name = "reportSceneTypes")
	private List<ReportSceneType> reportSceneType;
	private String contractNo;
	private String loanNo;
	private String customerTypeCd;
	private String customerNo;
	private String projectNo;
	private String loanKindCd;
	private String loanProduct;
	private String loanTypeCd;
	private String cnapsCode;
	private String loanPurpose;
	private BigDecimal loanAmount;
	private BigDecimal loanBalance;
	private BigDecimal overBalance;
	private Integer timeLimit;
	private String timeLimitUnit;
	private String loanDate;
	private String expiringDate;
	private String overdueDate;
	private String fiveLevelChgDate;
	private String guaranteeMethodCd;
	private BigDecimal interestRate;
	private String repaymentMethod;
	private String latestRepaydate;
	private String fiveLevelCd;
	private String greenDecidedDate;
	private String pbcGreenClass;
	private String cbrcGreenClass;
	private String otherGreenDecidedStdNm;
	private String otherGreenClass;
	private String isAccordWithCreditPolicy;
	private String pledgeReloanState;
	private String pledgeReloanChgDate;
	private String pledgeExpiringDate;

	public List<ReportSceneType> getReportSceneType() {
		return reportSceneType;
	}

	public void setReportSceneType(List<ReportSceneType> reportSceneType) {
		this.reportSceneType = reportSceneType;
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

	public String getCustomerTypeCd() {
		return customerTypeCd;
	}

	public void setCustomerTypeCd(String customerTypeCd) {
		this.customerTypeCd = customerTypeCd;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		if (StringUtils.isBlank(projectNo)) {
			this.projectNo = null;
		} else {
			this.projectNo = projectNo;
		}
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

	public String getLoanTypeCd() {
		return loanTypeCd;
	}

	public void setLoanTypeCd(String loanTypeCd) {
		this.loanTypeCd = loanTypeCd;
	}

	public String getCnapsCode() {
		return cnapsCode;
	}

	public void setCnapsCode(String cnapsCode) {
		this.cnapsCode = cnapsCode;
	}

	public String getLoanPurpose() {
		return loanPurpose;
	}

	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
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

	public BigDecimal getOverBalance() {
		return overBalance;
	}

	public void setOverBalance(String overBalance) {
		overBalance = StringUtils.isBlank(overBalance) ? "0" : overBalance.replace(",", "");
		this.overBalance = BigDecimal.valueOf(Double.valueOf(overBalance));
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
		if (StringUtils.isBlank(timeLimit)) {
			this.timeLimit = null;
		} else {
			timeLimit = timeLimit.replace(",", "");
			this.timeLimit = Integer.valueOf(timeLimit);
		}
	}

	public String getTimeLimitUnit() {
		return timeLimitUnit;
	}

	public void setTimeLimitUnit(String timeLimitUnit) {
		this.timeLimitUnit = timeLimitUnit;
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

	public String getFiveLevelChgDate() {
		return fiveLevelChgDate;
	}

	public void setFiveLevelChgDate(String fiveLevelChgDate) {
		this.fiveLevelChgDate = fiveLevelChgDate;
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
		interestRate = StringUtils.isBlank(interestRate) ? "0" : interestRate.replace(",", "");
		this.interestRate = BigDecimal.valueOf(Double.valueOf(interestRate));
	}

	public String getRepaymentMethod() {
		return repaymentMethod;
	}

	public void setRepaymentMethod(String repaymentMethod) {
		this.repaymentMethod = repaymentMethod;
	}

	public String getLatestRepaydate() {
		return latestRepaydate;
	}

	public void setLatestRepaydate(String latestRepaydate) {
		this.latestRepaydate = latestRepaydate;
	}

	public String getFiveLevelCd() {
		return fiveLevelCd;
	}

	public void setFiveLevelCd(String fiveLevelCd) {
		this.fiveLevelCd = fiveLevelCd;
	}

	public String getGreenDecidedDate() {
		return greenDecidedDate;
	}

	public void setGreenDecidedDate(String greenDecidedDate) {
		this.greenDecidedDate = greenDecidedDate;
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

	public String getIsAccordWithCreditPolicy() {
		return isAccordWithCreditPolicy;
	}

	public void setIsAccordWithCreditPolicy(String isAccordWithCreditPolicy) {
		this.isAccordWithCreditPolicy = isAccordWithCreditPolicy;
	}

	public String getPledgeReloanState() {
		return pledgeReloanState;
	}

	public void setPledgeReloanState(String pledgeReloanState) {
		this.pledgeReloanState = pledgeReloanState;
	}

	public String getPledgeReloanChgDate() {
		return pledgeReloanChgDate;
	}

	public void setPledgeReloanChgDate(String pledgeReloanChgDate) {
		this.pledgeReloanChgDate = pledgeReloanChgDate;
	}

	public String getPledgeExpiringDate() {
		return pledgeExpiringDate;
	}

	public void setPledgeExpiringDate(String pledgeExpiringDate) {
		this.pledgeExpiringDate = pledgeExpiringDate;
	}
}
