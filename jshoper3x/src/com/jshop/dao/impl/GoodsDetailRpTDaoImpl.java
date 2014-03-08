package com.jshop.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GoodsDetailRpTDao;
import com.jshop.entity.GoodsCategoryT;
import com.jshop.entity.GoodsDetailRpT;

@Repository("goodsDetailRpTDao")
public class GoodsDetailRpTDaoImpl extends BaseTDaoImpl<GoodsDetailRpT>
		implements GoodsDetailRpTDao {
	private static final Logger log = LoggerFactory
			.getLogger(ArticleCategoryTDaoImpl.class);



	@Override
	public GoodsDetailRpT findGoodsDetailRpBygoodsid(String goodsid) {
		log.debug("findGoodsDetailRpBygoodsid");
		try {
			String queryString = "from GoodsDetailRpT as gdrp where gdrp.goodsid=:goodsid";
			List<GoodsDetailRpT> list = this.getHibernateTemplate()
					.findByNamedParam(queryString, "goodsid", goodsid);
			if (!list.isEmpty()) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findGoodsDetailRpBygoodsid error", re);
			throw re;
		}

	}

	@Override
	public void update(GoodsDetailRpT gdrt) {
		log.debug("update GoodsDetailRpT");
		try {
			this.getHibernateTemplate().update(gdrt);
		} catch (RuntimeException re) {
			log.error("update GoodsDetailRpT error", re);
			throw re;
		}
	}

}
