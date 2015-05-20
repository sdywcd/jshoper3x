package com.jshop.action.mall.backstage.goods;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jshop.action.mall.backstage.base.BaseTAction;
import com.jshop.action.mall.backstage.utils.BaseTools;
import com.jshop.action.mall.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GoodsTypeTN;
import com.jshop.service.GoodsTypeTNService;
import com.jshop.service.impl.Serial;
@Namespace("")
@ParentPackage("jshop")
//@InterceptorRefs({  
//    @InterceptorRef("goodsmoduleGoodsTypeTNInterecptor"),  
//    @InterceptorRef("defaultStack")
//})
public class GoodsTypeTNAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	@Resource
	private GoodsTypeTNService goodsTypeTNService;
	private String goodsTypeId;
	private String name;
	private Date createtime;
	private String creatorid;
	private String goodsParameter;
	private GoodsTypeTN bean;
	private List<GoodsTypeTN> beanlist=new ArrayList<GoodsTypeTN>();;
	private String goodstypetnlist;
	private List<Map<String,Object>> rows=new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;

	
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

	public String getGoodsParameter() {
		return goodsParameter;
	}

	public void setGoodsParameter(String goodsParameter) {
		this.goodsParameter = goodsParameter;
	}

	public GoodsTypeTN getBean() {
		return bean;
	}

	public void setBean(GoodsTypeTN bean) {
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


	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getGoodstypetnlist() {
		return goodstypetnlist;
	}

	public void setGoodstypetnlist(String goodstypetnlist) {
		this.goodstypetnlist = goodstypetnlist;
	}

	public List<GoodsTypeTN> getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(List<GoodsTypeTN> beanlist) {
		this.beanlist = beanlist;
	}


	/**
	 *清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加商品类型
	 * 
	 * @return
	 */
	@Action(value = "addGoodsTypeTN", results = { @Result(name = "json", type = "json") })
	public String addGoodsTypeTN() {
		if(StringUtils.isBlank(this.getName())){
			return JSON;
		}
		Criterion criterion=Restrictions.eq("name", this.getName());
		List<GoodsTypeTN> list=this.goodsTypeTNService.findByCriteria(GoodsTypeTN.class, criterion);
		if(list.isEmpty()){
			GoodsTypeTN gtn = new GoodsTypeTN();
			gtn.setGoodsTypeId(this.getSerial().Serialid(Serial.GOODSTYPE));
			gtn.setName(this.getName().trim());
			gtn.setCreatetime(BaseTools.getSystemTime());
			gtn.setCreatorid(BaseTools.getAdminCreateId());
			if(StringUtils.isBlank(this.getGoodsParameter())){
				gtn.setGoodsParameter(StaticKey.EMPTY);
			}else{
				gtn.setGoodsParameter(this.getGoodsParameter());
			}
			this.goodsTypeTNService.save(gtn);
			this.setSucflag(true);
			return JSON;
		}
		return JSON;
	}

	/**
	 * 增加商品类型参数
	 * @return
	 */
	@Action(value = "addgoodsParameter", results = { @Result(name = "json", type = "json") })
	public String addgoodsParameter() {
		if(StringUtils.isBlank(this.getName())){
			//this.setSucflag(true);
			return JSON;
		}
		Criterion criterion=Restrictions.eq("name", this.getName());
		GoodsTypeTN gtn=this.goodsTypeTNService.findOneByCriteria(GoodsTypeTN.class, criterion);
		if(gtn!=null){
			gtn.setGoodsParameter(this.getGoodsParameter());
			this.goodsTypeTNService.update(gtn);
			this.setSucflag(true);
		}
		return JSON;
	}

	/**
	 * 获取所有商品类型
	 * 
	 * @return
	 */
	@Action(value = "findAllGoodsTypeTN", results = { @Result(name = "json", type = "json") })
	public String findAllGoodsTypeTN() {
		if (StaticKey.SC.equals(this.getQtype())) {
			findDefaultAllGoodsTypeTN();
		} else {
			if (StringUtils.isNotBlank(this.getQtype())) {
				return JSON;
			} else {
				if(this.getQtype().equals("name")){
					findGoodsTypeTNByParams();
				}
				return JSON;
			}
		}
		return JSON;
	}

	

	public void processGoodsTypeTNList(List<GoodsTypeTN> list) {
		for (Iterator<GoodsTypeTN> it = list.iterator(); it.hasNext();) {
			GoodsTypeTN gtn = it.next();
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", gtn.getGoodsTypeId());
			cellMap.put("cell", new Object[] {gtn.getName(), BaseTools.formateDbDate(gtn.getCreatetime()),"<a id='editegoodstypetn' name='editegoodstypetn' href='goodstypetn.jsp?operate=edit&folder=goods&goodsTypeId=" + gtn.getGoodsTypeId() + "'>[编辑]</a>" });
			rows.add(cellMap);
		}
	}
	
	private void findGoodsTypeTNByParams() {
		int currentPage = page;
		int lineSize = rp;
		Criterion criterion=Restrictions.like(this.getQtype(), this.getQuery().trim(), MatchMode.ANYWHERE);
		total = this.goodsTypeTNService.count(GoodsTypeTN.class, criterion).intValue();
		if(StringUtils.isNotBlank(this.getSortname())&&StringUtils.isNotBlank(this.getSortorder())){
			Order order=null;
			if(StringUtils.equals(this.getSortorder(), StaticKey.ASC)){
				order=Order.asc(this.getSortname());
			}else{
				order=Order.desc(this.getSortname());
			}
			List<GoodsTypeTN>list=this.goodsTypeTNService.findByCriteriaByPage(GoodsTypeTN.class, criterion, order, currentPage, lineSize);
			this.processGoodsTypeTNList(list);
		}
	}
	public void findDefaultAllGoodsTypeTN() {
		int currentPage = page;
		int lineSize = rp;
		total = this.goodsTypeTNService.count(GoodsTypeTN.class).intValue();
		if(StringUtils.isNotBlank(this.getSortname())&&StringUtils.isNotBlank(this.getSortorder())){
			Order order=null;
			if(StringUtils.equals(this.getSortorder(), StaticKey.ASC)){
				order=Order.asc(this.getSortname());
			}else{
				order=Order.desc(this.getSortname());
			}
			List<GoodsTypeTN>list=this.goodsTypeTNService.findByCriteriaByPage(GoodsTypeTN.class,order, currentPage, lineSize);
			this.processGoodsTypeTNList(list);
		}
	}

	/**
	 * 根据id获取商品类型
	 * 
	 * @return
	 */
	@Action(value = "findGoodsTypeTNById", results = { @Result(name = "json", type = "json") })
	public String findGoodsTypeTNById() {
		if (StringUtils.isNotBlank(this.getGoodsTypeId())) {
			bean=this.goodsTypeTNService.findByPK(GoodsTypeTN.class, this.getGoodsTypeId());
			if(bean!=null){
				this.setSucflag(true);
			}
		}
		return JSON;
	}

	/**
	 * 更新商品类型
	 * 
	 * @return
	 */
	@Action(value = "updateGoodsTypeTN", results = { @Result(name = "json", type = "json") })
	public String updateGoodsTypeTN() {
		if(StringUtils.isBlank(this.getGoodsTypeId())){
			return JSON;
		}
		GoodsTypeTN gtn = this.goodsTypeTNService.findByPK(GoodsTypeTN.class, this.getGoodsTypeId());
		if(gtn!=null){
			gtn.setGoodsTypeId(this.getGoodsTypeId().trim());
			gtn.setName(this.getName());
			gtn.setCreatetime(BaseTools.getSystemTime());
			gtn.setCreatorid(BaseTools.getAdminCreateId());
			gtn.setGoodsParameter(this.getGoodsParameter());
			this.goodsTypeTNService.update(gtn);
			this.setSucflag(true);
		}
		return JSON;
	}

	/**
	 * 删除商品类型
	 * 
	 * @return
	 */
	@Action(value = "delGoodsTypeTN", results = { @Result(name = "json", type = "json") })
	public String delGoodsTypeTN() {
		if (StringUtils.isNotBlank(this.getGoodsTypeId())) {
			String[] strs = StringUtils.split(this.getGoodsTypeId(), StaticKey.SPLITDOT);
			for(String s:strs){
				GoodsTypeTN gtn=this.goodsTypeTNService.findByPK(GoodsTypeTN.class, s);
				if(gtn!=null){
					this.goodsTypeTNService.delete(gtn);
				}
			}
			this.setSucflag(true);
		}
		return JSON;
	}

	@Action(value = "findGoodsTypeTNForSelect", results = { @Result(name = "json", type = "json") })
	public String findGoodsTypeTNForSelect() {
		this.setGoodstypetnlist(StaticKey.EMPTY);
		List<GoodsTypeTN> list = this.goodsTypeTNService.findAll(GoodsTypeTN.class);
		if (list != null) {
			this.setGoodstypetnlist("<option value='0'>---请选择---</option>");
			for (Iterator<GoodsTypeTN> it = list.iterator(); it.hasNext();) {
				GoodsTypeTN gtn =it.next();
				this.goodstypetnlist += "<option value='" + gtn.getGoodsTypeId() + "'>" + gtn.getName() + "</option>";
			}
			this.setGoodstypetnlist(goodstypetnlist);
			return JSON;
		}
		this.setGoodstypetnlist(StaticKey.EMPTY);
		return JSON;

	}

	/**
	 * 获取商品参数
	 * 
	 * @return
	 */
	@Action(value = "findGoodsParameter", results = { @Result(name = "json", type = "json") })
	public String findGoodsParameter() {
		if(StringUtils.isNotBlank(this.getGoodsTypeId())){
			bean=this.goodsTypeTNService.findByPK(GoodsTypeTN.class, this.getGoodsTypeId());
			if(bean!=null){
				this.setSucflag(true);
			}
		}
		return JSON;

	}

}
