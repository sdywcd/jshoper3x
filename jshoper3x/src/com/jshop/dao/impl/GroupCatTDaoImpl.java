package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GroupCartDao;
import com.jshop.entity.GroupCartT;
@Repository("groupCartDao")
public class GroupCatTDaoImpl extends BaseTDaoImpl<GroupCartT> implements GroupCartDao {
	private static final Log log = LogFactory.getLog(CartTDaoImpl.class);
	@Override
	public List<GroupCartT> findGroupById(final String cartid) {
		try {
			String queryString ="from GroupCartT as gt where gt.cartid=:cartid";
			List<GroupCartT> list=this.getHibernateTemplate().findByNamedParam(queryString, "cartid", cartid);
			if(list!=null){
				return list;
			}
			return null;
		} catch (DataAccessException e) {
			throw e;
		}
	}


	@Override
	public int delGroupCart(final String cartid) {
		final String queryString="delete from GroupCartT as gt where gt.cartid=:cartid";
		try {
			this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					int i=0;
					Query query = session.createQuery(queryString);
					query.setParameter("cartid",cartid);
					i=query.executeUpdate();
					if(i>0){
						return i;
					}else{
						return 0;	
					}			
				}
			});
		} catch (DataAccessException e) {
			throw e;
		}
		return 0;
		
	}


	@Override
	public List<GroupCartT> findAllGroupCartByUserId(String userid) {
		log.debug("find all GroupCartT ");
		try {
			String queryString = "from GroupCartT as c where c.userid=:userid and c.state='1' order by addtime desc";
			List<GroupCartT> list = this.getHibernateTemplate().findByNamedParam(queryString, "userid", userid);
			if (list != null) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all GroupCartT  error", re);
			throw re;
		}
	}


	@Override
	public List<GroupCartT> findgroupCartByCartid(String cartid, String state) {
		try {
			String queryString="from GroupCartT as gct where gct.cartid=:cartid and gct.state=:state ";
			List<GroupCartT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[]{"cartid","state"}, new Object[]{cartid,state});
			return list;
		} catch (DataAccessException e) {
			throw e;
		}
	}


	public int updateGroupCartStateandOrderidByGoodsidList(final String cartid,
			final String orderid, final String userid, final String state) {
		
		try {

			final String queryString = "update GroupCartT as c set c.state=:state,c.orderid=:orderid where c.userid=:userid  and c.cartid=:cartid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					query.setParameter("orderid", orderid);
					query.setParameter("userid", userid);
					query.setParameter("cartid", cartid);
					query.setParameter("state", state);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("UpdateCartStateandOrderidByGoodsidList cart failed", re);
			throw re;
		}
		return 0;
	}


	@Override
	public List<GroupCartT> findGroupCartGoodsByOrderid(String orderid) {
		log.debug("find all findGroupCartGoodsByOrderid ");
		try {
			String queryString = "from GroupCartT as c where c.orderid=:orderid and c.state='3' order by addtime desc";
			List<GroupCartT> list = this.getHibernateTemplate().findByNamedParam(queryString, "orderid", orderid);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all findGroupCartGoodsByOrderid  error", re);
			throw re;
		}
	}


	@Override
	public int updateGroupCartStateByGoodsId(final String goodsid,final String state) {
		try {
			final String queryString ="update GroupCartT as gct set gct.state=:state where gct.goodsid=:goodsid";
			this.getHibernateTemplate().executeFind(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					int i=0;
					Query query = session.createQuery(queryString);
					query.setParameter("state", state);
					query.setParameter("goodsid",goodsid);
					i=query.executeUpdate();
					i++;
					return i;
				}
			});
		} catch (DataAccessException e) {
			throw e;
		}
		return 0;
	}

}
