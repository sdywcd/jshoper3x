package com.jshop.action.backstage.content;

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
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.StaticString;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.SiteNavigationT;
import com.jshop.service.SiteNavigationTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class SiteNavigationTAction extends ActionSupport {
	private Serial serial;
	private SiteNavigationTService siteNavigationTService;

	private String snid;
	private String isTargetBlank;
	private String isVisible;
	private String name;
	private String position;
	private String createtime;
	private String creatorid;
	private String htmlPath;
	private String sort;
	private String sign;
	private SiteNavigationT bean = new SiteNavigationT();
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String query;
	private String qtype;
	private boolean slogin;
	private boolean sucflag;
	private String sortname;
	private String sortorder;

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	@JSON(serialize = false)
	public SiteNavigationTService getSiteNavigationTService() {
		return siteNavigationTService;
	}

	public void setSiteNavigationTService(SiteNavigationTService siteNavigationTService) {
		this.siteNavigationTService = siteNavigationTService;
	}

	public String getSnid() {
		return snid;
	}

	public void setSnid(String snid) {
		this.snid = snid;
	}

	public String getIsTargetBlank() {
		return isTargetBlank;
	}

	public void setIsTargetBlank(String isTargetBlank) {
		this.isTargetBlank = isTargetBlank;
	}

	public String getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public String getHtmlPath() {
		return htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public SiteNavigationT getBean() {
		return bean;
	}

	public void setBean(SiteNavigationT bean) {
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

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
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

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 查询所有导航
	 * 
	 * @return
	 */

	@Action(value = "findAllSiteNavigationT", results = { @Result(name = "json", type = "json") })
	public String findAllSiteNavigationT() {
		if (StaticString.SC.equals(this.getQtype())) {
			this.findDefaultAllSiteNavigation();
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {
				return "json";
			}
		}
		return "json";
	}

	public void findDefaultAllSiteNavigation() {
		int currentPage = page;
		int lineSize = rp;
		total = this.getSiteNavigationTService().countfindAllSiteNavigationT(BaseTools.adminCreateId());
		if (Validate.StrNotNull(sortname) && Validate.StrNotNull(sortorder)) {
			String queryString = "from SiteNavigationT as st where st.creatorid=:creatorid order by " + sortname + " " + sortorder + "";
			List<SiteNavigationT> list = this.getSiteNavigationTService().sortAllSiteNavigationT(currentPage, lineSize, BaseTools.adminCreateId(), queryString);
			if (list != null) {
				this.ProcessSiteNavigationList(list);
			}
		}
	}

	public void ProcessSiteNavigationList(List<SiteNavigationT> list) {
		rows.clear();
		for (Iterator it = list.iterator(); it.hasNext();) {
			SiteNavigationT sn = (SiteNavigationT) it.next();
			if (sn.getIsTargetBlank().equals("1")) {
				sn.setIsTargetBlank("<span class='truestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				sn.setIsTargetBlank("<span class='falsestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (sn.getIsVisible().equals(StaticString.ONE)) {
				sn.setIsVisible("<span class='truestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				sn.setIsVisible("<span class='falsestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (sn.getPosition().equals(StaticString.ONE)) {
				sn.setPosition("页面上部");
			} else if (sn.getPosition().equals(StaticString.TWO)) {
				sn.setPosition("页面中部");
			} else {
				sn.setPosition("页面下部");
			}
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", sn.getSnid());
			cellMap.put("cell", new Object[] { sn.getName(), sn.getPosition(), sn.getSign(), sn.getSort(), sn.getIsTargetBlank(), sn.getIsVisible(), BaseTools.formateDbDate(sn.getCreatetime()), sn.getCreatorid(), "<a id='editsitenavigation' href='sitenavigation.jsp?operate=edit&folder=pagecontent&snid=" + sn.getSnid() + "' name='editsitenavigation'>[编辑]</a>" });
			rows.add(cellMap);
		}
	}

	/**
	 * 增加导航
	 * 
	 * @return
	 */
	@Action(value = "addSiteNavigationT", results = { @Result(name = "json", type = "json") })
	public String addSiteNavigationT() {

		SiteNavigationT sn = new SiteNavigationT();
		sn.setSnid(this.getSerial().Serialid(Serial.SITENAVIGATION));
		sn.setIsTargetBlank(this.getIsTargetBlank());
		sn.setIsVisible(this.getIsVisible());
		sn.setName(this.getName());
		sn.setPosition(this.getPosition());
		sn.setCreatetime(BaseTools.systemtime());
		sn.setCreatorid(BaseTools.adminCreateId());
		sn.setHtmlPath(this.getHtmlPath());
		sn.setSort(Integer.parseInt(this.getSort()));
		sn.setSign(this.getSign());
		if (this.getSiteNavigationTService().addSiteNavigationT(sn) > 0) {
			//这里需要对应模板生成静态页面
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}

	}

	/**
	 * 根据snid获取导航数据
	 * 
	 * @return
	 */
	@Action(value = "findSiteNavigationBysnid", results = { @Result(name = "json", type = "json") })
	public String findSiteNavigationBysnid() {

		bean = this.getSiteNavigationTService().findSiteNavigationBysnid(this.getSnid());
		if (bean != null) {
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";

	}

	/**
	 * 更新导航
	 * 
	 * @return
	 */
	@Action(value = "updateSiteNavigationT", results = { @Result(name = "json", type = "json") })
	public String updateSiteNavigationT() {
		SiteNavigationT sn = new SiteNavigationT();
		sn.setSnid(this.getSnid());
		sn.setIsTargetBlank(this.getIsTargetBlank());
		sn.setIsVisible(this.getIsVisible());
		sn.setName(this.getName());
		sn.setPosition(this.getPosition());
		sn.setCreatetime(BaseTools.systemtime());
		sn.setCreatorid(BaseTools.adminCreateId());
		sn.setHtmlPath(this.getHtmlPath());
		sn.setSort(Integer.parseInt(this.getSort()));
		sn.setSign(this.getSign());
		if (this.getSiteNavigationTService().updateSiteNavigationT(sn) > 0) {
			//更新模板页面数据
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";

	}

	/**
	 * 删除导航
	 * 
	 * @return
	 */
	@Action(value = "delSiteNavigationT", results = { @Result(name = "json", type = "json") })
	public String delSiteNavigationT() {
		if(StringUtils.isNotBlank(this.getSnid())){
			String[] strs = StringUtils.split(this.getSnid(), ",");
			this.getSiteNavigationTService().delSiteNavigationT(strs);
			this.setSucflag(true);
			return "json";
		}
		return "json";

	}
}
