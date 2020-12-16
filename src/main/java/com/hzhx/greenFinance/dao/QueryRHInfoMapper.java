package com.hzhx.greenFinance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hzhx.greenFinance.renHangVo.Enterprise;
import com.hzhx.greenFinance.renHangVo.Environment;
import com.hzhx.greenFinance.renHangVo.Loan;
import com.hzhx.greenFinance.renHangVo.Personal;
import com.hzhx.greenFinance.renHangVo.Project;
import com.hzhx.greenFinance.renHangVo.ReportSummary;

@Mapper
@DS("impala")
public interface QueryRHInfoMapper {
	List<ReportSummary> queryReportSummaryList();

	List<Enterprise> queryEnterpriseList();

	List<Personal> queryPersonalList();

	List<Project> queryProjectList();

	List<Loan> queryLoanList();

	List<Environment> queryEnvironmentList();

	List<ReportSummary> queryDeleteSummaryList();

	List<Loan> getSendedLoanNoList();
	
	List<String> getSendedInvolvedReasonNoList();

}
