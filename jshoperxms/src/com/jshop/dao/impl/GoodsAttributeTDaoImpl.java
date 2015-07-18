package com.jshop.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GoodsAttributeTDao;
import com.jshop.entity.GoodsAttributeT;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoodsAttributeT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.GoodsAttributeT
 * @author MyEclipse Persistence Tools
 */
@Repository("goodsAttributeTDao")
public class GoodsAttributeTDaoImpl extends BaseTDaoImpl<GoodsAttributeT> implements GoodsAttributeTDao {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsAttributeTDaoImpl.class);

	
}