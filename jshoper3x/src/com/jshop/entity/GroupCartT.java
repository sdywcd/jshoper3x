package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the group_cart_t database table.
 * 
 */
@Entity
@Table(name="group_cart_t")
@NamedQuery(name="GroupCartT.findAll", query="SELECT g FROM GroupCartT g")
public class GroupCartT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Date addtime;
	private String cartid;
	private double changeprice;
	private String goodsid;
	private String goodsname;
	private double groupprice;
	private String htmlpath;
	private int needquantity;
	private String orderid;
	private String picture;
	private double points;
	private double price;
	private String productid;
	private int quantity;
	private String state;
	private double subtotal;
	private String userid;
	private String username;
	private String usersetnum;
	private String weight;

	public GroupCartT() {
	}


	@Id
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}


	public String getCartid() {
		return this.cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}


	public double getChangeprice() {
		return this.changeprice;
	}

	public void setChangeprice(double changeprice) {
		this.changeprice = changeprice;
	}


	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}


	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}


	public double getGroupprice() {
		return this.groupprice;
	}

	public void setGroupprice(double groupprice) {
		this.groupprice = groupprice;
	}


	public String getHtmlpath() {
		return this.htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}


	public int getNeedquantity() {
		return this.needquantity;
	}

	public void setNeedquantity(int needquantity) {
		this.needquantity = needquantity;
	}


	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}


	public double getPoints() {
		return this.points;
	}

	public void setPoints(double points) {
		this.points = points;
	}


	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}


	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public double getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
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


	public String getUsersetnum() {
		return this.usersetnum;
	}

	public void setUsersetnum(String usersetnum) {
		this.usersetnum = usersetnum;
	}


	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

}