package com.jshop.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.dao.CartTDao;
import com.jshop.dao.OrderInvoiceTDao;
import com.jshop.dao.OrderTDao;
import com.jshop.dao.ShippingAddressTDao;
import com.jshop.dao.impl.OrderTDaoImpl;
import com.jshop.entity.CartT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.OrderInvoiceT;
import com.jshop.entity.OrderT;
import com.jshop.entity.ShippingAddressT;
import com.jshop.service.OrderTService;

@Service("orderTService")
@Scope("prototype")
public class OrderTServiceImpl extends BaseTServiceImpl<OrderT>implements OrderTService {
	@Resource
	private OrderTDao orderTDao;
	private Serial serial;
	private ShippingAddressTDao shippingAddressTDao;
	private CartTDao cartTDao;
	private OrderInvoiceTDao orderInvoiceTDao;
	
	public OrderInvoiceTDao getOrderInvoiceTDao() {
		return orderInvoiceTDao;
	}
	public void setOrderInvoiceTDao(OrderInvoiceTDao orderInvoiceTDao) {
		this.orderInvoiceTDao = orderInvoiceTDao;
	}
	public ShippingAddressTDao getShippingAddressTDao() {
		return shippingAddressTDao;
	}
	public void setShippingAddressTDao(ShippingAddressTDao shippingAddressTDao) {
		this.shippingAddressTDao = shippingAddressTDao;
	}
	public CartTDao getCartTDao() {
		return cartTDao;
	}
	public void setCartTDao(CartTDao cartTDao) {
		this.cartTDao = cartTDao;
	}
	public OrderTDao getOrderTDao() {
		return orderTDao;
	}
	public void setOrderTDao(OrderTDao orderTDao) {
		this.orderTDao = orderTDao;
	}

	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}


	public int countfindAllOrderByorderstate(String memberid, String orderstate, String paystate, String shippingstate) {
		return this.getOrderTDao().countfindAllOrderByorderstate(memberid, orderstate, paystate, shippingstate);
	}

	public List<OrderT> findAllOrderByorderstate(int currentPage, int lineSize, String memberid, String orderstate, String paystate, String shippingstate) {
		return this.getOrderTDao().findAllOrderByorderstate(currentPage, lineSize, memberid, orderstate, paystate, shippingstate);
	}

	public int delOrderByorderid(String memberid, String orderid, String orderstate) {
		return this.getOrderTDao().delOrderByorderid(memberid, orderid, orderstate);
	}

	public List<OrderT> findAllOrderByorderstateForOn(int currentPage, int lineSize, String memberid, String orderstate, String paystate, String shippingstate) {
		return this.getOrderTDao().findAllOrderByorderstateForOn(currentPage, lineSize, memberid, orderstate, paystate, shippingstate);
	}

	public int countfindAllOrderByorderstateForOn(String memberid, String orderstate, String paystate, String shippingstate) {
		return this.getOrderTDao().countfindAllOrderByorderstateForOn(memberid, orderstate, paystate, shippingstate);
	}

	public OrderT findOrderDetailByorderid(String orderid) {
		return this.getOrderTDao().findOrderDetailByorderid(orderid);
	}

	public void updateOrder(OrderT o) {
		this.getOrderTDao().updateOrder(o);
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

	public int countfindAllTobeShippedOrders(String orderstate,String paystate,String shippingstate) {
		return this.getOrderTDao().countfindAllTobeShippedOrders(orderstate,paystate,shippingstate);
	}

	public List<OrderT> findAllTobeShippedOrders(int currentPage, int lineSize, String orderstate,String paystate,String shippingstate) {
		return this.getOrderTDao().findAllTobeShippedOrders(currentPage, lineSize, orderstate,paystate,shippingstate);
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
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveNormalOrderNeedInfoBack(OrderT ordert,
			ShippingAddressT sAddressT,List<CartT>cartLists,OrderInvoiceT oit) {
		//生成一个订单号
		String orderid=this.getSerial().Serialid(Serial.ORDER);
		//生成一个同批次购物车号
		String cartid=this.getSerial().Serialid(Serial.CART);
		//加入购物车表
		for(CartT c:cartLists){
			c.setOrderid(orderid);
			c.setCartid(cartid);
			c.setState(StaticKey.CARTSTATE_RELBYORDER_NUM);
			this.getCartTDao().save(c);
		}
		//加入到发货地址表中
		sAddressT.setOrderid(orderid);
		this.getShippingAddressTDao().save(sAddressT);
		//加入订单表
		ordert.setOrderid(orderid);
		this.getOrderTDao().save(ordert);
		//加入订单发票表
		oit.setOrderInvoiceid(this.getSerial().Serialid(Serial.ORDERINVOICE));
		oit.setOrderid(orderid);
		this.getOrderInvoiceTDao().save(oit);
	}



	
	
}
