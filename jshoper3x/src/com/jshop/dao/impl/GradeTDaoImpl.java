package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GradeTDao;
import com.jshop.entity.GradeT;

/**
 * A data access object (DAO) providing persistence and search support for
 * GradeT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.GradeT
 * @author MyEclipse Persistence Tools
 */
@Repository("gradeTDao")
public class GradeTDaoImpl extends HibernateDaoSupport implements GradeTDao {
	
	private static final Log log = LogFactory.getLog(GradeTDaoImpl.class);
	

	public int addGradet(GradeT gt) {
		log.debug("save GradeT");
		try {
			this.getHibernateTemplate().save(gt);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public int countfindAllGrade() {
		log.debug("count all GradeT");
		try {
			String queryString = "select count(*) from GradeT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all GradeT error", re);
			throw re;
		}
	}

	public int delGradet(final String[] list) {
		log.debug("del GradeT");
		try {

			final String queryString = "delete from GradeT as gt where gt.gradeid=:gradeid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("gradeid", s);
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
			log.error("del GradeT failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<GradeT> findAllGrade(final int currentPage, final int lineSize) {
		log.debug("find all GradeT");
		try {
			List<GradeT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from GradeT  order by createtime desc";

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
			log.error("find all GradeT error", re);
			throw re;
		}
	}

	public List<GradeT> findAllGradeByValue(String gradevalue) {
		log.debug("find all GradeT");
		try {
			String queryString = "from GradeT as gt where gt.gradevalue=:gradevalue";
			List<GradeT> list = this.getHibernateTemplate().findByNamedParam(queryString, "gradevalue", gradevalue);
			return list;
		} catch (RuntimeException re) {
			log.error("find all VouchersT error", re);
			throw re;
		}
	}

	public GradeT findGradeById(String gradeid) {
		log.debug("find by id GradeT");
		try {
			String queryString = "from GradeT as gt where gt.gradeid=:gradeid";
			List<GradeT> list = this.getHibernateTemplate().findByNamedParam(queryString, "gradeid", gradeid);
			if (list != null) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id GradeT error", re);
			throw re;
		}
	}

	public void updateGradeById(GradeT gt) {
		log.debug("update GradeT");
		try {
			this.getHibernateTemplate().update(gt);
		} catch (RuntimeException re) {
			log.error("update  GradeT error", re);
			throw re;
		}
	}

	@Override
	public List<GradeT> findAllGrade() {
		log.debug("findAllGrade");
		try {
			String queryString = "from GradeT";
			List<GradeT> list = this.getHibernateTemplate().find(queryString);
			return list;
		} catch (RuntimeException re) {
			log.error("find by id GradeT error", re);
			throw re;
		}
	}
	
	
	
	
	
}