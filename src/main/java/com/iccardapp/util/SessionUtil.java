package com.iccardapp.util;

import javax.servlet.http.HttpSession;

import com.iccardapp.common.vo.GlobalConstant;
import com.iccardapp.common.vo.SessionInfo;

public class SessionUtil {

	/**
	 * 获取session 用户登陆相关信息
	 * 
	 * @param session
	 * @return
	 */
	public static SessionInfo getSessionInfo(HttpSession session) {
		Object obj = session.getAttribute(GlobalConstant.SESSION_INFO);
		if (null != obj) {
			return (SessionInfo) obj;
		}
		return null;
	}

	/**
	 * 获取登录用户编号
	 * 
	 * @return
	 */
	public static String getUserId(HttpSession session) {
		SessionInfo sessionInfo = getSessionInfo(session);
		return null != sessionInfo ? sessionInfo.getId() : null;
	}

}
