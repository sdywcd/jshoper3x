package com.jshop.action.backstage.goods;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.tools.Serial;
import com.jshop.entity.GoodsBelinkedT;
import com.jshop.service.GoodsBelinkedTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class GoodsBeLinkedTAction extends ActionSupport {
	private Serial serial;
	private GoodsBelinkedTService goodsBelinkedTService;
	private String belinkedid;
	private String maingoodsid;
	private String belinkedgoodsid;
	private String mode;
	private String state;
	private String creatorid;
	private Date createtime;
	private Date updatetime;
	private int versiont;
	private String sxlinkedgoodsid;
	private String goodsname;
	private GoodsBelinkedT bean=new GoodsBelinkedT();
	
	private boolean sucflag;
	
	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	@JSON(serialize = false)
	public GoodsBelinkedTService getGoodsBelinkedTService() {
		return goodsBelinkedTService;
	}
	public void setGoodsBelinkedTService(GoodsBelinkedTService goodsBelinkedTService) {
		this.goodsBelinkedTService = goodsBelinkedTService;
	}
	public String getBelinkedid() {
		return belinkedid;
	}
	public void setBelinkedid(String belinkedid) {
		this.belinkedid = belinkedid;
	}
	public String getMaingoodsid() {
		return maingoodsid;
	}
	public void setMaingoodsid(String maingoodsid) {
		this.maingoodsid = maingoodsid;
	}
	public String getBelinkedgoodsid() {
		return belinkedgoodsid;
	}
	public void setBelinkedgoodsid(String belinkedgoodsid) {
		this.belinkedgoodsid = belinkedgoodsid;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public int getVersiont() {
		return versiont;
	}
	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}
	public String getSxlinkedgoodsid() {
		return sxlinkedgoodsid;
	}
	public void setSxlinkedgoodsid(String sxlinkedgoodsid) {
		this.sxlinkedgoodsid = sxlinkedgoodsid;
	}
	
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	
	public GoodsBelinkedT getBean() {
		return bean;
	}
	public void setBean(GoodsBelinkedT bean) {
		this.bean = bean;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	/**
	 * 根据goodsid获取关联商品
	 * @return
	 */
	@Action(value = "findGoodsBelinkedBymaingoodsid", results = { @Result(name = "json", type = "json") })
	public String findGoodsBelinkedBymaingoodsid(){
		List<GoodsBelinkedT>list=this.getGoodsBelinkedTService().findGoodsBelinkedBymaingoodsid(this.getMaingoodsid());
		if(!list.isEmpty()){
			this.setBean(list.get(0));
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	
	
	
	
	
}
