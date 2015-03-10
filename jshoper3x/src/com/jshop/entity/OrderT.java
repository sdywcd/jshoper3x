package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the order_t database table.
 * 
 */
@Entity
@Table(name="order_t")
@NamedQuery(name="OrderT.findAll", query="SELECT o FROM OrderT o")
public class OrderT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orderid;
	private double amount;
	private Date createtime;
	private String customerordernotes;
	private String deliveraddressid;
	private String delivermode;
	private String deliverynumber;
	private Date deliverytime;
	private String errorOrderTag;
	private String expressnumber;
	private double freight;
	private String isinvoice;
	private String isprintexpress;
	private String isprintfpinvoice;
	private String isprintinvoice;
	private String logisticsid;
	private String logisticsname;
	private String logisticswebaddress;
	private String mainpicture;
	private Date memberdelivertime;
	private String memberid;
	private String membername;
	private int needquantity;
	private String orderTag;
	private String ordername;
	private String orderstate;
	private String paymentid;
	private String paymentname;
	private String paystate;
	private Date paytime;
	private double points;
	private String productinfo;
	private Date purchasetime;
	private String shippingaddressid;
	private String shippingstate;
	private String shippingusername;
	private String shopid;
	private String shopname;
	private double shouldpay;
	private String toBuyerNotes;
	private String tradeNo;
	private Date updatetime;
	private double usepoints;
	private String userid;
	private String username;
	private int versiont;
	private String vouchersid;

	public OrderT() {
	}


	@Id
	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getCustomerordernotes() {
		return this.customerordernotes;
	}

	public void setCustomerordernotes(String customerordernotes) {
		this.customerordernotes = customerordernotes;
	}


	public String getDeliveraddressid() {
		return this.deliveraddressid;
	}

	public void setDeliveraddressid(String deliveraddressid) {
		this.deliveraddressid = deliveraddressid;
	}


	public String getDelivermode() {
		return this.delivermode;
	}

	public void setDelivermode(String delivermode) {
		this.delivermode = delivermode;
	}


	public String getDeliverynumber() {
		return this.deliverynumber;
	}

	public void setDeliverynumber(String deliverynumber) {
		this.deliverynumber = deliverynumber;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getDeliverytime() {
		return this.deliverytime;
	}

	public void setDeliverytime(Date deliverytime) {
		this.deliverytime = deliverytime;
	}


	@Column(name="ERROR_ORDER_TAG")
	public String getErrorOrderTag() {
		return this.errorOrderTag;
	}

	public void setErrorOrderTag(String errorOrderTag) {
		this.errorOrderTag = errorOrderTag;
	}


	public String getExpressnumber() {
		return this.expressnumber;
	}

	public void setExpressnumber(String expressnumber) {
		this.expressnumber = expressnumber;
	}


	public double getFreight() {
		return this.freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}


	public String getIsinvoice() {
		return this.isinvoice;
	}

	public void setIsinvoice(String isinvoice) {
		this.isinvoice = isinvoice;
	}


	public String getIsprintexpress() {
		return this.isprintexpress;
	}

	public void setIsprintexpress(String isprintexpress) {
		this.isprintexpress = isprintexpress;
	}


	public String getIsprintfpinvoice() {
		return this.isprintfpinvoice;
	}

	public void setIsprintfpinvoice(String isprintfpinvoice) {
		this.isprintfpinvoice = isprintfpinvoice;
	}


	public String getIsprintinvoice() {
		return this.isprintinvoice;
	}

	public void setIsprintinvoice(String isprintinvoice) {
		this.isprintinvoice = isprintinvoice;
	}


	public String getLogisticsid() {
		return this.logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}


	public String getLogisticsname() {
		return this.logisticsname;
	}

	public void setLogisticsname(String logisticsname) {
		this.logisticsname = logisticsname;
	}


	public String getLogisticswebaddress() {
		return this.logisticswebaddress;
	}

	public void setLogisticswebaddress(String logisticswebaddress) {
		this.logisticswebaddress = logisticswebaddress;
	}


	public String getMainpicture() {
		return this.mainpicture;
	}

	public void setMainpicture(String mainpicture) {
		this.mainpicture = mainpicture;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getMemberdelivertime() {
		return this.memberdelivertime;
	}

	public void setMemberdelivertime(Date memberdelivertime) {
		this.memberdelivertime = memberdelivertime;
	}


	public String getMemberid() {
		return this.memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}


	public String getMembername() {
		return this.membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}


	public int getNeedquantity() {
		return this.needquantity;
	}

	public void setNeedquantity(int needquantity) {
		this.needquantity = needquantity;
	}


	@Column(name="ORDER_TAG")
	public String getOrderTag() {
		return this.orderTag;
	}

	public void setOrderTag(String orderTag) {
		this.orderTag = orderTag;
	}


	public String getOrdername() {
		return this.ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}


	public String getOrderstate() {
		return this.orderstate;
	}

	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}


	public String getPaymentid() {
		return this.paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}


	public String getPaymentname() {
		return this.paymentname;
	}

	public void setPaymentname(String paymentname) {
		this.paymentname = paymentname;
	}


	public String getPaystate() {
		return this.paystate;
	}

	public void setPaystate(String paystate) {
		this.paystate = paystate;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getPaytime() {
		return this.paytime;
	}

	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}


	public double getPoints() {
		return this.points;
	}

	public void setPoints(double points) {
		this.points = points;
	}


	public String getProductinfo() {
		return this.productinfo;
	}

	public void setProductinfo(String productinfo) {
		this.productinfo = productinfo;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getPurchasetime() {
		return this.purchasetime;
	}

	public void setPurchasetime(Date purchasetime) {
		this.purchasetime = purchasetime;
	}


	public String getShippingaddressid() {
		return this.shippingaddressid;
	}

	public void setShippingaddressid(String shippingaddressid) {
		this.shippingaddressid = shippingaddressid;
	}


	public String getShippingstate() {
		return this.shippingstate;
	}

	public void setShippingstate(String shippingstate) {
		this.shippingstate = shippingstate;
	}


	public String getShippingusername() {
		return this.shippingusername;
	}

	public void setShippingusername(String shippingusername) {
		this.shippingusername = shippingusername;
	}


	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}


	public double getShouldpay() {
		return this.shouldpay;
	}

	public void setShouldpay(double shouldpay) {
		this.shouldpay = shouldpay;
	}


	@Column(name="TO_BUYER_NOTES")
	public String getToBuyerNotes() {
		return this.toBuyerNotes;
	}

	public void setToBuyerNotes(String toBuyerNotes) {
		this.toBuyerNotes = toBuyerNotes;
	}


	@Column(name="TRADE_NO")
	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	public double getUsepoints() {
		return this.usepoints;
	}

	public void setUsepoints(double usepoints) {
		this.usepoints = usepoints;
	}


	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public int getVersiont() {
		return this.versiont;
	}

	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}


	public String getVouchersid() {
		return this.vouchersid;
	}

	public void setVouchersid(String vouchersid) {
		this.vouchersid = vouchersid;
	}

}