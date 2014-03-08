package com.jshop.service;

import java.util.List;

import com.jshop.entity.InvoicetempleteT;

public interface InvoicetempleteTService extends BaseTService<InvoicetempleteT> {


	/**
	 * 删除发货单模板
	 * 
	 * @param list
	 * @return
	 */
	public int delInvoiceTemplete(String[] list);

	/**
	 * 查询所有发货单模板
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<InvoicetempleteT> findAllInvoicetempleteT(
			final int currentPage, final int lineSize);

	/**
	 * 统计查询所有发货单模板
	 * 
	 * @return
	 */
	public int countfindAllInvoicetempleteT();

	/**
	 * 更新发货单模板
	 * 
	 * @param it
	 * @return
	 */
	public int updateInvoicetempleteT(InvoicetempleteT it);

	/**
	 * 根据id获取发货单信息
	 * 
	 * @param invoicetempleteid
	 * @return
	 */
	public InvoicetempleteT findInvoicetempleteById(String invoicetempleteid);

	/**
	 * 根据发货单模板状态获取
	 * 
	 * @param state
	 * @return
	 */
	public InvoicetempleteT findInvoicetempleteByState(String state);

}
