package com.jshop.action.backstage.staticspage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jshop.action.backstage.base.InitTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.TemplatesetT;
import com.jshop.service.TemplatesetTService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.TemplateException;
@Namespace("")
@ParentPackage("jshop")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class BuildHtmlPages extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private CreateHtml createHtml;
	private DataCollectionTAction dataCollectionTAction;
	private InitTAction initTAction;
	private TemplatesetTService templatesetTService;
	private Map<String, Object> map;
	private String status;
	private String buildlog;
	//商品分类id
	private String navid;
	private String ltypeid;
	private String stypeid;
	
	private int processbar;
	private boolean sucflag;
	public BuildHtmlPages() {
		map = new HashMap<String, Object>();
	}
	@JSON(serialize = false)
	public TemplatesetTService getTemplatesetTService() {
		return templatesetTService;
	}

	public void setTemplatesetTService(TemplatesetTService templatesetTService) {
		this.templatesetTService = templatesetTService;
	}

	@JSON(serialize = false)
	public InitTAction getInitTAction() {
		return initTAction;
	}
	public void setInitTAction(InitTAction initTAction) {
		this.initTAction = initTAction;
	}
	@JSON(serialize = false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}
	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}
	
	@JSON(serialize = false)
	public CreateHtml getCreateHtml() {
		return createHtml;
	}

	public void setCreateHtml(CreateHtml createHtml) {
		this.createHtml = createHtml;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public String getBuildlog() {
		return buildlog;
	}

	public void setBuildlog(String buildlog) {
		this.buildlog = buildlog;
	}

	public int getProcessbar() {
		return processbar;
	}
	public void setProcessbar(int processbar) {
		this.processbar = processbar;
	}
	
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
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
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 获取精度条所需数据
	 * @return
	 */
	@Action(value = "findProcessBar", results = { 
			@Result(name = "json",type="json")
	})
	public String findProcessBar(){
		this.getProcessbar();
		return "json";
	}
	
	/**
	 * 生成所有静态数据
	 * 
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("finally")
	@Action(value = "buildAllHtml", results = { 
			@Result(name = "json",type="json")
	})
	public String buildAllHtml() throws IOException, TemplateException, IllegalAccessException {
		StringBuilder buildhtmllog=new StringBuilder();
		final Logger log = LoggerFactory.getLogger(BuildHtmlPages.class);
		//开始收集公共数据
		try{
			//生成记录开始
			buildhtmllog.append("<p>1,获取默认主题信息</p>");
			log.info("<p>1,获取默认主题信息</p>");
			this.setProcessbar(2);//进度2%
			//获取默认主题
			this.getInitTAction().InitDefaultThemeT();
			buildhtmllog.append(this.getInitTAction().getLogmsg());
			//创建ftl模板数据
			buildhtmllog.append("<p>2,创建FTL模板数据</p>");
			log.info("<p>2,创建FTL模板数据</p>");
			this.getCreateHtml().recreateTemplate();
			buildhtmllog.append(this.getCreateHtml().getLogmsg());
			//获取根目录
			buildhtmllog.append("<p>3,获取网站根目录</p>");
			log.info("<p>3,获取网站根目录</p>");
			map.put(FreeMarkervariable.BASEPATH,this.getDataCollectionTAction().getBasePath());
			buildhtmllog.append("<p>根目录获取成功</p>");
			log.info("<p>根目录获取成功</p>");
			//获取session
//			buildhtmllog.append("<p>4,获取Session数据</p>");
//			map.put(FreeMarkervariable.SESSION, this.getDataCollectionTAction().getSession());
//			buildhtmllog.append("<p>Session数据获取成功</p>");
			//获取导航数据
			buildhtmllog.append("<p>5,获取导航数据<p>");
			log.info("<p>5,获取导航数据<p>");
			map.put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation(StaticKey.SiteNavigationState.SHOW.getVisible()));
			buildhtmllog.append(this.getDataCollectionTAction().getLogmsg());
			//获取商城基本数据
			buildhtmllog.append("<p>6,获取商城基础数据</p>");
			log.info("<p>6,获取商城基础数据</p>");
			map.put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo(StaticKey.DataShowState.SHOW.getState(),StaticKey.JshopOpenState.OPEN.getOpenstate()));
			buildhtmllog.append(this.getDataCollectionTAction().getLogmsg());
			
			
			//获取商品分类左侧主导航
			buildhtmllog.append("<p>7,获取商品分类导航数据</p>");
			log.info("<p>7,获取商品分类导航数据</p>");
			map.put(FreeMarkervariable.GOODSCATEGORYTREE, this.getDataCollectionTAction().findGoodsCategoryT(StaticKey.DataGrade.FIRST.getState(),StaticKey.DataShowState.SHOW.getState()));
			map.put(FreeMarkervariable.GOODSCATEGORYTREEFIRSTCOUNT, this.getDataCollectionTAction().getGoodsCategoryTreeFirstCount());
			buildhtmllog.append(this.getDataCollectionTAction().getLogmsg());
			//获取页脚分类数据
			buildhtmllog.append("<p>8,获取商城页脚分类数据</p>");
			log.info("<p>8,获取商城页脚分类数据</p>");
			//这里获取页脚帮助中心的分类，取值放在freemarker文件中
			map.put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT(StaticKey.DataGrade.FIRST.getState(),StaticKey.DataShowState.SHOW.getState()));
			buildhtmllog.append(this.getDataCollectionTAction().getLogmsg());
			//获取页脚文章数据
			buildhtmllog.append("<p>9,获取商城页脚文章数据</p>");
			log.info("<p>9,获取商城页脚文章数据</p>");
			map.put(FreeMarkervariable.FOOTERATRICLE,this.getDataCollectionTAction().findFooterArticle(StaticKey.DataShowState.SHOW.getState()));
			buildhtmllog.append(this.getDataCollectionTAction().getLogmsg());
			//获取首页自定义区域
			buildhtmllog.append("<p>10,获取首页自定义区域数据</p>");
			
			//获取系统所有文章数据
			map.put(FreeMarkervariable.ALLARTICLE, this.getDataCollectionTAction().findAllArticleT(StaticKey.DataShowState.SHOW.getState()));
			
			this.setProcessbar(20);//进度20%
			
			//根据模板生成静态页
			List<TemplatesetT>list=this.getTemplatesetTService().findTemplatesetTBystatus("1");
			if(!list.isEmpty()){
				this.setProcessbar(30);//进度30%
				for(Iterator it=list.iterator();it.hasNext();){
					if(list.size()+this.getProcessbar()<=100){
						this.setProcessbar(this.getProcessbar()+5);
					}
					TemplatesetT tt=(TemplatesetT)it.next();
					if(tt.getSign().equals(BaseTools.getApplicationthemesign()+"_"+ContentTag.TEMPLATENAMEFORGOODSDETAIL)){
						this.getCreateHtml().buildGoodsdetailsPage(map);
						buildhtmllog.append(this.getCreateHtml().getLogmsg().toString());
					}else if(tt.getSign().equals(BaseTools.getApplicationthemesign()+"_"+ContentTag.TEMPLATENAMEFORARTICLE)){
						this.getCreateHtml().buildArticlesPage(map);
						buildhtmllog.append(this.getCreateHtml().getLogmsg().toString());
					}else if(tt.getSign().equals(BaseTools.getApplicationthemesign()+"_"+ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST)){
						this.getCreateHtml().buildGoodsCategoryPage(map);
						buildhtmllog.append(this.getCreateHtml().getLogmsg().toString());
					}else if(tt.getSign().equals(BaseTools.getApplicationthemesign() + "_" + ContentTag.TEMPLATENAMEFORNOTICE)){
						this.getCreateHtml().buildNoticeArticlesPage(map);
						buildhtmllog.append(this.getCreateHtml().getLogmsg().toString());
					}else if(tt.getSign().equals(BaseTools.getApplicationthemesign()+"_"+ContentTag.TEMPLATENAME4NOTICELIST)){
						//创建帮助中心（页脚分类）的列表页
						this.getCreateHtml().buildHelpCenterArticlelist(map);
					}else{
						this.getCreateHtml().createNormalhtml(tt.getSign(), "", map);
						buildhtmllog.append(this.getCreateHtml().getLogmsg().toString());
					}
				}
				
			}
			
			
			
		}catch(Exception e){
			if(e.getMessage()!=null){
				buildhtmllog.append("<p style='color:red;'>"+e.getMessage()+"出现异常请根据反馈信息修复</p>");
				log.info("<p style='color:red;'>"+e.getMessage()+"出现异常请根据反馈信息修复</p>");
				this.setBuildlog(buildhtmllog.toString());
			}
			
		}
		this.setProcessbar(100);//进度100%
		this.setBuildlog(buildhtmllog.toString());
		this.setStatus("success");
		return "json";
		
		
	}
	/**
	 * 根据userid获取购物车信息(给普通商品使用ordertag=1)
	 * 
	 * @return
	 */
	@Action(value = "showindex", results = { @Result(name = "success", type = "freemarker", location = "/WEB-INF/theme/default/shop/login.ftl"), @Result(name = "input", type = "redirect", location = "/html/default/shop/user/login.html?redirecturl=${redirecturl}") })
	public String showindex() {
		//路径获取
		ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
		//获取商城基本数据
		ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo(StaticKey.DataShowState.SHOW.getState(),StaticKey.JshopOpenState.OPEN.getOpenstate()));
		//获取导航数据
		ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation(StaticKey.SiteNavigationState.SHOW.getVisible()));
		return SUCCESS;
		
	}
	
	/**
	 * 生成首页静态页
	 * @return
	 */
	@Action(value = "buildIndexHtml", results = { 
			@Result(name = "json",type="json")
	})
	public String buildIndexHtml(){
		Map<String,Object>map=new HashMap<String,Object>();
		map=this.getDataCollectionTAction().getBaseInfoContext(map);
		map.put(FreeMarkervariable.GOODSCATEGORYTREE, this.getDataCollectionTAction().findGoodsCategoryT(StaticKey.DataGrade.FIRST.getState(),StaticKey.DataShowState.SHOW.getState()));
		map.put(FreeMarkervariable.GOODSCATEGORYTREEFIRSTCOUNT, this.getDataCollectionTAction().getGoodsCategoryTreeFirstCount());
		//获取此商品顶级分类的热销商品集合
		map.put(FreeMarkervariable.RECOMMENDGOODSLIST, this.getDataCollectionTAction().getrecommendGoods(StaticKey.GoodsState.SALE.getState(), 4));
		this.getCreateHtml().createNormalhtml(BaseTools.getApplicationthemesign()+"_"+ContentTag.TEMPLATENAMEFORINDEX, "", map);
		this.setSucflag(true);
		return "json";
	}
	
	/**
	 * 根据商品分类生成商品详情页
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	@Action(value = "buildGoodsdetailHtml", results = { 
			@Result(name = "json",type="json")
	})
	public String buildGoodsdetailHtml() throws IOException, TemplateException{
		if(StringUtils.isNotBlank(this.getNavid())){
			this.getCreateHtml().buildGoodsdetailPageByCategory(this.getNavid(),null,null);
			this.setSucflag(true);
		}
		if(StringUtils.isNotBlank(this.getLtypeid())){
			this.getCreateHtml().buildGoodsdetailPageByCategory(null,this.getLtypeid(),null);
			this.setSucflag(true);
		}
		if(StringUtils.isNotBlank(this.getStypeid())){
			this.getCreateHtml().buildGoodsdetailPageByCategory(null,null,this.getStypeid());
			this.setSucflag(true);
		}
		return "json";
	}
	/**
	 * 静态化所有商品详情页
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	@Action(value = "buildAllGoodsdetailHtml", results = { 
			@Result(name = "json",type="json")
	})
	public String buildAllGoodsdetailHtml() throws IOException, TemplateException{
		this.getCreateHtml().buildAllGoodsdetailsPage();
		this.setSucflag(true);
		return "json";
	}
	
	/**
	 * 根据商品分类生成商品详情页
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	@Action(value = "buildArticledetailHtml", results = { 
			@Result(name = "json",type="json")
	})
	public String buildArticledetailHtml(){
		if(StringUtils.isNotBlank(this.getNavid())){
			this.getCreateHtml().buildArticlesdetailPage(this.getNavid(),null,null);
			this.setSucflag(true);
		}
		if(StringUtils.isNotBlank(this.getLtypeid())){
			this.getCreateHtml().buildArticlesdetailPage(null,this.getLtypeid(),null);
			this.setSucflag(true);
		}
		if(StringUtils.isNotBlank(this.getStypeid())){
			this.getCreateHtml().buildArticlesdetailPage(null,null,this.getStypeid());
			this.setSucflag(true);
		}
		return "json";
	}
	
	/**
	 * 静态化所有文章详情页
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	@Action(value = "buildAllArticledetailHtml", results = { 
			@Result(name = "json",type="json")
	})
	public String buildAllArticledetailHtml() throws IOException, TemplateException{
		this.getCreateHtml().buildAllArticlesdetailPage();
		this.setSucflag(true);
		return "json";
	}
	
	

	
}
