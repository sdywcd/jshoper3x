package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the goods_t database table.
 * 
 */
@Entity
@Table(name="goods_t")
@NamedQuery(name="GoodsT.findAll", query="SELECT g FROM GoodsT g")
public class GoodsT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String goodsid;
	private String bargainprice;
	private String brandid;
	private String brandname;
	private String commoditylist;
	private double cost;
	private Date createtime;
	private String creatorid;
	private String fname;
	private int freezeStore;
	private String goodsParameterValue;
	private String goodsTypeId;
	private String goodsTypeName;
	private String goodsname;
	private String hotsale;
	private String htmlPath;
	private String isNew;
	private String isSpecificationsOpen;
	private String isgroup;
	private String ismobileplatformgoods;
	private String isoutsite;
	private String issecondkill;
	private String isvirtualsale;
	private String keywordid;
	private String keywordname;
	private String lname;
	private String ltypeid;
	private String mainPicture;
	private String mainSmaillPicture;
	private double memberprice;
	private String metaDescription;
	private String metaKeywords;
	private String navid;
	private String nname;
	private String outsitelink;
	private String pictureurl;
	private String placeStore;
	private double points;
	private double price;
	private String productSn;
	private int quantity;
	private int readcount;
	private int realsales;
	private String recommended;
	private String relatedproductid;
	private int replycount;
	private double saleprice;
	private int sales;
	private String salestate;
	private String shopid;
	private String shopname;
	private String smaillPictures;
	private String sname;
	private int sort;
	private String stypeid;
	private String subgoodsname;
	private int totalcomment;
	private int totalstar;
	private int totalstaruser;
	private String unitname;
	private String unitnameid;
	private Date updatetime;
	private String usersetnum;
	private int versiont;
	private String weight;

	public GoodsT() {
	}


	@Id
	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}


	public String getBargainprice() {
		return this.bargainprice;
	}

	public void setBargainprice(String bargainprice) {
		this.bargainprice = bargainprice;
	}


	public String getBrandid() {
		return this.brandid;
	}

	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}


	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}


	public String getCommoditylist() {
		return this.commoditylist;
	}

	public void setCommoditylist(String commoditylist) {
		this.commoditylist = commoditylist;
	}


	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}


	@Column(name="FREEZE_STORE")
	public int getFreezeStore() {
		return this.freezeStore;
	}

	public void setFreezeStore(int freezeStore) {
		this.freezeStore = freezeStore;
	}


	@Column(name="GOODS_PARAMETER_VALUE")
	public String getGoodsParameterValue() {
		return this.goodsParameterValue;
	}

	public void setGoodsParameterValue(String goodsParameterValue) {
		this.goodsParameterValue = goodsParameterValue;
	}


	@Column(name="GOODS_TYPE_ID")
	public String getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}


	@Column(name="GOODS_TYPE_NAME")
	public String getGoodsTypeName() {
		return this.goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}


	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}


	public String getHotsale() {
		return this.hotsale;
	}

	public void setHotsale(String hotsale) {
		this.hotsale = hotsale;
	}


	@Column(name="HTML_PATH")
	public String getHtmlPath() {
		return this.htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}


	@Column(name="IS_NEW")
	public String getIsNew() {
		return this.isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}


	@Column(name="IS_SPECIFICATIONS_OPEN")
	public String getIsSpecificationsOpen() {
		return this.isSpecificationsOpen;
	}

	public void setIsSpecificationsOpen(String isSpecificationsOpen) {
		this.isSpecificationsOpen = isSpecificationsOpen;
	}


	public String getIsgroup() {
		return this.isgroup;
	}

	public void setIsgroup(String isgroup) {
		this.isgroup = isgroup;
	}


	public String getIsmobileplatformgoods() {
		return this.ismobileplatformgoods;
	}

	public void setIsmobileplatformgoods(String ismobileplatformgoods) {
		this.ismobileplatformgoods = ismobileplatformgoods;
	}


	public String getIsoutsite() {
		return this.isoutsite;
	}

	public void setIsoutsite(String isoutsite) {
		this.isoutsite = isoutsite;
	}


	public String getIssecondkill() {
		return this.issecondkill;
	}

	public void setIssecondkill(String issecondkill) {
		this.issecondkill = issecondkill;
	}


	public String getIsvirtualsale() {
		return this.isvirtualsale;
	}

	public void setIsvirtualsale(String isvirtualsale) {
		this.isvirtualsale = isvirtualsale;
	}


	public String getKeywordid() {
		return this.keywordid;
	}

	public void setKeywordid(String keywordid) {
		this.keywordid = keywordid;
	}


	public String getKeywordname() {
		return this.keywordname;
	}

	public void setKeywordname(String keywordname) {
		this.keywordname = keywordname;
	}


	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getLtypeid() {
		return this.ltypeid;
	}

	public void setLtypeid(String ltypeid) {
		this.ltypeid = ltypeid;
	}


	@Column(name="MAIN_PICTURE")
	public String getMainPicture() {
		return this.mainPicture;
	}

	public void setMainPicture(String mainPicture) {
		this.mainPicture = mainPicture;
	}


	@Column(name="MAIN_SMAILL_PICTURE")
	public String getMainSmaillPicture() {
		return this.mainSmaillPicture;
	}

	public void setMainSmaillPicture(String mainSmaillPicture) {
		this.mainSmaillPicture = mainSmaillPicture;
	}


	public double getMemberprice() {
		return this.memberprice;
	}

	public void setMemberprice(double memberprice) {
		this.memberprice = memberprice;
	}


	@Column(name="META_DESCRIPTION")
	public String getMetaDescription() {
		return this.metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}


	@Column(name="META_KEYWORDS")
	public String getMetaKeywords() {
		return this.metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}


	public String getNavid() {
		return this.navid;
	}

	public void setNavid(String navid) {
		this.navid = navid;
	}


	public String getNname() {
		return this.nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}


	public String getOutsitelink() {
		return this.outsitelink;
	}

	public void setOutsitelink(String outsitelink) {
		this.outsitelink = outsitelink;
	}


	public String getPictureurl() {
		return this.pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}


	@Column(name="PLACE_STORE")
	public String getPlaceStore() {
		return this.placeStore;
	}

	public void setPlaceStore(String placeStore) {
		this.placeStore = placeStore;
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


	@Column(name="PRODUCT_SN")
	public String getProductSn() {
		return this.productSn;
	}

	public void setProductSn(String productSn) {
		this.productSn = productSn;
	}


	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getReadcount() {
		return this.readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}


	public int getRealsales() {
		return this.realsales;
	}

	public void setRealsales(int realsales) {
		this.realsales = realsales;
	}


	public String getRecommended() {
		return this.recommended;
	}

	public void setRecommended(String recommended) {
		this.recommended = recommended;
	}


	public String getRelatedproductid() {
		return this.relatedproductid;
	}

	public void setRelatedproductid(String relatedproductid) {
		this.relatedproductid = relatedproductid;
	}


	public int getReplycount() {
		return this.replycount;
	}

	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}


	public double getSaleprice() {
		return this.saleprice;
	}

	public void setSaleprice(double saleprice) {
		this.saleprice = saleprice;
	}


	public int getSales() {
		return this.sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}


	public String getSalestate() {
		return this.salestate;
	}

	public void setSalestate(String salestate) {
		this.salestate = salestate;
	}


	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}


	@Column(name="SMAILL_PICTURES")
	public String getSmaillPictures() {
		return this.smaillPictures;
	}

	public void setSmaillPictures(String smaillPictures) {
		this.smaillPictures = smaillPictures;
	}


	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}


	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}


	public String getStypeid() {
		return this.stypeid;
	}

	public void setStypeid(String stypeid) {
		this.stypeid = stypeid;
	}


	public String getSubgoodsname() {
		return this.subgoodsname;
	}

	public void setSubgoodsname(String subgoodsname) {
		this.subgoodsname = subgoodsname;
	}


	public int getTotalcomment() {
		return this.totalcomment;
	}

	public void setTotalcomment(int totalcomment) {
		this.totalcomment = totalcomment;
	}


	public int getTotalstar() {
		return this.totalstar;
	}

	public void setTotalstar(int totalstar) {
		this.totalstar = totalstar;
	}


	public int getTotalstaruser() {
		return this.totalstaruser;
	}

	public void setTotalstaruser(int totalstaruser) {
		this.totalstaruser = totalstaruser;
	}


	public String getUnitname() {
		return this.unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}


	public String getUnitnameid() {
		return this.unitnameid;
	}

	public void setUnitnameid(String unitnameid) {
		this.unitnameid = unitnameid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	public String getUsersetnum() {
		return this.usersetnum;
	}

	public void setUsersetnum(String usersetnum) {
		this.usersetnum = usersetnum;
	}


	public int getVersiont() {
		return this.versiont;
	}

	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}


	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

}