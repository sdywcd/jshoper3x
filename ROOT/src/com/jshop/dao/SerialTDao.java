package com.jshop.dao;

import com.jshop.entity.SerialT;

public interface SerialTDao {
	/**
	 * 保存逻辑id数据
	 * @param transientInstance
	 */
	public abstract void save(SerialT transientInstance);
	/**
	 * 查找新的逻辑id
	 * @param baseid
	 * @return
	 */
	public abstract SerialT findBybaseid(String biz);
	/**
	 * 更新新的逻辑id
	 * @param baseid
	 * @return
	 */
	public abstract int updateBybaseid(SerialT transientInstance);
}
