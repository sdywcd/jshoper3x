package com.jshop.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GoodsTypeBrandTDao;
import com.jshop.entity.GoodsTypeBrandT;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoodsTypeBrandT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.GoodsTypeBrandT
 * @author MyEclipse Persistence Tools
 */
@Repository("goodsTypeBrandTDao")
public class GoodsTypeBrandTDaoImpl extends BaseTDaoImpl<GoodsTypeBrandT> implements GoodsTypeBrandTDao {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsTypeBrandTDaoImpl.class);
	


}