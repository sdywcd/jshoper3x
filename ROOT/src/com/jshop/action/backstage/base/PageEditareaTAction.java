package com.jshop.action.backstage.base;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.GoodsCategoryT;
import com.jshop.entity.PageEditareaT;
import com.jshop.entity.SiteNavigationT;
import com.jshop.service.GoodsCategoryTService;
import com.jshop.service.PageEditareaTService;
import com.jshop.service.SiteNavigationTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class PageEditareaTAction extends ActionSupport {
	private PageEditareaTService pageEditareaTService;
	private Serial serial;
	private SiteNavigationTService siteNavigationTService;
	private GoodsCategoryTService goodsCategoryTService;

	private String pageeditareaid;
	private String goodscategoryid;
	private String name;
	private String sign;
	private String htmlpath;
	private String editareatitle;
	private String editareavalue;
	private Integer editflag;
	private String state;
	private String snid;
	private String creatorid;
	private Date createtime;
	private String sitenavigationstr = null;
	private String goodscategorystr = null;
	private PageEditareaT bean = new PageEditareaT();
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String query;
	private String qtype;
	private boolean slogin;
	private boolean sucflag;

	@JSON(serialize = false)
	public PageEditareaTService getPageEditareaTService() {
		return pageEditareaTService;
	}

	public void setPageEditareaTService(PageEditareaTService pageEditareaTService) {
		this.pageEditareaTService = pageEditareaTService;
	}
	@JSON(serialize = false)
	public SiteNavigationTService getSiteNavigationTService() {
		return siteNavigationTService;
	}

	public void setSiteNavigationTService(SiteNavigationTService siteNavigationTService) {
		this.siteNavigationTService = siteNavigationTService;
	}
	@JSON(serialize = false)
	public GoodsCategoryTService getGoodsCategoryTService() {
		return goodsCategoryTService;
	}

	public void setGoodsCategoryTService(GoodsCategoryTService goodsCategoryTService) {
		this.goodsCategoryTService = goodsCategoryTService;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getPageeditareaid() {
		return pageeditareaid;
	}

	public void setPageeditareaid(String pageeditareaid) {
		this.pageeditareaid = pageeditareaid;
	}

	public String getEditareatitle() {
		return editareatitle;
	}

	public void setEditareatitle(String editareatitle) {
		this.editareatitle = editareatitle;
	}

	public String getEditareavalue() {
		return editareavalue;
	}

	public void setEditareavalue(String editareavalue) {
		this.editareavalue = editareavalue;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGoodscategoryid() {
		return goodscategoryid;
	}

	public void setGoodscategoryid(String goodscategoryid) {
		this.goodscategoryid = goodscategoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getHtmlpath() {
		return htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}

	public Integer getEditflag() {
		return editflag;
	}

	public void setEditflag(Integer editflag) {
		this.editflag = editflag;
	}

	public String getSnid() {
		return snid;
	}

	public void setSnid(String snid) {
		this.snid = snid;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public PageEditareaT getBean() {
		return bean;
	}

	public void setBean(PageEditareaT bean) {
		this.bean = bean;
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

	public String getSitenavigationstr() {
		return sitenavigationstr;
	}

	public void setSitenavigationstr(String sitenavigationstr) {
		this.sitenavigationstr = sitenavigationstr;
	}

	public String getGoodscategorystr() {
		return goodscategorystr;
	}

	public void setGoodscategorystr(String goodscategorystr) {
		this.goodscategorystr = goodscategorystr;
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

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加页面自定义编辑数据
	 * 
	 * @return
	 */
	@Action(value = "addPageEditareaT", results = { @Result(name = "json", type = "json") })
	public String addPageEditareaT() {

		PageEditareaT pea = new PageEditareaT();
		pea.setPageeditareaid(this.getSerial().Serialid(Serial.PAGEEDITAREA));
		pea.setGoodscategoryid(this.getGoodscategoryid());
		pea.setName(this.getName());
		pea.setSign(this.getSign());
		pea.setHtmlpath(this.getHtmlpath());
		pea.setEditareatitle(this.getEditareatitle());
		pea.setEditareavalue(this.getEditareavalue());
		pea.setEditflag(this.getEditflag());
		pea.setState(this.getState());
		pea.setSnid(this.getSnid());
		pea.setCreatorid(BaseTools.adminCreateId());
		pea.setCreatetime(BaseTools.systemtime());
		if (this.getPageEditareaTService().addPageEditareaT(pea) > 0) {
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}

	}

	/**
	 * 获取导航下拉数据给自定义编辑页面
	 * 
	 * @return
	 */
	@Action(value = "findSiteNavigationList", results = { @Result(name = "json", type = "json") })
	public String findSiteNavigationList() {

		this.setSitenavigationstr("");
		String isVisible = "1";
		List<SiteNavigationT> list = this.getSiteNavigationTService().findSiteNavigationByisVisible(isVisible, BaseTools.adminCreateId());
		if (list != null) {
			this.setSitenavigationstr("<option value='-1'>---请选择---</option>");
			for (Iterator it = list.iterator(); it.hasNext();) {
				SiteNavigationT sn = (SiteNavigationT) it.next();
				this.sitenavigationstr += "<option value='" + sn.getSnid() + "," + sn.getHtmlPath() + "," + sn.getSign() + "'>" + sn.getName() + "</option>";
			}
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(true);
		return "json";

	}

	/**
	 * 获取商品分类下拉数据
	 * 
	 * @return
	 */
	@Action(value = "findGoodsCategoryList", results = { @Result(name = "json", type = "json") })
	public String findGoodsCategoryList() {

		this.setGoodscategorystr("");
		List<GoodsCategoryT> list = this.getGoodsCategoryTService().findAllGoodsCategoryBycreatorid(BaseTools.adminCreateId());
		if (list != null) {
			this.setGoodscategorystr("<option value='-1'>---请选择---</option>");
			for (Iterator it = list.iterator(); it.hasNext();) {
				GoodsCategoryT gct = (GoodsCategoryT) it.next();
				this.goodscategorystr += "<option value='" + gct.getGoodsCategoryTid() + "," + gct.getSign() + "'>" + gct.getName() + "</option>";
			}
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(true);
		return "json";

	}

	/**
	 *查询所有页面编辑
	 * 
	 * @return
	 */
	@Action(value = "findAllPageareaT", results = { @Result(name = "json", type = "json") })
	public String findAllPageareaT() {

		if ("sc".equals(this.getQtype())) {
			this.setTotal(0);
			rows.clear();
			this.findDefaultAllPageareaT();
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {
				return "json";
			}
		}
		return "json";
	}

	public void findDefaultAllPageareaT() {
		int currentPage = page;
		int lineSize = rp;
		total = this.getPageEditareaTService().countfindAllPageEditareaT(BaseTools.adminCreateId());
		List<PageEditareaT> list = this.getPageEditareaTService().findAllPageEditareaT(currentPage, lineSize, BaseTools.adminCreateId());
		if (list != null) {
			this.ProcessPageEditareaTList(list);
		}
	}

	public void ProcessPageEditareaTList(List<PageEditareaT> list) {
		rows.clear();
		for (Iterator it = list.iterator(); it.hasNext();) {
			PageEditareaT pea = (PageEditareaT) it.next();
			if (pea.getState().equals("1")) {
				pea.setState("<span class='truestatue'><img src='../images/base_right_icon.gif'/></span>");
			} else {
				pea.setState("<span class='falsestatue'><img src='../images/base_wrong_icon.gif'/></span>");
			}
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", pea.getPageeditareaid());
			cellMap.put("cell", new Object[] { pea.getName(), pea.getEditareatitle(), pea.getEditflag(), pea.getCreatorid(), pea.getState(), "<a target='_blank' id='editpea' href='jshop/admin/pageedit/addpageeditareamanagement.jsp?pageeditareaid=" + pea.getPageeditareaid() + "' name='editpea'>[编辑]</a>" + "<a target='_blank' id='browerpea' href='" + this.getHtmlpath() + "' name='browerpea'>[预览]</a>" });
			rows.add(cellMap);
		}
	}

	/**
	 * 显示和隐藏编辑区域
	 * 
	 * @param list
	 * @param state
	 * @return
	 */
	@Action(value = "UpdatePageEditareaTBystate", results = { @Result(name = "json", type = "json") })
	public String UpdatePageEditareaTBystate() {

		if (Validate.StrNotNull(this.getPageeditareaid())) {
			String[] array = this.getPageeditareaid().trim().split(",");
			int i = this.getPageEditareaTService().updatePageEditareaTBystate(array, this.getState(), BaseTools.adminCreateId());
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";

	}

	/**
	 * 更新页面编辑区域
	 * 
	 * @param pea
	 * @return
	 */
	@Action(value = "UpdatePageEditareaT", results = { @Result(name = "json", type = "json") })
	public String UpdatePageEditareaT() {

		PageEditareaT pea = new PageEditareaT();
		pea.setPageeditareaid(this.getPageeditareaid());
		pea.setGoodscategoryid(this.getGoodscategoryid());
		pea.setName(this.getName());
		pea.setSign(this.getSign());
		pea.setHtmlpath(this.getHtmlpath());
		pea.setEditareatitle(this.getEditareatitle());
		pea.setEditareavalue(this.getEditareavalue());
		pea.setEditflag(this.getEditflag());
		pea.setState(this.getState());
		pea.setSnid(this.getSnid());
		pea.setCreatorid(BaseTools.adminCreateId());
		pea.setCreatetime(BaseTools.systemtime());
		if (this.getPageEditareaTService().updatePageEditareaT(pea) > 0) {
			;
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}

	}

	/**
	 *查询指定的编辑区域
	 * 
	 * @param pageeditareaid
	 * @return
	 */
	@Action(value = "findPageEditareaById", results = { @Result(name = "json", type = "json") })
	public String findPageEditareaById() {

		if (Validate.StrNotNull(this.getPageeditareaid())) {
			bean = this.getPageEditareaTService().findPageEditareaById(this.getPageeditareaid());
			if (bean != null) {
				this.setSucflag(true);
				return "json";
			}
			this.setSucflag(false);
			return "json";
		}
		this.setSucflag(false);
		return "json";

	}

	/**
	 * 根据自定义编号删除内容 state=2标示禁用可删除
	 * 
	 * @return
	 */
	@Action(value = "delPageEditareaTBypageeditareaid", results = { @Result(name = "json", type = "json") })
	public String delPageEditareaTBypageeditareaid() {
		if (Validate.StrNotNull(this.getPageeditareaid())) {
			String[] strs = this.getPageeditareaid().split(",");
			if (this.getPageEditareaTService().delPageEditareaTBypageeditareaid(strs, "2") > 0) {
				this.setSucflag(true);
				return "json";
			}
			this.setSucflag(false);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
}
