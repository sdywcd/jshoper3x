package com.jshop.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GoodsTwocodeRelationshipTDao;
import com.jshop.entity.GoodsTwocodeRpT;

@Repository("goodsTwocodeRelationshipTDao")
public class GoodsTwocodeRelationshipTDaoImpl extends
		BaseTDaoImpl<GoodsTwocodeRpT> implements GoodsTwocodeRelationshipTDao {
	private static final Logger log = LoggerFactory
			.getLogger(GoodsTwocodeRelationshipTDaoImpl.class);


}
