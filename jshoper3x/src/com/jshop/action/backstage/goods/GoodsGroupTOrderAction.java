package com.jshop.action.backstage.goods;

import java.util.ArrayList;
import java.util.Date;
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
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.order.AllOrderState;
import com.jshop.entity.GroupCartT;
import com.jshop.entity.GroupOrderT;
import com.jshop.entity.LogisticsBusinessT;
import com.jshop.entity.ShippingAddressT;
import com.jshop.entity.UserT;
import com.jshop.service.GroupCartService;
import com.jshop.service.GroupOrderTService;
import com.jshop.service.LogisticsBusinessTService;
import com.jshop.service.ShippingAddressTService;
import com.jshop.service.UsertService;
import com.opensymphony.xwork2.ActionContext;
@Namespace("")
@ParentPackage("jshop")
public class GoodsGroupTOrderAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private GroupOrderTService groupOrderTService;
	private UsertService usertService;
	private ShippingAddressTService shippingAddressTService;
	private GroupCartService groupCartService;
	private LogisticsBusinessTService logisticsBusinessTService;
	private String orderid;
	private String userid;
	private String username;
	private String paymentid;
	private String paymentname;
	private String delivermode;
	private String deliverynumber;
	private String orderstate;
	private String logisticsid;
	private double freight;
	private double amount;
	private Double points;
	private Date purchasetime;
	private Date deliverytime;
	private String invoice;
	private String shippingaddressid;
	private String customernotes;
	private String logisticswebaddress;
	private Date paytime;
	private String orderTag;
	private String toBuyer;
	private double shouldpay;
	private double usepoints;
	private String vouchersid;
	private String goodid;
	private String goodsname;
	private Integer needquantity;
	private String paystate;
	private String shippingstate;
	private String deliveraddressid;
	private String shippingusername;
	private Date createtime;
	private String hasprintexpress;
	private String hasprintinvoice;
	private String hasprintfpinvoice;
	private String expressnumber;
	private String tradeNo;
	private List<Map<String, Object>> rows= new ArrayList<Map<String, Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String Invoicenumber;
	private String tradeno;
	private String logisticsname;
	private String formatedeliverytime;//格式化的发货时间
	private Map<String, Object> map = new HashMap<String, Object>();
	@JSON(serialize=false)
	public LogisticsBusinessTService getLogisticsBusinessTService() {
		return logisticsBusinessTService;
	}
	public void setLogisticsBusinessTService(
			LogisticsBusinessTService logisticsBusinessTService) {
		this.logisticsBusinessTService = logisticsBusinessTService;
	}
	@JSON(serialize=false)
	public GroupCartService getGroupCartService() {
		return groupCartService;
	}
	public void setGroupCartService(GroupCartService groupCartService) {
		this.groupCartService = groupCartService;
	}
	@JSON(serialize=false)
	public ShippingAddressTService getShippingAddressTService() {
		return shippingAddressTService;
	}
	public void setShippingAddressTService(
			ShippingAddressTService shippingAddressTService) {
		this.shippingAddressTService = shippingAddressTService;
	}
	@JSON(serialize=false)
	public UsertService getUsertService() {
		return usertService;
	}
	public void setUsertService(UsertService usertService) {
		this.usertService = usertService;
	}
	
	public String getTradeno() {
		return tradeno;
	}
	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}
	public String getLogisticsname() {
		return logisticsname;
	}
	public void setLogisticsname(String logisticsname) {
		this.logisticsname = logisticsname;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	@JSON(serialize=false)
	public GroupOrderTService getGroupOrderTService() {
		return groupOrderTService;
	}
	public void setGroupOrderTService(GroupOrderTService groupOrderTService) {
		this.groupOrderTService = groupOrderTService;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}
	public String getPaymentname() {
		return paymentname;
	}
	public void setPaymentname(String paymentname) {
		this.paymentname = paymentname;
	}
	public String getDelivermode() {
		return delivermode;
	}
	public void setDelivermode(String delivermode) {
		this.delivermode = delivermode;
	}
	public String getDeliverynumber() {
		return deliverynumber;
	}
	public void setDeliverynumber(String deliverynumber) {
		this.deliverynumber = deliverynumber;
	}
	public String getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}
	public String getLogisticsid() {
		return logisticsid;
	}
	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
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
	public Double getPoints() {
		return points;
	}
	public void setPoints(Double points) {
		this.points = points;
	}
	public Date getPurchasetime() {
		return purchasetime;
	}
	public void setPurchasetime(Date purchasetime) {
		this.purchasetime = purchasetime;
	}
	public Date getDeliverytime() {
		return deliverytime;
	}
	public void setDeliverytime(Date deliverytime) {
		this.deliverytime = deliverytime;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getShippingaddressid() {
		return shippingaddressid;
	}
	public void setShippingaddressid(String shippingaddressid) {
		this.shippingaddressid = shippingaddressid;
	}
	public String getCustomernotes() {
		return customernotes;
	}
	public void setCustomernotes(String customernotes) {
		this.customernotes = customernotes;
	}
	public String getLogisticswebaddress() {
		return logisticswebaddress;
	}
	public void setLogisticswebaddress(String logisticswebaddress) {
		this.logisticswebaddress = logisticswebaddress;
	}
	public Date getPaytime() {
		return paytime;
	}
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}
	public String getOrderTag() {
		return orderTag;
	}
	public void setOrderTag(String orderTag) {
		this.orderTag = orderTag;
	}
	public String getToBuyer() {
		return toBuyer;
	}
	public void setToBuyer(String toBuyer) {
		this.toBuyer = toBuyer;
	}
	public double getShouldpay() {
		return shouldpay;
	}
	public void setShouldpay(double shouldpay) {
		this.shouldpay = shouldpay;
	}
	public double getUsepoints() {
		return usepoints;
	}
	public void setUsepoints(double usepoints) {
		this.usepoints = usepoints;
	}
	public String getVouchersid() {
		return vouchersid;
	}
	public void setVouchersid(String vouchersid) {
		this.vouchersid = vouchersid;
	}
	public String getGoodid() {
		return goodid;
	}
	public void setGoodid(String goodid) {
		this.goodid = goodid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public Integer getNeedquantity() {
		return needquantity;
	}
	public void setNeedquantity(Integer needquantity) {
		this.needquantity = needquantity;
	}
	public String getPaystate() {
		return paystate;
	}
	public void setPaystate(String paystate) {
		this.paystate = paystate;
	}
	public String getShippingstate() {
		return shippingstate;
	}
	public void setShippingstate(String shippingstate) {
		this.shippingstate = shippingstate;
	}
	public String getDeliveraddressid() {
		return deliveraddressid;
	}
	public void setDeliveraddressid(String deliveraddressid) {
		this.deliveraddressid = deliveraddressid;
	}
	public String getShippingusername() {
		return shippingusername;
	}
	public void setShippingusername(String shippingusername) {
		this.shippingusername = shippingusername;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getHasprintexpress() {
		return hasprintexpress;
	}
	public void setHasprintexpress(String hasprintexpress) {
		this.hasprintexpress = hasprintexpress;
	}
	public String getHasprintinvoice() {
		return hasprintinvoice;
	}
	public void setHasprintinvoice(String hasprintinvoice) {
		this.hasprintinvoice = hasprintinvoice;
	}
	public String getHasprintfpinvoice() {
		return hasprintfpinvoice;
	}
	public void setHasprintfpinvoice(String hasprintfpinvoice) {
		this.hasprintfpinvoice = hasprintfpinvoice;
	}
	public String getExpressnumber() {
		return expressnumber;
	}
	public void setExpressnumber(String expressnumber) {
		this.expressnumber = expressnumber;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
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
	
	public String getInvoicenumber() {
		return Invoicenumber;
	}
	public void setInvoicenumber(String invoicenumber) {
		Invoicenumber = invoicenumber;
	}
	public String getFormatedeliverytime() {
		return formatedeliverytime;
	}
	public void setFormatedeliverytime(String formatedeliverytime) {
		this.formatedeliverytime = formatedeliverytime;
	}
	/**
	 * 迭代显示数据
	 * @param list
	 */
	public void processGroupOrder(List<GroupOrderT> list){
		rows.clear();
		for(Iterator<GroupOrderT> it = list.iterator();it.hasNext();){
			GroupOrderT grouporder = (GroupOrderT) it.next();
			if (grouporder.getOrderstate().equals("0")) {
				grouporder.setOrderstate(AllOrderState.ORDERSTATE_ZERO);
			} else if (grouporder.getOrderstate().equals("1")) {
				grouporder.setOrderstate(AllOrderState.ORDERSTATE_ONE);
			} else if (grouporder.getOrderstate().equals("2")) {
				grouporder.setOrderstate(AllOrderState.ORDERSTATE_TWO);
			} else if (grouporder.getOrderstate().equals("3")) {
				grouporder.setOrderstate(AllOrderState.ORDERSTATE_THREE);
			} else if (grouporder.getOrderstate().equals("4")) {
				grouporder.setOrderstate(AllOrderState.ORDERSTATE_FOUR);
			} else if (grouporder.getOrderstate().equals("5")) {
				grouporder.setOrderstate(AllOrderState.ORDERSTATE_FIVE);
			} else if (grouporder.getOrderstate().equals("6")) {
				grouporder.setOrderstate(AllOrderState.ORDERSTATE_SIX);
			} else if (grouporder.getOrderstate().equals("7")) {
				grouporder.setOrderstate(AllOrderState.ORDERSTATE_SEVEN);
			} else if (grouporder.getOrderstate().equals("8")) {
				grouporder.setOrderstate(AllOrderState.ORDERSTATE_EIGHT);
			} else {
				grouporder.setOrderstate(AllOrderState.ORDERSTATE_NINE);
			}

			if (grouporder.getPaystate().equals("0")) {
				grouporder.setPaystate(AllOrderState.PAYSTATE_ZERO);
			} else if (grouporder.getPaystate().equals("1")) {
				grouporder.setPaystate(AllOrderState.PAYSTATE_ONE);
			} else {
				grouporder.setPaystate(AllOrderState.PAYSTATE_TWO);
			}

			if (grouporder.getShippingstate().equals("0")) {
				grouporder.setShippingstate(AllOrderState.SHIPPINGSTATE_ZERO);
			} else if (grouporder.getShippingstate().equals("1")) {
				grouporder.setShippingstate(AllOrderState.SHIPPINGSTATE_ONE);
			} else {
				grouporder.setShippingstate(AllOrderState.SHIPPINGSTATE_TWO);
			}

			if (grouporder.getInvoice().equals("0")) {
				grouporder.setInvoice(AllOrderState.INVOICE_ZERO);
			} else {
				grouporder.setInvoice(AllOrderState.INVOICE_ONE);
			}
			if (grouporder.getDelivermode().equals("EXPRESS")) {
				grouporder.setDelivermode(AllOrderState.EXPRESS);
			} else if (grouporder.getDelivermode().equals("POST")) {
				grouporder.setDelivermode(AllOrderState.POST);
			} else {
				grouporder.setDelivermode(AllOrderState.EMS);
			}
			if (grouporder.getOrderTag().equals("1")) {
				grouporder.setOrderTag(AllOrderState.ORDERTAG_ONE);
			} else if (grouporder.getOrderTag().equals("2")) {
				grouporder.setOrderTag(AllOrderState.ORDERTAG_TWO);
			}
			if(grouporder.getDeliverytime()!=null){
				this.setFormatedeliverytime(BaseTools.formateDbDate(grouporder.getDeliverytime()));
			}else{
				this.setFormatedeliverytime("");
			}
			Map<String,Object> cellmap=new HashMap<String,Object>();
			cellmap.put("id", grouporder.getOrderid());
			cellmap.put("cell",new Object[]{
					grouporder.getOrderid(),
					"<a id='orderdetial' target='_blank' href='InitgroupOrdersDetail?orderid=" + grouporder.getOrderid() + "'   name='orderdetail'>" + grouporder.getGoodsname() + "</a>",
					
					grouporder.getAmount(),
					grouporder.getNeedquantity(), 
					grouporder.getUsername(), 
					grouporder.getShippingusername(), 
					grouporder.getPaymentname(), 
					grouporder.getDelivermode(), 
					grouporder.getOrderstate(), 
					grouporder.getPaystate(), 
					grouporder.getShippingstate(), 
					BaseTools.formateDbDate(grouporder.getPurchasetime()),  
					grouporder.getInvoice(), 
					grouporder.getOrderTag() 
			});
			
			rows.add(cellmap);
			}
	}
	/**]
	 * 查询默认所有的订单
	 */
	public void  finddefaultGroupOrder(){
		int currentPage = page;
		int lineSize= rp;

//		total = this.getGroupOrderTService().countAllGroupOrder();
//		if(Validate.StrNotNull(sortname)&& Validate.StrNotNull(sortorder)){
//			String queryString ="from GroupOrderT order by "+ sortname +" "+ sortorder +"";
//			List<GroupOrderT> order = this.getGroupOrderTService().sortAllGroupOrder(currentPage, lineSize, queryString);
//			if(order!=null){
//				this.processGroupOrder(order);
//			}
//		}

		total = this.getGroupOrderTService().countfindAllGroupOrderT();
		if(Validate.StrNotNull(getSortname())&& Validate.StrNotNull(getSortorder())){
			String queryString ="from GroupOrderT order by "+ getSortname() +" "+ getSortorder() +"";
			List<GroupOrderT> order = this.getGroupOrderTService().sortAllGroupOrderT(currentPage, lineSize, queryString);
			if(order!=null){
				this.processGroupOrder(order);
			}
		}

	}
	/**
	 * 查询所有团购订单信息
	 * @return
	 */
	@Action(value="findAllGroupOrder",results={@Result(name="json",type="json")})

	public String  findAllGroupOrder(){
		if ("sc".equals(this.getQtype())) {
			this.setTotal(0);
			rows.clear();
			this.finddefaultGroupOrder();
		}
		return "json";
	}
	/**
	 * 获取订单详细
	 */
	public void GetGroupOrderDetail(String orderid) {
		GroupOrderT o = this.getGroupOrderTService().findgroupOrderDetailByorderid(orderid);
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

			if (o.getInvoice().equals("0")) {
				o.setInvoice(AllOrderState.INVOICE_ZERO);
			} else {
				o.setInvoice(AllOrderState.INVOICE_ONE);
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
	 * 获取订单发货地址
	 * 
	 * @param orderid
	 */
	public void GetgroupOrderShippingAddress(String orderid) {
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
	@Action(value = "InitgroupOrdersDetail", results = { 
			@Result(name = "success",type="dispatcher",location = "/jshop/admin/order/grouporderdetail.jsp?session=${usession}"),
			@Result(name = "input",type="dispatcher",location = "/jshop/admin/order/grouporderdetail.jsp?session=${usession}")
	})
	public String InitgroupOrdersDetail() {
		map.clear();
		String orderid = this.getOrderid().trim();
		//获取订单详细
		GetGroupOrderDetail(orderid);
		//获取订单中的商品列表
		GetGroupOrderGoodsList(orderid);
		//获取发货地址信息
		GetgroupOrderShippingAddress(orderid);
		ActionContext.getContext().put("order", map);
		return SUCCESS;
	}
	/**
	 * 获取订单中的商品列表
	 * 
	 * @param orderid
	 */
	public void GetGroupOrderGoodsList(String orderid) {
		List<GroupCartT> list = this.getGroupCartService().findGroupCartGoodsByOrderid(orderid);
		if (list != null) {
			map.put("ordergoods", list);
		}
	}
	/**
	 * 更新订单到关闭状态
	 * 
	 * @return
	 */
	@Action(value="UpdateGroupOrderToClose",results={
			@Result(name="json",type="json")
	})
	public String UpdateGroupOrderToClose() {
		String orderid = this.getOrderid().trim();
		String orderstate = AllOrderState.ORDERSTATE_FIVE_NUM;//关闭
		String paystate = AllOrderState.PAYSTATE_TWO_NUM;//表示关闭订单后的付款状态制空
		String shippingstate = AllOrderState.SHIPPINGSTATE_TWO_NUM;//表示关闭订单后的发货状态制空
		this.getGroupOrderTService().updateGroupOrderPayShippingState(orderid, orderstate, paystate, shippingstate);
		//InitOrdersDetail();
		return "json";
	}
	/**
	 * 更新订单到确认状态（当订单被关闭或者货到付款模式需要确认订单）
	 * 
	 * @return
	 */
	@Action(value="UpdateGroupOrderToConfirm",results={
			@Result(name="json",type="json")
	})
	public String UpdateGroupOrderToConfirm() {
		String orderid = this.getOrderid().trim();
		String orderstate = AllOrderState.ORDERSTATE_ONE_NUM;//已确认
		String paystate = AllOrderState.PAYSTATE_ZERO_NUM;//未付款
		String shippingstate = AllOrderState.SHIPPINGSTATE_ZERO_NUM;//配货，未发货
		int i = this.getGroupOrderTService().updateGroupOrderPayShippingState(orderid, orderstate, paystate, shippingstate);
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
		int i = this.getGroupOrderTService().updateGroupOrderPayShippingState(orderid, orderstate, paystate, shippingstate);
		//InitOrdersDetail();
		return "json";
	}
	/**
	 * 更新订单到付款状态（货到付款使用）
	 * 
	 * @return
	 */
	@Action(value="UpdateGroupOrderToPay",results={
			@Result(name="json",type="json")
	})
	public String UpdateGroupOrderToPay() {
		String orderid = this.getOrderid().trim();
		String orderstate = AllOrderState.ORDERSTATE_ONE_NUM;//已确认
		String paystate = AllOrderState.PAYSTATE_ONE_NUM;//付款
		String shippingstate = AllOrderState.SHIPPINGSTATE_ONE_NUM;//发货
		int i = this.getGroupOrderTService().updateGroupOrderPayShippingState(orderid, orderstate, paystate, shippingstate);
		//InitOrdersDetail();
		return "json";
	}
	/**
	 *更新订单快递单号
	 * 
	 * @return
	 */
	@Action(value="UpdateExpressnumberByGroupOrderId",results={
			@Result(name="json",type="json")
	})
	public String UpdateExpressnumberByGroupOrderId() {
		if (Validate.StrNotNull(this.getExpressnumber())&&Validate.StrNotNull(this.getOrderid())) {
			int i = this.getGroupOrderTService().updateExpressnumberByGroupOrderId(this.getOrderid().trim(), this.getExpressnumber().trim());
			return "json";
		}
		return "json";		
	}
	/**
	 * 更新发货单号
	 * 
	 * @return
	 */
	@Action(value="UpdateInvoicenumberByGroupOrderId",results={
			@Result(name="json",type="json")
	})
	public String UpdateInvoicenumberByGroupOrderId() {
		if (Validate.StrNotNull(this.getInvoicenumber())&&Validate.StrNotNull(this.getOrderid())) {
			int i = this.getGroupOrderTService().updateInvoicenumberByOrderId(this.getOrderid().trim(), this.getInvoicenumber().trim(), BaseTools.systemtime());
			return "json";
		}
		return "json";

	}
	/**
	 * 获取同步发货必要参数
	 * 
	 * @return
	 */
	@Action(value="GetAlipayFhNeedParamsGroup",results={
			@Result(name="json",type="json")
	})
	public String GetAlipayFhNeedParamsGroup() {
		GroupOrderT o = this.getGroupOrderTService().findgroupOrderDetailByorderid(this.getOrderid().trim());
		this.setTradeno(o.getTradeNo());//支付宝交易号
		this.setExpressnumber(o.getExpressnumber());//快递单号，发货单号
		this.setDelivermode(o.getDelivermode());
		this.setPaymentid(o.getPaymentid());
		LogisticsBusinessT lt = this.getLogisticsBusinessTService().findLogisticsBusinessById(o.getLogisticsid());
		this.setLogisticsname(lt.getLogisticsname());
		return "json";
	}
	
}
