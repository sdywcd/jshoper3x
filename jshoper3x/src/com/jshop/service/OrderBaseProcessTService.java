package com.jshop.service;

import java.util.List;

import com.jshop.entity.CartT;
import com.jshop.entity.DeliverAddressT;
import com.jshop.entity.LogisticsBusinessT;
import com.jshop.entity.LogisticsbusinessareaT;
import com.jshop.entity.MemberT;
import com.jshop.entity.OrderT;
import com.jshop.entity.PaymentM;
import com.jshop.entity.ShippingAddressT;

/**
 * 订单生成过程必须调用的方法
 * @author sdywcd
 *
 */
public interface OrderBaseProcessTService {
	/**
	 * 获取当前用户的所有收货地址
	 * @param m
	 * @return
	 */
	public List<DeliverAddressT>getMemberDeliverAddress(MemberT m);
	
	/**
	 * 获取当前可用的物流商信息
	 * @param state
	 * @return
	 */
	public List<LogisticsBusinessT>getLogisticstsBusiness(String state);
	/**
	 * 获取当前可用的支付方式
	 * @param state
	 * @return
	 */
	public List<PaymentM>getPaymentM(String state);
	/**
	 * 获取当前用的购物车信息
	 * @param memberid
	 * @param state
	 * @param orderTag
	 * @return
	 */
	public List<CartT>getMemberCart(String memberid,String state,String orderTag);
	/**
	 * 获取系统默认的物流商
	 * @param visiable
	 * @return
	 */
	public List<LogisticsBusinessT>getDefaultLogisticsBusinessT(String visiable);
	/**
	 * 获取系统默认物流商的全过阶梯运费信息
	 * @param logisticsid
	 * @return
	 */
	public List<LogisticsbusinessareaT>getDefaultLogisticsbusinessareaT(String logisticsid);
	/**
	 * 获取当前选择的支付信息
	 * @param paymentid
	 * @return
	 */
	public PaymentM getSelectedPayMent(String paymentid);
	/**
	 * 获取收货地址信息
	 * @param addressid
	 * @return
	 */
	public DeliverAddressT getDeliverAddress(String addressid);
	/**
	 * 获取订单信息
	 * @param orderid
	 * @return
	 */
	public OrderT getOrder(String orderid);
	/**
	 * 根据收货地址id查询是否有对应的发货地址信息
	 * @param deliveraddressid
	 * @param state
	 * @param orderid
	 * @return
	 */
	public ShippingAddressT getShippingAddress(String deliveraddressid,String state,String orderid);
	/**
	 * 根据订单获取发货地址
	 * @param orderid
	 * @return
	 */
	public List<ShippingAddressT>getShippingAddress(String orderid);
	
}
