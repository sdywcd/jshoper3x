package com.jshop.service;

import java.util.List;

import com.jshop.entity.GlobalParamM;

public interface GlobalParamService extends BaseTService<GlobalParamM>{
	/**
	 * 更新全局变量
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public void updateGolbalParamByKey(GlobalParamM gm);

	/**
	 * 根据key获取全局值
	 * 
	 * @param key
	 * @return
	 */
	public GlobalParamM findValueByKey(String key);

	/**
	 * 获取所有全局变量
	 * 
	 * @return
	 */
	public List<GlobalParamM> findAllGlobalParam();

}
