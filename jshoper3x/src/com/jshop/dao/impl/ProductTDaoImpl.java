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

import com.jshop.dao.ProductTDao;
import com.jshop.entity.ArticleCategoryT;
import com.jshop.entity.ProductT;

/**
 * A data access object (DAO) providing persistence and search support for
 * ProductT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.ProductT
 * @author MyEclipse Persistence Tools
 */
@Repository("productTDao")
public class ProductTDaoImpl extends BaseTDaoImpl<ProductT> implements ProductTDao {
	private static final Logger log = LoggerFactory.getLogger(ProductTDaoImpl.class);
	
	public int countfindAllProductT(String creatorid) {
		log.debug("countfindAllProductT");
		try {
			String queryString = "select count(*) from ProductT as pt where pt.creatorid=:creatorid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllProductT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProductT> findAllProductT(final int currentPage, final int lineSize, final String creatorid) {
		log.debug("find all ProductT");
		try {
			List<ProductT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from ProductT as pt where pt.creatorid=:creatorid order by productid desc";

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
			log.error("find all ProductT error", re);
			throw re;
		}
	}

	public List<ProductT> findAllProductTByGoodsid(String creatorid, String goodsid) {
		log.debug("findAllProductTByGoodsid");
		try {
			String queryString = "from ProductT as pt where pt.creatorid=:creatorid and pt.goodsid=:goodsid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "creatorid", "goodsid" }, new Object[] { creatorid, goodsid });
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findAllProductTByGoodsid error", re);
			throw re;
		}
	}

	public void updateProductT(final ProductT pt) {
		log.debug("updateProductT");
		try {
			this.getHibernateTemplate().update(pt);
		} catch (RuntimeException re) {
			log.error("updateProductT error", re);
			throw re;
		}
	}

	public List<ProductT> findProductTByproductid(String creatorid, String productid) {
		log.debug("findAllProductTByGoodsid");
		try {
			String queryString = "from ProductT as pt where pt.creatorid=:creatorid and pt.productid=:productid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "creatorid", "productid" }, new Object[] { creatorid, productid });
			return list;
		} catch (RuntimeException re) {
			log.error("findAllProductTByGoodsid error", re);
			throw re;
		}
	}

	public int delProductTBygoodsid(final String goodsid, final String creatorid) {
		log.debug("delProductTBygoodsid");
		try {

			final String queryString = "delete from ProductT as pt where pt.goodsid=:goodsid and pt.creatorid=:creatorid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("goodsid", goodsid);
					query.setParameter("creatorid", creatorid);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("delProductTBygoodsid failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<ProductT> sortAllProductT(final int currentPage, final int lineSize, final String queryString) {
		log.debug("find all ProductT");
		try {
			List<ProductT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
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
			log.error("find all ProductT error", re);
			throw re;
		}
	}

	@Override
	public int delProductTByproductid(final String productid) {
		log.debug("delProductTBygoodsid");
		try {
			final String queryString = "delete from ProductT as pt where pt.productid=:productid";
			Integer integer=(Integer)this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("productid", productid);
					i = query.executeUpdate();
					return i;
				}
			});
			return integer;
		} catch (RuntimeException re) {
			log.error("delProductTBygoodsid failed", re);
			throw re;
		}
	}

	@Override
	public List<ProductT> findProductTByGoodsid(String goodsid) {
		log.debug("findProductTByGoodsid");
		try {
			String queryString = "from ProductT as pt where pt.goodsid=:goodsid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString,"goodsid",goodsid);
			return list;
		} catch (RuntimeException re) {
			log.error("findProductTByGoodsid error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductT> findAllProductT(final int currentPage, final int lineSize) {
		log.debug("find all ProductT");
		try {
			List<ProductT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from ProductT as pt order by pt.createtime desc";

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
			log.error("find all ProductT error", re);
			throw re;
		}
	}

	@Override
	public int countfineAllProductT() {
		log.debug("countfindAllProductT");
		try {
			String queryString = "select count(*) from ProductT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllProductT error", re);
			throw re;
		}
	}

	@Override
	public ProductT findProductByProductid(String productid) {
		log.debug("getting findProductByProductid instance with id: " + productid);
		try {
			ProductT instance = (ProductT) this.getHibernateTemplate().get("com.jshop.entity.ProductT", productid);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public int delProductT(final String[] strs) {
		log.debug("delProductT");
		try {
			final String queryString = "delete from ProductT as pt where pt.productid=:productid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : strs) {
						query.setParameter("productid", s);
						i = query.executeUpdate();
						i++;
					}
					if (strs.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("delArticleT failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductT> findProductByproductName(final String productName,
			final int lineSize) {
		log.debug("findProductByproductName");
		try {
			List<ProductT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from ProductT as pt where pt.productName like :productName order by pt.createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setMaxResults(lineSize);
					query.setParameter("productName", "%"+productName+"%");
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("findProductByproductName error", re);
			throw re;
		}
	}

	
	
	
}