package com.jshop.action.backstage.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.Arith;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.enums.BaseEnums.CartGoodstate;
import com.jshop.action.backstage.utils.enums.BaseEnums.DataEffectiveState;
import com.jshop.action.backstage.utils.enums.BaseEnums.DataUsingState;
import com.jshop.action.backstage.utils.enums.BaseEnums.OrderCreateTag;
import com.jshop.action.backstage.utils.enums.BaseEnums.OrderDeliverMode;
import com.jshop.action.backstage.utils.enums.BaseEnums.OrderIsInvoice;
import com.jshop.action.backstage.utils.enums.BaseEnums.OrderPayState;
import com.jshop.action.backstage.utils.enums.BaseEnums.OrderShippingState;
import com.jshop.action.backstage.utils.enums.BaseEnums.OrderState;
import com.jshop.action.backstage.utils.enums.BaseEnums.PrintExpressState;
import com.jshop.action.backstage.utils.enums.BaseEnums.PrintFaPiaoInvoiceState;
import com.jshop.action.backstage.utils.enums.BaseEnums.PrintInvoiceState;
import com.jshop.action.backstage.utils.enums.BaseEnums.ShippingHaveDeliverAddress;
import com.jshop.action.backstage.utils.enums.BaseEnums.ShippingIsOrderState;
import com.jshop.action.backstage.utils.enums.BaseEnums.ShippingIsSend;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.CartT;
import com.jshop.entity.DeliverAddressT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.LogisticsBusinessT;
import com.jshop.entity.MemberT;
import com.jshop.entity.OrderInvoiceT;
import com.jshop.entity.OrderT;
import com.jshop.entity.PaymentM;
import com.jshop.entity.ProductT;
import com.jshop.entity.ShippingAddressT;
import com.jshop.entity.UserT;
import com.jshop.service.CartTService;
import com.jshop.service.DeliverAddressTService;
import com.jshop.service.GoodsTService;
import com.jshop.service.LogisticsBTService;
import com.jshop.service.MemberTService;
import com.jshop.service.OrderTService;
import com.jshop.service.PaymentMService;
import com.jshop.service.ProductTService;
import com.jshop.service.ShippingAddressTService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;
@Namespace("")
@ParentPackage("jshop")
public class OrderTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	@Resource
	private ProductTService productTService;
	@Resource
	private OrderTService orderTService;
	@Resource
	private CartTService cartTService;
	@Resource
	private ShippingAddressTService shippingAddressTService;
	@Resource
	private LogisticsBTService logisticsBTService;
	@Resource
	private GoodsTService goodsTService;
	@Resource
	private PaymentMService paymentMService;
	@Resource
	private DeliverAddressTService deliverAddressTService;
	@Resource
	private MemberTService memberTService;
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
	private String invPayee;//发票抬头
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String productName;
	private Map<String, Object> map = new HashMap<String, Object>();
	private String formatedeliverytime;//格式化的发货时间
	private boolean sucflag;


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

	public List<Map<String,Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String,Object>> rows) {
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

	public String getInvPayee() {
		return invPayee;
	}

	public void setInvPayee(String invPayee) {
		this.invPayee = invPayee;
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
	private void processOrderList(List<OrderT> order) {
		rows.clear();
		for (Iterator<OrderT> it = order.iterator(); it.hasNext();) {
			OrderT o = (OrderT) it.next();
			//订单状态
			o.setOrderstate(OrderState.getName(o.getOrderstate()));
			//支付状态
			o.setPaystate(OrderPayState.getName(o.getPaystate()));
			//配送状态
			o.setShippingstate(OrderShippingState.getName(o.getShippingstate()));
			//订单开票状态
			o.setIsinvoice(OrderIsInvoice.getName(o.getIsinvoice()));
			//配送方式
			o.setDelivermode(OrderDeliverMode.getName(o.getDelivermode()));
			//订单类型
			o.setOrderTag(OrderCreateTag.getName(o.getOrderTag()));
			if(o.getDeliverytime()!=null){
				this.setFormatedeliverytime(BaseTools.formateDbDate(o.getDeliverytime()));
			}else{
				this.setFormatedeliverytime("");
			}
			Map<String,Object> cellMap = new HashMap<String,Object>();
			cellMap.put("id", o.getOrderid());
			cellMap.put("cell", new Object[] {
					o.getShopname(),
					o.getOrderid(),
					"<a id='orderdetial' href='InitOrdersDetail.action?orderid=" + o.getOrderid() + "' name='orderdetail'>" + o.getOrdername() + "</a>",
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
		total = this.orderTService.count(OrderT.class).intValue();
		if(StringUtils.isNotBlank(this.getSortname())&&StringUtils.isNotBlank(this.getSortorder())){
			Order order=null;
			if(StringUtils.equals(this.getSortorder(), StaticKey.ASC)){
				order=Order.asc(this.getSortname());
			}else{
				order=Order.desc(this.getSortname());
			}
			List<OrderT>list=this.orderTService.findByCriteriaByPage(OrderT.class, order, currentPage, lineSize);
			this.processOrderList(list);
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
		Criterion criterion=Restrictions.eq("orderid", orderid);
		Order order=Order.desc("createtime");
		total = this.orderTService.count(OrderT.class, criterion).intValue();
		List<OrderT> list = this.orderTService.findByCriteriaByPage(OrderT.class, criterion, order, currentPage, lineSize);
		this.processOrderList(list);
	}

	/**
	 *根据收货人查询订单数据
	 * 
	 * @param orderid
	 */
	public void findOrderInfoByShippingUsername(String shippingusername) {
		int currentPage = page;
		int lineSize = rp;
		Criterion criterion=Restrictions.eq("shippingusername", shippingusername);
		Order order=Order.desc("createtime");
		total = this.orderTService.count(OrderT.class, criterion).intValue();
		List<OrderT> list = this.orderTService.findByCriteriaByPage(OrderT.class, criterion, order, currentPage, lineSize);
		this.processOrderList(list);
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
		if (StaticKey.SC.equals(this.getQtype())) {
			this.setTotal(0);
			rows.clear();
			this.finddefaultAllOrder();
		} else {
			if (StringUtils.isBlank(this.getQtype())) {
				return JSON;
			} else {
				if (StringUtils.equals("orderid", this.getQtype())) {
					//根据订单id获取订单数据
					this.findOrderInfoByorderid(this.getQuery().trim());
				}
				if (StringUtils.equals("shippingusername", this.getQtype())) {
					//根据收货人查询订单数据
					this.findOrderInfoByShippingUsername(this.getQuery().trim());
				}
			}
		}
		return JSON;
	}

	/**
	 * 获取默认的所有未付款需要发货的即货到付款的普通订单
	 * 
	 * @return
	 */
	@Action(value="findAllTobeShippedOrdersUnpay",results={
			@Result(name="json",type="json")
	})
	public String findAllTobeShippedOrdersUnpay() {
		if (this.getQtype().equals(StaticKey.SC)) {
			this.finddefaultAllUnpayTobeShippedOrder();
		} else {
			if (StringUtils.isBlank(this.getQtype())) {
				return JSON;
			} else {
				return JSON;
			}
		}
		return JSON;
	}
	/**
	 * 获取默认的所有已付款需要发货的普通订单
	 * @return
	 */
	@Action(value="findAllTobeShippedOrdersHavepay",results={
			@Result(name="json",type="json")
	})
	public String findAllTobeShippedOrdersHavepay(){
		if(StaticKey.SC.equals(this.getQtype())){
			this.finddefaultAllHavepayTobeShippedOrder();
		}else{
			if(StringUtils.isBlank(this.getQtype())){
				return JSON;
			}else{
				return JSON;
			}
		}
		return JSON;
	}
	
	/**
	 *获取默认的所有已付款需要发货的普通订单
	 */
	private void finddefaultAllHavepayTobeShippedOrder() {
		int currentPage=page;
		int lineSize=rp;
		//String shippingstate=StaticKey.SHIPPINGSTATE_NOT_DELIVER_ZERO_NUM;//配货中未发货
		//String orderstate=StaticKey.ORDERSTATE_ONE_NUM;//订单状态已确认
		//String paystate=StaticKey.PAYSTATE_ONE_NUM;//付款状态已支付
		String shippingstate=OrderShippingState.ORDERSHIPPINGSTATE_UNDELIVER_GOODS_ZERO_NUM.getState();//配货中未发货
		String orderstate=OrderState.ORDERSTATE_CONFIRMED_ONE_NUM.getState();//订单状态已确认
		String paystate=OrderPayState.ORDERPAYSTATE_HAVEPAY_ONE_NUM.getState();//付款状态已支付
		Map<String, String>params=new HashMap<String,String>();
		params.put("orderstate", orderstate);
		params.put("shippingstate", shippingstate);
		params.put("paystate", paystate);
		Criterion criterion=Restrictions.allEq(params);
		Order order=Order.desc("updatetime");
		total=this.orderTService.count(OrderT.class, criterion).intValue();
		List<OrderT>list=this.orderTService.findByCriteriaByPage(OrderT.class, criterion, order, currentPage, lineSize);
		this.processOrderList(list);
	}

	/**
	 *获取默认的所有未付款需要发货的即货到付款的订单
	 */
	public void finddefaultAllUnpayTobeShippedOrder() {
		int currentPage = page;
		int lineSize = rp;
		//String shippingstate = StaticKey.SHIPPINGSTATE_NOT_DELIVER_ZERO_NUM;//配货中未发货
		//String orderstate=StaticKey.ORDERSTATE_TWO_NUM;//订单状态货到付款
		//String paystate=StaticKey.PAYSTATE_NOT_PAID_ZERO_NUM;//付款状态未付款
		String shippingstate=OrderShippingState.ORDERSHIPPINGSTATE_UNDELIVER_GOODS_ZERO_NUM.getState();//配货中未发货
		String orderstate=OrderState.ORDERSTATE_PAYMENT_AFTER_ARRIVAL_OF_GOODS_TWO_NUM.getState();//订单状态货到付款
		String paystate=OrderPayState.ORDERPAYSTATE_UNPAY_ZERO_NUM.getState();//付款货到付款
		Map<String,String>params=new HashMap<String,String>();
		params.put("shippingstate", shippingstate);
		params.put("orderstate",orderstate);
		params.put("paystate", paystate);
		Criterion criterion=Restrictions.allEq(params);
		Order order=Order.desc("updatetime");
		total = this.orderTService.count(OrderT.class, criterion).intValue();
		List<OrderT> list = this.orderTService.findByCriteriaByPage(OrderT.class, criterion, order, currentPage, lineSize);
		this.processOrderList(list);
	}

	/**
	 * 获取订单详细
	 */
	public void getOrderDetail(String orderid) {
		Criterion criterion=Restrictions.eq("orderid", orderid);
		OrderT o = this.orderTService.findOneByCriteria(OrderT.class, criterion);
		if (o != null) {
			o.setOrderstate(OrderState.getName(o.getOrderstate()));
			o.setPaystate(OrderPayState.getName(o.getPaystate()));
			o.setShippingstate(OrderShippingState.getName(o.getShippingstate()));
			o.setIsinvoice(OrderIsInvoice.getName(o.getIsinvoice()));
			o.setDelivermode(OrderDeliverMode.getName(o.getDelivermode()));
			o.setOrderTag(OrderCreateTag.getName(o.getOrderTag()));
			map.put("orderdetail", o);
			//获取买家信息
			getMemberBuyerInfo(o.getMemberid());
		}
	}

	/**
	 * 获取买家信息
	 * 
	 * @param userid
	 */
	public void getMemberBuyerInfo(String memberid) {
		MemberT memberT = this.memberTService.findByPK(MemberT.class, memberid);
		if (memberT != null) {
			map.put("orderbuyerinfo", memberT);
		}
	}

	/**
	 * 获取订单中的商品列表
	 * 
	 * @param orderid
	 */
	public void getOrderGoodsList(String orderid) {
		Criterion criterion=Restrictions.eq("orderid", orderid);
		List<CartT> list = this.cartTService.findByCriteria(CartT.class, criterion);
		if (list != null) {
			map.put("ordergoods", list);
		}
	}

	/**
	 * 获取订单发货地址
	 * 
	 * @param orderid
	 */
	public void getOrderShippingAddress(String orderid) {
		Criterion criterion=Restrictions.and(Restrictions.eq("orderid", orderid)).add(Restrictions.eq("state", DataEffectiveState.EFFECTIVE.getState()));
		ShippingAddressT st = this.shippingAddressTService.findOneByCriteria(ShippingAddressT.class, criterion);
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
			@Result(name = "success",type="dispatcher",location = "/admin/order/normalorderdetail.jsp?operate=edit"),
			@Result(name = "input",type="dispatcher",location = "/admin/order/normalorderdetail.jsp?operate=error")
	})
	public String InitOrdersDetail() {
		map.clear();
		String orderid = this.getOrderid().trim();
		//获取订单详细
		getOrderDetail(orderid);
		//获取订单中的商品列表
		getOrderGoodsList(orderid);
		//获取发货地址信息
		getOrderShippingAddress(orderid);
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
	public String updateOrderToClose() {
		String orderid = this.getOrderid().trim();
		//String orderstate = AllOrderState.ORDERSTATE_FIVE_NUM;//关闭
		//String paystate = AllOrderState.PAYSTATE_TWO_NUM;//表示关闭订单后的付款状态制空
		//String shippingstate = AllOrderState.SHIPPINGSTATE_TWO_NUM;//表示关闭订单后的发货状态制空
		OrderT order=this.orderTService.findByPK(OrderT.class, orderid);
		if(order!=null){
			String orderstate=OrderState.ORDERSTATE_CLOSE_FIVE_NUM.getState();//订单关闭
			String paystate=OrderPayState.ORDERPAYSTATE_CLOSE_TWO_NUM.getState();//关闭订单后支付状态到关闭
			String shippingstate=OrderShippingState.ORDERSHIPPINGSTATE_CLOSE_TWO_NUM.getState();//关闭订单后发货状态关闭
			order.setOrderstate(orderstate);
			order.setPaystate(paystate);
			order.setShippingstate(shippingstate);
			this.orderTService.update(order);
		}
		return JSON;
	}

	/**
	 * 更新订单到确认状态（当订单被关闭或者货到付款模式需要确认订单）
	 * 
	 * @return
	 */
	@Action(value="UpdateOrderToConfirm",results={
			@Result(name="json",type="json")
	})
	public String updateOrderToConfirm() {
		String orderid = this.getOrderid().trim();
		//String orderstate = AllOrderState.ORDERSTATE_ONE_NUM;//已确认
		//String paystate = AllOrderState.PAYSTATE_ZERO_NUM;//未付款
		//String shippingstate = AllOrderState.SHIPPINGSTATE_ZERO_NUM;//配货，未发货
		OrderT order=this.orderTService.findByPK(OrderT.class, orderid);
		if(order!=null){
			String orderstate=OrderState.ORDERSTATE_CONFIRMED_ONE_NUM.getState();//已确认
			String paystate=OrderPayState.ORDERPAYSTATE_UNPAY_ZERO_NUM.getState();//未付款
			String shippingstate=OrderShippingState.ORDERSHIPPINGSTATE_UNDELIVER_GOODS_ZERO_NUM.getState();//配送未发货
			order.setOrderstate(orderstate);
			order.setPaystate(paystate);
			order.setShippingstate(shippingstate);
			this.orderTService.update(order);
		}
		return JSON;
	}

	/**
	 * 更新订单到发货状态（需要判断订单是否已经付款）
	 * 
	 * @return
	 */
	@Action(value="UpdateOrderToDelivery",results={
			@Result(name="json",type="json")
	})
	public String updateOrderToDelivery() {
		String orderid = this.getOrderid().trim();
		//String orderstate = AllOrderState.ORDERSTATE_THREE_NUM;//等待确认收获
		//String paystate = this.getPaystate().trim();//付款状态
		//String shippingstate = AllOrderState.SHIPPINGSTATE_ONE_NUM;//发货
		OrderT order=this.orderTService.findByPK(OrderT.class, orderid);
		if(order!=null){
			String orderstate=OrderState.ORDERSTATE_WAIT_CONFIRM_RECEIVE_THREE_NUM.getState();//等待确认收获
			String paystate=this.getPaystate().trim();//付款状态
			String shippingstate=OrderShippingState.ORDERSHIPPINGSTATE_HAVE_DELIVER_GOODS_ONE_NUM.getState();//发货
			order.setOrderstate(orderstate);
			order.setPaystate(paystate);
			order.setShippingstate(shippingstate);
			this.orderTService.update(order);
		}
		return JSON;
	}

	/**
	 * 更新订单到付款状态（货到付款使用）
	 * 
	 * @return
	 */
	@Action(value="UpdateOrderToPay",results={
			@Result(name="json",type="json")
	})
	public String updateOrderToPay() {
		String orderid = this.getOrderid().trim();
		//String orderstate = AllOrderState.ORDERSTATE_ONE_NUM;//已确认
		//String paystate = AllOrderState.PAYSTATE_ONE_NUM;//付款
		//String shippingstate = AllOrderState.SHIPPINGSTATE_ZERO_NUM;//未发货，这里需要斟酌
		OrderT order=this.orderTService.findByPK(OrderT.class,orderid);
		if(order!=null){
			String orderstate=OrderState.ORDERSTATE_CONFIRMED_ONE_NUM.getState();
			String paystate=OrderPayState.ORDERPAYSTATE_HAVEPAY_ONE_NUM.getState();
			String shippingstate=OrderShippingState.ORDERSHIPPINGSTATE_UNDELIVER_GOODS_ZERO_NUM.getState();
			order.setOrderstate(orderstate);
			order.setShippingstate(shippingstate);
			order.setPaystate(paystate);
			this.orderTService.update(order);
		}
		return JSON;
	}

	/**
	 *更新订单快递单号
	 * 
	 * @return
	 */
	@Action(value="UpdateExpressnumberByOrderId",results={
			@Result(name="json",type="json")
	})
	public String updateExpressnumberByOrderId() {
		if(StringUtils.isNotBlank(this.getExpressnumber())&&StringUtils.isNotBlank(this.getOrderid())){
			OrderT order=this.orderTService.findByPK(OrderT.class, this.getOrderid());
			if(order!=null){
				//更新快递单号
				order.setExpressnumber(this.getExpressnumber());
				//更新发货状态-->已发货
				order.setShippingstate(OrderShippingState.ORDERSHIPPINGSTATE_HAVE_DELIVER_GOODS_ONE_NUM.getState());
				this.orderTService.update(order);
				this.setSucflag(true);
			}
		}
		return JSON;
	}

	/**
	 * 更新发货单号
	 * 
	 * @return
	 */
	@Action(value="UpdateInvoicenumberByOrderId",results={
			@Result(name="json",type="json")
	})
	public String updateInvoicenumberByOrderId() {
		if(StringUtils.isNotBlank(this.getInvoicenumber())&&StringUtils.isNotBlank(this.getOrderid())){
			OrderT order=this.orderTService.findByPK(OrderT.class, this.getOrderid());
			if(order!=null){
				//发货单号
				order.setDeliverynumber(this.getInvoicenumber());
				//发货时间
				order.setDeliverytime(BaseTools.getSystemTime());
				this.orderTService.update(order);
				this.setSucflag(true);
			}
		}
		return JSON;
	}

	/**
	 * 获取同步发货必要参数
	 * 
	 * @return
	 */
	@Action(value="GetAlipayFhNeedParams",results={
			@Result(name="json",type="json")
	})
	public String getAlipayFhNeedParams() {
		if(StringUtils.isNotBlank(this.getOrderid())){
			OrderT o = this.orderTService.findByPK(OrderT.class, this.getOrderid());
			this.setTradeno(o.getTradeNo());//支付宝交易号
			this.setExpressnumber(o.getExpressnumber());//快递单号，发货单号
			this.setDelivermode(o.getDelivermode());
			this.setPaymentid(o.getPaymentid());
			LogisticsBusinessT lt =this.logisticsBTService.findByPK(LogisticsBusinessT.class, this.getLogisticsid());
			if(lt!=null){
				this.setLogisticsname(lt.getLogisticsname());
			}
			this.setSucflag(true);
		}
		return JSON;
	
	}
	/**
	 * 查询所有已发货的订单
	 * @return
	 */
	@Action(value="findAllhaveshippedOrder",results={
			@Result(name="json",type="json")
	})
	public String findAllhaveshippedOrder(){
		if (StaticKey.SC.equals(this.getQtype())) {
			this.setTotal(0);
			rows.clear();
			this.defaultfindAllhaveshippedOrder();
		} else {
			if (StringUtils.isBlank(this.getQtype())) {
				return JSON;
			} else {	
				return JSON;
			}
		}
		return JSON;	
	}
	/**
	 * 默认查询所有没有条件的已发货订单
	 */
	public void defaultfindAllhaveshippedOrder(){
		int currentPage=page;
		int lineSize=rp;
		String shippingstate=OrderShippingState.ORDERSHIPPINGSTATE_HAVE_DELIVER_GOODS_ONE_NUM.getState();//已发货
		Criterion criterion=Restrictions.eq("shippingstate", shippingstate);
		Order order=Order.desc("createtime");
		total = this.orderTService.count(OrderT.class, criterion).intValue();
		List<OrderT> list =this.orderTService.findByCriteriaByPage(OrderT.class, criterion, order, currentPage, lineSize);
		this.processOrderList(list);
	}
	/**
	 * 查询所有已退货的订单
	 * @return
	 */
	@Action(value="findAllrenturnOrder",results={
			@Result(name="json",type="json")
	})
	public String findAllrenturnOrder(){
		if (StaticKey.SC.equals(this.getQtype())) {
			this.setTotal(0);
			rows.clear();
			this.defaultfindAllreturnOrder();
		} else {
			if (StringUtils.isBlank(this.getQtype())) {
				return JSON;
			}
		}
		return JSON;
	}
	/**
	 * 默认查询所有没有条件的退货订单
	 */
	public void defaultfindAllreturnOrder(){
		int currentPage=page;
		int lineSize=rp;
		String orderstate=OrderState.ORDERSTATE_RETURN_GOODS_FOUR_NUM.getState();//退货
		Criterion criterion=Restrictions.eq("orderstate", orderstate);
		Order order=Order.desc("createtime");
		total = this.orderTService.count(OrderT.class, criterion).intValue();
		List<OrderT> list =this.orderTService.findByCriteriaByPage(OrderT.class, criterion, order, currentPage, lineSize);
		this.processOrderList(list);
	}
	
	
	
	
	
	/**
	 * 初始化普通订单所需数据
	 * @return
	 */
	@Action(value="InitNormalOrderNeedInfoBack",results={
			@Result(name="json",type="json")
	})
	public String InitNormalOrderNeedInfoBack(){
		if(StringUtils.isBlank(this.getProductid())||StringUtils.isBlank(this.getPaymentid())||StringUtils.isBlank(this.getLogisticsid())){
			return JSON;
		}
		//获取管理员id和名称
		UserT usert=(UserT) ActionContext.getContext().getSession().get(StaticKey.BACK_USER_SESSION_KEY);
		String userid=usert.getUserid();
		String username=usert.getUsername();
		
		//获取该购物信息购买者的id和收货人名称
		String memberid=this.getMemberid().trim();
		//获取页面传递过来的会员名称
		String membername=this.getMembername().trim();
		//购物车集合
		List<CartT>cartlists=new ArrayList<CartT>();
		//收集商品数据，加入购物车实体
		List<ProductT>plists=this.collectProductsForCart(this.getProductid().trim());
		for(ProductT p:plists){
			//如果购物车中没有该货物信息,就将货物信息增加到购物车表中(这一步在后端不需要，后端增加订单不存在该货物已经在购物车的情况)
//			CartT cart=this.getCartTService().findProductInCart(memberid, p.getGoodsid(), p.getProductid(),StaticString.CARTSTATE_NEWADDTOCART);
//			if(cart==null){
//			}
			GoodsT g=this.goodsTService.findByPK(GoodsT.class, p.getGoodsid());
			if(g!=null){
				//如果购物车中没有该货物信息，则加入购物车,并标记来自系统订单
				CartT t=new CartT();
				t.setId(this.getSerial().Serialid(Serial.CARTINFO));//购物车的主键
				t.setCartid(StaticKey.EMPTY);//一批货物，在做订单分拆时可以通过这个标记来区分本次购物中需要分拆的货物
				t.setOrderid(StaticKey.EMPTY);//订单id
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
				t.setAddtime(BaseTools.getSystemTime());
				t.setQuantity(p.getStore());//库存
				if(g.getPictureurl()!=null&&g.getPictureurl().length()>0){//处理图片
					t.setPicture(StringUtils.split(g.getPictureurl(),StaticKey.SPLITDOT)[0]);
				}
				t.setPicture(StaticKey.EMPTY);
				t.setUsersetnum(g.getUsersetnum());
				t.setWeight(p.getWeight());
				t.setState(CartGoodstate.NEWADDTOCART_ONE_NUM.getState());//新加入购物车的状态
				t.setHtmlpath(g.getHtmlPath());//货物的静态页沿用商品的静态页
				t.setProductid(p.getProductid());
				t.setOrderTag(OrderCreateTag.ORDERTAG_NORMAL_ONE_NUM.getState());//普通订单
				t.setProductName(p.getProductName());
				t.setCartTag(CartGoodstate.NEWADDTOCART_BACKSTAGE_ZERO_NUM.getState());//从后台加入的购物车
				t.setMemberid(memberid);
				t.setMembername(membername);
				cartlists.add(t);//将购物车信息加入购物车集合
			}
		}
		//收集发货地址信息 
		//通过在会员的deliveraddress表中搜索id获取收货地址信息并加入到shippingaddress表中
		//货发地址实体类
		ShippingAddressT sAddressT=new ShippingAddressT();
		DeliverAddressT deliverAddressTs=new DeliverAddressT();
		deliverAddressTs=this.deliverAddressTService.findByPK(DeliverAddressT.class, this.getHidshippingaddressid());
		if(deliverAddressTs!=null){
			sAddressT.setShippingaddressid(this.getSerial().Serialid(Serial.SHIPPINGADDRESS));
			sAddressT.setMemberid(memberid);
			sAddressT.setShippingusername(deliverAddressTs.getShippingusername());
			sAddressT.setProvince(deliverAddressTs.getProvince());
			sAddressT.setCity(deliverAddressTs.getCity());
			sAddressT.setDistrict(deliverAddressTs.getDistrict());
			sAddressT.setStreet(deliverAddressTs.getStreet());
			sAddressT.setPostcode(deliverAddressTs.getPostcode());
			sAddressT.setTelno(deliverAddressTs.getTelno());
			sAddressT.setMobile(deliverAddressTs.getMobile());
			sAddressT.setEmail(deliverAddressTs.getEmail());
			sAddressT.setCreatetime(BaseTools.getSystemTime());
			sAddressT.setState(ShippingIsOrderState.SHIPPING_BIND_ORDER.getState());//有对应订单的发货地址
			sAddressT.setDeliveraddressid(ShippingHaveDeliverAddress.SHIPPING_UNHAVE_DA_ZERO_NUM.getState());//发货地址没有对应收获地址
			sAddressT.setIssend(ShippingIsSend.SHIPPING_UNSEND.getState());
			sAddressT.setOrderid(StaticKey.EMPTY);
			sAddressT.setCountry(deliverAddressTs.getCountry());
			sAddressT.setShopid(BaseTools.getShopId());//店铺id 未来支持入住模式时启用
		}
		//收集支付方式数据
		PaymentM paymentM=this.paymentMService.findByPK(PaymentM.class, this.getPaymentid().trim());
		//收集物流商数据
		LogisticsBusinessT lBusinessT=this.logisticsBTService.findByPK(LogisticsBusinessT.class, this.getLogisticsid().trim());
		//收集本次购物积分数据，组织ORDERT中PRODUCTINFO 和GOODSINFO字段
		double totalpoints=0.0;//{productid:"",productname:"",goodsid:""}
		String productinfo=null;
		int needquantity=0;
		StringBuffer psbBuffer=new StringBuffer();
		for(CartT c:cartlists){
			totalpoints=Arith.add(totalpoints, Arith.mul(c.getPoints(), Double.parseDouble(String.valueOf(c.getNeedquantity()))));
			productinfo="{\"productid\":\""+c.getProductid()+"\",\"productname\":\""+c.getProductName()+"\",\"goodsid\":\""+c.getGoodsid()+"\"}";
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
		orderT.setDelivermode(OrderDeliverMode.ORDERDELIVERMODE_EXPRESS.getState());//快递
		orderT.setDeliverynumber(StaticKey.ZERO);//默认发货单号是0，在发货单填写过程中输入真正的发货单号
		orderT.setOrderstate(OrderState.ORDERSTATE_UNCONFIRMED_ZERO_NUM.getState());//未确认
		orderT.setLogisticsid(lBusinessT.getLogisticsid());
		orderT.setLogisticsname(lBusinessT.getLogisticsname());
		orderT.setLogisticswebaddress(lBusinessT.getWebsite());//查询快递点信息地址
		orderT.setFreight(this.getFreight());//运费
		orderT.setAmount(Arith.add(this.getAmount(), this.getFreight()));//此处可能有一个抵用券逻辑
		orderT.setPoints(totalpoints);//积分
		orderT.setPurchasetime(BaseTools.getSystemTime());
		orderT.setDeliverytime(null);//目前没有到发货步骤所以设置成null
		orderT.setIsinvoice(this.getIsinvoice().trim());//是否需要开票
		orderT.setShippingaddressid(sAddressT.getShippingaddressid());//获取发货地址id
		orderT.setCustomerordernotes(this.getCustomerordernotes());//会员留的订单备注，后台等于管理员留给物流部的备注
		orderT.setPaytime(null);//支付时间，在获得支付宝回调时更新
		orderT.setOrderTag(this.getOrderTag());//从页面获取订单标记，表示订单来自原那个类型1普通订单 
		orderT.setToBuyerNotes(StaticKey.EMPTY);//管理员给订单所有人的留言
		orderT.setShouldpay(this.getShouldpay());//直接从页面上拿应支付,处理修改订单价格的需求
		orderT.setUsepoints(0.0);//用户如果使用了积分这里可以从页面上拿积分
		orderT.setVouchersid(StaticKey.EMPTY);//后台不需要使用优惠券所以设置成null
		orderT.setProductinfo("["+psbBuffer+"]");//订单中货物信息
		orderT.setNeedquantity(needquantity);//购物车中的货物数量总和
		orderT.setPaystate(OrderPayState.ORDERPAYSTATE_UNPAY_ZERO_NUM.getState());//未付款
		orderT.setShippingstate(OrderShippingState.ORDERSHIPPINGSTATE_UNDELIVER_GOODS_ZERO_NUM.getState());//未发货
		orderT.setDeliveraddressid(sAddressT.getDeliveraddressid());//获取收货地址id 此处0表示改订单的收货地址不在会员的收货地址管理中
		orderT.setShippingusername(sAddressT.getShippingusername());//商户角度来看的收货人，来自于会员的deliveraddress表中或者直接从页面上获取
		orderT.setCreatetime(BaseTools.getSystemTime());
		orderT.setIsprintexpress(PrintExpressState.EXPRESS_NOT_PRINT_ZERO_NUM.getState());
		orderT.setIsprintinvoice(PrintInvoiceState.INVOICE_NOT_PRINT_ZERO_NUM.getState());
		orderT.setIsprintfpinvoice(PrintFaPiaoInvoiceState.FAPIAOINVOICE_NOT_PRINT_ZERO_NUM.getState());
		orderT.setExpressnumber(StaticKey.EMPTY);//快递单号
		orderT.setTradeNo(StaticKey.EMPTY);//支付交易号由第三方提供
		orderT.setUserid(userid);
		orderT.setUsername(username);
		orderT.setErrorOrderTag(StaticKey.ERRORORDERTAG_ZERO_NUM);//订单目前没有错误
		orderT.setVersiont(1);
		orderT.setOrdername(this.getOrdername());
		orderT.setShopid(BaseTools.getShopId());//店铺id 未来支持入住模式时启用
		orderT.setShopname(BaseTools.getShopName());
		if(this.getMemberdelivertime()!=null){
			orderT.setMemberdelivertime(BaseTools.getMemberDeliverTime(this.getMemberdelivertime()));
		}else{
			orderT.setMemberdelivertime(BaseTools.getSystemTime());
			
		}
		//构建订单发票实体
		OrderInvoiceT oit=new OrderInvoiceT();
		oit.setInvType(this.getIsinvoice());
		oit.setInvPayee(this.getInvPayee());
		oit.setAmount(this.getAmount()+StaticKey.EMPTY);
		oit.setMemberid(memberid);
		oit.setState(DataUsingState.USING.getState());
		oit.setMembername(membername);
		oit.setInvContent(StaticKey.EMPTY);
		oit.setCreatetime(BaseTools.getSystemTime());
		oit.setUpdatetime(oit.getCreatetime());
		oit.setVersiont(1);
		this.orderTService.saveNormalOrderNeedInfoBack(orderT, sAddressT, cartlists,oit);
		//调用订单发票逻辑
		this.setSucflag(true);
		return JSON;
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
		String strs[]=StringUtils.split(productid, StaticKey.SPLITDOT);
		for(String s:strs){
			ProductT bean=this.productTService.findByPK(ProductT.class, s);
			if(bean!=null){
				lists.add(bean);
			}
		}
		return lists;
	}
	
	/**
	 * 根据会员名称查询收货地址
	 * @return
	 */
	@Action(value="findDeliverAddressBymemberName",results={
			@Result(name="json",type="json")
	})
	public String findDeliverAddressBymemberName(){
		if(StringUtils.isBlank(this.getMembername())){
			return JSON;
		}
		this.findDefaultMemberDeliverAddress();
		this.setSucflag(true);
		return JSON;
	}
	
	
	
	private void findDefaultMemberDeliverAddress() {
		Criterion criterion=Restrictions.eq("loginname", this.getMembername());
		MemberT member=this.memberTService.findOneByCriteria(MemberT.class, criterion);
		if(member!=null){
			Criterion criterion2=Restrictions.eq("memberid", member.getId());
			List<DeliverAddressT>deliverlists=this.deliverAddressTService.findByCriteria(DeliverAddressT.class, criterion2);
			this.ProcessDeliverAddress(deliverlists);
			total=deliverlists.size();
		}
	}

	private void ProcessDeliverAddress(List<DeliverAddressT> list) {
		for(Iterator<DeliverAddressT> it=list.iterator();it.hasNext();){
			DeliverAddressT dt=(DeliverAddressT) it.next();
			if(dt.getState().equals(StaticKey.DELIVERADDRESSSTATE_ZERO_NUM)){
				dt.setState(StaticKey.DELIVERADDRESSSTATE_ZERO);
			}else{
				dt.setState(StaticKey.DELIVERADDRESSSTATE_ONE);
			}
			Map<String,Object>cellMap=new HashMap<String, Object>();
			cellMap.put("id", dt.getAddressid());
			cellMap.put("cell", new Object[]{
					dt.getShippingusername(),
					dt.getCountry(),
					dt.getProvince(),
					dt.getCity(),
					dt.getDistrict(),
					dt.getStreet(),
					dt.getPostcode(),
					dt.getMobile(),
					dt.getState(),
					dt.getMemberid(),
					BaseTools.formateDbDate(dt.getCreatetime())	
			});
			rows.add(cellMap);
		}
	}
	
	/**
	 * 后台订单新增收货地址
	 * @return
	 */
	@Action(value="saveDeliverAddressbsOrder",results={
			@Result(name="json",type="json")
	})
	public String saveDeliverAddressbsOrder(){
		Criterion criterion=Restrictions.eq("loginname", this.getMembername());
		MemberT member=this.memberTService.findOneByCriteria(MemberT.class, criterion);
		if(member!=null){
			DeliverAddressT dt=new DeliverAddressT();
			dt.setAddressid(this.getSerial().Serialid(Serial.DELIVERADDRESS));
			dt.setMemberid(member.getId());
			dt.setShippingusername(this.getShippingusername().trim());
			dt.setProvince(this.getProvince().trim());
			dt.setCity(this.getCity().trim());
			dt.setDistrict(this.getDistrict().trim());
			dt.setStreet(this.getStreet().trim());
			dt.setPostcode(this.getPostcode().trim());
			dt.setTelno(this.getTelno().trim());
			dt.setMobile(this.getMobile().trim());
			dt.setEmail(this.getEmail().trim());
			dt.setCreatetime(BaseTools.getSystemTime());
			dt.setState(DataUsingState.UNUSING.getState());
			dt.setCountry(this.getCountry().trim());
			this.deliverAddressTService.save(dt);
			this.setSucflag(true);
			return JSON;
		}
		return "json";
		
	}
	

	
}
