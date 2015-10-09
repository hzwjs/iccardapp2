package com.iccardapp.service;

import java.io.Writer;

public interface IResourceService {

	/**
	 * 根据操作员的的ID获取权限，再返回菜单树的节点并传到前端
	 * 
	 * @param userId
	 * @param w
	 */
	public void tree(String userId, Writer w);

	/**
	 * 获取数据库中所有的功能节点
	 * 
	 * @param w
	 */
	public void tree(Writer w);
	
	/**
	 * 获取某一角色拥有的功能节点
	 * 
	 * @param roleId
	 */
	public void treeByRole(String roleId, Writer w);
}
