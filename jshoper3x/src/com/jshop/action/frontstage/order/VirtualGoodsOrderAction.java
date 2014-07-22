package com.jshop.action.frontstage.order;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.pay.thirdpartyplatform.alipay.AlipayConfig;
import com.jshop.action.backstage.staticspage.DataCollectionTAction;
import com.jshop.action.backstage.staticspage.FreeMarkervariable;
import com.jshop.action.backstage.utils.Arith;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.statickey.PaymentCode;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.CartT;
import com.jshop.entity.OrderT;
import com.jshop.entity.PaymentM;
import com.jshop.entity.UserT;
import com.jshop.entity.VirtualShippingAddressT;
import com.jshop.service.CartTService;
import com.jshop.service.OrderTService;
import com.jshop.service.PaymentMService;
import com.jshop.service.VirtualShippingAddressTService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
/**
 * 这个类的支付方式无论是财付通还是支付宝都直接使用即时到帐
 */
public class VirtualGoodsOrderAction extends ActionSupport {

	private Serial serial;
	private CartTService cartTService;
	private PaymentMService paymentMService;
	private OrderTService orderTService;
	private VirtualShippingAddressTService virtualShippingAddressTService;
	private DataCollectionTAction dataCollectionTAction;
	/**
	 * 虚拟收获地址，邮件和手机号码
	 * 
	 */
	private String userid;
	private String username;
	private String mobile;//虚拟手机，充值用
	private String email;//虚拟邮件地址，发送虚拟商品密码和地址
	private Date createtime;
	private String state;
	private String issend;
	private String orderid;
	private Double total;//会员总价
	private Double totalweight;
	private String defaultlogisticsid;
	private Double freight;
	private Double vouchercontent = 0.0;
	private Double totalpoints;
	private String usedvoucherid;
	private String cartgoodsname;
	private String cartgoodsid;
	private int cartneedquantity;
	private String customernotes;
	private String orderTag;
	private String cartid;
	private String hidurl;
	private String goodsid;
	private boolean slogin;
	private String serialidorderid;
	private OrderT order = new OrderT();
	private PaymentM pm=new PaymentM();//支付信息
	private VirtualShippingAddressT vsat=new VirtualShippingAddressT();//发货信息
	private String paymentid;
	private boolean spayment = false;//是否支付信息写入成功标记
	private boolean svirtualshippingaddress=false;//是否增加虚拟发货地址成功标记
	private boolean saddorder = false;//是否订单增加成功标记
	private String paymentcode;//返回给前台的支付方式
	private String paymentinterface;//反馈给前台的支付接口类型
	@JSON(serialize=false)
	public VirtualShippingAddressTService getVirtualShippingAddressTService() {
		return virtualShippingAddressTService;
	}
	public void setVirtualShippingAddressTService(
			VirtualShippingAddressTService virtualShippingAddressTService) {
		this.virtualShippingAddressTService = virtualShippingAddressTService;
	}
	@JSON(serialize=false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	@JSON(serialize=false)
	public CartTService getCartTService() {
		return cartTService;
	}
	public void setCartTService(CartTService cartTService) {
		this.cartTService = cartTService;
	}
	@JSON(serialize=false)
	public PaymentMService getPaymentMService() {
		return paymentMService;
	}
	public void setPaymentMService(PaymentMService paymentMService) {
		this.paymentMService = paymentMService;
	}
	@JSON(serialize=false)
	public OrderTService getOrderTService() {
		return orderTService;
	}
	public void setOrderTService(OrderTService orderTService) {
		this.orderTService = orderTService;
	}
	@JSON(serialize=false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}
	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
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
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIssend() {
		return issend;
	}
	public void setIssend(String issend) {
		this.issend = issend;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	
	
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}
	public OrderT getOrder() {
		return order;
	}
	public void setOrder(OrderT order) {
		this.order = order;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getTotalweight() {
		return totalweight;
	}
	public void setTotalweight(Double totalweight) {
		this.totalweight = totalweight;
	}
	public String getDefaultlogisticsid() {
		return defaultlogisticsid;
	}
	public void setDefaultlogisticsid(String defaultlogisticsid) {
		this.defaultlogisticsid = defaultlogisticsid;
	}
	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	public Double getVouchercontent() {
		return vouchercontent;
	}
	public void setVouchercontent(Double vouchercontent) {
		this.vouchercontent = vouchercontent;
	}
	public Double getTotalpoints() {
		return totalpoints;
	}
	public void setTotalpoints(Double totalpoints) {
		this.totalpoints = totalpoints;
	}
	public String getUsedvoucherid() {
		return usedvoucherid;
	}
	public void setUsedvoucherid(String usedvoucherid) {
		this.usedvoucherid = usedvoucherid;
	}
	public String getCartgoodsname() {
		return cartgoodsname;
	}
	public void setCartgoodsname(String cartgoodsname) {
		this.cartgoodsname = cartgoodsname;
	}
	public String getCartgoodsid() {
		return cartgoodsid;
	}
	public void setCartgoodsid(String cartgoodsid) {
		this.cartgoodsid = cartgoodsid;
	}
	public int getCartneedquantity() {
		return cartneedquantity;
	}
	public void setCartneedquantity(int cartneedquantity) {
		this.cartneedquantity = cartneedquantity;
	}
	
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	public String getHidurl() {
		return hidurl;
	}
	public void setHidurl(String hidurl) {
		this.hidurl = hidurl;
	}
	
	public boolean isSlogin() {
		return slogin;
	}
	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}
	
	
	public String getSerialidorderid() {
		return serialidorderid;
	}
	public void setSerialidorderid(String serialidorderid) {
		this.serialidorderid = serialidorderid;
	}
	
	
	public boolean isSpayment() {
		return spayment;
	}
	public void setSpayment(boolean spayment) {
		this.spayment = spayment;
	}
	
	public boolean isSvirtualshippingaddress() {
		return svirtualshippingaddress;
	}
	public void setSvirtualshippingaddress(boolean svirtualshippingaddress) {
		this.svirtualshippingaddress = svirtualshippingaddress;
	}
	
	public String getCustomernotes() {
		return customernotes;
	}
	public void setCustomernotes(String customernotes) {
		this.customernotes = customernotes;
	}
	
	public String getOrderTag() {
		return orderTag;
	}
	public void setOrderTag(String orderTag) {
		this.orderTag = orderTag;
	}
	
	public boolean isSaddorder() {
		return saddorder;
	}
	public void setSaddorder(boolean saddorder) {
		this.saddorder = saddorder;
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
	public PaymentM getPm() {
		return pm;
	}
	public void setPm(PaymentM pm) {
		this.pm = pm;
	}
	

	public VirtualShippingAddressT getVsat() {
		return vsat;
	}
	public void setVsat(VirtualShippingAddressT vsat) {
		this.vsat = vsat;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	
	/**
	 * 获取支付方式
	 */
	public List<PaymentM> GetDefaultPayment() {
		List<PaymentM> list = this.getPaymentMService().findAllPayment(StaticKey.ONE);
		return list;
		
	}
	/**
	 * 获取购物车中的商品作为订单商品处理
	 * 
	 * @param user
	 */
	public void GetMyCart(UserT user) {
		String state="1";
		String orderTag=null;
		if(Validate.StrisNull(this.getOrderTag())){
			orderTag="";
		}else{
			orderTag=this.getOrderTag().trim();
		}

		List<CartT> list = this.getCartTService().findAllCartByUserId(user.getUserid(),state,orderTag);
		if (list != null) {
			this.setTotal(0.0);
			this.setTotalweight(0.0);
			this.setTotalpoints(0.0);
			this.setCartgoodsname("");
			this.setCartgoodsid("");
			this.setCartneedquantity(0);
			for (Iterator<CartT> it = list.iterator(); it.hasNext();) {
				CartT ct = (CartT) it.next();
				total = Arith.add(total, Arith.mul(ct.getFavorable(), Double.parseDouble(String.valueOf(ct.getNeedquantity()))));
				totalweight = Arith.add(totalweight, Arith.mul(Double.parseDouble(ct.getWeight()), Double.parseDouble(String.valueOf(ct.getNeedquantity()))));
				totalpoints = Arith.add(totalpoints, Arith.mul(ct.getPoints(), Double.parseDouble(String.valueOf(ct.getNeedquantity()))));
				cartgoodsname += ct.getGoodsname();
				cartgoodsid += ct.getGoodsid() + ",";
				cartneedquantity += ct.getNeedquantity();
				cartid = ct.getCartid();//获取购物车中的cartid表示同一个cartid即在同一个订单中
			}
			ActionContext.getContext().put("cart", list);
			ActionContext.getContext().put("totalprice", total);
			ActionContext.getContext().put("totalpoints", totalpoints);
			ActionContext.getContext().put("cartid", cartid);
			ActionContext.getContext().put("cartgoodsid", cartgoodsid);
			ActionContext.getContext().put("cartgoodsname", cartgoodsname);
			ActionContext.getContext().put("cartneedquantity", cartneedquantity);
		}
	}
	/**
	 * 初始化虚拟商品订单所需信息
	 * 
	 * @return
	 */
	@Action(value = "InitvirtualcardOrder", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/shop/confirmvirtualcardorder.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html?redirecturl=${hidurl}")
	})
	public String InitvirtualcardOrder() {
		UserT user = (UserT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (user != null) {
			//跟新下购物车的cartid（特殊）
			updateCartidForVirtualGoodsCard();
//			//获取用户收获地址
//			GetUserDeliverAddress(user);
			//获取物流商
			//GetDefaultLogistictsBusiness();
			//获取支付方式并注入上下文
			ActionContext.getContext().put("payments", GetDefaultPayment());
			//获取购物车中的商品作为订单商品处理
			GetMyCart(user);
			//计算运费
			//GetLogisticsPrice();
			//获取总金额+运费
			Double totalfreight = this.getTotal();
			ActionContext.getContext().put("totalfreight", totalfreight);
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
		return INPUT;

	}
	
	
	/**
	 * 初始化虚拟商品订单所需信息
	 * 
	 * @return
	 */
	@Action(value = "InitvirtualmovieOrder", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/shop/confirmvirtualmovieorder.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html?redirecturl=${hidurl}")
	})
	public String InitvirtualmovieOrder() {
		UserT user = (UserT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (user != null) {
			//跟新下购物车的cartid（特殊）
			updateCartidForVirtualGoodsCard();
//			//获取用户收获地址
//			GetUserDeliverAddress(user);
			//获取物流商
			//GetDefaultLogistictsBusiness();
			//获取支付方式并注入上下文
			ActionContext.getContext().put("payments", GetDefaultPayment());
			//获取购物车中的商品作为订单商品处理
			GetMyCart(user);
			//计算运费
			//GetLogisticsPrice();
			//获取总金额+运费
			Double totalfreight = this.getTotal();
			ActionContext.getContext().put("totalfreight", totalfreight);
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
		return INPUT;

	}
	
	/**
	 * 事先获取订单编号
	 */
	public void GetSerialidorder() {
		
		this.setSerialidorderid(this.getSerial().Serialid(Serial.GROUPORDER));
	}

	
	/**
	 * 增加虚拟发货地址
	 */
	public void AddVirtualCardShippingAddress(UserT user){
		//从前台直接手机号码只是充值卡
		if(Validate.StrNotNull(this.getMobile())){
			VirtualShippingAddressT vsa=new VirtualShippingAddressT();
			vsa.setVirtualshippingaddressid(this.getSerial().Serialid(Serial.VIRTUALSHIPPINGADDRESS));
			vsa.setUserid(user.getUserid());
			vsa.setUsername(user.getUsername());
			vsa.setMobile(this.getMobile().trim());//写入需要充值的号码
			vsa.setEmail("");
			vsa.setCreatetime(BaseTools.systemtime());
			vsa.setState("1");//有对应订单的虚拟发货地址
			vsa.setIssend("0");//未发送过的地址
			vsa.setOrderid(this.getSerialidorderid());//预先获取的订单号
			this.getVirtualShippingAddressTService().save(vsa);
				this.setVsat(vsa);
				this.setSvirtualshippingaddress(true);
			
		}
		
	}
	public void AddVirtualMovieShippingAddress(UserT user){
		//从前台直接手机号码只是充值卡
		if(Validate.StrNotNull(this.getEmail())){
			VirtualShippingAddressT vsa=new VirtualShippingAddressT();
			vsa.setVirtualshippingaddressid(this.getSerial().Serialid(Serial.VIRTUALSHIPPINGADDRESS));
			vsa.setUserid(user.getUserid());
			vsa.setUsername(user.getUsername());
			vsa.setMobile("");
			vsa.setEmail(this.getEmail());
			vsa.setCreatetime(BaseTools.systemtime());
			vsa.setState("1");//有对应订单的虚拟发货地址
			vsa.setIssend("0");//未发送过的地址
			vsa.setOrderid(this.getSerialidorderid());//预先获取的订单号
			this.getVirtualShippingAddressTService().save(vsa);
				this.setVsat(vsa);
				this.setSvirtualshippingaddress(true);
			
			
		}
		
	}
	/**
	 * 设置订单数据（充值卡）
	 * @param user
	 */
	public void initVirtualOrderCardInfo(UserT user){
		order.setOrderid(this.getSerialidorderid());
		order.setUserid(user.getUserid());
		order.setUsername(user.getUsername());
		if (this.getPaymentid().trim().equals("-1")) {
			order.setDelivermode("货到付款");
			//未来获取特定的支付标记来标记货到付款
		}
		order.setDelivermode("CARD");//充值卡模式，代表发货模式
		order.setDeliverynumber("");//发货单号在充值成功后可以回填一个标记序号，到底什么序号暂定
		order.setOrderstate("0");//为确认
		order.setPaystate("0");//未付款
		order.setShippingstate("0");//未发货
		order.setLogisticsid("");//虚拟不需要物流商
		order.setLogisticswebaddress("");//x
//		order.setGoodid(this.getCartgoodsid());//购物车中商品id串
//		order.setGoodsname(this.getCartgoodsname());//购物车中的商品名称串
		
		order.setNeedquantity(this.getCartneedquantity());//购物车中的商品数量串
		order.setFreight(0.0);//因为虚拟所以无运费
		order.setAmount(Arith.sub(Arith.add(this.getTotal(), this.getFreight()),this.getVouchercontent()));
		order.setPoints(this.getTotalpoints());
		order.setPurchasetime(BaseTools.systemtime());
		order.setDeliverytime(null);//虚拟发货时间，在系统支付成功后填充
		order.setDeliverynumber(null);//同上时间点，有系统自行生成一个号码
		order.setIsinvoice("0");//虚拟不开票
		order.setCustomerordernotes(this.getCustomernotes());
		order.setPaytime(null);//订单刚加入没有支付时间
		order.setOrderTag(this.getOrderTag());//这里是虚拟订单充值卡类型
		//order.setToBuyer(null);//给用户留言，这个应该会在后台给出，仅能给出一次
		order.setShouldpay(Arith.sub(Arith.add(this.getTotal(), this.getFreight()), this.getVouchercontent()));//金额包含运费，但不包含优惠
		order.setUsepoints(0.0);//用户使用的积分，目前没提供这个功能故为0
		order.setVouchersid(this.getUsedvoucherid());//使用的优惠券id
		order.setCreatetime(BaseTools.systemtime());
		order.setIsprintexpress("0");//虚拟订单不需要打印快递单
		order.setIsprintinvoice("0");//虚拟订单不需要打印发货单
		order.setIsprintfpinvoice("0");//虚拟订单不需要开发票
		order.setExpressnumber(null);//虚拟订单不需要快递单号
		order.setPaymentid(this.getPm().getPaymentid());
		order.setPaymentname(this.getPm().getPaymentname());
		order.setShippingaddressid(this.getVsat().getVirtualshippingaddressid());//设置虚拟发货地址到订单中
		order.setDeliveraddressid("");//设置收货地址到订单中,虚拟所以为空
		order.setShippingusername("");//设置收货人虚拟所以为空
		this.getOrderTService().save(order);
			this.setSaddorder(true);
		
	}
	/**
	 * 设置订单数据（视频，下载类）
	 * @param user
	 */
	public void initVirtualOrderMovieInfo(UserT user){
		order.setOrderid(this.getSerialidorderid());
		order.setUserid(user.getUserid());
		order.setUsername(user.getUsername());
		if (this.getPaymentid().trim().equals("-1")) {
			order.setDelivermode("货到付款");
			//未来获取特定的支付标记来标记货到付款
		}
		order.setDelivermode("MOVIE");//充值卡模式，代表发货模式
		order.setDeliverynumber("");//发货单号在充值成功后可以回填一个标记序号，到底什么序号暂定
		order.setOrderstate("0");//为确认
		order.setPaystate("0");//未付款
		order.setShippingstate("0");//未发货
		order.setLogisticsid("");//虚拟不需要物流商
		order.setLogisticswebaddress("");//x
//		order.setGoodid(this.getCartgoodsid());//购物车中商品id串
//		order.setGoodsname(this.getCartgoodsname());//购物车中的商品名称串
		order.setNeedquantity(this.getCartneedquantity());//购物车中的商品数量串
		order.setFreight(0.0);//因为虚拟所以无运费
		order.setAmount(Arith.sub(Arith.add(this.getTotal(), this.getFreight()),this.getVouchercontent()));
		order.setPoints(this.getTotalpoints());
		order.setPurchasetime(BaseTools.systemtime());
		order.setDeliverytime(null);//虚拟发货时间，在系统支付成功后填充
		order.setDeliverynumber(null);//同上时间点，有系统自行生成一个号码
		order.setIsinvoice("0");//虚拟不开票
		order.setCustomerordernotes(this.getCustomernotes());
		order.setPaytime(null);//订单刚加入没有支付时间
		order.setOrderTag(this.getOrderTag());//这里是虚拟订单充值卡类型
		order.setToBuyerNotes(null);//给用户留言，这个应该会在后台给出，仅能给出一次
		order.setShouldpay(Arith.sub(Arith.add(this.getTotal(), this.getFreight()), this.getVouchercontent()));//金额包含运费，但不包含优惠
		order.setUsepoints(0.0);//用户使用的积分，目前没提供这个功能故为0
		order.setVouchersid(this.getUsedvoucherid());//使用的优惠券id
		order.setCreatetime(BaseTools.systemtime());
		order.setIsprintexpress("0");//虚拟订单不需要打印快递单
		order.setIsprintinvoice("0");//虚拟订单不需要打印发货单
		order.setIsprintfpinvoice("0");//虚拟订单不需要开发票
		order.setExpressnumber(null);//虚拟订单不需要快递单号
		order.setPaymentid(this.getPm().getPaymentid());
		order.setPaymentname(this.getPm().getPaymentname());
		order.setShippingaddressid(this.getVsat().getVirtualshippingaddressid());//设置虚拟发货地址到订单中
		order.setDeliveraddressid("");//设置收货地址到订单中,虚拟所以为空
		order.setShippingusername("");//设置收货人虚拟所以为空
		this.getOrderTService().save(order);
			this.setSaddorder(true);
		
		
	}
	/**
	 * 在多支付方式情况下初始化订单采用的支付方式所需要的信息
	 */
	public void InitPayway(){
		PaymentM list = this.getPaymentMService().findPaymentbyId(this.getPaymentid().trim());
		if (list != null) {
			this.setPm(list);
			if(PaymentCode.PAYMENT_CODE_TENPAY.equals(list.getPaymentCode())){
				this.setPaymentcode(PaymentCode.PAYMENT_CODE_TENPAY);
				//目前仅做支付宝和财付通的双接口及后台对应的接口类型爽功能接口
				if("3".equals(list.getPaymentInterface())){
					//进行财付通的双接口虚拟即时到帐操作，采集即时到帐需要的数据
					//BuildTenPayConfig();
					this.setPaymentinterface("3");
					this.setSpayment(true);
				}
				this.setSpayment(true);
			}else if(PaymentCode.PAYMENT_CODE_ALIPAY.equals(list.getPaymentCode())){
				this.setPaymentcode(PaymentCode.PAYMENT_CODE_ALIPAY);
				if("3".equals(list.getPaymentInterface())){
					//BuildAlipayConfig();
					this.setPaymentinterface("3");//双接口
					this.setSpayment(true);
				}
				this.setSpayment(true);
			}
		}else{
			this.setSpayment(false);
		}
	}
	
	/**
	 * 开始对TenPay所需数据进行采集
	 */
//	public void BuildTenPayConfig(){
//		TenPayConfig.partner=this.getPm().getPartnerid();//商户号
//		TenPayConfig.key=this.getPm().getSafecode();//密钥
//		TenPayConfig.out_trade_no=order.getOrderid();//订单号
//		int totalfee=(int)(order.getShouldpay()*100);
//		TenPayConfig.total_fee=String.valueOf(totalfee);
//		TenPayConfig.body=order.getOrdername();
//		TenPayConfig.bank_type="DEFAULT";
//		TenPayConfig.subject=order.getOrdername();
//		TenPayConfig.goods_tag=order.getOrderTag();//手机充值虚拟卡
//		TenPayConfig.trade_mode="1";//即时到帐
//		TenPayConfig.trans_type="2";//虚拟交易
//		if(Validate.StrNotNull(this.getMobile())){
//			TenPayConfig.mobile=this.getMobile();
//		}
//		if(Validate.StrNotNull(this.getEmail())){
//			TenPayConfig.email=this.getEmail();
//		}
//		//TenPayConfig.return_url="http://"+this.getDataCollectionTAction().getBasePath()+"pay/tenpay_api_b2c/payReturnUrl.jsp";
//		//TenPayConfig.notify_url="http://"+this.getDataCollectionTAction().getBasePath()+"pay/tenpay_api_b2c/payNotifyUrl.jsp";
//	}
	
	
	/**
	 * 开始对支付宝采集数据
	 */
	public void BuildAlipayConfig(){
		AlipayConfig.partner = this.getPm().getPartnerid();
		AlipayConfig.key = this.getPm().getSafecode();
		AlipayConfig.seller_email = this.getPm().getAccount();
		AlipayConfig.out_trade_no = order.getOrderid();
		AlipayConfig.subject = order.getOrdername();
		AlipayConfig.body = order.getOrdername();
		AlipayConfig.price = String.valueOf(order.getShouldpay());
		AlipayConfig.logistics_fee = String.valueOf(order.getFreight());
		//设置收货人信息给支付宝借口
//		AlipayConfig.receive_name = this.getDt().getUsername();
//		AlipayConfig.receive_address = this.getDt().getProvince() + this.getDt().getCity() + this.getDt().getDistrict() + this.getDt().getStreet();
//		AlipayConfig.reveive_zip = this.getDt().getPostcode();
//		AlipayConfig.reveive_phone = this.getDt().getTelno();
//		AlipayConfig.reveive_mobile = this.getDt().getMobile();
	}
	/**
	 * 获取支付需要的订单信息(充值卡系列，虚拟发货地址仅获取电话号码)
	 * 
	 * @return
	 */
	@Action(value = "InitpayneedInfoVirtualGoodsCard", results = { 
			@Result(name = "json",type="json")
	})
	public String InitpayneedInfoVirtualGoodsCard() {
		UserT user = (UserT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (user != null) {
			this.setSlogin(true);
			
			//预先生成订单编号
			GetSerialidorder();
			//增加虚拟收获信息到虚拟发货地址表中一般都是邮件和手机作为地址
			AddVirtualCardShippingAddress(user);
			//这里开始我根据选择的支付方式进行不同的支付实现
			InitPayway();
			//增加订单到数据库
			initVirtualOrderCardInfo(user);
			if (this.isSaddorder()) {
				if(PaymentCode.PAYMENT_CODE_ALIPAY.equals(this.getPm().getPaymentCode())){
					BuildAlipayConfig();
				}else if(PaymentCode.PAYMENT_CODE_TENPAY.equals(this.getPm().getPaymentCode())){
					//BuildTenPayConfig();
				}
				
				//更新购物车商品到3，表示已经在订单中。并把对应订单号更新
				//String []tempgoodsid=order.getGoodid().split(",");
				//检查如果购物已经有对应的订单号则不更新
				//3表示加入订单的购物车
				List<CartT>list=this.getCartTService().findCartByCartid(this.getCartid(), "3");
				if(!list.isEmpty()){
					return "json";
				}
				this.getCartTService().updateCartStateandOrderidByGoodsidList(this.getCartid().trim(), this.getSerialidorderid(), user.getUserid(), "3");
			}
			return "json";

		}
		this.setSlogin(false);
		return "json";
	}
	/**
	 * 获取支付需要的订单信息(充值卡系列，虚拟发货地址仅获取电话号码)
	 * 
	 * @return
	 */
	@Action(value = "InitpayneedInfoVirtualGoodsmovie", results = { 
			@Result(name = "json",type="json")
	})
	public String InitpayneedInfoVirtualGoodsmovie() {
		UserT user = (UserT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (user != null) {
			this.setSlogin(true);
			
			//预先生成订单编号
			GetSerialidorder();
			//增加虚拟收获信息到虚拟发货地址表中一般都是邮件和手机作为地址
			AddVirtualMovieShippingAddress(user);
			//这里开始我根据选择的支付方式进行不同的支付实现
			InitPayway();
			//增加订单到数据库
			initVirtualOrderMovieInfo(user);
			if (this.isSaddorder()) {
				if(PaymentCode.PAYMENT_CODE_ALIPAY.equals(this.getPm().getPaymentCode())){
					BuildAlipayConfig();
				}else if(PaymentCode.PAYMENT_CODE_TENPAY.equals(this.getPm().getPaymentCode())){
					//BuildTenPayConfig();
				}
				
				//更新购物车商品到3，表示已经在订单中。并把对应订单号更新
				//String []tempgoodsid=order.getGoodid().split(",");
				//检查如果购物已经有对应的订单号则不更新
				//3表示加入订单的购物车
				List<CartT>list=this.getCartTService().findCartByCartid(this.getCartid(), "3");
				if(!list.isEmpty()){
					return "json";
				}
				this.getCartTService().updateCartStateandOrderidByGoodsidList(this.getCartid().trim(), this.getSerialidorderid(), user.getUserid(), "3");
			}
			return "json";

		}
		this.setSlogin(false);
		return "json";
	}
	
	
	
	/**
	 * 给在购物车中的虚拟卡类商品添加唯一cardid号
	 * @return
	 */
	public void updateCartidForVirtualGoodsCard(){
		UserT user = (UserT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (user != null) {
			String cartid=this.getSerial().Serialid(Serial.CART);//获取购物车信息id是可重复的。一次提交只有一个购物车信息id,标记这批商品被标记在同一个订单中
			int i=this.getCartTService().updateCartIdBygoodsid(cartid, user.getUserid(), this.getGoodsid(), "1");
			
		}
	}
	
	
}
