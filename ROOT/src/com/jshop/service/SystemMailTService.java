package com.jshop.service;

import java.util.List;

import com.jshop.entity.SystemMailT;

public interface SystemMailTService {
	/**
	 * 增加系统邮件
	 * 
	 * @param sm
	 * @return
	 */
	public int addSystemMail(SystemMailT sm);

	/**
	 * 更新系统邮件
	 * 
	 * @param sm
	 * @return
	 */
	public void updateSystemMail(SystemMailT sm);

	/**
	 * 查找所有系统邮件
	 * 
	 * @return
	 */
	public List<SystemMailT> findAllSystemMail();
	/**
	 * 统计查询所有系统邮箱
	 * @return
	 */
	public int countfindAllSystemMail();

	/**
	 * id获取邮箱信息
	 * 
	 * @param smialid
	 * @return
	 */
	public SystemMailT findSysmailBysmailid(String id);

}
