package com.jshop.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
public class JshopbasicInfoTDaoImpl extends BaseTDaoImpl<JshopbasicInfoT> implements JshopbasicInfoTDao {
	
	private static final Log log = LogFactory.getLog(JshopbasicInfoTDaoImpl.class);
	

}