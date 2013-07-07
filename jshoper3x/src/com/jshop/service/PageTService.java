package com.jshop.service;

import java.util.List;

import com.jshop.entity.PageT;

public interface PageTService {
	/**
	 * 增加页面
	 * @param pt
	 * @return
	 */
	public abstract int addPaget(PageT pt);
	/**
	 * 删除页面
	 * @param list
	 * @return
	 */
	public abstract int delPaget(String [] list);
	/**
	 * 更新页面
	 * @param pt
	 * @return
	 */
	public abstract int updatePaget(PageT pt);
	/**
	 * 查询所有页面
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<PageT>findAllPaget(final int currentPage,final int lineSize);
	/**
	 * 统计所有页面
	 * @return
	 */
	public abstract int countfindAllPaget();
	/**
	 * 根据id获取页面
	 * @param pageid
	 * @return
	 */
	public abstract PageT findPagetById(String pageid);
	/**
	 * 查询所有页面信息用于页面编辑区域
	 * @return
	 */
	public abstract List<PageT>findAllPagetforPageEdit();
	
	
	
	
}
