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

import com.jshop.dao.GoodsAttributeTDao;
import com.jshop.entity.GoodsAttributeT;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoodsAttributeT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.GoodsAttributeT
 * @author MyEclipse Persistence Tools
 */
@Repository("goodsAttributeTDao")
public class GoodsAttributeTDaoImpl extends BaseTDaoImpl<GoodsAttributeT> implements GoodsAttributeTDao {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsAttributeTDaoImpl.class);
	

	public GoodsAttributeT findGoodsAttributeTBygoodstypeId(String goodsTypeId) {
		log.debug("find by id GoodsAttributeT");
		try {
			String queryString = "from GoodsAttributeT as gat where gat.goodsTypeId=:goodsTypeId";
			List<GoodsAttributeT> list = this.getHibernateTemplate().findByNamedParam(queryString, "goodsTypeId", goodsTypeId);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id GoodsAttributeT error", re);
			throw re;
		}
	}

	public int updateGoodsAttributeT(final GoodsAttributeT gat) {
		log.debug("update GoodsAttributeT");
		try {

			final String queryString = "update GoodsAttributeT as gat set gat.goodsattributename=:goodsattributename,gat.goodsTypeId=:goodsTypeId,gat.goodsTypeName=:goodsTypeName,gat.createtime=:createtime,gat.creatorid=:creatorid,gat.state=:state,gat.attributeType=:attributeType,gat.attributelist=:attributelist,gat.sort=:sort,gat.attributeIndex=:attributeIndex where gat.goodsattributeid=:goodsattributeid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("goodsattributeid", gat.getGoodsattributeid());
					query.setParameter("goodsattributename", gat.getGoodsattributename());
					query.setParameter("goodsTypeId", gat.getGoodsTypeId());
					query.setParameter("goodsTypeName", gat.getGoodsTypeName());
					query.setParameter("createtime", gat.getCreatetime());
					query.setParameter("state", gat.getState());
					query.setParameter("creatorid", gat.getCreatorid());
					query.setParameter("attributeType", gat.getAttributeType());
					query.setParameter("attributelist", gat.getAttributelist());
					query.setParameter("sort", gat.getSort());
					query.setParameter("attributeIndex", gat.getAttributeIndex());
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  GoodsAttributeT error", re);
			throw re;
		}
		return 0;
	}

	public int countfindAllGoodsAttributeT() {
		log.debug("count all GoodsAttributeT");
		try {
			String queryString = "select count(*) from GoodsAttributeT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all GoodsAttributeT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsAttributeT> findAllGoodsAttributeT(final int currentPage, final int lineSize) {
		log.debug("find all GoodsAttributeT");
		try {
			List<GoodsAttributeT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from GoodsAttributeT  order by createtime desc";

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
			log.error("find all GoodsAttributeT error", re);
			throw re;
		}
	}

	public int delGoodsAttributeT(final String[] list) {
		log.debug("del DelGoodsAttributeT");
		try {

			final String queryString = "delete from GoodsAttributeT as gat where gat.goodsattributeid=:goodsattributeid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("goodsattributeid", s);
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
			log.error("del DelGoodsAttributeT failed", re);
			throw re;
		}
		return 0;
	}

	public List<GoodsAttributeT> findGoodsAttributeTByGoodsTypeName(String goodsTypeName) {
		log.debug("find by id findGoodsAttributeTByGoodsTypeName");
		try {
			String queryString = "from GoodsAttributeT as gat where gat.goodsTypeName=:goodsTypeName";
			List<GoodsAttributeT> list = this.getHibernateTemplate().findByNamedParam(queryString, "goodsTypeName", goodsTypeName);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id findGoodsAttributeTByGoodsTypeName error", re);
			throw re;
		}
	}

	public List<GoodsAttributeT> findGoodsAttributeTBygoodsTypeId(String goodsTypeId) {
		log.debug("find by id findGoodsAttributeTBygoodsTypeId");
		try {
			String queryString = "from GoodsAttributeT as gat where gat.goodsTypeId=:goodsTypeId";
			List<GoodsAttributeT> list = this.getHibernateTemplate().findByNamedParam(queryString, "goodsTypeId", goodsTypeId);
			return list;
		} catch (RuntimeException re) {
			log.error("find by id findGoodsAttributeTBygoodsTypeId error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsAttributeT> sortAllGoodsAttributeT(final int currentPage, final int lineSize, final String queryString) {
		log.debug("find all GoodsAttributeT");
		try {
			List<GoodsAttributeT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
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
			log.error("find all GoodsAttributeT error", re);
			throw re;
		}
	}

	public int updateGoodsAttributeTgoodsTypeName(final String goodsTypeName, final String goodsTypeId) {
		log.debug("updateGoodsAttributeTgoodsTypeName");
		try {
			final String queryString = "update GoodsAttributeT as gat set gat.goodsTypeName=:goodsTypeName where gat.goodsTypeId=:goodsTypeId";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("goodsTypeName", goodsTypeName);
					query.setParameter("goodsTypeId", goodsTypeId);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateGoodsAttributeTgoodsTypeName error", re);
			throw re;
		}
		return 0;
	}

	public int updateGoodsAttributeissametolinkBygoodsattributeid(final String[] goodsattributeid, final String issametolink) {
		log.debug("updateGoodsAttributeissametolinkBygoodsattributeid");
		try {
			final String queryString = "update GoodsAttributeT as gat set gat.issametolink=:issametolink where gat.goodsattributeid=:goodsattributeid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsattributeid) {
						query.setParameter("goodsattributeid", s);
						query.setParameter("issametolink", issametolink);
						i = query.executeUpdate();
						i++;
					}
					if (goodsattributeid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("updateGoodsAttributeissametolinkBygoodsattributeid error", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public int updateGoodsAttributeissearchBygoodsattributeid(final String[] goodsattributeid, final String issearch) {
		log.debug("updateGoodsAttributeissearchBygoodsattributeid");
		try {
			final String queryString = "update GoodsAttributeT as gat set gat.issearch=:issearch where gat.goodsattributeid=:goodsattributeid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsattributeid) {
						query.setParameter("goodsattributeid", s);
						query.setParameter("issearch", issearch);
						i = query.executeUpdate();
						i++;
					}
					if (goodsattributeid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("updateGoodsAttributeissearchBygoodsattributeid error", re);
			throw re;
		}
		return 0;
	}

	@Override
	public int countsortAllGoodsAttributeT(String queryString) {
		log.debug("countsortAllGoodsAttributeT");
		try {
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countsortAllGoodsAttributeT error", re);
			throw re;
		}
	}
	
	
	
	
}