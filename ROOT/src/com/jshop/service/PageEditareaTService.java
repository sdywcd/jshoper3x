package com.jshop.service;

import java.util.List;

import com.jshop.entity.PageEditareaT;

public interface PageEditareaTService {

	/**
	 * 增加页面编辑区域
	 * @param pea
	 * @return
	 */
	public abstract int addPageEditareaT(PageEditareaT pea);
	/**
	 * 更新页面编辑区域
	 * @param pea
	 * @return
	 */
	public abstract int updatePageEditareaT(PageEditareaT pea);
	/**
	 * 查询某页面下的所有可编辑区域值
	 * @param pageid
	 * @param typeid
	 * @return
	 */
	public abstract List<PageEditareaT> findPageEditareaTByPageidandTypeid(String pageid,String typeid);
	/**
	 * 查询所有有页面编辑的数据
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<PageEditareaT>findAllPageEditareaT(final int currentPage,final int lineSize,final String creatorid);
	/**
	 * 统计所有页面编辑区域数据
	 * @return
	 */
	public abstract int countfindAllPageEditareaT(String creatorid);
	/**
	 * 显示和隐藏编辑区域
	 * @param list
	 * @param state
	 * @return
	 */
	public abstract int updatePageEditareaTBystate(String []list,String state,String creatorid);

	/**
	 * 查询指定的编辑区域
	 * @param pageeditareaid
	 * @return
	 */
	public abstract PageEditareaT findPageEditareaById(String pageeditareaid);
	/**
	 * 查询某页面下的所有可编辑区域值
	 * @param pageid
	 * @param typeid
	 * @param state
	 * @return
	 */
	public abstract List<PageEditareaT> findPageEditareaTByPageidandTypeidandState(String pageid,String typeid,String state);
	/**
	 * 在导航情况下根据模板关系id读取自定义数据
	 * @param tid
	 * @param creatorid
	 * @return
	 */
	public abstract List<PageEditareaT>findPageEditareaTByTid(String tid,String creatorid);
	/**
	 * 获取自定义数据
	 * @param sign
	 * @param creatorid
	 * @return
	 */
	public abstract List<PageEditareaT>findPageEditareaTBySign(String sign,String state,String creatorid);
	/**
	 * 批量删除自定义页面区域
	 * @param strs
	 * @param state
	 */
	public abstract int delPageEditareaTBypageeditareaid(String []strs,String state);
	
	
	
}
