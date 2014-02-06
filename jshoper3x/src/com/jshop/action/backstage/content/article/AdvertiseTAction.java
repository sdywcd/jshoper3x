package com.jshop.action.backstage.content.article;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.entity.AdvertiseT;
import com.jshop.entity.SerialT;
import com.jshop.service.AdvertiseTService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 广告管理action
 * @author chenda
 *
 */
@Namespace("")
@ParentPackage("jshop")
public class AdvertiseTAction extends ActionSupport {
	private AdvertiseTService advertiseTService;
	private Serial serial;
	private String id;
	private String type;
	private String advPath;
	private String showTag;
	private String showWhere;
	private String alt;
	private Date begintime;
	private Date endtime;
	private Date createtime;
	private String creatorid;
	private String state;
	private int sort;
	private int height;
	private int width;
	private int versiont;
	private String code;
	private AdvertiseT bean=new AdvertiseT();
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String query;
	private String qtype;
	private boolean sucflag;
	private String sortname;
	private String sortorder;
	
	@JSON(serialize = false)
	public AdvertiseTService getAdvertiseTService() {
		return advertiseTService;
	}


	public void setAdvertiseTService(AdvertiseTService advertiseTService) {
		this.advertiseTService = advertiseTService;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}


	public void setSerial(Serial serial) {
		this.serial = serial;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getAdvPath() {
		return advPath;
	}


	public void setAdvPath(String advPath) {
		this.advPath = advPath;
	}


	public String getShowTag() {
		return showTag;
	}


	public void setShowTag(String showTag) {
		this.showTag = showTag;
	}


	public String getShowWhere() {
		return showWhere;
	}


	public void setShowWhere(String showWhere) {
		this.showWhere = showWhere;
	}


	public String getAlt() {
		return alt;
	}


	public void setAlt(String alt) {
		this.alt = alt;
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


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getSort() {
		return sort;
	}


	public void setSort(int sort) {
		this.sort = sort;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getVersiont() {
		return versiont;
	}


	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public AdvertiseT getBean() {
		return bean;
	}


	public void setBean(AdvertiseT bean) {
		this.bean = bean;
	}


	public List getRows() {
		return rows;
	}


	public void setRows(List rows) {
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


	public String getQuery() {
		return query;
	}


	public void setQuery(String query) {
		this.query = query;
	}


	public String getQtype() {
		return qtype;
	}


	public void setQtype(String qtype) {
		this.qtype = qtype;
	}


	public boolean isSucflag() {
		return sucflag;
	}


	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
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


	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	/**
	 * 增加广告信息
	 * @return
	 */
	@Action(value = "addAdvertiseT", results = { @Result(name = "json", type = "json") })
	public String addAdvertiseT(){
		AdvertiseT advertiseT=new AdvertiseT();
		advertiseT.setType(this.getType());
		advertiseT.setAdvPath(this.getAdvPath());
		advertiseT.setShowTag(this.getShowTag());
		advertiseT.setShowWhere(this.getShowWhere());
		advertiseT.setAlt(this.getAlt());
		advertiseT.setBegintime(this.getBegintime());
		advertiseT.setEndtime(this.getEndtime());
		advertiseT.setCreatetime(BaseTools.systemtime());
		advertiseT.setCreatorid(BaseTools.adminCreateId());
		advertiseT.setState(this.getState());
		advertiseT.setSort(this.getSort());
		advertiseT.setHeight(this.getHeight());
		advertiseT.setWidth(this.getWidth());
		advertiseT.setVersiont(0);
		advertiseT.setCode(this.getCode());
		this.getAdvertiseTService().save(advertiseT);
		this.setSucflag(true);
		return "json";
	}
	
	/**
	 * 根据主键获取广告信息
	 * @return
	 */
	@Action(value = "findAdvertiseTById", results = { @Result(name = "json", type = "json") })
	public String findAdvertiseTById(){
		bean=this.getAdvertiseTService().findByPK(AdvertiseT.class, this.getId());
		if(bean!=null){
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}
	
	public String updateAdvertiseT(){
		bean=this.getAdvertiseTService().findByPK(AdvertiseT.class, this.getId());
		return "json";
	}
	
	
	
	
	
}
