package com.jshop.action.frontstage.goods;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.staticspage.DataCollectionTAction;
import com.jshop.action.backstage.staticspage.FreeMarkervariable;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GoodsGroupT;
import com.jshop.service.GoodsGroupTService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class GoodsGroupAction extends ActionSupport {
	private GoodsGroupTService goodsGroupTService;
	private DataCollectionTAction dataCollectionTAction;
	private Serial serial;
	private String pictureurl;
	private String groupid;
	private String goodsid;
	private String goodsname;
	private String state;
	private Date begintime;
	private Date endtime;
	private String creatorid;
	private Date createtime;
	private String cashstate;
	private Double cashlimit;
	private int limitbuy;
	private int salequantity;
	private int SOrderCount;
	private int totalOrderCount;
	private double sendpoint;
	private String priceladder;
	private String detail;
	private String htmlpath;
	private int total=0;
	private int page=1;
	private int rp;
	private String sortname;//排序字段
	private String sortorder;//排序方式
	private String qtype;
	private boolean goodsgroup =false;
	private GoodsGroupT groupList= new GoodsGroupT();
	
	private List rows= new ArrayList();
	@JSON(serialize = false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}

	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}
	@JSON(serialize = false)
	public GoodsGroupTService getGoodsGroupTService() {
		return goodsGroupTService;
	}

	public void setGoodsGroupTService(GoodsGroupTService goodsGroupTService) {
		this.goodsGroupTService = goodsGroupTService;
	}

	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getPictureurl() {
		return pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getBegintime() {
		return begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCashstate() {
		return cashstate;
	}

	public void setCashstate(String cashstate) {
		this.cashstate = cashstate;
	}

	public Double getCashlimit() {
		return cashlimit;
	}

	public void setCashlimit(Double cashlimit) {
		this.cashlimit = cashlimit;
	}

	public int getLimitbuy() {
		return limitbuy;
	}

	public void setLimitbuy(int limitbuy) {
		this.limitbuy = limitbuy;
	}

	public int getSalequantity() {
		return salequantity;
	}

	public void setSalequantity(int salequantity) {
		this.salequantity = salequantity;
	}

	public int getSOrderCount() {
		return SOrderCount;
	}

	public void setSOrderCount(int sOrderCount) {
		SOrderCount = sOrderCount;
	}

	public int getTotalOrderCount() {
		return totalOrderCount;
	}

	public void setTotalOrderCount(int totalOrderCount) {
		this.totalOrderCount = totalOrderCount;
	}

	public double getSendpoint() {
		return sendpoint;
	}

	public void setSendpoint(double sendpoint) {
		this.sendpoint = sendpoint;
	}

	public String getPriceladder() {
		return priceladder;
	}

	public void setPriceladder(String priceladder) {
		this.priceladder = priceladder;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getHtmlpath() {
		return htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public boolean isGoodsgroup() {
		return goodsgroup;
	}

	public void setGoodsgroup(boolean goodsgroup) {
		this.goodsgroup = goodsgroup;
	}

	public GoodsGroupT getGroupList() {
		return groupList;
	}

	public void setGroupList(GoodsGroupT groupList) {
		this.groupList = groupList;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
	
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	/**
	 * 团购商品集合
	 * @return
	 */
	@Action(value="GettoGoodsGroupList",results={
			@Result(name="success",type="freemarker",location="/WEB-INF/theme/default/shop/goodsgrouplist.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html")
	})
	public String GettoGoodsGroupList(){
		List<GoodsGroupT> list = this.getGoodsGroupTService().findGoodsGroupByState("1");
		//路径获取
		ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
		ActionContext.getContext().put("goodsgrouplist", list);
		//获取导航数据
		ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation(StaticKey.SiteNavigationState.SHOW.getVisible()));
		//获取商城基本数据
		ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo(StaticKey.DataShowState.SHOW.getState(),StaticKey.JshopOpenState.OPEN.getOpenstate()));
		//获取页脚分类数据
		ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT(StaticKey.DataGrade.FIRST.getState(),StaticKey.DataUsingState.USING.getState()));
		//获取页脚文章数据
		ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, this.getDataCollectionTAction().findFooterArticle(StaticKey.DataShowState.SHOW.getState()));

		return SUCCESS;
	}

}
