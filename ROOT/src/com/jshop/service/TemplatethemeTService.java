package com.jshop.service;

import java.util.List;

import com.jshop.entity.TemplatethemeT;

public interface TemplatethemeTService {
	/**
	 * 增加模板主题
	 * @param tt
	 * @return
	 */
	public abstract int addTemplatetheme(TemplatethemeT tt);
	/**
	 * 查询所有模板主题
	 * @param currentPage
	 * @param lineSize
	 * @param creatorid
	 * @return
	 */
	public abstract List<TemplatethemeT> findAllTemplatetheme(final int currentPage,final int lineSize,final String creatorid);
	
	/**
	 * 统计查询所有模板主题
	 * @param creatorid
	 * @return
	 */
	public abstract int countfindAllTemplatetheme(String creatorid);
	
	/**
	 * 批量删除模板主题
	 * @param str
	 * @return
	 */
	public abstract int delTemplatetheme(String[] str);
	/**
	 * 检测模板主题是否存在
	 * @param themename
	 * @return
	 */
	public abstract int checkTemplatethemeBythemenameandsign(String themename,String sign);
	/**
	 * 根据排序字段按照排序方式排序
	 * @param currentPage
	 * @param lineSize
	 * @param creatorid
	 * @param queryString
	 * @return
	 */
	public abstract List<TemplatethemeT>sortAllTemplatetheme(final int currentPage,final int lineSize,final String creatorid, final String queryString);
	/**
	 * 根据主键获取模板主题
	 * @param ttid
	 * @return
	 */
	public abstract TemplatethemeT findTemplatethemeByttid(String ttid);
	/**
	 * 更新模板主题
	 * @param tt
	 */
	public abstract void updateTemplatetheme(TemplatethemeT tt);
	/**
	 * 获取所有模板主题
	 * @param creatorid
	 * @return
	 */
	public abstract List<TemplatethemeT>findAllTemplatethemeWithNoParam(String creatorid);
	
	/**
	 * 根据ttid更新模板主题状态
	 * @param ttid
	 * @param status
	 */
	public abstract int updateTemplatethemestatus(String ttid,String status);
	/**
	 * 在更新是检测是否有重复的模板主题
	 * @param themename
	 * @param sign
	 * @param ttid
	 * @return
	 */
	public abstract int checkTemplatethemeBythemenameandsign(String themename,String sign,String ttid);
	/**
	 * 删除模板主题
	 * @param str
	 * @return
	 */
	public abstract int delTemplatetheme(String ttid);
	/**
	 * 根据status读取模板主题，只读取一条
	 * @param status
	 * @return
	 */
	public abstract TemplatethemeT findTemplatethemeBystatus(String status);
	
	
}
