
package com.jshop.action.backstage.product;

import java.util.ArrayList;
import java.util.Date;
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
import com.jshop.entity.ProductSpecificationsT;
import com.jshop.service.ProductSpecificationsTService;
import com.jshop.service.impl.Serial;
@Namespace("")
@ParentPackage("jshop")
public class ProductSpecificationsTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
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

	@JSON(serialize = false)
	public ProductSpecificationsTService getProductSpecificationsTService() {
		return productSpecificationsTService;
	}

	public void setProductSpecificationsTService(ProductSpecificationsTService productSpecificationsTService) {
		this.productSpecificationsTService = productSpecificationsTService;
	}

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
		pst.setCreatetime(BaseTools.systemtime());
		pst.setCreatorid(BaseTools.getAdminCreateId());
		pst.setState(StaticKey.ONE);
		pst.setGoodsTypeId(this.getGoodsTypeId());
		pst.setGoodsTypeName(this.getGoodsTypeName());
		this.getProductSpecificationsTService().save(pst);
		this.setSucflag(true);
		return "json";

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
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {
				return "json";
			}
		}
		return "json";
	}

	public void findDefaultAllProductSpecificationsT() {
		int currentPage = page;
		int lineSize = rp;
		total = this.getProductSpecificationsTService().countfindAllProductSpecificationsT();
		String queryString = "from ProductSpecificationsT order by " + this.getSortname() + " " + this.getSortorder() + " ";
		if (Validate.StrNotNull(this.getSortname()) && Validate.StrNotNull(this.getSortorder())) {
			List<ProductSpecificationsT> list = this.getProductSpecificationsTService().sortAllProductSpecificationsT(currentPage, lineSize, queryString);
			if (list != null) {
				this.ProcessProductSpecificationsTList(list);
			}
		}
	}

	public void ProcessProductSpecificationsTList(List<ProductSpecificationsT> list) {
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
			bean = this.getProductSpecificationsTService().findProductSpecificationsTByspecificationsid(this.getSpecificationsid().trim());
			if (bean != null) {
				this.setSucflag(true);
				return "json";
			}
		}
		return "json";

	}

	/**
	 * 更新商品规格值
	 * 
	 * @return
	 */
	@Action(value = "updateProductSpecification", results = { @Result(name = "json", type = "json") })
	public String updateProductSpecification() {
		if(StringUtils.isNotBlank(this.getSpecificationsid())){
			ProductSpecificationsT pst=this.getProductSpecificationsTService().findByPK(ProductSpecificationsT.class, this.getSpecificationsid());
			if(pst!=null){
				pst.setName(this.getName().trim());
				pst.setNote(this.getNote());
				pst.setSort(this.getSort());
				pst.setSpecificationsType(this.getSpecificationsType());
				pst.setSpecificationsValue(this.getSpecificationsValue());
				pst.setCreatetime(BaseTools.systemtime());
				pst.setCreatorid(BaseTools.getAdminCreateId());
				pst.setGoodsTypeId(this.getGoodsTypeId());
				pst.setGoodsTypeName(this.getGoodsTypeName());
				this.getProductSpecificationsTService().update(pst);
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

		if (Validate.StrNotNull(this.getSpecificationsid())) {
			String[] list = StringUtils.split(this.getSpecificationsid(), ",");
			int i = this.getProductSpecificationsTService().delProductSpecification(list);
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}

	}

	/**
	 * 查询所有商品规格值
	 * 
	 * @return
	 */
	@Action(value = "findAllSpecificationsforjson", results = { @Result(name = "json", type = "json") })
	public String findAllSpecificationsforjson() {
		String state=StaticKey.ONE;//可用状态
		specificationList = this.getProductSpecificationsTService().findAllProductSpecificationsT(state);
		if (!specificationList.isEmpty()) {
			this.setSucflag(true);
			return "json";
		}
		return "json";

	}
	
	/**
	 * 根据商品类型查询规格值信息
	 * 
	 * @return
	 */
	@Action(value = "findAllSpecificationsByGoodsTypeId", results = { @Result(name = "json", type = "json") })
	public String findAllSpecificationsByGoodsTypeId(){
		if(StringUtils.isNotBlank(this.getGoodsTypeId())){
			specificationList=this.getProductSpecificationsTService().findAllProductSpecificationsByGoodsTypeId(this.getGoodsTypeId(), StaticKey.ONE);
			this.setSucflag(true);
			return JSON;
		}
		return JSON;
	}
}
