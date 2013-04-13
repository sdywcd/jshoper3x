package com.jshop.dao;

import java.util.List;

import com.jshop.entity.TaobaoUserT;

public interface TaoBaoUsertDao {
	/**
	 * 查询所有的淘宝用户
	 * @param taobao
	 * @return
	 */
	public   List<TaobaoUserT> findAllTaobaoUserT( int currentPage,int lineSize);
	/**
	 * 添加淘宝用户
	 * @param taobao
	 * @return
	 */
	public int addTaoBaoUserT(TaobaoUserT taobao);

}
