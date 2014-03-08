package com.jshop.dao;

import java.util.List;

import com.jshop.entity.ModuleM;

public interface ModuleMDao extends BaseTDao<ModuleM>{


	/**
	 * 更新系统模块信息
	 * 
	 * @param mm
	 */
	public void updateModuleM(ModuleM mm);

	/**
	 * 根据Id获取系统模块信息
	 * 
	 * @param id
	 * @return
	 */
	public ModuleM findModuleMById(String id);

	/**
	 * 删除模块信息
	 * 
	 * @param strs
	 * @return
	 */
	public int delModuleM(String[] strs);

	/**
	 * 查询所有模块信息
	 * 
	 * @return
	 */
	public List<ModuleM> findAllModuleM();
}
