package com.hzhx.greenFinance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hzhx.greenFinance.config.PageBean;
import com.hzhx.greenFinance.vo.CustomerLoanInfo;

@Mapper
@DS("impala")
public interface QueryLoanInfoMapper {

	List<CustomerLoanInfo> queryCustomerLoanInfoByPage(PageBean pageBean);
	
	List<CustomerLoanInfo> queryCustomerLoanInfo();

	int queryCustomerLoanInfoCount();

	int queryDailyCount(String dataDate);

	List<CustomerLoanInfo> queryDailyInfoByPage(@Param(value = "pageBean")PageBean pageBean, @Param(value = "dataDate")String dataDate);

}
