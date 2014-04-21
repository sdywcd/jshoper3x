package com.jshop.action.backstage.interceptor;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.jshop.service.ArticleTService;

/**
 * 对文章模块的拦截器处理
 * @author Administrator
 *
 */
@ParentPackage("jshop")

public class ArticlemoduleInterecptor {
	private ArticleTService articleTService;
	
	public ArticleTService getArticleTService() {
		return articleTService;
	}

	public void setArticleTService(ArticleTService articleTService) {
		this.articleTService = articleTService;
	}

	/**
	 * 在更新文章分类的时候更新文章的显示位置
	 * @param articleCategory
	 * @param position
	 */
	public void updateArticleposition(String articleCategoryTid,String position){
		this.getArticleTService().updateArticlepositionByarticleCategoryTid(articleCategoryTid, position);
	}
}
