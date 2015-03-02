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


	public double getChangeprice() {
		return this.changeprice;
	}

	public void setChangeprice(double changeprice) {
		this.changeprice = changeprice;
	}


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


	@Column(name="ELECTRONIC_MENU_CARTID")
	public String getElectronicMenuCartid() {
		return this.electronicMenuCartid;
	}

	public void setElectronicMenuCartid(String electronicMenuCartid) {
		this.electronicMenuCartid = electronicMenuCartid;
	}


	@Column(name="ELECTRONIC_MENU_ORDERID")
	public String getElectronicMenuOrderid() {
		return this.electronicMenuOrderid;
	}

	public void setElectronicMenuOrderid(String electronicMenuOrderid) {
		this.electronicMenuOrderid = electronicMenuOrderid;
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


	public double getMemberprice() {
		return this.memberprice;
	}

	public void setMemberprice(double memberprice) {
		this.memberprice = memberprice;
	}


	public int getNeedquantity() {
		return this.needquantity;
	}

	public void setNeedquantity(int needquantity) {
		this.needquantity = needquantity;
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


	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Column(name="ROOM_NAME")
	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
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


	@Column(name="TABLE_NUMBER")
	public String getTableNumber() {
		return this.tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}


	public String getTablestate() {
		return this.tablestate;
	}

	public void setTablestate(String tablestate) {
		this.tablestate = tablestate;
	}


	public String getTaste() {
		return this.taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
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