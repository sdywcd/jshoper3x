package com.jshop.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.ArticleTDao;
import com.jshop.entity.ArticleT;
import com.jshop.service.ArticleTService;

@Service("articleTService")
@Scope("prototype")
public class ArticleTServiceImpl extends BaseTServiceImpl<ArticleT> implements ArticleTService {
	@Resource
	private ArticleTDao articleTDao;

	public ArticleTDao getArticleTDao() {
		return articleTDao;
	}

	public void setArticleTDao(ArticleTDao articleTDao) {
		this.articleTDao = articleTDao;
	}



	public int countfindAllArticle(String creatorid) {
		return this.getArticleTDao().countfindAllArticle(creatorid);
	}

	public List<ArticleT> findAllArticleT(int currentPage, int lineSize, String creatorid) {
		return this.getArticleTDao().findAllArticleT(currentPage, lineSize, creatorid);
	}

	public ArticleT findArticleByarticleid(String articleid) {
		return this.getArticleTDao().findArticleByarticleid(articleid);
	}

	public int updateArticleT(ArticleT at) {
		return this.getArticleTDao().updateArticleT(at);
	}

	public int updateHtmlPath(String articleid, String htmlPath) {
		return this.getArticleTDao().updateHtmlPath(articleid, htmlPath);
	}

	public List<ArticleT> findAllArticleBycreatorid(String creatorid) {
		return this.getArticleTDao().findAllArticleBycreatorid(creatorid);
	}

	public List<ArticleT> findAllArticleT(String status) {
		return this.getArticleTDao().findAllArticleT(status);
	}

	public List<ArticleT> sortAllArticleT(int currentPage, int lineSize, String creatorid, String queryString) {

		return this.getArticleTDao().sortAllArticleT(currentPage, lineSize, creatorid, queryString);
	}


	public void delArticleT(String[] strs) {
	    this.getArticleTDao().delArticleT(strs);
	}

	public int updateArticlepositionByarticleCategoryTid(String articleCategoryTid, String position) {
		return this.getArticleTDao().updateArticlepositionByarticleCategoryTid(articleCategoryTid, position);
	}

	@Override
	public int updateHtmlPath(String articleid, String htmlPath, Date updatetime) {
		return this.getArticleTDao().updateHtmlPath(articleid, htmlPath, updatetime);
	}

	@Override
	// @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public int delArticleT(String id) {
		return this.getArticleTDao().delArticleT(id);
	}

	@Override
	public List<ArticleT> findAllArticleT(int currentPage, int lineSize) {
		return this.getArticleTDao().findAllArticleT(currentPage, lineSize);
	}

	@Override
	public int countfindAllArticle() {
		return this.getArticleTDao().countfindAllArticle();
				
	}

	@Override
	public List<ArticleT> findArticlesByNavid(String navid, String status) {
		return this.getArticleTDao().findArticlesByNavid(navid, status);
	}

	@Override
	public List<ArticleT> findArticlesByLtypeid(String ltypeid, String status) {
		return this.getArticleTDao().findArticlesByLtypeid(ltypeid, status);
	}

	@Override
	public List<ArticleT> findArticlesByStypeid(String stypeid, String status) {
		return this.getArticleTDao().findArticlesByStypeid(stypeid, status);
	}

}
