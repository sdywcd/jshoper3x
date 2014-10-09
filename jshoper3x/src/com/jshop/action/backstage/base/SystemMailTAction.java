package com.jshop.action.backstage.base;

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
import org.springframework.core.task.TaskExecutor;

import com.jshop.action.backstage.staticspage.CreateHtml;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.SystemMailT;
import com.jshop.service.SystemMailTService;
import com.jshop.service.UsertService;
import com.jshop.service.impl.Serial;

@Namespace("")
@ParentPackage("jshop")
public class SystemMailTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private UsertService usertService;
	private TaskExecutor taskExecutor;
	private SystemMailTService SystemMailTService;
	private CreateHtml createHtml;
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
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
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
		sm.setCreatorid(BaseTools.getAdminCreateId());
		sm.setCreatorname(BaseTools.getAdminCreateName());
		sm.setCreatetime(BaseTools.systemtime());
		sm.setUpdatetime(BaseTools.systemtime());
		this.getSystemMailTService().save(sm);
		this.setSucflag(true);		
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
		sm=this.getSystemMailTService().findSysmailByid(this.getId());
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
	 * 根据id获取邮箱信息
	 * @return
	 */
	@Action(value = "findSysmailByid", results = { @Result(name = "json", type = "json") })
	public String findSysmailByid(){
		if(Validate.StrNotNull(this.getId())){
			bean=this.getSystemMailTService().findSysmailByid(this.getId());
			if(bean!=null){
				this.setSucflag(true);
			}
		}
		return "json";
	}
	
	
	/**
	 * 查询系统邮件
	 * 
	 * @return
	 */
	@Action(value = "findAllSystemMail", results = { @Result(name = "json", type = "json") })
	public String findAllSystemMail() {
		if (StaticKey.SC.equals(this.getQtype())) {
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
		for (Iterator<SystemMailT> it = list.iterator(); it.hasNext();) {
			SystemMailT sm = (SystemMailT) it.next();
			if(StaticKey.ONE.equals(sm.getIsssl())){
				sm.setIsssl(StaticKey.SUPPORT);
			}else{
				sm.setIsssl(StaticKey.UNSUPPORT);
			}
			if(StaticKey.ONE.equals(sm.getIsdefault())){
				sm.setIsdefault(StaticKey.YES);
			}else{
				sm.setIsdefault(StaticKey.NO);
			}
			sm.setState(StaticKey.DataUsingState.getName(sm.getState()));
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", sm.getId());
			cellMap.put("cell", new Object[] { sm.getEmail(), sm.getSmtp(), sm.getPort(), sm.getIsssl(), sm.getIsdefault(), sm.getState(), sm.getCreatorid(), BaseTools.formateDbDate(sm.getCreatetime()), "<a id='editemail' name='editemail' href='email.jsp?operate=edit&folder=setting&id=" + sm.getId() + "'>[编辑]</a>" });
			rows.add(cellMap);
		}

	}

	/**
	 * 删除邮箱
	 * @return
	 */
	@Action(value = "delSystemMail", results = { @Result(name = "json", type = "json") })
	public String delSystemMail(){
		String []strs=StringUtils.split(this.getId(),",");
		for(String s:strs){
			this.getSystemMailTService().delSystemMail(s);
		}
		this.setSucflag(true);
		return "json";
	}
	
	
	
}
