package com.hzhx.greenFinance.renHangVo;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Shareholder {
	private String shareholderName;
	private BigDecimal capitalContributionAmount;
	private BigDecimal capitalContributionProportion;

	public String getShareholderName() {
		return shareholderName;
	}

	public void setShareholderName(String shareholderName) {
		this.shareholderName = shareholderName;
	}

	public BigDecimal getCapitalContributionAmount() {
		return capitalContributionAmount;
	}

	public void setCapitalContributionAmount(BigDecimal capitalContributionAmount) {
		this.capitalContributionAmount = capitalContributionAmount;
	}

	public BigDecimal getCapitalContributionProportion() {
		return capitalContributionProportion;
	}

	public void setCapitalContributionProportion(BigDecimal capitalContributionProportion) {
		this.capitalContributionProportion = capitalContributionProportion;
	}

}
