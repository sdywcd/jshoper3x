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

import com.jshop.dao.TemplatethemeTDao;
import com.jshop.entity.TemplatethemeT;

/**
 * A data access object (DAO) providing persistence and search support for
 * TemplatethemeT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.TemplatethemeT
 * @author MyEclipse Persistence Tools
 */
@Repository("templatethemeTDao")
public class TemplatethemeTDaoImpl extends BaseTDaoImpl<TemplatethemeT> implements TemplatethemeTDao {
	
	private static final Logger log = LoggerFactory.getLogger(TemplatethemeTDaoImpl.class);
	
	public int countfindAllTemplatetheme(String creatorid) {
		log.debug("countfindAllTemplatetheme");
		try {
			String queryString = "select count(*) from TemplatethemeT as tt where tt.creatorid=:creatorid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllTemplatetheme error", re);
			throw re;
		}
	}
	public int delTemplatetheme(final String[] str) {
		log.debug("del TemplatethemeT");
		try {

			final String queryString = "delete from TemplatethemeT as tt where tt.ttid=:ttid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : str) {
						query.setParameter("ttid", s);
						i = query.executeUpdate();
						i++;
					}
					if (str.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("del TemplatethemeT failed", re);
			throw re;
		}
		return 0;
	}
	public List<TemplatethemeT> findAllTemplatetheme(final int currentPage, final int lineSize, final String creatorid) {
		log.debug("findAllTemplatetheme");
		try {
			List<TemplatethemeT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from TemplatethemeT as tt where tt.creatorid=:creatorid order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("creatorid", creatorid);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findAllTemplatetheme error", re);
			throw re;
		}
	}

	public int checkTemplatethemeBythemenameandsign(String themename,String sign) {
		log.debug("checkTemplatethemeBythemename");
		try {
			String queryString = "from TemplatethemeT as tt where tt.themename=:themename and tt.sign=:sign";
			List<TemplatethemeT> list = this.getHibernateTemplate().findByNamedParam(queryString,new String[]{"themename","sign"},new Object[]{themename,sign});
			if (list != null && list.size() > 0) {
				return 1;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("checkTemplatethemeBythemename error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TemplatethemeT> sortAllTemplatetheme(final int currentPage, final int lineSize, final String creatorid, final String queryString) {
		log.debug("sortAllTemplatetheme");
		try {
			List<TemplatethemeT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("creatorid", creatorid);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("sortAllTemplatetheme error", re);
			throw re;
		}
	}



	public List<TemplatethemeT> findAllTemplatethemeWithNoParam(String creatorid) {
		log.debug("findAllTemplatethemeWithNoParam");
		try {
			String queryString = "from TemplatethemeT as tt where tt.creatorid=:creatorid";
			List<TemplatethemeT> list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findAllTemplatethemeWithNoParam error", re);
			throw re;
		}
	}

	public int updateTemplatethemestatus(final String ttid, final String status) {		
		log.debug("updateTemplatethemestatus");
		try {
			final String queryString = "update TemplatethemeT as tt set tt.status=:status where tt.ttid=:ttid";
			this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("ttid", ttid);
					query.setParameter("status", status);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateTemplatethemestatus error", re);
			throw re;
		}
		return 0;
		
	}

	public int checkTemplatethemeBythemenameandsign(String themename, String sign, String ttid) {
		log.debug("checkTemplatethemeBythemename");
		try {
			String queryString = "from TemplatethemeT as tt where tt.themename=:themename and tt.sign=:sign and tt.ttid!=:ttid";
			List<TemplatethemeT> list = this.getHibernateTemplate().findByNamedParam(queryString,new String[]{"themename","sign","ttid"},new Object[]{themename,sign,ttid});
			if (list != null && list.size() > 0) {
				return 1;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("checkTemplatethemeBythemename error", re);
			throw re;
		}
	}

	public int delTemplatetheme(final String ttid) {
		log.debug("del TemplatethemeT");
		try {

			final String queryString = "delete from TemplatethemeT as tt where tt.ttid=:ttid";
			this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("ttid", ttid);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("del TemplatethemeT failed", re);
			throw re;
		}
		return 0;
	}

	public TemplatethemeT findTemplatethemeBystatus(String status) {
		log.debug("findTemplatethemeBystatus");
		try {
			String queryString = "from TemplatethemeT as tt where tt.status=:status";
			List<TemplatethemeT> list = this.getHibernateTemplate().findByNamedParam(queryString, "status", status);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findTemplatethemeBystatus error", re);
			throw re;
		}
	}

	
}