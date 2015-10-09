package com.iccardapp.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iccardapp.common.Constants;
import com.iccardapp.common.vo.AjaxResponse;
import com.iccardapp.common.vo.GlobalConstant;
import com.iccardapp.common.vo.SessionInfo;
import com.iccardapp.entity.Operators;
import com.iccardapp.service.ILoginService;

@Controller
@RequestMapping(value = "/sys")
public class LoginSysController {
	
	private static Logger logger = LoggerFactory.getLogger(LoginSysController.class);

	@Autowired
	private ILoginService iLoginService;

	@Autowired 
	private AjaxResponse ajaxResponse;

	/**
	 * 跳转至登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toLogin")
	public String loginJsp() {
		logger.info("跳转登录界面！!");
		return "system/login";
	}

	/**
	 * 跳转到后台管理的首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toHome")
	public String homeJsp() {
		logger.info("跳转后台管理首页！!");
		return "system/home";
	}

	/**
	 * 用户登录验证
	 * 
	 * @param SysUser
	 * @return AjaxResponse
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public AjaxResponse login(Operators operators, HttpServletRequest re) {
		
		logger.info("登录验证");
		
		/** 验证密码，如果密码正确返回用户信息实体operator **/
		Operators oper = iLoginService.login(operators);
		if (oper != null) {
			SessionInfo sessionInfo = new SessionInfo();
			sessionInfo.setId(oper.getOperator());
			sessionInfo.setLoginname(oper.getName());
			re.getSession().setAttribute(GlobalConstant.SESSION_INFO, sessionInfo);
			ajaxResponse.setCode(AjaxResponse.SUCCESS);
		} else {
			ajaxResponse.setCode(AjaxResponse.FAILURE);
			ajaxResponse.setMsg(Constants.LOGIN_ERROR);
		}
		return ajaxResponse;
	}
	
	@ResponseBody
	@RequestMapping("/logout")
	public AjaxResponse logout(HttpSession session) {
		AjaxResponse j = new AjaxResponse();
		if (session != null) {
			session.invalidate();
		}
		j.setCode(AjaxResponse.SUCCESS);
		j.setMsg("注销成功！");
		return j;
	}

}
