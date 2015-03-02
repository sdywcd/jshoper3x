package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the `group_order _t` database table.
 * 
 */
@Entity
@Table(name="`group_order _t`")
@NamedQuery(name="GroupOrder_T.findAll", query="SELECT g FROM GroupOrder_T g")
public class GroupOrder_T implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orderid;
	private double amount;
	private Date createtime;
	private String customernotes;
	private String deliveraddressid;
	private String delivermode;
	private String deliverynumber;
	private Date deliverytime;
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
	private String orderstate;
	private String paymentid;
	private String paymentname;
	private String paystate;
	private Date paytime;
	private double points;
	private Date purchasetime;
	private String shippingaddressid;
	private String shippingstate;
	private String shippingusername;
	private double shouldpay;
	private String toBuyer;
	private String tradeNo;
	private double usepoints;
	private String userid;
	private String username;
	private String vouchersid;

	public GroupOrder_T() {
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


	public String getCustomernotes() {
		return this.customernotes;
	}

	public void setCustomernotes(String customernotes) {
		this.customernotes = customernotes;
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


	public String getGoodid() {
		return this.goodid;
	}

	public void setGoodid(String goodid) {
		this.goodid = goodid;
	}


	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}


	public String getHasprintexpress() {
		return this.hasprintexpress;
	}

	public void setHasprintexpress(String hasprintexpress) {
		this.hasprintexpress = hasprintexpress;
	}


	public String getHasprintfpinvoice() {
		return this.hasprintfpinvoice;
	}

	public void setHasprintfpinvoice(String hasprintfpinvoice) {
		this.hasprintfpinvoice = hasprintfpinvoice;
	}


	public String getHasprintinvoice() {
		return this.hasprintinvoice;
	}

	public void setHasprintinvoice(String hasprintinvoice) {
		this.hasprintinvoice = hasprintinvoice;
	}


	public String getInvoice() {
		return this.invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}


	public String getLogisticsid() {
		return this.logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}


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


	@Column(name="ORDER_TAG")
	public String getOrderTag() {
		return this.orderTag;
	}

	public void setOrderTag(String orderTag) {
		this.orderTag = orderTag;
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


	public double getShouldpay() {
		return this.shouldpay;
	}

	public void setShouldpay(double shouldpay) {
		this.shouldpay = shouldpay;
	}


	@Column(name="TO_BUYER")
	public String getToBuyer() {
		return this.toBuyer;
	}

	public void setToBuyer(String toBuyer) {
		this.toBuyer = toBuyer;
	}


	@Column(name="TRADE_NO")
	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
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


	public String getVouchersid() {
		return this.vouchersid;
	}

	public void setVouchersid(String vouchersid) {
		this.vouchersid = vouchersid;
	}

}