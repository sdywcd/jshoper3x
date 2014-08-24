package com.jshop.dao;

import java.util.Date;
import java.util.List;

import com.jshop.entity.ArticleT;

public interface ArticleTDao extends BaseTDao<ArticleT>{

	

	/**
	 * 批量删除文章
	 * 
	 * @param list
	 * @return
	 */
	public void delArticleT(String[] strs);

	/**
	 * 根据articleid获取文章
	 * 
	 * @param articleid
	 * @return
	 */
	public ArticleT findArticleByarticleid(String articleid);

	/**
	 * 获取所有文章
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param status
	 * @param creatorid
	 * @return
	 */
	public List<ArticleT> findAllArticleT(final int currentPage,
			final int lineSize, final String creatorid);
	/**
	 * 获取所有文章
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param status
	 * @param creatorid
	 * @return
	 */
	public List<ArticleT> findAllArticleT(final int currentPage,
			final int lineSize);
	/**
	 * 统计获取所有文章
	 * 
	 * @param creatorid
	 * @return
	 */
	public int countfindAllArticle(String creatorid);
	/**
	 * 统计获取所有文章
	 * 
	 * @return
	 */
	public int countfindAllArticle();

	/**
	 * 更新文章
	 * 
	 * @param at
	 * @return
	 */
	public int updateArticleT(ArticleT at);

	/**
	 * 更新文章静态页
	 * 
	 * @param articleid
	 * @param htmlPath
	 */
	public int updateHtmlPath(String articleid, String htmlPath);

	/**
	 * 更新文章静态页避免重复生成
	 * 
	 * @param articleid
	 * @param htmlPath
	 * @param updatetime
	 * @return
	 */
	public int updateHtmlPath(String articleid, String htmlPath, Date updatetime);

	/**
	 * 根据用户id获取文章列表
	 * 
	 * @param creatorid
	 * @return
	 */
	public List<ArticleT> findAllArticleBycreatorid(String creatorid);

	/**
	 * 根据status读取所有文章数据
	 * 
	 * @param status
	 * @return
	 */
	public List<ArticleT> findAllArticleT(String status);

	/**
	 * 根据排序方式进行排序
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param creatorid
	 * @param queryString
	 * @return
	 */
	public List<ArticleT> sortAllArticleT(final int currentPage,
			final int lineSize, final String creatorid, final String queryString);

	/**
	 * 根据文章分类跟新文章显示位置
	 * 
	 * @param articleCategoryTid
	 * @param position
	 * @return
	 */
	public int updateArticlepositionByarticleCategoryTid(
			String articleCategoryTid, String position);

	/**
	 * 删除文章
	 * 
	 * @param id
	 * @return
	 */
	public int delArticleT(String id);
	/**
	 * 获取一级分类文章列表
	 * @param navid
	 * @param status
	 * @return
	 */
	public List<ArticleT>findArticlesByNavid(String navid,String status);
	
	/**
	 * 获取二级分类文章列表
	 * @param ltypeid
	 * @param status
	 * @return
	 */
	public List<ArticleT>findArticlesByLtypeid(String ltypeid,String status);
	/**
	 * 获取三级分类文章列表
	 * @param stypeid
	 * @param status
	 * @return
	 */
	public List<ArticleT>findArticlesByStypeid(String stypeid,String status);
	
	
}
