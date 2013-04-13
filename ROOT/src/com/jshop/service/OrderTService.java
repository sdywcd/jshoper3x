package com.jshop.service;


import java.util.Date;
import java.util.List;

import com.jshop.entity.OrderT;

public interface OrderTService {

	/**
	 * 增加订单
	 * @param o
	 * @return
	 */
	public abstract int addOrder(OrderT o);
	
	/**
	 * 根据订单状态获取订单信息
	 * @param currentPage
	 * @param lineSize
	 * @param userid
	 * @param orderstate
	 * @return
	 */
	public abstract List<OrderT>findAllOrderByorderstate(final int currentPage,final int lineSize,final String userid,final String orderstate,String paystate,String shippingstate);
	/**
	 * 统计根据订单状态获取订单信息
	 * @param userid
	 * @param orderstate
	 * @return
	 */
	public abstract int countfindAllOrderByorderstate(String userid,String orderstate,String paystate,String shippingstate);
	
	/**
	 * 用户删除自己订单
	 * @param userid
	 * @param orderid
	 * @param orderstate
	 * @return
	 */
	public abstract int delOrderByorderid(String userid,String orderid,String orderstate);

	/**
	 * 获取用户需要处理的订单，及包含paystate是1and0，shippingstate是1and0，orderstate不是8
	 * @param currentPage
	 * @param lineSize
	 * @param userid
	 * @param orderstate
	 * @param paystate
	 * @param shippingstate
	 * @return
	 */
	public abstract List<OrderT>findAllOrderByorderstateForOn(final int currentPage,final int lineSize,final String userid,final String orderstate,final String paystate,final String shippingstate);	
	/**
	 * 统计获取用户需要处理的订单，及包含paystate是1and0，shippingstate是1and0，orderstate不是8
	 * @param userid
	 * @param orderstate
	 * @param paystate
	 * @param shippingstate
	 * @return
	 */
	public abstract int countfindAllOrderByorderstateForOn(String userid,String orderstate,String paystate,String shippingstate);
	/**
	 * 根据订单号获取订单详细信息
	 * @param orderid
	 * @return
	 */
	public abstract OrderT findOrderDetailByorderid(String orderid);

	/**
	 * 更新订单
	 * @param o
	 * @return
	 */
	public abstract int updateOrder(OrderT o);
	
	/**
	 * 支付宝返回数据，更新订单是否付款标记
	 * @param orderid
	 * @param paystate
	 * @return
	 */
	public abstract int updateOrderPaystateByorderid(String orderid,String paystate);
	/**
	 * 支付宝返回数据，更新订单是否发货
	 * @param orderid
	 * @param shippingstate
	 * @return
	 */
	public abstract int updateOrderShippingstateByorderid(String orderid,String shippingstate);
	/**
	 * 支付宝返回数据，更新订单状态
	 * @param orderid
	 * @param orderstate
	 * @return
	 */
	public abstract int updateOrderStateByorderid(String orderid,String orderstate);
	
	/**
	 * 查询所有订单（后台）
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<OrderT>findAllOrderT(final int currentPage,final int lineSize); 
	/**
	 * 统计查询所有订单（后台）
	 * @return
	 */
	public abstract int countfindAllOrderT();
	/**
	 * 根据订单id查询订单列表（其实就只能查出唯一的一条）
	 * @param currentPage
	 * @param lineSize
	 * @param orderid
	 * @return
	 */
	public abstract List<OrderT>findOrderByOrderid(final int currentPage,final int lineSize,final String orderid);
	/**
	 * 统计根据订单id查询订单列表
	 * @param orderid
	 * @return
	 */
	public abstract int countfindOrderbyOrderid(String orderid);
	/**
	 * 根据收货人查询订单
	 * @param currentPage
	 * @param lineSize
	 * @param shippingusername
	 * @return
	 */
	public abstract List<OrderT>findOrderByShippingUsername(final int currentPage,final int lineSize,final String shippingusername);
	/**
	 * 统计收货人查询订单
	 * @param shippingusername
	 * @return
	 */
	public abstract int countfindOrderByShippingUsername(String shippingusername);
	/**
	 * 更新订单状态，支付状态，发货状态
	 * @param orderid
	 * @param orderstate
	 * @param paystate
	 * @param shippingstate
	 * @return
	 */
	public abstract int updateOrderPayShippingState(String orderid,String orderstate,String paystate,String shippingstate);
	/**
	 * 获取待发货订单
	 * @param currentPage
	 * @param lineSize
	 * @param shippingstate
	 * @return
	 */
	public abstract List<OrderT>findAllTobeShippedOrders(final int currentPage,final int lineSize,String shippingstate);
	/**
	 * 统计获取带发货订单
	 * @param shippingstate
	 * @return
	 */
	public abstract int countfindAllTobeShippedOrders(String shippingstate);
	/**
	 * 更新订单快递单号
	 * @param orderid
	 * @param expressnumber
	 * @return
	 */
	public abstract int updateExpressnumberByOrderId(String orderid,String expressnumber);
	/**
	 * 更新发货单号
	 * @param orderid
	 * @param invoicenumber
	 * @param time
	 * @return
	 */
	public abstract int updateInvoicenumberByOrderId(String orderid,String invoicenumber,Date deliverytime);
	
	/**
	 * 更新订单是否要开票
	 * @param orderid
	 * @param invoice
	 * @return
	 */
	public abstract int updateInvoiceByOrderId(String orderid,String invoice);
	/**
	 * 根据排序方式查询所有
	 * @param currentPage
	 * @param lineSize
	 * @param queryString
	 * @return
	 */
	public abstract List<OrderT>sortAllOrderT(final int currentPage,final int lineSize,String queryString); 
	/**
	 * 根据发货状态获取已发货商品
	 * @param currentPage
	 * @param lineSize
	 * @param orderstate
	 * @return
	 */
	public abstract List<OrderT> findAllhaveshippedOrder(final int currentPage,final int lineSize,String shippingstate);
	/**
	 * 获取所有已发货订单
	 * @param shippingstate
	 * @return
	 */
	public abstract int countAllhaveshippedOrder(String shippingstate);
	/**
	 * 根据订单状态获取已退货商品
	 * @param currentPage
	 * @param lineSize
	 * @param orderstate
	 * @return
	 */
	public abstract List<OrderT> findAllreturnOrder(final int currentPage,final int lineSize,String orderstate);
	/**
	 * 计算所有退货的订单
	 * @param shippingstate
	 * @return
	 */
	public abstract int countAllreturnOrder(String orderstate);
	
	
}
