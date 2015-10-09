package com.iccardapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hzw-pc
 * 处理首页的内嵌页面
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/sys/home")
public class IndexSysController {
	@RequestMapping(value = "/system/{jspName}")
	public String toSysJsp(@PathVariable String jspName) {
		return "system/"+jspName;
	}
	
	@RequestMapping(value = "/merchantmanage/{jspName}")
	public String toMerchantJsp(@PathVariable String jspName) {
		return "merchantmanage/"+jspName;
	}

	@RequestMapping(value = "/report/{jspName}")
	public String toReportjsp(@PathVariable String jspName){
		return "reportmanage/"+jspName;
	}
}
