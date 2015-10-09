package com.iccardapp.service;

import java.util.Map;

import com.iccardapp.common.vo.Grid;

/**
 * 通用管理
 * 
 * @author hzw-pc
 */
public interface ICommonService {

	/**
	 * 返回由于显示的表格对象
	 * 
	 * @param page
	 * @param rows
	 * @param params
	 * @return
	 */
	public Grid page(int page, int rows, Map<String, Object> params);

	/**
	 * 保存和更新
	 * 
	 * @param obj
	 */
	public Boolean saveOrUpdate(Object obj);

	/**
	 * 删除信息
	 * 
	 * @param obj
	 */
	public Boolean delete(Object obj);
	
}
