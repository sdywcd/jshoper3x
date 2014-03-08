package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.ArticleCategoryTDao;
import com.jshop.dao.impl.ArticleCategoryTDaoImpl;
import com.jshop.entity.ArticleCategoryT;
import com.jshop.service.ArticleCategoryTService;

@Service("articleCategoryTService")
@Scope("prototype")
public class ArticleCategoryTServiceImpl extends BaseTServiceImpl<ArticleCategoryT>implements ArticleCategoryTService {
	@Resource
	private ArticleCategoryTDao articleCategoryTDao;

	public ArticleCategoryTDao getArticleCategoryTDao() {
		return articleCategoryTDao;
	}

	public void setArticleCategoryTDao(ArticleCategoryTDao articleCategoryTDao) {
		this.articleCategoryTDao = articleCategoryTDao;
	}

	public int checkArticleCategoryName(String name, String creatorid) {
		return getArticleCategoryTDao().checkArticleCategoryName(name, creatorid);
	}

	public int checkArticleCategoryNamewithoutMe(String articleCategoryTid, String name, String creatorid) {
		return getArticleCategoryTDao().checkArticleCategoryNamewithoutMe(articleCategoryTid, name, creatorid);
	}

	public int checkArticleCategorySign(String sign, String creatorid) {
		return getArticleCategoryTDao().checkArticleCategorySign(sign, creatorid);
	}


	public int countfindAllArticleCategoryT(String status, String creatorid) {
		return getArticleCategoryTDao().countfindAllArticleCategoryT(status, creatorid);
	}

	public int countfindAllArticleCategoryTByGrade(String grade, String status, String creatorid) {
		return getArticleCategoryTDao().countfindAllArticleCategoryTByGrade(grade, status, creatorid);
	}



	public void delArticleCategoryT(ArticleCategoryT act) {
		this.getArticleCategoryTDao().delArticleCategoryT(act);

	}

	public List<ArticleCategoryT> findAllArticleCategoryT(int currentPage, int lineSize, String status, String creatorid) {
		return getArticleCategoryTDao().findAllArticleCategoryT(currentPage, lineSize, status, creatorid);
	}

	public List<ArticleCategoryT> findAllArticleCategoryTByGrade(int currentPage, int lineSize, String status, String grade, String creatorid) {
		return getArticleCategoryTDao().findAllArticleCategoryTByGrade(currentPage, lineSize, status, grade, creatorid);
	}

	public List<ArticleCategoryT> findArticleCategoryByGrade(String grade, String status, String creatorid) {
		return getArticleCategoryTDao().findArticleCategoryByGrade(grade, status, creatorid);
	}

	public ArticleCategoryT findArticleCategoryByarticleCategoryTid(String articleCategoryTid) {
		return getArticleCategoryTDao().findArticleCategoryByarticleCategoryTid(articleCategoryTid);
	}

	public List<ArticleCategoryT> findArticleCategoryByparentId(String status, String parentId, String creatorid) {
		return getArticleCategoryTDao().findArticleCategoryByparentId(status, parentId, creatorid);
	}

	public List<ArticleCategoryT> findArticleCategoryByparentIdnull(String status, String creatorid) {
		return getArticleCategoryTDao().findArticleCategoryByparentIdnull(status, creatorid);
	}

	public ArticleCategoryT findPathParentIdByParentId(String parentId, String creatorid) {
		return getArticleCategoryTDao().findPathParentIdByParentId(parentId, creatorid);
	}


	public List<ArticleCategoryT> findAllArticleCategoryBycreatorid(String creatorid) {
		return this.getArticleCategoryTDao().findAllArticleCategoryBycreatorid(creatorid);
	}

	public List<ArticleCategoryT> findArticleCategoryByposition(int lineSize, String status, String position, String creatorid) {
		return getArticleCategoryTDao().findArticleCategoryByposition(lineSize, status, position, creatorid);
	}

	public List<ArticleCategoryT> findArticleCategoryByposition(int lineSize, String status, String position) {
		return getArticleCategoryTDao().findArticleCategoryByposition(lineSize, status, position);
	}

	public List<ArticleCategoryT> sortAllArticleCategoryT(int currentPage, int lineSize, String status, String creatorid, String queryString) {

		return this.getArticleCategoryTDao().sortAllArticleCategoryT(currentPage, lineSize, status, creatorid, queryString);
	}

	public List<ArticleCategoryT> findArticleCategoryByGrade(String grade, String status) {
		return this.getArticleCategoryTDao().findArticleCategoryByGrade(grade, status);
	}

	@Override
	public int checkArticleCategoryName(String name) {
		return this.getArticleCategoryTDao().checkArticleCategoryName(name);
	}

	@Override
	public int checkArticleCategorySign(String sign) {
		return this.getArticleCategoryTDao().checkArticleCategorySign(sign);
	}

	@Override
	public int checkArticleCategoryNamewithoutMe(String articleCategoryTid,
			String name) {
		return this.getArticleCategoryTDao().checkArticleCategoryNamewithoutMe(articleCategoryTid, name);
	}

	@Override
	public int checkArticleCategorySignwithoutMe(String articleCategoryTid,
			String sign) {
		return this.getArticleCategoryTDao().checkArticleCategorySignwithoutMe(articleCategoryTid, sign);
	}

	@Override
	public int checkArticleCategorySignwithoutMe(String articleCategoryTid,
			String sign, String creatorid) {
		return this.getArticleCategoryTDao().checkArticleCategorySignwithoutMe(articleCategoryTid, sign, creatorid);
	}

	@Override
	public List<ArticleCategoryT> findArticleCategoryByparentId(String status,
			String parentId) {
		return this.getArticleCategoryTDao().findArticleCategoryByparentId(status, parentId);
	}

	@Override
	public void delArticleCategoryT(String[] strs) {
		this.getArticleCategoryTDao().delArticleCategoryT(strs);
	}



}
