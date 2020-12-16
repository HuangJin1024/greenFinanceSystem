package com.hzhx.greenFinance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hzhx.greenFinance.config.PageBean;
import com.hzhx.greenFinance.vo.CustomerEnvironmentInfo;

@Mapper
@DS("impala")
public interface QueryEnvironmentInfoMapper {

	List<CustomerEnvironmentInfo> queryCustomerEnvironmentInfoByPage(PageBean pageBean);
	
	List<CustomerEnvironmentInfo> queryCustomerEnvironmentInfo();

	int queryCustomerEnvironmentInfoCount();
	
	int queryDailyCount(String dataDate);

	List<CustomerEnvironmentInfo> queryDailyInfoByPage(@Param(value = "pageBean")PageBean pageBean, @Param(value = "dataDate")String dataDate);

}
