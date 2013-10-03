package com.jshop.action.backstage.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.PlaceoforiginT;
import com.jshop.service.PlaceoforiginTService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class PlaceoforiginTAction extends ActionSupport {
	
	private PlaceoforiginTService placeoforiginTService;
	private Serial serial;
	private String placeid;
	private String placename;
	private String creatorid;
	private String placeoforigintjson = null;
	private List<PlaceoforiginT> placeoforigin = new ArrayList<PlaceoforiginT>();
	private PlaceoforiginT beanlist = new PlaceoforiginT();
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean slogin;
	private String usession;
	@JSON(serialize = false)
	public PlaceoforiginTService getPlaceoforiginTService() {
		return placeoforiginTService;
	}

	public void setPlaceoforiginTService(PlaceoforiginTService placeoforiginTService) {
		this.placeoforiginTService = placeoforiginTService;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getPlaceid() {
		return placeid;
	}

	public void setPlaceid(String placeid) {
		this.placeid = placeid;
	}

	public String getPlacename() {
		return placename;
	}

	public void setPlacename(String placename) {
		this.placename = placename;
	}

	public PlaceoforiginT getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(PlaceoforiginT beanlist) {
		this.beanlist = beanlist;
	}

	@JSON(name = "rows")
	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
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

	public String getPlaceoforigintjson() {
		return placeoforigintjson;
	}

	public void setPlaceoforigintjson(String placeoforigintjson) {
		this.placeoforigintjson = placeoforigintjson;
	}

	public List<PlaceoforiginT> getPlaceoforigin() {
		return placeoforigin;
	}

	public void setPlaceoforigin(List<PlaceoforiginT> placeoforigin) {
		this.placeoforigin = placeoforigin;
	}

	

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
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

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	
	/**
	 * 增加商品产地
	 * 
	 * @return
	 */
	@Action(value = "addPlaceoforigint", results = { 
			@Result(name = "success", type="redirect",location = "/jshop/admin/goods/goodsplacemanagement.jsp?session=${usession}"),
			@Result(name = "input", type="redirect",location = "/jshop/admin/goods/goodsplacemanagement.jsp?session=${usession}")
	})
	public String addPlaceoforigint() {
		PlaceoforiginT p = new PlaceoforiginT();
		p.setPlaceid(this.getSerial().Serialid(Serial.PLACEFORIGIN));
		p.setPlacename(this.getPlacename().trim());
		p.setCreatetime(BaseTools.systemtime());
		p.setCreatorid(BaseTools.adminCreateId());
		if (this.getPlaceoforiginTService().addPlaceoforigint(p) > 0) {
			return SUCCESS;
		}
		return INPUT;
	}

	/**
	 * 查询所有商品产地
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Action(value = "findAllPlaceoforigint", results = { 
			@Result(name = "json",type="json")
	})
	public String findAllPlaceoforigint() {
		int currentPage = page;
		int lineSize = rp;
		List<PlaceoforiginT> pt = this.getPlaceoforiginTService().findAllPlaceoforigint(currentPage, lineSize);
		if (pt != null) {
			total = this.getPlaceoforiginTService().countfindAllPlaceoforigint();
			rows.clear();
			for (Iterator it = pt.iterator(); it.hasNext();) {
				PlaceoforiginT p = (PlaceoforiginT) it.next();
				Map cellMap = new HashMap();
				cellMap.put("id", p.getPlaceid());
				cellMap.put("cell", new Object[] { "<input id='id' name='firstcol' class='firstplaceid' type='checkbox' value='" + p.getPlaceid() + "'></input>", p.getPlacename(), p.getCreatetime(), p.getCreatorid() });
				rows.add(cellMap);
			}
			return "json";
		}
		this.setTotal(0);
		rows.clear();
		return "json";
	}

	/**
	 *更新商品产地
	 * 
	 * @return
	 */
	@Action(value = "UpdatePlaceoforigint", results = { 
			@Result(name = "success",type="redirect",location = "/jshop/admin/goods/goodsplacemanagement.jsp?session=${usession}"),
			@Result(name = "input",type="redirect", location = "/jshop/admin/goods/goodsplacemanagement.jsp?session=${usession}")
	})
	public String UpdatePlaceoforigint() {
		PlaceoforiginT p = new PlaceoforiginT();
		p.setPlacename(this.getPlacename().trim());
		p.setPlaceid(this.getPlaceid());
		p.setCreatetime(BaseTools.systemtime());
		p.setCreatorid(BaseTools.adminCreateId());
		this.getPlaceoforiginTService().updatePlaceoforigint(p);
		return SUCCESS;
	}

	/**
	 *根据id获取商品产地
	 * 
	 * @return
	 */
	@Action(value = "findPlaceoforigintById", results = { 
			@Result(name = "json",type="json")
	})
	public String findPlaceoforigintById() {
		if (Validate.StrNotNull(this.getPlaceid())) {
			beanlist = this.getPlaceoforiginTService().findPlaceoforigintById(this.getPlaceid().trim());
			if (beanlist != null) {
				return "json";
			}
			return "json";
		}
		return "json";
	}

	/**
	 * 删除商品产地
	 * 
	 * @return
	 */
	@Action(value = "DelPlaceoforigint", results = { 
			@Result(name = "json",type="json")
	})
	public String DelPlaceoforigint() {
		if (Validate.StrNotNull(this.getPlaceid())) {
			String[] strs = this.getPlaceid().trim().split(",");
			if (this.getPlaceoforiginTService().delPlaceoforigint(strs) > 0) {
				return "json";
			}
			return "json";
		}
		return "json";
	
	
	}

	/**
	 * 获取商品产地json方式
	 * 
	 * @return
	 */
	@Action(value = "findAllPlaceoforigintjson", results = { 
			@Result(name = "json",type="json")
	})
	public String findAllPlaceoforigintjson() {
		this.setPlaceoforigintjson("");
		this.placeoforigin = this.getPlaceoforiginTService().findAllPlaceoforigintjson();
		if (this.placeoforigin != null) {
			for (Iterator it = this.placeoforigin.iterator(); it.hasNext();) {
				PlaceoforiginT p = (PlaceoforiginT) it.next();
				this.placeoforigintjson += "<option value='" + p.getPlaceid() + "'>" + p.getPlacename() + "</option>";
			}
			this.setPlaceoforigintjson(placeoforigintjson);
			return "json";
		}
		return "json";
	}
}
