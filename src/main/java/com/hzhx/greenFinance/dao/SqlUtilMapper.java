package com.hzhx.greenFinance.dao;

import org.apache.ibatis.annotations.*;

import com.baomidou.dynamic.datasource.annotation.DS;

@Mapper
@DS("impala")
public interface SqlUtilMapper {

	@Select("select fileNameIndex from greenfin_log where reportBank = #{reportBank} and requestDate = #{requestDate} and requestType = #{requestType} and resultCode ='200' order by fileNameIndex desc limit 1")
	String findFileNameIndex(@Param("reportBank") String reportBank, @Param("requestDate") String requestDate, @Param("requestType") String requestType);

}