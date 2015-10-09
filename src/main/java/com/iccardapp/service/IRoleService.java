package com.iccardapp.service;

import java.io.Writer;

import com.iccardapp.common.vo.AjaxResponse;


/**
 * @author 志文
 *
 */
public interface IRoleService {

	/**
	 * 为角色授权
	 * @param roleId
	 * @param resources
	 * @return 
	 */
	public AjaxResponse grant(String roleId, String resources);
	
	/**
	 * 查询指定日期总共有多少条记录
	 * @param date
	 * @return
	 */
	public int queryByDate(String date);
	
	/**
	 * 获取所有的角色
	 * @param w
	 */
	public void tree(Writer w);
	
	/**
	 * 用户拥有的角色
	 * @param roleId
	 * @param w
	 */
	public void roleByUserid(String userId, Writer w);
	
	/**
	 * 给用户赋予角色
	 * @param userId
	 * @param roles
	 * @return 
	 */
	public AjaxResponse roleToUser(String userId, String roles);

}
