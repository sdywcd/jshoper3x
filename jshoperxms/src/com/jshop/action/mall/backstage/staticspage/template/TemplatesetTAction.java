package com.jshop.action.mall.backstage.staticspage.template;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jshop.action.mall.backstage.base.BaseTAction;
import com.jshop.action.mall.backstage.utils.BaseTools;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums;
import com.jshop.action.mall.backstage.utils.statickey.StaticKey;
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
	@Resource
	private TemplatesetTService templatesetTService;
	@Resource
	private TemplateTService templateTService;
	@Resource
	private GoodsCategoryTService goodsCategoryTService;
	@Resource
	private ArticleCategoryTService articleCategoryTService;
	private String tsid;
	private String templateurl;
	private String systemcontent;
	private String buildhtmlpath;
	private Date createtime;
	private String creatorid;
	private String sign;
	private TemplatesetT bean = new TemplatesetT();
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String syscontentstrs;
	private String templatestrs;
	private String templatesetstrs;
	private boolean sucflag;

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

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
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
		if (StaticKey.SC.equals(this.getQtype())) {
			this.findDefaultAllTemplateset();
		} else {
			if (StringUtils.isBlank(this.getQuery())) {
				return JSON;
			} else {
				return JSON;
			}
		}
		return JSON;
	}

	public void findDefaultAllTemplateset() {
		int currentPage = page;
		int lineSize = rp;
		Criterion criterion = Restrictions.eq("creatorid",
				BaseTools.getAdminCreateId());
		Order order = Order.desc("createtime");
		total = this.templatesetTService.count(TemplatesetT.class, criterion)
				.intValue();
		List<TemplatesetT> list = this.templatesetTService
				.findByCriteriaByPage(TemplatesetT.class, criterion, order,
						currentPage, lineSize);
		if (!list.isEmpty()) {
			this.ProcessTemplatesetTlist(list);
		}
	}

	public void ProcessTemplatesetTlist(List<TemplatesetT> list) {
		rows.clear();
		for (Iterator<TemplatesetT> it = list.iterator(); it.hasNext();) {
			TemplatesetT tst = (TemplatesetT) it.next();
			tst.setStatus(BaseEnums.DataUsingState.getName(tst.getStatus()));
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", tst.getTsid());
			cellMap.put(
					"cell",
					new Object[] {
							tst.getThemename(),
							tst.getSystemcontent(),
							tst.getSign(),
							tst.getStatus(),
							tst.getTemplateurl(),
							tst.getBuildhtmlpath(),
							BaseTools.formateDbDate(tst.getCreatetime()),
							"<a  id='edittemplateset' href='templateset.jsp?operate=edit&folder=setting&tsid="
									+ tst.getTsid()
									+ "' name='edittemplateset'>[编辑]</a>" });
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
		Criterion criterion = Restrictions.eq("creatorid",
				BaseTools.getAdminCreateId());
		List<GoodsCategoryT> gclist = this.goodsCategoryTService
				.findByCriteria(GoodsCategoryT.class, criterion);
		List<ArticleCategoryT> aclist = this.articleCategoryTService
				.findByCriteria(ArticleCategoryT.class, criterion);
		// 组织商品分类的所有信息
		this.setSyscontentstrs("");
		this.setSyscontentstrs("<option value='-1'>---请选择---</option><option value='0'>--自定义系统内容--</option><option value='1'>--以下是所创建的商品分类--</option>");
		if (!gclist.isEmpty()) {
			for (Iterator<GoodsCategoryT> it = gclist.iterator(); it.hasNext();) {
				GoodsCategoryT gct = (GoodsCategoryT) it.next();
				if (StringUtils.equals(
						BaseEnums.CategoryGrade.FIRST.getState(),
						gct.getGrade())) {
					this.syscontentstrs += "<option value='"
							+ gct.getGoodsCategoryTid() + "," + gct.getSign()
							+ "'>" + gct.getName() + "</option>";
				} else if (StringUtils.equals(
						BaseEnums.CategoryGrade.SECOND.getState(),
						gct.getGrade())) {
					this.syscontentstrs += "<option value='"
							+ gct.getGoodsCategoryTid() + "," + gct.getSign()
							+ "'>&nbsp;&nbsp;" + gct.getName() + "</option>";
				} else {
					this.syscontentstrs += "<option value='"
							+ gct.getGoodsCategoryTid() + "," + gct.getSign()
							+ "'>&nbsp;&nbsp;&nbsp;" + gct.getName()
							+ "</option>";
				}
			}
		}
		if (!aclist.isEmpty()) {
			this.syscontentstrs += "<option value='2'>--以下是所创建的文章分类--</option>";
			for (Iterator<ArticleCategoryT> it = aclist.iterator(); it
					.hasNext();) {
				ArticleCategoryT act = (ArticleCategoryT) it.next();
				if (StringUtils.equals(
						BaseEnums.CategoryGrade.FIRST.getState(),
						act.getGrade())) {
					this.syscontentstrs += "<option value='"
							+ act.getArticleCategoryTid() + "," + act.getSign()
							+ "'>" + act.getName() + "</option>";
				} else if (StringUtils.equals(
						BaseEnums.CategoryGrade.SECOND.getState(),
						act.getGrade())) {
					this.syscontentstrs += "<option value='"
							+ act.getArticleCategoryTid() + "," + act.getSign()
							+ "'>&nbsp;&nbsp;" + act.getName() + "</option>";
				} else {
					this.syscontentstrs += "<option value='"
							+ act.getArticleCategoryTid() + "," + act.getSign()
							+ "'>&nbsp;&nbsp;&nbsp;" + act.getName()
							+ "</option>";
				}
			}
		}
		this.setSucflag(true);
		return JSON;

	}

	/**
	 * 获取所有模板文件路径
	 */
	@Action(value = "getAllTemplate", results = { @Result(name = "json", type = "json") })
	public String getAllTemplate() {
		Criterion criterion = Restrictions.and(
				Restrictions.eq("creatorid", BaseTools.getAdminCreateId()))
				.add(Restrictions.eq("status",
						BaseEnums.DataUsingState.USING.getState()));
		List<TemplateT> list = this.templateTService.findByCriteria(
				TemplateT.class, criterion);
		if (list != null && list.size() > 0) {
			this.setTemplatestrs("");
			this.setTemplatestrs("<option value='-1'>---请选择---</option>");
			for (Iterator<TemplateT> it = list.iterator(); it.hasNext();) {
				TemplateT tt = (TemplateT) it.next();
				this.templatestrs += "<option value='" + tt.getUrl() + ","
						+ tt.getSign() + "'>" + tt.getUrl() + "</option>";
			}
			this.setSucflag(true);
			return JSON;
		}
		this.setSucflag(false);
		return JSON;
	}

	/**
	 * 获取模板文件和系统内容的输出路径
	 * 
	 * @return
	 */
	@Action(value = "getTemplateOutHtmlPath", results = { @Result(name = "json", type = "json") })
	public String getTemplateOutHtmlPath() {
		Criterion criterion = Restrictions.eq("creatorid",
				BaseTools.getAdminCreateId());
		List<TemplatesetT> list = this.templatesetTService.findByCriteria(
				TemplatesetT.class, criterion);
		if (list != null && list.size() > 0) {
			this.setTemplatesetstrs("<option value='-1'>---请选择---</option>");
			for (Iterator<TemplatesetT> it = list.iterator(); it.hasNext();) {
				TemplatesetT tst = (TemplatesetT) it.next();
				this.templatesetstrs += "<option value='"
						+ tst.getBuildhtmlpath() + "'>"
						+ tst.getSystemcontent() + "</option>";
			}
			this.setSucflag(true);
			return JSON;
		}
		this.setSucflag(false);
		return JSON;

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
		tst.setCreatetime(BaseTools.getSystemTime());
		tst.setCreatorid(BaseTools.getAdminCreateId());
		tst.setSign(this.getSign());
		// 获取模板主题和状态
		Criterion criterion = Restrictions.and(
				Restrictions.eq("sign", this.getSign())).add(
				Restrictions.eq("status",
						BaseEnums.DataUsingState.USING.getState()));
		TemplateT tt = this.templateTService.findOneByCriteria(TemplateT.class,
				criterion);
		if (tt != null) {
			tst.setThemeid(tt.getThemeid());
			tst.setThemename(tt.getThemename());
			tst.setStatus(tt.getStatus());
		}
		this.templatesetTService.save(tst);
		this.setSucflag(true);
		return JSON;

	}

	/**
	 * 根据tsid获取模板文件和系统内容设定值
	 * 
	 * @return
	 */
	@Action(value = "findTemplatesetTBytsid", results = { @Result(name = "json", type = "json") })
	public String findTemplatesetTBytsid() {

		if (StringUtils.isNotBlank(this.getTsid())) {
			bean = this.templatesetTService.findByPK(TemplatesetT.class,
					this.getTsid());
			if (bean != null) {
				this.setSucflag(true);
				return JSON;
			} else {
				this.setSucflag(false);
				return JSON;
			}
		} else {
			this.setSucflag(false);
			return JSON;
		}

	}

	/**
	 * 更新模板文件和系统内容设定
	 * 
	 * @return
	 */
	@Action(value = "updateTemplatesetT", results = { @Result(name = "json", type = "json") })
	public String updateTemplatesetT() {
		TemplatesetT tst = this.templatesetTService.findByPK(
				TemplatesetT.class, this.getTsid());
		if (tst != null) {
			tst.setTemplateurl(this.getTemplateurl());
			tst.setSystemcontent(this.getSystemcontent().trim());
			tst.setBuildhtmlpath(this.getBuildhtmlpath());
			tst.setCreatetime(BaseTools.getSystemTime());
			tst.setCreatorid(BaseTools.getAdminCreateId());
			tst.setSign(this.getSign());
			// 获取模板主题和状态
			Criterion criterion = Restrictions.and(
					Restrictions.eq("sign", this.getSign())).add(
					Restrictions.eq("status",
							BaseEnums.DataUsingState.USING.getState()));
			TemplateT tt = this.templateTService.findOneByCriteria(
					TemplateT.class, criterion);
			if (tt != null) {
				tst.setThemeid(tt.getThemeid());
				tst.setThemename(tt.getThemename());
				tst.setStatus(tt.getStatus());
			}
			this.templatesetTService.update(tst);
			this.setSucflag(true);
			return JSON;
		}
		this.setSucflag(false);
		return JSON;

	}

	/**
	 * 删除模板文件和系统内容设定
	 * 
	 * @return
	 */
	@Action(value = "delTemplatesetT", results = { @Result(name = "json", type = "json") })
	public String delTemplatesetT() {

		if (StringUtils.isNotBlank(this.getTsid())) {
			String[] strs = StringUtils.split(this.getTsid(), StaticKey.SPLITDOT);
			for(String s:strs){
				TemplatesetT tst=this.templatesetTService.findByPK(TemplatesetT.class, s);
				if(tst!=null){
					this.templatesetTService.delete(tst);
				}
			}
			this.setSucflag(true);
			return JSON;
		}
		this.setSucflag(false);
		return JSON;

	}
}
