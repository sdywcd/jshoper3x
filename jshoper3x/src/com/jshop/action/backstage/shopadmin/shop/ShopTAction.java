package com.jshop.action.backstage.shopadmin.shop;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.entity.JshopbasicInfoT;
import com.jshop.service.JshopbasicInfoTService;
@Namespace("/shopadmin")
@ParentPackage("jshop")
public class ShopTAction extends BaseTAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private JshopbasicInfoTService jshopbasicInfoTService;
	
	private JshopbasicInfoT bean=new JshopbasicInfoT();
	private boolean sucflag;
	
	public boolean isSucflag() {
		return sucflag;
	}


	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}


	public JshopbasicInfoT getBean() {
		return bean;
	}


	public void setBean(JshopbasicInfoT bean) {
		this.bean = bean;
	}


	/**
	 * 查询店铺信息
	 * @return
	 */
	@Action(value = "/findShopInfo", results = { @Result(name = "json", type = "json") })
	public String findShopInfo(){
		String shopId=BaseTools.getShopId();
		bean=this.jshopbasicInfoTService.findByPK(JshopbasicInfoT.class, shopId);
		if(bean!=null){
			this.setSucflag(true);
		}
		return JSON;
	}
	
}
