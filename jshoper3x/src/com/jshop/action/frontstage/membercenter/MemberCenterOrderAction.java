package com.jshop.action.frontstage.membercenter;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.pay.thirdpartyplatform.alipay.AlipayConfig;
import com.jshop.action.backstage.staticspage.DataCollectionTAction;
import com.jshop.action.backstage.staticspage.FreeMarkervariable;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.PageModel;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.order.AllOrderState;
import com.jshop.action.backstage.utils.statickey.PaymentCode;
import com.jshop.action.backstage.utils.statickey.StaticKey;
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
import com.jshop.service.MemberTService;
import com.jshop.service.OrderBaseProcessTService;
import com.jshop.service.OrderTService;
import com.jshop.service.PaymentMService;
import com.jshop.service.ShippingAddressTService;
import com.jshop.service.UsertService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs( { @InterceptorRef("defaultStack") })
public class MemberCenterOrderAction extends ActionSupport {
	private Serial serial;
	private LogisticsBusinessTService logisticsBusinessTService;
	private PaymentMService paymentMService;
	private DeliverAddressTService deliverAddressTService;
	private CartTService cartTService;
	private ShippingAddressTService shippingAddressTService;
	private OrderTService orderTService;
	private UsertService usertService;
	private DataCollectionTAction dataCollectionTAction;
	private MemberTService memberTService;
	@Resource
	private OrderBaseProcessTService orderBaseProcessTService;
	//获取隐藏的url
	private String hidurl;
	private OrderT order = new OrderT();
	private PaymentM pm=new PaymentM();
	private DeliverAddressT dt=new DeliverAddressT();
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
	private boolean spayment = false;//是否支付信息写入成功标记
	private boolean sshoppingaddress = false;//发货地址标记
	private boolean supdateorder = false;//订单更新标记
	private boolean ischangeaddress;//是否改变了收货地址
	private String paymentcode;//返回给前台的支付方式
	private String paymentinterface;//反馈给前台的支付接口类型
	private int rp=8;//每页显示数量
	private int page=1;
	private int total=0;
	private int totalpage=1;
	private boolean slogin;
	private String basePath;
	@JSON(serialize = false)
	public MemberTService getMemberTService() {
		return memberTService;
	}

	public void setMemberTService(MemberTService memberTService) {
		this.memberTService = memberTService;
	}

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

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public PaymentM getPm() {
		return pm;
	}

	public void setPm(PaymentM pm) {
		this.pm = pm;
	}

	public String getPaymentcode() {
		return paymentcode;
	}

	public void setPaymentcode(String paymentcode) {
		this.paymentcode = paymentcode;
	}

	public String getPaymentinterface() {
		return paymentinterface;
	}

	public void setPaymentinterface(String paymentinterface) {
		this.paymentinterface = paymentinterface;
	}

	public boolean isSpayment() {
		return spayment;
	}

	public void setSpayment(boolean spayment) {
		this.spayment = spayment;
	}

	public boolean isIschangeaddress() {
		return ischangeaddress;
	}

	public void setIschangeaddress(boolean ischangeaddress) {
		this.ischangeaddress = ischangeaddress;
	}

	public DeliverAddressT getDt() {
		return dt;
	}

	public void setDt(DeliverAddressT dt) {
		this.dt = dt;
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
	@Action(value = "findAllMemberOrder", results = { @Result(name = "success", type = "freemarker", location = "/WEB-INF/theme/default/shop/myorder.ftl"), @Result(name = "input", type = "redirect", location = "/html/default/shop/user/login.html?redirecturl=${hidurl}") })
	public String findAllMemberOrder() {
		MemberT memberT = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (memberT != null) {
			//获取最近的订单信息
			this.findAllUserOrderOn(memberT.getId());
			this.getDataCollectionTAction().putBaseInfoToContext();
			return SUCCESS;
		}
		return INPUT;
	}
	
	
	/**
	 * 获取用户未处理的订单只获取前30条
	 */
	public void findAllUserOrderOn(String memberid){
		int currentPage=page;
		int lineSize=rp;
		List<OrderT>list=this.getOrderTService().findAllOrderByorderstateForOn(currentPage, lineSize, memberid, AllOrderState.ORDERSTATE_EIGHT_NUM, AllOrderState.PAYSTATE_TWO_NUM, AllOrderState.SHIPPINGSTATE_TWO_NUM);
	
		total=this.getOrderTService().countfindAllOrderByorderstateForOn(memberid, AllOrderState.ORDERSTATE_EIGHT, AllOrderState.PAYSTATE_TWO_NUM, AllOrderState.SHIPPINGSTATE_TWO_NUM);
		PageModel<OrderT>pm=new PageModel<>(currentPage, lineSize, list, total);
		String action=this.getDataCollectionTAction().getBasePath()+"/findAllMemberOrder.action?";
		ActionContext.getContext().put("actionlink", action);
		ActionContext.getContext().put("sign", "disstatic");
		ActionContext.getContext().put("goods", pm);
		ActionContext.getContext().put(FreeMarkervariable.MEMBERORDERON,list);
		ActionContext.getContext().put("totalgoods",pm.getTotalRecord());
		ActionContext.getContext().put("totalpage",pm.getTotalpage());
		

		
	}
	
	
	
	
	
	

	/**
	 * 删除订单（更新订单到8状态）
	 * 
	 * @return
	 */
	@Action(value = "DelOrderByorderid", results = { @Result(name = "success", type = "chain", location = "findAllUserOrder"), @Result(name = "input", type = "redirect", location = "/html/default/shop/login.html?redirecturl=${hidurl}") })
	public String delOrderByorderid() {
		MemberT memberT = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (memberT != null) {
			String orderstate = "8";//8表示用户自己删除的订单
			@SuppressWarnings("unused")
			int i = this.getOrderTService().delOrderByorderid(memberT.getId(), this.getOrderid().trim(), orderstate);
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
		UserT user = (UserT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
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
		MemberT memberT = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (memberT != null) {
//			currentPage = 1;
//			lineSize = 5;
//			String orderstate = "8";//9表示用户自己删除的订单
//			String paystate = "2";//未付款,已付款
//			String shippingstate = "2";//已发货，未发货
//			try {
//				currentPage = Integer.parseInt(this.getCp());
//			} catch (Exception e) {
//
//			}
//			allRecorders = this.getOrderTService().countfindAllOrderByorderstateForOn(memberT.getId(), orderstate, paystate, shippingstate);
//			List<OrderT> list = this.getOrderTService().findAllOrderByorderstateForOn(currentPage, lineSize, memberT.getId(), orderstate, paystate, shippingstate);
//			//获取我的订单
//			ActionContext.getContext().put("userorderon", list);
//			this.getDataCollectionTAction().putBaseInfoToContext();
			return SUCCESS;
	

		} else {
			return INPUT;
		}
	}

	





	/**
	 * 初始化再次支付的页面信息（收货地址，支付方式，抵用券）用户中心订单付款界面
	 * 
	 * @return
	 */
	@Action(value = "InitPayPage", results = { @Result(name = "success", type="freemarker", location = "/WEB-INF/theme/default/shop/confirmorderag.ftl"), @Result(name = "input", type = "redirect", location = "/html/default/shop/user/login.html?redirecturl=${hidurl}") })
	public String InitPayPage() {
		MemberT memberT = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (memberT != null) {
			//获取用户收获地址
			ActionContext.getContext().put(FreeMarkervariable.DELIVERADDRESS, orderBaseProcessTService.getMemberDeliverAddress(memberT));
			//获取物流商 需要设定一个默认物流商来计算运费
			ActionContext.getContext().put(FreeMarkervariable.LOGISTICS, orderBaseProcessTService.getLogisticstsBusiness(StaticKey.ONE));
			//获取支付方式
			ActionContext.getContext().put(FreeMarkervariable.PAYMENTS, orderBaseProcessTService.getPaymentM(StaticKey.ONE));
			//获取订单信息
			OrderT o=orderBaseProcessTService.getOrder(this.getOrderid());
			if(o!=null){
				//订单信息
				ActionContext.getContext().put(FreeMarkervariable.MYORDERINFO,o);
				//运费
				ActionContext.getContext().put(FreeMarkervariable.FREIGHT, o.getFreight());
			}
			//路径获取
			ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
			//获取导航数据
			ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation(StaticKey.SiteNavigationState.SHOW.getVisible()));
			//获取商城基本数据
			ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo(StaticKey.DataShowState.SHOW.getState(),StaticKey.JshopOpenState.OPEN.getOpenstate()));
			//获取页脚分类数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT(StaticKey.DataGrade.FIRST.getState(),StaticKey.DataUsingState.USING.getState()));
			//获取页脚文章数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, this.getDataCollectionTAction().findFooterArticle(StaticKey.DataShowState.SHOW.getState()));
			
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	
	
	/**
	 * 增加发货地址
	 */
	public ShippingAddressT saveShippingAddress(DeliverAddressT da) {
		
		ShippingAddressT s = new ShippingAddressT();
		s.setShippingaddressid(this.getSerial().Serialid(Serial.SHIPPINGADDRESS));
		s.setMemberid(da.getMemberid());
		s.setShippingusername(da.getShippingusername());
		s.setCountry(da.getCountry());
		s.setProvince(da.getProvince());
		s.setCity(da.getCity());
		s.setDistrict(da.getDistrict());
		s.setStreet(da.getStreet());
		s.setPostcode(da.getPostcode());
		s.setTelno(da.getTelno());
		s.setMobile(da.getMobile());
		s.setEmail(da.getEmail());
		s.setCreatetime(BaseTools.systemtime());
		s.setState(StaticKey.ONE);//把发货地址设置成状态1，表示此地址已经和订单绑定
		s.setDeliveraddressid(da.getAddressid());
		s.setIssend(StaticKey.ZERO);//未发送到这个地址过
		s.setOrderid(oldorder.getOrderid());
		this.getShippingAddressTService().save(s);
		this.setDt(da);
		this.setSshoppingaddress(true);
		
		return s;

	}

	/**
	 * 比较收货地址和发货地址，判断是否需要更新订单中的收获地址id和发货地址id，和发货地址表中的响应信息
	 */
	public boolean compareShippingAddress(String addressid,String orderid) {
		//如果选中的地址已经在发货地址表，并且用户选中的发货地址也在订单中，则根据订单中的发货地址id读取信息给支付宝
		//如果用户选中的地址不在发货地址表中，那么新增发货地址并且更新发货地址到过去节点并且更新订单中的发货地址
		/**
		 * 获取发货地址表数据，判断传来的收获地址是不是已经在发货地址表中 state="1"表示使用的地址
		 */
		ShippingAddressT sa = orderBaseProcessTService.getShippingAddress(addressid, StaticKey.ONE, orderid);
		if (sa!=null) {
			if (StringUtils.equals(oldorder.getDeliveraddressid(), addressid)) {
				//用户选择的收获地址已经在发货地址表中，那么订单中任然使用原始的发货地址id和收获地址id
				this.setIschangeaddress(false);
			}
			return false;
		} else {
			this.setIschangeaddress(true);//改变了收货地址信息需要新增收货地址
			//设定以前这个订单在发货表中的地址到state2表示弃用了。根据orderid获取并更新
			List<ShippingAddressT>slist=orderBaseProcessTService.getShippingAddress(orderid);
			for(ShippingAddressT s:slist){
				s.setState(StaticKey.TWO);
				this.getShippingAddressTService().update(s);
			}
			return true;
		}
	}

	/**
	 * 获取支付方式
	 * @param paymentid
	 * @return
	 */
	private PaymentM getPayway(String paymentid){
		PaymentM pm=orderBaseProcessTService.getSelectedPayMent(paymentid);
		if(pm!=null){
			this.setPm(pm);
			if(StringUtils.equals(PaymentCode.PAYMENT_CODE_ALIPAY, pm.getPaymentCode())){
				this.setPaymentcode(PaymentCode.PAYMENT_CODE_ALIPAY);
				if(StringUtils.equals(StaticKey.PAY_INTERFACE_CODE_TWOPAY, pm.getPaymentInterface())){
					this.setPaymentinterface(StaticKey.PAY_INTERFACE_CODE_TWOPAY);//双接口
				}
			}else if(StringUtils.equals(PaymentCode.PAYMENT_CODE_TENPAY, pm.getPaymentCode())){
				this.setPaymentcode(PaymentCode.PAYMENT_CODE_TENPAY);
				if(StringUtils.equals(StaticKey.PAY_INTERFACE_CODE_TWOPAY, pm.getPaymentInterface())){
					this.setPaymentinterface(StaticKey.PAY_INTERFACE_CODE_TWOPAY);
				}
			}
			this.setSpayment(true);
		}else{
			this.setSpayment(false);
		}
		return pm;
	
	}
	
	/**
	 * 比较支付方式是不是不同了，不同则更新订单，同则不变
	 */
	public PaymentM getPaymentinfo(String paymentid) {
		
		if(StringUtils.equals(oldorder.getPaymentid(), paymentid)){
			return getPayway(paymentid);	
		}else{
			return getPayway(paymentid);
		}
	}

	/**
	 * 比较物流方式是否改变
	 */
	public String compareLogisticsbusiness(String logisticsid) {
		if(StringUtils.equals(oldorder.getLogisticsid(), logisticsid)){
			return oldorder.getLogisticsid();
		}else{
			return logisticsid;
		}
	}

	/**
	 * 更新订单信息
	 * 
	 * @param user
	 */
	public void updateOrderInfo(MemberT membert,PaymentM pm,DeliverAddressT da,ShippingAddressT s,String logisticsid) {
		order.setOrderid(oldorder.getOrderid());
		order.setUserid(oldorder.getUserid());
		order.setUsername(oldorder.getUsername());
		order.setMemberid(membert.getId());
		order.setMembername(membert.getLoginname());
		if(StaticKey.PAY_ON_DELIVERY_TAG.equals(this.getPaymentid())){
			order.setDelivermode(StaticKey.PAY_ON_DELIVERY);
		}else{
			order.setDelivermode(oldorder.getDelivermode());
		}
		order.setDeliverynumber(StaticKey.EMPTY);//发货单号在发货后填写
		order.setOrderstate(oldorder.getOrderstate());
		order.setPaystate(oldorder.getPaystate());
		order.setShippingstate(oldorder.getShippingstate());
		order.setLogisticsid(logisticsid);
		order.setLogisticswebaddress(oldorder.getLogisticswebaddress());
		order.setProductinfo(oldorder.getProductinfo());
		order.setOrdername(oldorder.getOrdername());
		order.setMainpicture(oldorder.getMainpicture());
		order.setNeedquantity(oldorder.getNeedquantity());
		order.setFreight(oldorder.getFreight());
		order.setAmount(oldorder.getAmount());
		order.setPoints(oldorder.getPoints());
		order.setPurchasetime(BaseTools.systemtime());
		order.setDeliverytime(null);
		order.setDeliverynumber(StaticKey.EMPTY);
		order.setIsinvoice(oldorder.getIsinvoice());
		order.setCustomerordernotes(this.getCustomernotes());
		order.setPaytime(null);
		order.setOrderTag(oldorder.getOrderTag());
		order.setToBuyerNotes(oldorder.getToBuyerNotes());
		order.setShouldpay(oldorder.getShouldpay());
		order.setUsepoints(oldorder.getUsepoints());
		order.setVouchersid(oldorder.getVouchersid());
		order.setCreatetime(oldorder.getCreatetime());
		order.setUpdatetime(BaseTools.systemtime());
		order.setIsprintexpress(oldorder.getIsprintexpress());//未打印快递单
		order.setIsprintinvoice(oldorder.getIsprintinvoice());//未打印发货单
		order.setIsprintfpinvoice(oldorder.getIsprintfpinvoice());//未开具发票
		order.setExpressnumber(oldorder.getExpressnumber());//快递单号
		order.setPaymentid(pm.getPaymentid());
		order.setPaymentname(pm.getPaymentname());
		if(!this.isIschangeaddress()){
			//如果发货地址没有变化则使用以前的订单信息
			order.setShippingaddressid(oldorder.getShippingaddressid());
			order.setDeliveraddressid(oldorder.getDeliveraddressid());
			order.setShippingusername(oldorder.getShippingusername());
		}else{
			//如果发货地址变化则使用新的发货地址信息
			order.setShippingaddressid(s.getShippingaddressid());//设置发货地址到订单中
			order.setDeliveraddressid(da.getAddressid());//设置收货地址到订单中
			order.setShippingusername(da.getShippingusername());//设置收货人
		}
		this.getOrderTService().updateOrder(order);
		this.setSupdateorder(true);
	}

	/**
	 * 获取收货地址信息
	 * @param addressid
	 * @return
	 */
	private DeliverAddressT getDeliverAddress(String addressid){
		return orderBaseProcessTService.getDeliverAddress(addressid);
	}
	
	/**
	 * 再次获取支付所需信息并更新订单
	 * 
	 * @return
	 */
	@Action(value = "InitAgAlipayandUpdateOrder", results = { @Result(name = "json", type = "json") })
	public String initAgAlipayandUpdateOrder() {
		MemberT membert = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (membert != null) {
			this.setSlogin(true);
			//这里需要注意
			//获取一次原始订单比较地址信息
			oldorder=this.getOrderTService().findOrderDetailByorderid(this.getOrderid());
			//比较发货地址,如果地址和原有订单中的发货地址不一致则废弃原有地址，新增地址
			if(compareShippingAddress(this.getAddressid(),this.getOrderid())){
				//增加发货地址
				DeliverAddressT da=getDeliverAddress(this.getAddressid());
				if(da!=null){
					ShippingAddressT s=saveShippingAddress(da);
					//获取支付方式信息
					PaymentM pm=getPaymentinfo(this.getPaymentid());
					//比较物流并更新
					String lid=compareLogisticsbusiness(this.getLogisticsid());
					if(pm!=null){
						//更新订单
						updateOrderInfo(membert,pm,da,s,lid);
						if(isSupdateorder()){
							if(PaymentCode.PAYMENT_CODE_ALIPAY.equals(pm.getPaymentCode())){
								BuildAlipayConfig();
							}
						}
					}
					
				}
			}
			this.setBasePath(this.getDataCollectionTAction().getBasePath());
			return "json";
		} else {
			this.setSlogin(false);
			return "json";
		}

	}
	/**
	 * 开始对支付宝采集数据
	 */
	private void BuildAlipayConfig() {
		AlipayConfig.partner = this.getPm().getPartnerid();
		AlipayConfig.key = this.getPm().getSafecode();
		AlipayConfig.seller_email = this.getPm().getAccount();
		AlipayConfig.out_trade_no = order.getOrderid();
		AlipayConfig.subject = order.getOrdername();
		AlipayConfig.body = order.getOrdername();
		AlipayConfig.price = String.valueOf(order.getShouldpay());
		AlipayConfig.logistics_fee = String.valueOf(order.getFreight());
		//设置收货人信息给支付宝借口
		AlipayConfig.receive_name = this.getDt().getShippingusername();
		AlipayConfig.receive_address = this.getDt().getProvince() + this.getDt().getCity() + this.getDt().getDistrict() + this.getDt().getStreet();
		AlipayConfig.reveive_zip = this.getDt().getPostcode();
		AlipayConfig.reveive_phone = this.getDt().getTelno();
		AlipayConfig.reveive_mobile = this.getDt().getMobile();
		
	}

	/**
	 * 获取订单详细
	 */
	public void getOrderDetail(String orderid) {
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
			getUserBuyerInfo(o.getUserid());
		}
	}

	/**
	 * 获取买家信息
	 * 
	 * @param userid
	 */
	public void getUserBuyerInfo(String memberid) {
		MemberT member = this.getMemberTService().findMemberTById(memberid);
		if (member != null) {
			map.put("myorderbuyerinfo", member);
		}
	}

	/**
	 * 获取订单中的商品列表
	 * 
	 * @param orderid
	 */
	public void getOrderGoodsList(String orderid) {
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
	public void getOrderShippingAddress(String orderid) {
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
	@Action(value = "InitMyOrdersDetail", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/shop/myordersdetail.ftl"),
			@Result(name = "input",location = "/html/default/shop/user/login.html")
	})
	public String initMyOrdersDetail() {
		MemberT memberT = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (memberT != null) {
			if(StringUtils.isNotBlank(this.getOrderid())){
				String orderid = this.getOrderid().trim();
				//获取订单详细
				getOrderDetail(orderid);
				//获取订单中的商品列表
				getOrderGoodsList(orderid);
				//获取发货地址信息
				getOrderShippingAddress(orderid);
				ActionContext.getContext().put("myorder", map);
				//路径获取
				ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
				//获取导航数据
				ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation(StaticKey.SiteNavigationState.SHOW.getVisible()));
				//获取商城基本数据
				ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo(StaticKey.DataShowState.SHOW.getState(),StaticKey.JshopOpenState.OPEN.getOpenstate()));
				//获取页脚分类数据
				ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT(StaticKey.DataGrade.FIRST.getState(),StaticKey.DataUsingState.USING.getState()));
				//获取页脚文章数据
				ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, this.getDataCollectionTAction().findFooterArticle(StaticKey.DataShowState.SHOW.getState()));
				
				return SUCCESS;
			}
		}
		return INPUT;
		
	}

}
