package com.jshop.dao.impl;

import org.springframework.stereotype.Repository;

import com.jshop.dao.MemberGradeTDao;
import com.jshop.entity.MemberGradeT;

/**
 * A data access object (DAO) providing persistence and search support for
 * GradeT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.GradeT
 * @author MyEclipse Persistence Tools
 */
@Repository("memberGradeTDao")
public class MemberGradeTImpl extends BaseTDaoImpl<MemberGradeT> implements MemberGradeTDao {
	

	
	
}