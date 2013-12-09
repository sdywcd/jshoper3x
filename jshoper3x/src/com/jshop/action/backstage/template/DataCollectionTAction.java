package com.jshop.action.backstage.template;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.json.annotations.JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.modelbean.GoodsBelinkedModel;
import com.jshop.entity.ArticleCategoryT;
import com.jshop.entity.ArticleT;
import com.jshop.entity.BrandT;
import com.jshop.entity.GoodsAttributeT;
import com.jshop.entity.GoodsBelinkedT;
import com.jshop.entity.GoodsCategoryT;
import com.jshop.entity.GoodsCommentT;
import com.jshop.entity.GoodsSpecificationsProductRpT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.GoodsTypeBrandT;
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
import com.jshop.service.GoodsSpecificationsProductRpTService;
import com.jshop.service.GoodsTService;
import com.jshop.service.GoodsTypeBrandTService;
import com.jshop.service.JshopbasicInfoTService;
import com.jshop.service.ProductSpecificationsTService;
import com.jshop.service.SiteNavigationTService;
import com.jshop.service.TemplatethemeTService;
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

	private JshopbasicInfoTService jshopbasicInfoTService;
	private SiteNavigationTService siteNavigationTService;
	
	private GoodsCategoryTService goodsCategoryTService;
	private BrandTService brandTService;
	private GoodsTypeBrandTService goodsTypeBrandTService;
	private ProductSpecificationsTService productSpecificationsTService;
	private GoodsSpecificationsProductRpTService goodsSpecificationsProductRpTService;
	private int gradecount;
	private GoodsTService goodsTService;
	private ArticleTService articleTService;
	private ArticleCategoryTService articleCategoryTService;
	private GoodsAttributeTService goodsAttributeTService;
	private GoodsCommentTService goodsCommentTService;
	private TemplatethemeTService templatethemeTService;
	private GoodsBelinkedTService goodsBelinkedTService;
	private TemplatethemeT tt;
	private String logmsg;
	@JSON(serialize = false)
	public GoodsBelinkedTService getGoodsBelinkedTService() {
		return goodsBelinkedTService;
	}

	public void setGoodsBelinkedTService(GoodsBelinkedTService goodsBelinkedTService) {
		this.goodsBelinkedTService = goodsBelinkedTService;
	}

	
	@JSON(serialize = false)
	public GoodsSpecificationsProductRpTService getGoodsSpecificationsProductRpTService() {
		return goodsSpecificationsProductRpTService;
	}

	public void setGoodsSpecificationsProductRpTService(
			GoodsSpecificationsProductRpTService goodsSpecificationsProductRpTService) {
		this.goodsSpecificationsProductRpTService = goodsSpecificationsProductRpTService;
	}

	@JSON(serialize = false)
	public ProductSpecificationsTService getProductSpecificationsTService() {
		return productSpecificationsTService;
	}

	public void setProductSpecificationsTService(
			ProductSpecificationsTService productSpecificationsTService) {
		this.productSpecificationsTService = productSpecificationsTService;
	}

	@JSON(serialize = false)
	public TemplatethemeTService getTemplatethemeTService() {
		return templatethemeTService;
	}

	public void setTemplatethemeTService(
			TemplatethemeTService templatethemeTService) {
		this.templatethemeTService = templatethemeTService;
	}

	@JSON(serialize = false)
	public GoodsCommentTService getGoodsCommentTService() {
		return goodsCommentTService;
	}

	public void setGoodsCommentTService(
			GoodsCommentTService goodsCommentTService) {
		this.goodsCommentTService = goodsCommentTService;
	}

	@JSON(serialize = false)
	public GoodsAttributeTService getGoodsAttributeTService() {
		return goodsAttributeTService;
	}

	public void setGoodsAttributeTService(
			GoodsAttributeTService goodsAttributeTService) {
		this.goodsAttributeTService = goodsAttributeTService;
	}

	@JSON(serialize = false)
	public GoodsTypeBrandTService getGoodsTypeBrandTService() {
		return goodsTypeBrandTService;
	}

	public void setGoodsTypeBrandTService(
			GoodsTypeBrandTService goodsTypeBrandTService) {
		this.goodsTypeBrandTService = goodsTypeBrandTService;
	}

	@JSON(serialize = false)
	public BrandTService getBrandTService() {
		return brandTService;
	}

	public void setBrandTService(BrandTService brandTService) {
		this.brandTService = brandTService;
	}

	@JSON(serialize = false)
	public JshopbasicInfoTService getJshopbasicInfoTService() {
		return jshopbasicInfoTService;
	}

	public void setJshopbasicInfoTService(
			JshopbasicInfoTService jshopbasicInfoTService) {
		this.jshopbasicInfoTService = jshopbasicInfoTService;
	}

	@JSON(serialize = false)
	public SiteNavigationTService getSiteNavigationTService() {
		return siteNavigationTService;
	}

	public void setSiteNavigationTService(
			SiteNavigationTService siteNavigationTService) {
		this.siteNavigationTService = siteNavigationTService;
	}


	@JSON(serialize = false)
	public GoodsCategoryTService getGoodsCategoryTService() {
		return goodsCategoryTService;
	}

	public void setGoodsCategoryTService(
			GoodsCategoryTService goodsCategoryTService) {
		this.goodsCategoryTService = goodsCategoryTService;
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
	public ArticleCategoryTService getArticleCategoryTService() {
		return articleCategoryTService;
	}

	public void setArticleCategoryTService(
			ArticleCategoryTService articleCategoryTService) {
		this.articleCategoryTService = articleCategoryTService;
	}

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
		String status = "1";// 标示默认主题
		tt = this.getTemplatethemeTService().findTemplatethemeBystatus(status);
		if (tt != null) {
			// 将启用的模板主题标示加入到服务器内存中
			if (!tt.getSign().isEmpty()) {
				return tt.getSign();
			} else {
				// 如果没有默认的模板，那么启用默认主题模板
				return "default";
			}
		}
		return "default";
	}

	/**
	 * 获取网站根目录
	 * 
	 * @return
	 */
	public String getBasePath() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getContextPath();
		return path;
	}

	/**
	 * 获取session数据
	 * 
	 * @return
	 */
	public Map<String, Object> getSession() {
		return ActionContext.getContext().getSession();
	}

	/**
	 * 获取商城基本信息
	 */
	public JshopbasicInfoT findJshopbasicInfo() {
		try {
			String state = "1";// 商城状态标记
			String openstate = "1";// 商城开启运作标记
			JshopbasicInfoT bean = this.getJshopbasicInfoTService()
					.findJshopbasicInfoBystateandopstate(state, openstate);
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
	public List<SiteNavigationT> findSiteNavigation() {
		try {
			String isVisible = "1";// 显示标记
			List<SiteNavigationT> list = this.getSiteNavigationTService()
					.findSiteNavigationByisVisible(isVisible);
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
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsCategoryT> findGoodsCategoryT() {
		try {
			String state = "1";// 标示激活的商品分类
			gradecount=0;
			List<GoodsCategoryT> list = this.getGoodsCategoryTService()
					.findAllGoodsCategoryT(state);
			if (!list.isEmpty()) {
				for (Iterator it = list.iterator(); it.hasNext();) {
					GoodsCategoryT gt = (GoodsCategoryT) it.next();
					if (gt.getGrade().equals("0")&&gt.getHtmlpath().length()>0) {
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
	public List<GoodsCategoryT> findAllGoodsCategoryTByState() {
		String state = "1";// 启用的商品状态
		List<GoodsCategoryT> list = this.getGoodsCategoryTService()
				.findAllGoodsCategoryT(state);
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
	@SuppressWarnings({ "unchecked", "unchecked" })
	public List<GoodsCategoryT> findSecondGoodsCategoryT(String parentId) {
		String state = "1";
		List<GoodsCategoryT> list = this.getGoodsCategoryTService()
				.findGoodscategoryByparentId(state, parentId);
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
	public List<GoodsT> findAllGoodsT() {
		String salestate = "1";// 标示上架
		List<GoodsT> list = this.getGoodsTService().finaAllGoodsT(salestate);
		if (!list.isEmpty()) {
			return list;
		}
		return Collections.emptyList();

	}

	/**
	 * 获取所有文章数据
	 * @return
	 */
	public List<ArticleT> findAllArticleT() {
		String status = "1";// 标示显示
		List<ArticleT> list = this.getArticleTService().findAllArticleT(status);
		if (!list.isEmpty()) {
			return list;
		} else {
			return Collections.emptyList();
		}
	}

	/**
	 * 获取页脚文章一级分类
	 */
	public List<ArticleCategoryT> findFooterCateogyrT() {
		try {
			String grade = "0";// 标示文章是顶级分类
			String status = "1";// 标示显示
			List<ArticleCategoryT> list = this.getArticleCategoryTService()
					.findArticleCategoryByGrade(grade, status);
			if (!list.isEmpty()) {
				return list;
			}

		} catch (Exception e) {
			this.setLogmsg("<p style='color:red;'>" + e.getMessage() + "</p>");
		}
		this.setLogmsg("<p>商城页脚分类数据获取成功</p>");
		return Collections.emptyList();

	}

	/**
	 * 获取页脚文章一级分类下得文章
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	public List<ArticleT> findFooterArticle() {
		try {
			String status = "1";// 显示的文章
			List<ArticleT> list = this.getArticleTService().findAllArticleT(
					status);
			if (!list.isEmpty()) {
				List<ArticleT> list1 = new ArrayList<ArticleT>();
				for (Iterator it = list.iterator(); it.hasNext();) {
					ArticleT at = (ArticleT) it.next();
					if (at.getPosition() != null
							&& at.getPosition().equals("1")) {
						list1.add(at);
					}
				}
				return list1;
			}

		} catch (Exception e) {
			this.setLogmsg("<p style='color:red;'>" + e.getMessage() + "</p>");
		}
		this.setLogmsg("<p>获取商城页脚文章成功</p>");
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
			List<BrandT> list = this.getBrandTService().findAllBrandt();
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
			List<GoodsTypeBrandT> list = this.getGoodsTypeBrandTService()
					.findBrandBygoodsTypeId(goodsTypeId);
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
			List<GoodsAttributeT> list = this.getGoodsAttributeTService()
					.findGoodsAttributeTBygoodsTypeId(goodsTypeId);
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
		List<GoodsCommentT> list = this.getGoodsCommentTService()
				.findGoodsCommentByGoodsid(gt.getGoodsid(), 1, 10);
		return list;
	}
	
	/**
	 * 根据商品id获取规格值参数
	 * @param gt
	 * @return
	 */
	public List<ProductSpecificationsT>findProductSpecificationsTByspecificationsid(GoodsT gt){
		List<GoodsSpecificationsProductRpT>gsrlist=this.getGoodsSpecificationsProductRpTService().checkSpecificationRelationshipBygoodssetid(gt.getGoodsid());
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
		List<GoodsBelinkedT>list=this.getGoodsBelinkedTService().findGoodsBelinkedBymaingoodsid(gt.getGoodsid());
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
	

}
