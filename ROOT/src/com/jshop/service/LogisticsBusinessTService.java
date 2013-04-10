package com.jshop.service;

import java.util.List;

import com.jshop.entity.LogisticsBusinessT;

public interface LogisticsBusinessTService {
	/**
	 * 增加物流商
	 * @param lb
	 * @return
	 */
	public abstract int addLogisticsBusiness(LogisticsBusinessT lb);

	/**
	 * 删除物流商
	 * @param list
	 * @return
	 */
	public abstract int delLogisticsBusiness(String [] list);
	
	/**
	 * 更新物流商
	 * @param lb
	 * @return
	 */
	public abstract int updateLogisticsBusiness(LogisticsBusinessT lb);
	/**
	 * 查询所有物流商
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<LogisticsBusinessT>findAllLogisticsBusiness(final int currentPage,final int lineSize);
	/**
	 * 统计查询所有物流商
	 * @return
	 */
	public abstract int countfindAllLogisticsBusiness();
	/**
	 * 根据id查询物流商信息
	 * @param logisticsid
	 * @return
	 */
	public abstract LogisticsBusinessT findLogisticsBusinessById(String logisticsid);
	/**
	 * 查询前台可用的物流商信息（配送方式）
	 * @return
	 */
	public abstract List<LogisticsBusinessT>findAllLogisticsBusinessWithoutPage();
	/**
	 * 为设置快递单模板获取物流商
	 * @return
	 */
	public abstract List<LogisticsBusinessT>findAllLogisticsBusinessTjson();
	
	
}
