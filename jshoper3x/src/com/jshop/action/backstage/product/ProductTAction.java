package com.jshop.action.backstage.product;

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

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GoodsSpecificationsProductRpT;
import com.jshop.entity.ProductT;
import com.jshop.service.GoodsSpecificationsProductRpTService;
import com.jshop.service.ProductTService;
import com.jshop.service.impl.Serial;
@Namespace("")
@ParentPackage("jshop")
public class ProductTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private ProductTService productTService;
	private GoodsSpecificationsProductRpTService goodsSpecificationsProductRpTService;
	private String productid;
	private Double price;
	private Double memberprice;
	private Double cost;
	private Double saleprice;
	private String freezeStore;
	private String store;
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
	private String specificationsid;
	private String specificationsName;
	private String unit;
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private List<ProductT> beanlist = new ArrayList<ProductT>();
	private ProductT bean = new ProductT();

	private boolean sucflag;
	
	@JSON(serialize = false)
	public ProductTService getProductTService() {
		return productTService;
	}

	public void setProductTService(ProductTService productTService) {
		this.productTService = productTService;
	}

	@JSON(serialize = false)
	public GoodsSpecificationsProductRpTService getGoodsSpecificationsProductRpTService() {
		return goodsSpecificationsProductRpTService;
	}

	public void setGoodsSpecificationsProductRpTService(
			GoodsSpecificationsProductRpTService goodsSpecificationsProductRpTService) {
		this.goodsSpecificationsProductRpTService = goodsSpecificationsProductRpTService;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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



	public String getFreezeStore() {
		return freezeStore;
	}

	public void setFreezeStore(String freezeStore) {
		this.freezeStore = freezeStore;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
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

	public ProductT getBean() {
		return bean;
	}

	public void setBean(ProductT bean) {
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

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	
	
	
	/**
	 * 保存商品的货物信息
	 * @return
	 */
	@Action(value = "saveProductT", results = { @Result(name = "json", type = "json") })
	public String saveProductT(){
		if(StringUtils.isBlank(this.getProductName())){
			return "json";
		} 
		ProductT pt=new ProductT();
		pt.setProductid(this.getSerial().Serialid(Serial.PRODUCT));
		pt.setPrice(this.getPrice());
		pt.setMemberprice(this.getMemberprice());
		pt.setCost(this.getCost());
		pt.setSaleprice(this.getSaleprice());
		pt.setFreezeStore(Integer.parseInt(this.getFreezeStore()));
		pt.setStore(Integer.parseInt(this.getStore()));
		pt.setIsDefault(this.getIsDefault());
		pt.setIsSalestate(this.getIsSalestate());
		pt.setProductName(this.getProductName());
		pt.setProductSn(this.getProductSn());
		pt.setSpecificationsValue(this.getSpecificationsValue());
		pt.setWarehouseLocation(this.getWarehouseLocation());
		pt.setPlaceStore(this.getPlaceStore());
		pt.setWeight(this.getWeight());
		pt.setGoodsid(this.getGoodsid());
		pt.setCreatorid(BaseTools.getAdminCreateId());
		pt.setCreatetime(BaseTools.systemtime());
		pt.setSpecificationsid(this.getSpecificationsid());
		pt.setSpecificationsName(this.getSpecificationsName());
		pt.setUpdatetime(BaseTools.systemtime());
		pt.setUnit(this.getUnit());
		//保存商品和规格和货物关系，要进行事务控制
		GoodsSpecificationsProductRpT gsrt=new GoodsSpecificationsProductRpT();
		gsrt.setGoodsSpecificationsProductRpTid(this.getSerial().Serialid(Serial.GOODSSPECIFICATIONSPRODUCTRPT));
		gsrt.setGoodsid(pt.getGoodsid());
		gsrt.setProductid(pt.getProductid());
		gsrt.setSpecidicationsid(pt.getSpecificationsid());
		this.getProductTService().saveProductProcess(pt, gsrt);
		this.setSucflag(true);
		return "json";
	}
	
	
	/**
	 * 根据商品id获取货品信息
	 * 
	 * @return
	 */
	@Action(value = "findAllProductTByGoodsid", results = { @Result(name = "json", type = "json") })
	public String findAllProductTByGoodsid() {
		if (Validate.StrNotNull(this.getGoodsid())) {
			this.setBeanlist(this.getProductTService().findAllProductTByGoodsid(BaseTools.getAdminCreateId(), this.getGoodsid()));
			if (this.getBeanlist() != null) {
				this.setSucflag(true);
				return "json";
			}
		}
		this.setSucflag(false);
		return "json";

	}
	
	/**
	 * 根据产品id删除产品
	 * @return
	 */
	@Action(value = "delProductTByproductid", results = { @Result(name = "json", type = "json") })
	public String delProductTByproductid(){
		if(StringUtils.isNotBlank(this.getProductid())){
			int i=this.getProductTService().delProductTByproductid(this.getProductid());
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
		
	}
	

	
	/**
	 * 查询所有的货物
	 * @return
	 */
	@Action(value = "findAllProducts", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
	public String findAllProducts(){
		if(StaticKey.SC.equals(this.getQtype())){
			finddefaultAllProducts();
		}else{
			if(StringUtils.isBlank(this.getQtype())){
				return "json";
			}else if(this.getQtype().equals("goodsid")){
				findProductByGoodsid(this.getGoodsid());
			}
		}
		return "json";
	}

	private void findProductByGoodsid(String goodsid){
		int currentPage=page;
		int lineSize=rp;
		if(StringUtils.isNotBlank(this.getSortname())&&StringUtils.isNotBlank(this.getSortorder())){
			String queryString = "from ProductT as pt where pt.goodsid="+goodsid+" order by " + this.getSortname() + " " + this.getSortorder() + "";
			List<ProductT>list=this.getProductTService().sortAllProductT(currentPage, lineSize,queryString);
			if(!list.isEmpty()){
				ProcessProductsList(list);
			}
		}

	}
	
	private void finddefaultAllProducts() {
		int currentPage=page;
		int lineSize=rp;
		List<ProductT>list=this.getProductTService().findAllProductT(currentPage, lineSize);
		if(!list.isEmpty()){
			ProcessProductsList(list);
		}
	}

	private void ProcessProductsList(List<ProductT> list) {
		total=this.getProductTService().countfineAllProductT();
		rows.clear();
		for(Iterator<ProductT> it=list.iterator();it.hasNext();){
			ProductT pt=(ProductT) it.next();
			if(pt.getIsDefault().equals(StaticKey.ZERO)){
				pt.setIsDefault(StaticKey.NO);
			}else{
				pt.setIsDefault(StaticKey.YES);
			}
			if(pt.getIsSalestate().equals(StaticKey.ZERO)){
				pt.setIsSalestate(StaticKey.OFFSALE);
			}else{
				pt.setIsSalestate(StaticKey.ONSALE);
			}
			Map<String,Object> cellMap=new HashMap<String,Object>();
			cellMap.put("id", pt.getProductid());
			cellMap.put("cell", new Object[]{
					pt.getProductSn(),
					pt.getProductName(),
					pt.getPrice(),
					pt.getMemberprice(),
					pt.getCost(),
					pt.getSaleprice(),
					pt.getFreezeStore(),
					pt.getStore(),
					pt.getWeight(),
					BaseTools.formateDbDate(pt.getCreatetime()),
					"<a id='editproduct' href='product.jsp?operate=edit&productid="+pt.getProductid()+"&folder=goods' name='editproduct'>[编辑]</a>" 
				});
			rows.add(cellMap);
		}
	}
	/**
	 * 获取货物详细
	 * @return
	 */
	@Action(value = "findProductByProductid", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
	public String findProductByProductid(){
		if(StringUtils.isBlank(this.getProductid())){
			return "json";
		}
		bean=this.getProductTService().findProductByProductid(this.getProductid());
		if(bean!=null){
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}
	
	/**
	 * 更新货物信息
	 * @return
	 */
	@Action(value = "updateProductT", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
	public String updateProductT(){
		if(StringUtils.isBlank(this.getProductid())){
			return "json";
		}
		ProductT pt=new ProductT();
		pt=this.getProductTService().findProductByProductid(this.getProductid());
		//当前货物的旧库存
		int oldQuantity=pt.getStore();
		pt.setPrice(this.getPrice());
		pt.setMemberprice(this.getMemberprice());
		pt.setCost(this.getCost());
		pt.setSaleprice(this.getSaleprice());
		pt.setFreezeStore(Integer.parseInt(this.getFreezeStore()));
		pt.setStore(Integer.parseInt(this.getStore()));
		pt.setIsDefault(this.getIsDefault());
		pt.setIsSalestate(this.getIsSalestate());
		pt.setProductName(this.getProductName());
		pt.setProductSn(this.getProductSn());
		pt.setSpecificationsValue(this.getSpecificationsValue());
		pt.setWarehouseLocation(this.getWarehouseLocation());
		pt.setPlaceStore(this.getPlaceStore());
		pt.setWeight(this.getWeight());
		pt.setCreatorid(BaseTools.getAdminCreateId());
		pt.setSpecificationsid(this.getSpecificationsid());
		pt.setSpecificationsName(this.getSpecificationsName());
		pt.setUpdatetime(BaseTools.systemtime());
		pt.setUnit(this.getUnit());
		//保存商品和规格和货物关系，要进行事务控制
		GoodsSpecificationsProductRpT gsrt=this.getGoodsSpecificationsProductRpTService().checkSpecificationRelationshipByproductid(pt.getProductid()).get(0);
		gsrt.setGoodsid(pt.getGoodsid());
		gsrt.setProductid(pt.getProductid());
		gsrt.setSpecidicationsid(pt.getSpecificationsid());
		this.getProductTService().updateProductProcess(pt, gsrt,oldQuantity);
		this.setSucflag(true);
		return "json";
	}
	
	/**
	 * 批量删除货物
	 * @return
	 */
	@Action(value = "delProductT", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
	public String delProductT(){
		if(StringUtils.isNotBlank(this.getProductid())){
			String[] strs=StringUtils.split(this.getProductid(), ",");
			if(this.getProductTService().delProductT(strs)>0){
				this.setSucflag(true);
				return "json";
			}
			return "json";
		}
		return "json";
	}
	
	/**
	 * 根据货物名称获取货物信息
	 * @return
	 */
	@Action(value = "findProductByproductName", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
	public String findProductByproductName(){
		if(StringUtils.isBlank(this.getProductName())){
			return "json";
		}
		beanlist=this.getProductTService().findProductByproductName(this.getProductName(), 100);
		if(!beanlist.isEmpty()){
			ProcessProductsList(beanlist);
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}
	
	
	
	
}
