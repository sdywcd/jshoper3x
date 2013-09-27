package com.jshop.action.backstage.template;

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
import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.ContentTag;
import com.jshop.action.backstage.tools.PageModel;
import com.jshop.entity.ArticleT;
import com.jshop.entity.GoodsCategoryT;
import com.jshop.entity.GoodsGroupT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.TemplateT;
import com.jshop.entity.TemplatesetT;
import com.jshop.service.ArticleTService;
import com.jshop.service.GoodsCategoryTService;
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
	private TemplateTAction templateTAction;
	private TemplateTService templateTService;
	private TemplatesetTService templatesetTService;
	private GoodsTService goodsTService;
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
	private PageModel pm = new PageModel();
	private String status;
	private boolean slogin;
	private StringBuilder logmsg=new StringBuilder();
	
	
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
	public PageModel getPm() {
		return pm;
	}

	public void setPm(PageModel pm) {
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
	 * 生成商品静态页
	 */
	public void buildGoodsdetailsPage(Map<String, Object> map) throws IOException, TemplateException {
		List<GoodsT> glist = this.getDataCollectionTAction().findAllGoodsT();
		for (Iterator it = glist.iterator(); it.hasNext();) {
			GoodsT gt = (GoodsT) it.next();
//			if(!gt.getCreatetime().equals(gt.getUpdatetime())){
				map.put(FreeMarkervariable.GOODSDETAIL, gt);
				//获取商品参数
				map.put(FreeMarkervariable.GOODSPARAMETERS,this.getGoodsTAction().processGoodsparameters(gt));
				//获取商品评论
				map.put(FreeMarkervariable.GOODSCOMMENTS, this.getDataCollectionTAction().findGoodsCommentBygoodsid(gt));
				//获取规格值
				map.put(FreeMarkervariable.GOODSSPECIFICATION, this.getDataCollectionTAction().findProductSpecificationsTByspecificationsid(gt));
				//获取关联商品
				map.put(FreeMarkervariable.GOODSBELINKED, this.getDataCollectionTAction().findGoodsBelinkedTBygoodsid(gt));
				String htmlPath = this.createGoodsT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSDETAIL, gt.getGoodsid(), map);
				this.getGoodsTService().updateHtmlPath(gt.getGoodsid(), htmlPath,gt.getCreatetime());
//			}
		}
	}

	/**
	 * 生成文章静态页
	 * 
	 * @throws IOException
	 * @throws TemplateException
	 */
	public void buildArticlesPage(Map<String, Object> map) throws IOException, TemplateException {
		List<ArticleT> alist = this.getDataCollectionTAction().findAllArticleT();
		if (!alist.isEmpty()) {
			for (Iterator it = alist.iterator(); it.hasNext();) {
				ArticleT at = (ArticleT) it.next();
//				if(!at.getCreatetime().equals(at.getUpdatetime())){
					if(!"1".equals(at.getIsnotice())){
						map.put(FreeMarkervariable.ARTICLE, at);
						String htmlPath = this.createArticleT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORARTICLE, at.getArticleid(), map);
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
		List<ArticleT> alist = this.getDataCollectionTAction().findAllArticleT();
		if (!alist.isEmpty()) {
			for (Iterator it = alist.iterator(); it.hasNext();) {
				ArticleT at = (ArticleT) it.next();
//				if(!at.getCreatetime().equals(at.getUpdatetime())){
					if("1".equals(at.getIsnotice())){
						map.put(FreeMarkervariable.ARTICLE, at);
						String htmlPath = this.createArticleT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORNOTICE, at.getArticleid(), map);
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
		String salestate = "1";//salestate=1表示上架商品
		List<GoodsCategoryT> gclist = this.getDataCollectionTAction().findAllGoodsCategoryTByState();//读取所有启用的商品分类
		if (!gclist.isEmpty()) {
			List<GoodsT> list = new ArrayList<GoodsT>();
			for (Iterator it = gclist.iterator(); it.hasNext();) {
				GoodsCategoryT gct = (GoodsCategoryT) it.next();
				map.put(FreeMarkervariable.GOODSCATEGORY, gct);
				if (gct.getGrade().equals("0")) {
					String navid = gct.getGoodsCategoryTid();
					//生成上架状态的商品分类静态页
					list = this.getGoodsTService().findAllGoodsBynavid(navid, salestate);
					if (list != null) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.SIGN, gct.getSign());//页面链接标示
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));//收集商品类型下的品牌
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid()));//获取此分类下的二级分类
						String htmlPath = this.createGoodsCategoryT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign(), map);
						this.getGoodsCategoryTService().updateHtmlPath(gct.getGoodsCategoryTid(), htmlPath);
						
					}
					//生成按照销量排序
					list = this.getGoodsTService().findAllGoodsBynavidorderbyParams(navid, salestate, "sales", null, null, null, null, null, null, null);
					if (list != null) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "sales");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid()));//获取此分类下的二级分类
						this.createGoodsCategoryT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "sales", map);

					}
					//生成按照会员价格排序
					list = this.getGoodsTService().findAllGoodsBynavidorderbyParams(navid, salestate, null, "memberprice", null, null, null, null, null, null);
					if (list != null) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "memberprice");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid()));//获取此分类下的二级分类
						this.createGoodsCategoryT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "memberprice", map);

					}
					//生成按照评论排序
					list = this.getGoodsTService().findAllGoodsBynavidorderbyParams(navid, salestate, null, null, "totalcomment", null, null, null, null, null);
					if (list != null) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "totalcomment");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid()));//获取此分类下的二级分类
						this.createGoodsCategoryT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "totalcomment", map);

					}

					//生成按照特价筛选
					//List<GoodsT>listb=new ArrayList<GoodsT>();
					list = this.getGoodsTService().findAllGoodsBynavidorderbyParams(navid, salestate, null, null, null, "bargainprice", null, null, null, "1");
					if (list != null) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "bargainprice");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid()));//获取此分类下的二级分类
						this.createGoodsCategoryT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "bargainprice", map);
					}
					//生成按照热销筛选
					list = this.getGoodsTService().findAllGoodsBynavidorderbyParams(navid, salestate, null, null, null, null, "hotsale", null, null, "1");
					if (list != null) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "hotsale");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid()));//获取此分类下的二级分类
						this.createGoodsCategoryT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "hotsale", map);
					}

					//生成按照推荐排序
					list = this.getGoodsTService().findAllGoodsBynavidorderbyParams(navid, salestate, null, null, null, null, null, "recommended", null, "1");
					map.put(FreeMarkervariable.ALLGOODS, list);
					map.put(FreeMarkervariable.SIGN, gct.getSign() + "recommended");
					map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
					map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
					map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid()));//获取此分类下的二级分类
					this.createGoodsCategoryT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "recommended", map);
					//生成按照新品排序
					list = this.getGoodsTService().findAllGoodsBynavidorderbyParams(navid, salestate, null, null, null, null, null, null, "isNew", "1");
					map.put(FreeMarkervariable.ALLGOODS, list);
					map.put(FreeMarkervariable.SIGN, gct.getSign() + "isNew");
					map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
					map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
					map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid()));//获取此分类下的二级分类
					this.createGoodsCategoryT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "isNew", map);
				} else if (gct.getGrade().equals("1")) {
					String ltypeid = gct.getGoodsCategoryTid();
					//生成上架状态的商品分类静态页
					list = this.getGoodsTService().findGoodsByLtypeid(ltypeid, salestate);
					if (list != null) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.SIGN, gct.getSign());//页面链接标示
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid()));//获取此分类下的二级分类
						String htmlPath = this.createGoodsCategoryT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign(), map);
						this.getGoodsCategoryTService().updateHtmlPath(gct.getGoodsCategoryTid(), htmlPath);
					}
					//生成按照销量排序
					list = this.getGoodsTService().findAllGoodsByLtypeidorderbyParams(ltypeid, salestate, "sales", null, null, null, null, null, null, null);
					if (list != null) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "sales");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid()));//获取此分类下的二级分类
						this.createGoodsCategoryT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "sales", map);

					}
					//生成按照会员价格排序
					list = this.getGoodsTService().findAllGoodsByLtypeidorderbyParams(ltypeid, salestate, null, "memberprice", null, null, null, null, null, null);
					if (list != null) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "memberprice");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid()));//获取此分类下的二级分类
						this.createGoodsCategoryT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "memberprice", map);

					}
					//生成按照评论排序
					list = this.getGoodsTService().findAllGoodsByLtypeidorderbyParams(ltypeid, salestate, null, null, "totalcomment", null, null, null, null, null);
					if (list != null) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "totalcomment");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid()));//获取此分类下的二级分类
						this.createGoodsCategoryT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "totalcomment", map);

					}

					//生成按照特价筛选
					//List<GoodsT>listb=new ArrayList<GoodsT>();
					list = this.getGoodsTService().findAllGoodsByLtypeidorderbyParams(ltypeid, salestate, null, null, null, "bargainprice", null, null, null, "1");
					if (list != null) {
						map.put(FreeMarkervariable.ALLGOODS, list);
						map.put(FreeMarkervariable.SIGN, gct.getSign() + "bargainprice");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid()));//获取此分类下的二级分类
						this.createGoodsCategoryT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "bargainprice", map);
					}
					//生成按照热销筛选
					list = this.getGoodsTService().findAllGoodsByLtypeidorderbyParams(ltypeid, salestate, null, null, null, null, "hotsale", null, null, "1");
					if (list != null) {
						map.put("allgoods", list);
						map.put("sign", gct.getSign() + "hotsale");
						map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
						map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
						map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid()));//获取此分类下的二级分类
						this.createGoodsCategoryT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "hotsale", map);
					}

					//生成按照推荐排序
					list = this.getGoodsTService().findAllGoodsByLtypeidorderbyParams(ltypeid, salestate, null, null, null, null, null, "recommended", null, "1");
					map.put(FreeMarkervariable.ALLGOODS, list);
					map.put(FreeMarkervariable.SIGN, gct.getSign() + "recommended");
					map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
					map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
					map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid()));//获取此分类下的二级分类
					this.createGoodsCategoryT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "recommended", map);
					//生成按照新品排序
					list = this.getGoodsTService().findAllGoodsByLtypeidorderbyParams(ltypeid, salestate, null, null, null, null, null, null, "isNew", "1");
					map.put(FreeMarkervariable.ALLGOODS, list);
					map.put(FreeMarkervariable.SIGN, gct.getSign() + "isNew");
					map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
					map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
					map.put(FreeMarkervariable.SECONDGOODSCATEGORY, this.getDataCollectionTAction().findSecondGoodsCategoryT(gct.getGoodsCategoryTid()));//获取此分类下的二级分类
					this.createGoodsCategoryT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign() + "isNew", map);
				} else {
					String stypeid = gct.getGoodsCategoryTid();
					list = this.getGoodsTService().findGoodsByStypeid(stypeid, salestate);
					map.put(FreeMarkervariable.ALLGOODS, list);
					map.put(FreeMarkervariable.GOODSTYPEBRAND, this.getDataCollectionTAction().findGoodsTypeBrandBygoodsType(gct.getGoodsTypeId()));
					map.put(FreeMarkervariable.GOODSATTRS, this.getDataCollectionTAction().findGoodsAttributeTBygoodsTypeId(gct.getGoodsTypeId()));//收集商品类型下的商品属性
					String htmlPath = this.createGoodsCategoryT(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST, gct.getSign(), map);
					this.getGoodsCategoryTService().updateHtmlPath(gct.getGoodsCategoryTid(), htmlPath);
				}
			}

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
		map.put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo());
		map.put(FreeMarkervariable.USERACTIVATES, emailcontent);
		return this.createEmail(ContentTag.TEMPLATENAMEFOREMAIL, BaseTools.adminCreateId(), map);

	}

	/**
	 * 生成活动邮件模板数据
	 * 
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	public String buildactivityEmail(String emailcontent) throws IOException, TemplateException {
		map.put(FreeMarkervariable.BASEPATH, this.getBasePath());
		map.put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo());
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
		map.put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo());
		this.createNormalhtml(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORUSERACTIVATESCALLBACK, null, map);
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
	public static List<GoodsT> getDataByPageNo(int pageNo, int pageSize, List<GoodsT> lstGoods) {
		int totalpage = pageNo * pageSize > lstGoods.size() ? lstGoods.size() : pageNo * pageSize;
		return lstGoods.subList((pageNo - 1) * pageSize, totalpage);
	}

	/**
	 * 获取网站根目录
	 * 
	 * @param map
	 * @throws UnknownHostException
	 *             InetAddress inet = InetAddress.getLocalHost();
	 *             request.getScheme() + "://" + inet.getHostAddress() + ":" +
	 *             request.getServerPort() +
	 */
	public String getBasePath() throws UnknownHostException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getContextPath();
		String basePath = path + "/";
		return basePath;
	}

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
		int pageSize = 12;
		try{
			setbean = this.getTemplatesetTService().findTemplatesetTBysign(sign);
			if (setbean != null) {
				map.put("basePath", this.getBasePath());
				String ftl = setbean.getTemplateurl();
				String folder = setbean.getBuildhtmlpath();
				String fileName;
				String relativePath = "";
				List<GoodsT> allGoods = (List<GoodsT>) data.get("allgoods");
				if (allGoods != null && allGoods.size() > 0) {
					PageModel<GoodsT> pms = new PageModel<GoodsT>(1, pageSize, null, allGoods.size());
					long totalPage = pms.getTotalpage();
					for (int i = 1; i <= totalPage; i++) {
						PageModel<GoodsT> pm = new PageModel<GoodsT>(i, pageSize, CreateHtml.getDataByPageNo(i, pageSize, allGoods), allGoods.size());
						data.put("goods", pm);
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
			map.put("basePath", this.getBasePath());
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
			map.put("basePath", this.getBasePath());
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
			List<TemplateT> tlist = this.getTemplateTService().findAllTemplateWithNoParam(BaseTools.adminCreateId(), "1");
			if (!tlist.isEmpty()) {
				for (Iterator it = tlist.iterator(); it.hasNext();) {
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
		for(Iterator it=list.iterator();it.hasNext();){
			GoodsGroupT ggt = (GoodsGroupT) it.next();
			map.put(FreeMarkervariable.GOODSGROUPT, ggt);
			String htmlpath = this.createGoodsGroup(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSGROUPT, ggt.getGroupid(), map);
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
