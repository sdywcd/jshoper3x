package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GoodsTwocodeRelationshipTDao;
import com.jshop.entity.GoodsTwocodeRelationshipT;
@Repository("goodsTwocodeRelationshipTDao")
public class GoodsTwocodeRelationshipTDaoImpl extends HibernateDaoSupport implements
		GoodsTwocodeRelationshipTDao {
	private static final Logger log = LoggerFactory.getLogger(GoodsTwocodeRelationshipTDaoImpl.class);
	
	@Override
	public int addGoodsQRCode(GoodsTwocodeRelationshipT qrcode) {
		try {
			log.debug("add GoodsTwocodeRelationship success");
			this.getHibernateTemplate().save(qrcode);
			return 1;
		} catch (RuntimeException e) {
			log.error("add GoodsTwocodeRelationshipT failed");
			throw e;
		}
	}

	@Override
	public GoodsTwocodeRelationshipT findGoodsQRCodeByGoodsid(final String goodsid) {
		try {
			final String queryString="from GoodsTwocodeRelationshipT as gc where gc.goodsid=:goodsid";
			List<GoodsTwocodeRelationshipT> list = this.getHibernateTemplate().findByNamedParam(queryString, "goodsid", goodsid);
			if(!list.isEmpty()){
				return list.get(0);
			}
			return null;
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@Override
	public int updateGoodsQRCode(final String goodsid,final String twocodepath) {
		try {
			final String queryString="update GoodsTwocodeRelationshipT as gc set gc.twocodepath=:twocodepath where gc.goodsid=:goodsid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session seesion) throws HibernateException,
						SQLException {
					int i=0;
					Query query = seesion.createQuery(queryString);
					query.setParameter("goodsid", goodsid);
					query.setParameter("twocodepath", twocodepath);
					i=query.executeUpdate();
					return i;
				}
			});
			return 0;
		} catch (RuntimeException e) {
			throw e;
		}
	
	}

}
