package com.jshop.service;

import java.util.List;

import com.jshop.entity.ElectronicMenuOrderT;

public interface ElectronicMenuOrderTService {
	/**
	 * 增加电子菜单订单
	 * @param eo
	 * @return
	 */
	public abstract int addElectronicMenuOrderT(ElectronicMenuOrderT eo);
	/**
	 * 根据传入的sql排序获取电子菜单订单(后台)
	 * @param currentPage
	 * @param lineSize
	 * @param queryString
	 * @return
	 */
	public abstract List<ElectronicMenuOrderT>sortAllElectronicMenuOrderT(final int currentPage,final int lineSize,final String queryString);
	
	/**
	 * 统计所有订单数量（后台）
	 * @return
	 */
	public abstract int countfindAllElectronicMenuOrderT();
	/**
	 * 用户查询当前订单内容，条件是餐桌号和使用中的状态electronicorderstate!=8的情况
	 * @param tableNumber
	 * @param tablestate
	 * @return
	 */
	public abstract List<ElectronicMenuOrderT>findAllElectronicMenuOrderTBytableNumberandstate(String tableNumber,String tablestate,String electronicorderstate);
	/**
	 * 根据电子菜单订单号查询详细信息
	 * @param electronicMenuOrderid
	 * @return
	 */
	public abstract ElectronicMenuOrderT findElectronicMenuOrderTByelectronicMenuOrderid(String electronicMenuOrderid);
	/**
	 * 更新电子菜单订单
	 * @param eo
	 * @return
	 */
	public abstract void updateElectronicMenuOrderT(ElectronicMenuOrderT eo);
	/**
	 * 在结账的时候更新电子订单的是否付款标记
	 * @param electronicMenuOrderid
	 * @param paystate
	 * @return
	 */
	public abstract int updateElectronicMenuOrderTpaystateByelectronicMenuOrderid(String electronicMenuOrderid,String paystate);
	/**
	 * 当外卖的情况下，更新电子订单的发货状态标记
	 * @param electronicMenuOrderid
	 * @param shippingstate
	 * @return
	 */
	public abstract int updateElectronicMenuOrderTshippingstateByelectronicMenuOrderid(String electronicMenuOrderid,String shippingstate);
	/**
	 * 根据电子订单号更新电子订单状态
	 * @param electronicMenuOrderid
	 * @param electronicorderstate
	 * @return
	 */
	public abstract int updateElectronicMenuOrderTelectronicorderstateByelectronicMenuOrderid(String electronicMenuOrderid,String electronicorderstate);
	
	/**
	 * 统计根据收货人查询电子菜单订单
	 * @param shippingusername
	 * @return
	 */
	public abstract int countsortAllElectronicMenuOrderTByshippingusername(String shippingusername);
	/**
	 * 同时更新3个订单状态
	 * @param electronicMenuOrderid
	 * @param electronicorderstate
	 * @param paystate
	 * @param shippingstate
	 * @return
	 */
	public abstract int updateElectronicMenuOrderTpayshippingstate(String electronicMenuOrderid,String electronicorderstate,String paystate,String shippingstate);
	/**
	 * 获取带发货的订单
	 * @param currentPage
	 * @param lineSize
	 * @param shippingstate
	 * @return
	 */
	public abstract List<ElectronicMenuOrderT>sortAllTobeShippedElectronicMenuOrderT(final int currentPage,final int lineSize,String shippingstate);
	/**
	 * 统计获取带发货的订单
	 * @param shippingstate
	 * @return
	 */
	public abstract int countsortAllTobeShippedElectronicMenuOrderT(String shippingstate);
	/**
	 * 更新快递单号
	 * @param electronicMenuOrderid
	 * @param expressnumber
	 * @return
	 */
	public abstract int updateexpressnumberByelectronicMenuOrderid(String electronicMenuOrderid,String expressnumber);
	/**
	 * 更新是否开票
	 * @param electronicMenuOrderid
	 * @param invoice
	 * @return
	 */
	public abstract int updateInvoiceByelectronicMenuOrderid(String electronicMenuOrderid,String invoice);
	/**
	 *根据餐桌号 更新定单状态
	 * @param electronicorderstate
	 * @return
	 */
	public int updateElectronicMenuOrderElectrobicOrderState(String electronicorderstate,String tableNumber);
	/**
	 * 根据餐桌号查询详细信息
	 * @param electronicMenuOrderid
	 * @return
	 */
	public abstract List<ElectronicMenuOrderT> findElectronicMenuOrderTByelectronicMenuTablenumber(String tableNumber);
	/**
	 * 根据餐桌号更新付款状态
	 * @param paystate
	 * @param tableNumber
	 * @return
	 */
	public int updateElectronicMenuOrderPaystate(String paystate,String tableNumber);
}
