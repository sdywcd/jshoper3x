package com.jshop.dao;

import java.util.List;

import com.jshop.entity.RoleFunctionM;

public interface RoleFunctionMDao extends BaseTDao<RoleFunctionM>{

	/**
	 * 根据角色获取权限列表
	 * 
	 * @return
	 */
	public List<RoleFunctionM> findAllRoleFunctionMByroleid(String roleid);

	/**
	 * 根据角色id删除权限关系
	 * 
	 * @param roleid
	 * @return
	 */
	public int delRoleFunctionM(String roleid);
}
