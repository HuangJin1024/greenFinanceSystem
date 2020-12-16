package com.hzhx.greenFinance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hzhx.greenFinance.renHangVo.Customer;

@Mapper
@DS("impala")
public interface QueryRHCLInfoMapper {
	List<Customer> queryCustomerLoan();

	@Select("select count(*) from (select distinct customerNo from send_green_thr_credit_company_info) temp")
	int queryCustomersLoanNum();

	List<Customer> queryCustomersLoans();

}
