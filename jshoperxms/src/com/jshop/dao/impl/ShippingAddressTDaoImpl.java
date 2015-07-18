package com.jshop.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.ShippingAddressTDao;
import com.jshop.entity.ShippingAddressT;

/**
 * A data access object (DAO) providing persistence and search support for
 * ShippingAddressT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.ShippingAddressT
 * @author MyEclipse Persistence Tools
 */
@Repository("shippingAddressTDao")
public class ShippingAddressTDaoImpl extends BaseTDaoImpl<ShippingAddressT> implements ShippingAddressTDao {

	

	private static final Log log = LogFactory.getLog(ShippingAddressTDaoImpl.class);
	

}