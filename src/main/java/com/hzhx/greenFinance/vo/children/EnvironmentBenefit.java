package com.hzhx.greenFinance.vo.children;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
//XML文件中的根标识
@XmlRootElement(name = "environmentBenefit")
//控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "environmentBenefitResult", "environmentBenefitBasis" })
public class EnvironmentBenefit {
	private EnvironmentBenefitResult environmentBenefitResult;
	private EnvironmentBenefitBasis environmentBenefitBasis;
	public EnvironmentBenefitResult getEnvironmentBenefitResult() {
		return environmentBenefitResult;
	}
	public void setEnvironmentBenefitResult(EnvironmentBenefitResult environmentBenefitResult) {
		this.environmentBenefitResult = environmentBenefitResult;
	}
	public EnvironmentBenefitBasis getEnvironmentBenefitBasis() {
		return environmentBenefitBasis;
	}
	public void setEnvironmentBenefitBasis(EnvironmentBenefitBasis environmentBenefitBasis) {
		this.environmentBenefitBasis = environmentBenefitBasis;
	}
	
}
