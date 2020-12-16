package com.hzhx.greenFinance.vo.totalReport;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang.StringUtils;

@XmlAccessorType(XmlAccessType.FIELD)
public class RiskEnterprise {
	private String indexCode;
	private Integer customerNum;
	private BigDecimal balance;
	private BigDecimal balanceIncrease;
	private BigDecimal passBalance;
	private BigDecimal followBalance;
	private BigDecimal subBalance;
	private BigDecimal doubtfulBalance;
	private BigDecimal lossBalance;

	public String getIndexCode() {
		return indexCode;
	}

	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}

	public Integer getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(String customerNum) {
		customerNum = StringUtils.isBlank(customerNum) ? "0" : customerNum.replace(",", "");
		this.customerNum = Integer.valueOf(customerNum);
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		balance = StringUtils.isBlank(balance) ? "0" : balance.replace(",", "");
		this.balance = BigDecimal.valueOf(Double.valueOf(balance));
	}

	public BigDecimal getBalanceIncrease() {
		return balanceIncrease;
	}

	public void setBalanceIncrease(String balanceIncrease) {
		balanceIncrease = StringUtils.isBlank(balanceIncrease) ? "0" : balanceIncrease.replace(",", "");
		this.balanceIncrease = BigDecimal.valueOf(Double.valueOf(balanceIncrease));
	}

	public BigDecimal getPassBalance() {
		return passBalance;
	}

	public void setPassBalance(String passBalance) {
		passBalance = StringUtils.isBlank(passBalance) ? "0" : passBalance.replace(",", "");
		this.passBalance = BigDecimal.valueOf(Double.valueOf(passBalance));
	}

	public BigDecimal getFollowBalance() {
		return followBalance;
	}

	public void setFollowBalance(String followBalance) {
		followBalance = StringUtils.isBlank(followBalance) ? "0" : followBalance.replace(",", "");
		this.followBalance = BigDecimal.valueOf(Double.valueOf(followBalance));
	}

	public BigDecimal getSubBalance() {
		return subBalance;
	}

	public void setSubBalance(String subBalance) {
		subBalance = StringUtils.isBlank(subBalance) ? "0" : subBalance.replace(",", "");
		this.subBalance = BigDecimal.valueOf(Double.valueOf(subBalance));
	}

	public BigDecimal getDoubtfulBalance() {
		return doubtfulBalance;
	}

	public void setDoubtfulBalance(String doubtfulBalance) {
		doubtfulBalance = StringUtils.isBlank(doubtfulBalance) ? "0" : doubtfulBalance.replace(",", "");
		this.doubtfulBalance = BigDecimal.valueOf(Double.valueOf(doubtfulBalance));
	}

	public BigDecimal getLossBalance() {
		return lossBalance;
	}

	public void setLossBalance(String lossBalance) {
		lossBalance = StringUtils.isBlank(lossBalance) ? "0" : lossBalance.replace(",", "");
		this.lossBalance = BigDecimal.valueOf(Double.valueOf(lossBalance));
	}

}
