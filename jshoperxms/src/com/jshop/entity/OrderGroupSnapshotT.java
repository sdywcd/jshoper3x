package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the order_group_snapshot_t database table.
 * 
 */
@Entity
@Table(name="order_group_snapshot_t")
@NamedQuery(name="OrderGroupSnapshotT.findAll", query="SELECT o FROM OrderGroupSnapshotT o")
public class OrderGroupSnapshotT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Date addtime;
	private String cartTag;
	private String cartid;
	private String cartinfoid;
	private BigDecimal changeprice;
	private BigDecimal favorable;
	private String goodsid;
	private String goodsname;
	private String htmlpath;
	private String isvirtual;
	private String memberid;
	private String membername;
	private int needquantity;
	private String orderTag;
	private String orderid;
	private String picture;
	private double points;
	private BigDecimal price;
	private String productName;
	private String productid;
	private int quantity;
	private String shippingaddressid;
	private String shopid;
	private String shopname;
	private String state;
	private int storeTag;
	private BigDecimal subtotal;
	private String userid;
	private String username;
	private String usersetnum;
	private String weight;

	public OrderGroupSnapshotT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}


	@Column(name="CART_TAG", nullable=false, length=1)
	public String getCartTag() {
		return this.cartTag;
	}

	public void setCartTag(String cartTag) {
		this.cartTag = cartTag;
	}


	@Column(nullable=false, length=20)
	public String getCartid() {
		return this.cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}


	@Column(nullable=false, length=20)
	public String getCartinfoid() {
		return this.cartinfoid;
	}

	public void setCartinfoid(String cartinfoid) {
		this.cartinfoid = cartinfoid;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getChangeprice() {
		return this.changeprice;
	}

	public void setChangeprice(BigDecimal changeprice) {
		this.changeprice = changeprice;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getFavorable() {
		return this.favorable;
	}

	public void setFavorable(BigDecimal favorable) {
		this.favorable = favorable;
	}


	@Column(nullable=false, length=20)
	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}


	@Column(nullable=false, length=100)
	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}


	@Column(nullable=false, length=255)
	public String getHtmlpath() {
		return this.htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}


	@Column(nullable=false, length=1)
	public String getIsvirtual() {
		return this.isvirtual;
	}

	public void setIsvirtual(String isvirtual) {
		this.isvirtual = isvirtual;
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


	@Column(nullable=false, length=20)
	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	@Column(nullable=false, length=250)
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}


	@Column(nullable=false)
	public double getPoints() {
		return this.points;
	}

	public void setPoints(double points) {
		this.points = points;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	@Column(name="PRODUCT_NAME", nullable=false, length=100)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


	@Column(nullable=false, length=20)
	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}


	@Column(nullable=false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Column(nullable=false, length=20)
	public String getShippingaddressid() {
		return this.shippingaddressid;
	}

	public void setShippingaddressid(String shippingaddressid) {
		this.shippingaddressid = shippingaddressid;
	}


	@Column(nullable=false, length=20)
	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	@Column(nullable=false, length=45)
	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(name="STORE_TAG", nullable=false)
	public int getStoreTag() {
		return this.storeTag;
	}

	public void setStoreTag(int storeTag) {
		this.storeTag = storeTag;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}


	@Column(nullable=false, length=20)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


	@Column(nullable=false, length=50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	@Column(nullable=false, length=20)
	public String getUsersetnum() {
		return this.usersetnum;
	}

	public void setUsersetnum(String usersetnum) {
		this.usersetnum = usersetnum;
	}


	@Column(nullable=false, length=20)
	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

}