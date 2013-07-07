package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.PageTDao;
import com.jshop.entity.PageT;

/**
 * A data access object (DAO) providing persistence and search support for PageT
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.jshop.entity.PageT
 * @author MyEclipse Persistence Tools
 */
@Repository("pageTDao")
public class PageTDaoImpl extends HibernateDaoSupport implements PageTDao {
	

	private static final Log log = LogFactory.getLog(PageTDaoImpl.class);
	
	public int addPaget(PageT pt) {
		log.debug("save PageT");
		try {
			this.getHibernateTemplate().save(pt);
			return 1;
		} catch (RuntimeException re) {
			log.error("save PageT", re);
			throw re;
		}
	}

	public int countfindAllPaget() {
		log.debug("count all PageT");
		try {
			String queryString = "select count(*) from PageT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all PageT error", re);
			throw re;
		}
	}

	public int delPaget(final String[] list) {
		log.debug("del PageT");
		try {

			final String queryString = "delete from PageT as pt where pt.pageid=:pageid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("pageid", s);
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
			log.error("del PageT failed", re);
			throw re;
		}
		return 0;
	}

	public List<PageT> findAllPaget(final int currentPage, final int lineSize) {
		log.debug("find all PageT");
		try {
			List<PageT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from PageT  order by createtime desc";

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
			log.error("find all PageT error", re);
			throw re;
		}
	}

	public int updatePaget(final PageT pt) {
		//		log.debug("update PageT");
		//		try{
		//			final String queryString="update PageT as pt set pt.pagename=:pagename,pt.pagenameen=:pagenameen,pt.url=:url,pt.rangearea=:rangearea,pt.createtime=:createtime,pt.creatorid=:creatorid,pt.canedit=:canedit where pt.pageid=:pageid ";
		//			this.getHibernateTemplate().execute(new HibernateCallback(){
		//				public Object doInHibernate(Session session)throws HibernateException,SQLException {
		//					int i=0;
		//					Query query=session.createQuery(queryString);
		//					query.setParameter("pageid", pt.getPageid());
		//					query.setParameter("pagename", pt.getPagename());
		//					query.setParameter("pagenameen", pt.getPagenameen());
		//					query.setParameter("creatorid", pt.getCreatorid());
		//					query.setParameter("url", pt.getUrl());
		//					query.setParameter("createtime", pt.getCreatetime());
		//					query.setParameter("rangearea", pt.getRangearea());
		//					query.setParameter("canedit", pt.getCanedit());
		//					i=query.executeUpdate();
		//					++i;
		//					return i;
		//				}
		//			});
		//		}catch(RuntimeException re){
		//			log.error("update  PageT error",re);
		//			throw re;
		//		}
		return 0;
	}

	public PageT findPagetById(String pageid) {
		log.debug("find by id PageT");
		try {
			String queryString = "from PageT as pt where pt.pageid=:pageid";
			List<PageT> list = this.getHibernateTemplate().findByNamedParam(queryString, "pageid", pageid);
			if (list != null) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id PageT error", re);
			throw re;
		}

	}

	public List<PageT> findAllPagetforPageEdit() {
		log.debug("find by id PageT");
		try {
			String queryString = "from PageT as pt where pt.canedit='1'";
			List<PageT> list = this.getHibernateTemplate().find(queryString);
			if (list != null) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id PageT error", re);
			throw re;
		}

	}
}