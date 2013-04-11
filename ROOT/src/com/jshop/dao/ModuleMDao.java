package com.jshop.dao;

import java.util.List;

import com.jshop.entity.ModuleM;

public interface ModuleMDao {
	/**
	 * 增加系统模块信息
	 * @param mm
	 */
	public abstract void addModuleM(ModuleM mm); 
	/**
	 * 更新系统模块信息
	 * @param mm
	 */
	public abstract void updateModuleM(ModuleM mm);
	/**
	 * 根据Id获取系统模块信息
	 * @param id
	 * @return
	 */
	public abstract ModuleM findModuleMById(String id);
	/**
	 * 删除模块信息
	 * @param strs
	 * @return
	 */
	public abstract int delModuleM(String []strs);
	/**
	 * 查询所有模块信息
	 * @return
	 */
	public abstract List<ModuleM>findAllModuleM();
}
