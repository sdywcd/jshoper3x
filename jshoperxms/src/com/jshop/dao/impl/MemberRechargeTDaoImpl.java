
package com.jshop.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.MemberRechargeTDao;
import com.jshop.entity.MemberRechargeT;
@Repository("memberRechargeTDao")
public class MemberRechargeTDaoImpl extends BaseTDaoImpl<MemberRechargeT> implements MemberRechargeTDao {
	private static final Logger log = LoggerFactory.getLogger(MemberRechargeTDaoImpl.class);
	


}
