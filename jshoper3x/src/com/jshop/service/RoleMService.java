package com.jshop.service;

import java.util.List;

import com.jshop.entity.RoleM;

public interface RoleMService extends BaseTService<RoleM>{

	/**
	 * 更新角色
	 * 
	 * @param rm
	 */
	public void updateRoleM(RoleM rm);

	/**
	 * 根据id获取角色信息
	 * 
	 * @param id
	 * @return
	 */
	public RoleM findRoleMById(String id);

	/**
	 * 删除角色
	 * 
	 * @param strs
	 * @return
	 */
	public int delRoleM(String[] strs);

	/**
	 * 获取所有角色列表
	 * 
	 * @return
	 */
	public List<RoleM> findAllRoleM();

}
