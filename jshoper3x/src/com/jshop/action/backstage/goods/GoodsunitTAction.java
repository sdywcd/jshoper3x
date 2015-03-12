package com.jshop.action.backstage.goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.entity.GoodsunitT;
import com.jshop.service.GoodsunitTService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class GoodsunitTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private GoodsunitTService goodsunitTService;
	private String unitid;
	private String unitname;
	private String creatorid;
	private String unitjson;
	private List<GoodsunitT> unit = new ArrayList<GoodsunitT>();
	private GoodsunitT beanlist = new GoodsunitT();
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String param;
	private String usession;

	
	@JSON(serialize = false)
	public GoodsunitTService getGoodsunitTService() {
		return goodsunitTService;
	}

	public void setGoodsunitTService(GoodsunitTService goodsunitTService) {
		this.goodsunitTService = goodsunitTService;
	}

	public String getUnitid() {
		return unitid;
	}

	public void setUnitid(String unitid) {
		this.unitid = unitid;
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public GoodsunitT getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(GoodsunitT beanlist) {
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

	public String getUnitjson() {
		return unitjson;
	}

	public void setUnitjson(String unitjson) {
		this.unitjson = unitjson;
	}

	public List<GoodsunitT> getUnit() {
		return unit;
	}

	public void setUnit(List<GoodsunitT> unit) {
		this.unit = unit;
	}


	public String getUsession() {
		return usession;
	}

	public void setUsession(String usession) {
		this.usession = usession;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}



	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加商品单位
	 * 
	 * @return
	 */
	@Action(value = "addGoodsunit", results = { @Result(name = "success", type = "redirect", location = "/jshop/admin/goods/goodsunitmanagement.jsp?session=${usession}"), @Result(name = "input", type = "redirect", location = "/jshop/admin/goods/goodsunitmanagement.jsp?session=${usession}"), @Result(name = "error", type = "redirect", location = "/jshop/admin/goods/goodsunitmanagement.jsp?session=${usession}") })
	public String addGoodsunit() {
		GoodsunitT u = new GoodsunitT();
		u.setUnitid(this.getSerial().Serialid(Serial.UNIT));
		u.setUnitname(this.getUnitname().trim());
		u.setCreatorid(BaseTools.getAdminCreateId());
		u.setCreatetime(BaseTools.systemtime());
		this.getGoodsunitTService().save(u);
		return SUCCESS;
	
	}

	/**
	 * 获取所有单位数据
	 * 
	 * @return
	 */
	@Action(value = "findAllGoodsunit", results = { @Result(name = "json", type = "json") })
	public String findAllGoodsunit() {
		int currentPage = page;
		int lineSize = rp;
		String queryString = "from GoodsunitT order by " + getSortname() + " " + getSortorder() + "";
		if (Validate.StrNotNull(getSortname()) && Validate.StrNotNull(getSortorder())) {
			List<GoodsunitT> gt = this.getGoodsunitTService().sortAllGoodsunit(currentPage, lineSize, queryString);
			if (gt != null) {
				total = this.getGoodsunitTService().countfindAllGoodsunit();
				rows.clear();
				for (Iterator<GoodsunitT> it = gt.iterator(); it.hasNext();) {
					GoodsunitT u = (GoodsunitT) it.next();
					Map<String, Object> cellMap = new HashMap<String, Object>();
					cellMap.put("id", u.getUnitid());
					cellMap.put("cell", new Object[] { u.getUnitname(), BaseTools.formateDbDate(u.getCreatetime()), u.getCreatorid() });
					rows.add(cellMap);
				}
				return "json";
			}
		}
		this.setTotal(0);
		rows.clear();
		return "json";
	}

	/**
	 *更新单位
	 * 
	 * @return
	 */
	@Action(value = "UpdateGoodsunit", results = { @Result(name = "json", type = "json") })
	public String UpdateGoodsunit() {
		if (Validate.StrNotNull(this.getUnitname())) {
			GoodsunitT u = new GoodsunitT();
			u.setUnitid(this.getUnitid().trim());
			u.setUnitname(this.getUnitname().trim());
			u.setCreatorid(BaseTools.getAdminCreateId());
			u.setCreatetime(BaseTools.systemtime());
			this.getGoodsunitTService().updateGoodsunit(u);
			return "json";
		}
		return "json";
	}

	/**
	 * 根据id获取单位
	 * 
	 * @return
	 */
	@Action(value = "findGoodsunitById", results = { @Result(name = "json", type = "json") })
	public String findGoodsunitById() {
		if (Validate.StrNotNull(this.getUnitid())) {
			beanlist = this.getGoodsunitTService().findGoodsunitById(this.getUnitid().trim());
			if (beanlist != null) {
				return "json";
			}
		}
		return "json";
	}

	/**
	 * 删除单位
	 * 
	 * @return
	 */
	@Action(value = "DelGoodsunit", results = { @Result(name = "json", type = "json") })
	public String DelGoodsunit() {
		if (Validate.StrNotNull(this.getUnitid())) {
			String[] array = this.getUnitid().trim().split(",");
			if (this.getGoodsunitTService().delGoodsunit(array) > 0) {
				return "json";
			}
			return "json";
		}
		return "json";
	}

	/**
	 * 获取所有单位数据json
	 * 
	 * @return
	 */
	@Action(value = "findAllGoodsunitjson", results = { @Result(name = "json", type = "json") })
	public String findAllGoodsunitjson() {
		this.setUnitjson("");
		this.unit = this.getGoodsunitTService().findAllGoodsunitjson();
		if (unit != null) {
			for (Iterator<GoodsunitT> it = this.unit.iterator(); it.hasNext();) {
				GoodsunitT gt = (GoodsunitT) it.next();
				this.unitjson += "<option value='" + gt.getUnitid() + "'>" + gt.getUnitname() + "</option>";
			}
			this.setUnitjson(unitjson);
			return "json";
		}
		return "json";
	}
}
