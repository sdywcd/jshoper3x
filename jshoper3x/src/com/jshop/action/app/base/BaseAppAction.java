package com.jshop.action.app.base;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.entity.AppPostTokenT;
import com.jshop.service.BaseTService;

@Namespace("/app")
@ParentPackage("jshop")
@InterceptorRefs({ @InterceptorRef("defaultStack") })
public class BaseAppAction extends BaseTAction implements ServletRequestAware, ServletResponseAware{
	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BaseAppAction.class);
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private String uuid;
	
	@Resource
	private BaseTService<AppPostTokenT> baseTService;
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}
	
	@Action(value="registerUuid4App")
	public void registerUuid(){
		
	}

}
