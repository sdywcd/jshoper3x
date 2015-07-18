package com.jshop.action.mall.backstage.goods;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.jshop.action.mall.backstage.base.BaseTAction;
import com.jshop.entity.GoodsDetailRpT;
import com.jshop.entity.GoodsGroupDetailRpT;
import com.jshop.service.GoodsDetailRpTService;
import com.jshop.service.GoodsGroupDetailRpTService;
@Namespace("")
@ParentPackage("jshop")
public class GoodsGroupDetailRpTAction extends BaseTAction {

	private static final long serialVersionUID = 1L;
	@Resource
	private GoodsGroupDetailRpTService goodsGroupDetailRpTService;
	private String groupid;
	private GoodsGroupDetailRpT bean=new GoodsGroupDetailRpT();
	private boolean sucflag;
	
	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public GoodsGroupDetailRpT getBean() {
		return bean;
	}

	public void setBean(GoodsGroupDetailRpT bean) {
		this.bean = bean;
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
	/**
	 * 根据goodsid获取商品详细
	 * @return
	 */
	@Action(value = "findGoodsGroupDetialRpTBygroupid", results = { @Result(name = "json", type = "json") })
	public String findGoodsGroupDetialRpTBygroupid(){
		if(StringUtils.isNotBlank(this.getGroupid())){
			Criterion criterion=Restrictions.eq("groupid", this.getGroupid());
			bean=this.goodsGroupDetailRpTService.findOneByCriteria(GoodsGroupDetailRpT.class, criterion);
			if(bean!=null){
				this.setSucflag(true);
			}
		}
		return JSON;
	}
	
	
}
