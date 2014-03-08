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

import com.jshop.dao.SystemMailTDao;
import com.jshop.entity.SystemMailT;

/**
 * A data access object (DAO) providing persistence and search support for
 * SystemMailM entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.SystemMailM
 * @author MyEclipse Persistence Tools
 */
@Repository("systemMailTDao")
public class SystemMailTDaoImpl extends BaseTDaoImpl<SystemMailT> implements SystemMailTDao {
	
	private static final Logger log = LoggerFactory.getLogger(SystemMailTDaoImpl.class);
	


	public void updateSystemMail(SystemMailT sm) {
		log.debug("update SystemMailM");
		try {
			this.getHibernateTemplate().update(sm);
		} catch (RuntimeException re) {
			log.error("update  SystemMailM error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SystemMailT> findAllSystemMail() {
		log.debug("find all findAllSystemMail");
		try {
			String queryString = "from SystemMailT";
			List<SystemMailT> list = this.getHibernateTemplate().find(queryString);
			return list;
		} catch (RuntimeException re) {
			log.error("find all findAllSystemMail error", re);
			throw re;
		}
	}

	public SystemMailT findSysmailByid(String id) {
		log.debug("find by id SystemMailM");
		try {
			SystemMailT instance=(SystemMailT) this.getHibernateTemplate().get("com.jshop.entity.SystemMailT", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("find by id SystemMailM error", re);
			throw re;
		}
	}

	@Override
	public int countfindAllSystemMail() {
		log.debug("countfindAllSystemMail");
		try {
			String queryString = "select count(*) from SystemMailT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllSystemMail error", re);
			throw re;
		}
	}

	@Override
	public int delSystemMail(final String id) {
		log.debug("SystemMailT");
		try {
			final String queryString = "delete from  SystemMailT as sm where sm.id=:id ";
			Integer integer=(Integer) this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("id", id);
					i = query.executeUpdate();
					return i;
				}
			});
			return integer;
		} catch (RuntimeException re) {
			log.error("SystemMailT error", re);
			throw re;
		}
	}
	
	
}
