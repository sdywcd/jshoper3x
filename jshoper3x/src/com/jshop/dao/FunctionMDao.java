package com.jshop.dao;

import java.util.List;

import com.jshop.entity.FavoriteT;
import com.jshop.entity.FunctionM;

public interface FunctionMDao extends BaseTDao<FunctionM>{

	/**
	 * 更新模块功能
	 * 
	 * @param fm
	 */
	public void updateFunctionM(FunctionM fm);

	/**
	 * 根据功能id获取功能信息
	 * 
	 * @param id
	 * @return
	 */
	public FunctionM findFunctionMById(String id);

	/**
	 * 批量删除功能信息
	 * 
	 * @param strs
	 * @return
	 */
	public int delFunctionM(String[] strs);

	/**
	 * 获取所有功能信息
	 * 
	 * @return
	 */
	public List<FunctionM> findAllFunctionM();

	/**
	 * 根据模块id获取功能列表数据
	 * 
	 * @param moduleid
	 * @return
	 */
	public List<FunctionM> findAllFunctionMBymoduleid(String moduleid);
}
