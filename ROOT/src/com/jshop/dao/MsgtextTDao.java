package com.jshop.dao;

import java.util.List;

import com.jshop.entity.MsgtextT;

public interface MsgtextTDao {

	/**
	 * 增加站内信消息
	 * @param mt
	 * @return
	 */
	public abstract int addMsgtext(MsgtextT mt);
	/**
	 * 删除站内信消息
	 * @param list
	 * @return
	 */
	public abstract int delMsgtext(String []list);
	/**
	 * 更新站内信消息
	 * @param mt
	 * @return
	 */
	public abstract int updateMsgtext(MsgtextT mt);
	/**
	 * 根据id获取站内信消息
	 * @param id
	 * @return
	 */
	public abstract MsgtextT findMsgtextById(String id);
	/**
	 * 获取所有站内信
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<MsgtextT>findAllMsgtext(final int currentPage,final int lineSize);
	/**
	 * 统计获取所有站内信
	 * @return
	 */
	public abstract int countfindAllMsgtext();
	
	
}
