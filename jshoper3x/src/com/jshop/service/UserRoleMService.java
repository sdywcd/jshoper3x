package com.jshop.service;

import java.util.List;

import com.jshop.entity.UserRoleM;

public interface UserRoleMService extends BaseTService<UserRoleM>{


	/**
	 * 根据用户id删除角色
	 * @param roleid
	 */
	public  int delUserRoleM(String userid);
	/**
	 * 根据userid获取用户角色
	 * @param userid
	 * @return
	 */
	public  List<UserRoleM>findUserRoleMByuserid(String userid);
	
}
