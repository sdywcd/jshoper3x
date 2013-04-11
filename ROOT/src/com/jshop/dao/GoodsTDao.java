package com.jshop.dao;

import java.util.Date;
import java.util.List;

import com.jshop.entity.GoodsT;

public interface GoodsTDao {

	/**
	 * 增加商品
	 * 
	 * @param g
	 * @return
	 */
	public abstract int addGoods(GoodsT g);

	/**
	 * 批量删除商品
	 * 
	 * @param list
	 * @return
	 */
	public abstract int delGoods(String[] list, String creatorid);

	/**
	 * 更新商品
	 * 
	 * @param g
	 * @return
	 */
	public abstract int updateGoods(GoodsT g);

	/**
	 * 查询所有商品信息
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param creatorid
	 * @return
	 */
	public abstract List<GoodsT> findAllGoods(final int currentPage, final int lineSize, final String creatorid);
	/**
	 * 查询所有没有条件商品
	 * @return
	 */
	public abstract List<GoodsT> findAllGoodsByNoTerm();

	/**
	 * 统计所有商品信息
	 * 
	 * @param creatorid
	 * @return
	 */
	public abstract int countAllGoods(String creatorid);

	/**
	 * 根据id获取商品信息
	 * 
	 * @param goodsid
	 * @return
	 */
	public abstract GoodsT findGoodsById(String goodsid);

	/**
	 * 根据导航id获取商品列表
	 * 
	 * @param navid
	 * @param state
	 * @return
	 */
	public abstract List<GoodsT> findGoodsByNavid(final String navid, final String salestate, final int currentPage, final int lineSize);

	/**
	 * 统计根据导航id获取商品列表
	 * 
	 * @param navid
	 * @param salestate
	 * @return
	 */
	public abstract int countfindGoodsByNavid(String navid, String salestate);

	/**
	 * 根据二级分类id获取商品列表
	 * 
	 * @param ltypeid
	 * @param state
	 * @return
	 */
	public abstract List<GoodsT> findGoodsByLtypeid(final String ltypeid, final String salestate, final int currentPage, final int lineSize);

	/**
	 * 统计根据二级分类id获取商品列表
	 * 
	 * @param ltypeid
	 * @param state
	 * @return
	 */
	public abstract int countfindGoodsByLtypeid(String ltypeid, String salestate);

	/**
	 * 根据三级分类id获取商品列表
	 * 
	 * @param stypeid
	 * @param state
	 * @return
	 */
	public abstract List<GoodsT> findGoodsByStypeid(String stypeid, String salestate);

	/**
	 * 批量更新商品上下架
	 * 
	 * @param salestate
	 * @param goodsid
	 * @param creatorid
	 * @return
	 */
	public abstract int updateGoodsSaleState(String[] goodsid, String salestate, String creatorid);
	/**
	 * 根据商品类型id下架商品
	 * @param goodsTypeId
	 * @param salestate
	 * @return
	 */
	public abstract int updateGoodsSaleState(String goodsTypeId,String salestate);
	/**
	 * 根据商品品牌获取商品信息
	 * 
	 * @param brand
	 * @return
	 */
	public abstract List<GoodsT> findGoodsBybrand(String brand);

	/**
	 * 根据商品名称获取商品信息
	 * 
	 * @param goodsname
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<GoodsT> findGoodsByGoodsname(final int currentPage, final int lineSize, final String goodsname);

	/**
	 * 根据商品型号获取商品信息
	 * 
	 * @param model
	 * @return
	 */
	public abstract List<GoodsT> findGoodsBymodel(String model);

	/**
	 * 根据商品价格查询商品信息
	 * 
	 * @param price
	 * @return
	 */
	public abstract List<GoodsT> findGoodsByprice(String price);

	/**
	 * 根据关键字查询商品信息
	 * 
	 * @param keywordid
	 * @param currentpage
	 * @param linesize
	 * @return
	 */
	public abstract List<GoodsT> findGoodsByKeyword(String keywordid, int currentPage, int lineSize);

	/**
	 * 统计根据关键字查询商品信息
	 * 
	 * @param keywordid
	 * @return
	 */
	public abstract int countfindGoodsByKeyword(String keywordid);

	/**
	 * 根据用户自定义商品编号查询商品信息
	 * 
	 * @param usersetnum
	 * @return
	 */
	public abstract List<GoodsT> findGoodsByusersetnum(String usersetnum);

	/**
	 * 根据商品id更新商品浏览次数
	 * 
	 * @param goodsid
	 * @return
	 */
	public abstract int updateGoodsreadcount(String goodsid);

	/**
	 * 根据商品id更新关联配件（未使用电子产品适用）
	 * 
	 * @param list
	 * @return
	 */
	public abstract int updateGoodsrelatedfit(String goodsid, String list);

	/**
	 * 根据商品id更新关联商品（现在已经使用到）
	 * 
	 * @param list
	 * @return
	 */
	public abstract int updateGoodsrelatedgoods(String goodsid, String list);

	/**
	 * 根据商品id更新5种商品状态
	 * 
	 * @param recommended
	 * @param hotsale
	 * @param bargainprice
	 * @param isNew
	 * @param ismobileplatformgoods
	 * @return
	 */
	public abstract int updateFiveGoodsState(String[] goodsid, String recommended, String hotsale, String bargainprice, String isNew, String ismobileplatformgoods);

	/**
	 * 根据商品id更新商品是否推荐
	 * 
	 * @param goodsid
	 * @param recommended
	 * @param creatorid
	 * @return
	 */
	public abstract int updateGoodsrecommended(String[] goodsid, String recommended, String creatorid);

	/**
	 * 根据商品id更新商品是否热销
	 * 
	 * @param goodsid
	 * @param hotsale
	 * @param creatorid
	 * @return
	 */
	public abstract int updateGoodshotsale(String[] goodsid, String hotsale, String creatorid);

	/**
	 * 根据商品id更新商品是否特价
	 * 
	 * @param goodsid
	 * @param bargainprice
	 * @param creatorid
	 * @return
	 */
	public abstract int updateGoodsbargainprice(String[] goodsid, String bargainprice, String creatorid);

	/**
	 * 根据商品id更新是否新品
	 * 
	 * @param goodsid
	 * @param isNew
	 * @param creatorid
	 * @return
	 */
	public abstract int updateGoodsisNew(String[] goodsid, String isNew, String creatorid);

	/**
	 * 根据商品id更新是否同步到移动平台
	 * 
	 * @param goodsid
	 * @param ismobileplatformgoods
	 * @param creatorid
	 * @return
	 */
	public abstract int updateGoodsismobileplatformgoods(String[] goodsid, String ismobileplatformgoods, String creatorid);

	/**
	 * 根据商品id更新商品排序
	 * 
	 * @param goodsid
	 * @param sort
	 * @return
	 */
	public abstract int updateSort(String goodsid, Integer sort);

	/**
	 * 根据商品id更新商品对应的种类
	 * 
	 * @param goodsid
	 * @param goodsortid
	 * @return
	 */
	public abstract int updateGoodssortid(String goodsid, String goodsortid);

	/**
	 * 根据商品id更新商品种类名称
	 * 
	 * @param goodsid
	 * @param goodssortname
	 * @return
	 */
	public abstract int updateGoodssortname(String goodsid, String goodssortname);

	/**
	 * 更新商品id更新商品回复数量
	 * 
	 * @param goodsid
	 * @return
	 */
	public abstract int updateGoodsreplycount(String goodsid);

	/**
	 * 根据导航，大类，小类，商品名称，查询商品数据用于optiontransforselect
	 * 
	 * @param navid
	 * @param ltypeid
	 * @param stypeid
	 * @param goodsname
	 * @return
	 */
	public abstract List<GoodsT> findGoodsForoptiontransferselect(final String navid, final String ltypeid, final String stypeid, final String goodsname);

	/**
	 * 查询所有商品没有分页
	 * 
	 * @return
	 */
	public abstract List<GoodsT> findAllGoodstWithoutSplitpage();

	/**
	 * 根据商品分类获取指定条数的商品记录
	 * 
	 * @param nlstypeid
	 * @param limit
	 * @return
	 */
	public abstract List<GoodsT> findGoodsLimitByGoodsType(String nlstypeid, int limit);

	/**
	 * 获取同价位商品集合
	 * 
	 * @param minprice
	 * @param maxprice
	 * @param goodsid
	 * @return
	 */
	public abstract List<GoodsT> findSamepriceGoods(int limit, double minprice, double maxprice, String goodsid);

	/**
	 * 获取更多商品
	 * 
	 * @param nlstypeid
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<GoodsT> findMoreGoodsByGoodsType(final String nlstypeid, final int currentPage, int lineSize);

	/**
	 * 统计获取更多商品
	 * 
	 * @param nlstypeid
	 * @return
	 */
	public abstract int countfindMoreGoodsByGoodsType(final String nlstypeid);

	/**
	 * 搜索商品
	 * 
	 * @param goodsname
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<GoodsT> findSearchGoods(final String goodsname, final int currentPage, int lineSize);

	/**
	 * 统计搜索商品
	 * 
	 * @param goodsname
	 * @return
	 */
	public abstract int countfindSearchGoods(String goodsname);

	/**
	 * 获取更多的上架商品（首页更多商品）
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param salestate
	 * @return
	 */
	public abstract List<GoodsT> findAllGoodslistMore(final int currentPage, final int lineSize, String salestate);

	/**
	 * 统计获取更多上架商品
	 * 
	 * @param salestate
	 * @return
	 */
	public abstract int countfindAllGoodslistMore(String salestate);

	/**
	 * 根据商品类型获取更多热卖商品
	 * 
	 * @param nlstypeid
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<GoodsT> findMoreHotSaleGoodsByGoodsType(final String nlstypeid, final int currentPage, int lineSize);

	/**
	 * 统计根据商品类型获取更多热卖商品
	 * 
	 * @param nlstypeid
	 * @return
	 */
	public abstract int countfindMoreHotSaleGoodsByGoodsType(final String nlstypeid);

	/**
	 * 根据商品类型获取更多特价商品
	 * 
	 * @param nlstypeid
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<GoodsT> findMoreBargainPriceGoodsByGoodsType(final String nlstypeid, final int currentPage, int lineSize);

	/**
	 * 统计根据商品类型获取更多特价商品
	 * 
	 * @param nlstypeid
	 * @return
	 */
	public abstract int countfindMoreBargainPriceGoodsByGoodsType(final String nlstypeid);

	/**
	 * 根据商品类型获取更多推荐商品
	 * 
	 * @param nlstypeid
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<GoodsT> findMoreRecommendedGoodsByGoodsType(final String nlstypeid, final int currentPage, int lineSize);

	/**
	 * 统计根据商品类型获取更多推荐商品
	 * 
	 * @param nlstypeid
	 * @return
	 */
	public abstract int countfindMoreRecommendedGoodsByGoodsType(final String nlstypeid);

	/**
	 * 获取更多特价商品
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<GoodsT> findMoreBargainPriceGoods(final int currentPage, int lineSize);

	/**
	 * 统计获取更多特价商品
	 * 
	 * @return
	 */
	public abstract int countfindMoreBargainPriceGoods();

	/**
	 * 获取商品数据给手机客户端
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param creatorid
	 * @return
	 */
	public abstract List<GoodsT> findAllGoodsByismobileplatformgoods(final int currentPage, int lineSize, String creatorid);
	/**
	 * 根据顶级分类获取手机端商品
	 * @param navid
	 * @param salestate
	 * @param ismobileplatformgoods
	 * @return
	 */
	public abstract List<GoodsT> findAllGoodsByismobileplatformgoodsBynavid(String navid,String salestate,String ismobileplatformgoods);
	/**
	 * 统计获取商品数据给手机客户端
	 * 
	 * @param creatorid
	 * @return
	 */
	public abstract int countfindAllGoodsByismobileplatformgoods(String creatorid);

	/**
	 * 根据顶级分类获取旗下商品
	 * 
	 * @param navid
	 * @param salestate
	 * @return
	 */
	public abstract List<GoodsT> findAllGoodsBynavid(String navid, String salestate);

	/**
	 * 根据一级分类获旗下商品
	 * 
	 * @param ltypeid
	 * @param salestate
	 * @return
	 */
	public abstract List<GoodsT> findGoodsByLtypeid(String ltypeid, String salestate);
	
	/**
	 * 根据商品id更新htmlpath
	 * 
	 * @param goodsid
	 * @param htmlPath
	 * @return
	 */
	public abstract int updateHtmlPath(String goodsid, String htmlPath);
	/**
	 * 根据商品id更新htmlpath避免重复生成无修改页面
	 * 
	 * @param goodsid
	 * @param htmlPath
	 * @param updatetime
	 * @return
	 */
	public abstract int updateHtmlPath(String goodsid, String htmlPath,Date updatetime);

	/**
	 * 获取所有商品用于安装程序生成静态页
	 * 
	 * @param salestate
	 * @return
	 */
	public abstract List<GoodsT> finaAllGoodsT(String salestate);

	/**
	 * 增加星级评分
	 * 
	 * @param goodsid
	 * @param starsum
	 * @return
	 */
	public abstract int updatestarsumBygoodsid(String goodsid, int star);

	/**
	 * 更新商品总打分人数
	 * 
	 * @param goodsid
	 * @param starusersum
	 * @return
	 */
	public abstract int updatestarusersumBygoodsid(String goodsid, int staruser);

	/**
	 * 更新商品总评分人数
	 * 
	 * @param goodsid
	 * @param commentsum
	 * @return
	 */
	public abstract int updatecommentsumBygoodsid(String goodsid, int totalcomment);

	/**
	 * 根据传入的状态查询对应的商品顶级分类数据
	 * 
	 * @param navid
	 * @param salestate
	 * @param sales
	 * @param memberprice
	 * @param totalcomment
	 * @param bargainprice
	 * @param hotsale
	 * @param recommended
	 * @param isNew
	 * @param value
	 *            筛选值1/0
	 * @return
	 */
	public abstract List<GoodsT> findAllGoodsBynavidorderbyParams(String navid, String salestate, String sales, String memberprice, String totalcomment, String bargainprice, String hotsale, String recommended, String isNew, String value);

	/**
	 * 根据传入的状态查询对应的商品
	 * 
	 * @param navid
	 * @param salestate
	 * @param sales
	 * @param memberprice
	 * @param totalcomment
	 * @param bargainprice
	 * @param hotsale
	 * @param recommended
	 * @param isNew
	 * @param value
	 * @return
	 */
	public abstract List<GoodsT> findAllGoodsByLtypeidorderbyParams(String ltypeid, String salestate, String sales, String memberprice, String totalcomment, String bargainprice, String hotsale, String recommended, String isNew, String value);

	/**
	 * 根据排序字段按照排序方式排序
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param queryString
	 * @param creatorid
	 * @return
	 */
	public abstract List<GoodsT> sortAllGoods(final int currentPage, final int lineSize, final String creatorid, final String queryString);
	/**
	 * 根据商品类型ID更新商品类型名称
	 * @param goodsTypeName
	 * @param goodsTypeId
	 * @return
	 */
	public abstract int updateGoodsTypeNameBygoodsTypeId(String goodsTypeName,String goodsTypeId);
	/**
	 * 根据商品分类的id更新商品分类的名称
	 * @param queryString
	 * @return
	 */
	public abstract int updateGoodsCategoryBynlsid(String queryString);
	
	public abstract List<GoodsT>findAllGoodsForImgT();
	/**
	 * 根据推荐和上架获取商品数据并打乱顺序
	 * @param currentPage
	 * @param lineSize
	 * @param salestate
	 * @param recommended
	 * @return
	 */
	public abstract List<GoodsT>findshuffleGoods(final int currentPage,final int lineSize,final String salestate,final String recommended);
	/**
	 * 根据属性获取商品列表
	 * @param currentPage
	 * @param lineSize
	 * @param attr
	 * @param salestate
	 * @return
	 */
	public abstract List<GoodsT>findGoodsByattrs(final int currentPage,final int lineSize,final String attr,final String salestate);
	/**
	 * 根据商品顶级分类获取移动平台的商品数据
	 * @param navid
	 * @param salestate
	 * @param ismobileplatformgoods
	 * @return
	 */
	public abstract List<GoodsT>findGoodsByNavid(String navid,String salestate,String ismobileplatformgoods);
	/**
	 * 根据顶级分类获取旗下商品不包含规格值
	 * 
	 * @param navid
	 * @param salestate
	 * @return
	 */
	public abstract List<GoodsT> findAllGoodsBynavid(String navid, String salestate,String isSpecificationsOpen);
	/**
	 * 根据传入的商品分类数据查询商品集合不包含规格值
	 * @param navid
	 * @param ltypeid
	 * @param salestate
	 * @param isSpecificationsOpen
	 * @return
	 */
	public abstract List<GoodsT>findAllGoodsBynavidandltypeid(String navid,String ltypeid,String salestate,String isSpecificationsOpen);
	
	/**
	 * 根据传入的商品分类数据查询商品集合不包含规格值
	 * @param navid
	 * @param ltypeid
	 * @param stypeid
	 * @param salestate
	 * @param isSpecificationsOpen
	 * @return
	 */
	public abstract List<GoodsT>findAllGoodsBynavidandltypeidandstypeid(String navid,String ltypeid,String stypeid,String salestate,String isSpecificationsOpen);
//	
//	public List<GoodsT> findGoodsByLikePrice(String price);
}
