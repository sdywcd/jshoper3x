package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.VouchersTDao;
import com.jshop.entity.VouchersT;

/**
 * A data access object (DAO) providing persistence and search support for
 * VouchersT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.VouchersT
 * @author MyEclipse Persistence Tools
 */
@Repository("vouchersTDao")
public class VouchersTDaoImpl extends BaseTDaoImpl<VouchersT> implements VouchersTDao {
	
	private static final Log log = LogFactory.getLog(VouchersTDaoImpl.class);
	

	public int countfindAllVoucherst() {
		log.debug("count all VouchersT");
		try {
			String queryString = "select count(*) from VouchersT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all VouchersT error", re);
			throw re;
		}
	}

	public int delVoucherst(final String[] list) {
		log.debug("del VouchersT");
		try {

			final String queryString = "delete from VouchersT as vt where vt.vouchersid=:vouchersid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("vouchersid", s);
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
			log.error("del VouchersT failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<VouchersT> findAllVoucherst(final int currentPage, final int lineSize) {
		log.debug("find all VouchersT");
		try {
			List<VouchersT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from VouchersT  order by createtime desc";

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
			log.error("find all brand error", re);
			throw re;
		}
	}

	public int updateVoucherst(final VouchersT vt) {
		log.debug("update VouchersT");
		try {
			final String queryString = "update VouchersT as vt set vt.vouchersname=:vouchersname,vt.begintime=:begintime,vt.endtime=:endtime,vt.voucherscontent=:voucherscontent,vt.limitprice=:limitprice,vt.givenuserid=:givenuserid,vt.voucherstate=:voucherstate,vt.voucheruseway=:voucheruseway,vt.state=:state,vt.creatorid=:creatorid,vt.createtime=:createtime where vt.vouchersid=:vouchersid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("vouchersid", vt.getVouchersid());
					query.setParameter("vouchersname", vt.getVouchersname());
					query.setParameter("begintime", vt.getBegintime());
					query.setParameter("endtime", vt.getEndtime());
					query.setParameter("voucherscontent", vt.getVoucherscontent());
					query.setParameter("limitprice", vt.getLimitprice());
					query.setParameter("givenuserid", vt.getGivenmemberid());
					query.setParameter("voucherstate", vt.getVoucherstate());
					query.setParameter("voucheruseway", vt.getVoucheruseway());
					query.setParameter("state", vt.getState());
					query.setParameter("creatorid", vt.getCreatorid());
					query.setParameter("createtime", vt.getCreatetime());
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  BrandT error", re);
			throw re;
		}
		return 0;
	}

	public List<VouchersT> findVoucherstByName(String vouchersname) {
		log.debug("find all VouchersT");
		try {
			String queryString = "from VouchersT as vt where vt.vouchersname=:vouchersname";
			List<VouchersT> list = this.getHibernateTemplate().findByNamedParam(queryString, "vouchersname", vouchersname);
			if (list != null) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all VouchersT error", re);
			throw re;
		}
	}

	public VouchersT findVouchersForHonor(String vouchersname) {
		log.debug("find all VouchersT");
		try {
			String queryString = "from VouchersT as vt where vt.vouchersname=:vouchersname and v.vouchersstate='1' ";
			List<VouchersT> list = this.getHibernateTemplate().findByNamedParam(queryString, "vouchersname", vouchersname);
			if (list != null) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all VouchersT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<VouchersT> findUserVouchers(final String userid, final int currentPage, final int lineSize) {
		log.debug("find all VouchersT");
		try {
			List<VouchersT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from VouchersT as vt where vt.givenuserid=:userid  order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("userid", userid);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all brand error", re);
			throw re;
		}
	}

	public int countfindUserVouchers(String userid) {
		log.debug("count user VouchersT");
		try {
			String queryString = "select count(*) from VouchersT as vt where vt.givenuserid=:userid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "userid", userid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count user VouchersT error", re);
			throw re;
		}
	}
}