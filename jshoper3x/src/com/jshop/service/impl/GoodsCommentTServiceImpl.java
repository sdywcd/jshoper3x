package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GoodsCommentTDao;
import com.jshop.dao.impl.GoodsCommentTDaoImpl;
import com.jshop.entity.GoodsCommentT;
import com.jshop.service.GoodsCommentTService;

@Service("goodsCommentTService")
@Scope("prototype")
public class GoodsCommentTServiceImpl extends BaseTServiceImpl<GoodsCommentT>implements GoodsCommentTService {
	@Resource
	private GoodsCommentTDao goodsCommentTDao;

	public GoodsCommentTDao getGoodsCommentTDao() {
		return goodsCommentTDao;
	}

	public void setGoodsCommentTDao(GoodsCommentTDao goodsCommentTDao) {
		this.goodsCommentTDao = goodsCommentTDao;
	}

	public int delGoodsComment(String[] list) {
		return this.getGoodsCommentTDao().delGoodsComment(list);
	}

	public int updateGoodsCommentorReplyByState(String state, String[] list) {
		return this.getGoodsCommentTDao().updateGoodsCommentorReplyByState(
				state, list);
	}


	public List<GoodsCommentT> findAllGoodsComment(int currentPage, int lineSize) {
		return this.getGoodsCommentTDao().findAllGoodsComment(currentPage,
				lineSize);
	}

	public int countfindGoodsCommentByGoodsid(String goodsid) {
		return this.getGoodsCommentTDao().countfindGoodsCommentByGoodsid(
				goodsid);
	}

	public List<GoodsCommentT> findGoodsCommentByGoodsid(String goodsid,
			int currentPage, int lineSize) {
		return this.getGoodsCommentTDao().findGoodsCommentByGoodsid(goodsid,
				currentPage, lineSize);
	}

	public int countfindAllGoodsComment() {
		return this.getGoodsCommentTDao().countfindAllGoodsComment();
	}

	public List<GoodsCommentT> sortAllGoodsComment(int currentPage,
			int lineSize, String queryString) {
		return this.getGoodsCommentTDao().sortAllGoodsComment(currentPage,
				lineSize, queryString);
	}

	@Override
	public GoodsCommentT findGoodsCommentById(String id) {
		return this.getGoodsCommentTDao().findGoodsCommentById(id);
	}

	@Override
	public void updateGoodsComment(GoodsCommentT gct) {
		this.getGoodsCommentTDao().updateGoodsComment(gct);
	}
}
