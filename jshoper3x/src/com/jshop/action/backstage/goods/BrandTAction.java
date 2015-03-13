package com.jshop.action.backstage.goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.catalina.valves.CrawlerSessionManagerValve;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.BrandT;
import com.jshop.entity.BrandT_;
import com.jshop.entity.GoodsTypeBrandT;
import com.jshop.service.BrandTService;
import com.jshop.service.GoodsTypeBrandTService;
import com.jshop.service.impl.Serial;
@Namespace("/bk/goods")
@ParentPackage("jshop")
public class BrandTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	@Resource
	private BrandTService brandTService;
	@Resource
	private GoodsTypeBrandTService goodsTypeBrandTService;
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
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;

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



	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
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
	@Action(value = "/addBrandt", results = { @Result(name = "json", type = "json") })
	public String addBrandt() {
		BrandT bt = new BrandT();
		bt.setBrandid(this.getSerial().Serialid(Serial.BRAND));
		bt.setBrandname(this.getBrandname().trim());
		bt.setCreatorid(BaseTools.getAdminCreateId());
		bt.setUsername(this.getUsername());
		bt.setCreatetime(BaseTools.getSystemTime());
		bt.setIntro(this.getIntro());
		bt.setLogoPath(this.getLogoPath().trim());
		bt.setSort(Integer.parseInt(this.getSort().trim()));
		bt.setUrl(this.getUrl().trim());
		bt.setShopid(BaseTools.getShopId());
		bt.setShopname(BaseTools.getShopName());
		//增加商品品牌和商品类型的关系
		GoodsTypeBrandT gtbt = new GoodsTypeBrandT();
		gtbt.setGoodsTypeBrandTid(this.getSerial().Serialid(Serial.GOODSTYPEBRAND));
		gtbt.setBrandid(bt.getBrandid());
		gtbt.setBrandname(bt.getBrandname());
		gtbt.setGoodsTypeId(this.getGoodsTypeId());
		gtbt.setName(this.getGoodsTypeName());
		this.brandTService.saveBrandTransaction(bt, gtbt);
		this.setSucflag(true);
		return JSON;
	}

	/**
	 * 获取所有品牌
	 * 
	 * @return
	 */
	@Action(value = "/findAllBrandt", results = { @Result(name = "json", type = "json") })
	public String findAllBrandt() {
		if(StringUtils.equals(StaticKey.SC, this.getQtype())){
			this.findDefaultBrand();
		}else{
			if(StringUtils.isBlank(this.getQtype())){
				return JSON;
			}
		}
		return JSON;
	}

	private void findDefaultBrand() {
		int currentPage = page;
		int lineSize = rp;
		total = this.brandTService.count(BrandT.class).intValue();
		if(StringUtils.isNotBlank(this.getSortname())&&StringUtils.isNotBlank(this.getSortorder())){
			Order order=null;
			if(StringUtils.equals(this.getSortorder(), StaticKey.DESC)){
				order=Order.desc(this.getSortname());
			}else{
				order=Order.asc(this.getSortname());
			}
			List<BrandT>list=this.brandTService.findByCriteriaByPage(BrandT.class, order, currentPage, lineSize);
			this.processList(list);
		}
	}

	private void processList(List<BrandT> list) {
		for (Iterator<BrandT> it = list.iterator(); it.hasNext();) {
			BrandT b = (BrandT) it.next();
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", b.getBrandid());
			cellMap.put("cell", new Object[] {b.getShopname(),b.getBrandname(), b.getSort(), BaseTools.formateDbDate(b.getCreatetime()), b.getCreatorid(),"<a id='editbrands' name='editbrands' href='brands.jsp?operate=edit&folder=goods&brandid=" + b.getBrandid()+ "'>[编辑]</a>" });
			rows.add(cellMap);
		}
	}

	/**
	 * 更新品牌信息
	 * 
	 * @return
	 */
	@Action(value = "/updateBrandt", results = { @Result(name = "json", type = "json") })
	public String updateBrandt() {
		if(StringUtils.isBlank(this.getBrandid())){
			return JSON;
		}
		BrandT bt = this.brandTService.findByPK(BrandT.class, this.getBrandid());
		if(bt!=null){
			bt.setBrandname(this.getBrandname().trim());
			bt.setCreatorid(BaseTools.getAdminCreateId());
			bt.setUsername(this.getUsername());
			bt.setCreatetime(BaseTools.getSystemTime());
			bt.setIntro(this.getIntro());
			bt.setLogoPath(this.getLogoPath().trim());
			bt.setSort(Integer.parseInt(this.getSort().trim()));
			bt.setUrl(this.getUrl().trim());
			bt.setShopid(BaseTools.getShopId());
			bt.setShopname(BaseTools.getShopName());
			this.brandTService.update(bt);
			Criterion criterion=Restrictions.and(Restrictions.eq("brandid", bt.getBrandid())).add(Restrictions.eq("goodsTypeId", this.getGoodsTypeId()));
			GoodsTypeBrandT gtb =this.goodsTypeBrandTService.findOneByCriteria(GoodsTypeBrandT.class, criterion);
			if (gtb==null) {
				//增加商品品牌和商品类型的关系
				GoodsTypeBrandT gtbt = new GoodsTypeBrandT();
				gtbt.setGoodsTypeBrandTid(this.getSerial().Serialid(Serial.GOODSTYPEBRAND));
				gtbt.setBrandid(bt.getBrandid());
				gtbt.setBrandname(bt.getBrandname());
				gtbt.setGoodsTypeId(this.getGoodsTypeId());
				gtbt.setName(this.getGoodsTypeName());
				this.goodsTypeBrandTService.save(gtbt);
				this.setSucflag(true);
			}
		}
		return JSON;
	}

	/**
	 * 根据id获取品牌信息
	 * 
	 * @return
	 */
	@Action(value = "/findBrandById", results = { @Result(name = "json", type = "json") })
	public String findBrandById() {
		if (StringUtils.isNotBlank(this.getBrandid())) {
			bean = this.brandTService.findByPK(BrandT.class, this.getBrandid());
			if (bean != null) {
				//bean.setLogoPath(BaseTools.getBasePath()+bean.getLogoPath());
				Criterion criterion=Restrictions.eq("brandid",this.getBrandid());
				GoodsTypeBrandT gtbt=this.goodsTypeBrandTService.findOneByCriteria(GoodsTypeBrandT.class, criterion);
				if(gtbt==null){
					this.setSucflag(false);
				}else{
					this.setGoodsTypeId(gtbt.getGoodsTypeId());
					this.setSucflag(true);
				}
			}
		}
		return JSON;
	}

	/**
	 * 批量删除品牌
	 * 
	 * @return
	 */
	@Action(value = "/delBrandt", results = { @Result(name = "json", type = "json") })
	public String delBrandt() {
		if (StringUtils.isNotBlank(this.getBrandid())) {
			String[] strs = StringUtils.split(this.getBrandid(), StaticKey.SPLITDOT);
			for(String s:strs){
				BrandT bt=this.brandTService.findByPK(BrandT.class, s);
				if(bt!=null){
					this.brandTService.delete(bt);
				}
			}
			this.setSucflag(true);
		}
		return JSON;

	}

	/**
	 * 获取所有品牌json
	 * 
	 * @return
	 */
	@Action(value = "/findAllBrandtjson", results = { @Result(name = "json", type = "json") })
	public String findAllBrandtjson() {
		this.setBrandjson("");
		this.brand = this.brandTService.findAll(BrandT.class);
		if (brand != null) {
			for (Iterator<BrandT> it = this.brand.iterator(); it.hasNext();) {
				BrandT b = (BrandT) it.next();
				this.brandjson += "<option value='" + b.getBrandid() + "'>" + b.getBrandname() + "</option>";
			}
			this.setBrandjson(brandjson);
			this.setSucflag(true);
		}
		return JSON;

	}
	
	
}
