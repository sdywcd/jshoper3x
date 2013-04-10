package com.jshop.dao;

import java.util.List;

import com.jshop.entity.VouchersT;

public interface VouchersTDao {

	/**
	 * 增加优惠券
	 * @param vt
	 * @return
	 */
	public abstract int addVoucherst(VouchersT vt);
	/**
	 * 删除优惠券
	 * @param list
	 * @return
	 */
	public abstract int delVoucherst(String [] list);
	/**
	 * 更新优惠券
	 * @param vt
	 * @return
	 */
	public abstract int updateVoucherst(VouchersT vt);
	/**
	 * 查询所有优惠券
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<VouchersT>findAllVoucherst(final int currentPage,final int lineSize);
	/**
	 * 统计所有优惠券
	 * @return
	 */
	public abstract int countfindAllVoucherst();
	/**
	 * 根据抵用券编码查询是否有相同编码的抵用券
	 * @param vouchersname
	 * @return
	 */
	public abstract List<VouchersT>findVoucherstByName(String vouchersname);

	/**
	 * 兑现抵用券
	 * @param vouchersname
	 * @return
	 */
	public abstract VouchersT findVouchersForHonor(String vouchersname);

	/**
	 * 检索用户抵用券
	 * @param userid
	 * @return
	 */
	public abstract List<VouchersT>findUserVouchers(final String userid,final int currentPage,final int lineSize);

	/**
	 * 统计检索用户抵用券
	 * @param userid
	 * @return
	 */
	public abstract int countfindUserVouchers(String userid);


}
