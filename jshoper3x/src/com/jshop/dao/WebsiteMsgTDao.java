package com.jshop.dao;

import java.util.List;

import com.jshop.entity.WebsiteMsgT;

public interface WebsiteMsgTDao extends BaseTDao<WebsiteMsgT>{



	/**
	 * 批量删除
	 * 
	 * @param list
	 * @return
	 */
	public int delWebsiteMsgT(String[] list);

	/**
	 * 根据发件人获取其所有消息数据
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param userid
	 * @return
	 */
	public List<WebsiteMsgT> findAllWebsiteMsgByFromUserid(int currentPage,
			int lineSize, String userid);

	/**
	 * 统计根据发件人获取器所有消息数据
	 * 
	 * @param userid
	 * @return
	 */
	public int countfindAllWebsiteMsgByFromUserid(String userid);

	/**
	 * 查询所有收件人是我的信息
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param username
	 * @return
	 */
	public List<WebsiteMsgT> findAllWebsiteMsgByToUsername(int currentPage,
			int lineSize, String msgtousername);

	/**
	 * 统计查询所有收件人是我的信息
	 * 
	 * @return
	 */
	public int countfindAllWebsiteMsgByToUsername(String msgtousername);

	/**
	 * 更新消息状态 ，已经读，和未读
	 * 
	 * @param list
	 * @param state
	 * @return
	 */
	public int updateWebsiteMsgstate(String[] list, String state);

	/**
	 * 根据消息状态统计所有收件人是我消息
	 * 
	 * @param msgtousername
	 * @param state
	 * @return
	 */
	public int countfindAllWebsitemsgOfStateByToUsername(String msgtousername,
			String state);

	/**
	 * 根据id获取站内信消息
	 * 
	 * @param id
	 * @return
	 */
	public WebsiteMsgT findMsgtextById(String id);

}
