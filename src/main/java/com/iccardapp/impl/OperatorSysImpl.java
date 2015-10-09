package com.iccardapp.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iccardapp.common.vo.Grid;
import com.iccardapp.dao.service.IBaseDao;
import com.iccardapp.entity.Operators;
import com.iccardapp.service.ICommonService;

/**
 * 用户管理相关的操作
 * 
 * @author hzw-pc
 */
@Service
@Transactional
public class OperatorSysImpl implements ICommonService {

	@Autowired
	private IBaseDao<Operators> operatorDao;

	/*
	 * 获取用于显示的用户信息表格对象
	 * 
	 * @see com.iccardapp.service.IOperatorService#page(int, int, java.util.Map)
	 */
	public Grid page(int page, int rows, Map<String, Object> params) {
		Grid grid = new Grid();
		Operators user = operatorDao.get(Operators.class,
				(String) params.get("userId"));
		params.clear();
		if (Integer.parseInt(user.getLev().trim()) >= 20) {// 超级管理员
			String hql = "from Operators t where t.lev<20";
			grid.setRows(this.operatorDao.find(hql, page, rows));
			grid.setTotal(this.operatorDao
					.count("select count(*) from Operators t where t.lev<20"));
		}
		return grid;
	}

	/*
	 * 用户信息的保存和更新
	 * 等级是为了更细的权限控制
	 * @see
	 * com.iccardapp.service.IOperatorService#saveOrUpdate(java.lang.Object)
	 */
	public Boolean saveOrUpdate(Object obj) {
		try {
			Operators oper = (Operators) obj;
			oper.setLev("1");
			operatorDao.saveOrUpdate(oper);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 删除用户信息
	 * 
	 * @see com.iccardapp.service.IOperatorService#delete()
	 */
	public Boolean delete(Object obj) {
		try {
			operatorDao.delete((Operators) obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
