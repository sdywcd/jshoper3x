package com.jshop.dao;

import java.util.List;

import com.jshop.entity.CartT;
import com.jshop.entity.GroupCartT;

public interface GroupCartDao extends BaseTDao<GroupCartT> {
	/**
	 * 根据ID查询团购商品
	 * @param groupid
	 * @return
	 */
	public List<GroupCartT> findGroupById(String groupid);
	/**
	 * 根据ID删除商品
	 * @param groupid
	 * @return
	 * 
	 */
	public int delGroupCart(String cartid);
	/**
	 * 根据userid查询团购购物车内容 前台
	 * @param userid
	 * @return
	 */
	public abstract List<GroupCartT>findAllGroupCartByUserId(String userid);

	/**检查被加入订单的购物车商品是否已经有订单号，如果有则不再更新订单号，防止多次提交订单操作，导致订单异常
	 * @param state =3
	 * @param cartid
	 * @return
	 */
	public abstract List<GroupCartT>findgroupCartByCartid(String cartid,String state);
	/**
	 * 更新购物车中的商品状态，根据商品id集合,并作订单更新
	 * @param userid
	 * @param goodsid
	 * @param state
	 * @param orderid
	 * @param cartid
	 * @returnString []goodsid
	 */
	public abstract int updateGroupCartStateandOrderidByGoodsidList(String cartid,String orderid,String userid,String state);
	/**
	 * 根据订单号在购物车中查询对应的商品记录
	 * @param orderid
	 * @return
	 */
	public abstract List<GroupCartT>findGroupCartGoodsByOrderid(String orderid);
	/**
	 * 当订单提交成功后修改商品的状态。
	 * @param goodsid
	 * @return
	 */
	public int updateGroupCartStateByGoodsId(String goodsid,String state);
}
