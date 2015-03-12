package com.jshop.vo;

public class GoodsBelinkedModel {
	
	private String id;//主键id
	
	private String maingoodsid;//主商品id
	
	private String goodsname;//主商品名称
	
	private String productid;//货品id
	
	private String productName;//货物名称
	
	private String memberprice;//会员价/套餐价/组合价
	
	private String price;//市场价，
	
	private String pictureurl;//主图片

	
	private String htmlpath;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaingoodsid() {
		return maingoodsid;
	}

	public void setMaingoodsid(String maingoodsid) {
		this.maingoodsid = maingoodsid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getHtmlpath() {
		return htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}


	public String getMemberprice() {
		return memberprice;
	}

	public void setMemberprice(String memberprice) {
		this.memberprice = memberprice;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPictureurl() {
		return pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public GoodsBelinkedModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
