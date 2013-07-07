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

import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.GoodsTypeBrandT;
import com.jshop.service.GoodsTypeBrandTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class GoodsTypeBrandTAction extends ActionSupport {
	private Serial serial;
	private GoodsTypeBrandTService goodsTypeBrandTService;
	private String goodsTypeBrandTid;
	private String goodsTypeId;
	private String name;
	private String brandname;
	private String brandid;
	private String query;
	private String qtype;
	private List rows;
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean slogin;
	private boolean sucflag;
	private String sortname;
	private String sortorder;

	public GoodsTypeBrandTAction() {
		rows = new ArrayList();
	}
	@JSON(serialize = false)
	public GoodsTypeBrandTService getGoodsTypeBrandTService() {
		return goodsTypeBrandTService;
	}

	public void setGoodsTypeBrandTService(GoodsTypeBrandTService goodsTypeBrandTService) {
		this.goodsTypeBrandTService = goodsTypeBrandTService;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getBrandid() {
		return brandid;
	}

	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

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

	public String getGoodsTypeBrandTid() {
		return goodsTypeBrandTid;
	}

	public void setGoodsTypeBrandTid(String goodsTypeBrandTid) {
		this.goodsTypeBrandTid = goodsTypeBrandTid;
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

	/**
	 * 设置日期格式
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加品牌商品
	 * 
	 * @return
	 */
	@Action(value = "addGoodsTypeBrand", results = { @Result(name = "json", type = "json") })
	public String addGoodsTypeBrand() {
		int i = 0;
		String brandidarray[] = this.getBrandid().split(",");
		String brandnamearray[] = this.getBrandname().split(",");
		GoodsTypeBrandT gtbt = new GoodsTypeBrandT();
		for (int j = 0; j < brandidarray.length; j++) {
			gtbt.setBrandid(brandidarray[j]);
			gtbt.setBrandname(brandnamearray[j]);
			gtbt.setGoodsTypeId(this.getGoodsTypeId());
			gtbt.setName(this.getName());
			GoodsTypeBrandT list = this.getGoodsTypeBrandTService().findGoodsTypeBrandByBrandid(brandidarray[j], this.getGoodsTypeId());
			if (list != null) {
				this.setSucflag(false);
			} else {
				gtbt.setGoodsTypeBrandTid(this.getSerial().Serialid(Serial.GOODSTYPEBRAND));
				i = this.getGoodsTypeBrandTService().addGoodsTypeBrand(gtbt);
			}

		}
		this.setSucflag(true);
		return "json";
	}

	/**
	 *获取所有品牌商品
	 * 
	 * @return
	 */
	@Action(value = "findAllGoodsTypeBrand", results = { @Result(name = "json", type = "json") })
	public String findAllGoodsTypeBrand() {
		if (this.getQtype().equals("sc")) {
			findDefaultAllGoodsTypeBrand();
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {
				return "json";
			}
		}
		return "json";

	}

	public void findDefaultAllGoodsTypeBrand() {
		int currentPage = page;
		int lineSize = rp;
		if (Validate.StrNotNull(sortname) && Validate.StrNotNull(sortorder)) {
			String queryString = "from GoodsTypeBrandT  order by " + sortname + " " + sortorder + "";
			List<GoodsTypeBrandT> list = this.getGoodsTypeBrandTService().sortAllGoodsTypeBrand(currentPage, lineSize, queryString);
			if (list != null) {
				this.ProcessGoodsTypeBrandTList(list);
			}
		}
	}

	public void ProcessGoodsTypeBrandTList(List<GoodsTypeBrandT> list) {
		total = this.getGoodsTypeBrandTService().countfindAllGoodsTypeBrand();
		for (Iterator it = list.iterator(); it.hasNext();) {
			GoodsTypeBrandT gtbt = (GoodsTypeBrandT) it.next();
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", gtbt.getGoodsTypeBrandTid());
			cellMap.put("cell", new Object[] {gtbt.getBrandname(), gtbt.getName() });
			rows.add(cellMap);
		}

	}

	/**
	 * 删除品牌商品
	 * 
	 * @return
	 */
	@Action(value = "DelGoodsTypeBrand", results = { @Result(name = "json", type = "json") })
	public String DelGoodsTypeBrand() {
		String[] list = this.getGoodsTypeBrandTid().trim().split(",");
		int i = this.getGoodsTypeBrandTService().delGoodsTypeBrand(list);
		this.setSucflag(true);
		return "json";
	}
}
