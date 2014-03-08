package com.jshop.dao;

import java.util.List;

import com.jshop.entity.MemberRechargeT;

public interface MemberRechargeTDao extends BaseTDao<MemberRechargeT>{
	/**
	 * 查询所有充值账户余额
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<MemberRechargeT>findAllMemberRechargeT(int currentPage,int lineSize);
	/**
	 * 统计查询所有充值账户余额
	 * @return
	 */
	public int countfindAllMemberRechargeT();
	/**
	 * 更新充值账户余额信息
	 * @param mrt
	 */
	public void updateMemberRechargeT(MemberRechargeT mrt);
	/**
	 * 删除充值账户信息
	 * @param strs
	 */
	public void delMemberRechargeT(String[]strs);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public MemberRechargeT findMemberRechargeTById(String id);
	/**
	 * 根据会员id查询
	 * @param memberid
	 * @return
	 */
	public MemberRechargeT findMemberRechargeTByMemberId(String memberid);
	
	
	
	
}
