package com.jshop.redis.dao;

import com.jshop.entity.MemberT;

public interface RedisMemberDao {
	
	public void save(MemberT memberT);

	public MemberT read(String id);

	public void delete(String id);
}
