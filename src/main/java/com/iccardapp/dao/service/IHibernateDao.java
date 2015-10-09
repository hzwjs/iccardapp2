package com.iccardapp.dao.service;


import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author huangzhiwen
 * 以对象的方式操作数据库
 * @param <T>
 */
@Repository
@Transactional
public interface IHibernateDao<T> {
	
	
	/**
	 * @param o
	 * 新增
	 */
	public void add(T o);
	
	/**
	 * @param c
	 * 更新
	 */
	public void save(Class<T> c);
	
	/**
	 * @param c
	 * 删除
	 */
	public void delfete(Class<T> c);
	
	/**
	 * @param c
	 * @param id
	 * @return
	 * 根据id查询实体
	 */
	public T getById(Class<T> c, Serializable id);
	
	/**
	 * @param c
	 * @return
	 * 根据信息不完整的实体查询符合条件的实体列表
	 */
	public List<T> get(Class<T> c);
}
