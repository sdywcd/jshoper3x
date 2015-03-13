package com.jshop.action.backstage.goods;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.annotation.Reference;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.entity.GoodsAttributeRpT;
import com.jshop.service.GoodsAttributeRpTService;
@Namespace("")
@ParentPackage("jshop")
public class GoodsAttributeRpTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	@Resource
	private GoodsAttributeRpTService goodsAttributeRpTService;
	private String goodsid;
	private String goodsAttrsVals;
	private List<GoodsAttributeRpT> beanlist=new ArrayList<GoodsAttributeRpT>();
	private boolean sucflag;
	
	public String getGoodsAttrsVals() {
		return goodsAttrsVals;
	}
	public void setGoodsAttrsVals(String goodsAttrsVals) {
		this.goodsAttrsVals = goodsAttrsVals;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	
	public List<GoodsAttributeRpT> getBeanlist() {
		return beanlist;
	}
	public void setBeanlist(List<GoodsAttributeRpT> beanlist) {
		this.beanlist = beanlist;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	
	
	@Action(value = "findGoodsAttributeRpTBygoodsid", results = { 
			@Result(name = "json",type="json",params = { "excludeNullProperties", "true" })
	})
	public String findGoodsAttributeRpTBygoodsid(){
		if(StringUtils.isNotBlank(this.getGoodsid())){
			Criterion criterion=Restrictions.eq("goodsid", this.getGoodsid());
			List<GoodsAttributeRpT>list=this.goodsAttributeRpTService.findByCriteria(GoodsAttributeRpT.class, criterion);
			if(!list.isEmpty()){
				beanlist=list;
				this.setSucflag(true);
			}
		}
		return JSON;
	}
	

	
	
}
