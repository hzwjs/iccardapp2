package com.iccardapp.service;


import com.iccardapp.entity.Operators;

/**
 * @author hzw-pc
 *
 */
public interface ILoginService {
	
	/**
	 * 登录验证，返回操作员实体
	 * @param operators
	 * @return	
	 */
	public Operators login(Operators operators);
}
