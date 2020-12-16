package com.hzhx.greenFinance.vo.totalReport;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class RiskEnterprises {
	@XmlAttribute
	private String riskEnterpriseType;
	private List<RiskEnterprise> riskEnterprise;

	public String getRiskEnterpriseType() {
		return riskEnterpriseType;
	}

	public void setRiskEnterpriseType(String riskEnterpriseType) {
		this.riskEnterpriseType = riskEnterpriseType;
	}

	public List<RiskEnterprise> getRiskEnterprise() {
		return riskEnterprise;
	}

	public void setRiskEnterprise(List<RiskEnterprise> riskEnterprise) {
		this.riskEnterprise = riskEnterprise;
	}

}
