package com.jshop.service;

import java.util.List;

import com.jshop.entity.TemplateT;

public interface TemplateTService extends BaseTService<TemplateT> {

	/**
	 * 查询所有模板
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<TemplateT> findAllTemplate(final int currentPage,
			final int lineSize, final String creatorid);

	/**
	 * 统计查询所有模板
	 * 
	 * @return
	 */
	public int countfindAllTemplate(String creatorid);

	

	/**
	 * 删除模板
	 * 
	 * @param list
	 * @return
	 */
	public int delTemplate(String[] list);

	/**
	 * 获取所有模板数据
	 * 
	 * @param status
	 * @return
	 */
	public List<TemplateT> findAllTemplateWithNoParam(String creatorid,
			String status);

	/**
	 * 检测模板文件唯一性
	 * 
	 * @param creatorid
	 * @param note
	 * @param name
	 * @return
	 */
	public int findTemplateBynameandnote(String creatorid, String note,
			String name);

	/**
	 * 根据name和creatorid获取模板文件
	 * 
	 * @param creatorid
	 * @param name
	 * @return
	 */
	public TemplateT findTemplateByname(String creatorid, String name);

	/**
	 * 根据模板类型获取模板文件
	 * 
	 * @param type
	 * @return
	 */
	public TemplateT findTemplateBytype(String type);

	/**
	 * 检测模板主题下是否有模板文件
	 * 
	 * @param themeid
	 * @return
	 */
	public TemplateT checkTemplatetheme(String themeid);

	/**
	 * 根据模板主题id更新模板文件状态
	 * 
	 * @param themeid
	 * @param status
	 */
	public int updateTemplatetBystatus(String themeid, String status);

	/**
	 * 根据sign和status获取模板文件
	 * 
	 * @param sign
	 * @param status
	 * @return
	 */
	public TemplateT findTemplateBysign(String sign, String status);

	/**
	 * 模糊查询根据名称
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param name
	 * @return
	 */
	public List<TemplateT> findTemplateTByLikeName(final int currentPage,
			final int lineSize, final String name);

	/**
	 * 统计所有根据迷糊查询的数据
	 * 
	 * @param name
	 * @return
	 */
	public int countTemplateTBYLikeNmae(String name);

}
