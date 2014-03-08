package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GoodsCategoryTDao;
import com.jshop.entity.GoodsCategoryT;
import com.jshop.service.GoodsCategoryTService;

@Service("goodsCategoryTService")
@Scope("prototype")
public class GoodsCategoryTServiceImpl extends BaseTServiceImpl<GoodsCategoryT> implements GoodsCategoryTService {
	@Resource
	private GoodsCategoryTDao goodsCategoryTDao;

	public GoodsCategoryTDao getGoodsCategoryTDao() {
		return goodsCategoryTDao;
	}

	public void setGoodsCategoryTDao(GoodsCategoryTDao goodsCategoryTDao) {
		this.goodsCategoryTDao = goodsCategoryTDao;
	}

	public GoodsCategoryT findPathParentIdByParentId(String parentId) {
		return this.getGoodsCategoryTDao().findPathParentIdByParentId(parentId);
	}

	public List<GoodsCategoryT> findGoodsCategoryByGrade(String grade, String state) {
		return this.getGoodsCategoryTDao().findGoodsCategoryByGrade(grade, state);
	}

	public int checkGoodscategoryName(String name) {
		return this.getGoodsCategoryTDao().checkGoodscategoryName(name);
	}

	public int checkGoodscategorySign(String sign) {
		return this.getGoodsCategoryTDao().checkGoodscategorySign(sign);
	}

	public int countfindAllGoodsCategoryT(String state) {
		return this.getGoodsCategoryTDao().countfindAllGoodsCategoryT(state);
	}

	public int countfindAllGoodsCategoryTByGrade(String grade, String state) {
		return this.getGoodsCategoryTDao().countfindAllGoodsCategoryTByGrade(grade, state);
	}

	public int delGoodscategoryT(String goodsCategoryTid, String state) {
		return this.getGoodsCategoryTDao().delGoodscategoryT(goodsCategoryTid, state);
	}

	public List<GoodsCategoryT> findAllGoodsCategoryT(int currentPage, int lineSize, String state) {
		return this.getGoodsCategoryTDao().findAllGoodsCategoryT(currentPage, lineSize, state);
	}

	public List<GoodsCategoryT> findAllGoodsCategoryTByGrade(int currentPage, int lineSize, String grade, String state) {
		return this.getGoodsCategoryTDao().findAllGoodsCategoryTByGrade(currentPage, lineSize, grade, state);
	}

	public int updateGoodscategoryT(GoodsCategoryT gct) {
		return this.getGoodsCategoryTDao().updateGoodscategoryT(gct);
	}

	public GoodsCategoryT findGoodscategoryBygoodscategoryId(String goodsCategoryTid) {
		return this.getGoodsCategoryTDao().findGoodscategoryBygoodscategoryId(goodsCategoryTid);
	}

	public int checkGoodscategoryNamewithoutMe(String goodsCategoryTid, String name) {
		return this.getGoodsCategoryTDao().checkGoodscategoryNamewithoutMe(goodsCategoryTid, name);
	}

	public int checkGoodscategorySignwithoutMe(String goodsCategoryTid, String sign) {
		return this.getGoodsCategoryTDao().checkGoodscategorySignwithoutMe(goodsCategoryTid, sign);
	}

	public List<GoodsCategoryT> findGoodscategoryByparentId(String state, String parentId) {
		return this.getGoodsCategoryTDao().findGoodscategoryByparentId(state, parentId);
	}

	public List<GoodsCategoryT> findGoodscategoryByparentIdnull(String state) {
		return this.getGoodsCategoryTDao().findGoodscategoryByparentIdnull(state);
	}

	public List<GoodsCategoryT> findAllGoodsCategoryBycreatorid(String creatorid) {
		return this.getGoodsCategoryTDao().findAllGoodsCategoryBycreatorid(creatorid);
	}

	public int updateHtmlPath(String goodsCategoryTid, String htmlpath) {
		return this.getGoodsCategoryTDao().updateHtmlPath(goodsCategoryTid, htmlpath);
	}

	public List<GoodsCategoryT> findAllGoodsCategoryT(String state) {
		return this.getGoodsCategoryTDao().findAllGoodsCategoryT(state);
	}

	public List<GoodsCategoryT> sortAllGoodsCategoryT(int currentPage, int lineSize, String state, String queryString) {

		return this.getGoodsCategoryTDao().sortAllGoodsCategoryT(currentPage, lineSize, state, queryString);
	}

	@Override
	public List<GoodsCategoryT> findAllCategoryByNoTrem() {

		return this.getGoodsCategoryTDao().findAllCategoryByNoTrem();
	}

	@Override
	public int delGoodscategoryT(String[] strs) {
		return this.getGoodsCategoryTDao().delGoodscategoryT(strs);
	}

}
