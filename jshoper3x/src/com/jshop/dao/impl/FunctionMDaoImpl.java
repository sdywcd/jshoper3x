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

import com.jshop.dao.FunctionMDao;
import com.jshop.entity.FunctionM;

/**
 * A data access object (DAO) providing persistence and search support for
 * FunctionM entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.FunctionM
 * @author MyEclipse Persistence Tools
 */
@Repository("functionMDao")
public class FunctionMDaoImpl extends BaseTDaoImpl<FunctionM> implements FunctionMDao {
	private static final Logger log = LoggerFactory.getLogger(FunctionMDaoImpl.class);


	@SuppressWarnings("unchecked")
	public int delFunctionM(final String[] strs) {
		log.debug("delFunctionM");
		try {

			final String queryString = "delete from FunctionM as fm where fm.id=:id";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : strs) {
						query.setParameter("id", s);
						i = query.executeUpdate();
						i++;
					}
					if (strs.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("delFunctionM failed", re);
			throw re;
		}
		return 0;
	}

	public List<FunctionM> findAllFunctionM() {
		log.debug("findAllFunctionM");
		try {
			String queryString = "from FunctionM";
			List<FunctionM> list = this.getHibernateTemplate().find(queryString);
			return list;
		} catch (RuntimeException re) {
			log.error("findAllFunctionM error", re);
			throw re;
		}
	}

	public FunctionM findFunctionMById(String id) {
		log.debug("findFunctionMById");
		try {
			FunctionM instance = (FunctionM) this.getHibernateTemplate().get("com.jshop.entity.FunctionM", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("findFunctionMById failed", re);
			throw re;
		}
	}

	public void updateFunctionM(FunctionM fm) {
		log.debug("updateFunctionM");
		try {
			this.getHibernateTemplate().update(fm);
		} catch (RuntimeException re) {
			log.error("updateFunctionM failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<FunctionM> findAllFunctionMBymoduleid(String moduleid) {
		log.debug("findAllFunctionMBymoduleid");
		try {
			String queryString = "from FunctionM as fm where fm.moduleid=:moduleid";
			List<FunctionM> list = this.getHibernateTemplate().findByNamedParam(queryString, "moduleid", moduleid);
			return list;
		} catch (RuntimeException re) {
			log.error("findAllFunctionMBymoduleid error", re);
			throw re;
		}
	}

	
	
	
	
}