package com.hzhx.greenFinance.vo.totalReport;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang.StringUtils;

@XmlAccessorType(XmlAccessType.FIELD)
public class GreenOperate {
	private String indexCode;
	private BigDecimal yearTotalNum;
	private BigDecimal lastYearTotalNum;

	public String getIndexCode() {
		return indexCode;
	}

	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}

	public BigDecimal getYearTotalNum() {
		return yearTotalNum;
	}

	public void setYearTotalNum(String yearTotalNum) {
		yearTotalNum = StringUtils.isBlank(yearTotalNum) ? "0" : yearTotalNum.replace(",", "");
		this.yearTotalNum = BigDecimal.valueOf(Double.valueOf(yearTotalNum));
	}

	public BigDecimal getLastYearTotalNum() {
		return lastYearTotalNum;
	}

	public void setLastYearTotalNum(String lastYearTotalNum) {
		lastYearTotalNum = StringUtils.isBlank(lastYearTotalNum) ? "0" : lastYearTotalNum.replace(",", "");
		this.lastYearTotalNum = BigDecimal.valueOf(Double.valueOf(lastYearTotalNum));
	}

}
