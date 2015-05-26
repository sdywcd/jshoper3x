package com.jshop.action.mall.backstage.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jshop.action.mall.backstage.staticspage.FreeMarkervariable;
import com.jshop.action.mall.backstage.utils.BaseTools;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.CategoryGrade;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.DataShowState;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.DataUsingState;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.GoodsSaleState;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.GoodsState;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.IsDefault;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.JshopOpenState;
import com.jshop.action.mall.backstage.utils.statickey.StaticKey;
import com.jshop.entity.ArticleCategoryT;
import com.jshop.entity.ArticleT;
import com.jshop.entity.BrandT;
import com.jshop.entity.GoodsAttributeT;
import com.jshop.entity.GoodsBelinkedT;
import com.jshop.entity.GoodsCategoryT;
import com.jshop.entity.GoodsCommentT;
import com.jshop.entity.GoodsDetailRpT;
import com.jshop.entity.GoodsSpecificationsProductRpT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.GoodsTypeBrandT;
import com.jshop.entity.GoodsTypeTN;
import com.jshop.entity.JshopbasicInfoT;
import com.jshop.entity.ProductSpecificationsT;
import com.jshop.entity.SiteNavigationT;
import com.jshop.entity.TemplatethemeT;
import com.jshop.service.ArticleCategoryTService;
import com.jshop.service.ArticleTService;
import com.jshop.service.BrandTService;
import com.jshop.service.GoodsAttributeTService;
import com.jshop.service.GoodsBelinkedTService;
import com.jshop.service.GoodsCategoryTService;
import com.jshop.service.GoodsCommentTService;
import com.jshop.service.GoodsDetailRpTService;
import com.jshop.service.GoodsSpecificationsProductRpTService;
import com.jshop.service.GoodsTService;
import com.jshop.service.GoodsTypeBrandTService;
import com.jshop.service.GoodsTypeTNService;
import com.jshop.service.JshopbasicInfoTService;
import com.jshop.service.ProductSpecificationsTService;
import com.jshop.service.SiteNavigationTService;
import com.jshop.service.TemplatethemeTService;
import com.jshop.vo.GoodsBelinkedModel;
import com.jshop.vo.GoodsCategoryPathVo;
import com.jshop.vo.GoodsParameterInGoodsTVo;
import com.jshop.vo.GoodsParameterInGoodsTypeTnVo;
import com.jshop.vo.GoodsParameterlistVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.emory.mathcs.backport.java.util.Collections;

/**
 * 数据收集 收集所有模板页面需要的数据
 * 
 * @author cd
 * 
 */

@ParentPackage("json-default")
@Namespace("")
@Controller("dataCollectionTAction")
public class DataCollectionTAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource
	private JshopbasicInfoTService jshopbasicInfoTService;
	@Resource
	private SiteNavigationTService siteNavigationTService;
	@Resource
	private GoodsCategoryTService goodsCategoryTService;
	@Resource
	private BrandTService brandTService;
	@Resource
	private GoodsTypeBrandTService goodsTypeBrandTService;
	@Resource
	private ProductSpecificationsTService productSpecificationsTService;
	@Resource
	private GoodsSpecificationsProductRpTService goodsSpecificationsProductRpTService;
	@Resource
	private GoodsTypeTNService goodsTypeTNService;
	@Resource
	private GoodsTService goodsTService;
	@Resource
	private GoodsDetailRpTService goodsDetailRpTService;
	@Resource
	private ArticleTService articleTService;
	@Resource
	private ArticleCategoryTService articleCategoryTService;
	@Resource
	private GoodsAttributeTService goodsAttributeTService;
	@Resource
	private GoodsCommentTService goodsCommentTService;
	@Resource
	private TemplatethemeTService templatethemeTService;
	@Resource
	private GoodsBelinkedTService goodsBelinkedTService;
	private int gradecount;
	private Gson gson=new Gson();
	private TemplatethemeT tt;
	private String logmsg;

	public int getGradecount() {
		return gradecount;
	}

	public void setGradecount(int gradecount) {
		this.gradecount = gradecount;
	}

	public String getLogmsg() {
		return logmsg;
	}

	public void setLogmsg(String logmsg) {
		this.logmsg = logmsg;
	}

	public TemplatethemeT getTt() {
		return tt;
	}

	public void setTt(TemplatethemeT tt) {
		this.tt = tt;
	}

	/**
	 * 初始化后台所需要的数据
	 * 
	 * @return
	 */
	public String getDefaultTheme() {
		String status = IsDefault.DEFAULT.getState();// 标示默认主题
		Criterion criterion=Restrictions.eq("status", status);
		tt = this.templatethemeTService.findOneByCriteria(TemplatethemeT.class, criterion);
		if (tt != null) {
			// 将启用的模板主题标示加入到服务器内存中
			if (!tt.getSign().isEmpty()) {
				return tt.getSign();
			} else {
				// 如果没有默认的模板，那么启用默认主题模板
				return StaticKey.DEFAULT_THEME;
			}
		}
		return StaticKey.DEFAULT_THEME;
	}

	

	/**
	 * 将路径，导航，商城基本信息，页脚分类，页脚文章put到上下文中
	 */
	public void putBaseInfoToContext(){
		//路径获取
		ActionContext.getContext().put(FreeMarkervariable.BASEPATH, BaseTools.getBasePath());
		//获取导航数据
		ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, findSiteNavigation(DataShowState.SHOW.getState()));
		//获取商城基本数据
		ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO,findJshopbasicInfo(DataShowState.SHOW.getState(),JshopOpenState.OPEN.getState()));
		//获取页脚分类数据
		ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, findFooterCateogyrT(CategoryGrade.FIRST.getState(),DataUsingState.USING.getState()));
		//获取页脚文章数据
		ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, findFooterArticle(DataShowState.SHOW.getState()));
	}
	
	
	/**
	 * 将路径，导航，商城基本信息，页脚分类，页脚文章放入map中用于静态化
	 * @param map
	 * @return
	 */
	public Map<String,Object> getBaseInfoContext(Map<String,Object> map){
		map.put(FreeMarkervariable.BASEPATH, BaseTools.getBasePath());
		map.put(FreeMarkervariable.SITENAVIGATIONLIST, findSiteNavigation(DataShowState.SHOW.getState()));
		map.put(FreeMarkervariable.JSHOPBASICINFO,findJshopbasicInfo(DataShowState.SHOW.getState(),JshopOpenState.OPEN.getState()));
		map.put(FreeMarkervariable.FOOTCATEGORY, findFooterCateogyrT(CategoryGrade.FIRST.getState(),DataUsingState.USING.getState()));
		map.put(FreeMarkervariable.FOOTERATRICLE, findFooterArticle(DataShowState.SHOW.getState()));
		return map;
	}
//	
//	/**
//	 * 获取session数据
//	 * 
//	 * @return
//	 */
//	public Map<String, Object> getSession() {
//		return ActionContext.getContext().getSession();
//	}

	/**
	 * 获取商城基本信息
	 * @param state 1 可用 商城状态标记
	 * @param openstate 1  开启 商城开启运作标记
	 * @return
	 */
	public JshopbasicInfoT findJshopbasicInfo(String state,String openstate) {
		try {
			Criterion criterion=Restrictions.and(Restrictions.eq("state", state)).add(Restrictions.eq("openstate", openstate));
			JshopbasicInfoT bean = this.jshopbasicInfoTService.findOneByCriteria(JshopbasicInfoT.class, criterion);
			if (bean != null) {
				return bean;
			}
		} catch (Exception e) {
			this.setLogmsg("<p style='color:red;'>" + e.getMessage() + "</p>");
		}
		this.setLogmsg("<p>商城基础信息获取成功");
		return (JshopbasicInfoT) Collections.emptyList().get(0);
	}

	/**
	 * 获取导航
	 */
	@SuppressWarnings({ "unchecked" })
	public List<SiteNavigationT> findSiteNavigation(String isVisible) {
		try {
			Criterion criterion=Restrictions.eq("isVisible", isVisible);
			List<SiteNavigationT> list =this.siteNavigationTService.findByCriteria(SiteNavigationT.class, criterion);
			if (!list.isEmpty()) {
				return list;
			}
		} catch (Exception e) {
			this.setLogmsg("<p style='color:red;'>" + e.getMessage() + "</p>");
		}
		this.setLogmsg("<p>获取导航数据成功</p>");
		return Collections.emptyList();
	}

	
	/**
	 * 读取左侧主导航(商品分类)
	 * @param state 分类状态1显示 0隐藏
	 * @param grade 分类等级
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsCategoryT> findGoodsCategoryT(String grade,String state) {
		try {
			gradecount=0;
			Criterion criterion=Restrictions.eq("state", state);
			List<GoodsCategoryT> list = this.goodsCategoryTService.findByCriteria(GoodsCategoryT.class, criterion);
			if (!list.isEmpty()) {
				for (Iterator<GoodsCategoryT> it = list.iterator(); it.hasNext();) {
					GoodsCategoryT gt = (GoodsCategoryT) it.next();
					//grade=0 表示顶级分类
					if (gt.getGrade().equals(grade)&&gt.getHtmlpath().length()>0) {
						gradecount++;
					}
				}
				return list;
			}
		} catch (Exception e) {
			this.setLogmsg("<p style='color:red;'>" + e.getMessage() + "</p>");
		}
		this.setLogmsg("<p>商品分类导航数据获取成功</p>");
		return Collections.emptyList();

	}

	/**
	 * 统计顶级分类个数
	 * 
	 * @return
	 */
	public int getGoodsCategoryTreeFirstCount() {
		return this.getGradecount();
	}

	/**
	 * 根据状态获取商品分类,用于生成静态分页商品列表
	 * 
	 * @return
	 */
	public List<GoodsCategoryT> findAllGoodsCategoryTByState(String state) {
		Criterion criterion=Restrictions.eq("state", state);
		List<GoodsCategoryT> list = this.goodsCategoryTService.findByCriteria(GoodsCategoryT.class, criterion);
		if (!list.isEmpty()) {
			return list;
		}
		return Collections.emptyList();
	}

	/**
	 * 获取二级商品分类
	 * 
	 * @param parentId
	 * @return
	 */
	public List<GoodsCategoryT> findSecondGoodsCategoryT(String parentId,String state) {
		Criterion criterion=Restrictions.and(Restrictions.eq("state", state)).add(Restrictions.eq("parentId", parentId));
		List<GoodsCategoryT> list = this.goodsCategoryTService.findByCriteria(GoodsCategoryT.class, criterion);
		if (!list.isEmpty()) {
			return list;
		}
		return Collections.emptyList();
	}

	/**
	 * 查询所有上架商品数据
	 * 
	 * @return
	 */
	public List<GoodsT> findAllGoodsT(String salestate) {
		Criterion criterion=Restrictions.eq("salestate", salestate);
		List<GoodsT> list = this.goodsTService.findByCriteria(GoodsT.class, criterion);
		if (!list.isEmpty()) {
			return list;
		}
		return Collections.emptyList();

	}

	/**
	 * 获取所有文章数据
	 * @return
	 */
	public List<ArticleT> findAllArticleT(String status) {
		Criterion criterion=Restrictions.eq("status", status);
		List<ArticleT> list = this.articleTService.findByCriteria(ArticleT.class, criterion);
		if (!list.isEmpty()) {
			return list;
		} else {
			return Collections.emptyList();
		}
	}

	/**
	 * 获取页脚文章一级分类
	 */
	public List<ArticleCategoryT> findFooterCateogyrT(String grade,String status) {
		try {
			Criterion criterion=Restrictions.and(Restrictions.eq("grade", grade)).add(Restrictions.eq("status", status));
			List<ArticleCategoryT> list = this.articleCategoryTService.findByCriteria(ArticleCategoryT.class, criterion);
			if (!list.isEmpty()) {
				return list;
			}
		} catch (Exception e) {
		}
		return Collections.emptyList();
	}

	/**
	 * 获取页脚文章一级分类下得文章
	 */
	public List<ArticleT> findFooterArticle(String status) {
		try {
			Criterion criterion=Restrictions.eq("status", status);
			List<ArticleT> list = this.articleTService.findByCriteria(ArticleT.class, criterion);
			if (!list.isEmpty()) {
				List<ArticleT> list1 = new ArrayList<ArticleT>();
				for (Iterator<ArticleT> it = list.iterator(); it.hasNext();) {
					ArticleT at = (ArticleT) it.next();
					if (at.getPosition() != null
							&& at.getPosition().equals(StaticKey.ONE)) {
						list1.add(at);
					}
				}
				return list1;
			}
		} catch (Exception e) {
			
		}
		return Collections.emptyList();

	}
	/**
	 * 根据一级文章分类获取文章数据
	 * @param navid
	 * @return
	 */
	public List<ArticleT>getArticlesByNavidCategoryT(String navid){
		Criterion criterion=Restrictions.and(Restrictions.eq("navid", navid)).add(Restrictions.eq("state", DataShowState.SHOW.getState()));
		List<ArticleT>list=this.articleTService.findByCriteria(ArticleT.class, criterion);
		if(!list.isEmpty()){
			return list;
		}
		return Collections.emptyList();
	}
	/**
	 * 根据二级文章分类获取文章数据
	 * @param ltypeid
	 * @return
	 */
	public List<ArticleT>getArticlesByLtypeidCategoryT(String ltypeid){
		Criterion criterion=Restrictions.and(Restrictions.eq("ltypeid", ltypeid)).add(Restrictions.eq("state", DataShowState.SHOW.getState()));
		List<ArticleT>list=this.articleTService.findByCriteria(ArticleT.class, criterion);
		if(!list.isEmpty()){
			return list;
		}
		return Collections.emptyList();
	}
	/**
	 * 根据三级文章分类获取文章数据
	 * @param ltypeid
	 * @return
	 */
	public List<ArticleT>getArticlesByStypeidCategoryT(String stypeid){
		Criterion criterion=Restrictions.and(Restrictions.eq("stypeid", stypeid)).add(Restrictions.eq("state", DataShowState.SHOW.getState()));
		List<ArticleT>list=this.articleTService.findByCriteria(ArticleT.class, criterion);
		if(!list.isEmpty()){
			return list;
		}
		return Collections.emptyList();
	}
	

	
	
	/**
	 * 获取所有的商品品牌数据
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<BrandT> findAllBrandt() {
		try {
			List<BrandT> list = this.brandTService.findAll(BrandT.class);
			if (!list.isEmpty()) {
				return list;
			}
		} catch (Exception e) {
			this.setLogmsg("<p style='color:red;'>" + e.getMessage() + "</p>");
		}
		this.setLogmsg("<p>获取商品品牌信息成功</p>");
		return Collections.emptyList();
	}

	/**
	 * 
	 * @param goodsTypeId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsTypeBrandT> findGoodsTypeBrandBygoodsType(
			String goodsTypeId) {
		try {
			Criterion criterion=Restrictions.eq("goodsTypeId", goodsTypeId);
			List<GoodsTypeBrandT> list = this.goodsTypeBrandTService.findByCriteria(GoodsTypeBrandT.class, criterion);
			if (!list.isEmpty()) {
				return list;
			}
		} catch (Exception e) {
			this.setLogmsg("<p style='color:red;'>" + e.getMessage() + "</p>");
		}
		this.setLogmsg("<p>获取商品类型品牌列表成功</p>");
		return Collections.emptyList();
	}

	/**
	 * 根据商品类型来获取对应的属性列表
	 * 
	 * @param goodsTypeId
	 * @return
	 */
	public List<GoodsAttributeT> findGoodsAttributeTBygoodsTypeId(
			String goodsTypeId) {
		try {
			Criterion criterion=Restrictions.eq("goodsTypeId", goodsTypeId);
			List<GoodsAttributeT> list = this.goodsAttributeTService.findByCriteria(GoodsAttributeT.class, criterion);
			if (!list.isEmpty()) {
				return list;
			}
		} catch (Exception e) {
			this.setLogmsg("<p style='color:red;'>" + e.getMessage() + "</p>");
		}
		this.setLogmsg("<p>获取商品类型属性列表成功</p>");
		return Collections.emptyList();
	}

	/**
	 * 根据商品id获取商品评论
	 * 
	 * @return
	 */
	public List<GoodsCommentT> findGoodsCommentBygoodsid(GoodsT gt) {
		int currentPage=1;
		int lineSize=10;
		String goodsid=gt.getGoodsid();
		Criterion criterion=Restrictions.eq("goodsid", goodsid);
		Order order=Order.asc("posttime");
		List<GoodsCommentT> list = this.goodsCommentTService.findByCriteriaByPage(GoodsCommentT.class, criterion,order, currentPage, lineSize);
		return list;
	}
	
	/**
	 * 根据商品id获取规格值参数
	 * @param gt
	 * @return
	 */
	public List<ProductSpecificationsT>findProductSpecificationsTByspecificationsid(GoodsT gt){
		Criterion criterion=Restrictions.eq("goodsid", gt.getGoodsid());
		List<GoodsSpecificationsProductRpT>gsrlist=this.goodsSpecificationsProductRpTService.findByCriteria(GoodsSpecificationsProductRpT.class, criterion);
		if(!gsrlist.isEmpty()){
//			List<ProductSpecificationsT>list =new ArrayList<ProductSpecificationsT>();
//			ProductSpecificationsT pst=new ProductSpecificationsT();
//			String []strspec=StringUtils.split(gsrlist.get(0).getId().getSpecidicationsId(), ',');
//			for(String s:strspec){
//				pst=this.getProductSpecificationsTService().findProductSpecificationsTByspecificationsid(s);
//				list.add(pst);
//			}
//			return list;
		}
		return Collections.emptyList();
	}
	
	/**
	 * 根据商品id获取关联商品信息
	 * @param gt
	 * @return
	 */
	public List<GoodsBelinkedModel>findGoodsBelinkedTBygoodsid(GoodsT gt){
		Criterion criterion=Restrictions.eq("maingoodsid", gt.getGoodsid());
		List<GoodsBelinkedT>list=this.goodsBelinkedTService.findByCriteria(GoodsBelinkedT.class, criterion);
		if(!list.isEmpty()){
			List<GoodsBelinkedModel> gbmlist=new ArrayList<GoodsBelinkedModel>();
			JSONArray ja = (JSONArray) JSONValue.parse(list.get(0).getBelinkedproductinfo().toString());
			for(int i=0;i<ja.size();i++){
				GoodsBelinkedModel gbm=new GoodsBelinkedModel();
				JSONObject jo = (JSONObject) ja.get(i);
				gbm.setMaingoodsid(jo.get("goodsid").toString());
				gbm.setProductid(jo.get("productid").toString());
				gbm.setProductName(jo.get("productName").toString());
				gbm.setGoodsname(jo.get("goodsname").toString());
				gbm.setMemberprice(jo.get("memberprice").toString());
				gbm.setPrice(jo.get("price").toString());
				gbm.setPictureurl(jo.get("pictureurl").toString());
				gbm.setHtmlpath(jo.get("htmlpath").toString());
				gbmlist.add(gbm);
			}
			return gbmlist;
		}
		return Collections.emptyList();
	}
	
	/**
	 * 获取商品分类的递归路径，表示当前浏览的位置
	 * @param path
	 * @return
	 */
	public List<GoodsCategoryPathVo> getGoodsCategoryPath(String path){
		List<GoodsCategoryPathVo>list=new ArrayList<GoodsCategoryPathVo>();
		if(StringUtils.isNotBlank(path)){
			String paths[]=StringUtils.split(StaticKey.SPLITDOT);
			for(String s:paths){
				GoodsCategoryT gct=this.goodsCategoryTService.findByPK(GoodsCategoryT.class, s);
				if(gct!=null){
					GoodsCategoryPathVo gcpv=new GoodsCategoryPathVo();
					if(StringUtils.isNotBlank(gct.getName())&&StringUtils.isNotBlank(gct.getHtmlpath())){
						gcpv.setName(gct.getName());
						gcpv.setUrl(gct.getHtmlpath());
					}
					list.add(gcpv);
				}
			}
		}
		return list;
	}

	/**
	 * 根据商品id获取商品详细描述信息
	 * @param goodsid
	 * @return
	 */
	public GoodsDetailRpT getGoodsDetailRpByGoodsId(String goodsid){
		if(StringUtils.isNotBlank(goodsid)){
			Criterion criterion=Restrictions.eq("goodsid", goodsid);
			GoodsDetailRpT gdrt=this.goodsDetailRpTService.findOneByCriteria(GoodsDetailRpT.class, criterion);
			if(gdrt!=null){
				return gdrt;
			}
		}
		return null;
	}
	/**
	 * 在这里增加商品参数的处理逻辑
	 * 1,根据goodstypeid获取goodstypen中的参数列表json格式
	 * 2,迭代此json和goods中的goodsparmeters对比
	 * 3,放入一个工具bean中
	 *
	 */
	public List<GoodsParameterlistVo> getGoodsparameters(GoodsT goodst){
		List<GoodsParameterlistVo> gmllist=new ArrayList<GoodsParameterlistVo>();
		GoodsTypeTN gtn=this.goodsTypeTNService.findByPK(GoodsTypeTN.class, goodst.getGoodsTypeId());
		if(gtn!=null){
			String goodsparameteringoodstyetn=gtn.getGoodsParameter();
			String goodsparameteringoods=goodst.getGoodsParameterValue();
			if(StringUtils.isNotBlank(goodsparameteringoods)){
				List<GoodsParameterInGoodsTVo>gpigs=gson.fromJson(goodsparameteringoods, new TypeToken<List<GoodsParameterInGoodsTVo>>(){}.getType());
				if(StringUtils.isNotBlank(goodsparameteringoodstyetn)){
					//[{"name":"型号","id":"paramlistname34571","sortList":""}]
					List<GoodsParameterInGoodsTypeTnVo>gpigtvs=gson.fromJson(goodsparameteringoodstyetn, new TypeToken<List<GoodsParameterInGoodsTypeTnVo>>(){}.getType());
					for(GoodsParameterInGoodsTypeTnVo gpigtv:gpigtvs){
						gmllist.add(compareGoodsparameters(gpigtv,gpigs));
					}
					
				}
			}
		}
		return gmllist;
	}
	/**
	 * 处理商品表中的商品参数
	 * @param id
	 * @param goodst
	 */
	private GoodsParameterlistVo compareGoodsparameters(GoodsParameterInGoodsTypeTnVo gpigtv,List<GoodsParameterInGoodsTVo>gpigs){
		GoodsParameterlistVo gslm=new GoodsParameterlistVo();
		for(GoodsParameterInGoodsTVo gpig:gpigs){
			if(gpig.getId().equals(gpigtv.getId())){
				gslm.setGoodsTypeParamid(gpigtv.getId());
				gslm.setGoodsParamid(gpig.getId());
				gslm.setParamName(gpigtv.getName());
				gslm.setParamValue(gpig.getValue());
				gslm.setSortList(gpigtv.getSortList());
				break;
			}
		}
		return gslm;
	}
	

	/**
	 * 根据一级分类id获取其信息
	 * @param navid
	 * @return
	 */
	public GoodsCategoryT getGoodsCategoryTByNavid(String navid){
		GoodsCategoryT gct=this.goodsCategoryTService.findByPK(GoodsCategoryT.class, navid);
		if(gct!=null){
			return gct;
		}
		return null;
	}
	
	/**
	 * 获取推荐商品
	 * @param state
	 * @return
	 */
	public List<GoodsT>getrecommendGoods(String state,int lineSize){
		Criterion criterion=Restrictions.and(Restrictions.eq("salestate", state)).add(Restrictions.eq("recommend", GoodsState.RECOMMENDED.getState()));
		Order order=Order.desc("updatetime");
		List<GoodsT>list=this.goodsTService.findByCriteriaByPage(GoodsT.class, criterion, order, 1, lineSize);
		if(!list.isEmpty()){
			return list;
		}
		return Collections.emptyList();
	}
	
	/**
	 * 根据商品一级分类id获取商品信息
	 * @param navid
	 * @return
	 */
	public List<GoodsT>getGoodsByNavIdCategoryT(String navid){
		Map<String,String>params=new HashMap<String, String>();
		params.put("navid", navid);
		params.put("salestate", GoodsSaleState.SALE.getState());
		params.put("ismobileplatformgoods", GoodsState.ISMOBILEPLATFORM.getState());
		Criterion criterion=Restrictions.allEq(params);
		List<GoodsT>list=this.goodsTService.findByCriteria(GoodsT.class, criterion);
		if(!list.isEmpty()){
			return list;
		}
		return Collections.emptyList();
				
	}
	/**
	 * 根据商品二级分类id获取商品信息
	 * @param navid
	 * @return
	 */
	public List<GoodsT>getGoodsByLtypeIdCategoryT(String ltypeid){
		Criterion criterion=Restrictions.and(Restrictions.eq("ltypeid", ltypeid)).add(Restrictions.eq("salestate", GoodsSaleState.SALE.getState()));
		List<GoodsT>list=this.goodsTService.findByCriteria(GoodsT.class, criterion);
		if(!list.isEmpty()){
			return list;
		}
		return Collections.emptyList();
			
	}
	
	/**
	 * 根据商品三级分类id获取商品信息
	 * @param navid
	 * @return
	 */
	public List<GoodsT>getGoodsByStypeIdCategoryT(String stypeid){
		Criterion criterion=Restrictions.and(Restrictions.eq("stypeid", stypeid)).add(Restrictions.eq("salestate", GoodsSaleState.SALE.getState()));
		List<GoodsT>list=this.goodsTService.findByCriteria(GoodsT.class, criterion);
	if(!list.isEmpty()){
			return list;
		}
		return Collections.emptyList();
			
	}
}
