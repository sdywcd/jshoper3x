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

import com.jshop.dao.GoodsTypeBrandTDao;
import com.jshop.entity.GoodsTypeBrandT;

import edu.emory.mathcs.backport.java.util.Collections;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoodsTypeBrandT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.GoodsTypeBrandT
 * @author MyEclipse Persistence Tools
 */
@Repository("goodsTypeBrandTDao")
public class GoodsTypeBrandTDaoImpl extends BaseTDaoImpl<GoodsTypeBrandT> implements GoodsTypeBrandTDao {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsTypeBrandTDaoImpl.class);
	


	public int delGoodsTypeBrand(final String[] list) {
		log.debug("del DelGoodsTypeBrand");
		try {

			final String queryString = "delete from GoodsTypeBrandT as gtbt where gtbt.goodsTypeBrandTid=:goodsTypeBrandTid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("goodsTypeBrandTid", s);
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
			log.error("del DelGoodsTypeBrand failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<GoodsTypeBrandT> findAllGoodsTypeBrand(final int currentPage, final int lineSize) {
		log.debug("find all GoodsTypeBrandT");
		try {
			List<GoodsTypeBrandT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from GoodsTypeBrandT  order by goodsTypeId desc";

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
			log.error("find all GoodsTypeBrandT error", re);
			throw re;
		}
	}

	public int countfindAllGoodsTypeBrand() {
		log.debug("count all countfindAllGoodsTypeBrand");
		try {
			String queryString = "select count(*) from GoodsTypeBrandT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindAllGoodsTypeBrand error", re);
			throw re;
		}
	}

	public GoodsTypeBrandT findGoodsTypeBrandByBrandid(String brandid, String goodsTypeId) {
		log.debug("getting findGoodsTypeBrandByBrandid instance with id: " + brandid);
		try {
			String queryString = "from GoodsTypeBrandT as gtbt where gtbt.brandid=:brandid and gtbt.goodsTypeId=:goodsTypeId";
			List<GoodsTypeBrandT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "brandid", "goodsTypeId" }, new Object[] { brandid, goodsTypeId });
			if (!list.isEmpty()) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsTypeBrandT> sortAllGoodsTypeBrand(final int currentPage, final int lineSize, final String queryString) {
		try {
			List<GoodsTypeBrandT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);

					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0 && list != null) {
				return list;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public int updateGoodsTypeBrandTname(final String name,final String goodsTypeId ) {
		log.debug("updateGoodsTypeBrandTname");
		try {
			final String queryString = "update GoodsTypeBrandT as gtbt set gtbt.name=:name where gtbt.goodsTypeId=:goodsTypeId";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("name", name);
					query.setParameter("goodsTypeId", goodsTypeId);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateGoodsTypeBrandTname error", re);
			throw re;
		}
		return 0;
	}

	public List<GoodsTypeBrandT> findBrandBygoodsTypeId(String goodsTypeId) {
		log.debug("findBrandBygoodsTypeId");
		try {
			String queryString = "from GoodsTypeBrandT as gtbt where gtbt.goodsTypeId=:goodsTypeId";
			List<GoodsTypeBrandT> list = this.getHibernateTemplate().findByNamedParam(queryString, "goodsTypeId", goodsTypeId);
			return list;
		} catch (RuntimeException re) {
			log.error("findBrandBygoodsTypeId error", re);
			throw re;
		}
	}

	@Override
	public GoodsTypeBrandT findGoodsTypeIdByBrandid(String brandid) {
		log.debug("findGoodsTypeIdByBrandid: " + brandid);
		try {
			String queryString = "from GoodsTypeBrandT as gtbt where gtbt.brandid=:brandid";
			List<GoodsTypeBrandT> list = this.getHibernateTemplate().findByNamedParam(queryString, "brandid", brandid);
			if (!list.isEmpty()) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findGoodsTypeIdByBrandid failed", re);
			throw re;
		}
	}
	
	
	
}