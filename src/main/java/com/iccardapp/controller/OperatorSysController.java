package com.iccardapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iccardapp.common.vo.AjaxResponse;
import com.iccardapp.common.vo.Grid;
import com.iccardapp.entity.Operators;
import com.iccardapp.service.ICommonService;
import com.iccardapp.util.SessionUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/sys/manage/operator")
public class OperatorSysController {

	@Autowired
	private @Qualifier("operatorSysImpl") ICommonService operatorService;
	
	/**
	 * @param operator
	 * @return
	 * 添加或更新操作员信息
	 */
	@RequestMapping(value = "/saveorupdate")
	@ResponseBody
	public AjaxResponse saveOrUpdate(Operators operator) {
		//operator.setPassword(MD5Util.md5(operator.getpwd()));
		operatorService.saveOrUpdate(operator);
		AjaxResponse ajaxResponse = new AjaxResponse();
		ajaxResponse.setCode(AjaxResponse.SUCCESS);
		return ajaxResponse;
	}
	
	/**
	 * @param operator
	 * @return
	 * 删除操作员
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public AjaxResponse delete(Operators operator){
		AjaxResponse ajaxResponse = new AjaxResponse();
		if(operatorService.delete(operator)){
			ajaxResponse.setCode(AjaxResponse.SUCCESS);			
		}else{
			ajaxResponse.setCode(AjaxResponse.FAILURE);		
		}
		
		return ajaxResponse;
	}
	
	@RequestMapping(value = "/page")
	@ResponseBody
	public Grid page(int start, int limit, HttpSession session) {
		Map<String, Object> params = new HashMap<String, Object>();
		String userId = SessionUtil.getUserId(session);
		params.put("userId", userId);
		return this.operatorService.page(start, limit, params);
	}

}
