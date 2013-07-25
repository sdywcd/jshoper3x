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

import com.jshop.dao.OutsideGoodsTwocodeRelationshipTDao;
import com.jshop.entity.OutsidegoodsTwocodeRelationshipT;
@Repository("outsideGoodsTwocodeRelationshipTDao")
public class OutsidegoodsTwocodeRelationshipTImpl extends HibernateDaoSupport implements OutsideGoodsTwocodeRelationshipTDao {


	private static final Logger log = LoggerFactory.getLogger(GoodsTwocodeRelationshipTDaoImpl.class);
	
	@Override
	public int addGoodsQRCode(OutsidegoodsTwocodeRelationshipT qrcode) {
		try {
			log.debug("add OutsidegoodsTwocodeRelationshipT success");
			this.getHibernateTemplate().save(qrcode);
			return 1;
		} catch (RuntimeException e) {
			log.error("add OutsidegoodsTwocodeRelationshipT failed");
			throw e;
		}
	}

	@Override
	public OutsidegoodsTwocodeRelationshipT findGoodsQRCodeByGoodsid(final String id) {
		try {
			final String queryString="from OutsidegoodsTwocodeRelationshipT as gc where gc.id=:id";
			List<OutsidegoodsTwocodeRelationshipT> list = this.getHibernateTemplate().findByNamedParam(queryString, "id", id);
			if(!list.isEmpty()){
				return list.get(0);
			}
			return null;
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@Override
	public int updateGoodsQRCode(final String id,final String twocodepath) {
		try {
			final String queryString="update OutsidegoodsTwocodeRelationshipT as gc set gc.twocodepath=:twocodepath where gc.id=:id ";
			this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session seesion) throws HibernateException,
						SQLException {
					int i=0;
					Query query = seesion.createQuery(queryString);
					query.setParameter("id", id);
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
