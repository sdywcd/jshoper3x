package com.jshop.action.frontstage.pay;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.jshop.dao.impl.OrderForAlipayDaoImpl;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class CallBackAlipayOrderAction extends ActionSupport {

	private OrderForAlipayDaoImpl orderdaoimpl = new OrderForAlipayDaoImpl();

	public OrderForAlipayDaoImpl getOrderdaoimpl() {
		return orderdaoimpl;
	}

	public void setOrderdaoimpl(OrderForAlipayDaoImpl orderdaoimpl) {
		this.orderdaoimpl = orderdaoimpl;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();
	}

	public int CallBackToChangeOrderPayState(String orderid, String paystate) {
		int i =this.getOrderdaoimpl().updateOrderPaystateByorderid(orderid, paystate);
		return i;
	}

	public int CallBackToChangeOrderState(String orderid, String orderstate) {
		int i = this.getOrderdaoimpl().updateOrderStateByorderid(orderid, orderstate);
		return i;
	}

	public int CallBackToChangeOrderShippingState(String orderid, String shippingstate) {
		int i = this.getOrderdaoimpl().updateOrderShippingstateByorderid(orderid, shippingstate);
		return i;
	}

	public int CallBackToChangeOrderTradeNo(String tradeno, String orderid) {
		int i = this.getOrderdaoimpl().callBackToChangeOrderTradeNo(tradeno, orderid);
		return i;
	}

}
