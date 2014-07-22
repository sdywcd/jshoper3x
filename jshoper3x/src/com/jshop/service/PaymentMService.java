package com.jshop.service;

import java.util.List;

import com.jshop.entity.PaymentM;

public interface PaymentMService extends BaseTService<PaymentM>{

	

	/**
	 * 开启支付方式使用
	 * 
	 * @param list
	 * @return
	 */
	public int openPayment(String[] list);

	/**
	 * 更新支付方式信息
	 * 
	 * @param pm
	 * @return
	 */
	public int updatePayment(PaymentM pm);

	/**
	 * 查询所有支付方式
	 * 
	 * @param currenPage
	 * @param lineSize
	 * @return
	 */
	public List<PaymentM> findAllPayment(final int currentPage,
			final int lineSize);

	/**
	 * 统计所有支付方式
	 * 
	 * @return
	 */
	public int countfindAllPayment();

	/**
	 * 根据id获取支付方式
	 * 
	 * @param paymentid
	 * @return
	 */
	public PaymentM findPaymentbyId(String paymentid);

	/**
	 * 禁止支付方式
	 * 
	 * @param list
	 * @return
	 */
	public int closePayment(String[] list);

	/**
	 * 获取所有启用的支付方式
	 * 
	 * @return
	 */
	public List<PaymentM> findAllPayment(String state);

	/**
	 * 根据id批量删除支付方式
	 * 
	 * @param str
	 * @return
	 */
	public int delPaymentByid(String[] str);

}
