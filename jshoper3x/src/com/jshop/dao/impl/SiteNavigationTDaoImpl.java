package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.SiteNavigationTDao;
import com.jshop.entity.SiteNavigationT;

/**
 * A data access object (DAO) providing persistence and search support for
 * SiteNavigationT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.SiteNavigationT
 * @author MyEclipse Persistence Tools
 */
@Repository("siteNavigationTDao")
public class SiteNavigationTDaoImpl extends BaseTDaoImpl<SiteNavigationT> implements SiteNavigationTDao {
	

	private static final Logger log = LoggerFactory.getLogger(SiteNavigationTDaoImpl.class);
	

	public int countfindAllSiteNavigationT(String creatorid) {
		log.debug("countfindAllSiteNavigationT");
		try {
			String queryString = "select count(*) from SiteNavigationT as sn where  sn.creatorid=:creatorid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllSiteNavigationT error", re);
			throw re;
		}
	}

	public int delSiteNavigationT(final String[] list) {
		log.debug("delSiteNavigationT");
		try {

			final String queryString = "delete from SiteNavigationT as sn where sn.snid=:snid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("snid", s);
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
			log.error("delSiteNavigationT failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<SiteNavigationT> findAllSiteNavigationT(final int currentPage, final int lineSize, final String creatorid) {
		log.debug("findAllSiteNavigationT");
		try {
			List<SiteNavigationT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from SiteNavigationT as sn where sn.creatorid=:creatorid  order by position desc";

				@SuppressWarnings("unchecked")
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
			log.error("findAllArticleT error", re);
			throw re;
		}
	}

	public int updateSiteNavigationT(SiteNavigationT sn) {
		log.debug("updateSiteNavigationT");
		try {
			this.getHibernateTemplate().update(sn);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("updateSiteNavigationT", re);
			throw re;
		}
	}

	public SiteNavigationT findSiteNavigationBysnid(String snid) {
		log.debug("getting ArticleT instance with id: " + snid);
		try {
			SiteNavigationT instance = (SiteNavigationT) this.getHibernateTemplate().get("com.jshop.entity.SiteNavigationT", snid);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<SiteNavigationT> findSiteNavigationByposition(String isVisible, String position, String creatorid) {
		log.debug("findSiteNavigationByposition");
		try {
			String queryString = "from SiteNavigationT as sn where sn.isVisible=:isVisible and sn.position=:position and sn.creatorid=:creatorid order by sort desc";
			List<SiteNavigationT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "isVisible", "position", "creatorid" }, new Object[] { isVisible, position, creatorid });
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findArticleCategoryByGrade error", re);
			throw re;
		}
	}

	public List<SiteNavigationT> findSiteNavigationByisVisible(String isVisible, String creatorid) {
		log.debug("findSiteNavigationByisVisible");
		try {
			String queryString = "from SiteNavigationT as sn where sn.isVisible=:isVisible and  sn.creatorid=:creatorid order by sort desc";
			List<SiteNavigationT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "isVisible", "creatorid" }, new Object[] { isVisible, creatorid });
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findSiteNavigationByisVisible error", re);
			throw re;
		}
	}

	public List<SiteNavigationT> findSiteNavigationByisVisible(String isVisible) {
		log.debug("findSiteNavigationByisVisible");
		try {
			String queryString = "from SiteNavigationT as sn where sn.isVisible=:isVisible order by sort desc";
			List<SiteNavigationT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "isVisible" }, new Object[] { isVisible });
			return list;
		} catch (RuntimeException re) {
			log.error("findSiteNavigationByisVisible error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SiteNavigationT> sortAllSiteNavigationT(final int currentPage, final int lineSize, final String creatorid, final String queryString) {
		log.debug("findAllSiteNavigationT");
		try {
			List<SiteNavigationT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				@SuppressWarnings("unchecked")
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
			log.error("findAllArticleT error", re);
			throw re;
		}
	}
}