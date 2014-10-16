package com.jshop.action.backstage.staticspage.template;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.entity.TemplateT;
import com.jshop.entity.TemplatethemeT;
import com.jshop.service.TemplateTService;
import com.jshop.service.TemplatesetTService;
import com.jshop.service.TemplatethemeTService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class TemplatethemeTAction extends BaseTAction {

	private static final long serialVersionUID = 1L;
	private TemplatethemeTService templatethemeTService;
	private TemplateTService templateTService;
	private TemplatesetTService templatesetTService;
	private String ttid;
	private String note;
	private String themename;
	private Date createtime;
	private String creatorid;
	private String sign;
	private String status;
	private String templatethemestrs;
	private TemplatethemeT bean = new TemplatethemeT();
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;
	private String msg;

	@JSON(serialize = false)
	public TemplatethemeTService getTemplatethemeTService() {
		return templatethemeTService;
	}

	public void setTemplatethemeTService(TemplatethemeTService templatethemeTService) {
		this.templatethemeTService = templatethemeTService;
	}
	@JSON(serialize = false)
	public TemplateTService getTemplateTService() {
		return templateTService;
	}

	public void setTemplateTService(TemplateTService templateTService) {
		this.templateTService = templateTService;
	}
	@JSON(serialize = false)
	public TemplatesetTService getTemplatesetTService() {
		return templatesetTService;
	}

	public void setTemplatesetTService(TemplatesetTService templatesetTService) {
		this.templatesetTService = templatesetTService;
	}

	public TemplatethemeT getBean() {
		return bean;
	}

	public void setBean(TemplatethemeT bean) {
		this.bean = bean;
	}

	public String getTtid() {
		return ttid;
	}

	public void setTtid(String ttid) {
		this.ttid = ttid;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getThemename() {
		return themename;
	}

	public void setThemename(String themename) {
		this.themename = themename;
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

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
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

	public String getTemplatethemestrs() {
		return templatethemestrs;
	}

	public void setTemplatethemestrs(String templatethemestrs) {
		this.templatethemestrs = templatethemestrs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 查询所有模板主题
	 * 
	 * @return
	 */
	@Action(value = "findAllTemplatetheme", results = { @Result(name = "json", type = "json") })
	public String findAllTemplatetheme() {

		if ("sc".equals(this.getQtype())) {
			this.setTotal(0);
			rows.clear();
			finddefaultAllTemplatetheme();
		} else {
			if (Validate.StrisNull(this.getQtype())) {
				return "json";
			} else {
				return "json";
			}
		}
		return "json";
	}

	/**
	 * 获取模板主题信息
	 */
	public void finddefaultAllTemplatetheme() {
		int currentPage = page;
		int lineSize = rp;
		if (Validate.StrNotNull(this.getSortname()) && Validate.StrNotNull(this.getSortorder())) {
			String queryString = "from TemplatethemeT as tt where tt.creatorid=:creatorid order by " + this.getSortname() + " " + this.getSortorder() + " ";
			List<TemplatethemeT> list = this.getTemplatethemeTService().sortAllTemplatetheme(currentPage, lineSize, BaseTools.getAdminCreateId(), queryString);
			if (list != null) {
				ProcessTemplatethemeList(list);
			}
		}
	}

	/**
	 * 迭代处理供前台显示
	 * 
	 * @param list
	 */
	public void ProcessTemplatethemeList(List<TemplatethemeT> list) {
		total = this.getTemplatethemeTService().countfindAllTemplatetheme(BaseTools.getAdminCreateId());
		rows.clear();
		for (Iterator<TemplatethemeT> it = list.iterator(); it.hasNext();) {
			TemplatethemeT tt = (TemplatethemeT) it.next();
			if (tt.getStatus().equals("1")) {
				tt.setStatus("启用");
			} else {
				tt.setStatus("禁用");
			}
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", tt.getTtid());
			cellMap.put("cell", new Object[] { tt.getThemename(), tt.getNote(), tt.getSign(), tt.getStatus(), BaseTools.formateDbDate(tt.getCreatetime()), tt.getCreatorid(), "<a id='edittemplatetheme' href='templatetheme.jsp?operate=edit&folder=setting&ttid=" + tt.getTtid() + "' name='edittemplatetheme'>[编辑]</a>" });
			rows.add(cellMap);
		}
	}

	/**
	 * 增加模板主题
	 * 
	 * @return
	 */
	@Action(value = "addTemplatetheme", results = { @Result(name = "json", type = "json") })
	public String addTemplatetheme() {

		if (this.getTemplatethemeTService().checkTemplatethemeBythemenameandsign(this.getThemename(), this.getSign()) > 0) {
			this.setSucflag(false);
			return "json";
		}

		TemplatethemeT tt = new TemplatethemeT();
		tt.setTtid(this.getSerial().Serialid(Serial.TEMPLATETHEME));
		tt.setThemename(this.getThemename().trim());
		tt.setNote(this.getNote().trim());
		tt.setSign(this.getSign().trim());
		tt.setCreatetime(BaseTools.systemtime());
		tt.setCreatorid(BaseTools.getAdminCreateId());
		tt.setStatus(this.getStatus());
		this.getTemplatethemeTService().save(tt);
		this.setSucflag(true);
		return "json";
		
	}

	/**
	 * 批量删除模板主题
	 * 
	 * @return
	 */
	@Action(value = "delTemplatetheme", results = { @Result(name = "json", type = "json") })
	public String delTemplatetheme() {
		if (Validate.StrNotNull(this.getTtid())) {
			String[] str = this.getTtid().trim().split(",");
			String tip = null;
			int count = 0;
			TemplateT tt = new TemplateT();
			for (int i = 0; i < str.length; i++) {
				tt = this.getTemplateTService().checkTemplatetheme(str[i]);
				if (tt != null) {
					tip += tt.getThemename() + ",";
					count++;
				} else {
					int j = this.getTemplatethemeTService().delTemplatetheme(str[i]);
				}
			}
			if (count == 0) {
				this.setSucflag(true);
				return "json";
			} else {
				//这里有问题
				this.setMsg(tip + "模板正在被其他文件使用，如需要删除请先删除模板文件");
				this.setSucflag(false);
				return "json";

			}
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 获取单主题模板信息
	 * 
	 * @return
	 */
	@Action(value = "findTemplatethemeByttid", results = { @Result(name = "json", type = "json") })
	public String findTemplatethemeByttid() {

		if (Validate.StrNotNull(this.getTtid())) {
			bean = this.getTemplatethemeTService().findByPK(TemplatethemeT.class,this.getTtid());
			if (bean != null) {
				return "json";
			}
		}

		return "json";
	}

	/**
	 * 更新模板主题
	 * 
	 * @return
	 */
	@Action(value = "updateTemplatetheme", results = { @Result(name = "json", type = "json") })
	public String updateTemplatetheme() {

		if (this.getTemplatethemeTService().checkTemplatethemeBythemenameandsign(this.getThemename(), this.getSign(), this.getTtid()) > 0) {
			this.setSucflag(false);
			return "json";
		}
		TemplatethemeT tt = new TemplatethemeT();
		tt.setTtid(this.getTtid());
		tt.setThemename(this.getThemename());
		tt.setNote(this.getNote());
		tt.setSign(this.getSign());
		tt.setCreatetime(BaseTools.systemtime());
		tt.setCreatorid(BaseTools.getAdminCreateId());
		tt.setStatus(this.getStatus());
		this.getTemplatethemeTService().update(tt);
		int k = this.getTemplateTService().updateTemplatetBystatus(this.getTtid(), this.getStatus());
		int j = this.getTemplatesetTService().updateTemplatesetBystatus(this.getTtid(), this.getStatus());
		this.setSucflag(true);
		return "json";

	}

	/**
	 * 获取所有模板主题
	 * 
	 * @return
	 */
	@Action(value = "getAllTemplatetheme", results = { @Result(name = "json", type = "json") })
	public String getAllTemplatetheme() {

		List<TemplatethemeT> list = this.getTemplatethemeTService().findAllTemplatethemeWithNoParam(BaseTools.getAdminCreateId());
		if (list != null) {
			this.setTemplatethemestrs("");
			this.setTemplatethemestrs("<option value='-1'>---请选择---</option>");
			for (Iterator<TemplatethemeT> it = list.iterator(); it.hasNext();) {
				TemplatethemeT tt = (TemplatethemeT) it.next();
				this.templatethemestrs += "<option value='" + tt.getTtid() + "," + tt.getSign() + "'>" + tt.getThemename() + "</option>";
			}
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";

	}

	/**
	 * 更新模板主题状态同时更新模板文件表把相应主题下得模板文件同时更新到启用状态
	 * 
	 * @return
	 */
	@Action(value = "updateTemplatethemestatus", results = { @Result(name = "json", type = "json") })
	public String updateTemplatethemestatus() {

		if (Validate.StrNotNull(this.getTtid()) && Validate.StrNotNull(this.getStatus())) {
			int i = this.getTemplatethemeTService().updateTemplatethemestatus(this.getTtid(), this.getStatus());
			int k = this.getTemplateTService().updateTemplatetBystatus(this.getTtid(), this.getStatus());
			int j = this.getTemplatesetTService().updateTemplatesetBystatus(this.getTtid(), this.getStatus());
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}

	}

}
