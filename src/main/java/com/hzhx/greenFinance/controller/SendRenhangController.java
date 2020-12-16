package com.hzhx.greenFinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hzhx.greenFinance.service.SendRHService;
import com.hzhx.greenFinance.vo.ResultVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class SendRenhangController {
	private Logger logger = LoggerFactory.getLogger(SendRenhangController.class);
	
	@Autowired
	private SendRHService sendRHService;
		
	@ResponseBody
	@RequestMapping(path = {"/reportDataAllRH/{msgType}"})
    public String reportDataAllRH (@PathVariable("msgType") String msgType){
        
		ResultVo result = sendRHService.reportDataAllRH(msgType);
		logger.info(result.getMessage());
        return result.getMessage().toString();
    }
	
	@ResponseBody
	@RequestMapping(path = {"/deleteDataRH"})
    public String deleteDataRH (){
        
		ResultVo result = sendRHService.reportDataAllRH("D");
		logger.info(result.getMessage());
        return result.getMessage().toString();
    }
	
	@ResponseBody
	@RequestMapping(path = {"/receiptRH/{reportDate}"})
    public String receiptRH (@PathVariable("reportDate") String reportDate){
        
		ResultVo result = sendRHService.receipt(reportDate);
		logger.info(result.getMessage());
        return result.getMessage().toString();
    }

	@ResponseBody
	@RequestMapping(path = {"/inspectionRH"})
    public String inspectionRH (){
        
		ResultVo result = sendRHService.inspection();
		logger.info(result.getMessage());
        return result.getMessage().toString();
    }
	
	@ResponseBody
	@RequestMapping(path = {"/reportMCIF/{msgType}"})
    public String reportMCIF (@PathVariable("msgType") String msgType){
        
		ResultVo result = sendRHService.reportMCIF(msgType);
		logger.info(result.getMessage());
        return result.getMessage().toString();
    }
	
	@ResponseBody
	@RequestMapping(path = {"/reportMCIF/{reportDate}/{reportPackageName}"})
	public String receiptMCIF (@PathVariable("reportDate") String reportDate,@PathVariable("reportPackageName") String reportPackageName){
		
		ResultVo result = sendRHService.reportMCIF(reportDate,reportPackageName+".zip");
		logger.info(result.getMessage());
		return result.getMessage().toString();
	}
}
