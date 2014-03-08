package com.jshop.service;

import java.util.List;

import com.jshop.entity.FunctionM;

public interface FunctionMService extends BaseTService<FunctionM>{

	/**
	 * 更新模块功能
	 * @param fm
	 */
	public abstract void updateFunctionM(FunctionM fm);
	/**
	 * 根据功能id获取功能信息
	 * @param id
	 * @return
	 */
	public abstract FunctionM findFunctionMById(String id);
	/**
	 * 批量删除功能信息
	 * @param strs
	 * @return
	 */
	public abstract int delFunctionM(String []strs);
	/**
	 * 获取所有功能信息
	 * @return
	 */
	public abstract List<FunctionM>findAllFunctionM();
	/**
	 * 根据模块id获取功能列表数据
	 * @param moduleid
	 * @return
	 */
	public abstract List<FunctionM>findAllFunctionMBymoduleid(String moduleid);
}
