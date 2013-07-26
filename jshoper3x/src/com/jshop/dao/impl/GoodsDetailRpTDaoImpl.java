package com.jshop.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jshop.dao.GoodsDetailRpTDao;
import com.jshop.entity.GoodsDetailRpT;

public class GoodsDetailRpTDaoImpl extends HibernateDaoSupport implements
		GoodsDetailRpTDao {
	private static final Logger log = LoggerFactory.getLogger(ArticleCategoryTDaoImpl.class);

	@Override
	public void saveGoodsDetailRpT(GoodsDetailRpT gdrt) {
		log.debug("saveGoodsDetailRpT");
		try {
			this.getHibernateTemplate().save(gdrt);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

}
