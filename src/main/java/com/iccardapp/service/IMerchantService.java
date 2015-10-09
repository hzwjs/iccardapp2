package com.iccardapp.service;

/**
 * @author 志文
 *
 */
public interface IMerchantService {

	/**
	 * 查询指定日期总共有多少条记录
	 * @param date
	 * @return
	 */
	public int queryByDate(String date);
	
}
