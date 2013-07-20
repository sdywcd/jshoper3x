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

import com.jshop.dao.GoodsSpecificationsRelationshipTDao;
import com.jshop.entity.GoodsSpecificationsRelationshipT;

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
@Repository("goodsSpecificationsRelationshipTDao")
public class GoodsSpecificationsRelationshipTDaoImpl extends HibernateDaoSupport implements GoodsSpecificationsRelationshipTDao{
	
	private static final Logger log = LoggerFactory.getLogger(GoodsSpecificationsRelationshipTDaoImpl.class);
	// property constants
	public static final String SPECIDICATIONS_ID = "specidicationsId";
	
	@Override
	public List<GoodsSpecificationsRelationshipT> checkSpecificationRelationshipByspecificationsid(
			String specificationsid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<GoodsSpecificationsRelationshipT> checkSpecificationRelationshipBygoodssetid(
			String goodssetid) {
		// TODO Auto-generated method stub
		log.debug("find specificaionid by gooodsetid");
		try{
			String queryString = "from GoodsSpecificationsRelationshipT as gsrt where gsrt.goodsSetId=:goodssetid";
			List<GoodsSpecificationsRelationshipT> list = this.getHibernateTemplate().findByNamedParam(queryString, "goodssetid", goodssetid);
			return list;
		}catch (RuntimeException re) {			
            log .error("find specificaionid by gooodsetid error" , re);
            throw re;
		}
	}
	
	
	public int addGoodsAssociatedProductById(GoodsSpecificationsRelationshipT gsrt) {
		// TODO Auto-generated method stub
		log.debug("add Goods Associated products");
		try{
			this.getHibernateTemplate().save(gsrt);
			log.debug("add successful");
			return 1;
		}catch(RuntimeException re){
			log.error("add failed", re);
			throw re;
		}
	}
	
	
	public int updateGoodsAssociatedProductById(final GoodsSpecificationsRelationshipT gsrt) {
		// TODO Auto-generated method stub
		log.debug("update Goods Associated products");
		try{
			final String queryString = "update GoodsSpecificationsRelationshipT as gsrt set gsrt.specidicationsId=:specidicationsId where gsrt.goodsSetId=:goodsSetId";
			Integer integer =(Integer) this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("goodsSetId", gsrt.getId().getGoodsSetId());
					query.setParameter("specidicationsId", gsrt.getId().getSpecidicationsId());
					i = query.executeUpdate();
					return i;
				}
			});
			log.debug("update successful");
			return integer;
		}catch(RuntimeException re){
			log.error("updat failed");
			throw re;
		}
	}
	
	public int delGoodsAssociatedProductById(final String goodssetid) {
		// TODO Auto-generated method stub
		log.debug("del Goods associated prouducts");
		try{
			final String queryString ="delete from GoodsSpecificationsRelationshipT as gsrt where gsrt.goodsSetId=:goodssetid";
			Integer integer = (Integer)this.getHibernateTemplate().execute(new HibernateCallback(){
				
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					query.setParameter("goodssetid",goodssetid);
					i = query.executeUpdate();
					return i;
				}
			});
			log.debug("update successful");
			return integer;
		}catch(RuntimeException re){
			log.error("del failed",re);
			throw re;
		}		
	}

}