package com.iccardapp.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iccardapp.common.vo.AjaxResponse;
import com.iccardapp.common.vo.Grid;
import com.iccardapp.service.IReportService;

@Controller
@RequestMapping("/sys/manage/report")
public class ReportManController {

	@Autowired
	private AjaxResponse ajaxResponse;

	// @Autowired
	// private @Qualifier("reportManImpl") ICommonService reportService;

	@Autowired
	private @Qualifier("reportManImpl") IReportService reportService;

	/**
	 * 查询出的是公司月报表的数据
	 * 
	 * @param start
	 * @param limit
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/companyreport")
	@ResponseBody
	public Grid page(int start, int limit, HttpSession session,	HttpServletRequest request) {

		Map<String, Object> params = new HashMap<String, Object>();
		String month = (String) request.getParameter("qmonth");
		params.put("month", month);
		return this.reportService.page1(start, limit, params);
	}

	/**
	 * 消费刷卡汇总表(后勤)
	 * @param start
	 * @param limit
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/depsumreport")
	@ResponseBody
	public Grid page2(int start, int limit, HttpSession session, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		String stime = (String) request.getParameter("stime");
		String etime = (String) request.getParameter("etime");
		params.put("stime", stime);
		params.put("etime", etime);
		return this.reportService.page2(start, limit, params);
	}
	
	/**
	 * 食堂应用汇总报表
	 * @param start
	 * @param limit
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/terminatorreport")
	@ResponseBody
	public Grid page3(int start, int limit, HttpSession session, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		String stime = (String) request.getParameter("stime");
		String etime = (String) request.getParameter("etime");
		params.put("stime", stime);
		params.put("etime", etime);
		return this.reportService.page3(start, limit, params);
	} 
	
	/**
	 * 食堂IC卡应用交易明细表								
	 * @param start
	 * @param limit
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detialsreport")
	@ResponseBody
	public Grid page4(int start, int limit, HttpSession session, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		String stime = (String) request.getParameter("stime");
		String etime = (String) request.getParameter("etime");
		params.put("stime", stime);
		params.put("etime", etime);
		return this.reportService.page4(start, limit, params);
	} 
	
	@RequestMapping(value = "/detials2report")
	@ResponseBody
	public Grid page5(int start, int limit, HttpSession session, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		String qname = (String) request.getParameter("qname");
		params.put("qname", qname);
		return this.reportService.page5(start, limit, params);
	} 

	@RequestMapping(value = "/download")
	@ResponseBody
	public void download(HttpServletResponse res, HttpServletRequest req) throws IOException {  
		String expFileName = req.getParameter("expfilename");
		
		// 获取java项目编译后根路径
		URL url = this.getClass().getClassLoader().getResource("");
		File file = new File(url.getFile());
		String path = file.getPath();
		// 报表文件
		String expFilePath = path + File.separator + "download" + File.separator + expFileName;
	    OutputStream os = res.getOutputStream();  
	    File file2 = new File(expFilePath);
	    try {  
	        res.reset();  
	        res.setContentType("text/html;charset=UTF-8");
	        res.setHeader("Content-Disposition", "attachment; filename="+ new String(expFileName.getBytes("gb2312"),"ISO-8859-1"));  
	        res.setContentType("application/octet-stream; charset=utf-8");  
	        os.write(FileUtils.readFileToByteArray(file2));  
	        os.flush();  
	    } finally {  
	        if (os != null) {  
	            os.close();  
	        }  
	    }  
	}  
	

}
