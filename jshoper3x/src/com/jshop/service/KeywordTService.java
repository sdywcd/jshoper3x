package com.jshop.service;

import java.util.List;

import com.jshop.entity.KeywordT;

public interface KeywordTService {
	/**
	 * 增加关键字
	 * @param kt
	 * @return
	 */
	public abstract int addKeywordT(KeywordT kt);
	/**
	 * 删除关键字（更新显示到隐藏）
	 * @param list
	 * @return
	 */
	public abstract int delKeywordT(String[]list);
	/**
	 * 更新关键字（排序和前台显示有关系数字越大越靠前）
	 * @param kt
	 * @return
	 */
	public abstract int updateKeywordT(KeywordT kt);
	/**
	 * 查询所有关键字
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<KeywordT>findAllKeywordT(final int currentPage,final int lineSize);
	/**
	 * 统计所有关键字
	 * @return
	 */
	public abstract int countAllKeywordT();
	/**
	 * 根据id获取关键字
	 * @param keywordid
	 * @return
	 */
	public abstract KeywordT findKeywordById(String keywordid);
	/**
	 * 根据关键字名称更新关键字使用次数
	 * @param keywordname
	 * @return
	 */
	public abstract int updatekeywordsearchcount(String keywordname);

	/**
	 * 查询所有关键字json方式
	 * @return
	 */
	public abstract List<KeywordT> findAllKeywordTjson();

	/**
	 * 获取指定个数的关键字，前台index使用
	 * @param limit
	 * @return
	 */
	public abstract List<KeywordT>findKeywordLimit(int limit);
	
	
	
	

}
