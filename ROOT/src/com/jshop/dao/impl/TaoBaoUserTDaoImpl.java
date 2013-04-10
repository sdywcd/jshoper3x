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
import com.jshop.dao.TaoBaoUsertDao;
import com.jshop.entity.TaobaoUserT;
@Repository("taoBaoUsertDao")
public class TaoBaoUserTDaoImpl extends HibernateDaoSupport implements TaoBaoUsertDao {
	
	private static final Logger log = LoggerFactory.getLogger(TaoBaoUserTDaoImpl.class);
	
	public int addTaoBaoUserT(TaobaoUserT taobao) {
		
		log.debug("saving TaobaoUserT instance");
		try {
			this.getHibernateTemplate().save(taobao);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}

	}

	@SuppressWarnings("unchecked")
	public List<TaobaoUserT> findAllTaobaoUserT(final int currentPage, final int lineSize) {
		// TODO Auto-generated method stub
		log.debug("finding all TaobaoUserT instances");
		try {
			List<TaobaoUserT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from TaobaoUserT";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all TaobaoUserT error", re);
			throw re;
		}
	}
}
