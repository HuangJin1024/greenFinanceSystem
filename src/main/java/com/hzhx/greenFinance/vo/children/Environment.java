package com.hzhx.greenFinance.vo.children;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "customer")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "businessType", "businessOrg", "riskTypeCd", "involvedDate", "involvedDesc", "involvedReasonNo",
		"dealDate", "dealMeasure", "reformOverDate", "isOverReform" })
public class Environment {
	private BusinessType businessType;
	private String businessOrg;
	private String riskTypeCd;
	private String involvedDate;
	private String involvedDesc;
	private String involvedReasonNo;
	private String dealDate;
	private String dealMeasure;
	private String reformOverDate;
	private String isOverReform;
	public BusinessType getBusinessType() {
		return businessType;
	}
	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}
	public String getBusinessOrg() {
		return businessOrg;
	}
	public void setBusinessOrg(String businessOrg) {
		this.businessOrg = businessOrg;
	}
	public String getRiskTypeCd() {
		return riskTypeCd;
	}
	public void setRiskTypeCd(String riskTypeCd) {
		this.riskTypeCd = riskTypeCd;
	}
	public String getInvolvedDate() {
		return involvedDate;
	}
	public void setInvolvedDate(String involvedDate) {
		this.involvedDate = involvedDate;
	}
	public String getInvolvedDesc() {
		return involvedDesc;
	}
	public void setInvolvedDesc(String involvedDesc) {
		this.involvedDesc = involvedDesc;
	}
	public String getInvolvedReasonNo() {
		return involvedReasonNo;
	}
	public void setInvolvedReasonNo(String involvedReasonNo) {
		this.involvedReasonNo = involvedReasonNo;
	}
	public String getDealDate() {
		return dealDate;
	}
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	public String getDealMeasure() {
		return dealMeasure;
	}
	public void setDealMeasure(String dealMeasure) {
		this.dealMeasure = dealMeasure;
	}
	public String getReformOverDate() {
		return reformOverDate;
	}
	public void setReformOverDate(String reformOverDate) {
		this.reformOverDate = reformOverDate;
	}
	public String getIsOverReform() {
		return isOverReform;
	}
	public void setIsOverReform(String isOverReform) {
		this.isOverReform = isOverReform;
	}
	
}
