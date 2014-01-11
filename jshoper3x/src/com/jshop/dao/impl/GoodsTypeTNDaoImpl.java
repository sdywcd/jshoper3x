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

import com.jshop.dao.GoodsTypeTNDao;
import com.jshop.entity.GoodsTypeTN;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoodsTypeTN entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.GoodsTypeTN
 * @author MyEclipse Persistence Tools
 */

@Repository("goodsTypeTNDao")
public class GoodsTypeTNDaoImpl extends BaseTDaoImpl<GoodsTypeTN> implements GoodsTypeTNDao {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsTypeTNDaoImpl.class);
	

	public int countfindAllGoodsTypeTN() {
		log.debug("count all GoodsTypeTN");
		try {
			String queryString = "select count(*) from GoodsTypeTN";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all GoodsTypeTN error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsTypeTN> findAllGoodsTypeTN(final int currentPage, final int lineSize) {
		log.debug("find all GoodsTypeTN");
		try {
			List<GoodsTypeTN> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from GoodsTypeTN";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("find all GoodsTypeTN error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsTypeTN> findGoodsTypeTNById(String goodsTypeId) {
		log.debug("find by id GoodsTypeTN");
		try {
			String queryString = "from GoodsTypeTN as gtn where gtn.goodsTypeId=:goodsTypeId";
			List<GoodsTypeTN> list = this.getHibernateTemplate().findByNamedParam(queryString, "goodsTypeId", goodsTypeId);
			return list;
		} catch (RuntimeException re) {
			log.error("find by id GoodsTypeTN error", re);
			throw re;
		}
	}

	public int updateGoodsTypeTN(final GoodsTypeTN gtn) {
		log.debug("update GoodsTypeTN");
		try {
			final String queryString = "update GoodsTypeTN as gtn set gtn.name=:name,gtn.createtime=:createtime,gtn.creatorid=:creatorid,gtn.goodsParameter=:goodsParameter where gtn.goodsTypeId=:goodsTypeId ";
			Integer integer=this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter("goodsTypeId", gtn.getGoodsTypeId());
					query.setParameter("name", gtn.getName());
					query.setParameter("createtime", gtn.getCreatetime());
					query.setParameter("creatorid", gtn.getCreatorid());
					query.setParameter("goodsParameter", gtn.getGoodsParameter());
					return query.executeUpdate();
					
				}
			});
			return integer;
		} catch (RuntimeException re) {
			log.error("update  GoodsTypeTN error", re);
			throw re;
		}
	}

	public int delGoodsTypeTN(final String[] list) {
		log.debug("del DelGoodsTypeTN");
		try {
			final String queryString = "delete from GoodsTypeTN as gtn where gtn.goodsTypeId=:goodsTypeId";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("goodsTypeId", s);
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
			log.error("del DelGoodsTypeTN failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<GoodsTypeTN> findAllGoodsTypeTNNopage() {
		log.debug("find all GoodsTypeTN");
		try {
			String queryString = "from GoodsTypeTN";
			List<GoodsTypeTN> list = this.getHibernateTemplate().find(queryString);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all GoodsTypeTN error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsTypeTN> sortAllGoodsTypeTN(final int currentPage, final int lineSize, final String queryString) {
		try {
			List<GoodsTypeTN> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			throw re;
		}

	}

	@Override
	public List<GoodsTypeTN> findGoodsTypeTNByName(String name) {
		log.debug("findGoodsTypeTNByName");
		try {
			String queryString = "from GoodsTypeTN as gtn where gtn.name=:name";
			List<GoodsTypeTN> list = this.getHibernateTemplate().findByNamedParam(queryString, "name", name);
			return list;
		} catch (RuntimeException re) {
			log.error("findGoodsTypeTNByName  error", re);
			throw re;
		}
	}

	@Override
	public int countsortAllGoodsTypeTN(String queryString) {
		log.debug("countsortAllGoodsTypeTN");
		try {
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countsortAllGoodsTypeTN error", re);
			throw re;
		}
	}
	
	
	
}