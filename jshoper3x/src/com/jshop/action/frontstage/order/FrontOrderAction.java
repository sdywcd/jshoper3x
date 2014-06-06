package com.jshop.action.frontstage.order;

import java.text.ParseException;
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
import com.jshop.entity.DeliverAddressT;
import com.jshop.entity.LogisticsBusinessT;
import com.jshop.entity.LogisticsbusinessareaT;
import com.jshop.entity.MemberT;
import com.jshop.entity.OrderT;
import com.jshop.entity.PaymentM;
import com.jshop.entity.ShippingAddressT;
import com.jshop.entity.UserT;
import com.jshop.entity.VouchersT;
import com.jshop.service.CartTService;
import com.jshop.service.DeliverAddressTService;
import com.jshop.service.LogisticsBusinessTService;
import com.jshop.service.LogisticsbusinessareaTService;
import com.jshop.service.OrderTService;
import com.jshop.service.PaymentMService;
import com.jshop.service.ShippingAddressTService;
import com.jshop.service.VouchersTService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class FrontOrderAction extends ActionSupport {
	private DeliverAddressTService deliverAddressTService;
	private Serial serial;
	private CartTService cartTService;
	private LogisticsBusinessTService logisticsBusinessTService;
	private PaymentMService paymentMService;
	private LogisticsbusinessareaTService logisticsbusinessareaTService;
	private VouchersTService vouchersTService;
	private ShippingAddressTService shippingAddressTService;
	private OrderTService orderTService;
	private DataCollectionTAction dataCollectionTAction;
	
	/**
	 * 收获地址区域变量
	 */
	private String addressid;
	private String userid;
	private String username;
	private String province;
	private String city;
	private String district;
	private String street;
	private String postcode;
	private String telno;
	private String mobile;
	private String email;
	private String state;
	private String shippingusername;
	private String serialidorderid;
	private OrderT order = new OrderT();
	private String paymentid;
	private String logisticsid;
	private String logisticswebaddress;
	private String totalfreight;
	private String vouchername;
	private String customernotes;
	private String orderTag;
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
	private static String mainpicture;//订单中显示的主图片
	private String cartid;
	private String hidurl;
	private String redirecturl;
	private PaymentM pm=new PaymentM();
	private DeliverAddressT dt=new DeliverAddressT();
	private boolean sflag = false;
	private boolean svoucher = false;
	private boolean spayment = false;//是否支付信息写入成功标记
	private boolean sshoppingaddress = false;
	private boolean saddorder = false;
	private boolean supdatecart = false;
	private boolean slogin;
	private String paymentcode;//返回给前台的支付方式
	private String paymentinterface;//反馈给前台的支付接口类型
	private String basePath;
	
	@JSON(serialize = false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}

	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
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
	public LogisticsbusinessareaTService getLogisticsbusinessareaTService() {
		return logisticsbusinessareaTService;
	}

	public void setLogisticsbusinessareaTService(LogisticsbusinessareaTService logisticsbusinessareaTService) {
		this.logisticsbusinessareaTService = logisticsbusinessareaTService;
	}
	@JSON(serialize = false)
	public VouchersTService getVouchersTService() {
		return vouchersTService;
	}

	public void setVouchersTService(VouchersTService vouchersTService) {
		this.vouchersTService = vouchersTService;
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
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}


	public OrderT getOrder() {
		return order;
	}

	public void setOrder(OrderT order) {
		this.order = order;
	}

	public String getAddressid() {
		return addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}

	public String getTotalfreight() {
		return totalfreight;
	}

	public void setTotalfreight(String totalfreight) {
		this.totalfreight = totalfreight;
	}

	public Double getTotalpoints() {
		return totalpoints;
	}

	public void setTotalpoints(Double totalpoints) {
		this.totalpoints = totalpoints;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHidurl() {
		return hidurl;
	}

	public void setHidurl(String hidurl) {
		this.hidurl = hidurl;
	}

	public boolean isSflag() {
		return sflag;
	}

	public void setSflag(boolean sflag) {
		this.sflag = sflag;
	}

	public String getShippingusername() {
		return shippingusername;
	}

	public void setShippingusername(String shippingusername) {
		this.shippingusername = shippingusername;
	}

	public String getCartgoodsname() {
		return cartgoodsname;
	}

	public void setCartgoodsname(String cartgoodsname) {
		this.cartgoodsname = cartgoodsname;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getDefaultlogisticsid() {
		return defaultlogisticsid;
	}

	public void setDefaultlogisticsid(String defaultlogisticsid) {
		this.defaultlogisticsid = defaultlogisticsid;
	}

	public Double getTotalweight() {
		return totalweight;
	}

	public void setTotalweight(Double totalweight) {
		this.totalweight = totalweight;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public String getVouchername() {
		return vouchername;
	}

	public void setVouchername(String vouchername) {
		this.vouchername = vouchername;
	}

	public boolean isSvoucher() {
		return svoucher;
	}

	public void setSvoucher(boolean svoucher) {
		this.svoucher = svoucher;
	}

	public String getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

	public Double getVouchercontent() {
		return vouchercontent;
	}

	public void setVouchercontent(Double vouchercontent) {
		this.vouchercontent = vouchercontent;
	}

	public int getCartneedquantity() {
		return cartneedquantity;
	}

	public void setCartneedquantity(int cartneedquantity) {
		this.cartneedquantity = cartneedquantity;
	}

	public boolean isSupdatecart() {
		return supdatecart;
	}

	public void setSupdatecart(boolean supdatecart) {
		this.supdatecart = supdatecart;
	}

	public String getCartgoodsid() {
		return cartgoodsid;
	}

	public void setCartgoodsid(String cartgoodsid) {
		this.cartgoodsid = cartgoodsid;
	}

	public boolean isSaddorder() {
		return saddorder;
	}

	public void setSaddorder(boolean saddorder) {
		this.saddorder = saddorder;
	}

	public String getOrderTag() {
		return orderTag;
	}

	public void setOrderTag(String orderTag) {
		this.orderTag = orderTag;
	}

	public String getCustomernotes() {
		return customernotes;
	}

	public void setCustomernotes(String customernotes) {
		this.customernotes = customernotes;
	}

	public boolean isSshoppingaddress() {
		return sshoppingaddress;
	}

	public void setSshoppingaddress(boolean sshoppingaddress) {
		this.sshoppingaddress = sshoppingaddress;
	}

	public String getLogisticsid() {
		return logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}

	public boolean isSpayment() {
		return spayment;
	}

	public void setSpayment(boolean spayment) {
		this.spayment = spayment;
	}

	public String getUsedvoucherid() {
		return usedvoucherid;
	}

	public void setUsedvoucherid(String usedvoucherid) {
		this.usedvoucherid = usedvoucherid;
	}

	public String getSerialidorderid() {
		return serialidorderid;
	}

	public void setSerialidorderid(String serialidorderid) {
		this.serialidorderid = serialidorderid;
	}

	public String getLogisticswebaddress() {
		return logisticswebaddress;
	}

	public void setLogisticswebaddress(String logisticswebaddress) {
		this.logisticswebaddress = logisticswebaddress;
	}

	public String getCartid() {
		return cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}

	public String getRedirecturl() {
		return redirecturl;
	}

	public void setRedirecturl(String redirecturl) {
		this.redirecturl = redirecturl;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public PaymentM getPm() {
		return pm;
	}

	public void setPm(PaymentM pm) {
		this.pm = pm;
	}

	public DeliverAddressT getDt() {
		return dt;
	}

	public void setDt(DeliverAddressT dt) {
		this.dt = dt;
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

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getMainpicture() {
		return mainpicture;
	}

	public void setMainpicture(String mainpicture) {
		this.mainpicture = mainpicture;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	//初始化订单操作，包括收货地址是否已经有了。有就读取出来没有就增加新的，涉及保存新收获地址，
	//读取出新购物车内容，读取出默认的物流商，读取出默认的支付方式，保存订单需要同时保存发货地址
	//发票初始化，支付宝对接
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
		if (!list.isEmpty()) {
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
	 * 获取购物车中的商品作为订单商品处理
	 * 
	 * @param user
	 */
	public void GetMyCart(MemberT memberT) {
		String state="1";
		String orderTag="1";
		List<CartT> list = this.getCartTService().findAllCartByMemberId(memberT.getId(),state,orderTag);
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
				if(ct.getWeight()!=null){
					totalweight = Arith.add(totalweight, Arith.mul(Double.parseDouble(ct.getWeight()), Double.parseDouble(String.valueOf(ct.getNeedquantity()))));
				}
				totalpoints = Arith.add(totalpoints, Arith.mul(ct.getPoints(), Double.parseDouble(String.valueOf(ct.getNeedquantity()))));
				
				cartgoodsname=ct.getGoodsname();
				cartgoodsid += ct.getGoodsid() + ",";
				cartneedquantity += ct.getNeedquantity();
				cartid = ct.getCartid();//获取购物车中的cartid表示同一个cartid即在同一个订单中
				mainpicture=ct.getPicture();
			}
			ActionContext.getContext().put(FreeMarkervariable.MEMBERCART, list);
			ActionContext.getContext().put(FreeMarkervariable.TOTALPRICE, total);
			ActionContext.getContext().put(FreeMarkervariable.TOTALPOINTS, totalpoints);
			ActionContext.getContext().put(FreeMarkervariable.CARTID, cartid);
			ActionContext.getContext().put(FreeMarkervariable.CARTGOODSID, cartgoodsid);
			ActionContext.getContext().put(FreeMarkervariable.CARTGOODSNAME, cartgoodsname);
			ActionContext.getContext().put(FreeMarkervariable.CARTNEEDQUANTITY, cartneedquantity);
		}
	}

	/**
	 * 计算运费
	 */
	private void GetLogisticsPrice() {
		Double temptotal = this.getTotal();
		List<LogisticsbusinessareaT> list = this.getLogisticsbusinessareaTService().findAllLogisticsbusinessareaTBylogisticsid(this.getDefaultlogisticsid());
		if (list != null) {
			Double tempfreight = 0.0;
			int tempy = 0;
			for (Iterator it = list.iterator(); it.hasNext();) {
//				LogisticsbusinessareaT lbt = (LogisticsbusinessareaT) it.next();
//				if (this.getTotal() > lbt.getNeedcostmin() && this.getTotal() < lbt.getNeedcostmax() && this.getTotalweight() < lbt.getOvervalue()) {
//					tempfreight = lbt.getNormalcost();
//					tempy = (int) (this.getTotalweight() / 1000);
//				} else if (this.getTotal() > lbt.getNeedcostmin() && this.getTotal() < lbt.getNeedcostmax() && this.getTotalweight() < lbt.getOvervalue()) {
//					tempfreight = 0.0;
//					tempy = (int) (this.getTotalweight() / 1000);
//				} else {
//					tempfreight = 0.0;
//					tempy = (int) (this.getTotalweight() / 1000);
//				}
			}
			Double freight = tempfreight + tempy;
			this.setFreight(freight);
			ActionContext.getContext().put(FreeMarkervariable.FREIGHT, freight);

		}

	}

	/**
	 * 初始化订单所需信息
	 * 
	 * @return
	 */
	@Action(value = "initOrder", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/shop/confirmorder.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html?redirecturl=${redirecturl}")
	})
	public String initOrder() {
		MemberT memberT = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (memberT != null) {
			//获取用户收获地址
			GetUserDeliverAddress(memberT);
			//获取物流商
			GetDefaultLogistictsBusiness();
			//获取支付方式
			GetDefaultPayment();
			//获取购物车中的商品作为订单商品处理
			GetMyCart(memberT);
			//计算运费
			GetLogisticsPrice();
			//获取总金额+运费
			Double totalfreight = this.getTotal() + this.getFreight();
			ActionContext.getContext().put(FreeMarkervariable.TOTALFREIGHT, totalfreight);
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
	 * 根据编码兑现抵用券
	 * 
	 * @return
	 * @throws ParseException
	 */
	@Action(value = "GetVouchersByname", results = { 
			@Result(name = "json",type="json")
	})
	public String GetVouchersByname() throws ParseException {
		UserT user = (UserT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (user != null) {
			if (Validate.StrNotNull(this.getVouchername())) {
				VouchersT v = this.getVouchersTService().findVouchersForHonor(this.getVouchername());
				if (v != null) {
					this.setVouchercontent(Double.parseDouble(v.getVoucherscontent()));
					this.setUsedvoucherid(v.getVouchersid());
					this.setSvoucher(false);
					return "json";
				}
				return "json";
			} else {
				this.setSvoucher(true);
				return "json";
			}

		} else {
			return "json";
		}

	}

	/**
	 *获取支付信息
	 * 
	 * @return
	 */
//	public void GetPaymentinfo() {
//		PaymentM list = this.getPaymentMService().findPaymentbyId(this.getPaymentid().trim());
//		if (list != null) {
//			AlipayConfig.partner = list.getPartnerid();
//			AlipayConfig.key = list.getSafecode();
//			AlipayConfig.seller_email = list.getAccount();
//			//把支付方式id和名称增加到order中
//			order.setPaymentid(list.getPaymentid());
//			order.setPaymentname(list.getPaymentname());
//			this.setSpayment(true);
//		} else {
//			this.setSpayment(false);
//		}
//	}

	/**
	 * 设置订单数据
	 * 
	 * @return
	 */
	public void initOrderInfo(MemberT member) {
		order.setOrderid(this.getSerialidorderid());
		order.setUserid(member.getId());
		order.setUsername(member.getLoginname());
		order.setMemberid(member.getId());
		order.setMembername(member.getLoginname());
		//未来需要在这里处理是平邮还是快递或者是ems，这样物流商需要选择是平邮还是快递还是ems
		if (this.getPaymentid().trim().equals("-1")) {
			order.setDelivermode("货到付款");
			//未来获取特定的支付标记来标记货到付款
		}
		order.setDelivermode("EXPRESS");
		order.setDeliverynumber("");//发货单号在发货后填写
		order.setOrderstate("0");//待确认
		order.setPaystate("0");//未付款
		order.setShippingstate("0");//未发货
		order.setLogisticsid(this.getLogisticsid().trim());
		order.setLogisticswebaddress(this.getLogisticswebaddress());
		//这部分的逻辑需要修改，需要组织json来填写productinfo
		//order.setGoodid(this.getCartgoodsid());
		order.setProductinfo(this.getCartgoodsid());
		//order.setGoodsname(this.getCartgoodsname());
		order.setOrdername(this.getCartgoodsname());
		order.setMainpicture(this.getMainpicture());
		order.setNeedquantity(this.getCartneedquantity());
		order.setFreight(this.getFreight());//运费，在request中也有
		//		if(!this.isSvoucher()){

		order.setAmount(Arith.sub(Arith.add(this.getTotal(), this.getFreight()), this.getVouchercontent()));
		//		}else{
		//			order.setAmount(this.getTotal()+this.getFreight());//金额，含运费
		//		}
		order.setPoints(this.getTotalpoints());
		order.setPurchasetime(BaseTools.systemtime());
		order.setDeliverytime(null);
		order.setDeliverynumber(null);
		//发票处理
		order.setIsinvoice("0");//目前前台没有开票，如果要这里需要动态取得为1
		order.setCustomerordernotes(this.getCustomernotes());
		order.setPaytime(null);
		order.setOrderTag(this.getOrderTag());
		order.setToBuyerNotes(null);//给用户的留言
		//		if(!this.isSvoucher()){
		order.setShouldpay(Arith.sub(Arith.add(this.getTotal(), this.getFreight()), this.getVouchercontent()));
		//		}else{
		//			order.setShouldpay(this.getTotal()+this.getFreight());//金额，含运费
		//		}
		order.setUsepoints(0.0);//用户没有使用积分
		order.setVouchersid(this.getUsedvoucherid());
		order.setCreatetime(BaseTools.systemtime());
		order.setIsprintexpress("0");//未打印快递单
		order.setIsprintinvoice("0");//未打印发货单
		order.setIsprintfpinvoice("0");//未开具发票
		order.setExpressnumber(null);//快递单号
		order.setPaymentid(this.getPm().getPaymentid());
		order.setPaymentname(this.getPm().getPaymentname());
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
			if(PaymentCode.PAYMENT_CODE_ALIPAY.equals(list.getPaymentCode())){
				this.setPaymentcode(PaymentCode.PAYMENT_CODE_ALIPAY);
				if("3".equals(list.getPaymentInterface())){
					//BuildAlipayConfig();
					this.setPaymentinterface("3");//双接口
					this.setSpayment(true);
				}
				//把支付方式id和名称增加到order中
				order.setPaymentid(list.getPaymentid());
				order.setPaymentname(list.getPaymentname());
				this.setSpayment(true);
			}else if(PaymentCode.PAYMENT_CODE_TENPAY.equals(list.getPaymentCode())){
				this.setPaymentcode(PaymentCode.PAYMENT_CODE_TENPAY);
				if("3".equals(list.getPaymentInterface())){
					//进行财付通的双接口虚拟即时到帐操作，采集即时到帐需要的数据
					//BuildTenPayConfig();
					this.setPaymentinterface("3");
					this.setSpayment(true);
				}
				order.setPaymentid(this.getPaymentid());
				order.setPaymentname(list.getPaymentname());
				this.setSpayment(true);
			}
		} else {
			this.setSpayment(false);
		}
	}
	
	/**
	 * 开始对支付宝采集数据
	 */
	public void BuildAlipayConfig(){
		AlipayConfig.partner = this.getPm().getPartnerid();
		AlipayConfig.key = this.getPm().getSafecode();
		AlipayConfig.seller_email = this.getPm().getAccount();
		AlipayConfig.out_trade_no = order.getOrderid();
		AlipayConfig.subject = order.getOrdername();//这里获取productinfo的第一个json的productname
		AlipayConfig.body = order.getOrdername();//获取productinfo所有的productname
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
//		TenPayConfig.mobile=this.getMobile();
//		//TenPayConfig.return_url="http://"+this.getDataCollectionTAction().getBasePath()+"pay/tenpay_api_b2c/payReturnUrl.jsp";
//		//TenPayConfig.notify_url="http://"+this.getDataCollectionTAction().getBasePath()+"pay/tenpay_api_b2c/payNotifyUrl.jsp";
//	}
	
	/**
	 * 增加发货地址
	 */
	public void AddShippingAddress() {
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
			s.setState("1");
			s.setDeliveraddressid(list.getAddressid());
			s.setIssend("0");//未发送到这个地址过
			s.setOrderid(this.getSerialidorderid());//设置订单号
			this.getShippingAddressTService().save(s);
				this.setDt(list);//将收获地址信息存入dt
				this.setSshoppingaddress(false);//这里应该改成true比较好
				order.setShippingaddressid(s.getShippingaddressid());//设置发货地址到订单中
				order.setDeliveraddressid(list.getAddressid());//设置收货地址到订单中
				order.setShippingusername(list.getShippingusername());//设置收货人
//			} else {
//				this.setSshoppingaddress(true);
//			}
		}
	}
	

	/**
	 * 事先获取订单编号
	 */
	public void getSerialidorder() {
		this.setSerialidorderid(this.getSerial().Serialid(Serial.ORDER));
	}

	/**
	 * 获取支付宝需要的订单信息
	 * 1,预先生成一个订单id
	 * 2,增加收货地址信息到发货地址表中
	 * 3,获取支付通道信息
	 * 4,增加订单到数据表中
	 * 5,将支付信息绑定到支付宝接口中
	 * 6,更新购物车中的商品到已加入订单状态并将订单id和购物车记录绑定
	 * @return
	 */
	@Action(value = "InitAlipayneedInfo", results = { 
			@Result(name = "json",type="json")
	})
	public String initAlipayneedInfo() {
		this.setBasePath(this.getDataCollectionTAction().getBasePath());
		MemberT member = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (member != null) {
			this.setSlogin(true);
			//预先生成订单编号
			getSerialidorder();
			//增加收获信息到发货地址表中
			AddShippingAddress();
			//获取支付信息
			InitPayway();
			//增加订单到数据库
			initOrderInfo(member);
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
				this.getCartTService().updateCartStateandOrderidByGoodsidList(this.getCartid().trim(), this.getSerialidorderid(), member.getId(), "3");
			}
			return "json";

		}
		this.setSlogin(false);
		return "json";
	}
}
