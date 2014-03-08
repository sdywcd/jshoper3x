package com.jshop.redis.dao.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.jshop.entity.MemberT;
import com.jshop.redis.dao.RedisMemberDao;
@Repository("redisUserDao")
public class RedisMemberDaoImpl implements RedisMemberDao {
	@Autowired
	private RedisTemplate<Serializable, Serializable> redisTemplate;

	@Override
	public void save(final MemberT memberT) {
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.set(
						redisTemplate.getStringSerializer().serialize(
								"MemberT.id." + memberT.getId()),
						redisTemplate.getStringSerializer().serialize(
								memberT.getNick()));
				return null;
			}
		});
		
	}

	@Override
	public MemberT read(final String id) {
		return redisTemplate.execute(new RedisCallback<MemberT>() {
			@Override
			public MemberT doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key = redisTemplate.getStringSerializer().serialize(
						"MemberT.id." + id);
				if (connection.exists(key)) {
					byte[] value = connection.get(key);
					String nick = redisTemplate.getStringSerializer()
							.deserialize(value);
					MemberT memberT = new MemberT();
					memberT.setNick(nick);
					memberT.setId(id);
					return memberT;
				}
				return null;
			}
		});
	}

	@Override
	public void delete(final String id) {
		redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection) {
				connection.del(redisTemplate.getStringSerializer().serialize(
						"MemberT.uid." + id));
				return null;
			}
		});
		
	}

	
}
