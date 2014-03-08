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

import com.jshop.dao.TemplateTDao;
import com.jshop.entity.TemplateT;

/**
 * A data access object (DAO) providing persistence and search support for
 * TemplateT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.TemplateT
 * @author MyEclipse Persistence Tools
 */

@Repository("templateTDao")
public class TemplateTDaoImpl extends BaseTDaoImpl<TemplateT> implements TemplateTDao {
	
	private static final Logger log = LoggerFactory.getLogger(TemplateTDaoImpl.class);

	

	public int countfindAllTemplate(String creatorid) {
		log.debug("count all TemplateT");
		try {
			String queryString = "select count(*) from TemplateT as tt where tt.creatorid=:creatorid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all TemplateT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TemplateT> findAllTemplate(final int currentPage, final int lineSize, final String creatorid) {
		log.debug("find all brand");
		try {
			List<TemplateT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from TemplateT as tt where tt.creatorid=:creatorid order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("creatorid", creatorid);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("find all TemplateT error", re);
			throw re;
		}
	}

	public int delTemplate(final String[] list) {
		log.debug("del TemplateT");
		try {
			final String queryString = "delete from TemplateT as tt where tt.tid=:tid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("tid", s);
						i = query.executeUpdate();
					}
					if (list.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("del TemplateT failed", re);
			throw re;
		}
		return 0;
	}

	public List<TemplateT> findAllTemplateWithNoParam(String creatorid,String status) {
		log.debug("findAllTemplateWithNoParam");
		try {
			String queryString = "from TemplateT as tt where tt.creatorid=:creatorid and tt.status=:status";
			List<TemplateT> list = this.getHibernateTemplate().findByNamedParam(queryString,new String[]{"creatorid","status"}, new Object[]{creatorid,status});
			return list;
		} catch (RuntimeException re) {
			log.error("findAllTemplateWithNoParam error", re);
			throw re;
		}
	}

	public int findTemplateBynameandnote(String creatorid, String note, String name) {
		log.debug("findTemplateBynameandnote");
		try {
			String queryString = "from TemplateT as tt where tt.creatorid=:creatorid and tt.note=:note and tt.name=:name";
			List<TemplateT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "creatorid", "note", "name" }, new Object[] { creatorid, note, name });
			if (list != null && list.size() > 0) {
				return 1;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("findTemplateBynameandnote error", re);
			throw re;
		}
	}

	public int checkTemplateBysign(String sign) {
		log.debug("checkTemplateBysign");
		try {
			String queryString = "from TemplateT as tt where tt.sign=:sign";
			List<TemplateT> list = this.getHibernateTemplate().findByNamedParam(queryString,"sign", sign);
			if (list != null && list.size() > 0) {
				return 1;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("checkTemplateBysign error", re);
			throw re;
		}
	}

	public TemplateT findTemplateByname(String creatorid, String name) {
		log.debug("findTemplateByname");
		try {
			String queryString = "from TemplateT as tt where tt.creatorid=:creatorid and tt.name=:name";
			List<TemplateT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "creatorid", "name" }, new Object[] { creatorid, name });
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findTemplateByname error", re);
			throw re;
		}
	}

	public TemplateT findTemplateBytype(String type) {
		log.debug("findTemplateByname");
		try {
			String queryString = "from TemplateT as tt where  tt.type=:type";
			List<TemplateT> list = this.getHibernateTemplate().findByNamedParam(queryString, "type", type);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findTemplateByname error", re);
			throw re;
		}
	}

	public TemplateT checkTemplatetheme(String themeid) {
		log.debug("checkTemplateBysign");
		try {
			String queryString = "from TemplateT as tt where tt.themeid=:themeid";
			List<TemplateT> list = this.getHibernateTemplate().findByNamedParam(queryString,"themeid", themeid);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("checkTemplateBysign error", re);
			throw re;
		}
	}

	public int updateTemplatetBystatus(final String themeid, final String status) {
		log.debug("updateTemplatethemestatus");
		try {
			final String queryString = "update TemplateT as tt set tt.status=:status where tt.themeid=:themeid";
			this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("themeid", themeid);
					query.setParameter("status", status);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateTemplatethemestatus error", re);
			throw re;
		}
		return 0;
	}

	public TemplateT findTemplateBysign(String sign, String status) {
		log.debug("findTemplateBysign");
		try {
			String queryString = "from TemplateT as tt where tt.sign=:sign and tt.status=:status";
			List<TemplateT> list = this.getHibernateTemplate().findByNamedParam(queryString,new String[]{"sign","status"}, new Object[]{sign,status});
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findTemplateBysign error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TemplateT> findTemplateTByLikeName(final int currentPage,
			final int lineSize, final String name) {
		log.debug("findTemplateTByLikeName success");
		try {
			final String queryString="from TemplateT as tt where tt.note like ? ";
			List<TemplateT> list=  this.getHibernateTemplate().executeFind(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage-1)*lineSize);
					query.setMaxResults(lineSize);
					query.setParameter(0, "%" + name+ "%");
					List list = query.list();
				
					return list;
				}
				});
			if(list.size()>0){
				return list;
			}
			return null;
		} catch (DataAccessException e) {
			log.error("findTemplateTByLikeName error",e);
			throw e;
		}
	}

	@Override
	public int countTemplateTBYLikeNmae(final String name) {
		try {
			final String queryString="select count(*) from TemplateT as tt where tt.note like ?";
			//List list = this.getHibernateTemplate().findByNamedParam(queryString, "?", "%"+name+"%");
			List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter(0, "%"+name+"%");
					List list= query.list();
					return list;
				}
			});
			if(list.size()>0){
				Object o =list.get(0);
				long l=(Long) o;
				return (int) l;
			}
			return 0;
		} catch (DataAccessException e) {
			throw e;
		}
	}


	
	
	
	
	
}