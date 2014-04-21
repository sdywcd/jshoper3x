package com.jshop.action.backstage.logistics;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.PrintInvoiceParam;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.entity.CartT;
import com.jshop.entity.InvoicetempleteT;
import com.jshop.entity.OrderT;
import com.jshop.entity.ShippingAddressT;
import com.jshop.service.CartTService;
import com.jshop.service.InvoicetempleteTService;
import com.jshop.service.OrderTService;
import com.jshop.service.ShippingAddressTService;
@Namespace("")
@ParentPackage("jshop")
public class PrintInvoiceSingleTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private OrderTService orderTService;
	private CartTService cartTService;
	private ShippingAddressTService shippingAddressTService;
	private InvoicetempleteTService invoicetempleteTService;
	private String orderid;
	private PrintInvoiceParam pi = new PrintInvoiceParam();
	private List<CartT> ct = new ArrayList<CartT>();
	private List<Map<String, Object>> invoicerows = new ArrayList<Map<String, Object>>();
	private boolean sprintinvoiceflag = false;

	@JSON(serialize = false)
	public OrderTService getOrderTService() {
		return orderTService;
	}

	public void setOrderTService(OrderTService orderTService) {
		this.orderTService = orderTService;
	}
	@JSON(serialize = false)
	public CartTService getCartTService() {
		return cartTService;
	}

	public void setCartTService(CartTService cartTService) {
		this.cartTService = cartTService;
	}
	@JSON(serialize = false)
	public ShippingAddressTService getShippingAddressTService() {
		return shippingAddressTService;
	}

	public void setShippingAddressTService(ShippingAddressTService shippingAddressTService) {
		this.shippingAddressTService = shippingAddressTService;
	}
	@JSON(serialize = false)
	public InvoicetempleteTService getInvoicetempleteTService() {
		return invoicetempleteTService;
	}

	public void setInvoicetempleteTService(InvoicetempleteTService invoicetempleteTService) {
		this.invoicetempleteTService = invoicetempleteTService;
	}

	public List<CartT> getCt() {
		return ct;
	}

	public void setCt(List<CartT> ct) {
		this.ct = ct;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public PrintInvoiceParam getPi() {
		return pi;
	}

	public void setPi(PrintInvoiceParam pi) {
		this.pi = pi;
	}

	public boolean isSprintinvoiceflag() {
		return sprintinvoiceflag;
	}

	public void setSprintinvoiceflag(boolean sprintinvoiceflag) {
		this.sprintinvoiceflag = sprintinvoiceflag;
	}

	public List<Map<String, Object>> getInvoicerows() {
		return invoicerows;
	}

	public void setInvoicerows(List<Map<String, Object>> invoicerows) {
		this.invoicerows = invoicerows;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 显示是否开具发票了
	 * 
	 * @return
	 */
	private String GetChangeHasprintfpinvoice(String hasprintfpinvoice) {
		String temp;
		if (hasprintfpinvoice.equals("1")) {
			temp = "是";
		} else {
			temp = "否";
		}
		return temp;
	}

	private void GetChangeTime(Date t) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh-yy-ss");
		String time = formatter.format(t.getTime()).toString();
		pi.setPurchasetime(time);
	}

	

	/**
	 * 获取订单发货地址
	 * 
	 * @param orderid
	 */
	public void GetOrderShippingAddress(String orderid) {
		ShippingAddressT st = this.getShippingAddressTService().findShippingAddressByOrderid(orderid, "1");
		if (st != null) {
			pi.setShippingusername(st.getShippingusername());
			pi.setCountry(st.getCountry());
			pi.setProvince(st.getProvince());
			pi.setCity(st.getCity());
			pi.setDistrict(st.getDistrict());
			pi.setStreet(st.getStreet());
			pi.setPostcode(st.getPostcode());
		}
	}

	/**
	 * 根据id获取订单详细
	 * 
	 * @param orderid
	 */
	public void GetOrderDetailByOrderId(String orderid) {
		OrderT o = this.getOrderTService().findOrderDetailByorderid(orderid);
		if (o != null) {
			GetChangeTime(Date.valueOf(o.getPurchasetime().toString()));
			pi.setOrderid(o.getOrderid());
			pi.setHasprintfpinvoice(GetChangeHasprintfpinvoice(o.getIsprintfpinvoice()));
			pi.setAmount(String.valueOf(o.getAmount()));
			pi.setShouldpay(String.valueOf(o.getShouldpay()));
			pi.setFreight(String.valueOf(o.getFreight()));
			pi.setInvoicenumber(o.getDeliverynumber());//发货单号
		}
	}

	/**
	 *根据订单id获取购物车中商品数据
	 */
	public void findCartGoodsByOrderid(String orderid) {
		List<CartT> ct = this.getCartTService().findCartGoodsByOrderid(orderid);
		if (ct != null) {
			invoicerows.clear();
			for (Iterator<CartT> it = ct.iterator(); it.hasNext();) {
				CartT c = (CartT) it.next();
				Map<String, Object> cellMap = new HashMap<String, Object>();
				cellMap.put("goodsname", c.getGoodsname());
				cellMap.put("usersetnum", c.getUsersetnum());
				cellMap.put("favorable", c.getFavorable());
				cellMap.put("needquantity", c.getNeedquantity());
				cellMap.put("subtotal", c.getSubtotal());
				invoicerows.add(cellMap);
			}

		}
	}

	/**
	 * 读取发货单模板
	 */
	public void GetPrintInvoiceValue() {
		InvoicetempleteT it = this.getInvoicetempleteTService().findInvoicetempleteByState("1");
		pi.setKindeditorCode(it.getCode());
	}

	/**
	 * 初始化发货单打印
	 * 
	 * @return
	 */
	@Action(value = "InitPrintInvoice", results = { 
			@Result(name = "json",type="json")
	})
	public String InitPrintInvoice() {
		if (Validate.StrNotNull(this.getOrderid())) {
			String orderid = this.getOrderid().trim();
			GetOrderDetailByOrderId(orderid);
			GetOrderShippingAddress(orderid);
			findCartGoodsByOrderid(orderid);
			GetPrintInvoiceValue();
			this.setSprintinvoiceflag(true);
			return "json";
		}
		this.setSprintinvoiceflag(false);
		return "json";
		
	}
}
