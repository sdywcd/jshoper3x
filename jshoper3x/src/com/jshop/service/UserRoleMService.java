package com.jshop.service;

import java.util.List;

import com.jshop.entity.UserRoleM;

public interface UserRoleMService {

	/**
	 * 增加用户和角色关系
	 * @param urm
	 */
	public abstract void addUserRoleM(UserRoleM urm);
	/**
	 * 根据用户id删除角色
	 * @param roleid
	 */
	public abstract int delUserRoleM(String userid);
	/**
	 * 根据userid获取用户角色
	 * @param userid
	 * @return
	 */
	public abstract List<UserRoleM>findUserRoleMByuserid(String userid);
	
}
