package com.hzhx.greenFinance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hzhx.greenFinance.config.PageBean;
import com.hzhx.greenFinance.vo.CustomerBillInfo;

@Mapper
@DS("impala")
public interface QueryBillInfoMapper {
	List<CustomerBillInfo> queryCustomerBillInfo();

	int queryCustomerBillInfoCount();

	List<CustomerBillInfo> queryCustomerBillInfoByPage(PageBean pageBean);
	
	int queryDailyCount(String dataDate);

	List<CustomerBillInfo> queryDailyInfoByPage(@Param(value = "pageBean")PageBean pageBean, @Param(value = "dataDate")String dataDate);

}
