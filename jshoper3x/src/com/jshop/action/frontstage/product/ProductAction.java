package com.jshop.action.frontstage.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.utils.Validate;
import com.jshop.entity.ProductT;
import com.jshop.service.ProductTService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs( { @InterceptorRef("defaultStack") })
public class ProductAction extends ActionSupport {
	private Serial serial;
	private ProductTService productTService;
	private String productid;
	private Double price;
	private Double memberprice;
	private Double cost;
	private Double saleprice;
	private Integer freezeStore;
	private Integer store;
	private String isDefault;
	private String isSalestate;
	private String productName;
	private String productSn;
	private String specificationsValue;
	private String warehouseLocation;
	private String placeStore;
	private String weight;
	private String goodsid;
	private String creatorid;
	private boolean slogin;
	private boolean sucflag;
	private String sortname;
	private String sortorder;
	private String guigevalue;
	private List<ProductT> beanlist = new ArrayList<ProductT>();
	private ProductT bean = new ProductT();
	private List<String> guigearray;//用来存储规格值的集合
	@JSON(serialize = false)
	public ProductTService getProductTService() {
		return productTService;
	}

	public void setProductTService(ProductTService productTService) {
		this.productTService = productTService;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getMemberprice() {
		return memberprice;
	}

	public void setMemberprice(Double memberprice) {
		this.memberprice = memberprice;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(Double saleprice) {
		this.saleprice = saleprice;
	}

	public Integer getFreezeStore() {
		return freezeStore;
	}

	public void setFreezeStore(Integer freezeStore) {
		this.freezeStore = freezeStore;
	}

	public Integer getStore() {
		return store;
	}

	public void setStore(Integer store) {
		this.store = store;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getIsSalestate() {
		return isSalestate;
	}

	public void setIsSalestate(String isSalestate) {
		this.isSalestate = isSalestate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSn() {
		return productSn;
	}

	public void setProductSn(String productSn) {
		this.productSn = productSn;
	}

	public String getSpecificationsValue() {
		return specificationsValue;
	}

	public void setSpecificationsValue(String specificationsValue) {
		this.specificationsValue = specificationsValue;
	}

	public String getWarehouseLocation() {
		return warehouseLocation;
	}

	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}

	public String getPlaceStore() {
		return placeStore;
	}

	public void setPlaceStore(String placeStore) {
		this.placeStore = placeStore;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public List<ProductT> getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(List<ProductT> beanlist) {
		this.beanlist = beanlist;
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

	public String getGuigevalue() {
		return guigevalue;
	}

	public void setGuigevalue(String guigevalue) {
		this.guigevalue = guigevalue;
	}

	public ProductT getBean() {
		return bean;
	}

	public void setBean(ProductT bean) {
		this.bean = bean;
	}

	public List<String> getGuigearray() {
		return guigearray;
	}

	public void setGuigearray(List<String> guigearray) {
		this.guigearray = guigearray;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}


	/**
	 * 前台根据规格值获取货品记录必定返回单条记录
	 * @return
	 */
	@Action(value = "findProductTByGoodsid", results = { @Result(name = "json", type = "json") })
	public String findProductTByGoodsid(){
		if(Validate.StrNotNull(this.getGoodsid())){
			List<ProductT>ptlist=this.getProductTService().findProductTByGoodsid(this.getGoodsid().trim());
			if(!ptlist.isEmpty()){
				if(Validate.StrNotNull(this.getGuigevalue())){
					//this.getGuigearray().add(guigevalue);
					for(Iterator it=ptlist.iterator();it.hasNext();){
						ProductT pt=(ProductT)it.next();
						String jsonstrs[]=pt.getSpecificationsValue().split("=");
						for(String s:jsonstrs){
							pjsonstr(ptlist,s);
						}
					}
				}
				
			}
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	
	
	public void pjsonstr(List<ProductT>list,String s){
		JSONArray ja=(JSONArray) JSONValue.parse("["+s+"]");
		for(int i=0;i<ja.size();i++){
			JSONObject jo=(JSONObject)ja.get(i);
			if(jo.get("goodsattributename").equals(this.getGuigevalue())){
				bean=list.get(i);
			}
		}
	}
	
}
