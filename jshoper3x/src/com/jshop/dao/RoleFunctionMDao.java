package com.jshop.dao;

import java.util.List;

import com.jshop.entity.RoleFunctionM;

public interface RoleFunctionMDao {

	/**
	 * 增加角色可操作的功能
	 * @param rfm
	 */
	public abstract void addRoleFunctionM(RoleFunctionM rfm);
	/**
	 * 根据角色获取权限列表
	 * @return
	 */
	public abstract List<RoleFunctionM>findAllRoleFunctionMByroleid(String roleid);
	/**
	 * 根据角色id删除权限关系
	 * @param roleid
	 * @return
	 */
	public abstract int delRoleFunctionM(String roleid);
}
