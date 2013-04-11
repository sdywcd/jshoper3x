package com.jshop.dao;

import java.util.List;

import com.jshop.entity.GoodsCategoryT;

public interface GoodsCategoryTDao {

	/**
	 * 增加商品分类
	 * @param gct
	 * @return
	 */
	public abstract int addGoodsCategory(GoodsCategoryT gct);
	
	/**
	 * 获取父路径数据
	 * @param parentId
	 * @return
	 */
	public abstract GoodsCategoryT findPathParentIdByParentId(String parentId);
	/**
	 * 根据分类级数获取商品分类
	 * @param state
	 * @param grade
	 * @return
	 */
	public abstract List<GoodsCategoryT>findGoodsCategoryByGrade(String grade,String state);
	/**
	 * 检测商品分类名称
	 * @param name
	 * @return
	 */
	public abstract int  checkGoodscategoryName(String name);
	/**
	 * 检测商品分类标记
	 * @param sign
	 * @return
	 */
	public abstract int checkGoodscategorySign(String sign);
	/**
	 * 删除商品分类state=0
	 * @param goodscategoryid
	 */
	public abstract int delGoodscategoryT(String goodsCategoryTid,String state);
	/**
	 * 更新商品分类
	 * @param gct
	 */
	public abstract int updateGoodscategoryT(GoodsCategoryT gct);
	/**
	 * 获取所有激活的商品分类state=1
	 * @param currentPage
	 * @param lineSize
	 * @param state
	 * @return
	 */
	public abstract List<GoodsCategoryT>findAllGoodsCategoryT(final int currentPage,final int lineSize,final String state);
	/**
	 * 统计所有激活的商品分类
	 * @param state
	 * @return
	 */
    public abstract int countfindAllGoodsCategoryT(String state);
	/**
	 * 根据分类级数获取商品分类
	 * @param currentPage
	 * @param lineSize
	 * @param grade
	 * @param state
	 * @return
	 */
    public abstract List<GoodsCategoryT>findAllGoodsCategoryTByGrade(final int currentPage,final int lineSize,final String grade,final String state);
    /**
     * 统计根据分类级数获取商品分类
     * @param grade
     * @param state
     * @return
     */
	public abstract int countfindAllGoodsCategoryTByGrade(String grade,String state);

	/**
	 * 根据分类id获取商品分类
	 * @param goodsCategoryTid
	 * @return
	 */
	public abstract GoodsCategoryT findGoodscategoryBygoodscategoryId(String goodsCategoryTid);

	/**
	 * 排除自己获取商品分类名称
	 * @param goodsCategoryTid
	 * @param name
	 * @return
	 */
	public abstract int checkGoodscategoryNamewithoutMe(String goodsCategoryTid,String name);
	/** 
	 * 排除自己检测商品分级
	 * @param goodsCategoryTid
	 * @param sign
	 * @return
	 */
	public abstract int checkGoodscategorySignwithoutMe(String goodsCategoryTid,String sign);

	/**
	 * 根据parentid获取商品分类
	 * @param state
	 * @param parentId
	 * @return
	 */
	public abstract List<GoodsCategoryT>findGoodscategoryByparentId(String state,String parentId);
	/**
	 * 获取parentid null的商品分类
	 * @param state
	 * @return
	 */
	public abstract List<GoodsCategoryT>findGoodscategoryByparentIdnull(String state);
	/**
	 * 根据用户id获取所有商品分类
	 * @param creatorid
	 * @return
	 */
	public abstract List<GoodsCategoryT>findAllGoodsCategoryBycreatorid(String creatorid);
	/**
	 * 更新商品分类静态页路劲
	 * @param goodscategoryId
	 * @param htmlPath
	 * @return
	 */
	public abstract int updateHtmlPath(String goodsCategoryTid,String htmlpath);
	/**
	 * 获取所有激活的商品分类state=1
	 * @param currentPage
	 * @param lineSize
	 * @param state
	 * @return
	 */
	public abstract List<GoodsCategoryT>findAllGoodsCategoryT(String state);
	/**
	 * 根据排序方式进行排序
	 * @param currentPage
	 * @param lineSize
	 * @param state
	 * @param queryString
	 * @return
	 */
	public abstract List<GoodsCategoryT>sortAllGoodsCategoryT(final int currentPage,final int lineSize,final String state,String queryString);
	/**
	 * 查询所有没有条件商品分类
	 * @return
	 */
	public abstract List<GoodsCategoryT> findAllCategoryByNoTrem();

	

}
