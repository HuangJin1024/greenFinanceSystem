package com.hzhx.greenFinance.dao.formDao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hzhx.greenFinance.vo.totalReport.GreenBuild;

@Mapper
@DS("impala")
public interface QueryGreenBuildMapper {
	
	GreenBuild queryGreenBuild();

}
