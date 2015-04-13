package com.jshop.action.backstage.goods;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.staticspage.CreateHtml;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.enums.BaseEnums.CategoryGrade;
import com.jshop.action.backstage.utils.enums.BaseEnums.DataUsingState;
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
	@Resource
	private GoodsCategoryTService goodsCategoryTService;
	@Resource
	private GoodsTService goodsTService;
	@Resource
	private JshopbasicInfoTService jshopbasicInfoTService;
	@Resource
	private SiteNavigationTService siteNavigationTService;
	@Resource
	private ArticleCategoryTService articleCategoryTService;
	@Resource
	private ArticleTService articleTService;
	@Resource
	private CreateHtml createHtml;
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
	private String smallLogo;
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
	
	public String getSmallLogo() {
		return smallLogo;
	}

	public void setSmallLogo(String smallLogo) {
		this.smallLogo = smallLogo;
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
		this.setGoodscategoryzero(StaticKey.EMPTY);
		String grade=CategoryGrade.FIRST.getState();//表示顶级分类
		String state=DataUsingState.USING.getState();//表示启用的分类
		Map<String,String>params=new HashMap<String, String>();
		params.put("grade", grade);
		params.put("state", state);
		Criterion criterion=Restrictions.allEq(params);
		List<GoodsCategoryT> list = this.goodsCategoryTService.findByCriteria(GoodsCategoryT.class,criterion);
		this.goodscategoryzero = StaticKey.EMPTY;
		for (Iterator<GoodsCategoryT> it = list.iterator(); it.hasNext();) {
			GoodsCategoryT gct = (GoodsCategoryT) it.next();
			this.goodscategoryzero += "<option value='" + gct.getGoodsCategoryTid() + "'>" + gct.getName() + "</option>";
		}
		this.setSucflag(true);
		return JSON;
	}
	

	
	/**
	 * 获取一级分类对应的二级分类列表
	 * @return
	 */
	@Action(value = "findGoodscategoryByparentId", results = { @Result(name = "json", type = "json") })
	public String findGoodscategoryByparentId(){
		this.setGoodscategorytwo(StaticKey.EMPTY);
		if(StringUtils.isBlank(this.getParentId())){
			return JSON;
		}
		String state=DataUsingState.USING.getState();
		String parentId=this.getParentId().trim();
		Map<String,String>params=new HashMap<String, String>();
		params.put("state", state);
		params.put("parentId", parentId);
		Criterion criterion=Restrictions.allEq(params);
		List<GoodsCategoryT>list=this.goodsCategoryTService.findByCriteria(GoodsCategoryT.class, criterion);
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
		return JSON;
		
		
	}

	/**
	 * 获取二级分类
	 */
	@Action(value = "findGoodsCategoryByGradeTwo", results = { @Result(name = "json", type = "json") })
	public String findGoodsCategoryByGradeTwo() {
		this.setGoodscategorytwo(StaticKey.EMPTY);
		String state=DataUsingState.USING.getState();
		String grade=CategoryGrade.SECOND.getState();
		Map<String,String>params=new HashMap<String, String>();
		params.put("state", state);
		params.put("grade", grade);
		Criterion criterion=Restrictions.allEq(params);
		List<GoodsCategoryT> list = this.goodsCategoryTService.findByCriteria(GoodsCategoryT.class, criterion);
		if (list != null) {
			this.goodscategorytwo = "<option value='-1'>---请选择---</option>";
			for (Iterator<GoodsCategoryT> it = list.iterator(); it.hasNext();) {
				GoodsCategoryT gct = (GoodsCategoryT) it.next();
				this.goodscategorytwo += "<option value='" + gct.getGoodsCategoryTid() + "'>" + gct.getName() + "</option>";
			}
			this.setSucflag(true);
			return JSON;
		} else {
			this.setGoodscategorytwo(StaticKey.EMPTY);
			this.goodscategorytwo = "<option value='-1'>---请选择---</option>";
		}
		this.setSucflag(true);
		return JSON;
	}

	/**
	 * 增加商品分类
	 * 
	 * @return
	 */
	@Action(value = "addGoodsCategory", results = { @Result(name = "json", type = "json") })
	public String addGoodsCategory() {
		Criterion criterion=Restrictions.eq("name", this.getName());
		GoodsCategoryT gname=this.goodsCategoryTService.findOneByCriteria(GoodsCategoryT.class, criterion);
		Criterion criterion2=Restrictions.eq("sign", this.getSign());
		GoodsCategoryT gsign=this.goodsCategoryTService.findOneByCriteria(GoodsCategoryT.class, criterion2);
		if (gname==null&& gsign==null) {
			if (Integer.parseInt(this.getGrade()) == 0) {
				GoodsCategoryT gct = new GoodsCategoryT();
				gct.setGoodsCategoryTid(this.getSerial().Serialid(Serial.GOODSCATEGORY));
				gct.setGrade(this.getGrade().trim());//顶级，一级
				gct.setMetaKeywords(this.getMetaKeywords().trim());
				gct.setMetaDes(this.getMetaDes().trim());
				gct.setName(this.getName().trim());
				gct.setState(DataUsingState.USING.getState());
				gct.setPath(gct.getGoodsCategoryTid());
				gct.setSort(Integer.parseInt(this.getSort().trim()));
				gct.setSign(this.getSign().trim());
				gct.setGoodsTypeId(this.getGoodsTypeId());
				gct.setCreatetime(BaseTools.getSystemTime());
				gct.setCreatorid(BaseTools.getAdminCreateId());
				gct.setUpdatetime(BaseTools.getSystemTime());
				gct.setVersiont(0);
				gct.setParentName(StaticKey.EMPTY);
				gct.setLogo(this.getLogo());
				gct.setSmallLogo(this.getSmallLogo());
				gct.setMobilesync(this.getMobilesync());
				gct.setShopid(BaseTools.getShopId());
				gct.setShopname(BaseTools.getShopName());
				this.goodsCategoryTService.save(gct);
				this.setSucflag(true);
				return JSON;
			}
		} else {
			return JSON;
		}
		return JSON;
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
			return JSON;
		}
		String goodsCategoryTid=this.getGoodsCategoryTid().trim();
		GoodsCategoryT gct=this.goodsCategoryTService.findByPK(GoodsCategoryT.class, goodsCategoryTid);
		if(gct==null){
			return JSON;
		}
		Criterion criterion=Restrictions.and(Restrictions.eq("name", gct.getName())).add(Restrictions.ne("goodsCategoryTid", goodsCategoryTid));
		GoodsCategoryT gname=this.goodsCategoryTService.findOneByCriteria(GoodsCategoryT.class,criterion);
		Criterion criterion2=Restrictions.and(Restrictions.eq("sign", gct.getSign())).add(Restrictions.ne("goodsCategoryTid", goodsCategoryTid));
		GoodsCategoryT gsign=this.goodsCategoryTService.findOneByCriteria(GoodsCategoryT.class, criterion2);
		//判断更新的一级分类的名称和标示是否和其他分类重复
		if (gname==null && gsign==null) {
			if (Integer.parseInt(this.getGrade()) == 0) {
				gct.setGoodsTypeId(this.getGoodsTypeId());//商品类型id
				gct.setParentId(StaticKey.EMPTY);//将父分类设置成空
				gct.setParentName(StaticKey.EMPTY);//父分类名称应为是顶级和一级分类所以名称空
				gct.setGrade(this.getGrade().trim());//顶级分类一级分类
				gct.setName(this.getName().trim());
				gct.setMetaKeywords(this.getMetaKeywords().trim());
				gct.setMetaDes(this.getMetaDes().trim());
				gct.setState(DataUsingState.USING.getState());
				gct.setPath(StaticKey.EMPTY);//将原有分类递归路径设置成空
				gct.setSort(Integer.parseInt(this.getSort().trim()));
				gct.setSign(this.getSign().trim());
				gct.setCreatorid(BaseTools.getAdminCreateId());
				gct.setUpdatetime(BaseTools.getSystemTime());
				gct.setVersiont(gct.getVersiont()+1);
				gct.setLogo(this.getLogo());
				gct.setSmallLogo(this.getSmallLogo());
				gct.setMobilesync(this.getMobilesync());
				gct.setShopid(BaseTools.getShopId());
				gct.setShopname(BaseTools.getShopName());
				this.goodsCategoryTService.update(gct);
				this.setSucflag(true);
				return JSON;
			}
		}
		return JSON;
	}

	/**
	 * 增加二级分类
	 * 
	 * @return
	 */
	@Action(value = "addGoodsCategoryTwo", results = { @Result(name = "json", type = "json") })
	public String addGoodsCategoryTwo() {
		Criterion criterion=Restrictions.eq("name", this.getName());
		GoodsCategoryT gname=this.goodsCategoryTService.findOneByCriteria(GoodsCategoryT.class, criterion);
		Criterion criterion2=Restrictions.eq("sign", this.getSign());
		GoodsCategoryT gsign=this.goodsCategoryTService.findOneByCriteria(GoodsCategoryT.class, criterion2);
		if (gname==null && gsign== null) {
			if (Integer.parseInt(this.getGrade()) == 1) {
				GoodsCategoryT gct = new GoodsCategoryT();
				gct.setGoodsCategoryTid(this.getSerial().Serialid(Serial.GOODSCATEGORY));
				gct.setGrade(this.getGrade().trim());//二级
				gct.setMetaKeywords(this.getMetaKeywords().trim());
				gct.setMetaDes(this.getMetaDes().trim());
				gct.setName(this.getName().trim());
				gct.setState(DataUsingState.USING.getState());
				gct.setPath(this.getParentId() + StaticKey.SPLITDOT + gct.getGoodsCategoryTid());
				gct.setSort(Integer.parseInt(this.getSort().trim()));
				gct.setSign(this.getSign().trim());
				gct.setGoodsTypeId(this.getGoodsTypeId());
				gct.setCreatetime(BaseTools.getSystemTime());
				gct.setCreatorid(BaseTools.getAdminCreateId());
				gct.setUpdatetime(BaseTools.getSystemTime());
				gct.setVersiont(0);
				gct.setParentId(this.getParentId());
				gct.setParentName(this.getParentName());
				gct.setLogo(this.getLogo());
				gct.setSmallLogo(this.getSmallLogo());
				gct.setMobilesync(this.getMobilesync());
				gct.setShopid(BaseTools.getShopId());
				gct.setShopname(BaseTools.getShopName());
				this.goodsCategoryTService.save(gct);
				this.setSucflag(true);
				return JSON;
			}
		} else {
			return JSON;
		}
		return JSON;
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
			return JSON;
		}
		String goodsCategoryTid=this.getGoodsCategoryTid().trim();
		GoodsCategoryT gct=this.goodsCategoryTService.findByPK(GoodsCategoryT.class, goodsCategoryTid);
		if(gct==null){
			return JSON;
		}
		Criterion criterion=Restrictions.and(Restrictions.eq("name", gct.getName())).add(Restrictions.ne("goodsCategoryTid", goodsCategoryTid));
		GoodsCategoryT gname=this.goodsCategoryTService.findOneByCriteria(GoodsCategoryT.class,criterion);
		Criterion criterion2=Restrictions.and(Restrictions.eq("sign", gct.getSign())).add(Restrictions.ne("goodsCategoryTid", goodsCategoryTid));
		GoodsCategoryT gsign=this.goodsCategoryTService.findOneByCriteria(GoodsCategoryT.class, criterion2);
		//判断更新的一级分类的名称和标示是否和其他分类重复
		if (gname==null && gsign==null) {
			if (Integer.parseInt(this.getGrade()) ==1) {
				gct.setGoodsTypeId(this.getGoodsTypeId());//商品类型id
				gct.setParentId(this.getParentId().trim());
				gct.setParentName(this.getParentName());
				gct.setGrade(this.getGrade().trim());//二级分类
				gct.setName(this.getName().trim());
				gct.setMetaKeywords(this.getMetaKeywords().trim());
				gct.setMetaDes(this.getMetaDes().trim());
				gct.setState(DataUsingState.USING.getState());
			    gct.setPath(this.getParentId() + StaticKey.SPLITDOT + gct.getGoodsCategoryTid());//path代表了递归路径，要更新
				gct.setSort(Integer.parseInt(this.getSort().trim()));
				gct.setSign(this.getSign().trim());
				gct.setCreatorid(BaseTools.getAdminCreateId());
				gct.setUpdatetime(BaseTools.getSystemTime());
				gct.setVersiont(gct.getVersiont()+1);
				gct.setLogo(this.getLogo());
				gct.setSmallLogo(this.getSmallLogo());
				gct.setMobilesync(this.getMobilesync());
				gct.setShopid(BaseTools.getShopId());
				gct.setShopname(BaseTools.getShopName());
				this.goodsCategoryTService.update(gct);
				this.setSucflag(true);
				return JSON;
			}
		} else {
			this.setSucflag(false);
			return JSON;
		}
		this.setSucflag(false);
		return JSON;
	}
	/**
	 * 增加三级分类
	 * 
	 * @return
	 */
	@Action(value = "addGoodsCategoryThree", results = { @Result(name = "json", type = "json") })
	public String addGoodsCategoryThree() {
		Criterion criterion=Restrictions.eq("name", this.getName());
		GoodsCategoryT gname=this.goodsCategoryTService.findOneByCriteria(GoodsCategoryT.class, criterion);
		Criterion criterion2=Restrictions.eq("sign", this.getSign());
		GoodsCategoryT gsign=this.goodsCategoryTService.findOneByCriteria(GoodsCategoryT.class, criterion2);
		if (gname==null && gsign==null) {
			if (Integer.parseInt(this.getGrade()) == 2) {
				GoodsCategoryT gct = new GoodsCategoryT();
				gct.setGoodsCategoryTid(this.getSerial().Serialid(Serial.GOODSCATEGORY));
				gct.setGrade(this.getGrade().trim());//三级
				gct.setMetaKeywords(this.getMetaKeywords().trim());
				gct.setMetaDes(this.getMetaDes().trim());
				gct.setName(this.getName().trim());
				gct.setState(DataUsingState.USING.getState());
				gct.setPath(this.getParentId() +StaticKey.SPLITDOT + this.getParentId1() + StaticKey.SPLITDOT + gct.getGoodsCategoryTid());
				gct.setSort(Integer.parseInt(this.getSort().trim()));
				gct.setSign(this.getSign().trim());
				gct.setGoodsTypeId(this.getGoodsTypeId());
				gct.setCreatetime(BaseTools.getSystemTime());
				gct.setCreatorid(BaseTools.getAdminCreateId());
				gct.setUpdatetime(BaseTools.getSystemTime());
				gct.setVersiont(0);
				gct.setParentId(this.getParentId1());
				gct.setParentName(this.getParentName1());
				gct.setLogo(this.getLogo());
				gct.setSmallLogo(this.getSmallLogo());
				gct.setMobilesync(this.getMobilesync());
				gct.setShopid(BaseTools.getShopId());
				gct.setShopname(BaseTools.getShopName());
				this.goodsCategoryTService.save(gct);
				this.setSucflag(true);
				return JSON;
			}
		} else {
			return JSON;
		}
		return JSON;
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
			return JSON;
		}
		String goodsCategoryTid=this.getGoodsCategoryTid().trim();
		GoodsCategoryT gct=this.goodsCategoryTService.findByPK(GoodsCategoryT.class, goodsCategoryTid);
		if(gct==null){
			return JSON;
		}
		Criterion criterion=Restrictions.and(Restrictions.eq("name", gct.getName())).add(Restrictions.ne("goodsCategoryTid", goodsCategoryTid));
		GoodsCategoryT gname=this.goodsCategoryTService.findOneByCriteria(GoodsCategoryT.class,criterion);
		Criterion criterion2=Restrictions.and(Restrictions.eq("sign", gct.getSign())).add(Restrictions.ne("goodsCategoryTid", goodsCategoryTid));
		GoodsCategoryT gsign=this.goodsCategoryTService.findOneByCriteria(GoodsCategoryT.class, criterion2);
		//判断更新的一级分类的名称和标示是否和其他分类重复
		if (gname==null && gsign==null) {
			if (Integer.parseInt(this.getGrade()) == 2) {
				gct.setGoodsTypeId(this.getGoodsTypeId());
				gct.setParentId(this.getParentId1());
				gct.setParentName(this.getParentName1());
				gct.setGrade(this.getGrade().trim());//三级分类
				gct.setName(this.getName().trim());
				gct.setMetaKeywords(this.getMetaKeywords().trim());
				gct.setMetaDes(this.getMetaDes().trim());
				gct.setState(DataUsingState.USING.getState());
				gct.setPath(this.getParentId()+StaticKey.SPLITDOT+this.getParentId1()+StaticKey.SPLITDOT+gct.getGoodsCategoryTid());
				gct.setSort(Integer.parseInt(this.getSort().trim()));
				gct.setSign(this.getSign().trim());
				gct.setCreatorid(BaseTools.getAdminCreateId());
				gct.setUpdatetime(BaseTools.getSystemTime());
				gct.setVersiont(gct.getVersiont()+1);
				gct.setLogo(this.getLogo());
				gct.setSmallLogo(this.getSmallLogo());
				gct.setMobilesync(this.getMobilesync());
				gct.setShopid(BaseTools.getShopId());
				gct.setShopname(BaseTools.getShopName());
				this.goodsCategoryTService.update(gct);
				this.setSucflag(true);
				return JSON;
			}
		} else {
			this.setSucflag(false);
			return JSON;
		}
		this.setSucflag(false);
		return JSON;
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
				return JSON;
			} else {
				return JSON;
			}
		}
		return JSON;
	}

	private void findDefaultAllGoodsCategoryT() {
		int currentPage = page;
		int lineSize = rp;
		String state = DataUsingState.USING.getState();
		Criterion criterion=Restrictions.eq("state", state);
		total = this.goodsCategoryTService.count(GoodsCategoryT.class, criterion).intValue();
		if(StringUtils.isNotBlank(this.getSortname())&&StringUtils.isNotBlank(this.getSortorder())){
			Order order=null;
			if(StringUtils.equals(this.getSortorder(), StaticKey.ASC)){
				order=Order.asc(this.getSortname());
			}else{
				order=Order.desc(this.getSortname());
			}
			List<GoodsCategoryT>list=this.goodsCategoryTService.findByCriteriaByPage(GoodsCategoryT.class, criterion, order, currentPage, lineSize);
			this.processGoodsCategoryTList(list);
		}
	}

	public void processGoodsCategoryTList(List<GoodsCategoryT> list) {
		for (Iterator<GoodsCategoryT> it = list.iterator(); it.hasNext();) {
			GoodsCategoryT gct = (GoodsCategoryT) it.next();
			gct.setGrade(CategoryGrade.getName(gct.getGrade()));
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
		if (StringUtils.isNotBlank(this.getGoodsCategoryTid())) {
			bean = this.goodsCategoryTService.findByPK(GoodsCategoryT.class, this.getGoodsCategoryTid());
			if (bean != null) {
				this.setBasepath(BaseTools.getBasePath()+"/");
				this.setSucflag(true);
				return JSON;
			}
		}
		return JSON;
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
		if(StringUtils.isBlank(this.getName())&&StringUtils.isBlank(this.getSign())&&StringUtils.isBlank(this.getGoodsCategoryTid())){
			return JSON;
		}
		GoodsCategoryT gct =this.goodsCategoryTService.findByPK(GoodsCategoryT.class, this.getGoodsCategoryTid());
		if(gct==null){
			return JSON;
		}
		Criterion criterion=Restrictions.and(Restrictions.eq("name", this.getName())).add(Restrictions.ne("goodsCategoryTid", this.getGoodsCategoryTid()));
		GoodsCategoryT gname=this.goodsCategoryTService.findOneByCriteria(GoodsCategoryT.class,criterion);
		Criterion criterion2=Restrictions.and(Restrictions.eq("sign", this.getSign())).add(Restrictions.ne("goodsCategoryTid",this.getGoodsCategoryTid()));
		GoodsCategoryT gsign=this.goodsCategoryTService.findOneByCriteria(GoodsCategoryT.class, criterion2);
		if (gname== null && gsign == null) {
			gct.setName(this.getName().trim());
			gct.setGoodsTypeId(this.getGoodsTypeId().trim());
			gct.setSign(this.getSign().trim());
			gct.setSort(Integer.parseInt(this.getSort().trim()));
			gct.setMetaKeywords(this.getMetaKeywords());
			gct.setMetaDes(this.getMetaDes());
			gct.setGoodsCategoryTid(this.getGoodsCategoryTid());
			gct.setCreatetime(BaseTools.getSystemTime());
			gct.setCreatorid(BaseTools.getAdminCreateId());
			gct.setUpdatetime(BaseTools.getSystemTime());
			gct.setVersiont(0);
			gct.setLogo(this.getLogo());
			gct.setSmallLogo(this.getSmallLogo());
			gct.setMobilesync(this.getMobilesync());
			gct.setShopid(BaseTools.getShopId());
			gct.setShopname(BaseTools.getShopName());
			this.goodsCategoryTService.update(gct);
			this.setSucflag(true);
			bean=gct;
			return JSON;
		} else {
			this.setSucflag(false);
			return JSON;
		}
	}

	/**
	 * 更新商品分类静态路径
	 * 
	 * @param articleid
	 * @param htmlPath
	 */
	public void updateHtmlPath(String goodsCategoryTid, String htmlpath) {
		GoodsCategoryT gct=this.goodsCategoryTService.findByPK(GoodsCategoryT.class, goodsCategoryTid);
		if(gct!=null){
			gct.setHtmlpath(htmlpath);;
			this.goodsCategoryTService.update(gct);
		}
	}

	/**
	 * 删除商品分类
	 * 
	 * @return
	 */
	@Action(value = "delGoodscategoryT", results = { @Result(name = "json", type = "json") })
	public String delGoodscategoryT() {
		if (StringUtils.isNotBlank(this.getGoodsCategoryTid())) {
			String[]strs=StringUtils.split(this.getGoodsCategoryTid().trim(), StaticKey.SPLITDOT);
			for(String s:strs){
				GoodsCategoryT gct=this.goodsCategoryTService.findByPK(GoodsCategoryT.class, s);
				if(gct!=null){
					this.goodsCategoryTService.delete(gct);
				}
			}
			this.setSucflag(true);
			//更新商品分类的静态页路径
			updateGoodsCategoryhtmlpath();
		}
		return JSON;
	}
	
	
	/**
	 * 更新商品分类的静态页路径
	 */
	private void updateGoodsCategoryhtmlpath(){
		Criterion criterion=Restrictions.and(Restrictions.eq("grade", CategoryGrade.FIRST.getState())).add(Restrictions.eq("state", DataUsingState.USING.getState()));
		List<GoodsCategoryT>list=this.goodsCategoryTService.findByCriteria(GoodsCategoryT.class, criterion);
		for(Iterator<GoodsCategoryT> it=list.iterator();it.hasNext();){
			GoodsCategoryT gct=(GoodsCategoryT)it.next();
			Criterion criterion2=Restrictions.and(Restrictions.eq("parentId", gct.getParentId())).add(Restrictions.eq("state", DataUsingState.USING.getState()));
			List<GoodsCategoryT>glist=this.goodsCategoryTService.findByCriteria(GoodsCategoryT.class, criterion2);
			if(glist.isEmpty()){
				updateHtmlPath(glist);
			}
		}
	}
	
	private void updateHtmlPath(List<GoodsCategoryT>list){
		for(Iterator<GoodsCategoryT> it=list.iterator();it.hasNext();){
			GoodsCategoryT gct=(GoodsCategoryT)it.next();
			gct.setHtmlpath(StaticKey.EMPTY);
			this.goodsCategoryTService.update(gct);
		}
	}

	/**
	 * 获取顶级分类一级
	 * 
	 * @return
	 */
	@Action(value = "findGoodscategoryNavid", results = { @Result(name = "json", type = "json") })
	public String findGoodscategoryNavid() {
		this.setNavidlist(StaticKey.EMPTY);
		Criterion criterion=Restrictions.eq("grade", CategoryGrade.FIRST.getState());
		this.goodstypetnav = this.goodsCategoryTService.findByCriteria(GoodsCategoryT.class, criterion);
		if(!goodstypetnav.isEmpty()){
			for (Iterator<GoodsCategoryT> it = goodstypetnav.iterator(); it.hasNext();) {
				GoodsCategoryT gct = it.next();
				navidlist += "<option value='" + gct.getGoodsCategoryTid() + "'>" + gct.getName() + "</option>";
			}
		}
		this.setNavidlist(navidlist);
		this.setSucflag(true);
		return JSON;
	}

	/**
	 * 获取二级分类
	 * 
	 * @return
	 */
	@Action(value = "findGoodscategoryLtypeid", results = { @Result(name = "json", type = "json") })
	public String findGoodscategoryLtypeid() {
		if (StringUtils.isNotBlank(this.getParentId())) {
			this.setLtypeidlist(StaticKey.EMPTY);
			Criterion criterion=Restrictions.and(Restrictions.eq("parentId", this.getParentId())).add(Restrictions.eq("state", DataUsingState.USING.getState()));
			this.secondcategory = this.goodsCategoryTService.findByCriteria(GoodsCategoryT.class, criterion);
			if (!this.secondcategory.isEmpty()) {
				this.ltypeidlist = "<option value='0'>---请选择---</option>";
				for (Iterator<GoodsCategoryT> it = this.secondcategory.iterator(); it.hasNext();) {
					GoodsCategoryT gct = it.next();
					ltypeidlist += "<option value='" + gct.getGoodsCategoryTid() + "'>" + gct.getName() + "</option>";
				}
				this.setLtypeidlist(ltypeidlist);
				this.setSucflag(true);
				return JSON;
			}
			this.setLtypeidlist(StaticKey.EMPTY);
			this.setSucflag(true);
			return JSON;
		}
		return JSON;
	}

	/**
	 * 获取三级分类
	 * 
	 * @return
	 */
	@Action(value = "findGoodscategoryStypeid", results = { @Result(name = "json", type = "json") })
	public String findGoodscategoryStypeid() {
		if (StringUtils.isNotBlank(this.getParentId())) {
			this.setLtypeidlist(StaticKey.EMPTY);
			Criterion criterion=Restrictions.and(Restrictions.eq("parentId", this.getParentId())).add(Restrictions.eq("state", DataUsingState.USING.getState()));
			this.thiredscategory = this.goodsCategoryTService.findByCriteria(GoodsCategoryT.class, criterion);
			if (this.thiredscategory != null) {
				this.stypeidlist = "<option value='-1'>---请选择---</option>";
				for (Iterator<GoodsCategoryT> it = this.thiredscategory.iterator(); it.hasNext();) {
					GoodsCategoryT gct = (GoodsCategoryT) it.next();
					stypeidlist += "<option value='" + gct.getGoodsCategoryTid() + "'>" + gct.getName() + "</option>";
				}
				this.setStypeidlist(stypeidlist);
				this.setSucflag(true);
				return JSON;
			}
			this.setStypeidlist(StaticKey.EMPTY);
			this.setSucflag(true);
			return JSON;
		}
		return JSON;
	}
}
