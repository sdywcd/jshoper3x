package com.jshop.action.backstage.modelbean;

public class GoodsBelinkedModel {

	private String belinkedgoodsid;//被关联商品id
	
	private String memberprice;//会员价/套餐价/组合价
	
	private String price;//市场价，
	
	private String pictureurl;//主图片
	
	private String goodsname;
	
	private String htmlpath;

	public String getHtmlpath() {
		return htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}

	public String getBelinkedgoodsid() {
		return belinkedgoodsid;
	}

	public void setBelinkedgoodsid(String belinkedgoodsid) {
		this.belinkedgoodsid = belinkedgoodsid;
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
