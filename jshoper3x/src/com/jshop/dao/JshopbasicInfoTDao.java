package com.jshop.dao;

import java.util.List;

import com.jshop.entity.JshopbasicInfoT;

public interface JshopbasicInfoTDao extends BaseTDao<JshopbasicInfoT> {

	/**
	 * 删除商城基本信息
	 * 
	 * @param list
	 * @return
	 */
	public int delJshopbasicInfo(String[] list, String creatorid);

	/**
	 * 更新商城基本信息
	 * 
	 * @param jbit
	 * @return
	 */
	public void updateJshopbasicInfo(JshopbasicInfoT jbit);

	/**
	 * 查询所有商城基本信息
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<JshopbasicInfoT> findAllJshopbasicInfo(final int currentPage,
			final int lineSize, final String creatorid);

	/**
	 * 统计所有商城基本信息
	 * 
	 * @return
	 */
	public int countfindAllJshopbasicInfo(String creatorid);

	/**
	 * 根据id获取商城基本信息
	 * 
	 * @param basicinfoid
	 * @return
	 */
	public JshopbasicInfoT findJshopbasicInfoTById(String basicinfoid);

	/**
	 * 更新商城信息使用状态
	 * 
	 * @param basicinfoid
	 * @param state
	 * @return
	 */
	public int updateJshopbasicInfostate(String basicinfoid, String state);

	/**
	 * 获取商城信息中快递单所需要填写的信息只获取一个
	 * 
	 * @return
	 */
	public JshopbasicInfoT findJshopbasicInfoSingleForExpress(
			final String creatorid);

	/**
	 * 根据creatorid获取商城基本信息
	 * 
	 * @param creatorid
	 * @return
	 */
	public List<JshopbasicInfoT> findJshopbasicInfoBycreatorid(String creatorid);

	/**
	 * 获取所有商城数据，给手机客户端
	 * 
	 * @return
	 */
	public List<JshopbasicInfoT> findAllJshopbasicInfoNoParam(
			final int currentPage, final int lineSize, final String state);

	/**
	 * 获取开启状态和运行状态的商城
	 * 
	 * @param creatorid
	 * @param state
	 * @param openstate
	 * @return
	 */
	public JshopbasicInfoT findJshopbasicInfoBystateandopstate(
			String creatorid, String state, String openstate);

	/**
	 * 获取开启状态和运行状态的商城无用户id
	 * 
	 * @param creatorid
	 * @param state
	 * @param openstate
	 * @return
	 */
	public JshopbasicInfoT findJshopbasicInfoBystateandopstate(String state,
			String openstate);

	/**
	 * 根据创建者id获取商店信息
	 * 
	 * @param creatorid
	 * @return
	 */
	public JshopbasicInfoT findAllJshopbasicInfo(String creatorid);
}
