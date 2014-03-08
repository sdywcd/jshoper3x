package com.jshop.redis.service;

import com.jshop.entity.MemberT;

public interface RedisMemberService {
	
	public void save(MemberT memberT);

	public MemberT read(String id);

	public void delete(String id);
}
