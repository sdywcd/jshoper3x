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
	private String mainPicture;
	private String mainSmallPicture;
	private BigDecimal memberprice;
	private String metaDescription;
	private String metaKeywords;
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
	private int sort;
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
	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
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


	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
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


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="GROUP_BEGIN_TIME")
	public Date getGroupBeginTime() {
		return this.groupBeginTime;
	}

	public void setGroupBeginTime(Date groupBeginTime) {
		this.groupBeginTime = groupBeginTime;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="GROUP_END_TIME")
	public Date getGroupEndTime() {
		return this.groupEndTime;
	}

	public void setGroupEndTime(Date groupEndTime) {
		this.groupEndTime = groupEndTime;
	}


	@Column(name="GROUP_NEED_POINTS_LIMIT")
	public double getGroupNeedPointsLimit() {
		return this.groupNeedPointsLimit;
	}

	public void setGroupNeedPointsLimit(double groupNeedPointsLimit) {
		this.groupNeedPointsLimit = groupNeedPointsLimit;
	}


	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}


	public BigDecimal getGroupprice() {
		return this.groupprice;
	}

	public void setGroupprice(BigDecimal groupprice) {
		this.groupprice = groupprice;
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


	public String getIsvirtualsale() {
		return this.isvirtualsale;
	}

	public void setIsvirtualsale(String isvirtualsale) {
		this.isvirtualsale = isvirtualsale;
	}


	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}


	@Column(name="LIMIT_BUY")
	public int getLimitBuy() {
		return this.limitBuy;
	}

	public void setLimitBuy(int limitBuy) {
		this.limitBuy = limitBuy;
	}


	@Column(name="MAIN_PICTURE")
	public String getMainPicture() {
		return this.mainPicture;
	}

	public void setMainPicture(String mainPicture) {
		this.mainPicture = mainPicture;
	}


	@Column(name="MAIN_SMALL_PICTURE")
	public String getMainSmallPicture() {
		return this.mainSmallPicture;
	}

	public void setMainSmallPicture(String mainSmallPicture) {
		this.mainSmallPicture = mainSmallPicture;
	}


	public BigDecimal getMemberprice() {
		return this.memberprice;
	}

	public void setMemberprice(BigDecimal memberprice) {
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


	public String getOutsitelink() {
		return this.outsitelink;
	}

	public void setOutsitelink(String outsitelink) {
		this.outsitelink = outsitelink;
	}


	public String getPictures() {
		return this.pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}


	public double getPoints() {
		return this.points;
	}

	public void setPoints(double points) {
		this.points = points;
	}


	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public double getReadcount() {
		return this.readcount;
	}

	public void setReadcount(double readcount) {
		this.readcount = readcount;
	}


	@Column(name="REAL_ORDERS_COUNT")
	public int getRealOrdersCount() {
		return this.realOrdersCount;
	}

	public void setRealOrdersCount(int realOrdersCount) {
		this.realOrdersCount = realOrdersCount;
	}


	public String getRecommended() {
		return this.recommended;
	}

	public void setRecommended(String recommended) {
		this.recommended = recommended;
	}


	public BigDecimal getSaleprice() {
		return this.saleprice;
	}

	public void setSaleprice(BigDecimal saleprice) {
		this.saleprice = saleprice;
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


	@Column(name="SMALL_PICTURES")
	public String getSmallPictures() {
		return this.smallPictures;
	}

	public void setSmallPictures(String smallPictures) {
		this.smallPictures = smallPictures;
	}


	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}


	public String getSubgroupname() {
		return this.subgroupname;
	}

	public void setSubgroupname(String subgroupname) {
		this.subgroupname = subgroupname;
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


	@Column(name="VIRTUAL_ORDERS_COUNT")
	public int getVirtualOrdersCount() {
		return this.virtualOrdersCount;
	}

	public void setVirtualOrdersCount(int virtualOrdersCount) {
		this.virtualOrdersCount = virtualOrdersCount;
	}

}