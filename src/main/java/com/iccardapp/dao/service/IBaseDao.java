package com.iccardapp.dao.service;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 * 基础 DAO 实现在一些基础DAO调用方法
 * 
 * @author huangzhiwen
 *
 * @param <T>
 */
@Repository
@Transactional
public interface IBaseDao<T> {
	/**
	 * 保存一个实体
	 * 
	 * @param o
	 * @return
	 */
	public Serializable save(T o);
	/**
	 * 删除一个实体
	 * 
	 * @param o
	 */
	public void delete(T o);
	/**
	 * 更新一个实体
	 * 
	 * @param o
	 */
	public void update(T o);
	/**
	 * 添加或者更新
	 * 
	 * @param o
	 */
	public void saveOrUpdate(T o);
	/**
	 * 通过类和ID获取对象
	 * 
	 * @param c
	 * @param id
	 * @return
	 */
	public T get(Class<T> c, Serializable id);
	/**
	 * 通过一个HQL获取对象
	 * 
	 * @param hql
	 * @return
	 */
	public T get(String hql);
	/**
	 * 通过HQL，和相关参数获取数据
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public T get(String hql, Map<String, Object> params);
	/**
	 * 获取LIST通过HQL
	 * 
	 * @param hql
	 * @return
	 */
	public List<T> find(String hql);
	/**
	 * 获取通过HQL还有相关参数获取
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public List<T> find(String hql, Map<String, Object> params);
	/**
	 * 分页类型的获取方法
	 * 
	 * @param hql
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<T> find(String hql, int page, int rows);

	/**
	 * 
	 * @param hql
	 * @param params
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<T> find(String hql, Map<String, Object> params, int page, int rows);
	/**
	 * 
	 * @param hql
	 * @return
	 */
	public Long count(String hql);
	/**
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public Long count(String hql, Map<String, Object> params);
	/**
	 * 
	 * @param hql
	 * @return
	 */
	public int executeHql(String hql);
	/**
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public int executeHql(String hql, Map<String, Object> params);
	/**
	 * 
	 * @param sql
	 * @return
	 */
	public List<Object[]> findBySql(String sql);
	/**
	 * 
	 * @param sql
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Object[]> findBySql(String sql, int page, int rows);

	/**
	 * @param sql
	 * @return
	 */
	public T findOneBySql(String sql);
	/**
	 * @param sql
	 * @param params
	 * @param t
	 * @return
	 */
	public T findOneBySql(String sql, Map<String, Object> params, Class<T> t);

	/**
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Object[]> findBySql(String sql, Map<String, Object> params);
	/**
	 * 
	 * @param sql
	 * @param params
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Object[]> findBySql(String sql, Map<String, Object> params, int page, int rows);
	/**
	 * 
	 * @param sql
	 * @return
	 */
	public int executeSql(String sql);
	/**
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeSql(String sql, Map<String, Object> params);
	/**
	 * 
	 * @param sql
	 * @return
	 */
	public BigInteger countBySql(String sql);
	/**
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public Integer countBySql(String sql, Map<String, Object> params);
	/**
	 * 
	 * @param sql
	 * @param index
	 * @param rows
	 * @param t
	 * @return
	 */
	List<T> findBySql(String sql, int index, int rows, Class<T> t);
	/**
	 * 
	 * @param sql
	 * @param params
	 * @param index
	 * @param rows
	 * @param t
	 * @return
	 */
	List<T> findBySql(String sql, Map<String, Object> params, int index, int rows, Class<T> t);
	/**
	 * 
	 * @param sql
	 * @param params
	 * @param t
	 * @return
	 */
	List<T> findBySql(String sql, Map<String, Object> params, Class<T> t);

}
