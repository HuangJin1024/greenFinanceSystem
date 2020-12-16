/**
 * 
 */
package com.hzhx.greenFinance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzhx.greenFinance.Util.XMLUtil;
import com.hzhx.greenFinance.dao.GreenfinSendLogMapper;
import com.hzhx.greenFinance.dao.QueryLoanInfoMapper;
import com.hzhx.greenFinance.entity.GreenfinSendLog;
import com.hzhx.greenFinance.service.TestService;
import com.hzhx.greenFinance.vo.CustomerLoanInfo;
import com.hzhx.greenFinance.vo.ReportSummarys;
import com.hzhx.greenFinance.vo.report.CustomerLoanInfoReport;

/**
 * @author hzhx
 *
 */
@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private QueryLoanInfoMapper queryInfoMapper;
	@Autowired
	private GreenfinSendLogMapper greenfinSendLogMapper;

	@Override
	public void creatXml() {
		List<CustomerLoanInfo> customerLoanInfoList = queryInfoMapper.queryCustomerLoanInfo();
		CustomerLoanInfoReport customerLoanInfoReport = new CustomerLoanInfoReport();
		customerLoanInfoReport.setReportSummarys(new ReportSummarys("Bldefdf11111","LB"));
		customerLoanInfoReport.setCustomerLoanInfo(customerLoanInfoList);
		String path = "D:\\userLB_001"+".xml";  
        System.out.println("---将对象转换成File类型的xml Start---");  
        XMLUtil.convertToXml(customerLoanInfoReport, path);  
        System.out.println("---将对象转换成File类型的xml End---");  
	}
	@Override
	public void insert() {
		GreenfinSendLog greenfinSendLog = new GreenfinSendLog("requestID999999");
		greenfinSendLogMapper.insert(greenfinSendLog);
	}
}
