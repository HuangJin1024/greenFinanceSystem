package com.hzhx.greenFinance.scheduler;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hzhx.greenFinance.service.SendRHService;
import com.hzhx.greenFinance.service.SendService;

@Component
public class SchedulerTask {
	@Autowired
	private SendService sendService;
	
	@Autowired
	private SendRHService sendRHService;
	
	//@Scheduled(cron="0 0 0 * * ?")
	//@Scheduled(cron="0 */5 * * * ?")
	public void reportDataDailyAuto() {
		String dataDate = DateFormatUtils.format(new Date(), "yyyyMMdd");
		sendService.reportDataDaily("N", dataDate);
	}
	
	//@Scheduled(cron="0 */2 * * * ?")
	public void test() {
		sendRHService.reportDataAllRH("N");
		sendService.reportDataAll("A");
	}
}
