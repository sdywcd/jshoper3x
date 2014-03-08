package com.jshop.service;

import java.util.List;

import com.jshop.entity.DeliverAddressT;

public interface DeliverAddressTService extends BaseTService<DeliverAddressT>{


	/**
	 * 删除收获地址
	 * 
	 * @param list
	 * @return
	 */
	public int delDeliverAddress(String[] list);

	/**
	 * 更新收获地址
	 * 
	 * @param d
	 * @return
	 */
	public int updateDeliverAddress(DeliverAddressT d);

	/**
	 * 查询所有收获地址
	 * 
	 * @return
	 */
	public List<DeliverAddressT> findAllDeliverAddress();

	/**
	 * 根据用户id获取用户收货地址
	 * 
	 * @param memberid
	 * @return
	 */
	public List<DeliverAddressT> findDeliverAddressBymemberid(String memberid);

	/**
	 * 根据地址id获取地址信息
	 * 
	 * @param addressid
	 * @return
	 */
	public DeliverAddressT findDeliverAddressById(String addressid);
}
