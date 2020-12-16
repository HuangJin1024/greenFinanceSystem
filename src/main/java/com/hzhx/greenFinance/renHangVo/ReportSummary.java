package com.hzhx.greenFinance.renHangVo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
//XML文件中的根标识
@XmlRootElement(name = "reportSummary")
//控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "reportSceneType", "yewuNum"})
public class ReportSummary {
	@XmlAttribute
	private String reportSceneType;
	@XmlValue
	private int yewuNum;
	public String getReportSceneType() {
		return reportSceneType;
	}
	public void setReportSceneType(String reportSceneType) {
		this.reportSceneType = reportSceneType;
	}
	public int getYewuNum() {
		return yewuNum;
	}
	public void setYewuNum(int yewuNum) {
		this.yewuNum = yewuNum;
	}
	
}
