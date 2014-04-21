package com.jshop.action.backstage.androidclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;

import com.google.gson.Gson;
import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.entity.GoodsT;
import com.jshop.service.GoodsCategoryTService;
import com.jshop.service.GoodsTService;
@Namespace("")
@ParentPackage("jshop")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})

public class AndroidGoodsTAction extends BaseTAction implements
ServletRequestAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private GoodsTService goodsTService;
	private GoodsCategoryTService goodsCategoryTService;
	private HttpServletRequest request;
    private HttpServletResponse response;
	private List<GoodsT>beanlist=new ArrayList<GoodsT>();
	private String goodsCategoryTid;
	private String creatorid;
	private String goodsid;
	private String navid;
	private String salestate;
	private int rp;
	private int page=1;
	private int total=0;
	private String responsejsonstr;
    private boolean sucflag;
    
    @JSON(serialize = false)
    public GoodsCategoryTService getGoodsCategoryTService() {
		return goodsCategoryTService;
	}
	public void setGoodsCategoryTService(GoodsCategoryTService goodsCategoryTService) {
		this.goodsCategoryTService = goodsCategoryTService;
	}
	@JSON(serialize = false)
	public GoodsTService getGoodsTService() {
		return goodsTService;
	}
	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	
	public List<GoodsT> getBeanlist() {
		return beanlist;
	}
	public void setBeanlist(List<GoodsT> beanlist) {
		this.beanlist = beanlist;
	}
	public String getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
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
	
	public String getResponsejsonstr() {
		return responsejsonstr;
	}
	public void setResponsejsonstr(String responsejsonstr) {
		this.responsejsonstr = responsejsonstr;
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
	
	public String getNavid() {
		return navid;
	}
	public void setNavid(String navid) {
		this.navid = navid;
	}
	public String getSalestate() {
		return salestate;
	}
	public void setSalestate(String salestate) {
		this.salestate = salestate;
	}

	public String getGoodsCategoryTid() {
		return goodsCategoryTid;
	}
	public void setGoodsCategoryTid(String goodsCategoryTid) {
		this.goodsCategoryTid = goodsCategoryTid;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	

	
	

	/**
	 * 根据商品id获取商品数据
	 * 
	 * @return
	 * @throws IOException 
	 */
	@Action(value = "findGoodsByIdAndroid", results = { @Result(name = "json", type = "json",params = { "excludeNullProperties", "true"}) })
	public String findGoodsById() throws IOException {

		if (StringUtils.isNotBlank(this.getGoodsid())) {
			GoodsT bean=new GoodsT();
			bean = this.getGoodsTService().findGoodsById(this.getGoodsid().trim());
			Gson gs=new Gson();
			this.setResponsejsonstr(gs.toJson(bean));
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.write(this.getResponsejsonstr());
		out.flush();
		out.close();
		this.setSucflag(false);
		return "json";

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
