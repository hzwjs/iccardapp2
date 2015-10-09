package com.iccardapp.service;

import java.util.Map;

import com.iccardapp.common.vo.Grid;

/**
 * 和报表相关的服务
 * @author 志文
 *
 */
public interface IReportService {
	
	/**
	 * 公司每月报表
	 * @param page
	 * @param rows
	 * @param params
	 * @return
	 */
	public Grid page1(int page, int rows, Map<String, Object> params);
	
	/**
	 * 刷卡消费汇总报表
	 * @param page
	 * @param rows
	 * @param params
	 * @return
	 */
	public Grid page2(int page, int rows, Map<String, Object> params);
	
	/**
	 * 食堂应用汇总报表
	 * @param page
	 * @param rows
	 * @param params
	 * @return
	 */
	public Grid page3(int page, int rows, Map<String, Object> params);

	/**
	 * 食堂IC卡应用交易明细表	
	 * @param start
	 * @param limit
	 * @param params
	 * @return
	 */
	public Grid page4(int start, int limit, Map<String, Object> params);

	/**
	 * 食堂IC卡应用交易明细表	2
	 * @param start
	 * @param limit
	 * @param params
	 * @return
	 */
	public Grid page5(int start, int limit, Map<String, Object> params);

}
