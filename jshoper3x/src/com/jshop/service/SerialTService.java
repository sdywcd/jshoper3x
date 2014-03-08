package com.jshop.service;

import com.jshop.entity.SerialT;

public interface SerialTService extends BaseTService<SerialT> {


	/**
	 * 查找新的逻辑id
	 * 
	 * @param baseid
	 * @return
	 */
	public SerialT findBybaseid(String biz);

	/**
	 * 更新新的逻辑id
	 * 
	 * @param baseid
	 * @return
	 */
	public int updateBybaseid(SerialT transientInstance);

	/**
	 * 获取最新的主键id
	 * 
	 * @return
	 */
	public SerialT SerialTlastId(String serialkey);

}
