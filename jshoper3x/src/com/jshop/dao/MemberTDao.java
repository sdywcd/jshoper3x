package com.jshop.dao;

import java.util.List;

import com.jshop.entity.MemberT;

public interface MemberTDao {
	/**
	 * 增加用户
	 * @param mt
	 */
	public void saveMemberT(MemberT mt);
	/**
	 * 查询所有用户
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<MemberT>findAllMemberT(final int currentPage,final int lineSize);
	/**
	 * 统计查询所有用户
	 * @return
	 */
	public int countfindAllMemberT();
	
	/**
	 * 根据创建人id查询所有用户
	 * @param currentPage
	 * @param lineSize
	 * @param creatorid
	 * @return
	 */
	public List<MemberT>findAllMemberT(final int currentPage,final int lineSize,String creatorid);
	/**
	 * 统计根据创建人id查询所有用户
	 * @param creatorid
	 * @return
	 */
	public int countfindAllMemberT(String creatorid);
	/**
	 * 更新用户
	 * @param mt
	 */
	public void updateMemberT(MemberT mt);
	/**
	 * 根据主键id查询用户
	 * @param id
	 * @return
	 */
	public MemberT findMemberTById(String id);
	/**
	 * 批量删除用户
	 * @param strs
	 * @return
	 */
	public int delMemberT(String[] strs);
	/**
	 * 根据名称查询用户
	 * @param name
	 * @return
	 */
	public List<MemberT>findMemberTByloginname(String loginname);
	
	
	
	
}
