package com.jshop.dao;

import java.util.List;

import com.jshop.entity.ImgT;

public interface ImgTDao extends BaseTDao<ImgT> {

	/**
	 * 删除图片数据
	 * 
	 * @param list
	 * @return
	 */
	public int delImgT(String[] list);

	/**
	 * 更新图片数据
	 * 
	 * @param i
	 * @return
	 */
	public int updateImgT(ImgT i);

	/**
	 * 查询所有图片数据
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<ImgT> findAllImgT(final int currentPage, final int lineSize);

	/**
	 * 统计查询所有图片数据
	 * 
	 * @return
	 */
	public int countfindAllImgT();

	/**
	 * 根据图片名称获取图片数据
	 * 
	 * @param imgName
	 * @return
	 */
	public ImgT findImgTByImgName(String imgName);

	/**
	 * 查找图片是否被引用
	 * 
	 * @return
	 */
	public List<ImgT> findImgTByusedGoodsidandusedPositionId(String imgId);

	/**
	 * 根据被商品引用id获取数据
	 * 
	 * @param usedGoodsid
	 * @return
	 */
	public List<ImgT> findImgTByusedGoodsid(String usedGoodsid);

	/**
	 * 获取被商品引用但是未被自定义引用的图片
	 * 
	 * @param usedGoodsid
	 * @return
	 */
	public List<ImgT> findImgTByusedGoodsidandPositionIdisNull(
			String usedGoodsid);

	/**
	 * 根据被商品引用id更新状态
	 * 
	 * @param usedGoodsid
	 * @param state
	 * @return
	 */
	public int updateImgState(String imgId, String state);

	/**
	 * 根据图片名称获取图片被引用数据
	 * 
	 * @param imgName
	 * @return
	 */
	public List<ImgT> findAllImgTByImgName(final int currentPage,
			final int lineSize, final String imgName);

	/**
	 * 统计根据图片名称获取图片被引用数据
	 * 
	 * @param imgName
	 * @return
	 */
	public int countfindAllImgTByImgName(String imgName);

	/**
	 * 根据排序方式排序所有
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param queryString
	 * @return
	 */
	public List<ImgT> sortAllImgT(final int currentPage, final int lineSize,
			String queryString);

}
