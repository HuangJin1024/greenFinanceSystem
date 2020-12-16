package com.hzhx.greenFinance.dao.formDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hzhx.greenFinance.vo.totalReport.RiskEnterprises;

@Mapper
@DS("impala")
public interface QueryRiskEnterpriseMapper {
	
	List<RiskEnterprises> queryRiskEnterprises();

}
