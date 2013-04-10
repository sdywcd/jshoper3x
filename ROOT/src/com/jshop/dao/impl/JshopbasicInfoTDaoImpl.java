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

import com.jshop.dao.JshopbasicInfoTDao;
import com.jshop.entity.JshopbasicInfoT;

/**
 * A data access object (DAO) providing persistence and search support for
 * JshopbasicInfoT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.JshopbasicInfoT
 * @author MyEclipse Persistence Tools
 */
@Repository("jshopbasicInfoTDao")
public class JshopbasicInfoTDaoImpl extends HibernateDaoSupport implements JshopbasicInfoTDao {
	
	private static final Log log = LogFactory.getLog(JshopbasicInfoTDaoImpl.class);
	

	public int addJshopbasicInfoT(JshopbasicInfoT jbit) {
		log.debug("save JshopbasicInfoT");
		try {
			this.getHibernateTemplate().save(jbit);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public int countfindAllJshopbasicInfo(String creatorid) {
		log.debug("count all countfindAllJshopbasicInfo");
		try {
			String queryString = "select count(*) from JshopbasicInfoT as jbi where jbi.creatorid=:creatorid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all JshopbasicInfoT error", re);
			throw re;
		}
	}

	public int delJshopbasicInfo(final String[] list, final String creatorid) {
		log.debug("del DelJshopbasicInfo");
		try {

			final String queryString = "delete from JshopbasicInfoT as jbi where jbi.basicinfoid=:basicinfoid and jbi.creatorid=:creatorid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("basicinfoid", s);
						query.setParameter("creatorid", creatorid);
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
			log.error("del DelJshopbasicInfo failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<JshopbasicInfoT> findAllJshopbasicInfo(final int currentPage, final int lineSize, final String creatorid) {
		log.debug("find all JshopbasicInfoT");
		try {
			List<JshopbasicInfoT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from JshopbasicInfoT as jbi where jbi.creatorid=:creatorid";

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
			log.error("find all brand error", re);
			throw re;
		}
	}

	public JshopbasicInfoT findJshopbasicInfoTById(String basicinfoid) {
		log.debug("find by id JshopbasicInfoT");
		try {
			String queryString = "from JshopbasicInfoT as jbi where jbi.basicinfoid=:basicinfoid";
			List<JshopbasicInfoT> list = this.getHibernateTemplate().findByNamedParam(queryString, "basicinfoid", basicinfoid);
			if(!list.isEmpty()){
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id JshopbasicInfoT error", re);
			throw re;
		}
	}

	public int updateJshopbasicInfo(final JshopbasicInfoT jbi) {
		log.debug("update BrandT");
		try {

			final String queryString = "update JshopbasicInfoT as jbi set jbi.jshopname=:jshopname,jbi.jshopslogan=:jshopslogan,jbi.country=:country,jbi.province=:province," + "jbi.city=:city,jbi.district=:district,jbi.street=:street,jbi.qqservice=:qqservice,jbi.taobaowwservice=:taobaowwservice,jbi.skypeservice=:skypeservice,jbi.yahooservice=:yahooservice,jbi.msnservice=:msnservice," + "jbi.emailservice=:emailservice,jbi.phoneservice=:phoneservice,jbi.openstate=:openstate,jbi.siteclosenotes=:siteclosenotes,jbi.sitelogo=:sitelogo,jbi.licensed=:licensed,jbi.usercenternote=:usercenternote,"
					+ "jbi.jshopnotice=:jshopnotice,jbi.registerclose=:registerclose,jbi.icpnum=:icpnum,jbi.sendName=:sendName,jbi.sendCountry=:sendCountry,jbi.sendProvince=:sendProvince,jbi.sendCity=:sendCity,jbi.sendDistrict=:sendDistrict," + "jbi.sendStreet=:sendStreet,jbi.sendTelno=:sendTelno,jbi.sendMobile=:sendMobile,jbi.sendContactor=:sendContactor,jbi.state=:state,jbi.createtime=:createtime,jbi.metaKeywords=:metaKeywords,jbi.metaDes=:metaDes where jbi.basicinfoid=:basicinfoid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("basicinfoid", jbi.getBasicinfoid());
					query.setParameter("jshopname", jbi.getJshopname());
					query.setParameter("jshopslogan", jbi.getJshopslogan());
					query.setParameter("country", jbi.getCountry());
					query.setParameter("province", jbi.getProvince());
					query.setParameter("city", jbi.getCity());
					query.setParameter("street", jbi.getStreet());
					query.setParameter("qqservice", jbi.getQqservice());
					query.setParameter("taobaowwservice", jbi.getTaobaowwservice());
					query.setParameter("skypeservice", jbi.getSkypeservice());
					query.setParameter("yahooservice", jbi.getYahooservice());
					query.setParameter("msnservice", jbi.getMsnservice());
					query.setParameter("emailservice", jbi.getEmailservice());
					query.setParameter("phoneservice", jbi.getPhoneservice());
					query.setParameter("openstate", jbi.getOpenstate());
					query.setParameter("siteclosenotes", jbi.getSiteclosenotes());
					query.setParameter("sitelogo", jbi.getSitelogo());
					query.setParameter("licensed", jbi.getLicensed());
					query.setParameter("usercenternote", jbi.getUsercenternote());
					query.setParameter("jshopnotice", jbi.getJshopnotice());
					query.setParameter("registerclose", jbi.getRegisterclose());
					query.setParameter("icpnum", jbi.getIcpnum());
					query.setParameter("sendName", jbi.getSendName());
					query.setParameter("sendCountry", jbi.getSendCountry());
					query.setParameter("sendProvince", jbi.getSendProvince());
					query.setParameter("sendCity", jbi.getSendCity());
					query.setParameter("sendDistrict", jbi.getSendDistrict());
					query.setParameter("sendStreet", jbi.getSendStreet());
					query.setParameter("sendTelno", jbi.getSendTelno());
					query.setParameter("sendMobile", jbi.getSendMobile());
					query.setParameter("sendContactor", jbi.getSendContactor());
					query.setParameter("state", jbi.getState());
					query.setParameter("district", jbi.getDistrict());
					query.setParameter("createtime", jbi.getCreatetime());
					query.setParameter("metaKeywords", jbi.getMetaKeywords());
					query.setParameter("metaDes", jbi.getMetaDes());
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

	public int updateJshopbasicInfostate(final String basicinfoid, final String state) {
		log.debug("update updateJshopbasicInfostate");
		try {

			final String queryString = "update JshopbasicInfoT as jbi set jbi.state=:state where jbi.basicinfoid=:basicinfoid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("basicinfoid", basicinfoid);
					query.setParameter("state", state);
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

	@SuppressWarnings("unchecked")
	public JshopbasicInfoT findJshopbasicInfoSingleForExpress(final String creatorid) {
		log.debug("find  findJshopbasicInfoSingleForExpress");
		try {
			List<JshopbasicInfoT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from JshopbasicInfoT as jbi where jbi.state='1' and jbi.creatorid=:creatorid";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setMaxResults(1);
					query.setParameter("creatorid", creatorid);
					List list = query.list();
					return list;
				}
			});
			if(!list.isEmpty()){
				return list.get(0);
			}
			return null;
			
		} catch (RuntimeException re) {
			log.error("find all brand error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<JshopbasicInfoT> findJshopbasicInfoBycreatorid(String creatorid) {
		log.debug("find by id findJshopbasicInfoBycreatorid");
		try {
			String queryString = "from JshopbasicInfoT as jbi where jbi.creatorid=:creatorid";
			List<JshopbasicInfoT> list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			return list;
			
		} catch (RuntimeException re) {
			log.error("find by id findJshopbasicInfoBycreatorid error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<JshopbasicInfoT> findAllJshopbasicInfoNoParam(final int currentPage, final int lineSize, final String state) {
		log.debug("find all findAllJshopbasicInfoNoParam");
		try {
			List<JshopbasicInfoT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from JshopbasicInfoT as jbi where jbi.state=:state and jbi.openstate=:openstate";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("state", state);
					query.setParameter("openstate", state);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("find all findAllJshopbasicInfoNoParam error", re);
			throw re;
		}
	}

	public JshopbasicInfoT findJshopbasicInfoBystateandopstate(String creatorid, String state, String openstate) {
		log.debug("find by id JshopbasicInfoT");
		try {
			String queryString = "from JshopbasicInfoT as jbi where jbi.creatorid=:creatorid and jbi.state=:state and jbi.openstate=:openstate";
			List<JshopbasicInfoT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "creatorid", "state", "openstate" }, new Object[] { creatorid, state, openstate });
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id JshopbasicInfoT error", re);
			throw re;
		}
	}

	public JshopbasicInfoT findJshopbasicInfoBystateandopstate(String state, String openstate) {
		log.debug("find by id JshopbasicInfoT");
		try {
			String queryString = "from JshopbasicInfoT as jbi where  jbi.state=:state and jbi.openstate=:openstate";
			List<JshopbasicInfoT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "state", "openstate" }, new Object[] { state, openstate });
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id JshopbasicInfoT error", re);
			throw re;
		}
	}
}