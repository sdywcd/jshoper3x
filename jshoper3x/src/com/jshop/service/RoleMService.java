package com.jshop.service;

import java.util.List;

import com.jshop.entity.RoleM;

public interface RoleMService {
	/**
	 * 增加角色
	 * @param rm
	 */
	public abstract void addRoleM(RoleM rm);
	
	/**
	 * 更新角色
	 * @param rm
	 */
	public abstract void updateRoleM(RoleM rm);
	/**
	 * 根据id获取角色信息
	 * @param id
	 * @return
	 */
	public abstract RoleM findRoleMById(String id);
	/**
	 * 删除角色
	 * @param strs
	 * @return
	 */
	public abstract int delRoleM(String []strs);
	/**
	 * 获取所有角色列表
	 * @return
	 */
	public abstract List<RoleM>findAllRoleM();
	
}
