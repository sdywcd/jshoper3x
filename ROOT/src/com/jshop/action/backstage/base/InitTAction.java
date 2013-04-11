package com.jshop.action.backstage.base;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.jshop.action.backstage.template.FreeMarkervariable;
import com.jshop.entity.TemplatethemeT;
import com.jshop.service.TemplatethemeTService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
@Controller("initTAction")
public class InitTAction extends ActionSupport {
	private TemplatethemeTService templatethemeTService;
	private TemplatethemeT tt;
	private boolean slogin;
	private boolean sucflag;
	private String logmsg;
	@JSON(serialize = false)
	public TemplatethemeTService getTemplatethemeTService() {
		return templatethemeTService;
	}
	public void setTemplatethemeTService(TemplatethemeTService templatethemeTService) {
		this.templatethemeTService = templatethemeTService;
	}
	public TemplatethemeT getTt() {
		return tt;
	}
	public void setTt(TemplatethemeT tt) {
		this.tt = tt;
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
	
	
	public String getLogmsg() {
		return logmsg;
	}
	public void setLogmsg(String logmsg) {
		this.logmsg = logmsg;
	}
	public InitTAction() {
		tt=new TemplatethemeT();
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 初始化后台所需要的数据
	 * @return
	 */
	public void InitDefaultThemeT(){
		try{
			String status="1";//标示默认主题
			tt=this.getTemplatethemeTService().findTemplatethemeBystatus(status);
			if(tt!=null){
				//将启用的模板主题标示加入到服务器内存中
				if(!tt.getSign().isEmpty()){
					ActionContext.getContext().getApplication().put(FreeMarkervariable.DEFAULTTHEMESIGN, tt.getSign());
				}else{
					//如果没有默认的模板，那么启用默认主题模板
					tt.setSign("default");
					ActionContext.getContext().getApplication().put(FreeMarkervariable.DEFAULTTHEMESIGN, tt.getSign());
				}
				
			}
		}catch(Exception e){
			this.setLogmsg("<p style='color:red;'>"+e.getMessage()+"</p>");
		}finally{
			this.setLogmsg("<p>默认主题获取成功</p>");
		}
		
	}
	
	
	
	
}
