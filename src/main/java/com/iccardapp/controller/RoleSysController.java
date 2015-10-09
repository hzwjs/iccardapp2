package com.iccardapp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iccardapp.common.vo.AjaxResponse;
import com.iccardapp.common.vo.Grid;
import com.iccardapp.entity.PbmsgRole;
import com.iccardapp.service.ICommonService;
import com.iccardapp.service.IRoleService;

/**
 * 角色管理
 * 
 * @author hzw-pc
 *
 */
@Controller
@RequestMapping(value = "/sys/manage/role")
public class RoleSysController {

	private static Logger logger = LoggerFactory
			.getLogger(RoleSysController.class);

	@Autowired
	private @Qualifier("roleSysImpl") ICommonService roleService;

	@Autowired
	@Qualifier("roleSysImpl")
	private IRoleService roleService2;

	/**
	 * 获取角色列表数据
	 * 
	 * @param start
	 * @param limit
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/page")
	@ResponseBody
	public Grid page(int start, int limit, HttpSession session) {
		return this.roleService.page(start, limit, null);
	}

	/**
	 * 给角色授予权限
	 */
	@RequestMapping(value = "/grant")
	@ResponseBody
	public AjaxResponse grant(String roleId, String resources) {
		logger.info(roleId);
		logger.info("资源[{}]", resources);
		AjaxResponse ajaxResponse = new AjaxResponse();
		if("".equals(roleId)){
			ajaxResponse.setCode(AjaxResponse.EXCEPTION);
			return ajaxResponse;
		}
		return roleService2.grant(roleId, resources);
	}

	/**
	 * 新增或修改保存角色
	 */
	@RequestMapping(value = "/saveorupdate")
	@ResponseBody
	public AjaxResponse saveOrUpdate(PbmsgRole role) {

		String role_id = getId();
		role.setRoleId(role_id);
		roleService.saveOrUpdate(role);
		AjaxResponse ajaxResponse = new AjaxResponse();
		ajaxResponse.setCode(AjaxResponse.SUCCESS);
		return ajaxResponse;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/getid")
	@ResponseBody
	public String getId() {
		// 生成ID
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String date = sf.format(new Date());
		int index = roleService2.queryByDate(date) + 1;
		String role_id = date + index;
		return role_id;
	}

	/**
	 * 删除角色
	 * 
	 * @param obj
	 * @return
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public AjaxResponse delete(PbmsgRole obj) {
		AjaxResponse ajaxResponse = new AjaxResponse();
		if (roleService.delete(obj)) {
			ajaxResponse.setCode(AjaxResponse.SUCCESS);
		} else {
			ajaxResponse.setCode(AjaxResponse.FAILURE);
		}
		return ajaxResponse;
	}

	/**
	 * 获取所有角色
	 * 
	 * @param re
	 * @throws IOException
	 */
	@RequestMapping(value = "/allrole")
	@ResponseBody
	public void getAllRole(HttpServletResponse re) throws IOException {
		roleService2.tree(re.getWriter());
	}

	/**
	 * 用户拥有的角色
	 * 
	 * @param userId
	 * @param re
	 * @throws IOException
	 */
	@RequestMapping(value = "/rolebyuserid")
	@ResponseBody
	public void roleByUserid(String userId, HttpServletResponse re)
			throws IOException {
		roleService2.roleByUserid(userId, re.getWriter());
	}

	/**
	 * 给用户赋予角色
	 * @param userId
	 * @param roles
	 */
	@RequestMapping(value = "/roletouser")
	@ResponseBody
	public AjaxResponse roleToUser(String userId, String roles) {
		logger.info(userId);
		logger.info("资源[{}]", roles);

		return roleService2.roleToUser(userId, roles);
	}
}
