package com.jshop.action.backstage.goods;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GoodsAttributeT;
import com.jshop.service.GoodsAttributeTService;
import com.jshop.service.impl.Serial;
@Namespace("")
@ParentPackage("jshop")
public class GoodsAttributeTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
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


	@JSON(serialize = false)
	public GoodsAttributeTService getGoodsAttributeTService() {
		return goodsAttributeTService;
	}


	public void setGoodsAttributeTService(GoodsAttributeTService goodsAttributeTService) {
		this.goodsAttributeTService = goodsAttributeTService;
	}
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
			gat.setCreatetime(BaseTools.systemtime());
			gat.setState(StaticKey.ONE);
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
				this.getGoodsAttributeTService().save(gat);
			}else{
				this.getGoodsAttributeTService().updateGoodsAttributeT(gat);
			}
		}
		this.setSucflag(true);
		return "json";
	}

	/**
	 * 获取所有商品参数
	 */
	@Action(value = "findAllGoodsAttributeT", results = { @Result(name = "json", type = "json") })
	public String findAllGoodsAttributeT() {
		if (StaticKey.SC.equals(this.getQtype())) {
			this.findDefaultAllGoodsAttributeT();
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {
				if(this.getQtype().equals("goodsTypeName")){
					findGoodsAttributeByParams();
				}
				return "json";
			}
		}
		return "json";

	}

	private void findGoodsAttributeByParams() {
		int currentPage=page;
		int lineSize=rp;
		String qs="select count(*) from GoodsAttributeT where "+this.getQtype()+" like '%"+this.getQuery().trim()+"%' ";
		total=this.getGoodsAttributeTService().countsortAllGoodsAttributeT(qs);
		if(StringUtils.isNotBlank(getSortname()) &&StringUtils.isNotBlank(getSortorder())){
			String queryString="from GoodsAttributeT as gat where gat."+this.getQtype()+" like '%"+this.getQuery().trim()+"%' order by " + getSortname() + " " + getSortorder() + "";
			List<GoodsAttributeT>list=this.getGoodsAttributeTService().sortAllGoodsAttributeT(currentPage, lineSize, queryString);
			this.ProcessGoodsAttributeTList(list);
		}
		
	}


	public void findDefaultAllGoodsAttributeT() {
		int currentPage = page;
		int lineSize = rp;
		total = this.getGoodsAttributeTService().countfindAllGoodsAttributeT();
		List<GoodsAttributeT> list = this.getGoodsAttributeTService().findAllGoodsAttributeT(currentPage, lineSize);
		if (list != null) {
			this.ProcessGoodsAttributeTList(list);
		}
	}

	public void ProcessGoodsAttributeTList(List<GoodsAttributeT> list) {
		rows.clear();
		for (Iterator<GoodsAttributeT> it = list.iterator(); it.hasNext();) {
			GoodsAttributeT gat = (GoodsAttributeT) it.next();
			if(StaticKey.ZERO.equals(gat.getAttributeType())){
				gat.setAttributeType(StaticKey.SELECTITEM);
			}else{
				gat.setAttributeType(StaticKey.INPUTITEM);
			}
			if(StaticKey.ONE.equals(gat.getIssearch())){
				gat.setIssearch(StaticKey.SUPPORT);
			}else{
				gat.setIssearch(StaticKey.UNSUPPORT);
			}
			if(StaticKey.ONE.equals(gat.getIssametolink())){
				gat.setIssametolink(StaticKey.SUPPORT);
			}else{
				gat.setIssametolink(StaticKey.UNSUPPORT);
			}
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

		if (Validate.StrNotNull(this.getGoodsattributeid())) {
			String[] list = StringUtils.split(this.getGoodsattributeid(), ",");
			this.getGoodsAttributeTService().delGoodsAttributeT(list);
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 根据商品类型来获取对应的商品参数
	 * 
	 * @return
	 */
	@Action(value = "findGoodsAttributeTByGoodsTypeName", results = { @Result(name = "json", type = "json") })
	public String findGoodsAttributeTByGoodsTypeName() {

		if (Validate.StrNotNull(this.getGoodsTypeName())) {
			List<GoodsAttributeT> list = this.getGoodsAttributeTService().findGoodsAttributeTByGoodsTypeName(this.getGoodsTypeName().trim());
			if (!list.isEmpty()) {
				beanlist = list;
				this.setSucflag(true);
				return "json";
			}
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 根据商品类型id获取商品属性参数
	 * 
	 * @return
	 */
	@Action(value = "findGoodsAttributeTBygoodsTypeId", results = { @Result(name = "json", type = "json") })
	public String findGoodsAttributeTBygoodsTypeId() {

		if (Validate.StrNotNull(this.getGoodsTypeId())) {
			List<GoodsAttributeT> list = this.getGoodsAttributeTService().findGoodsAttributeTBygoodsTypeId(this.getGoodsTypeId());
			if (!list.isEmpty()) {
				gatbeanlist = list;
				this.setSucflag(true);
				return "json";
			} else {
				this.setSucflag(true);
				return "json";
			}
		}
		this.setSucflag(true);
		return "json";

	}
	
	
	/**
	 * 更新是否支持检索
	 * @return
	 */
	@Action(value = "updateGoodsAttributeissearchBygoodsattributeid", results = { @Result(name = "json", type = "json") })
	public String updateGoodsAttributeissearchBygoodsattributeid(){
		if(Validate.StrNotNull(this.getGoodsattributeid())){
			String []strs=StringUtils.split(this.getGoodsattributeid(), ",");
			if(this.getGoodsAttributeTService().updateGoodsAttributeissearchBygoodsattributeid(strs, this.getIssearch())>0){
				this.setSucflag(true);
				return "json";
			}
			this.setSucflag(false);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	
	/**
	 * 更新是否支持关联检索
	 * @return
	 */
	@Action(value = "updateGoodsAttributeissametolinkBygoodsattributeid", results = { @Result(name = "json", type = "json") })
	public String updateGoodsAttributeissametolinkBygoodsattributeid(){
		if(Validate.StrNotNull(this.getGoodsattributeid())){
			String []strs=StringUtils.split(this.getGoodsattributeid(),",");
			if(this.getGoodsAttributeTService().updateGoodsAttributeissametolinkBygoodsattributeid(strs, this.getIssametolink())>0){
				this.setSucflag(true);
				return "json";
			}
			this.setSucflag(false);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	
	
	

}
