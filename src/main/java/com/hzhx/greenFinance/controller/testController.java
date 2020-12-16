package com.hzhx.greenFinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hzhx.greenFinance.service.TestService;

@Controller
public class testController {
	@Autowired
	private TestService testService;
	
	@RequestMapping(path = { "/testInsert" })
	@ResponseBody
	public String test() {
		testService.insert();
		return "Seccess";
	}
	
	/**
	 * url传参，访问的路径类似这样：localhost:8080/getParamDemo1/1
	 * 方法体中的参数要在前面加注释，@PathVariable，代表url中的参数
	 */
	@RequestMapping(path = { "/getParamDemo1/{id}" })
	public String getParamDemo1(@PathVariable("id") int userId) {
		System.out.println("get param " + userId);
		return "success get param";
	}

	/**
	 * 当然，你也可以通过这种传参方式：localhost:8080/getParamDemo?param1=1或者直接表单提交参数
	 * 当然，同时方法中参数声明的注释也要变成@RequestParam，代表请求参数，required属性说明了参数是否是必须的
	 */
	@RequestMapping(path = { "/getParamDemo2" })
	public String getParamDemo2(@RequestParam(value = "param1", required = false) int param) {
		System.out.println("get param " + param);
		return "success get param";
	}

	/**
	 * 通过设置RequestMapping的method属性便可以设置该方法可处理的对应请求了，例如下面的getRequestDemo方法只会处理get请求
	 */
	@RequestMapping(path = { "/getRequestDemo" }, method = RequestMethod.GET)
	public String getRequestDemo(@RequestParam(value = "param1", required = false) int param) {
		System.out.println("get request test ,get param " + param);
		return "success get param";
	}

	/**
	 * 下面的deleteRequestDemo方法只会处理delete请求
	 */
	@RequestMapping(path = { "/deleteRequestDemo" }, method = RequestMethod.DELETE)
	public String deleteRequestDemo(@RequestParam(value = "param1", required = false) int param) {
		System.out.println("delete request test ,get param " + param);
		return "success get param";
	}

}
