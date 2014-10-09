package com.jshop.action.backstage.staticspage;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.goods.GoodsGroupTAction;
import com.jshop.action.backstage.goods.GoodsTAction;
import com.jshop.action.backstage.staticspage.template.TemplateTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.PageModel;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.ArticleCategoryT;
import com.jshop.entity.ArticleT;
import com.jshop.entity.GoodsCategoryT;
import com.jshop.entity.GoodsGroupT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.TemplateT;
import com.jshop.entity.TemplatesetT;
import com.jshop.service.ArticleCategoryTService;
import com.jshop.service.ArticleTService;
import com.jshop.service.GoodsCategoryTService;
import com.jshop.service.GoodsDetailRpTService;
import com.jshop.service.GoodsGroupTService;
import com.jshop.service.GoodsTService;
import com.jshop.service.TemplateTService;
import com.jshop.service.TemplatesetTService;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.TemplateException;

@ParentPackage("json-default")
@Namespace("")
@Controller("createHtml")
public class CreateHtml extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private TemplateTAction templateTAction;
	private TemplateTService templateTService;
	private TemplatesetTService templatesetTService;
	private GoodsTService goodsTService;
	private ArticleCategoryTService articleCategoryTService;
	private ArticleTService articleTService;
	private GoodsCategoryTService goodsCategoryTService;	
	private DataCollectionTAction dataCollectionTAction;
	private GoodsGroupTAction goodsGroupTAction;
	private GoodsTAction goodsTAction;
	private GoodsGroupTService goodsGroupTService;
	private Map<String, Object> map = new HashMap<String, Object>();
	private Map<String, Object> session = new HashMap<String, Object>();
	private TemplateT bean = new TemplateT();
	private TemplatesetT setbean = new TemplatesetT();
	private FreeMarkerController fc = new FreeMarkerController();
	private PageModel<Object> pm = new PageModel<Object>();
	private String status;
	private boolean slogin;
	private StringBuilder logmsg=new StringBuilder();
	
	 
	public ArticleCategoryTService getArticleCategoryTService() {
		return articleCategoryTService;
	}

	public void setArticleCategoryTService(
			ArticleCategoryTService articleCategoryTService) {
		this.articleCategoryTService = articleCategoryTService;
	}

	@JSON(serialize = false)
	public GoodsTAction getGoodsTAction() {
		return goodsTAction;
	}

	public void setGoodsTAction(GoodsTAction goodsTAction) {
		this.goodsTAction = goodsTAction;
	}
	@JSON(serialize = false)
	public TemplateTService getTemplateTService() {
		return templateTService;
	}
	

	public void setTemplateTService(TemplateTService templateTService) {
		this.templateTService = templateTService;
	}

	@JSON(serialize = false)
	public TemplatesetTService getTemplatesetTService() {
		return templatesetTService;
	}

	public void setTemplatesetTService(TemplatesetTService templatesetTService) {
		this.templatesetTService = templatesetTService;
	}

	@JSON(serialize = false)
	public GoodsTService getGoodsTService() {
		return goodsTService;
	}

	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}

	@JSON(serialize = false)
	public ArticleTService getArticleTService() {
		return articleTService;
	}

	public void setArticleTService(ArticleTService articleTService) {
		this.articleTService = articleTService;
	}

	@JSON(serialize = false)
	public GoodsCategoryTService getGoodsCategoryTService() {
		return goodsCategoryTService;
	}

	public void setGoodsCategoryTService(GoodsCategoryTService goodsCategoryTService) {
		this.goodsCategoryTService = goodsCategoryTService;
	}

	@JSON(serialize = false)
	public TemplateTAction getTemplateTAction() {
		return templateTAction;
	}

	public void setTemplateTAction(TemplateTAction templateTAction) {
		this.templateTAction = templateTAction;
	}

	@JSON(serialize = false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}

	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}
	@JSON(serialize = false)
	public GoodsGroupTService getGoodsGroupTService() {
		return goodsGroupTService;
	}

	public void setGoodsGroupTService(GoodsGroupTService goodsGroupTService) {
		this.goodsGroupTService = goodsGroupTService;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JSON(serialize = false)
	public TemplateT getBean() {
		return bean;
	}

	public void setBean(TemplateT bean) {
		this.bean = bean;
	}

	@JSON(serialize = false)
	public FreeMarkerController getFc() {
		return fc;
	}

	public void setFc(FreeMarkerController fc) {
		this.fc = fc;
	}

	public TemplatesetT getSetbean() {
		return setbean;
	}

	public void setSetbean(TemplatesetT setbean) {
		this.setbean = setbean;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	@JSON(serialize = false)
	public PageModel<Object> getPm() {
		return pm;
	}

	public void setPm(PageModel<Object> pm) {
		this.pm = pm;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	

	public StringBuilder getLogmsg() {
		return logmsg;
	}

	public void setLogmsg(StringBuilder logmsg) {
		this.logmsg = logmsg;
	}

	public GoodsGroupTAction getGoodsGroupTAction() {
		return goodsGroupTAction;
	}

	public void setGoodsGroupTAction(GoodsGroupTAction goodsGroupTAction) {
		this.goodsGroupTAction = goodsGroupTAction;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	/**
	 * 将系统基础信息加入map集合中
	 */
	private void putBaseInfoToMap(){
		map.put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
		map.put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo(StaticKey.DataShowState.SHOW.getState(),StaticKey.JshopOpenState.OPEN.getOpenstate()));
		map.put(FreeMarkervariable.SITENAVIGATIONLIST,this.getDataCollectionTAction().findSiteNavigation(StaticKey.SiteNavigationState.SHOW.getVisible()));
		map.put(FreeMarkervariable.FOOTCATEGORY,this.getDataCollectionTAction().findFooterCateogyrT(StaticKey.DataGrade.FIRST.getState(),StaticKey.DataUsingState.USING.getState()));
		map.put(FreeMarkervariable.FOOTERATRICLE,this.getDataCollectionTAction().findFooterArticle(StaticKey.DataShowState.SHOW.getState()));

	}
	
	/**
	 * 根据商品分类创建对应的静态页商品详情页
	 * @param navid
	 * @param ltypeid
	 * @param stypeid
	 * @throws TemplateException 
	 * @throws IOException 
	 */
	public void buildGoodsdetailPageByCategory(String navid,String ltypeid,String stypeid) throws IOException, TemplateException{
		List<GoodsT>list=null;
		if(navid!=null){
			list=this.getDataCollectionTAction().getGoodsByNavIdCategoryT(navid);	
		}
		if(ltypeid!=null){
			list=this.getDataCollectionTAction().getGoodsByLtypeIdCategoryT(ltypeid);
		}
		if(stypeid!=null){
			list=this.getDataCollectionTAction().getGoodsByStypeIdCategoryT(stypeid);
		}
		putBaseInfoToMap();
		for (Iterator<GoodsT> it = list.iterator(); it.hasNext();) {
			GoodsT gt = (GoodsT) it.next();
			//获取商品详细
			map.put(FreeMarkervariable.GOODSDETAIL, gt);
			//页面导航路径
			map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gt.getNavid()+","+gt.getLtypeid()+","+gt.getStypeid()));
			//获取此该商品的同级分类
			map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gt.getNavid(),StaticKey.DataUsingState.USING.getState()));
			//获取此商品顶级分类的热销商品集合
			map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(gt.getNavid(), null));
			//获取商品描述信息
			map.put(FreeMarkervariable.GOODSDES, this.getDataCollectionTAction().getGoodsDetailRpByGoodsId(gt.getGoodsid()));
			//获取商品参数
			map.put(FreeMarkervariable.GOODSPARAMETERS,this.getDataCollectionTAction().getGoodsparameters(gt));
			//获取推荐商品 条件 同分类下，同类型商品
			map.put(FreeMarkervariable.RECOMMENDGOODSLIST, this.getDataCollectionTAction().getRecommedGoodsListByCategoryId(gt.getNavid()));	
			String htmlPath = this.createGoodsT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSDETAIL, gt.getGoodsid(), map);
			this.getGoodsTService().updateHtmlPath(gt.getGoodsid(), htmlPath,gt.getCreatetime());
		}
		
	}
	
	/**
	 * 静态化所有商品详情页
	 * @throws IOException
	 * @throws TemplateException
	 */
	public void buildAllGoodsdetailsPage() throws IOException, TemplateException{
		List<GoodsT> glist = this.getDataCollectionTAction().findAllGoodsT(StaticKey.GoodsState.SALE.getState());
		putBaseInfoToMap();
		for (Iterator<GoodsT> it = glist.iterator(); it.hasNext();) {
			GoodsT gt = (GoodsT) it.next();
			//获取商品详细
			map.put(FreeMarkervariable.GOODSDETAIL, gt);
			//页面导航路径
			map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gt.getNavid()+","+gt.getLtypeid()+","+gt.getStypeid()));
			//获取此该商品的同级分类
			map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gt.getNavid(),StaticKey.DataUsingState.USING.getState()));
			//获取此商品顶级分类的热销商品集合
			map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(gt.getNavid(), null));
			//获取商品描述信息
			map.put(FreeMarkervariable.GOODSDES, this.getDataCollectionTAction().getGoodsDetailRpByGoodsId(gt.getGoodsid()));
			//获取商品参数
			map.put(FreeMarkervariable.GOODSPARAMETERS,this.getDataCollectionTAction().getGoodsparameters(gt));
			//获取推荐商品 条件 同分类下，同类型商品
			map.put(FreeMarkervariable.RECOMMENDGOODSLIST, this.getDataCollectionTAction().getRecommedGoodsListByCategoryId(gt.getNavid()));	
			String htmlPath = this.createGoodsT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSDETAIL, gt.getGoodsid(), map);
			this.getGoodsTService().updateHtmlPath(gt.getGoodsid(), htmlPath,gt.getCreatetime());
		}
	}
	


	/**
	 * 生成商品静态页
	 */
	public void buildGoodsdetailsPage(Map<String, Object> map) throws IOException, TemplateException {
		List<GoodsT> glist = this.getDataCollectionTAction().findAllGoodsT(StaticKey.GoodsState.SALE.getState());
		for (Iterator<GoodsT> it = glist.iterator(); it.hasNext();) {
			GoodsT gt = (GoodsT) it.next();
//			if(!gt.getCreatetime().equals(gt.getUpdatetime())){
				//获取商品详细
				map.put(FreeMarkervariable.GOODSDETAIL, gt);
				//页面导航路径
				map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gt.getNavid()+","+gt.getLtypeid()+","+gt.getStypeid()));
				//获取此该商品的同级分类
				map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gt.getNavid(),StaticKey.DataUsingState.USING.getState()));
				//获取此商品顶级分类的热销商品集合
				map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(gt.getNavid(), null));
				//获取商品描述信息
				map.put(FreeMarkervariable.GOODSDES, this.getDataCollectionTAction().getGoodsDetailRpByGoodsId(gt.getGoodsid()));
				//获取商品参数
				map.put(FreeMarkervariable.GOODSPARAMETERS,this.getDataCollectionTAction().getGoodsparameters(gt));
				//获取推荐商品 条件 同分类下，同类型商品
				map.put(FreeMarkervariable.RECOMMENDGOODSLIST, this.getDataCollectionTAction().getRecommedGoodsListByCategoryId(gt.getNavid()));
				
				//获取商品评论
				//map.put(FreeMarkervariable.GOODSCOMMENTS, this.getDataCollectionTAction().findGoodsCommentBygoodsid(gt));
				//获取规格值
				//map.put(FreeMarkervariable.GOODSSPECIFICATION, this.getDataCollectionTAction().findProductSpecificationsTByspecificationsid(gt));
				//获取关联商品
				//map.put(FreeMarkervariable.GOODSBELINKED, this.getDataCollectionTAction().findGoodsBelinkedTBygoodsid(gt));
				String htmlPath = this.createGoodsT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSDETAIL, gt.getGoodsid(), map);
				this.getGoodsTService().updateHtmlPath(gt.getGoodsid(), htmlPath,gt.getCreatetime());
//			}
		}
	}
	/**
	 * 根据文章分类静态化文章详情页
	 * @param navid
	 * @param ltypeid
	 * @param stypeid
	 */
	public void buildArticlesdetailPage(String navid,String ltypeid,String stypeid){
		try{
			List<ArticleT>list=null;
			if(navid!=null){
				list=this.getDataCollectionTAction().getArticlesByNavidCategoryT(navid);
			}
			if(ltypeid!=null){
				list=this.getDataCollectionTAction().getArticlesByLtypeidCategoryT(ltypeid);
			}
			if(stypeid!=null){
				list=this.getDataCollectionTAction().getArticlesByStypeidCategoryT(stypeid);
			}
			putBaseInfoToMap();
			for (Iterator<ArticleT> it = list.iterator(); it.hasNext();) {
				ArticleT at = (ArticleT) it.next();
				map.put(FreeMarkervariable.ARTICLE, at);
				String htmlPath = this.createArticleT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORARTICLE, at.getArticleid(), map);
				this.getArticleTService().updateHtmlPath(at.getArticleid(), htmlPath,at.getCreatetime());
			}
		}catch(Exception e){
			
		}
		
	}
	
	/**
	 * 静态化所有文章详情页
	 * @param navid
	 * @param ltypeid
	 * @param stypeid
	 */
	public void buildAllArticlesdetailPage(){
		try{
			List<ArticleT>list=this.getDataCollectionTAction().findAllArticleT(StaticKey.DataShowState.SHOW.getState());
			putBaseInfoToMap();
			for (Iterator<ArticleT> it = list.iterator(); it.hasNext();) {
				ArticleT at = (ArticleT) it.next();
				map.put(FreeMarkervariable.ARTICLE, at);
				String htmlPath = this.createArticleT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORARTICLE, at.getArticleid(), map);
				this.getArticleTService().updateHtmlPath(at.getArticleid(), htmlPath,at.getCreatetime());
			}
		}catch(Exception e){
			
		}
		
	}
	/**
	 * 生成文章静态页
	 * 
	 * @throws IOException
	 * @throws TemplateException
	 */
	public void buildArticlesPage(Map<String, Object> map) throws IOException, TemplateException {
		List<ArticleT> alist = this.getDataCollectionTAction().findAllArticleT(StaticKey.DataShowState.SHOW.getState());
		if (!alist.isEmpty()) {
			for (Iterator<ArticleT> it = alist.iterator(); it.hasNext();) {
				ArticleT at = (ArticleT) it.next();
//				if(!at.getCreatetime().equals(at.getUpdatetime())){
					if(!"1".equals(at.getIsnotice())){
						map.put(FreeMarkervariable.ARTICLE, at);
						String htmlPath = this.createArticleT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORARTICLE, at.getArticleid(), map);
						this.getArticleTService().updateHtmlPath(at.getArticleid(), htmlPath,at.getCreatetime());
					}
//				}
				
			}
		}
	}
	/**
	 * 生成公告静态页
	 * 
	 * @throws IOException
	 * @throws TemplateException
	 */
	public void buildNoticeArticlesPage(Map<String, Object> map) throws IOException, TemplateException {
		List<ArticleT> alist = this.getDataCollectionTAction().findAllArticleT(StaticKey.DataShowState.SHOW.getState());
		if (!alist.isEmpty()) {
			for (Iterator<ArticleT> it = alist.iterator(); it.hasNext();) {
				ArticleT at = (ArticleT) it.next();
//				if(!at.getCreatetime().equals(at.getUpdatetime())){
					if("1".equals(at.getIsnotice())){
						map.put(FreeMarkervariable.ARTICLE, at);
						String htmlPath = this.createArticleT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORNOTICE, at.getArticleid(), map);
						this.getArticleTService().updateHtmlPath(at.getArticleid(), htmlPath,at.getCreatetime());
					}
//				}
			}
		}
	}
	

	/**
	 * 商城上架状态的商品分类静态页
	 * 
	 * @throws IOException
	 * @throws TemplateException
	 */
	public void buildGoodsCategoryPage(Map<String, Object> map) throws IOException, TemplateException {
		String salestate =StaticKey.GoodsState.SALE.getState();//上架商品
		List<GoodsCategoryT> gclist = this.getDataCollectionTAction().findAllGoodsCategoryTByState(StaticKey.DataShowState.SHOW.getState());//读取所有启用的商品分类
		if (!gclist.isEmpty()) {
			List<GoodsT> list = new ArrayList<GoodsT>();
			for (Iterator<GoodsCategoryT> it = gclist.iterator(); it.hasNext();) {
				GoodsCategoryT gct = (GoodsCategoryT) it.next();
				map.put(FreeMarkervariable.GOODSCATEGORY, gct);
				//顶级分类
				if (gct.getGrade().equals(StaticKey.ZERO)) {
					String navid = gct.getGoodsCategoryTid();
					//生成上架状态的商品分类静态页
					list = this.getGoodsTService().findAllGoodsBynavid(navid, salestate);
					if (list != null&&list.size()>0) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gct.getPath()));
						map.put(FreeMarkervariable.SIGN, gct.getSign());//页面链接标示
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));//收集商品类型下的品牌
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid(),StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
						//获取此商品顶级分类的热销商品集合
						map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(gct.getGoodsCategoryTid(), null));
						
						String htmlPath = this.createGoodsCategoryT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign(), map);
						this.getGoodsCategoryTService().updateHtmlPath(gct.getGoodsCategoryTid(), htmlPath);
					}
					//生成按照销量排序
					list = this.getGoodsTService().findAllGoodsBynavidorderbyParams(navid, salestate, "sales", null, null, null, null, null, null, null);
					if (list != null&&list.size()>0) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gct.getPath()));
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "sales");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid(),StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
						//获取此商品顶级分类的热销商品集合
						map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(gct.getGoodsCategoryTid(), null));
						
						this.createGoodsCategoryT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "sales", map);

					}
					//生成按照会员价格排序
					list = this.getGoodsTService().findAllGoodsBynavidorderbyParams(navid, salestate, null, "memberprice", null, null, null, null, null, null);
					if (list != null&&list.size()>0) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gct.getPath()));
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "memberprice");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid(),StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
						//获取此商品顶级分类的热销商品集合
						map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(gct.getGoodsCategoryTid(), null));
						
						this.createGoodsCategoryT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "memberprice", map);

					}
					//生成按照评论排序
					list = this.getGoodsTService().findAllGoodsBynavidorderbyParams(navid, salestate, null, null, "totalcomment", null, null, null, null, null);
					if (list != null&&list.size()>0) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gct.getPath()));
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "totalcomment");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid(),StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
						//获取此商品顶级分类的热销商品集合
						map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(gct.getGoodsCategoryTid(), null));
						
						this.createGoodsCategoryT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "totalcomment", map);

					}

					//生成按照特价筛选
					//List<GoodsT>listb=new ArrayList<GoodsT>();
					list = this.getGoodsTService().findAllGoodsBynavidorderbyParams(navid, salestate, null, null, null, "bargainprice", null, null, null, "1");
					if (list != null&&list.size()>0) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gct.getPath()));
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "bargainprice");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid(),StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
						//获取此商品顶级分类的热销商品集合
						map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(gct.getGoodsCategoryTid(), null));
						
						this.createGoodsCategoryT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "bargainprice", map);
					}
					//生成按照热销筛选
					list = this.getGoodsTService().findAllGoodsBynavidorderbyParams(navid, salestate, null, null, null, null, "hotsale", null, null, "1");
					if (list != null&&list.size()>0) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gct.getPath()));
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "hotsale");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid(),StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
						//获取此商品顶级分类的热销商品集合
						map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(gct.getGoodsCategoryTid(), null));
						
						this.createGoodsCategoryT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "hotsale", map);
					}

					//生成按照推荐排序
					list = this.getGoodsTService().findAllGoodsBynavidorderbyParams(navid, salestate, null, null, null, null, null, "recommended", null, "1");
					map.put(FreeMarkervariable.ALLGOODS, list);
					map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gct.getPath()));
					map.put(FreeMarkervariable.SIGN, gct.getSign() + "recommended");
					map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
					map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
					map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid(),StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
					//获取此商品顶级分类的热销商品集合
					map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(gct.getGoodsCategoryTid(), null));
					
					this.createGoodsCategoryT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "recommended", map);
					//生成按照新品排序
					list = this.getGoodsTService().findAllGoodsBynavidorderbyParams(navid, salestate, null, null, null, null, null, null, "isNew", "1");
					map.put(FreeMarkervariable.ALLGOODS, list);
					map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gct.getPath()));
					map.put(FreeMarkervariable.SIGN, gct.getSign() + "isNew");
					map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
					map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
					map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid(),StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
					//获取此商品顶级分类的热销商品集合
					map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(gct.getGoodsCategoryTid(), null));
					
					this.createGoodsCategoryT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "isNew", map);
				} else if (gct.getGrade().equals("1")) {
					String ltypeid = gct.getGoodsCategoryTid();
					//生成上架状态的商品分类静态页
					list = this.getGoodsTService().findGoodsByLtypeid(ltypeid, salestate);
					if (list != null&&list.size()>0) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gct.getPath()));
						map.put(FreeMarkervariable.SIGN, gct.getSign());//页面链接标示
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid(),StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
						//获取此商品顶级分类的热销商品集合
						map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(null,gct.getGoodsCategoryTid()));
						
						String htmlPath = this.createGoodsCategoryT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign(), map);
						this.getGoodsCategoryTService().updateHtmlPath(gct.getGoodsCategoryTid(), htmlPath);
					}
					//生成按照销量排序
					list = this.getGoodsTService().findAllGoodsByLtypeidorderbyParams(ltypeid, salestate, "sales", null, null, null, null, null, null, null);
					if (list != null&&list.size()>0) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gct.getPath()));
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "sales");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid(),StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
						//获取此商品顶级分类的热销商品集合
						map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(null,gct.getGoodsCategoryTid()));
						this.createGoodsCategoryT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "sales", map);

					}
					//生成按照会员价格排序
					list = this.getGoodsTService().findAllGoodsByLtypeidorderbyParams(ltypeid, salestate, null, "memberprice", null, null, null, null, null, null);
					if (list != null&&list.size()>0) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gct.getPath()));
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "memberprice");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid(),StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
						//获取此商品顶级分类的热销商品集合
						map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(null,gct.getGoodsCategoryTid()));
						this.createGoodsCategoryT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "memberprice", map);

					}
					//生成按照评论排序
					list = this.getGoodsTService().findAllGoodsByLtypeidorderbyParams(ltypeid, salestate, null, null, "totalcomment", null, null, null, null, null);
					if (list != null&&list.size()>0) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gct.getPath()));
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "totalcomment");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid(),StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
						//获取此商品顶级分类的热销商品集合
						map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(null,gct.getGoodsCategoryTid()));
						this.createGoodsCategoryT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "totalcomment", map);

					}

					//生成按照特价筛选
					//List<GoodsT>listb=new ArrayList<GoodsT>();
					list = this.getGoodsTService().findAllGoodsByLtypeidorderbyParams(ltypeid, salestate, null, null, null, "bargainprice", null, null, null, "1");
					if (list != null&&list.size()>0) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gct.getPath()));
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "bargainprice");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid(),StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
						//获取此商品顶级分类的热销商品集合
						map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(null,gct.getGoodsCategoryTid()));
						this.createGoodsCategoryT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "bargainprice", map);
					}
					//生成按照热销筛选
					list = this.getGoodsTService().findAllGoodsByLtypeidorderbyParams(ltypeid, salestate, null, null, null, null, "hotsale", null, null, "1");
					if (list != null&&list.size()>0) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gct.getPath()));
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "hotsale");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid(),StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
						//获取此商品顶级分类的热销商品集合
						map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(null,gct.getGoodsCategoryTid()));
						this.createGoodsCategoryT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "hotsale", map);
					}

					//生成按照推荐排序
					list = this.getGoodsTService().findAllGoodsByLtypeidorderbyParams(ltypeid, salestate, null, null, null, null, null, "recommended", null, "1");
					map.put(FreeMarkervariable.ALLGOODS, list);
					map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gct.getPath()));
					map.put(FreeMarkervariable.SIGN, gct.getSign() + "recommended");
					map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
					map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
					map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid(),StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
					//获取此商品顶级分类的热销商品集合
					map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(null,gct.getGoodsCategoryTid()));
					this.createGoodsCategoryT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "recommended", map);
					//生成按照新品排序
					list = this.getGoodsTService().findAllGoodsByLtypeidorderbyParams(ltypeid, salestate, null, null, null, null, null, null, "isNew", "1");
					map.put(FreeMarkervariable.ALLGOODS, list);
					map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gct.getPath()));
					map.put(FreeMarkervariable.SIGN, gct.getSign() + "isNew");
					map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
					map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
					map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid(),StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
					//获取此商品顶级分类的热销商品集合
					map.put(FreeMarkervariable.HOTSALEGOODSLIST, this.getDataCollectionTAction().getHostsaleGoodsByCategoryId(null,gct.getGoodsCategoryTid()));
					this.createGoodsCategoryT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "isNew", map);
				} else {
					String stypeid = gct.getGoodsCategoryTid();
					list = this.getGoodsTService().findGoodsByStypeid(stypeid, salestate);
					map.put(FreeMarkervariable.ALLGOODS, list);
					map.put(FreeMarkervariable.GOODSCATEGORYPATH, this.getDataCollectionTAction().getGoodsCategoryPath(gct.getPath()));
					map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
					map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
					String htmlPath = this.createGoodsCategoryT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign(), map);
					this.getGoodsCategoryTService().updateHtmlPath(gct.getGoodsCategoryTid(), htmlPath);
				}
			}

		}
	}
	
	/**
	 * 创建帮助中心列表
	 * @param map
	 * @throws TemplateException 
	 * @throws IOException 
	 */
	public void buildHelpCenterArticlelist(Map<String, Object> map) throws IOException, TemplateException{
		List<ArticleCategoryT>list= this.getDataCollectionTAction().findFooterCateogyrT(StaticKey.DataGrade.FIRST.getState(),StaticKey.DataShowState.SHOW.getState());
		List<ArticleT> allArticleTs = (List<ArticleT>) map.get(FreeMarkervariable.ALLARTICLE);
		List<ArticleT>articles=new ArrayList();
		for(ArticleCategoryT act:list){
			for(ArticleT at:allArticleTs){
				if(at.getNavid().equals(act.getArticleCategoryTid())){
					articles.add(at);
				}
			}
			map.put(FreeMarkervariable.ARTICLESINCATEGORY,articles);
			
			map.put(FreeMarkervariable.HELPARTICLECATEGORY,list);
			String htmlpath=this.createHelpCenterArticleCategoryT(BaseTools.getApplicationthemesign()+"_"+ContentTag.TEMPLATENAME4NOTICELIST, act.getSign(), map);
			articles.clear();
			act.setHtmlpath(htmlpath);
			this.getArticleCategoryTService().update(act);
		}
		
	}

	/**
	 * 生成激活邮件模板数据
	 * 
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	public String buildEmail(String emailcontent) throws IOException, TemplateException {
		map.put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
		map.put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo(StaticKey.DataShowState.SHOW.getState(),StaticKey.JshopOpenState.OPEN.getOpenstate()));
		map.put(FreeMarkervariable.USERACTIVATES, emailcontent);
		return this.createEmail(ContentTag.TEMPLATENAMEFOREMAIL, BaseTools.getAdminCreateId(), map);

	}

	/**
	 * 生成活动邮件模板数据
	 * 
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	public String buildactivityEmail(String emailcontent) throws IOException, TemplateException {
		map.put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
		map.put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo(StaticKey.DataShowState.SHOW.getState(),StaticKey.JshopOpenState.OPEN.getOpenstate()));
		map.put(FreeMarkervariable.EMAILCONTENT, emailcontent);
		return this.createactivityEmail(ContentTag.TEMPLATENAMEFOREMAILTEMPLATE, ContentTag.CREATORID, map);
	}

	/**
	 * 邮件激活回调页面模板
	 * 
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	public void buildUseractivatescallback(Map<String, Object> map) throws IOException, TemplateException {
		map.put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
		map.put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo(StaticKey.DataShowState.SHOW.getState(),StaticKey.JshopOpenState.OPEN.getOpenstate()));
		this.createNormalhtml(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORUSERACTIVATESCALLBACK, null, map);
	}

	/**
	 * 根据当前页和每页大小拿到分页数据
	 * 
	 * @param pageNo
	 *            当前页
	 * @param pageSize
	 *            每页大小
	 * @param lstArticle
	 *            数据
	 * @return List<Article>
	 */
	public static List<?> getDataByPageNo(int pageNo, int pageSize, List<?> lstGoods) {
		int totalpage = pageNo * pageSize > lstGoods.size() ? lstGoods.size() : pageNo * pageSize;
		return lstGoods.subList((pageNo - 1) * pageSize, totalpage);
	}

//	/**
//	 * 获取网站根目录
//	 * 
//	 * @param map
//	 * @throws UnknownHostException
//	 *             InetAddress inet = InetAddress.getLocalHost();
//	 *             request.getScheme() + "://" + inet.getHostAddress() + ":" +
//	 *             request.getServerPort() +
//	 */
//	public String getBasePath() throws UnknownHostException {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		String path = request.getContextPath();
//		String basePath = path + "/";
//		return basePath;
//	}

	/**
	 * 根据传入参数创建文章详细的静态页
	 * 
	 * @param note
	 *            模板表中得备注说明这个值和模板关系设定表中得系统内容要一致才可得到静态页输出目录或者输出文件
	 * @param sign
	 *            标示
	 * @param filename
	 *            生成的html文件名称
	 * @param creatorid
	 *            用户id
	 * @param map
	 *            模板参数
	 * @param ftlname
	 *            模板表中模板文件名
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	public String createArticleT(String sign, String filename, Map<String, Object> data) throws IOException, TemplateException {
		String realhtmlpath = "";
		try{
			setbean = this.getTemplatesetTService().findTemplatesetTBysign(sign);
			if (setbean != null) {
				String ftl = setbean.getTemplateurl();
				String folder = setbean.getBuildhtmlpath();
				String fileName = filename + ".html";
				String relativePath = "";
				fc.init(ftl, folder, fileName, data, relativePath);
				realhtmlpath = folder + fileName;
			}
			return realhtmlpath;
		}catch(Exception e){
			this.getLogmsg().append("<p style='color:red;'>" + fc.getLogmsg() + "</p>");
		}
		return realhtmlpath;
	}

	/**
	 * 生成商品静态页
	 * 
	 * @param ftlname
	 * @param note
	 * @param filename
	 * @param creatorid
	 * @param data
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	public String createGoodsT(String sign, String filename, Map<String, Object> data) throws IOException, TemplateException {
		String realhtmlpath = "";
		try{
			setbean = this.getTemplatesetTService().findTemplatesetTBysign(sign);
			if (setbean != null) {
				String ftl = setbean.getTemplateurl();
				String folder = setbean.getBuildhtmlpath();
				String fileName = filename + ".html";
				String relativePath = "";
				fc.init(ftl, folder, fileName, data, relativePath);
				realhtmlpath = folder + fileName;
			}
			return realhtmlpath;
		}catch(Exception e){
			this.getLogmsg().append("<p style='color:red;'>" + fc.getLogmsg() + "</p>");
		}
		return realhtmlpath;
	}


	/**
	 * 生成商品分类静态页
	 * 
	 * @param ftlname
	 * @param note
	 * @param filename
	 * @param creatorid
	 * @param data
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public String createGoodsCategoryT(String sign, String filename, Map<String, Object> data) throws IOException, TemplateException {
		String realhtmlpath = "";
		int pageSize = 1;
		try{
			setbean = this.getTemplatesetTService().findTemplatesetTBysign(sign);
			if (setbean != null) {
				map.put("basePath", this.getDataCollectionTAction().getBasePath());
				String ftl = setbean.getTemplateurl();
				String folder = setbean.getBuildhtmlpath();
				String fileName;
				String relativePath = "";
				List<GoodsT> allGoods = (List<GoodsT>) data.get(FreeMarkervariable.ALLGOODS);
				if (allGoods != null && allGoods.size() > 0) {
					PageModel<GoodsT> pms = new PageModel<GoodsT>(1, pageSize, null, allGoods.size());
					long totalPage = pms.getTotalpage();
					for (int i = 1; i <= totalPage; i++) {
						PageModel<GoodsT> pm = new PageModel<GoodsT>(i, pageSize, (List<GoodsT>) CreateHtml.getDataByPageNo(i, pageSize, allGoods), allGoods.size());
						data.put(FreeMarkervariable.GOODS, pm);
						if (i == 1) {
							fileName = filename + "_" + i + ".html";
							fc.init(ftl, folder, fileName, data, relativePath);
							realhtmlpath = folder + fileName;
						} else {
							fileName = filename + "_" + i + ".html";
							fc.init(ftl, folder, fileName, data, relativePath);
						}
					}
				}
			}
			return realhtmlpath;
		}catch(Exception e){
			this.getLogmsg().append("<p style='color:red;'>" + fc.getLogmsg() + "</p>");
		}
		return realhtmlpath;
		
	}

	/**
	 * 生成帮助中心列表静态页
	 * 
	 * @param ftlname
	 * @param note
	 * @param filename
	 * @param creatorid
	 * @param data
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public String createHelpCenterArticleCategoryT(String sign, String filename, Map<String, Object> data) throws IOException, TemplateException {
		String realhtmlpath = "";
		int pageSize =20;
		try{
			setbean = this.getTemplatesetTService().findTemplatesetTBysign(sign);
			if (setbean != null) {
				map.put("basePath", this.getDataCollectionTAction().getBasePath());
				String ftl = setbean.getTemplateurl();
				String folder = setbean.getBuildhtmlpath();
				String fileName;
				String relativePath = "";
				List<ArticleT> allArticleTs = (List<ArticleT>) data.get(FreeMarkervariable.ARTICLESINCATEGORY);
				if (allArticleTs != null && allArticleTs.size() > 0) {
					PageModel<ArticleT> pms = new PageModel<ArticleT>(1, pageSize, null, allArticleTs.size());
					long totalPage = pms.getTotalpage();
					for (int i = 1; i <= totalPage; i++) {
						PageModel<ArticleT> pm = new PageModel<ArticleT>(i, pageSize, (List<ArticleT>) CreateHtml.getDataByPageNo(i, pageSize, allArticleTs), allArticleTs.size());
						data.put(FreeMarkervariable.ARTICLE, pm);
						if (i == 1) {
							fileName = filename + "_" + i + ".html";
							fc.init(ftl, folder, fileName, data, relativePath);
							realhtmlpath = folder + fileName;
						} else {
							fileName = filename + "_" + i + ".html";
							fc.init(ftl, folder, fileName, data, relativePath);
						}
					}
				}
			}
			return realhtmlpath;
		}catch(Exception e){
			this.getLogmsg().append("<p style='color:red;'>" + fc.getLogmsg() + "</p>");
		}
		return realhtmlpath;
		
	}


	
	/**
	 * 创建普通的html页面
	 * @param sign
	 * @param filename
	 * @param data
	 * @return
	 */
	public String createNormalhtml(String sign, String filename, Map<String, Object> data){
		String realhtmlpath = "";
		try{
			setbean = this.getTemplatesetTService().findTemplatesetTBysign(sign);
			if (setbean != null) {
				String ftl = setbean.getTemplateurl();
				String folder = "";
				String fileName = "";
				String strs[] = setbean.getBuildhtmlpath().split("/");
				for (int i = 0; i < strs.length; i++) {
					if (strs[i].contains(".html")) {
						fileName = strs[i];
					} else {
						folder += strs[i] + "/";
					}
				}
				String relativePath = "";
				fc.init(ftl, folder, fileName, data, relativePath);
				realhtmlpath = folder + fileName;
			}
			return realhtmlpath;
		}catch(Exception e){
			this.getLogmsg().append("<p style='color:red;'>"+fc.getLogmsg()+"</p>");
		}
		return realhtmlpath;
	}


	/**
	 * 创建激活邮件模板
	 * 
	 * @param ftlname
	 * @param creatorid
	 * @param data
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	public String createEmail(String ftlname, String creatorid, Map<String, Object> data) throws IOException, TemplateException {
		String htmlText = "";
		bean = this.getTemplateTService().findTemplateByname(creatorid, ftlname);
		if (bean != null) {
			map.put("basePath", this.getDataCollectionTAction().getBasePath());
			String ftl = bean.getUrl();
			String relativePath = "";
			htmlText = fc.init(ftl, data, relativePath);
		}
		return htmlText;
	}

	/**
	 * 创建活动邮件模板
	 * 
	 * @param ftlname
	 * @param creatorid
	 * @param data
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	public String createactivityEmail(String ftlname, String creatorid, Map<String, Object> data) throws IOException, TemplateException {
		String htmlText = "";
		bean = this.getTemplateTService().findTemplateByname(creatorid, ftlname);
		if (bean != null) {
			map.put("basePath", this.getDataCollectionTAction().getBasePath());
			String ftl = bean.getUrl();
			String relativePath = "";
			htmlText = fc.init(ftl, data, relativePath);
		}
		return htmlText;
	}
	
	
	
	

	/**
	 * 重新生成模板文件
	 * 
	 * @throws IOException
	 * @throws IllegalAccessException
	 */
	public void recreateTemplate() throws IOException, IllegalAccessException {
		try {
			List<TemplateT> tlist = this.getTemplateTService().findAllTemplateWithNoParam(BaseTools.getAdminCreateId(), "1");
			if (!tlist.isEmpty()) {
				for (Iterator<TemplateT> it = tlist.iterator(); it.hasNext();) {
					TemplateT tt = (TemplateT) it.next();
					this.getTemplateTAction().updateFTLFile(tt);
				}
			}
		} catch (Exception e) {
			this.getLogmsg().append("<p style='color:red;'>" + fc.getLogmsg() + "</p>");
		} 
		
	}
	/**
	 *生成团购页面模板
	 * @param map
	 * @throws IOException
	 * @throws TemplateException
	 */
	public void buildGoodsGroupT(Map<String, Object> map) throws IOException, TemplateException{
		List<GoodsGroupT> list = this.getGoodsGroupTService().findGoodsGroupByState("1");
		for(Iterator<GoodsGroupT> it=list.iterator();it.hasNext();){
			GoodsGroupT ggt = (GoodsGroupT) it.next();
			map.put(FreeMarkervariable.GOODSGROUPT, ggt);
			String htmlpath = this.createGoodsGroup(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSGROUPT, ggt.getGroupid(), map);
			this.getGoodsGroupTService().updateGoodsGroupHtmlPath(htmlpath, ggt.getGroupid());
		}
	}
	/**
	 * 生成团购商品静态页
	 * @param sign
	 * @param filename
	 * @param data
	 * @return
	 * @throws TemplateException
	 */
	public String createGoodsGroup(String sign,String filename,Map<String, Object> data) throws TemplateException{
		String realhtmlpath="";
		try {			
			setbean = this.getTemplatesetTService().findTemplatesetTBysign(sign);
			if(setbean!=null){
				String ftl = setbean.getTemplateurl();
				String folder =setbean.getBuildhtmlpath();
				String fileName= filename+".html";
				String relativePath = "";
				fc.init(ftl, folder, fileName, data, relativePath);
				realhtmlpath = folder + fileName;
			}
			return realhtmlpath;
		} catch (IOException e) {
			this.getLogmsg().append("<p style='color:red;'>" + fc.getLogmsg() + "</p>");
		} 
		return realhtmlpath;
	}
	
	

}
