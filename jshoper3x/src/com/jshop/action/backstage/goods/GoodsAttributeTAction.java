package com.jshop.action.backstage.goods;

import java.sql.Date;
import java.util.ArrayList;
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
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Criterion;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.enums.BaseEnums.DataUsingState;
import com.jshop.action.backstage.utils.enums.BaseEnums.SupportType;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GoodsAttributeT;
import com.jshop.service.GoodsAttributeTService;
import com.jshop.service.impl.Serial;
@Namespace("")
@ParentPackage("jshop")
public class GoodsAttributeTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	@Resource
	private GoodsAttributeTService goodsAttributeTService;
	private String goodsattributeid;
	private String goodsattributename;
	private String goodsTypeId;
	private String goodsTypeName;
	private Date createtime;
	private String state;
	private String creatorid;
	private String attributeType;
	private String attributelist;
	private String sort;
	private String attributeIndex;
	private String issearch;
	private String issametolink;
	private String rjson;
	private GoodsAttributeT bean = new GoodsAttributeT();
	private List<GoodsAttributeT> gatbeanlist = new ArrayList<GoodsAttributeT>();
	private List<GoodsAttributeT> beanlist = new ArrayList<GoodsAttributeT>();
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;


	public String getGoodsattributeid() {
		return goodsattributeid;
	}

	public void setGoodsattributeid(String goodsattributeid) {
		this.goodsattributeid = goodsattributeid;
	}

	public String getGoodsattributename() {
		return goodsattributename;
	}

	public void setGoodsattributename(String goodsattributename) {
		this.goodsattributename = goodsattributename;
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

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
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

	public String getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}

	public String getAttributelist() {
		return attributelist;
	}

	public void setAttributelist(String attributelist) {
		this.attributelist = attributelist;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getAttributeIndex() {
		return attributeIndex;
	}

	public void setAttributeIndex(String attributeIndex) {
		this.attributeIndex = attributeIndex;
	}

	public GoodsAttributeT getBean() {
		return bean;
	}

	public void setBean(GoodsAttributeT bean) {
		this.bean = bean;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
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

	public String getRjson() {
		return rjson;
	}

	public void setRjson(String rjson) {
		this.rjson = rjson;
	}

	public List<GoodsAttributeT> getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(List<GoodsAttributeT> beanlist) {
		this.beanlist = beanlist;
	}

	public List<GoodsAttributeT> getGatbeanlist() {
		return gatbeanlist;
	}

	public void setGatbeanlist(List<GoodsAttributeT> gatbeanlist) {
		this.gatbeanlist = gatbeanlist;
	}

	public String getIssearch() {
		return issearch;
	}


	public void setIssearch(String issearch) {
		this.issearch = issearch;
	}


	public String getIssametolink() {
		return issametolink;
	}


	public void setIssametolink(String issametolink) {
		this.issametolink = issametolink;
	}


	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 更新商品参数
	 * 
	 * @return
	 */
	@Action(value = "updateGoodsAttributeT", results = { @Result(name = "json", type = "json") })
	public String updateGoodsAttributeT() {
		JSONArray ja=(JSONArray)JSONValue.parse(this.getRjson());
		int jsonsize=ja.size();
		GoodsAttributeT gat = new GoodsAttributeT();
		for (int i = 0; i <jsonsize; i++) {
			gat.setCreatetime(BaseTools.getSystemTime());
			gat.setState(DataUsingState.USING.getState());
			gat.setCreatorid(BaseTools.getAdminCreateId());
			gat.setGoodsTypeId(this.getGoodsTypeId());
			gat.setGoodsTypeName(this.getGoodsTypeName());
			gat.setAttributeIndex(this.getAttributeIndex());
			JSONObject jo=(JSONObject)ja.get(i);
			gat.setGoodsattributename(jo.get(StaticKey.GOODSATTRIBUTENAME).toString());
			gat.setAttributeType(jo.get(StaticKey.ATTRIBUTETYPE).toString());
			gat.setAttributelist(jo.get(StaticKey.ATTRIBUTELIST).toString());
			gat.setSort(jo.get(StaticKey.SORT).toString());
			gat.setGoodsattributeid(jo.get(StaticKey.GOODSATTRIBUTEID).toString());
			if(gat.getGoodsattributeid().length()==0){
				gat.setGoodsattributeid(this.getSerial().Serialid(Serial.GOODSATTRIBUTE));
				this.goodsAttributeTService.save(gat);
			}else{
				this.goodsAttributeTService.update(gat);
			}
		}
		this.setSucflag(true);
		return JSON;
	}

	/**
	 * 获取所有商品参数
	 */
	@Action(value = "findAllGoodsAttributeT", results = { @Result(name = "json", type = "json") })
	public String findAllGoodsAttributeT() {
		if (StaticKey.SC.equals(this.getQtype())) {
			this.findDefaultAllGoodsAttributeT();
		} else {
			if (StringUtils.isBlank(this.getQtype())) {
				return JSON;
			} else {
				if(StringUtils.equals(this.getQtype(), "goodsTypeName")){
					findGoodsAttributeByParams();
				}
				return JSON;
			}
		}
		return JSON;

	}

	private void findGoodsAttributeByParams() {
		int currentPage=page;
		int lineSize=rp;
		Criterion criterion=Restrictions.like(this.getQtype(), this.getQuery(), MatchMode.ANYWHERE);
		total=this.goodsAttributeTService.count(GoodsAttributeT.class, criterion).intValue();
		if(StringUtils.isNotBlank(getSortname()) &&StringUtils.isNotBlank(getSortorder())){
			Order order=null;
			if(StringUtils.equals(this.getSortorder(), StaticKey.ASC)){
				order=Order.asc(this.getSortname());
			}else{
				order=Order.desc(this.getSortname());
			}
			List<GoodsAttributeT>list=this.goodsAttributeTService.findByCriteriaByPage(GoodsAttributeT.class, criterion, order, currentPage, lineSize);
			this.processGoodsAttributeTList(list);
		}
		
	}


	public void findDefaultAllGoodsAttributeT() {
		int currentPage = page;
		int lineSize = rp;
		total = this.goodsAttributeTService.count(GoodsAttributeT.class).intValue();
		Order order=Order.desc("createtime");
		List<GoodsAttributeT> list = this.goodsAttributeTService.findByCriteriaByPage(GoodsAttributeT.class, order, currentPage, lineSize);
		this.processGoodsAttributeTList(list);
	}

	public void processGoodsAttributeTList(List<GoodsAttributeT> list) {
		rows.clear();
		for (Iterator<GoodsAttributeT> it = list.iterator(); it.hasNext();) {
			GoodsAttributeT gat = (GoodsAttributeT) it.next();
			if(StaticKey.ZERO.equals(gat.getAttributeType())){
				gat.setAttributeType(StaticKey.SELECTITEM);
			}else{
				gat.setAttributeType(StaticKey.INPUTITEM);
			}
			gat.setIssearch(SupportType.getName(gat.getIssearch()));
			gat.setIssametolink(SupportType.getName(gat.getIssametolink()));
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", gat.getGoodsattributeid());
			cellMap.put("cell", new Object[] {gat.getGoodsattributename(), gat.getAttributeType(), gat.getAttributelist(), gat.getSort(), gat.getGoodsTypeName(),gat.getIssearch(),gat.getIssametolink(), BaseTools.formateDbDate(gat.getCreatetime()),"<a id='editgoodsattribute' name='editgoodsattribute' href='goodsattribute.jsp?operate=edit&folder=goods&goodsTypeName=" + gat.getGoodsTypeName() + "'>[编辑]</a>" });
			rows.add(cellMap);
		}
	}

	/**
	 * 删除商品参数
	 * 
	 * @return
	 */
	@Action(value = "delGoodsAttributeT", results = { @Result(name = "json", type = "json") })
	public String delGoodsAttributeT() {
		if (StringUtils.isNotBlank(this.getGoodsattributeid())) {
			String[] strs = StringUtils.split(this.getGoodsattributeid(),StaticKey.SPLITDOT);
			for(String s:strs){
				GoodsAttributeT gat=this.goodsAttributeTService.findByPK(GoodsAttributeT.class, s);
				if(gat!=null){
					this.goodsAttributeTService.delete(gat);
				}
			}
			this.setSucflag(true);
		}
		return JSON;
	}

	/**
	 * 根据商品类型来获取对应的商品参数
	 * 
	 * @return
	 */
	@Action(value = "findGoodsAttributeTByGoodsTypeName", results = { @Result(name = "json", type = "json") })
	public String findGoodsAttributeTByGoodsTypeName() {
		if (StringUtils.isNotBlank(this.getGoodsTypeName())) {
			Criterion criterion=Restrictions.eq("goodsTypeName", this.getGoodsTypeName());
			List<GoodsAttributeT> list = this.goodsAttributeTService.findByCriteria(GoodsAttributeT.class, criterion);
			if (!list.isEmpty()) {
				beanlist = list;
				this.setSucflag(true);
			}
		}
		return JSON;
	}

	/**
	 * 根据商品类型id获取商品属性参数
	 * 
	 * @return
	 */
	@Action(value = "findGoodsAttributeTBygoodsTypeId", results = { @Result(name = "json", type = "json") })
	public String findGoodsAttributeTBygoodsTypeId() {
		if (StringUtils.isNotBlank(this.getGoodsTypeId())) {
			Criterion criterion=Restrictions.eq("goodsTypeId", this.getGoodsTypeId());
			List<GoodsAttributeT> list =this.goodsAttributeTService.findByCriteria(GoodsAttributeT.class, criterion);
			if (!list.isEmpty()) {
				gatbeanlist = list;
				this.setSucflag(true);
			}
		}
		return JSON;
	}
	
	
	/**
	 * 更新是否支持检索
	 * @return
	 */
	@Action(value = "updateGoodsAttributeissearchBygoodsattributeid", results = { @Result(name = "json", type = "json") })
	public String updateGoodsAttributeissearchBygoodsattributeid(){
		if(StringUtils.isNotBlank(this.getGoodsattributeid())){
			String []strs=StringUtils.split(this.getGoodsattributeid(),StaticKey.SPLITDOT);
			for(String s:strs){
				GoodsAttributeT gat=this.goodsAttributeTService.findByPK(GoodsAttributeT.class, s);
				if(gat!=null){
					gat.setIssearch(this.getIssearch());
					this.goodsAttributeTService.update(gat);
				}
			}
			this.setSucflag(true);
		}
		return JSON;
	}
	
	/**
	 * 更新是否支持关联检索
	 * @return
	 */
	@Action(value = "updateGoodsAttributeissametolinkBygoodsattributeid", results = { @Result(name = "json", type = "json") })
	public String updateGoodsAttributeissametolinkBygoodsattributeid(){
		if(StringUtils.isNotBlank(this.getGoodsattributeid())){
			String []strs=StringUtils.split(this.getGoodsattributeid(),StaticKey.SPLITDOT);
			for(String s:strs){
				GoodsAttributeT gat=this.goodsAttributeTService.findByPK(GoodsAttributeT.class, s);
				if(gat!=null){
					gat.setIssametolink(this.getIssametolink());
					this.goodsAttributeTService.update(gat);
				}
			}
			this.setSucflag(true);
		}
		return JSON;
	}
	
	
	

}
