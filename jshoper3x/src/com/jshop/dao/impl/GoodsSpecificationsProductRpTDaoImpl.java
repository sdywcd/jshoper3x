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

import com.jshop.dao.GoodsSpecificationsProductRpTDao;
import com.jshop.entity.GoodsSpecificationsProductRpT;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoodsSpecificationsRelationshipT entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.jshop.entity.GoodsSpecificationsRelationshipT
 * @author MyEclipse Persistence Tools
 */
@Repository("goodsSpecificationsProductRpTDao")
public class GoodsSpecificationsProductRpTDaoImpl extends BaseTDaoImpl<GoodsSpecificationsProductRpT> implements GoodsSpecificationsProductRpTDao{
	
	private static final Logger log = LoggerFactory.getLogger(GoodsSpecificationsProductRpTDaoImpl.class);

	@Override
	public List<GoodsSpecificationsProductRpT> checkSpecificationRelationshipByspecificationsid(
			String specificationsid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsSpecificationsProductRpT> checkSpecificationRelationshipBygoodssetid(
			String goodsid) {
		log.debug("find specificaionid by gooodsetid");
		try{
			String queryString = "from GoodsSpecificationsProductRpT as gsrt where gsrt.goodsid=:goodsid";
			List<GoodsSpecificationsProductRpT> list = this.getHibernateTemplate().findByNamedParam(queryString, "goodsid", goodsid);
			return list;
		}catch (RuntimeException re) {			
            log .error("find specificaionid by gooodsetid error" , re);
            throw re;
		}
	}


	@Override
	public void updateGoodsAssociatedProductById(
			GoodsSpecificationsProductRpT gsrt) {
		log.debug("add Goods Associated products");
		try{
			this.getHibernateTemplate().update(gsrt);
			log.debug("add successful");
		}catch(RuntimeException re){
			log.error("add failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public int delGoodsAssociatedProductById(final String goodsid) {
		// TODO Auto-generated method stub
		log.debug("del Goods associated prouducts");
		try{
			final String queryString ="delete from GoodsSpecificationsProductRpT as gsrt where gsrt.goodsid=:goodsid";
			Integer integer = (Integer)this.getHibernateTemplate().execute(new HibernateCallback(){
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter("goodsid",goodsid);
					return query.executeUpdate();
				}
			});
			log.debug("update successful");
			return integer;
		}catch(RuntimeException re){
			log.error("del failed",re);
			throw re;
		}		
	}

	@Override
	public List<GoodsSpecificationsProductRpT> checkSpecificationRelationshipByproductid(
			String productid) {
		log.debug("find specificaionid by productid");
		try{
			String queryString = "from GoodsSpecificationsProductRpT as gsrt where gsrt.productid=:productid";
			List<GoodsSpecificationsProductRpT> list = this.getHibernateTemplate().findByNamedParam(queryString, "productid", productid);
			return list;
		}catch (RuntimeException re) {			
            log .error("find specificaionid by productid error" , re);
            throw re;
		}
	}
	
	

}