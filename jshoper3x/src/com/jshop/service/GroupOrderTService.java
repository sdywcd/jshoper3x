package com.jshop.service;

import java.util.Date;
import java.util.List;

import com.jshop.entity.GroupOrderT;

public interface GroupOrderTService extends BaseTService<GroupOrderT> {

	/**
	 * 查询所有订单（后台）
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<GroupOrderT>findAllGroupOrderT(final int currentPage,final int lineSize); 
	/**
	 * 统计查询所有订单（后台）
	 * @return
	 */
	public abstract int countfindAllGroupOrderT();
	/**
	 * 根据排序方式查询所有
	 * @param currentPage
	 * @param lineSize
	 * @param queryString
	 * @return
	 */
	public abstract List<GroupOrderT>sortAllGroupOrderT(final int currentPage,final int lineSize,String queryString); 
	/**
	 * 根据团购订单号获取订单详细信息
	 * @param orderid
	 * @return
	 */
	public abstract GroupOrderT findgroupOrderDetailByorderid(String orderid);

	/**
	 * 更新订单状态，支付状态，发货状态
	 * @param orderid
	 * @param orderstate
	 * @param paystate
	 * @param shippingstate
	 * @return
	 */
	public abstract int updateGroupOrderPayShippingState(String orderid,String orderstate,String paystate,String shippingstate);
	/**
	 * 更新订单快递单号
	 * @param orderid
	 * @param expressnumber
	 * @return
	 */
	public abstract int updateExpressnumberByGroupOrderId(String orderid,String expressnumber);
	/**
	 * 更新发货单号
	 * @param orderid
	 * @param invoicenumber
	 * @param time
	 * @return
	 */
	public abstract int updateInvoicenumberByOrderId(String orderid,String invoicenumber,Date deliverytime);
	

}
