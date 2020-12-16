package com.hzhx.greenFinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hzhx.greenFinance.service.SendService;
import com.hzhx.greenFinance.vo.ResultVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class SendMessageController {
	private Logger logger = LoggerFactory.getLogger(SendMessageController.class);
	
	@Autowired
	private SendService sendService;
	
	@ResponseBody
	@RequestMapping(path = {"/reportDataDaily/{msgType}/{dataDate}"})
    public String reportDataDaily (@PathVariable("msgType") String msgType,@PathVariable("dataDate") String dataDate){
        
		ResultVo result = sendService.reportDataDaily(msgType,dataDate);
		logger.info(result.getMessage());
        return result.getMessage().toString();
    }
	
	@ResponseBody
	@RequestMapping(path = {"/reportDataAll/{msgType}"})
    public String reportDataAll (@PathVariable("msgType") String msgType){
        
		ResultVo result = sendService.reportDataAll(msgType);
		logger.info(result.getMessage());
        return result.getMessage().toString();
    }
	
	@ResponseBody
	@RequestMapping(path = {"/send/{msgType}/{msgBusinessType}"})
    public String reportData (@PathVariable("msgType") String msgType, @PathVariable("msgBusinessType") String msgBusinessType){
        
		ResultVo result = sendService.reportData(msgType,msgBusinessType);
		logger.info(result.getMessage());
        return result.getMessage().toString();
    }
	
	@ResponseBody
	@RequestMapping(path = {"/receipt/{reportPackageName}"})
	public String receipt (@PathVariable("reportPackageName") String reportPackageName){
		
		ResultVo result = sendService.receipt(reportPackageName+".zip");
		logger.info(result.getMessage());
        return result.getMessage().toString();
	}
	
	@ResponseBody
	@RequestMapping(path = {"/inspection"})
	public String inspection (){
		
		ResultVo result = sendService.inspection();
		logger.info(result.getMessage());
        return result.getMessage().toString();
	}
	
	@ResponseBody
	@RequestMapping(path = {"/inspectionFeedback"})
	public String inspectionFeedback (){
		
		ResultVo result = sendService.inspectionFeedback();
		logger.info(result.getMessage());
        return result.getMessage().toString();
	}
	
	@ResponseBody
	@RequestMapping(path = {"/getFormTaskList"})
	public String getFormTaskList (){
		
		ResultVo result = sendService.getFormTaskList();
		logger.info(result.getMessage());
        return result.getMessage().toString();
	}
	
	@ResponseBody
	@RequestMapping(path = {"/reportForm/{formPeriod}"})
	public String reportForm (@PathVariable("formPeriod") String formPeriod){
		
		ResultVo result = sendService.reportForm(formPeriod);
		logger.info(result.getMessage());
        return result.getMessage().toString();
	}
	
	@ResponseBody
	@RequestMapping(path = {"/receiptForm/{reportPackageName}"})
	public String receiptForm (@PathVariable("reportPackageName") String reportPackageName){
		
		ResultVo result = sendService.receiptForm(reportPackageName);
		logger.info(result.getMessage());
        return result.getMessage().toString();
	}
	
	@ResponseBody
	@RequestMapping(path = {"/queryAuditResult"})
	public String queryAuditResult (){
		
		ResultVo result = sendService.queryAuditResult(null);
		logger.info(result.getMessage());
        return result.getMessage().toString();
	}
}
