package com.jshop.service;

import java.util.List;

import com.jshop.entity.VouchersT;

public interface VouchersTService extends BaseTService<VouchersT>{

	
	/**
	 * 删除优惠券
	 * 
	 * @param list
	 * @return
	 */
	public int delVoucherst(String[] list);

	/**
	 * 更新优惠券
	 * 
	 * @param vt
	 * @return
	 */
	public int updateVoucherst(VouchersT vt);

	/**
	 * 查询所有优惠券
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<VouchersT> findAllVoucherst(final int currentPage,
			final int lineSize);

	/**
	 * 统计所有优惠券
	 * 
	 * @return
	 */
	public int countfindAllVoucherst();

	/**
	 * 根据抵用券编码查询是否有相同编码的抵用券
	 * 
	 * @param vouchersname
	 * @return
	 */
	public List<VouchersT> findVoucherstByName(String vouchersname);

	/**
	 * 兑现抵用券
	 * 
	 * @param vouchersname
	 * @return
	 */
	public VouchersT findVouchersForHonor(String vouchersname);

	/**
	 * 检索用户抵用券
	 * 
	 * @param userid
	 * @return
	 */
	public List<VouchersT> findUserVouchers(final String userid,
			final int currentPage, final int lineSize);

	/**
	 * 统计检索用户抵用券
	 * 
	 * @param userid
	 * @return
	 */
	public int countfindUserVouchers(String userid);

}
