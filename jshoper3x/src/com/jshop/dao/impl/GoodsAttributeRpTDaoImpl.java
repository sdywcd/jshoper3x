package com.jshop.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GoodsAttributeRpTDao;
import com.jshop.entity.FunctionM;
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

	@Override
	public List<GoodsAttributeRpT> findGoodsAttributeRpTBygoodsid(String goodsid) {
		log.debug("findGoodsAttributeRpTBygoodsid");
		try {
			String queryString = "from GoodsAttributeRpT as garpt where garpt.goodsid=:goodsid";
			List<GoodsAttributeRpT> list = this.getHibernateTemplate().findByNamedParam(queryString, "goodsid", goodsid);
			return list;
		} catch (RuntimeException re) {
			log.error("findGoodsAttributeRpTBygoodsid error", re);
			throw re;
		}
	}

	@Override
	public void delByProperty(String property, Object entity) {
		log.debug("delByProperty");
		try {
			this.getHibernateTemplate().delete(property, entity);
		} catch (RuntimeException re) {
			log.error("delByProperty error", re);
			throw re;
		}
	}

	

}
