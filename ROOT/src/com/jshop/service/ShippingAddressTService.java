package com.jshop.service;

import java.util.List;

import com.jshop.entity.ShippingAddressT;

public interface ShippingAddressTService {
	/**
	 * 增加收获地址
	 * @param d
	 * @return
	 */
	public abstract int addShoppingAddress(ShippingAddressT s);
	/**
	 * 根据发货地址id查询层级的一系列发货地址（是否变更过地址等）
	 * @param shippingaddressid
	 * @param state
	 * @return
	 */
	public abstract List<ShippingAddressT> findShippingAddressByIdAndState(String shippingaddressid,String state);

	/**
	 * 根据收货地址id查询是否有对应的发货地址信息
	 * @param deliveraddressid
	 * @param state
	 * @param orderid
	 * @return
	 */
	public abstract List<ShippingAddressT>findShippingAddressByDeliveraddressidAndstate(String deliveraddressid,String state,String orderid);
	
	/**
	 * 根据订单编号把地址设定到state2
	 * @param orderid
	 * @param state
	 * @return
	 */
	public abstract int updateShippingAddressByorderandstate(String orderid,String state);
	/**
	 * 根据订单号和地址状态获取发货地址，地址状态是最新的可用地址，state=1
	 * @param orderid
	 * @param state
	 * @return
	 */
	public abstract ShippingAddressT findShippingAddressByOrderid(String orderid,String state);



}
