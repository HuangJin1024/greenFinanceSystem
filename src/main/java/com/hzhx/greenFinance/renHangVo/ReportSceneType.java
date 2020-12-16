package com.hzhx.greenFinance.renHangVo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "reportSceneType")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "businessDate", "reportSceneType" })
public class ReportSceneType {
	@XmlAttribute
	private String businessDate;
	@XmlValue
	private String reportSceneType;

	public String getBusinessDate() {
		return businessDate;
	}

	public void setBusinessDate(String businessDate) {
		this.businessDate = businessDate;
	}

	public String getReportSceneType() {
		return reportSceneType;
	}

	public void setReportSceneType(String reportSceneType) {
		this.reportSceneType = reportSceneType;
	}

}
