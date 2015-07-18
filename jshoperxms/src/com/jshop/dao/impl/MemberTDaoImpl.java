package com.jshop.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.MemberTDao;
import com.jshop.entity.MemberT;

@Repository("memberTDao")
public class MemberTDaoImpl extends BaseTDaoImpl<MemberT> implements MemberTDao {
	private static final Logger log = LoggerFactory.getLogger(MemberTDaoImpl.class);


}
