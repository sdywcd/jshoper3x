package com.jshop.dao.impl;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.BaseTDao;
@Repository("baseTDao")
public class BaseTDaoImpl<T> extends HibernateDaoSupport implements BaseTDao<T> {
	private static final Logger log = LoggerFactory.getLogger(BaseTDaoImpl.class);


	@Override
	public void save(T t) {
		try{
			this.getHibernateTemplate().save(t);
		}catch(RuntimeException re){
			log.error("save "+t.getClass().getName()+" error", re);
			throw re;
		}
	}

	@Override
	public void update(T t) {
		try{
			this.getHibernateTemplate().update(t);
		}catch(RuntimeException re){
			log.error("update "+t.getClass().getName()+" error",re);
		}
		
	}

	@Override
	public void delete(T t) {
		try{
			this.getHibernateTemplate().delete(t);
		}catch(RuntimeException re){
			log.error("delete "+t.getClass().getName()+" error",re);
		}
	}
	
	@Override
	public T findByPK(Class<T>t, Serializable id) {
		return (T) this.getHibernateTemplate().get(t, id);
	
	}

}
