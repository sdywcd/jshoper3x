package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the electronic_menu_cart_t database table.
 * 
 */
@Entity
@Table(name="electronic_menu_cart_t")
@NamedQuery(name="ElectronicMenuCartT.findAll", query="SELECT e FROM ElectronicMenuCartT e")
public class ElectronicMenuCartT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Date addtime;
	private double changeprice;
	private String cookingstate;
	private double deliveryprice;
	private String electronicMenuCartid;
	private String electronicMenuOrderid;
	private String goodsid;
	private String goodsname;
	private String ispackaway;
	private int lunchbox;
	private double memberprice;
	private int needquantity;
	private String picture;
	private double points;
	private double price;
	private int quantity;
	private String roomName;
	private String state;
	private double subtotal;
	private String tableNumber;
	private String tablestate;
	private String taste;
	private String userid;
	private String username;
	private String usersetnum;
	private String weight;

	public ElectronicMenuCartT() {
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


	public double getChangeprice() {
		return this.changeprice;
	}

	public void setChangeprice(double changeprice) {
		this.changeprice = changeprice;
	}


	@Column(length=1)
	public String getCookingstate() {
		return this.cookingstate;
	}

	public void setCookingstate(String cookingstate) {
		this.cookingstate = cookingstate;
	}


	public double getDeliveryprice() {
		return this.deliveryprice;
	}

	public void setDeliveryprice(double deliveryprice) {
		this.deliveryprice = deliveryprice;
	}


	@Column(name="ELECTRONIC_MENU_CARTID", nullable=false, length=20)
	public String getElectronicMenuCartid() {
		return this.electronicMenuCartid;
	}

	public void setElectronicMenuCartid(String electronicMenuCartid) {
		this.electronicMenuCartid = electronicMenuCartid;
	}


	@Column(name="ELECTRONIC_MENU_ORDERID", length=20)
	public String getElectronicMenuOrderid() {
		return this.electronicMenuOrderid;
	}

	public void setElectronicMenuOrderid(String electronicMenuOrderid) {
		this.electronicMenuOrderid = electronicMenuOrderid;
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


	@Column(length=1)
	public String getIspackaway() {
		return this.ispackaway;
	}

	public void setIspackaway(String ispackaway) {
		this.ispackaway = ispackaway;
	}


	public int getLunchbox() {
		return this.lunchbox;
	}

	public void setLunchbox(int lunchbox) {
		this.lunchbox = lunchbox;
	}


	@Column(nullable=false)
	public double getMemberprice() {
		return this.memberprice;
	}

	public void setMemberprice(double memberprice) {
		this.memberprice = memberprice;
	}


	@Column(nullable=false)
	public int getNeedquantity() {
		return this.needquantity;
	}

	public void setNeedquantity(int needquantity) {
		this.needquantity = needquantity;
	}


	@Column(nullable=false, length=255)
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


	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Column(name="ROOM_NAME", length=45)
	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(nullable=false)
	public double getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
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


	@Column(length=500)
	public String getTaste() {
		return this.taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
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