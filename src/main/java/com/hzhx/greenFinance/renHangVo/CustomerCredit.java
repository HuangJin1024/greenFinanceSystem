package com.hzhx.greenFinance.renHangVo;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang.StringUtils;

@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerCredit {
	private String unifiedCreditFlag;
	private BigDecimal creditLimit;

	public String getUnifiedCreditFlag() {
		return unifiedCreditFlag;
	}

	public void setUnifiedCreditFlag(String unifiedCreditFlag) {
		this.unifiedCreditFlag = unifiedCreditFlag;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		creditLimit = StringUtils.isBlank(creditLimit) ? "0" : creditLimit.replace(",", "");
		this.creditLimit = BigDecimal.valueOf(Double.valueOf(creditLimit));
	}

}