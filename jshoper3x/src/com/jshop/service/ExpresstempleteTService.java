package com.jshop.service;

import java.util.List;

import com.jshop.entity.ExpresstempleteT;

public interface ExpresstempleteTService extends BaseTService<ExpresstempleteT>{

	/**
	 * 删除快递单模板
	 * 
	 * @param list
	 * @return
	 */
	public int delExpresstemplete(String[] list);

	/**
	 * 更新快递单模板
	 * 
	 * @param et
	 * @return
	 */
	public int updateExpresstemplete(ExpresstempleteT et);

	/**
	 * 根据物流商id获取快递单模板
	 * 
	 * @param logisticsid
	 * @return
	 */
	public ExpresstempleteT findExpresstempleteByLogisticsid(String logisticsid);

	/**
	 * 查询所有物流商的快递单模板
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<ExpresstempleteT> findAllExpresstempleteT(
			final int currentPage, final int lineSize);

	/**
	 * 统计查询所有物流商的快递单模板
	 * 
	 * @return
	 */
	public int countfindAllExpresstempleteT();

	/**
	 * 根据快递单模板编号获取信息
	 * 
	 * @param expresstempleteid
	 * @return
	 */
	public ExpresstempleteT findExpresstempleteBytempleteid(
			String expresstempleteid);

}
