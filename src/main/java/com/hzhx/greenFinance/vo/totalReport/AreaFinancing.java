package com.hzhx.greenFinance.vo.totalReport;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang.StringUtils;

@XmlAccessorType(XmlAccessType.FIELD)
public class AreaFinancing {
	private String areaCode;
	private BigDecimal greenBalance;
	private BigDecimal greenOnBalance;
	private BigDecimal greenOffBalance;
	private BigDecimal totalBalance;
	private BigDecimal totalOnBalance;
	private BigDecimal totalOffBalance;
	private Integer greenCustomerNum;
	private Integer greenOnCustomerNum;
	private Integer greenOffCustomerNum;
	private Integer totalCustomerNum;
	private Integer totalOnCustomerNum;
	private Integer totalOffCustomerNum;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public BigDecimal getGreenBalance() {
		return greenBalance;
	}

	public void setGreenBalance(String greenBalance) {
		greenBalance = StringUtils.isBlank(greenBalance) ? "0" : greenBalance.replace(",", "");
		this.greenBalance = BigDecimal.valueOf(Double.valueOf(greenBalance));
	}

	public BigDecimal getGreenOnBalance() {
		return greenOnBalance;
	}

	public void setGreenOnBalance(String greenOnBalance) {
		greenOnBalance = StringUtils.isBlank(greenOnBalance) ? "0" : greenOnBalance.replace(",", "");
		this.greenOnBalance = BigDecimal.valueOf(Double.valueOf(greenOnBalance));
	}

	public BigDecimal getGreenOffBalance() {
		return greenOffBalance;
	}

	public void setGreenOffBalance(String greenOffBalance) {
		greenOffBalance = StringUtils.isBlank(greenOffBalance) ? "0" : greenOffBalance.replace(",", "");
		this.greenOffBalance = BigDecimal.valueOf(Double.valueOf(greenOffBalance));
	}

	public BigDecimal getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(String totalBalance) {
		totalBalance = StringUtils.isBlank(totalBalance) ? "0" : totalBalance.replace(",", "");
		this.totalBalance = BigDecimal.valueOf(Double.valueOf(totalBalance));
	}

	public BigDecimal getTotalOnBalance() {
		return totalOnBalance;
	}

	public void setTotalOnBalance(String totalOnBalance) {
		totalOnBalance = StringUtils.isBlank(totalOnBalance) ? "0" : totalOnBalance.replace(",", "");
		this.totalOnBalance = BigDecimal.valueOf(Double.valueOf(totalOnBalance));
	}

	public BigDecimal getTotalOffBalance() {
		return totalOffBalance;
	}

	public void setTotalOffBalance(String totalOffBalance) {
		totalOffBalance = StringUtils.isBlank(totalOffBalance) ? "0" : totalOffBalance.replace(",", "");
		this.totalOffBalance = BigDecimal.valueOf(Double.valueOf(totalOffBalance));
	}

	public Integer getGreenCustomerNum() {
		return greenCustomerNum;
	}

	public void setGreenCustomerNum(String greenCustomerNum) {
		greenCustomerNum = StringUtils.isBlank(greenCustomerNum) ? "0" : greenCustomerNum.replace(",", "");
		this.greenCustomerNum = Integer.valueOf(greenCustomerNum);
	}

	public Integer getGreenOnCustomerNum() {
		return greenOnCustomerNum;
	}

	public void setGreenOnCustomerNum(String greenOnCustomerNum) {
		greenOnCustomerNum = StringUtils.isBlank(greenOnCustomerNum) ? "0" : greenOnCustomerNum.replace(",", "");
		this.greenOnCustomerNum = Integer.valueOf(greenOnCustomerNum);
	}

	public Integer getGreenOffCustomerNum() {
		return greenOffCustomerNum;
	}

	public void setGreenOffCustomerNum(String greenOffCustomerNum) {
		greenOffCustomerNum = StringUtils.isBlank(greenOffCustomerNum) ? "0" : greenOffCustomerNum.replace(",", "");
		this.greenOffCustomerNum = Integer.valueOf(greenOffCustomerNum);
	}

	public Integer getTotalCustomerNum() {
		return totalCustomerNum;
	}

	public void setTotalCustomerNum(String totalCustomerNum) {
		totalCustomerNum = StringUtils.isBlank(totalCustomerNum) ? "0" : totalCustomerNum.replace(",", "");
		this.totalCustomerNum = Integer.valueOf(totalCustomerNum);
	}

	public Integer getTotalOnCustomerNum() {
		return totalOnCustomerNum;
	}

	public void setTotalOnCustomerNum(String totalOnCustomerNum) {
		totalOnCustomerNum = StringUtils.isBlank(totalOnCustomerNum) ? "0" : totalOnCustomerNum.replace(",", "");
		this.totalOnCustomerNum = Integer.valueOf(totalOnCustomerNum);
	}

	public Integer getTotalOffCustomerNum() {
		return totalOffCustomerNum;
	}

	public void setTotalOffCustomerNum(String totalOffCustomerNum) {
		totalOffCustomerNum = StringUtils.isBlank(totalOffCustomerNum) ? "0" : totalOffCustomerNum.replace(",", "");
		this.totalOffCustomerNum = Integer.valueOf(totalOffCustomerNum);
	}

}
