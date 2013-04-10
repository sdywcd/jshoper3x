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

import com.jshop.dao.PageEditareaTDao;
import com.jshop.entity.PageEditareaT;

/**
 * A data access object (DAO) providing persistence and search support for
 * PageEditareaT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.PageEditareaT
 * @author MyEclipse Persistence Tools
 */
@Repository("pageEditareaTDao")
public class PageEditareaTDaoImpl extends HibernateDaoSupport implements PageEditareaTDao {
	
	private static final Log log = LogFactory.getLog(PageEditareaTDaoImpl.class);
	

	public int addPageEditareaT(PageEditareaT pea) {
		log.debug("save PageEditareaT");
		try {
			this.getHibernateTemplate().save(pea);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public List<PageEditareaT> findPageEditareaTByPageidandTypeid(final String pageid, final String typeid) {
		log.debug("find all PageEditareaT");
		try {
			List<PageEditareaT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from PageEditareaT  as pea where pea.pageid=:pageid and pea.typeid=:typeid";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter("pageid", pageid);
					query.setParameter("typeid", typeid);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all PageEditareaT error", re);
			throw re;
		}
	}

	public int updatePageEditareaT(final PageEditareaT pea) {
		log.debug("update PageEditareaT");
		try {
			this.getHibernateTemplate().update(pea);
			return 1;
		} catch (RuntimeException re) {
			log.error("update  PageEditareaT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<PageEditareaT> findAllPageEditareaT(final int currentPage, final int lineSize, final String creatorid) {
		log.debug("find all PageEditareaT");
		try {
			List<PageEditareaT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from PageEditareaT as pea where pea.creatorid=:creatorid order by state asc";

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
			log.error("find all PageEditareaT error", re);
			throw re;
		}
	}

	public int countfindAllPageEditareaT(String creatorid) {
		log.debug("count all PageEditareaT");
		try {
			String queryString = "select count(*) from PageEditareaT as pea where pea.creatorid=:creatorid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all PageEditareaT error", re);
			throw re;
		}
	}

	public int updatePageEditareaTBystate(final String[] list, final String state, final String creatorid) {
		log.debug("UpdatePageEditareaTBystate");
		try {

			final String queryString = "Update  PageEditareaT as pea set pea.state=:state where pea.pageeditareaid=:pageeditareaid and pea.creatorid=:creatorid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("pageeditareaid", s);
						query.setParameter("state", state);
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
			log.error("UpdatePageEditareaTBystate", re);
			throw re;
		}
		return 0;
	}

	public PageEditareaT findPageEditareaById(String pageeditareaid) {
		log.debug("find by id PageEditareaT");
		try {
			String queryString = "from PageEditareaT as pea where pea.pageeditareaid=:pageeditareaid";
			List<PageEditareaT> list = this.getHibernateTemplate().findByNamedParam(queryString, "pageeditareaid", pageeditareaid);
			if (list != null) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id PageEditareaT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<PageEditareaT> findPageEditareaTByPageidandTypeidandState(final String pageid, final String typeid, final String state) {
		log.debug("find all PageEditareaT state");
		try {
			List<PageEditareaT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from PageEditareaT  as pea where pea.pageid=:pageid and pea.typeid=:typeid and pea.state=:state";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter("pageid", pageid);
					query.setParameter("typeid", typeid);
					query.setParameter("state", state);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all PageEditareaT error state", re);
			throw re;
		}
	}

	public List<PageEditareaT> findPageEditareaTByTid(String tid, String creatorid) {
		log.debug("findPageEditareaTByTid");
		try {
			String queryString = "from PageEditareaT as pea where pea.tid=:tid and pea.creatorid=:creatorid";
			List<PageEditareaT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "tid", "creatorid" }, new Object[] { tid, creatorid });
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findPageEditareaTByTid error", re);
			throw re;
		}
	}

	public List<PageEditareaT> findPageEditareaTBySign(String sign, String state, String creatorid) {
		log.debug("findPageEditareaTBySign");
		try {
			String queryString = "from PageEditareaT as pea where pea.sign=:sign and pea.creatorid=:creatorid and pea.state=:state";
			List<PageEditareaT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "sign", "creatorid", "state" }, new Object[] { sign, creatorid, state });
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findPageEditareaTBySign error", re);
			throw re;
		}
	}

	public int delPageEditareaTBypageeditareaid(final String[] strs,final String state) {
		log.debug("updateHtmlPath");
		try {

			final String queryString = "delete from PageEditareaT as pea where pea.pageeditareaid=:pageeditareaid and pea.state=:state";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for(String s:strs){
						query.setParameter("pageeditareaid", s);
						query.setParameter("state", state);
						i = query.executeUpdate();
					}
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateHtmlPath error", re);
			throw re;
		}
		return 0;
		
	}
	
	
	
	
}