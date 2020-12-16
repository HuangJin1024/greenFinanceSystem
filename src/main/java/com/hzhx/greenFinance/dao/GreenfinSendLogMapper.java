package com.hzhx.greenFinance.dao;

import org.apache.ibatis.annotations.*;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hzhx.greenFinance.entity.GreenfinSendLog;

@Mapper
@DS("mysql")
public interface GreenfinSendLogMapper {

	int insert(@Param("greenfinSendLog") GreenfinSendLog greenfinSendLog);

}