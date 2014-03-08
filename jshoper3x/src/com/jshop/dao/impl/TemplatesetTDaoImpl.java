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

import com.jshop.dao.TemplatesetTDao;
import com.jshop.entity.TemplatesetT;

/**
 * A data access object (DAO) providing persistence and search support for
 * TemplatesetT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.TemplatesetT
 * @author MyEclipse Persistence Tools
 */

@Repository("templatesetTDao")
public class TemplatesetTDaoImpl extends BaseTDaoImpl<TemplatesetT> implements TemplatesetTDao {
	
	private static final Logger log = LoggerFactory.getLogger(TemplatesetTDaoImpl.class);
	

	public int countfindAllTemplatesetT(String creatorid) {
		log.debug("countfindAllTemplatesetT");
		try {
			String queryString = "select count(*) from TemplatesetT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllTemplatesetT error", re);
			throw re;
		}
	}

	public int delTemplatesetT(final String[] list) {
		log.debug("delTemplatesetT");
		try {

			final String queryString = "delete from TemplatesetT as tst where tst.tsid=:tsid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("tsid", s);
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
			log.error("delTemplatesetT failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<TemplatesetT> findAllTemplatesetT(final int currentPage, final int lineSize, final String creatorid) {
		log.debug("findAllTemplatesetT");
		try {
			List<TemplatesetT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from TemplatesetT  as tst where tst.creatorid=:creatorid order by createtime desc";

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
			log.error("findAllTemplatesetT error", re);
			throw re;
		}
	}

	public TemplatesetT findTemplatesetTBytsid(String tsid) {
		log.debug("findTemplatesetTBytsid");
		try {
			String queryString = "from TemplatesetT as tst where tst.tsid=:tsid";
			List<TemplatesetT> list = this.getHibernateTemplate().findByNamedParam(queryString, "tsid", tsid);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findTemplatesetTBytsid error", re);
			throw re;
		}
	}

	public int updateTemplatesetT(TemplatesetT tst) {
		log.debug("updateTemplatesetT");
		try {
			this.getHibernateTemplate().update(tst);
			return 1;
		} catch (RuntimeException re) {
			log.error("updateTemplatesetT error", re);
			throw re;
		}
	}

	public List<TemplatesetT> findAllTemplatesetWithNoParam(String creatorid) {
		log.debug("find by id TemplatesetT");
		try {
			String queryString = "from TemplatesetT as tst where tst.creatorid=:creatorid";
			List<TemplatesetT> list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id TemplatesetT error", re);
			throw re;
		}
	}

	public TemplatesetT findTemplatesetTBysystemcontent(String systemcontent, String creatorid) {
		log.debug("findTemplatesetTBysystemcontent");
		try {
			String queryString = "from TemplatesetT as tst where tst.systemcontent=:systemcontent and tst.creatorid=:creatorid";
			List<TemplatesetT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "systemcontent", "creatorid" }, new Object[] { systemcontent, creatorid });
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findTemplatesetTBysystemcontent error", re);
			throw re;
		}
	}

	public TemplatesetT findTemplatesetTBysign(String sign, String creatorid) {
		log.debug("findTemplatesetTBysign");
		try {
			String queryString = "from TemplatesetT as tst where tst.sign=:sign and tst.creatorid=:creatorid";
			List<TemplatesetT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "sign", "creatorid" }, new Object[] { sign, creatorid });
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findTemplatesetTBysign error", re);
			throw re;
		}
	}

	public int updateTemplatesetBystatus(final String themeid, final String status) {
		log.debug("updateTemplatesetBystatus");
		try {
			final String queryString = "update TemplatesetT as tst set tst.status=:status where tst.themeid=:themeid";
			this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("themeid", themeid);
					query.setParameter("status", status);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateTemplatesetBystatus error", re);
			throw re;
		}
		return 0;
	}

	public TemplatesetT findTemplatesetTBysign(String sign) {
		log.debug("findTemplatesetTBysign");
		try {
			String queryString = "from TemplatesetT as tst where tst.sign=:sign";
			List<TemplatesetT> list = this.getHibernateTemplate().findByNamedParam(queryString, "sign", sign);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findTemplatesetTBysign error", re);
			throw re;
		}
	}

	public List<TemplatesetT> findTemplatesetTBystatus(String status) {
		log.debug("findTemplatesetTBystatus");
		try {
			String queryString = "from TemplatesetT as tst where tst.status=:status";
			List<TemplatesetT> list = this.getHibernateTemplate().findByNamedParam(queryString, "status", status);
			return list;
		} catch (RuntimeException re) {
			log.error("findTemplatesetTBystatus error", re);
			throw re;
		}
	}
	
	
	
	
}