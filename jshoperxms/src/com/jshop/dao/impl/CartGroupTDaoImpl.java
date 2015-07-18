package com.jshop.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.CartGroupTDao;
import com.jshop.entity.CartGroupT;
@Repository("cartGroupTDao")
public class CartGroupTDaoImpl extends BaseTDaoImpl<CartGroupT> implements CartGroupTDao {
	private static final Log log = LogFactory.getLog(CartGroupTDaoImpl.class);


}
