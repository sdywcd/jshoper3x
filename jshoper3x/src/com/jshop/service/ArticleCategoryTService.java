package com.jshop.service;

import java.util.List;

import com.jshop.entity.ArticleCategoryT;

public interface ArticleCategoryTService extends BaseTService<ArticleCategoryT>{


	/**
	 * 获取父路径数据
	 * 
	 * 
	 * @param parentId
	 * @return
	 */
	public ArticleCategoryT findPathParentIdByParentId(String parentId, String creatorid);

	/**
	 * 根据分类级数获取文章分类
	 * 
	 * @param grade
	 * @param state
	 * @return
	 */
	public List<ArticleCategoryT> findArticleCategoryByGrade(String grade, String status, String creatorid);

	/**
	 * 检测文章分类名称
	 * 
	 * @param name
	 * @param creatorid
	 * @return
	 */
	public int checkArticleCategoryName(String name, String creatorid);
	/**
	 * 检测文章分类名称
	 * 
	 * @param name
	 * @return
	 */
	public int checkArticleCategoryName(String name);
	/**
	 * 检测文章分类标记
	 * 
	 * @param sign
	 * @param creatorid
	 * @return
	 */
	public int checkArticleCategorySign(String sign, String creatorid);
	/**
	 * 检测文章分类标记
	 * 
	 * @param sign
	 * @param creatorid
	 * @return
	 */
	public int checkArticleCategorySign(String sign);
	/**
	 * 删除文章分类status=0
	 * 
	 * @param articlecategoryTid
	 * @param status
	 * @param creatorid
	 * @return
	 */
	public void delArticleCategoryT(ArticleCategoryT act);
	/**
	 * 删除文章分类
	 * @param strs
	 * @return
	 */
	public void delArticleCategoryT(String strs[]);
	/**
	 * 获取所有激活的文章分类status=1
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param status
	 * @param creatorid
	 * @return
	 */
	public List<ArticleCategoryT> findAllArticleCategoryT(final int currentPage, final int lineSize, final String status, final String creatorid);

	/**
	 * 统计所有激活的文章分类
	 * 
	 * @param status
	 * @param creatorid
	 * @return
	 */
	public int countfindAllArticleCategoryT(String status, String creatorid);

	/**
	 * 根据分类级数获取文章分类
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param status
	 * @param grade
	 * @param creatorid
	 * @return
	 */
	public List<ArticleCategoryT> findAllArticleCategoryTByGrade(final int currentPage, final int lineSize, final String status, final String grade, final String creatorid);

	/**
	 * 统计根据分类级数获取文章分类
	 * 
	 * @param grade
	 * @param status
	 * @param creatorid
	 * @return
	 */
	public int countfindAllArticleCategoryTByGrade(String grade, String status, String creatorid);

	/**
	 * 根据分类id获取文章分类
	 * 
	 * @param articleCategoryTid
	 * @return
	 */
	public ArticleCategoryT findArticleCategoryByarticleCategoryTid(String articleCategoryTid);

	/**
	 * 排除自己获取文章分类名称
	 * 
	 * @param articleCategoryTid
	 * @param name
	 * @param creatorid
	 * @return
	 */
	public int checkArticleCategoryNamewithoutMe(String articleCategoryTid, String name, String creatorid);
	/**
	 * 排除自己获取文章分类名称
	 * 
	 * @param articleCategoryTid
	 * @param name
	 * @param creatorid
	 * @return
	 */
	public int checkArticleCategoryNamewithoutMe(String articleCategoryTid, String name);

	/**
	 * 排除自己检测文章标记
	 * 
	 * @param articleCategoryTid
	 * @param sign
	 * @param creatorid
	 * @return
	 */
	public int checkArticleCategorySignwithoutMe(String articleCategoryTid, String sign, String creatorid);
	/**
	 * 排除自己检测文章标记
	 * 
	 * @param articleCategoryTid
	 * @param sign
	 * @param creatorid
	 * @return
	 */
	public int checkArticleCategorySignwithoutMe(String articleCategoryTid, String sign);
	/**
	 * 根据parentId获取文章分类
	 * 
	 * @param status
	 * @param parentId
	 * @param creatroid
	 * @return
	 */
	public List<ArticleCategoryT> findArticleCategoryByparentId(String status, String parentId, String creatorid);

	/**
	 * 根据parentId 是 null获取文章分类
	 * 
	 * @param status
	 * @param creatorid
	 * @return
	 */
	public List<ArticleCategoryT> findArticleCategoryByparentIdnull(String status, String creatorid);

	/**
	 * 根据用户id获取所有文章分类
	 * 
	 * @param creatorid
	 * @return
	 */
	public List<ArticleCategoryT> findAllArticleCategoryBycreatorid(String creatorid);

	/**
	 * 根据position获取文章分类
	 * 
	 * @param position
	 * @param creatorid
	 * @return
	 */
	public List<ArticleCategoryT> findArticleCategoryByposition(final int lineSize, String status, String position, String creatorid);

	/**
	 * 根据position获取文章分类无用户id
	 * 
	 * @param position
	 * @param creatorid
	 * @return
	 */
	public List<ArticleCategoryT> findArticleCategoryByposition(final int lineSize, String status, String position);

	/**
	 * 根据排序方式进行排序
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param status
	 * @param creatorid
	 * @return
	 */
	public List<ArticleCategoryT> sortAllArticleCategoryT(final int currentPage, final int lineSize, final String status, final String creatorid, String queryString);

	/**
	 * 根据分类级数获取文章分类无用户id
	 * 
	 * @param grade
	 * @param state
	 * @return
	 */
	public List<ArticleCategoryT> findArticleCategoryByGrade(String grade, String status);
	/**
	 * 根据parentid获取文章分类
	 * @param status
	 * @param parentId
	 * @return
	 */
	public List<ArticleCategoryT>findArticleCategoryByparentId(String status,String parentId);
	
}
