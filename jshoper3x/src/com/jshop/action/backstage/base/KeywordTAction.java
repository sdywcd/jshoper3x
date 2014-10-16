package com.jshop.action.backstage.base;

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

import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.entity.KeywordT;
import com.jshop.service.KeywordTService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;
@Namespace("")
@ParentPackage("jshop")
public class KeywordTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private KeywordTService keywordTService;
	private String creatorid;
	private String keywordid;
	private String keywordname;
	private String sort;
	private String state;
	private String type;
	private KeywordT beanlist = new KeywordT();
	private String keywordjson = null;
	private List<KeywordT> keyword = new ArrayList<KeywordT>();
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String usession;
	private boolean slogin;

	
	@JSON(serialize = false)
	public KeywordTService getKeywordTService() {
		return keywordTService;
	}

	public void setKeywordTService(KeywordTService keywordTService) {
		this.keywordTService = keywordTService;
	}
	public String getKeywordid() {
		return keywordid;
	}

	public void setKeywordid(String keywordid) {
		this.keywordid = keywordid;
	}

	public String getKeywordname() {
		return keywordname;
	}

	public void setKeywordname(String keywordname) {
		this.keywordname = keywordname;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public KeywordT getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(KeywordT beanlist) {
		this.beanlist = beanlist;
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

	public String getKeywordjson() {
		return keywordjson;
	}

	public void setKeywordjson(String keywordjson) {
		this.keywordjson = keywordjson;
	}

	public List<KeywordT> getKeyword() {
		return keyword;
	}

	public void setKeyword(List<KeywordT> keyword) {
		this.keyword = keyword;
	}

	public String getUsession() {
		return usession;
	}

	public void setUsession(String usession) {
		this.usession = usession;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加关键字
	 * 
	 * @return
	 */
	@Action(value = "addKeywordT", results = { @Result(name = "json", type = "json") })
	public String addKeywordT() {
		if (Validate.StrisNull(this.getKeywordname())) {
			ActionContext.getContext().put("errormsg", "关键字名称必须填写");
			return "json";
		}
		if (Validate.StrisNull(this.getState())) {
			ActionContext.getContext().put("errormsg", "关键字显示状态必须选择");
			return "json";
		}
		if (Validate.StrNotNull(this.getSort())) {
			if (!Validate.isINTEGER_NEGATIVE(this.getSort())) {
				ActionContext.getContext().put("errormsg", "排序编号必须是正整数");
				return "json";
			}
		}
		if (Validate.StrisNull(this.getType())) {
			if (this.getType().equals("0")) {
				ActionContext.getContext().put("errormsg", "关键字类型必须选择");
				return "json";
			}
		}
		KeywordT kt = new KeywordT();
		kt.setKeywordid(this.getSerial().Serialid(Serial.KEYWORD));
		kt.setKeywordname(this.getKeywordname().trim());
		kt.setSearchCount(0);
		kt.setSort(Integer.parseInt(this.getSort().trim()));
		kt.setState(this.getState());
		kt.setType(this.getType());
		kt.setCreatetime(BaseTools.systemtime());
		kt.setCreatorid(BaseTools.getAdminCreateId());
		this.getKeywordTService().save(kt);
		this.setSlogin(true);
			
		return "json";
	}

	/**
	 * 删除关键字
	 * 
	 * @return
	 */
	@Action(value = "DelKeywordT", results = { @Result(name = "json", type = "json") })
	public String DelKeywordT() {
		if (Validate.StrNotNull(this.getKeywordid())) {
			String[] array = this.getKeywordid().trim().split(",");
			if (this.getKeywordTService().delKeywordT(array) > 0) {
				return "json";
			}
			return "json";
		}
		return "json";
	}

	/**
	 * 更新关键字（排序和前台显示有关系数字越大越靠前）
	 * 
	 * @return
	 */
	@Action(value = "UpdateKeywordT", results = { @Result(name = "json", type = "json") })
	public String UpdateKeywordT() {

		if (Validate.StrNotNull(this.getSort())) {
			if (!Validate.isINTEGER_NEGATIVE(this.getSort())) {
				ActionContext.getContext().put("errormsg", "排序编号必须是正整数");
				return "json";
			}
			if (Validate.StrNotNull(this.getKeywordname())) {
				KeywordT kt = new KeywordT();
				kt.setKeywordid(this.getKeywordid().trim());
				kt.setKeywordname(this.getKeywordname().trim());
				kt.setSort(Integer.parseInt(this.getSort().trim()));
				kt.setState(this.getState().trim());
				kt.setType(this.getType().trim());
				kt.setCreatetime(BaseTools.systemtime());
				kt.setCreatorid(BaseTools.getAdminCreateId());
				if (this.getKeywordTService().updateKeywordT(kt) > 0) {
					return "json";
				}
				return "json";
			} else {
				ActionContext.getContext().put("errormsg", "关键字名称必须填写");
				return "json";
			}
		}
		return "json";
	}

	/**
	 * 查询所有关键字
	 * 
	 * @return
	 */
	@Action(value = "findAllKeywordT", results = { @Result(name = "json", type = "json") })
	public String findAllKeywordT() {
		int currentPage = page;
		int lineSize = rp;
		List<KeywordT> kt = this.getKeywordTService().findAllKeywordT(currentPage, lineSize);
		if (kt != null) {
			total = this.getKeywordTService().countAllKeywordT();
			rows.clear();
			for (Iterator<KeywordT> it = kt.iterator(); it.hasNext();) {
				KeywordT k = (KeywordT) it.next();
				if (k.getType().equals("1")) {
					k.setType("商品类型");
				}
				if (k.getType().equals("2")) {
					k.setType("文章类型");
				}
				if (k.getState().equals("1")) {
					k.setState("显示");
				}
				if (k.getState().equals("2")) {
					k.setState("隐藏");
				}
				Map<String, Object> cellMap = new HashMap<String, Object>();
				cellMap.put("id", k.getKeywordid());
				cellMap.put("cell", new Object[] {k.getKeywordname(), k.getType(), k.getState(), k.getSort(), BaseTools.formateDbDate(k.getCreatetime()), k.getCreatorid() });
				rows.add(cellMap);
			}
			return "json";
		}
		this.setTotal(0);
		rows.clear();
		return "json";
	}

	/**
	 * 根据id获取关键字
	 * 
	 * @return
	 */
	@Action(value = "findKeywordById", results = { @Result(name = "json", type = "json") })
	public String findKeywordById() {
		if (Validate.StrNotNull(this.getKeywordid())) {
			beanlist = this.getKeywordTService().findKeywordById(this.getKeywordid().trim());
			if (beanlist != null) {
				return "json";
			}
			return "json";
		}
		return "json";
	}

	/**
	 * 查询所有关键字json方式传输
	 * 
	 * @return
	 */
	@Action(value = "findAllKeywordTjson", results = { @Result(name = "json", type = "json") })
	public String findAllKeywordTjson() {
		this.setKeywordjson("");
		this.keyword = this.getKeywordTService().findAllKeywordTjson();
		if (this.keyword != null) {
			for (Iterator<KeywordT> it = this.keyword.iterator(); it.hasNext();) {
				KeywordT k = (KeywordT) it.next();
				this.keywordjson += "<option value='" + k.getKeywordid() + "'>" + k.getKeywordname() + "</option>";
			}
			this.setKeywordjson(keywordjson);
			return "json";
		}
		return "json";
	}
}
