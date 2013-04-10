package com.jshop.dao;

import java.util.List;

import com.jshop.entity.CartT;

public interface CartTDao {

	/**
	 * 查询所有购物车 后台
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<CartT> findAllCart(final int currentPage,final int lineSize);

	/**
	 * 统计查询所有购物车 后台
	 * @return
	 */
	public abstract int countfindAllCart();
	/**
	 * 根据userid查询购物车内容 前台
	 * @param userid
	 * @param state 商品在购物车中的状态
	 * @param orderTag 商品的类型是虚拟还是普通
	 * @return
	 */
	public abstract List<CartT>findAllCartByUserId(String userid,String state,String orderTag);

	/**
	 * 增加购物车内容
	 * @param c
	 * @return
	 */
	public abstract int addCart(CartT c);

	/**
	 * 查询商品是否已经在购物车中
	 * @param userid
	 * @param goodsid
	 * @param state 1表示新增，2表示删除，3表示已经和订单对应
	 * @return
	 */
	public abstract CartT findGoodsInCartOrNot(String userid,String goodsid,String state);
	/**
	 * 查询商品是否已经在购物车中
	 * @param userid
	 * @param goodsid
	 * @param state 1表示新增，2表示删除，3表示已经和订单对应
	 * @param productid
	 * @return
	 */
	public abstract CartT findGoodsInCartOrNot(String userid,String goodsid,String productid,String state);
	/**
	 * 更新购物车中的商品数量
	 * @param userid
	 * @param goodsid
	 * @param needquantity
	 * @return
	 */
	public abstract int updateCartNeedquantityByGoodsid(String userid,String goodsid,int needquantity,String state);
	/**
	 * 更新购物车中的商品数量
	 * @param userid
	 * @param goodsid
	 * @param needquantity
	 * @param productid
	 * @return
	 */
	public abstract int updateCartNeedquantityByGoodsid(String userid,String goodsid,String productid,int needquantity,String state);
	
	/**
	 * 减少需要的商品数量
	 * @param userid
	 * @param goodsid
	 * @param needquantity
	 * @return
	 */
	public abstract int reduceCartNeddquantityByGoodsid(String userid,String goodsid,int needquantity);
	/**
	 * 删除购物车商品加入state=1的条件表示只会删除新增加入的商品会在购物车中删除时生效。
	 * @param userid
	 * @param goodsid
	 * @param state
	 * @return
	 */
	public abstract int delCartByGoodsId(String userid,String goodsid,String state);
	
	/**
	 * 更新购物车商品数量
	 * @param userid
	 * @param goodsid
	 * @param needquantity
	 * @return
	 */
	public abstract int updateCartNeedquantity(String userid,String goodsid,int needquantity);
	/**
	 * 更新商品价格小计
	 * @param userid
	 * @param goodsid
	 * @param subtotal
	 * @return
	 */
	public abstract int updateCartSubtotal(String userid,String goodsid,double subtotal);

	/**
	 * 更新购物车中商品状态
	 * @param userid
	 * @param goodsid
	 * @param state
	 * @return
	 */
	public abstract int updateCartState(String userid,String goodsid,String state);

	/**
	 * 更新购物车中的商品状态，根据商品id集合,并作订单更新
	 * @param userid
	 * @param goodsid
	 * @param state
	 * @param orderid
	 * @param cartid
	 * @returnString []goodsid
	 */
	public abstract int updateCartStateandOrderidByGoodsidList(String cartid,String orderid,String userid,String state);
	/**
	 * 更新购物车中的商品状态，根据商品id集合
	 * @param userid
	 * @param goodsid
	 * @param state
	 * @return
	 */
	public abstract int updateCartStateByGoodsidList(String userid,String []goodsid,String state);
	/**
	 * 根据订单号在购物车中查询对应的商品记录
	 * @param orderid
	 * @return
	 */
	public abstract List<CartT>findCartGoodsByOrderid(String orderid);

	/**
	 * 根据goodsid更新购物车id，表示次购物车下的商品同属一个购物车
	 * @param userid
	 * @param goodsid
	 * @param state
	 * @return
	 */
	public abstract int updateCartIdBygoodsid(String cartid,String userid,String goodsid,String state);
	/**
	 * 根据productid更新购物车id，表示次购物车下的商品同属一个购物车
	 * @param cartid
	 * @param userid
	 * @param productid
	 * @param state
	 * @return
	 */
	public abstract int updateCartIdByproductid(String cartid,String userid,String productid,String state);
	
	
	/**检查被加入订单的购物车商品是否已经有订单号，如果有则不再更新订单号，防止多次提交订单操作，导致订单异常
	 * @param state =3
	 * @param cartid
	 * @return
	 */
	public abstract List<CartT>findCartByCartid(String cartid,String state);
	/**
	 * 根据购物车id删除购物车
	 * @param id
	 * @return
	 */
	public abstract int delCartByid(String id);
	
	
}
