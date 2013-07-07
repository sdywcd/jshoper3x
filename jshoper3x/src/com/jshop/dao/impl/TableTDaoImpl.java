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

import com.jshop.dao.TableTDao;
import com.jshop.entity.TableT;

/**
 * A data access object (DAO) providing persistence and search support for
 * TableT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.TableT
 * @author MyEclipse Persistence Tools
 */
@Repository("tableTDao")
public class TableTDaoImpl extends HibernateDaoSupport implements TableTDao{
	private static final Logger log = LoggerFactory.getLogger(TableTDaoImpl.class);

	public int addTableT(TableT t) {
		log.debug("save TableT");
		try {
			this.getHibernateTemplate().save(t);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public int countfindAllTableT() {
		log.debug("countfindAllTableT");
		try {
			String queryString = "select count(*) from TableT";
			List<TableT> list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllTableT error", re);
			throw re;
		}
	}

	public int delTableT(final String[] strs) {
		log.debug("delTableT");
		try {
			final String queryString = "delete from TableT as t where t.tableid=:tableid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : strs) {
						query.setParameter("tableid", s);
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
			log.error("delTableT failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<TableT> findAllTableT() {
		log.debug("findAllTableT");
		try {
			String queryString = "from TableT";
			List<TableT> list = this.getHibernateTemplate().find(queryString);
			return list;
		} catch (RuntimeException re) {
			log.error("findAllTableT error", re);
			throw re;
		}
	}

	public TableT findTableBytableid(String tableid) {
		log.debug("findTableBytableid");
		try {
			TableT instance = (TableT) this.getHibernateTemplate().get("com.jshop.entity.TableT", tableid);
			return instance;
		} catch (RuntimeException re) {
			log.error("findTableBytableid failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TableT> sortAllTableT(final int currentPage, final int lineSize, final String queryString) {
		log.debug("sortAllTableT");
		try {
			List<TableT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
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
			log.error("sortAllTableT failed",re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TableT> findAllTableT(final int currentPage, final int lineSize) {
		log.debug("sortAllTableT");
		try {
			List<TableT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				String queryString="from TableT";
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
			log.error("sortAllTableT failed",re);
			throw re;
		}
	}

	public void updateTableT(TableT t) {
		log.debug("updateTableT");
		try {
			this.getHibernateTemplate().update(t);			
		} catch (RuntimeException re) {
			log.error("updateTableT failed", re);
			throw re;
		}
		
	}

	public int updateTableTtablestateBytableNo(final String tableid, final String tablestate) {
		log.debug("updateTableTtablestateBytableNo");
		try {
			final String queryString = "update TableT as t set t.tablestate=:tablestate where t.tableid=:tableid";
			Integer integer=(Integer) this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("tableid", tableid);
					query.setParameter("tablestate", tablestate);
					i = query.executeUpdate();
					return i;
				}
			});
			return integer;
		} catch (RuntimeException re) {
			log.error("updateTableTtablestateBytableNo error", re);
			throw re;
		}
		
	}

	@Override
	public List<TableT> findTableBytablenumber(String tableNumber) {
		log.debug("findTableBytablenumber");
		try {
			String queryString="from TableT as tt where tt.tableNumber=:tableNumber";
			List<TableT>list=this.getHibernateTemplate().findByNamedParam(queryString, "tableNumber", tableNumber);
			return list;

		} catch (RuntimeException re) {
			log.error("findTableBytablenumber failed", re);
			throw re;
		}
	}
	

}