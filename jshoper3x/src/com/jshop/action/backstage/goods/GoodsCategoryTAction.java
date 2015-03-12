package com.jshop.action.backstage.goods;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.staticspage.CreateHtml;
import com.jshop.action.backstage.staticspage.DataCollectionTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GoodsCategoryT;
import com.jshop.service.ArticleCategoryTService;
import com.jshop.service.ArticleTService;
import com.jshop.service.GoodsCategoryTService;
import com.jshop.service.GoodsTService;
import com.jshop.service.JshopbasicInfoTService;
import com.jshop.service.SiteNavigationTService;
import com.jshop.service.impl.Serial;

import freemarker.template.TemplateException;
@Namespace("")
@ParentPackage("jshop")
//@InterceptorRefs({  
//    @InterceptorRef("goodsmoduleGoodsCategoryTInterecptor"),  
//    @InterceptorRef("defaultStack")
//})
public class GoodsCategoryTAction extends BaseTAction {
	
	private GoodsCategoryTService goodsCategoryTService;
	private GoodsTService goodsTService;
	private JshopbasicInfoTService jshopbasicInfoTService;
	private SiteNavigationTService siteNavigationTService;
	private ArticleCategoryTService articleCategoryTService;
	private ArticleTService articleTService;
	private CreateHtml createHtml;
	private DataCollectionTAction dataCollectionTAction;
	private String goodsCategoryTid;
	private String grade;
	private String metaKeywords;
	private String metaDes;
	private String name;
	private String state;
	private String path;
	private String sort;
	private String sign;
	private String goodsTypeId;
	private String parentId;
	private String parentId1;
	private String parentName;
	private String parentName1;
	private Date createtime;
	private String creatorid;
	private String logo;
	private String mobilesync;
	private String goodscategoryzero = null;
	private String goodscategorythree = null;
	private String goodscategorytwo = null;
	private List<GoodsCategoryT> goodstypetnav = new ArrayList<GoodsCategoryT>();
	private List<GoodsCategoryT> secondcategory = new ArrayList<GoodsCategoryT>();
	private List<GoodsCategoryT> thiredscategory = new ArrayList<GoodsCategoryT>();
	private String navidlist = null;
	private String ltypeidlist = null;
	private String stypeidlist = null;
	private GoodsCategoryT bean = new GoodsCategoryT();
	private Map<String, Object> map = new HashMap<String, Object>();
	private List<Map<String,Object>>rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;
	private String basepath;
	@JSON(serialize = false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}

	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}

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
	@JSON(serialize = false)
	public JshopbasicInfoTService getJshopbasicInfoTService() {
		return jshopbasicInfoTService;
	}

	public void setJshopbasicInfoTService(JshopbasicInfoTService jshopbasicInfoTService) {
		this.jshopbasicInfoTService = jshopbasicInfoTService;
	}
	@JSON(serialize = false)
	public SiteNavigationTService getSiteNavigationTService() {
		return siteNavigationTService;
	}

	public void setSiteNavigationTService(SiteNavigationTService siteNavigationTService) {
		this.siteNavigationTService = siteNavigationTService;
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
	public CreateHtml getCreateHtml() {
		return createHtml;
	}

	public void setCreateHtml(CreateHtml createHtml) {
		this.createHtml = createHtml;
	}
	public String getGoodsCategoryTid() {
		return goodsCategoryTid;
	}

	public void setGoodsCategoryTid(String goodsCategoryTid) {
		this.goodsCategoryTid = goodsCategoryTid;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public String getMetaDes() {
		return metaDes;
	}

	public void setMetaDes(String metaDes) {
		this.metaDes = metaDes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}
	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getGoodscategoryzero() {
		return goodscategoryzero;
	}

	public void setGoodscategoryzero(String goodscategoryzero) {
		this.goodscategoryzero = goodscategoryzero;
	}

	public String getGoodscategorythree() {
		return goodscategorythree;
	}

	public void setGoodscategorythree(String goodscategorythree) {
		this.goodscategorythree = goodscategorythree;
	}

	public String getGoodscategorytwo() {
		return goodscategorytwo;
	}

	public void setGoodscategorytwo(String goodscategorytwo) {
		this.goodscategorytwo = goodscategorytwo;
	}

	public String getParentId1() {
		return parentId1;
	}

	public void setParentId1(String parentId1) {
		this.parentId1 = parentId1;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentName1() {
		return parentName1;
	}

	public void setParentName1(String parentName1) {
		this.parentName1 = parentName1;
	}

	
	public List<Map<String,Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String,Object>> rows) {
		this.rows = rows;
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

	public List<GoodsCategoryT> getGoodstypetnav() {
		return goodstypetnav;
	}

	public void setGoodstypetnav(List<GoodsCategoryT> goodstypetnav) {
		this.goodstypetnav = goodstypetnav;
	}

	public List<GoodsCategoryT> getSecondcategory() {
		return secondcategory;
	}

	public void setSecondcategory(List<GoodsCategoryT> secondcategory) {
		this.secondcategory = secondcategory;
	}

	public List<GoodsCategoryT> getThiredscategory() {
		return thiredscategory;
	}

	public void setThiredscategory(List<GoodsCategoryT> thiredscategory) {
		this.thiredscategory = thiredscategory;
	}

	public GoodsCategoryT getBean() {
		return bean;
	}

	public void setBean(GoodsCategoryT bean) {
		this.bean = bean;
	}

	public String getNavidlist() {
		return navidlist;
	}

	public void setNavidlist(String navidlist) {
		this.navidlist = navidlist;
	}

	public String getLtypeidlist() {
		return ltypeidlist;
	}

	public void setLtypeidlist(String ltypeidlist) {
		this.ltypeidlist = ltypeidlist;
	}

	public String getStypeidlist() {
		return stypeidlist;
	}

	public void setStypeidlist(String stypeidlist) {
		this.stypeidlist = stypeidlist;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getMobilesync() {
		return mobilesync;
	}

	public void setMobilesync(String mobilesync) {
		this.mobilesync = mobilesync;
	}

	public String getBasepath() {
		return basepath;
	}

	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 获取顶级分类和一级分类
	 */
	@Action(value = "findGoodsCategoryByGradeZeroone", results = { @Result(name = "json", type = "json") })
	public String findGoodsCategoryByGradeZeroone() {
		this.setGoodscategoryzero("");
		String grade="0";//表示顶级分类
		String state="1";//表示启用的分类
		List<GoodsCategoryT> list = this.getGoodsCategoryTService().findGoodsCategoryByGrade(grade, state);
		this.goodscategoryzero = "";
		for (Iterator<GoodsCategoryT> it = list.iterator(); it.hasNext();) {
			GoodsCategoryT gct = (GoodsCategoryT) it.next();
			this.goodscategoryzero += "<option value='" + gct.getGoodsCategoryTid() + "'>" + gct.getName() + "</option>";
		}
		this.setSucflag(true);
		return "json";
	}
	

	
	/**
	 * 获取一级分类对应的二级分类列表
	 * @return
	 */
	@Action(value = "findGoodscategoryByparentId", results = { @Result(name = "json", type = "json") })
	public String findGoodscategoryByparentId(){
		this.setGoodscategorytwo("");
		if(StringUtils.isBlank(this.getParentId())){
			this.setSucflag(false);
			return "json";
		}
		String state="1";
		String parentId=this.getParentId().trim();
		List<GoodsCategoryT>list=this.getGoodsCategoryTService().findGoodscategoryByparentId(state, parentId);
		if(!list.isEmpty()){
			this.goodscategorytwo = "<option value='-1'>---请选择---</option>";
			for (Iterator<GoodsCategoryT> it = list.iterator(); it.hasNext();) {
				GoodsCategoryT gct = (GoodsCategoryT) it.next();
				this.goodscategorytwo += "<option value='" + gct.getGoodsCategoryTid() + "'>" + gct.getName() + "</option>";
			}
		}else {
			this.setGoodscategorytwo("");
			this.goodscategorytwo = "<option value='-1'>---请选择---</option>";
		}
		this.setSucflag(true);
		return "json";
		
		
	}

	/**
	 * 获取二级分类
	 */
	@Action(value = "findGoodsCategoryByGradeTwo", results = { @Result(name = "json", type = "json") })
	public String findGoodsCategoryByGradeTwo() {
		this.setGoodscategorytwo("");
		List<GoodsCategoryT> list = this.getGoodsCategoryTService().findGoodsCategoryByGrade("1", "1");
		if (list != null) {
			this.goodscategorytwo = "<option value='-1'>---请选择---</option>";
			for (Iterator<GoodsCategoryT> it = list.iterator(); it.hasNext();) {
				GoodsCategoryT gct = (GoodsCategoryT) it.next();
				this.goodscategorytwo += "<option value='" + gct.getGoodsCategoryTid() + "'>" + gct.getName() + "</option>";
			}
			this.setSucflag(true);
			return "json";
		} else {
			this.setGoodscategorytwo("");
			this.goodscategorytwo = "<option value='-1'>---请选择---</option>";
		}
		this.setSucflag(true);
		return "json";
	}

	/**
	 * 增加商品分类
	 * 
	 * @return
	 */
	@Action(value = "addGoodsCategory", results = { @Result(name = "json", type = "json") })
	public String addGoodsCategory() {
		int i = this.getGoodsCategoryTService().checkGoodscategoryName(this.getName());
		int j = this.getGoodsCategoryTService().checkGoodscategorySign(this.getSign());
		if (i == 0 && j == 0) {
			if (Integer.parseInt(this.getGrade()) == 0) {
				GoodsCategoryT gct = new GoodsCategoryT();
				gct.setGoodsCategoryTid(this.getSerial().Serialid(Serial.GOODSCATEGORY));
				gct.setGrade(this.getGrade().trim());//顶级，一级
				gct.setMetaKeywords(this.getMetaKeywords().trim());
				gct.setMetaDes(this.getMetaDes().trim());
				gct.setName(this.getName().trim());
				gct.setState(StaticKey.ONE);
				gct.setPath(gct.getGoodsCategoryTid());
				gct.setSort(Integer.parseInt(this.getSort().trim()));
				gct.setSign(this.getSign().trim());
				gct.setGoodsTypeId(this.getGoodsTypeId());
				gct.setCreatetime(BaseTools.systemtime());
				gct.setCreatorid(BaseTools.getAdminCreateId());
				gct.setUpdatetime(BaseTools.systemtime());
				gct.setVersiont(0);
				gct.setParentName(StaticKey.EMPTY);
				gct.setLogo(this.getLogo());
				gct.setMobilesync(this.getMobilesync());
				this.getGoodsCategoryTService().save(gct);
				this.setSucflag(true);
				return "json";
			}
		} else {
			return "json";
		}
		return "json";
	}
	
	
	/**
	 * 
	 * 更新商品分类到顶级分类或者一级分类（顶级分类就是一级分类只是在前端有区分）
	 * @return
	 */
	@Action(value = "updateGoodsCategory", results = { @Result(name = "json", type = "json") })
	public String updateGoodsCategory() {
		//根据goodscategoryid读取商品分类信息
		if(StringUtils.isBlank(this.getGoodsCategoryTid())){
			return "json";
		}
		String goodsCategoryTid=this.getGoodsCategoryTid().trim();
		GoodsCategoryT gct=new GoodsCategoryT();
		gct=this.getGoodsCategoryTService().findGoodscategoryBygoodscategoryId(goodsCategoryTid);
		int i = this.getGoodsCategoryTService().checkGoodscategoryNamewithoutMe(goodsCategoryTid, gct.getName());
		int j = this.getGoodsCategoryTService().checkGoodscategorySignwithoutMe(goodsCategoryTid, gct.getSign());
		//判断更新的一级分类的名称和标示是否和其他分类重复
		if (i == 0 && j == 0) {
			if (Integer.parseInt(this.getGrade()) == 0) {
				gct.setGoodsTypeId(this.getGoodsTypeId());//商品类型id
				gct.setParentId(StaticKey.EMPTY);//将父分类设置成空
				gct.setParentName(StaticKey.EMPTY);//父分类名称应为是顶级和一级分类所以名称空
				gct.setGrade(this.getGrade().trim());//顶级分类一级分类
				gct.setName(this.getName().trim());
				gct.setMetaKeywords(this.getMetaKeywords().trim());
				gct.setMetaDes(this.getMetaDes().trim());
				gct.setState(StaticKey.ONE);
				gct.setPath(StaticKey.EMPTY);//将原有分类递归路径设置成空
				gct.setSort(Integer.parseInt(this.getSort().trim()));
				gct.setSign(this.getSign().trim());
				gct.setCreatorid(BaseTools.getAdminCreateId());
				gct.setUpdatetime(BaseTools.systemtime());
				gct.setVersiont(gct.getVersiont()+1);
				gct.setLogo(this.getLogo());
				gct.setMobilesync(this.getMobilesync());
				this.getGoodsCategoryTService().updateGoodscategoryT(gct);
				this.setSucflag(true);
				return "json";
			}
		}
		return "json";
	}

	/**
	 * 增加二级分类
	 * 
	 * @return
	 */
	@Action(value = "addGoodsCategoryTwo", results = { @Result(name = "json", type = "json") })
	public String addGoodsCategoryTwo() {
		int i = this.getGoodsCategoryTService().checkGoodscategoryName(this.getName());
		int j = this.getGoodsCategoryTService().checkGoodscategorySign(this.getSign());
		if (i == 0 && j == 0) {
			if (Integer.parseInt(this.getGrade()) == 1) {
				GoodsCategoryT gct = new GoodsCategoryT();
				gct.setGoodsCategoryTid(this.getSerial().Serialid(Serial.GOODSCATEGORY));
				gct.setGrade(this.getGrade().trim());//二级
				gct.setMetaKeywords(this.getMetaKeywords().trim());
				gct.setMetaDes(this.getMetaDes().trim());
				gct.setName(this.getName().trim());
				gct.setState(StaticKey.ONE);
				gct.setPath(this.getParentId() + "," + gct.getGoodsCategoryTid());
				gct.setSort(Integer.parseInt(this.getSort().trim()));
				gct.setSign(this.getSign().trim());
				gct.setGoodsTypeId(this.getGoodsTypeId());
				gct.setCreatetime(BaseTools.systemtime());
				gct.setCreatorid(BaseTools.getAdminCreateId());
				gct.setUpdatetime(BaseTools.systemtime());
				gct.setVersiont(0);
				gct.setParentId(this.getParentId());
				gct.setParentName(this.getParentName());
				gct.setLogo(this.getLogo());
				gct.setMobilesync(this.getMobilesync());
				this.getGoodsCategoryTService().save(gct);
				this.setSucflag(true);
				return "json";
			}
		} else {
			return "json";
		}
		return "json";
	}
	/**
	 * 
	 * 更新商品分类到二级分类
	 * @return
	 */
	@Action(value = "updateGoodsCategoryTwo", results = { @Result(name = "json", type = "json") })
	public String updateGoodsCategoryTwo() {
		//根据goodscategoryid读取商品分类信息
		if(StringUtils.isBlank(this.getGoodsCategoryTid())){
			this.setSucflag(false);
			return "json";
		}
		String goodsCategoryTid=this.getGoodsCategoryTid().trim();
		GoodsCategoryT gct=new GoodsCategoryT();
		gct=this.getGoodsCategoryTService().findGoodscategoryBygoodscategoryId(goodsCategoryTid);
		int i = this.getGoodsCategoryTService().checkGoodscategoryNamewithoutMe(goodsCategoryTid, gct.getName());
		int j = this.getGoodsCategoryTService().checkGoodscategorySignwithoutMe(goodsCategoryTid, gct.getSign());
		//判断更新的一级分类的名称和标示是否和其他分类重复
		if (i == 0 && j == 0) {
			if (Integer.parseInt(this.getGrade()) ==1) {
				gct.setGoodsTypeId(this.getGoodsTypeId());//商品类型id
				gct.setParentId(this.getParentId().trim());
				gct.setParentName(this.getParentName());
				gct.setGrade(this.getGrade().trim());//二级分类
				gct.setName(this.getName().trim());
				gct.setMetaKeywords(this.getMetaKeywords().trim());
				gct.setMetaDes(this.getMetaDes().trim());
				gct.setState(StaticKey.ONE);
			    gct.setPath(this.getParentId() + "," + gct.getGoodsCategoryTid());//path代表了递归路径，要更新
				gct.setSort(Integer.parseInt(this.getSort().trim()));
				gct.setSign(this.getSign().trim());
				gct.setCreatorid(BaseTools.getAdminCreateId());
				gct.setUpdatetime(BaseTools.systemtime());
				gct.setVersiont(gct.getVersiont()+1);
				gct.setLogo(this.getLogo());
				gct.setMobilesync(this.getMobilesync());
				this.getGoodsCategoryTService().updateGoodscategoryT(gct);
				this.setSucflag(true);
				return "json";
			}
		} else {
			this.setSucflag(false);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	/**
	 * 增加三级分类
	 * 
	 * @return
	 */
	@Action(value = "addGoodsCategoryThree", results = { @Result(name = "json", type = "json") })
	public String addGoodsCategoryThree() {
		int i = this.getGoodsCategoryTService().checkGoodscategoryName(this.getName());
		int j = this.getGoodsCategoryTService().checkGoodscategorySign(this.getSign());
		if (i == 0 && j == 0) {
			if (Integer.parseInt(this.getGrade()) == 2) {
				GoodsCategoryT gct = new GoodsCategoryT();
				gct.setGoodsCategoryTid(this.getSerial().Serialid(Serial.GOODSCATEGORY));
				gct.setGrade(this.getGrade().trim());//三级
				gct.setMetaKeywords(this.getMetaKeywords().trim());
				gct.setMetaDes(this.getMetaDes().trim());
				gct.setName(this.getName().trim());
				gct.setState(StaticKey.ONE);
				gct.setPath(this.getParentId() + "," + this.getParentId1() + "," + gct.getGoodsCategoryTid());
				gct.setSort(Integer.parseInt(this.getSort().trim()));
				gct.setSign(this.getSign().trim());
				gct.setGoodsTypeId(this.getGoodsTypeId());
				gct.setCreatetime(BaseTools.systemtime());
				gct.setCreatorid(BaseTools.getAdminCreateId());
				gct.setUpdatetime(BaseTools.systemtime());
				gct.setVersiont(0);
				gct.setParentId(this.getParentId1());
				gct.setParentName(this.getParentName1());
				gct.setLogo(this.getLogo());
				gct.setMobilesync(this.getMobilesync());
				this.getGoodsCategoryTService().save(gct);
				this.setSucflag(true);
				return "json";
			}
		} else {
			return "json";
		}
		return "json";
	}
	/**
	 * 
	 * 更新商品分类到三级分类
	 * @return
	 */
	@Action(value = "updateGoodsCategoryThree", results = { @Result(name = "json", type = "json") })
	public String updateGoodsCategoryThree() {
		//根据goodscategoryid读取商品分类信息
		if(StringUtils.isBlank(this.getGoodsCategoryTid())){
			this.setSucflag(false);
			return "json";
		}
		String goodsCategoryTid=this.getGoodsCategoryTid().trim();
		GoodsCategoryT gct=new GoodsCategoryT();
		gct=this.getGoodsCategoryTService().findGoodscategoryBygoodscategoryId(goodsCategoryTid);
		int i = this.getGoodsCategoryTService().checkGoodscategoryNamewithoutMe(goodsCategoryTid, gct.getName());
		int j = this.getGoodsCategoryTService().checkGoodscategorySignwithoutMe(goodsCategoryTid, gct.getSign());
		//判断更新的一级分类的名称和标示是否和其他分类重复
		if (i == 0 && j == 0) {
			if (Integer.parseInt(this.getGrade()) == 2) {
				gct.setGoodsTypeId(this.getGoodsTypeId());
				gct.setParentId(this.getParentId1());
				gct.setParentName(this.getParentName1());
				gct.setGrade(this.getGrade().trim());//三级分类
				gct.setName(this.getName().trim());
				gct.setMetaKeywords(this.getMetaKeywords().trim());
				gct.setMetaDes(this.getMetaDes().trim());
				gct.setState(StaticKey.ONE);
				gct.setPath(this.getParentId()+","+this.getParentId1()+","+gct.getGoodsCategoryTid());
				gct.setSort(Integer.parseInt(this.getSort().trim()));
				gct.setSign(this.getSign().trim());
				gct.setCreatorid(BaseTools.getAdminCreateId());
				gct.setUpdatetime(BaseTools.systemtime());
				gct.setVersiont(gct.getVersiont()+1);
				gct.setLogo(this.getLogo());
				gct.setMobilesync(this.getMobilesync());
				this.getGoodsCategoryTService().updateGoodscategoryT(gct);
				this.setSucflag(true);
				return "json";
			}
		} else {
			this.setSucflag(false);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	/**
	 * 获取所有商品分类
	 * 
	 * @return
	 */
	@Action(value = "findAllGoodsCategoryT", results = { @Result(name = "json", type = "json") })
	public String findAllGoodsCategoryT() {
		if (StaticKey.SC.equals(this.getQtype())) {
			this.findDefaultAllGoodsCategoryT();
		} else {
			if (StringUtils.isNotBlank(this.getQuery())) {
//				if("name".equals(this.getQtype())){
//					this.findGoodsCategoryByName();
//				}
				return "json";
			} else {
				return "json";
			}
		}
		return "json";
	}

	private void findDefaultAllGoodsCategoryT() {
		int currentPage = page;
		int lineSize = rp;
		String state = StaticKey.ONE;
		total = this.getGoodsCategoryTService().countfindAllGoodsCategoryT(state);
		if (Validate.StrNotNull(getSortname()) && Validate.StrNotNull(getSortorder())) {
			String queryString = "from GoodsCategoryT as gt where state=:state order by " + getSortname() + " " + getSortorder() + " ";
			List<GoodsCategoryT> list = this.getGoodsCategoryTService().sortAllGoodsCategoryT(currentPage, lineSize, state, queryString);
			if(!list.isEmpty()){
				this.ProcessGoodsCategoryTList(list);
			}
		}
	}

	public void ProcessGoodsCategoryTList(List<GoodsCategoryT> list) {
		for (Iterator<GoodsCategoryT> it = list.iterator(); it.hasNext();) {
			GoodsCategoryT gct = (GoodsCategoryT) it.next();
			if (gct.getGrade().equals(StaticKey.ZERO)) {
				gct.setGrade(StaticKey.TOPCA);
			} else if (gct.getGrade().equals(StaticKey.ONE)) {
				gct.setGrade(StaticKey.TWOCA);
			} else {
				gct.setGrade(StaticKey.THREECA);
			}
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", gct.getGoodsCategoryTid());
			cellMap.put("cell", new Object[] {"<a href='goodscategory.jsp?operate=edit&folder=goods&goodsCategoryTid=" + gct.getGoodsCategoryTid() + "'>" + gct.getName() + "</a>", gct.getParentName(), gct.getGrade(), gct.getSign(), gct.getSort(), BaseTools.formateDbDate(gct.getCreatetime()), gct.getCreatorid(), "<a href='goodscategory.jsp?operate=edit&goods&goodsCategoryTid=" + gct.getGoodsCategoryTid() + "'>编辑</a>" });
			rows.add(cellMap);
		}

	}

	/**
	 * 获取商品分类详细
	 * 
	 * @return
	 */
	@Action(value = "findGoodscategoryBygoodscategoryId", results = { @Result(name = "json", type = "json") })
	public String findGoodscategoryBygoodscategoryId() {
		if (Validate.StrNotNull(this.getGoodsCategoryTid())) {
			bean = this.getGoodsCategoryTService().findGoodscategoryBygoodscategoryId(this.getGoodsCategoryTid());
			if (bean != null) {
				//bean.setLogo(BaseTools.getBasePath()+bean.getLogo());
				this.setBasepath(BaseTools.getBasePath());
				return "json";
			}
		}
		return "json";
	}

	/**
	 * 更新商品分类
	 * 
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	@Action(value = "updateGoodscategoryT", results = { @Result(name = "json", type = "json") })
	public String updateGoodscategoryT() throws IOException, TemplateException {
		int i = this.getGoodsCategoryTService().checkGoodscategoryNamewithoutMe(this.getGoodsCategoryTid().trim(), this.getName().trim());
		int j = this.getGoodsCategoryTService().checkGoodscategorySignwithoutMe(this.getGoodsCategoryTid().trim(), this.getSign().trim());
		if (i == 0 && j == 0) {
			
			GoodsCategoryT gct = new GoodsCategoryT();
			gct=this.getGoodsCategoryTService().findGoodscategoryBygoodscategoryId(this.getGoodsCategoryTid());
			gct.setName(this.getName().trim());
			gct.setGoodsTypeId(this.getGoodsTypeId().trim());
			gct.setSign(this.getSign().trim());
			gct.setSort(Integer.parseInt(this.getSort().trim()));
			gct.setMetaKeywords(this.getMetaKeywords());
			gct.setMetaDes(this.getMetaDes());
			gct.setGoodsCategoryTid(this.getGoodsCategoryTid());
			gct.setCreatetime(BaseTools.systemtime());
			gct.setCreatorid(BaseTools.getAdminCreateId());
			gct.setUpdatetime(BaseTools.systemtime());
			gct.setVersiont(0);
			gct.setLogo(this.getLogo());
			gct.setMobilesync(this.getMobilesync());
			this.getGoodsCategoryTService().updateGoodscategoryT(gct);
			this.setSucflag(true);
			bean=gct;
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}

	}

	/**
	 * 更新商品分类静态路径
	 * 
	 * @param articleid
	 * @param htmlPath
	 */
	public void updateHtmlPath(String goodsCategoryTid, String htmlpath) {
		this.getGoodsCategoryTService().updateHtmlPath(goodsCategoryTid, htmlpath);
	}

	/**
	 * 删除商品分类
	 * 
	 * @return
	 */
	@Action(value = "delGoodscategoryT", results = { @Result(name = "json", type = "json") })
	public String delGoodscategoryT() {
		if (StringUtils.isNotBlank(this.getGoodsCategoryTid())) {
			String[]strs=StringUtils.split(this.getGoodsCategoryTid().trim(), ",");
			if(this.getGoodsCategoryTService().delGoodscategoryT(strs)>0){
				//更新商品分类的静态页路径
				updateGoodsCategoryhtmlpath();
			}
//			for (int i = 0; i < strs.length; i++) {
//				bean = this.getGoodsCategoryTService().findGoodscategoryBygoodscategoryId(strs[i]);
//				if (bean != null) {
//					if (bean.getGrade().equals("0")) {
//						this.setSucflag(false);
//						return "json";
//					} else {
//						int j = this.getGoodsCategoryTService().delGoodscategoryT(strs[i], "0");
//						if (j > 0) {
//							this.setSucflag(true);
//							return "json";
//						}
//					}
//				}
//			}
		}
		this.setSucflag(true);
		return "json";
	}
	
	
	/**
	 * 更新商品分类的静态页路径
	 */
	public void updateGoodsCategoryhtmlpath(){
		List<GoodsCategoryT>list=this.getGoodsCategoryTService().findGoodsCategoryByGrade("0","1");
		for(Iterator<GoodsCategoryT> it=list.iterator();it.hasNext();){
			GoodsCategoryT gct=(GoodsCategoryT)it.next();
			List<GoodsCategoryT>glist=this.getGoodsCategoryTService().findGoodscategoryByparentId("1",gct.getParentId());
			if(glist.isEmpty()){
				this.getGoodsCategoryTService().updateHtmlPath(gct.getParentId(), "");
			}
		}
	}

	/**
	 * 获取顶级分类一级
	 * 
	 * @return
	 */
	@Action(value = "findGoodscategoryNavid", results = { @Result(name = "json", type = "json") })
	public String findGoodscategoryNavid() {

		this.setNavidlist("");
		this.goodstypetnav = this.getGoodsCategoryTService().findGoodscategoryByparentIdnull("1");
		if (this.goodstypetnav != null) {
			for (Iterator<GoodsCategoryT> it = goodstypetnav.iterator(); it.hasNext();) {
				GoodsCategoryT gct = (GoodsCategoryT) it.next();
				navidlist += "<option value='" + gct.getGoodsCategoryTid() + "'>" + gct.getName() + "</option>";
			}
			this.setNavidlist(navidlist);
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 获取二级分类
	 * 
	 * @return
	 */
	@Action(value = "findGoodscategoryLtypeid", results = { @Result(name = "json", type = "json") })
	public String findGoodscategoryLtypeid() {
		if (Validate.StrNotNull(this.getParentId())) {
			this.setLtypeidlist("");
			this.secondcategory = this.getGoodsCategoryTService().findGoodscategoryByparentId("1", this.getParentId().trim());
			if (this.secondcategory != null) {
				this.ltypeidlist = "<option value='0'>---请选择---</option>";
				for (Iterator<GoodsCategoryT> it = this.secondcategory.iterator(); it.hasNext();) {
					GoodsCategoryT gct = (GoodsCategoryT) it.next();
					ltypeidlist += "<option value='" + gct.getGoodsCategoryTid() + "'>" + gct.getName() + "</option>";
				}
				this.setLtypeidlist(ltypeidlist);
				this.setSucflag(true);
				return "json";
			}
			this.setLtypeidlist("");
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 获取三级分类
	 * 
	 * @return
	 */
	@Action(value = "findGoodscategoryStypeid", results = { @Result(name = "json", type = "json") })
	public String findGoodscategoryStypeid() {

		if (Validate.StrNotNull(this.getParentId())) {
			this.setLtypeidlist("");
			this.thiredscategory = this.getGoodsCategoryTService().findGoodscategoryByparentId("1", this.getParentId().trim());
			if (this.thiredscategory != null) {
				this.stypeidlist = "<option value='-1'>---请选择---</option>";
				for (Iterator<GoodsCategoryT> it = this.thiredscategory.iterator(); it.hasNext();) {
					GoodsCategoryT gct = (GoodsCategoryT) it.next();
					stypeidlist += "<option value='" + gct.getGoodsCategoryTid() + "'>" + gct.getName() + "</option>";
				}
				this.setStypeidlist(stypeidlist);
				this.setSucflag(true);
				return "json";
			}
			this.setStypeidlist("");
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
}
