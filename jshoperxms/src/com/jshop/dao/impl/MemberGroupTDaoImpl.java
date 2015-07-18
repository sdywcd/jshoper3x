package com.jshop.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.MemberGroupTDao;
import com.jshop.entity.MemberGroupT;

@Repository("memberGroupTDao")
public class MemberGroupTDaoImpl extends BaseTDaoImpl<MemberGroupT> implements MemberGroupTDao {
	private static final Logger log = LoggerFactory.getLogger(MemberGroupTDaoImpl.class);

}
