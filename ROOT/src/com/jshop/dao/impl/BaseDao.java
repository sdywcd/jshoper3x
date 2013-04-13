package com.jshop.dao.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDao<E> extends HibernateDaoSupport {
	  @Resource(name = "sessionFactory")  
	    public void setInjectionSessionFacotry(SessionFactory sessionFacotry) {  
	        super.setSessionFactory(sessionFacotry);  
	    }  
	  
	    @PostConstruct  
	    public void injectSessionFactory() {  
	        logger.info(super.getSessionFactory());  
	    }  
	
}
