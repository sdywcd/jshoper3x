package com.jshop.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.OrderTDao;
import com.jshop.dao.impl.OrderTDaoImpl;
import com.jshop.entity.OrderT;
import com.jshop.service.OrderTService;

@Service("orderTService")
@Scope("prototype")
public class OrderTServiceImpl implements OrderTService {
	@Resource
	private OrderTDao orderTDao;

	public OrderTDao getOrderTDao() {
		return orderTDao;
	}

	public void setOrderTDao(OrderTDao orderTDao) {
		this.orderTDao = orderTDao;
	}

	public int addOrder(OrderT o) {
		return this.getOrderTDao().addOrder(o);
	}

	public int countfindAllOrderByorderstate(String userid, String orderstate, String paystate, String shippingstate) {
		return this.getOrderTDao().countfindAllOrderByorderstate(userid, orderstate, paystate, shippingstate);
	}

	public List<OrderT> findAllOrderByorderstate(int currentPage, int lineSize, String userid, String orderstate, String paystate, String shippingstate) {
		return this.getOrderTDao().findAllOrderByorderstate(currentPage, lineSize, userid, orderstate, paystate, shippingstate);
	}

	public int delOrderByorderid(String userid, String orderid, String orderstate) {
		return this.getOrderTDao().delOrderByorderid(userid, orderid, orderstate);
	}

	public List<OrderT> findAllOrderByorderstateForOn(int currentPage, int lineSize, String userid, String orderstate, String paystate, String shippingstate) {
		return this.getOrderTDao().findAllOrderByorderstateForOn(currentPage, lineSize, userid, orderstate, paystate, shippingstate);
	}

	public int countfindAllOrderByorderstateForOn(String userid, String orderstate, String paystate, String shippingstate) {
		return this.getOrderTDao().countfindAllOrderByorderstateForOn(userid, orderstate, paystate, shippingstate);
	}

	public OrderT findOrderDetailByorderid(String orderid) {
		return this.getOrderTDao().findOrderDetailByorderid(orderid);
	}

	public int updateOrder(OrderT o) {
		return this.getOrderTDao().updateOrder(o);
	}

	public int updateOrderPaystateByorderid(String orderid, String paystate) {
		return this.getOrderTDao().updateOrderPaystateByorderid(orderid, paystate);
	}

	public List<OrderT> findAllOrderT(int currentPage, int lineSize) {
		return this.getOrderTDao().findAllOrderT(currentPage, lineSize);
	}

	public int countfindAllOrderT() {
		return this.getOrderTDao().countfindAllOrderT();
	}

	public int countfindOrderbyOrderid(String orderid) {
		return this.getOrderTDao().countfindOrderbyOrderid(orderid);
	}

	public List<OrderT> findOrderByOrderid(int currentPage, int lineSize, String orderid) {
		return this.getOrderTDao().findOrderByOrderid(currentPage, lineSize, orderid);
	}

	public int countfindOrderByShippingUsername(String shippingusername) {
		return this.getOrderTDao().countfindOrderByShippingUsername(shippingusername);
	}

	public List<OrderT> findOrderByShippingUsername(int currentPage, int lineSize, String shippingusername) {
		return this.getOrderTDao().findOrderByShippingUsername(currentPage, lineSize, shippingusername);
	}

	public int updateOrderPayShippingState(String orderid, String orderstate, String paystate, String shippingstate) {
		return this.getOrderTDao().updateOrderPayShippingState(orderid, orderstate, paystate, shippingstate);
	}

	public int countfindAllTobeShippedOrders(String shippingstate) {
		return this.getOrderTDao().countfindAllTobeShippedOrders(shippingstate);
	}

	public List<OrderT> findAllTobeShippedOrders(int currentPage, int lineSize, String shippingstate) {
		return this.getOrderTDao().findAllTobeShippedOrders(currentPage, lineSize, shippingstate);
	}

	public int updateExpressnumberByOrderId(String orderid, String expressnumber) {
		return this.getOrderTDao().updateExpressnumberByOrderId(orderid, expressnumber);
	}

	public int updateInvoicenumberByOrderId(String orderid, String invoicenumber, Date deliverytime) {
		return this.getOrderTDao().updateInvoicenumberByOrderId(orderid, invoicenumber, deliverytime);
	}

	public int updateInvoiceByOrderId(String orderid, String invoice) {
		return this.getOrderTDao().updateInvoiceByOrderId(orderid, invoice);
	}

	public int updateOrderShippingstateByorderid(String orderid, String shippingstate) {
		return this.getOrderTDao().updateOrderShippingstateByorderid(orderid, shippingstate);
	}

	public int updateOrderStateByorderid(String orderid, String orderstate) {
		return this.getOrderTDao().updateOrderStateByorderid(orderid, orderstate);
	}

	public List<OrderT> sortAllOrderT(int currentPage, int lineSize, String queryString) {

		return this.getOrderTDao().sortAllOrderT(currentPage, lineSize, queryString);
	}

	public List<OrderT> findAllhaveshippedOrder(int currentPage, int lineSize, String shippingstate) {

		return this.getOrderTDao().findAllhaveshippedOrder(currentPage, lineSize, shippingstate);
	}

	public int countAllhaveshippedOrder(String shippingstate) {

		return this.getOrderTDao().countAllhaveshippedOrder(shippingstate);
	}

	public int countAllreturnOrder(String orderstate) {
		return this.getOrderTDao().countAllreturnOrder(orderstate);
	}

	public List<OrderT> findAllreturnOrder(int currentPage, int lineSize, String orderstate) {
		return this.getOrderTDao().findAllreturnOrder(currentPage, lineSize, orderstate);
	}
}
