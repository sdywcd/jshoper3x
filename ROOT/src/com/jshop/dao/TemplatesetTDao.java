package com.jshop.dao;

import java.util.List;

import com.jshop.entity.TemplatesetT;

public interface TemplatesetTDao {

	/**
	 * 增加模板文件设定
	 * @param tst
	 * @return
	 */
	public abstract int addTemplatesetT(TemplatesetT tst);
	/**
	 * 批量删除模板文件设定
	 * @param list
	 * @return
	 */
	public abstract int delTemplatesetT(String []list);
	/**
	 * 获取所有模板文件设定
	 * @param currentPage
	 * @param lineSize
	 * @param creatorid
	 * @return
	 */
	public abstract List<TemplatesetT>findAllTemplatesetT(final int currentPage,final int lineSize,final String creatorid);
	/**
	 * 统计所有模板文件设定
	 * @param creatorid
	 * @return
	 */
	public abstract int countfindAllTemplatesetT(String creatorid);
	/**
	 * 根据tsid获取信息
	 * @param tsid
	 * @return
	 */
	public abstract TemplatesetT findTemplatesetTBytsid(String tsid);
	/**
	 * 更新模板文件和系统内容
	 * @param tst
	 * @return
	 */
	public abstract int updateTemplatesetT(TemplatesetT tst);
	/**
	 * 获取所有模板文件和系统内容关系设定
	 * @param creatorid
	 * @return
	 */
	public abstract List<TemplatesetT>findAllTemplatesetWithNoParam(String creatorid);
	/**
	 * 根据系统内容获取模板关系
	 * @param systemcontent
	 * @param creatorid
	 * @return
	 */
	public abstract TemplatesetT findTemplatesetTBysystemcontent(String systemcontent,String creatorid);
	/**
	 * 根据标示获取系统内容模板关系
	 * @param sign
	 * @param creatorid
	 * @return
	 */
	public abstract TemplatesetT findTemplatesetTBysign(String sign,String creatorid);
	/**
	 * 根据themeid更新系统内容状态
	 * @param themeid
	 * @param status
	 * @return
	 */
	public abstract int updateTemplatesetBystatus(String themeid,String status);
	
	/**
	 * 根据标示获取系统内容模板关系并结合主题
	 * @param sign
	 * @return
	 */
	public abstract TemplatesetT findTemplatesetTBysign(String sign);
	/**
	 * 根据状态获取模板和模板关系
	 * @param status
	 * @return
	 */
	public abstract List<TemplatesetT>findTemplatesetTBystatus(String status);
}
