package com.hzhx.greenFinance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hzhx.greenFinance.config.PageBean;
import com.hzhx.greenFinance.vo.CustomerCreditInfo;


@Mapper
@DS("impala")
public interface QueryCreditInfoMapper {

	List<CustomerCreditInfo> queryCustomerCreditInfo();

	int queryCustomerCreditInfoCount();

	List<CustomerCreditInfo> queryCustomerCreditInfoByPage(PageBean pageBean);

	int queryDailyCount(String dataDate);

	List<CustomerCreditInfo> queryDailyInfoByPage(@Param(value = "pageBean")PageBean pageBean, @Param(value = "dataDate")String dataDate);

}
