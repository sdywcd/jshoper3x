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

import com.jshop.dao.KeywordTDao;
import com.jshop.entity.KeywordT;

/**
 * A data access object (DAO) providing persistence and search support for
 * KeywordT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.KeywordT
 * @author MyEclipse Persistence Tools
 */
@Repository("keywordTDao")
public class KeywordTDaoImpl extends BaseTDaoImpl<KeywordT> implements KeywordTDao {
	
	private static final Log log = LogFactory.getLog(KeywordTDaoImpl.class);
	

	public int countAllKeywordT() {
		log.debug("count all KeywordT");
		try {
			String queryString = "select count(*) from KeywordT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all KeywordT error", re);
			throw re;
		}
	}

	public int delKeywordT(final String[] list) {
		log.debug("del KeywordT");
		try {

			final String queryString = "delete from  KeywordT as kt where kt.keywordid=:keywordid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("keywordid", s);
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
			log.error("del KeywordT failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<KeywordT> findAllKeywordT(final int currentPage, final int lineSize) {
		log.debug("find all KeywordT");
		try {
			List<KeywordT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from KeywordT  as kt order by kt.sort asc and kt.state asc and kt.createtime desc";

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
			log.error("find all KeywordT error", re);
			throw re;
		}
	}

	public KeywordT findKeywordById(String keywordid) {
		log.debug("find by id KeywordT");
		try {
			String queryString = "from KeywordT as kt where kt.keywordid=:keywordid";
			List<KeywordT> list = this.getHibernateTemplate().findByNamedParam(queryString, "keywordid", keywordid);
			if (list != null) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id KeywordT error", re);
			throw re;
		}
	}

	public int updateKeywordT(final KeywordT kt) {
		log.debug("update KeywordT");
		try {
			final String queryString = "update KeywordT as kt set kt.keywordname=:keywordname,kt.creatorid=:creatorid,kt.sort=:sort,kt.createtime=:createtime,kt.state=:state,kt.type=:type where kt.keywordid=:keywordid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("keywordname", kt.getKeywordname());
					query.setParameter("creatorid", kt.getCreatorid());
					query.setParameter("sort", kt.getSort());
					query.setParameter("state", kt.getState());
					query.setParameter("type", kt.getType());
					query.setParameter("createtime", kt.getCreatetime());
					query.setParameter("keywordid", kt.getKeywordid());
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  KeywordT error", re);
			throw re;
		}
		return 0;
	}

	public int updatekeywordsearchcount(String keywordname) {
		log.debug("update searchcount by keywordname");
		try {
			String queryString = "update KeywordT as kt set kt.searchCount=kt.searchCount+1 where kt.keywordname=:keywordname";
			int i = this.getHibernateTemplate().bulkUpdate(queryString, keywordname);
			if (i > 0) {
				return i;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("find by id KeywordT error", re);
			throw re;
		}
	}

	public List<KeywordT> findAllKeywordTjson() {
		log.debug("find keyword state!=2");
		try {
			String queryString = "from KeywordT as kt where kt.state!=2";
			List<KeywordT> list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find keyword state!=2 error", re);
			throw re;
		}
	}

	public List<KeywordT> findKeywordLimit(final int limit) {
		log.debug("find keyword findKeywordLimit state!=2");
		try {
			List<KeywordT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from KeywordT as kt where kt.state!=2 and kt.type='1'";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setMaxResults(limit);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find keyword findKeywordLimit state!=2 error", re);
			throw re;
		}
	}
}