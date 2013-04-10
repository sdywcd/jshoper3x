package com.jshop.service;

import java.util.List;

import com.jshop.entity.TableT;

public interface TableTService {
	/**
	 * 增加桌信息
	 * @param t
	 * @return
	 */
	public abstract int addTableT(TableT t);
	/**
	 * 批量删除桌信息
	 * @param strs
	 * @return
	 */
	public abstract int delTableT(String [] strs);
	/**
	 * 更新桌信息
	 * @param t
	 */
	public abstract void updateTableT(TableT t);
	/**
	 * 查询所有桌
	 * @return
	 */
	public abstract List<TableT>findAllTableT();
	/**
	 * 分页查询所有桌
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<TableT>findAllTableT(final int currentPage,final int lineSize);
	
	/**
	 * 统计分页查询所有桌
	 * @return
	 */
	public abstract int countfindAllTableT();
	/**
	 * 根据tableid查询桌信息
	 * @param tableid
	 * @return
	 */
	public abstract TableT findTableBytableid(String tableid);
	
	/**
	 * 根据指定sql语句进行排序查询
	 * @param currentPage
	 * @param lineSize
	 * @param queryString
	 * @return
	 */
	public abstract List<TableT>sortAllTableT(final int currentPage,final int lineSize,String queryString);
	/**
	 * 更新当前餐桌使用情况
	 * @param tableid
	 * @param tablestate
	 * @return
	 */
	public abstract int updateTableTtablestateBytableNo(String tableid,String tablestate);
	/**
	 * 根据tablebumber查询桌信息
	 * @param tableid
	 * @return
	 */

	public abstract List<TableT> findTableBytablenumber(String tableNumber);


}
