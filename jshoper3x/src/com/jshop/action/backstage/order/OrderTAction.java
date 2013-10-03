package com.jshop.action.backstage.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.tools.AllOrderState;
import com.jshop.action.backstage.tools.Arith;
import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.StaticString;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.CartT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.LogisticsBusinessT;
import com.jshop.entity.OrderT;
import com.jshop.entity.PaymentM;
import com.jshop.entity.ProductT;
import com.jshop.entity.ShippingAddressT;
import com.jshop.entity.UserT;
import com.jshop.service.CartTService;
import com.jshop.service.DeliverAddressTService;
import com.jshop.service.GoodsTService;
import com.jshop.service.LogisticsBusinessTService;
import com.jshop.service.OrderTService;
import com.jshop.service.PaymentMService;
import com.jshop.service.ProductTService;
import com.jshop.service.ShippingAddressTService;
import com.jshop.service.UsertService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class OrderTAction extends ActionSupport {
	private Serial serial;
	private ProductTService productTService;
	private OrderTService orderTService;
	private UsertService usertService;
	private CartTService cartTService;
	private ShippingAddressTService shippingAddressTService;
	private LogisticsBusinessTService logisticsBusinessTService;
	private GoodsTService goodsTService;
	private PaymentMService paymentMService;
	private DeliverAddressTService deliverAddressTService;
	private String orderid;
	private String expressnumber;
	private String invoicenumber;
	private String paystate;
	private String query;
	private String qtype;
	private String tradeno;
	private String logisticsname;
	private String delivermode;
	private String paymentid; 
	private String productid;
	private String memberid;
	private String membername;
	private String shippingusername;
	private String province;
	private String city;
	private String district;
	private String street;
	private String postcode;
	private String telno;
	private String mobile;
	private String email;
	private String country;
	private String logisticsid;
	private double freight;
	private double amount;
	private String isinvoice;
	private String customerordernotes;
	private String orderTag;
	private double shouldpay;
	private String hidshippingaddressid;//隐藏的发货地址id
	private String ordername;
	private String memberdelivertime;//会员指定的送货日期
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String sortname;
	private String sortorder;
	private String productName;
	private Map<String, Object> map = new HashMap<String, Object>();
	private boolean slogin = false;
	private String usession;
	private String formatedeliverytime;//格式化的发货时间
	private boolean sucflag;
	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	@JSON(serialize = false)
	public DeliverAddressTService getDeliverAddressTService() {
		return deliverAddressTService;
	}

	public void setDeliverAddressTService(
			DeliverAddressTService deliverAddressTService) {
		this.deliverAddressTService = deliverAddressTService;
	}

	@JSON(serialize = false)
	public PaymentMService getPaymentMService() {
		return paymentMService;
	}

	public void setPaymentMService(PaymentMService paymentMService) {
		this.paymentMService = paymentMService;
	}

	@JSON(serialize = false)
	public GoodsTService getGoodsTService() {
		return goodsTService;
	}

	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}

	@JSON(serialize = false)
	public ProductTService getProductTService() {
		return productTService;
	}

	public void setProductTService(ProductTService productTService) {
		this.productTService = productTService;
	}

	@JSON(serialize = false)
	public OrderTService getOrderTService() {
		return orderTService;
	}

	public void setOrderTService(OrderTService orderTService) {
		this.orderTService = orderTService;
	}
	@JSON(serialize = false)
	public UsertService getUsertService() {
		return usertService;
	}

	public void setUsertService(UsertService usertService) {
		this.usertService = usertService;
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
	public LogisticsBusinessTService getLogisticsBusinessTService() {
		return logisticsBusinessTService;
	}

	public void setLogisticsBusinessTService(LogisticsBusinessTService logisticsBusinessTService) {
		this.logisticsBusinessTService = logisticsBusinessTService;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	@JSON(name = "rows")
	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public String getPaystate() {
		return paystate;
	}

	public void setPaystate(String paystate) {
		this.paystate = paystate;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

	public String getDelivermode() {
		return delivermode;
	}

	public void setDelivermode(String delivermode) {
		this.delivermode = delivermode;
	}

	public String getLogisticsname() {
		return logisticsname;
	}

	public void setLogisticsname(String logisticsname) {
		this.logisticsname = logisticsname;
	}

	public String getTradeno() {
		return tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public String getExpressnumber() {
		return expressnumber;
	}

	public void setExpressnumber(String expressnumber) {
		this.expressnumber = expressnumber;
	}

	public String getInvoicenumber() {
		return invoicenumber;
	}

	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	public String getUsession() {
		return usession;
	}

	public void setUsession(String usession) {
		this.usession = usession;
	}

	public String getFormatedeliverytime() {
		return formatedeliverytime;
	}

	public void setFormatedeliverytime(String formatedeliverytime) {
		this.formatedeliverytime = formatedeliverytime;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLogisticsid() {
		return logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getIsinvoice() {
		return isinvoice;
	}

	public void setIsinvoice(String isinvoice) {
		this.isinvoice = isinvoice;
	}

	public String getCustomerordernotes() {
		return customerordernotes;
	}

	public void setCustomerordernotes(String customerordernotes) {
		this.customerordernotes = customerordernotes;
	}

	public String getOrderTag() {
		return orderTag;
	}

	public void setOrderTag(String orderTag) {
		this.orderTag = orderTag;
	}

	public double getShouldpay() {
		return shouldpay;
	}

	public void setShouldpay(double shouldpay) {
		this.shouldpay = shouldpay;
	}

	public String getShippingusername() {
		return shippingusername;
	}

	public void setShippingusername(String shippingusername) {
		this.shippingusername = shippingusername;
	}

	public String getHidshippingaddressid() {
		return hidshippingaddressid;
	}

	public void setHidshippingaddressid(String hidshippingaddressid) {
		this.hidshippingaddressid = hidshippingaddressid;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getMemberdelivertime() {
		return memberdelivertime;
	}

	public void setMemberdelivertime(String memberdelivertime) {
		this.memberdelivertime = memberdelivertime;
	}

	@Override
	public void validate() {
		this.clearErrorsAndMessages();
	}

	

	/**
	 * 处理订单迭代
	 * 
	 * @param order
	 */
	@SuppressWarnings("unchecked")
	public void ProcessOrderList(List<OrderT> order) {
		rows.clear();
		for (Iterator it = order.iterator(); it.hasNext();) {
			OrderT o = (OrderT) it.next();
			if (o.getOrderstate().equals("0")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_ZERO);
			} else if (o.getOrderstate().equals("1")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_ONE);
			} else if (o.getOrderstate().equals("2")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_TWO);
			} else if (o.getOrderstate().equals("3")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_THREE);
			} else if (o.getOrderstate().equals("4")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_FOUR);
			} else if (o.getOrderstate().equals("5")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_FIVE);
			} else if (o.getOrderstate().equals("6")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_SIX);
			} else if (o.getOrderstate().equals("7")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_SEVEN);
			} else if (o.getOrderstate().equals("8")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_EIGHT);
			} else {
				o.setOrderstate(AllOrderState.ORDERSTATE_NINE);
			}

			if (o.getPaystate().equals("0")) {
				o.setPaystate(AllOrderState.PAYSTATE_ZERO);
			} else if (o.getPaystate().equals("1")) {
				o.setPaystate(AllOrderState.PAYSTATE_ONE);
			} else {
				o.setPaystate(AllOrderState.PAYSTATE_TWO);
			}

			if (o.getShippingstate().equals("0")) {
				o.setShippingstate(AllOrderState.SHIPPINGSTATE_ZERO);
			} else if (o.getShippingstate().equals("1")) {
				o.setShippingstate(AllOrderState.SHIPPINGSTATE_ONE);
			} else {
				o.setShippingstate(AllOrderState.SHIPPINGSTATE_TWO);
			}

			if (o.getIsinvoice().equals("0")) {
				o.setIsinvoice(AllOrderState.INVOICE_ZERO);
			} else {
				o.setIsinvoice(AllOrderState.INVOICE_ONE);
			}
			if (o.getDelivermode().equals("EXPRESS")) {
				o.setDelivermode(AllOrderState.EXPRESS);
			} else if (o.getDelivermode().equals("POST")) {
				o.setDelivermode(AllOrderState.POST);
			} else {
				o.setDelivermode(AllOrderState.EMS);
			}
			if (o.getOrderTag().equals("1")) {
				o.setOrderTag(AllOrderState.ORDERTAG_ONE);
			} else if (o.getOrderTag().equals("2")) {
				o.setOrderTag(AllOrderState.ORDERTAG_TWO);
			}
			if(o.getDeliverytime()!=null){
				this.setFormatedeliverytime(BaseTools.formateDbDate(o.getDeliverytime()));
			}else{
				this.setFormatedeliverytime("");
			}
			Map cellMap = new HashMap();
			cellMap.put("id", o.getOrderid());
			cellMap.put("cell", new Object[] {
					o.getOrderid(),
					"<a id='orderdetial' href='InitOrdersDetail.action?orderid=" + o.getOrderid() + "' name='orderdetail'>" + o.getProductinfo() + "</a>",
					
					o.getAmount(), 
					o.getNeedquantity(), 
					o.getMembername(), 
					o.getShippingusername(), 
					o.getPaymentname(), 
					o.getDelivermode(), 
					o.getOrderstate(), 
					o.getPaystate(), 
					o.getShippingstate(), 
					BaseTools.formateDbDate(o.getPurchasetime()), 
					this.getFormatedeliverytime(), 
					o.getOrderTag(),
					o.getIsinvoice() });
			rows.add(cellMap);
		}
	}

	/**
	 *查询所有订单没有任何检索条件
	 */
	public void finddefaultAllOrder() {
		int currentPage = page;
		int lineSize = rp;
		total = this.getOrderTService().countfindAllOrderT();
		if (Validate.StrNotNull(sortname) && Validate.StrNotNull(sortorder)) {
			String queryString = "from OrderT order by " + sortname + " " + sortorder + "";
			List<OrderT> order = this.getOrderTService().sortAllOrderT(currentPage, lineSize, queryString);
			if (order != null) {
				this.ProcessOrderList(order);
			}
		}
	}

	/**
	 * 根据订单编号查询订单
	 * 
	 * @param orderid
	 */
	public void findOrderInfoByorderid(String orderid) {
		int currentPage = page;
		int lineSize = rp;
		total = this.getOrderTService().countfindOrderbyOrderid(orderid);
		List<OrderT> order = this.getOrderTService().findOrderByOrderid(currentPage, lineSize, orderid);
		if (order != null) {
			this.ProcessOrderList(order);
		}
	}

	/**
	 *根据收货人查询订单数据
	 * 
	 * @param orderid
	 */
	public void findOrderInfoByShippingUsername(String shippingusername) {
		int currentPage = page;
		int lineSize = rp;
		total = this.getOrderTService().countfindOrderByShippingUsername(shippingusername);
		List<OrderT> order = this.getOrderTService().findOrderByOrderid(currentPage, lineSize, orderid);
		if (order != null) {
			this.ProcessOrderList(order);
		}
	}

	/**
	 * 查询所有订单
	 * 
	 * @return
	 */
	
	@Action(value="findAllOrders",results={
			@Result(name="json",type="json")
	})
	public String findAllOrders() {
		if ("sc".equals(this.getQtype())) {
			this.setTotal(0);
			rows.clear();
			this.finddefaultAllOrder();
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {
				if ("orderid".equals(this.getQtype())) {
					//根据订单id获取订单数据
					this.findOrderInfoByorderid(this.getQuery().trim());
				}
				if ("shippingusername".equals(this.getQtype())) {
					//根据收货人查询订单数据
					this.findOrderInfoByShippingUsername(this.getQuery().trim());
				}
			}
		}
		return "json";
	}

	/**
	 * 获取待发货订单
	 * 
	 * @return
	 */
	@Action(value="findAllTobeShippedOrders",results={
			@Result(name="json",type="json")
	})
	public String findAllTobeShippedOrders() {
		if (this.getQtype().equals("sc")) {
			this.setTotal(0);
			rows.clear();
			this.finddefaultAllTobeShippedOrder();
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {
				return "json";
			}
		}
		return "json";
	}

	/**
	 *获取默认的所有待发货订单
	 */
	public void finddefaultAllTobeShippedOrder() {
		int currentPage = page;
		int lineSize = rp;
		String shippingstate = "0";//未发货状态
		total = this.getOrderTService().countfindAllTobeShippedOrders(shippingstate);
		List<OrderT> order = this.getOrderTService().findAllTobeShippedOrders(currentPage, lineSize, shippingstate);
		if (order != null) {
			this.ProcessOrderList(order);
		}
	}

	/**
	 * 获取订单详细
	 */
	public void GetOrderDetail(String orderid) {
		OrderT o = this.getOrderTService().findOrderDetailByorderid(orderid);
		if (o != null) {
			if (o.getOrderstate().equals("0")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_ZERO);
			} else if (o.getOrderstate().equals("1")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_ONE);
			} else if (o.getOrderstate().equals("2")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_TWO);
			} else if (o.getOrderstate().equals("3")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_THREE);
			} else if (o.getOrderstate().equals("4")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_FOUR);
			} else if (o.getOrderstate().equals("5")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_FIVE);
			} else if (o.getOrderstate().equals("6")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_SIX);
			} else if (o.getOrderstate().equals("7")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_SEVEN);
			} else if (o.getOrderstate().equals("8")) {
				o.setOrderstate(AllOrderState.ORDERSTATE_EIGHT);
			} else {
				o.setOrderstate(AllOrderState.ORDERSTATE_NINE);
			}

			if (o.getPaystate().equals("0")) {
				o.setPaystate(AllOrderState.PAYSTATE_ZERO);
			} else if (o.getPaystate().equals("1")) {
				o.setPaystate(AllOrderState.PAYSTATE_ONE);
			} else {
				o.setPaystate(AllOrderState.PAYSTATE_TWO);
			}

			if (o.getShippingstate().equals("0")) {
				o.setShippingstate(AllOrderState.SHIPPINGSTATE_ZERO);
			} else if (o.getShippingstate().equals("1")) {
				o.setShippingstate(AllOrderState.SHIPPINGSTATE_ONE);
			} else {
				o.setShippingstate(AllOrderState.SHIPPINGSTATE_TWO);
			}

			if (o.getIsinvoice().equals("0")) {
				o.setIsinvoice(AllOrderState.INVOICE_ZERO);
			} else {
				o.setIsinvoice(AllOrderState.INVOICE_ONE);
			}
			if (o.getDelivermode().equals("EXPRESS")) {
				o.setDelivermode(AllOrderState.EXPRESS);
			} else if (o.getDelivermode().equals("POST")) {
				o.setDelivermode(AllOrderState.POST);
			} else {
				o.setDelivermode(AllOrderState.EMS);
			}
			if (o.getOrderTag().equals("1")) {
				o.setOrderTag(AllOrderState.ORDERTAG_ONE);
			} else if (o.getOrderTag().equals("2")) {
				o.setOrderTag(AllOrderState.ORDERTAG_TWO);
			}

			map.put("orderdetail", o);

			//获取买家信息
			GetUserBuyerInfo(o.getUserid());
		}
	}

	/**
	 * 获取买家信息
	 * 
	 * @param userid
	 */
	public void GetUserBuyerInfo(String userid) {
		UserT user = this.getUsertService().findById(userid);
		if (user != null) {
			map.put("orderbuyerinfo", user);
		}
	}

	/**
	 * 获取订单中的商品列表
	 * 
	 * @param orderid
	 */
	public void GetOrderGoodsList(String orderid) {
		List<CartT> list = this.getCartTService().findCartGoodsByOrderid(orderid);
		if (list != null) {
			map.put("ordergoods", list);
		}
	}

	/**
	 * 获取订单发货地址
	 * 
	 * @param orderid
	 */
	public void GetOrderShippingAddress(String orderid) {
		ShippingAddressT st = this.getShippingAddressTService().findShippingAddressByOrderid(orderid, "1");
		if (st != null) {
			map.put("shipping", st);
		}
	}

	/**
	 * 获取订单详细信息
	 * 
	 * @return
	 */
	@Action(value = "InitOrdersDetail", results = { 
			@Result(name = "success",type="dispatcher",location = "/admin/order/ordersdetail.jsp?operate=find"),
			@Result(name = "input",type="dispatcher",location = "/admin/order/ordersdetail.jsp?operate=error")
	})
	public String InitOrdersDetail() {
		map.clear();
		String orderid = this.getOrderid().trim();
		//获取订单详细
		GetOrderDetail(orderid);
		//获取订单中的商品列表
		GetOrderGoodsList(orderid);
		//获取发货地址信息
		GetOrderShippingAddress(orderid);
		ActionContext.getContext().put("order", map);
		return SUCCESS;
	}

	/**
	 * 更新订单到关闭状态
	 * 
	 * @return
	 */
	@Action(value="UpdateOrderToClose",results={
			@Result(name="json",type="json")
	})
	public String UpdateOrderToClose() {
		String orderid = this.getOrderid().trim();
		String orderstate = AllOrderState.ORDERSTATE_FIVE_NUM;//关闭
		String paystate = AllOrderState.PAYSTATE_TWO_NUM;//表示关闭订单后的付款状态制空
		String shippingstate = AllOrderState.SHIPPINGSTATE_TWO_NUM;//表示关闭订单后的发货状态制空
		this.getOrderTService().updateOrderPayShippingState(orderid, orderstate, paystate, shippingstate);
		//InitOrdersDetail();
		return "json";
	}

	/**
	 * 更新订单到确认状态（当订单被关闭或者货到付款模式需要确认订单）
	 * 
	 * @return
	 */
	@Action(value="UpdateOrderToConfirm",results={
			@Result(name="json",type="json")
	})
	public String UpdateOrderToConfirm() {
		String orderid = this.getOrderid().trim();
		String orderstate = AllOrderState.ORDERSTATE_ONE_NUM;//已确认
		String paystate = AllOrderState.PAYSTATE_ZERO_NUM;//未付款
		String shippingstate = AllOrderState.SHIPPINGSTATE_ZERO_NUM;//配货，未发货
		int i = this.getOrderTService().updateOrderPayShippingState(orderid, orderstate, paystate, shippingstate);
		//InitOrdersDetail();
		return "json";
	}

	/**
	 * 更新订单到发货状态（需要判断订单是否已经付款）
	 * 
	 * @return
	 */
	@Action(value="UpdateOrderToDelivery",results={
			@Result(name="json",type="json")
	})
	public String UpdateOrderToDelivery() {
		String orderid = this.getOrderid().trim();
		String orderstate = AllOrderState.ORDERSTATE_THREE_NUM;//等待确认收获
		String paystate = this.getPaystate().trim();//付款状态
		String shippingstate = AllOrderState.SHIPPINGSTATE_ONE_NUM;//发货
		int i = this.getOrderTService().updateOrderPayShippingState(orderid, orderstate, paystate, shippingstate);
		//InitOrdersDetail();
		return "json";
	}

	/**
	 * 更新订单到付款状态（货到付款使用）
	 * 
	 * @return
	 */
	@Action(value="UpdateOrderToPay",results={
			@Result(name="json",type="json")
	})
	public String UpdateOrderToPay() {
		String orderid = this.getOrderid().trim();
		String orderstate = AllOrderState.ORDERSTATE_ONE_NUM;//已确认
		String paystate = AllOrderState.PAYSTATE_ONE_NUM;//付款
		String shippingstate = AllOrderState.SHIPPINGSTATE_ONE_NUM;//发货
		int i = this.getOrderTService().updateOrderPayShippingState(orderid, orderstate, paystate, shippingstate);
		//InitOrdersDetail();
		return "json";
	}

	/**
	 *更新订单快递单号
	 * 
	 * @return
	 */
	@Action(value="UpdateExpressnumberByOrderId",results={
			@Result(name="json",type="json")
	})
	public String UpdateExpressnumberByOrderId() {
		if (Validate.StrNotNull(this.getExpressnumber())&&Validate.StrNotNull(this.getOrderid())) {
			int i = this.getOrderTService().updateExpressnumberByOrderId(this.getOrderid().trim(), this.getExpressnumber().trim());
			return "json";
		}
		return "json";
	
	}

	/**
	 * 更新发货单号
	 * 
	 * @return
	 */
	@Action(value="UpdateInvoicenumberByOrderId",results={
			@Result(name="json",type="json")
	})
	public String UpdateInvoicenumberByOrderId() {
		if (Validate.StrNotNull(this.getInvoicenumber())&&Validate.StrNotNull(this.getOrderid())) {
			int i = this.getOrderTService().updateInvoicenumberByOrderId(this.getOrderid().trim(), this.getInvoicenumber().trim(), BaseTools.systemtime());
			return "json";
		}
		return "json";

	}

	/**
	 * 获取同步发货必要参数
	 * 
	 * @return
	 */
	@Action(value="GetAlipayFhNeedParams",results={
			@Result(name="json",type="json")
	})
	public String GetAlipayFhNeedParams() {
		OrderT o = this.getOrderTService().findOrderDetailByorderid(this.getOrderid().trim());
		this.setTradeno(o.getTradeNo());//支付宝交易号
		this.setExpressnumber(o.getExpressnumber());//快递单号，发货单号
		this.setDelivermode(o.getDelivermode());
		this.setPaymentid(o.getPaymentid());
		LogisticsBusinessT lt = this.getLogisticsBusinessTService().findLogisticsBusinessById(o.getLogisticsid());
		this.setLogisticsname(lt.getLogisticsname());
		return "json";
	}
	/**
	 * 查询所有已发货的订单
	 * @return
	 */
	@Action(value="findAllhaveshippedOrder",results={
			@Result(name="json",type="json")
	})
	public String findAllhaveshippedOrder(){
		if ("sc".equals(this.getQtype())) {
			this.setTotal(0);
			rows.clear();
			this.defaultfindAllhaveshippedOrder();
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {	
				return "json";
			}
		}
		return "json";	
	}
	/**
	 * 默认查询所有没有条件的已发货订单
	 */
	public void defaultfindAllhaveshippedOrder(){
		int currentPage=page;
		int lineSize=rp;
		String shippingstate="1";
		total = this.getOrderTService().countAllhaveshippedOrder(shippingstate);
		List<OrderT> order =this.getOrderTService().findAllhaveshippedOrder(currentPage, lineSize, shippingstate);
		if(order!=null){
			this.ProcessOrderList(order);
		}
	}
	/**
	 * 查询所有已退货的订单
	 * @return
	 */
	@Action(value="findAllrenturnOrder",results={
			@Result(name="json",type="json")
	})
	public String findAllrenturnOrder(){
		if ("sc".equals(this.getQtype())) {
			this.setTotal(0);
			rows.clear();
			this.defaultfindAllreturnOrder();
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {				
			}
		}
		return "json";
	}
	/**
	 * 默认查询所有没有条件的退货订单
	 */
	public void defaultfindAllreturnOrder(){
		int currentPage=page;
		int lineSize=rp;
		String orderstate="4";
		total = this.getOrderTService().countAllreturnOrder(orderstate);
		List<OrderT> order =this.getOrderTService().findAllreturnOrder(currentPage, lineSize, orderstate);
		if(order!=null){
			this.ProcessOrderList(order);
		}
	}
	
	
	
	
	
	/**
	 * 初始化普通订单所需数据
	 * @return
	 */
	public String InitNormalOrderNeedInfoBack(){
		if(StringUtils.isBlank(this.getProductid())||StringUtils.isBlank(this.getPaymentid())||StringUtils.isBlank(this.getLogisticsid())){
			return "json";
		}
		//获取管理员id和名称
		UserT usert=(UserT) ActionContext.getContext().getSession().get(StaticString.BACK_USER_SESSION_KEY);
		String userid=usert.getUserid();
		String username=usert.getUsername();
		
		//获取该购物信息购买者的id和收货人名称
		String memberid=this.getMemberid().trim();
		String shippingusername=this.getMembername().trim();
		//购物车集合
		List<CartT>cartlists=new ArrayList<CartT>();
		//收集商品数据，加入购物车实体
		List<ProductT>plists=this.collectProductsForCart(this.getProductid().trim());
		for(ProductT p:plists){
			//如果购物车中没有该货物信息,就将货物信息增加到购物车表中(这一步在后端不需要，后端增加订单不存在该货物已经在购物车的情况)
//			CartT cart=this.getCartTService().findProductInCart(memberid, p.getGoodsid(), p.getProductid(),StaticString.CARTSTATE_NEWADDTOCART);
//			if(cart==null){
//			}
			GoodsT g=this.getGoodsTService().findGoodsById(p.getGoodsid());
			if(g!=null){
				//如果购物车中没有该货物信息，则加入购物车,并标记来自系统订单
				CartT t=new CartT();
				t.setId(this.getSerial().Serialid(Serial.CARTINFO));//购物车的主键
				t.setCartid(null);//一批货物，在做订单分拆时可以通过这个标记来区分本次购物中需要分拆的货物
				t.setOrderid(null);//订单id
				t.setGoodsid(p.getGoodsid());
				t.setGoodsname(p.getProductName());
				t.setUserid(userid);//当前管理员id
				t.setUsername(username);//当前管理员名称
				t.setNeedquantity(1);//后台默认购买数量为1
				t.setPrice(p.getPrice());
				t.setFavorable(p.getMemberprice());
				t.setChangeprice(Math.abs(p.getPrice()-p.getMemberprice()));
				t.setPoints(g.getPoints());//设置商品积分等于会员价 且可以通过aop进行全局控制
				t.setSubtotal(1.00*p.getMemberprice());//价格小计
				t.setAddtime(BaseTools.systemtime());
				t.setQuantity(p.getStore());//库存
				t.setPicture(StringUtils.split(g.getPictureurl(),",")[0]);
				t.setUsersetnum(g.getUsersetnum());
				t.setWeight(p.getWeight());
				t.setState(StaticString.CARTSTATE_NEWADDTOCART);//新加入购物车的状态
				t.setHtmlpath(g.getHtmlPath());//货物的静态页沿用商品的静态页
				t.setProductid(p.getProductid());
				t.setOrderTag(StaticString.CART_ORDER_TAG_NORMALPRODUCT);
				t.setProductName(p.getProductName());
				t.setCartTag(StaticString.CARTTAG_PRODUCTFROM);
				t.setMemberid(memberid);
				t.setMembername(membername);
				cartlists.add(t);//将购物车信息加入购物车集合
			}
		}
		//收集发货地址信息 后台增加发货地址不在从deliveraddress去获取而是直接从页面上获取并增加到shippingaddress
		//货发地址实体类
		ShippingAddressT sAddressT=new ShippingAddressT();
		sAddressT.setShippingaddressid(this.getSerial().Serialid(Serial.SHIPPINGADDRESS));
		sAddressT.setMemberid(memberid);
		sAddressT.setShippingusername(shippingusername);
		sAddressT.setProvince(this.getProvince().trim());
		sAddressT.setCity(this.getCity().trim());
		sAddressT.setDistrict(this.getDistrict().trim());
		sAddressT.setStreet(this.getStreet().trim());
		sAddressT.setPostcode(this.getPostcode().trim());
		sAddressT.setTelno(this.getTelno().trim());
		sAddressT.setMobile(this.getMobile().trim());
		sAddressT.setEmail(this.getEmail().trim());
		sAddressT.setCreatetime(BaseTools.systemtime());
		sAddressT.setState(StaticString.SHIPPINGSTATE_HAVEORDER);//有对应订单的发货地址
		sAddressT.setDeliveraddressid(StaticString.SHIPPINGADDRESS_DELIVERADDRESSID);
		sAddressT.setIssend(StaticString.SHIPPINGISSEND_NOSEND);
		sAddressT.setOrderid(null);
		sAddressT.setCountry(this.getCountry().trim());
		sAddressT.setShopid(null);//店铺id 未来支持入住模式时启用
		//收集支付方式数据
		PaymentM paymentM=this.getPaymentMService().findPaymentbyId(this.getPaymentid().trim());
		//收集物流商数据
		LogisticsBusinessT lBusinessT=this.getLogisticsBusinessTService().findLogisticsBusinessById(this.getLogisticsid().trim());
		//收集本次购物积分数据，组织ORDERT中PRODUCTINFO 和GOODSINFO字段
		double totalpoints=0.0;//{productid:"",productname:"",goodsid:""}
		String productinfo=null;
		int needquantity=0;
		StringBuffer psbBuffer=new StringBuffer();
		for(CartT c:cartlists){
			totalpoints=Arith.add(totalpoints, Arith.mul(c.getPoints(), Double.parseDouble(String.valueOf(c.getNeedquantity()))));
			productinfo="{productid:"+c.getProductid()+",productname:"+c.getProductName()+",goodsid:"+c.getGoodsid()+"}";
			psbBuffer.append(productinfo).append(",");
			needquantity+=c.getNeedquantity();
		}
		psbBuffer.substring(0, psbBuffer.length()-1);
		
		//收集订单数据
		OrderT orderT=new OrderT();
		orderT.setMemberid(memberid);
		orderT.setMembername(membername);
		orderT.setPaymentid(paymentM.getPaymentid());
		orderT.setPaymentname(paymentM.getPaymentname());
		orderT.setDelivermode(StaticString.DELIVERMODE_EXPRESS);//快递
		orderT.setDeliverynumber(StaticString.ZERO);//默认发货单号是0，在发货单填写过程中输入真正的发货单号
		orderT.setOrderstate(StaticString.ORDERSTATE_ZERO_NUM);//未确认
		orderT.setLogisticsid(lBusinessT.getLogisticsid());
		orderT.setLogisticsname(lBusinessT.getLogisticsname());
		orderT.setLogisticswebaddress(lBusinessT.getWebsite());//查询快递点信息地址
		orderT.setFreight(this.getFreight());//运费
		orderT.setAmount(Arith.add(this.getAmount(), this.getFreight()));//此处可能有一个抵用券逻辑
		orderT.setPoints(totalpoints);//积分
		orderT.setPurchasetime(BaseTools.systemtime());
		orderT.setDeliverytime(null);//目前没有到发货步骤所以设置成null
		orderT.setIsinvoice(this.getIsinvoice().trim());//是否需要开票
		orderT.setShippingaddressid(sAddressT.getShippingaddressid());//获取发货地址id
		orderT.setCustomerordernotes(this.getCustomerordernotes());//会员留的订单备注，后台等于管理员留给物流部的备注
		orderT.setPaytime(null);//支付时间，在获得支付宝回调时更新
		orderT.setOrderTag(this.getOrderTag());//从页面获取订单标记，表示订单来自原那个类型1普通订单 
		orderT.setToBuyerNotes(null);//管理员给订单所有人的留言
		orderT.setShouldpay(this.getShouldpay());//直接从页面上拿应支付,处理修改订单价格的需求
		orderT.setUsepoints(0.0);//用户如果使用了积分这里可以从页面上拿积分
		orderT.setVouchersid(null);//后台不需要使用优惠券所以设置成null
		orderT.setProductinfo("["+psbBuffer+"]");//订单中货物信息
		orderT.setNeedquantity(needquantity);//购物车中的货物数量总和
		orderT.setPaystate(StaticString.PAYSTATE_ZERO_NUM);//未付款
		orderT.setShippingstate(StaticString.SHIPPINGSTATE_ZERO_NUM);//未发货
		orderT.setDeliveraddressid(sAddressT.getDeliveraddressid());//获取收货地址id 此处0表示改订单的收货地址不在会员的收货地址管理中
		orderT.setShippingusername(sAddressT.getShippingusername());//商户角度来看的收货人，来自于会员的deliveraddress表中或者直接从页面上获取
		orderT.setCreatetime(BaseTools.systemtime());
		orderT.setIsprintexpress(StaticString.ISPRINTEXPRESS_ZERO_NUM);
		orderT.setIsprintinvoice(StaticString.ISPRINTINVOICE_ZERO_NUM);
		orderT.setIsprintfpinvoice(StaticString.ISPRINTFPINVOICE_ZERO_NUM);
		orderT.setExpressnumber(null);//快递单号
		orderT.setTradeNo(null);//支付交易号由第三方提供
		orderT.setUserid(userid);
		orderT.setUsername(username);
		orderT.setErrorOrderTag(StaticString.ERRORORDERTAG_ZERO_NUM);//订单目前没有错误
		orderT.setVersiont(1);
		orderT.setOrdername(this.getOrdername());
		orderT.setShopid(null);//店铺id 未来支持入住模式时启用
		orderT.setMemberdelivertime(BaseTools.getMemberDeliverTime(this.getMemberdelivertime()));
		this.getOrderTService().saveNormalOrderNeedInfoBack(orderT, sAddressT, cartlists);
		this.setSucflag(true);
		return "json";
	}
	
	/**
	 * 开始对支付宝支付接口进行参数设置
	 */
	private void BuildAlipayConfig(){
		
	}
	
	
	/**
	 * 收集货物信息加入到购物车
	 * @param productid
	 * @return
	 */
	private List<ProductT>collectProductsForCart(String productid){
		
		List<ProductT>lists=new ArrayList<ProductT>();
		String strs[]=StringUtils.split(productid, ",");
		for(String s:strs){
			ProductT bean=this.getProductTService().findProductByProductid(s);
			if(bean!=null){
				lists.add(bean);
			}
		}
		return lists;
	}
	

	
}
