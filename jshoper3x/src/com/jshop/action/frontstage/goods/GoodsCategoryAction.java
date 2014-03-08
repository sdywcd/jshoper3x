package com.jshop.action.frontstage.goods;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.template.DataCollectionTAction;
import com.jshop.action.backstage.template.FreeMarkervariable;
import com.jshop.action.backstage.tools.PageModel;
import com.jshop.entity.ArticleCategoryT;
import com.jshop.entity.GoodsCategoryT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.JshopbasicInfoT;
import com.jshop.entity.SiteNavigationT;
import com.jshop.service.ArticleCategoryTService;
import com.jshop.service.ArticleTService;
import com.jshop.service.GoodsCategoryTService;
import com.jshop.service.GoodsTService;
import com.jshop.service.JshopbasicInfoTService;
import com.jshop.service.SiteNavigationTService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class GoodsCategoryAction extends ActionSupport{
	private GoodsTService goodsTService;
	private SiteNavigationTService siteNavigationTService;
	private GoodsCategoryTService goodsCategoryTService;
	private ArticleCategoryTService articleCategoryTService;
	private ArticleTService articleTService;
	private JshopbasicInfoTService jshopbasicInfoTService;
	private DataCollectionTAction dataCollectionTAction;
	private Map<String,Object>map=new HashMap<String,Object>();
	private List<GoodsT>goodsList;
	private String navid;
	private String ltypeid;
	private String stypeid;
	private String cp;
    private String ls;
    private String goodsname;
    private String topKeywords;
    private int rp=4;//每页显示数量
	private int page = 1;
	private int total = 0;
	private int totalpage=1;
   
    public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}
	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}
	@JSON(serialize = false)
	public GoodsTService getGoodsTService() {
		return goodsTService;
	}
	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}
	@JSON(serialize = false)
	public SiteNavigationTService getSiteNavigationTService() {
		return siteNavigationTService;
	}
	public void setSiteNavigationTService(SiteNavigationTService siteNavigationTService) {
		this.siteNavigationTService = siteNavigationTService;
	}
	@JSON(serialize = false)
	public GoodsCategoryTService getGoodsCategoryTService() {
		return goodsCategoryTService;
	}
	public void setGoodsCategoryTService(GoodsCategoryTService goodsCategoryTService) {
		this.goodsCategoryTService = goodsCategoryTService;
	}
	@JSON(serialize = false)
	public ArticleCategoryTService getArticleCategoryTService() {
		return articleCategoryTService;
	}
	public void setArticleCategoryTService(ArticleCategoryTService articleCategoryTService) {
		this.articleCategoryTService = articleCategoryTService;
	}
	@JSON(serialize = false)
	public ArticleTService getArticleTService() {
		return articleTService;
	}
	public void setArticleTService(ArticleTService articleTService) {
		this.articleTService = articleTService;
	}
	@JSON(serialize = false)
	public JshopbasicInfoTService getJshopbasicInfoTService() {
		return jshopbasicInfoTService;
	}
	public void setJshopbasicInfoTService(JshopbasicInfoTService jshopbasicInfoTService) {
		this.jshopbasicInfoTService = jshopbasicInfoTService;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public List<GoodsT> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<GoodsT> goodsList) {
		this.goodsList = goodsList;
	}
	public String getNavid() {
		return navid;
	}
	public void setNavid(String navid) {
		this.navid = navid;
	}
	public String getLtypeid() {
		return ltypeid;
	}
	public void setLtypeid(String ltypeid) {
		this.ltypeid = ltypeid;
	}
	public String getStypeid() {
		return stypeid;
	}
	public void setStypeid(String stypeid) {
		this.stypeid = stypeid;
	}

	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	public String getLs() {
		return ls;
	}
	public void setLs(String ls) {
		this.ls = ls;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
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
	public String getTopKeywords() {
		return topKeywords;
	}
	public void setTopKeywords(String topKeywords) {
		this.topKeywords = topKeywords;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}

	/**
	 * 收集生成静态页所需数据
	 */
	public void createGoodsCategory(){
		this.findIndexSiteNavigation();
		this.findGoodsCategoryT();
		this.findJshopbasicInfo();
		findFooterCateogyrT();

		
		
	}
	/**
	 * 获取商城基本信息
	 */
	public void findJshopbasicInfo(){
		String state="1";
		String openstate="1";
		JshopbasicInfoT bean=this.getJshopbasicInfoTService().findJshopbasicInfoBystateandopstate(state, openstate);
		if(bean!=null){
			map.put("jshopbasicinfo", bean);
		}
		
	}
	/**
	 * 获取导航
	 */
	public void findIndexSiteNavigation(){
		String isVisible="1";
		List<SiteNavigationT>list=this.getSiteNavigationTService().findSiteNavigationByisVisible(isVisible);
		if(list!=null){
			map.put("siteNavigationList", list);
		}
	}
	/**
	 * 读取左侧主导航
	 * @return
	 */
	public void findGoodsCategoryT(){
		String state="1";
		List<GoodsCategoryT>list=this.getGoodsCategoryTService().findAllGoodsCategoryBycreatorid(state);
		if(list!=null){
			int gradecount=0;
			for(Iterator it=list.iterator();it.hasNext();){
				GoodsCategoryT gt=(GoodsCategoryT)it.next();
				if(gt.getGrade().equals("0")){
					gradecount++;
				}
			}
			map.put("goodsCategoryTree", list);
			map.put("goodsCategoryTreeFirstCount", gradecount);
		}
	}
	/**
	 * 获取页脚分类
	 */
	public void findFooterCateogyrT(){
		String position="1";
		String status="1";
		int lineSize=5;
		List<ArticleCategoryT>list=this.getArticleCategoryTService().findArticleCategoryByposition(lineSize, status, position);
		if(list!=null){
			map.put("footcategory", list);
		}
	}
	/**
	 * 根据商品名称搜索商品
	 * @return
	 */
	@Action(value = "searchGoodsByGoodsName", results = { 
			@Result(name = "success",type="freemarker" ,location = "/WEB-INF/theme/default/shop/searchgoods.ftl"),
			@Result(name = "input",type="freemarker" ,location = "/WEB-INF/theme/default/shop/searchgoods.ftl")})
	public String searchGoodsByGoodsName(){
		int currentPage = page;
		int lineSize = rp;
		List<GoodsT> list = this.getGoodsTService().findGoodsByGoodsname(currentPage, lineSize, this.getTopKeywords().trim());
		if(!list.isEmpty()&&list!=null){
			total=this.getGoodsTService().countfindSearchGoods(this.getTopKeywords().trim());
			PageModel<GoodsT> pm = new PageModel<GoodsT>(currentPage, lineSize, list,total);			
			//判断是否有余数
			float i= total%lineSize;
			if(i>0){
				totalpage=total/lineSize+1;//有余数，页码数+1
			}else{
				totalpage=total/lineSize;//没有余数 页码数等于当前值
			}			
			ActionContext.getContext().put("goods", pm);
			ActionContext.getContext().put("goodsList", list);
			ActionContext.getContext().put("totalgoods",total);
			ActionContext.getContext().put("totalpage",totalpage);
			ActionContext.getContext().put("topKeywords",topKeywords);
			
		}
		//路径获取
		ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
		//获取导航数据
		ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation());
		//获取商城基本数据
		ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo());
		//获取页脚分类数据
		ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT());
		//获取页脚文章数据
		ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, this.getDataCollectionTAction().findFooterArticle());
		return SUCCESS;
		
	}

	/**
	 * 根据属性获取商品列表用于属性搜索
	 * @return
	 */
//	public String findGoodsByAttrs(){
//		
//	}
//	
	
	

}
