package com.jshop.action.mall.backstage.goods;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.jshop.action.mall.backstage.base.BaseTAction;
import com.jshop.entity.GoodsGroupAttributeRpT;
import com.jshop.service.GoodsGroupAttributeRpTService;
@Namespace("")
@ParentPackage("jshop")
public class GoodsGroupAttributeRpTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	@Resource
	private GoodsGroupAttributeRpTService goodsGroupAttributeRpTService;
	private String attrval;
	private String groupid;
	private List<GoodsGroupAttributeRpT> beanlist=new ArrayList<GoodsGroupAttributeRpT>();
	private boolean sucflag;
	
	
	public String getAttrval() {
		return attrval;
	}


	public void setAttrval(String attrval) {
		this.attrval = attrval;
	}


	public String getGroupid() {
		return groupid;
	}


	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}


	public List<GoodsGroupAttributeRpT> getBeanlist() {
		return beanlist;
	}


	public void setBeanlist(List<GoodsGroupAttributeRpT> beanlist) {
		this.beanlist = beanlist;
	}


	public boolean isSucflag() {
		return sucflag;
	}


	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}


	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	
	
	@Action(value = "findGoodsGroupAttributeRpTBygroupid", results = { 
			@Result(name = "json",type="json",params = { "excludeNullProperties", "true" })
	})
	public String findGoodsAttributeRpTBygoodsid(){
		if(StringUtils.isNotBlank(this.getGroupid())){
			Criterion criterion=Restrictions.eq("groupid", this.getGroupid());
			List<GoodsGroupAttributeRpT>list=this.goodsGroupAttributeRpTService.findByCriteria(GoodsGroupAttributeRpT.class, criterion);					
			if(!list.isEmpty()){
				beanlist=list;
				this.setSucflag(true);
			}
		}
		return JSON;
	}
	

	
	
}
