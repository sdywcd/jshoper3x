package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.CartTDao;
import com.jshop.dao.DeliverAddressTDao;
import com.jshop.dao.LogisticsBusinessTDao;
import com.jshop.dao.LogisticsbusinessareaTDao;
import com.jshop.dao.OrderTDao;
import com.jshop.dao.PaymentMDao;
import com.jshop.dao.ShippingAddressTDao;
import com.jshop.entity.CartT;
import com.jshop.entity.DeliverAddressT;
import com.jshop.entity.LogisticsBusinessT;
import com.jshop.entity.LogisticsbusinessareaT;
import com.jshop.entity.MemberT;
import com.jshop.entity.OrderT;
import com.jshop.entity.PaymentM;
import com.jshop.entity.ShippingAddressT;
import com.jshop.service.OrderBaseProcessTService;
@Service("orderBaseProcessTService")
@Scope("prototype")
public class OrderBaseProcessTServiceImpl implements OrderBaseProcessTService {
	@Resource
	private DeliverAddressTDao deliverAddressTDao;
	@Resource
	private LogisticsBusinessTDao logisticsBusinessTDao;
	@Resource
	private PaymentMDao paymentMDao;
	@Resource
	private CartTDao cartTDao;
	@Resource
	private LogisticsbusinessareaTDao logisticsbusinessareaTDao;
	@Resource
	private OrderTDao orderTDao;
	@Resource
	private ShippingAddressTDao shippingAddressTDao;
	@Override
	public List<DeliverAddressT> getMemberDeliverAddress(MemberT m) {
		return deliverAddressTDao.findDeliverAddressBymemberid(m.getId());
	}


	@Override
	public List<LogisticsBusinessT> getLogisticstsBusiness(String state) {
		return logisticsBusinessTDao.findAllLogisticsBusiness(state);
	}


	@Override
	public List<PaymentM> getPaymentM(String state) {
		return paymentMDao.findAllPayment(state);
	}


	@Override
	public List<CartT> getMemberCart(String memberid, String state,
			String orderTag) {
		return cartTDao.findAllCartByMemberId(memberid, state, orderTag);
	}


	@Override
	public List<LogisticsBusinessT> getDefaultLogisticsBusinessT(String visible) {
		return logisticsBusinessTDao.findLogisticsBusiness(visible);
	}


	@Override
	public List<LogisticsbusinessareaT> getDefaultLogisticsbusinessareaT(
			String logisticsid) {
		return logisticsbusinessareaTDao.findAllLogisticsbusinessareaTBylogisticsid(logisticsid);
	}


	@Override
	public PaymentM getSelectedPayMent(String paymentid) {
		return paymentMDao.findPaymentbyId(paymentid);
	}


	@Override
	public DeliverAddressT getDeliverAddress(String addressid) {
		return deliverAddressTDao.findDeliverAddressById(addressid);
	}


	@Override
	public OrderT getOrder(String orderid) {
		return orderTDao.findOrderDetailByorderid(orderid);
	}


	@Override
	public ShippingAddressT getShippingAddress(String deliveraddressid,
			String state, String orderid) {
		return shippingAddressTDao.findShippingAddressByDeliveraddressidAndstate(deliveraddressid, state, orderid).get(0);
	}


	@Override
	public List<ShippingAddressT> getShippingAddress(String orderid) {
		return shippingAddressTDao.findShippingAddressByOrderId(orderid);
	}


	

}
