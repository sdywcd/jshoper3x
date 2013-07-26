package com.jshop.service;

import java.util.List;

import com.jshop.entity.GoodsCommentT;

public interface GoodsCommentTService {
	/**
	 * 增加商品评论和用户回复此评论
	 * @param gct
	 * @return
	 */
	public abstract int addGoodsComment(GoodsCommentT gct);
	/**
	 * 删除评论和用户回复的评论
	 * @param list
	 * @return
	 */
	public abstract int delGoodsComment(String[]list);
	/**
	 * 更新用户评论和回复的评论状态
	 * @param list
	 * @param state
	 * @return
	 */
	public abstract int updateGoodsCommentorReplyByState(String state,String[] list);
	/**
	 * 获取对应商品的评论
	 * @param goodsid
	 * @return
	 */
	public abstract List<GoodsCommentT>findGoodsCommentByGoodsid(final String goodsid,final int currentPage,final int lineSize);

	/**
	 * 统计获取对应商品的评论
	 * @param goodsid
	 * @return
	 */
	public abstract int countfindGoodsCommentByGoodsid(String goodsid);
	/**
	 * 获取商品评论
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<GoodsCommentT>findAllGoodsComment(final int currentPage,final int lineSize);
	/**
	 * 统计获取商品评论
	 * @return
	 */
	public abstract int countfindAllGoodsComment();

	/**
	 * 根据排序方式进行排序
	 * @param currentPage
	 * @param lineSize
	 * @param queryString
	 * @return
	 */
	public abstract List<GoodsCommentT>sortAllGoodsComment(final int currentPage,final int lineSize, String queryString);








}
