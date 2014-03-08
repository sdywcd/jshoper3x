package com.jshop.service;

import java.util.List;

import com.jshop.entity.RoleFunctionM;
import com.jshop.entity.RoleM;

public interface RoleFunctionMService extends BaseTService<RoleFunctionM> {

	/**
	 * 增加用户权限
	 * @param rm
	 * @param functionids
	 */
	public void addRoleFunctionM(RoleM rm,String functionids);


	/**
	 * 根据角色获取权限列表
	 * 
	 * @return
	 */
	public List<RoleFunctionM> findAllRoleFunctionMByroleid(String roleid);

	/**
	 * 更新用户角色权限
	 */
	public void delRoleFunctionM(String roleid);

}
