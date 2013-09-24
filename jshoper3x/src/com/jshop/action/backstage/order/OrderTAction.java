package com.jshop.action.backstage.order;

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
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.tools.AllOrderState;
import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.CartT;
import com.jshop.entity.LogisticsBusinessT;
import com.jshop.entity.OrderT;
import com.jshop.entity.ShippingAddressT;
import com.jshop.entity.UserT;
import com.jshop.service.CartTService;
import com.jshop.service.LogisticsBusinessTService;
import com.jshop.service.OrderTService;
import com.jshop.service.ShippingAddressTService;
import com.jshop.service.UsertService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class OrderTAction extends ActionSupport {
	private OrderTService orderTService;
	private UsertService usertService;
	private CartTService cartTService;
	private ShippingAddressTService shippingAddressTService;
	private LogisticsBusinessTService logisticsBusinessTService;
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
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String sortname;
	private String sortorder;
	Map<String, Object> map = new HashMap<String, Object>();
	private boolean slogin = false;
	private String usession;
	private String formatedeliverytime;//格式化的发货时间
	
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
					"<a id='orderdetial' href='InitOrdersDetail.action?orderid=" + o.getOrderid() + "' name='orderdetail'>" + o.getGoodsname() + "</a>",
					
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
	
}
