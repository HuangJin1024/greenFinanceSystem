package com.hzhx.greenFinance.dao.formDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hzhx.greenFinance.vo.totalReport.GreenFinances;

@Mapper
@DS("impala")
public interface QueryGreenFinanceMapper {
	
	List<GreenFinances> queryGreenFinances();

}
