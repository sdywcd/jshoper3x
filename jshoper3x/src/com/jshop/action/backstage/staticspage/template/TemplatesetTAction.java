package com.jshop.action.backstage.staticspage.template;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.jshop.entity.GoodsCategoryT;
import com.jshop.entity.TemplateT;
import com.jshop.entity.TemplatesetT;
import com.jshop.service.ArticleCategoryTService;
import com.jshop.service.GoodsCategoryTService;
import com.jshop.service.TemplateTService;
import com.jshop.service.TemplatesetTService;
import com.jshop.service.impl.Serial;
@Namespace("")
@ParentPackage("jshop")
public class TemplatesetTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private TemplatesetTService templatesetTService;
	private TemplateTService templateTService;
	private GoodsCategoryTService goodsCategoryTService;
	private ArticleCategoryTService articleCategoryTService;
	private String tsid;
	private String templateurl;
	private String systemcontent;
	private String buildhtmlpath;
	private Date createtime;
	private String creatorid;
	private String sign;
	private TemplatesetT bean = new TemplatesetT();
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String syscontentstrs;
	private String templatestrs;
	private String templatesetstrs;
	private boolean sucflag;
	
	@JSON(serialize = false)
	public TemplatesetTService getTemplatesetTService() {
		return templatesetTService;
	}

	public void setTemplatesetTService(TemplatesetTService templatesetTService) {
		this.templatesetTService = templatesetTService;
	}
	@JSON(serialize = false)
	public TemplateTService getTemplateTService() {
		return templateTService;
	}

	public void setTemplateTService(TemplateTService templateTService) {
		this.templateTService = templateTService;
	}
	@JSON(serialize = false)
	public GoodsCategoryTService getGoodsCategoryTService() {
		return goodsCategoryTService;
	}

	public void setGoodsCategoryTService(GoodsCategoryTService goodsCategoryTService) {
		this.goodsCategoryTService = goodsCategoryTService;
	}
	
	@JSON(serialize = false)
	public ArticleCategoryTService getArticleCategoryTService() {
		return articleCategoryTService;
	}

	public void setArticleCategoryTService(ArticleCategoryTService articleCategoryTService) {
		this.articleCategoryTService = articleCategoryTService;
	}


	public String getTsid() {
		return tsid;
	}

	public void setTsid(String tsid) {
		this.tsid = tsid;
	}

	public String getSystemcontent() {
		return systemcontent;
	}

	public String getTemplateurl() {
		return templateurl;
	}

	public void setTemplateurl(String templateurl) {
		this.templateurl = templateurl;
	}

	public String getBuildhtmlpath() {
		return buildhtmlpath;
	}

	public void setBuildhtmlpath(String buildhtmlpath) {
		this.buildhtmlpath = buildhtmlpath;
	}

	public void setSystemcontent(String systemcontent) {
		this.systemcontent = systemcontent;
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

	public TemplatesetT getBean() {
		return bean;
	}

	public void setBean(TemplatesetT bean) {
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

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getSyscontentstrs() {
		return syscontentstrs;
	}

	public void setSyscontentstrs(String syscontentstrs) {
		this.syscontentstrs = syscontentstrs;
	}

	public String getTemplatestrs() {
		return templatestrs;
	}

	public void setTemplatestrs(String templatestrs) {
		this.templatestrs = templatestrs;
	}

	public String getTemplatesetstrs() {
		return templatesetstrs;
	}

	public void setTemplatesetstrs(String templatesetstrs) {
		this.templatesetstrs = templatesetstrs;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 查询所有模板文件和系统内容设定
	 * 
	 * @return
	 */
	@Action(value = "findAllTemplatesetT", results = { @Result(name = "json", type = "json") })
	public String findAllTemplatesetT() {
		if ("sc".equals(this.getQtype())) {
			this.findDefaultAllTemplateset();
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {
				return "json";
			}
		}
		return "json";
	}

	public void findDefaultAllTemplateset() {
		int currentPage = page;
		int lineSize = rp;
		total = this.getTemplatesetTService().countfindAllTemplatesetT(BaseTools.getAdminCreateId());
		List<TemplatesetT> list = this.getTemplatesetTService().findAllTemplatesetT(currentPage, lineSize, BaseTools.getAdminCreateId());
		if (!list.isEmpty()) {
			this.ProcessTemplatesetTlist(list);
		}
	}

	public void ProcessTemplatesetTlist(List<TemplatesetT> list) {
		rows.clear();
		for (Iterator<TemplatesetT> it = list.iterator(); it.hasNext();) {
			TemplatesetT tst = (TemplatesetT) it.next();
			tst.setStatus(StaticKey.DataUsingState.getName(tst.getStatus()));
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", tst.getTsid());
			cellMap.put("cell", new Object[] { tst.getThemename(), tst.getSystemcontent(), tst.getSign(), tst.getStatus(), tst.getTemplateurl(), tst.getBuildhtmlpath(), BaseTools.formateDbDate(tst.getCreatetime()), "<a  id='edittemplateset' href='templateset.jsp?operate=edit&folder=setting&tsid=" + tst.getTsid() + "' name='edittemplateset'>[编辑]</a>" });
			rows.add(cellMap);
		}
	}

	/**
	 * 获取系统内容，包含文章分类，和商品分类的预先读取,可能还有更多的内容，或许会做一个更加多选的页面来描述系统内容，让后绑定模板
	 * 
	 * @return
	 */
	@Action(value = "findSystemcontent", results = { @Result(name = "json", type = "json") })
	public String findSystemcontent() {
		List<GoodsCategoryT> gclist = this.getGoodsCategoryTService().findAllGoodsCategoryBycreatorid(BaseTools.getAdminCreateId());
		List<ArticleCategoryT> aclist = this.getArticleCategoryTService().findAllArticleCategoryBycreatorid(BaseTools.getAdminCreateId());
		//组织商品分类的所有信息
		this.setSyscontentstrs("");
		this.setSyscontentstrs("<option value='-1'>---请选择---</option><option value='0'>--自定义系统内容--</option><option value='1'>--以下是所创建的商品分类--</option>");
		if(!gclist.isEmpty()){
			for (Iterator<GoodsCategoryT> it = gclist.iterator(); it.hasNext();) {
				GoodsCategoryT gct = (GoodsCategoryT) it.next();
				if (gct.getGrade().equals("0")) {
					this.syscontentstrs += "<option value='" + gct.getGoodsCategoryTid() + "," + gct.getSign() + "'>" + gct.getName() + "</option>";
				} else if (gct.getGrade().equals("1")) {
					this.syscontentstrs += "<option value='" + gct.getGoodsCategoryTid() + "," + gct.getSign() + "'>&nbsp;&nbsp;" + gct.getName() + "</option>";
				} else {
					this.syscontentstrs += "<option value='" + gct.getGoodsCategoryTid() + "," + gct.getSign() + "'>&nbsp;&nbsp;&nbsp;" + gct.getName() + "</option>";
				}
			}
		}
		if (!aclist.isEmpty()) {
			this.syscontentstrs += "<option value='2'>--以下是所创建的文章分类--</option>";
			for (Iterator<ArticleCategoryT> it = aclist.iterator(); it.hasNext();) {
				ArticleCategoryT act = (ArticleCategoryT) it.next();
				if (act.getGrade().equals("0")) {
					this.syscontentstrs += "<option value='" + act.getArticleCategoryTid() + "," + act.getSign() + "'>" + act.getName() + "</option>";
				} else if (act.getGrade().equals("1")) {
					this.syscontentstrs += "<option value='" + act.getArticleCategoryTid() + "," + act.getSign() + "'>&nbsp;&nbsp;" + act.getName() + "</option>";
				} else {
					this.syscontentstrs += "<option value='" + act.getArticleCategoryTid() + "," + act.getSign() + "'>&nbsp;&nbsp;&nbsp;" + act.getName() + "</option>";
				}
			}
		}
		this.setSucflag(true);
		return "json";

	}

	/**
	 * 获取所有模板文件路径
	 */
	@Action(value = "getAllTemplate", results = { @Result(name = "json", type = "json") })
	public String getAllTemplate() {
		List<TemplateT> list = this.getTemplateTService().findAllTemplateWithNoParam(BaseTools.getAdminCreateId(), "1");
		if (list != null) {
			this.setTemplatestrs("");
			this.setTemplatestrs("<option value='-1'>---请选择---</option>");
			for (Iterator<TemplateT> it = list.iterator(); it.hasNext();) {
				TemplateT tt = (TemplateT) it.next();
				this.templatestrs += "<option value='" + tt.getUrl() + "," + tt.getSign() + "'>" + tt.getUrl() + "</option>";
			}
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 获取模板文件和系统内容的输出路径
	 * 
	 * @return
	 */
	@Action(value = "getTemplateOutHtmlPath", results = { @Result(name = "json", type = "json") })
	public String getTemplateOutHtmlPath() {

		List<TemplatesetT> list = this.getTemplatesetTService().findAllTemplatesetWithNoParam(BaseTools.getAdminCreateId());
		if (list != null) {
			this.setTemplatesetstrs("<option value='-1'>---请选择---</option>");
			for (Iterator<TemplatesetT> it = list.iterator(); it.hasNext();) {
				TemplatesetT tst = (TemplatesetT) it.next();
				this.templatesetstrs += "<option value='" + tst.getBuildhtmlpath() + "'>" + tst.getSystemcontent() + "</option>";
			}
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";

	}

	/**
	 * 增加模板文件和系统内容设定
	 * 
	 * @return
	 */
	@Action(value = "addTemplatesetT", results = { @Result(name = "json", type = "json") })
	public String addTemplatesetT() {

		TemplatesetT tst = new TemplatesetT();
		tst.setTsid(this.getSerial().Serialid(Serial.TEMPLATESET));
		tst.setSystemcontent(this.getSystemcontent().trim());
		tst.setTemplateurl(this.getTemplateurl());
		tst.setBuildhtmlpath(this.getBuildhtmlpath());
		tst.setCreatetime(BaseTools.systemtime());
		tst.setCreatorid(BaseTools.getAdminCreateId());
		tst.setSign(this.getSign());
		//获取模板主题和状态
		TemplateT tt = new TemplateT();
		tt = this.getTemplateTService().findTemplateBysign(this.getSign(), "1");
		if (tt != null) {
			tst.setThemeid(tt.getThemeid());
			tst.setThemename(tt.getThemename());
			tst.setStatus(tt.getStatus());
		}
		this.getTemplatesetTService().save(tst);
		this.setSucflag(true);
		return "json";
		

	}

	/**
	 * 根据tsid获取模板文件和系统内容设定值
	 * 
	 * @return
	 */
	@Action(value = "findTemplatesetTBytsid", results = { @Result(name = "json", type = "json") })
	public String findTemplatesetTBytsid() {

		if (Validate.StrNotNull(this.getTsid())) {
			bean = this.getTemplatesetTService().findTemplatesetTBytsid(this.getTsid());
			if (bean != null) {
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
	 * 更新模板文件和系统内容设定
	 * 
	 * @return
	 */
	@Action(value = "updateTemplatesetT", results = { @Result(name = "json", type = "json") })
	public String updateTemplatesetT() {

		TemplatesetT tst = new TemplatesetT();
		tst.setTsid(this.getTsid());
		tst.setTemplateurl(this.getTemplateurl());
		tst.setSystemcontent(this.getSystemcontent().trim());
		tst.setBuildhtmlpath(this.getBuildhtmlpath());
		tst.setCreatetime(BaseTools.systemtime());
		tst.setCreatorid(BaseTools.getAdminCreateId());
		tst.setSign(this.getSign());
		//获取模板主题和状态
		TemplateT tt = new TemplateT();
		tt = this.getTemplateTService().findTemplateBysign(this.getSign(), "1");
		if (tt != null) {
			tst.setThemeid(tt.getThemeid());
			tst.setThemename(tt.getThemename());
			tst.setStatus(tt.getStatus());
		}
		if (this.getTemplatesetTService().updateTemplatesetT(tst) > 0) {
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";

	}

	/**
	 * 删除模板文件和系统内容设定
	 * 
	 * @return
	 */
	@Action(value = "delTemplatesetT", results = { @Result(name = "json", type = "json") })
	public String delTemplatesetT() {

		if (Validate.StrNotNull(this.getTsid())) {
			String[] strs = this.getTsid().split(",");
			this.getTemplatesetTService().delTemplatesetT(strs);
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";

	}
}
