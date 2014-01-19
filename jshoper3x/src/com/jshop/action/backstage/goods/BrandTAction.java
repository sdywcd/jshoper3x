package com.jshop.action.backstage.goods;

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

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.BrandT;
import com.jshop.entity.GoodsTypeBrandT;
import com.jshop.service.BrandTService;
import com.jshop.service.GoodsTypeBrandTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class BrandTAction extends ActionSupport {
	private BrandTService brandTService;
	private GoodsTypeBrandTService goodsTypeBrandTService;
	private Serial serial;
	private String brandid;
	private String brandname;
	private String creatorid;
	private String username;
	private String createtime;
	private String intro;
	private String logoPath;
	private String sort;
	private String url;
	private String goodsTypeId;
	private String goodsTypeName;
	private BrandT bean=new BrandT();
	private String brandjson;
	private List<BrandT> brand = new ArrayList<BrandT>();
	private String query;
	private String qtype;
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean slogin;
	private boolean sucflag;
	private String sortname;
	private String sortorder;
	@JSON(serialize = false)
	public GoodsTypeBrandTService getGoodsTypeBrandTService() {
		return goodsTypeBrandTService;
	}

	public void setGoodsTypeBrandTService(
			GoodsTypeBrandTService goodsTypeBrandTService) {
		this.goodsTypeBrandTService = goodsTypeBrandTService;
	}

	@JSON(serialize = false)
	public BrandTService getBrandTService() {
		return brandTService;
	}

	public void setBrandTService(BrandTService brandTService) {
		this.brandTService = brandTService;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getBrandid() {
		return brandid;
	}

	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
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

	public BrandT getBean() {
		return bean;
	}

	public void setBean(BrandT bean) {
		this.bean = bean;
	}

	public String getBrandjson() {
		return brandjson;
	}

	public void setBrandjson(String brandjson) {
		this.brandjson = brandjson;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<BrandT> getBrand() {
		return brand;
	}

	public void setBrand(List<BrandT> brand) {
		this.brand = brand;
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
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加品牌
	 * 
	 * @return
	 */
	@Action(value = "addBrandt", results = { @Result(name = "json", type = "json") })
	public String addBrandt() {
		BrandT bt = new BrandT();
		bt.setBrandid(this.getSerial().Serialid(Serial.BRAND));
		bt.setBrandname(this.getBrandname().trim());
		bt.setCreatorid(BaseTools.adminCreateId());
		bt.setUsername(this.getUsername());
		bt.setCreatetime(BaseTools.systemtime());
		bt.setIntro(this.getIntro());
		bt.setLogoPath(this.getLogoPath().trim());
		bt.setSort(Integer.parseInt(this.getSort().trim()));
		bt.setUrl(this.getUrl().trim());
		//增加商品品牌和商品类型的关系
		GoodsTypeBrandT gtbt = new GoodsTypeBrandT();
		gtbt.setGoodsTypeBrandTid(this.getSerial().Serialid(Serial.GOODSTYPEBRAND));
		gtbt.setBrandid(bt.getBrandid());
		gtbt.setBrandname(bt.getBrandname());
		gtbt.setGoodsTypeId(this.getGoodsTypeId());
		gtbt.setName(this.getGoodsTypeName());
		this.getBrandTService().saveBrandTransaction(bt, gtbt);
		this.setSucflag(true);
		return "json";
	}

	/**
	 * 获取所有品牌
	 * 
	 * @return
	 */
	@Action(value = "/web/findAllBrandt", results = { @Result(name = "json", type = "json") })
	public String findAllBrandt() {
		int currentPage = page;
		int lineSize = rp;
		total = this.getBrandTService().countfindAllBrandt(BaseTools.adminCreateId());
		if (Validate.StrNotNull(sortname) && Validate.StrNotNull(sortorder)) {
			String queryString = " from BrandT as bt where bt.creatorid=:creatorid order by " + sortname + " " + sortorder + "";
			List<BrandT> bt = this.getBrandTService().sortAllBrandt(currentPage, lineSize, BaseTools.adminCreateId(), queryString);
			if (bt != null) {
				for (Iterator it = bt.iterator(); it.hasNext();) {
					BrandT b = (BrandT) it.next();
					Map cellMap = new HashMap();
					cellMap.put("id", b.getBrandid());
					cellMap.put("cell", new Object[] {b.getBrandname(), b.getSort(), BaseTools.formateDbDate(b.getCreatetime()), b.getCreatorid(),"<a id='editbrands' name='editbrands' href='brands.jsp?operate=edit&folder=goods&brandid=" + b.getBrandid()+ "'>[编辑]</a>" });
					rows.add(cellMap);
				}
				return "json";
			}
			return "json";
		}
		return "json";

	}

	/**
	 * 更新品牌信息
	 * 
	 * @return
	 */
	@Action(value = "updateBrandt", results = { @Result(name = "json", type = "json") })
	public String updateBrandt() {
		BrandT bt = new BrandT();
		bt.setBrandid(this.getBrandid());
		bt.setBrandname(this.getBrandname().trim());
		bt.setCreatorid(BaseTools.adminCreateId());
		bt.setUsername(this.getUsername());
		bt.setCreatetime(BaseTools.systemtime());
		bt.setIntro(this.getIntro());
		bt.setLogoPath(this.getLogoPath().trim());
		bt.setSort(Integer.parseInt(this.getSort().trim()));
		bt.setUrl(this.getUrl().trim());
		this.getBrandTService().updateBrandt(bt);
		GoodsTypeBrandT list = this.getGoodsTypeBrandTService().findGoodsTypeBrandByBrandid(bt.getBrandid(), this.getGoodsTypeId());
		if (list==null) {
			//增加商品品牌和商品类型的关系
			GoodsTypeBrandT gtbt = new GoodsTypeBrandT();
			gtbt.setGoodsTypeBrandTid(this.getSerial().Serialid(Serial.GOODSTYPEBRAND));
			gtbt.setBrandid(bt.getBrandid());
			gtbt.setBrandname(bt.getBrandname());
			gtbt.setGoodsTypeId(this.getGoodsTypeId());
			gtbt.setName(this.getGoodsTypeName());
			this.getGoodsTypeBrandTService().save(gtbt);
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(true);
		return "json";
	}

	/**
	 * 根据id获取品牌信息
	 * 
	 * @return
	 */
	@Action(value = "findBrandById", results = { @Result(name = "json", type = "json") })
	public String findBrandById() {
		if (Validate.StrNotNull(this.getBrandid())) {
			bean = this.getBrandTService().findBrandById(this.getBrandid().trim());
			if (bean != null) {
				//bean.setLogoPath(BaseTools.getBasePath()+bean.getLogoPath());
				GoodsTypeBrandT gtbt=this.getGoodsTypeBrandTService().findGoodsTypeIdByBrandid(bean.getBrandid());
				if(gtbt==null){
					this.setSucflag(false);
				}else{
					this.setGoodsTypeId(gtbt.getGoodsTypeId());
					this.setSucflag(true);
					return "json";
				}
				
			}
		}
		return "json";
	}

	/**
	 * 批量删除品牌
	 * 
	 * @return
	 */
	@Action(value = "delBrandt", results = { @Result(name = "json", type = "json") })
	public String delBrandt() {
		if (StringUtils.isNotBlank(this.getBrandid())) {
			String[] strs = StringUtils.split(this.getBrandid(), ",");
			this.getBrandTService().delBrandt(strs, BaseTools.adminCreateId());
			this.setSucflag(true);
			return "json";
		}
		return "json";

	}

	/**
	 * 获取所有品牌json
	 * 
	 * @return
	 */
	@Action(value = "findAllBrandtjson", results = { @Result(name = "json", type = "json") })
	public String findAllBrandtjson() {
		this.setBrandjson("");
		this.brand = this.getBrandTService().findAllBrandt();
		if (this.brand != null) {
			for (Iterator it = this.brand.iterator(); it.hasNext();) {
				BrandT b = (BrandT) it.next();
				this.brandjson += "<option value='" + b.getBrandid() + "'>" + b.getBrandname() + "</option>";
			}
			this.setBrandjson(brandjson);
			this.setSucflag(true);
			return "json";
		}
		return "json";

	}
	
	
}
