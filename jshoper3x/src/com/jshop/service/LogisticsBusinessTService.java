package com.jshop.service;

import java.util.List;

import com.jshop.entity.LogisticsBusinessT;

public interface LogisticsBusinessTService extends BaseTService<LogisticsBusinessT>{
	/**
	 * 删除物流商
	 * 
	 * @param list
	 * @return
	 */
	public int delLogisticsBusiness(String[] list);

	/**
	 * 更新物流商
	 * 
	 * @param lb
	 * @return
	 */
	public int updateLogisticsBusiness(LogisticsBusinessT lb);

	/**
	 * 查询所有物流商
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<LogisticsBusinessT> findAllLogisticsBusiness(
			final int currentPage, final int lineSize);

	/**
	 * 统计查询所有物流商
	 * 
	 * @return
	 */
	public int countfindAllLogisticsBusiness();

	/**
	 * 根据id查询物流商信息
	 * 
	 * @param logisticsid
	 * @return
	 */
	public LogisticsBusinessT findLogisticsBusinessById(String logisticsid);

	/**
	 * 查询前台可用的物流商信息（配送方式）
	 * 
	 * @return
	 */
	public List<LogisticsBusinessT> findAllLogisticsBusiness(String state);

	/**
	 * 为设置快递单模板获取物流商
	 * 
	 * @return
	 */
	public List<LogisticsBusinessT> findAllLogisticsBusinessTjson();
	/**
	 * 根据默认值查询物流商
	 * @param visible
	 * @return
	 */
	public List<LogisticsBusinessT>findLogisticsBusiness(String visible);
	
	
}
