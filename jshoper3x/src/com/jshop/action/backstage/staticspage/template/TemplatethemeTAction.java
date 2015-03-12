package com.jshop.action.backstage.staticspage.template;

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

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.enums.BaseEnums;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.TemplateT;
import com.jshop.entity.TemplatesetT;
import com.jshop.entity.TemplatethemeT;
import com.jshop.service.TemplateTService;
import com.jshop.service.TemplatesetTService;
import com.jshop.service.TemplatethemeTService;
import com.jshop.service.impl.Serial;
@Namespace("")
@ParentPackage("jshop")
public class TemplatethemeTAction extends BaseTAction {

	private static final long serialVersionUID = 1L;
	@Resource
	private TemplatethemeTService templatethemeTService;
	@Resource
	private TemplateTService templateTService;
	@Resource
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
		if (StaticKey.SC.equals(this.getQtype())) {
			this.setTotal(0);
			rows.clear();
			finddefaultAllTemplatetheme();
		} else {
			if (StringUtils.isBlank(this.getQtype())) {
				return JSON;
			} else {
				return JSON;
			}
		}
		return JSON;
	}

	/**
	 * 获取模板主题信息
	 */
	public void finddefaultAllTemplatetheme() {
		int currentPage = page;
		int lineSize = rp;
		
		if (StringUtils.isNotBlank(this.getSortname()) && StringUtils.isNotBlank(this.getSortorder())) {
			//String queryString = "from TemplatethemeT as tt where tt.creatorid=:creatorid order by " + this.getSortname() + " " + this.getSortorder() + " ";
			Criterion criterion=Restrictions.eq("creatorid", BaseTools.getAdminCreateId());
			Order order=null;
			if(StringUtils.equals(this.getSortorder(), StaticKey.ASC)){
				order=Order.asc(this.getSortname());
			}
			if(StringUtils.equals(this.getSortorder(), StaticKey.DESC)){
				order=Order.desc(this.getSortname());
			}
			total = this.templatethemeTService.count(TemplatethemeT.class, criterion).intValue();
			List<TemplatethemeT> list = this.templatethemeTService.findByCriteriaByPage(TemplatethemeT.class, criterion, order, currentPage, lineSize);
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
		rows.clear();
		for (Iterator<TemplatethemeT> it = list.iterator(); it.hasNext();) {
			TemplatethemeT tt = (TemplatethemeT) it.next();
			if(StringUtils.equals(BaseEnums.DataUsingState.USING.getState(), tt.getStatus())){
				tt.setStatus(BaseEnums.DataUsingState.USING.getName());
			}
			if(StringUtils.equals(BaseEnums.DataUsingState.UNUSING.getState(), tt.getStatus())){
				tt.setStatus(BaseEnums.DataUsingState.UNUSING.getName());
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
		Criterion criterion=Restrictions.and(Restrictions.eq("themename", this.getThemename())).add(Restrictions.eq("sign", this.getSign()));
		TemplatethemeT t=this.templatethemeTService.findOneByCriteria(TemplatethemeT.class, criterion);
		if(t!=null){
			this.setSucflag(false);
			return JSON;
		}

		TemplatethemeT tt = new TemplatethemeT();
		tt.setTtid(this.getSerial().Serialid(Serial.TEMPLATETHEME));
		tt.setThemename(this.getThemename().trim());
		tt.setNote(this.getNote().trim());
		tt.setSign(this.getSign().trim());
		tt.setCreatetime(BaseTools.getSystemTime());
		tt.setCreatorid(BaseTools.getAdminCreateId());
		tt.setStatus(this.getStatus());
		this.templatethemeTService.save(tt);
		this.setSucflag(true);
		return JSON;
		
	}

	/**
	 * 批量删除模板主题
	 * 
	 * @return
	 */
	@Action(value = "delTemplatetheme", results = { @Result(name = "json", type = "json") })
	public String delTemplatetheme() {
		if (StringUtils.isNotBlank(this.getTtid())) {
			String strs[]=StringUtils.split(this.getTtid(), StaticKey.SPLITDOT);
			String tip = null;
			int count = 0;
			for (String s:strs) {
				Criterion criterion=Restrictions.eq("themeid", s);
				TemplateT tt = this.templateTService.findOneByCriteria(TemplateT.class, criterion);
				if (tt != null) {
					tip += tt.getThemename() + ",";
					count++;
				} else {
					TemplatethemeT tmt=this.templatethemeTService.findByPK(TemplatethemeT.class, s);
					if(tmt!=null){
						this.templatethemeTService.delete(tmt);
					}
				}
			}
			if (count == 0) {
				this.setSucflag(true);
				return JSON;
			} else {
				//这里有问题
				this.setMsg(tip + "模板正在被其他文件使用，如需要删除请先删除模板文件");
				this.setSucflag(false);
				return JSON;

			}
		}
		this.setSucflag(false);
		return JSON;
	}

	/**
	 * 获取单主题模板信息
	 * 
	 * @return
	 */
	@Action(value = "findTemplatethemeByttid", results = { @Result(name = "json", type = "json") })
	public String findTemplatethemeByttid() {
		if (StringUtils.isNotBlank(this.getTtid())) {
			bean = this.templatethemeTService.findByPK(TemplatethemeT.class,this.getTtid());
			if (bean != null) {
				return JSON;
			}
		}
		return JSON;
	}

	/**
	 * 更新模板主题
	 * 
	 * @return
	 */
	@Action(value = "updateTemplatetheme", results = { @Result(name = "json", type = "json") })
	public String updateTemplatetheme() {
		Map<String,Object>params=new HashMap<String, Object>();
		params.put("ttid", this.getTtid());
		params.put("themename", this.getThemename());
		params.put("sign", this.getSign());
		Criterion criterion=Restrictions.allEq(params);
		TemplatethemeT t=this.templatethemeTService.findOneByCriteria(TemplatethemeT.class, criterion);
		if(t!=null){
			this.setSucflag(false);
			return JSON;
		}
		TemplatethemeT tt = new TemplatethemeT();
		tt.setTtid(this.getTtid());
		tt.setThemename(this.getThemename());
		tt.setNote(this.getNote());
		tt.setSign(this.getSign());
		tt.setCreatetime(BaseTools.getSystemTime());
		tt.setCreatorid(BaseTools.getAdminCreateId());
		tt.setStatus(this.getStatus());
		this.templatethemeTService.update(tt);
		Criterion criterion2=Restrictions.eq("themeid", this.getTtid());
		TemplateT templateT=this.templateTService.findOneByCriteria(TemplateT.class, criterion2);
		if(templateT!=null){
			templateT.setStatus(this.getStatus());
			this.templateTService.update(templateT);
		}
		TemplatesetT tsetT=this.templatesetTService.findOneByCriteria(TemplatesetT.class, criterion2);
		if(tsetT!=null){
			tsetT.setStatus(this.getStatus());
			this.templatesetTService.update(tsetT);
		}
		this.setSucflag(true);
		return JSON;

	}

	/**
	 * 获取所有模板主题
	 * 
	 * @return
	 */
	@Action(value = "getAllTemplatetheme", results = { @Result(name = "json", type = "json") })
	public String getAllTemplatetheme() {
		Criterion criterion=Restrictions.eq("creatorid", BaseTools.getAdminCreateId());
		List<TemplatethemeT> list = this.templatethemeTService.findByCriteria(TemplatethemeT.class, criterion);
		if (list != null) {
			this.setTemplatethemestrs("");
			this.setTemplatethemestrs("<option value='-1'>---请选择---</option>");
			for (Iterator<TemplatethemeT> it = list.iterator(); it.hasNext();) {
				TemplatethemeT tt = (TemplatethemeT) it.next();
				this.templatethemestrs += "<option value='" + tt.getTtid() + "," + tt.getSign() + "'>" + tt.getThemename() + "</option>";
			}
			this.setSucflag(true);
			return JSON;
		}
		this.setSucflag(false);
		return JSON;

	}

	/**
	 * 更新模板主题状态同时更新模板文件表把相应主题下得模板文件同时更新到启用状态
	 * 
	 * @return
	 */
	@Action(value = "updateTemplatethemestatus", results = { @Result(name = "json", type = "json") })
	public String updateTemplatethemestatus() {

		if (StringUtils.isNotBlank(this.getTtid()) && StringUtils.isNotBlank(this.getStatus())) {
			TemplatethemeT templatethemeT=this.templatethemeTService.findByPK(TemplatethemeT.class, this.getTtid());
			if(templatethemeT!=null){
				templatethemeT.setStatus(this.getStatus());
				this.templatethemeTService.update(templatethemeT);
			}
			Criterion criterion=Restrictions.eq("themeid", this.getTtid());
			
			TemplateT templateT=this.templateTService.findOneByCriteria(TemplateT.class, criterion);
			if(templateT!=null){
				templateT.setStatus(this.getStatus());
				this.templateTService.update(templateT);
			}
			TemplatesetT tsetT=this.templatesetTService.findOneByCriteria(TemplatesetT.class, criterion);
			if(tsetT!=null){
				tsetT.setStatus(this.getStatus());
				this.templatesetTService.update(tsetT);
			}this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}

	}

}
