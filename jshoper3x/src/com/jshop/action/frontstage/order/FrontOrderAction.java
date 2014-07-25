package com.jshop.action.frontstage.order;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

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
import com.jshop.action.backstage.utils.Arith;
import com.jshop.action.backstage.utils.BaseTools;
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
import com.jshop.entity.VouchersT;
import com.jshop.service.CartTService;
import com.jshop.service.DeliverAddressTService;
import com.jshop.service.LogisticsBusinessTService;
import com.jshop.service.LogisticsbusinessareaTService;
import com.jshop.service.OrderBaseProcessTService;
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
	@Resource
	private OrderBaseProcessTService orderBaseProcessTService;
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
	private boolean sshoppingaddress = false;//是否发货地址写入成功
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

	/**
	 * 事先获取订单编号
	 */
	public void getSerialidorder() {
		this.setSerialidorderid(this.getSerial().Serialid(Serial.ORDER));
	}

	/**
	 * 初始化订单所需信息
	 * 1,获取用户收获地址列表,有就读取出来没有就增加新的，涉及保存新收获地址
	 * 2，获取物流商信息
	 * 3，获取支付方式
	 * 4，获取购物车中的商品数据并进行重量信息计算
	 * 5，计算运费
	 * 6，计算总金额包含运费
	 * 保存订单需要同时保存发货地址
	 * 发票初始化，支付宝对接
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
			ActionContext.getContext().put(FreeMarkervariable.DELIVERADDRESS, orderBaseProcessTService.getMemberDeliverAddress(memberT));
			//获取物流商 需要设定一个默认物流商来计算运费
			ActionContext.getContext().put(FreeMarkervariable.LOGISTICS, orderBaseProcessTService.getLogisticstsBusiness(StaticKey.ONE));
			//获取支付方式
			ActionContext.getContext().put(FreeMarkervariable.PAYMENTS, orderBaseProcessTService.getPaymentM(StaticKey.ONE));
			//获取购物车中的商品
			List<CartT>list= orderBaseProcessTService.getMemberCart(memberT.getId(), StaticKey.ONE, StaticKey.ORDERTAG_NORMAL);
			ActionContext.getContext().put(FreeMarkervariable.MEMBERCART,list);
			//计算购物车信息
			getMemberCartInfo(list);
			//获取总价
			ActionContext.getContext().put(FreeMarkervariable.TOTALPRICE, total);
			//获取总积分
			ActionContext.getContext().put(FreeMarkervariable.TOTALPOINTS, totalpoints);
			//获取购物车ID
			ActionContext.getContext().put(FreeMarkervariable.CARTID, cartid);
			//获取购物车中商品ID串
			ActionContext.getContext().put(FreeMarkervariable.CARTGOODSID, cartgoodsid);
			//获取购物车中商品名称串
			ActionContext.getContext().put(FreeMarkervariable.CARTGOODSNAME, cartgoodsname);
			//获取购物车中商品总数
			ActionContext.getContext().put(FreeMarkervariable.CARTNEEDQUANTITY, cartneedquantity);
			//运费
			ActionContext.getContext().put(FreeMarkervariable.FREIGHT, getLogisticsPrice());
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
		MemberT membert = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (membert != null) {
			this.setSlogin(true);
			//预先生成订单编号
			getSerialidorder();
			//新增收货地址
			DeliverAddressT da=getDeliverAddress(this.getAddressid());
			if(da!=null){
				//增加收获信息到发货地址表中
				ShippingAddressT s=saveShippingAddress(da);
				//获取支付信息
				PaymentM pm=getPayway(this.getPaymentid().trim());
				if(pm!=null){
					//增加订单到数据库
					saveOrderInfo(membert,pm,da,s);
					if (isSaddorder()) {
						if(PaymentCode.PAYMENT_CODE_ALIPAY.equals(pm.getPaymentCode())){
							BuildAlipayConfig();
						}else if(PaymentCode.PAYMENT_CODE_TENPAY.equals(pm.getPaymentCode())){
							//进行财付通的双接口虚拟即时到帐操作，采集即时到帐需要的数据
							//BuildTenPayConfig();
						}
						//更新购物车商品到3，表示已经在订单中。并把对应订单号更新
						//检查如果购物已经有对应的订单号则不更新
						//3表示加入订单的购物车
						this.getCartTService().updateCartStateandOrderidByGoodsidList(this.getCartid().trim(), this.getSerialidorderid(), membert.getId(), StaticKey.CARTSTATE_RELBYORDER_NUM);
//							List<CartT>list=this.getCartTService().findCartByCartid(this.getCartid(), StaticKey.THREE);
//							if(!list.isEmpty()){
//								return "json";
//							}
						//这里为何要在查询一个已经加入订单的购物车信息？？？？
					
					}
				}
	
			}
			return "json";
		}
		this.setSlogin(false);
		return "json";
	}
	
	/**
	 * 获取购物车中的商品作为订单商品处理
	 * 
	 * 
	 */
	public void getMemberCartInfo(List<CartT> list) {
		if (!list.isEmpty()) {
			this.setTotal(0.0);
			this.setTotalweight(0.0);
			this.setTotalpoints(0.0);
			this.setCartgoodsname(StaticKey.EMPTY);
			this.setCartgoodsid(StaticKey.EMPTY);
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
				mainpicture=ct.getPicture();//用于订单界面中显示一个主图
			}
		}
	}

	/**
	 * 计算运费
	 */
	private double getLogisticsPrice() {
		//Double temptotal = this.getTotal();
		Double freight=0.0;
		List<LogisticsBusinessT>lblist=orderBaseProcessTService.getDefaultLogisticsBusinessT(StaticKey.ONE);
		if(lblist!=null&&lblist.size()>0){
			List<LogisticsbusinessareaT> list = orderBaseProcessTService.getDefaultLogisticsbusinessareaT(lblist.get(0).getLogisticsid());
			if (list != null) {
				Double tempfreight = 0.0;
				int tempy = 0;
				for (Iterator it = list.iterator(); it.hasNext();) {
//					LogisticsbusinessareaT lbt = (LogisticsbusinessareaT) it.next();
//					if (this.getTotal() > lbt.getNeedcostmin() && this.getTotal() < lbt.getNeedcostmax() && this.getTotalweight() < lbt.getOvervalue()) {
//						tempfreight = lbt.getNormalcost();
//						tempy = (int) (this.getTotalweight() / 1000);
//					} else if (this.getTotal() > lbt.getNeedcostmin() && this.getTotal() < lbt.getNeedcostmax() && this.getTotalweight() < lbt.getOvervalue()) {
//						tempfreight = 0.0;
//						tempy = (int) (this.getTotalweight() / 1000);
//					} else {
//						tempfreight = 0.0;
//						tempy = (int) (this.getTotalweight() / 1000);
//					}
				}
				freight = tempfreight + tempy;
				this.setFreight(freight);
			}
		}
		return freight;

	}

	
	/**
	 * 根据编码兑现抵用券
	 * 
	 * @return
	 * @throws ParseException
	 */
	@Action(value = "getVouchersByname", results = { 
			@Result(name = "json",type="json")
	})
	public String getVouchersByname() throws ParseException {
		MemberT membert = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (membert != null) {
			if (StringUtils.isNotBlank(this.getVouchername())) {
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
	 * 设置订单数据
	 * 
	 * @return
	 */
	public void saveOrderInfo(MemberT membert,PaymentM pm,DeliverAddressT da,ShippingAddressT s) {
		order.setOrderid(this.getSerialidorderid());
		order.setUserid(membert.getId());
		order.setUsername(membert.getLoginname());
		order.setMemberid(membert.getId());
		order.setMembername(membert.getLoginname());
		//未来需要在这里处理是平邮还是快递或者是ems，这样物流商需要选择是平邮还是快递还是ems
		if (this.getPaymentid().trim().equals(StaticKey.PAY_ON_DELIVERY_TAG)) {
			order.setDelivermode(StaticKey.PAY_ON_DELIVERY);
			//未来获取特定的支付标记来标记货到付款
		}else{
			//快递
			order.setDelivermode(StaticKey.DELIVERMODE_EXPRESS);
		}
		order.setDeliverynumber(StaticKey.EMPTY);//发货单号在发货后填写
		order.setOrderstate(StaticKey.ORDERSTATE_UNCONFIRMED_ZERO_NUM);//待确认
		order.setPaystate(StaticKey.PAYSTATE_NOT_PAID_ZERO_NUM);//未付款
		order.setShippingstate(StaticKey.SHIPPINGSTATE_NOT_DELIVER_ZERO_NUM);//未发货
		order.setLogisticsid(this.getLogisticsid().trim());
		order.setLogisticswebaddress(this.getLogisticswebaddress());//物流商网站需要通过查询获得
		//这部分的逻辑需要修改，需要组织json来填写productinfo
		order.setProductinfo(this.getCartgoodsid());
		order.setOrdername(this.getCartgoodsname());
		order.setMainpicture(this.getMainpicture());
		order.setNeedquantity(this.getCartneedquantity());
		order.setFreight(this.getFreight());//运费，在request中也有
		//		if(!this.isSvoucher()){
		//不包含运费的订单价格
		order.setAmount(Arith.sub(Arith.add(this.getTotal(), this.getFreight()), this.getVouchercontent()));
		//		}else{
		//			order.setAmount(this.getTotal()+this.getFreight());//金额，含运费
		//		}
		order.setPoints(this.getTotalpoints());
		order.setPurchasetime(BaseTools.systemtime());
		order.setDeliverytime(null);
		order.setDeliverynumber(StaticKey.EMPTY);
		//发票处理
		order.setIsinvoice(StaticKey.PINVOICE_NOT_PRINT_ZERO_NUM);//目前前台没有开票，如果要这里需要动态取得为1
		order.setCustomerordernotes(this.getCustomernotes());
		order.setPaytime(null);
		order.setOrderTag(this.getOrderTag());
		order.setToBuyerNotes(StaticKey.EMPTY);//给用户的留言
		//		if(!this.isSvoucher()){
		//包含运费的订单价格，此价格是用户需支付的
		order.setShouldpay(Arith.sub(Arith.add(this.getTotal(), this.getFreight()), this.getVouchercontent()));
		//		}else{
		//			order.setShouldpay(this.getTotal()+this.getFreight());//金额，含运费
		//		}
		order.setUsepoints(0.0);//用户没有使用积分
		order.setVouchersid(this.getUsedvoucherid());
		order.setCreatetime(BaseTools.systemtime());
		order.setUpdatetime(order.getCreatetime());
		order.setIsprintexpress(StaticKey.EXPRESS_NOT_PRINT_ZERO_NUM);//未打印快递单
		order.setIsprintinvoice(StaticKey.INVOICE_NOT_PRINT_ZERO_NUM);//未打印发货单
		order.setIsprintfpinvoice(StaticKey.PINVOICE_NOT_PRINT_ZERO_NUM);//未开具发票
		order.setExpressnumber(StaticKey.EMPTY);//快递单号
		order.setPaymentid(pm.getPaymentid());
		order.setPaymentname(pm.getPaymentname());
		order.setShippingaddressid(s.getShippingaddressid());//设置发货地址到订单中
		order.setDeliveraddressid(da.getAddressid());//设置收货地址到订单中
		order.setShippingusername(da.getShippingusername());//设置收货人
		this.getOrderTService().save(order);
		this.setSaddorder(true);
		
	}
	
	/**
	 * 在多支付方式情况下初始化订单采用的支付方式所需要的信息
	 */
	public PaymentM getPayway(String paymentid){
		PaymentM pm = orderBaseProcessTService.getSelectedPayMent(paymentid);
		if (pm != null) {
			this.setPm(pm);
			if(PaymentCode.PAYMENT_CODE_ALIPAY.equals(pm.getPaymentCode())){
				this.setPaymentcode(PaymentCode.PAYMENT_CODE_ALIPAY);
				if(StaticKey.PAY_INTERFACE_CODE_TWOPAY.equals(pm.getPaymentInterface())){
					this.setPaymentinterface(StaticKey.PAY_INTERFACE_CODE_TWOPAY);//双接口
				}
			}else if(PaymentCode.PAYMENT_CODE_TENPAY.equals(pm.getPaymentCode())){
				this.setPaymentcode(PaymentCode.PAYMENT_CODE_TENPAY);
				if(StaticKey.PAY_INTERFACE_CODE_TWOPAY.equals(pm.getPaymentInterface())){
					//进行财付通的双接口虚拟即时到帐操作，采集即时到帐需要的数据
					this.setPaymentinterface(StaticKey.PAY_INTERFACE_CODE_TWOPAY);
				}	
			}
			this.setSpayment(true);
		} else {
			this.setSpayment(false);
		}
		return pm;
		
	}
	
	/**
	 * 开始对支付宝采集数据
	 */
	private void BuildAlipayConfig(){
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
	 * 获取收货地址信息
	 * @param addressid
	 * @return
	 */
	public DeliverAddressT getDeliverAddress(String addressid){
		return orderBaseProcessTService.getDeliverAddress(addressid);
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
		s.setState(StaticKey.ONE);
		s.setDeliveraddressid(da.getAddressid());
		s.setIssend(StaticKey.ZERO);//未发送到这个地址过
		s.setOrderid(this.getSerialidorderid());//设置订单号
		this.getShippingAddressTService().save(s);
		this.setDt(da);//将收获地址信息存入dt
		this.setSshoppingaddress(true);//这里应该改成true比较好
		return s;
	}
	
	

	
}
