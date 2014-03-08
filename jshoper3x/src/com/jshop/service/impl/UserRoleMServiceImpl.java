package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.UserRoleMDao;
import com.jshop.entity.UserRoleM;
import com.jshop.service.UserRoleMService;
@Service("userRoleMService")
@Scope("prototype")
public class UserRoleMServiceImpl extends BaseTServiceImpl<UserRoleM> implements UserRoleMService {
	@Resource
	private UserRoleMDao userRoleMDao;
	
	public UserRoleMDao getUserRoleMDao() {
		return userRoleMDao;
	}

	public void setUserRoleMDao(UserRoleMDao userRoleMDao) {
		this.userRoleMDao = userRoleMDao;
	}


	public int delUserRoleM(String userid) {
		return this.getUserRoleMDao().delUserRoleM(userid);
	}

	public List<UserRoleM> findUserRoleMByuserid(String userid) {
		return this.getUserRoleMDao().findUserRoleMByuserid(userid);
	}

}
