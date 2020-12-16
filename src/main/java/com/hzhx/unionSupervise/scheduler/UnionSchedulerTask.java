package com.hzhx.unionSupervise.scheduler;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hzhx.unionSupervise.service.AccInfoFileService;

@Component
public class UnionSchedulerTask {
	
	@Autowired
	private AccInfoFileService accInfoFileService;
	
	//@Scheduled(cron="0 0 0 * * ?")
	//@Scheduled(cron="0 */5 * * * ?")
	public void reportDataDailyAuto() {
		String date = DateFormatUtils.format(new Date(), "yyyyMMdd");
		accInfoFileService.sendAccInfoFile(date);
	}
	

}
