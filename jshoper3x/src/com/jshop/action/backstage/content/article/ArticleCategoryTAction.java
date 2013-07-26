package com.jshop.action.backstage.content.article;

import java.sql.Date;
import java.util.ArrayList;
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

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.ArticleCategoryT;
import com.jshop.service.ArticleCategoryTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
@InterceptorRefs({  
    @InterceptorRef("articlemoduleArticleInterecptor"),  
    @InterceptorRef("defaultStack")
})
public class ArticleCategoryTAction extends ActionSupport {
	private ArticleCategoryTService articleCategoryTService;
	private Serial serial;
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
	private String parentName;
	private String parentName1;
	private String articlecategoryzero;
	private String articlecategorythree;
	private String articlecategorytwo;
	private String query;
	private String qtype;
	private List<ArticleCategoryT> secondcategory = new ArrayList<ArticleCategoryT>();
	private List<ArticleCategoryT> thiredscategory = new ArrayList<ArticleCategoryT>();
	private String navidlist;
	private String ltypeidlist;
	private String stypeidlist;
	private ArticleCategoryT bean = new ArticleCategoryT();
	private List rows=new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean slogin;
	private boolean sucflag;
	private String sortname;
	private String sortorder;
	private String usession;


	@JSON(serialize = false)
	public ArticleCategoryTService getArticleCategoryTService() {
		return articleCategoryTService;
	}

	public void setArticleCategoryTService(ArticleCategoryTService articleCategoryTService) {
		this.articleCategoryTService = articleCategoryTService;
	}


	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	
	public void setSerial(Serial serial) {
		this.serial = serial;
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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
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

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
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

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	public String getUsession() {
		return usession;
	}

	public void setUsession(String usession) {
		this.usession = usession;
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
		List<ArticleCategoryT> list = this.getArticleCategoryTService().findArticleCategoryByGrade("0", "1", BaseTools.adminCreateId());
		if (!list.isEmpty()) {
			this.setArticlecategoryzero("<option value='-1'>---请选择---</option><option value='0'>顶级分类</option>");
			for (Iterator it = list.iterator(); it.hasNext();) {
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
	@Action(value = "findArticleCategoryByGradeTwo", results = { @Result(name = "json", type = "json") })
	public String findArticleCategoryByGradeTwo() {
		this.setArticlecategorytwo("");
		List<ArticleCategoryT> list = this.getArticleCategoryTService().findArticleCategoryByGrade("1", "1", BaseTools.adminCreateId());
		if (!list.isEmpty()) {
			this.setArticlecategorytwo("<option value='-1'>---请选择---</option>");
			for (Iterator it = list.iterator(); it.hasNext();) {
				ArticleCategoryT act = (ArticleCategoryT) it.next();
				this.articlecategorytwo += "<option value='" + act.getArticleCategoryTid() + "'>" + act.getName() + "</option>";
			}
			this.setSucflag(true);
			return "json";
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
		int i = this.getArticleCategoryTService().checkArticleCategoryName(this.getName(), BaseTools.adminCreateId());
		int j = this.getArticleCategoryTService().checkArticleCategorySign(this.getSign(), BaseTools.adminCreateId());
		if (i == 0 && j == 0) {
			if (Integer.parseInt(this.getGrade()) == 0) {
				ArticleCategoryT act = new ArticleCategoryT();
				act.setArticleCategoryTid(this.getSerial().Serialid(Serial.ARTICLECATEGORY));
				act.setGrade(this.getGrade().trim());//顶级，一级
				act.setMetaKeywords(this.getMetaKeywords().trim());
				act.setMetaDes(this.getMetaDes().trim());
				act.setName(this.getName().trim());
				act.setStatus("1");
				act.setPath(act.getArticleCategoryTid());
				act.setSort(Integer.parseInt(this.getSort().trim()));
				act.setSign(this.getSign().trim());
				act.setCreatetime(BaseTools.systemtime());
				act.setCreatorid(BaseTools.adminCreateId());
				act.setUpdatetime(BaseTools.systemtime());
				act.setVersiont(0);
				act.setParentName("");
				act.setPosition(this.getPosition());
				this.getArticleCategoryTService().addArticleCategoryT(act);
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
	 * 增加二级分类
	 * 
	 * @return
	 */
	@Action(value = "addArticleCategoryTwo", results = { @Result(name = "json", type = "json") })
	public String addArticleCategoryTwo() {
		int i = this.getArticleCategoryTService().checkArticleCategoryName(this.getName(), BaseTools.adminCreateId());
		int j = this.getArticleCategoryTService().checkArticleCategorySign(this.getSign(), BaseTools.adminCreateId());
		if (i == 0 && j == 0) {
			if (Integer.parseInt(this.getGrade()) == 1) {
				ArticleCategoryT act = new ArticleCategoryT();
				act.setArticleCategoryTid(this.getSerial().Serialid(Serial.ARTICLECATEGORY));
				act.setGrade(this.getGrade().trim());//二级
				act.setMetaKeywords(this.getMetaKeywords().trim());
				act.setMetaDes(this.getMetaDes().trim());
				act.setName(this.getName().trim());
				act.setStatus("1");
				act.setPath(this.getParentId() + "," + act.getArticleCategoryTid());
				act.setSort(Integer.parseInt(this.getSort().trim()));
				act.setSign(this.getSign().trim());
				act.setCreatetime(BaseTools.systemtime());
				act.setCreatorid(BaseTools.adminCreateId());
				act.setUpdatetime(BaseTools.systemtime());
				act.setVersiont(0);
				act.setParentId(this.getParentId());
				act.setParentName(this.getParentName());
				act.setPosition(this.getPosition());
				this.getArticleCategoryTService().addArticleCategoryT(act);
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
	 * 增加三级分类
	 * 
	 * @return
	 */
	@Action(value = "addArticleCategoryThree", results = { @Result(name = "json", type = "json") })
	public String addArticleCategoryThree() {
		int i = this.getArticleCategoryTService().checkArticleCategoryName(this.getName(), BaseTools.adminCreateId());
		int j = this.getArticleCategoryTService().checkArticleCategorySign(this.getSign(), BaseTools.adminCreateId());
		if (i == 0 && j == 0) {
			if (Integer.parseInt(this.getGrade()) == 2) {
				ArticleCategoryT act = new ArticleCategoryT();
				act.setArticleCategoryTid(this.getSerial().Serialid(Serial.ARTICLECATEGORY));
				act.setGrade(this.getGrade().trim());//三级
				act.setMetaKeywords(this.getMetaKeywords().trim());
				act.setMetaDes(this.getMetaDes().trim());
				act.setName(this.getName().trim());
				act.setStatus("1");
				act.setPath(this.getParentId() + "," + this.getParentId1() + "," + act.getArticleCategoryTid());
				act.setSort(Integer.parseInt(this.getSort().trim()));
				act.setSign(this.getSign().trim());
				act.setCreatetime(BaseTools.systemtime());
				act.setCreatorid(BaseTools.adminCreateId());
				act.setUpdatetime(BaseTools.systemtime());
				act.setVersiont(0);
				act.setParentId(this.getParentId1());
				act.setParentName(this.getParentName1());
				act.setPosition(this.getPosition());
				this.getArticleCategoryTService().addArticleCategoryT(act);
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
	 * 获取所有激活的文章分类
	 * 
	 * @return
	 */
	@Action(value = "findAllArticleCategoryT", results = { @Result(name = "json", type = "json") })
	public String findAllArticleCategoryT() {
		if ("sc".equals(this.getQtype())) {
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
			bean = this.getArticleCategoryTService().findArticleCategoryByarticleCategoryTid(this.getArticleCategoryTid());
			if (bean != null) {
				return "json";
			}
		}
		return "json";
	}

	public void findDefaultAllArticleCategory() {
		int currentPage = page;
		int lineSize = rp;
		this.setStatus("1");
		total = this.getArticleCategoryTService().countfindAllArticleCategoryT(this.getStatus(), BaseTools.adminCreateId());
		if (Validate.StrNotNull(sortname) && Validate.StrNotNull(sortorder)) {
			String queryString = "from ArticleCategoryT as act where act.status=:status and act.creatorid=:creatorid  order by " + sortname + " " + sortorder + "";
			List<ArticleCategoryT> list = this.getArticleCategoryTService().sortAllArticleCategoryT(currentPage, lineSize, this.getStatus(), BaseTools.adminCreateId(), queryString);
			if (!list.isEmpty()) {
				this.ProcessArticleCategoryTList(list);
			}
		}
	}

	public void ProcessArticleCategoryTList(List<ArticleCategoryT> list) {
		for (Iterator it = list.iterator(); it.hasNext();) {
			ArticleCategoryT act = (ArticleCategoryT) it.next();
			if (act.getGrade().equals("0")) {
				act.setGrade("顶级分类");
			} else if (act.getGrade().equals("1")) {
				act.setGrade("二级分类");
			} else {
				act.setGrade("三级分类");
			}
			if (act.getPosition().equals("1")) {
				act.setPosition("<span class='truestatue'><img src='../images/base_right_icon.gif'/></span>");
			} else {
				act.setPosition("<span class='falsestatue'><img src='../images/base_wrong_icon.gif'/></span>");
			}
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", act.getArticleCategoryTid());
			cellMap.put("cell", new Object[] {"<a href='addarticlecategory.jsp?session=" + this.getUsession() + "#pagecontent&articleCategoryTid=" + act.getArticleCategoryTid() + "'>" + act.getName() + "</a>", act.getParentName(), act.getGrade(), act.getSign(), act.getSort(), act.getPosition(), act.getCreatetime(), act.getCreatorid() });
			rows.add(cellMap);
		}

	}

	/**
	 * 更新文章分类
	 * 
	 * @return
	 */
	@Action(value = "updateArticleCategoryT", results = { @Result(name = "json", type = "json") })
	public String updateArticleCategoryT() {
		int i = this.getArticleCategoryTService().checkArticleCategoryNamewithoutMe(this.getArticleCategoryTid(), this.getName(), BaseTools.adminCreateId());
		int j = this.getArticleCategoryTService().checkArticleCategorySignwithoutMe(this.getArticleCategoryTid(), this.getSign(), BaseTools.adminCreateId());
		if (i == 0 && j == 0) {
			bean=this.getArticleCategoryTService().findArticleCategoryByarticleCategoryTid(this.getArticleCategoryTid());
			bean.setName(this.getName().trim());
			bean.setSign(this.getSign().trim());
			bean.setSort(Integer.parseInt(this.getSort().trim()));
			bean.setMetaKeywords(this.getMetaKeywords());
			bean.setMetaDes(this.getMetaDes());
			bean.setPosition(this.getPosition());
			//bean.setCreatetime(BaseTools.systemtime());
			bean.setUpdatetime(BaseTools.systemtime());
			bean.setCreatorid(BaseTools.adminCreateId());
			this.getArticleCategoryTService().updateArticleCategoryT(bean);
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}

	}

	/**
	 * 删除文章分类
	 * 
	 * @return
	 */
	@Action(value = "delArticleCategoryT", results = { @Result(name = "json", type = "json") })
	public String delArticleCategoryT() {
		if (Validate.StrNotNull(this.getArticleCategoryTid())) {
			String[] strs = this.getArticleCategoryTid().split(",");
			for (String s : strs) {  
				bean=this.getArticleCategoryTService().findArticleCategoryByarticleCategoryTid(s);
			    bean.setArticleCategoryTid(s);
			    bean.setStatus("0");
			    bean.setCreatorid(BaseTools.adminCreateId());
			    this.getArticleCategoryTService().delArticleCategoryT(bean);
			}  
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";

	}
}
