package com.iccardapp.dao.impl;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iccardapp.dao.service.IHibernateDao;



@Repository
public class HibernateDao<T> implements IHibernateDao<T>{
	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory
	 *            构造DAO
	 */
	@Autowired
	public HibernateDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return 获取当前Session
	 */
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * @param o
	 *            新增
	 */
	public void add(T o) {
		currentSession().save(o);
	}

	/**
	 * @param c
	 *            更新
	 */
	public void save(Class<T> c) {
		currentSession().update(c);
	}

	/**
	 * @param c
	 *            删除
	 */
	public void delfete(Class<T> c) {
		currentSession().delete(c);
	}

	/**
	 * @param c
	 * @param id
	 * @return 根据id查询实体
	 */
	@SuppressWarnings("unchecked")
	public T getById(Class<T> c, Serializable id) {
		return (T) this.currentSession().get(c, id);
	}

	/**
	 * @param c
	 * @return 根据信息不完整的实体查询符合条件的实体列表
	 */
	@SuppressWarnings("unchecked")
	public List<T> get(Class<T> c) {
		Criteria tCriteria = currentSession().createCriteria(c);
		List<T> lists = tCriteria.list();
		return lists;
	}

}
