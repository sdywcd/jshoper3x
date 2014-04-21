package com.jshop.action.backstage.goods;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.entity.GoodsDetailRpT;
import com.jshop.service.GoodsDetailRpTService;
@Namespace("")
@ParentPackage("jshop")
public class GoodsDetailRpTAction extends BaseTAction {

	private static final long serialVersionUID = 1L;
	private GoodsDetailRpTService goodsDetailRpTService;
	private String goodsid;
	private GoodsDetailRpT bean=new GoodsDetailRpT();
	private boolean sucflag;
	@JSON(serialize = false)
	public GoodsDetailRpTService getGoodsDetailRpTService() {
		return goodsDetailRpTService;
	}

	public void setGoodsDetailRpTService(GoodsDetailRpTService goodsDetailRpTService) {
		this.goodsDetailRpTService = goodsDetailRpTService;
	}

	
	public GoodsDetailRpT getBean() {
		return bean;
	}

	public void setBean(GoodsDetailRpT bean) {
		this.bean = bean;
	}

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
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
	@Action(value = "findGoodsDetialRpTBygoodsid", results = { @Result(name = "json", type = "json") })
	public String findGoodsDetialRpTBygoodsid(){
		if(StringUtils.isNotBlank(this.getGoodsid())){
			bean=this.getGoodsDetailRpTService().findGoodsDetailRpBygoodsid(this.getGoodsid());
			if(bean!=null){
				this.setSucflag(true);
				return "json";
			}
		}
		return "json";
		
	}
	
	
}
