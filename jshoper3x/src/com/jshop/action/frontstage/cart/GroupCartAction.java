package com.jshop.action.frontstage.cart;

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GoodsGroupT;
import com.jshop.entity.GroupCartT;
import com.jshop.entity.UserT;
import com.jshop.service.GoodsGroupTService;
import com.jshop.service.GroupCartService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
@InterceptorRefs({ @InterceptorRef("defaultStack") })
public class GroupCartAction extends ActionSupport {
	private GroupCartService groupCartService;
	private GoodsGroupTService goodsGroupTService;
	private Serial serial;
	private String id;
	private String cartid;
	private String orderid;
	private String goodsid;
	private String groupid;
	private String goodsname;
	private String userid;
	private String username;
	private int needquantity;
	private double price;
	private double groupprice;
	private Double changeprice;
	private double points;
	private double subtotal;
	private Date addtime;
	private Integer quantity;
	private String picture;

	private String usersetnum;
	private String weight;
	private String state;
	private String htmlpath;
	private String productid;
	private boolean sucflag = false;
	private boolean slogin = false;

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	@JSON(serialize = false)
	public GroupCartService getGroupCartService() {
		return groupCartService;
	}

	public void setGroupCartService(GroupCartService groupCartService) {
		this.groupCartService = groupCartService;
	}

	@JSON(serialize = false)
	public GoodsGroupTService getGoodsGroupTService() {
		return goodsGroupTService;
	}

	public void setGoodsGroupTService(GoodsGroupTService goodsGroupTService) {
		this.goodsGroupTService = goodsGroupTService;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCartid() {
		return cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
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

	public int getNeedquantity() {
		return needquantity;
	}

	public void setNeedquantity(int needquantity) {
		this.needquantity = needquantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getGroupprice() {
		return groupprice;
	}

	public void setGroupprice(double groupprice) {
		this.groupprice = groupprice;
	}

	public Double getChangeprice() {
		return changeprice;
	}

	public void setChangeprice(Double changeprice) {
		this.changeprice = changeprice;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getUsersetnum() {
		return usersetnum;
	}

	public void setUsersetnum(String usersetnum) {
		this.usersetnum = usersetnum;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHtmlpath() {
		return htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	/**
	 * 加入购物车前查询出商品信息
	 * 
	 * @return
	 */
	public GoodsGroupT GetGoodsGroupTForGroupCart() {
		if (Validate.StrNotNull(this.getGroupid())) {
			GoodsGroupT ggt = this.getGoodsGroupTService().findGoodsGroupById(
					this.getGroupid());
			if (ggt != null) {
				return ggt;
			}
		}
		return null;

	}

	/**
	 * 增加商品到购物车
	 * 
	 * @return
	 */
	@Action(value = "addGroupCart", results = { @Result(name = "json", type = "json") })
	public String addGroupCart() {
		UserT user = (UserT) ActionContext.getContext().getSession()
				.get(StaticKey.MEMBER_SESSION_KEY);
		if (user != null) {

			GoodsGroupT ggt = this.GetGoodsGroupTForGroupCart();
			GroupCartT gct = new GroupCartT();
			gct.setId(this.getSerial().Serialid(serial.GROUPCARTINFO));
			gct.setCartid(this.getSerial().Serialid(serial.GROUPCART));
			gct.setOrderid(null);
			gct.setGoodsid(ggt.getGroupid());
			gct.setUserid(user.getUserid());
			gct.setUsername(user.getUsername());
			gct.setUsersetnum("0");
			gct.setNeedquantity(1);
			gct.setPrice(ggt.getMemberprice());
			gct.setGroupprice(ggt.getGroupprice());
			gct.setChangeprice(0.0);
			gct.setPoints(ggt.getSendpoint());
			gct.setSubtotal(this.getNeedquantity() * ggt.getGroupprice());
			gct.setAddtime(BaseTools.systemtime());
			gct.setQuantity(ggt.getSalequantity());
			gct.setPicture(ggt.getPictureurl());
			gct.setWeight("0");
			gct.setState("1");
			gct.setHtmlpath(ggt.getHtmlpath());
			gct.setProductid("0");
			gct.setGoodsname(ggt.getGoodsname());
			this.getGroupCartService().save(gct);
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}

}
