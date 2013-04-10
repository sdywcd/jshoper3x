package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.ElectronicMenuCartTDao;
import com.jshop.entity.ElectronicMenuCartT;

/**
 * A data access object (DAO) providing persistence and search support for
 * ElectronicMenuCartT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.ElectronicMenuCartT
 * @author MyEclipse Persistence Tools
 */
@Repository("electronicMenuCartTDao")
public class ElectronicMenuCartTDaoImpl extends HibernateDaoSupport implements ElectronicMenuCartTDao {
	private static final Logger log = LoggerFactory.getLogger(ElectronicMenuCartTDaoImpl.class);

	public int addElectronicMenuCartT(ElectronicMenuCartT ec) {
		log.debug("save ElectronicMenuCartT");
		try {
			this.getHibernateTemplate().save(ec);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("save ElectronicMenuCartT", re);
			throw re;
		}
	}

	public int countfindAllElectronicMenuCartT() {
		log.debug("countfindAllElectronicMenuCartT");
		try {
			String queryString = "select count(*) from ElectronicMenuCartT";
			List<ElectronicMenuCartT> list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllElectronicMenuCartT error", re);
			throw re;
		}
	}

	public int delElectronicMenuCartTGoods(final String tableNumber, final String tablestate, final String goodsid, final String state) {
		log.debug("delElectronicMenuCartTGoods");
		try {

			final String queryString = "delete from ElectronicMenuCartT as ec where ec.tableNumber=:tableNumber and ec.tablestate=:tablestate and ec.goodsid=:goodsid and ec.state=:state";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					query.setParameter("tableNumber", tableNumber);
					query.setParameter("tablestate", tablestate);
					query.setParameter("goodsid", goodsid);
					query.setParameter("state", state);
					i = query.executeUpdate();
					i++;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("delElectronicMenuCartTGoods failed", re);
			throw re;
		}
		return 0;
	}

	public List<ElectronicMenuCartT> findAllElectronicMenuCartT() {
		log.debug("findAllElectronicMenuCartT");
		try {
			String queryString = "from ElectronicMenuCartT";
			List<ElectronicMenuCartT> list = this.getHibernateTemplate().find(queryString);
			return list;
		} catch (RuntimeException re) {
			log.error("findAllElectronicMenuCartT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ElectronicMenuCartT> findAllElectronicMenuCartTBytableNumber(String tableNumber, String tablestate) {
		log.debug("findAllElectronicMenuCartTBytableNumber");
		try {
			String queryString = "from ElectronicMenuCartT as ec where ec.tableNumber=:tableNumber and ec.tablestate=:tablestate";
			List<ElectronicMenuCartT> list = this.getHibernateTemplate().findByNamedParam(queryString,new String[]{"tableNumber","tablestate"}, new Object[]{tableNumber,tablestate});
			return list;
		} catch (RuntimeException re) {
			log.error("findAllElectronicMenuCartTBytableNumber error", re);
			throw re;
		}
	}

	public List<ElectronicMenuCartT> findAllElectronicMenuCartTByusername(String username) {
		log.debug("findAllElectronicMenuCartTByusername");
		try {
			String queryString = "from ElectronicMenuCartT as ec where ec.username=:username";
			List<ElectronicMenuCartT> list = this.getHibernateTemplate().findByNamedParam(queryString,"username",username);
			return list;
		} catch (RuntimeException re) {
			log.error("findAllElectronicMenuCartTByusername error", re);
			throw re;
		}
	}

	public List<ElectronicMenuCartT> findElectronicMenuCartTByelectronicMenuOrderid(String electronicMenuOrderid, String state) {
		log.debug("findElectronicMenuCartTByelectronicMenuOrderid");
		try {
			String queryString = "from ElectronicMenuCartT as ec where ec.electronicMenuOrderid=:electronicMenuOrderid and ec.state=:state";
			List<ElectronicMenuCartT> list = this.getHibernateTemplate().findByNamedParam(queryString,new String[]{"electronicMenuOrderid","state"}, new Object[]{electronicMenuOrderid,state});
			return list;
		} catch (RuntimeException re) {
			log.error("findElectronicMenuCartTByelectronicMenuOrderid error", re);
			throw re;
		}
	}

	public ElectronicMenuCartT findGoodsInElectronicMenuCartTOrNot(String tableNumber, String tablestate, String goodsid, String state) {
		log.debug("findGoodsInElectronicMenuCartTOrNot");
		try {
			String queryString = "from ElectronicMenuCartT as ec where ec.tableNumber=:tableNumber and ec.tablestate=:tablestate and ec.goodsid=:goodsid and ec.state=:state";
			List<ElectronicMenuCartT> list = this.getHibernateTemplate().findByNamedParam(queryString,new String[]{"tableNumber","tablestate","goodsid","state"}, new Object[]{tableNumber,tablestate,goodsid,state});
			if(!list.isEmpty()){
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findGoodsInElectronicMenuCartTOrNot error", re);
			throw re;
		}
	}

	public int updateElectronicMenuCartTelectronicMenuCartid(final String electronicMenuCartid, final String state, final String tableNumber, final String tablestate) {
		log.debug("updateElectronicMenuCartTelectronicMenuCartid");
		try {
			final String queryString = "update ElectronicMenuCartT as ec set ec.electronicMenuCartid=:electronicMenuCartid where ec.state=:state and ec.tableNumber=:tableNumber and ec.tablestate=:tablestate";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("electronicMenuCartid", electronicMenuCartid);
					query.setParameter("state", state);
					query.setParameter("tableNumber", tableNumber);
					query.setParameter("tablestate", tablestate);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateElectronicMenuCartTelectronicMenuCartid error", re);
			throw re;
		}
		return 0;
	}

	public int updateElectronicMenuCartTneedquantityBygoodsid(final String tableNumber, final String tablestate, final String goodsid, final int needquantity, final String state) {
		log.debug("updateElectronicMenuCartTneedquantityBygoodsid");
		try {
			final String queryString = "update ElectronicMenuCartT as ec set ec.needquantity=:needquantity+ec.needquantity where ec.tableNumber=:tableNumber and ec.tablestate=:tablestate and ec.goodsid=:goodsid and ec.state=:state";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("needquantity", needquantity);
					query.setParameter("state", state);
					query.setParameter("tableNumber", tableNumber);
					query.setParameter("tablestate", tablestate);
					query.setParameter("goodsid", goodsid);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateElectronicMenuCartTneedquantityBygoodsid error", re);
			throw re;
		}
		return 0;
	}

	public int updateElectronicMenuCartTstate(final String tableNumber, final String tablestate, final String electronicMenuOrderid, final String state, final String electronicMenuCartid) {
		log.debug("updateElectronicMenuCartTstate");
		try {
			final String queryString = "update ElectronicMenuCartT as ec set ec.state=:state where ec.tableNumber=:tableNumber and ec.tablestate=:tablestate and ec.electronicMenuOrderid=:electronicMenuOrderid and ec.electronicMenuCartid=:electronicMenuCartid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("state",state);
					query.setParameter("electronicMenuOrderid", electronicMenuOrderid);
					query.setParameter("tableNumber", tableNumber);
					query.setParameter("tablestate", tablestate);
					query.setParameter("electronicMenuCartid", electronicMenuCartid);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateElectronicMenuCartTstate error", re);
			throw re;
		}
		return 0;
	}

	public int updateElectronicMenuCartTstate(final String tableNumber, final String tablestate, final String goodsid, final String state) {
		log.debug("updateElectronicMenuCartTstate");
		try {
			final String queryString = "update ElectronicMenuCartT as ec set ec.state=:state where ec.tableNumber=:tableNumber and ec.tablestate=:tablestate and ec.goodsid=:goodsid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("state",state);
					query.setParameter("tableNumber", tableNumber);
					query.setParameter("tablestate", tablestate);
					query.setParameter("goodsid", goodsid);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateElectronicMenuCartTstate error", re);
			throw re;
		}
		return 0;
	}

	public int updateElectronicMenuCartTsubtotal(final String tableNumber, final String tablestate, final String goodsid, final double subtotal) {
		log.debug("updateElectronicMenuCartTsubtotal");
		try {
			final String queryString = "update ElectronicMenuCartT as ec set ec.subtotal=:subtotal where ec.tableNumber=:tableNumber and ec.tablestate=:tablestate and ec.goodsid=:goodsid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("subtotal",subtotal);
					query.setParameter("tableNumber", tableNumber);
					query.setParameter("tablestate", tablestate);
					query.setParameter("goodsid", goodsid);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateElectronicMenuCartTsubtotal error", re);
			throw re;
		}
		return 0;
	}

	public int updateElectronicMenuCartTtablestate(final String electronicMenuOrderid, final String tablestate) {
		log.debug("updateElectronicMenuCartTtablestate");
		try {
			final String queryString = "update ElectronicMenuCartT as ec set ec.tablestate=:tablestate where ec.electronicMenuOrderid=:electronicMenuOrderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("tablestate",tablestate);
					query.setParameter("electronicMenuOrderid", electronicMenuOrderid);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateElectronicMenuCartTtablestate error", re);
			throw re;
		}
		return 0;
	}

	@Override
	public int updateElectroMenuCartCookingState(final String cookingstate,final String tableNumber) {
		final String queryString="update ElectronicMenuCartT as ec set ec.cookingstate=:cookingstate where ec.tableNumber=:tableNumber";
		try {
			this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					int i =0;
					Query query = session.createQuery(queryString);
					query.setParameter("cookingstate", cookingstate);
					query.setParameter("tableNumber", tableNumber);
					i=query.executeUpdate();				
					return i;
				}
			});
		} catch (RuntimeException e) {
			throw e;
		}
		return 0;
	}

	@Override
	public List<ElectronicMenuCartT> findElectronicCartByTableNumber(
			String tableNumber) {
		try {
			String queryString="from ElectronicMenuCartT as ec where ec.tableNumber=:tableNumber";
			List<ElectronicMenuCartT>list = this.getHibernateTemplate().findByNamedParam(queryString, "tableNumber", tableNumber);
			return list;
		} catch (RuntimeException e) {
			throw e;
		}
	}
	public int updateElectroMenuCartCookingState(final String cookingstate) {
		final String queryString="update ElectronicMenuCartT as ec ec.cookingstate=:cookingstate";
		try {
			this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					int i =0;
					Query query = session.createQuery(queryString);
					query.setParameter("cookingstate", cookingstate);
					i=query.executeUpdate();				
					return i;
				}
			});
		} catch (DataAccessException e) {
			throw e;
		}
		return 0;
	}


	
	
}