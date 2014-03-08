package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.JshopbasicInfoTDao;
import com.jshop.entity.JshopbasicInfoT;

/**
 * A data access object (DAO) providing persistence and search support for
 * JshopbasicInfoT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.JshopbasicInfoT
 * @author MyEclipse Persistence Tools
 */
@Repository("jshopbasicInfoTDao")
public class JshopbasicInfoTDaoImpl extends BaseTDaoImpl<JshopbasicInfoT> implements JshopbasicInfoTDao {
	
	private static final Log log = LogFactory.getLog(JshopbasicInfoTDaoImpl.class);
	
	public int countfindAllJshopbasicInfo(String creatorid) {
		log.debug("count all countfindAllJshopbasicInfo");
		try {
			String queryString = "select count(*) from JshopbasicInfoT as jbi where jbi.creatorid=:creatorid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all JshopbasicInfoT error", re);
			throw re;
		}
	}

	public int delJshopbasicInfo(final String[] list, final String creatorid) {
		log.debug("del DelJshopbasicInfo");
		try {

			final String queryString = "delete from JshopbasicInfoT as jbi where jbi.basicinfoid=:basicinfoid and jbi.creatorid=:creatorid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("basicinfoid", s);
						query.setParameter("creatorid", creatorid);
						i = query.executeUpdate();
						i++;
					}
					if (list.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("del DelJshopbasicInfo failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<JshopbasicInfoT> findAllJshopbasicInfo(final int currentPage, final int lineSize, final String creatorid) {
		log.debug("find all JshopbasicInfoT");
		try {
			List<JshopbasicInfoT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from JshopbasicInfoT as jbi where jbi.creatorid=:creatorid";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("creatorid", creatorid);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("find all brand error", re);
			throw re;
		}
	}

	public JshopbasicInfoT findJshopbasicInfoTById(String basicinfoid) {
		log.debug("find by id JshopbasicInfoT");
		try {
			String queryString = "from JshopbasicInfoT as jbi where jbi.basicinfoid=:basicinfoid";
			List<JshopbasicInfoT> list = this.getHibernateTemplate().findByNamedParam(queryString, "basicinfoid", basicinfoid);
			if(!list.isEmpty()){
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id JshopbasicInfoT error", re);
			throw re;
		}
	}

	public void updateJshopbasicInfo(JshopbasicInfoT jbi) {
		log.debug("updateJshopbasicInfo");
		try {
			this.getHibernateTemplate().update(jbi);
		} catch (RuntimeException re) {
			log.error("update  BrandT error", re);
			throw re;
		}
	}

	public int updateJshopbasicInfostate(final String basicinfoid, final String state) {
		log.debug("update updateJshopbasicInfostate");
		try {

			final String queryString = "update JshopbasicInfoT as jbi set jbi.state=:state where jbi.basicinfoid=:basicinfoid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("basicinfoid", basicinfoid);
					query.setParameter("state", state);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  BrandT error", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public JshopbasicInfoT findJshopbasicInfoSingleForExpress(final String creatorid) {
		log.debug("find  findJshopbasicInfoSingleForExpress");
		try {
			List<JshopbasicInfoT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from JshopbasicInfoT as jbi where jbi.state='1' and jbi.creatorid=:creatorid";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setMaxResults(1);
					query.setParameter("creatorid", creatorid);
					List list = query.list();
					return list;
				}
			});
			if(!list.isEmpty()){
				return list.get(0);
			}
			return null;
			
		} catch (RuntimeException re) {
			log.error("find all brand error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<JshopbasicInfoT> findJshopbasicInfoBycreatorid(String creatorid) {
		log.debug("find by id findJshopbasicInfoBycreatorid");
		try {
			String queryString = "from JshopbasicInfoT as jbi where jbi.creatorid=:creatorid";
			List<JshopbasicInfoT> list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			return list;
			
		} catch (RuntimeException re) {
			log.error("find by id findJshopbasicInfoBycreatorid error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<JshopbasicInfoT> findAllJshopbasicInfoNoParam(final int currentPage, final int lineSize, final String state) {
		log.debug("find all findAllJshopbasicInfoNoParam");
		try {
			List<JshopbasicInfoT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from JshopbasicInfoT as jbi where jbi.state=:state and jbi.openstate=:openstate";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("state", state);
					query.setParameter("openstate", state);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("find all findAllJshopbasicInfoNoParam error", re);
			throw re;
		}
	}

	public JshopbasicInfoT findJshopbasicInfoBystateandopstate(String creatorid, String state, String openstate) {
		log.debug("find by id JshopbasicInfoT");
		try {
			String queryString = "from JshopbasicInfoT as jbi where jbi.creatorid=:creatorid and jbi.state=:state and jbi.openstate=:openstate";
			List<JshopbasicInfoT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "creatorid", "state", "openstate" }, new Object[] { creatorid, state, openstate });
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id JshopbasicInfoT error", re);
			throw re;
		}
	}

	public JshopbasicInfoT findJshopbasicInfoBystateandopstate(String state, String openstate) {
		log.debug("find by id JshopbasicInfoT");
		try {
			String queryString = "from JshopbasicInfoT as jbi where  jbi.state=:state and jbi.openstate=:openstate";
			List<JshopbasicInfoT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "state", "openstate" }, new Object[] { state, openstate });
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id JshopbasicInfoT error", re);
			throw re;
		}
	}

	@Override
	public JshopbasicInfoT findAllJshopbasicInfo(String creatorid) {
		log.debug("find by findAllJshopbasicInfo");
		try {
			String queryString = "from JshopbasicInfoT as jbi where  jbi.creatorid=:creatorid";
			List<JshopbasicInfoT> list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findAllJshopbasicInfo error", re);
			throw re;
		}
	}
}