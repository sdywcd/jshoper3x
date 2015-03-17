package com.jshop.action.backstage.goods;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GoodsGroupT;
import com.jshop.service.GoodsGroupTService;
import com.jshop.service.impl.Serial;
@Namespace("")
@ParentPackage("jshop")
public class GoodsGroupTAction extends BaseTAction {

	private static final long serialVersionUID = 1L;
	@Resource
	private GoodsGroupTService goodsGroupTService;
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
	private double memberprice;
	private double groupprice;
	private String htmlpath;
	private int total=0;
	private int page=1;
	private int rp;
	private boolean sucflag;
	private GoodsGroupT groupList= new GoodsGroupT();
	private List<Map<String,Object>> rows= new ArrayList<Map<String,Object>>();
	
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
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Map<String,Object>> getRows() {
		return rows;
	}
	public void setRows(List<Map<String,Object>> rows) {
		this.rows = rows;
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

	public GoodsGroupT getGroupList() {
		return groupList;
	}
	public void setGroupList(GoodsGroupT groupList) {
		this.groupList = groupList;
	}
	public String getPictureurl() {
		return pictureurl;
	}
	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}
	public String getHtmlpath() {
		return htmlpath;
	}
	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}
	public double getMemberprice() {
		return memberprice;
	}
	public void setMemberprice(double memberprice) {
		this.memberprice = memberprice;
	}
	public double getGroupprice() {
		return groupprice;
	}
	public void setGroupprice(double groupprice) {
		this.groupprice = groupprice;
	}
	
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	/**
	 * 添加团购商品
	 * @return
	 */
	@Action(value="addGoodsGroupT",results={@Result(name="json",type="json")})
	public String addGoodsGroupT(){
		GoodsGroupT ggt = new GoodsGroupT();		
		ggt.setGroupid(this.getSerial().Serialid(Serial.GOODSGROUPT));
		ggt.setGoodsid(this.getGoodsid().trim());
		ggt.setCreatetime(BaseTools.getSystemTime());
		ggt.setGoodsname(this.getGoodsname().trim());
		ggt.setCreatorid(BaseTools.getAdminCreateId());
		ggt.setState(this.getState().trim());
		ggt.setCashstate(this.getCashstate().trim());
		ggt.setCashlimit(this.getCashlimit());
		ggt.setLimitbuy(this.getLimitbuy());
		ggt.setSalequantity(this.getSalequantity());
	//	ggt.setSOrderCount(this.getSOrderCount());
		//ggt.setTotalOrderCount(this.getTotalOrderCount());
		ggt.setBegintime(this.getBegintime());
		ggt.setEndtime(this.getEndtime());
		ggt.setSendpoint(this.getSendpoint());
		ggt.setPriceladder("0");
		ggt.setGroupprice(this.getGroupprice());
		ggt.setMemberprice(this.getMemberprice());
		ggt.setDetail(this.getDetail().trim());		
		ggt.setPictureurl(this.getPictureurl());
		ggt.setHtmlpath(StaticKey.EMPTY);
		this.goodsGroupTService.save(ggt);
		this.setSucflag(true);
		return JSON;			
	}

	/**
	 * 处理迭代商品信息
	 * @param ggtList
	 */
	public void processGoodsGroupTList(List<GoodsGroupT> ggtList){
		rows.clear();
		for(Iterator<GoodsGroupT> it = ggtList.iterator();it.hasNext();){
			GoodsGroupT ggt =it.next();
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", ggt.getGroupid());
			cellMap.put("cell", new Object[]{
					ggt.getGoodsid(),
					ggt.getGoodsname(),
					ggt.getGroupprice(),
					ggt.getSendpoint(),
					ggt.getCashlimit(),
					ggt.getBegintime(),
					ggt.getEndtime(),					
					ggt.getCashstate(),
					ggt.getState(),
					ggt.getLimitbuy(),
					ggt.getSalequantity(),
					ggt.getSOrderCount(),
					ggt.getTotalOrderCount(),					
					ggt.getCreatorid()
			});
			rows.add(cellMap);
		}
		
	}
	/**
	 * 获取默认所有的团购商品信息
	 */	
	public  void defaultfindAllGoodsGroupT(){
		int currentPage= page;
		int lineSize = rp;
		total = this.goodsGroupTService.count(GoodsGroupT.class).intValue();
		if(StringUtils.isNotBlank(this.getSortname())&&StringUtils.isNotBlank(this.getSortorder())){
			Order order=null;
			if(StringUtils.equals(this.getSortorder(), StaticKey.ASC)){
				order=Order.asc(this.getSortname());
			}else{
				order=Order.desc(this.getSortname());
			}
			List<GoodsGroupT> list = this.goodsGroupTService.findByCriteriaByPage(GoodsGroupT.class, order, currentPage, lineSize);
			processGoodsGroupTList(list);
		}
	}
	/**
	 * 获取所有团购商品的信息
	 * @return
	 */
	@Action(value="findAllGoodsGroupT",results={@Result(name="json",type="json")})
	public String findAllGoodsGroupT(){
		if(this.getQtype().equals(StaticKey.SC)){
			defaultfindAllGoodsGroupT();
		}else{
			if(StringUtils.isBlank(this.getQtype())){
				return JSON;
			}else{
				return JSON;
			}
		}
		return JSON;
	}
	/**
	 * 根据groupid 获取团购商品信息
	 * @return
	 */
	@Action(value="findGoodsGroupById",results={@Result(name="json",type="json")})
	public String findGoodsGroupById(){
		if(StringUtils.isNotBlank(this.getGroupid())){
			groupList= this.goodsGroupTService.findByPK(GoodsGroupT.class, this.getGroupid());
			if(groupList!=null){
				this.setSucflag(true);
				return JSON;
			}
		}
		return JSON;
	}
	/**
	 * 修改团购商品的信息
	 * @return
	 */
	@Action(value="updateGoodsGroup",results={@Result(name="json",type="json")})
	public String updateGoodsGroup(){
		if(StringUtils.isNotBlank(this.getGroupid())){
			GoodsGroupT ggt=this.goodsGroupTService.findByPK(GoodsGroupT.class, this.getGroupid());
			if(ggt!=null){
				ggt.setBegintime(this.getBegintime());
				ggt.setEndtime(this.getEndtime());
				ggt.setDetail(this.getDetail().trim());
				ggt.setCashlimit(this.getCashlimit());
				ggt.setCashstate(this.getCashstate().trim());
				ggt.setLimitbuy(this.getLimitbuy());
//				ggt.setGoodsid(this.getGoodsid().trim());
				ggt.setCreatetime(BaseTools.getSystemTime());
				ggt.setGoodsname(this.getGoodsname().trim());
				ggt.setState(this.getState().trim());
				ggt.setSalequantity(this.getSalequantity());
//				ggt.setSOrderCount(0);
//				ggt.setTotalOrderCount(0);
				ggt.setSendpoint(this.getSendpoint());
				ggt.setGroupprice(this.getGroupprice());
				ggt.setMemberprice(this.getMemberprice());
				ggt.setPictureurl(this.getPictureurl());
				this.goodsGroupTService.update(ggt);
				this.setSucflag(true);
				return JSON;
			}
		}
		return JSON;
	}
	/**
	 * 根据groupid批量删除团购商品
	 * @return
	 */
	@Action(value="delGoodsGroup",results={@Result(name="json",type="json")})
	public String delGoodsGroup(){
		if(StringUtils.isNotBlank(this.getGroupid())){
			String []strs = StringUtils.split(this.getGroupid(), StaticKey.SPLITDOT);
			for(String s:strs){
				GoodsGroupT ggt=this.goodsGroupTService.findByPK(GoodsGroupT.class, s);
				if(ggt!=null){
					this.goodsGroupTService.delete(ggt);
				}
			}
			this.setSucflag(true);
		}
		return JSON;
	}
	/**
	 * 修改团购状态
	 * @return
	 */
	@Action(value="updateState",results={@Result(name="json",type="json")})
	public String updateState(){
		if(StringUtils.isNotBlank(this.getGroupid())){
			GoodsGroupT ggt=this.goodsGroupTService.findByPK(GoodsGroupT.class, this.getGroupid());
			if(ggt!=null){
				ggt.setState("2");
				this.goodsGroupTService.update(ggt);
				this.setSucflag(true);
			}
		}
		return JSON;
		
	}
	/**
	 * 根据团购商品状态是“1”的 获取商品信息
	 * @return
	 */
	@Action(value="findGoodsGroupByState",results={@Result(name="json", type="json")})
	public String findGoodsGroupByState(){
		Criterion criterion=Restrictions.eq("state", "1");
		List<GoodsGroupT> list =this.goodsGroupTService.findByCriteria(GoodsGroupT.class, criterion);
		if(!list.isEmpty()){
			this.setSucflag(true);
			return JSON;
		}
		return JSON;
		
	}
}
