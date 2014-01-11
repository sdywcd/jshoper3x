package com.jshop.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.BaseTDao;
@Repository("baseTDao")
public class BaseTDaoImpl<T> extends HibernateDaoSupport implements BaseTDao<T> {

	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

}
