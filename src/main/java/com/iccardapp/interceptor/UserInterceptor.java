package com.iccardapp.interceptor;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iccardapp.common.Constants;



public class UserInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object obj, Exception err) throws Exception {
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj,
			ModelAndView mav) throws Exception {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj)
			throws Exception {
		// 浏览器传入地址
		String sUri = request.getRequestURI();
		// 登录地址
		String sLoginUrl = request.getContextPath() + "/sys/toLogin";
		
		if (sUri.indexOf("sys") != -1) {// 后台
			// TODO SESSION_INFO
			Object str = (Object) request.getSession().getAttribute(Constants.SESSION_INFO);
			// 重定向到登录界面
			if (str != null || sLoginUrl.equals(sUri) || (sUri.indexOf("login") != -1)) {
				return true;
			}
			response.sendRedirect(sLoginUrl);
		}
		return false;
	}

}
