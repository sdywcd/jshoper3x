package com.jshop.dao;

import java.util.List;

import com.jshop.entity.CouponT;

public interface CouponTDao {

	/**
	 * 获取所有优惠券
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<CouponT>findAllCoupon(final int currentPage,final int lineSize);
	/**
	 * 统计获取所有优惠券
	 * @return
	 */
	public abstract int countfindAllCoupon();
	/**
	 * 增加优惠券
	 * @param ct
	 */
	public abstract void addCouponT(CouponT ct);
	
	
	
	
}
