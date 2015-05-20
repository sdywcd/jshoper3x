package com.jshop.action.mall.backstage.goods;

import java.util.ArrayList;
import java.util.Date;
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

import com.jshop.action.mall.backstage.base.BaseTAction;
import com.jshop.action.mall.backstage.utils.BaseTools;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.CartGoodstate;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.OrderCreateTag;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.OrderDeliverMode;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.OrderIsInvoice;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.OrderPayState;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.OrderShippingState;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.OrderState;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.ShippingIsOrderState;
import com.jshop.action.mall.backstage.utils.statickey.StaticKey;
import com.jshop.entity.CartGroupT;
import com.jshop.entity.LogisticsBusinessT;
import com.jshop.entity.MemberT;
import com.jshop.entity.OrderGroupT;
import com.jshop.entity.ShippingAddressT;
import com.jshop.service.CartGroupTService;
import com.jshop.service.LogisticsBTService;
import com.jshop.service.MemberTService;
import com.jshop.service.OrderGroupTService;
import com.jshop.service.ShippingAddressTService;
import com.opensymphony.xwork2.ActionContext;
@Namespace("")
@ParentPackage("jshop")
public class GoodsGroupTOrderAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	@Resource
	private OrderGroupTService orderGroupTService;
	@Resource
	private MemberTService memberTService;
	@Resource
	private ShippingAddressTService shippingAddressTService;
	@Resource
	private CartGroupTService cartGroupTService;
	@Resource
	private LogisticsBTService logisticsBTService;
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
	private boolean sucflag;
	
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
	
	
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	/**
	 * 迭代显示数据
	 * @param list
	 */
	public void processGroupOrder(List<OrderGroupT> list){
		rows.clear();
		for(Iterator<OrderGroupT> it = list.iterator();it.hasNext();){
			OrderGroupT gt =it.next();
			gt.setOrderstate(OrderState.getName(gt.getOrderstate()));
			gt.setPaystate(OrderPayState.getName(gt.getPaystate()));
			gt.setShippingstate(OrderShippingState.getName(gt.getShippingstate()));
			gt.setIsinvoice(OrderIsInvoice.getName(gt.getIsinvoice()));
			gt.setDelivermode(OrderDeliverMode.getName(gt.getDelivermode()));
			gt.setOrderTag(OrderCreateTag.getName(gt.getOrderTag()));
			if(gt.getDeliverytime()!=null){
				this.setFormatedeliverytime(BaseTools.formateDbDate(gt.getDeliverytime()));
			}else{
				this.setFormatedeliverytime(StaticKey.EMPTY);
			}
			Map<String,Object> cellmap=new HashMap<String,Object>();
			cellmap.put("id", gt.getOrderid());
			cellmap.put("cell",new Object[]{
					gt.getOrderid(),
					"<a id='orderdetial' target='_blank' href='InitgtsDetail?orderid=" + gt.getOrderid() + "'   name='orderdetail'>" + gt.getOrdername() + "</a>",
					gt.getAmount(),
					gt.getNeedquantity(), 
					gt.getUsername(), 
					gt.getShippingusername(), 
					gt.getPaymentname(), 
					gt.getDelivermode(), 
					gt.getOrderstate(), 
					gt.getPaystate(),
					gt.getShippingstate(), 
					BaseTools.formateDbDate(gt.getPurchasetime()),  
					gt.getIsinvoice(), 
					gt.getOrderTag() 
			});
			rows.add(cellmap);
			}
	}
	/**
	 * 查询默认所有的订单
	 */
	public void  finddefaultGroupOrder(){
		int currentPage = page;
		int lineSize= rp;
		total = this.orderGroupTService.count(OrderGroupT.class).intValue();
		if(StringUtils.isNotBlank(this.getSortname())&&StringUtils.isNotBlank(this.getSortorder())){
			Order order=null;
			if(StringUtils.equals(this.getSortorder(), StaticKey.ASC)){
				order=Order.asc(this.getSortname());
			}else{
				order=Order.desc(this.getSortname());
			}
			List<OrderGroupT>list=this.orderGroupTService.findByCriteriaByPage(OrderGroupT.class, order, currentPage, lineSize);
			this.processGroupOrder(list);
		}
	}
	/**
	 * 查询所有团购订单信息
	 * @return
	 */
	@Action(value="findAllGroupOrder",results={@Result(name="json",type="json")})
	public String  findAllGroupOrder(){
		if (StaticKey.SC.equals(this.getQtype())) {
			this.setTotal(0);
			rows.clear();
			this.finddefaultGroupOrder();
		}
		return JSON;
	}
	/**
	 * 获取订单详细
	 */
	public void GetGroupOrderDetail(String orderid) {
		OrderGroupT o = this.orderGroupTService.findByPK(OrderGroupT.class, orderid);
		o.setOrderstate(OrderState.getName(o.getOrderstate()));
		o.setPaystate(OrderPayState.getName(o.getPaystate()));
		o.setShippingstate(OrderShippingState.getName(o.getShippingstate()));
		o.setIsinvoice(OrderIsInvoice.getName(o.getIsinvoice()));
		o.setDelivermode(OrderDeliverMode.getName(o.getDelivermode()));
		o.setOrderTag(OrderCreateTag.getName(o.getOrderTag()));
		map.put("orderdetail", o);
		//获取买家信息
		getBuyerInfo(o.getMemberid());
	}
	/**
	 * 获取买家信息
	 * 
	 * @param userid
	 */
	public void getBuyerInfo(String memberid) {
		MemberT memberT = this.memberTService.findByPK(MemberT.class, memberid);
		if (memberT != null) {
			map.put("orderbuyerinfo", memberT);
		}
	}
	/**
	 * 获取订单发货地址
	 * 
	 * @param orderid
	 */
	public void getgroupOrderShippingAddress(String orderid) {
		Criterion criterion=Restrictions.and(Restrictions.eq("orderid", orderid)).add(Restrictions.eq("state", ShippingIsOrderState.SHIPPING_BIND_ORDER.getState()));
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
		getGroupOrderGoodsList(orderid);
		//获取发货地址信息
		getgroupOrderShippingAddress(orderid);
		ActionContext.getContext().put("order", map);
		return SUCCESS;
	}
	/**
	 * 获取订单中的商品列表
	 * 
	 * @param orderid
	 */
	public void getGroupOrderGoodsList(String orderid) {
		Criterion criterion=Restrictions.and(Restrictions.eq("orderid", orderid)).add(Restrictions.eq("state", CartGoodstate.HAVE_ADDTOCART_THREE_NUM.getState()));
		List<CartGroupT> list = this.cartGroupTService.findByCriteria(CartGroupT.class, criterion);
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
		//String orderstate = AllOrderState.ORDERSTATE_FIVE_NUM;//关闭
		//String paystate = AllOrderState.PAYSTATE_TWO_NUM;//表示关闭订单后的付款状态制空
		//String shippingstate = AllOrderState.SHIPPINGSTATE_TWO_NUM;//表示关闭订单后的发货状态制空
		OrderGroupT got=this.orderGroupTService.findByPK(OrderGroupT.class, orderid);
		if(got!=null){
			String orderstate=OrderState.ORDERSTATE_CLOSE_FIVE_NUM.getState();//关闭
			String paystate=OrderPayState.ORDERPAYSTATE_CLOSE_TWO_NUM.getState();
			String shippingstate=OrderShippingState.ORDERSHIPPINGSTATE_CLOSE_TWO_NUM.getState();
			got.setOrderstate(orderstate);
			got.setPaystate(paystate);
			got.setShippingstate(shippingstate);
			this.orderGroupTService.update(got);
			this.setSucflag(true);
		}
		return JSON;
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
		//String orderstate = AllOrderState.ORDERSTATE_ONE_NUM;//已确认
		//String paystate = AllOrderState.PAYSTATE_ZERO_NUM;//未付款
		//String shippingstate = AllOrderState.SHIPPINGSTATE_ZERO_NUM;//配货，未发货
		OrderGroupT got=this.orderGroupTService.findByPK(OrderGroupT.class, orderid);
		if(got!=null){
			String orderstate=OrderState.ORDERSTATE_CONFIRMED_ONE_NUM.getState();//已确认
			String paystate=OrderPayState.ORDERPAYSTATE_UNPAY_ZERO_NUM.getState();//未付款
			String shippingstate=OrderShippingState.ORDERSHIPPINGSTATE_UNDELIVER_GOODS_ZERO_NUM.getState();//配货中
			got.setOrderstate(orderstate);
			got.setPaystate(paystate);
			got.setShippingstate(shippingstate);
			this.setSucflag(true);
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
	public String UpdateOrderToDelivery() {
		String orderid = this.getOrderid().trim();
		//String orderstate = AllOrderState.ORDERSTATE_THREE_NUM;//等待确认收获
		//String paystate = this.getPaystate().trim();//付款状态
		//String shippingstate = AllOrderState.SHIPPINGSTATE_ONE_NUM;//发货
		OrderGroupT got=this.orderGroupTService.findByPK(OrderGroupT.class, orderid);
		if(got!=null){
			String orderstate=OrderState.ORDERSTATE_WAIT_CONFIRM_RECEIVE_THREE_NUM.getState();//等待确认收获
			String paystate=this.getPaystate().trim();//付款状态
			String shippingstate=OrderShippingState.ORDERSHIPPINGSTATE_HAVE_DELIVER_GOODS_ONE_NUM.getState();//发货
			got.setOrderstate(orderstate);
			got.setPaystate(paystate);
			got.setShippingstate(shippingstate);
			this.orderGroupTService.update(got);
			this.setSucflag(true);
		}
		return JSON;
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
		//String orderstate = AllOrderState.ORDERSTATE_ONE_NUM;//已确认
		//String paystate = AllOrderState.PAYSTATE_ONE_NUM;//付款
		//String shippingstate = AllOrderState.SHIPPINGSTATE_ONE_NUM;//发货
		OrderGroupT got=this.orderGroupTService.findByPK(OrderGroupT.class, orderid);
		if(got!=null){
			String orderstate=OrderState.ORDERSTATE_CONFIRMED_ONE_NUM.getState();//已确认
			String paystate=OrderPayState.ORDERPAYSTATE_HAVEPAY_ONE_NUM.getState();//付款
			String shippingstate=OrderShippingState.ORDERSHIPPINGSTATE_HAVE_DELIVER_GOODS_ONE_NUM.getState();//发货
			got.setOrderstate(orderstate);
			got.setPaystate(paystate);
			got.setShippingstate(shippingstate);
			this.orderGroupTService.update(got);
			this.setSucflag(true);
		}
		return JSON;
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
		if(StringUtils.isNotBlank(this.getExpressnumber())&&StringUtils.isNotBlank(this.getOrderid())){
			OrderGroupT got=this.orderGroupTService.findByPK(OrderGroupT.class, this.getOrderid());
			if(got!=null){
				got.setExpressnumber(this.getExpressnumber());
				this.orderGroupTService.update(got);
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
	@Action(value="UpdateInvoicenumberByGroupOrderId",results={
			@Result(name="json",type="json")
	})
	public String UpdateInvoicenumberByGroupOrderId() {
		if(StringUtils.isNotBlank(this.getInvoicenumber())&&StringUtils.isNotBlank(this.getOrderid())){
			OrderGroupT got=this.orderGroupTService.findByPK(OrderGroupT.class, this.getOrderid());
			if(got!=null){
				got.setDeliverynumber(this.getInvoicenumber());
				this.orderGroupTService.update(got);
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
	@Action(value="GetAlipayFhNeedParamsGroup",results={
			@Result(name="json",type="json")
	})
	public String GetAlipayFhNeedParamsGroup() {
		if(StringUtils.isNotBlank(this.getOrderid())){
			OrderGroupT got=this.orderGroupTService.findByPK(OrderGroupT.class, this.getOrderid());
			if(got!=null){
				this.setTradeno(got.getTradeNo());//支付宝交易号
				this.setExpressnumber(got.getExpressnumber());//快递单号，发货单号
				this.setDelivermode(got.getDelivermode());
				this.setPaymentid(got.getPaymentid());
				LogisticsBusinessT lt = this.logisticsBTService.findByPK(LogisticsBusinessT.class, got.getLogisticsid());
				if(lt!=null){
					this.setLogisticsname(lt.getLogisticsname());
				}
				this.setSucflag(true);
			}
		}
		return JSON;
	}
	
}
