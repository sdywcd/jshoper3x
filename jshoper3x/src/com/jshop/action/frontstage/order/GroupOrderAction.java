package com.jshop.action.frontstage.order;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

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
import com.jshop.entity.DeliverAddressT;
import com.jshop.entity.GoodsGroupT;
import com.jshop.entity.GroupCartT;
import com.jshop.entity.GroupOrderT;
import com.jshop.entity.LogisticsBusinessT;
import com.jshop.entity.LogisticsbusinessareaT;
import com.jshop.entity.MemberT;
import com.jshop.entity.PaymentM;
import com.jshop.entity.ShippingAddressT;
import com.jshop.entity.UserT;
import com.jshop.service.DeliverAddressTService;
import com.jshop.service.GroupCartService;
import com.jshop.service.GroupOrderTService;
import com.jshop.service.LogisticsBusinessTService;
import com.jshop.service.LogisticsbusinessareaTService;
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

public class GroupOrderAction extends ActionSupport {
	private GroupOrderTService groupOrderTService;
	private LogisticsbusinessareaTService logisticsbusinessareaTService;
	@Resource(name = "serial")
	private Serial serial;
	private PaymentMService paymentMService;
	private LogisticsBusinessTService logisticsBusinessTService;
	private VouchersTService vouchersTService;
	private ShippingAddressTService shippingAddressTService;
	private DeliverAddressTService deliverAddressTService;
	private DataCollectionTAction dataCollectionTAction;
	private GroupCartService groupCartService;
	private GroupOrderT got = new GroupOrderT();
	private Double totalweight;
	private String addressid;
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
	private double favorable;
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
	private double groupprice;
	private Double total;//会员总价
	private String defaultlogisticsid;
	private Double vouchercontent = 0.0;
	private boolean sflag = false;
	private boolean svoucher = false;
	private boolean spayment = false;
	private boolean sshoppingaddress = false;
	private boolean saddorder = false;
	private boolean supdatecart = false;
	private boolean slogin;
	private String serialidorderid;
	private Double totalpoints;
	private String cartid;
	private String cartgoodsname;
	private String cartgoodsid;
	private int cartneedquantity;
	private PaymentM pm=new PaymentM();
	private DeliverAddressT dt=new DeliverAddressT();
	private String paymentcode;//返回给前台的支付方式
	private String paymentinterface;//反馈给前台的支付接口类型
	@JSON(serialize=false)
	public GroupCartService getGroupCartService() {
		return groupCartService;
	}
	public void setGroupCartService(GroupCartService groupCartService) {
		this.groupCartService = groupCartService;
	}
	@JSON(serialize=false)
	public DeliverAddressTService getDeliverAddressTService() {
		return deliverAddressTService;
	}
	public void setDeliverAddressTService(
			DeliverAddressTService deliverAddressTService) {
		this.deliverAddressTService = deliverAddressTService;
	}
	@JSON(serialize=false)
	public PaymentMService getPaymentMService() {
		return paymentMService;
	}
	public void setPaymentMService(PaymentMService paymentMService) {
		this.paymentMService = paymentMService;
	}
	@JSON(serialize=false)
	public LogisticsBusinessTService getLogisticsBusinessTService() {
		return logisticsBusinessTService;
	}
	public void setLogisticsBusinessTService(
			LogisticsBusinessTService logisticsBusinessTService) {
		this.logisticsBusinessTService = logisticsBusinessTService;
	}
	@JSON(serialize=false)
	public VouchersTService getVouchersTService() {
		return vouchersTService;
	}
	public void setVouchersTService(VouchersTService vouchersTService) {
		this.vouchersTService = vouchersTService;
	}
	@JSON(serialize=false)
	public ShippingAddressTService getShippingAddressTService() {
		return shippingAddressTService;
	}
	public void setShippingAddressTService(
			ShippingAddressTService shippingAddressTService) {
		this.shippingAddressTService = shippingAddressTService;
	}
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}
	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}
	@JSON(serialize=false)
	public LogisticsbusinessareaTService getLogisticsbusinessareaTService() {
		return logisticsbusinessareaTService;
	}
	public void setLogisticsbusinessareaTService(
			LogisticsbusinessareaTService logisticsbusinessareaTService) {
		this.logisticsbusinessareaTService = logisticsbusinessareaTService;
	}
	@JSON(serialize=false)
	public GroupOrderTService getGroupOrderTService() {
		return groupOrderTService;
	}
	public void setGroupOrderTService(GroupOrderTService groupOrderTService) {
		this.groupOrderTService = groupOrderTService;
	}
	@JSON(serialize=false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
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
	
	public double getGroupprice() {
		return groupprice;
	}
	public void setGroupprice(double groupprice) {
		this.groupprice = groupprice;
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
	public Double getVouchercontent() {
		return vouchercontent;
	}
	public void setVouchercontent(Double vouchercontent) {
		this.vouchercontent = vouchercontent;
	}
	public GroupOrderT getGot() {
		return got;
	}
	public void setGot(GroupOrderT got) {
		this.got = got;
	}
	public boolean isSflag() {
		return sflag;
	}
	public void setSflag(boolean sflag) {
		this.sflag = sflag;
	}
	public boolean isSvoucher() {
		return svoucher;
	}
	public void setSvoucher(boolean svoucher) {
		this.svoucher = svoucher;
	}
	public boolean isSpayment() {
		return spayment;
	}
	public void setSpayment(boolean spayment) {
		this.spayment = spayment;
	}
	public boolean isSshoppingaddress() {
		return sshoppingaddress;
	}
	public void setSshoppingaddress(boolean sshoppingaddress) {
		this.sshoppingaddress = sshoppingaddress;
	}
	public boolean isSaddorder() {
		return saddorder;
	}
	public void setSaddorder(boolean saddorder) {
		this.saddorder = saddorder;
	}
	public boolean isSupdatecart() {
		return supdatecart;
	}
	public void setSupdatecart(boolean supdatecart) {
		this.supdatecart = supdatecart;
	}
	public boolean isSlogin() {
		return slogin;
	}
	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	public String getSerialidorderid() {
		return serialidorderid;
	}
	public void setSerialidorderid(String serialidorderid) {
		this.serialidorderid = serialidorderid;
	}
	public Double getTotalpoints() {
		return totalpoints;
	}
	public void setTotalpoints(Double totalpoints) {
		this.totalpoints = totalpoints;
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
	public double getFavorable() {
		return favorable;
	}
	public void setFavorable(double favorable) {
		this.favorable = favorable;
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
		List<LogisticsBusinessT> list = this.getLogisticsBusinessTService().findAllLogisticsBusiness(StaticKey.ONE);
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
		List<PaymentM> list = this.getPaymentMService().findAllPayment(StaticKey.ONE);
		ActionContext.getContext().put("payments", list);
	}
	/**
	 * 增加订单
	 * @param user
	 */
	public void initGroupOrder(UserT user){
		user = (UserT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		GoodsGroupT ggt = new GoodsGroupT();
		if(user!=null){
			
			got.setOrderid(this.getSerialidorderid());		
			got.setUserid(user.getUserid());
			got.setUsername(user.getUsername());
			//未来需要在这里处理是平邮还是快递或者是ems，这样物流商需要选择是平邮还是快递还是ems
			if (this.getPaymentid().trim().equals("-1")) {
				got.setDelivermode("货到付款");
				//未来获取特定的支付标记来标记货到付款
			}
			got.setDelivermode("EXPRESS");
			got.setDeliverynumber(null);//发货单号在发货后填写
			got.setOrderstate("0");//待确认
			got.setPaystate("0");//未付款
			got.setShippingstate("0");//未发货
			got.setLogisticsid(this.getLogisticsid().trim());
			got.setLogisticswebaddress(this.getLogisticswebaddress());
			got.setGoodid(this.getCartgoodsid());
			got.setGoodsname(this.getCartgoodsname());
			got.setNeedquantity(this.getCartneedquantity());
			got.setFreight(this.getFreight());//运费，在request中也有
			//		if(!this.isSvoucher()){

			got.setAmount(Arith.sub(Arith.add(this.getTotal(), this.getFreight()), this.getVouchercontent()));
			//		}else{
			//			order.setAmount(this.getTotal()+this.getFreight());//金额，含运费
			//		}
			got.setPoints(this.getTotalpoints());
			got.setPurchasetime(BaseTools.systemtime());
			got.setDeliverytime(null);
			got.setDeliverynumber(null);
			//发票处理晚
			got.setInvoice("0");
			got.setCustomernotes(this.getCustomernotes());
			got.setPaytime(null);
			got.setOrderTag(this.getOrderTag());
			got.setToBuyer(null);//给用户的留言
			//		if(!this.isSvoucher()){
			got.setShouldpay(Arith.sub(Arith.add(this.getTotal(), this.getFreight()), this.getVouchercontent()));
			//		}else{
			//			order.setShouldpay(this.getTotal()+this.getFreight());//金额，含运费
			//		}
			got.setUsepoints(0.0);//用户没有使用积分
			got.setVouchersid(this.getVouchersid());
			got.setCreatetime(BaseTools.systemtime());
			got.setHasprintexpress("0");//未打印快递单
			got.setHasprintinvoice("0");//未打印发货单
			got.setHasprintfpinvoice("0");//未开具发票
			got.setExpressnumber(null);//快递单号
			this.getGroupOrderTService().save(got);
			//	this.getGroupCartService().updateGroupCartStateByGoodsId(this.getCartgoodsid(), "3");
				AlipayConfig.out_trade_no = got.getOrderid();
				AlipayConfig.subject = got.getGoodsname();
				AlipayConfig.body = got.getGoodsname();
				AlipayConfig.price = String.valueOf(got.getShouldpay());
				AlipayConfig.logistics_fee = String.valueOf(got.getFreight());
				//测试发短信
//		         boolean b = fetchToSendSMS("18721337900", "TAO601238880",  "18721337900" ,
//		                 "TestMessage");
//		         System.out.println("Send Message result:" + b);
//				try {
//					sendmessage();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				try {
					sendSMSMessage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.setSaddorder(true);
			} else {
				this.setSaddorder(false);
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
			ActionContext.getContext().put("freight", freight);

		}

	}
//	/**
//	 *获取支付信息
//	 * 
//	 * @return
//	 */
//	public void GetPaymentinfo() {
//		PaymentM list = this.getPaymentMService().findPaymentbyId(this.getPaymentid().trim());
//		if (list != null) {
//			
//			AlipayConfig.partner = list.getPartnerid();
//			AlipayConfig.key = list.getSafecode();
//			AlipayConfig.seller_email = list.getAccount();
//			//把支付方式id和名称增加到order中
//			got.setPaymentid(list.getPaymentid());
//			got.setPaymentname(list.getPaymentname());
//			this.setSpayment(true);
//		} else {
//			this.setSpayment(false);
//		}
//	}
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
				got.setPaymentid(list.getPaymentid());
				got.setPaymentname(list.getPaymentname());
				this.setSpayment(true);
			}else if(PaymentCode.PAYMENT_CODE_TENPAY.equals(list.getPaymentCode())){
				this.setPaymentcode(PaymentCode.PAYMENT_CODE_TENPAY);
				if("3".equals(list.getPaymentInterface())){
					//进行财付通的双接口虚拟即时到帐操作，采集即时到帐需要的数据
					//BuildTenPayConfig();
					this.setPaymentinterface("3");
					this.setSpayment(true);
				}
				got.setPaymentid(this.getPaymentid());
				got.setPaymentname(list.getPaymentname());
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
		AlipayConfig.out_trade_no = got.getOrderid();
		AlipayConfig.subject = got.getGoodsname();
		AlipayConfig.body = got.getGoodsname();
		AlipayConfig.price = String.valueOf(got.getShouldpay());
		AlipayConfig.logistics_fee = String.valueOf(got.getFreight());
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
//		TenPayConfig.out_trade_no=got.getOrderid();//订单号
//		int totalfee=(int)(got.getShouldpay()*100);
//		TenPayConfig.total_fee=String.valueOf(totalfee);
//		TenPayConfig.body=got.getGoodsname();
//		TenPayConfig.bank_type="DEFAULT";
//		TenPayConfig.subject=got.getGoodsname();
//		TenPayConfig.goods_tag=got.getOrderTag();//手机充值虚拟卡
//		TenPayConfig.trade_mode="1";//即时到帐
//		TenPayConfig.trans_type="2";//虚拟交易
////		TenPayConfig.mobile=this.getMobile();
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
				this.setSshoppingaddress(false);
				got.setShippingaddressid(s.getShippingaddressid());//设置发货地址到订单中
				got.setDeliveraddressid(list.getAddressid());//设置收货地址到订单中
				got.setShippingusername(list.getShippingusername());//设置收货人
				//设置收货人信息给支付宝借口
				AlipayConfig.receive_name = list.getShippingusername();
				AlipayConfig.receive_address = list.getProvince() + list.getCity() + list.getDistrict() + list.getStreet();
				AlipayConfig.reveive_zip = list.getPostcode();
				AlipayConfig.reveive_phone = list.getTelno();
				AlipayConfig.reveive_mobile = list.getMobile();
//			else {
//				this.setSshoppingaddress(true);
//			}
		}
	}

	/**
	 * 事先获取订单编号
	 */
	public void GetSerialidorder() {
		
		this.setSerialidorderid(this.getSerial().Serialid(Serial.GROUPORDER));
	}

	/**
	 * 获取支付宝需要的订单信息
	 * 
	 * @return
	 */
	@Action(value = "InitAlipayneedInfoGroup", results = { 
			@Result(name = "json",type="json")
	})
	public String InitAlipayneedInfoGroup() {
		UserT user = (UserT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (user != null) {
			this.setSlogin(true);
			//预先生成订单编号
			GetSerialidorder();
			//获取支付信息
			InitPayway();
			//增加收获信息到发货地址表中
			AddShippingAddress();
			//增加订单到数据库
			initGroupOrder(user);
			if (this.isSaddorder()) {
//				//更新购物车商品到3，表示已经在订单中。并把对应订单号更新
//				//String []tempgoodsid=order.getGoodid().split(",");
//				//检查如果购物已经有对应的订单号则不更新
//				//3表示加入订单的购物车
			List<GroupCartT>list=this.getGroupCartService().findgroupCartByCartid(this.getCartid(), "3");
				if(!list.isEmpty()){
					return "json";
				}
				this.getGroupCartService().updateGroupCartStateandOrderidByGoodsidList(this.getCartid().trim(), this.getSerialidorderid(), user.getUserid(), "3");
				return "json";
		}
			

		}
		this.setSlogin(false);
		return "json";
	}
	/**
	 * 初始化订单所需信息
	 * 
	 * @return
	 */
	@Action(value = "InitGroupOrder", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/shop/grouporder.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html?redirecturl=${redirecturl}")
	})
	public String InitGroupOrder() {
		MemberT memberT = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if (memberT != null) {
			//获取用户收获地址
			GetUserDeliverAddress(memberT);
			//获取物流商
			GetDefaultLogistictsBusiness();
			//获取支付方式
			GetDefaultPayment();
//			//获取购物车中的商品作为订单商品处理
			//GetMyCart(memberT);
			//计算运费
			GetLogisticsPrice();
			//获取总金额+运费
			Double totalfreight =this.getTotal() + this.getFreight();
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
	 * 获取购物车中的商品作为订单商品处理
	 * 
	 * @param user
	 */
	public void GetMyCart(UserT user) {
//		List<GroupCartT> list = this.getGroupCartService().findAllGroupCartBymemberId(user.getUserid());
//		GroupCartT gct = list.get(0);
//		if (gct != null) {
//			this.setTotal(0.0);
//			this.setTotalweight(0.0);
//			this.setTotalpoints(0.0);
//			this.setCartgoodsname("");
//			this.setCartgoodsid("");
//			this.setCartneedquantity(0);
//			
//			
//				total = Arith.add(total, Arith.mul(gct.getGroupprice(), Double.parseDouble(String.valueOf(gct.getNeedquantity()))));
//				totalweight = Arith.add(totalweight, Arith.mul(Double.parseDouble(gct.getWeight()), Double.parseDouble(String.valueOf(gct.getNeedquantity()))));
//				totalpoints = Arith.add(totalpoints, Arith.mul(gct.getPoints(), Double.parseDouble(String.valueOf(gct.getNeedquantity()))));
//				cartgoodsname = gct.getGoodsname();
//				cartgoodsid = gct.getGoodsid() ;
//				cartneedquantity = gct.getNeedquantity();
//				cartid = gct.getCartid();
//			}
//			ActionContext.getContext().put("groupcart", gct);
//			ActionContext.getContext().put("totalprice", total);
//			ActionContext.getContext().put("totalpoints", totalpoints);
//			ActionContext.getContext().put("cartid", cartid);
//			ActionContext.getContext().put("cartgoodsid", cartgoodsid);
//			ActionContext.getContext().put("cartgoodsname", cartgoodsname);
//			ActionContext.getContext().put("cartneedquantity", cartneedquantity);
		}
	/**
	 * 通过飞信发送短信	 
	 * @return
	 * @throws IOException 
	 */
	public void sendmessage() throws IOException{
		String sUrl="https://fetionAPI.appspot.com/api/?";
		String fromNo="18721337900";
		String password="TAO601238880";
		String toNo="18721337900";
		String msg="您好！";
		sUrl+="from="+fromNo+"&pw="+password+"&to="+toNo+"&msg="+msg;
		System.out.print(sUrl);
		URL url = new URL(sUrl);
		HttpURLConnection urlconn= (HttpURLConnection) url.openConnection();
		urlconn.setRequestMethod("POST");		
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String input = in.readLine();
		System.out.print(input);
		String rets="";
		if(in!=null){
			for(String s="";(s=in.readLine())!=null;){
				rets = rets+s;
			}
		}
		in.close();
		System.out.print("发送信息:"+rets);
		System.out.print("发送成功");
	}
	/**
	 * 
	 * @param mobile
	 * @param password
	 * @param friends
	 * @param message
	 * @return
	 */
	public static boolean fetchToSendSMS(String mobile, String password,
			   String friends, String message) {
		 final int TRY_TIMES = 3;
		 final int TIME_OUT = 30000;


			  // 加上UUID的目的是防止这样的情况，在服务器上已经成功发送短信，却在返回结果过程中遇到错误，
			  // 而导致客户端继续尝试请求，此时让服务器根据UUID分辨出该请求已经发送过，避免再次发送短信。
			  String uuid = UUID.randomUUID().toString();
			  for (int i = 0; i < TRY_TIMES; i++) {
			   int responseCode = 0;
			   try {
			    URL postUrl = new URL("http://fetionlib.appspot.com/restlet/fetion");
			    HttpURLConnection connection = (HttpURLConnection) postUrl .openConnection();
			    connection.setConnectTimeout(TIME_OUT);
			    connection.setReadTimeout(TIME_OUT);
			    connection.setDoOutput(true);
			    connection.setRequestMethod("POST");
			    connection.setUseCaches(false);
			    connection.setInstanceFollowRedirects(true);
//			    connection.setRequestProperty("Content-Type",
//			      "application/x-www-form-urlencoded");
//			    connection.connect();
			    DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			    String content = "mobile=" + mobile + "&uuid=" + uuid
			      + "&password=" + password + "&friend="
			      + friends + "&message="
			      + URLEncoder.encode(message, "utf-8");
			    out.writeBytes(content);

			    out.flush();
			    out.close();

			    responseCode = connection.getResponseCode();
			    connection.disconnect();
			    if (responseCode == 202)
			     return true;
			    else
			     return false;
			   } catch (Exception e) {			    
			      
			   }
			  }
			  return false;
			 }
		/**
		 * SMS发送信息
		 * @throws IOException
		 */
			public void sendSMSMessage() throws IOException{
				//发送内容
				String content = "中国短信网JAVA示例测试"; 
				
				// 创建StringBuffer对象用来操作字符串
				StringBuffer sb = new StringBuffer("http://http.c123.com/tx/?");

				// 向StringBuffer追加用户名
				sb.append("uid=9999");

				// 向StringBuffer追加密码（密码采用MD5 32位 小写）
				sb.append("&pwd=9999");

				// 向StringBuffer追加手机号码
				sb.append("&mobile=18721337900");

				// 向StringBuffer追加消息内容转URL标准码
				sb.append("&content="+URLEncoder.encode(content));

				// 创建url对象
				URL url = new URL(sb.toString());

				// 打开url连接
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();

				// 设置url请求方式 ‘get’ 或者 ‘post’
				connection.setRequestMethod("POST");

				// 发送
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

				// 返回发送结果
				String inputline = in.readLine();

				// 返回结果为‘100’ 发送成功
				System.out.println(inputline);
			} 

}
	
	
	
	
	


