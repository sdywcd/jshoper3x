package com.jshop.redis.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.entity.MemberT;
import com.jshop.redis.dao.RedisMemberDao;
import com.jshop.redis.service.RedisMemberService;

@Service("redisMemberService")
@Scope("prototype")
public class RedisMemberServiceImpl implements  RedisMemberService{
	@Resource
	private RedisMemberDao redisMemberDao;

	public RedisMemberDao getRedisMemberDao() {
		return redisMemberDao;
	}

	public void setRedisMemberDao(RedisMemberDao redisMemberDao) {
		this.redisMemberDao = redisMemberDao;
	}

	@Override
	public void save(final MemberT memberT) {
		this.getRedisMemberDao().save(memberT);
		
	}

	@Override
	public MemberT read(final String id) {
		return this.getRedisMemberDao().read(id);
	}

	@Override
	public void delete(final String id) {
		this.getRedisMemberDao().delete(id);
		
	}

	
}
