package com.hzhx.greenFinance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hzhx.greenFinance.config.PageBean;
import com.hzhx.greenFinance.vo.children.Bond;
@Mapper
@DS("impala")
public interface QueryBondInfoMapper {

	List<Bond> queryBondInfo();

	int queryBondInfoByPageCount();

	List<Bond> queryBondInfoByPage(PageBean pageBean);
	
	int queryDailyCount(String dataDate);

	List<Bond> queryDailyInfoByPage(@Param(value = "pageBean")PageBean pageBean, @Param(value = "dataDate")String dataDate);

}
