package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.OrderTDao;
import com.jshop.entity.OrderT;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrderT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.OrderT
 * @author MyEclipse Persistence Tools
 */
@Repository("orderTDao")
public class OrderTDaoImpl extends BaseTDaoImpl<OrderT> implements OrderTDao {
	

	private static final Log log = LogFactory.getLog(OrderTDaoImpl.class);
	
	public int addOrder(OrderT o) {
		log.debug("save OrderT");
		try {
			this.getHibernateTemplate().save(o);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public int delOrderByorderid(final String memberid, final String orderid, final String orderstate) {
		log.debug("update OrderT");
		try {
			final String queryString = "update OrderT as o set o.orderstate=:orderstate where o.memberid=:memberid and o.orderid=:orderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("memberid", memberid);
					query.setParameter("orderid", orderid);
					query.setParameter("orderstate", orderstate);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  OrderT error", re);
			throw re;
		}
		return 0;
	}

	public int countfindAllOrderByorderstate(String memberid, String orderstate, String paystate, String shippingstate) {
		log.debug("count all OrderT  by OrderTstate");
		try {
			String queryString = "select count(*) from OrderT as o where o.memberid=:memberid and o.orderstate!=:orderstate and o.paystate=:paystate and o.shippingstate=:shippingstate";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "memberid", "orderstate", "paystate", "shippingstate" }, new Object[] { memberid, orderstate, paystate, shippingstate });
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all OrderT  by OrderTstate error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderT> findAllOrderByorderstate(final int currentPage, final int lineSize, final String memberid, final String orderstate, final String paystate, final String shippingstate) {
		log.debug("find all OrderT by OrderTstate");
		try {
			List<OrderT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from OrderT as o where o.orderstate!=:orderstate and o.memberid=:memberid and o.paystate=:paystate and o.shippingstate=:shippingstate order by purchasetime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("memberid", memberid);
					query.setParameter("orderstate", orderstate);
					query.setParameter("shippingstate", shippingstate);
					query.setParameter("paystate", paystate);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("find all OrderT  by OrderTstate error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderT> findAllOrderByorderstateForOn(final int currentPage, final int lineSize, final String memberid, final String orderstate, final String paystate, final String shippingstate) {
		log.debug("find all OrderT by OrderTstate");
		try {
			List<OrderT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from OrderT as o where o.orderstate!=:orderstate and o.memberid=:memberid and o.paystate!=:paystate and o.shippingstate!=:shippingstate order by purchasetime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("memberid", memberid);
					query.setParameter("orderstate", orderstate);
					query.setParameter("shippingstate", shippingstate);
					query.setParameter("paystate", paystate);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("find all OrderT  by OrderTstate error", re);
			throw re;
		}
	}

	public int countfindAllOrderByorderstateForOn(String memberid, String orderstate, String paystate, String shippingstate) {
		log.debug("count all OrderT  by OrderTstate");
		try {
			String queryString = "select count(*) from OrderT as o where o.memberid=:memberid and o.orderstate!=:orderstate and o.paystate!=:paystate and o.shippingstate!=:shippingstate";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "memberid", "orderstate", "paystate", "shippingstate" }, new Object[] { memberid, orderstate, paystate, shippingstate });
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all OrderT  by OrderTstate error", re);
			throw re;
		}
	}

	public OrderT findOrderDetailByorderid(String orderid) {
		log.debug("getting findOrderDetailByorderid instance with id: " + orderid);
		try {
			OrderT list = (OrderT) this.getHibernateTemplate().get("com.jshop.entity.OrderT", orderid);
			return list;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public void updateOrder(final OrderT o) {
		log.debug("update OrderT");
		try {
			this.getHibernateTemplate().update(o);
		} catch (RuntimeException re) {
			log.error("update  OrderT error", re);
			throw re;
		}
	}

	public int updateOrderPaystateByorderid(final String orderid, final String paystate) {
		log.debug("update OrderT paystate");
		try {

			final String queryString = "update OrderT as o set o.paystate=:paystate where o.orderid=:orderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("orderid", orderid);
					query.setParameter("paystate", paystate);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  OrderT paystate error", re);
			throw re;
		}
		return 0;
	}

	public int updateOrderShippingstateByorderid(final String orderid, final String shippingstate) {
		log.debug("update OrderT UpdateOrderShippingstateByorderid");
		try {

			final String queryString = "update OrderT as o set o.shippingstate=:shippingstate where o.orderid=:orderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("orderid", orderid);
					query.setParameter("shippingstate", shippingstate);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  OrderT UpdateOrderShippingstateByorderid error", re);
			throw re;
		}
		return 0;
	}

	public int updateOrderStateByorderid(final String orderid, final String orderstate) {
		log.debug("update OrderT UpdateOrderStateByorderid");
		try {

			final String queryString = "update OrderT as o set o.orderstate=:orderstate where o.orderid=:orderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("orderid", orderid);
					query.setParameter("orderstate", orderstate);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  OrderT UpdateOrderStateByorderid error", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<OrderT> findAllOrderT(final int currentPage, final int lineSize) {
		log.debug("find all OrderT");
		try {
			List<OrderT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from OrderT as o  order by purchasetime desc";

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
			log.error("find all OrderT ", re);
			throw re;
		}
	}

	public int countfindAllOrderT() {
		log.debug("count all OrderT");
		try {
			String queryString = "select count(*) from OrderT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all OrderT ", re);
			throw re;
		}
	}

	public int countfindOrderbyOrderid(String orderid) {
		log.debug("count all countfindOrderbyOrderid");
		try {
			String queryString = "select count(*) from OrderT as o where o.orderid=:orderid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "orderid", orderid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindOrderbyOrderid ", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderT> findOrderByOrderid(final int currentPage, final int lineSize, final String orderid) {
		log.debug("find all findOrderByOrderid");
		try {
			List<OrderT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from OrderT as o  where o.orderid=:orderid order by purchasetime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("orderid", orderid);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all findOrderByOrderid ", re);
			throw re;
		}
	}

	public int countfindOrderByShippingUsername(String shippingusername) {
		log.debug("count all countfindOrderByShippingUsername");
		try {
			String queryString = "select count(*) from OrderT as o where o.shippingusername=:shippingusername";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "shippingusername", shippingusername);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindOrderByShippingUsername ", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderT> findOrderByShippingUsername(final int currentPage, final int lineSize, final String shippingusername) {
		log.debug("find all findOrderByShippingUsername");
		try {
			List<OrderT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from OrderT as o  where o.shippingusername=:shippingusername order by purchasetime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("shippingusername", shippingusername);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all findOrderByShippingUsername ", re);
			throw re;
		}
	}

	public int updateOrderPayShippingState(final String orderid, final String orderstate, final String paystate, final String shippingstate) {
		log.debug("update OrderT UpdateOrderPayShippingState");
		try {

			final String queryString = "update OrderT as o set o.orderstate=:orderstate,o.paystate=:paystate,o.shippingstate=:shippingstate where o.orderid=:orderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("orderid", orderid);
					query.setParameter("orderstate", orderstate);
					query.setParameter("paystate", paystate);
					query.setParameter("shippingstate", shippingstate);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  OrderT UpdateOrderPayShippingState error", re);
			throw re;
		}
		return 0;
	}

	public int countfindAllTobeShippedOrders(String orderstate,String paystate,String shippingstate) {
		log.debug("count all countfindAllTobeShippedOrders");
		try {
			String queryString = "select count(*) from OrderT as o  where o.orderstate=:orderstate and o.paystate=:paystate and o.shippingstate=:shippingstate order by purchasetime desc";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[]{"orderstate","paystate","shippingstate"}, new Object[]{orderstate,paystate,shippingstate});
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindAllTobeShippedOrders ", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderT> findAllTobeShippedOrders(final int currentPage, final int lineSize, final String orderstate,final String paystate,final String shippingstate) {
		log.debug("find all findAllTobeShippedOrders");
		try {
			List<OrderT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from OrderT as o  where o.orderstate=:orderstate and o.paystate=:paystate and o.shippingstate=:shippingstate order by purchasetime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("paystate", paystate);
					query.setParameter("orderstate", orderstate);
					query.setParameter("shippingstate", shippingstate);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("find all findAllTobeShippedOrders ", re);
			throw re;
		}
	}

	public int updateExpressnumberByOrderId(final String orderid, final String expressnumber) {
		log.debug("update OrderT UpdateExpressnumberByOrderId");
		try {

			final String queryString = "update OrderT as o set o.expressnumber=:expressnumber where o.orderid=:orderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("orderid", orderid);
					query.setParameter("expressnumber", expressnumber);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  OrderT UpdateExpressnumberByOrderId error", re);
			throw re;
		}
		return 0;
	}

	//deliverynumber invoicenumber
	//deliverytime invoicetime
	public int updateInvoicenumberByOrderId(final String orderid, final String deliverynumber, final Date deliverytime) {
		log.debug("update OrderT UpdateInvoicenumberByOrderId");
		try {

			final String queryString = "update OrderT as o set o.deliverynumber=:deliverynumber,o.deliverytime=:deliverytime where o.orderid=:orderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("orderid", orderid);
					query.setParameter("deliverynumber", deliverynumber);
					query.setParameter("deliverytime", deliverytime);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  OrderT UpdateInvoicenumberByOrderId error", re);
			throw re;
		}
		return 0;
	}

	public int updateInvoiceByOrderId(final String orderid, final String invoice) {
		log.debug("update OrderT UpdateInvoiceByOrderId");
		try {

			final String queryString = "update OrderT as o set o.invoice=:invoice where o.orderid=:orderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("orderid", orderid);
					query.setParameter("invoice", invoice);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  OrderT UpdateInvoicenumberByOrderId error", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<OrderT> sortAllOrderT(final int currentPage, final int lineSize, final String queryString) {
		log.debug("find all OrderT");
		try {
			List<OrderT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

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
			log.error("find all OrderT ", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderT> findAllhaveshippedOrder(final int currentPage, final int lineSize, final String shippingstate) {
		log.debug("find all haveshippedOrder");
		try {
			List<OrderT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					String queryString = "from OrderT as ot where ot.shippingstate=:shippingstate order by purchasetime desc";
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("shippingstate", shippingstate);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0 && list != null) {
				return list;
			}
			return null;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			log.error("find all haveshippedOrder error");
			e.printStackTrace();
			throw e;

		}
	}

	@SuppressWarnings("unchecked")
	public int countAllhaveshippedOrder(String shippingstate) {
		log.debug("count all haveshippedOrder");
		try {
			String queryString = "select count(*) from OrderT as ot where ot.shippingstate=:shippingstate order by purchasetime desc";
			List<OrderT> list = this.getHibernateTemplate().findByNamedParam(queryString, "shippingstate", shippingstate);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}

		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			log.error("count all haveshippedOrder error");
			e.printStackTrace();
			throw e;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public int countAllreturnOrder(String orderstate) {
		log.debug("count all returnOrder");
		try {
			String queryString = "select count(*) from OrderT as ot where ot.orderstate=:orderstate order by purchasetime desc";
			List<OrderT> list = this.getHibernateTemplate().findByNamedParam(queryString, "orderstate", orderstate);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}

		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			log.error("count all returnOrder error");
			e.printStackTrace();
			throw e;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<OrderT> findAllreturnOrder(final int currentPage, final int lineSize, final String orderstate) {
		log.debug("find all returnOrder");
		try {
			List<OrderT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					String queryString = "from OrderT as ot where ot.orderstate=:orderstate order by purchasetime desc";
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("orderstate", orderstate);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0 && list != null) {
				return list;
			}
			return null;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			log.error("find all returnOrder error");
			e.printStackTrace();
			throw e;

		}
	}


}