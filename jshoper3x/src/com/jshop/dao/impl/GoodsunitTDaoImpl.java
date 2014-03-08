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

import com.jshop.dao.GoodsunitTDao;
import com.jshop.entity.GoodsunitT;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoodsunitT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.GoodsunitT
 * @author MyEclipse Persistence Tools
 */
@Repository("goodsunitTDao")
public class GoodsunitTDaoImpl extends BaseTDaoImpl<GoodsunitT> implements
		GoodsunitTDao {

	private static final Log log = LogFactory.getLog(GoodsunitTDaoImpl.class);

	public int countfindAllGoodsunit() {
		log.debug("count all Goodsunit");
		try {
			String queryString = "select count(*) from GoodsunitT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all GoodsunitT error", re);
			throw re;
		}
	}

	public int delGoodsunit(final String[] list) {
		log.debug("del GoodsunitT");
		try {

			final String queryString = "delete from GoodsunitT as u where u.unitid=:unitid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("unitid", s);
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
			log.error("del GoodsunitT failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<GoodsunitT> findAllGoodsunit(final int currentPage,
			final int lineSize) {
		log.debug("find all GoodsunitT");
		try {
			List<GoodsunitT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsunitT  order by createtime desc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
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
			log.error("find all GoodsunitT error", re);
			throw re;
		}
	}

	public GoodsunitT findGoodsunitById(String unitid) {
		log.debug("find by id GoodsunitT");
		try {
			String queryString = "from GoodsunitT as u where u.unitid=:unitid";
			List<GoodsunitT> list = this.getHibernateTemplate()
					.findByNamedParam(queryString, "unitid", unitid);
			if (list != null) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id GoodsunitT error", re);
			throw re;
		}
	}

	public int updateGoodsunit(final GoodsunitT u) {
		log.debug("update GoodsunitT");
		try {
			final String queryString = "update GoodsunitT as u set u.unitname=:unitname,u.creatorid=:creatorid,u.createtime=:createtime where u.unitid=:unitid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("unitname", u.getUnitname());
					query.setParameter("creatorid", u.getCreatorid());
					query.setParameter("unitid", u.getUnitid());
					query.setParameter("createtime", u.getCreatetime());
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

	public List<GoodsunitT> findAllGoodsunitjson() {
		log.debug("find by id GoodsunitT json");
		try {
			String queryString = "from GoodsunitT  order by createtime desc";
			List<GoodsunitT> list = this.getHibernateTemplate().find(
					queryString);
			if (list != null) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id GoodsunitT json error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsunitT> sortAllGoodsunit(final int currentPage,
			final int lineSize, final String queryString) {
		log.debug("find all GoodsunitT");
		try {
			List<GoodsunitT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
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
			log.error("find all GoodsunitT error", re);
			throw re;
		}
	}
}