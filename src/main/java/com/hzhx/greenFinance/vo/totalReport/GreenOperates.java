package com.hzhx.greenFinance.vo.totalReport;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class GreenOperates {
	@XmlAttribute
	private String greenOperateType;
	private List<GreenOperate> greenOperate;

	public String getGreenOperateType() {
		return greenOperateType;
	}

	public void setGreenOperateType(String greenOperateType) {
		this.greenOperateType = greenOperateType;
	}

	public List<GreenOperate> getGreenOperate() {
		return greenOperate;
	}

	public void setGreenOperate(List<GreenOperate> greenOperate) {
		this.greenOperate = greenOperate;
	}

}
