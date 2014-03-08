package com.jshop.dao;

import java.util.List;

import com.jshop.entity.MemberGradeT;

public interface MemberGradeTDao extends BaseTDao<MemberGradeT>{


	/**
	 * 删除会员等级
	 * 
	 * @param list
	 * @return
	 */
	public void delMemberGradeT(String[] strs);

	/**
	 * 查询所有会员等级信息
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<MemberGradeT> findAllMemberGradeT(final int currentPage, final int lineSize);

	/**
	 * 统计查询所有用户等级信息
	 * 
	 * @return
	 */
	public int countfindAllMemberGradeT();



	/**
	 * 根据用户等级获取等级设置信息
	 * 
	 * @param id
	 * @return
	 */
	public MemberGradeT findMemberGradeTById(String id);

	/**
	 * 更新用户等级
	 * 
	 * @param gt
	 * @return
	 */
	public void updateMemberGradeTById(MemberGradeT mgt);

	/**
	 * 查询所有用户等级信息
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<MemberGradeT> findAllMemberGradeT();

}
