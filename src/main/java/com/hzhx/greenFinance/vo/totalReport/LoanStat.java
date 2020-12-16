package com.hzhx.greenFinance.vo.totalReport;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang.StringUtils;

@XmlAccessorType(XmlAccessType.FIELD)
public class LoanStat {
	private String customerTypeCd;
	private BigDecimal cbrcGreenBalance;
	private BigDecimal cbrcBalanceIncrease;
	private Integer cbrcCustomerNum;
	private Integer cbrcCustomerIncrease;
	private BigDecimal cbrcGreenBalanceRate;
	private BigDecimal localGreenBalance;
	private BigDecimal localBalanceIncrease;
	private Integer localCustomerNum;
	private Integer localCustomerIncrease;
	private BigDecimal localGreenBalanceRate;
	private BigDecimal totalBalance;
	private BigDecimal totalBalanceIncrease;
	private Integer totalCustomerNum;
	private Integer totalCustomerIncrease;
	private BigDecimal greenOnBalance;
	private BigDecimal greenOnBalanceIncrease;
	private Integer greenOnCustomerNum;
	private Integer greenOnCustomerIncrease;
	private BigDecimal totalOnBalance;
	private BigDecimal totalOnBalanceIncrease;
	private Integer totalOnCustomerNum;
	private Integer totalOnCustomerIncrease;
	private BigDecimal greenOffBalance;
	private BigDecimal greenOffBalanceIncrease;
	private Integer greenOffCustomerNum;
	private Integer greenOffCustomerIncrease;
	private BigDecimal totalOffBalance;
	private BigDecimal totalOffBalanceIncrease;
	private Integer totalOffCustomerNum;
	private Integer totalOffCustomerIncrease;

	public String getCustomerTypeCd() {
		return customerTypeCd;
	}

	public void setCustomerTypeCd(String customerTypeCd) {
		this.customerTypeCd = customerTypeCd;
	}

	public BigDecimal getCbrcGreenBalance() {
		return cbrcGreenBalance;
	}

	public void setCbrcGreenBalance(String cbrcGreenBalance) {
		cbrcGreenBalance = StringUtils.isBlank(cbrcGreenBalance) ? "0" : cbrcGreenBalance.replace(",", "");
		this.cbrcGreenBalance = BigDecimal.valueOf(Double.valueOf(cbrcGreenBalance));
	}

	public BigDecimal getCbrcBalanceIncrease() {
		return cbrcBalanceIncrease;
	}

	public void setCbrcBalanceIncrease(String cbrcBalanceIncrease) {
		cbrcBalanceIncrease = StringUtils.isBlank(cbrcBalanceIncrease) ? "0" : cbrcBalanceIncrease.replace(",", "");
		this.cbrcBalanceIncrease = BigDecimal.valueOf(Double.valueOf(cbrcBalanceIncrease));
	}

	public Integer getCbrcCustomerNum() {
		return cbrcCustomerNum;
	}

	public void setCbrcCustomerNum(String cbrcCustomerNum) {
		cbrcCustomerNum = StringUtils.isBlank(cbrcCustomerNum) ? "0" : cbrcCustomerNum.replace(",", "");
		this.cbrcCustomerNum = Integer.valueOf(cbrcCustomerNum);
	}

	public Integer getCbrcCustomerIncrease() {
		return cbrcCustomerIncrease;
	}

	public void setCbrcCustomerIncrease(String cbrcCustomerIncrease) {
		cbrcCustomerIncrease = StringUtils.isBlank(cbrcCustomerIncrease) ? "0" : cbrcCustomerIncrease.replace(",", "");
		this.cbrcCustomerIncrease = Integer.valueOf(cbrcCustomerIncrease);
	}

	public BigDecimal getCbrcGreenBalanceRate() {
		return cbrcGreenBalanceRate;
	}

	public void setCbrcGreenBalanceRate(String cbrcGreenBalanceRate) {
		cbrcGreenBalanceRate = StringUtils.isBlank(cbrcGreenBalanceRate) ? "0" : cbrcGreenBalanceRate.replace(",", "");
		this.cbrcGreenBalanceRate = BigDecimal.valueOf(Double.valueOf(cbrcGreenBalanceRate));
	}

	public BigDecimal getLocalGreenBalance() {
		return localGreenBalance;
	}

	public void setLocalGreenBalance(String localGreenBalance) {
		localGreenBalance = StringUtils.isBlank(localGreenBalance) ? "0" : localGreenBalance.replace(",", "");
		this.localGreenBalance = BigDecimal.valueOf(Double.valueOf(localGreenBalance));
	}

	public BigDecimal getLocalBalanceIncrease() {
		return localBalanceIncrease;
	}

	public void setLocalBalanceIncrease(String localBalanceIncrease) {
		localBalanceIncrease = StringUtils.isBlank(localBalanceIncrease) ? "0" : localBalanceIncrease.replace(",", "");
		this.localBalanceIncrease = BigDecimal.valueOf(Double.valueOf(localBalanceIncrease));
	}

	public Integer getLocalCustomerNum() {
		return localCustomerNum;
	}

	public void setLocalCustomerNum(String localCustomerNum) {
		localCustomerNum = StringUtils.isBlank(localCustomerNum) ? "0" : localCustomerNum.replace(",", "");
		this.localCustomerNum = Integer.valueOf(localCustomerNum);
	}

	public Integer getLocalCustomerIncrease() {
		return localCustomerIncrease;
	}

	public void setLocalCustomerIncrease(String localCustomerIncrease) {
		localCustomerIncrease = StringUtils.isBlank(localCustomerIncrease) ? "0" : localCustomerIncrease.replace(",", "");
		this.localCustomerIncrease = Integer.valueOf(localCustomerIncrease);
	}

	public BigDecimal getLocalGreenBalanceRate() {
		return localGreenBalanceRate;
	}

	public void setLocalGreenBalanceRate(String localGreenBalanceRate) {
		localGreenBalanceRate = StringUtils.isBlank(localGreenBalanceRate) ? "0" : localGreenBalanceRate.replace(",", "");
		this.localGreenBalanceRate = BigDecimal.valueOf(Double.valueOf(localGreenBalanceRate));
	}

	public BigDecimal getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(String totalBalance) {
		totalBalance = StringUtils.isBlank(totalBalance) ? "0" : totalBalance.replace(",", "");
		this.totalBalance = BigDecimal.valueOf(Double.valueOf(totalBalance));
	}

	public BigDecimal getTotalBalanceIncrease() {
		return totalBalanceIncrease;
	}

	public void setTotalBalanceIncrease(String totalBalanceIncrease) {
		totalBalanceIncrease = StringUtils.isBlank(totalBalanceIncrease) ? "0" : totalBalanceIncrease.replace(",", "");
		this.totalBalanceIncrease = BigDecimal.valueOf(Double.valueOf(totalBalanceIncrease));
	}

	public Integer getTotalCustomerNum() {
		return totalCustomerNum;
	}

	public void setTotalCustomerNum(String totalCustomerNum) {
		totalCustomerNum = StringUtils.isBlank(totalCustomerNum) ? "0" : totalCustomerNum.replace(",", "");
		this.totalCustomerNum = Integer.valueOf(totalCustomerNum);
	}

	public Integer getTotalCustomerIncrease() {
		return totalCustomerIncrease;
	}

	public void setTotalCustomerIncrease(String totalCustomerIncrease) {
		totalCustomerIncrease = StringUtils.isBlank(totalCustomerIncrease) ? "0" : totalCustomerIncrease.replace(",", "");
		this.totalCustomerIncrease = Integer.valueOf(totalCustomerIncrease);
	}

	public BigDecimal getGreenOnBalance() {
		return greenOnBalance;
	}

	public void setGreenOnBalance(String greenOnBalance) {
		greenOnBalance = StringUtils.isBlank(greenOnBalance) ? "0" : greenOnBalance.replace(",", "");
		this.greenOnBalance = BigDecimal.valueOf(Double.valueOf(greenOnBalance));
	}

	public BigDecimal getGreenOnBalanceIncrease() {
		return greenOnBalanceIncrease;
	}

	public void setGreenOnBalanceIncrease(String greenOnBalanceIncrease) {
		greenOnBalanceIncrease = StringUtils.isBlank(greenOnBalanceIncrease) ? "0" : greenOnBalanceIncrease.replace(",", "");
		this.greenOnBalanceIncrease = BigDecimal.valueOf(Double.valueOf(greenOnBalanceIncrease));
	}

	public Integer getGreenOnCustomerNum() {
		return greenOnCustomerNum;
	}

	public void setGreenOnCustomerNum(String greenOnCustomerNum) {
		greenOnCustomerNum = StringUtils.isBlank(greenOnCustomerNum) ? "0" : greenOnCustomerNum.replace(",", "");
		this.greenOnCustomerNum = Integer.valueOf(greenOnCustomerNum);
	}

	public Integer getGreenOnCustomerIncrease() {
		return greenOnCustomerIncrease;
	}

	public void setGreenOnCustomerIncrease(String greenOnCustomerIncrease) {
		greenOnCustomerIncrease = StringUtils.isBlank(greenOnCustomerIncrease) ? "0" : greenOnCustomerIncrease.replace(",", "");
		this.greenOnCustomerIncrease = Integer.valueOf(greenOnCustomerIncrease);
	}

	public BigDecimal getTotalOnBalance() {
		return totalOnBalance;
	}

	public void setTotalOnBalance(String totalOnBalance) {
		totalOnBalance = StringUtils.isBlank(totalOnBalance) ? "0" : totalOnBalance.replace(",", "");
		this.totalOnBalance = BigDecimal.valueOf(Double.valueOf(totalOnBalance));
	}

	public BigDecimal getTotalOnBalanceIncrease() {
		return totalOnBalanceIncrease;
	}

	public void setTotalOnBalanceIncrease(String totalOnBalanceIncrease) {
		totalOnBalanceIncrease = StringUtils.isBlank(totalOnBalanceIncrease) ? "0" : totalOnBalanceIncrease.replace(",", "");
		this.totalOnBalanceIncrease = BigDecimal.valueOf(Double.valueOf(totalOnBalanceIncrease));
	}

	public Integer getTotalOnCustomerNum() {
		return totalOnCustomerNum;
	}

	public void setTotalOnCustomerNum(String totalOnCustomerNum) {
		totalOnCustomerNum = StringUtils.isBlank(totalOnCustomerNum) ? "0" : totalOnCustomerNum.replace(",", "");
		this.totalOnCustomerNum = Integer.valueOf(totalOnCustomerNum);
	}

	public Integer getTotalOnCustomerIncrease() {
		return totalOnCustomerIncrease;
	}

	public void setTotalOnCustomerIncrease(String totalOnCustomerIncrease) {
		totalOnCustomerIncrease = StringUtils.isBlank(totalOnCustomerIncrease) ? "0" : totalOnCustomerIncrease.replace(",", "");
		this.totalOnCustomerIncrease = Integer.valueOf(totalOnCustomerIncrease);
	}

	public BigDecimal getGreenOffBalance() {
		return greenOffBalance;
	}

	public void setGreenOffBalance(String greenOffBalance) {
		greenOffBalance = StringUtils.isBlank(greenOffBalance) ? "0" : greenOffBalance.replace(",", "");
		this.greenOffBalance = BigDecimal.valueOf(Double.valueOf(greenOffBalance));
	}

	public BigDecimal getGreenOffBalanceIncrease() {
		return greenOffBalanceIncrease;
	}

	public void setGreenOffBalanceIncrease(String greenOffBalanceIncrease) {
		greenOffBalanceIncrease = StringUtils.isBlank(greenOffBalanceIncrease) ? "0" : greenOffBalanceIncrease.replace(",", "");
		this.greenOffBalanceIncrease = BigDecimal.valueOf(Double.valueOf(greenOffBalanceIncrease));
	}

	public Integer getGreenOffCustomerNum() {
		return greenOffCustomerNum;
	}

	public void setGreenOffCustomerNum(String greenOffCustomerNum) {
		greenOffCustomerNum = StringUtils.isBlank(greenOffCustomerNum) ? "0" : greenOffCustomerNum.replace(",", "");
		this.greenOffCustomerNum = Integer.valueOf(greenOffCustomerNum);
	}

	public Integer getGreenOffCustomerIncrease() {
		return greenOffCustomerIncrease;
	}

	public void setGreenOffCustomerIncrease(String greenOffCustomerIncrease) {
		greenOffCustomerIncrease = StringUtils.isBlank(greenOffCustomerIncrease) ? "0" : greenOffCustomerIncrease.replace(",", "");
		this.greenOffCustomerIncrease = Integer.valueOf(greenOffCustomerIncrease);
	}

	public BigDecimal getTotalOffBalance() {
		return totalOffBalance;
	}

	public void setTotalOffBalance(String totalOffBalance) {
		totalOffBalance = StringUtils.isBlank(totalOffBalance) ? "0" : totalOffBalance.replace(",", "");
		this.totalOffBalance = BigDecimal.valueOf(Double.valueOf(totalOffBalance));
	}

	public BigDecimal getTotalOffBalanceIncrease() {
		return totalOffBalanceIncrease;
	}

	public void setTotalOffBalanceIncrease(String totalOffBalanceIncrease) {
		totalOffBalanceIncrease = StringUtils.isBlank(totalOffBalanceIncrease) ? "0" : totalOffBalanceIncrease.replace(",", "");
		this.totalOffBalanceIncrease = BigDecimal.valueOf(Double.valueOf(totalOffBalanceIncrease));
	}

	public Integer getTotalOffCustomerNum() {
		return totalOffCustomerNum;
	}

	public void setTotalOffCustomerNum(String totalOffCustomerNum) {
		totalOffCustomerNum = StringUtils.isBlank(totalOffCustomerNum) ? "0" : totalOffCustomerNum.replace(",", "");
		this.totalOffCustomerNum = Integer.valueOf(totalOffCustomerNum);
	}

	public Integer getTotalOffCustomerIncrease() {
		return totalOffCustomerIncrease;
	}

	public void setTotalOffCustomerIncrease(String totalOffCustomerIncrease) {
		totalOffCustomerIncrease = StringUtils.isBlank(totalOffCustomerIncrease) ? "0" : totalOffCustomerIncrease.replace(",", "");
		this.totalOffCustomerIncrease = Integer.valueOf(totalOffCustomerIncrease);
	}

}
