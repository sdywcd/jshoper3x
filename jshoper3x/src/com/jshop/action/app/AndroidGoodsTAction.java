package com.jshop.action.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GoodsCategoryT;
import com.jshop.entity.GoodsT;
import com.jshop.service.GoodsCategoryTService;
import com.jshop.service.GoodsTService;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.utility.StringUtil;
@Namespace("/app")
@ParentPackage("jshop")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})

public class AndroidGoodsTAction extends ActionSupport implements
ServletRequestAware, ServletResponseAware {
	@Resource
	private GoodsTService goodsTService;
	@Resource
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
	 * 根据商品分类id获取旗下所有商品信息
	 * @throws IOException 
	 */
	@Action(value="findrecommendedGoods")
	public void findrecommendedGoods() throws IOException{
		int lineSize=10;;
		List<GoodsT>list=this.getGoodsTService().findrecommendedGoodsT(StaticKey.ONE, StaticKey.ONE, lineSize);
		Gson gson=new Gson();
		String jsonstr=gson.toJson(list);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.write(jsonstr);
		out.flush();
		out.close();
	}
	
	
	/**
	 * 获取商品分类给手机端
	 * @throws IOException
	 */
	@Action(value="findAllGoodsCategoryTforAndroid")
	public void findAllGoodsCategoryTforAndroid() throws IOException{
		String state="1";//表示显示的商品分类
		List<GoodsCategoryT>list=this.getGoodsCategoryTService().findAllGoodsCategoryT(state);
		StringBuilder json=new StringBuilder();
		json.append("[");
		for(Iterator it=list.iterator();it.hasNext();){
			GoodsCategoryT gct=(GoodsCategoryT)it.next();
			json.append("{");
			json.append("\"goodsCategoryTid\":\"").append(gct.getGoodsCategoryTid()).append("\",");
			json.append("\"grade\":\"").append(gct.getGrade()).append("\",");
			json.append("\"metaKeywords\":\"").append(gct.getMetaKeywords()).append("\",");
			json.append("\"metaDes\":\"").append(gct.getMetaDes()).append("\",");
			json.append("\"name\":\"").append(gct.getName()).append("\",");
			json.append("\"state\":\"").append(gct.getState()).append("\",");
			json.append("\"path\":\"").append(gct.getPath()).append("\",");
			json.append("\"sort\":\"").append(gct.getSort()).append("\",");
			json.append("\"sign\":\"").append(gct.getSign()).append("\",");
			json.append("\"goodsTypeId\":\"").append(gct.getGoodsTypeId()).append("\",");
			json.append("\"parentId\":\"").append(gct.getParentId()).append("\",");
			json.append("\"createtime\":\"").append(BaseTools.formateDbDate(gct.getCreatetime())).append("\",");
			json.append("\"creatorid\":\"").append(gct.getCreatorid()).append("\",");
			json.append("\"parentName\":\"").append(gct.getParentName()).append("\",");
			json.append("\"htmlpath\":\"").append(gct.getHtmlpath()).append("\"");
			json.append("},");
		}
		json.deleteCharAt(json.length()-1);
		json.append("]");
		this.setResponsejsonstr(json.toString());
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.write(this.getResponsejsonstr());
		out.flush();
		out.close();
	}
	
	/**
	 * 查询商品给手机客户端
	 * @throws IOException 
	 */
	@Action(value="findAllGoodsByismobileplatformgoodsforAndroid")
	public void findAllGoodsByismobileplatformgoodsforAndroid() throws IOException{
		if(Validate.StrNotNull(this.getNavid())&&Validate.StrNotNull(this.getSalestate())){
			beanlist=this.getGoodsTService().findAllGoodsBynavid(navid, salestate);
			if(!beanlist.isEmpty()){
				String temp=null;
				String []temparray=null;
				StringBuilder json=new StringBuilder();
				json.append("[");
				for(Iterator it=beanlist.iterator();it.hasNext();){
					GoodsT gt=(GoodsT)it.next();
					temparray=StringUtil.split(gt.getPictureurl(), ',');
					temp=temparray[0];
					gt.setPictureurl(temp);
					json.append("{");
					json.append("\"goodsid\":\"").append(gt.getGoodsid()).append("\",");
					json.append("\"goodsname\":\"").append(gt.getGoodsname()).append("\",");
					json.append("\"brandname\":\"").append(gt.getBrandname()).append("\",");
					json.append("\"nname\":\"").append(gt.getNname()).append("\",");
					json.append("\"lname\":\"").append(gt.getLname()).append("\",");
					json.append("\"sname\":\"").append(gt.getSname()).append("\",");
					json.append("\"fname\":\"").append(gt.getFname()).append("\",");
					json.append("\"navid\":\"").append(gt.getNavid()).append("\",");
					json.append("\"ltypeid\":\"").append(gt.getLtypeid()).append("\",");
					json.append("\"stypeid\":\"").append(gt.getStypeid()).append("\",");
					json.append("\"price\":\"").append(gt.getPrice()).append("\",");
					json.append("\"memberprice\":\"").append(gt.getMemberprice()).append("\",");
					json.append("\"pictureurl\":\"").append(gt.getPictureurl()).append("\",");
					json.append("\"quantity\":\"").append(gt.getQuantity()).append("\",");
					json.append("\"salestate\":\"").append(gt.getSalestate()).append("\",");
					//json.append("\"detail\":\"").append(gt.getDetail()).append("\",");
					json.append("\"unitname\":\"").append(gt.getUnitname()).append("\",");
					json.append("\"keywordname\":\"").append(gt.getKeywordname()).append("\",");
					json.append("\"weight\":\"").append(gt.getWeight()).append("\",");
					json.append("\"readcount\":\"").append(gt.getReadcount()).append("\",");
					json.append("\"relatedproductid\":\"").append(gt.getRelatedproductid()).append("\",");
					json.append("\"recommended\":\"").append(gt.getRecommended()).append("\",");
					json.append("\"hotsale\":\"").append(gt.getHotsale()).append("\",");
					json.append("\"bargainprice\":\"").append(gt.getBargainprice()).append("\",");
					json.append("\"sort\":\"").append(gt.getSort()).append("\",");
					json.append("\"createtime\":\"").append(gt.getCreatetime()).append("\",");
					json.append("\"creatorid\":\"").append(gt.getCreatorid()).append("\",");
					json.append("\"replycount\":\"").append(gt.getReplycount()).append("\",");
					json.append("\"brandid\":\"").append(gt.getBrandid()).append("\",");
					json.append("\"placeStore\":\"").append(gt.getPlaceStore()).append("\",");
					json.append("\"metaKeywords\":\"").append(gt.getMetaKeywords()).append("\",");
					json.append("\"metaDescription\":\"").append(gt.getMetaDescription()).append("\",");
					json.append("\"cost\":\"").append(gt.getCost()).append("\",");
					json.append("\"saleprice\":\"").append(gt.getSaleprice()).append("\",");
					json.append("\"isNew\":\"").append(gt.getIsNew()).append("\",");
					json.append("\"htmlPath\":\"").append(gt.getHtmlPath()).append("\",");
					json.append("\"productSn\":\"").append(gt.getPrice()).append("\",");
					//json.append("\"goodsParameterValue\":\"").append(gt.getGoodsParameterValue()).append("\",");
					//json.append("\"freezeStore\":\"").append(gt.getFreezeStore()).append("\",");
					json.append("\"keywordid\":\"").append(gt.getKeywordid()).append("\",");
					json.append("\"unitnameid\":\"").append(gt.getUnitnameid()).append("\",");
					json.append("\"goodsTypeId\":\"").append(gt.getGoodsTypeId()).append("\",");
					json.append("\"goodsTypeName\":\"").append(gt.getGoodsTypeName()).append("\",");
//					json.append("\"goodsAttrVal0\":\"").append(gt.getGoodsAttrVal0()).append("\",");
//					json.append("\"goodsAttrVal1\":\"").append(gt.getGoodsAttrVal1()).append("\",");
//					json.append("\"goodsAttrVal2\":\"").append(gt.getGoodsAttrVal2()).append("\",");
//					json.append("\"goodsAttrVal3\":\"").append(gt.getGoodsAttrVal3()).append("\",");
//					json.append("\"goodsAttrVal4\":\"").append(gt.getGoodsAttrVal4()).append("\",");
//					json.append("\"goodsAttrVal5\":\"").append(gt.getGoodsAttrVal5()).append("\",");
//					json.append("\"goodsAttrVal6\":\"").append(gt.getGoodsAttrVal6()).append("\",");
//					json.append("\"goodsAttrVal7\":\"").append(gt.getGoodsAttrVal7()).append("\",");
//					json.append("\"goodsAttrVal8\":\"").append(gt.getGoodsAttrVal8()).append("\",");
//					json.append("\"goodsAttrVal9\":\"").append(gt.getGoodsAttrVal9()).append("\",");
//					json.append("\"goodsAttrVal10\":\"").append(gt.getGoodsAttrVal10()).append("\",");
//					json.append("\"goodsAttrVal11\":\"").append(gt.getGoodsAttrVal11()).append("\",");
//					json.append("\"goodsAttrVal12\":\"").append(gt.getGoodsAttrVal12()).append("\",");
//					json.append("\"goodsAttrVal13\":\"").append(gt.getGoodsAttrVal13()).append("\",");
//					json.append("\"goodsAttrVal14\":\"").append(gt.getGoodsAttrVal14()).append("\",");
//					json.append("\"goodsAttrVal15\":\"").append(gt.getGoodsAttrVal15()).append("\",");
//					json.append("\"goodsAttrVal16\":\"").append(gt.getGoodsAttrVal16()).append("\",");
//					json.append("\"goodsAttrVal17\":\"").append(gt.getGoodsAttrVal17()).append("\",");
//					json.append("\"goodsAttrVal18\":\"").append(gt.getGoodsAttrVal18()).append("\",");
//					json.append("\"goodsAttrVal19\":\"").append(gt.getGoodsAttrVal19()).append("\",");
//					json.append("\"goodsAttrVal20\":\"").append(gt.getGoodsAttrVal20()).append("\",");
//					json.append("\"goodsAttrVal21\":\"").append(gt.getGoodsAttrVal21()).append("\",");
//					json.append("\"goodsAttrVal22\":\"").append(gt.getGoodsAttrVal22()).append("\",");
//					json.append("\"goodsAttrVal23\":\"").append(gt.getGoodsAttrVal23()).append("\",");
//					json.append("\"goodsAttrVal24\":\"").append(gt.getGoodsAttrVal24()).append("\",");
//					json.append("\"goodsAttrVal25\":\"").append(gt.getGoodsAttrVal25()).append("\",");
//					json.append("\"goodsAttrVal26\":\"").append(gt.getGoodsAttrVal26()).append("\",");
//					json.append("\"goodsAttrVal27\":\"").append(gt.getGoodsAttrVal27()).append("\",");
//					json.append("\"goodsAttrVal28\":\"").append(gt.getGoodsAttrVal28()).append("\",");
//					json.append("\"goodsAttrVal29\":\"").append(gt.getGoodsAttrVal29()).append("\",");
					json.append("\"usersetnum\":\"").append(gt.getUsersetnum()).append("\",");
					json.append("\"isSpecificationsOpen\":\"").append(gt.getIsSpecificationsOpen()).append("\",");
					json.append("\"star\":\"").append(gt.getTotalstar()).append("\",");
					json.append("\"staruser\":\"").append(gt.getTotalstaruser()).append("\",");
					json.append("\"totalcomment\":\"").append(gt.getTotalcomment()).append("\"");
					//json.append("\"virtualsale\":\"").append(gt.getVirtualsale()).append("\",");
					json.append("\"ismobileplatformgoods\":\"").append(gt.getIsmobileplatformgoods()).append("\",");
					json.append("\"sales\":\"").append(gt.getSales()).append("\",");
					json.append("\"realsales\":\"").append(gt.getRealsales()).append("\"");
					json.append("},");
				}
				json.deleteCharAt(json.length()-1);
				json.append("]");
				this.setResponsejsonstr(json.toString());
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				PrintWriter out=response.getWriter();
				out.write(this.getResponsejsonstr());
				out.flush();
				out.close();
			}
		
		}
		
	}
	@Action(value="textJson")
	public void textJson() throws IOException{
		JSONObject jsonObj = new JSONObject(); 
		jsonObj.put("users", "1"); 
		jsonObj.put("u","2"); 
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.write(jsonObj.toJSONString());
		out.flush();
		out.close();
	}
	
	
	/**
	 * 根据商品id查询商品详细给手机客户端
	 * @throws IOException 
	 */
	@Action(value="findGoodsByGoodsidforAndroid")
	public void findGoodsByGoodsidforAndroid() throws IOException{
		if(Validate.StrNotNull(this.getGoodsid())){
			GoodsT gt=new GoodsT();
			gt=this.getGoodsTService().findGoodsById(this.getGoodsid().trim());
			if(gt!=null){
				StringBuilder json=new StringBuilder();
				String temp=null;
				String []temparray=null;
				temparray=gt.getPictureurl().split(",");
				temp=temparray[0];
				gt.setPictureurl(temp);
				json.append("[");
				json.append("{");
				json.append("\"goodsid\":\"").append(gt.getGoodsid()).append("\",");
				json.append("\"goodsname\":\"").append(gt.getGoodsname()).append("\",");
				//json.append("\"brandname\":\"").append(gt.getBrandname()).append("\",");
				//json.append("\"model\":\"").append(gt.getModel()).append("\",");
				json.append("\"nname\":\"").append(gt.getNname()).append("\",");
				json.append("\"lname\":\"").append(gt.getLname()).append("\",");
				//json.append("\"sname\":\"").append(gt.getSname()).append("\",");
				//json.append("\"fname\":\"").append(gt.getFname()).append("\",");
				json.append("\"navid\":\"").append(gt.getNavid()).append("\",");
				//json.append("\"ltypeid\":\"").append(gt.getLtypeid()).append("\",");
				//json.append("\"stypeid\":\"").append(gt.getStypeid()).append("\",");
				json.append("\"price\":\"").append(gt.getPrice()).append("\",");
				json.append("\"memberprice\":\"").append(gt.getMemberprice()).append("\",");
				json.append("\"pictureurl\":\"").append(gt.getPictureurl()).append("\",");
				json.append("\"quantity\":\"").append(gt.getQuantity()).append("\",");
				//json.append("\"salestate\":\"").append(gt.getSalestate()).append("\",");
				//json.append("\"detail\":\"").append(gt.getDetail()).append("\",");
				//json.append("\"unitname\":\"").append(gt.getUnitname()).append("\",");
				//json.append("\"keywordname\":\"").append(gt.getKeywordname()).append("\",");
				json.append("\"weight\":\"").append(gt.getWeight()).append("\",");
				json.append("\"readcount\":\"").append(gt.getReadcount()).append("\",");
				//json.append("\"relatedproductid\":\"").append(gt.getRelatedproductid()).append("\",");
				json.append("\"recommended\":\"").append(gt.getRecommended()).append("\",");
				json.append("\"hotsale\":\"").append(gt.getHotsale()).append("\",");
				json.append("\"bargainprice\":\"").append(gt.getBargainprice()).append("\",");
				json.append("\"sort\":\"").append(gt.getSort()).append("\",");
				//json.append("\"createtime\":\"").append(gt.getCreatetime()).append("\",");
				//json.append("\"creatorid\":\"").append(gt.getCreatorid()).append("\",");
				json.append("\"replycount\":\"").append(gt.getReplycount()).append("\",");
				json.append("\"brandid\":\"").append(gt.getBrandid()).append("\",");
				json.append("\"placeStore\":\"").append(gt.getPlaceStore()).append("\",");
				//json.append("\"metaKeywords\":\"").append(gt.getMetaKeywords()).append("\",");
				json.append("\"metaDescription\":\"").append(gt.getMetaDescription()).append("\",");
				json.append("\"cost\":\"").append(gt.getCost()).append("\",");
				json.append("\"saleprice\":\"").append(gt.getSaleprice()).append("\",");
				json.append("\"isNew\":\"").append(gt.getIsNew()).append("\",");
				//json.append("\"htmlPath\":\"").append(gt.getHtmlPath()).append("\",");
				json.append("\"productSn\":\"").append(gt.getPrice()).append("\",");
				//json.append("\"goodsParameterValue\":\"").append(gt.getGoodsParameterValue()).append("\",");
				//json.append("\"freezeStore\":\"").append(gt.getFreezeStore()).append("\",");
				//json.append("\"keywordid\":\"").append(gt.getKeywordid()).append("\",");
				//json.append("\"unitnameid\":\"").append(gt.getUnitnameid()).append("\",");
				json.append("\"goodsTypeId\":\"").append(gt.getGoodsTypeId()).append("\",");
				json.append("\"goodsTypeName\":\"").append(gt.getGoodsTypeName()).append("\",");
//				json.append("\"goodsAttrVal0\":\"").append(gt.getGoodsAttrVal0()).append("\",");
//				json.append("\"goodsAttrVal1\":\"").append(gt.getGoodsAttrVal1()).append("\",");
//				json.append("\"goodsAttrVal2\":\"").append(gt.getGoodsAttrVal2()).append("\",");
//				json.append("\"goodsAttrVal3\":\"").append(gt.getGoodsAttrVal3()).append("\",");
//				json.append("\"goodsAttrVal4\":\"").append(gt.getGoodsAttrVal4()).append("\",");
//				json.append("\"goodsAttrVal5\":\"").append(gt.getGoodsAttrVal5()).append("\",");
//				json.append("\"goodsAttrVal6\":\"").append(gt.getGoodsAttrVal6()).append("\",");
//				json.append("\"goodsAttrVal7\":\"").append(gt.getGoodsAttrVal7()).append("\",");
//				json.append("\"goodsAttrVal8\":\"").append(gt.getGoodsAttrVal8()).append("\",");
//				json.append("\"goodsAttrVal9\":\"").append(gt.getGoodsAttrVal9()).append("\",");
//				json.append("\"goodsAttrVal10\":\"").append(gt.getGoodsAttrVal10()).append("\",");
//				json.append("\"goodsAttrVal11\":\"").append(gt.getGoodsAttrVal11()).append("\",");
//				json.append("\"goodsAttrVal12\":\"").append(gt.getGoodsAttrVal12()).append("\",");
//				json.append("\"goodsAttrVal13\":\"").append(gt.getGoodsAttrVal13()).append("\",");
//				json.append("\"goodsAttrVal14\":\"").append(gt.getGoodsAttrVal14()).append("\",");
//				json.append("\"goodsAttrVal15\":\"").append(gt.getGoodsAttrVal15()).append("\",");
//				json.append("\"goodsAttrVal16\":\"").append(gt.getGoodsAttrVal16()).append("\",");
//				json.append("\"goodsAttrVal17\":\"").append(gt.getGoodsAttrVal17()).append("\",");
//				json.append("\"goodsAttrVal18\":\"").append(gt.getGoodsAttrVal18()).append("\",");
//				json.append("\"goodsAttrVal19\":\"").append(gt.getGoodsAttrVal19()).append("\",");
//				json.append("\"goodsAttrVal20\":\"").append(gt.getGoodsAttrVal20()).append("\",");
//				json.append("\"goodsAttrVal21\":\"").append(gt.getGoodsAttrVal21()).append("\",");
//				json.append("\"goodsAttrVal22\":\"").append(gt.getGoodsAttrVal22()).append("\",");
//				json.append("\"goodsAttrVal23\":\"").append(gt.getGoodsAttrVal23()).append("\",");
//				json.append("\"goodsAttrVal24\":\"").append(gt.getGoodsAttrVal24()).append("\",");
//				json.append("\"goodsAttrVal25\":\"").append(gt.getGoodsAttrVal25()).append("\",");
//				json.append("\"goodsAttrVal26\":\"").append(gt.getGoodsAttrVal26()).append("\",");
//				json.append("\"goodsAttrVal27\":\"").append(gt.getGoodsAttrVal27()).append("\",");
//				json.append("\"goodsAttrVal28\":\"").append(gt.getGoodsAttrVal28()).append("\",");
//				json.append("\"goodsAttrVal29\":\"").append(gt.getGoodsAttrVal29()).append("\",");
				json.append("\"usersetnum\":\"").append(gt.getUsersetnum()).append("\",");
				json.append("\"isSpecificationsOpen\":\"").append(gt.getIsSpecificationsOpen()).append("\",");
				json.append("\"star\":\"").append(gt.getTotalstar()).append("\",");
				json.append("\"staruser\":\"").append(gt.getTotalstaruser()).append("\",");
				json.append("\"totalcomment\":\"").append(gt.getTotalcomment()).append("\",");
				//json.append("\"virtualsale\":\"").append(gt.getVirtualsale()).append("\",");
				json.append("\"ismobileplatformgoods\":\"").append(gt.getIsmobileplatformgoods()).append("\",");
				json.append("\"sales\":\"").append(gt.getSales()).append("\",");
				json.append("\"realsales\":\"").append(gt.getRealsales()).append("\"");
				json.append("}]");
				this.setResponsejsonstr(json.toString());
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				PrintWriter out=response.getWriter();
				out.write(this.getResponsejsonstr());
				out.flush();
				out.close();
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
