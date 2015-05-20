package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
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
	private BigDecimal amount;
	private Date createtime;
	private String customerordernotes;
	private String deliveraddressid;
	private String delivermode;
	private String deliverynumber;
	private Date deliverytime;
	private String errorOrderTag;
	private String expressnumber;
	private BigDecimal freight;
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
	private BigDecimal shouldpay;
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
	@Column(unique=true, nullable=false, length=20)
	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	@Column(length=100)
	public String getCustomerordernotes() {
		return this.customerordernotes;
	}

	public void setCustomerordernotes(String customerordernotes) {
		this.customerordernotes = customerordernotes;
	}


	@Column(length=20)
	public String getDeliveraddressid() {
		return this.deliveraddressid;
	}

	public void setDeliveraddressid(String deliveraddressid) {
		this.deliveraddressid = deliveraddressid;
	}


	@Column(nullable=false, length=50)
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


	@Column(name="ERROR_ORDER_TAG", length=1)
	public String getErrorOrderTag() {
		return this.errorOrderTag;
	}

	public void setErrorOrderTag(String errorOrderTag) {
		this.errorOrderTag = errorOrderTag;
	}


	@Column(length=50)
	public String getExpressnumber() {
		return this.expressnumber;
	}

	public void setExpressnumber(String expressnumber) {
		this.expressnumber = expressnumber;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getFreight() {
		return this.freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}


	@Column(nullable=false, length=1)
	public String getIsinvoice() {
		return this.isinvoice;
	}

	public void setIsinvoice(String isinvoice) {
		this.isinvoice = isinvoice;
	}


	@Column(length=1)
	public String getIsprintexpress() {
		return this.isprintexpress;
	}

	public void setIsprintexpress(String isprintexpress) {
		this.isprintexpress = isprintexpress;
	}


	@Column(length=1)
	public String getIsprintfpinvoice() {
		return this.isprintfpinvoice;
	}

	public void setIsprintfpinvoice(String isprintfpinvoice) {
		this.isprintfpinvoice = isprintfpinvoice;
	}


	@Column(length=1)
	public String getIsprintinvoice() {
		return this.isprintinvoice;
	}

	public void setIsprintinvoice(String isprintinvoice) {
		this.isprintinvoice = isprintinvoice;
	}


	@Column(nullable=false, length=20)
	public String getLogisticsid() {
		return this.logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}


	@Column(length=45)
	public String getLogisticsname() {
		return this.logisticsname;
	}

	public void setLogisticsname(String logisticsname) {
		this.logisticsname = logisticsname;
	}


	@Column(length=225)
	public String getLogisticswebaddress() {
		return this.logisticswebaddress;
	}

	public void setLogisticswebaddress(String logisticswebaddress) {
		this.logisticswebaddress = logisticswebaddress;
	}


	@Column(length=255)
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


	@Column(nullable=false, length=20)
	public String getMemberid() {
		return this.memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}


	@Column(nullable=false, length=100)
	public String getMembername() {
		return this.membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}


	@Column(nullable=false)
	public int getNeedquantity() {
		return this.needquantity;
	}

	public void setNeedquantity(int needquantity) {
		this.needquantity = needquantity;
	}


	@Column(name="ORDER_TAG", nullable=false, length=1)
	public String getOrderTag() {
		return this.orderTag;
	}

	public void setOrderTag(String orderTag) {
		this.orderTag = orderTag;
	}


	@Column(nullable=false, length=1000)
	public String getOrdername() {
		return this.ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}


	@Column(nullable=false, length=1)
	public String getOrderstate() {
		return this.orderstate;
	}

	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
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


	@Column(nullable=false)
	public double getPoints() {
		return this.points;
	}

	public void setPoints(double points) {
		this.points = points;
	}


	@Column(nullable=false, length=2000)
	public String getProductinfo() {
		return this.productinfo;
	}

	public void setProductinfo(String productinfo) {
		this.productinfo = productinfo;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getPurchasetime() {
		return this.purchasetime;
	}

	public void setPurchasetime(Date purchasetime) {
		this.purchasetime = purchasetime;
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


	@Column(length=45)
	public String getShippingusername() {
		return this.shippingusername;
	}

	public void setShippingusername(String shippingusername) {
		this.shippingusername = shippingusername;
	}


	@Column(length=20)
	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	@Column(length=45)
	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getShouldpay() {
		return this.shouldpay;
	}

	public void setShouldpay(BigDecimal shouldpay) {
		this.shouldpay = shouldpay;
	}


	@Column(name="TO_BUYER_NOTES", length=100)
	public String getToBuyerNotes() {
		return this.toBuyerNotes;
	}

	public void setToBuyerNotes(String toBuyerNotes) {
		this.toBuyerNotes = toBuyerNotes;
	}


	@Column(name="TRADE_NO", length=45)
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


	@Column(length=100)
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


	@Column(length=20)
	public String getVouchersid() {
		return this.vouchersid;
	}

	public void setVouchersid(String vouchersid) {
		this.vouchersid = vouchersid;
	}

}