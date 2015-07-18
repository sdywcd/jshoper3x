package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the electronic_menu_order_t database table.
 * 
 */
@Entity
@Table(name="electronic_menu_order_t")
@NamedQuery(name="ElectronicMenuOrderT.findAll", query="SELECT e FROM ElectronicMenuOrderT e")
public class ElectronicMenuOrderT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String electronicMenuOrderid;
	private double amount;
	private Date createtime;
	private String customernotes;
	private String deliveraddressid;
	private String delivermode;
	private String deliverynumber;
	private Date deliverytime;
	private String electronicorderstate;
	private String expressnumber;
	private double freight;
	private String goodid;
	private String goodsname;
	private String hasprintexpress;
	private String hasprintfpinvoice;
	private String hasprintinvoice;
	private String invoice;
	private String logisticsid;
	private String logisticswebaddress;
	private int needquantity;
	private String orderTag;
	private String paymentid;
	private String paymentname;
	private String paystate;
	private Date paytime;
	private double points;
	private Date purchasetime;
	private String roomName;
	private String shippingaddressid;
	private String shippingstate;
	private String shippingusername;
	private double shouldpay;
	private String tableNumber;
	private String tablestate;
	private String toBuyer;
	private String tradeNo;
	private double usepoints;
	private String userid;
	private String username;
	private String vouchersid;

	public ElectronicMenuOrderT() {
	}


	@Id
	@Column(name="ELECTRONIC_MENU_ORDERID", unique=true, nullable=false, length=20)
	public String getElectronicMenuOrderid() {
		return this.electronicMenuOrderid;
	}

	public void setElectronicMenuOrderid(String electronicMenuOrderid) {
		this.electronicMenuOrderid = electronicMenuOrderid;
	}


	@Column(nullable=false)
	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	@Column(length=2000)
	public String getCustomernotes() {
		return this.customernotes;
	}

	public void setCustomernotes(String customernotes) {
		this.customernotes = customernotes;
	}


	@Column(length=1)
	public String getDeliveraddressid() {
		return this.deliveraddressid;
	}

	public void setDeliveraddressid(String deliveraddressid) {
		this.deliveraddressid = deliveraddressid;
	}


	@Column(length=50)
	public String getDelivermode() {
		return this.delivermode;
	}

	public void setDelivermode(String delivermode) {
		this.delivermode = delivermode;
	}


	@Column(length=50)
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


	@Column(nullable=false, length=1)
	public String getElectronicorderstate() {
		return this.electronicorderstate;
	}

	public void setElectronicorderstate(String electronicorderstate) {
		this.electronicorderstate = electronicorderstate;
	}


	@Column(length=50)
	public String getExpressnumber() {
		return this.expressnumber;
	}

	public void setExpressnumber(String expressnumber) {
		this.expressnumber = expressnumber;
	}


	@Column(nullable=false)
	public double getFreight() {
		return this.freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}


	@Column(length=1000)
	public String getGoodid() {
		return this.goodid;
	}

	public void setGoodid(String goodid) {
		this.goodid = goodid;
	}


	@Column(length=5000)
	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}


	@Column(length=1)
	public String getHasprintexpress() {
		return this.hasprintexpress;
	}

	public void setHasprintexpress(String hasprintexpress) {
		this.hasprintexpress = hasprintexpress;
	}


	@Column(length=1)
	public String getHasprintfpinvoice() {
		return this.hasprintfpinvoice;
	}

	public void setHasprintfpinvoice(String hasprintfpinvoice) {
		this.hasprintfpinvoice = hasprintfpinvoice;
	}


	@Column(length=1)
	public String getHasprintinvoice() {
		return this.hasprintinvoice;
	}

	public void setHasprintinvoice(String hasprintinvoice) {
		this.hasprintinvoice = hasprintinvoice;
	}


	@Column(nullable=false, length=1)
	public String getInvoice() {
		return this.invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}


	@Column(length=20)
	public String getLogisticsid() {
		return this.logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}


	@Column(length=225)
	public String getLogisticswebaddress() {
		return this.logisticswebaddress;
	}

	public void setLogisticswebaddress(String logisticswebaddress) {
		this.logisticswebaddress = logisticswebaddress;
	}


	public int getNeedquantity() {
		return this.needquantity;
	}

	public void setNeedquantity(int needquantity) {
		this.needquantity = needquantity;
	}


	@Column(name="ORDER_TAG", length=1)
	public String getOrderTag() {
		return this.orderTag;
	}

	public void setOrderTag(String orderTag) {
		this.orderTag = orderTag;
	}


	@Column(nullable=false, length=20)
	public String getPaymentid() {
		return this.paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}


	@Column(nullable=false, length=50)
	public String getPaymentname() {
		return this.paymentname;
	}

	public void setPaymentname(String paymentname) {
		this.paymentname = paymentname;
	}


	@Column(nullable=false, length=1)
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


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getPurchasetime() {
		return this.purchasetime;
	}

	public void setPurchasetime(Date purchasetime) {
		this.purchasetime = purchasetime;
	}


	@Column(name="ROOM_NAME", length=45)
	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}


	@Column(length=20)
	public String getShippingaddressid() {
		return this.shippingaddressid;
	}

	public void setShippingaddressid(String shippingaddressid) {
		this.shippingaddressid = shippingaddressid;
	}


	@Column(length=1)
	public String getShippingstate() {
		return this.shippingstate;
	}

	public void setShippingstate(String shippingstate) {
		this.shippingstate = shippingstate;
	}


	@Column(length=50)
	public String getShippingusername() {
		return this.shippingusername;
	}

	public void setShippingusername(String shippingusername) {
		this.shippingusername = shippingusername;
	}


	@Column(nullable=false)
	public double getShouldpay() {
		return this.shouldpay;
	}

	public void setShouldpay(double shouldpay) {
		this.shouldpay = shouldpay;
	}


	@Column(name="TABLE_NUMBER", nullable=false, length=20)
	public String getTableNumber() {
		return this.tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}


	@Column(nullable=false, length=1)
	public String getTablestate() {
		return this.tablestate;
	}

	public void setTablestate(String tablestate) {
		this.tablestate = tablestate;
	}


	@Column(name="TO_BUYER", length=100)
	public String getToBuyer() {
		return this.toBuyer;
	}

	public void setToBuyer(String toBuyer) {
		this.toBuyer = toBuyer;
	}


	@Column(name="TRADE_NO", length=45)
	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}


	@Column(nullable=false)
	public double getUsepoints() {
		return this.usepoints;
	}

	public void setUsepoints(double usepoints) {
		this.usepoints = usepoints;
	}


	@Column(length=20)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


	@Column(length=50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	@Column(length=20)
	public String getVouchersid() {
		return this.vouchersid;
	}

	public void setVouchersid(String vouchersid) {
		this.vouchersid = vouchersid;
	}

}