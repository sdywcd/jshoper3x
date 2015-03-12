package com.jshop.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.TemplatethemeTDao;
import com.jshop.entity.TemplatethemeT;

/**
 * A data access object (DAO) providing persistence and search support for
 * TemplatethemeT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.TemplatethemeT
 * @author MyEclipse Persistence Tools
 */
@Repository("templatethemeTDao")
public class TemplatethemeTDaoImpl extends BaseTDaoImpl<TemplatethemeT> implements TemplatethemeTDao {
	
	private static final Logger log = LoggerFactory.getLogger(TemplatethemeTDaoImpl.class);
	
	
}