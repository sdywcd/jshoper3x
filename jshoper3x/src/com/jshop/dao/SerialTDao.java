package com.jshop.dao;

import com.jshop.entity.SerialT;

public interface SerialTDao extends BaseTDao<SerialT> {

	/**
	 * 查找新的逻辑id
	 * @param baseid
	 * @return
	 */
	public  SerialT findBybaseid(String biz);
	/**
	 * 更新新的逻辑id
	 * @param baseid
	 * @return
	 */
	public  int updateBybaseid(SerialT transientInstance);
}
