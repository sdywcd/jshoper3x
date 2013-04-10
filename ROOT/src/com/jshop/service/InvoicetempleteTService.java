package com.jshop.service;

import java.util.List;

import com.jshop.entity.InvoicetempleteT;

public interface InvoicetempleteTService {
	/**
	 * 增加发货单模板
	 * @param it
	 * @return
	 */
	public abstract int  addInvoiceTemplete(InvoicetempleteT it);
	/**
	 * 删除发货单模板
	 * @param list
	 * @return
	 */
	public abstract int delInvoiceTemplete(String []list);
	/**
	 * 查询所有发货单模板
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<InvoicetempleteT> findAllInvoicetempleteT(final int currentPage,final int lineSize);
	/**
	 * 统计查询所有发货单模板
	 * @return
	 */
	public abstract int countfindAllInvoicetempleteT();
	/**
	 * 更新发货单模板
	 * @param it
	 * @return
	 */
	public abstract int updateInvoicetempleteT(InvoicetempleteT it);
	/**
	 * 根据id获取发货单信息
	 * @param invoicetempleteid
	 * @return
	 */
	public abstract InvoicetempleteT findInvoicetempleteById(String invoicetempleteid);
	/**
	 * 根据发货单模板状态获取
	 * @param state
	 * @return
	 */
	public abstract InvoicetempleteT findInvoicetempleteByState(String state);


}
