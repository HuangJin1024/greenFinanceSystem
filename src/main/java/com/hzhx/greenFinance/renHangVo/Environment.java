package com.hzhx.greenFinance.renHangVo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "environment")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "customerNo", "customerTypeCd", "cnapsCode", "riskTypeCd", "involvedDate", "involvedDesc",
		"involvedReasonNo", "dealDate", "dealMeasure", "reformOverDate", "isOverReform" })
public class Environment {
	private String customerNo;
	private String customerTypeCd;
	private String cnapsCode;
	private String riskTypeCd;
	private String involvedDate;
	private String involvedDesc;
	private String involvedReasonNo;
	private String dealDate;
	private String dealMeasure;
	private String reformOverDate;
	private String isOverReform;
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getCustomerTypeCd() {
		return customerTypeCd;
	}
	public void setCustomerTypeCd(String customerTypeCd) {
		this.customerTypeCd = customerTypeCd;
	}
	public String getCnapsCode() {
		return cnapsCode;
	}
	public void setCnapsCode(String cnapsCode) {
		this.cnapsCode = cnapsCode;
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
