package com.jshop.dao;

import java.util.List;

import com.jshop.entity.ElectronicMenuCartT;

public interface ElectronicMenuCartTDao {
	/**
	 * 增加菜单内容到电子订餐车中
	 * @param ec
	 * @return
	 */
	public abstract int addElectronicMenuCartT(ElectronicMenuCartT ec);
	/**
	 * 查询所有电子订餐车中的数据
	 * @return
	 */
	public abstract List<ElectronicMenuCartT>findAllElectronicMenuCartT();
	/**
	 * 统计查询所有电子订餐车中的数据
	 * @return
	 */
	public abstract int countfindAllElectronicMenuCartT();
	/**
	 * 根据注册用户用户名（会员号）可以是手机号查询电子订餐车数据(后台)
	 * @param username
	 * @return
	 */
	public abstract List<ElectronicMenuCartT>findAllElectronicMenuCartTByusername(String username);
	/**
	 * 根据桌号查询点了多少菜
	 * @param tableNumber
	 * @param tablestate 1标示使用中 0标示空闲中
	 * @return
	 */
	public abstract List<ElectronicMenuCartT>findAllElectronicMenuCartTBytableNumber(String tableNumber,String tablestate);
	/**
	 * 根据传入的state查询菜是否已经被加入过电子订餐车中
	 * @param tableNumber
	 * @param goodsid
	 * @param state 1标示新菜，2标示在加入订单后删除的菜，3标示菜已经和订单关联,4标示菜品可以在日后的数据清理时删除。当新加菜时用state=1，当订单提交成功后退菜让state=2，当关联了订单state=3，当本次用餐结束更新至4
	 * @param tablestate 1标示使用中 0标示空闲中
	 * @return
	 */
	public abstract ElectronicMenuCartT findGoodsInElectronicMenuCartTOrNot(String tableNumber,String tablestate,String goodsid,String state);
	/**
	 * 根据桌号和菜品号菜品状态更新所需的菜品数量
	 * @param tableNumber
	 * @param goodsid
	 * @param needquantity
	 * @param tablestate 1标示使用中 0标示空闲中
	 * @param state
	 * @return
	 */
	public abstract int updateElectronicMenuCartTneedquantityBygoodsid(String tableNumber,String tablestate,String goodsid,int needquantity,String state);
	/**
	 * 根据使用中的桌号和菜品状态=3的时候，删除菜品，由管理员操作即已经下单却撤销菜品的情况
	 * 用户不允许在下单后随意删除菜品。
	 * 当为生成订单的时候用户可以通过state=1来删除菜品
	 * @param tableNumber
	 * @param tablestate
	 * @param goodsid
	 * @param state 当state=3的时候，需要删除菜，这个时候只能让管理员操作，让state=2，表示加入了订单后删除了菜品
	 * @return
	 */
	public abstract int delElectronicMenuCartTGoods(String tableNumber,String tablestate,String goodsid,String state);
	/**
	 * 根据使用中的桌号和菜品id更新小计价格，例如一个菜品点了2个，小计价格就是2*单价
	 * @param tableNumber
	 * @param tablestate
	 * @param goodsid
	 * @param subtotal
	 * @return
	 */
	public abstract int updateElectronicMenuCartTsubtotal(String tableNumber,String tablestate,String goodsid,double subtotal);
	/**
	 * 更新电子订餐车中的菜品状态，主要涉及到如下：在结账的同时更新菜品到state=4，标示所有菜品已经结算完毕
	 * @param tableNumber
	 * @param tablestate
	 * @param goodsid
	 * @param state
	 * @return
	 */
	public abstract int updateElectronicMenuCartTstate(String tableNumber,String tablestate,String goodsid,String state);
	/**
	 * 更新餐桌状态，当用餐完毕后更新到空闲状态，同时也要更新餐桌记录的TABLESTATE表到空闲状态
	 * @param electronicMenuOrderid
	 * @param tablestate
	 * @return
	 */
	public abstract int updateElectronicMenuCartTtablestate(String electronicMenuOrderid,String tablestate);
	/**
	 * 在生成订单后更新电子餐车中菜品状态到3，条件是，桌号，桌使用情况
	 * @param tableNumber
	 * @param tablestate
	 * @param electronicMenuOrderid
	 * @param state
	 * @param electronicMenuCartid
	 * @return
	 */
	public abstract int updateElectronicMenuCartTstate(String tableNumber,String tablestate,String electronicMenuOrderid,String state,String electronicMenuCartid);
	/**
	 * 根据订单号和状态查询电子订餐车（后台）
	 * @param electronicMenuOrderid
	 * @param state
	 * @return
	 */
	public abstract List<ElectronicMenuCartT>findElectronicMenuCartTByelectronicMenuOrderid(String electronicMenuOrderid,String state);
	/**
	 * 更新电子订餐车id表示此次订餐车下的菜品同属一个订餐车
	 * @param electronicMenuCartid
	 * @param state
	 * @param tableNumber
	 * @param tablestate
	 * @return
	 */
	public abstract int updateElectronicMenuCartTelectronicMenuCartid(String electronicMenuCartid,String state,String tableNumber,String tablestate);
	/**
	 * 更新烹调状态
	 * @param cookingstate
	 * @return
	 */

	public int updateElectroMenuCartCookingState(String cookingstate,String tableNumber);
	/**
	 * 根据餐桌号查询信息
	 * @param tablenumber
	 * @return
	 */
	public List<ElectronicMenuCartT> findElectronicCartByTableNumber(String tableNumber);

	

}
