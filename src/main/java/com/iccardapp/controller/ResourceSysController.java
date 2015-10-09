package com.iccardapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iccardapp.service.IResourceService;
import com.iccardapp.util.BizUtil;

@Controller
@RequestMapping(value = "/sys/manage/resource")
public class ResourceSysController {
	@Autowired
	private IResourceService resourceService;

	/**
	 * 获取当前用户有权限访问的功能节点
	 * 
	 * @param session
	 * @param re
	 */
	@RequestMapping(value = "/tree")
	@ResponseBody
	public void getTree(HttpSession session, HttpServletResponse re) {
		String userId = BizUtil.getUserId(session);
		try {
			resourceService.tree(userId, re.getWriter());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取所有的功能节点
	 * 
	 * @param re
	 * @throws IOException
	 */
	@RequestMapping(value = "/alltree")
	@ResponseBody
	public void getAll(HttpServletResponse re) throws IOException {
		resourceService.tree(re.getWriter());
	}

	/**
	 * 获取某一角色拥有的功能节点
	 * 
	 * @param roleId
	 * @throws IOException
	 */
	@RequestMapping(value = "/roletotree")
	@ResponseBody
	public void getTreeByRole(String roleId, HttpServletResponse re)
			throws IOException {
		resourceService.treeByRole(roleId, re.getWriter());
	}

}
