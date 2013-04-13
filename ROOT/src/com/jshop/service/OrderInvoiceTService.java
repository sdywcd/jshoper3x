package com.jshop.service;

import java.util.List;

import com.jshop.entity.OrderInvoiceT;

public interface OrderInvoiceTService {

	/**
	 * 增加订单发票记录
	 * @param oi
	 * @return
	 */
	public abstract int addOrderInvoice(OrderInvoiceT oi);
	/**
	 * 删除订单发票记录
	 * @param list
	 * @return
	 */
	public abstract int delOrderInvoice(String [] list);
	/**
	 * 更新是否已经开过发票
	 * @param orderinvoiceid
	 * @param state
	 * @return
	 */
	public abstract int updateOrderInvoiceState(String []orderinvoiceid,String state);
	/**
	 * 获取所有订单发票信息
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<OrderInvoiceT>findAllOrderIvoice(final int currentPage,final int lineSize);
	/**
	 * 统计获取所有订单发票信息
	 * @return
	 */
	public abstract int countfindAllOrderIvoice();
	
	
	
	
}
