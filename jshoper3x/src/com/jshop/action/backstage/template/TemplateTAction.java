package com.jshop.action.backstage.template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.TemplateT;
import com.jshop.service.TemplateTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class TemplateTAction extends ActionSupport {

	private TemplateTService templateTService;
	private Serial serial;
	private String tid;
	private String url;
	private String note;
	private String name;
	private String tvalue;
	private Date createtime;
	private String creatorid;
	private String themeid;
	private String themename;
	private String sign;
	private String type;
	private String status;
	private String query;//text
	private String qtype;//select
	private TemplateT bean=new TemplateT();
	private List rows=new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;
	@JSON(serialize = false)
	public TemplateTService getTemplateTService() {
		return templateTService;
	}

	public void setTemplateTService(TemplateTService templateTService) {
		this.templateTService = templateTService;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public TemplateT getBean() {
		return bean;
	}

	public void setBean(TemplateT bean) {
		this.bean = bean;
	}

	public String getTvalue() {
		return tvalue;
	}

	public void setTvalue(String tvalue) {
		this.tvalue = tvalue;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getThemeid() {
		return themeid;
	}

	public void setThemeid(String themeid) {
		this.themeid = themeid;
	}

	public String getThemename() {
		return themename;
	}

	public void setThemename(String themename) {
		this.themename = themename;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 去除查询所有商品类别的错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	
	/**
	 * 读取所有模板数据
	 * 
	 * @return
	 */
	@Action(value = "findAllTemplate", results = { 
			@Result(name = "json",type="json")
	})
	public String findAllTemplate() {
			if ("sc".equals(this.getQtype())) {
				this.findDefaultAllTemplate();
			} else {
				if (Validate.StrisNull(this.getQuery())) {
					return "json";
				} else {
					this.findTemplateByLikeName();
					return "json";
				}
			}
			return "json";
	}

	public void findDefaultAllTemplate() {
		int currentPage = page;
		int lineSize = rp;
		total = this.getTemplateTService().countfindAllTemplate(BaseTools.adminCreateId());
		List<TemplateT> list = this.getTemplateTService().findAllTemplate(currentPage, lineSize, BaseTools.adminCreateId());
		if (!list.isEmpty()) {
			this.ProcessTemplateList(list);
		}
	}

	public void ProcessTemplateList(List<TemplateT> list) {
		for (Iterator it = list.iterator(); it.hasNext();) {
			TemplateT t = (TemplateT) it.next();
			if (t.getType().equals("1")) {
				t.setType("页面模板");
			}
			if (t.getType().equals("2")) {
				t.setType("邮件模板");
			}
			if (t.getType().equals("3")) {
				t.setType("打印模板");
			}
			if(t.getStatus().equals("1")){
				t.setStatus("启用");
			}else{
				t.setStatus("禁用");
			}

			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", t.getTid());
			cellMap.put("cell", new Object[] { 
					t.getSign(),
					t.getThemename(),
					t.getName(), 
					t.getType(), 
					t.getNote(), 
					t.getStatus(),
					t.getUrl(), 
					"<a  id='edittemplate' href='template.jsp?operate=edit&folder=setting&tid=" + t.getTid() + "' name='edittemplate'>[编辑]</a>" });
			rows.add(cellMap);
		}

	}

	/**
	 * 根据主题名称获取创建模板文件路径
	 * 
	 * @param themename
	 * @throws IllegalAccessException
	 */
	public String getWebInfoPath() throws IllegalAccessException {
		URL base = this.getClass().getResource("/");
		String path = base.getFile().substring(0, base.getFile().length() - 8);
		return path;
	}

	/**
	 * 创建ftl文件
	 * 
	 * @param tt
	 * @throws IOException
	 * @throws IllegalAccessException
	 */
	public void createFTLFile(TemplateT tt) throws IOException, IllegalAccessException {
		String path = getWebInfoPath() + "/theme/" + tt.getThemename() + "/shop";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String filepath = path + "/" + tt.getName() + ".ftl";
		File file = new File(filepath);
		if(!file.exists()){
			file.createNewFile();
			FileOutputStream out = new FileOutputStream(file, true);
			out.write(tt.getTvalue().toString().getBytes("utf-8"));
			out.close();
		}
		
		
	}

	/**
	 * 更新ftl文件
	 * 
	 * @param tt
	 * @throws IllegalAccessException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public void updateFTLFile(TemplateT tt) throws IllegalAccessException, UnsupportedEncodingException, IOException {
		String path = getWebInfoPath() + "/theme/" + tt.getThemename() + "/shop";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String filepath = path + "/" + tt.getName() + ".ftl";
		File file = new File(filepath);
		if (file.exists()) {
			if (file.delete()) {
				file.createNewFile();
				FileOutputStream out = new FileOutputStream(file, true);
				out.write(tt.getTvalue().toString().getBytes("utf-8"));
				out.close();
			}
		} else {
			file.createNewFile();
			FileOutputStream out = new FileOutputStream(file, true);
			out.write(tt.getTvalue().toString().getBytes("utf-8"));
			out.close();
		}
	}

	/**
	 * 增加模板信息
	 * 
	 * @return
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	@Action(value = "addTemplate", results = { 
			@Result(name = "json",type="json")
	})
	public String addTemplate() throws IOException, IllegalAccessException {
		if (this.getTemplateTService().findTemplateBynameandnote(BaseTools.adminCreateId(), this.getNote(), this.getName()) > 0) {
			this.setSucflag(false);
			return "json";
		}
		TemplateT tt = new TemplateT();
		tt.setTid(this.getSerial().Serialid(Serial.TEMPLATE));
		tt.setName(this.getName().trim());
		tt.setUrl(this.getUrl().trim());
		tt.setNote(this.getNote());
		tt.setTvalue(this.getTvalue());
		tt.setCreatetime(BaseTools.systemtime());
		tt.setCreatorid(BaseTools.adminCreateId());
		tt.setThemeid(this.getThemeid());
		tt.setThemename(this.getThemename());
		tt.setSign(this.getSign());
		tt.setType(this.getType());
		tt.setStatus("1");//默认开启
		this.getTemplateTService().save(tt);
		createFTLFile(tt);
		this.setSucflag(true);
		return "json";
	
	}

	/**
	 * 根据tid获取模板信息
	 * 
	 * @return
	 */
	@Action(value = "findTemplateByTid", results = { 
			@Result(name = "json",type="json")
	})
	public String findTemplateByTid() {
		if (Validate.StrNotNull(this.getTid())) {
			bean = this.getTemplateTService().findByPK(TemplateT.class, this.getTid());
			if (bean != null) {
				return "json";
			}
		}
		return "json";
	}

	/**
	 * 更新模板文件信息
	 * 
	 * @return
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws UnsupportedEncodingException
	 */
	@Action(value = "updateTemplate", results = { 
			@Result(name = "json",type="json")
	})
	public String updateTemplate() throws UnsupportedEncodingException, IllegalAccessException, IOException {
		TemplateT tt = new TemplateT();
		tt.setTid(this.getTid().trim());
		tt.setName(this.getName().trim());
		tt.setNote(this.getNote().trim());
		tt.setUrl(this.getUrl().trim());
		tt.setTvalue(this.getTvalue());
		tt.setType(this.getType());
		tt.setThemeid(this.getThemeid());
		tt.setThemename(this.getThemename());
		tt.setSign(this.getSign());
		tt.setCreatetime(BaseTools.systemtime());
		tt.setCreatorid(BaseTools.adminCreateId());
		tt.setStatus(this.getStatus());
		this.getTemplateTService().update(tt);
		updateFTLFile(tt);
		this.setSucflag(true);
		return "json";
	}

	/**
	 * 批量删除模板信息
	 * 
	 * @return
	 */
	@Action(value = "delTemplate", results = { 
			@Result(name = "json",type="json")
	})
	public String delTemplate() {
		if (Validate.StrNotNull(this.getTid())) {
			String[] strs =StringUtils.split(this.getTid().trim(), ","); 
			@SuppressWarnings("unused")
			int i = this.getTemplateTService().delTemplate(strs);
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	
	}

	/**
	 * 重新生成所有模板页面
	 * 
	 * @return
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws UnsupportedEncodingException
	 */
	@Action(value = "recreateTemplate", results = { 
			@Result(name = "json",type="json")
	})
	public String recreateTemplate() throws UnsupportedEncodingException, IllegalAccessException, IOException {
			List<TemplateT> list = this.getTemplateTService().findAllTemplateWithNoParam(BaseTools.adminCreateId(),"1");
			for (Iterator it = list.iterator(); it.hasNext();) {
				TemplateT tt = (TemplateT) it.next();
				this.updateFTLFile(tt);
			}
			this.setSucflag(true);
			return "json";
	}
	/**
	 * 根据名称模糊查询
	 * @return
	 */
	@Action(value="findTemplateByLikeName",results={@Result(name="json",type="json")})
	public void findTemplateByLikeName(){
		int currentPage = page;
		int lineSize = rp;
		total=this.getTemplateTService().countTemplateTBYLikeNmae(this.getQuery());
		List<TemplateT> list = this.getTemplateTService().findTemplateTByLikeName(currentPage, lineSize, this.getQuery());
		if(!list.isEmpty()){
			this.ProcessTemplateList(list);
		}
		//return "json";
	}
}
