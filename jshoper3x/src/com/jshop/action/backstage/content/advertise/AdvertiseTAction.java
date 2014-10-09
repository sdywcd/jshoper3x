package com.jshop.action.backstage.content.advertise;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.entity.AdvertiseT;
import com.jshop.service.AdvertiseTService;

/**
 * 广告管理action
 * @author chenda
 *
 */
@Namespace("")
@ParentPackage("jshop")
public class AdvertiseTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private AdvertiseTService advertiseTService;
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
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;
	
	@JSON(serialize = false)
	public AdvertiseTService getAdvertiseTService() {
		return advertiseTService;
	}


	public void setAdvertiseTService(AdvertiseTService advertiseTService) {
		this.advertiseTService = advertiseTService;
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


	public List<Map<String,Object>> getRows() {
		return rows;
	}


	public void setRows(List<Map<String,Object>> rows) {
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

	public boolean isSucflag() {
		return sucflag;
	}


	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
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
		advertiseT.setCreatorid(BaseTools.getAdminCreateId());
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
	
	/**
	 * 更新广告信息
	 * @return
	 */
	@Action(value = "updateAdvertiseT", results = { @Result(name = "json", type = "json") })
	public String updateAdvertiseT(){
		bean=this.getAdvertiseTService().findByPK(AdvertiseT.class, this.getId());
		bean.setType(this.getType());
		bean.setAdvPath(this.getAdvPath());
		bean.setShowTag(this.getShowTag());
		bean.setShowWhere(this.getShowWhere());
		bean.setAlt(this.getAlt());
		bean.setBegintime(this.getBegintime());
		bean.setEndtime(this.getEndtime());
		bean.setState(this.getState());
		bean.setSort(this.getSort());
		bean.setHeight(this.getHeight());
		bean.setWidth(this.getWidth());
		bean.setVersiont(bean.getVersiont()+1);
		bean.setCode(this.getCode());
		this.getAdvertiseTService().update(bean);
		this.setSucflag(true);
		return "json";
	}
	
	/**
	 * 批量删除广告信息
	 * @return
	 */
	public String delAdvertiseT(){
		String[]ids=StringUtils.split(this.getId(),",");
		for(String id:ids){
			bean=this.getAdvertiseTService().findByPK(AdvertiseT.class, id);
			this.getAdvertiseTService().delete(bean);
		}
		this.setSucflag(true);
		return "json";
	}
	
	
	
	
	
}
