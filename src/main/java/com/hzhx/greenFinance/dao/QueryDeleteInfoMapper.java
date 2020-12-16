package com.hzhx.greenFinance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hzhx.greenFinance.vo.children.Bill;
import com.hzhx.greenFinance.vo.children.Credit;
import com.hzhx.greenFinance.vo.children.Loan;

@Mapper
@DS("impala")
public interface QueryDeleteInfoMapper {
	@Select("select distinct loanNo from send_green_thr_loan_info")
	List<Loan> queryLoans();

	@Select("select distinct billNo from send_green_thr_acceptance_bill_info")
	List<Bill> queryBills();

	@Select("select distinct letterCreditNo from send_green_thr_credit_info")
	List<Credit> queryCredits();


}
