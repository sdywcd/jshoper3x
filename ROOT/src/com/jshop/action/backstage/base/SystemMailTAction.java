package com.jshop.action.backstage.base;

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
import org.springframework.core.task.TaskExecutor;
import com.jshop.action.backstage.template.CreateHtml;
import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.StaticString;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.SystemMailT;
import com.jshop.service.SystemMailTService;
import com.jshop.service.UsertService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("")
@ParentPackage("jshop")
public class SystemMailTAction extends ActionSupport {
	private UsertService usertService;
	private TaskExecutor taskExecutor;
	private SystemMailTService SystemMailTService;
	private CreateHtml createHtml;
	private Serial serial;

	private String id;
	private String email;
	private String smtp;
	private String port;
	private String smtpusername;
	private String pwd;
	private String state;
	private String isdefault;
	private String isssl;
	private String creatorid;
	private Date createtime;
	private Date updatetime;
	private String creatorname;
	private SystemMailT bean = new SystemMailT();
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String query;
	private String qtype;
	private boolean sucflag;

	@JSON(serialize = false)
	public TaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	@JSON(serialize = false)
	public UsertService getUsertService() {
		return usertService;
	}

	public void setUsertService(UsertService usertService) {
		this.usertService = usertService;
	}

	@JSON(serialize = false)
	public SystemMailTService getSystemMailTService() {
		return SystemMailTService;
	}

	public void setSystemMailTService(SystemMailTService SystemMailTService) {
		this.SystemMailTService = SystemMailTService;
	}

	@JSON(serialize = false)
	public CreateHtml getCreateHtml() {
		return createHtml;
	}

	public void setCreateHtml(CreateHtml createHtml) {
		this.createHtml = createHtml;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getSmtpusername() {
		return smtpusername;
	}

	public void setSmtpusername(String smtpusername) {
		this.smtpusername = smtpusername;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public SystemMailT getBean() {
		return bean;
	}

	public void setBean(SystemMailT bean) {
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

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSmtp() {
		return smtp;
	}

	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}

	public String getIsssl() {
		return isssl;
	}

	public void setIsssl(String isssl) {
		this.isssl = isssl;
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

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getCreatorname() {
		return creatorname;
	}

	public void setCreatorname(String creatorname) {
		this.creatorname = creatorname;
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

	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加邮件地址
	 * 
	 * @return
	 */
	@Action(value = "addSystemMail", results = { @Result(name = "json", type = "json") })
	public String addSystemMail() {
		SystemMailT sm = new SystemMailT();
		sm.setId(this.getSerial().Serialid(Serial.SYSTEMMAILM));
		sm.setEmail(this.getEmail());
		sm.setSmtp(this.getSmtp());
		sm.setPort(this.getPort());
		sm.setPwd(this.getPwd());
		sm.setState(this.getState());
		sm.setIsdefault(this.getIsdefault());
		sm.setIsssl(this.getIsssl());
		sm.setCreatorid(BaseTools.adminCreateId());
		sm.setCreatorname(BaseTools.adminCreatename());
		sm.setCreatetime(BaseTools.systemtime());
		sm.setUpdatetime(BaseTools.systemtime());
		if (this.getSystemMailTService().addSystemMail(sm) > 0) {
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}

	/**
	 * 更新系统邮件地址
	 * 
	 * @return
	 */
	@Action(value = "updateSystemMail", results = { @Result(name = "json", type = "json") })
	public String updateSystemMail() {
		SystemMailT sm = new SystemMailT();
		sm = this.getSystemMailTService().findSysmailBysmailid(this.getId());
		sm.setEmail(this.getEmail());
		sm.setSmtp(this.getSmtp());
		sm.setPort(this.getPort());
		sm.setPwd(this.getPwd());
		sm.setState(this.getState());
		sm.setIsdefault(this.getIsdefault());
		sm.setIsssl(this.getIsssl());
		sm.setUpdatetime(BaseTools.systemtime());
		this.getSystemMailTService().updateSystemMail(sm);
		this.setSucflag(true);
		return "json";
	}

	/**
	 * 查询系统邮件
	 * 
	 * @return
	 */
	@Action(value = "findAllSystemMail", results = { @Result(name = "json", type = "json") })
	public String findAllSystemMail() {
		if (StaticString.SC.equals(this.getQtype())) {
			this.findDefaultAllSystemMail();
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {
				return "json";
			}
		}
		return "json";

	}

	public void findDefaultAllSystemMail() {
		total = this.getSystemMailTService().countfindAllSystemMail();
		List<SystemMailT> list = this.getSystemMailTService().findAllSystemMail();
		if (!list.isEmpty()) {
			ProcessSystemMailTlist(list);
		}
	}

	public void ProcessSystemMailTlist(List<SystemMailT> list) {
		rows.clear();
		for (Iterator it = list.iterator(); it.hasNext();) {
			SystemMailT sm = (SystemMailT) it.next();
			if(StaticString.ONE.equals(sm.getIsssl())){
				sm.setIsssl(StaticString.SUPPORT);
			}else{
				sm.setIsssl(StaticString.UNSUPPORT);
			}
			if(StaticString.ONE.equals(sm.getIsdefault())){
				sm.setIsdefault(StaticString.YES);
			}else{
				sm.setIsdefault(StaticString.NO);
			}
			if(StaticString.ONE.equals(sm.getState())){
				sm.setState(StaticString.USEING);
			}else{
				sm.setState(StaticString.UNUSING);
			}
			Map cellMap = new HashMap();
			cellMap.put("id", sm.getId());
			cellMap.put("cell", new Object[] { sm.getEmail(), sm.getSmtp(), sm.getPort(), sm.getIsssl(), sm.getIsdefault(), sm.getState(), sm.getCreatorid(), BaseTools.formateDbDate(sm.getCreatetime()), "<a id='editemail' name='editemail' href='email.jsp?operate=edit&folder=setting&id=" + sm.getId() + "'>[编辑]</a>" });
			rows.add(cellMap);
		}

	}

}
