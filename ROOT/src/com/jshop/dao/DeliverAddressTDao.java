package com.jshop.dao;

import java.util.List;

import com.jshop.entity.DeliverAddressT;

public interface DeliverAddressTDao {

	/**
	 * 增加收获地址
	 * @param d
	 * @return
	 */
	public abstract int addDeliverAddress(DeliverAddressT d);
	
	/**
	 * 删除收获地址
	 * @param list
	 * @return
	 */
	public abstract int delDeliverAddress(String [] list);
	
	/**
	 * 更新收获地址
	 * @param d
	 * @return
	 */
	public abstract int updateDeliverAddress(DeliverAddressT d);
	
	/**
	 * 查询所有收获地址
	 * @return
	 */
	public abstract List<DeliverAddressT>findAllDeliverAddress();
	
	/**
	 * 根据用户id获取用户收货地址
	 * @param userid
	 * @return
	 */
	public abstract List<DeliverAddressT>findDeliverAddressByuserid(String userid);
	/**
	 * 根据地址id获取地址信息
	 * @param addressid
	 * @return
	 */
	public abstract DeliverAddressT findDeliverAddressById(String addressid);
}
