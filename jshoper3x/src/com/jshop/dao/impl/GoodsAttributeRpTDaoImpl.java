package com.jshop.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GoodsAttributeRpTDao;
import com.jshop.entity.GoodsAttributeRpT;
@Repository("goodsAttributeRpTDao")
public class GoodsAttributeRpTDaoImpl extends HibernateDaoSupport  implements GoodsAttributeRpTDao {
	private static final Logger log = LoggerFactory.getLogger(TemplatesetTDaoImpl.class);
	
	@Override
	public void saveGoodsAttributeRpT(GoodsAttributeRpT gart) {
		log.debug("save TemplatesetT");
		try {
			this.getHibernateTemplate().save(gart);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

}
