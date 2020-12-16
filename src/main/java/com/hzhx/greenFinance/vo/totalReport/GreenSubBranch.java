package com.hzhx.greenFinance.vo.totalReport;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang.StringUtils;

@XmlAccessorType(XmlAccessType.FIELD)
public class GreenSubBranch {
	private String subBranchName;
	private String buildTime;
	private Integer staffNum;
	private List<LoanStat> loanStats;

	public String getSubBranchName() {
		return subBranchName;
	}

	public void setSubBranchName(String subBranchName) {
		this.subBranchName = subBranchName;
	}

	public String getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}

	public Integer getStaffNum() {
		return staffNum;
	}

	public void setStaffNum(String staffNum) {
		staffNum = StringUtils.isBlank(staffNum) ? "0" : staffNum.replace(",", "");
		this.staffNum = Integer.valueOf(staffNum);
	}

	public List<LoanStat> getLoanStats() {
		return loanStats;
	}

	public void setLoanStats(List<LoanStat> loanStats) {
		this.loanStats = loanStats;
	}

}
