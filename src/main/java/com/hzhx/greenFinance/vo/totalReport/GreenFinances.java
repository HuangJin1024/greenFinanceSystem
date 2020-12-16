package com.hzhx.greenFinance.vo.totalReport;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class GreenFinances {
	@XmlAttribute
	private String greenFinanceType;
	private List<GreenFinance> greenFinance;

	public String getGreenFinanceType() {
		return greenFinanceType;
	}

	public void setGreenFinanceType(String greenFinanceType) {
		this.greenFinanceType = greenFinanceType;
	}

	public List<GreenFinance> getGreenFinance() {
		return greenFinance;
	}

	public void setGreenFinance(List<GreenFinance> greenFinance) {
		this.greenFinance = greenFinance;
	}

}
