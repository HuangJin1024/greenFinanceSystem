package com.hzhx.greenFinance.vo.children;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
//XML文件中的根标识
@XmlRootElement(name = "businessTypes")
//控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {    
    "businessDate",   
    "businessTypeCd"
}) 
public class BusinessType {  
	@XmlAttribute
	private String businessDate;
	private List<String> businessTypeCd;
	public String getBusinessDate() {
		return businessDate;
	}
	public void setBusinessDate(String businessDate) {
		this.businessDate = businessDate;
	}
	public List<String> getBusinessTypeCd() {
		return businessTypeCd;
	}
	public void setBusinessTypeCd(List<String> businessTypeCd) {
		this.businessTypeCd = businessTypeCd;
	}
}
