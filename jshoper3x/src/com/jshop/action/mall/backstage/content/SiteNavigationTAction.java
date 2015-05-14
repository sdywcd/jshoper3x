package com.jshop.action.mall.backstage.content;

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
import org.hibernate.criterion.Order;

import com.jshop.action.mall.backstage.base.BaseTAction;
import com.jshop.action.mall.backstage.utils.BaseTools;
import com.jshop.action.mall.backstage.utils.enums.BaseEnums.SiteNavPosition;
import com.jshop.action.mall.backstage.utils.statickey.StaticKey;
import com.jshop.entity.SiteNavigationT;
import com.jshop.service.SiteNavigationTService;
import com.jshop.service.impl.Serial;

@Namespace("")
@ParentPackage("jshop")
public class SiteNavigationTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	@Resource
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
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;

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
	 * 查询所有导航
	 * 
	 * @return
	 */

	@Action(value = "findAllSiteNavigationT", results = { @Result(name = "json", type = "json") })
	public String findAllSiteNavigationT() {
		if (StringUtils.equals(StaticKey.SC, this.getQtype())) {
			this.findDefaultAllSiteNavigation();
		} else {
			if (StringUtils.isBlank(this.getQuery())) {
				return JSON;
			} else {
				return JSON;
			}
		}
		return JSON;
	}

	public void findDefaultAllSiteNavigation() {
		int currentPage = page;
		int lineSize = rp;
		total = this.siteNavigationTService.countfindAll(SiteNavigationT.class);
		if (StringUtils.isNotBlank(getSortname())
				&& StringUtils.isNotBlank(getSortorder())) {
			// String queryString =
			// "from SiteNavigationT as st where st.creatorid=:creatorid order by "
			// + getSortname() + " " + getSortorder() + "";
			Order order = null;
			if (StringUtils.equals(this.getSortorder(), StaticKey.ASC)) {
				order = Order.asc(this.getSortname());
			}
			if (StringUtils.equals(this.getSortorder(), StaticKey.DESC)) {
				order = Order.desc(this.getSortname());
			}
			List<SiteNavigationT> list = this.siteNavigationTService
					.findByCriteriaByPage(SiteNavigationT.class, order,
							currentPage, lineSize);
			this.processSiteNavigationList(list);
		}
	}

	public void processSiteNavigationList(List<SiteNavigationT> list) {
		rows.clear();
		for (Iterator<SiteNavigationT> it = list.iterator(); it.hasNext();) {
			SiteNavigationT sn = (SiteNavigationT) it.next();
			if (sn.getIsTargetBlank().equals("1")) {
				sn.setIsTargetBlank("<span class='truestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				sn.setIsTargetBlank("<span class='falsestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (sn.getIsVisible().equals(StaticKey.ONE)) {
				sn.setIsVisible("<span class='truestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				sn.setIsVisible("<span class='falsestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			sn.setPosition(SiteNavPosition.getName(sn.getPosition()));
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", sn.getSnid());
			cellMap.put(
					"cell",
					new Object[] {
							sn.getShopname(),
							sn.getName(),
							sn.getPosition(),
							sn.getSign(),
							sn.getSort(),
							sn.getIsTargetBlank(),
							sn.getIsVisible(),
							BaseTools.formateDbDate(sn.getCreatetime()),
							sn.getCreatorid(),
							"<a id='editsitenavigation' href='sitenavigation.jsp?operate=edit&folder=pagecontent&snid="
									+ sn.getSnid()
									+ "' name='editsitenavigation'>[编辑]</a>" });
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
		sn.setCreatetime(BaseTools.getSystemTime());
		sn.setCreatorid(BaseTools.getAdminCreateId());
		sn.setHtmlPath(this.getHtmlPath());
		sn.setSort(Integer.parseInt(this.getSort()));
		sn.setSign(this.getSign());
		sn.setShopid(BaseTools.getShopId());
		sn.setShopname(BaseTools.getShopName());
		this.siteNavigationTService.save(sn);
		// 这里需要对应模板生成静态页面
		this.setSucflag(true);
		return JSON;
	}

	/**
	 * 根据snid获取导航数据
	 * 
	 * @return
	 */
	@Action(value = "findSiteNavigationBysnid", results = { @Result(name = "json", type = "json") })
	public String findSiteNavigationBysnid() {
		bean = this.siteNavigationTService.findByPK(SiteNavigationT.class,
				this.getSnid());
		if (bean != null) {
			this.setSucflag(true);
		}
		return JSON;

	}

	/**
	 * 更新导航
	 * 
	 * @return
	 */
	@Action(value = "updateSiteNavigationT", results = { @Result(name = "json", type = "json") })
	public String updateSiteNavigationT() {
		SiteNavigationT sn = this.siteNavigationTService.findByPK(
				SiteNavigationT.class, this.getSnid());
		if (sn != null) {
			sn.setIsTargetBlank(this.getIsTargetBlank());
			sn.setIsVisible(this.getIsVisible());
			sn.setName(this.getName());
			sn.setPosition(this.getPosition());
			sn.setCreatetime(BaseTools.getSystemTime());
			sn.setCreatorid(BaseTools.getAdminCreateId());
			sn.setHtmlPath(this.getHtmlPath());
			sn.setSort(Integer.parseInt(this.getSort()));
			sn.setSign(this.getSign());
			sn.setShopid(BaseTools.getShopId());
			sn.setShopname(BaseTools.getShopName());
			this.siteNavigationTService.update(sn);
			// 更新模板页面数据
			this.setSucflag(true);
		}
		return JSON;

	}

	/**
	 * 删除导航
	 * 
	 * @return
	 */
	@Action(value = "delSiteNavigationT", results = { @Result(name = "json", type = "json") })
	public String delSiteNavigationT() {
		if (StringUtils.isNotBlank(this.getSnid())) {
			String[] strs = StringUtils.split(this.getSnid(),
					StaticKey.SPLITDOT);
			for (String s : strs) {
				SiteNavigationT sn = this.siteNavigationTService.findByPK(
						SiteNavigationT.class, s);
				if (sn != null) {
					this.siteNavigationTService.delete(sn);
				}
			}
			this.setSucflag(true);
		}
		return JSON;

	}
}
