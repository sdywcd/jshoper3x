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

import com.jshop.dao.ProductSpecificationsTDao;
import com.jshop.entity.ProductSpecificationsT;

/**
 * A data access object (DAO) providing persistence and search support for
 * ProductSpecificationsT entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.ProductSpecificationsT
 * @author MyEclipse Persistence Tools
 */
@Repository("productSpecificationsTDao")
public class ProductSpecificationsTDaoImpl extends BaseTDaoImpl<ProductSpecificationsT> implements ProductSpecificationsTDao{
	
	private static final Logger log = LoggerFactory.getLogger(ProductSpecificationsTDaoImpl.class);
	

	public int countfindAllProductSpecificationsT() {
		log.debug("count all ProductSpecificationsT");
		try {
			String queryString = "select count(*) from ProductSpecificationsT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all ProductSpecificationsT error", re);
			throw re;
		}
	}

	public int delProductSpecification(final String[] list) {
		log.debug("del delProductSpecification");
		try {

			final String queryString = "delete from ProductSpecificationsT as pst where pst.specificationsid=:specificationsid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("specificationsid", s);
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
			log.error("del delProductSpecification failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<ProductSpecificationsT> findAllProductSpecificationsT(final int currentPage, final int lineSize) {
		log.debug("find all GoodsAttributeT");
		try {
			List<ProductSpecificationsT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from ProductSpecificationsT as pst where pst.state='1'  order by createtime desc";

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

	public ProductSpecificationsT findProductSpecificationsTByspecificationsid(String specificationsid) {
		log.debug("find by id ProductSpecificationsT");
		try {
			ProductSpecificationsT list = (ProductSpecificationsT) this.getHibernateTemplate().get("com.jshop.entity.ProductSpecificationsT", specificationsid);
			return list;
		} catch (RuntimeException re) {
			log.error("find by id GoodsAttributeT error", re);
			throw re;
		}
	}

	public int updateProductSpecification(final ProductSpecificationsT pst) {
		log.debug("update updateProductSpecification");
		try {

			final String queryString = "update ProductSpecificationsT as pst set pst.name=:name,pst.note=:note,pst.sort=:sort,pst.createtime=:createtime,pst.creatorid=:creatorid,pst.specificationsValue=:specificationsValue,pst.specificationsType=:specificationsType where pst.specificationsid=:specificationsid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("specificationsid", pst.getSpecificationsid());
					query.setParameter("name", pst.getName());
					query.setParameter("note", pst.getNote());
					query.setParameter("sort", pst.getSort());
					query.setParameter("createtime", pst.getCreatetime());
					query.setParameter("specificationsType", pst.getSpecificationsType());
					query.setParameter("creatorid", pst.getCreatorid());
					query.setParameter("specificationsValue", pst.getSpecificationsValue());
					i = query.executeUpdate();
					return 1;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  updateProductSpecification error", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<ProductSpecificationsT> findAllProductSpecificationsT(String state) {
		log.debug("find all findAllProductSpecificationsT by state");
		try {
			String queryString = "from ProductSpecificationsT as pst where pst.state=:state order by createtime desc";
			List<ProductSpecificationsT> list = this.getHibernateTemplate().findByNamedParam(queryString, "state", state);
			return list;
		} catch (RuntimeException re) {
			log.error("find all findAllProductSpecificationsT by state error", re);
			throw re;
		}
	}

		@SuppressWarnings("unchecked")
		public List<ProductSpecificationsT> sortAllProductSpecificationsT(final int currentPage, final int lineSize, final String queryString) {
            log.debug("find all GoodsAttributeT");
            try {
                      List<ProductSpecificationsT> list = this.getHibernateTemplate().executeFind(
                              new HibernateCallback() {
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

		@Override
		public List<ProductSpecificationsT> findAllProductSpecificationsByGoodsTypeId(
				String goodsTypeId,String state) {
			log.debug("find all findAllProductSpecificationsByGoodsTypeId");
			try {
				String queryString = "from ProductSpecificationsT as pst where pst.goodsTypeId=:goodsTypeId and pst.state=:state order by createtime desc";
				List<ProductSpecificationsT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[]{"goodsTypeId","state"}, new Object[]{goodsTypeId,state});
				return list;
			} catch (RuntimeException re) {
				log.error("find all findAllProductSpecificationsByGoodsTypeId error", re);
				throw re;
			}
		}
}