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

import com.jshop.dao.PlaceoforiginTDao;
import com.jshop.entity.PlaceoforiginT;

/**
 * A data access object (DAO) providing persistence and search support for
 * PlaceoforiginT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.PlaceoforiginT
 * @author MyEclipse Persistence Tools
 */
@Repository("placeoforiginTDao")
public class PlaceoforiginTDaoImpl extends HibernateDaoSupport implements PlaceoforiginTDao {
	

	private static final Log log = LogFactory.getLog(PlaceoforiginTDaoImpl.class);
	

	public int addPlaceoforigint(PlaceoforiginT p) {
		log.debug("save placeofrigint");
		try {
			this.getHibernateTemplate().save(p);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("save placeofrigint error", re);
			throw re;
		}
	}

	public int countfindAllPlaceoforigint() {
		log.debug("count all placeofrigint");
		try {
			String queryString = "select count(*) from PlaceoforiginT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all PlaceoforiginT error", re);
			throw re;
		}
	}

	public int delPlaceoforigint(final String[] list) {
		log.debug("del PlaceoforiginT");
		try {

			final String queryString = "delete from PlaceoforiginT as p where p.placeid=:placeid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("placeid", s);
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
			log.error("del PlaceoforiginT failed", re);
			throw re;
		}
		return 0;
	}

	public List<PlaceoforiginT> findAllPlaceoforigint(final int currentPage, final int lineSize) {
		log.debug("find all PlaceoforiginT");
		try {
			List<PlaceoforiginT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from PlaceoforiginT  order by createtime desc";

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
			log.error("find all PlaceoforiginT error", re);
			throw re;
		}
	}

	public PlaceoforiginT findPlaceoforigintById(String placeid) {
		log.debug("find by id PlaceoforiginT");
		try {
			String queryString = "from PlaceoforiginT as p where p.placeid=:placeid";
			List<PlaceoforiginT> list = this.getHibernateTemplate().findByNamedParam(queryString, "placeid", placeid);
			if (list != null) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id PlaceoforiginT error", re);
			throw re;
		}
	}

	public int updatePlaceoforigint(final PlaceoforiginT p) {
		log.debug("update BrandT");
		try {
			final String queryString = "update PlaceoforiginT as p set p.placename=:placename,p.creatorid=:creatorid,p.createtime=:createtime where p.placeid=:placeid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("placename", p.getPlacename());
					query.setParameter("creatorid", p.getCreatorid());
					query.setParameter("placeid", p.getPlaceid());
					query.setParameter("createtime", p.getCreatetime());
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

	public List<PlaceoforiginT> findAllPlaceoforigintjson() {
		log.debug("find by id PlaceoforiginT");
		try {
			String queryString = "from PlaceoforiginT  order by createtime desc";
			List<PlaceoforiginT> list = this.getHibernateTemplate().find(queryString);
			if (list != null) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id PlaceoforiginT error", re);
			throw re;
		}
	}
}