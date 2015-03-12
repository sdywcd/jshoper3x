package com.jshop.action.backstage.goods;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.image.ImgTAction;
import com.jshop.action.backstage.staticspage.CreateHtml;
import com.jshop.action.backstage.staticspage.DataCollectionTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GoodsAttributeRpT;
import com.jshop.entity.GoodsDetailRpT;
import com.jshop.entity.GoodsSpecificationsProductRpT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.GoodsTwocodeRpT;
import com.jshop.entity.GoodsTypeTN;
import com.jshop.entity.ProductT;
import com.jshop.service.ArticleCategoryTService;
import com.jshop.service.ArticleTService;
import com.jshop.service.GoodsAttributeRpTService;
import com.jshop.service.GoodsBelinkedTService;
import com.jshop.service.GoodsCommentTService;
import com.jshop.service.GoodsDetailRpTService;
import com.jshop.service.GoodsSpecificationsProductRpTService;
import com.jshop.service.GoodsTService;
import com.jshop.service.GoodsTwocodeRelationshipTService;
import com.jshop.service.GoodsTypeTNService;
import com.jshop.service.JshopbasicInfoTService;
import com.jshop.service.ProductTService;
import com.jshop.service.SiteNavigationTService;
import com.jshop.service.impl.Serial;
import com.jshop.vo.GoodsParameterlistVo;
import com.swetake.util.Qrcode;

import freemarker.template.TemplateException;
@Namespace("/admin/goods")
@ParentPackage("jshop")
public class GoodsTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private GoodsTService goodsTService;
	private ImgTAction imgTAction;
	private ProductTService productTService;
	private ArticleTService articleTService;
	private ArticleCategoryTService articleCategoryTService;
	private JshopbasicInfoTService jshopbasicInfoTService;
	private SiteNavigationTService siteNavigationTService;
	private GoodsAttributeRpTService goodsAttributeRpTService;
	private GoodsDetailRpTService goodsDetailRpTService;
	private GoodsCommentTService goodsCommentTService;
	private GoodsTypeTNService goodsTypeTNService;
	private GoodsBelinkedTService goodsBelinkedTService;
	private CreateHtml createHtml;
	private DataCollectionTAction dataCollectionTAction;
	private GoodsSpecificationsProductRpTService goodsSpecificationsProductRpTService;
	private GoodsTwocodeRelationshipTService goodsTwocodeRelationshipTService;
	private String goodsid;
	private String goodsname;
	private String brandname;
	private String nname;
	private String lname;
	private String sname;
	private String fname;
	private String navid;
	private String ltypeid;
	private String stypeid;
	private String price;
	private String memberprice;
	private String points;
	private String pictureurl;
	private String quantity;
	private String salestate;
	private String detail;
	private String keywordname;
	private String weight;
	private String readcount;
	private String relatedproductid;
	private String recommended;
	private String hotsale;
	private String bargainprice;
	private String sort;
	private Date createtime;
	private String creatorid;
	private String replycount;
	private String brandid;
	private String placeStore;
	private String metaKeywords;
	private String metaDescription;
	private String cost;
	private String saleprice;
	private String isNew;
	private String htmlPath;
	private String productSn;
	private String productName;
	private String unit;
	private String store;
	private String isDefault;
	private String isSalestate;
	private String warehouseLocation;
	private String goodsParameterValue;
	private String freezeStore;
	private String keywordid;
	private String productplaceid;
	private String goodsTypeId;
	private String goodsTypeName;
	private String goodsAttrsVals;
	private String usersetnum;
	private String isSpecificationsOpen;
	private String specificationsValue;
	private String specificationsid;
	private String specificationsName;
	private String star;
	private String otherPath;
	private String pathName;
	private String staruser;
	private String totalcomment;
	private String ismobileplatformgoods;
	private String commoditylist;//清单
	private String belinkedgoodsid;//关联商品id串
	private String isvirtualsale;//是否虚拟商品标记
	private String virtualresults;//虚拟商品返回结果
	private String productid;
	private String isoutsite;
	private String outsitelink;
	private String rejson;
	private GoodsT bean = new GoodsT();
	private GoodsT gt = new GoodsT();
	private List<GoodsT>beanlist=new ArrayList<GoodsT>();
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private Map<String, Object> map = new HashMap<String, Object>();
	private List<GoodsTypeTN>gtnlist=new ArrayList<GoodsTypeTN>();
	private GoodsTypeTN gtnbean=new GoodsTypeTN();
	private List<GoodsParameterlistVo>gmllist=new ArrayList<GoodsParameterlistVo>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private File fileupload;
	private String fileuploadFileName;
	private String allfilename;
	private String pcpath;
	private String twocodepath;
	private String basepath;
	private boolean sucflag;
	@JSON(serialize = false)
	public ProductTService getProductTService() {
		return productTService;
	}

	public void setProductTService(ProductTService productTService) {
		this.productTService = productTService;
	}

	@JSON(serialize = false)
	public GoodsDetailRpTService getGoodsDetailRpTService() {
		return goodsDetailRpTService;
	}

	public void setGoodsDetailRpTService(GoodsDetailRpTService goodsDetailRpTService) {
		this.goodsDetailRpTService = goodsDetailRpTService;
	}

	@JSON(serialize = false)
	public GoodsAttributeRpTService getGoodsAttributeRpTService() {
		return goodsAttributeRpTService;
	}

	public void setGoodsAttributeRpTService(
			GoodsAttributeRpTService goodsAttributeRpTService) {
		this.goodsAttributeRpTService = goodsAttributeRpTService;
	}

	@JSON(serialize = false)
	public GoodsTwocodeRelationshipTService getGoodsTwocodeRelationshipTService() {
		return goodsTwocodeRelationshipTService;
	}

	public void setGoodsTwocodeRelationshipTService(
			GoodsTwocodeRelationshipTService goodsTwocodeRelationshipTService) {
		this.goodsTwocodeRelationshipTService = goodsTwocodeRelationshipTService;
	}

	@JSON(serialize = false)
	public GoodsBelinkedTService getGoodsBelinkedTService() {
		return goodsBelinkedTService;
	}

	public void setGoodsBelinkedTService(GoodsBelinkedTService goodsBelinkedTService) {
		this.goodsBelinkedTService = goodsBelinkedTService;
	}

	@JSON(serialize = false)
	public GoodsTypeTNService getGoodsTypeTNService() {
		return goodsTypeTNService;
	}

	public void setGoodsTypeTNService(GoodsTypeTNService goodsTypeTNService) {
		this.goodsTypeTNService = goodsTypeTNService;
	}

	@JSON(serialize = false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}

	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}

	@JSON(serialize = false)
	public GoodsTService getGoodsTService() {
		return goodsTService;
	}

	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}

	@JSON(serialize = false)
	public ArticleTService getArticleTService() {
		return articleTService;
	}

	public void setArticleTService(ArticleTService articleTService) {
		this.articleTService = articleTService;
	}

	@JSON(serialize = false)
	public ArticleCategoryTService getArticleCategoryTService() {
		return articleCategoryTService;
	}

	public void setArticleCategoryTService(ArticleCategoryTService articleCategoryTService) {
		this.articleCategoryTService = articleCategoryTService;
	}

	@JSON(serialize = false)
	public JshopbasicInfoTService getJshopbasicInfoTService() {
		return jshopbasicInfoTService;
	}

	public void setJshopbasicInfoTService(JshopbasicInfoTService jshopbasicInfoTService) {
		this.jshopbasicInfoTService = jshopbasicInfoTService;
	}

	@JSON(serialize = false)
	public SiteNavigationTService getSiteNavigationTService() {
		return siteNavigationTService;
	}

	public void setSiteNavigationTService(SiteNavigationTService siteNavigationTService) {
		this.siteNavigationTService = siteNavigationTService;
	}

	@JSON(serialize = false)
	public GoodsCommentTService getGoodsCommentTService() {
		return goodsCommentTService;
	}

	public void setGoodsCommentTService(GoodsCommentTService goodsCommentTService) {
		this.goodsCommentTService = goodsCommentTService;
	}
	
	@JSON(serialize = false)
	public GoodsSpecificationsProductRpTService getGoodsSpecificationsProductRpTService() {
		return goodsSpecificationsProductRpTService;
	}

	public void setGoodsSpecificationsProductRpTService(
			GoodsSpecificationsProductRpTService goodsSpecificationsProductRpTService) {
		this.goodsSpecificationsProductRpTService = goodsSpecificationsProductRpTService;
	}


	@JSON(serialize = false)
	public ImgTAction getImgTAction() {
		return imgTAction;
	}

	public void setImgTAction(ImgTAction imgTAction) {
		this.imgTAction = imgTAction;
	}

	@JSON(serialize = false)
	public CreateHtml getCreateHtml() {
		return createHtml;
	}

	public void setCreateHtml(CreateHtml createHtml) {
		this.createHtml = createHtml;
	}

	public String getBasepath() {
		return basepath;
	}

	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}

	public String getTwocodepath() {
		return twocodepath;
	}

	public void setTwocodepath(String twocodepath) {
		this.twocodepath = twocodepath;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
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

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}


	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getNavid() {
		return navid;
	}

	public void setNavid(String navid) {
		this.navid = navid;
	}

	public String getLtypeid() {
		return ltypeid;
	}

	public void setLtypeid(String ltypeid) {
		this.ltypeid = ltypeid;
	}

	public String getStypeid() {
		return stypeid;
	}

	public void setStypeid(String stypeid) {
		this.stypeid = stypeid;
	}

	public String getPictureurl() {
		return pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}

	public String getSalestate() {
		return salestate;
	}

	public void setSalestate(String salestate) {
		this.salestate = salestate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getKeywordname() {
		return keywordname;
	}

	public void setKeywordname(String keywordname) {
		this.keywordname = keywordname;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getRelatedproductid() {
		return relatedproductid;
	}

	public void setRelatedproductid(String relatedproductid) {
		this.relatedproductid = relatedproductid;
	}

	public String getRecommended() {
		return recommended;
	}

	public void setRecommended(String recommended) {
		this.recommended = recommended;
	}

	public String getHotsale() {
		return hotsale;
	}

	public void setHotsale(String hotsale) {
		this.hotsale = hotsale;
	}

	public String getBargainprice() {
		return bargainprice;
	}

	public void setBargainprice(String bargainprice) {
		this.bargainprice = bargainprice;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public String getBrandid() {
		return brandid;
	}

	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}

	public String getPlaceStore() {
		return placeStore;
	}

	public void setPlaceStore(String placeStore) {
		this.placeStore = placeStore;
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
	
	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}

	public String getHtmlPath() {
		return htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}

	public String getProductSn() {
		return productSn;
	}

	public void setProductSn(String productSn) {
		this.productSn = productSn;
	}

	public String getGoodsParameterValue() {
		return goodsParameterValue;
	}

	public void setGoodsParameterValue(String goodsParameterValue) {
		this.goodsParameterValue = goodsParameterValue;
	}

	public String getKeywordid() {
		return keywordid;
	}

	public void setKeywordid(String keywordid) {
		this.keywordid = keywordid;
	}

	public String getProductplaceid() {
		return productplaceid;
	}

	public void setProductplaceid(String productplaceid) {
		this.productplaceid = productplaceid;
	}

	public String getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public String getGoodsTypeName() {
		return goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}


	

	public GoodsT getBean() {
		return bean;
	}

	public void setBean(GoodsT bean) {
		this.bean = bean;
	}

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}


	public File getFileupload() {
		return fileupload;
	}

	public void setFileupload(File fileupload) {
		this.fileupload = fileupload;
	}

	public String getFileuploadFileName() {
		return fileuploadFileName;
	}

	public void setFileuploadFileName(String fileuploadFileName) {
		this.fileuploadFileName = fileuploadFileName;
	}

	public String getAllfilename() {
		return allfilename;
	}

	public void setAllfilename(String allfilename) {
		this.allfilename = allfilename;
	}

	public String getPcpath() {
		return pcpath;
	}

	public void setPcpath(String pcpath) {
		this.pcpath = pcpath;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getUsersetnum() {
		return usersetnum;
	}

	public void setUsersetnum(String usersetnum) {
		this.usersetnum = usersetnum;
	}

	public String getIsSpecificationsOpen() {
		return isSpecificationsOpen;
	}

	public void setIsSpecificationsOpen(String isSpecificationsOpen) {
		this.isSpecificationsOpen = isSpecificationsOpen;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMemberprice() {
		return memberprice;
	}

	public void setMemberprice(String memberprice) {
		this.memberprice = memberprice;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getWarehouseLocation() {
		return warehouseLocation;
	}

	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getReadcount() {
		return readcount;
	}

	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getReplycount() {
		return replycount;
	}

	public void setReplycount(String replycount) {
		this.replycount = replycount;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(String saleprice) {
		this.saleprice = saleprice;
	}

	public String getFreezeStore() {
		return freezeStore;
	}

	public void setFreezeStore(String freezeStore) {
		this.freezeStore = freezeStore;
	}

	public String getRejson() {
		return rejson;
	}

	public void setRejson(String rejson) {
		this.rejson = rejson;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getStaruser() {
		return staruser;
	}

	public void setStaruser(String staruser) {
		this.staruser = staruser;
	}

	public String getTotalcomment() {
		return totalcomment;
	}

	public void setTotalcomment(String totalcomment) {
		this.totalcomment = totalcomment;
	}

	public String getIsmobileplatformgoods() {
		return ismobileplatformgoods;
	}

	public void setIsmobileplatformgoods(String ismobileplatformgoods) {
		this.ismobileplatformgoods = ismobileplatformgoods;
	}


	public String getSpecificationsValue() {
		return specificationsValue;
	}

	public void setSpecificationsValue(String specificationsValue) {
		this.specificationsValue = specificationsValue;
	}



	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getGoodsAttrsVals() {
		return goodsAttrsVals;
	}

	public void setGoodsAttrsVals(String goodsAttrsVals) {
		this.goodsAttrsVals = goodsAttrsVals;
	}

	public GoodsT getGt() {
		return gt;
	}

	public void setGt(GoodsT gt) {
		this.gt = gt;
	}

	public List<GoodsTypeTN> getGtnlist() {
		return gtnlist;
	}

	public void setGtnlist(List<GoodsTypeTN> gtnlist) {
		this.gtnlist = gtnlist;
	}

	public GoodsTypeTN getGtnbean() {
		return gtnbean;
	}

	public void setGtnbean(GoodsTypeTN gtnbean) {
		this.gtnbean = gtnbean;
	}

	public List<GoodsParameterlistVo> getGmllist() {
		return gmllist;
	}

	public void setGmllist(List<GoodsParameterlistVo> gmllist) {
		this.gmllist = gmllist;
	}
	
	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getCommoditylist() {
		return commoditylist;
	}

	public void setCommoditylist(String commoditylist) {
		this.commoditylist = commoditylist;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getSpecificationsid() {
		return specificationsid;
	}

	public void setSpecificationsid(String specificationsid) {
		this.specificationsid = specificationsid;
	}

	public String getSpecificationsName() {
		return specificationsName;
	}

	public void setSpecificationsName(String specificationsName) {
		this.specificationsName = specificationsName;
	}

	public List<GoodsT> getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(List<GoodsT> beanlist) {
		this.beanlist = beanlist;
	}

	public String getBelinkedgoodsid() {
		return belinkedgoodsid;
	}

	public void setBelinkedgoodsid(String belinkedgoodsid) {
		this.belinkedgoodsid = belinkedgoodsid;
	}
	public String getIsvirtualsale() {
		return isvirtualsale;
	}

	public void setIsvirtualsale(String isvirtualsale) {
		this.isvirtualsale = isvirtualsale;
	}

	public String getVirtualresults() {
		return virtualresults;
	}

	public void setVirtualresults(String virtualresults) {
		this.virtualresults = virtualresults;
	}


	public String getIsSalestate() {
		return isSalestate;
	}

	public void setIsSalestate(String isSalestate) {
		this.isSalestate = isSalestate;
	}


	public String getOtherPath() {
		return otherPath;
	}

	public void setOtherPath(String otherPath) {
		this.otherPath = otherPath;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getIsoutsite() {
		return isoutsite;
	}

	public void setIsoutsite(String isoutsite) {
		this.isoutsite = isoutsite;
	}

	public String getOutsitelink() {
		return outsitelink;
	}

	public void setOutsitelink(String outsitelink) {
		this.outsitelink = outsitelink;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加商品
	 * 
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	@Action(value = "saveGoods", results = { @Result(name = "json", type = "json") })
	public String saveGoods()  {
		//构造goods
		GoodsT gt=new GoodsT();
		gt.setGoodsid(this.getSerial().Serialid(Serial.GOODS));
		gt.setGoodsTypeId(this.getGoodsTypeId());
		gt.setGoodsTypeName(this.getGoodsTypeName());
		gt.setGoodsParameterValue(this.getGoodsParameterValue());
		gt.setNavid(this.getNavid());
		gt.setNname(this.getNname());
		gt.setLtypeid(this.getLtypeid());
		gt.setLname(this.getLname());
		gt.setStypeid(this.getStypeid());
		gt.setSname(this.getSname());
		gt.setFname(this.getFname());
		gt.setGoodsname(this.getGoodsname());
		gt.setUsersetnum(this.getUsersetnum());
		gt.setBrandid(this.getBrandid());
		gt.setBrandname(this.getBrandname());
		gt.setCost(Double.parseDouble(this.getCost()));
		gt.setSaleprice(Double.parseDouble(this.getSaleprice()));
		gt.setMemberprice(Double.parseDouble(this.getMemberprice()));
		gt.setPrice(Double.parseDouble(this.getPrice()));
		gt.setPoints(Double.parseDouble(this.getPoints()));
		gt.setSort(Integer.parseInt(this.getSort()));
		gt.setIsNew(this.getIsNew());
		gt.setRecommended(this.getRecommended());
		gt.setHotsale(this.getHotsale());
		gt.setBargainprice(this.getBargainprice());
		gt.setIsvirtualsale(this.getIsvirtualsale());//是否虚拟商品标记，用于充值卡或者购物卡类没有实物的商品
		gt.setIsmobileplatformgoods(this.getIsmobileplatformgoods());
		gt.setSalestate(this.getSalestate());
		gt.setIsSpecificationsOpen(StaticKey.ONE);//默认开启规格值
		gt.setPictureurl(this.getPictureurl());
		gt.setCommoditylist(this.getCommoditylist());
		gt.setMetaDescription(this.getMetaDescription());
		gt.setMetaKeywords(this.getMetaKeywords());
		gt.setCreatetime(BaseTools.systemtime());
		gt.setCreatorid(BaseTools.getAdminCreateId());
		gt.setUpdatetime(BaseTools.systemtime());
		gt.setIsoutsite(this.getIsoutsite());
		gt.setOutsitelink(this.getOutsitelink());
		//构造goodsdetail和goods关系
		GoodsDetailRpT gdpt=new GoodsDetailRpT();
		gdpt.setId(this.getSerial().Serialid(Serial.GOODSDETAILRPT));
		gdpt.setDetail(this.getDetail());
		gdpt.setGoodsid(gt.getGoodsid());
		//构造product
		ProductT pt=new ProductT();
		pt.setProductid(this.getSerial().Serialid(Serial.PRODUCT));
		pt.setPrice(gt.getPrice());
		pt.setMemberprice(gt.getMemberprice());
		pt.setCost(gt.getCost());
		pt.setSaleprice(gt.getSaleprice());
		pt.setFreezeStore(0);
		pt.setStore(0);
		pt.setIsDefault(StaticKey.ONE);//表示默认
		pt.setIsSalestate(StaticKey.ONE);//表示对外销售状态
		pt.setProductName(gt.getGoodsname());
		pt.setProductSn(gt.getUsersetnum());
		pt.setSpecificationsValue(StaticKey.EMPTY);
		pt.setWarehouseLocation(StaticKey.EMPTY);
		pt.setPlaceStore(StaticKey.EMPTY);
		pt.setWeight(StaticKey.EMPTY);
		pt.setGoodsid(gt.getGoodsid());
		pt.setCreatorid(gt.getCreatorid());
		pt.setCreatetime(gt.getCreatetime());
		pt.setSpecificationsid(StaticKey.ZERO);//表示默认规格的值
		pt.setSpecificationsName(StaticKey.DEFAULTSPECIFNAME);//默认规格值名称
		pt.setUpdatetime(gt.getCreatetime());
		pt.setUnit(StaticKey.EMPTY);
		//构造goodsspecificationproductrp
		GoodsSpecificationsProductRpT gspt=new GoodsSpecificationsProductRpT();
		gspt.setGoodsSpecificationsProductRpTid(this.getSerial().Serialid(Serial.GOODSSPECIFICATIONSPRODUCTRPT));
		gspt.setGoodsid(gt.getGoodsid());
		gspt.setProductid(pt.getProductid());
		gspt.setSpecidicationsid("0");//0表示默认规格
		
		this.getGoodsTService().saveGoodsProcess(gt,gdpt,pt,gspt);
		this.saveGoodsAttributeRp(gt, this.getGoodsAttrsVals());
		this.setSucflag(true);
		return "json";
	
		
		
	}
	/**
	 * 保存属性和商品关系
	 * @param gt
	 * @param goodsattrsval
	 */
	private void saveGoodsAttributeRp(GoodsT gt,String goodsattrsval){
		JSONArray ja=(JSONArray)JSONValue.parse(goodsattrsval);
		int jsonsize=ja.size();
		GoodsAttributeRpT gart=new GoodsAttributeRpT();
		for(int i=0;i<jsonsize;i++){
			gart.setId(this.getSerial().Serialid(Serial.GOODSATTRIBUTERPT));
			gart.setGoodsid(gt.getGoodsid());
			JSONObject jo=(JSONObject) ja.get(i);
			gart.setAttrval(jo.get(StaticKey.ATTRVAL).toString());
			this.getGoodsAttributeRpTService().save(gart);
		}
	}

	
	/**
	 * 根据用户id读取所有该用户增加的商品
	 * 
	 * @return
	 */
	@Action(value = "findAllGoods", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
	public String findAllGoods() {
		if (StaticKey.SC.equals(this.getQtype())) {
			finddefaultAllGoods();
		} else {
			if(StringUtils.isNotBlank(this.getQtype())){
				if(this.getQtype().equals("goodsname")){
					findGoodsByGoodsname();
				}
			}
		}
		return "json";

	}
	/**
	 * 根据商品名称查询商品
	 */
	private void findGoodsByGoodsname() {
		int currentPage=page;
		int lineSize=rp;
		String qs="select count(*) from GoodsT where "+this.getQtype()+" like '%"+this.getQuery().trim()+"%' ";
		total=this.getGoodsTService().countfindAllGoodsByattribute(qs);
		if(StringUtils.isNotBlank(this.getSortname())&&StringUtils.isNotBlank(this.getSortorder())){
			String queryString="from GoodsT as gt where gt."+this.getQtype()+" like '%"+this.getQuery().trim()+"%' order by " +this.getSortname()+" "+this.getSortorder()+"";
			List<GoodsT>list=this.getGoodsTService().findAllGoodsByattribute(currentPage, lineSize, queryString);
			this.ProcessGoodsList(list);
		}
	}

	/**
	 * 获取用户的所有商品信息
	 */
	private void finddefaultAllGoods() {
		int currentPage = page;
		int lineSize = rp;
		total=this.getGoodsTService().countAllGoods();
		List<GoodsT> list = this.getGoodsTService().findAllGoods(currentPage, lineSize);
		if (!list.isEmpty()) {
			ProcessGoodsList(list);
		}
	}

	/**
	 * 迭代处理供前台显示
	 * 
	 * @param list
	 */
	public void ProcessGoodsList(List<GoodsT> list) {
		total = this.getGoodsTService().countAllGoods();
		rows.clear();
		this.setBasepath(BaseTools.getBasePath());
		for (Iterator<GoodsT> it = list.iterator(); it.hasNext();) {
			GoodsT gt = (GoodsT) it.next();
			if (gt.getRecommended().equals(StaticKey.ONE)) {
				gt.setRecommended("<span class='truestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				gt.setRecommended("<span class='falsestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (gt.getHotsale().equals(StaticKey.ONE)) {
				gt.setHotsale("<span class='truestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				gt.setHotsale("<span class='falsestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (gt.getBargainprice().equals(StaticKey.ONE)) {
				gt.setBargainprice("<span class='truestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				gt.setBargainprice("<span class='falsestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (gt.getIsNew().equals(StaticKey.ONE)) {
				gt.setIsNew("<span class='truestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				gt.setIsNew("<span class='falsestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (gt.getSalestate().equals(StaticKey.ONE)) {
				gt.setSalestate("<span class='truestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				gt.setSalestate("<span class='falsestatue'><img width='20px' height='20px' src='"+this.getBasepath()+"/admin/ui/assets/img/header/icon-48-deny.png'/></span>");
			}

			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", gt.getGoodsid());
			cellMap.put("cell", new Object[] { 
					gt.getGoodsname(), 
					gt.getUsersetnum(), 
					gt.getMemberprice(),
					gt.getNname(),  
					gt.getSalestate(), 
					gt.getIsNew(), 
					gt.getBargainprice(), 
					gt.getHotsale(), 
					gt.getRecommended(), 
					gt.getQuantity(), 
					"<a id='editgoods' href='goods.jsp?operate=edit&folder=setting&goodsid="+gt.getGoodsid()+"' name='editgoods'>[编辑]</a>"});
			rows.add(cellMap);
		}
	}

	/**
	 * 根据商品id获取商品数据
	 * 
	 * @return
	 */
	@Action(value = "findGoodsById", results = { @Result(name = "json", type = "json",params = { "excludeNullProperties", "true","goods","bean"}) })
	public String findGoodsById() {

		if (StringUtils.isNotBlank(this.getGoodsid())) {
			bean = this.getGoodsTService().findGoodsById(this.getGoodsid().trim());
			if (bean != null) {
				List<ProductT>list=this.getProductTService().findProductTByGoodsid(bean.getGoodsid());
				if(!list.isEmpty()){
					this.setProductid(list.get(0).getProductid());
				}
				this.setBasepath(BaseTools.getBasePath());
				this.setSucflag(true);
				return "json";
			}
		}
		this.setSucflag(false);
		return "json";

	}

	/**
	 * 更新文章静态路径
	 * 
	 * @param articleid
	 * @param htmlPath
	 */
	public void updateHtmlPath(String goodsid, String htmlPath) {
		this.getGoodsTService().updateHtmlPath(goodsid, htmlPath);
	}

	/**
	 * 更新商品
	 * 
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	@Action(value = "updateGoods", results = { @Result(name = "json", type = "json",params = { "excludeNullProperties", "true" }) })
	public String updateGoods() throws IOException, TemplateException {
		if(StringUtils.isNotBlank(this.getGoodsid())){
			bean=this.getGoodsTService().findGoodsById(this.getGoodsid());
			if(bean!=null){
				bean.setGoodsTypeId(this.getGoodsTypeId());
				bean.setGoodsTypeName(this.getGoodsTypeName());
				bean.setGoodsParameterValue(this.getGoodsParameterValue());
				bean.setNavid(this.getNavid());
				bean.setNname(this.getNname());
				bean.setLtypeid(this.getLtypeid());
				bean.setLname(this.getLname());
				bean.setStypeid(this.getStypeid());
				bean.setSname(this.getSname());
				bean.setFname(this.getFname());
				bean.setGoodsname(this.getGoodsname());
				bean.setUsersetnum(this.getUsersetnum());
				bean.setBrandid(this.getBrandid());
				bean.setBrandname(this.getBrandname());
				bean.setCost(Double.parseDouble(this.getCost()));
				bean.setSaleprice(Double.parseDouble(this.getSaleprice()));
				bean.setMemberprice(Double.parseDouble(this.getMemberprice()));
				bean.setPrice(Double.parseDouble(this.getPrice()));
				bean.setPoints(Double.parseDouble(this.getPoints()));
				bean.setSort(Integer.parseInt(this.getSort()));
				bean.setIsNew(this.getIsNew());
				bean.setRecommended(this.getRecommended());
				bean.setHotsale(this.getHotsale());
				bean.setBargainprice(this.getBargainprice());
				bean.setIsvirtualsale(this.getIsvirtualsale());
				bean.setIsmobileplatformgoods(this.getIsmobileplatformgoods());
				bean.setSalestate(this.getSalestate());
				bean.setPictureurl(this.getPictureurl());
				bean.setCommoditylist(this.getCommoditylist());
				bean.setMetaKeywords(this.getMetaKeywords());
				bean.setMetaDescription(this.getMetaDescription());
				bean.setCreatorid(BaseTools.getAdminCreateId());
				bean.setUpdatetime(BaseTools.systemtime());
				bean.setIsoutsite(this.getIsoutsite());
				bean.setOutsitelink(this.getOutsitelink());
				//构造product
				ProductT pt=new ProductT();
				//根据商品和规格货物关系，通过spid0和goodsid来取出addgoods时唯一对照的默认规格值的productdid进行级联更新
				//this.getGoodsSpecificationsProductRpTService().checkSpecificationRelationshipBygoodssetid(this.getGoodsid());
				pt=this.getProductTService().findProductByProductid(this.getProductid());
				pt.setPrice(bean.getPrice());
				pt.setMemberprice(bean.getMemberprice());
				pt.setCost(bean.getCost());
				pt.setSaleprice(bean.getSaleprice());
				pt.setFreezeStore(0);
				pt.setStore(0);
				pt.setIsDefault(StaticKey.ONE);//表示默认
				pt.setIsSalestate(StaticKey.ONE);//表示对外销售状态
				pt.setProductName(bean.getGoodsname());
				pt.setProductSn(bean.getUsersetnum());
				pt.setSpecificationsValue(StaticKey.EMPTY);
				pt.setWarehouseLocation(StaticKey.EMPTY);
				pt.setPlaceStore(StaticKey.EMPTY);
				pt.setWeight(StaticKey.EMPTY);
				pt.setGoodsid(bean.getGoodsid());
				pt.setCreatorid(bean.getCreatorid());
				pt.setCreatetime(bean.getCreatetime());
				pt.setSpecificationsid(StaticKey.ZERO);//表示默认规格的值
				pt.setSpecificationsName(StaticKey.DEFAULTSPECIFNAME);//默认规格值名称
				pt.setUpdatetime(bean.getCreatetime());
				pt.setUnit(StaticKey.EMPTY);
				this.getGoodsTService().updateGoodsProcess(bean, this.getDetail(),pt);
				this.updateGoodsAttributeRp(bean, this.getGoodsAttrsVals());
				this.setSucflag(true);
				return "json";
				
			}
		}
		return "json";
		
	}

	/**
	 * 更新商品属性关系
	 * @param gt
	 * @param goodsattrvals
	 */
	private void updateGoodsAttributeRp(GoodsT gt,String goodsattrvals){
		if(this.getGoodsAttributeRpTService().delBygoodsid(gt.getGoodsid())>0){
			JSONArray ja=(JSONArray)JSONValue.parse(goodsattrvals);
			int jsonsize=ja.size();
			GoodsAttributeRpT gart=new GoodsAttributeRpT();
			for(int i=0;i<jsonsize;i++){
				gart.setId(this.getSerial().Serialid(Serial.GOODSATTRIBUTERPT));
				gart.setGoodsid(gt.getGoodsid());
				JSONObject jo=(JSONObject) ja.get(i);
				gart.setAttrval(jo.get(StaticKey.ATTRVAL).toString());
				this.getGoodsAttributeRpTService().save(gart);
			}
		}
		
	}
	
	/**
	 * 删除商品同时删除商品对应的货品
	 * 
	 * @return
	 */
	@Action(value = "delGoods", results = { @Result(name = "json", type = "json") })
	//判断是否上架
	public String delGoods() {
		if (Validate.StrNotNull(this.getGoodsid())) {
			String[] strs = this.getGoodsid().split(",");
			for (int i = 0; i < strs.length; i++) {
				this.getProductTService().delProductTBygoodsid(strs[i], BaseTools.getAdminCreateId());
			}
			int i = this.getGoodsTService().delGoods(strs, BaseTools.getAdminCreateId());
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}
	}

	/**
	 * 根据goodsid更新上下架状态
	 * 
	 * @return
	 */
	@Action(value = "updateGoodsSaleState", results = { @Result(name = "json", type = "json") })
	public String updateGoodsSaleState() {
		if (Validate.StrNotNull(this.getGoodsid())) {
			String[] strs = this.getGoodsid().split(",");
			int i = this.getGoodsTService().updateGoodsSaleState(strs, this.getSalestate(), BaseTools.getAdminCreateId());
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}
	}

	/**
	 * 根据goodsid更新特价商品
	 * 
	 * @return
	 */
	@Action(value = "updateGoodsbargainprice", results = { @Result(name = "json", type = "json") })
	public String updateGoodsbargainprice() {
		if (Validate.StrNotNull(this.getGoodsid())) {
			String[] strs = this.getGoodsid().split(",");
			int i = this.getGoodsTService().updateGoodsbargainprice(strs, this.getBargainprice(), BaseTools.getAdminCreateId());
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}

	}

	/**
	 * 根据goodsid更新热销商品
	 * 
	 * @return
	 */
	@Action(value = "updateGoodshotsale", results = { @Result(name = "json", type = "json") })
	public String updateGoodshotsale() {
		if (Validate.StrNotNull(this.getGoodsid())) {
			String[] strs = this.getGoodsid().split(",");
			int i = this.getGoodsTService().updateGoodshotsale(strs, this.getHotsale(), BaseTools.getAdminCreateId());
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}
	}

	/**
	 * 根据goodsid更新推荐商品
	 * 
	 * @return
	 */
	@Action(value = "updateGoodsrecommended", results = { @Result(name = "json", type = "json") })
	public String updateGoodsrecommended() {
		if (Validate.StrNotNull(this.getGoodsid())) {
			String[] strs = this.getGoodsid().split(",");
			int i = this.getGoodsTService().updateGoodsrecommended(strs, this.getRecommended(), BaseTools.getAdminCreateId());
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}
	}

	/**
	 * 根据goodsid更新新品商品
	 * 
	 * @return
	 */
	@Action(value = "updateGoodsisNew", results = { @Result(name = "json", type = "json") })
	public String updateGoodsisNew() {
		if (Validate.StrNotNull(this.getGoodsid())) {
			String[] strs = this.getGoodsid().split(",");
			int i = this.getGoodsTService().updateGoodsisNew(strs, this.getIsNew(), BaseTools.getAdminCreateId());
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}
	}

	/**
	 * 根据商品id更新是否同步到移动平台
	 * 
	 * @return
	 */
	@Action(value = "updateGoodsismobileplatformgoods", results = { @Result(name = "json", type = "json") })
	public String updateGoodsismobileplatformgoods() {
		if (Validate.StrNotNull(this.getGoodsid())) {
			String[] strs = this.getGoodsid().split(",");
			int i = this.getGoodsTService().updateGoodsismobileplatformgoods(strs, this.getIsmobileplatformgoods(), BaseTools.getAdminCreateId());
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}
	}

	/**
	 * 根据商品id更新5种商品状态
	 * 
	 * @return
	 */
	@Action(value = "updateFiveGoodsState", results = { @Result(name = "json", type = "json") })
	public String updateFiveGoodsState() {

		if (Validate.StrNotNull(this.getGoodsid())) {
			String[] strs = this.getGoodsid().split(",");
			int i = this.getGoodsTService().updateFiveGoodsState(strs, this.getRecommended(), this.getHotsale(), this.getBargainprice(), this.getIsNew(), this.getIsmobileplatformgoods());
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}

	}

	/**
	 * 增加星级评分
	 * 
	 * @return
	 */
	@Action(value = "updatestarsumBygoodsid", results = { @Result(name = "json", type = "json") })
	public String updatestarsumBygoodsid() {
		this.getGoodsTService().updatestarsumBygoodsid(this.getGoodsid().trim(), Integer.parseInt(this.getStar()));
		this.setSucflag(true);
		return "json";
	}

	/**
	 * 更新商品总打分人数
	 * 
	 * @return
	 */
	@Action(value = "updatestarusersumBygoodsid", results = { @Result(name = "json", type = "json") })
	public String updatestarusersumBygoodsid() {
		this.getGoodsTService().updatestarusersumBygoodsid(this.getGoodsid(), Integer.parseInt(this.getStaruser()));
		this.setSucflag(true);
		return "json";
	}

	/**
	 * 更新商品总评分人数
	 * 
	 * @return
	 */
	@Action(value = "updatecommentsumBygoodsid", results = { @Result(name = "json", type = "json") })
	public String updatecommentsumBygoodsid() {
		this.getGoodsTService().updatecommentsumBygoodsid(this.getGoodsid(), Integer.parseInt(this.getTotalcomment()));
		this.setSucflag(true);
		return "json";
	}
	

	
	/**
	 * 根据顶级分类获取商品列表传送到前台给关联商品部分
	 * @return
	 */
	@Action(value = "findAllGoodsByCategory", results = { @Result(name = "json", type = "json") })
	public String findAllGoodsByCategory(){
		if(!"-1".equals(this.getNavid())&&"-1".equals(this.getLtypeid())&&"-1".equals(this.getStypeid())){
			String navid=this.getNavid().trim();
			String salestate=StaticKey.ONE;//上架
			String isSpecificationsOpen=StaticKey.ONE;//默认都开启规格
			List<GoodsT>list=this.getGoodsTService().findAllGoodsBynavid(navid, salestate,isSpecificationsOpen);
			if(!list.isEmpty()){
				this.ProcessGoodsList(list);
			}
			this.setSucflag(true);
			return "json";
		}
		if(!"-1".equals(this.getNavid())&&!"-1".equals(this.getLtypeid())&&"-1".equals(this.getStypeid())){
			String navid=this.getNavid().trim();
			String ltypeid=this.getLtypeid().trim();
			String salestate=StaticKey.ONE;//上架
			String isSpecificationsOpen=StaticKey.ONE;//开启规格
			List<GoodsT>list=this.getGoodsTService().findAllGoodsBynavidandltypeid(navid, ltypeid, salestate, isSpecificationsOpen);
			if(!list.isEmpty()){
				this.ProcessGoodsList(list);
			}
			this.setSucflag(true);
			return "json";
		}
		if(!"-1".equals(this.getNavid())&&!"-1".equals(this.getLtypeid())&&!"-1".equals(this.getStypeid())){
			String navid=this.getNavid().trim();
			String ltypeid=this.getLtypeid().trim();
			String stypeid=this.getStypeid().trim();
			String salestate=StaticKey.ONE;//上架
			String isSpecificationsOpen=StaticKey.ONE;//开启规格
			List<GoodsT>list=this.getGoodsTService().findAllGoodsBynavidandltypeidandstypeid(navid, ltypeid, stypeid, salestate, isSpecificationsOpen);
			if(!list.isEmpty()){
				this.ProcessGoodsList(list);
			}
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}
	
	/**
	 * 生成商品静态路径二维码
	 * @return
	 * @throws IOException
	 */
	@Action(value="encoderQRcode",results={@Result(name="json",type="json")})
	public String encoderQRcode() throws IOException{
		GoodsT goods=new GoodsT();
		Qrcode qr =new Qrcode();
		qr.setQrcodeErrorCorrect('M');
		qr.setQrcodeEncodeMode('B');
		qr.setQrcodeVersion(7);
		BufferedImage bufImg= new BufferedImage(140, 140, BufferedImage.TYPE_INT_RGB);
		Graphics2D gs = bufImg.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.clearRect(0, 0, 140,140);
		  // 设定图像颜色 > BLACK  
		gs.setColor(Color.BLACK);
		// 设置偏移量 不设置可能导致解析出错
		int pixoff=2;
		byte[] htmlPath;
		 // 根据商品id获取商品数据
			if (Validate.StrNotNull(this.getGoodsid())) {
				goods = this.getGoodsTService().findGoodsById(this.getGoodsid().trim());
				
				if (goods != null) {					
					HttpServletRequest requet=ServletActionContext.getRequest();
					String Path="http://"+requet.getRemoteAddr()+"/"+ goods.getHtmlPath();
					 htmlPath=Path.getBytes("utf-8");
					 // 输出内容 > 二维码  
					if(htmlPath.length>0 && htmlPath.length<120){
						boolean[][] codeOut=qr.calQrcode(htmlPath);
						for(int i=0;i<codeOut.length;i++){
							for(int j=0;j<codeOut.length;j++){
								if(codeOut[j][i]){
									gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
								}
							}
						}
					}
					gs.dispose();
					bufImg.flush();
					String jshoppath=ServletActionContext.getServletContext().getRealPath("");//获取根目录
					String path=jshoppath+isexistdir();
					//根目录路径
					String codePath=path+goods.getGoodsid()+".png";
					//文件夹路径
					String code = isexistdir()+goods.getGoodsid()+".png";
					//生成二维码图片名称
					File imgFile= new File(codePath);
					// 生成二维码QRCode图片
					ImageIO.write(bufImg, "png", imgFile);
					GoodsTwocodeRpT list = this.getGoodsTwocodeRelationshipTService().findGoodsQRCodeByGoodsid(goods.getGoodsid());
					GoodsTwocodeRpT goodscode = new GoodsTwocodeRpT();
					//当数据里面存在此记录的时候，只修改二维码路径
					if(list!=null){						
						this.getGoodsTwocodeRelationshipTService().updateGoodsQRCode(goods.getGoodsid(), code);
						this.setSucflag(true);
						return "json";
					}else{
						//生成商品与二维码关系的记录
						
						goodscode.setProductname(goods.getGoodsname());
						goodscode.setGoodsid(goods.getGoodsid());
						goodscode.setId(this.getSerial().Serialid(Serial.GOODSQRCODE));
						goodscode.setState("1");
						goodscode.setTwocodepath(code);
						this.getGoodsTwocodeRelationshipTService().save(goodscode);
						this.setSucflag(true);
						return "json";
					}
				}
				
			}else{
				htmlPath=this.getOtherPath().getBytes("utf-8");	
					 // 输出内容 > 二维码  
					if(htmlPath.length>0 && htmlPath.length<120){
						boolean[][] codeOut=qr.calQrcode(htmlPath);
						for(int i=0;i<codeOut.length;i++){
							for(int j=0;j<codeOut.length;j++){
								if(codeOut[j][i]){
									gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
								}
							}
						}
				}
				gs.dispose();
				bufImg.flush();
				String jshoppath=ServletActionContext.getServletContext().getRealPath("");//获取根目录
				String path=jshoppath+isexistdir();
				//生成二维码图片名称
				File imgFile= new File(path+this.getPathName()+".png");
				// 生成二维码QRCode图片
				ImageIO.write(bufImg, "png", imgFile);
				
				this.setSucflag(true);
				return "json";
			}
			return "json";
	}
	/**
	 * 检测目录是否存在
	 * 
	 * @return
	 */

	public static String isexistdir() {
		String nowTimeStr = "";
		String savedir = "/QRcode/";
		String realpath = "";
//		SimpleDateFormat sDateFormat;
//		sDateFormat = new SimpleDateFormat("yyyyMMdd");
//		nowTimeStr = sDateFormat.format(new Date());
		String savePath = ServletActionContext.getServletContext().getRealPath("");
		savePath = savePath + savedir ;
		File dir = new File(savePath);
		if (!dir.exists()) {
			dir.mkdirs();
			realpath = savedir ;
			return realpath;
		} else {
			realpath = savedir ;
			return realpath;
		}
	}
	/**
	 * 根据商品名称搜索商品
	 * @return
	 */
	@Action(value = "searchGoodsBygoodsname", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
	public String searchGoodsBygoodsname(){
		if(StringUtils.isBlank(this.getGoodsname())){
			return "json";
		}
		int currentPage=1;
		int lineSize=100;
		String queryString="from GoodsT as gt where gt.goodsname like '%"+this.getGoodsname()+"%' order by " +this.getSortname()+" "+this.getSortorder()+"";
		beanlist=this.getGoodsTService().findAllGoodsByattribute(currentPage, lineSize, queryString);
		if(!beanlist.isEmpty()){
			this.ProcessGoodsList(beanlist);
			this.setSucflag(true);
			return "json";
		}
		return "json";
		
	}
	
}
