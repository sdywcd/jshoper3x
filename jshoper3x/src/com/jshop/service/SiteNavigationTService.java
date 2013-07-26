package com.jshop.service;

import java.util.List;

import com.jshop.entity.SiteNavigationT;

public interface SiteNavigationTService {

	/**
	 * 增加导航
	 * @param sn
	 * @return
	 */
	public abstract int addSiteNavigationT(SiteNavigationT sn);
	/**
	 * 删除导航
	 * @param list
	 * @return
	 */
	public abstract int delSiteNavigationT(String[]list);
	/**
	 * 获取所有导航
	 * @param currentPage
	 * @param lineSize
	 * @param creatorid
	 * @return
	 */
	public abstract List<SiteNavigationT>findAllSiteNavigationT(final int currentPage,final int lineSize,String creatorid);
	/**
	 * 统计获取所有导航
	 * @param creatorid
	 * @return
	 */
	public abstract int countfindAllSiteNavigationT(String creatorid);
	/**
	 * 更新导航
	 * @param sn
	 * @return
	 */
	public abstract int updateSiteNavigationT(SiteNavigationT sn);
	
	/**
	 * 根据snid获取导航数据
	 * @param snid
	 * @return
	 */
	public abstract SiteNavigationT findSiteNavigationBysnid(String snid);
	/**
	 * 根据导航位置获取导航数据
	 * @param isVisible
	 * @param position
	 * @param creatorid
	 * @return
	 */
	public abstract List<SiteNavigationT>findSiteNavigationByposition(String isVisible,String position,String creatorid);
	/**
	 * 根据是否显示来获取导航数据
	 * @param isVisible
	 * @param creatorid
	 * @return
	 */
	public abstract List<SiteNavigationT>findSiteNavigationByisVisible(String isVisible,String creatorid);
	/**
	 * 根据是否显示来获取导航数据无用户id
	 * @param isVisible
	 * @param creatorid
	 * @return
	 */
	public abstract List<SiteNavigationT>findSiteNavigationByisVisible(String isVisible);
	/**
	 * 根据排序方式查询所有
	 * @param currentPage
	 * @param lineSize
	 * @param creatorid
	 * @param queryString
	 * @return
	 */
	public abstract List<SiteNavigationT>sortAllSiteNavigationT(final int currentPage,final int lineSize,String creatorid,String queryString);



	
}
