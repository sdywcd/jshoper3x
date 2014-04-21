package com.jshop.action.backstage.interceptor.impl;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.jshop.action.backstage.interceptor.AuthorityInterceptor;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
@ParentPackage("jshop")
public class Issendactivatemail extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;
	private AuthorityInterceptor authorityInterceptor;
	
	
	public AuthorityInterceptor getAuthorityInterceptor() {
		return authorityInterceptor;
	}


	public void setAuthorityInterceptor(AuthorityInterceptor authorityInterceptor) {
		this.authorityInterceptor = authorityInterceptor;
	}


	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		ActionContext ctx=ai.getInvocationContext();
		boolean flag=this.getAuthorityInterceptor().issendactivatemail();
		if(flag){
			
			ActionContext.getContext().getSession().put("userstate", "0");
			return ai.invoke();
		}else{
			ActionContext.getContext().getSession().put("userstate", "1");
			return ai.invoke();
		}
	}

}
