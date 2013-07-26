package com.jshop.service;

import java.util.List;

import com.jshop.entity.RoleFunctionM;
import com.jshop.entity.RoleM;

public interface RoleFunctionMService {

	/**
	 * 增加角色可操作的功能
	 * @param rfm
	 */
	public abstract void addRoleFunctionM(RoleFunctionM rfm);
	/**
	 * 增加角色可操作的功能
	 * @param rm
	 * @param functionids
	 */
	public abstract void addRoleFunctionM(RoleM rm,String functionids);

	/**
	 * 根据角色获取权限列表
	 * @return
	 */
	public abstract List<RoleFunctionM>findAllRoleFunctionMByroleid(String roleid);
	/**
	 * 更新用户角色权限
	 */
	public abstract void delRoleFunctionM(String roleid);
	
}
