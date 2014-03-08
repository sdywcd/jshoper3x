package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.OrderInvoiceTDao;
import com.jshop.dao.impl.OrderInvoiceTDaoImpl;
import com.jshop.entity.OrderInvoiceT;
import com.jshop.service.OrderInvoiceTService;

@Service("orderInvoiceTService")
@Scope("prototype")
public class OrderInvoiceTServiceImpl extends BaseTServiceImpl<OrderInvoiceT>implements OrderInvoiceTService {
	@Resource
	private OrderInvoiceTDao orderInvoiceTDao;

	public OrderInvoiceTDao getOrderInvoiceTDao() {
		return orderInvoiceTDao;
	}

	public void setOrderInvoiceTDao(OrderInvoiceTDao orderInvoiceTDao) {
		this.orderInvoiceTDao = orderInvoiceTDao;
	}

	public int delOrderInvoice(String[] list) {
		return this.getOrderInvoiceTDao().delOrderInvoice(list);
	}

	public int updateOrderInvoiceState(String[] orderinvoiceid, String state) {
		return this.getOrderInvoiceTDao().updateOrderInvoiceState(orderinvoiceid, state);
	}


	public int countfindAllOrderIvoice() {
		return this.getOrderInvoiceTDao().countfindAllOrderIvoice();
	}

	public List<OrderInvoiceT> findAllOrderIvoice(int currentPage, int lineSize) {
		return this.getOrderInvoiceTDao().findAllOrderIvoice(currentPage, lineSize);
	}
}
