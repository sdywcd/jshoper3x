package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
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
	private BigDecimal cost;
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
	private String mainSmallPicture;
	private BigDecimal memberprice;
	private String metaDescription;
	private String metaKeywords;
	private String navid;
	private String nname;
	private String outsitelink;
	private String pictureurl;
	private String placeStore;
	private double points;
	private BigDecimal price;
	private String productSn;
	private int quantity;
	private double readcount;
	private int realsales;
	private String recommended;
	private String relatedproductid;
	private int replycount;
	private BigDecimal saleprice;
	private int sales;
	private String salestate;
	private String shopid;
	private String shopname;
	private String smallPictures;
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
	@Column(unique=true, nullable=false, length=20)
	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}


	@Column(nullable=false, length=1)
	public String getBargainprice() {
		return this.bargainprice;
	}

	public void setBargainprice(String bargainprice) {
		this.bargainprice = bargainprice;
	}


	@Column(nullable=false, length=20)
	public String getBrandid() {
		return this.brandid;
	}

	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}


	@Column(nullable=false, length=50)
	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}


	@Column(nullable=false, length=1000)
	public String getCommoditylist() {
		return this.commoditylist;
	}

	public void setCommoditylist(String commoditylist) {
		this.commoditylist = commoditylist;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	@Column(nullable=false, length=20)
	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	@Column(nullable=false, length=50)
	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}


	@Column(name="FREEZE_STORE", nullable=false)
	public int getFreezeStore() {
		return this.freezeStore;
	}

	public void setFreezeStore(int freezeStore) {
		this.freezeStore = freezeStore;
	}


	@Column(name="GOODS_PARAMETER_VALUE", nullable=false, length=5000)
	public String getGoodsParameterValue() {
		return this.goodsParameterValue;
	}

	public void setGoodsParameterValue(String goodsParameterValue) {
		this.goodsParameterValue = goodsParameterValue;
	}


	@Column(name="GOODS_TYPE_ID", nullable=false, length=20)
	public String getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}


	@Column(name="GOODS_TYPE_NAME", nullable=false, length=45)
	public String getGoodsTypeName() {
		return this.goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}


	@Column(nullable=false, length=200)
	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}


	@Column(nullable=false, length=1)
	public String getHotsale() {
		return this.hotsale;
	}

	public void setHotsale(String hotsale) {
		this.hotsale = hotsale;
	}


	@Column(name="HTML_PATH", nullable=false, length=255)
	public String getHtmlPath() {
		return this.htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}


	@Column(name="IS_NEW", nullable=false, length=1)
	public String getIsNew() {
		return this.isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}


	@Column(name="IS_SPECIFICATIONS_OPEN", nullable=false, length=1)
	public String getIsSpecificationsOpen() {
		return this.isSpecificationsOpen;
	}

	public void setIsSpecificationsOpen(String isSpecificationsOpen) {
		this.isSpecificationsOpen = isSpecificationsOpen;
	}


	@Column(nullable=false, length=1)
	public String getIsgroup() {
		return this.isgroup;
	}

	public void setIsgroup(String isgroup) {
		this.isgroup = isgroup;
	}


	@Column(nullable=false, length=1)
	public String getIsmobileplatformgoods() {
		return this.ismobileplatformgoods;
	}

	public void setIsmobileplatformgoods(String ismobileplatformgoods) {
		this.ismobileplatformgoods = ismobileplatformgoods;
	}


	@Column(nullable=false, length=1)
	public String getIsoutsite() {
		return this.isoutsite;
	}

	public void setIsoutsite(String isoutsite) {
		this.isoutsite = isoutsite;
	}


	@Column(nullable=false, length=1)
	public String getIssecondkill() {
		return this.issecondkill;
	}

	public void setIssecondkill(String issecondkill) {
		this.issecondkill = issecondkill;
	}


	@Column(nullable=false, length=1)
	public String getIsvirtualsale() {
		return this.isvirtualsale;
	}

	public void setIsvirtualsale(String isvirtualsale) {
		this.isvirtualsale = isvirtualsale;
	}


	@Column(nullable=false, length=20)
	public String getKeywordid() {
		return this.keywordid;
	}

	public void setKeywordid(String keywordid) {
		this.keywordid = keywordid;
	}


	@Column(nullable=false, length=45)
	public String getKeywordname() {
		return this.keywordname;
	}

	public void setKeywordname(String keywordname) {
		this.keywordname = keywordname;
	}


	@Column(nullable=false, length=50)
	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}


	@Column(nullable=false, length=20)
	public String getLtypeid() {
		return this.ltypeid;
	}

	public void setLtypeid(String ltypeid) {
		this.ltypeid = ltypeid;
	}


	@Column(name="MAIN_PICTURE", nullable=false, length=100)
	public String getMainPicture() {
		return this.mainPicture;
	}

	public void setMainPicture(String mainPicture) {
		this.mainPicture = mainPicture;
	}


	@Column(name="MAIN_SMALL_PICTURE", nullable=false, length=100)
	public String getMainSmallPicture() {
		return this.mainSmallPicture;
	}

	public void setMainSmallPicture(String mainSmallPicture) {
		this.mainSmallPicture = mainSmallPicture;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getMemberprice() {
		return this.memberprice;
	}

	public void setMemberprice(BigDecimal memberprice) {
		this.memberprice = memberprice;
	}


	@Column(name="META_DESCRIPTION", nullable=false, length=255)
	public String getMetaDescription() {
		return this.metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}


	@Column(name="META_KEYWORDS", nullable=false, length=255)
	public String getMetaKeywords() {
		return this.metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}


	@Column(nullable=false, length=20)
	public String getNavid() {
		return this.navid;
	}

	public void setNavid(String navid) {
		this.navid = navid;
	}


	@Column(nullable=false, length=50)
	public String getNname() {
		return this.nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}


	@Column(nullable=false, length=255)
	public String getOutsitelink() {
		return this.outsitelink;
	}

	public void setOutsitelink(String outsitelink) {
		this.outsitelink = outsitelink;
	}


	@Column(nullable=false, length=2000)
	public String getPictureurl() {
		return this.pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}


	@Column(name="PLACE_STORE", nullable=false, length=100)
	public String getPlaceStore() {
		return this.placeStore;
	}

	public void setPlaceStore(String placeStore) {
		this.placeStore = placeStore;
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


	@Column(name="PRODUCT_SN", nullable=false, length=45)
	public String getProductSn() {
		return this.productSn;
	}

	public void setProductSn(String productSn) {
		this.productSn = productSn;
	}


	@Column(nullable=false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Column(nullable=false)
	public double getReadcount() {
		return this.readcount;
	}

	public void setReadcount(double readcount) {
		this.readcount = readcount;
	}


	@Column(nullable=false)
	public int getRealsales() {
		return this.realsales;
	}

	public void setRealsales(int realsales) {
		this.realsales = realsales;
	}


	@Column(nullable=false, length=1)
	public String getRecommended() {
		return this.recommended;
	}

	public void setRecommended(String recommended) {
		this.recommended = recommended;
	}


	@Column(nullable=false, length=500)
	public String getRelatedproductid() {
		return this.relatedproductid;
	}

	public void setRelatedproductid(String relatedproductid) {
		this.relatedproductid = relatedproductid;
	}


	@Column(nullable=false)
	public int getReplycount() {
		return this.replycount;
	}

	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getSaleprice() {
		return this.saleprice;
	}

	public void setSaleprice(BigDecimal saleprice) {
		this.saleprice = saleprice;
	}


	@Column(nullable=false)
	public int getSales() {
		return this.sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}


	@Column(nullable=false, length=1)
	public String getSalestate() {
		return this.salestate;
	}

	public void setSalestate(String salestate) {
		this.salestate = salestate;
	}


	@Column(nullable=false, length=20)
	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	@Column(nullable=false, length=100)
	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}


	@Column(name="SMALL_PICTURES", nullable=false, length=2000)
	public String getSmallPictures() {
		return this.smallPictures;
	}

	public void setSmallPictures(String smallPictures) {
		this.smallPictures = smallPictures;
	}


	@Column(nullable=false, length=50)
	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}


	@Column(nullable=false)
	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}


	@Column(nullable=false, length=20)
	public String getStypeid() {
		return this.stypeid;
	}

	public void setStypeid(String stypeid) {
		this.stypeid = stypeid;
	}


	@Column(nullable=false, length=100)
	public String getSubgoodsname() {
		return this.subgoodsname;
	}

	public void setSubgoodsname(String subgoodsname) {
		this.subgoodsname = subgoodsname;
	}


	@Column(nullable=false)
	public int getTotalcomment() {
		return this.totalcomment;
	}

	public void setTotalcomment(int totalcomment) {
		this.totalcomment = totalcomment;
	}


	@Column(nullable=false)
	public int getTotalstar() {
		return this.totalstar;
	}

	public void setTotalstar(int totalstar) {
		this.totalstar = totalstar;
	}


	@Column(nullable=false)
	public int getTotalstaruser() {
		return this.totalstaruser;
	}

	public void setTotalstaruser(int totalstaruser) {
		this.totalstaruser = totalstaruser;
	}


	@Column(nullable=false, length=45)
	public String getUnitname() {
		return this.unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}


	@Column(nullable=false, length=20)
	public String getUnitnameid() {
		return this.unitnameid;
	}

	public void setUnitnameid(String unitnameid) {
		this.unitnameid = unitnameid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	@Column(nullable=false, length=45)
	public String getUsersetnum() {
		return this.usersetnum;
	}

	public void setUsersetnum(String usersetnum) {
		this.usersetnum = usersetnum;
	}


	@Column(nullable=false)
	public int getVersiont() {
		return this.versiont;
	}

	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}


	@Column(nullable=false, length=20)
	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

}