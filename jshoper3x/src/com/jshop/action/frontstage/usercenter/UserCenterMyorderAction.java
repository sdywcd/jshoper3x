package com.jshop.action.frontstage.usercenter;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.template.DataCollectionTAction;
import com.jshop.action.backstage.template.FreeMarkervariable;
import com.jshop.action.backstage.thirdpartyplatform.alipay.AlipayConfig;
import com.jshop.action.backstage.tools.AllOrderState;
import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.StaticString;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.CartT;
import com.jshop.entity.DeliverAddressT;
import com.jshop.entity.LogisticsBusinessT;
import com.jshop.entity.MemberT;
import com.jshop.entity.OrderT;
import com.jshop.entity.PaymentM;
import com.jshop.entity.ShippingAddressT;
import com.jshop.entity.UserT;
import com.jshop.service.CartTService;
import com.jshop.service.DeliverAddressTService;
import com.jshop.service.LogisticsBusinessTService;
import com.jshop.service.OrderTService;
import com.jshop.service.PaymentMService;
import com.jshop.service.ShippingAddressTService;
import com.jshop.service.UsertService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs( { @InterceptorRef("defaultStack") })
public class UserCenterMyorderAction extends ActionSupport {
	private Serial serial;
	private LogisticsBusinessTService logisticsBusinessTService;
	private PaymentMService paymentMService;
	private DeliverAddressTService deliverAddressTService;
	private CartTService cartTService;
	private ShippingAddressTService shippingAddressTService;
	private OrderTService orderTService;
	private UsertService usertService;
	private DataCollectionTAction dataCollectionTAction;
	//获取隐藏的url
	private String hidurl;
	private OrderT order = new OrderT();
	private String cp;
	private String orderid;//订单编号
	private String defaultlogisticsid;//默认 物流商id，用来计算默认运费
	//支付方式id
	private String paymentid;
	//物流商id
	private String logisticsid;
	//订单标记
	private String orderTag;

	private String addressid;
	//收获地址id
	private String logisticswebaddress;
	//客户留言，订单备注
	private String customernotes;
	private OrderT oldorder = new OrderT();
	//放入request的数据
	private Map<String, Object> map = new HashMap<String, Object>();

	private boolean sshoppingaddress = false;//发货地址标记
	private boolean supdateorder = false;//订单更新标记
	int page;
	int currentPage = 1;
	int lineSize = 5;
	int allRecorders;
	private boolean slogin;
	@JSON(serialize = false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}

	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	@JSON(serialize = false)
	public LogisticsBusinessTService getLogisticsBusinessTService() {
		return logisticsBusinessTService;
	}

	public void setLogisticsBusinessTService(LogisticsBusinessTService logisticsBusinessTService) {
		this.logisticsBusinessTService = logisticsBusinessTService;
	}

	@JSON(serialize = false)
	public PaymentMService getPaymentMService() {
		return paymentMService;
	}

	public void setPaymentMService(PaymentMService paymentMService) {
		this.paymentMService = paymentMService;
	}

	@JSON(serialize = false)
	public DeliverAddressTService getDeliverAddressTService() {
		return deliverAddressTService;
	}

	public void setDeliverAddressTService(DeliverAddressTService deliverAddressTService) {
		this.deliverAddressTService = deliverAddressTService;
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

	public OrderT getOrder() {
		return order;
	}

	public void setOrder(OrderT order) {
		this.order = order;
	}

	public OrderT getOldorder() {
		return oldorder;
	}

	public void setOldorder(OrderT oldorder) {
		this.oldorder = oldorder;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String getHidurl() {
		return hidurl;
	}

	public void setHidurl(String hidurl) {
		this.hidurl = hidurl;
	}

	public boolean isSupdateorder() {
		return supdateorder;
	}

	public void setSupdateorder(boolean supdateorder) {
		this.supdateorder = supdateorder;
	}

	public boolean isSshoppingaddress() {
		return sshoppingaddress;
	}

	public void setSshoppingaddress(boolean sshoppingaddress) {
		this.sshoppingaddress = sshoppingaddress;
	}

	public String getAddressid() {
		return addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}

	public String getCustomernotes() {
		return customernotes;
	}

	public void setCustomernotes(String customernotes) {
		this.customernotes = customernotes;
	}

	public String getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

	public String getLogisticsid() {
		return logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}

	public String getOrderTag() {
		return orderTag;
	}

	public void setOrderTag(String orderTag) {
		this.orderTag = orderTag;
	}

	public String getDefaultlogisticsid() {
		return defaultlogisticsid;
	}

	public void setDefaultlogisticsid(String defaultlogisticsid) {
		this.defaultlogisticsid = defaultlogisticsid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getLogisticswebaddress() {
		return logisticswebaddress;
	}

	public void setLogisticswebaddress(String logisticswebaddress) {
		this.logisticswebaddress = logisticswebaddress;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLineSize() {
		return lineSize;
	}

	public void setLineSize(int lineSize) {
		this.lineSize = lineSize;
	}

	public int getAllRecorders() {
		return allRecorders;
	}

	public void setAllRecorders(int allRecorders) {
		this.allRecorders = allRecorders;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 获取用户的所有订单（即已买到的商品）
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	@Action(value = "findAllUserOrder", results = { @Result(name = "success", type = "freemarker", location = "/WEB-INF/theme/default/shop/myorder.ftl"), @Result(name = "input", type = "redirect", location = "/html/default/shop/user/login.html?redirecturl=${hidurl}") })
	public String findAllUserOrder() {
		UserT user = (UserT) ActionContext.getContext().getSession().get(StaticString.MEMBER_SESSION_KEY);
		if (user != null) {
			int lineSize = 50;
			String orderstate = "8";//8表示用户自己删除的订单
			String paystate = "1";//已付款
			String shippingstate = "1";//已发货
			try {
				currentPage = Integer.parseInt(this.getCp());
			} catch (Exception e) {

			}
			//int allRecorders=this.getOrderTService().countfindAllOrderByorderstate(user.getUserid(), orderstate, paystate, shippingstate);
			List<OrderT> list = this.getOrderTService().findAllOrderByorderstate(currentPage, lineSize, user.getUserid(), orderstate, paystate, shippingstate);

			//路径获取
			ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
			//获取我已买到的商品
			ActionContext.getContext().put("userorder", list);
			//获取导航数据
			ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation());
			//获取商城基本数据
			ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo());
			//获取页脚分类数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT());
			//获取页脚文章数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, this.getDataCollectionTAction().findFooterArticle());
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	/**
	 * 删除订单（更新订单到8状态）
	 * 
	 * @return
	 */
	@Action(value = "DelOrderByorderid", results = { @Result(name = "success", type = "chain", location = "findAllUserOrder"), @Result(name = "input", type = "redirect", location = "/html/default/shop/login.html?redirecturl=${hidurl}") })
	public String DelOrderByorderid() {
		UserT user = (UserT) ActionContext.getContext().getSession().get(StaticString.MEMBER_SESSION_KEY);
		if (user != null) {
			String orderstate = "8";//9表示用户自己删除的订单
			@SuppressWarnings("unused")
			int i = this.getOrderTService().delOrderByorderid(user.getUserid(), this.getOrderid().trim(), orderstate);
			return SUCCESS;
		} else {
			return INPUT;
		}

	}

	/**
	 * 用户更新到收货确认
	 * 
	 * @return
	 */
	@Action(value = "ConfirmGoodsReceive", results = { @Result(name = "success", type = "chain", location = "findAllUserOrder"), @Result(name = "input", type = "redirect", location = "/html/default/shop/login.html?redirecturl=${hidurl}") })
	public String ConfirmGoodsReceive() {
		UserT user = (UserT) ActionContext.getContext().getSession().get(StaticString.MEMBER_SESSION_KEY);
		if (user != null) {
			String orderstate = "6";//6表示用户已经确认收货
			@SuppressWarnings("unused")
			int i = this.getOrderTService().delOrderByorderid(user.getUserid(), this.getOrderid().trim(), orderstate);
			return SUCCESS;
		} else {
			return INPUT;
		}

	}

	/**
	 * 查询我的未处理订单
	 * 
	 * @return
	 * 
	 */
	@Action(value = "findAllUserOrderOn", results = { @Result(name = "success", type = "freemarker", location = "WEB-INF/theme/default/shop/myorder.ftl"), @Result(name = "input", type = "redirect", location = "/html/default/shop/login.html?redirecturl=${hidurl}") })
	public String findAllUserOrderOn() {
		UserT user = (UserT) ActionContext.getContext().getSession().get(StaticString.MEMBER_SESSION_KEY);
		if (user != null) {
			currentPage = 1;
			lineSize = 5;
			String orderstate = "8";//9表示用户自己删除的订单
			String paystate = "2";//未付款,已付款
			String shippingstate = "2";//已发货，未发货
			try {
				currentPage = Integer.parseInt(this.getCp());
			} catch (Exception e) {

			}
			allRecorders = this.getOrderTService().countfindAllOrderByorderstateForOn(user.getUserid(), orderstate, paystate, shippingstate);
			List<OrderT> list = this.getOrderTService().findAllOrderByorderstateForOn(currentPage, lineSize, user.getUserid(), orderstate, paystate, shippingstate);
			
			//路径获取
			ActionContext.getContext().put("basePath", this.getDataCollectionTAction().getBasePath());
			//获取我的订单
			ActionContext.getContext().put("userorderon", list);
			//获取导航数据
			ActionContext.getContext().put("siteNavigationList", this.getDataCollectionTAction().findSiteNavigation());
			//获取商城基本数据
			ActionContext.getContext().put("jshopbasicinfo", this.getDataCollectionTAction().findJshopbasicInfo());
			//获取页脚分类数据
			ActionContext.getContext().put("footcategory", this.getDataCollectionTAction().findFooterCateogyrT());
			//获取页脚文章数据
			ActionContext.getContext().put("footerarticle", this.getDataCollectionTAction().findFooterArticle());
			return SUCCESS;
	

		} else {
			return INPUT;
		}
	}

	/**
	 * 获取用户收获地址
	 */
	public void GetUserDeliverAddress(MemberT memberT) {
		List<DeliverAddressT> list = this.getDeliverAddressTService().findDeliverAddressBymemberid(memberT.getId());
		ActionContext.getContext().put("deliveraddress", list);
		
	}

	/**
	 * 获取物流商配送方式
	 */
	public void GetDefaultLogistictsBusiness() {
		List<LogisticsBusinessT> list = this.getLogisticsBusinessTService().findAllLogisticsBusinessWithoutPage();
		if (list != null) {
			for (Iterator it = list.iterator(); it.hasNext();) {
				LogisticsBusinessT lbt = (LogisticsBusinessT) it.next();
				if (lbt.getVisible().equals("1")) {
					this.setDefaultlogisticsid(lbt.getLogisticsid());
					break;
				}
			}
			ActionContext.getContext().put("logistics", list);
		}
	}

	/**
	 * 获取支付方式
	 */
	public void GetDefaultPayment() {
		List<PaymentM> list = this.getPaymentMService().findAllPaymentWithoutPage();	
		ActionContext.getContext().put("payments", list);
	}

	/**
	 * 获取本次获取的订单信息
	 */
	public void GetthisOrderinfo() {
		OrderT o = this.getOrderTService().findOrderDetailByorderid(this.getOrderid().trim());
		if (o != null) {
			ActionContext.getContext().put("myorderinfo", o);
			ActionContext.getContext().put("freight", o.getFreight());
			//把订单信息赋值给全局变量oldorder
			//oldorder = o;
		}
	}

	/**
	 * 初始化再次支付的页面信息（收货地址，支付方式，抵用券）
	 * 
	 * @return
	 */
	@Action(value = "InitPayPage", results = { @Result(name = "success", type="freemarker", location = "/WEB-INF/theme/default/shop/confirmorderag.ftl"), @Result(name = "input", type = "redirect", location = "/html/default/shop/login.html?redirecturl=${hidurl}") })
	public String InitPayPage() {
		MemberT memberT = (MemberT) ActionContext.getContext().getSession().get(StaticString.MEMBER_SESSION_KEY);
		if (memberT != null) {
			//获取用户收获地址
			GetUserDeliverAddress(memberT);
			//获取物流商
			GetDefaultLogistictsBusiness();
			//获取支付方式
			GetDefaultPayment();
			//获取订单信息
			GetthisOrderinfo();
			//路径获取
			ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
			//获取导航数据
			ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation());
			//获取商城基本数据
			ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo());
			//获取页脚分类数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT());
			//获取页脚文章数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, this.getDataCollectionTAction().findFooterArticle());
			
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	/**
	 * 增加发货地址
	 */
	public void AddShippingAddress(String deliveraddressid) {
		DeliverAddressT list = this.getDeliverAddressTService().findDeliverAddressById(this.getAddressid());
		if (list != null) {
			ShippingAddressT s = new ShippingAddressT();
			s.setShippingaddressid(this.getSerial().Serialid(Serial.SHIPPINGADDRESS));
			s.setMemberid(list.getMemberid());
			s.setShippingusername(list.getShippingusername());
			s.setCountry(list.getCountry());
			s.setProvince(list.getProvince());
			s.setCity(list.getCity());
			s.setDistrict(list.getDistrict());
			s.setStreet(list.getStreet());
			s.setPostcode(list.getPostcode());
			s.setTelno(list.getTelno());
			s.setMobile(list.getMobile());
			s.setEmail(list.getEmail());
			s.setCreatetime(BaseTools.systemtime());
			s.setState("1");//把发货地址设置成状态1，表示此地址已经和订单绑定
			s.setDeliveraddressid(list.getAddressid());
			s.setIssend("0");//未发送到这个地址过
			s.setOrderid(oldorder.getOrderid());
			this.getShippingAddressTService().save(s);
				this.setSshoppingaddress(false);
				order.setShippingaddressid(s.getShippingaddressid());//设置发货地址到订单中
				order.setDeliveraddressid(list.getAddressid());//设置收货地址到订单中
				order.setShippingusername(list.getShippingusername());//设置收货人到订单中
				//设置收货人信息给支付宝借口
				AlipayConfig.receive_name = list.getShippingusername();
				AlipayConfig.receive_address = list.getProvince() + list.getCity() + list.getDistrict() + list.getStreet();
				AlipayConfig.reveive_zip = list.getPostcode();
				AlipayConfig.reveive_phone = list.getTelno();
				AlipayConfig.reveive_mobile = list.getMobile();
//			} else {
//				this.setSshoppingaddress(true);
//			}
		}
	}

	/**
	 * 比较收货地址和发货地址，判断是否需要更新订单中的收获地址id和发货地址id，和发货地址表中的响应信息
	 */
	public void CompareShippingAddress() {
		//如果选中的地址已经在发货地址表，并且用户选中的发货地址也在订单中，则根据订单总的发货地址id读取信息给支付宝
		//如果用户选中的地址不在发货地址表中，那么新增发货地址并且更新发货地址到过去节点并且更新订单中的发货地址
		/**
		 * 获取发货地址表数据，判断传来的收获地址是不是已经在发货地址表中 state="1"表示使用的地址
		 */
		List<ShippingAddressT> list = this.getShippingAddressTService().findShippingAddressByDeliveraddressidAndstate(this.getAddressid().trim(), "1", this.getOrderid().trim());
		if (list != null) {
			//获取一次原始订单比较地址信息
			oldorder=this.getOrderTService().findOrderDetailByorderid(this.getOrderid());
			if (oldorder.getDeliveraddressid().equals(this.getAddressid().trim())) {
				//用户选择的收获地址已经在发货地址表中，那么订单中任然使用原始的发货地址id和收获地址id
				order.setShippingaddressid(oldorder.getShippingaddressid());
				order.setDeliveraddressid(oldorder.getDeliveraddressid());
				order.setShippingusername(oldorder.getShippingusername());
				//设置收货人信息给支付宝借口
				AlipayConfig.receive_name = list.get(0).getShippingusername();
				AlipayConfig.receive_address = list.get(0).getProvince() + list.get(0).getCity() + list.get(0).getDistrict() + list.get(0).getStreet();
				AlipayConfig.reveive_zip = list.get(0).getPostcode();
				AlipayConfig.reveive_phone = list.get(0).getTelno();
				AlipayConfig.reveive_mobile = list.get(0).getMobile();
			}
		} else {
			//设定以前的在发货表中的地址到state2表示弃用了。根据orderid获取并更新
			int i = this.getShippingAddressTService().updateShippingAddressByorderandstate(oldorder.getOrderid(), "2");
			//增加地址
			AddShippingAddress(this.getAddressid().trim());
		}
	}

	/**
	 * 比较支付方式是不是不同了，不同则更新订单，同则不变
	 */
	public void ComparePaymentinfo() {
		if (oldorder.getPaymentid().equals(this.getPaymentid().trim())) {
			PaymentM list = this.getPaymentMService().findPaymentbyId(this.getPaymentid().trim());
			if (list != null) {
				AlipayConfig.partner = list.getPartnerid();
				AlipayConfig.key = list.getSafecode();
				AlipayConfig.seller_email = list.getAccount();
				//把支付方式id和名称增加到order中
				order.setPaymentid(list.getPaymentid());
				order.setPaymentname(list.getPaymentname());
			}
		} else {
			PaymentM list = this.getPaymentMService().findPaymentbyId(this.getPaymentid().trim());
			if (list != null) {
				AlipayConfig.partner = list.getPartnerid();
				AlipayConfig.key = list.getSafecode();
				AlipayConfig.seller_email = list.getAccount();
				//把支付方式id和名称增加到order中
				order.setPaymentid(list.getPaymentid());
				order.setPaymentname(list.getPaymentname());
			}
		}
	}

	/**
	 * 比较物流方式是否改变
	 */
	public void CompareLogisticsbusiness() {
		if (oldorder.getLogisticsid().equals(this.getLogisticsid().trim())) {
			order.setLogisticsid(oldorder.getLogisticsid());
		} else {
			order.setLogisticsid(this.getLogisticsid().trim());
		}
	}

	/**
	 * 更新订单信息
	 * 
	 * @param user
	 */
	public void UpdateOrderInfo(UserT user) {
		order.setOrderid(oldorder.getOrderid());
		order.setUserid(oldorder.getUserid());
		order.setUsername(oldorder.getUsername());
		order.setDelivermode(oldorder.getDelivermode());
		order.setDeliverynumber(null);//这里会有问题
		order.setOrderstate(oldorder.getOrderstate());
		order.setPaystate(oldorder.getPaystate());
		order.setShippingstate(oldorder.getShippingstate());

//		order.setGoodid(oldorder.getGoodid());
//		order.setGoodsname(oldorder.getGoodsname());
		order.setNeedquantity(oldorder.getNeedquantity());
		order.setFreight(oldorder.getFreight());
		order.setAmount(oldorder.getAmount());
		order.setPoints(oldorder.getPoints());
		order.setPurchasetime(BaseTools.systemtime());
		order.setDeliverytime(null);
		order.setDeliverynumber(null);
		order.setIsinvoice(oldorder.getIsinvoice());
		order.setCustomerordernotes(this.getCustomernotes());
		order.setLogisticswebaddress(this.getLogisticswebaddress());
		order.setPaytime(null);
		order.setOrderTag(this.getOrderTag());
		order.setToBuyerNotes(null);
		order.setShouldpay(oldorder.getShouldpay());
		order.setUsepoints(oldorder.getUsepoints());
		order.setVouchersid(oldorder.getVouchersid());
		order.setCreatetime(BaseTools.systemtime());
		order.setIsprintexpress("0");//未打印快递单
		order.setIsprintinvoice("0");//未打印发货单
		order.setIsprintfpinvoice("0");//未开具发票
		order.setExpressnumber(null);//快递单号
		try {
			this.getOrderTService().updateOrder(order);
			AlipayConfig.out_trade_no = order.getOrderid();
			AlipayConfig.subject = order.getOrdername();
			AlipayConfig.body = order.getOrdername();
			AlipayConfig.price = String.valueOf(order.getShouldpay());
			AlipayConfig.logistics_fee = String.valueOf(order.getFreight());
			this.setSupdateorder(false);
		} catch (RuntimeException re) {
			this.setSupdateorder(true);
			throw re;
		}

	}

	/**
	 * 再次获取支付所需信息并更新订单
	 * 
	 * @return
	 */
	@Action(value = "InitAgAlipayandUpdateOrder", results = { @Result(name = "json", type = "json") })
	public String InitAgAlipayandUpdateOrder() {
		UserT user = (UserT) ActionContext.getContext().getSession().get(StaticString.MEMBER_SESSION_KEY);
		if (user != null) {
			this.setSlogin(true);
			//比较发货地址并更新
			CompareShippingAddress();
			//比较支付方式并更新
			ComparePaymentinfo();
			//比较物流上市并更新
			CompareLogisticsbusiness();
			//更新订单
			UpdateOrderInfo(user);
			return "json";
		} else {
			this.setSlogin(false);
			return "json";
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

			map.put("myorderdetail", o);

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
			map.put("myorderbuyerinfo", user);
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
			map.put("myordergoods", list);
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
			map.put("myshipping", st);
		}
	}

	/**
	 * 获取订单详细信息
	 * 
	 * @return
	 */
	@Action(value = "InitMyOrdersDetail", results = { @Result(name = "success", type="freemarker",location = "/WEB-INF/theme/default/shop/myordersdetail.ftl"), @Result(name = "input", type = "redirect", location = "/html/default/shop/user/login.html") })
	public String InitMyOrdersDetail() {
		if(Validate.StrNotNull(this.getOrderid())){
			String orderid = this.getOrderid().trim();
			//获取订单详细
			GetOrderDetail(orderid);
			//获取订单中的商品列表
			GetOrderGoodsList(orderid);
			//获取发货地址信息
			GetOrderShippingAddress(orderid);
			ActionContext.getContext().put("myorder", map);
			//路径获取
			ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
			//获取导航数据
			ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation());
			//获取商城基本数据
			ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo());
			//获取页脚分类数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT());
			//获取页脚文章数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, this.getDataCollectionTAction().findFooterArticle());
			
			return SUCCESS;
		}
		return INPUT;
		
	}

}
