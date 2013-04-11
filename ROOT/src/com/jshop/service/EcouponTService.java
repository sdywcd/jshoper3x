package com.jshop.service;

import java.util.List;

import com.jshop.entity.EcouponT;

public interface EcouponTService {
	/**
	 * 添加电子优惠券
	 * @param et
	 * @return
	 */
	public int addEcoupon(EcouponT et);
	/**
	 * 查询所有电子优惠券
	 * @return
	 */
	public List<EcouponT> findAllEcoupon(final int currentPage,final int lineSize);
	/**
	 * 统计所有优惠券数量
	 * @return
	 */
	public int countAllEcoupon();
	/**
	 * 根据电子券id获取信息
	 * @param eid
	 * @return
	 */
	public EcouponT findEcouponByEid(String eid);
	/**
	 * 批量删除
	 * @param id
	 * @return
	 */
	public int dekEcoupont(String[] eid);
	/**
	 * 更新优惠券信息
	 * @param eid
	 * @return
	 */
	public int updateEcouponT(EcouponT et);
	
}
