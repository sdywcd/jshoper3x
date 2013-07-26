package com.jshop.dao;

import java.util.List;

import com.jshop.entity.LogisticsbusinessareaT;

public interface LogisticsbusinessareaTDao {

	/**
	 * 增加物流商区域价格
	 * @param lba
	 * @return
	 */
	public abstract int addLogisticsbusinessarea(LogisticsbusinessareaT lba);
	/**
	 * 删除物流商区域价格
	 * @param list
	 * @return
	 */
	public abstract int delLogisticsbusinessarea(String []list);
	/**
	 * 更新物流商区域价格
	 * @param lba
	 * @return
	 */
	public abstract int updateLogisticsbusinessarea(LogisticsbusinessareaT lba);
	/**
	 * 查询所有物流商区域价格
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<LogisticsbusinessareaT> findAllLogisticsbusinessareaT(final int currentPage,final int lineSize);
	/**
	 * 统计查询所有物流商区域价格
	 * @return
	 */
	public abstract int countfindAllLogisticsbusinessareaT();
	/**
	 * 根据id获取物流商区域价格数据
	 * @param logbusareaid
	 * @return
	 */
	public abstract LogisticsbusinessareaT findLogisticsbusinessareaTById(String logbusareaid);
	/**
	 * 启用和禁止物流商区域价格
	 * @param list
	 * @param state
	 * @return
	 */
	public abstract int updateLogisticsbusinessareaBystate(String []list,String state);

	/**
	 * 根据物流商id获取对应的物流商区域价格id
	 * @param logisticsid
	 * @return
	 */
	public abstract List<LogisticsbusinessareaT>findAllLogisticsbusinessareaTBylogisticsid(String logisticsid);

	
	
}
