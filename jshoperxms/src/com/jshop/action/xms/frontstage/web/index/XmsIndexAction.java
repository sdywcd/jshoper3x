package com.jshop.action.xms.frontstage.web.index;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.jshop.action.mall.backstage.base.BaseTAction;
import com.jshop.action.mall.backstage.base.DataCollectionTAction;
@ParentPackage("jshop")
@Namespace("/xms")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class XmsIndexAction extends BaseTAction{
	@Resource
	private DataCollectionTAction dataCollectionTAction;
	/**
	 * 跳转xms首页
	 * @return
	 */
	@Action(value = "index", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/xms/index.ftl")
	})
	public String toxmsIndex(){
		this.dataCollectionTAction.putBaseInfoToContext();
		return SUCCESS;
	}
	

	/**
	 * 跳转注册服务商
	 * @return
	 */
	@Action(value = "goregisterMerchant", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/xms/merchant/registermerchant.ftl")
	})
	public String goRegisterMerchant(){
		this.dataCollectionTAction.putBaseInfoToContext();
		return SUCCESS;
	}
	
	
	/**
	 * 跳转500页面
	 * @return
	 */
	@Action(value = "servererror", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/xms/500.ftl")
	})
	public String goServerError(){
		this.dataCollectionTAction.putBaseInfoToContext();
		return SUCCESS;
	}
	
	/**
	 * 跳转404页面
	 * @return
	 */
	@Action(value = "pagenotfound", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/xms/404.ftl")
	})
	public String goPageNotFound(){
		this.dataCollectionTAction.putBaseInfoToContext();
		return SUCCESS;
	}
	
}
