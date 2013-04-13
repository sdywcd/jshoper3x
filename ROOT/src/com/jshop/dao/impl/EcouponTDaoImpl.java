package com.jshop.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.EcouponTDao;
import com.jshop.entity.EcouponT;
@Repository("ecouponTDao")
public class EcouponTDaoImpl extends HibernateDaoSupport implements EcouponTDao {
	
	public int addEcoupon(EcouponT et) {
		try {
			this.getHibernateTemplate().save(et);
			return 1;
		} catch (RuntimeException e) {			
			throw e;
		}
	}

	@Override
	public List<EcouponT> findAllEcoupon(final int currentPage, final int lineSize) {
		final String queryString="from EcouponT ";
		try {
			@SuppressWarnings("unchecked")
			List<EcouponT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage-1)*lineSize);
					query.setMaxResults(lineSize);
					List list =query.list();
					return list;
				}
			});
			if(list.size()>0){
				return list;
			}
			return null;
		} catch (DataAccessException e) {			
			throw e;
		}
	}

	@Override
	public int countAllEcoupon() {
		String queryString ="select count(*) from EcouponT";
		try {
			List list = this.getHibernateTemplate().find(queryString);
			if(list.size()>0){
				Object o= list.get(0);
				long l = (Long) o;
				return (int)l;
			}
			return 0;
		} catch (DataAccessException e) {
			throw e;
			
		}
	}

	@Override
	public EcouponT findEcouponByEid(String eid) {
		try {
			String queryString="from EcouponT as et where et.eid=:eid";
			List<EcouponT> list=this.getHibernateTemplate().findByNamedParam(queryString, "eid", eid);
			if(!list.isEmpty()){
				return list.get(0);
			}
			return null;
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@Override
	public int dekEcoupont(final String[] eid) {
		final String queryString ="delete from EcouponT as et where et.eid=:eid";
		 try {
			 this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
						Query query = session.createQuery(queryString);
						int i =0;
						for(String s:eid){
							query.setParameter("eid", s);
							i=query.executeUpdate();
							i++;
						}
						if(eid.length==i){
							return i;
						}else{
							return 0;
						}
				
				}
			});
			return 0;
		} catch (DataAccessException e) {
			throw e;
		}
	
	}

	@Override
	public int updateEcouponT(final EcouponT et) {
		final String queryString ="update EcouponT as et set et.eid=:eid, et.goodsname=:goodsname,et.goodsid=:goodsid,et.favourableprices=:favourableprices,et.pricededuction=:pricededuction,et.begintime=:begintime,et.endtime=:endtime,et.ecouponstate=:ecouponstate,et.state=:state,et.note=:note where et.eid=:eid";
		 try {
			Integer integer=  (Integer) this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query = session.createQuery(queryString);
					int i=0;
					query.setParameter("eid", et.getEid());
					query.setParameter("goodsname", et.getGoodsname());
					query.setParameter("goodsid", et.getGoodsid());
					query.setParameter("favourableprices", et.getFavourableprices());
					query.setParameter("pricededuction", et.getPricededuction());
					query.setParameter("begintime", et.getBegintime());
					query.setParameter("endtime", et.getEndtime());
					query.setParameter("ecouponstate", et.getEcouponstate());
					query.setParameter("state", et.getState());
					query.setParameter("note", et.getNote());
					i=query.executeUpdate();
					return i;
				}
			});
			return integer;
		} catch (DataAccessException e) {
			throw e;
		}
		
	}

}
