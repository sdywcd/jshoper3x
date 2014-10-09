package com.jshop.action.backstage.content.article;

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
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.ArticleCategoryT;
import com.jshop.service.ArticleCategoryTService;
import com.jshop.service.impl.Serial;
@Namespace("")
@ParentPackage("jshop")
//@InterceptorRefs({  
//    @InterceptorRef("articlemoduleArticleInterecptor"),  
//    @InterceptorRef("defaultStack")
//})
public class ArticleCategoryTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private ArticleCategoryTService articleCategoryTService;
	private String articleCategoryTid;
	private String grade;
	private String metaKeywords;
	private String metaDes;
	private String name;
	private String status;
	private Date createtime;
	private String creatorid;
	private String path;
	private String sort;
	private String parentId;
	private String parentId1;
	private String sign;
	private String position;
	private String mobilesync;
	private String logo;
	private String parentName;
	private String parentName1;
	private String articlecategoryzero;
	private String articlecategorythree;
	private String articlecategorytwo;
	private List<ArticleCategoryT> secondcategory = new ArrayList<ArticleCategoryT>();
	private List<ArticleCategoryT> thiredscategory = new ArrayList<ArticleCategoryT>();
	private String navidlist;
	private String ltypeidlist;
	private String stypeidlist;
	private ArticleCategoryT bean = new ArticleCategoryT();
	private List<Map<String,Object>> rows=new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean slogin;
	private boolean sucflag;
	private String basepath;

	@JSON(serialize = false)
	public ArticleCategoryTService getArticleCategoryTService() {
		return articleCategoryTService;
	}

	public void setArticleCategoryTService(ArticleCategoryTService articleCategoryTService) {
		this.articleCategoryTService = articleCategoryTService;
	}
	public String getArticleCategoryTid() {
		return articleCategoryTid;
	}

	public void setArticleCategoryTid(String articleCategoryTid) {
		this.articleCategoryTid = articleCategoryTid;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getArticlecategoryzero() {
		return articlecategoryzero;
	}

	public void setArticlecategoryzero(String articlecategoryzero) {
		this.articlecategoryzero = articlecategoryzero;
	}

	public String getArticlecategorythree() {
		return articlecategorythree;
	}

	public void setArticlecategorythree(String articlecategorythree) {
		this.articlecategorythree = articlecategorythree;
	}

	public String getArticlecategorytwo() {
		return articlecategorytwo;
	}

	public void setArticlecategorytwo(String articlecategorytwo) {
		this.articlecategorytwo = articlecategorytwo;
	}

	public List<ArticleCategoryT> getSecondcategory() {
		return secondcategory;
	}

	public void setSecondcategory(List<ArticleCategoryT> secondcategory) {
		this.secondcategory = secondcategory;
	}

	public List<ArticleCategoryT> getThiredscategory() {
		return thiredscategory;
	}

	public void setThiredscategory(List<ArticleCategoryT> thiredscategory) {
		this.thiredscategory = thiredscategory;
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

	public ArticleCategoryT getBean() {
		return bean;
	}

	public void setBean(ArticleCategoryT bean) {
		this.bean = bean;
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

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getParentId1() {
		return parentId1;
	}

	public void setParentId1(String parentId1) {
		this.parentId1 = parentId1;
	}

	public String getParentName1() {
		return parentName1;
	}

	public void setParentName1(String parentName1) {
		this.parentName1 = parentName1;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMobilesync() {
		return mobilesync;
	}

	public void setMobilesync(String mobilesync) {
		this.mobilesync = mobilesync;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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
	 * 
	 * @return
	 */
	@Action(value = "findArticlCategoryByGradeZeroone", results = { @Result(name = "json", type = "json") })
	public String findArticlCategoryByGradeZeroone() {
		this.setArticlecategoryzero("");
		List<ArticleCategoryT> list = this.getArticleCategoryTService().findArticleCategoryByGrade("0", "1");
		if (!list.isEmpty()) {
			for (Iterator<ArticleCategoryT> it = list.iterator(); it.hasNext();) {
				ArticleCategoryT act = (ArticleCategoryT) it.next();
				this.articlecategoryzero += "<option value='" + act.getArticleCategoryTid() + "'>" + act.getName() + "</option>";
			}
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(true);
		return "json";
	}
	

	/**
	 * 获取二级分类
	 * 
	 * @return
	 */
	@Action(value = "findArticleCategoryByparentId", results = { @Result(name = "json", type = "json") })
	public String findArticleCategoryByparentId() {
		if(StringUtils.isBlank(this.getParentId())){
			return "json";
		}
		this.setArticlecategorytwo("");
		String status="1";
		String parentId=this.getParentId().trim();
		List<ArticleCategoryT> list = this.getArticleCategoryTService().findArticleCategoryByparentId(status, parentId);
		if (!list.isEmpty()) {
			this.setArticlecategorytwo("<option value='-1'>---请选择---</option>");
			for (Iterator<ArticleCategoryT> it = list.iterator(); it.hasNext();) {
				ArticleCategoryT act = (ArticleCategoryT) it.next();
				this.articlecategorytwo += "<option value='" + act.getArticleCategoryTid() + "'>" + act.getName() + "</option>";
			}
		} else {
			this.setArticlecategorytwo("");
			this.articlecategorytwo = "<option value='-1'>---请选择---</option>";
		}
		this.setSucflag(true);
		return "json";
	}

	/**
	 * 增加文章分类
	 * 
	 * @return
	 */
	@Action(value = "addArticleCategoryT", results = { @Result(name = "json", type = "json") })
	public String addArticleCategoryT() {
		int i = this.getArticleCategoryTService().checkArticleCategoryName(this.getName());
		int j = this.getArticleCategoryTService().checkArticleCategorySign(this.getSign());
		if (i == 0 && j == 0) {
			if (Integer.parseInt(this.getGrade()) == 0) {
				ArticleCategoryT act = new ArticleCategoryT();
				act.setArticleCategoryTid(this.getSerial().Serialid(Serial.ARTICLECATEGORY));
				act.setGrade(this.getGrade().trim());//顶级，一级
				act.setMetaKeywords(this.getMetaKeywords().trim());
				act.setMetaDes(this.getMetaDes().trim());
				act.setName(this.getName().trim());
				act.setStatus(StaticKey.ONE);//启用
				act.setPath(act.getArticleCategoryTid());
				act.setSort(Integer.parseInt(this.getSort().trim()));
				act.setSign(this.getSign().trim());
				act.setCreatetime(BaseTools.systemtime());
				act.setCreatorid(BaseTools.getAdminCreateId());
				act.setUpdatetime(BaseTools.systemtime());
				act.setVersiont(0);
				act.setParentName(StaticKey.EMPTY);
				act.setPosition(this.getPosition());
				act.setMobilesync(this.getMobilesync());
				act.setLogo(this.getLogo().trim());
				this.getArticleCategoryTService().save(act);
				this.setSucflag(true);
				return "json";
			} else {
				this.setSucflag(false);
				return "json";
			}
		} else {
			this.setSucflag(false);
			return "json";
		}

	}
	
	/**
	 * 更新文章分类到顶级分类或者一级分类（顶级分类就是一级分类只是在前端有区分）
	 * @return
	 */
	@Action(value = "updateArticleCategory", results = { @Result(name = "json", type = "json") })
	public String updateArticleCategory(){
		if(StringUtils.isBlank(this.getArticleCategoryTid())){
			return "json";
		}
		String articleCategoryTid=this.getArticleCategoryTid().trim();
		ArticleCategoryT act=new ArticleCategoryT();
		act=this.getArticleCategoryTService().findArticleCategoryByarticleCategoryTid(articleCategoryTid);
		int i=this.getArticleCategoryTService().checkArticleCategoryNamewithoutMe(articleCategoryTid, act.getName());
		int j=this.getArticleCategoryTService().checkArticleCategorySignwithoutMe(articleCategoryTid, act.getSign());
		//判定更新的一级分类名称和标示是否和其他分类重复
		if(i==0&&j==0){
			if(Integer.parseInt(this.getGrade())==0){
				act.setGrade(this.getGrade().trim());//顶级分类一级分类
				act.setMetaKeywords(this.getMetaKeywords().trim());
				act.setMetaDes(this.getMetaDes().trim());
				act.setName(this.getName().trim());
				act.setStatus(StaticKey.ONE);
				act.setCreatorid(BaseTools.getAdminCreateId());
				act.setPath(StaticKey.EMPTY);
				act.setSort(Integer.parseInt(this.getSort()));
				act.setParentId(StaticKey.EMPTY);
				act.setSign(this.getSign().trim());
				act.setParentName(StaticKey.EMPTY);
				act.setPosition(this.getPosition().trim());
				act.setUpdatetime(BaseTools.systemtime());
				act.setVersiont(act.getVersiont()+1);
				act.setMobilesync(this.getMobilesync());
				act.setLogo(this.getLogo().trim());
				this.getArticleCategoryTService().update(act);
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
	@Action(value = "addArticleCategoryTwo", results = { @Result(name = "json", type = "json") })
	public String addArticleCategoryTwo() {
		int i = this.getArticleCategoryTService().checkArticleCategoryName(this.getName());
		int j = this.getArticleCategoryTService().checkArticleCategorySign(this.getSign());
		if (i == 0 && j == 0) {
			if (Integer.parseInt(this.getGrade()) == 1) {
				ArticleCategoryT act = new ArticleCategoryT();
				act.setArticleCategoryTid(this.getSerial().Serialid(Serial.ARTICLECATEGORY));
				act.setGrade(this.getGrade().trim());//二级
				act.setMetaKeywords(this.getMetaKeywords().trim());
				act.setMetaDes(this.getMetaDes().trim());
				act.setName(this.getName().trim());
				act.setStatus(StaticKey.ONE);
				act.setPath(this.getParentId() + "," + act.getArticleCategoryTid());
				act.setSort(Integer.parseInt(this.getSort().trim()));
				act.setSign(this.getSign().trim());
				act.setCreatetime(BaseTools.systemtime());
				act.setCreatorid(BaseTools.getAdminCreateId());
				act.setUpdatetime(BaseTools.systemtime());
				act.setVersiont(0);
				act.setParentId(this.getParentId());
				act.setParentName(this.getParentName());
				act.setPosition(this.getPosition());
				act.setMobilesync(this.getMobilesync());
				act.setLogo(this.getLogo().trim());
				this.getArticleCategoryTService().save(act);
				this.setSucflag(true);
				return "json";
			}
		} 
		return "json";
	}

	/**
	 * 更新文章分类到二级分类
	 * @return
	 */
	@Action(value = "updateArticleCategoryTwo", results = { @Result(name = "json", type = "json") })
	public String updateArticleCategoryTwo(){
		if(StringUtils.isBlank(this.getArticleCategoryTid())){
			return "json";
		}
		String articleCategoryTid=this.getArticleCategoryTid().trim();
		ArticleCategoryT act=new ArticleCategoryT();
		act=this.getArticleCategoryTService().findArticleCategoryByarticleCategoryTid(articleCategoryTid);
		int i=this.getArticleCategoryTService().checkArticleCategoryNamewithoutMe(articleCategoryTid, act.getName());
		int j=this.getArticleCategoryTService().checkArticleCategorySignwithoutMe(articleCategoryTid, act.getSign());
		//判定更新的一级分类名称和标示是否和其他分类重复
		if(i==0&&j==0){
			if(Integer.parseInt(this.getGrade())==1){
				act.setGrade(this.getGrade().trim());//顶级分类一级分类
				act.setMetaKeywords(this.getMetaKeywords().trim());
				act.setMetaDes(this.getMetaDes().trim());
				act.setName(this.getName().trim());
				act.setStatus(StaticKey.ONE);
				act.setCreatorid(BaseTools.getAdminCreateId());
				act.setPath(this.getParentId()+","+act.getArticleCategoryTid());
				act.setSort(Integer.parseInt(this.getSort()));
				act.setParentId(this.getParentId().trim());
				act.setSign(this.getSign().trim());
				act.setParentName(this.getParentName());
				act.setPosition(this.getPosition().trim());
				act.setUpdatetime(BaseTools.systemtime());
				act.setVersiont(act.getVersiont()+1);
				act.setMobilesync(this.getMobilesync());
				act.setLogo(this.getLogo().trim());
				this.getArticleCategoryTService().update(act);
				this.setSucflag(true);
				return "json";
			}
		}
		return "json";
	}
	
	
	/**
	 * 增加三级分类
	 * 
	 * @return
	 */
	@Action(value = "addArticleCategoryThree", results = { @Result(name = "json", type = "json") })
	public String addArticleCategoryThree() {
		int i = this.getArticleCategoryTService().checkArticleCategoryName(this.getName());
		int j = this.getArticleCategoryTService().checkArticleCategorySign(this.getSign());
		if (i == 0 && j == 0) {
			if (Integer.parseInt(this.getGrade()) == 2) {
				ArticleCategoryT act = new ArticleCategoryT();
				act.setArticleCategoryTid(this.getSerial().Serialid(Serial.ARTICLECATEGORY));
				act.setGrade(this.getGrade().trim());//三级
				act.setMetaKeywords(this.getMetaKeywords().trim());
				act.setMetaDes(this.getMetaDes().trim());
				act.setName(this.getName().trim());
				act.setStatus(StaticKey.ONE);
				act.setPath(this.getParentId() + "," + this.getParentId1() + "," + act.getArticleCategoryTid());
				act.setSort(Integer.parseInt(this.getSort().trim()));
				act.setSign(this.getSign().trim());
				act.setCreatetime(BaseTools.systemtime());
				act.setCreatorid(BaseTools.getAdminCreateId());
				act.setUpdatetime(BaseTools.systemtime());
				act.setVersiont(0);
				act.setParentId(this.getParentId1());
				act.setParentName(this.getParentName1());
				act.setPosition(this.getPosition());
				act.setMobilesync(this.getMobilesync());
				act.setLogo(this.getLogo().trim());
				this.getArticleCategoryTService().save(act);
				this.setSucflag(true);
				return "json";
			} 
		}
		return "json";
	}

	/**
	 * 更新文章分类到三级分类
	 * @return
	 */
	@Action(value = "updateArticleCategoryThree", results = { @Result(name = "json", type = "json") })
	public String updateArticleCategoryThree(){
		if(StringUtils.isBlank(this.getArticleCategoryTid())){
			return "json";
		}
		String articleCategoryTid=this.getArticleCategoryTid().trim();
		ArticleCategoryT act=new ArticleCategoryT();
		act=this.getArticleCategoryTService().findArticleCategoryByarticleCategoryTid(articleCategoryTid);
		int i=this.getArticleCategoryTService().checkArticleCategoryNamewithoutMe(articleCategoryTid, act.getName());
		int j=this.getArticleCategoryTService().checkArticleCategorySignwithoutMe(articleCategoryTid, act.getSign());
		//判定更新的一级分类名称和标示是否和其他分类重复
		if(i==0&&j==0){
			if(Integer.parseInt(this.getGrade())==2){
				act.setGrade(this.getGrade().trim());//顶级分类一级分类
				act.setMetaKeywords(this.getMetaKeywords().trim());
				act.setMetaDes(this.getMetaDes().trim());
				act.setName(this.getName().trim());
				act.setStatus(StaticKey.ONE);
				act.setCreatorid(BaseTools.getAdminCreateId());
				act.setPath(this.getParentId()+","+this.getParentId1()+","+act.getArticleCategoryTid());
				act.setSort(Integer.parseInt(this.getSort()));
				act.setParentId(this.getParentId1().trim());
				act.setSign(this.getSign().trim());
				act.setParentName(this.getParentName1());
				act.setPosition(this.getPosition().trim());
				act.setUpdatetime(BaseTools.systemtime());
				act.setVersiont(act.getVersiont()+1);
				act.setMobilesync(this.getMobilesync());
				act.setLogo(this.getLogo().trim());
				this.getArticleCategoryTService().update(act);
				this.setSucflag(true);
				return "json";
			}
		}
		return "json";
	}
	
	/**
	 * 获取所有激活的文章分类
	 * 
	 * @return
	 */
	@Action(value = "findAllArticleCategoryT", results = { @Result(name = "json", type = "json") })
	public String findAllArticleCategoryT() {
		if (StaticKey.SC.equals(this.getQtype())) {
			this.findDefaultAllArticleCategory();
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {
				return "json";
			}
		}
		return "json";
	}

	/**
	 * 获取文章分类
	 * 
	 * @return
	 */
	@Action(value = "findArticleCategoryByarticleCategoryTid", results = { @Result(name = "json", type = "json") })
	public String findArticleCategoryByarticleCategoryTid() {
		if (Validate.StrNotNull(this.getArticleCategoryTid())) {
			//bean = this.getArticleCategoryTService().findArticleCategoryByarticleCategoryTid(this.getArticleCategoryTid());
			bean=this.getArticleCategoryTService().findByPK(ArticleCategoryT.class, this.getArticleCategoryTid());
			if (bean != null) {
				this.setBasepath(BaseTools.getBasePath());
				return "json";
			}
		}
		return "json";
	}

	public void findDefaultAllArticleCategory() {
		int currentPage = page;
		int lineSize = rp;
		this.setStatus("1");
		total = this.getArticleCategoryTService().countfindAllArticleCategoryT(this.getStatus(), BaseTools.getAdminCreateId());
		if (Validate.StrNotNull(this.getSortname()) && Validate.StrNotNull(this.getSortorder())) {
			String queryString = "from ArticleCategoryT as act where act.status=:status and act.creatorid=:creatorid  order by " + this.getSortname() + " " + this.getSortorder() + "";
			List<ArticleCategoryT> list = this.getArticleCategoryTService().sortAllArticleCategoryT(currentPage, lineSize, this.getStatus(), BaseTools.getAdminCreateId(), queryString);
			if (!list.isEmpty()) {
				this.ProcessArticleCategoryTList(list);
			}
		}
	}

	public void ProcessArticleCategoryTList(List<ArticleCategoryT> list) {
		for (Iterator<ArticleCategoryT> it = list.iterator(); it.hasNext();) {
			ArticleCategoryT act = (ArticleCategoryT) it.next();
			if (act.getGrade().equals(StaticKey.ZERO)) {
				act.setGrade(StaticKey.TOPCA);
			} else if (act.getGrade().equals(StaticKey.ONE)) {
				act.setGrade(StaticKey.TWOCA);
			} else {
				act.setGrade(StaticKey.THREECA);
			}
			if (act.getPosition().equals(StaticKey.ONE)) {
				act.setPosition("<span class='truestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				act.setPosition("<span class='falsestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", act.getArticleCategoryTid());
			cellMap.put("cell", new Object[] {"<a href='articlecategory.jsp?operate=edit&folder=pagecontent&articleCategoryTid=" + act.getArticleCategoryTid() + "'>" + act.getName() + "</a>", act.getParentName(), act.getGrade(), act.getSign(), act.getSort(), act.getPosition(), BaseTools.formateDbDate(act.getCreatetime()), act.getCreatorid(),"<a id='editarticleCategory' href='articlecategory.jsp?operate=edit&folder=pagecontent&articleCategoryTid="+ act.getArticleCategoryTid()+"' name='editarticleCategory'>[编辑]</a>" });
			rows.add(cellMap);
		}

	}



	/**
	 * 删除文章分类
	 * 
	 * @return
	 */
	@Action(value = "delArticleCategoryT", results = { @Result(name = "json", type = "json") })
	public String delArticleCategoryT() {
		if (StringUtils.isNotBlank(this.getArticleCategoryTid())) {
			String[] strs = StringUtils.split(this.getArticleCategoryTid().trim(),",");
			this.getArticleCategoryTService().delArticleCategoryT(strs);
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";

	}
}
