package com.hzhx.greenFinance.vo.totalReport;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class AreaFinancings {
	@XmlAttribute
	private String customerTypeCd;
	private List<AreaFinancing> areaFinancing;

	public String getCustomerTypeCd() {
		return customerTypeCd;
	}

	public void setCustomerTypeCd(String customerTypeCd) {
		this.customerTypeCd = customerTypeCd;
	}

	public List<AreaFinancing> getAreaFinancing() {
		return areaFinancing;
	}

	public void setAreaFinancing(List<AreaFinancing> areaFinancing) {
		this.areaFinancing = areaFinancing;
	}

}
