package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the goods_group_t database table.
 * 
 */
@Entity
@Table(name="goods_group_t")
@NamedQuery(name="GoodsGroupT.findAll", query="SELECT g FROM GoodsGroupT g")
public class GoodsGroupT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String groupid;
	private String bargainprice;
	private String brandid;
	private String brandname;
	private String commoditylist;
	private BigDecimal cost;
	private Date createtime;
	private String creatorid;
	private String fname;
	private String goodsParameterValue;
	private String goodsTypeId;
	private String goodsTypeName;
	private String goodsid;
	private String goodsname;
	private Date groupBeginTime;
	private Date groupEndTime;
	private double groupNeedPointsLimit;
	private String groupname;
	private BigDecimal groupprice;
	private String hotsale;
	private String htmlPath;
	private String isNew;
	private String ismobileplatformgoods;
	private String isoutsite;
	private String isvirtualsale;
	private String keywords;
	private int limitBuy;
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
	private String pictures;
	private double points;
	private BigDecimal price;
	private double readcount;
	private int realOrdersCount;
	private String recommended;
	private BigDecimal saleprice;
	private String salestate;
	private String shopid;
	private String shopname;
	private String smallPictures;
	private String sname;
	private int sort;
	private String stypeid;
	private String subgroupname;
	private int totalcomment;
	private int totalstar;
	private int totalstaruser;
	private Date updatetime;
	private String usersetnum;
	private int versiont;
	private int virtualOrdersCount;

	public GoodsGroupT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
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


	@Column(nullable=false, length=45)
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


	@Column(nullable=false, length=20)
	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
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


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="GROUP_BEGIN_TIME", nullable=false)
	public Date getGroupBeginTime() {
		return this.groupBeginTime;
	}

	public void setGroupBeginTime(Date groupBeginTime) {
		this.groupBeginTime = groupBeginTime;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="GROUP_END_TIME", nullable=false)
	public Date getGroupEndTime() {
		return this.groupEndTime;
	}

	public void setGroupEndTime(Date groupEndTime) {
		this.groupEndTime = groupEndTime;
	}


	@Column(name="GROUP_NEED_POINTS_LIMIT", nullable=false)
	public double getGroupNeedPointsLimit() {
		return this.groupNeedPointsLimit;
	}

	public void setGroupNeedPointsLimit(double groupNeedPointsLimit) {
		this.groupNeedPointsLimit = groupNeedPointsLimit;
	}


	@Column(nullable=false, length=100)
	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getGroupprice() {
		return this.groupprice;
	}

	public void setGroupprice(BigDecimal groupprice) {
		this.groupprice = groupprice;
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
	public String getIsvirtualsale() {
		return this.isvirtualsale;
	}

	public void setIsvirtualsale(String isvirtualsale) {
		this.isvirtualsale = isvirtualsale;
	}


	@Column(nullable=false, length=45)
	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}


	@Column(name="LIMIT_BUY", nullable=false)
	public int getLimitBuy() {
		return this.limitBuy;
	}

	public void setLimitBuy(int limitBuy) {
		this.limitBuy = limitBuy;
	}


	@Column(nullable=false, length=20)
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


	@Column(name="MAIN_SMALL_PICTURE", length=100)
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


	@Column(nullable=false, length=20)
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


	@Column(length=2000)
	public String getPictures() {
		return this.pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
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


	@Column(nullable=false)
	public double getReadcount() {
		return this.readcount;
	}

	public void setReadcount(double readcount) {
		this.readcount = readcount;
	}


	@Column(name="REAL_ORDERS_COUNT", nullable=false)
	public int getRealOrdersCount() {
		return this.realOrdersCount;
	}

	public void setRealOrdersCount(int realOrdersCount) {
		this.realOrdersCount = realOrdersCount;
	}


	@Column(nullable=false, length=1)
	public String getRecommended() {
		return this.recommended;
	}

	public void setRecommended(String recommended) {
		this.recommended = recommended;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getSaleprice() {
		return this.saleprice;
	}

	public void setSaleprice(BigDecimal saleprice) {
		this.saleprice = saleprice;
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


	@Column(name="SMALL_PICTURES", length=2000)
	public String getSmallPictures() {
		return this.smallPictures;
	}

	public void setSmallPictures(String smallPictures) {
		this.smallPictures = smallPictures;
	}


	@Column(nullable=false, length=20)
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
	public String getSubgroupname() {
		return this.subgroupname;
	}

	public void setSubgroupname(String subgroupname) {
		this.subgroupname = subgroupname;
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


	@Column(name="VIRTUAL_ORDERS_COUNT", nullable=false)
	public int getVirtualOrdersCount() {
		return this.virtualOrdersCount;
	}

	public void setVirtualOrdersCount(int virtualOrdersCount) {
		this.virtualOrdersCount = virtualOrdersCount;
	}

}