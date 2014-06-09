package com.jshop.action.backstage.aspect;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.jshop.action.backstage.content.article.ArticleTAction;
import com.jshop.action.backstage.goods.GoodsCategoryTAction;
import com.jshop.action.backstage.goods.GoodsTAction;
import com.jshop.action.backstage.staticspage.ContentTag;
import com.jshop.action.backstage.staticspage.FreeMarkervariable;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GoodsT;

import freemarker.template.TemplateException;

@Aspect
public class CreateStaticHtmlAspect {
	private Map<String, Object> map = new HashMap<String, Object>();
	

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	/**
	 * 在商品增加/修改时更新静态页
	 * @throws TemplateException 
	 * @throws IOException 
	 */
	@After("execution(String com.jshop.action.backstage.goods.GoodsTAction.updateGoods())||execution(String com.jshop.action.backstage.goods.GoodsTAction.saveGoods())")
	public void aftergoodsIUCreatestatichtml(JoinPoint joinPoint) throws IOException, TemplateException{
		GoodsTAction gtn=(GoodsTAction) joinPoint.getThis();
		if(gtn.getBean()!=null){
			String basepath=gtn.getDataCollectionTAction().getBasePath();
			String theme=gtn.getDataCollectionTAction().getDefaultTheme();
			String htmlpath="html/"+theme+"/shop/"+gtn.getBean().getGoodsid()+".html";
			gtn.getBean().setHtmlPath(htmlpath);
			//获取默认项目路径
			map.put(FreeMarkervariable.BASEPATH,basepath);
			//获取默认主题
			map.put(FreeMarkervariable.DEFAULTTHEMESIGN, theme);
			//获取商城基本信息
			map.put(FreeMarkervariable.JSHOPBASICINFO, gtn.getDataCollectionTAction().findJshopbasicInfo(StaticKey.DataShowState.SHOW.getState(),StaticKey.JshopOpenState.OPEN.getOpenstate()));
			//获取导航
			map.put(FreeMarkervariable.SITENAVIGATIONLIST, gtn.getDataCollectionTAction().findSiteNavigation(StaticKey.SiteNavigationState.SHOW.getVisible()));
			//获取页脚文章一级分类
			map.put(FreeMarkervariable.FOOTCATEGORY, gtn.getDataCollectionTAction().findFooterCateogyrT(StaticKey.DataGrade.FIRST.getState(),StaticKey.DataUsingState.USING.getState()));
			//获取页脚文章一级分类下得文章
			map.put(FreeMarkervariable.FOOTERATRICLE, gtn.getDataCollectionTAction().findFooterArticle(StaticKey.DataShowState.SHOW.getState()));
			//获取商品详细
			map.put(FreeMarkervariable.GOODSDETAIL, gtn.getBean());
			//这里获取商品参数和商品类型表中的对比并显示
			map.put(FreeMarkervariable.GOODSPARAMETERS,gtn.getDataCollectionTAction().getGoodsparameters(gtn.getBean()));//这是处理过后的商品参数,用在freemarker模板
			//获取商品评论
			map.put(FreeMarkervariable.GOODSCOMMENTS, gtn.getDataCollectionTAction().findGoodsCommentBygoodsid(gtn.getBean()));
			//获取规格值
			map.put(FreeMarkervariable.GOODSSPECIFICATION, gtn.getDataCollectionTAction().findProductSpecificationsTByspecificationsid(gtn.getBean()));
			//获取关联商品
			map.put(FreeMarkervariable.GOODSBELINKED, gtn.getDataCollectionTAction().findGoodsBelinkedTBygoodsid(gtn.getBean()));
			
			String htmlPath = gtn.getCreateHtml().createGoodsT(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORGOODSDETAIL, gtn.getBean().getGoodsid(), map);
			if (Validate.StrNotNull(htmlPath)) {
				gtn.getGoodsTService().updateHtmlPath(gtn.getBean().getGoodsid(), htmlPath);
			}
		}
		
	}
	
	/**
	 * 在商品分类增加和修改时更新静态页
	 * @param joinPoint
	 * @throws TemplateException 
	 * @throws IOException 
	 */
	@After("execution(String com.jshop.action.backstage.goods.GoodsCategoryTAction.updateGoodscategoryT())")
	public void aftergoodscategoryIUCreatestatichtml(JoinPoint joinPoint) throws IOException, TemplateException{
		GoodsCategoryTAction gcta=(GoodsCategoryTAction)joinPoint.getThis();
		if(gcta.getBean()!=null){
			//获取默认项目路径
			map.put(FreeMarkervariable.BASEPATH,gcta.getDataCollectionTAction().getBasePath());
			//获取默认主题
			map.put(FreeMarkervariable.DEFAULTTHEMESIGN, gcta.getDataCollectionTAction().getDefaultTheme());
			//获取商城基本信息
			map.put(FreeMarkervariable.JSHOPBASICINFO, gcta.getDataCollectionTAction().findJshopbasicInfo(StaticKey.DataShowState.SHOW.getState(),StaticKey.JshopOpenState.OPEN.getOpenstate()));
			//获取导航
			map.put(FreeMarkervariable.SITENAVIGATIONLIST, gcta.getDataCollectionTAction().findSiteNavigation(StaticKey.SiteNavigationState.SHOW.getVisible()));
			//获取页脚文章一级分类
			map.put(FreeMarkervariable.FOOTCATEGORY, gcta.getDataCollectionTAction().findFooterCateogyrT(StaticKey.DataGrade.FIRST.getState(),StaticKey.DataUsingState.USING.getState()));
			//获取页脚文章一级分类下得文章
			map.put(FreeMarkervariable.FOOTERATRICLE, gcta.getDataCollectionTAction().findFooterArticle(StaticKey.DataShowState.SHOW.getState()));
			String salestate = "1";
			if (gcta.getBean().getGrade().equals("0")) {
				String navid = gcta.getGoodsCategoryTid();
				List<GoodsT> list = gcta.getGoodsTService().findAllGoodsBynavid(navid, salestate);
				map.put(FreeMarkervariable.SECONDGOODSCATEGORY, gcta.getDataCollectionTAction().findSecondGoodsCategoryT(navid,StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
				map.put(FreeMarkervariable.ALLGOODS, list);
			} else if (gcta.getBean().getGrade().equals("1")) {
				String ltypeid = gcta.getGoodsCategoryTid();
				List<GoodsT> list = gcta.getGoodsTService().findGoodsByLtypeid(ltypeid, salestate);
				map.put(FreeMarkervariable.SECONDGOODSCATEGORY, gcta.getDataCollectionTAction().findSecondGoodsCategoryT(ltypeid,StaticKey.DataUsingState.USING.getState()));//获取此分类下的二级分类
				map.put(FreeMarkervariable.ALLGOODS, list);
			} else {
				String stypeid = gcta.getGoodsCategoryTid();
				List<GoodsT> list = gcta.getGoodsTService().findGoodsByStypeid(stypeid, salestate);
				map.put(FreeMarkervariable.ALLGOODS, list);
			}
			map.put(FreeMarkervariable.GOODSCATEGORY, gcta.getBean());
			//更新商品分类静态页路径
			String htmlPath = gcta.getCreateHtml().createGoodsCategoryT(BaseTools.getApplicationthemesign()+"_"+ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gcta.getBean().getSign(), map);
			gcta.getGoodsCategoryTService().updateHtmlPath(gcta.getBean().getGoodsCategoryTid(), htmlPath);
		}
		
	}
	
	/**
	 * 在文章增加和修改时更新静态页
	 * @param joinPoint
	 * @throws TemplateException 
	 * @throws IOException 
	 */
	@After(value="execution(String com.jshop.action.backstage.content.article.ArticleTAction.addArticleT(..))||execution(String com.jshop.action.backstage.content.article.ArticleTAction.updateArticleT(..))")
	public void afterarticleIUCreatestatichtml(JoinPoint joinPoint) throws IOException, TemplateException{
		ArticleTAction ata=(ArticleTAction)joinPoint.getThis();
		if(ata.getBean()!=null){
			//获取默认项目路径
			map.put(FreeMarkervariable.BASEPATH,ata.getDataCollectionTAction().getBasePath());
			//获取默认主题
			map.put(FreeMarkervariable.DEFAULTTHEMESIGN, ata.getDataCollectionTAction().getDefaultTheme());
			//获取商城基本信息
			map.put(FreeMarkervariable.JSHOPBASICINFO, ata.getDataCollectionTAction().findJshopbasicInfo(StaticKey.DataShowState.SHOW.getState(),StaticKey.JshopOpenState.OPEN.getOpenstate()));
			//获取导航
			map.put(FreeMarkervariable.SITENAVIGATIONLIST, ata.getDataCollectionTAction().findSiteNavigation(StaticKey.SiteNavigationState.SHOW.getVisible()));
			//获取页脚文章一级分类
			map.put(FreeMarkervariable.FOOTCATEGORY, ata.getDataCollectionTAction().findFooterCateogyrT(StaticKey.DataGrade.FIRST.getState(),StaticKey.DataUsingState.USING.getState()));
			//获取页脚文章一级分类下得文章
			map.put(FreeMarkervariable.FOOTERATRICLE, ata.getDataCollectionTAction().findFooterArticle(StaticKey.DataShowState.SHOW.getState()));
			//获取文章详细
			map.put(FreeMarkervariable.ARTICLE, ata.getBean());
			if("1".equals(ata.getBean().getIsnotice())){
				//更新文章静态路径
				String htmlPath = ata.getCreateHtml().createArticleT(BaseTools.getApplicationthemesign()+"_"+ContentTag.TEMPLATENAMEFORNOTICE, ata.getBean().getArticleid(), map);
				ata.getArticleTService().updateHtmlPath(ata.getBean().getArticleid(), htmlPath);
			}else{
				//更新文章静态路径
				String htmlPath = ata.getCreateHtml().createArticleT(BaseTools.getApplicationthemesign()+"_"+ContentTag.TEMPLATENAMEFORARTICLE, ata.getBean().getArticleid(), map);
				ata.getArticleTService().updateHtmlPath(ata.getBean().getArticleid(), htmlPath);
			}
		}
	}

	
	
}
