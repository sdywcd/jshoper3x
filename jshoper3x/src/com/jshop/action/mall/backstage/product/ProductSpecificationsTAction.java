
package com.jshop.action.mall.backstage.product;

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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.jshop.action.mall.backstage.base.BaseTAction;
import com.jshop.action.mall.backstage.utils.BaseTools;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.DataUsingState;
import com.jshop.action.mall.backstage.utils.statickey.StaticKey;
import com.jshop.entity.ProductSpecificationsT;
import com.jshop.service.ProductSpecificationsTService;
import com.jshop.service.impl.Serial;
@Namespace("")
@ParentPackage("jshop")
public class ProductSpecificationsTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	@Resource
	private ProductSpecificationsTService productSpecificationsTService;
	private String specificationsid;
	private String name;
	private String note;
	private String sort;
	private String specificationsType;
	private String specificationsValue;
	private Date createtime;
	private String creatorid;
	private String state;
	private String goodsTypeId;
	private String goodsTypeName;
	private ProductSpecificationsT bean = new ProductSpecificationsT();
	private List<Map<String,Object>> beanlist = new ArrayList<Map<String,Object>>();
	private List<ProductSpecificationsT> specificationList = new ArrayList<ProductSpecificationsT>();
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String specificationslist = null;
	private String specificationsselect = null;
	private boolean sucflag;

	public String getSpecificationsid() {
		return specificationsid;
	}

	public void setSpecificationsid(String specificationsid) {
		this.specificationsid = specificationsid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSpecificationsType() {
		return specificationsType;
	}

	public void setSpecificationsType(String specificationsType) {
		this.specificationsType = specificationsType;
	}

	public String getSpecificationsValue() {
		return specificationsValue;
	}

	public void setSpecificationsValue(String specificationsValue) {
		this.specificationsValue = specificationsValue;
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

	public ProductSpecificationsT getBean() {
		return bean;
	}

	public void setBean(ProductSpecificationsT bean) {
		this.bean = bean;
	}

	public List<Map<String,Object>> getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(List<Map<String,Object>> beanlist) {
		this.beanlist = beanlist;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSpecificationslist() {
		return specificationslist;
	}

	public void setSpecificationslist(String specificationslist) {
		this.specificationslist = specificationslist;
	}



	public List<ProductSpecificationsT> getSpecificationList() {
		return specificationList;
	}

	public void setSpecificationList(List<ProductSpecificationsT> specificationList) {
		this.specificationList = specificationList;
	}

	public String getSpecificationsselect() {
		return specificationsselect;
	}

	public void setSpecificationsselect(String specificationsselect) {
		this.specificationsselect = specificationsselect;
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

	/**
	 * 清楚错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加所有商品规格值
	 * 
	 * @return
	 */
	@Action(value = "addProductSpecification", results = { @Result(name = "json", type = "json") })
	public String addProductSpecification() {
		ProductSpecificationsT pst = new ProductSpecificationsT();
		pst.setSpecificationsid(this.getSerial().Serialid(Serial.PRODUCTSPECIFICATION));
		pst.setName(this.getName().trim());
		pst.setNote(this.getNote());
		pst.setSort(this.getSort());
		pst.setSpecificationsType(this.getSpecificationsType());
		pst.setSpecificationsValue(this.getSpecificationsValue());
		pst.setCreatetime(BaseTools.getSystemTime());
		pst.setCreatorid(BaseTools.getAdminCreateId());
		pst.setState(DataUsingState.USING.getState());
		pst.setGoodsTypeId(this.getGoodsTypeId());
		pst.setGoodsTypeName(this.getGoodsTypeName());
		pst.setShopid(BaseTools.getShopId());
		this.productSpecificationsTService.save(pst);
		this.setSucflag(true);
		return JSON;
	}

	/**
	 * 查询所有商品规格值
	 * 
	 * @return
	 */
	@Action(value = "findAllProductSpecificationsT", results = { @Result(name = "json", type = "json") })
	public String findAllProductSpecificationsT() {
		if (StaticKey.SC.equals(this.getQtype())) {
			this.findDefaultAllProductSpecificationsT();
		} else {
			if (StringUtils.isBlank(this.getQtype())) {
				return JSON;
			} else {
				return JSON;
			}
		}
		return JSON;
	}

	public void findDefaultAllProductSpecificationsT() {
		int currentPage = page;
		int lineSize = rp;
		total = this.productSpecificationsTService.count(ProductSpecificationsT.class).intValue();
		if(StringUtils.isNotBlank(this.getSortname())&&StringUtils.isNotBlank(this.getSortorder())){
			Order order=null;
			if(StringUtils.equals(this.getSortorder(), StaticKey.ASC)){
				order=Order.asc(this.getSortname());
			}else{
				order=Order.desc(this.getSortname());
			}
			List<ProductSpecificationsT>list=this.productSpecificationsTService.findByCriteriaByPage(ProductSpecificationsT.class, order, currentPage, lineSize);
			this.processProductSpecificationsTList(list);
		}
	}

	public void processProductSpecificationsTList(List<ProductSpecificationsT> list) {
		rows.clear();
		StringBuilder sbkey = new StringBuilder();
		for (Iterator<ProductSpecificationsT> it = list.iterator(); it.hasNext();) {
			ProductSpecificationsT gst = (ProductSpecificationsT) it.next();
			if (gst.getSpecificationsType().equals(StaticKey.ONE)) {
				gst.setSpecificationsType(StaticKey.WORTTYPE);
			} else if(gst.getSpecificationsType().equals(StaticKey.TWO)) {
				gst.setSpecificationsType(StaticKey.IMGTYPE);
			}else{
				gst.setSpecificationsType(StaticKey.COLORTYPE);
			}
			JSONArray ja=(JSONArray)JSONValue.parse(gst.getSpecificationsValue());
			int jsonsize=ja.size();
			for (int i = 0; i < jsonsize; i++) {
				JSONObject jo=(JSONObject)(ja.get(i));
				Iterator iter = jo.keySet().iterator();
				while (iter.hasNext()) {
					String key = iter.next().toString();
					if (key.equals(StaticKey.SPECIFIKEY)) {
						sbkey.append(jo.get(key).toString()).append("");
					}
				}
			}
			gst.setSpecificationsValue(sbkey.toString());
			if (gst.getNote() == null) {
				gst.setNote("");
			}
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", gst.getSpecificationsid());
			cellMap.put("cell", new Object[] { gst.getName() + "[" + gst.getNote() + "]", gst.getSpecificationsType(), gst.getSpecificationsValue(), gst.getSort(), BaseTools.formateDbDate(gst.getCreatetime()),"<a id='editproductspecification' name='editproductspecification' href='productspecification.jsp?operate=edit&folder=goods&specificationsid=" +gst.getSpecificationsid()+ "'>[编辑]</a>" });
			rows.add(cellMap);
			sbkey.delete(0, sbkey.length());
		}

	}

	/**
	 * 根据规格值id获取规格值
	 * 
	 * @return
	 */
	@Action(value = "findProductSpecificationsTByspecificationsid", results = { @Result(name = "json", type = "json") })
	public String findProductSpecificationsTByspecificationsid() {
		if (StringUtils.isNotBlank(this.getSpecificationsid())){
			bean = this.productSpecificationsTService.findByPK(ProductSpecificationsT.class, this.getSpecificationsid());
			if (bean != null) {
				this.setSucflag(true);
			}
		}
		return JSON;
	}

	/**
	 * 更新商品规格值
	 * 
	 * @return
	 */
	@Action(value = "updateProductSpecification", results = { @Result(name = "json", type = "json") })
	public String updateProductSpecification() {
		if(StringUtils.isNotBlank(this.getSpecificationsid())){
			ProductSpecificationsT pst=this.productSpecificationsTService.findByPK(ProductSpecificationsT.class, this.getSpecificationsid());
			if(pst!=null){
				pst.setName(this.getName().trim());
				pst.setNote(this.getNote());
				pst.setSort(this.getSort());
				pst.setSpecificationsType(this.getSpecificationsType());
				pst.setSpecificationsValue(this.getSpecificationsValue());
				pst.setCreatetime(BaseTools.getSystemTime());
				pst.setCreatorid(BaseTools.getAdminCreateId());
				pst.setGoodsTypeId(this.getGoodsTypeId());
				pst.setGoodsTypeName(this.getGoodsTypeName());
				pst.setShopid(BaseTools.getShopId());
				this.productSpecificationsTService.update(pst);
				this.setSucflag(true);
				return JSON;
			}
		}
		return JSON;

	}

	/**
	 *删除商品规格值
	 * 
	 * @return
	 */
	@Action(value = "delProductSpecification", results = { @Result(name = "json", type = "json") })
	public String delProductSpecification() {
		if (StringUtils.isNotBlank(this.getSpecificationsid())) {
			String[] strs = StringUtils.split(this.getSpecificationsid(),StaticKey.SPLITDOT);
			for(String s:strs){
				ProductSpecificationsT pst=this.productSpecificationsTService.findByPK(ProductSpecificationsT.class, s);
				if(pst!=null){
					this.productSpecificationsTService.delete(pst);
				}
			}
			this.setSucflag(true);
		}
		return JSON;
	}

	/**
	 * 查询所有可用商品规格值
	 * 
	 * @return
	 */
	@Action(value = "findAllSpecificationsforjson", results = { @Result(name = "json", type = "json") })
	public String findAllSpecificationsforjson() {
		Criterion criterion=Restrictions.eq("state", DataUsingState.USING.getState());
		specificationList = this.productSpecificationsTService.findByCriteria(ProductSpecificationsT.class, criterion);
		if (!specificationList.isEmpty()) {
			this.setSucflag(true);
		}
		return JSON;
	}
	
	/**
	 * 根据商品类型查询规格值信息
	 * 
	 * @return
	 */
	@Action(value = "findAllSpecificationsByGoodsTypeId", results = { @Result(name = "json", type = "json") })
	public String findAllSpecificationsByGoodsTypeId(){
		if(StringUtils.isNotBlank(this.getGoodsTypeId())){
			Criterion criterion=Restrictions.and(Restrictions.eq("state", DataUsingState.USING.getState())).add(Restrictions.eq("goodsTypeId", this.getGoodsTypeId()));
			specificationList=this.productSpecificationsTService.findByCriteria(ProductSpecificationsT.class, criterion);
			this.setSucflag(true);
		}
		return JSON;
	}
}
