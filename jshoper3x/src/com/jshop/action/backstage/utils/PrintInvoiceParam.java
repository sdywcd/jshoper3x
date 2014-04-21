package com.jshop.action.backstage.utils;

public class PrintInvoiceParam {
	
	/**
	 * 订单数据变量
	 */
	private String purchasetime;//订购时间
	private String orderid;//订单id
	private String hasprintfpinvoice;//是否已开票
	private String amount;//总计，需支付多少
	private String shouldpay;//订单总金额
	private String freight;//运费
	private String  invoicenumber;//发货单号
	/**
	 * 发货数据变量
	 */
	
	private String shippingusername;//收货人姓名
	private String country;//国家
	private String province;//省
	private String city;//
	private String district;
	private String street;
	private String postcode;
	
	/**
	 * 商品数据（购物车数据提取）
	 */
	private String goodsname;//商品名称
	private String usersetnum;//商品编号
	private String favorable;//单价
	private String needquantity;//订购数量
	private String subtotal;//金额小计
	
	
	private String kindeditorCode;
	
	public String getPurchasetime() {
		return purchasetime;
	}
	public void setPurchasetime(String purchasetime) {
		this.purchasetime = purchasetime;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getHasprintfpinvoice() {
		return hasprintfpinvoice;
	}
	public void setHasprintfpinvoice(String hasprintfpinvoice) {
		this.hasprintfpinvoice = hasprintfpinvoice;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getShouldpay() {
		return shouldpay;
	}
	public void setShouldpay(String shouldpay) {
		this.shouldpay = shouldpay;
	}
	public String getFreight() {
		return freight;
	}
	public void setFreight(String freight) {
		this.freight = freight;
	}
	
	public String getInvoicenumber() {
		return invoicenumber;
	}
	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}
	public String getShippingusername() {
		return shippingusername;
	}
	public void setShippingusername(String shippingusername) {
		this.shippingusername = shippingusername;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getUsersetnum() {
		return usersetnum;
	}
	public void setUsersetnum(String usersetnum) {
		this.usersetnum = usersetnum;
	}
	public String getFavorable() {
		return favorable;
	}
	public void setFavorable(String favorable) {
		this.favorable = favorable;
	}
	public String getNeedquantity() {
		return needquantity;
	}
	public void setNeedquantity(String needquantity) {
		this.needquantity = needquantity;
	}
	public String getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	public String getKindeditorCode() {
		return kindeditorCode;
	}
	public void setKindeditorCode(String kindeditorCode) {
		this.kindeditorCode = kindeditorCode;
	}
	
	

}
