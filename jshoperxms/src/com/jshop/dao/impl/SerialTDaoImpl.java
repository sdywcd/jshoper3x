package com.jshop.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jshop.dao.SerialTDao;
import com.jshop.entity.SerialT;

/**
 * A data access object (DAO) providing persistence and search support for
 * SerialT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.SerialT
 * @author MyEclipse Persistence Tools
 */
@Repository("serialTDao")
public class SerialTDaoImpl extends BaseTDaoImpl<SerialT> implements SerialTDao {
	
	private static final Log log = LogFactory.getLog(SerialTDaoImpl.class);
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	

	@SuppressWarnings("unchecked")
	public SerialT findBybaseid(String biz) {
		log.debug("finding newestid by baseid");
		try {
			Criteria criteria=this.getCurrentSession().createCriteria(SerialT.class);
			criteria.add(Restrictions.eq("biz", biz));
			List<SerialT> list = criteria.list();
			if(list!=null&&list.size()>0){
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("finding newestid failed", re);
			throw re;
		}
	}



	@SuppressWarnings("unchecked")
	public int updateBybaseid(SerialT transientInstance) {
		log.debug("update newestid");
		try {
//			String queryString = "update SerialT as st set st.lastid=st.lastid+st.increment where st.biz='" + transientInstance.getBiz() + "'";
			Criteria criteria=this.getCurrentSession().createCriteria(SerialT.class);
			criteria.add(Restrictions.eq("biz", transientInstance.getBiz()));
			List<SerialT>list=criteria.list();
			if(list!=null&&list.size()>0){
				SerialT serialT=list.get(0);
				serialT.setLastid(String.valueOf(Integer.parseInt(serialT.getLastid())+serialT.getIncrement()));
				this.getCurrentSession().update(serialT);
				return 1;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("update newest failed", re);
			throw re;
		}
	}


}